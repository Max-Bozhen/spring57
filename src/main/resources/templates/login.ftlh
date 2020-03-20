<#import "parts/common.ftlh" as c>
<#import "parts/loginTemp.ftlh" as l>

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