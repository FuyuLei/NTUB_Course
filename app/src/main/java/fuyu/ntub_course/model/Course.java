package fuyu.ntub_course.model;


public class Course extends CommonModel{

    private String stdNo;
    private String today;

    public Course(){

    }

    public String getStdNo() {
        return stdNo;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }
}
