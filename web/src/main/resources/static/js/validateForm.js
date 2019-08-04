const FormValidator = {
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
    if (!FormValidator.login.val()) {
        event.preventDefault();
        FormValidator.login.css('border-color','red');
    }
    if (!FormValidator.pwd.val()) {
        event.preventDefault();
        FormValidator.pwd.css('border-color' ,'red');
    }
}
export default FormValidator;