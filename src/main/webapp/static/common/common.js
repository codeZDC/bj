/**
 * 项目公共使用的js
 */
//获取项目路径
var contextPath = parent.$('#contextPath').val();

//分页条
function initPaginationBar(total,pageSize,currentPage,callback){
	//currentPage = currentPage>(total/pageSize)?Math.ceil(total/pageSize):currentPage;
	//更新下分页信息
	$('#paginationMsg').text('显示 '+ (total == 0 ? 0:((currentPage-1)*pageSize+1))
								  +' 至 '+(currentPage*pageSize>total?total:currentPage*pageSize) 
								  +' 条记录,总共 '+total+' 条');
	if(total/pageSize<=1){
		$("#paginationBar *").remove();
		return;
	}
	$("#paginationBar").pagination(total, {
		paginationBarCount: 10, //主体页数
		callback: callback,
		currentPage :currentPage,
		pageSize: pageSize, //每页显示1项
		prev_text: "上一页",
		next_text: "下一页"
	});
}
//通过提示框,,提示框html样式在css.jsp中定义
function success(msg){
	if(msg)$('#success .modal-body *').text(msg);
	$('#success').modal();
}
//通过提示框,,提示框html样式在css.jsp中定义
function confirm(fn,msg,id){
	if(msg)$('#confirm .modal-body *').text(msg);
	$('#confirm').modal();
	$('#confirm-yes').off('click').on('click',function(){fn(id);});
}
//ajax异步请求error信息
var error ='网络错误,请联系管理员';