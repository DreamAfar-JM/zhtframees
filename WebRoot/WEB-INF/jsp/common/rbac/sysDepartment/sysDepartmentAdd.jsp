<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/resources/meta/taglib.jsp" %>
<script type="text/javascript">
	$(function() {
	});
	
	function doSubmit(){
		if(!validateFromCallback($("#formss"),ZHT.ajaxDoneAndCloseDialog)){
			alertMsg.info("请确认校验不通过数据");
		}
	}
	function cancel(){
		editDialog.close(100);
	}
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false ," title="" style="overflow: hidden;padding: 10px;">
		<form id="formss" method="post" action="${pageContext.request.contextPath}/common/rbac/sysDepartment/updateSysDepartment">
			<input type="hidden" name="sysDepartment.id" value="${sysDepartment.id}" />
			<fieldset>
				<legend><img src="resources/images/fromedit.png" style="margin-bottom: -3px;"/>部门添加</legend>
				 <table>
					<tr>
						<th>创建时间:</th>
						<td><input type="text" name="createTime" value="${createTime}"  class="easyui-datebox"  data-options=" required:true"/></td>
						<th>创建者:</th>
						<td><input type="text" name="creater" value="${creater}"  class="easyui-validatebox textbox"  data-options=" required:true, validType:'length[0,30]'"/></td>
						<th>描述:</th>
						<td><textarea name="description" value="${description}"  rows="3" cols="20"  class="easyui-validatebox textbox"  data-options=" required:true, validType:'length[0,60]'"></textarea></td>
					</tr>
					<tr>
						<th>是否启用:</th>
						<td><select  name="enabled" class="easyui-combobox"   data-options=" required:true"><option value="true" <c:if test="${enabled eq true }">selected='selected' </c:if> >是</option><option value="false" <c:if test="${enabled eq false }">selected='selected' </c:if> >否</option></select></td>
						<th>部门名称:</th>
						<td><input type="text" name="name" value="${name}"  class="easyui-validatebox textbox"  data-options=" required:true, validType:'length[0,30]'"/></td>
						<th>父级部门:</th>
						<td><input type="text" name="parentSysDepartment.id" value="${parentSysDepartment.id}"  class="easyui-combotree"  data-options=" url:'${pageContext.request.contextPath}/http;//www.baidu.com',method:'post',required:true,valueField:'id',textField:'name'"/></td>
					</tr>
					<tr>
				 	</tr>
				 </table>
			</fieldset>
			<div style="position: absolute;bottom: 5px;right: 10px;"  >
				<zht:authButton text="保存" onclick="doSubmit();" iconCls="icon-ok" />
				<zht:authButton text="取消" onclick="cancel();" iconCls="icon-cancel" />
			</div>
			
		</form>
	</div>
</div>