$(function(){
		
/**
 * 登录按钮验证；sub
 */

$("#sub").click(function() {
	var code = $("input[name='verify']").val();
	var idcard = $("input[name='name']").val();
	var password =$("input[name='password']").val();
	//verify code
	if(code==null){
		$("#vpsw").html("");
		$("#vpsw").css("color","#FF0000");
		$("#vpsw").html("*验证码不能为空！");
		return false;
	}else if(code.length > 5){
		$("#vpsw").html("");
		$("#vpsw").css("color","#FF0000");
		$("#vpsw").html("*验证码长度过长，请重新填写！");
		$(this).foucs();
		return false;
	}
	//idcard
	if(idcard==null){
		$("#vname").html("");
		$("#vname").css("color","#FF0000");
		$("#vname").html("*教工号不能为空！");
		$(this).foucs();
		return false;
	}else if(idcard.length > 32){
		$("#vname").html("");
		$("#vname").css("color","#FF0000");
		$("#vname").html("*用户名长度过长，请重新填写！");
		$(this).foucs();
		return false;
	}
	//password
	if(password==null){
		$("#vpsw").html("");
		$("#vpsw").css("color","#FF0000");
		$("#vpsw").html("*密码不能为空！");
		$(this).foucs();
		return false;
	}else if(password.length > 32){
		$("#vpsw").html("");
		$("#vpsw").css("color","#FF0000");
		$("#vpsw").html("*密码长度过长，请重新填写！");
		$(this).foucs();
		return false;
	}
	
	if(password!="" && code!="" && idcard!=""){
		$.ajax({
	        url  : "tear/verifysubcode_Action",
			type : "POST",
			data : "code="+code+"&idcard="+idcard+"&password="+password,
			dataType:"text",
			async : false,
			success : showSubMsg,
			error: function(XMLHttpRequest, textStatus, errorThrown) {
                 alert("返回失败!状态码："+XMLHttpRequest.status+" - "+XMLHttpRequest.readyState+" - "+textStatus);
              }
		});
	}
}
);

function showSubMsg(data){
	if(data=="success"){
		window.location.href="http://localhost:8080/hustocs/Teacher/index.jsp";
	}else if(data=="noIdCard"){
	     $("#vname").html("");
		 $("#vname").html("* 教工号不存！");
		 $("#vname").css("color","#FF0000");
	}else if(data=="nameOrpass"){
		 $("#vpsw").html("");
		 $("#vpsw").html("* 教工号或者密码错误！");
		 $("#vpsw").css("color","#FF0000");
	}else if(data=="codewrong"){
		 $("#vcode").html("");
		 $("#vcode").html("*验证码不正确，请重新输入！");
		 $("#vcode").css("color","green"); 
	}else if(data=="* 验证码不正确，请重新输入！"){
		 alert("code wrong");
		 $("#vcode").html("");
		 $("#vcode").html(data);
		 $("#vcode").css("color","#FF0000");
	}
}

});
