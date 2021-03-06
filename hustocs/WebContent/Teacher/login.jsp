<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">  
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>后台管理系统登录</title>

    <!-- Bootstrap Core CSS -->
    <link href="Teacher/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="Teacher/css/metisMenu.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="Teacher/css/sb-admin-2.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4" style="width: 400px;">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3>欢迎登录华科软院视频站后台！</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" id="loginform">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" id="name" placeholder="请输入教工号" name="name">
                                    <div id="vname" style="margin-left:13px;line-height:16px;vertical-align:middle"></div>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id="password" placeholder="请输入密码" name="password" type="password"/>
                                    <div id="vpsw" style="margin-left:13px;line-height:16px;vertical-align:middle"></div>
                                </div>
                                <div class="form-group" style="padding-bottom:30px;">
                                    <input class="form-control" id="verify" placeholder="验证码" name="verify" type="input" style="width:100px;float:left;">
                                    <span style="float:left;"><img src="Teacher/image.jsp" name="validateCodeImg" border=0 id="validateCodeImg" style="width:60px;margin:0px 10px;"/><a href="javascript:void(0);" onClick="changeimg()">换一张 </a></span> 
                                </div>
                                <div id="vcode" style="margin-left:13px;line-height:20px;vertical-align:middle;clear:both;margin-top:-10px;"></div>
                                <input id="sub" type="button" class="btn btn-lg btn-success btn-block" value="登录"/>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="Teacher/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="Teacher/js/teacherlogin.js"></script>
    <SCRIPT type="text/javascript">
	function changeimg()	
	{
		var myimg = document.getElementById("validateCodeImg"); 
		now = new Date(); 
		myimg.src="Teacher/image.jsp?code="+now.getTime();
	} 
	$(function(){
	$("input[name='name']").blur(function() {
		var name = $(this).val();
		if(name==null){
			$("#vname").html("");
			$("#vname").css("color","#FF0000");
			$("#vname").html("*教工号不能为空！");
			$(this).foucs();
		}else if(name.length > 32){
			$("#vname").html("");
			$("#vname").css("color","#FF0000");
			$("#vname").html("*用户名长度过长，请重新填写！");
			$(this).foucs();
		}else{
		    $("#vname").html("");
		}
		});
		
		$("input[name='password']").blur(function() {
			var psw = $(this).val();
			var name = $("input[name='name']").val();
			if(psw==null){
				$("#vpsw").html("");
				$("#vpsw").css("color","#FF0000");
				$("#vpsw").html("*密码不能为空！");
				$(this).foucs();
			}else if(psw.length > 32){
				$("#vpsw").html("");
				$("#vpsw").css("color","#FF0000");
				$("#vpsw").html("*密码长度过长，请重新填写！");
				$(this).foucs();
			}else{
			    $("#vpsw").html("");
			}
			});
	$("input[name='verify']").blur(function() {
		var code = $(this).val();
		var rand = $("#rand").val();
		if(code==null){
			$("#vcode").html("");
			$("#vcode").css("color","#FF0000");
			$("#vcode").html("*验证码不能为空！");
		}else if(code.length > 5){
			$("#vcode").html("");
			$("#vcode").css("color","#FF0000");
			$("#vcode").html("*验证码长度过长，请重新输入！");
		}else{
		    $("#vcode").html("");
		}
	});
	
});
	
   </SCRIPT>
</body>
</html>
