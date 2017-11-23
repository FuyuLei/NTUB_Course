package fuyu.ntub_course.model;


public class Course extends CommonModel{

    private static final Course course = new Course();

    private String stdNo;
    private String today;

    public static Course getInstance(){
        return course;
    }

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
