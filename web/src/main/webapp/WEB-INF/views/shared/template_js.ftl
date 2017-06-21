window.onload = function() {
	
};

var url;
function add() {
	$('#dlg').dialog('open').dialog('center').dialog('setTitle', '新增');
	$('#fm').form('clear');
	url = fileName+'/add';
}
function edit() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('center').dialog('setTitle', '编辑');
		$('#fm').form('clear');
		$('#fm').form('load', row);
		url = fileName+'/modify?id=' + row.id;
	}
}
function save() {
	$('#fm').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (!result.success) {
				$.messager.show({
					title : '错误',
					msg : result.errorMsg
				});
			} else {
				$('#dlg').dialog('close');
				$('#dg').datagrid('reload');
			}
		}
	});
}
function destroy() {
	var row = $('#dg').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '是否确认删除所选数据？', function(r) {
			if (r) {
				$.post(fileName+'/destroy', {
					id : row.id
				}, function(result) {
					if (result.success) {
						$('#dg').datagrid('reload'); 
					} else {
						$.messager.show({ 
							title : '错误',
							msg : result.errorMsg
						});
					}
				}, 'json');
			}
		});
	}
}
