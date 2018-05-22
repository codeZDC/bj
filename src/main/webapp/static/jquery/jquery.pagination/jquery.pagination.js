//该版本两边sidePageCount!=0的时候还没有弄,,所以参数不能需要等于0
jQuery.fn.pagination = function(total, params){
	params = jQuery.extend({
		pageSize:10,
		paginationBarCount:10,
		currentPage:1,
		sidePageCount:0,
		link_to:"#",
		prev_text:"Prev",
		next_text:"Next",
		ignore_text:"...",
		alwaysShowPrev:true,
		alwaysShowNext:true,
		callback:function(){return false;}
	},params||{});
	
	return this.each(function() {
		/**
		 * 计算最大分页显示数目
		 */
		function numPages() {
			return Math.ceil(total/params.pageSize);
		}	
		/**
		 * 极端分页的起始和结束点，这取决于currentPage 和 paginationBarCount.
		 * @返回 {数组(Array)}
		 */
		function getInterval()  {
			var ne_half = Math.ceil(params.paginationBarCount/2);
			var np = numPages();
			var upper_limit = np-params.paginationBarCount;
			var start = currentPage>ne_half?Math.min(currentPage-ne_half, upper_limit)+1:1;
			var end = currentPage>ne_half?Math.min(currentPage+ne_half, np):Math.min(params.paginationBarCount, np);
			if(start<1)start=1;
			return [start,end];
		}
		
		/**
		 * 分页链接事件处理函数
		 * @参数 {int} pageNum 为新页码
		 */
		function pageSelected(pageNum, evt){
			currentPage = pageNum;
			drawLinks();
			var continuePropagation = params.callback(pageNum, panel);
			if (!continuePropagation) {
				if (evt.stopPropagation) {
					evt.stopPropagation();
				}
				else {
					evt.cancelBubble = true;
				}
			}
			return continuePropagation;
		}
		
		/**
		 * 此函数将分页链接插入到容器元素中
		 */
		function drawLinks() {
			panel.empty();
			var interval = getInterval();
			var np = numPages();
			// 这个辅助函数返回一个处理函数调用有着正确pageNum的pageSelected。
			var getClickHandler = function(pageNum) {
				return function(evt){ return pageSelected(pageNum,evt); }
			}
			//辅助函数用来产生一个单链接(如果不是当前页则产生span标签)
			var appendItem = function(pageNum, appendparams){
				pageNum = pageNum<1?1:(pageNum<np?pageNum:np); // 规范page id值
				appendparams = jQuery.extend({text:pageNum, classes:""}, appendparams||{});
				if(pageNum == currentPage){
					var link = jQuery("<span class='current'>"+(appendparams.text)+"</span>");
				}else{
					var link = jQuery("<a>"+(appendparams.text)+"</a>")
						.bind("click", getClickHandler(pageNum))
						.attr('href', params.link_to.replace(/__id__/,pageNum));		
				}
				if(appendparams.classes){link.addClass(appendparams.classes);}
				panel.append(link);
			}
			// 产生"Previous"-链接
			if(params.prev_text && (currentPage > 1 || params.alwaysShowPrev)){
				appendItem(currentPage-1,{text:params.prev_text, classes:"prev"});
			}
			// 产生起始点
			if (interval[0] > 0 && params.sidePageCount > 0)
			{
				var end = Math.min(params.sidePageCount, interval[0]);
				for(var i=0; i<end; i++) {
					appendItem(i);
				}
				if(params.sidePageCount < interval[0] && params.ignore_text)
				{
					jQuery("<span>"+params.ignore_text+"</span>").appendTo(panel);
				}
			}
			// 产生内部的些链接
			for(var i=interval[0]; i<=interval[1]; i++) {
				appendItem(i);
			}
			// 产生结束点
			if (interval[1] < np && params.sidePageCount > 0)
			{
				if(np-params.sidePageCount > interval[1]&& params.ignore_text)
				{
					jQuery("<span>"+params.ignore_text+"</span>").appendTo(panel);
				}
				var begin = Math.max(np-params.sidePageCount, interval[1]);
				for(var i=begin; i<np; i++) {
					appendItem(i);
				}
				
			}
			// 产生 "Next"-链接
			if(params.next_text && (currentPage < np || params.alwaysShowNext)){
				appendItem(currentPage+1,{text:params.next_text, classes:"next"});
			}
		}
		
		//从选项中提取currentPage----dadssasa
		var currentPage = params.currentPage;
		//创建一个显示条数和每页显示条数值
		total = (!total || total < 0)?1:total;
		params.pageSize = (!params.pageSize || params.pageSize < 0)?1:params.pageSize;
		//存储DOM元素，以方便从所有的内部结构中获取
		var panel = jQuery(this);
		
		// 获得附加功能的元素,好像是给回调函数使用
		/*this.selectPage = function(pageNum){ pageSelected(pageNum);}
		this.prevPage = function(){
			if (currentPage > 0) {
				pageSelected(currentPage - 1);
				return true;
			}
			else {
				return false;
			}
		}
		this.nextPage = function(){ 
			if(currentPage < numPages()-1) {
				pageSelected(currentPage+1);
				return true;
			}
			else {
				return false;
			}
		}*/
		// 所有初始化完成，绘制链接
		drawLinks();
        // 回调函数
        //params.callback(currentPage + 1, this);
	});
}



