<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib uri="/tags/loushang-web" prefix="l"%> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户修改</title>
<!-- 引入css文件 -->


 <link href="/static/css/bootstrap.css" rel="stylesheet" type="text/css"/>
 <link href="/static/css/font-awesome.css" rel="stylesheet" type="text/css"/>
 <link href="/static/css/ui.css" rel="stylesheet" type="text/css"/>
 <link href="/static/css/form.css" rel="stylesheet" type="text/css"/>
 <link href="/static/css/user.css" rel="stylesheet" type="text/css"/>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="<l:asset path='html5shiv.js'/>"></script>
  <script src="<l:asset path='respond.js'/>"></script>
<![endif]-->

<!-- 引入js文件 -->

<script src="/static/js/jquery.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/form.js"></script>
<script src="/static/js/jquery.form.js"></script>
<script src="/static/js/ui.js"></script>

<script type="text/javascript">
	//项目上下文
	<%-- var context="<%=request.getContextPath()%>";
	var assetPath="<l:assetcontext/>"; --%>
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
	

</script>
</head>
<body>
	<div class="container" id="sandbox-container">
	  <h2 class="text-left htext"><spring:message code="useredit" text="编辑用户"></spring:message></h2>
	  <hr class="fenge"/>
	  <br/>
	  <div class="col-xs-10 col-md-10">	  
		<form class="form-horizontal" id="saveForm" name="saveForm" onsubmit="return false" enctype="multipart/form-data">
			<input type="hidden" value="${user.id}" name="id"/>
			
		<%-- 	<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="useredit.image" text="头像图片"></spring:message><span class="required">*</span></label>
				<div class="col-xs-8 col-md-8">
					<img id="pic">
					<input type="text" class="ue-form" id="filePath" style="display:none" value="" />		
					<span class="Validform_checktip Validform_span"></span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="useredit.userimage" text="用户头像"></spring:message><span class="required"></span></label>
				<div class="col-xs-8 col-md-8">
					<input type="file" class="Validform_input" id="icon"
						name="icon" value="" style="display: none" nullmsg="<spring:message code="useredittips.selectavatar" text="请选择头像"></spring:message>" />
					<button type="button"  id="uploadIcon"
						class="btn ue-btn"><spring:message code="useredit.selectavatar" text="选择头像"></spring:message></button>
					<button type="button" name="downloadIcon"  id="downloadIcon"
						class="btn ue-btn"><spring:message code="useredit.downloadavatar" text="下载头像"></spring:message></button>						
					<span class="Validform_checktip Validform_span"></span>
				</div>
			</div> --%>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="user.id" text="账号"></spring:message><span class="required">*</span></label>
				<div class="col-xs-8 col-md-8">
					<input type="text" class="form-control ue-form Validform_input" id="userId"
						name="user_id" value="${user.user_id}" 
						placeholder="<spring:message code="user.id" text="账号"></spring:message>" datatype="s3-16" errormsg="<spring:message code="useredittips.iderrormsg" text="姓名3~16个字符！"></spring:message>" nullmsg="<spring:message code="useredittips.idnullmsg" text="请设置账号"></spring:message>" />						
					<span class="Validform_checktip Validform_span"></span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="user.name" text="名称"></spring:message><span class="required">*</span></label>
				<div class="col-xs-8 col-md-8">
					<input type="text" class="form-control ue-form Validform_input" id="userName"
						name="user_name" value="${user.user_name}" placeholder="<spring:message code="user.name" text="名称"></spring:message>" datatype="s2-16" errormsg="<spring:message code="useredittips.nameerrormsg" text="姓名2~16个字符！"></spring:message>" nullmsg="<spring:message code="useredittips.namenullmsg" text="请填写名称"></spring:message>"/>						
					<span class="Validform_checktip Validform_span"></span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="user.nickname" text="昵称"></spring:message></label>
				<div class="col-xs-8 col-md-8">
					<input type="text" class="form-control ue-form Validform_input" id="nickname"
						name="nickname" value="${user.nickname}"
						placeholder="<spring:message code="user.nickname" text="昵称"></spring:message>" datatype="s2-16" errormsg="<spring:message code="useredittips.nicknameerrormsg" text="昵称2~16个字符！"></spring:message>" ignore="ignore">
					<div class="Validform_checktip Validform_span"></div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="user.password" text="密码"></spring:message><span class="required">*</span></label>
				<div class="col-xs-8 col-md-8">
					<input type="text" class="form-control ue-form Validform_input" id="password"
						name="password" value="${user.password}" 
						placeholder="<spring:message code="user.password" text="密码"></spring:message>" datatype="s6-16" errormsg="<spring:message code="useredittips.pwderror" text="密码6~16个字符！"></spring:message>" nullmsg="<spring:message code="useredittips.pwdnullmsg" text="请设置密码"></spring:message>" />						
					<span class="Validform_checktip Validform_span"></span>
				</div>
			</div>

			<%-- <div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="user.status" text="账号状态"></spring:message><span class="required">*</span></label>
				<div class="col-xs-8 col-md-8">
					<l:enum name="status" id="status" enumKey="USER.STATUS" currentVal="${user.status}" render="select" classes="form-control input-sm ue-form Validform_input" datatype="s" nullmsg="<spring:message code='useredittips.statusnullmsg' text='请设置账号状态'/>"></l:enum>
				</div>
			</div> --%>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="user.gender" text="性别"></spring:message><span class="required">*</span></label>
				<div class="col-xs-9 col-md-9">
					<div class="radio" id="gender">
						<label>
							<input type="radio" name="archive.gender" id="gender1" value="M" checked>男
						</label>
						<label>
							<input type="radio" name="archive.gender" id="gender2" value="F">女
						</label>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="user.birthday" text="生日"></spring:message></label>
				<div class="col-xs-8 col-md-8">
					<div class="input-group date Validform_input">
						<input type="text" class="form-control ue-form" id="birthday" name="archive.birthday" 
							value="${user.archive.birthday}" placeholder="<spring:message code="user.birthday" text="生日"></spring:message>" datatype="*" ignore="ignore"/><span class="input-group-addon ue-form-btn date-input-btn"><i
							class="fa fa-calendar"></i></span>										   
					</div>
					<span class="Validform_checktip Validform_span" ></span>	
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="user.education" text="学历"></spring:message></label>
				<div class="col-xs-9 col-md-9">
					<div class="radio" id="educations">
						<label>
							<input type="radio" name="archive.education" id="education1" value="0" checked>本科
						</label>
						<label>
							<input type="radio" name="archive.education" id="education2" value="1">硕士
						</label>
						<label>
							<input type="radio" name="archive.education" id="education3" value="2">博士
						</label>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="user.school" text="学校"></spring:message></label>
				<div class="col-xs-8 col-md-8">
					<input type="text" class="form-control ue-form Validform_input" id="school"
						name="archive.school" value="${user.archive.school}"
						placeholder="<spring:message code="user.school" text="学校"></spring:message>" datatype="s" ignore="ignore"/>
					<span class="Validform_checktip Validform_span"></span>					
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-xs-3 col-md-3 control-label"><spring:message code="user.email" text="电子邮件"></spring:message></label>
				<div class="col-xs-8 col-md-8">
					<input type="text" class="form-control ue-form Validform_input" id="email"
						name="archive.email" value="${user.archive.email}"
						placeholder="<spring:message code="useredittips.email" text="邮件地址"></spring:message>" datatype="email" ignore="ignore" errormsg="<spring:message code="useredittips.emailerrormsg" text="请填写正确的邮箱地址"></spring:message>"/>				    
					<span class="Validform_checktip Validform_span" ></span>
				</div>			
			</div>
			
			<div class="form-group" >
			  <label class="col-xs-3 col-md-3 control-label"></label>
			  <div class="col-xs-8 col-md-8">
					<button type="button" class="btn ue-btn-primary" id="saveBtn" >
						<spring:message code="save" text="保存"></spring:message>
					</button>
					<button type="button" class="btn ue-btn" id="returnBtn">
						 <spring:message code="return" text="返回"></spring:message>
					</button>
					<span id="msgdemo"></span>
			</div>
		  </div>
		</form>
		</div>
	</div>
</body>
</html>