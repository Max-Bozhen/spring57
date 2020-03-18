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
<a href="/users">Show all users</a>
<br/>
<a href="/companies">Show all companies</a>
<br/>
<div>
  <#list users as user>
  <a href="/editProfile/${user.id}">Show My Profile</a>
</#list>
</div>
</@c.page>