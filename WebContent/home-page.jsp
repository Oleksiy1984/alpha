<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

         <!-- css link -->
         <link href="css/home-page.css" rel="stylesheet" type="text/css"/>
        
        <title>Rent a Car</title>
    </head>
    <body>
        
        <div class="container-fluid header-section">
            <div class="row">
                <div class="col-md-12 text-center">
                     <h3 class="title">Welcome, ${sessionScope.username}! Choose the cars:</h3>
                </div>
            </div>
        </div>

        <div class="container-fluid table-section">
            <div class="row">
                <div class="col-md-12 text-center">
                    <table class="table table-bordered">
                        <tr class="heading">
                            <td>Car ID</td>
                            <td>Car Brand</td>
                            <td>carType</td>
                            <td>Color</td>
                            <td>price</td>
                            <td>photo</td>
                            <td></td>
                        </tr>

                        <c:forEach var="Vehicles" items="${vehiclesList}">
                        <tr class="hover-rows">
                            <td><c:out value="${Vehicles.id}"/></td>
                            <td><c:out value="${Vehicles.brand.name}"/></td>
                            <td><c:out value="${Vehicles.carType}"/></td>
                            <td><c:out value="${Vehicles.color}"/></td>
                            <td>$<c:out value="${Vehicles.price}"/></td>
                            <td><c:out value="${Vehicles.photo}"/></td>
                            <td> <a href="SelectVehicle?id=${Vehicles.id}"> Select </a></td>
                        </tr>
                        </c:forEach>     
                    </table>
                </div>
            </div>
        </div>
        
        <div class="container-fluid home-section">
            <div class="row">
                <div class="col-md-12 left-align">
                    <a href="/final/logout" class="btn btn-primary">Logout</a> <br>
             
                </div>
            </div>
        </div>
        
        <div class="container-fluid footer-section">
            <div class="row">
                <div class="col-md-12 left-align">
                    	<h6>&copy; 1993 - 2017 EPAM Systems.</h6>
                </div>
            </div>
        </div>
        
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
