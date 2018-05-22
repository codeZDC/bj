var localData ,hasRoles = false;
$(function() {
	loadTable();
});

//添加,编辑,查看按钮被点击的时候都需要获取角色信息
$(document).on('click','.view_btn,.edit_btn,#add_btn',function() {
	//当然是第一次点击的时候需要获取,不必重复获取角色信息
	if(!hasRoles){
		$.ajax({
			url : contextPath + 'role/list',//真是业务中需要自己写相关的获取sql,或者使用redis
			dataType : 'json',
			type : 'get',
			async : false,
			success : function(res) {
				$.each(res.data.list,function(){
					//直接创建相关下拉框
					hasRoles = true ;
					$('select[name=roleId]').append('<option value="'+this.id+'">'+this.roleName+'</option>');
				});
			},
			error : function() {
				success('网络错误,请联系管理员!');
			}
		});
		
		
	}
});

function loadTable(pageNum) {
	var filter = {};// 添加各种条件过滤
	$('.filter').each(function() {
		filter[$(this).attr('name')] = this.value;
	});
	filter.pageNum = pageNum;
	$.ajax({
		url : contextPath + 'user/list',
		data : filter,
		dataType : 'json',
		type : 'get',
		success : function(res) {
			localData = res.data.list;
			//创建表格
			buildTable();
			//创建分页条
			initPaginationBar(res.data.total,res.data.pageSize,res.data.pageNum,function(currentPage){loadTable(currentPage);});
		},
		error : function() {
			success('网络错误,请联系管理员!');
		}
	});
}

function buildTable(){
	var title = ['序号','用户名','账号','手机号码','状态','角色名称','备注','排序','创建时间','操作'],
		index,username,account,phone,status,roleName,remarks,orderBy,createdTime,
		handle = $('<td>').append('<div\
				class="visible-md visible-lg hidden-sm hidden-xs action-buttons">\
				<a class="blue view_btn" href="#"> <i\
					class="icon-zoom-in bigger-110"></i>\
				</a> <a class="green edit_btn" href="#"> <i\
					class="icon-pencil bigger-110"></i>\
				</a> <a class="red del_btn" href="#"> <i class="icon-trash bigger-110"></i>\
				</a></div>\
			<div class="visible-xs visible-sm hidden-md hidden-lg">\
				<div class="inline position-relative">\
					<button class="btn btn-minier btn-yellow dropdown-toggle"\
						data-toggle="dropdown">\
						<i class="icon-caret-down icon-only bigger-110"></i>\
					</button>\
					<ul\
						class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right \
						dropdown-caret dropdown-close">\
						<li><a href="#" class="tooltip-info" data-rel="tooltip"\
								title="" data-original-title="View"> <span class="blue view">\
										<i class="icon-zoom-in bigger-110"></i>\
						</span></a></li>\
						<li><a href="#" class="tooltip-success"\
								data-rel="tooltip" title="" data-original-title="Edit">\
									<span class="green edit_btn"> <i\
										class="icon-edit bigger-110"></i>\
						</span> </a> </li>\
						<li><a href="#" class="tooltip-error"\
								data-rel="tooltip" title="" data-original-title="Delete">\
									<span class="red del_btn"> <i class="icon-trash bigger-110"></i>\
						</span> </a> </li>\
					</ul></div></div>'),
	table = $('#data-table').empty(),
	//设置标题
	tr = $('<tr>').appendTo($('<thead>').appendTo(table));
	for ( var i in title) {
		if(title[i]=='序号') tr.append($('<th class="w-50">').text(title[i]));
		else tr.append($('<th>').text(title[i]));
	}
	//设置行内容
	var tbody = $('<tbody>').appendTo(table); 
	//index,username,account,phone,status,roleName,remarks,orderBy,createdTime,
	$.each(localData,function(ind){
		index = $('<td>').text(ind + 1);
		username = $('<td>').text(this.username);
		account = $('<td>').text(this.account);
		phone = $('<td>').text(this.phone);
		status = $('<td>').append(this.status==1
				?'<span class="label label-success arrowed arrowed-right">可用</span>'
				:'<span class="label label-danger arrowed arrowed-right">不可用</span>');
		roleName = $('<td>').text(this.roleName);
		remarks = $('<td>').text(this.remarks);
		orderBy = $('<td>').text(this.orderBy);
		createdTime = $('<td>').text(this.createdTime);
		$('<tr>').attr('id',this.id).append(index).append(username).append(account)
		.append(phone).append(status).append(roleName)
		.append(remarks).append(orderBy).append(createdTime)
		.append(handle.clone()).appendTo(tbody);
	});
}

/** 角色管理页面 */
// 添加按钮
$('#add_btn').click(function() {
	$('#add_form')[0].reset();
	$('#add_modal').modal({
		keyboard : false
	})
});
$(document).on('click','.edit_btn',function() {
	//本地数据回显,,原本想使用[]赋值,,但是没必要,有单选框的时候在单独赋值
	var id = $(this).parents('tr').attr('id');
	$('#edit_form')[0].reset();
	$.each(localData,function(){
		if(this.id == id){
			for ( var key in this) {
				$('#edit_modal :input[name='+key+']').val(this[key]);
			}
		}
	});
	$('#edit_modal').modal({
		keyboard : false
	})
});
$(document).on('click','.view_btn',function() {
	//本地数据回显,,原本想使用[]赋值,,但是没必要,有单选框的时候在单独赋值
	var id = $(this).parents('tr').attr('id');
	$('#view_form')[0].reset();
	$('#view_form').find(':input').attr('disabled',true);
	$.each(localData,function(){
		if(this.id == id){
			for ( var key in this) {
				$('#view_modal :input[name='+key+']').val(this[key]);
			}
		}
	});
	$('#view_modal').modal({
		keyboard : false
	})
});
$(document).on('click','.del_btn',function() {
	var id = $(this).parents('tr').attr('id');
	confirm(del,'确认删除该条数据吗?',id);
});

// 添加提交
function add_submit() {
	$.ajax({
		url : contextPath + 'user/save',
		data : $('#add_form').serialize(),
		dataType : 'json',
		type : 'post',
		success : function() {
			success('添加成功!');
			loadTable(9999);
		},
		error : function() {
			success('网络错误,请联系管理员!');
		}
	});
	$('#add_modal').modal('hide');
}
// 添加提交
function edit_submit() {
	
	$.ajax({
		url : contextPath + 'user/edit',
		data : $('#edit_form').serialize(),
		dataType : 'json',
		type : 'post',
		success : function() {
			success('编辑成功!');
			loadTable($('#paginationBar span.current').text());
		},
		error : function() {
			success('网络错误,请联系管理员!');
		}
	});
	$('#edit_modal').modal('hide');
}
function del(id){
	$.ajax({
		url : contextPath + 'user/del',
		data : {ids:[id]},
		dataType : 'json',
		type : 'post',
		success : function() {
			success('删除成功!');
			loadTable($('#paginationBar span.current').text());
		},
		error : function() {
			success('网络错误,请联系管理员!');
		}
	});
}
//过滤加载数据
$('.filter').change(function(){loadTable();});
