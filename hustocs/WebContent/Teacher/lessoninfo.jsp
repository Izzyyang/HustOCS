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
	<script src="Teacher/js/hideshow.js" type="text/javascript"></script>
	<script src="Teacher/js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="Teacher/js/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){ 
	    $(".tablesorter").tablesorter(); 
	    
	    $("#logout").click(function (){confirm("你确认要退出系统？");});
		$(".tog").hide();
	    $("#courses>li>a").click(function(){
		    $(this).next('.tog').toggle();
		}); 
	    
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
			<p>${sessionScope.tear.name}(<a href="#">欢迎您！ </a>)</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="Teacher/index.jsp">工具</a> <div class="breadcrumb_divider"></div> <a class="current" id="currentpage">开始新课</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column" style="min-height:660px; max-height:800px;">
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
			<header><h3>课程状态</h3></header>
			<div class="module_content">
				<article class="stats_graph">
					<img src="Teacher/uploadFiles/${sessionScope.currentLesson.picaddress}" width="200" height="140" alt="课程图片"/>
				</article>
				
				<article class="stats_overview">
					<div class="overview_today">
						<p class="overview_day">总计</p>
						<p class="overview_count">1,876</p>
						<p class="overview_type">观看</p>
						<p class="overview_count">2,103</p>
						<p class="overview_type">收藏</p>
					</div>
					<div class="overview_previous">
						<p class="overview_day">昨天</p>
						<p class="overview_count">1,646</p>
						<p class="overview_type">观看</p>
						<p class="overview_count">2,054</p>
						<p class="overview_type">收藏</p>
					</div>
				</article>
				<div class="clear"></div>
			</div>
		</article><!-- end of stats article -->
		<!--h4 class="alert_info">Welcome to the free MediaLoot admin panel template, this could be an informative message.</h4-->
		<!-- end of post new article -->
<article class="module width_3_quarter" style="width:95%; margin:20px 3% 0;">
		<header><h3 class="tabs_involved">课程资源列表</h3>
		<ul class="tabs">
   			<li><a href="#tab1">文档资源</a></li>
    		<li><a href="#tab2">视频资源</a></li>
		</ul>
		</header>

		<div class="tab_container" >
	     <div id="tab1" class="tab_content">
			<table class="tablesorter"> 
			<thead> 
				<tr> 
   					<th></th> 
    				<th>资源名称</th> 
    				<th>附件</th> 
					<th>审核状态</th> 
    				<th>上传时间</th> 
    				<th>操作</th> 
				</tr> 
			</thead> 
			<tbody> 
				<c:forEach var="rese" items="${sessionScope.fileSet.objectsList}">
				       <tr> 
	   					<td><input type="checkbox" name="subcheckf"></td> 
	    				<td><c:out value="${rese.title}" /></td> 
					    <td>
						  <c:choose>
							    <c:when test="${empty rese.reseSort}">
							                 未上传
							    </c:when>
							    <c:otherwise>
							                已上传
							    </c:otherwise>
							</c:choose>
					    </td>
	    				<td><c:out value="${rese.status}" /></td> 
	    				<td><c:out value="${rese.time}" /></td> 
	    				<td><input type="image" src="Teacher/images/icn_edit.png" title="Edit" id="cedit" onClick="ShowDiv('MyDiv','fade')" ><input type="image" src="Teacher/images/icn_trash.png" title="Trash"></td> 
				   </tr> 
			    </c:forEach>
			</tbody> 
		   <tr>
    		  <td colspan="6" style="text-align: center;">
    		         <c:if test="${sessionScope.fileSet.currentPage>1}">
    		            <a href="resource/lookFile_Action?lesid=${les.id}&currentPage=${sessionScope.fileSet.currentPage-1}">上一页</a>
    		         </c:if> 
    				 
    				 <c:forEach begin="1" end="${sessionScope.fileSet.totalPage}" step="1" var="x" >
    				         <a href="resource/lookFile_Action?lesid=${les.id}&currentPage=${x}"> ${x}</a>
    				 </c:forEach>
    				 
    				  <c:if test="${sessionScope.fileSet.currentPage<sessionScope.fileSet.totalPage}">
    				          <a href="resource/lookFile_Action?currentPage=${sessionScope.fileSet.currentPage+1}">下一页</a>
    		         </c:if> 
    		  </td> 
    		</tr>
			</table>
<div class="clear"></div>
			<footer>
				<div class="submit_link">
					<input type="checkbox" id="SelectAll">
					<input type="submit" value="添加" class="alt_btn">
					<input type="submit" value="删除">
				</div>
			</footer>
		</div><!-- end of #tab2 -->
			
			<div id="tab2" class="tab_content">
			<table class="tablesorter"> 
			<thead> 
				<tr> 
   					<th></th> 
    				<th>资源名称</th> 
    				<th>附件</th> 
					<th>审核状态</th> 
    				<th>上传时间</th> 
    				<th>操作</th> 
				</tr> 
			</thead> 
			<tbody> 
				<c:forEach var="rese" items="${sessionScope.videoSet.objectsList}">
				       <tr> 
	   					<td><input type="checkbox" name="subcheckv"></td> 
	    				<td><c:out value="${rese.title}" /></td> 
					    <td>
						    <c:choose>
							    <c:when test="${empty rese.reseSort}">
							                 未上传
							    </c:when>
							    <c:otherwise>
							                已上传
							    </c:otherwise>
							</c:choose>
					    </td>
	    				<td><c:out value="${rese.status}" /></td> 
	    				<td><c:out value="${rese.time}" /></td> 
	    				<td><input type="image" src="Teacher/images/icn_edit.png" title="Edit" id="cedit" onClick="ShowDiv('MyDiv','fade')" ><input type="image" src="Teacher/images/icn_trash.png" title="Trash"></td> 
				   </tr> 
			    </c:forEach>
			</tbody> 
			</table>
<div class="clear"></div>
			<footer>
				<div class="submit_link">
					<input type="checkbox" id="SelectAllf">
					<input type="submit" value="添加" class="alt_btn">
					<input type="submit" value="删除">
				</div>
			</footer>
    </div><!-- end of #tab2 -->
			
		</div><!-- end of .tab_container -->
		
	  </article><!-- end of content manager article -->
		<div class="clear"></div>
	</section>
</span>


<!--弹出层，上传课件-->
	<!--弹出层时背景层DIV-->
	<div id="fade" class="black_overlay">
	</div>
	<div id="MyDiv" class="white_content">
		<div style="text-align: right; cursor: default; height: 20px; left: 747px;">
			<span style="font-size:16px;" onClick="CloseDiv('MyDiv','fade')">
			    <img src="Teacher/images/icn_logout.png" style="margin:5px;">
			</span>
		</div>
		<div class="updatecourse">
		      <table width="600px;">
			     <tr><td class="tabright">课程名称：</td><td><input type="text" placeholder="请输入资源名称"></td></tr>
				 <tr><td class="tabright">资源附件：</td><td><input type="file" style="overflow:hidden; width:350px;"></td></tr>
				 <tr><td class="tabright">审核状态：</td><td><input type="text" value="审核通过" disabled="disabled"></td></tr>
				 <tr><td class="tabright">上传时间：</td><td><input type="text" value="5th April 2011" disabled="disabled"></td></tr>
				 <tr><td class="tabright"></td><td><input type="submit" value="提交" style="width:100px"></td></tr>
			  </table>
		</div>
	</div>
	<!--弹出层介绍-->
</body>
<script type="text/javascript">
//弹出隐藏层
function ShowDiv(show_div,bg_div){
	document.getElementById(show_div).style.display='block';
	document.getElementById(bg_div).style.display='block' ;
	var bgdiv = document.getElementById(bg_div);
	bgdiv.style.width = document.body.scrollWidth;
	// bgdiv.style.height = $(document).height();
	$("#"+bg_div).height($(document).height());
};
//关闭弹出层
function CloseDiv(show_div,bg_div)
{
	document.getElementById(show_div).style.display='none';
	document.getElementById(bg_div).style.display='none';
};

//子复选框的事件  
$(function(){
        //复选框事件  
		//全选、取消全选的事件   
     	$("#SelectAll").click(function(){
     	var all = document.getElementById("SelectAll");
     	var a = document.getElementsByName("subcheckf");
     	if(all){
		    for (var i=0;i<a.length;i++){
		       a[i].checked = this.checked;
		    }
		 }
	});

    // $("input[name='subcheck']").change(function() {
        //if (!$("input[name='subcheck']").checked) {  
          //  $("#SelectAll").attr("checked", false);  
      //  }  
      //  var chsub = $("input[type='checkbox'][name='subcheck']").length; //获取subcheck的个数  
      //  var checkedsub = $("input[type='checkbox'][name='subcheck']:checked").length; //获取选中的subcheck的个数  
       // if (checkedsub == chsub) {  
          //  $("#SelectAll").attr("checked", true);  
      //  }  
   // });
	//choose all files
	$("#SelectAllf").click(function(){
	    var all = document.getElementById("SelectAllf");
     	var a = document.getElementsByName("subcheckv");
     	if(all){
		    for (var i=0;i<a.length;i++){
		       a[i].checked = this.checked;
		    }
		 }
	});
	//single file choose
	  $("input[name='subcheck2']").change(function() {
        if (!$("input[name='subcheck2']").checked) {  
            $("#SelectAllf").attr("checked", false);  
        }  
        var chsub = $("input[type='checkbox'][name='subcheck2']").length; //获取subcheck的个数  
        var checkedsub = $("input[type='checkbox'][name='subcheck2']:checked").length; //获取选中的subcheck的个数  
        if (checkedsub == chsub) {  
            $("#SelectAllf").attr("checked", true);  
        }  
    });
	
}); 
</script>
</html>
