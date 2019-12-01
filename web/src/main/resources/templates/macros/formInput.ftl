<#macro input name type label value="">
    <div id="${name}-input">
        <label for="${name}">${label}</label>
        <input type="${type}" id="${name}" name="${name}" value="${value}" />
    </div>
</#macro>