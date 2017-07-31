<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">  
  
//取得XMLHttpRequest对象是AJAX的要点  
//此getXMLRequest()方法是根据不同浏览器来取得XMLHttpRequest对象  
function getXMLRequest(){  
    var request;  
    try{  
        //for火狐等浏览器  
        request = new XMLHttpRequest();  
    }catch(e){  
        try{  
            //for IE  
            request = new ActiveXObject("Microsoft.XMLHttp");    
        }catch(e){  
            alert("您的浏览器不支持AJAX!!!");  
            return null;  
        }  
    }  
    return request;  
}  

//此checkcode()方法是更换验证码图片的要点  
function checkcode(){  
    var request = getXMLRequest();//得到XMLHttpRequest对象  
    request.open("GET","${pageContext.request.contextPath}/user/validatecode",true);  
    
    request.onreadystatechange = function(){  
        if(request.readyState == 4){  
            document.getElementById("code").src = "${pageContext.request.contextPath}/user/validatecode";//改变验证码图片  
        }  
    }  
       
    request.send(null);  
}  
  
</script>  
</head>
<body>
		<form action="${pageContext.request.contextPath}/user/register" method="post" >
		<p>姓名: <input type="text" name="iusername" style="width: 100px" /></p>
		<p>密码: <input type="text" name="ipassword" style="width: 100px" /></p>
		<p>年龄: <input type="text" name="iage" style="width: 100px" /></p>
		<p>验证码: <input type="text" name="ivcode" style="width: 100px" /><img id="code"  src="${pageContext.request.contextPath}/user/validatecode" ><br>  
<a href="#" onclick="checkcode()">看不清，换一张</a>  </p>
		<p><input type="submit" value="提交" /></p>
		</form>
</body>
</html>