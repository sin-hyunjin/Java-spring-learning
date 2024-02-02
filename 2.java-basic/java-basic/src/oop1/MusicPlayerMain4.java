package oop1;

/** 객체지향 프로그래밍
 * `MusicPlayer` 클래스에 음악 플레이어에 필요한 속성과 기능을 모두 정의했다.
 * 이제 음악 플레이어가 필요한 곳에서 이 클래스만 있으면 온전한 음악 플레이어를 생성해서 사용할 수 있다.
 * 음악 플레이어를 사용하는데 필요한 모든 속성과 기능이 하나의 클래스에 포함되어 있다!
 *
 * **캡슐화**
 * `MusicPlayer` 를 보면 음악 플레이어를 구성하기 위한 속성과 기능이 마치 하나의 캡슐에 쌓여있는 것 같다.
 * 이렇게 속성과 기능을 하나로 묶어서 필요한 기능을 메서드를 통해 외부에 제공하는 것을 캡슐화라 한다.
 */
public class MusicPlayerMain4 {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        player.on();
        player.volumeUp();
        player.volumeUp();
        player.volumeDown();
        player.off();
    }
}
