package cn.edu.cdu.itcast.po;

public class StudentSelectCourse {
    private Integer studentSelectCourseId;

    private Integer studentId;

    private Integer courseId;

    public Integer getStudentSelectCourseId() {
        return studentSelectCourseId;
    }

    public void setStudentSelectCourseId(Integer studentSelectCourseId) {
        this.studentSelectCourseId = studentSelectCourseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}