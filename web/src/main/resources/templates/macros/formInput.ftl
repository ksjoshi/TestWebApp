<#macro input name type label value="" optional=false placeholder="" labelcss="" labelId="">
    <div id="${name}-input" class="input-row">
        <label id="${labelId}" for="${name}" class="${labelcss}">${label}<#if !optional>*</#if></label>
        <input type="${type}" id="${name}" name="${name}" value="${value}" placeholder="${placeholder}" />
    </div>
</#macro>