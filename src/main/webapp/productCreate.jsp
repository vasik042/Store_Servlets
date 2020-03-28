<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
        .main{
            background-color: lightgreen;
            border-color: black;
            border-style: solid;
            border-width: 1px;
            border-radius: 5px;
            width: 300px;
            height: 430px;
        }
        label{
            margin: auto;
        }
        input{
            margin-bottom: 10px;
            width: 229px;
            height: 30px;
            border-radius: 5px;
        }
        textarea{
            border-radius: 5px;
            margin-top: 5px;
        }
        p{
            top: 0;
            margin-top: 15px;
            margin-bottom: 5px;
        }
        
    </style>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
     <div class="main">
            <form action="product" method="post" style="display: flex; flex-direction: column; ">
                <label for="">
                    <p>Product name</p>
                    <input type="text" name="product_name" id="product_name">
                </label>

                <label for="">
                   <p>Price</p>
                    <input type="number" name="price" id="price">
                </label>

                <label for="">
                   <p>Description</p>
                    <textarea name="description" id="" cols="30" rows="10" placeholder="May be empty" id="description"></textarea>
                </label>

                <label for="" style="margin-top: 15px">
                    <input id="create" name = "create" type="submit" value="Create product" disabled style="background-color: lightgreen">
                </label>
            </form>
        </div>
    <jsp:include page="footer.jsp"></jsp:include>
    <script src="js/productCreate.js"></script>
</body>
</html>