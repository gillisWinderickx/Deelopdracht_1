<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1>
            <span>XXX</span>
        </h1>
        <nav>
            <ul>
                <li id="actual"><a href="Controller?command=HomeHandler">Home</a></li>
                <li><a href="Controller?command=OverviewHandler">Overview</a></li>
                <li><a href="Controller?command=RegisterHandler">Register</a></li>
            </ul>
        </nav>
        <h2>Home</h2>

    </header>
    <main>
        <article>
            To change your password, fill in the form below with your correct credentials and a new password.
            If succesfull you will automatically be logged in.
        </article>
        <article>
            <c:choose>
                <c:when test="${not empty login}">
                    <p>Changed password for ${login.firstName}</p>
                    <form action="Controller?command=LogoutHandler" method="POST">
                        <input type="submit" id="logout" value="Log out">
                    </form>
                </c:when>
                <c:otherwise>
                    <c:if test="${not empty error}">
                        <div class="alert-danger">
                            <ul>
                                <li>${error}</li>
                            </ul>
                        </div>
                    </c:if>
                    <form action="Controller?command=ChangePasswordHandler" method="POST">
                        <p>
                            <label for="userid">User Identification</label>
                            <input type="text" id="userid" name="userid" required>
                        </p>
                        <p>
                            <label for="password">Password</label>
                            <input type="password" id="password" name="password" required>
                        </p>
                        <p>
                            <label for="password">New Password</label>
                            <input type="password" id="newPassword" name="newPassword" required>
                        </p>
                        <p>
                            <input type="submit" id="login" value="Change Password">
                        </p>
                    </form>
                </c:otherwise>
            </c:choose>
        </article>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
</div>
</body>
</html>
