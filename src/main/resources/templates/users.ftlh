<#import "parts/common.ftl" as c>
<#import "parts/loginTemp.ftl" as l>
<@c.page>
<h1>Full list of users</h1>
<br/><br/>
<div>
  <table border="1">
    <tr>
      <th>User ID</th>
      <th>User name</th>
      <th>phoneNumbers</th>
      <th>Roles</th>
    </tr>
    <#list users as user>
    <tr>
    <td>${user.id}</td>
    <td>${user.username}</td>
    <td><#list user.phoneNumber as phoneNumber>${phoneNumber}<#sep>, </#list></td>
    <td><#list user.roles as roles>${roles}<#sep>, </#list></td>
     <td><a href="/editUsers/${user.id}">edit</a></td>
    </tr>
    </#list>
  </table>
</div>
<script !src="">
  function postUser
</script>
<@l.logout/>
</@c.page>