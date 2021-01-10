<#import "common.ftl" as c>
<#import "uploadFile.ftl" as u>

<#macro twoColumns>
    <@c.common>
        <div class="container mt-4">
            <div class="row">
                <aside class="col-sm-12 col-md-4 col-lg-3">
                    <#include "sideMenu.ftl">
                    <@u.upload/>
                </aside>
                <main class="col-sm-12 col-md-8 col-lg-9">
                    <#nested>
                </main>
            </div>
        </div>
    </@c.common>
</#macro>