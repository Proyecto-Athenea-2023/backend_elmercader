function nameValidation(name){
    const pattern = /^([A-Z][a-z]*)+ ([A-Z][a-z]*)+/;
    return pattern.test(name);
};


function emailValidation(email){
    const pattern = /^[a-z][a-z.]*@gmail.com/;
    return pattern.test(email);
};


function passwordValidation(password){
    return password.length >= 6? true : false;
}


function newPasswordValidation(password, confirmed_password){
    if(password === confirmed_password)
        return true;
    else
        return false;
};

