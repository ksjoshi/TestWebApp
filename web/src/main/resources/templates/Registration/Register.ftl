<#include "../macros/header.ftl">
<#include "../macros/formInput.ftl">
<html>
<head>
    <link rel="stylesheet" href="../css/myWeb.css" />
    <title>Register</title>
</head>
<body>
<div id="main-container">
    <div id="left-container"></div>
    <div id="middle-container">
        <div id="menu-container">
            <@header />
        </div>
        <div id="form-body" class="login-form">
            <div id="error-container" style="display: none">
                Please fill-out all the required information
            </div>
            <form action="/register" method="post">
                <@input name="userName" type="text" label="User Name"/>
                <@input name="firstName" type="text" label="First Name"/>
                <@input name="lastName" type="text" label="Last Name"/>
                <@input name="pwd" type="password" label="Password"/>
                <@input name="hint"
                type="text"
                label="Hint"
                optional=true
                placeholder="Optional"
                />
                <div class="submit">
                    <input type="submit" id="submit" name="submit" value="Submit" />
                </div>
            </form>
        </div>
        <div id="footer"></div>
    </div>
    <script src="http://localhost:9090/registration.js"></script>
    <div id="right-container" />
</div>
</body>
</html>