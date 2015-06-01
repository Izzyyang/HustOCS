<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8"/>
<title>Educational</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
</head>
<body>
<div class="wrapper col0">
  <div id="topbar">
    <div id="slidepanel">
    <!-- 网站介绍-->
      <div class="topbox">
        <h2>软件学院课程视频站</h2>
        <p>这是华中科技大学软件学院的课程视频网站，在这里，你可以充分的利用课余时间，自由地观看老师的课程视频，浏览课程文档资料，也可以将这些资源下载到你的本地计算机。快乐的使用这个网站来学习吧！</p>
        <p class="readmore"><a href="#">阅读详情 &raquo;</a></p>
      </div>
       <!-- 登录框-->
      <div class="topboxlogin" style="display:block;">
        <h2 style=" width:590px;">教师/学生登录</h2>
        <form action="#" method="post">
          <fieldset>
            <legend>Teachers Login Form</legend>
			<table width="900">
			  <tr>
			     <td align="right" style="width:106px;">教工号、学号/邮箱:</td>
				 <td width="210px"><label for="teachername"><input type="text"  name="num" id="num" value="" /></label></td>
				 <td><span id="cnum">*必填写,填写教工号、学号或者注册时使用的邮箱</span></td>
			  </tr>
			  <tr>
			      <td align="right">用户类型：</td>
				  <td> 
						<input type="radio" name="usertype" id="tech"  value="teacher" tabindex="1" checked/>
						<span>教工号</span>
						&nbsp;&nbsp; 
						<input type="radio" name="usertype" id="stu" value="student" tabindex="1"/>
						<span >学号</span>	
				  </td>
				  <td>
				       <span id="ctype">*请选择用户类型</span>			    
				  </td>
			  </tr>
			   <tr>
			     <td align="right">密码:</td><td><label for="teacherpass">
                 <input type="password" name="pwd" id="pwd" value="" /></label>
				 </td>
				 <td> <span id="cpwd"> *必填写,填写登录密码</span></td>
			  </tr>
			   <tr>
			     <td></td>
				 <td>  <label for="teacherremember">
              <input class="checkbox" type="checkbox" name="teacherremember" id="teacherremember" checked="checked" />
             记住密码</label></td>
			     <td><span id="cpwd"></span></td>
			  </tr>
			   <tr>
			     <td></td>
				 <td>  
				 <input id="loginButton" type="submit" name="teacherlogin" value="登录" />&nbsp;
                 <input type="reset" name="teacherreset" id="teacherreset" value="重置" /></td>
				 <td></td>
			  </tr>
			</table>
          </fieldset>
        </form>
      </div>
      <br class="clear" />
    </div>
   <div id="loginpanel">
      <ul>
        <li class="left" id="toggle"><a id="slideit" href="#slidepanel">登陆</a><a id="closeit" style="display: none;" href="#slidepanel">关闭</a></li>
        <li class="right"><a href="register.html">点此注册》</a></li>
      </ul>
    </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col1">
  <div id="header">
    <div id="logo">
      <h1><a href="index.html">软院视频站</a></h1>
      <p>-----------菜鸟的学习天堂-----------</p>
    </div>
    <div class="fl_right">
      <input id="search"  class="phold searh-color" value="搜索课程、视频、老师简介....."/>
	  <input  type="submit" value="搜 索" class="subbtn">
    </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col2">
  <div id="topnav">
    <ul class="clear">
      <li id="firstItem"><a href="#">首页</a>

	   <ul>
          <li><a class="drop" href="#">最受欢迎课程</a></li>
          <li><a href="#">下载量最大课程</a></li>
          <li><a href="#">最新上传课程</a></li>
        </ul>
      </li>
	  
      <li><a href="#">本科生课程</a>
       
	   <ul>
          <li ><a class="drop" href="#" >数学/算法</a>
              <ul> 
                  <li><a href="#">离散数学</a></li>
                  <li><a href="#">高等工程数学</a></li>
                  <li><a href="#">概率与统计</a></li>
				  <li><a href="#">算法导论</a></li>
              </ul>
          </li>
          <li><a href="#">语言</a>
		      <ul> 
                  <li><a href="#">c语言</a></li>
                  <li><a href="#">java</a></li>
                  <li><a href="#">python</a></li>
				  <li><a href="#">c++</a></li>
              </ul>
		  </li>
          <li><a href="#">数据库</a>
		         <ul> 
                  <li><a href="#">MySQL</a></li>
                  <li><a href="#">Oracle</a></li>
                  <li><a href="#">NoSQL</a></li>
				  <li><a href="#">DB2</a></li>
              </ul>
		  </li>
          <li><a href="#">移动开发</a></li>
          <li><a href="#">WEB开发</a></li>
          <li><a href="#">嵌入式</a></li>
          <li><a href="#">数据库</a></li>
          <li><a href="#">Suspendisse</a></li>
        </ul>
      </li>
	  
	  
      <li><a href="#">研究生课程</a>
	  
        <ul>
          <li><a href="#">面向对象</a></li>
          <li><a href="#">高级软件工程</a></li>
          <li><a href="#">高级软件测试</a></li>
		  <li><a href="#">外教课程</a>
		         <ul> 
                  <li><a href="#">典型程序设计与应用</a></li>
                  <li><a href="#">软件项目管理</a></li>
                  <li><a href="#">分布式程序设计</a></li>
				  <li><a href="#">英语听说强化</a></li>
              </ul>
		  </li>
        </ul>
      </li>
	  
	  <li><a href="#">其他</a>
	  
        <ul>
          <li><a href="http://sse.hust.edu.cn/">学院首页</a></li>
          <li><a href="#footer">成人教育</a></li>
          <li><a href="#footer">自考专业</a></li>
        </ul>
      </li>
	  
     <li><a href="#">联系我们</a>
	  
        <ul>
          <li><a href="#">学院首页</a></li>
          <li><a href="#">邮箱</a></li>
        </ul>
      </li>
	  
    </ul>
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col3">
  <div id="featured_slide">
    <div id="featured_wrap">
      <ul id="featured_tabs">
        <li><a href="#fc1">算法导论<br />
          <span>Nullamlacus dui ipsum conseqlo borttis.</span></a></li>
        <li><a href="#fc2">数据库技术与应用<br />
          <span>Nullamlacus dui ipsum conseqlo borttis.</span></a></li>
        <li><a href="#fc3">操作系统<br />
          <span>Nullamlacus dui ipsum conseqlo borttis.</span></a></li>
        <li><a href="#fc4">离散数学<br />
          <span>Nullamlacus dui ipsum conseqlo borttis.</span></a></li>
      </ul>
      <div id="featured_content">
        <div class="featured_box" id="fc1"><img src="images/demo/1.gif" alt="" />
          <div class="floater"><a href="#">点击观看 &raquo;</a></div>
        </div>
        <div class="featured_box" id="fc2"><img src="images/demo/2.gif" alt="" />
          <div class="floater"><a href="#">Continue Reading &raquo;</a></div>
        </div>
        <div class="featured_box" id="fc3"><img src="images/demo/3.gif" alt="" />
          <div class="floater"><a href="#">Continue Reading &raquo;</a></div>
        </div>
        <div class="featured_box" id="fc4"><img src="images/demo/4.gif" alt="" />
          <div class="floater"><a href="#">Continue Reading &raquo;</a></div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col4">
  <div id="container">
    <div id="hpage">
      <ul>
        <li>
          <h2>最新上线课程</h2>
          <div class="imgholder"><a href="#"><img src="images/demo/200x140.gif" alt="" /></a></div>
          <p>This is a W3C standards compliant free website template from <a href="http://www.os-templates.com/">OS Templates</a>. For more CSS templates visit <a href="http://www.os-templates.com/">Free Website Templates</a>. Etmetus conse cte tuer leo nisl justo sed vest vitae nunc massa scelerit</p>
          <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
        </li>
        <li>
          <h2>观看次数最多课程</h2>
          <div class="imgholder"><a href="#"><img src="images/demo/200x140.gif" alt="" /></a></div>
          <p>This template is distributed using a <a href="http://www.os-templates.com/template-terms">Website Template Licence</a>, which allows you to use and modify the template for both personal and commercial use when you keep the provided credit links in the footer.</p>
          <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
        </li>
        <li>
          <h2>最受好评课程</h2>
          <div class="imgholder"><a href="#"><img src="images/demo/200x140.gif" alt="" /></a></div>
          <p>Seddui vestibulum vest mi liberos estibulum urna at eget amet sed. Etmetus consectetuer leo nisl justo sed vest vitae nunc massa scelerit. Namaucibulum lor ligula nullam risque et ristie sollis sapien nulla neque.</p>
          <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
        </li>
        <li class="last">
          <h2>最受欢迎教师课程</h2>
          <div class="imgholder"><a href="#"><img src="images/demo/200x140.gif" alt="" /></a></div>
          <p>Nullamlacus dui ipsum conseque loborttis non euisque morbi pen as dapibulum orna. Urna ultrices quis curabitur phasellentesque congue magnis vestibulum. Orcieleifendimentum risuspenatoque massa nunc.</p>
          <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
        </li>
      </ul>
      <br class="clear" />
    </div>
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col5">
  <div id="footer">
    <div id="newsletter">
      <h2>友情链接</h2>
      <p>华中科技大学</p>
      <p><a href="#">白云黄鹤BBS站</a></p>
	  <p><a href="#">华中大图书馆</a></p>
	  <p><a href="#">华中大在线</a></p>
	  <p><a href="#">二手市场</a></p>
    </div>
    <div class="footbox">
      <h2>电话</h2>
	  <ul>
        <li><a href="#">027-87792252</a></li>
      </ul>
    </div>
    <div class="footbox">
      <h2>加入我们</h2>
      <ul>
        <li><a href="#">关于我们</a></li>
        <li><a href="#">联系我们</a></li>
      </ul>
    </div>
    <div class="footbox">
      <h2>合作伙伴</h2>
      <ul>
        <li><a href="#">华中科技大学</a></li>
        <li><a href="#">华中科技大学软件学院</a></li>
        <li><a href="#">华中科技大学教务处</a></li>
      </ul>
    </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col6">
  <div id="copyright">
    <p class="fl_left">Copyright &copy; 2014 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a target="_blank" href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
    <br class="clear" />
  </div>
