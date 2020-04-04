<#import "parts/common.ftl" as c>
<@c.page>
<h1>Phone companies</h1>
<br/><br/>
<div>
  <table border="1">
    <tr>
      <th>Phone Company</th>
      <th>Phone Codes</th>
    </tr>
    <tbody>
    <#list companies as phoneCompany>
    <tr>
      <td>${phoneCompany.companyName}</td>
      <td><#list phoneCompany.phoneCode as phoneCode>${phoneCode}<#sep>, </#list></td>
    </tr>
    </#list>
  </table>
  <a href="/main">Main page</a>
</div>
</@c.page>