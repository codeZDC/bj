<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<a class="menu-toggler" id="menu-toggler" href="#"> <span
	class="menu-text"></span>
</a>

<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="icon-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="icon-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="icon-group"></i>
			</button>

			<button class="btn btn-danger">
				<i class="icon-cogs"></i>
			</button>
		</div>

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
	<!-- #sidebar-shortcuts -->

	<ul class="nav nav-list">
		<li class="active"><a href="index.html"> <i
				class="icon-dashboard"></i> <span class="menu-text"> 控制台 </span>
		</a></li>

		<li>
			<a href="#" class="dropdown-toggle"> <i
				class="icon-text-width"></i> <span class="menu-text"> 运维管理
				</span> <b class="arrow icon-angle-down"></b>
			</a>
			<ul class="submenu">
				<li>
					<a href="page/user"> <i
						class="icon-double-angle-right"></i> 用户管理
					</a>
				</li>
				<li>
					<a href="page/role"> <i
						class="icon-double-angle-right"></i> 角色管理
					</a>
				</li>
			</ul></li>
		<li>
			<a href="#" class="dropdown-toggle"> <i
					class="icon-file-alt"></i> <span class="menu-text"> 审批管理 
				</span> <b class="arrow icon-angle-down"></b>
			</a>

			<ul class="submenu">
				<li>
					<a href="page/meeting"> <i
						class="icon-double-angle-right"></i> 会议管理
					</a>
				</li>
				<li>
					<a href="flow/myApply"> <i
						class="icon-double-angle-right"></i> 我的申请
					</a>
				</li>
				<li>
					<a href="flow/myDeal"> <i
						class="icon-double-angle-right"></i> 我的审批
					</a>
				</li>
				<li>
					<a href="flow/myMeeting"> <i
						class="icon-double-angle-right"></i> 我的会议
					</a>
				</li>
				<li>
					<a href="flow/myTask"> <i
						class="icon-double-angle-right"></i> 待处理文件
					</a>
				</li>
			</ul>
		</li>
		<li>
			<a href="#" class="dropdown-toggle"> <i
					class="icon-file-alt"></i> <span class="menu-text"> 其他页面 <span
						class="badge badge-primary ">5</span>
				</span> <b class="arrow icon-angle-down"></b>
			</a>

			<ul class="submenu">
				<li><a href="faq.html"> <i class="icon-double-angle-right"></i>
						帮助
				</a></li>

				<li><a href="error-404.html"> <i
						class="icon-double-angle-right"></i> 404错误页面
				</a></li>

				<li><a href="error-500.html"> <i
						class="icon-double-angle-right"></i> 500错误页面
				</a></li>

				<li><a href="grid.html"> <i class="icon-double-angle-right"></i>
						网格
				</a></li>

				<li><a href="blank.html"> <i
						class="icon-double-angle-right"></i> 空白页面
				</a></li>
				<li><a href="page/user2"> <i
						class="icon-double-angle-right"></i> 用户2
				</a></li>
				<li><a href="page/dept"> <i
						class="icon-double-angle-right"></i> 部门管理
				</a></li>
			</ul></li>
	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
			data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>