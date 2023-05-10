abstract class Food{ // 부모 클래스 추상화

    abstract public void eat(String name); // 선언은 되어 있으나 구현은 하지 않은 상태
    abstract public void hate(String food);

    abstract public void count(int food);

    }
class Eggplant extends Food {		// 추상클래스 Food를 상속받은 자손 클래스
    @Override
    public void eat(String name) {			// 오버라이드
        System.out.println(name + "이 음식을 먹습니다.");
    }
    @Override
    public void hate(String food){
        System.out.println("으! 아차! 이 음식은" + food + "였네요." );
    }
    @Override

    public void count(int food){
        System.out.println("맛있는건줄 알고 " + food + "개나 먹었어요.");
    }
}


public class abstractMethod {
    public static void main(String[] args) {
        Eggplant eggplant = new Eggplant(); // 인스턴스
        eggplant.eat("유진");
        eggplant.hate("가지");
        eggplant.count(3); // 오버 로딩 같은 food 지만 다른 타입으로 동작
    }
}

