import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackerTest {
    private Tracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new Tracker();
    }

    @Test
    void addSession() {
        Session session = new Session(60, "26-02-2025");
        tracker.addSession(session);
        assertEquals(60, tracker.getTrainingTime());
        assertEquals(1, tracker.getSessions().size());
        assertEquals(session, tracker.getSessions().getFirst());
    }

    @Test
    void calculateTrainingTime() {
        Session session1 = new Session(60, "26-02-2025");
        Session session2 = new Session(90, "27-02-2025");
        tracker.addSession(session1);
        tracker.addSession(session2);
        assertEquals(150, tracker.getTrainingTime());
    }

    @Test
    void checkGraduationByTrainingTime() {
        assertFalse(tracker.graduationEligibility(), "User should not be eligible initially");
        int requiredMinutes = 30 * 5 * 30 * 6; // 30 minutes * 5 days * 30 weeks * 6 months
        for (int i = 0; i < requiredMinutes / 30; i++) {
            tracker.addSession(new Session(30, "25-02-2025")); // Each session is 30 minutes, ignore the date
        }

        assertTrue(tracker.graduationEligibility(), "User should be eligible by training time");
    }

    @Test
    void checkGraduationBySessionCount() {
        assertFalse(tracker.graduationEligibility(), "User should not be eligible initially");
        for (int i = 0; i < 100; i++) {
            tracker.addSession(new Session(1, "25-02-2025")); // Each session is 1 minute
        }
        assertTrue(tracker.graduationEligibility(), "User should be eligible by session count");
    }

    @Test
    void testDate() {
        Session session = new Session(60, "26-02-2025");
        assertEquals("26-02-2025", session.getDate());
    }
}