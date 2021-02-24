
<?php
header('Content-Type: text/html; charset=utf-8');

    $con = mysqli_connect("localhost", "yg4236", "dbsrb0418!", "yg4236");
    mysqli_query($con,"SET NAMES utf8");

    $f_Name = $_POST["f_Name"];

    print $f_Name;

    $param = "'%{$f_Name}%'";
    print $param;


//
//     $statement = "SELECT distinct * FROM list WHERE main_menu like {$param}";
//     $result = mysqli_query($con,$statement);
//     while($row = mysqli_fetch_array($result)){
//         $res['name'] = $row["name"];
//         $res['main_menu'] = $row["main_menu"];
//         $res['address'] = $row["address"];
//         $res['contact'] = $row["contact"];
//         $arr["result"][] = $res;
//     }
//     $json = json_encode($arr,JSON_UNESCAPED_UNICODE);
//
//    print $json;


?>