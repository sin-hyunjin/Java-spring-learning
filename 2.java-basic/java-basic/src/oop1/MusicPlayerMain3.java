package oop1;

/**  절차지향 프로그래밍 (순서를 중요시한다)
 * 각각의 기능을 메서드로 만든 덕분에 각각의 기능이 모듈화 되었다. 덕분에 다음과 같은 장점이 생겼다.
 * **중복 제거:** 로직 중복이 제거되었다. 같은 로직이 필요하면 해당 메서드를 여러번 호출하면 된다.
 * **변경 영향 범위:** 기능을 수정할 때 해당 메서드 내부만 변경하면 된다.
 * *메서드 이름 추가:** 메서드 이름을 통해 코드를 더 쉽게 이해할 수 있다.
 *
 **  절차지향 프로그래밍의 한계
 * 우리가 작성한 코드의 한계는 바로 데이터와 기능이 분리되어 있다는 점이다.
 * 음악 플레이어의 데이터는 `MusicPlayerData` 에 있는데, 그 데이터를 사용하는 기능은 `MusicPlayerMain3` 에 있는 각각의 메서드에 분리 되어 있다.
 * 그래서 음악 플레이어와 관련된 데이터는 `MusicPlayerData` 를 사용해야 하고, 음악 플레이어와 관련된
 * 기능은 `MusicPlayerMain3` 의 각 메서드를 사용해야 한다.
 *
 * 데이터와 그 데이터를 사용하는 기능은 매우 밀접하게 연관되어 있다. 각각의 메서드를 보면 대부분 `MusicPlayerData` 의 데이터를 사용한다.
 * 따라서 이후에 관련 데이터가 변경되면 `MusicPlayerMain3` 부분의 메서드들도 함께 변경해야 한다.
 * 그리고 이렇게 데이터와 기능이 분리되어 있으면 유지보수 관점에서도 관리 포인트가 2곳으로 늘어난다.
 */
public class MusicPlayerMain3 {

    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();

        // 음악 플레이어 켜기
        on(data);
        //볼륨 증가
        volumeUp(data);
        //볼륨 증가
        volumeUp(data);
        //볼륨 감소
        volumeDown(data);
        //음악 플레이어 상태
        showStatus(data);

        //음악 플레이어 끄기
        off(data);

    }

    // 모듈화
    static void on(MusicPlayerData data) {
        data.isOn = true;
        System.out.println("음악 플레이어를 시작합니다");
    }
    //음악 플레이어 끄기
    static void off(MusicPlayerData data) {
        data.isOn = false;
        System.out.println("음악 플레이어를 종료합니다");
    }
    static void volumeUp(MusicPlayerData data){
        data.volume++;
        System.out.println("음악 플레이어 볼륨:" + data.volume);
    }

    static void volumeDown(MusicPlayerData data) {
        data.volume--;
        System.out.println("음악 플레이어 볼륨:" + data.volume);
    }
    static void showStatus(MusicPlayerData data) {
        System.out.println("음악 플레이어 상태 확인");
        if (data.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + data.volume);
        }
        else {
            System.out.println("음악 플레이어 OFF");
        }
    }
}
