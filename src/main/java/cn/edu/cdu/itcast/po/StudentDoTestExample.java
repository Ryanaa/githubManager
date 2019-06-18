package cn.edu.cdu.itcast.po;

import java.util.ArrayList;
import java.util.List;

public class StudentDoTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentDoTestExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStudentDoTestIdIsNull() {
            addCriterion("student_do_test_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentDoTestIdIsNotNull() {
            addCriterion("student_do_test_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentDoTestIdEqualTo(Integer value) {
            addCriterion("student_do_test_id =", value, "studentDoTestId");
            return (Criteria) this;
        }

        public Criteria andStudentDoTestIdNotEqualTo(Integer value) {
            addCriterion("student_do_test_id <>", value, "studentDoTestId");
            return (Criteria) this;
        }

        public Criteria andStudentDoTestIdGreaterThan(Integer value) {
            addCriterion("student_do_test_id >", value, "studentDoTestId");
            return (Criteria) this;
        }

        public Criteria andStudentDoTestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_do_test_id >=", value, "studentDoTestId");
            return (Criteria) this;
        }

        public Criteria andStudentDoTestIdLessThan(Integer value) {
            addCriterion("student_do_test_id <", value, "studentDoTestId");
            return (Criteria) this;
        }

        public Criteria andStudentDoTestIdLessThanOrEqualTo(Integer value) {
            addCriterion("student_do_test_id <=", value, "studentDoTestId");
            return (Criteria) this;
        }

        public Criteria andStudentDoTestIdIn(List<Integer> values) {
            addCriterion("student_do_test_id in", values, "studentDoTestId");
            return (Criteria) this;
        }

        public Criteria andStudentDoTestIdNotIn(List<Integer> values) {
            addCriterion("student_do_test_id not in", values, "studentDoTestId");
            return (Criteria) this;
        }

        public Criteria andStudentDoTestIdBetween(Integer value1, Integer value2) {
            addCriterion("student_do_test_id between", value1, value2, "studentDoTestId");
            return (Criteria) this;
        }

        public Criteria andStudentDoTestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student_do_test_id not between", value1, value2, "studentDoTestId");
            return (Criteria) this;
        }

        public Criteria andTestIdIsNull() {
            addCriterion("test_id is null");
            return (Criteria) this;
        }

        public Criteria andTestIdIsNotNull() {
            addCriterion("test_id is not null");
            return (Criteria) this;
        }

        public Criteria andTestIdEqualTo(Integer value) {
            addCriterion("test_id =", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotEqualTo(Integer value) {
            addCriterion("test_id <>", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThan(Integer value) {
            addCriterion("test_id >", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_id >=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThan(Integer value) {
            addCriterion("test_id <", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdLessThanOrEqualTo(Integer value) {
            addCriterion("test_id <=", value, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdIn(List<Integer> values) {
            addCriterion("test_id in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotIn(List<Integer> values) {
            addCriterion("test_id not in", values, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdBetween(Integer value1, Integer value2) {
            addCriterion("test_id between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andTestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("test_id not between", value1, value2, "testId");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdIsNull() {
            addCriterion("student_select_course_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdIsNotNull() {
            addCriterion("student_select_course_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdEqualTo(Integer value) {
            addCriterion("student_select_course_id =", value, "studentSelectCourseId");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdNotEqualTo(Integer value) {
            addCriterion("student_select_course_id <>", value, "studentSelectCourseId");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdGreaterThan(Integer value) {
            addCriterion("student_select_course_id >", value, "studentSelectCourseId");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_select_course_id >=", value, "studentSelectCourseId");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdLessThan(Integer value) {
            addCriterion("student_select_course_id <", value, "studentSelectCourseId");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("student_select_course_id <=", value, "studentSelectCourseId");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdIn(List<Integer> values) {
            addCriterion("student_select_course_id in", values, "studentSelectCourseId");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdNotIn(List<Integer> values) {
            addCriterion("student_select_course_id not in", values, "studentSelectCourseId");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("student_select_course_id between", value1, value2, "studentSelectCourseId");
            return (Criteria) this;
        }

        public Criteria andStudentSelectCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("student_select_course_id not between", value1, value2, "studentSelectCourseId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}