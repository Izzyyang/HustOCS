package action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.BaseDAO;

import service.teacher.LessonServicer;
import service.teacher.TeacherServiceFactory;
import entity.Lesn;
import entity.Tear;
import entity.TearInfo;

@SuppressWarnings("serial")
public class LessonAction extends ActionSupport implements RequestAware,ServletRequestAware {
	private Map<String, Object> request;
	protected HttpServletRequest servletRequest;
	private HttpServletResponse servletresponse;
	private LessonServicer lessonService = TeacherServiceFactory.produceLessonService();
	
    private Lesn lesson;
    
    private File image; //get the upload file
    private String imageFileName;//get the file name;
    private String imageContentType;//get the file type;
    
    
	/**
	 * teacher add new course
	 * @return
	 */
	public String addCourse(){
		System.out.println("123456789");
		System.out.println(" 文件名字   "+imageFileName);
		try {
			lesson.setPicaddress(this.getFilePath(image, imageFileName));
		} catch (Exception e) {
			e.printStackTrace();
			return "failaddLes";
		}
		
		TearInfo teacher = (TearInfo) servletRequest.getSession().getAttribute("tear");
		lesson.setStatus((short) 0);
		lesson.setTear(teacher.getTear());
		//(new Date()).getTime();
		lesson.setTime(new Timestamp(System.currentTimeMillis()));
		
		
//		Lesn less = new Lesn();
//		less.setTear((Tear) new BaseDAO().getById(Tear.class,"1"));
//		less.setBrief("111");
//		less.setFclassify("1");
//		less.setSclassify("2");
//		less.setTitle("23457890-=");
//		less.setStatus((short) 0);
//		less.setTime(new Timestamp(System.currentTimeMillis()));
		
//		//lessonService.openLesson(less);
		if(lessonService.openLesson(lesson)){
			System.out.println("  add lesson success  !");
		   return "success";
		}
		   return "failaddLes";
		
	}
	//upload file
	public String getFilePath(File file, String fileName) throws Exception
	{
		String savePath = ServletActionContext.getServletContext().getRealPath("Teacher/uploadFiles");
		System.out.println(savePath);
		if(file != null)
		{
			File saveFile = new File(new File(savePath), fileName);
			if(!saveFile.getParentFile().exists())
			{
				saveFile.getParentFile().mkdir();
			}
			FileUtils.copyFile(file, saveFile);
		}
		System.out.println(savePath + "\\" + fileName);
		return savePath + "\\" + fileName;
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request= request;
	}
	
	public Lesn getLesson() {
		return lesson;
	}

	public void setLesson(Lesn lesson) {
		this.lesson = lesson;
	}

	//upload file
	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	
}