</div>
</body>
</html>
<script type="text/javascript" src="layout/scripts/jquery.min.js"></script>
<script type="text/javascript" src="layout/scripts/jquery.slidepanel.setup.js"></script>
<script type="text/javascript" src="layout/scripts/jquery.ui.min.js"></script>
<script type="text/javascript" src="layout/scripts/jquery.tabs.setup.js"></script>
<script type="text/javascript">
 $(function(){
		  $("#firstItem").addClass("active");
		  
		  $("#topnav > ul > li").click(function () {
				$(this).addClass('active'); 
				$(this).siblings().removeClass('active'); 
			});
		  //搜索框内容；
		  $("#search").blur(function (){
		     this.value=(this.value=='')? '搜索课程、视频、老师简介.....' : this.value ;
			 if(this.value=='搜索课程、视频、老师简介.....'){
			    $(this).css("background","#F5F5F5");
			 }else{
			    $(this).css("background","#FFFFFF");
			 }
		  });
		  $("#search").focus(function (){
		     this.value=(this.value=='搜索课程、视频、老师简介.....')? '' : this.value ;
			 $(this).css("background","#FFFFFF");
		  });
		  
		  $("#num").blur(function (){
		    var num = $("#num").val();
		     if(num==""){
			    $("#cnum").html("");
				$("#cnum").css("color","#FF0000");
				$("#cnum").html("*此项必填，不能为空！");
			 }else if(num.length < 5 ){
			    $("#cnum").html("");
				$("#cnum").css("color","#FF0000");
				$("#cnum").html("*编号长度不符合规范，请重新填写！");
			 }else if(/^[a-zA-Z]([0-9]$){0,10}/.test(num)==false){
			    $("#cnum").html("");
				$("#cnum").css("color","#FF0000");
				$("#cnum").html("*编号以字母开头，只包含字母和数字！");
			 }else if(num.indexOf("@")!=-1){
			    if(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(num) == false){
					$("#cnum").html("");
					$("#cnum").css("color","#FF0000");
					$("#cnum").html("*邮箱格式正确，请重新填写！");
					return false;
				}else{
				   $("#cnum").html("");
				   $("#cnum").html(" √ ");
				   $("#cnum").css("color","#F8F7DF"); 
				}
			 }else{
			   $("#cnum").html("");
			   $("#cnum").html(" √ ");
			   $("#cnum").css("color","#F8F7DF");
			 }
			
		  });
		  
		  
		   $("#loginButton").click(function (){
		     var num = $("#num").val();
			 var type = $('input[name="usertype"]:checked').val(); //teacher or student；
			 var pwd =  $("#pwd").val();
             //用户名验证
		     if(num==""){
			    $("#cnum").html("");
				$("#cnum").css("color","#FF0000");
				$("#cnum").html("*此项必填，不能为空！");
				return false;
			 }else if(num.length < 7 ){
			    $("#cnum").html("");
				$("#cnum").css("color","#FF0000");
				$("#cnum").html("*编号长度不符合规范，请重新填写！");
				return false;
			 }else if(num.indexOf("@")!=-1){
			    if(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(num) == false){
					$("#cnum").html("");
					$("#cnum").css("color","#FF0000");
					$("#cnum").html("*邮箱格式正确，请重新填写！");
					return false;
				}else{
				   $("#cnum").html("");
				   $("#cnum").html(" √ ");
				   $("#cnum").css("color","#F8F7DF"); 
				}
			 }else{
			   $("#cnum").html("");
			   $("#cnum").html(" √ ");
			   $("#cnum").css("color","#F8F7DF");
			 }
			//密码验证 
			 if(pwd==""){
			    $("#cpwd").html("");
				$("#cpwd").css("color","#FF0000");
				$("#cpwd").html("*密码不能为空，请重新填写！");
			 }
			 
		  });
		  
	});
</script>