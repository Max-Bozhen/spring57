<#import "parts/common.ftlh" as c>

<@c.page>
<form action="changeCompany" method="post">
  <label>Account info</label>

<div>
  <input name="phoneNumber" value="${company.phoneNumber}"> <br>
  <input name="userName" value="${company.user.username}"><br>
  <#list companyNames as name>
  <div>
    <label><input type="radio" value="${name}" name="company" ${company.phoneCompany.companyName?matches(name)?string("checked", "")}>${name}</label>
  </div>
</#list>
</div>

  <input type="hidden" value="${company.id}" name="accountId">
  <input type="submit">
</form>

</@c.page>