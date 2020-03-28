$.get("api/products")
    .done(function (products1) {
        var cardsContent = "";
        jQuery.each(products1, function (i, product) {
            cardsContent +=
                "<div class=\"card\">" +
                "<div class=\"card-body\">" +
                "<h5 class=\"card-title\">" + product.product_name + "</h5>" +
                "<p class=\"card-text\">" + product.product_description + "</p>" +
                "<p class=\"card-text\">" + product.price + " uah </p>" +
                "<a href='products?id=" + product.id + "' class='card-link'>Product details</a>"+
                "</div>" +
                "</div>"
        });
        $('.product-card').html(cardsContent);
    })
    .fail(function () {
        alert("Can't get products");
        });