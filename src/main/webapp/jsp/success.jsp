 <<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <title>Success</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  </head>
  <body>
  <div class="container mt-5">
      <div class="alert alert-success" role="alert">
          Заявка успешно сохранена
      </div>
      <div>
                  <strong>Username:</strong><%= request.getAttribute("username") %><br>
                  <strong>First Name:</strong><%= request.getAttribute("firstName") %><br>
                  <strong>Last Name:</strong><%= request.getAttribute("lastName") %><br>
                  <strong>Gender:</strong><%= request.getAttribute("gender") %><br>
                  <strong>Date of Birth:</strong><%= request.getAttribute("date") %><br>
                  <strong>Phone Number:</strong><%= request.getAttribute("phoneNumber") %><br>
      </div>
  </div>
  </body>
  </html>