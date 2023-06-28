// Global information
const URL_BASE = "http://localhost:8080"
let user = null;

function getUserByEmail(email){
    $.ajax({
        url: URL_BASE + "/api/user/"+email,
        type: "GET",
        datatype: "JSON"
    })
    .done( function(response){
        return response;
    })
    .fail(function(jqXHR, textStatus, errorThrown){
        console.log("Error in getUserByEmail. " + textStatus);
        return true;
    })
};


function createUser(){
    let name = document.getElementById("txtName").value;
    let email = document.getElementById("txtEmail").value;
    let password = document.getElementById("txtPassword").value;
    let confirmedPassword = document.getElementById("txtConfirmedPassword").value;

    if(nameValidation(name)){
        if(emailValidation(email)){
            if(newPasswordValidation(password, confirmedPassword)){
                if(passwordValidation)
                    if(!getUserByEmail(email)){
                        user = {
                            userName: name,
                            userEmail: email,
                            userPassword: password
                        };
                        let body = JSON.stringify(user);

                        $.ajax({
                            url: URL_BASE + "/api/user/new",
                            type: "POST",
                            datatype: "JSON",
                            data: body,
                            contentType: "application/json;charset=UTF-8"
                        })
                        .done( function(response){
                            console.log(response);
                            if(response)
                                alert("Usuario registrado correctamente.");
                            else
                                alert("El usuario no ha podido ser registrado. Verifique la informacion e intente de nuevo.");
                        })
                        .fail(function(jqXHR, textStatus, errorThrown){
                            console.log("Error in createUser. " + textStatus);
                            alert("El registro del usuario ha fallado. Por favor, intente de nuevo.");
                        })
                    }
                    else
                        alert("Ya existe un usuario registrado con el mismo email. Por favor, utilizar un email diferente.");
               else
                    alert("La contrasenia debe ser de minimo seis caracteres.");
            }
            else
                alert("Las contrasenias no son iguales. Verifique de nuevo por favor.");
        }
        else
            alert("El email no tiene un formato correcto.");
    }
    else
        alert("El nombre no tiene un formato correcto.")

   // TODO redirect to home
};


function validateLogin(){
    let email = document.getElementById("txtEmail").value;
    let password = document.getElementById("txtPassword").value;

    if(emailValidation(email)){
        $.ajax({
            url: URL_BASE + "/api/user/"+email+"/"+password,
            type: "GET",
            datatype: "JSON"
        })
        .done( function(response){
            console.log(response);
            if(response)
                alert("Usuario con ingreso valido.");
            else
                alert("Usuario con ingreso incorrecto.");
            // TODO redirect to profile or main profile screen
        })
        .fail(function(jqXHR, textStatus, errorThrown){
            console.log("Error in validate login. " + textStatus);
            alert("Falla en la plataforma. No se puede validar ingreso del usuario.");
            // TODO redirect to profile or main profile screen
        })
    }
    else {
        alert("El formato del email es incorrecto.");
    }

};