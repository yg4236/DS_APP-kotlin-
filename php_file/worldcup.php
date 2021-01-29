
<?php




function randNoneDup($p_min, $p_max, $p_cnt){
  $result = array();

  $range = $p_max - $p_min + 1;

  if($p_min >= $p_max or $p_cnt < 1){
   return $result;
  }

  if($p_cnt > $range){
   $p_cnt = $range;
  }

  $loop_cnt = $p_cnt + 1000;

  for($i=0;$i<$loop_cnt;$i++){
   $val = rand($p_min,$p_max);

   if (!in_array($val, $result)) {
    $result[] = $val;
   }

   if(count($result) >= $p_cnt){
    break;
   }
  }

  return $result;
 }
$f_num = randNoneDup(1, 64, 16);

// for($i=0;$i<16;$i++){
//     echo $f_num[$i];
// }

///////////////////////////////////////
    $con = mysqli_connect("localhost", "yg4236", "dbsrb0418!", "yg4236");
    mysqli_query($con,'SET NAMES utf8');





    $statement = "SELECT * FROM food WHERE f_num =".$f_num[0]." or f_num =".$f_num[1]." or f_num =".$f_num[2]." or f_num =".$f_num[3]." or f_num =".$f_num[4]." or f_num =".$f_num[5]." or f_num =".$f_num[6]." or f_num =".$f_num[7]." or f_num =".$f_num[8]." or f_num =".$f_num[9]." or f_num =".$f_num[10]." or f_num =".$f_num[11]." or f_num =".$f_num[12]." or f_num =".$f_num[13]." or f_num =".$f_num[14]." or f_num =".$f_num[15]."";

//     echo $statement;


    $result = mysqli_query($con,$statement);
    while($row = mysqli_fetch_array($result)){
        echo $row['f_Name'];
        echo $row['calorie'];
        echo $row['car'];
        echo $row['pro'];
        echo $row['fat'];
        echo $row['win_count'];
    }

///////////////////////////////////
?>