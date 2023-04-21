import java.util.Scanner;
class Service{
    private String accountNumber;
    private String password;
    private String name;
    private int budget;

    public Service(String accountNumber, String password, String name, int budget){   // Service 리스트 만들기 위한 요소
        this.accountNumber = accountNumber;
        this.password = password;
        this.name = name;
        this.budget = budget;
    }

    public int getBudget(){ // 잔액
        return budget;
    }

    public void setPassword(String password) { // 비밀번호 설정 현재 비밀번호를, 받은 비밀번호로 변경
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void deposit(int money) {
        if (money <= 0) {                                   // 받은 금액이 0 이하 일 경우 입금 불가
            System.out.println("금액이 0이거나 0보다 작습니다.");
            return;
        }
        budget += money;
    }

    public void withdraw(int money) {
        if (money > budget){                                // 출금 금액이 현재 잔액보다 클 경우 출금 불가
            int outMoney = money-budget;
            System.out.println("출금 금액이 잔고보다 커, 빠질 수 있는 금액만 빠졌습니다. 빠진 금액: "+ outMoney );
            budget = 0;
            return;
        } if(money <= 0){
            System.out.println("0 이하의 금액은 출금할 수 없습니다.");
            return;
        }else {
            budget -= money;
        }
    }
    public String getAccountNumber() {                      // 계좌 정보를 불러옴
        return accountNumber;
    }

    public String getAccountInfo(){                        // 현재 있는 정보를 모두 불러옴.
        return "계좌번호: " + accountNumber + ", 고객이름: " + name + ", 비밀번호: " + password + ", 잔액: " + budget;
    }


}