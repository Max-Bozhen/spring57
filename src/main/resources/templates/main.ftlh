<#import "parts/common.ftlh" as c>
<#import "parts/loginTemp.ftlh" as l>
<@c.page>
<font color="red" size="22">
  <b>${error?ifExists}</b>
</font>
<b>${message?ifExists}</b>
<div>
  <@l.logout />
</div>

<a href="/usersList">Get PDF</a>
<br/>
<br/>
<a href="/upload">Upload file</a> <br>
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
  <a href="/editProfile/${user.id}">Show My Profile</a> <br>
  <a href="/changeAcc/${user.id}">Show accs</a>
  <#else> Please log-in
  </#if>
</#list>
</div>
</@c.page>