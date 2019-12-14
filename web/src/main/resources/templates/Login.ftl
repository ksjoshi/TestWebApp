<#include "./macros/header.ftl">
<#include "./macros/formInput.ftl">
<html>
<head>
    <link rel="stylesheet" href="../css/myWeb.css"/>
</head>
<body>
<div id="main-container">
    <div id="left-container"></div>
    <div id="middle-container">
        <div id="menu-container">
            <@header />
        </div>
        <div id="form-body" class="login-form">
            <form action="/submit" method="post" class="col-small">
                ${error!''}
                <@input
                name="login"
                type="text"
                value="${loginVO.getLogin()!''}"
                label="Login"
                labelcss="label"
                labelId="login-label">
                </@input>
                <@input
                name="password"
                type="password"
                label="Password"
                labelcss="label">
                </@input>
                <div class="submit">
                    <input type="submit" name="submit" id="submit">
                </div>
            </form>
            <a id="register-label" href="/register" name="register">Not Registered ? Sign Up Here</a>
        </div>
        <div id="footer"></div>
    </div>
    <script src="http://localhost:9090/main.js"></script>
    <div id="right-container"/>
</div>
</body>
</html>
