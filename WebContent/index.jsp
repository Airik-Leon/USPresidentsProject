<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>U.S. Presidents</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="favicon.ico"/>


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
            <a class="navbar-brand" href="WebContent/index.jsp">U.S. PRESIDENTS</a>
        </h1>
    </nav>
    <br />
    <!--Party Component  -->
    <div class="container" id="presidentApp">
        <div class="row" style="float: left;" id="partyComponent">
        <div class="col-sm">
                    <form action="party.do" method="POST">
                <div class=" btn-group-vertical col-sm">
                    <div class="btn-group-vertical">
                        <input class="btn btn-primary" type="submit"
                            value="Democrat" name="Democrat" /> <input
                            class="btn btn-danger" type="submit"
                            value="Republican" name="Republican" /> <input
                            class="btn btn-info" type="submit"
                            value="Democratic-Republican"
                            name="Democratic-Republican" /> <input
                            class="btn btn-warning" type="submit"
                            value="Federalist" name="Federalist" /> <input
                            class="btn btn-secondary" type="submit"
                            value="Whig" name="Whig" />
                            <input class="btn btn-dark" type="submit" value="All Presidents" name="reset"/>
                    </div>
                </div>
            </form>
            <br/>
            <!--PresidentsListComponent  -->
            <div class=" container col-sm" id="presidentsListComponent">
            <form action="selectPresident.do" method="POST">
                <select class="list-group" name="ListOfPresidents">
                    <c:forEach var="president" items="${presList}">
                <c:choose>
                     <c:when test="${count+1 == president.termNumber}">
                          <c:set var="selected" value="selected"></c:set>
                     </c:when>
                     <c:otherwise>
                          <c:set var="selected" value=""></c:set>
                     </c:otherwise>
                </c:choose>
                        <option class="list-group-item" value="${president.termNumber}" ${selected}>${president.termNumber}: ${president.firstName} ${president.middleName} ${president.lastName }</option> 
                    </c:forEach>
                </select>  
                <br/>
                <input class="btn btn-primary" type="submit" value="Get President"/>
            </form>
            </div>   
        </div>
        </div>
        <div class="row col-sm-8" >
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
                    <h3>${pres.termNumber}: ${pres.firstName}
                        ${pres.middleName} ${pres.lastName}</h3>
                </div>
                <!-- President Image -->
                <div class="col-sm-12 rounded" id="presidentImg">
                    <img class="container rounded" width="100%" height="100%"
                        src="${pres.url}" />
                </div>
                <!--President term time and facts  -->
                <div class="container col-sm-12" id="presidentTermAndFactsComponent">
                <c:choose>
                     <c:when test="${pres.termEnded == 0}">
                      <c:set var = "yearEnded" value="present"></c:set>
                     </c:when>
                     <c:otherwise>
                        <c:set var="yearEnded" value="${pres.termEnded}"></c:set>
                     </c:otherwise>
                </c:choose>
                     <h4>${pres.termStarted} to ${yearEnded}</h4>
                    <p>${pres.fact}</p>
                </div>
                <br>
                <!-- Buttons -->
                <div class="container-fluid" id="buttonComponent"
                    style="margin: 0px auto; display: block;">
                    <form class="container" action="backward.do"
                        method="POST">
                        <input class="btn btn-primary" type="submit" name="back"
                            value="<"/>
                    </form>
                    <form class="container" action=forward.do
                        method="POST">
                        <input class="btn btn-primary" type="submit"
                            value=">" name="forward" />
                    </form>
                </div>
            </div>
        </div>
    </div>
    <footer class="footer">
        <div class="container">
        <span class="text-muted">Presidents search application</span>
      </div>
    </footer>
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

