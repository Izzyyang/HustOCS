/**
 * teacher's idcard verfiy;
 */
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
			$.ajax({
		        url  : "tear/verifyname_Action",
				type : "POST",
				data : "idcard="+name,
				dataType:"text",
				async : false,
				success : showNameMsg,
				error: function(XMLHttpRequest, textStatus, errorThrown) {
	                   alert("返回失败!状态码："+XMLHttpRequest.status+" - "+XMLHttpRequest.readyState+" - "+textStatus);
	               }
			});
		}
	}
	);
		
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
		$.ajax({
	        url  : "tear/verifypsw_Action",
			type : "POST",
			data : "password="+psw+"&idcard="+name,
			dataType:"text",
			async : false,
			success : showPswMsg,
			error: function(XMLHttpRequest, textStatus, errorThrown) {
                   alert("返回失败!状态码："+XMLHttpRequest.status+" - "+XMLHttpRequest.readyState+" - "+textStatus);
               }
		});
	}
}
);

function showPswMsg(data){
	if(data=="empty"){
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
$("input[name='verify']").blur(function() {
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
		$.ajax({
	        url  : "tear/verifypsw_Action",
			type : "POST",
			data : "password="+psw+"&idcard="+name,
			dataType:"text",
			async : false,
			success : showPswMsg,
			error: function(XMLHttpRequest, textStatus, errorThrown) {
                  alert("返回失败!状态码："+XMLHttpRequest.status+" - "+XMLHttpRequest.readyState+" - "+textStatus);
              }
		});
	}
}
);

function showPswMsg(data){
	if(data=="empty"){
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


});
