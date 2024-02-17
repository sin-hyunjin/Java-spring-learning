package poly.ex2;

public class AnimalPolyMain3 {
    public static void main(String[] args) {

        /** `Animal` 클래스는 동물이라는 클래스이다. 이 클래스를 다음과 같이 직접 생성해서 사용할 일이 있을까?
         * 개, 고양이, 소가 실제 존재하는 것은 당연하지만, 동물이라는 추상적인 개념이 실제로 존재하는 것은 이상하다.
         * 사실 이 클래스는 다형성을 위해서 필요한 것이지 직접 인스턴스를 생성해서 사용할 일은 없다.
         * */
        Animal[] animalArr = {new Dog(), new Cat(), new Caw(), new Pig()};

        for (Animal animal : animalArr) {
            soundAnimal(animal);
        }
    }
    // 변하지 않는 부분
    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }


}
