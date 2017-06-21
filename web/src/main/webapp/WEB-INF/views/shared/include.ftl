<#assign ctx = rc.contextPath>
<#assign public = ctx+"/public">
<#assign uri = rc.requestUri>
<#assign viewName = uri?string?replace(ctx,"")>
<#assign fileName = viewName?substring(viewName?last_index_of("/")+1)>
<#-- js部分 -->
<script src= "${public}/easyui/jquery.min.js" type="text/javascript"></script>
<script src= "${public}/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src= "${public}/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<#-- css部分 -->
 <link href="${public}/easyui/themes/bootstrap/easyui.css" rel="stylesheet" type="text/css" />
 <link href="${public}/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
<#-- 定制部分 -->
<script src="${public}/js/common.js" type="text/javascript"></script>
<#if viewName??>
<script src="${public}/js/model${viewName}.js" type="text/javascript"></script>
<link href="${public}/css/model${viewName}.css" rel="stylesheet" type="text/css" />
</#if>