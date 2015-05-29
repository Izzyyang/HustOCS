<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8"/>      
	<title>Dashboard I Admin Panel</title>
	
	<link rel="stylesheet" href="Teacher/css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
    <script type="text/javascript" src="Teacher/js/jquery-1.11.1.js"></script>
	<script src="Teacher/js/hideshow.js" type="text/javascript"></script>
	<script src="Teacher/js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="Teacher/js/jquery.equalHeight.js"></script>
	   <script type="text/javascript">
	//cnewpsw    pswc
    $(function(){
     $('.column').equalHeight();
			 
	 $("#newpsw").blur(function(){
	    var va = $("#newpsw").val();
		if(va==""){
		   $("#pnew").html("*新密码不能为空！");
		   $("#pnew").addClass("redcolor");
		}else{
		   $("#pnew").html("");
		   $("#pnew").html("* √ ");
		   $("#pnew").addClass("greencolor");
		}
	});
	$("#cnewpsw").blur(function(){
	   var va = $("#cnewpsw").val();  //确认密码
	   var ps = $("#newpsw").val();   //新密码
		if(va==""){
		   $("#pswc").html("*新密码不能为空！");
		   $("#pswc").addClass("redcolor");
		}else if(va!=ps){
		   $("#pswc").html("*两次密码不一致！");
		   $("#pswc").addClass("redcolor");
		}else if(va==""){
		   $("#pswc").html("*确认不能为空！");
		   $("#pswc").addClass("redcolor");
		}else{
		   $("#pswc").html("");
		   $("#pswc").html("* √ ");
		   $("#pswc").addClass("greencolor");
		}
	});
	
	$("#sbm").click(function(){
	   var va = $("#cnewpsw").val();
	   var ps = $("#newpsw").val(); 
	   if(va=="" && ps==""){
	         alert("密码和确认密码不能为空！");
	         $("#pswc").html("*确认密码不能为空！");
			 $("#pswc").addClass("redcolor"); 
			 $("#pnew").html("*新密码不能为空！");
			 $("#pnew").addClass("redcolor");
		}else if(va!=ps){
		   alert("两次密码不一致，请重新填写！");
		   return false;
		}else{
		  if(va==""){
			   alert("确认密码不能为空，请重新填写！");
			   $("#pswc").html("*确认密码不能为空！");
			   $("#pswc").addClass("redcolor");
		    }else if(ps==""){
			   alert("新密码不能为空，请重新填写！");
			   $("#pnew").html("*新密码不能为空！");
			   $("#pnew").addClass("redcolor");
		   }
            return false;
		}
	});
	
		
    });
</script>
	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
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

});
    </script>

	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
		  $("#ifm").attr("src","Teacher/NewLesson.jsp");
		  $(".tog").hide();
   	 } 
	);
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
    $("#courses>li>a").click(function(){
	    $(this).next('.tog').toggle();
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
			<div class="btn_view_site"><a href="../teacherpage/teacher.jsp">个人主页</a></div>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<p>李杰 (<a href="#">3 条消息 </a>)</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="Teacher/index.jsp">工具</a> <div class="breadcrumb_divider"></div> <a class="current" id="currentpage">开始新课</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column" style="min-height:660px; max-height:800px;">
		<form class="quick_search">
			<input type="text" value="快速搜索" onFocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
		</form>
		<hr/>
		<h3>工具</h3>
		<ul class="toggle">
			<li class="icn_new_article" id="addnewCourse"><a href="Teacher/index.jsp">开设新课程</a></li>
			<li class="icn_edit_article" id="personInform"><a href="Teacher/personalinfo.jsp">个人资料</a></li>
			<li class="icn_categories" id="personSafe"><a href='Teacher/securityinfo.jsp'">账号安全</a></li>
			<li class="icn_tags" id="logout"><a href="#">退出</a></li>
		</ul>
		<h3>课程状态</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="#">课程浏览统计</a></li>
			<li class="icn_view_users"><a href="#">课程审核状态</a></li>
			<li class="icn_profile"><a href="#">Your Profile</a></li>
		</ul>
		<h3>课程管理</h3>
		<ul class="toggle" id="courses">
			<li class="icn_folder">
			    <a>数据库技术与应用</a>
			    <ul class="tog">
				     <li><a href="Teacher/updateCourse.jsp" style="background:url(Teacher/images/icn_edit.png) no-repeat scroll left center rgba(0, 0, 0, 0);" id="updatec"> 修改课程信息</a>
					 </li>
					 <li><a href="Teacher/lessoninfo.jsp" id="upload">上传课件</a></li>
				</ul>
			</li>
			<li class="icn_photo"><a>算法分析与设计</a>
			       <ul class="tog">
				     <li><a href="Teacher/updateCourse.jsp" style="background:url(Teacher/images/icn_edit.png) no-repeat scroll left center rgba(0, 0, 0, 0);" id="updatec"> 修改课程信息</a>
					 </li>
					 <li><a href="lessoninfo.jsp" id="upload">上传课件</a></li>
				</ul>
			</li>
			<li class="icn_audio"><a>高级操作系统</a>
			     <ul class="tog">
				     <li><a href="Teacher/updateCourse.jsp" style="background:url(Teacher/images/icn_edit.png) no-repeat scroll left center rgba(0, 0, 0, 0);" id="updatec"> 修改课程信息</a>
					 </li>
					 <li><a href="Teacher/lessoninfo.jsp" id="upload">上传课件</a></li>
				</ul>
			</li>
			<li class="icn_video"><a>数据结构</a>
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
			<header><h3>更改密码</h3></header>
            
				<div class="module_content">
						<fieldset>
							<label style="width:70px; margin-right:0px;">原密码：</label>
							<input type="text" style="width:40%; text-align:left;" >
						</fieldset>
						<fieldset>
							<label style="width:70px;">新密码：</label>
							<input type="password" style="width:40%; text-align:left;"  id="newpsw">
							<span class="verify" id="pnew"></span>
						</fieldset>
                    <fieldset>
							<label style="width:70px;">确认密码：</label>
							<input type="password" style="width:40%; text-align:left;" id="cnewpsw">
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
		</article><!-- end of post new article -->
  </span>
</body>

</html>
