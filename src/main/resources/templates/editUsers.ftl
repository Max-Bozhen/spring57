<#import "parts/common.ftl" as c>
<@c.page>
  <form action="editUsers" method="post">
    <label>User name :
      <input type="text" name="username" value="${user.username}"><br>
    </label>
    <br>
    <div>
      Phone numbers :
        <#list user.phoneNumber as phone>
          <div>
            <label><input type="text" name="phoneNumber/${phone?counter}" value="${phone}"></label>
  <!--          <input type="text" name="phoneNumber" value="${phone}" placeholder="Phone number"><br>-->
          </div>
        </#list>

    </div>
    <br>
    <#list roles as role>
      <div>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
      </div>
    </#list>
    <br>
    <input type="hidden" value="${user.id}" name="userId">
    <button type="submit">Save</button>
</form>
</@c.page>