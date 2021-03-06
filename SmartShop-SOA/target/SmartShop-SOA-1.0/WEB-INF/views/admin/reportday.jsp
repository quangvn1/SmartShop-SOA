<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Doanh thu theo ngày</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="utf-8">

        <link rel="icon" type="text/x-icon" href="images/logo.png">
        <link rel="stylesheet" type="text/css" href="styles/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="styles/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="styles/css/nivo-slider.css">
        <link rel="stylesheet" type="text/css" href="styles/css/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="styles/css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic,700,700italic,800' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

        <!-- Script -->
        <script type="text/javascript" src="styles/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="styles/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="styles/js/jquery.nivo.slider.pack.js"></script>
        <script type="text/javascript" src="styles/js/owl.carousel.min.js"></script>
        <script type="text/javascript" src="styles/js/main.js"></script>
    </head>
    <body>
        <jsp:include page="_header.jsp"></jsp:include> <!--End Header-->

            <div class="content">
                <div class="sitemap">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <span><a href="home">Trang chủ</a></span>
                                <span>Quản lí</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="title-choice">
                                <div>Tình hình kinh doanh</div>
                            </div>
                            <div class="sort-choice">
                                <div class="sort-by-firm">
                                    <h3>Thống kê doanh thu</h3>
                                    <ul class="list-choice">
                                        <li><a href="reportday">Ngày</a></li>
                                        <li><a href="#">Tháng</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="text-center">
                            <form action="reportday" method="POST">
                                <div class="col-md-9">
                                    <div class="col-md-4" style="padding-bottom: 30px">
                                        <div>Từ ngày:</div>
                                    </div>
                                    <div class="col-md-5">
                                        <input name="fromDay" type="text" value="${fromDay}">
                                </div>
                                <div class="col-md-3">
                                    <label>(dd-MM-yyyy)</label>
                                </div>
                            </div>
                            <div class="col-md-9" style="padding-bottom: 30px">
                                <div class="col-md-4">
                                    <div>Đến ngày:</div>
                                </div>
                                <div class="col-md-5">
                                    <input name="toDay" type="text" value="${toDay}">
                                </div>
                                <div class="col-md-3">
                                    <label>(dd-MM-yyyy)</label>
                                </div>
                            </div>
                            <div class="col-md-9" style="padding-bottom: 30px">
                                <div class="text-center">
                                    <input type="submit" class="btn btn-danger1" value="Xem">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-9">
                        <div class="table-responsive">
                            <table class="table custom-table">
                                <thead>
                                    <tr>
                                        <th>Tên sản phẩm</th>
                                        <th>Số lượng</th>
                                        <th>Đơn giá</th>
                                        <th>Doanh thu</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${listP}" var="listP">
                                    <tbody>
                                        <tr>
                                            <td>
                                                <div class="text-center">
                                                    <a href="#">${listP.name}</a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="text-center">
                                                    ${listP.number}</a>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="text-center">
                                                    <fmt:formatNumber type="number" value="${listP.price}" />đ
                                                </div>
                                            </td>
                                            <td>
                                                <div class="text-center">
                                                    <fmt:formatNumber type="number" value="${listP.total}" />đ
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </c:forEach>
                                <tbody>
                                    <tr>
                                        <td colspan="3" class="text-right "><strong>Tổng doanh thu:</strong></td>
                                        <td style="color: red;text-align: center"><fmt:formatNumber type="number" value="${amount}" /> đ</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--End Content-->

        <jsp:include page="_footer.jsp"></jsp:include><!--Footer bot-->

        <script type="text/javascript">
            $(function () {
                $('.mega-menu')[0].style.display = "none";
            });
        </script>
    </body>
</html>
