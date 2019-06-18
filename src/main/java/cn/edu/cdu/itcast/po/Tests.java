package cn.edu.cdu.itcast.po;

public class Tests extends Courses {
    private Integer testId;

    private Integer courseId;

    private String title;

    private Integer totalGrades;

    private String testDesc;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getTotalGrades() {
        return totalGrades;
    }

    public void setTotalGrades(Integer totalGrades) {
        this.totalGrades = totalGrades;
    }

    public String getTestDesc() {
        return testDesc;
    }

    public void setTestDesc(String testDesc) {
        this.testDesc = testDesc == null ? null : testDesc.trim();
    }
}