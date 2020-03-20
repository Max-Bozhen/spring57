<#import "parts/common.ftlh" as c>
<#import "parts/loginTemp.ftlh" as l>
<@c.page>
<b>${message}</b>
<div>
  <@l.logout />
</div>

<a href="/usersList">Get PDF</a>
<br/>
<a href="/upload">Upload file</a>
<#list users as user>
  <#if user??>
    <#list user.roles as role>
      <#if role?contains("ADMIN")>
        <a href="/users">Show all users</a>
      <#else>
      </#if>
    </#list>
  </#if>
</#list>
<br/>
<a href="/companies">Show all companies</a>
<br/>
<div>
  <#list users as user>
  <#if user??>
  <a href="/editProfile/${user.id}">Show My Profile</a>
  <#else> Please log-in
  </#if>
</#list>
</div>
</@c.page>