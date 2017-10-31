package fuyu.ntub_course.Model;


public class Session {
    private String session;
    private String startTime;
    private String endTime;

    public Session(){

    }

    public Session(String session, String startTime, String endTime) {
        this.session = session;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
