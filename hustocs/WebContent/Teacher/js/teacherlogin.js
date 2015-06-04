/**
 * teacher's idcard verfiy;
 */
$(function(){
//	$("input[name='name']").blur(function() {
//		var name = $(this).val();
//		if(name==null){
//			$("#vname").html("");
//			$("#vname").css("color","#FF0000");
//			$("#vname").html("*教工号不能为空！");
//			$(this).foucs();
//		}else if(name.length > 32){
//			$("#vname").html("");
//			$("#vname").css("color","#FF0000");
//			$("#vname").html("*用户名长度过长，请重新填写！");
//			$(this).foucs();
//		}else{
//			$.ajax({
//		        url  : "tear/verifyname_Action",
//				type : "POST",
//				data : "idcard="+name,
//				dataType:"text",
//				async : false,
//				success : showNameMsg,
//				error: function(XMLHttpRequest, textStatus, errorThrown) {
//	                   alert("返回失败!状态码："+XMLHttpRequest.status+" - "+XMLHttpRequest.readyState+" - "+textStatus);
//	               }
//			});
//		}
//	}
//	);
		
function showNameMsg(data){
	    if(data == "* √正确教工号"){ //name is right!
			 $("#vname").html("");
			 $("#vname").html(data);
			 $("#vname").css("color","green"); 
		}else{  //name is wrong!
		     $("#vname").html("");
			 $("#vname").html(data);
			 $("#vname").css("color","#FF0000");
		}
   }
/**
 * 密码验证；
 */
//$("input[name='password']").blur(function() {
//	var psw = $(this).val();
//	var name = $("input[name='name']").val();
//	if(psw==null){
//		$("#vpsw").html("");
//		$("#vpsw").css("color","#FF0000");
//		$("#vpsw").html("*密码不能为空！");
//		$(this).foucs();
//	}else if(psw.length > 32){
//		$("#vpsw").html("");
//		$("#vpsw").css("color","#FF0000");
//		$("#vpsw").html("*密码长度过长，请重新填写！");
//		$(this).foucs();
//	}else{
//		$.ajax({
//	        url  : "tear/verifypsw_Action",
//			type : "POST",
//			data : "password="+psw+"&idcard="+name,
//			dataType:"text",
//			async : false,
//			success : showPswMsg,
//			error: function(XMLHttpRequest, textStatus, errorThrown) {
//                   alert("返回失败!状态码："+XMLHttpRequest.status+" - "+XMLHttpRequest.readyState+" - "+textStatus);
//               }
//		});
//	}
//}
//);

function showPswMsg(data){
	if(data=="empty"){
		 alert("都为空！");
	     $("#vname").html("");
		 $("#vname").html("*用户名不能为空");
		 $("#vname").css("color","#FF0000");
		
		 $("#vpsw").html("");
		 $("#vpsw").css("color","#FF0000");
		 $("#vpsw").html("*密码不能为空！");
	}else if(data=="* 教工号或者密码错误！"){
		 $("#vpsw").html("");
		 $("#vpsw").html(data);
		 $("#vpsw").css("color","#FF0000");
	}else{
		 $("#vpsw").html("");
		 $("#vpsw").html(data);
		 $("#vpsw").css("color","green"); 
	}
}

/**
 * 验证码验证；
 */
//$("input[name='verify']").blur(function() {
//	var code = $(this).val();
//	if(code==null){
//		$("#vcode").html("");
//		$("#vcode").css("color","#FF0000");
//		$("#vcode").html("*验证码不能为空！");
//		$(this).foucs();
//	}else if(code.length > 5){
//		$("#vcode").html("");
//		$("#vcode").css("color","#FF0000");
//		$("#vcode").html("*验证码长度过长，请重新填写！");
//		$(this).foucs();
//	}else{
//		$.ajax({
//	        url  : "tear/verifycode_Action",
//			type : "POST",
//			data : "code="+code,
//			dataType:"text",
//			async : false,
//			success : showCodeMsg,
//			error: function(XMLHttpRequest, textStatus, errorThrown) {
//                  alert("返回失败!状态码："+XMLHttpRequest.status+" - "+XMLHttpRequest.readyState+" - "+textStatus);
//              }
//		});
//	}
//}
//);

function showCodeMsg(data){
	if(data==""||data==null){
	     $("#vcode").html("");
		 $("#vcode").html("* 验证码不能为空！");
		 $("#vcode").css("color","#FF0000");
	}else if(data=="* 验证码错误！"){
		 $("#vcode").html("");
		 $("#vcode").html(data);
		 $("#vcode").css("color","#FF0000");
	}else if(data=="* √验证码正确！"){
		 $("#vcode").html("");
		 $("#vcode").html(data);
		 $("#vcode").css("color","green"); 
	}else if(data=="* 验证码不正确，请重新输入！"){
		 alert("code wrong");
		 $("#vcode").html("");
		 $("#vcode").html(data);
		 $("#vcode").css("color","#FF0000");
	}else if(data=="success"){
		window.location.href="Teacher/index.jsp";
	}
	
}
/**
 * 登录按钮验证；sub
 */

$("#sub").click(function() {
	alert("");
	var code = $("input[name='verify']").val();
	var idcard = $("input[name='name']").val();
	var password =$("input[name='password']").val();
	//verify code
	if(code==null){
		$("#vpsw").html("");
		$("#vpsw").css("color","#FF0000");
		$("#vpsw").html("*验证码不能为空！");
		$(this).foucs();
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
                 // alert("返回失败!状态码："+XMLHttpRequest.status+" - "+XMLHttpRequest.readyState+" - "+textStatus);
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
