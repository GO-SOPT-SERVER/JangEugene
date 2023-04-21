class Test<T>{ // 제네릭 클래스 생성
    private T value;

    public T get() {
        return value;
    }
    public void set(T value) {
        this.value = value;
    }

}

public class generic {

    public static void main(String[] args) {
        Test<String> StringGeneric = new Test<String>(); // 제네릭 인스턴스 타입을 다르게 생성
        Test<Integer> IntGeneric = new Test<Integer>();

        StringGeneric.set("어려운것 같아요");
        String str = StringGeneric.get(); // String 형식

        IntGeneric.set(20);
        int val = IntGeneric.get(); // Int 형식

        System.out.println("제네릭은 " + str);
        System.out.println("한 이정도..." + val);
    }

}