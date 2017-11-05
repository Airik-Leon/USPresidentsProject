<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>US Presidents</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
    integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
    crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
</head>
<body>
    <!--Page Bar -->
    <nav class="navbar navbar-dark bg-dark justify-content-between">
        <h1>
            <a class="navbar-brand">U.S. PRESIDENTS</a>
        </h1>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <!--Area for potential side nav  -->

            </div>
        </div>
        <div class="container col-sm-8">
            <!--Search -->
            <div class="container col-sm-8" id="presidentComponent">
                <form action="pres.do" method="POST">
                    <div class="col-sm-12">
                        <div class="input-group">
                            <input type="text" class="form-control"
                                placeholder="Search by: Term Number, Party"
                                aria-label="Search for..."
                                name="searchBar"> <span
                                class="input-group-btn"> <input
                                class="btn btn-success" type="submit"
                                value="Search" />
                            </span>
                        </div>
                    </div>
                </form>
                <!--President Header -->
                <div class="container">
                    <h3>${pres.termNumber}:${pres.firstName}
                        ${pres.middleName} ${pres.lastName}</h3>
                </div>
                <!-- President Image -->
                <div class="col-sm-12" id="presidentImg">
                    <img class="container" width="100%"
                        height="100%" src="${pres.url}"/>
                </div>
                <!--President term time and facts  -->
                <div class="container col-sm-12">
                    <h4>${pres.termStarted}to${pres.termEnded}</h4>
                    <p>${pres.fact}</p>
                </div>
                <br>
                <!-- Buttons -->
                <div class="container-fluid" id="buttonComponent" >
                    <form class="container" action="backward.do"
                        method="POST">
                        <input class="btn btn-primary" type="submit" value="back" name="back"/>
                    </form>
                    <form class="container" action=forward.do
                        method="POST">
                        <input class="btn btn-primary" type="submit"
                            value="forward" name="forward" />
                    </form>
                </div>
            </div>
        </div>
    </div>
    <br />

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
<script
    src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
    integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
    crossorigin="anonymous"></script>
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
    integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
    crossorigin="anonymous"></script>
</html>

