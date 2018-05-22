<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!-- basic scripts -->
	<script src="${contextPath}/static/ace/js/jquery-2.0.3.min.js"></script>
	<script src="${contextPath}/static/ace/js/bootstrap.min.js"></script>
	<!-- ace scripts -->
	<script src="${contextPath}/static/ace/js/ace-extra.min.js"></script>
	<script src="${contextPath}/static/ace/js/ace-elements.min.js"></script>
	<script src="${contextPath}/static/ace/js/ace.min.js"></script>
	<script>
		$(function(){
			$(document.body).removeClass("skin-1 skin-2 skin-3").addClass('skin-1');
			//给iframe设置高度$(document).height()-$('#navbar').height()-$('#breadcrumbs').height()
			$('[name=iframe_body]')
				.height($(document).height()-$('#navbar').height()-$('#breadcrumbs').height()-5)
				.css({'border':'0px'});
			//breadcrumbs里面显示的内容居中
			$('#breadcrumbs .breadcrumb').css('marginTop',($('#breadcrumbs').height()-$('#breadcrumbs .breadcrumb').height())/2);
			//去掉iframe边框和设置大小
		}); 
	</script>