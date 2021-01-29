<?php 
    $con = mysqli_connect("localhost", "yg4236", "dbsrb0418!", "yg4236");
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];
    $userName = $_POST["userName"];
    $userAge = $_POST["userAge"];
    $userSex = $_POST["userSex"];


    $statement = mysqli_prepare($con, "INSERT INTO USER VALUES (?,?,?,?,?)");
    mysqli_stmt_bind_param($statement, "sssii", $userID, $userPassword, $userName, $userAge, $userSex);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>