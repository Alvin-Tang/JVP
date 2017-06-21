<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<#include "shared/include.ftl">
<html>  
<body class="easyui-layout">   
<div data-options="region:'north',split:true" style="height:50px;"></div>
<div data-options="region:'center'" >
<table id="dg" class="easyui-datagrid"  toolbar="#toolbar" url="${fileName}/list"
            toolbar="#toolbar" pagination="true" fit="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="username" >账号</th>
                <th field="password" >密码</th>
                <th field="phone" >电话</th>
                <th field="email" >邮箱</th>
                <th field="address" >地址</th>
            </tr>
        </thead>
    </table>
    </div>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()">修改</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroy()">删除</a>
    </div>
    <div id="dlg" class="easyui-dialog" style="width:600px"  closed="true" buttons="#dlg-buttons" maximizable="true" resizable="true">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <div style="margin-bottom:10px">
                <input name="username" class="easyui-textbox" required="true" label="账号:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="password" class="easyui-textbox" required="true" label="密码:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="phone" class="easyui-textbox" required="true" label="电话:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="email" class="easyui-textbox" required="true" validType="email" label="邮箱:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="address" class="easyui-textbox" required="true" label="地址:" style="width:100%">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="save()" >保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" >取消</a>
    </div>
</body>   
</html>