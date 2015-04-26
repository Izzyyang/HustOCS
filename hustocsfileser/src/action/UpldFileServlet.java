package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;

import util.RequstDealImpl;

public class UpldFileServlet extends HttpServlet {

	public UpldFileServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("a upload request");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// first check if the upload request coming in is a multipart
			// request
			boolean isMultipart = FileUpload.isMultipartContent(request);
			log("content-length: " + request.getContentLength());
			log("method: " + request.getMethod());
			log("character encoding: " + request.getCharacterEncoding());
			if (isMultipart) {
				DiskFileUpload upload = new DiskFileUpload();
				List items = null;
				try {
					// parse this request by the handler
					// this gives us a list of items from the request
					items = upload.parseRequest(request);
					log("items: " + items.toString());
				} catch (FileUploadException ex) {
					log("Failed to parse request", ex);
				}
				Iterator itr = items.iterator();

				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					// check if the current item is a form field or an uploaded
					// file
					if (item.isFormField()) {
						// get the name of the field
						String fieldName = item.getFieldName();
						// if it is name, we can set it in request to thank the
						// user
						if (fieldName.equals("name")) {
							System.out.print("Thank You: " + item.getString());
						}

					} else {
						// the item must be an uploaded file save it to disk.
						// Note that there
						// seems to be a bug in item.getName() as it returns the
						// full path on
						// the client's machine for the uploaded file name,
						// instead of the file
						// name only. To overcome that, I have used a workaround
						// using
						// fullFile.getName().
						File fullFile = new File(item.getName());
						File savedFile = new File(getServletContext()
								.getRealPath("/"), fullFile.getName());
						try {
							item.write(savedFile);
						} catch (Exception ex) {
							log("Failed to save file", ex);
						}
					}
				}
			}
		} finally {

		}
		new RequstDealImpl().draw(request);
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("a upload request");
		doPost(request, response);
	}

}
