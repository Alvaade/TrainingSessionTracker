public class Session {
    private final long duration;
    private final String date;

    public Session(long duration, String date) {
        this.duration = duration;
        this.date = date;
    }

    public long getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }
}
