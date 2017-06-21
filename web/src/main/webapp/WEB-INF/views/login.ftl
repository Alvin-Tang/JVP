<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<#include "shared/include.ftl">
<html>  
<body>  
    <div id="login" class="login">
    <p>平台登录</p>
    <form id="login_form" method="post" action="doLogin">   
    <input name="username" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'请输入用户名'" ><br/><br/>
    <input name="password" class="easyui-passwordbox" data-options="iconCls:'icon-lock',prompt:'请输入密码'" ><br/><br/>
    <span class="rememberMe">保持登录状态</span> <input name="rememberMe" class="easyui-switchbutton" data-options="onText:'是',offText:'否'"> <br/><br/>
    <a id="login_btn"  class="easyui-linkbutton login_btn" > 登 录 </a>
    </form>
    <div class="msgTips">${RequestParameters["msg"]}</div>
	</div>
	<div id="footer" class="footer">
	<p>系统时间：<span id="dt"></span></p>
	</div>
</body>  
</html>