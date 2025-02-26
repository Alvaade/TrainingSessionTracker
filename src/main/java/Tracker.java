import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tracker {
    private long trainingTime; // in minutes
    private final ArrayList<Session> sessions;

    public Tracker() {
        trainingTime = 0;
        sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        trainingTime += session.getDuration();
        sessions.add(session);
    }

    public long getTrainingTime() {
        return trainingTime;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public boolean graduationEligibility() {
        return trainingTime >= 30 * 5 * 30 * 6 || sessions.size() >= 100; // 30 minutes * 5 days * 30 weeks * 6 months or 100 sessions
    }
}
