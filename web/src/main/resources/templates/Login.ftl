<#include "./macros/header.ftl">
<html>
<head>
    <link rel="stylesheet" href="../css/myWeb.css" />
    <link rel="stylesheet" href="../css/menu.css" />
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
                <div class="input-row">
                    <label id="login-label" class="label">Login</label>
                    <input type="text" id="login" name="login" value=${loginVO.getLogin()!''}>
                </div>
                <div class="input-row">
                    <label class="label">Password</label>
                    <input type="password" id="password" name="password">
                </div>
                <div class="submit">
                    <input type="submit" name="submit" id="submit">
                </div>
                </form>
                <a id="register-label" href="/register" name="register">Not Registered ? Sign Up Here</a>
        </div>
        <div id="footer"></div>
    </div>
    <div id="right-container" />
</div>
</body>
</html>


<#--<#include "./macros/header.ftl">-->
<#--<html>-->
<#--<head>-->
<#--    <link rel="stylesheet" href="myWeb.css" />-->
<#--</head>-->
<#--<body>-->
<#--    <div id="container">-->
<#--        <@header />-->
<#--        <div>-->
<#--            <div id="login-main-data">-->
<#--                <form action="/submit" method="post" class="col-small">-->
<#--                ${error!''}-->
<#--                <div class="flex-grid">-->
<#--                    <label id="login-label" class="label">Login</label>-->
<#--                    <input type="text" id="login" name="login" value=${loginVO.getLogin()!''}>-->
<#--                </div>-->
<#--                <div class="flex-grid">-->
<#--                    <label class="label">Password</label>-->
<#--                    <input type="password" id="password" name="password">-->
<#--                </div>-->
<#--                <input type="submit" name="submit" id="submit">-->
<#--                </form>-->
<#--                <a id="register-label" href="/register" name="register">Not Registered ? Sign Up Here</a>-->
<#--            </div>-->
<#--        </div>-->
<#--    </div>-->
<#--    <script src="http://localhost:9090/main.js"></script>-->
<#--</body>-->
<#--</html>-->