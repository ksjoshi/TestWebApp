<#include "./macros/header.ftl">
<#include "./macros/formInput.ftl">
<html>
<head>
    <link rel="stylesheet" href="myWeb.css" />
    <title>Register</title>
</head>
<body>
    <div id="container">
        <@header />
        <div id="registration-container">
            <div id="registration-form-title">
                Registration Form
            </div>
            <br />
            <form action="/register" method="post">
                <div id="form-content">
                    <@input name="userName" type="text" label="User Name"/>
                    <@input name="firstName" type="text" label="First Name"/>
                    <@input name="lastName" type="text" label="Last Name"/>
                    <@input name="password" type="password" label="Password"/>
                    <@input name="hint" type="text" label="Hint"/>

                    <input type="button" name="submit" value="Submit" />
                </div>
            </form>
        </div>
    </div>
</body>
</html>