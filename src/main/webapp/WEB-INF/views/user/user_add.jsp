<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
								<label class="col-sm-3 control-label no-padding-right"> 用户名 </label>
								<div class="col-sm-9">
									<input type="text"  placeholder="请输入用户名 " name="username"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
                       <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 账号 </label>
								<div class="col-sm-9">
									<input type="text"  placeholder="请输入账号 " name="account"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
						 <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 密码 </label>
								<div class="col-sm-9">
									<input type="password"  placeholder="请输入密码 " name="password"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
                       <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 手机号码 </label>
								<div class="col-sm-9">
									<input type="text"  placeholder="请输入手机号码 " name="phone"
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
										<option value="">请选择</option>
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
									<input type="text"  placeholder="请输入排序编号 " name="orderBy"
										class="form-control col-xs-10 col-sm-12">
								</div>
						</div>
                       <div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 备注 </label>
								<div class="col-sm-9">
									<textarea placeholder="请输入备注" name="remarks"
										class="form-control col-xs-10 col-sm-12"></textarea>
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