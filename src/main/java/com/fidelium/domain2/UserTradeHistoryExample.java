package com.fidelium.domain2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserTradeHistoryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public UserTradeHistoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(byte[] value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(byte[] value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(byte[] value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(byte[] value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(byte[] value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(byte[] value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<byte[]> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<byte[]> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(byte[] value1, byte[] value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(byte[] value1, byte[] value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeIsNull() {
            addCriterion("user_trade_datetime is null");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeIsNotNull() {
            addCriterion("user_trade_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("user_trade_datetime =", value, "userTradeDatetime");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("user_trade_datetime <>", value, "userTradeDatetime");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("user_trade_datetime >", value, "userTradeDatetime");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("user_trade_datetime >=", value, "userTradeDatetime");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeLessThan(Date value) {
            addCriterionForJDBCDate("user_trade_datetime <", value, "userTradeDatetime");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("user_trade_datetime <=", value, "userTradeDatetime");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("user_trade_datetime in", values, "userTradeDatetime");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("user_trade_datetime not in", values, "userTradeDatetime");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("user_trade_datetime between", value1, value2, "userTradeDatetime");
            return (Criteria) this;
        }

        public Criteria andUserTradeDatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("user_trade_datetime not between", value1, value2, "userTradeDatetime");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(Double value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(Double value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(Double value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(Double value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(Double value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(Double value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<Double> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<Double> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(Double value1, Double value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(Double value1, Double value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andSendAddressIsNull() {
            addCriterion("send_address is null");
            return (Criteria) this;
        }

        public Criteria andSendAddressIsNotNull() {
            addCriterion("send_address is not null");
            return (Criteria) this;
        }

        public Criteria andSendAddressEqualTo(String value) {
            addCriterion("send_address =", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressNotEqualTo(String value) {
            addCriterion("send_address <>", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressGreaterThan(String value) {
            addCriterion("send_address >", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressGreaterThanOrEqualTo(String value) {
            addCriterion("send_address >=", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressLessThan(String value) {
            addCriterion("send_address <", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressLessThanOrEqualTo(String value) {
            addCriterion("send_address <=", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressLike(String value) {
            addCriterion("send_address like", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressNotLike(String value) {
            addCriterion("send_address not like", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressIn(List<String> values) {
            addCriterion("send_address in", values, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressNotIn(List<String> values) {
            addCriterion("send_address not in", values, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressBetween(String value1, String value2) {
            addCriterion("send_address between", value1, value2, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressNotBetween(String value1, String value2) {
            addCriterion("send_address not between", value1, value2, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendChargeIsNull() {
            addCriterion("send_charge is null");
            return (Criteria) this;
        }

        public Criteria andSendChargeIsNotNull() {
            addCriterion("send_charge is not null");
            return (Criteria) this;
        }

        public Criteria andSendChargeEqualTo(Double value) {
            addCriterion("send_charge =", value, "sendCharge");
            return (Criteria) this;
        }

        public Criteria andSendChargeNotEqualTo(Double value) {
            addCriterion("send_charge <>", value, "sendCharge");
            return (Criteria) this;
        }

        public Criteria andSendChargeGreaterThan(Double value) {
            addCriterion("send_charge >", value, "sendCharge");
            return (Criteria) this;
        }

        public Criteria andSendChargeGreaterThanOrEqualTo(Double value) {
            addCriterion("send_charge >=", value, "sendCharge");
            return (Criteria) this;
        }

        public Criteria andSendChargeLessThan(Double value) {
            addCriterion("send_charge <", value, "sendCharge");
            return (Criteria) this;
        }

        public Criteria andSendChargeLessThanOrEqualTo(Double value) {
            addCriterion("send_charge <=", value, "sendCharge");
            return (Criteria) this;
        }

        public Criteria andSendChargeIn(List<Double> values) {
            addCriterion("send_charge in", values, "sendCharge");
            return (Criteria) this;
        }

        public Criteria andSendChargeNotIn(List<Double> values) {
            addCriterion("send_charge not in", values, "sendCharge");
            return (Criteria) this;
        }

        public Criteria andSendChargeBetween(Double value1, Double value2) {
            addCriterion("send_charge between", value1, value2, "sendCharge");
            return (Criteria) this;
        }

        public Criteria andSendChargeNotBetween(Double value1, Double value2) {
            addCriterion("send_charge not between", value1, value2, "sendCharge");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_trade_history
     *
     * @mbg.generated do_not_delete_during_merge Tue Nov 07 16:47:44 KST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_trade_history
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
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