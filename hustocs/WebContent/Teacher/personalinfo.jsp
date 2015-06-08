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
	
	<link rel="stylesheet" href="Teacher/css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script type="text/javascript" src="Teacher/js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="Teacher/js/hideshow.js" ></script>
	<script type="text/javascript" src="Teacher/js/jquery.tablesorter.min.js" ></script>
	<script type="text/javascript" src="Teacher/js/jquery.equalHeight.js"></script>
	
	<script type="text/javascript">
	$(function(){
	    //1、
	   // $(".tablesorter").tablesorter(); 
		//When page loads...
		//$(".tab_content").hide(); //Hide all content
	//	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
		//$(".tab_content:first").show(); //Show first tab content
	
    $(".tog").hide();
	
	//2、On Click Event show course;
	$("ul.tabs li").click(function() {
		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});
	
	
	}); //end of the outermost js;
	 
    </script>

	<script type="text/javascript">
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});
	$("#logout").click(function (){
         confirm("你确认要退出系统？");
	});
  
});
    </script>
    <script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
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
			<article class="breadcrumbs"><a href="Teacher/index.jsp">工具</a> <div class="breadcrumb_divider"></div> <a class="current" id="currentpage">个人信息</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column" style="min-height:660px; max-height:800px;">
		<form class="quick_search">
			<input type="text" value="快速搜索" onFocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
			<input type="submit" value="搜索">
		</form>
		<hr/>
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
	  	<article class="module width_full">
			<header><h3>基本资料</h3></header>
			<div class="module_content">
				<article class="stats_graph">
                    <label>姓名：</label><input type="text" value="${sessionScope.tear.name}" style="width:40px"/>
                    <label>电话：</label><input type="text" value="${sessionScope.tear.phone}"/>
                    
                    <label>注册时间：</label><input type="text" value="${sessionScope.tear.time}"/>
				</article>
				
				<article class="stats_overview">
					<div class="overview_previous">
						<p class="overview_day">被关注次数</p>
						<p class="overview_count">1,646人</p>
					</div>
				</article>
				<div class="clear"></div>
			</div>
		</article><!-- end of stats article -->
       
		<article class="module width_full">
			<header><h3 style="padding-left: 10px">详细资料</h3></header>
               <form action="">
				<div class="module_content">
						<fieldset>
							<label style="width:70px;">教师编号：</label>
							<input type="text" value="${sessionScope.tear.idcard}">
						</fieldset>
						<fieldset>
							<label>个人简介</label>
							<textarea rows="12">
                                ${sessionScope.tear.brief}
							</textarea>
						</fieldset>
					  	<div class="clear"></div>
				</div>
			<footer>
				<div class="submit_link">
					<input type="submit" value="发布" class="alt_btn">
					<input type="reset" value="重置">
					</form>
				</div>
			</footer>
		</article><!-- end of post new article -->
</span>

</body>

</html>

