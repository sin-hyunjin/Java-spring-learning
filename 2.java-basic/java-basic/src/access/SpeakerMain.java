package access;

public class SpeakerMain {
    /**초기 음량 값을 90으로 지정했다. 그리고 음량을 높이는 메서드를 여러번 호출했다.

     */
    public static void main(String[] args) {
        Speaker speaker = new Speaker(90);
        speaker.showVolume();
        speaker.volumeUp();
        speaker.showVolume();
        speaker.volumeUp();
        speaker.showVolume();

        //필드에 직접 접근
        System.out.println("volume 필드 직접 접근 수정");
//        speaker.volume = 200;
        speaker.showVolume();
        /**`Speaker` 객체를 사용하는 사용자는 `Speaker` 의 `volume` 필드와 메서드에 모두 접근할 수 있다.
         앞서 `volumeUp()` 과 같은 메서드를 만들어서 음량이 100을 넘지 못하도록 기능을 개발했지만 소용이 없다. 왜냐하 면 `Speaker` 를 사용하는 입장에서는 `volume` 필드에 직접 접근해서 원하는 값을 설정할 수 있기 때문이다.
         이런 문제를 근본적으로 해결하기 위해서는 `volume` 필드의 외부 접근을 막을 수 있는 방법이 필요하다.
         */
    }
}
