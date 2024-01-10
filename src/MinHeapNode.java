import java.time.LocalDateTime;

public class MinHeapNode {
    int patronID;
    int priority; // Lower values indicate higher priority
    LocalDateTime timeOfReservation;

    public MinHeapNode(int patronID, int priority, LocalDateTime timeOfReservation) {
        this.patronID = patronID;
        this.priority = priority;
        this.timeOfReservation = timeOfReservation;
    }

    // Getter for timeOfReservation
    public LocalDateTime getTimeOfReservation() {
        return timeOfReservation;
    }


    // Getters and setters
    public int getPatronID() {
        return patronID;
    }

    public void setPatronID(int patronID) {
        this.patronID = patronID;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}