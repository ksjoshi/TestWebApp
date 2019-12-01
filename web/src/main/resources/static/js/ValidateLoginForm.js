const LoginFormValidator = {
    login: $('#login'),
    pwd: $('#password'),
    submit: $('#submit'),

    init() {
        this.submit.on('click',()=>{
            validate(event);
        });

        this.login.on('focus', () => {
            defaultView(this.login);
        });
        this.pwd.on('focus', () => {
            defaultView(this.pwd);
        })
    },
};

function defaultView(field) {
    field.css('border-color', '');
}

function validate(event) {
    if (!LoginFormValidator.login.val()) {
        event.preventDefault();
        LoginFormValidator.login.css('border-color','red');
    }
    if (!LoginFormValidator.pwd.val()) {
        event.preventDefault();
        LoginFormValidator.pwd.css('border-color' ,'red');
    }
}
export default LoginFormValidator;