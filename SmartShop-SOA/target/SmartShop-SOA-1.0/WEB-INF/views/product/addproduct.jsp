<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Danh sách sản phẩm</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">

        <link rel="icon" type="text/x-icon" href="images/logo.png">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="css/nivo-slider.css">
        <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic,700,700italic,800' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

        <!-- Script -->
        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
        <script type="text/javascript" src="js/owl.carousel.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
        <script type="text/javascript" src="https://apis.google.com/js/client.js"></script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/layouts/_header.jsp"></jsp:include> <!--Header-->
            <!--        <img src="https://i.imgur.com/addM6tx.jpg" style="display: block" height="200" id="uploadImage"/>
                    <input type="file" onchange="showImage.call(this)"/>-->
<!--            <div class="title">
                <h1>Imgur Upload API</h1>
                <p>Use JavaScript To Upload Image</p>
            </div>-->
            <div class="dropzone">
                <div class="info"></div>
            </div>
            <script type="text/javascript" src="./js/imgur.js"></script>
            <script type="text/javascript" src="./js/upload.js"></script>

        <jsp:include page="/WEB-INF/views/layouts/_footer.jsp"></jsp:include><!--Footer-->

        <script type="text/javascript">
            $(function () {
                $('.mega-menu')[0].style.display = "none";
            });
        </script>
    </script>
</body>
</html>