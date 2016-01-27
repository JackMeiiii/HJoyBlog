<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${hello}-后台管理</title>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/style/js/jquery-1.11.3.min.js"></script>
</head>
<body>
	博客名称:
	<input type="text" class="blog_name" value="${blog_name }">
</body>
<script type="text/javascript">
$(function(){
	$('.blog_name').change(function(){
		var blog_name=$('.blog_name').val();
		$.post(_path+"/updateBlogName.do",{blog_name:blog_name});
	})
})
</script>
</html>