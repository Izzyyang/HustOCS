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
        	    //System.out.println(teacherinfo.getIdcard()+"   --pass--  "+teacherinfo.getTear().getPasswd());
        	}
        	
        	if(teacherinfo!=null&&teacherinfo.getTear().getPasswd().equals(password)){
            	writer.print("* √密码正确");
            }else{
            	writer.print("* 教工号或者密码错误！");
            }
        }else{
        	System.out.println("teachername is null");
        	if(password =="" && teacheridcard ==""){
        		writer.print("empty");
        	}else if(password ==""){
        		writer.print("* 密码不能为空！");
        	}
      	}
      			writer.flush();
      			writer.close();
	}
	 
	/**
	 * 验证码验证
	 */
	public void verifycode(){
		String code="";
		String rand = (String) servletRequest.getSession().getAttribute("rand");
		// 获得OgnlValueStack 对象
        OgnlValueStack stack = (OgnlValueStack)request.get("struts.valueStack");
        // 获得HttpServletResponse对象
		servletresponse = (HttpServletResponse)stack.getContext().get(StrutsStatics.HTTP_RESPONSE);
        servletresponse.setContentType("text/xml;charset=UTF-8");   
        servletresponse.setHeader("Cache-Control", "no-cache"); 
        servletresponse.setContentType("application/json");
        servletresponse.setCharacterEncoding("UTF-8");
        
        code=servletRequest.getParameter("code").trim();
        PrintWriter writer = null;
        
        try {
			writer = servletresponse.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
        if(code !="" && code.equals(rand)){
        	writer.print("* √验证码正确！");
        }else if(code==""||code==null){
        	writer.print("* 验证码不能为空！");
        	System.out.println(" 22222");
      	}else{
      		System.out.println(" 33333333 back code wrong");
      		writer.print("* 验证码不正确，请重新输入！");
      	}
      			writer.flush();
      			writer.close();
	}
	/**
	 * 提交验证
	 */
	public void verifysubcode(){
		String code="";
		String idcard="";
		String password="";
		String rand = (String) servletRequest.getSession().getAttribute("rand");
		// 获得OgnlValueStack 对象
        OgnlValueStack stack = (OgnlValueStack)request.get("struts.valueStack");
        // 获得HttpServletResponse对象
		servletresponse = (HttpServletResponse)stack.getContext().get(StrutsStatics.HTTP_RESPONSE);
        servletresponse.setContentType("text/xml;charset=UTF-8");   
        servletresponse.setHeader("Cache-Control", "no-cache"); 
        servletresponse.setContentType("application/json");
        servletresponse.setCharacterEncoding("UTF-8");
        
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
        if(teacherinfoService.findTeacherByStr(TearInfo.class, "idcard" ,idcard ).size()>0){
    	    teacherinfo= (TearInfo)teacherinfoService.findTeacherByStr(TearInfo.class, "idcard" ,idcard ).get(0);
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
	
	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request= request;
	}

}
