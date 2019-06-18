package cn.edu.cdu.itcast.po;

import java.util.ArrayList;
import java.util.List;

public class TestsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestsExample() {
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

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTotalGradesIsNull() {
            addCriterion("total_grades is null");
            return (Criteria) this;
        }

        public Criteria andTotalGradesIsNotNull() {
            addCriterion("total_grades is not null");
            return (Criteria) this;
        }

        public Criteria andTotalGradesEqualTo(Integer value) {
            addCriterion("total_grades =", value, "totalGrades");
            return (Criteria) this;
        }

        public Criteria andTotalGradesNotEqualTo(Integer value) {
            addCriterion("total_grades <>", value, "totalGrades");
            return (Criteria) this;
        }

        public Criteria andTotalGradesGreaterThan(Integer value) {
            addCriterion("total_grades >", value, "totalGrades");
            return (Criteria) this;
        }

        public Criteria andTotalGradesGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_grades >=", value, "totalGrades");
            return (Criteria) this;
        }

        public Criteria andTotalGradesLessThan(Integer value) {
            addCriterion("total_grades <", value, "totalGrades");
            return (Criteria) this;
        }

        public Criteria andTotalGradesLessThanOrEqualTo(Integer value) {
            addCriterion("total_grades <=", value, "totalGrades");
            return (Criteria) this;
        }

        public Criteria andTotalGradesIn(List<Integer> values) {
            addCriterion("total_grades in", values, "totalGrades");
            return (Criteria) this;
        }

        public Criteria andTotalGradesNotIn(List<Integer> values) {
            addCriterion("total_grades not in", values, "totalGrades");
            return (Criteria) this;
        }

        public Criteria andTotalGradesBetween(Integer value1, Integer value2) {
            addCriterion("total_grades between", value1, value2, "totalGrades");
            return (Criteria) this;
        }

        public Criteria andTotalGradesNotBetween(Integer value1, Integer value2) {
            addCriterion("total_grades not between", value1, value2, "totalGrades");
            return (Criteria) this;
        }

        public Criteria andTestDescIsNull() {
            addCriterion("test_desc is null");
            return (Criteria) this;
        }

        public Criteria andTestDescIsNotNull() {
            addCriterion("test_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTestDescEqualTo(String value) {
            addCriterion("test_desc =", value, "testDesc");
            return (Criteria) this;
        }

        public Criteria andTestDescNotEqualTo(String value) {
            addCriterion("test_desc <>", value, "testDesc");
            return (Criteria) this;
        }

        public Criteria andTestDescGreaterThan(String value) {
            addCriterion("test_desc >", value, "testDesc");
            return (Criteria) this;
        }

        public Criteria andTestDescGreaterThanOrEqualTo(String value) {
            addCriterion("test_desc >=", value, "testDesc");
            return (Criteria) this;
        }

        public Criteria andTestDescLessThan(String value) {
            addCriterion("test_desc <", value, "testDesc");
            return (Criteria) this;
        }

        public Criteria andTestDescLessThanOrEqualTo(String value) {
            addCriterion("test_desc <=", value, "testDesc");
            return (Criteria) this;
        }

        public Criteria andTestDescLike(String value) {
            addCriterion("test_desc like", value, "testDesc");
            return (Criteria) this;
        }

        public Criteria andTestDescNotLike(String value) {
            addCriterion("test_desc not like", value, "testDesc");
            return (Criteria) this;
        }

        public Criteria andTestDescIn(List<String> values) {
            addCriterion("test_desc in", values, "testDesc");
            return (Criteria) this;
        }

        public Criteria andTestDescNotIn(List<String> values) {
            addCriterion("test_desc not in", values, "testDesc");
            return (Criteria) this;
        }

        public Criteria andTestDescBetween(String value1, String value2) {
            addCriterion("test_desc between", value1, value2, "testDesc");
            return (Criteria) this;
        }

        public Criteria andTestDescNotBetween(String value1, String value2) {
            addCriterion("test_desc not between", value1, value2, "testDesc");
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