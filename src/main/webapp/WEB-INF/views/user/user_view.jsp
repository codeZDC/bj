<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="modal" id="view_modal" tabindex="-1" role="dialog">
	<div class="modal-dialog w-400" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">查看角色</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal tasi-form" method="get" id="view_form">
                        <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 用户名 </label>
								<div class="col-sm-9">
									<input type="text" name="username"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
                       <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 账号 </label>
								<div class="col-sm-9">
									<input type="text" name="account"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
						 <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 密码 </label>
								<div class="col-sm-9">
									<input type="password" name="password"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
                       <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 手机号码 </label>
								<div class="col-sm-9">
									<input type="text"  name="phone"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
                       <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 状态 </label>
								<div class="col-sm-9">
									<select class="form-control" name="status">
										<option value="1">可用</option>
										<option value="0">不可用</option>
									</select>
								</div>
						</div>
						 <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 职位描述 </label>
								<div class="col-sm-9">
									<select class="form-control" name="level">
										<option value="0">领导</option>
										<option value="1">申请</option>
										<option value="2">专家</option>
										<option value="3">办结</option>
										<option value="4">开会</option>
									</select>
								</div>
						</div>
                       <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 角色名称 </label>
								<div class="col-sm-9">
									<select class="form-control" name="roleId">
										<option value="">请选择</option>
									</select>
								</div>
					   </div>
                       <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 排序 </label>
								<div class="col-sm-9">
									<input type="text" name="orderBy"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
                       <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 备注 </label>
								<div class="col-sm-9">
									<textarea name="remarks"
										class="form-control col-xs-10 col-sm-12"></textarea>
								</div>
						</div>
                       <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 创建时间 </label>
								<div class="col-sm-9">
									<input type="text" name="createdTime"
										class="form-control col-xs-10 col-sm-12">
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