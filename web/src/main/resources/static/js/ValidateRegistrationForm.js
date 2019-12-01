const RegistrationFormValidator = {
    userName: $('#userName'),
    firstName: $('#firstName'),
    lastName: $('#lastName'),
    password: $('#pwd'),
    hint: $('#hint'),
    submit: $('#submit'),

    initialize(){
        this.submit.on('click',() => {
            validate(event);
        });
    }
};
function validate(event) {

    let input = [
        RegistrationFormValidator.userName,
        RegistrationFormValidator.firstName,
        RegistrationFormValidator.lastName,
        RegistrationFormValidator.password
    ];

    if(!(RegistrationFormValidator.userName.val()
        || RegistrationFormValidator.firstName.val()
        || RegistrationFormValidator.lastName.val()
        || RegistrationFormValidator.password.val()
    )) {
        alert(RegistrationFormValidator.userName.val());
        event.preventDefault();
        $('#error-container').show();
    }
}

export default RegistrationFormValidator;