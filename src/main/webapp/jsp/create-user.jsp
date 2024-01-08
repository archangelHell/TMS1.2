   <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
       <title>Create User</title>
       <link rel="stylesheet" href="css/bootstrap.min.css">
       <script>
           window.addEventListener("Content Load", function () {
               [].forEach.call(document.querySelectorAll('.tel'), function (input) {
                   var keyCode;
                   function mask(event) {
                       event.keyCode && (keyCode = event.keyCode);
                       var pos = this.selectionStart;
                       if (pos < 3) event.preventDefault();
                       var matrix = "+375 (__) ___ ____",
                           i = 0,
                           def = matrix.replace(/\D/g, ""),
                           val = this.value.replace(/\D/g, ""),
                           new_value = matrix.replace(/[_\d]/g, function (a) {
                               return i < val.length ? val.charAt(i++) : a
                           });
                       i = new_value.indexOf("_");
                       if (i != -1) {
                           i < 5 && (i = 3);
                           new_value = new_value.slice(0, i)
                       }

                       var reg = matrix.subst(0, this.value.length).replace(/_+/g,
                           function (a) {
                               return "\\d{1," + a.length + "}"
                           }).replace(/[+()]/g, "\\$&");
                       reg = new RegExp("^" + reg + "$");
                       if (!reg.test(this.value) || this.value.length < 5 || keyCode > 47 && keyCode < 58) {
                           this.value = new_value;
                       }
                       if (event.type == "blur" && this.value.length < 5) {
                           this.value = "";
                       }
                   }
                   input.addEventListener("input", mask, false);
                   input.addEventListener("focus", mask, false);
                   input.addEventListener("blur", mask, false);
                   input.addEventListener("keydown", mask, false);
               });
           });
       </script>

   </head>
   <style>
       .form-group-button {
           margin-top: 20px;
       }
       .form-group{
           width: 40%;
           margin-left: 300px;

       }
   </style>
   <body>
   <div class="container mt-5">
       <form action="/user" method="post">
           <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
           <% if (errorMessage != null) { %>
           <div class="alert alert-danger" role="alert">
               <%= errorMessage %>
           </div>
           <% } %>
           <div class="form-group">
               <label for="username">Username</label>
               <input type="text" class="form-control" id="username" name="username" value="<c:out value="${requestScope.username}"/> ">
           </div>
           <div class="form-group">
               <label for="password">Password</label>
               <input type="password" class="form-control" id="password" name="password" required>
           </div>
           <div class="form-group">
               <label for="firstName">First Name</label>
               <input type="text" class="form-control" id="firstName" name="firstName" value="<c:out value="${requestScope.firstName}"/> ">
           </div>
           <div class="form-group">
               <label for="lastName">Last Name</label>
               <input type="text" class="form-control" id="lastName" name="lastName" value="<c:out value="${requestScope.lastName}"/> ">
           </div>
           <div class="form-group">
                <label for="date">Birthday date</label>
                <input type="text" class="form-control" id="date" name="date" value="<c:out value="${requestScope.date}"/> ">
           </div>
           <div class="form-group">
               <label for="gender">Gender</label>
               <select class="form-control" id="gender" name="gender" value="<c:out value="${requestScope.gender}"/> ">
                   <option value="male">Male</option>
                   <option value="female">Female</option>
               </select>
           </div>
           <div class="form-group">
               <label for="city">City</label>
               <input type="text" class="form-control" id="city" name="city" value="<c:out value="${requestScope.city}"/> ">
           </div>
           <div class="form-group">
               <label for="phoneNumber">Phone Number</label>
               <input type="tel" class="form-control tel" id="phoneNumber" name="phoneNumber" value="<c:out value="${requestScope.phoneNumber}"/> ">
           </div>
           <div class="form-group form-group-button">
               <button type="submit" class="btn btn-primary">Submit</button>
           </div>
   <%--        <button type="submit" class="btn btn-primary">Submit</button>--%>
       </form>
   </div>
   <script href="bootstrap.bundle.min.js"></script>
   </body>
   </html>
