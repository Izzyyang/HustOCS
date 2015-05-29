<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
      	 $("#courseSecond").append("<option value='1'>算法</option>");
		 $("#courseSecond").append("<option value='2'>语言</option>");
		 $("#courseSecond").append("<option value='3'>数据库</option>");
		 $("#courseSecond").append("<option value='4'>移动开发</option>");
		 $("#courseSecond").append("<option value='5'>web开发</option>");
		 $("#courseSecond").append("<option value='6'>嵌入式</option>");
		 $("#courseSecond").append("<option value='7'>大数据</option>");
		 $("#courseSecond").append("<option value='8'>机器学习</option>");
		 $("#courseSecond").append("<option value='9'>其他</option>");
		 $(".tog").hide();
		 
		$("#logout").click(function (){confirm("你确认要退出系统？");});
	    $("#courses>li>a").click(function(){
		    $(this).next('.tog').toggle();
		}); 
			
		
	//when choose course type
	$("#courseFirst").change(function(){
	  if($("#courseFirst").val()=="外教课程"){
		 $("#courseSecond").empty(); 
		 $("#courseSecond").append("<option value='1'>典型程序设计与应用</option>");
		 $("#courseSecond").append("<option value='2'>软件项目管理</option>");
		 $("#courseSecond").append("<option value='3'>分布式程序设计</option>");
		 $("#courseSecond").append("<option value='4'>英语听说强化</option>");
	   }else if($("#courseFirst").val()=="学院课程"){
	     $("#courseSecond").empty(); 
		 $("#courseSecond").append("<option value='1'>算法</option>");
		 $("#courseSecond").append("<option value='2'>语言</option>");
		 $("#courseSecond").append("<option value='3'>数据库</option>");
		 $("#courseSecond").append("<option value='4'>移动开发</option>");
		 $("#courseSecond").append("<option value='5'>web开发</option>");
		 $("#courseSecond").append("<option value='6'>嵌入式</option>");
		 $("#courseSecond").append("<option value='7'>大数据</option>");
		 $("#courseSecond").append("<option value='8'>机器学习</option>");
		 $("#courseSecond").append("<option value='9'>其他</option>");
	   }else{
	    $("#courseSecond").empty(); 
	    $("#courseSecond").append("<option value='10'>其他</option>");
	   }
	});
	
	//course related valid
	$("input[name='courseName']").blur(function (){
	   $("#feedback").css("display","block");
	   if($("input[name='courseName']").val()=="" || $("input[name='courseName']").val()==null){
		 $("#ctitle").css("display","block");
		 $("#ctitle").html("");
		 $("#ctitle").html("课程题目不能为空！");
	   }else{
		 $("#ctitle").html("");
		 $("#ctitle").css("display","none");
	   }
	});
	
							
	$("textarea[name='coursedes']").blur(function (){
	   $("#feedback").css("display","block");
	   if($("textarea[name='coursedes']").val()=="" || $("textarea[name='coursedes']").val()==null){
		 $("#cdes").css("display","block");
		 $("#cdes").html("");
		 $("#cdes").html("课程描述不能为空！");
	   }else{
	     $("#cdes").html("");
		 $("#cdes").css("display","none");
	   }
	});
	
	$("input[name='csub']").click(function (){
	   if($("#feedback").css("display")=="none"){
		  $("#feedback").css("display","block");
		  $("#ctitle").css("display","block");
		  $("#cdes").css("display","block");
	      $("#ctitle").html("");
	      $("#cdes").html("");
		  $("#cdes").html("课程描述不能为空！");
		  $("#ctitle").html("课程题目不能为空！");
		  alert("请填写完整课程信息后提交！");
		  return false;
	  }else if($("#feedback").length()>9){
	      alert("请填写完整课程信息后提交！");
		  return false;
	  }
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
			<div class="btn_view_site"><a href="../teacherpage/teacher.jsp">个人主页</a></div>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
		 <s:if test="#session.user!=null">
			<p><s:property value="%{#session.tear.name}"/> (<a href="#">欢迎您！ </a>)</p>
		  </s:if>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="Teacher/index.jsp">工具</a> <div class="breadcrumb_divider"></div> <a class="current" id="currentpage">开设新课</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column" style="min-height:660px; max-height:800px;">
		<h3>工具</h3>
		<ul class="toggle">
			<li class="icn_new_article" id="addnewCourse"><a href="Teacher/index.jsp">开设新课程</a></li>
			<li class="icn_edit_article" id="personInform"><a href="Teacher/personalinfo.jsp">个人资料</a></li>
			<li class="icn_categories" id="personSafe"><a href="Teacher/securityinfo.jsp">账号安全</a></li>
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
			   <a>数据库原理</a>
			    <ul class="tog">
				     <li><a href="Teacher/updateCourse.jsp" style="background:url(Teacher/images/icn_edit.png) no-repeat scroll left center rgba(0, 0, 0, 0);" id="updatec"> 修改课程信息</a>
					 </li>
					 <li><a href="Teacher/lessoninfo.jsp" id="upload" style="background:url(Teacher/images/icn_folder.png) no-repeat scroll left center rgba(0, 0, 0, 0);">上传课件</a></li>
				</ul>
			</li>
			
			<li class="icn_audio"><a>算法分析</a>
			     <ul class="tog">
				     <li><a href="Teacher/updateCourse.jsp" style="background:url(Teacher/images/icn_edit.png) no-repeat scroll left center rgba(0, 0, 0, 0);" id="updatec"> 修改课程信息</a>
					 </li>
					 <li><a href="Teacher/lessoninfo.jsp" id="upload">上传课件</a></li>
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
	     <section id="main">
           <article class="module width_full">
			<header><h3>课程信息</h3></header>
				<div class="module_content">
						<fieldset>
							<label>课程名称</label>
							<input type="text" id="coursename" name="courseName" style=" width:96%;">
						</fieldset>
						<fieldset>
						    <span style="float:left; width:60%; margin-left:10px;">
								<label>课程简介</label>
								<textarea rows="12" name="coursedes"></textarea>
							</span>
							<span style="float:left; width:30%;">
							    <label>课程图片</label>
							    <input type="file">
							</span>
						</fieldset>
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>一级分类</label>
							<select style="width:92%;" id="courseFirst">
								<option>学院课程</option>
								<option>外教课程</option>
								<option>其他</option>
							</select>
						</fieldset>
						<fieldset style="width:48%; float:left;">
							<label>二级分类</label>
							<select style="width:92%;" id="courseSecond">
							</select>
						</fieldset>
						<div class="clear"></div>
						<div id="feedback" style="display:none">
							<h4 class="alert_error" id="ctitle" style="display:none"></h4>
							<h4 class="alert_error" id="cdes" style="display:none"></h4>
	                    </div>
						
				</div>
			<footer>
				<div class="submit_link">
				   <input type="submit" value="添加课程" class="alt_btn" name="csub">
					<input type="submit" value="重置">
				</div>
			</footer>
	  </article><!-- end of post new article -->
</section>
</span>
</body>
</html>