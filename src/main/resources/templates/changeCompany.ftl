<#import "parts/common.ftl" as c>

<@c.page>
<form action="changeCompany" method="post">
  <font size="6">
    <b>
  <label>Account info</label>
    </b>
  </font>
<div>
  <input readonly name="phoneNumber" value="${company.phoneNumber}"> <br>
  <input readonly name="userName" value="${company.user.username}"><br>
  <#list companyNames as name>
  <div>
    <label><input type="radio" value="${name}" name="company" ${company.phoneCompany.companyName?matches(name)?string("checked", "")}>${name}</label>
  </div>
</#list>
  <br>
</b>
</div>

  <input type="hidden" value="${company.id}" name="accountId">
    <input type="submit" name="Save">
</form>
<div>
<a href="/changeAcc/${company.user.id}"> Back </a>
</div>
<a href="/main">Main page</a>
</@c.page>