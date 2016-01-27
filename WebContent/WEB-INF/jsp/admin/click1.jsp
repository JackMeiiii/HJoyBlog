<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${blog_name }</title>
	<jsp:include page="/WEB-INF/jsp/admin/sideMenu.jsp"></jsp:include>
<script type="text/javascript" src="<%=request.getContextPath() %>/style/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/style/js/click.js"></script>
</head>
<body>
	<span class="blog_title" style="padding-left:160px">博客名称:</span>
	<input type="text" class="blog_name" value="${blog_name }">
	<label>验证码</label>
	<span class="verifyCode"><img id="codeImage" onclick="changeImage()" src="${pageContext.request.contextPath }/verifyCode"></span>
</body>
<script type="text/javascript">
var errorMsg = "${errorMsg}";
</script>
</html>