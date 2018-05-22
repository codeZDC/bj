/** 审批界面JS */
var localData ;
$(function() {
	loadTable();
});

function loadTable(pageNum) {
	var filter = {};// 添加各种条件过滤
	$('.filter').each(function() {
		filter[$(this).attr('name')] = this.value;
	});
	filter.pageNum = pageNum;
	$.ajax({
		url : contextPath + 'apply/list',
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
	var title = ['序号','项目名称','申请人','申请部门','联系电话','状态','创建时间','操作'],
		index,projectName,applyPerson,applyDepartment,phone,status,createdTime,
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
	$.each(localData,function(ind){
		index = $('<td>').text(ind + 1);
		projectName = $('<td>').text(this.projectName);
		applyPerson = $('<td>').text(this.applyPerson);
		applyDepartment = $('<td>').text(this.applyDepartment);
		phone = $('<td>').text(this.phone);
		switch(this.status){
		case 0 : 
			status = $('<td>').append('<span class="label label-success arrowed arrowed-right">草 &nbsp;稿</span>');
			break;
		case 1 : 
			status = $('<td>').append('<span class="label label-success arrowed arrowed-right">处理中</span>');
			break;
		case 2 : 
			status = $('<td>').append('<span class="label label-success arrowed arrowed-right">办结中</span>');
			break;
		default : 
			status = $('<td>').append('<span class="label label-success arrowed arrowed-right">已完成</span>');
		}
		createdTime = $('<td>').text(this.createdTime);
		$('<tr>').attr('id',this.id).append(index).append(projectName).append(applyPerson)
		.append(applyDepartment).append(phone).append(status).append(createdTime)
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
	$('#add_form').submit();
}
// 添加提交
function edit_submit() {
	
	$.ajax({
		url : contextPath + 'apply/edit',
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
		url : contextPath + 'apply/del',
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
//筛选按钮
$('.dropdown-menu li').click(function(){
	$('#switch_btn span').text($(this).text());
	var status = $(this).find('a').attr('value');//520表示待处理
	$('.filter[name=status]').val(status);
	loadTable();
});
//datepicker
$('.date-picker').datepicker({autoclose:true});