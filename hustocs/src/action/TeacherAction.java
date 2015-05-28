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

import service.teacher.TeacherInfoService;
import service.teacher.TeacherInfoServicer;
import service.teacher.TeacherServiceFactory;
import service.teacher.TeacherServicer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ognl.OgnlValueStack;

import dao.TeacherDao;
import dao.TeacherInfoDao;
import entity.Tear;
import entity.TearInfo;

public class TeacherAction extends ActionSupport implements RequestAware,
		ServletRequestAware {
	private Map<String, Object> request;
	protected HttpServletRequest servletRequest;
	private HttpServletResponse servletresponse;
	private TeacherInfoServicer teacherinfoService = TeacherServiceFactory.produceTeacherInfoService();
			//new TeacherInfoService(new TeacherInfoDao());
	//private TeacherServicer teacherServicer = TeacherServiceFactory.produceTeacherService();
    //登录时验证用户名
	@SuppressWarnings("null")
	public void verifyname() {
		String teacheridcard="";
		// 获得OgnlValueStack 对象
        OgnlValueStack stack = (OgnlValueStack)request.get("struts.valueStack");
        // 获得HttpServletResponse对象
		servletresponse = (HttpServletResponse)stack.getContext().get(StrutsStatics.HTTP_RESPONSE);
        servletresponse.setContentType("text/xml;charset=UTF-8");   
        servletresponse.setHeader("Cache-Control", "no-cache"); 
        servletresponse.setContentType("application/json");
        servletresponse.setCharacterEncoding("UTF-8");
        
        teacheridcard=servletRequest.getParameter("idcard").trim();
        PrintWriter writer = null;
        
        try {
			writer = servletresponse.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        TearInfo teacher = null;
        if(teacheridcard !=""){
        	 //参数设定；
//        	 List<String> queryList = new ArrayList<>();
//             queryList.add("idcard");
//             List<Object> queryValue = new ArrayList<>();
//             queryValue.add(teacheridcard);
        	
            if(teacherinfoService.findTeacherByStr(TearInfo.class, "idcard" , teacheridcard)!=null){
        	    teacher= (TearInfo)teacherinfoService.findTeacherByStr(TearInfo.class,"idcard" , teacheridcard).get(0);
        	    writer.print("* √正确教工号");
        	}else{
            	writer.print("* 此教工号不存在");
            }
        }else{
      		writer.print("教师编号不能为空！");
      	}
      			writer.flush();
      			writer.close();
	}

	public void verifypsw(){
		System.out.println("------------------------------进入验证密码函数-----");
		String teacheridcard;
		String password;
		// 获得OgnlValueStack 对象
        OgnlValueStack stack = (OgnlValueStack)request.get("struts.valueStack");
        // 获得HttpServletResponse对象
		servletresponse = (HttpServletResponse)stack.getContext().get(StrutsStatics.HTTP_RESPONSE);
        servletresponse.setContentType("text/xml;charset=UTF-8");   
        servletresponse.setHeader("Cache-Control", "no-cache"); 
        servletresponse.setContentType("application/json");
        servletresponse.setCharacterEncoding("UTF-8");
        
        password=servletRequest.getParameter("password").trim();
        teacheridcard=servletRequest.getParameter("idcard").trim();
        System.out.println("------hhhhhhhhhhhhhhh------"+password+ "   " + teacheridcard);
        PrintWriter writer = null;
        
        try {
			writer = servletresponse.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        TearInfo teacherinfo = null;
        if(password !="" && teacheridcard !=""){
        	if(teacherinfoService.findTeacherByStr(TearInfo.class, "idcard" ,teacheridcard ).size()>0){
        	    teacherinfo= (TearInfo)teacherinfoService.findTeacherByStr(TearInfo.class, "idcard" ,teacheridcard ).get(0);
        	    
        	    System.out.println(teacherinfo.getIdcard()+"   --pass--  "+teacherinfo.getTear().getPasswd());
        	}
        	
        	if(teacherinfo!=null&&teacherinfo.getTear().getPasswd().equals(password)){
            	writer.print("* √密码正确");
            }else{
            	writer.print("* 教工号或者密码错误！");
            }
        }else{
        	System.out.println("teachername is null");
        	if(password =="" && teacheridcard ==""){
        		writer.print("empty！");
        	}else if(password ==""){
        		writer.print("* 密码不能为空！");
        	}
      	}
      			writer.flush();
      			writer.close();
	}
	 
	//String rand = (String) servletRequest.getSession().getAttribute("rand");
	/**
	 * 验证码验证
	 */
	public void verifycode(){
		System.out.println("-----------验证码---------");
		String teacheridcard;
		String password;
		// 获得OgnlValueStack 对象
        OgnlValueStack stack = (OgnlValueStack)request.get("struts.valueStack");
        // 获得HttpServletResponse对象
		servletresponse = (HttpServletResponse)stack.getContext().get(StrutsStatics.HTTP_RESPONSE);
        servletresponse.setContentType("text/xml;charset=UTF-8");   
        servletresponse.setHeader("Cache-Control", "no-cache"); 
        servletresponse.setContentType("application/json");
        servletresponse.setCharacterEncoding("UTF-8");
        
        password=servletRequest.getParameter("password").trim();
        teacheridcard=servletRequest.getParameter("idcard").trim();
        System.out.println("------hhhhhhhhhhhhhhh------"+password+ "   " + teacheridcard);
        PrintWriter writer = null;
        
        try {
			writer = servletresponse.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        TearInfo teacherinfo = null;
        if(password !="" && teacheridcard !=""){
        	if(teacherinfoService.findTeacherByStr(TearInfo.class, "idcard" ,teacheridcard ).size()>0){
        	    teacherinfo= (TearInfo)teacherinfoService.findTeacherByStr(TearInfo.class, "idcard" ,teacheridcard ).get(0);
        	    
        	    System.out.println(teacherinfo.getIdcard()+"   --pass--  "+teacherinfo.getTear().getPasswd());
        	}
        	
        	if(teacherinfo!=null&&teacherinfo.getTear().getPasswd().equals(password)){
            	writer.print("* √密码正确");
            }else{
            	writer.print("* 教工号或者密码错误！");
            }
        }else{
        	System.out.println("teachername is null");
        	if(password =="" && teacheridcard ==""){
        		writer.print("empty！");
        	}else if(password ==""){
        		writer.print("* 密码不能为空！");
        	}
      	}
      			writer.flush();
      			writer.close();
	
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
