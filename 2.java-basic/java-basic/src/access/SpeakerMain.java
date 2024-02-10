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
        speaker.volume = 200;
        speaker.showVolume();
    }
}
