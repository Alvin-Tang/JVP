window.onload = function() {

	$('#aa').accordion({
		fit : true,
		fillSpace : true,
		border : false
	});

	$.post('getMenu', function(data) {
		if (data) {
			$.each($.parseJSON(data), function(index, item) {
				var selected = false;
				if (index == 0) {
					selected = true;
				}
				$('#aa').accordion('add', {
					title : item.text,
					content : "<ul id='menu_tree_" + item.id + "'></ul>",
					selected : selected
				});
				$('#menu_tree_' + item.id).tree({
					data : item.children,
					onClick : function(node) {
						if (node.children.length != 0) {
							return;
						}
						addTabs('tabs', node.text, node.url);
					}
				});
			});
		}
	});

	$('#mb').menubutton({
		iconCls : 'icon-man',
		menu : '#mm'
	});

	$("#changePassword").click(changePassword);

	$("#logout").click(logout);

},

addTabs = function(tabsId, title, url) {
	var $tabs = $('#' + tabsId);
	if ($tabs.tabs('exists', title)) {
		$tabs.tabs('close', title);
	}
	$tabs.tabs('add', {
		title : title,
		fit : true,
		content : "<iframe frameborder='false' src=" + url + ">",
		closable : true
	})
},

logout = function() {
	$.messager.confirm('确认', '您确认想要退出登录吗？', function(r) {
		if (r) {
			window.location.href = "logout";
		}
	});
},

changePassword = function() {
	$('#changePasswordWin').dialog({
		title : '修改密码',
		width : 400,
		height : 200,
		closed : false,
		cache : false,
		modal : true,
		buttons : [ {
			text : '提交',
			handler : function() {

			}
		}, {
			text : '关闭',
			handler : function() {
				$('#changePasswordWin').dialog("close");
			}
		} ]
	});
}
