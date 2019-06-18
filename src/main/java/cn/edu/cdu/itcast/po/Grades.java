package cn.edu.cdu.itcast.po;

import java.util.Date;

public class Grades extends StudentDoTest {
    private Integer gradeId;

    private Integer studentDoTestId;

    private Integer result;

    private String memo;

    private Date updateDate;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getStudentDoTestId() {
        return studentDoTestId;
    }

    public void setStudentDoTestId(Integer studentDoTestId) {
        this.studentDoTestId = studentDoTestId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}