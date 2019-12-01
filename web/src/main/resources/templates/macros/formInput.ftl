<#macro input name type label value="" optional=false placeholder="">
    <div id="${name}-input">
        <label for="${name}">${label}</label>
        <input type="${type}" id="${name}" name="${name}" value="${value}" placeholder="${placeholder}" />
    </div>
</#macro>