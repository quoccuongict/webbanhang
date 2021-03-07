function loginValidate(){
    var email = document.forms["LoginForm"]["email"].value;
    var password = document.forms["LoginForm"]["password"].value;
    if(email == "" || password == ""){
        alert("Nhap thong tin");
        return false;
    }
    else{
        return true;
    }
}




