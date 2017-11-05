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

    <nav class="navbar navbar-dark bg-dark justify-content-between">
        <h1>
            <a class="navbar-brand">U.S. PRESIDENTS</a>
        </h1>
<!--         <form action="pres.do" method="POST">
            <input type="text" name="term" /> <input type="submit"
                value="Search" />
        </form> -->
    </nav>
    <form action="pres.do" method="POST">
        <div class="col-sm-4">
            <div class="input-group">
                <input type="text" class="form-control"
                    placeholder="Search for..."
                    aria-label="Search for..." name="term"> <span
                    class="input-group-btn">
                    <input class="btn btn-secondary" type="submit" value="Search" />
                </span>
            </div>
        </div>
    </form>



    <div class="col-sm-8">
        ${pres.termNumber} ${pres.firstName} ${pres.middleName}
        ${pres.lastName} ${pres.termStarted} ${pres.termEnded}
        ${pres.fact} <br /> <img src="${pres.url}" height="500"
            width=450 />
    </div>



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

