const RegistrationFormValidator = {
    userName: $('#userName'),
    firstName: $('#firstName'),
    lastName: $('#lastName'),
    password: $('#pwd'),
    hint: $('#hint'),
    submit: $('#submit'),

    initialize() {
        this.submit.on('click', () => {
            validate(event);
        });
    }
};

function validate(event) {

    if (!(RegistrationFormValidator.userName.val()
        || RegistrationFormValidator.firstName.val()
        || RegistrationFormValidator.lastName.val()
        || RegistrationFormValidator.password.val()
    )) {
        event.preventDefault();
        $('#error-container').show();
    }
}

export default RegistrationFormValidator;