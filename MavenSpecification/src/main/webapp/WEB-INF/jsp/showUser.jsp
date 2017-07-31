<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>测试</title>  
  </head>  
    
  <body>
  <div>
  	<table border="1px">
  		<tr>
  			<td align="center">用户id</td>
  			<td align="center">用户名</td>
  			<td align="center">密码</td>
  			<td align="center">年龄</td>
  		</tr>
  		<tr>
  			<td align="center">${user.id}</td>
  			<td align="center">${user.userName}</td>
  			<td align="center">${user.password}</td>
  			<td align="center">${user.age}</td>
  		</tr>
  	</table>
    		
   </div> 
  </body>  
</html>