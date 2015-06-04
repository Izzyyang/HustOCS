package action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import service.teacher.TeacherServicer;
import entity.Lesn;
import entity.Tear;
import entity.TearInfo;

@SuppressWarnings("serial")
public class LessonAction extends ActionSupport implements RequestAware,ServletRequestAware {
	private Map<String, Object> request;
	protected HttpServletRequest servletRequest;
	private HttpServletResponse servletresponse;
	private LessonServicer lessonService = TeacherServiceFactory.produceLessonService();
	private TeacherServicer teacherService = TeacherServiceFactory.produceTeacherService();
	
    private Lesn lesson;
    private Lesn updateLess;
    
    private File image; //get the upload file
    private String imageFileName;//get the file name;
    private String imageContentType;//get the file type;
    
    private String lesid; //delete/update need lesson id;
    
	/**
	 * teacher add new course
	 * @return
	 */
	public String addCourse(){
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
		return fileName;
	}
	/**
	 * query teacher's all lesson
	 * @return
	 */
	public String queryTeacherLesson(){
		TearInfo teacherInfo = (TearInfo) servletRequest.getSession().getAttribute("tear");
		Tear teacher = null;
		if(teacherInfo!=null){
		   teacher = teacherInfo.getTear();
		}
		if(teacher!=null){
			if(teacher.getLesns()!=null){
				Set<Lesn> flesSet = new HashSet<>();
				Set<Lesn> slesSet = new HashSet<>();
				
				List<Object> fQueryList  = new ArrayList<>();
				List<Object> fVlueList  = new ArrayList<>();
				fQueryList.add("tear");
				fVlueList.add(teacher);
				fQueryList.add("fclassify");
				fVlueList.add("1");
				
				List<Object> sQueryList  = new ArrayList<>();
				List<Object> sVlueList  = new ArrayList<>();
				sQueryList.add("tear");
				sVlueList.add(teacher);
				sQueryList.add("fclassify");
				sVlueList.add("2");
				
				List<Lesn> fLessList = lessonService.listLessons(Lesn.class, fQueryList, fVlueList);
				flesSet =new HashSet<Lesn>();
				if(fLessList!=null){
					flesSet.addAll(fLessList);
				}
				
				List<Lesn> sLessList = lessonService.listLessons(Lesn.class, sQueryList, sVlueList);
				slesSet =new HashSet<Lesn>();
				if(sLessList!=null){
					slesSet.addAll(sLessList);
				}
				
				servletRequest.getSession().setAttribute("flesSet", flesSet);// bachelor lesson
				servletRequest.getSession().setAttribute("slesSet", slesSet);// master lesson
			    
				return "teacherHaveLess";
			}else{
			    return "teacherNoLess";
			}
		}else{
		    return "failaddLes";
		}
	}
	/**
	 * delete lesson
	 * @return
	 */
	public String deleteLesson(){
		TearInfo teacherInfo = (TearInfo) servletRequest.getSession().getAttribute("tear");
		Tear teacher = teacherInfo.getTear();
		Set<Lesn> tearLessons = teacher.getLesns();
		Set<Lesn> deleteLess = new HashSet<Lesn>();
		Lesn deleteLesn = lessonService.viewLesson(Lesn.class, lesid);
		System.out.println(tearLessons.size());
		if(deleteLesn!=null && tearLessons!=null){
			 for(Lesn les : tearLessons){  
		        if(les.getId().equals(deleteLesn.getId())){
		        	tearLessons.remove(les);
		        }
			 } 
			//tearLessons.removeAll(deleteLess);
			System.out.println(tearLessons.size());
			teacher.setLesns(tearLessons);
			if(teacherService.updateTeacher(teacher)){
				 return "dLessSuccess";
			}
		}
		
		return "dLessFail";
	}
	/**
	 * go to update lesson
	 * @return
	 */
	public String goUpdateLess(){
		if(lesid!="" && lesid!=null){
		    Lesn updateLess = lessonService.viewLesson(Lesn.class, lesid);
		    servletRequest.setAttribute("updateLess", updateLess);
		    return "goUpdateLess";
		}else{
		    return "goUpdateFail";
		}
	}
	/**
	 * update lesson
	 * @return
	 */
	public String updateLess(){
		if(updateLess!=null){
			System.out.println(updateLess.getId()+"  ---   id--------");
			Lesn queryLesn = lessonService.viewLesson(Lesn.class, updateLess.getId());
			queryLesn.setBrief(updateLess.getBrief());
			queryLesn.setTitle(updateLess.getTitle());
			queryLesn.setFclassify(updateLess.getFclassify());
			queryLesn.setSclassify(updateLess.getSclassify());
			queryLesn.setPicaddress(updateLess.getPicaddress());
			System.out.println(updateLess.getBrief());
			if(lessonService.updateLesson(queryLesn )){
				return "updateLessSuccess";
			}else{
				return "updateLessFail";
			}
		}
		return "updateLessFail";
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
	public String getLesid() {
		return lesid;
	}
	public void setLesid(String lesid) {
		this.lesid = lesid;
	}
	public Lesn getUpdateLess() {
		return updateLess;
	}
	public void setUpdateLess(Lesn updateLess) {
		this.updateLess = updateLess;
	}
	
}
