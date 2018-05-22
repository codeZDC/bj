<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${contextPath }/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" href="${contextPath }/static/ace/css/font-awesome.min.css" />
 <link rel="stylesheet" href="${contextPath }/static/ace/css/ace-fonts.css" />
<link href="${contextPath }/static/ace/css/ace.min.css" rel="stylesheet">
<link href="${contextPath }/static/ace/css/jquery-ui.css" rel="stylesheet">
<link href="${contextPath }/static/jquery/jquery.pagination/pagination.css" rel="stylesheet">
<link href="${contextPath }/static/common/common.css" rel="stylesheet">
</head>
<body>
<!-- 通用提示框 -->
<div class="modal fade" id="success" tabindex="-1" role="dialog">
	<div class="modal-dialog w-250" role="document">
		<div class="modal-content">
			<div class="modal-header" style="padding: 3px;">
				<button type="button" class="close" style="font-size: x-large;" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h6 class="modal-title">温馨提示</h6>
			</div>
			<div class="modal-body">
				<h4>操作成功!</h4>
			</div>
			<div class="modal-footer" style="padding: 5px;">
				<button type="button" class="btn btn-xs btn-primary" data-dismiss="modal">确认</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="confirm" tabindex="-1" role="dialog">
	<div class="modal-dialog w-250" role="document">
		<div class="modal-content">
			<div class="modal-header" style="padding: 3px;">
				<button type="button" class="close" style="font-size: x-large;" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h6 class="modal-title">温馨提示</h6>
			</div>
			<div class="modal-body">
				<h4>你确认删除吗!</h4>
			</div>
			<div class="modal-footer" style="padding: 5px;">
				<button type="button" class="btn btn-xs btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-xs btn-primary"
				 data-dismiss="modal" id="confirm-yes">确认</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>