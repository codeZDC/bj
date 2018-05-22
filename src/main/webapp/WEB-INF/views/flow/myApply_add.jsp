<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal" id="add_modal" tabindex="-1" role="dialog">
	<div class="modal-dialog w-400" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加项目</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal tasi-form" id="add_form">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right">
							项目名称 </label>
						<div class="col-sm-9">
							<input type="text" placeholder="请输入... " name="projectName"
								class="form-control col-xs-10 col-sm-12">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"> 申请人 </label>
						<div class="col-sm-9">
							<input type="text" placeholder="请输入... " name="applyPerson"
								class="form-control col-xs-10 col-sm-12">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"> 申请部门 </label>
						<div class="col-sm-9">
							<input type="text" placeholder="请输入... " name="applDepartment"
								class="form-control col-xs-10 col-sm-12">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"> 项目信息 </label>
						<div class="col-sm-9">
							<input type="text" placeholder="请输入... " name="applyMsg"
								class="form-control col-xs-10 col-sm-12">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"> 联系电话 </label>
						<div class="col-sm-9">
							<input type="text" placeholder="请输入..." name="phone"
								class="form-control col-xs-10 col-sm-12">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"> 申请时间 </label>
						<div class="col-sm-9">
							<input class="form-control date-picker col-sm-12"
								placeholder="点击设置时间"
							 type="text" data-date-format="yyyy-mm-dd" name="applyTime">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"> 材料文件 </label>
						<div class="col-sm-9">
							<input type="file" multiple="multiple" placeholder="请输入..." name="image">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-sm btn-default"
					data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-sm btn-primary"
					onclick="add_submit();">保存</button>
			</div>
		</div>
	</div>
</div>