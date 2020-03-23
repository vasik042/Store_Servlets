let productName = false;
let price = false;


document.getElementById('product_name').onchange = function(){
    productName = document.getElementById('product_name').value;
}


document.getElementById('price').onchange = function(){
    price = document.getElementById('price').value;
}



document.body.onmousemove = function(){
    if(price && productName){
        document.getElementById('create').removeAttribute("disabled");
        document.getElementById('create').style.backgroundColor = "forestgreen";
    }else{
        document.getElementById('create').setAttribute("disabled", "true");
        document.getElementById('create').style.backgroundColor = "lightgreen";
    }
}