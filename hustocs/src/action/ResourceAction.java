package action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.faces.application.resource.ResourceInfo;

import service.*;
import service.teacher.*;
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
	private String fileType;
	/**
	 * look lesson's resorce
	 * default show the files resource also you can choose the video resource;
	 * @return
	 */
	public String lookFile(){
		Lesn lesson = null;
		short filetype = Short.parseShort(fileType);
		if(lesid!=null && lesid!="" && !lesid.equals("")){
				lesson = lessonService.viewLesson(Lesn.class, lesid);
				if(lesson!=null){
					//query file resource;
					ReseSort rSort = resourcSortService.viewResourceSort(ReseSort.class, (short)1);
					Set<Rese> filesSet = new HashSet<>();
					
					List<Object> rQueryList  = new ArrayList<>();
					List<Object> rVlueList  = new ArrayList<>();
					rQueryList.add("lesn");
					rVlueList.add(lesson);
					//Resource classification:default show files not video; 
					rQueryList.add("reseSort");
					rVlueList.add(rSort);
					
					List<Rese> fLessList = resourcService.listLessons(Rese.class, rQueryList, rVlueList);
					filesSet =new HashSet<Rese>();
					if(fLessList!=null){
					   filesSet.addAll(fLessList);
					}
					servletRequest.getSession().setAttribute("fileSet", filesSet);
					
					//query video resource;
					ReseSort vSort = resourcSortService.viewResourceSort(ReseSort.class, (short)2);
					Set<Rese> videoSet = new HashSet<>();
					
					List<Object> vVlueList  = new ArrayList<>();
					vVlueList.add(lesson);
					//Resource classification:default show files not video; 
					vVlueList.add(vSort);
					
					List<Rese> vLessList = resourcService.listLessons(Rese.class, rQueryList, vVlueList);
					videoSet =new HashSet<Rese>();
					if(vLessList!=null){
						videoSet.addAll(vLessList);
					}
					servletRequest.getSession().setAttribute("vidwoSet", videoSet);
					return "lookFileSuccess";
				}
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
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
}
