$(function () {
    $('.mega-menu-title').click(function () {
        if ($('.mega-menu').is(':visible')) {
            $('.mega-menu').slideUp();
        } else {
            $('.mega-menu').slideDown();
        }
    })
    $('.mega-menu .nav > li').hover(function () {
        $(this).addClass("active");
        $(this).find('.sub-menu').stop(true, true).fadeIn('slow');
    }, function () {
        $(this).removeClass("active");
        $(this).find('.sub-menu').stop(true, true).fadeOut('slow');
    })
    $('.mega-menu .nav > li.view-more').click(function (e) {
        if ($('.mega-menu .nav > li.more').is(':visible')) {
            $('.mega-menu .nav > li.more').stop().slideUp();
            $(this).find('a').text('Nhiều hơn');
        } else {
            $('.mega-menu .nav > li.more').stop().slideDown();
            $(this).find('a').text('Đóng');
        }
        e.preventDefault();
    })

    $('#ma-slider').nivoSlider({
        effect: 'random',
        animSpeed: 1000,
        controlNav: false,
        directionNav: true,
        pauseTime: 6000
    });

    $("#hotproducts .owl").owlCarousel({
        autoPlay: false,
        items: 4,
        slideSpeed: 3000,
        directionNav: true,
        paginationSpeed: 3000,
        rewindSpeed: 3000,
        navigation: true,
        stopOnHover: true,
        pagination: false,
        scrollPerPage: true,
    });

    $("#saleproduct .owl").owlCarousel({
        autoPlay: false,
        items: 4,
        slideSpeed: 3000,
        directionNav: true,
        paginationSpeed: 3000,
        rewindSpeed: 3000,
        navigation: true,
        stopOnHover: true,
        pagination: false,
        scrollPerPage: true,
    });

    $("#newproduct .owl").owlCarousel({
        autoPlay: false,
        items: 4,
        slideSpeed: 3000,
        directionNav: true,
        paginationSpeed: 3000,
        rewindSpeed: 3000,
        navigation: true,
        stopOnHover: true,
        pagination: false,
        scrollPerPage: true,
    });

    $("#offer .owl").owlCarousel({
        autoPlay: false,
        items: 1,
        slideSpeed: 2000,
        directionNav: true,
        paginationSpeed: 3000,
        rewindSpeed: 3000,
        navigation: true,
        stopOnHover: true,
        pagination: false,
        scrollPerPage: true,
    });

    $("#special-product .owl").owlCarousel({
        autoPlay: false,
        items: 1,
        slideSpeed: 2000,
        directionNav: true,
        paginationSpeed: 3000,
        rewindSpeed: 3000,
        navigation: true,
        stopOnHover: true,
        pagination: false,
        scrollPerPage: true,
    });
    $("#news-upload .owl").owlCarousel({
        autoPlay: false,
        items: 1,
        slideSpeed: 2000,
        directionNav: true,
        paginationSpeed: 3000,
        rewindSpeed: 3000,
        navigation: true,
        stopOnHover: true,
        pagination: false,
        scrollPerPage: true,
    });
});

function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();

    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.    
//    $(".topbar-right").html('<div class="topbar-right">\n\
//                                <ul class="topbar-nav clearfix">\n\
//                                    <li><a href="#" class="login">Xin chào, ${profile.getName()}</a></li>\n\
//                                    <li><a href="/smartshop-soa/logout" class="registration">Đăng xuất</a></li>\n\
//                                </ul>\n\
//                            </div>');
    $(".login").html('Xin chào, ' + profile.getName());
    $(".registration").attr('href', '/smartshop-soa/logout').html('Đăng xuất');
}

function onSignInFailure(authResult) {
    console.log('Sign-in error: ' + authResult['error']);
}

function showImage() {
    if (this.files && this.files[0]) {
        var obj = new FileReader();
        obj.onload = (data) => {
            var image = document.getElementById("uploadImage");
            image.src = data.target.result;
            image.style.display = "block";            
            uploadImage(data);
        }
        obj.readAsDataURL(this.files[0]);
    }
}

function uploadImage(data) {
    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "https://api.imgur.com/3/image",
        "method": "POST",
        "data": {
            "headers": {
                "Authorization": "Bearer e4d75f4796de6c4e48f43a005ca3cbbd9a339b06"
            },
            "body": {
                image: data
            }
        }
    }

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}

function getImages() {
    var settings = {
        "async": true,
        "crossDomain": true,
        "url": "https://api.imgur.com/3/account/me/images",
        "method": "GET",
        "headers": {
            "Authorization": "Bearer e4d75f4796de6c4e48f43a005ca3cbbd9a339b06"
        }
    }

    $.ajax(settings).done(function (response) {
        console.log(response);
    });

}