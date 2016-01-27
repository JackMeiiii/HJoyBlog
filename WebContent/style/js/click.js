$(function(){
	if (errorMsg.length != 0) {
		alert(errorMsg);
	}
	$('.blog_name').change(function(){
		var blog_name=$('.blog_name').val();
		$.post(_path+"/updateBlogName.do",{val:blog_name});
	})
	
})