<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE jsp:include PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="../../common/css.jsp"></jsp:include>
<body>
	<div class="main-container">
	<div class="row">
		<div class="col-xs-12">
			<h3 class="header smaller lighter blue">用户列表</h3>
			<div class="table-header">注意: 谨慎下面的操作</div>

			<div class="table-responsive">
				<div id="sample-table-2_wrapper" class="dataTables_wrapper"
					role="grid">
					<div class="row">
						<div class="col-sm-6">
							<div>
								<button type="button" class="btn btn-info btn-sm" id="add_btn">添加用户</button>
							</div>
						</div>
						<div class="col-sm-4  no-padding-right">
							<div class="dataTables_filter"> 
								<input name="username" class="filter" type="text">
							</div>
						</div>
						<div class="col-sm-2  no-padding-left" style="padding-top: 1px;">
							<button type="button" class="btn btn-xs btn-default">搜索</button>
						</div>
					</div>
					<table id = "data-table" class="table table-striped table-bordered table-hover dataTable">
					</table>
					<div class="row">
						<div class="col-sm-3">
							<div id="sample-table-2_length" class="dataTables_length">
								<label>显示 <select size="1" class="filter"
									name="pageSize" aria-controls="sample-table-2">
										<option value="3" selected="selected">3</option>
										<option value="10">10</option>
										<option value="25">25</option>
										<option value="50">50</option>
										<option value="100">100</option></select> 条记录
								</label>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="dataTables_info" id="paginationMsg"></div>
						</div>
						<div class="col-sm-6">
							<div id="paginationBar"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="user_add.jsp"></jsp:include>
<jsp:include page="user_edit.jsp"></jsp:include>
<jsp:include page="user_view.jsp"></jsp:include>
<jsp:include page="../../common/js.jsp"></jsp:include>
<script type="text/javascript" src="${contextPath }/static/modules/user.js"></script>
</body>
</html>