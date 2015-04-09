<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/resources/meta/taglib.jsp" %>
<script type="text/javascript">
	$(function() {
	});
	function doSubmit(){
		if(!ZHTAJAX.validateFromCallback($("#formss"),ZHT.ajaxDone)){
			alertMsg.info("请确认校验不通过数据");
		}
	}
	function cancel(){
		editDialog.close(100);
	}
</script>
		<form id="formss" method="post" action="${ctx}/common/generator/genEntityProperty/updatePropertyDetail">
		<input type="hidden" name="id" value="${genEntityProperty.id}"/>
			<fieldset>
				<legend><img src="resources/images/fromedit.png" style="margin-bottom: -3px;"/>
				详细编辑：<font style="color: red"> 注意是针对本实体进行编辑即：many-to-many 中的主控表</font>
				</legend>
				 <table>
					 <tr>
					    <th>是否主控中间表</th>
						<td >
							<select name="isManytoManyMasterControl"class="easyui-combobox" style="width:170px;">
								<option value="true"  <c:if test="${genEntityProperty.isManytoManyMasterControl eq true }">selected</c:if>>是</option>
							</select>
						</td>
						<th>中间表名称</th>
						<td>
						<input class="easyui-textbox" name="manytomanyJoinTable"  value="${genEntityProperty.manytomanyJoinTable}" data-options="required:false">
						</td>
					</tr>
						<tr>
						<th>中间表外键Self</th>
						<td>
							<input class="easyui-textbox" name="manytomanyJoinColumnSelf"  value="${genEntityProperty.manytomanyJoinColumnSelf}" data-options="required:false">
						</td>
						<th>中间表外键Oppsite</th>
						<td>
							<input class="easyui-textbox" name="manytomanyJoinColumnOpposite"  value="${genEntityProperty.manytomanyJoinColumnOpposite}" data-options="required:false">
						</td>
					 </tr>
					  <tr><th colspan="4"><hr></th></tr>
					  
				 </table>
			</fieldset>
			<div style="position: absolute;bottom: 5px;right: 10px;"  >
				<zht:authButton text="保存" onclick="doSubmit();" iconCls="icon-ok" />
				<zht:authButton text="取消" onclick="cancel();" iconCls="icon-cancel" />
			</div>
			
		</form>
