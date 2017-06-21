<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<#include "shared/include.ftl">
<html>  
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:70px;">
    <spen class="head-left"><h1>开发平台</h1></spen>
    <spen class="head-right"><a href="javascript:void(0)" id="mb">当前用户：${username}</a>
	<div id="mm" style="width:150px">
	<div  id="changePassword">修改密码</div>
	<div  id="logout">安全退出</div>
	</div></spen>
    </div>
    <div data-options="region:'south',split:true" style="height:30px;"></div>   
    <div data-options="region:'west',split:true" style="width:200px;">
    <div id="aa" class="easyui-accordion" ></div>  
    </div>   
    <div data-options="region:'center'" >
    <div id="tabs" class="easyui-tabs" style="height:100%;">   
</div>
</div>   
<div id="changePasswordWin">
</div> 
</body>   
</html>