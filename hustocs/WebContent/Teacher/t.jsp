<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
      <html xmlns="http://www.w3.org/1999/xhtml">  
     <head>  
     <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />  
     <title></title>  
     <style type="text/css">  
     #picshow  
       {  
        filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);  
         width:88px;  
        height:125px;  
     }  
     </style>  
     <script type="text/javascript" language="javascript">  
      
     function upimg(imgFile)  
     {   
        var picshow = document.getElementById("picshow");  
         picshow.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgFile.value;  
       picshow.style.width = "88px";  
         picshow.style.height = "125px";  
     }  
      
     </script>  
       </head>  
     <body>  
     <div id="picshow"></div>  
        
     <p>选择图片：<input type="file" size="20" onchange="upimg(this);" /></p>  
      </body>  
     </html>  

