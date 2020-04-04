<#import "parts/common.ftl" as c>
<#import "parts/loginTemp.ftl" as l>

<@c.page>
Login page

<tr>
  <@l.login "/login" />
  <td>Remember Me:</td>
  <td><input type="checkbox" name="remember-me" /></td>
</tr>
<br>
<a href="/registration">Register new user</a>
</@c.page>