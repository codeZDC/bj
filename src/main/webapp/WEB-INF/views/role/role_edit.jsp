<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="modal" id="edit_modal" tabindex="-1" role="dialog">
	<div class="modal-dialog w-400" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">编辑角色</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal tasi-form" method="get" id="edit_form">
					   <input type="hidden" name="id">
                       <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 角色名称 </label>
								<div class="col-sm-9">
									<input type="text"  placeholder="请输入角色名称 " name="roleName"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
                        <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 角色标识 </label>
					
								<div class="col-sm-9">
									<input type="text" placeholder="请输入角色标识" name="roleKey"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
                        <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 等级 </label>
					
								<div class="col-sm-9">
									<input type="text" placeholder="请输入等级" name="level"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
                        <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 备注 </label>
					
								<div class="col-sm-9">
									<input type="text" placeholder="请输入备注" name="remarks"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 排序 </label>
					
								<div class="col-sm-9">
									<input type="text" placeholder="请输入排序编号" name="orderBy"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
                        <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 创建时间 </label>
					
								<div class="col-sm-9">
									<input disabled="disabled" type="text" placeholder="请输入创建时间" name="createdTime"
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