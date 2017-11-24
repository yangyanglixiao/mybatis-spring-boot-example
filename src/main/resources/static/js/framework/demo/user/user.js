//项目上下文
	$(document).ready(function() {
	   var options = {
			    /*  paging:false, */
			/*     info:false   */
	   };	   
		var url = "/framework/demo/user/query";
		grid = new L.FlexGrid("userList",url); 
		grid.init(options); //初始化datatable
		
		//增加
		$("#add").on("click",modify);
		// 删除
		$(document).on("click",".del",function() {
			var recordIds = grid.oTable.row($(this).parents("tr")).data().id;
			$.dialog({
				type: 'confirm',
				content: "确认删除该记录?",
			    autofocus: true,
				ok: function(){window.location.href="/framework/demo/user/delete/"+recordIds;},
				cancel: function(){}
			});
		});
		//批量删除
		$("#batchDel").on("click",Batchdelete);
 		// 编辑
		 $(document).on("click",".modify",function() {
				var data = grid.oTable.row($(this).parents("tr")).data();
				modify(data);
		});
	  });
	
	function modify(data){
		var url = "/framework/demo/user/edit";
		if(data.id){
			url += "?id=" + data.id;
		}
		window.location.href = url;
	}
	
	function Batchdelete(){
		var recordTmp= [];
		var userIds = $(":checkbox[name=checkboxlist]:checked");
		if(userIds!=null&&userIds.length<1){
			$.dialog({
				type:'confirm',
				content: "请选择要删除的记录！",
				autofocus: true,
				ok: function(){}
			});
		}else{
			userIds.each(function(i, checkbox){
				recordTmp.push($(checkbox).val());
			});
			recordIds = recordTmp.join();
			$.dialog({
				type: 'confirm',
				content: "确认删除该记录?",
			    autofocus: true,
				ok: function(){window.location.href="/framework/demo/user/delete/"+recordIds;},
				cancel: function(){}
			});
		}
	}
	
	function rendercheckbox(data, type, full) {
        return '<input type="checkbox" value="' + data + '" title="' + data + '" id="checkbox" name="checkboxlist"/>';
    };
    
    function renderoptions(data, type, full) {
    	var delBtn = "<a class=\"del\" >删除</a>";
 		var editBtn = "<a class=\"modify\">编辑</a>";
 		
 		return delBtn + "&nbsp;&nbsp;&nbsp;" + editBtn;
    }
    function renderstatus(data,type,full){
    	
    	switch (data)
    	{
    	case "N":
   		  data = "启用";
    	  break;
    	case "X":
    	  data = "停用";
    	  break;
    	}
    	
		return data;
    }


$(function(){
	//更多搜索
	$("body").on("click","#search",function(){
		query();		
	});
	$("#moresearch").popover({
	    title: "",
	    content: $("#searchpanel").html(),
	    placement: "bottom",
	    html: true,
	    trigger: "click"
	});
	$("#testBtn").bind("click",function(){
		alert("ceshi");
		//$("#test1").html("测试");
	});
	//条件查询
    $("#query").bind("click", query);
    
	$("#userName").bind('keypress',function(event){
	    if(event.keyCode == "13")    
	    {
	    	query();
	    }
	});
});
function query() {
	var userId = $("#userId").val();
	var userName = $("#userName").val();
	if(userId == undefined){
		userId = "";
	}
	 if((/^\d*$/).test(userId)|| userId == ""){
		 var url = "/framework/demo/user/query";
		 var param={"userId":userId,"userName":userName};
		 url=encodeURI(url,"utf-8"); 
/*		 oTable.ajax.url(url).load();
*/	     grid.reload(url,param);
		 }else{
		 $.dialog({
			 type:"alert",
			 content:"用户ID应为数值型!",
			 autofocus: true,
		 });
	 }
}
//checkbox全选 
function selectAll(obj,iteName){
	  if (obj.checked) {
    	$("input[name='checkList']").each(function(){this.checked=true;}); 
    } else {
    	$("input[name='checkList']").each(function(){this.checked=false;}); 
    }
}


//获取选中的复选框的记录
function getCheckBoxValue(attrKey){	 
		var confCheckBox = $("input:checkbox[name="+attrKey+"]");
		var selectedValue = "";
		for (var i = 0; i < confCheckBox.length; i++) {
			if (confCheckBox[i].checked) {
				if ("" == selectedValue) {
					selectedValue = confCheckBox[i].value;
				} else {
					
					selectedValue = selectedValue + "," + confCheckBox[i].value;
				}
			}
		}
		return selectedValue;
	}