package car_park;

import java.time.LocalDateTime;

public class Ticket {
    private String serialUUID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
//    private Image carPhoto;

    public String getSerialUUID() {
        return serialUUID;
    }

    public void setSerialUUID(String serialUUID) {
        this.serialUUID = serialUUID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

//    public Image getCarPhoto() {
//        return carPhoto;
//    }

//    public void setCarPhoto(Image carPhoto) {
//        this.carPhoto = carPhoto;
//    }
}
