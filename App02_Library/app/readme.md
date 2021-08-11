# Data Activity

## app build.gradle에 속성추가
* app build.gradle의 android항목애 다름 속성을 추가
  buildFeatures {
        viewBinding true
  }
  
* old Android에서는 *.xml 파일에 직접 binding하는 속성을 추가해야 한다

# Fragment Activity
* 초기에 Android에서는 모든 화면을 Activity단위로 만들고 사용을 했다
* Activity는 만들고 화면에 보여지기 까지 많은 resource(메인 메모리)를 사용
* App에 보여주고자 하는 화면이 많으면 App 자체가 느려지거나 오류가 발생하는 경우가 많아짐
* 이런 문제들 떄문에 android에서는 Fragment라는 개념을 도입
* 여러개의 화면(UI)가 있는 App에서는  화면고 화면 사이에 빠른 전환이 이루어져야 하고 화면이 전환되는 과정에서 App에 오류가 발생하지 않아야 한다.
* 하지만  Activity는 이러한 문제를 해결하는데 많은 개발자의 노력이 필요했다
* 안드로이드에서는 Rfagment를 도입하여 작은 화면을구현하고, 필요할 경우 바꿔가면서 보여주는 개념을 만들게 된것이다
* 사용자에게는 Activity인지 Fragment인지 관계없이 같은 방식으로 화면을 전환하지만 개바자 입장에서 시스템적 입장에서는
상당히 유리한 방법이 된다.
  
* 기존에 Activity방식에 익숙한 개발자에게는 다소 생소한


# Retrofit을 사용한 open API 핸들링
OpenAPI를 사용하여 다른 서버에서 제공하는 데이터를 가져와 사용하는 경우
데이터를 수신한 후 parsing하는 과정을 거치는데
여러 툴이 있지만 그 중 안드로이드에 많이 사용하는 툴(라이브러리)이다.

* 수신되는 데이터 구조와 맞는 VO(DTO)를 만들고, 데이터를 수신한 후 자동으로 Mapping을 할 수 있다
* 데이터 수신한 후에 Gson 라이브러리를 사용하여 내부에서 자동 parsing이 이루어 진다

* Retrofit 을 사용하기 윟 다음의 두가지 dependency 를 사용한다
  implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
  implementation 'com.squareup.retrofit2:retrofit:2.9.0'
  
* API 요청과 Mapping을 하기 위한 interface를 선언해 주어야 한다