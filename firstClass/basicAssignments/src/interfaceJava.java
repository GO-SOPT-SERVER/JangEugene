interface Animal {                  // Animal 인터페이스
    public abstract void talk();

}

interface Feed {                    // Food 인터페이스
    public abstract void food(String food);
    public abstract void cnt(int cnt);
}

class Hamster implements Animal,Feed { // 인터페이스 다중 상속 가능
    public String talk = "쥑쥑";

    @Override                           // 인터페이스의 경우 모든 메서드를 무조건 호출
    public void talk() {
        System.out.println("햄스터는 " + this.talk);
    }
    @Override
    public void food(String food) {
        System.out.println("나는 " + food + "를 좋아해");
    }
    @Override
    public void cnt(int cnt) {
        System.out.println("오늘 " + cnt + "개 먹었어.쥑쥑");
    }
}
public class interfaceJava {
    public static void main(String[] args) {
        Hamster hamster = new Hamster();
        hamster.talk();
        hamster.food("해바라기씨");
        hamster.cnt(5);
    }
}
