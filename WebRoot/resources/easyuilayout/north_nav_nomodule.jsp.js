var ajaMenuUrl="rbac/menu/loadMenus";
$(function(){
	loadAllMenus(ajaMenuUrl);
	
});

function loadAllMenus(ajaxMenuUrl){
	ZHTAJAX.ajaxTodo(ajaxMenuUrl,{"moduleId":null,useModule:false},function(data){
		 var $ma=$("#menuAccordion");
		 $ma.find(">div").each(function(){
			 this.remove();
		 });
		 $ma.accordion({animate:true,fit:true,border:false,collapsible: true,});
			 $.each(data,function(i, item){
				 var menulist ="<div style=\"padding:2px 2px;\" >";
				 if(item.linkbuttonViewList &&item.linkbuttonViewList.length>0){
					 $.each(item.linkbuttonViewList,function(ci,citem){
						 var menuTitle=citem.display;
							var effort=citem.display+"||"+citem.iconCls+"||"+citem.url;
							menulist+=""+ 
							"<a href=\"javascript:void(0);\" "+
							"style=\"width:100%; \" "+
							"class=\"easyui-linkbutton\" "+
							"data-options=\"plain:false,iconCls:'"+'icon-color'+"' \" "+
							"onclick=\"addTab('"+effort+"');\">"+menuTitle+
							"</a><br/>";
						});
				 }
				 menulist+="</div>";
				$ma.accordion("add", {
			           title: item.title,
			           content: menulist,
					   border:false,
			           iconCls: item.iconCls,
			           selected: false
			    });
			 });
			 $ma.accordion("select",0);
	 }); 
	
}

function logout(b) {
	$.messager.confirm("提示", "确认退出吗?",function(r){
		if(r){
			$.ajax({
				async : false,
				cache : false,
				type : "POST",
				url : "systemAction!logout.action",
				error : function() {
				},
				success : function(json) {
					location.replace("login.jsp");
				}
			});
		}
	});
	
}

