public class AlarmClock {
    private int second;
    private int minute;
    private int hour;

    private int alarm_second;
    private int alarm_minute;
    private int alarm_hour;

    private boolean alarm;

    public void setTime(int hour, int minute, int second) {
        if(hour < 24) this.hour = hour;
        if(minute < 60) this.minute = minute;
        if(second < 60) this.second = second;
    }

    public void setAlarmTime(int hour, int minute, int second) {
        if(hour < 24) this.alarm_hour = hour;
        if(minute < 60) this.alarm_minute = minute;
        if(second < 60) this.alarm_second = second;
    }

    public void toggleAlarm() {
        alarm = ! alarm;
    }

    private void incrementTime() {

        second ++;

        if(second == 60) {
            second = 0;
            minute ++;
        }

        if(minute == 60) {
            minute = 0;
            hour ++;
        }

        if(hour == 24) {
            hour = 0;
        }

        if(hour == alarm_hour && minute == alarm_minute && second == alarm_second) soundAlarm();
    }

    private void soundAlarm(){
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
    }

}
