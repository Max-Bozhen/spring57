<#import "parts/common.ftlh" as c>
<@c.page>
<form action="editUsers" method="post">
  <label>User name :
    <input type="text" name="username" value="${user.username}"><br>
  </label>
  <br>
  <label>Phone numbers :
    <#list user.phoneNumber as phone>
    <div>
      <input type="text" name="phoneNumber" value="${phone}" placeholder="Phone number"><br>
    </div>
  </#list>
  </label>
  <br>
<br>
<input type="hidden" value="${user.id}" name="userId">
<button type="submit">Save</button>
</form>
</@c.page>