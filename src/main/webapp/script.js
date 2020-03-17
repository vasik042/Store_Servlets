let firstName = false;
let secondName = false;
let email = false;
let password1 = "ThisIsStrangeButItWorksOnlyThisWay";
let password2 = false;

document.getElementById('firstName').onchange = function(){
    firstName = document.getElementById('firstName').value;
}

document.getElementById('secondName').onchange = function(){
    secondName = document.getElementById('secondName').value;
}

document.getElementById('password1').onchange = function(){
    password1 = document.getElementById('password1').value;
}

document.getElementById('password2').onchange = function(){
    password2 = document.getElementById('password2').value;
}

document.getElementById('email').onchange = function(){
    emailStr = document.getElementById('email').value;
    if(emailStr.split("@")[1]){
        email = true;
    }else{
        email = false;
    }
}

document.body.onmousemove = function(){
    if(firstName && secondName && email && (password1 == password2)){
        document.getElementById('btn').removeAttribute("disabled");
        document.getElementById('btn').style.backgroundColor = "forestgreen";
    }else{
        document.getElementById('btn').setAttribute("disabled", "true");
        document.getElementById('btn').style.backgroundColor = "lightgreen";
    }
}