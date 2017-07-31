<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>
<body>
<form action="${pageContext.request.contextPath}/user/showUser" method="post" >
<p>编号: <input type="text" name="id" style="width: 300px" /></p>
<p><input type="submit" value="提交" /></p>
</form>

<button type="button" onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/user/zhuCe'">注册</button>
</body>
</html>
