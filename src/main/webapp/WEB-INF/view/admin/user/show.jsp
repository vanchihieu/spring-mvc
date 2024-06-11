<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Detail ${id}</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- <link href="/css/demo.css" rel="stylesheet"> -->

</head>

<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-12 mx-auto w-45 ">
            <div class="d-flex justify-content-center">
                <h3>User detail with id = ${id}</h3>
            </div>
            <div class="card mx-auto" style="width: 50%;">
                <div class="card-header">
                    User information
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">ID: ${user.id}</li>
                    <li class="list-group-item">Email: ${user.email}</li>
                    <li class="list-group-item">Fullname: ${user.fullName}</li>
                    <li class="list-group-item">Address: ${user.address}</li>

                </ul>
            </div>
            <div class="mt-2 d-flex justify-content-center">
                <button class="btn btn-primary " onclick="window.location.href='/admin/user'">Back to list</button>
            </div>
        </div>

    </div>

</div>
</body>

</html>