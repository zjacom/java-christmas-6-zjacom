# 크리스마스 프로모션

## 기능 목록

### 주문 서버
- [X] (String)"주문 음식-갯수"를 입력받아서 (Map<String, Integer>)"주문음식": 갯수로 변환한다.

### 메뉴판
- [X] 주문 음식을 입력받아서 주문 음식과 일치하는 가격 정보를 찾는다.

### 포스트기
- [X] 주문 음식과 개수를 입력받아 총 주문 금액을 계산한다.
- [X] 할인 정보와 증정품 가격 정보를 입력받아 총 혜택 금액을 계산한다.
- [X] 할인 정보를 입력받아서 예상 결제 금액을 계산한다.

### 이벤트 매니저
- [X] 총 주문 금액을 입력받아 샴페인을 증정할 수 있는지 확인한다.
- [X] 날짜, 총 주문 금액, 주문 정보를 활용하여 이벤트 달력으로부터 총 할인 정보를 확인한다.
- [X] 총 혜택 금액을 입력받아 받을 수 있는 배지를 확인한다.

### 이벤트 달력
- [X] D-day 할인 정보를 계산한다.
- [X] 평일이면 평일 할인 정보를, 주말이면 주말 할인 정보를 계산한다.
- [X] 특별 할인 정보를 계산한다.

### 입력 기능
- [X] 방문 날짜를 입력받는다.
  - ::boom:: 방문 날짜가 숫자가 아닌 경우 예외 처리한다.
  - ::boom:: 방문 날짜가 1 이상 31 이하가 아닌 경우 예외 처리한다.
- [X] 주문할 메뉴와 개수를 입력받는다.
  - ::boom:: 메뉴판에 없는 메뉴를 입력할 경우 예외 처리한다.
  - ::boom:: 중복 메뉴를 입력하는 경우 예외 처리한다.
  - ::boom:: 메뉴 형식이 예시와 다른 경우 예외 처리한다.
  - ::boom:: 메뉴의 개수가 1 이상이 아닐 경우 예외 처리한다.
  - ::boom:: 메뉴 개수의 총합이 20을 초과하는 경우 예외 처리한다.
  - ::boom:: 음료수만 주문하는 경우 예외 처리한다.

### 출력 기능
- [X] 주문 메뉴를 출력한다.
- [X] 할인 전 총 주문 금액을 출력한다.
- [X] 증정 메뉴를 출력한다.
- [X] 혜택 내역을 출력한다.
- [X] 총혜택 금액을 출력한다.
- [X] 할인 후 예상 결제 금액을 출력한다.
- [X] 이벤트 배지를 출력한다.
