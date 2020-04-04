<#import "parts/common.ftl" as c>
<@c.page>

<div>
  <label>Branch: ${fromUrl.branch}</label><br>
  <label>Build date : ${fromUrl.buildDateAndTime?ifExists}</label><br>
  <label>Commit message : ${fromUrl.gitCommit?ifExists}</label><br>
</div>

</@c.page>
