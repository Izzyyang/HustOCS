<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
<head>
    <base href="<%=basePath%>">  
	<meta charset="utf-8"/>    
	<title>Dashboard I Admin Panel</title>
	<link type="text/css" rel="stylesheet" href="Teacher/css/layout.css" media="screen" />
	<link type="text/css" rel="stylesheet" href="Teacher/css/tear.css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script type="text/javascript" src="Teacher/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="Teacher/js/hideshow.js"></script>
	<script type="text/javascript" src="Teacher/js/jquery.tablesorter.min.js"></script>
	<script type="text/javascript" src="Teacher/js/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){ 
	    $(".tablesorter").tablesorter(); 
		$("#logout").click(function (){confirm("你确认要退出系统？");});
		$(".tog").hide();
	    $("#courses>li>a").click(function(){
		    $(this).next('.tog').toggle();
		}); 
   });
   
  $(function(){$('.column').equalHeight();});
</script>

</head>
<body>
	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="Teacher/index.jsp">华中大公开课教师系统</a></h1>
			<h2 class="section_title">&nbsp;</h2>
			<div class="btn_view_site"><a href="<%=basePath%>/teacherpage/teacher.html">个人主页</a></div>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<p>${sessionScope.tear.name}(<a href="#">   欢迎您！ </a>)</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="Teacher/index.jsp">工具</a> <div class="breadcrumb_divider"></div> <a class="current" id="currentpage">修改密码</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column" style="min-height:660px; max-height:800px;">
		<form class="quick_search">
			<input type="text" value="快速搜索" onFocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
			<input type="submit" value="搜索">
		</form>
		<h3>工具</h3>
		<ul class="toggle">
			<li class="icn_new_article" id="addnewCourse"><a href="Teacher/index.jsp">开设新课程</a></li>
			<li class="icn_edit_article" id="personInform"><a href="Teacher/personalinfo.jsp">个人资料</a></li>
			<li class="icn_categories" id="personSafe"><a href="Teacher/securityinfo.jsp">账号安全</a></li>
			<li class="icn_tags" id="logout"><a href="Teacher/login.jsp">退出</a></li>
		</ul>
		<h3>我的课程</h3>
	<ul class="toggle">
			<li class="icn_add_user"><a href="lesson/queryTeacherLesson_Action">课程列表</a></li>
		</ul>
		<h3>课程管理</h3>
		<ul class="toggle" id="courses">
			<li class="icn_folder">
			   <a>本科生课程</a>
			    <ul class="tog">
				     <li><a href="Teacher/updateCourse.jsp" style="background:url(Teacher/images/icn_edit.png) no-repeat scroll left center rgba(0, 0, 0, 0);" id="updatec"> 修改课程信息</a>
					 </li>
					 <li><a href="Teacher/lessoninfo.jsp" id="upload" style="background:url(Teacher/images/icn_folder.png) no-repeat scroll left center rgba(0, 0, 0, 0);">上传课件</a></li>
				</ul>
			</li>
			
			<li class="icn_audio"><a>研究生课程</a>
			     <ul class="tog">
				     <li><a href="Teacher/updateCourse.jsp" style="background:url(Teacher/images/icn_edit.png) no-repeat scroll left center rgba(0, 0, 0, 0);" id="updatec"> 修改课程信息</a>
					 </li>
					 <li><a href="Teacher/lessoninfo.jsp" id="upload">上传课件</a></li>
				</ul>
			</li>
			
			<li class="icn_audio"><a>其他课程</a>
			     <ul class="tog">
				     <li><a href="Teacher/updateCourse.jsp" style="background:url(Teacher/images/icn_edit.png) no-repeat scroll left center rgba(0, 0, 0, 0);" id="updatec"> 修改课程信息</a>
					 </li>
					 <li><a href="Teacher/lessoninfo.jsp" id="upload">上传课件</a></li>
				</ul>
			</li>
		</ul>
		<h3 id="test">Admin</h3>
		<ul class="toggle">
			<li class="icn_settings"><a>Options</a></li>
			<li class="icn_security"><a>Security</a></li>
			<li class="icn_jump_back"><a>Logout</a></li>
		</ul>
		
		<footer>
			<hr />
			<p><strong>Copyright &copy; 2011 Website Admin</strong></p>
			<p>Theme by MediaLoot</a></p>
		</footer>
	</aside><!-- end of sidebar -->
	
  <span style="width:75%; float:left">
	 <section id="main" class="column">
        <article class="module width_full">
        <form action="tear/updatePsw_Action" method="post">
			<header><h3>更改密码</h3></header>
            
				<div class="module_content">
				     
						<fieldset>
							<label style="width:70px; margin-right:0px;">原密码：</label>
							<input type="text" style="width:40%; text-align:left;" name="psw">
						</fieldset>
						<fieldset>
							<label style="width:70px;">新密码：</label>
							<input type="password" style="width:40%; text-align:left;"  id="newpsw" name="newpsw">
							<span class="verify" id="pnew"></span>
						</fieldset>
                    <fieldset>
							<label style="width:70px;">确认密码：</label>
							<input type="password" style="width:40%; text-align:left;" id="cnewpsw" name="cnewpsw">
							<span class="verify" id="pswc"></span>
						</fieldset>
						<div class="clear"></div>
						
				</div>
			<footer>
				<div class="submit_link">
					
					<input type="submit" value="修改密码" class="alt_btn" id="sbm">
					<input type="submit" value="重置">
				</div>
			</footer>
			</form>
		</article><!-- end of post new article -->
  </span>
</body>

</html>
