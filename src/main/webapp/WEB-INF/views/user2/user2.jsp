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
								<input name="name" class="filter" type="text">
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
<!-- 模态窗之编辑实例-->
<div class="modal" id="edit_modal" tabindex="-1" role="dialog">
	<div class="modal-dialog w-400 role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">编辑用户</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal tasi-form" method="get" id="edit_form">
					<input type="hidden" name="id">
                							<div class="form-group">
					  		<label class="col-sm-3 control-label no-padding-right"> 姓名 </label>
							<div class="col-sm-9">
								<input type="text"  placeholder="请输入姓名" name="name"
									class="form-control col-xs-10 col-sm-12">
							</div>
						</div>
						<div class="form-group">
					  		<label class="col-sm-3 control-label no-padding-right"> 年龄 </label>
							<div class="col-sm-9">
								<input type="text"  placeholder="请输入年龄" name="age"
									class="form-control col-xs-10 col-sm-12">
							</div>
						</div>
						<div class="form-group">
					  		<label class="col-sm-3 control-label no-padding-right"> 职位 </label>
							<div class="col-sm-9">
								<input type="text"  placeholder="请输入职位" name="job"
									class="form-control col-xs-10 col-sm-12">
							</div>
						</div>

                </form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-sm btn-default"
					data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-sm btn-primary" onclick="edit_submit();">保存</button>
			</div>
		</div>
	</div>
</div>
<!-- 模态窗之查看实例 -->
<div class="modal" id="view_modal" tabindex="-1" role="dialog">
	<div class="modal-dialog w-400 role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">查看用户</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal tasi-form" method="get" id="view_form">
                							<div class="form-group">
					  		<label class="col-sm-3 control-label no-padding-right"> 姓名 </label>
							<div class="col-sm-9">
								<input type="text"  placeholder="请输入姓名" name="name"
									class="form-control col-xs-10 col-sm-12" disabled="disabled">
							</div>
						</div>
						<div class="form-group">
					  		<label class="col-sm-3 control-label no-padding-right"> 年龄 </label>
							<div class="col-sm-9">
								<input type="text"  placeholder="请输入年龄" name="age"
									class="form-control col-xs-10 col-sm-12" disabled="disabled">
							</div>
						</div>
						<div class="form-group">
					  		<label class="col-sm-3 control-label no-padding-right"> 职位 </label>
							<div class="col-sm-9">
								<input type="text"  placeholder="请输入职位" name="job"
									class="form-control col-xs-10 col-sm-12" disabled="disabled">
							</div>
						</div>

                </form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-sm btn-default"
					data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>
<!-- 模态窗之添加实例 -->
<div class="modal" id="add_modal" tabindex="-1" role="dialog">
	<div class="modal-dialog w-400 role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加用户</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal tasi-form" method="get" id="add_form">
                							<div class="form-group">
					  		<label class="col-sm-3 control-label no-padding-right"> 姓名 </label>
							<div class="col-sm-9">
								<input type="text"  placeholder="请输入姓名" name="name"
									class="form-control col-xs-10 col-sm-12">
							</div>
						</div>
						<div class="form-group">
					  		<label class="col-sm-3 control-label no-padding-right"> 年龄 </label>
							<div class="col-sm-9">
								<input type="text"  placeholder="请输入年龄" name="age"
									class="form-control col-xs-10 col-sm-12">
							</div>
						</div>
						<div class="form-group">
					  		<label class="col-sm-3 control-label no-padding-right"> 职位 </label>
							<div class="col-sm-9">
								<input type="text"  placeholder="请输入职位" name="job"
									class="form-control col-xs-10 col-sm-12">
							</div>
						</div>

                </form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-sm btn-default"
					data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-sm btn-primary" onclick="add_submit();">保存</button>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../../common/js.jsp"></jsp:include>
<script type="text/javascript" src="${contextPath }/static/modules/user2.js"></script>
</body>
</html>
