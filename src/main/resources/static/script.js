function profileEditValidation() {
    let returnVal = true;

    let inputsToValidateForLength = document.querySelectorAll('input.valid-length');
    for(let item of inputsToValidateForLength){
        item.classList.remove('is-invalid');
        if(!lengthValidation(item, 0, 70)){
            returnVal = markAsWrongInput(item, "Введите не более 70 символов");
        }
    }

    let inputToValidate = document.querySelector('input[name="company"]');
    inputToValidate.classList.remove('is-invalid');
    if(!lengthValidation(inputToValidate, 0, 350)){
        returnVal = markAsWrongInput(inputToValidate, "Введите не более 350 символов");
    }

    inputToValidate = document.querySelector('input[name="email"]');
    inputToValidate.classList.remove('is-invalid');
    if(!emailValidation(inputToValidate)){
        returnVal = markAsWrongInput(inputToValidate, "Некорректный email");
    }

    return returnVal;
}

function registrationValidation() {
    let alertMessage = document.getElementById("alert-message");
    alertMessage.innerText = null;

    let returnVal = true;

    let inputToValidate = document.querySelector('input[name="username"]');
    inputToValidate.classList.remove('is-invalid');
    if(!/^(([a-z\d])(?:[a-z\d]|-(?=[a-z\d])){0,}){0,}$/.test(inputToValidate.value)){
        returnVal = markAsWrongInput(inputToValidate, "Логин может включать строчные буквы латинского алфавита, цифры и одиночные дефисы, не может начинаться или заканчиваться дефисом");
    } else if(lengthValidation(inputToValidate, 0, 1)){
        returnVal = markAsWrongInput(inputToValidate, "Поле обязательно для заполнения");
    } else if(!lengthValidation(inputToValidate, 1, 21)){
        returnVal = markAsWrongInput(inputToValidate, "Длина логина не должна превышать 20 символов");
    }

    inputToValidate = document.querySelector('input[name="email"]');
    inputToValidate.classList.remove('is-invalid');
    if(lengthValidation(inputToValidate, 0, 1)) {
        returnVal = markAsWrongInput(inputToValidate, "Поле обязательно для заполнения");
    } else if(!emailValidation(inputToValidate)){
        returnVal = markAsWrongInput(inputToValidate, "Некорректный email");
    }

    inputToValidate = document.querySelector('input[name="password"]');
    inputToValidate.classList.remove('is-invalid');
    if(lengthValidation(inputToValidate, 0, 1)) {
        returnVal = markAsWrongInput(inputToValidate, "Поле обязательно для заполнения");
    }

    return returnVal;
}

function passwordResetValidation() {
    let inputToValidate = document.querySelector('input[name="password"]');
    let returnVal = true;

    inputToValidate.classList.remove('is-invalid');
    if(lengthValidation(inputToValidate, 0, 1)) {
        returnVal = markAsWrongInput(inputToValidate, "Поле обязательно для заполнения");
    }

    return returnVal;
}

function lengthValidation(p, from, to) {
    let varLength = p.value.length;
    return varLength >= from && varLength < to;
}

function emailValidation(p) {
    let varValue = p.value;
    return /^\w+((\.?\w*\-?)*\w+)*@(\w+\.?\w*\-?\w+)+$/.test(varValue);
}

function markAsWrongInput(p, t) {
    p.classList.add('is-invalid');
    p.nextElementSibling.innerText = t;
    return false;
}

document.addEventListener("DOMContentLoaded", popupMessage);

let mesageFromServ = document.querySelector("#registration-message")
    ? document.querySelector("#registration-message").value
    : null;

function popupMessage(){
    let popupMessage = document.querySelector("#popup");

    if(mesageFromServ != null && mesageFromServ !== ""){
        unfade(popupMessage);

        setTimeout(function (){
            fade(popupMessage)},
            3000
        );
    }
}

function unfade(element) {
    let op = 0.1;  // initial opacity
    element.style.display = 'block';
    let timer = setInterval(function () {
        if (op >= 1){
            clearInterval(timer);
        }
        element.style.opacity = op;
        element.style.filter = 'alpha(opacity=' + op * 100 + ")";
        op += op * 0.1;
    }, 1);
}

function fade(element) {
    let op = 1;  // initial opacity
    let timer = setInterval(function () {
        if (op <= 0.1){
            clearInterval(timer);
            element.style.display = 'none';
        }
        element.style.opacity = op;
        element.style.filter = 'alpha(opacity=' + op * 100 + ")";
        op -= op * 0.1;
    }, 50);
}
















