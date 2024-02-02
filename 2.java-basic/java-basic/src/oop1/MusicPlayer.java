package oop1;

/**
 * 음악 플레이어
 * 프로그램의 실행 순서 보다는
 * 음악 플레이어 클래스를 만드는 것 자체에 집중해야 한다.
 * 음악 플레이어 가 어떤 속성(데이터)을 가지고 어떤 기능(메서드)을 제공하는지 이 부분에 초점을 맞추어야 한다.
 * 속성: `volume` , `isOn`
 * 기능: `on()` , `off()` , `volumeUp()` , `volumeDown()` , `showStatus()`
 */
public class MusicPlayer {
    int volume = 0;
    boolean isOn = false;

    //
    void on() {
        isOn = true;
        System.out.println("음악 플레이어를 시작합니다"); }
    void off() {
        isOn = false;
        System.out.println("음악 플레이어를 종료합니다"); }
    void volumeUp() {
        volume++;
        System.out.println("음악 플레이어 볼륨올리기:" + volume); }
    void volumeDown() {
        volume--;
        System.out.println("음악 플레이어 볼륨내리기:" + volume); }
    void showStatus() {
        System.out.println("음악 플레이어 상태 확인"); if (isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + volume);
        }
        else {
            System.out.println("음악 플레이어 OFF");
        }
    }
}
