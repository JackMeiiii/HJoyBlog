<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${hello}</title>
	<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
	<style type="text/css">
		html,body,*{font-family:"Microsoft YaHei" ! important;}
		.c1{background-color: #1abc9c;color:#FFF;}
		.c2{background-color: #8e44ad;color:#FFF;}
		.ph-500{min-height: 500px;}/*用于占位*/
		.ph-50{min-height: 50px;}/*用于占位*/
		.ph-100{min-height: 100px;}/*用于占位*/
		.ph-150{min-height: 150px;}/*用于占位*/
		.ph-200{min-height: 200px;}/*用于占位*/
		.ph-300{min-height: 300px;}/*用于占位*/
		.mg{margin: 2px;}/*增加边距*/
		.main{max-width: 87%;margin: 0 auto;}/*页面主体*/
	</style>
</head>
<body>
	<div class="main pure-g">
		<jsp:include page="/WEB-INF/jsp/common/top.jsp"></jsp:include>
		<div class="pure-u-3-4">
			<div class="c1 ph-500 mg">
				<!--内容-->
			</div>
		</div>
		<div class="pure-u-1-4">
			<div class="c2 ph-200 mg">
			</div>
			<div class="c2 ph-300 mg">
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		//
	})
</script>
</html>