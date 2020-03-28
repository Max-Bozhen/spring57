<#import "parts/common.ftlh" as c>
<@c.page>
<form action="editProfile" method="post">
  <label>User name :
    <input type="text" name="username" value="${user.username}"><br>
  </label>
  <label>User full Name :
    <input type="text" name="fullName" value="${user.fullName}"><br>
  </label>
  <br>
  <label>Phone numbers :
    <#list user.phoneNumber as phone>
    <div>
      <input type="text" name="phoneNumber${phone?counter}" value="${phone}" placeholder="Phone number"><br>
    </div>
      </#list>
  </label>
  <br>
<br>
<input type="hidden" value="${user.id}" name="userId">
  <a href="/changeAcc/${user.id}">Show accounts</a>
<button type="submit">Save</button>
</form>
</@c.page>