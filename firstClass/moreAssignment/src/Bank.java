import java.util.Scanner;
import java.util.Random;

public class Bank {
    private static Service[] accounts = new Service[20]; // 리스트 생성
    private static int index = 0;

    public static int checkAccountNumber(String accountNumber) {
        for(int i=0; i<index; i++){
            if(accounts[i].getAccountNumber().contentEquals(accountNumber)){        // 받은 계좌와, getAccountNumber()에서 가져온 계좌가 일치하는지 확인.
                return i;
            }
        } return -1;
    }

    public static void getAccountList(){                                                // 계좌 리스트를 불러옴.
        for(int i=0; i< index; i++) {
            System.out.printf("%s%n", accounts[i].getAccountInfo());                    // for문으로 전체 리스트 호출
        }
    }

    public static void createAccount() {                                                // 계좌를 생성하는 메서드
        Random random = new Random();
        Scanner scanner = new Scanner((System.in));
        String accountNumber = (random.nextInt(90000) + 10000 ) + "-" + (random.nextInt(90000) + 10000 );   // 무작위 계좌
        System.out.println("계좌번호: " + accountNumber);                                 // 계좌는 임의로 생성 후 바로 사용자에게 보여줌.
        System.out.print("고객이름: ");                                                 // 나머지는 scanner을 통해 입력 받은 값 사용.
        String name = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();
        int budget = 0;                                                                 // 입금이 되어있는 상태가 아니기 때문에 0으로 시작.
        System.out.print("금액: "+budget);

        accounts[index] = new Service(accountNumber, password, name, budget);
        index ++;                                                                       // 새로운 계좌가 생길때마다 index++

        System.out.println(accountNumber + "인 계좌 계설 완료!");

    }

    public static void findAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("계좌번호를 입력해주세요.");
        String accountNumber = sc.nextLine() ;

        int index = checkAccountNumber(accountNumber);                                  // 함수를 통해 위에서 받은 accountNumber가 일치하는지 확인.
        if (index == -1) {
            System.out.println("계좌가 존재하지 않습니다.");
        } else {
            System.out.printf("계좌번호 %d%n", accounts[index].getBudget());
        }


    }

    public static void moneyIn() {
        Scanner scanner = new Scanner((System.in));

        System.out.print(("계좌번호를 입력해주세요.: "));
        String accountNumber = scanner.nextLine();
        System.out.print("입금할 금액: ");
        int money = scanner.nextInt();
        int index = checkAccountNumber(accountNumber);                                      // 위 와 일치.
        if (index == -1) {
            System.out.println("계좌가 존재하지 않습니다.");
        } else {
            accounts[index].deposit(money);
        }

    }

    public static void moneyOut() {
        Scanner scanner = new Scanner((System.in));
        System.out.print("계좌번호를 입력해주세요.");
        String accountNumber = scanner.nextLine();
        System.out.print("비밀번호 확인이 필요합니다.: ");
        String password = scanner.nextLine();
        int index = checkAccountNumber(accountNumber);
        if (index == -1) {
            System.out.println("계좌가 존재하지 않습니다.");
        } else {
            if (!accounts[index].getPassword().equals(password)) {                  // 계좌가 존재하기는 하나 출금을 위해 비밀번호 확인
                System.out.println("비밀번호가 일치하지 않습니다.");

            } else {
                accounts[index].withdraw();
            }
        }

    }

    public static void changePassword(){
        Scanner scanner = new Scanner((System.in));
        System.out.print("계좌번호를 입력해주세요.");
        String accountNumber = scanner.nextLine();
        int index = checkAccountNumber(accountNumber);
        if (index == -1) {
            System.out.println("계좌가 존재하지 않습니다.");
        } else {
            System.out.print("이전 비밀번호를 입력해주세요.: ");                           // 일치할시만 통과
            String password = scanner.nextLine();
            if (!accounts[index].getPassword().equals(password)) {
                System.out.println("비밀번호가 일치하지 않습니다.");
            } else {
                System.out.print("바꾸고 싶은 비밀번호를 입력해주세요.: ");
                String afterPassword = scanner.nextLine();
                accounts[index].setPassword(afterPassword);                             // 새로 받은 비밀번호를 this.password = password를 통해 재정의
                System.out.println("비밀번호를 변경 했습니다.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("1. 계좌 개설 2. 입금  3. 출금 4. 잔액 조회 5. 전체 계좌 조회 6. 비밀번호 변경");
            System.out.println("원하는 메뉴를 선택해주세요.");

            int num = scan.nextInt();
            switch (num) {                                                              // 받은 번호의 case를 실행.
                case 1 :
                    System.out.println("계좌를 개설합니다.");
                    createAccount();
                    break;
                case 2 :
                    System.out.println("입금입니다.");
                    moneyIn();
                    break;
                case 3 :
                    System.out.println("출금 입니다.");
                    moneyOut();
                    break;
                case 4:
                    System.out.println("현재 잔액을 조회합니다.");
                    findAccount();
                    break;
                case 5:
                    System.out.println("전체 계좌 조회");
                    getAccountList();
                    break;
                case 6:
                    System.out.println(" 비밀번호를 바꿉니다.");
                    changePassword();
                    break;
                default:
                    System.out.println("정해진 숫자 값이 아닙니다.");

            }
        }
    }
}
