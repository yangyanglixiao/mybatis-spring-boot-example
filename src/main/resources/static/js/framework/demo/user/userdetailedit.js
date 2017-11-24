//项目上下文
	$(function() {
		$("#uploadIcon").click(function(){
			$("#icon").click();
		});
		//修改是否显示下载按钮
		if("${user.id}"){
			/* $("#icon").hide(); */
			$("#downloadIcon").click(function(){
				window.location.href = "/framework/demo/user/download/"+"${user.id}"; 
			});
		}else{
			$("#downloadIcon").hide();
		}
		
		
		$("#saveForm").uValidform({
			btnSubmit:"#saveBtn",			
			datatype:{//传入自定义datatype类型;
			      "email":email
			},
			callback:function(form){
				$.dialog({
					type: 'confirm',
					content: "您确定要提交表单吗？",
					ok: function(){save();},
					cancel: function(){}
				});
			}
		});
		//日期插件
		$('.input-group.date').datetimepicker({
			language: "zh-CN",
			autoclose: true,
			minView: 2,
			format: "yyyymmdd"
		}).on("changeDate",function(){
			$(this).find("input").blur();
		}); 
		 
		//返回user页面
		$("#returnBtn").click(function() {
			window.location = "/";
		})
		
		
		/* 上传用户头像文件类型校验 */
		$("#icon").change(function(){
			var fileName = $("#icon").val();
			if (fileName != null && fileName != "") {
				if (fileName.lastIndexOf(".") != -1) {
					var fileType = (fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length)).toLowerCase();
					var suppotFile = new Array();
					suppotFile[0] = "jpg";
					/* suppotFile[1] = "png";  */
	
					for (var i = 0; i < suppotFile.length; i++) {
						if (suppotFile[i] == fileType) {
							//处理...
							$("#filePath").removeAttr("style")
										  .val(fileName);
							
						} else {
							alert("文件类型不合法,只能是jpg类型！");
							 var file = $("#icon") 
							    file.after(file.clone().val("")); 
							    file.remove();
							    $("#filePath").val("");
						}
					}
				} else {
					alert("文件类型不合法,只能是jpg类型！");
					var file = $("#icon") 
				    file.after(file.clone().val("")); 
				    file.remove();
				}
			}
		});
		
		if("${user.id}"){
			$("#pic").attr("src","framework/demo/user/showIcon/"+"${user.id}")
		}else{
			$("#pic").attr("src","/static/css/userIcon.jpg")
		}
		
	});
	
	//保存实例
	function save(){
		var url = "/framework/demo/user/save";
		saveForm.action = url;
		saveForm.method = "POST";
		saveForm.submit();
/* 		//表单的异步提交
	    $("#saveForm").ajaxSubmit({
            type: "post",
            url: requestUrl,
            error:function(data){
                alert("error："+data);  
            },
            success:function(data){
        		//跳转到列表展现页面,前导航实现
        		window.location = context + "/jsp/framework/demo/user/user.jsp";
            }  
        });
        return false; //不刷新页面  */
	}
