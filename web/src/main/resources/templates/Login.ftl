<#include "./macros/header.ftl">
<html>
<head>
    <link rel="stylesheet" href="myWeb.css" />
</head>
<body>
    <div id="container">
        <@header />
        <div>
            <div id="login-main-data">
                <form action="/submit" method="post" class="col-small">
                ${error!''}
                <div class="flex-grid">
                    <label id="login-label" class="label">Login</label>
                    <input type="text" id="login" name="login" value=${loginVO.getLogin()!''}>
                </div>
                <div class="flex-grid">
                    <label class="label">Password</label>
                    <input type="password" id="password" name="password">
                </div>
                <input type="submit" name="submit" id="submit">
                </form>
                <a id="register-label" href="/register" name="register">Not Registered ? Sign Up Here</a>
            </div>
        </div>
    </div>
    <script src="http://localhost:9090/main.js"></script>
</body>
</html>