<%-- 
    Document   : userSignUp
    Created on : 10 Apr, 2020, 2:18:28 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="SignUp.css">
    <title>Sign Up</title>
</head>
<body>
    <h1>Let's get started!</h1>
    <div class="main">
        <div class="contentUser">
            <label for="name">Name</label>
            <div class="inputField"><input type="text" name="name" id="field" placeholder="Name" required></div>
            <br>
            <label for="name">Username</label>
            <div class="inputField"><input type="text" name="name" id="field" placeholder="Username" required></div>    
            <br>
            <label for="name">Password</label>
            <div class="inputField"><input type="password" name="name" id="field" placeholder="Password" required></div>
            <br>
            <label for="name">Re-enter Password</label>
            <div class="inputField"><input type="password" name="name" id="field" placeholder="Confirm Password" required></div>
            <br>
            <label for="name">Mobile no.</label>
            <div class="inputField"><input type="number" name="name" id="field" min="0" max="9" range=10 placeholder="Mobile no" required></div>
            <br>
            <label for="name">E-mail</label>
            <div class="inputField"><input type="text" name="name" id="field" placeholder="e-mail" required></div>    
            <br>
            <label for="gender">Gender</label>
            
            Male
            <input type="radio" name="gender" >
            Female
            <input type="radio" name="gender" >
            Other
            <input type="radio" name="gender" >
            <br>
            <br>
            <label for="name">Address</label>
            <div class="inputField"><input type="text" name="name" id="field" placeholder="Your current address" required></div>
            <br>
            <label for="agree"><input type="checkbox" name="agree"> I agree to all the T&C.</label>
            <br>
            <br>
            <a href="index.jsp"><button>Back</button></a>
            <input type="button" value="Submit" id="button">
        </div>
    </div>
</body>
</html>