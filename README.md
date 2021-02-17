# DS_APP-kotlin-

## 2021.01.29 Login & Register 기능
![image](https://user-images.githubusercontent.com/62757915/106252371-8e10a900-6259-11eb-8f0f-a0bd219fb8ef.png)
![image](https://user-images.githubusercontent.com/62757915/106252400-979a1100-6259-11eb-9494-2b08e3122116.png)
![image](https://user-images.githubusercontent.com/62757915/106088611-a5706900-6169-11eb-978f-ed11fc541da2.png)
![image](https://user-images.githubusercontent.com/62757915/106088629-adc8a400-6169-11eb-84b6-eabc394d2f62.png)

## 2021.01.29 Menu Worldcup ( php에 16강 대진에 참가할 음식정보 랜덤으로 담아오기 까지 완성)
![image](https://user-images.githubusercontent.com/62757915/106287367-0a22e500-628a-11eb-9912-481aafeaecc2.png)
</br> 한글이 깨져서 나옴 </br>
![image](https://user-images.githubusercontent.com/62757915/106287546-435b5500-628a-11eb-9941-f307cd328e2e.png)

## 2021.01.30 Menu Worldcup ( php에 16강 메뉴들 json형태로 가져오고, WorldcupActivity에 읽어오기 )
![image](https://user-images.githubusercontent.com/62757915/106353424-d0a3b580-632d-11eb-8294-91ead3ab3456.png)
</br>json형태로 16개의 메뉴를 랜덤으로 가져옴 (랜덤메뉴선정 코드는 worldcup.php 안에 포함), 한글 깨짐 처리 못함 </br> 
![image](https://user-images.githubusercontent.com/62757915/106353433-e1542b80-632d-11eb-9a85-93285576f19b.png)

## 2021.02.01 Menu Worldcup ( 이상형 월드컵 진행, 우승 메뉴까지 뽑기)
![image](https://user-images.githubusercontent.com/62757915/106443145-83efe400-64bf-11eb-8514-f489190c24e1.png)
![image](https://user-images.githubusercontent.com/62757915/106443179-89e5c500-64bf-11eb-895f-970191fda5ed.png)
![image](https://user-images.githubusercontent.com/62757915/106443211-92d69680-64bf-11eb-90f4-c05936989369.png)
![image](https://user-images.githubusercontent.com/62757915/106443258-a08c1c00-64bf-11eb-9045-305db04fd135.png)
</br>이상형 월드컵을 진행하면서 인덱스를 담는과정에서 오류가 있어보임(같은 메뉴가 중복출전) , 한글 깨짐 처리 못함 </br> 

## 2021.02.08 PHP Modified
![php캡](https://user-images.githubusercontent.com/62757915/107182592-628f7a80-6a20-11eb-9d3b-83e5715caaa7.PNG)
</br> json_encode를 할때 코드 포인트 값에 따라 \ud0d5 이런식으로 자동 변환이 되는 것이고 이를 원문 그대로 사용하려면 JSON_UNESCAPED_UNICODE 값을 넣어주어야 함.</br> 
```$json = json_encode($arr, JSON_UNESCAPED_UNICODE);```</br> 하지만 여전히 한글은 깨지고 있음 (PHP에는 문제가 없고, DB에서 contents를 가져오는 과정에서 깨지는것 같아보임.

## 2021.02.09 PHP Modified
![image](https://user-images.githubusercontent.com/62757915/107235259-db65f500-6a67-11eb-8394-537bf282809a.png)
</br> php파일 인코딩을 UTF-8로 바꾸어 한글깨짐현상을 해결하였다.
```header('Content-Type: text/html; charset=utf-8');``` 다음 라인을 추가하여 인코딩 변경
</br> 하지만 이 과정에서 출력되는 json의 형태가 변형되어 worldcupActivity에서 웹서버에 접근해 contents를 parsing하는 과정에서 에러가 발생하였다.</br>
![image](https://user-images.githubusercontent.com/62757915/107238520-47962800-6a6b-11eb-992e-77c0d6c99f52.png)

## 2021.02.12 PHP Modified & WorldCup Algorithm Modified
</br> php파일에서 맨위의 html 코드를 제거하였더니 위의 에러가 해결되었다. 하지만 여전히 어플에서 불러오면 f_Name이 null로 표기된다</br>
![image](https://user-images.githubusercontent.com/62757915/107772230-54728e80-6d7f-11eb-8d43-1aee91d08381.png)
![image](https://user-images.githubusercontent.com/62757915/107773114-859f8e80-6d80-11eb-8223-546fd57471e8.png)
![image](https://user-images.githubusercontent.com/62757915/107773174-a10a9980-6d80-11eb-98ee-f1efaa19d507.png)
</br> Worldcup 알고리즘을 전의 알고리즘보다 쉽게 onCreate에서 fetch를 한번만하여 전역변수 array에 대진표를 저장해와 onCreate에서 나머지 worldcup을 수행하려한다

## 2021.02.14 WorldCup Algorithm Modified
![image](https://user-images.githubusercontent.com/62757915/107879674-9b968600-6f1d-11eb-8381-b31b9ac94799.png)
</br> 위의 코드를 추가하여 fetch와 메뉴의 이름을 바꾸어주는 사이에 delay를 주었다. -> fetch전에 메뉴의 이름을 바꾸어 값을 못읽어오는 사태를 방지</br>
![worldcup 21 02 14](https://user-images.githubusercontent.com/62757915/107879677-a05b3a00-6f1d-11eb-950c-a576cc88a8d0.gif)
</br> 메뉴이름이 null로 나오는 부분 빼고 기본적인 이상형 월드컵의 틀을 완성했다.

## 2021.02.16 Win_Menu_List
![image](https://user-images.githubusercontent.com/62757915/108087690-08935280-70bb-11eb-985e-937c2030669f.png)
</br> 이상형 월드컵에서 메뉴가 정해지면 화면전환하여 우승 메뉴와 우승 메뉴를 판매하는 음식점 리스트를 가져온다. 음식점 리스트는 새로운 php 파일로 음식점 정보를 받아와 리사이클러뷰에 넣을 계획 

## 2021.02.17 Win_Menu_List & List_Request
![worldcup 21 02 17](https://user-images.githubusercontent.com/62757915/108188520-0381e200-7153-11eb-81ec-529c4e53b914.gif)
</br> 한글이 null로 나오는 현상 해결 </br>
![image](https://user-images.githubusercontent.com/62757915/108189242-df72d080-7153-11eb-8cba-e949a2422595.png)
![image](https://user-images.githubusercontent.com/62757915/108188566-11376780-7153-11eb-802e-fbbd4ea8858d.png)
</br> 웹서버에 print한 json형태의 result에서 메뉴를 담는 column의 title이 다른 문제였다. (기존에 f_name으로 되어 있었다)</br>
추가로 DB의 강남 음식점리스트에서 우승 메뉴를 판매하는 식당리스트를 가져오는 php와 List_RequestActivity를 작성하였다. php에 아무 음식을 넣고 테스트하면 음식점이 잘 출력되나, List_RequsetActivity에서 우승메뉴를 넘겨주어 DB에 접근하면 읽어지지 않는다.
