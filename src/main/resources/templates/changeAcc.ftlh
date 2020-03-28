<#import "parts/common.ftlh" as c>

<@c.page>

<div>
  <label>${username}</label>

  <table border="1">
    <tr>
      <th>Account ID</th>
      <th>User name</th>
      <th>Phone Company</th>
      <th>Number</th>
      <th>Amount</th>
      <th></th>
    </tr>
    <#list accounts as account>
    <tr>
      <td>${account.id}</td>
      <td>${account.user.username}</td>
      <td>${account.phoneCompany.companyName}</td>
      <td>${account.phoneNumber}</td>
      <td typeof="number">${account.amount}</td>
      <td> <a  href="/changeCompany/${account.id}" title="This operation isn't free!">Change company</a></td>
    </tr>
  </#list>
  </table>
</div>
</@c.page>