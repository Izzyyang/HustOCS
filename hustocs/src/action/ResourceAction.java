package action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.faces.application.resource.ResourceInfo;

import service.*;
import service.teacher.*;
import util.Page;
import util.PageUtil;
import entity.*;

@SuppressWarnings("serial")
public class ResourceAction extends ActionSupport implements RequestAware,ServletRequestAware {
	private Map<String, Object> request;
	protected HttpServletRequest servletRequest;
	private LessonServicer lessonService = TeacherServiceFactory.produceLessonService();
	private ResourceServicer resourcService = TeacherServiceFactory.produceResourceService();
	private ResourceSortServicer resourcSortService = TeacherServiceFactory.produceResourceSortService();
	//lesson id
	private String lesid;
	private String currentPage;
	/**
	 * look lesson's resorce
	 * default show the files resource also you can choose the video resource;
	 * @return
	 */
	public String lookFile(){
		Lesn lesson = null;
		    	if(lesid!=null && lesid!="" && !lesid.equals("")){
		    		lesson = lessonService.viewLesson(Lesn.class, lesid);
		    		servletRequest.getSession().setAttribute("currentLesson",lesson);
		    	}else{
		    	   if(servletRequest.getSession().getAttribute("currentLesson")!=null||servletRequest.getSession().getAttribute("currentLesson")!=""){
		    		   lesson =  (Lesn) servletRequest.getSession().getAttribute("currentLesson");
		    		}else{
		    		   return "lookFileSuccess";
		    		}
		    	}
		    
		    currentPage = (currentPage==null)?"0":currentPage;
		    if(lesson!=null){
				//query file resource;
				ReseSort rSort = resourcSortService.viewResourceSort(ReseSort.class, (short)1);
							
				List<Object> rQueryList  = new ArrayList<>();
				List<Object> rVlueList  = new ArrayList<>();
				rQueryList.add("lesn");
				rVlueList.add(lesson);
				//Resource classification:default show files not video; 
				rQueryList.add("reseSort");
				rVlueList.add(rSort);
							
				Page fLessPage =  resourcService.listLessons(Rese.class, rQueryList, rVlueList,Integer.parseInt(currentPage),6);
				servletRequest.getSession().setAttribute("fileSet", fLessPage);
				System.out.println(fLessPage.getObjectsList().size()+"-------======文件列表====---------");
							
				////////////////////////////////   video  /////////////////////////////////////////////////////////
				//query video resource;
				ReseSort vSort = resourcSortService.viewResourceSort(ReseSort.class, (short)2);
				List<Object> vVlueList  = new ArrayList<>();
				vVlueList.add(lesson);
				vVlueList.add(vSort);
							
				Page vLessPage = resourcService.listLessons(Rese.class, rQueryList, vVlueList,Integer.parseInt(currentPage),6);
				servletRequest.getSession().setAttribute("videoSet", vLessPage);
							
				System.out.println(fLessPage.getObjectsList().size()+"-------======视频列表====---------");
				return "lookFileSuccess";
			}
		return "lookFileFail";
	}
	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request= request;
	}
	public String getLesid() {
		return lesid;
	}
	public void setLesid(String lesid) {
		this.lesid = lesid;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
}
