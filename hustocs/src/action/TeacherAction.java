package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import service.teacher.LessonServicer;
import service.teacher.TeacherInfoService;
import service.teacher.TeacherInfoServicer;
import service.teacher.TeacherServiceFactory;
import service.teacher.TeacherServicer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ognl.OgnlValueStack;

import dao.TeacherDao;
import dao.TeacherInfoDao;
import entity.Lesn;
import entity.Tear;
import entity.TearInfo;

public class TeacherAction extends ActionSupport implements RequestAware,
		ServletRequestAware {
	private Map<String, Object> request;
	protected HttpServletRequest servletRequest;
	private HttpServletResponse servletresponse;
	private TeacherInfoServicer teacherinfoService = TeacherServiceFactory.produceTeacherInfoService();
	/**
	 * verfiy submit
	 */
	public void verifysubcode(){
		// 获得OgnlValueStack 对象
        OgnlValueStack stack = (OgnlValueStack)request.get("struts.valueStack");
        // 获得HttpServletResponse对象
		servletresponse = (HttpServletResponse)stack.getContext().get(StrutsStatics.HTTP_RESPONSE);
        servletresponse.setContentType("text/xml;charset=UTF-8");   
        servletresponse.setHeader("Cache-Control", "no-cache"); 
        servletresponse.setContentType("application/json");
        servletresponse.setCharacterEncoding("UTF-8");
		
		String code="";
		String idcard="";
		String password="";
		String rand = (String) servletRequest.getSession().getAttribute("rand");
        
        code=servletRequest.getParameter("code").trim();
        idcard=servletRequest.getParameter("idcard").trim();
        password=servletRequest.getParameter("password").trim();
        PrintWriter writer = null;
        TearInfo teacherinfo=null;
        
        try {
			writer = servletresponse.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
        //用户名存在
        if(teacherinfoService.findTeacherInfoByStr(TearInfo.class, "idcard" ,idcard ).size()>0){
    	    teacherinfo= (TearInfo)teacherinfoService.findTeacherInfoByStr(TearInfo.class, "idcard" ,idcard ).get(0);
    	    //用户名和密码后台验证通过；
    	    if(teacherinfo.getTear().getPasswd().equals(password)){
    	    	if(code.equals(rand)){
	    	    	servletRequest.getSession().setAttribute("tear", teacherinfo);
	    	    	writer.print("success");
    	    	}else{
    	    		writer.print("codewrong");
    	    	}
    	    }else{
    	    	writer.print("nameOrpass");
    	    }
        }else{
        	writer.print("noIdCard");
        }
      			writer.flush();
      			writer.close();
	}
	/**
	 * update teacher's password
	 * @return
	 */
	public String updatePsw(){
		String psw = servletRequest.getParameter("psw");
		String newpsw = servletRequest.getParameter("newpsw");
		String cnewpsw = servletRequest.getParameter("newpsw");
		TearInfo teacherInfor = (TearInfo) servletRequest.getSession().getAttribute("tear");
		if(teacherInfor!=null){
		   Tear teacher = teacherInfor.getTear();
				if(psw!="" && newpsw!="" && cnewpsw !=""){
					if(psw.equals(teacher.getPasswd()) && newpsw.equals(cnewpsw)){
						teacher.setPasswd(newpsw);
						teacherInfor.setTear(teacher);
						if(teacherinfoService.updateTeacherInfo(teacherInfor)){
							 System.out.println(teacherInfor.getTear().getPasswd()+"   ----更改密码----     ");
						     return "updatePsdSuccess";
						}
					}else{
						return "updatePsdFail";
					}
				}
	     }
		 return "updatePsdFail";
	}
	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request= request;
	}


}
