<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
有错
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC "-//Apache Software Foundation//DTD Struts Configuration 2.1//EN" "http://struts.apache.org/dtds/struts-2.1.dtd">
<struts>
    <!-- <constant name="struts.action.extension" value="action" /> -->

    <constant name="struts.enable.DynamicMethodInvocation" value="false" />
    <constant name="struts.devMode" value="true" />
   
    <package name="default" namespace="/" extends="struts-default">
        <default-action-ref name="index" />
        <global-results>
            <result name="error">/WEB-INF/jsp/error.jsp</result>
        </global-results>
        <global-exception-mappings>
            <exception-mapping exception="java.lang.Exception" result="error"/>
        </global-exception-mappings>
        
		  <!--action name="index">
            <result type="redirectAction">
                <param name="actionName">HelloWorld</param>
                <param name="namespace">/example</param>
            </result>
        </action-->
       <action name="login" class="action.UserAction" method="login">
			<result name="succ">/error.jsp</result>
		</action>
    </package>
 <package name="Teacher" namespace="/tear" extends="struts-default">
		<action name="*_Action" class="action.TeacherAction" method="{1}">
		   <!-- 配置fileUpload的拦截器 -->
			<interceptor-ref name="fileUpload">
				<!-- 配置允许上传的文件类型 -->
				<param name="allowedTypes">image/png,image/gif,image/jpeg</param>
				<!-- 配置允许上传的文件大小 -->
				<param name="maximumSize">50000</param> 
			</interceptor-ref> 
			<!-- 配置系统默认的拦截器 -->
			<interceptor-ref name="defaultStack"/>
			<!-- 动态设置Action的属性值 -->
			<param name="savePath">/Teacher/uploadFiles</param>
			<!-- 配置Struts 2默认的视图页面 -->
			<result name="input">/Teacher/login.jsp</result>
			<result name="success">/Teacher/index.jsp</result>
			<result name="cPwd" >/Teacher/mySafe.jsp</result>
		</action>
	</package>
</struts>    

	


</body>
</html>