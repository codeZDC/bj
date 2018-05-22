<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@include file="./WEB-INF/common/header.jsp"%>
<%@include file="./WEB-INF/common/footer.jsp"%>
<%@include file="./WEB-INF/common/navbar.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<body>
	<input type="hidden" id="contextPath" value="${contextPath }/">
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="main-container-inner">
			<%@include file="./WEB-INF/common/sidebar.jsp"%>
			<div class="main-content">
				<%@include file="./WEB-INF/common/guider.jsp"%>
				<%@include file="./WEB-INF/common/main.jsp"%>
			</div>
			<!-- /.main-content -->
			<%@include file="./WEB-INF/common/settings.jsp"%>
		</div>
		<!-- /.main-container-inner -->
		<!-- 
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a> -->
	</div>
	<!-- /.main-container -->
</body>
</html>

