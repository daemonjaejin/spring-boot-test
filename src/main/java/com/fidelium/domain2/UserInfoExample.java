package com.fidelium.domain2;

import java.util.ArrayList;
import java.util.List;

public class UserInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_info
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_info
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_info
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public UserInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
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
     * This method corresponds to the database table user_info
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
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
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
     * This class corresponds to the database table user_info
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRegionYnIsNull() {
            addCriterion("region_yn is null");
            return (Criteria) this;
        }

        public Criteria andRegionYnIsNotNull() {
            addCriterion("region_yn is not null");
            return (Criteria) this;
        }

        public Criteria andRegionYnEqualTo(String value) {
            addCriterion("region_yn =", value, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionYnNotEqualTo(String value) {
            addCriterion("region_yn <>", value, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionYnGreaterThan(String value) {
            addCriterion("region_yn >", value, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionYnGreaterThanOrEqualTo(String value) {
            addCriterion("region_yn >=", value, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionYnLessThan(String value) {
            addCriterion("region_yn <", value, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionYnLessThanOrEqualTo(String value) {
            addCriterion("region_yn <=", value, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionYnLike(String value) {
            addCriterion("region_yn like", value, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionYnNotLike(String value) {
            addCriterion("region_yn not like", value, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionYnIn(List<String> values) {
            addCriterion("region_yn in", values, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionYnNotIn(List<String> values) {
            addCriterion("region_yn not in", values, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionYnBetween(String value1, String value2) {
            addCriterion("region_yn between", value1, value2, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionYnNotBetween(String value1, String value2) {
            addCriterion("region_yn not between", value1, value2, "regionYn");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andAddressYnIsNull() {
            addCriterion("address_yn is null");
            return (Criteria) this;
        }

        public Criteria andAddressYnIsNotNull() {
            addCriterion("address_yn is not null");
            return (Criteria) this;
        }

        public Criteria andAddressYnEqualTo(String value) {
            addCriterion("address_yn =", value, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressYnNotEqualTo(String value) {
            addCriterion("address_yn <>", value, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressYnGreaterThan(String value) {
            addCriterion("address_yn >", value, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressYnGreaterThanOrEqualTo(String value) {
            addCriterion("address_yn >=", value, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressYnLessThan(String value) {
            addCriterion("address_yn <", value, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressYnLessThanOrEqualTo(String value) {
            addCriterion("address_yn <=", value, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressYnLike(String value) {
            addCriterion("address_yn like", value, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressYnNotLike(String value) {
            addCriterion("address_yn not like", value, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressYnIn(List<String> values) {
            addCriterion("address_yn in", values, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressYnNotIn(List<String> values) {
            addCriterion("address_yn not in", values, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressYnBetween(String value1, String value2) {
            addCriterion("address_yn between", value1, value2, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressYnNotBetween(String value1, String value2) {
            addCriterion("address_yn not between", value1, value2, "addressYn");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTypeYnIsNull() {
            addCriterion("type_yn is null");
            return (Criteria) this;
        }

        public Criteria andTypeYnIsNotNull() {
            addCriterion("type_yn is not null");
            return (Criteria) this;
        }

        public Criteria andTypeYnEqualTo(String value) {
            addCriterion("type_yn =", value, "typeYn");
            return (Criteria) this;
        }

        public Criteria andTypeYnNotEqualTo(String value) {
            addCriterion("type_yn <>", value, "typeYn");
            return (Criteria) this;
        }

        public Criteria andTypeYnGreaterThan(String value) {
            addCriterion("type_yn >", value, "typeYn");
            return (Criteria) this;
        }

        public Criteria andTypeYnGreaterThanOrEqualTo(String value) {
            addCriterion("type_yn >=", value, "typeYn");
            return (Criteria) this;
        }

        public Criteria andTypeYnLessThan(String value) {
            addCriterion("type_yn <", value, "typeYn");
            return (Criteria) this;
        }

        public Criteria andTypeYnLessThanOrEqualTo(String value) {
            addCriterion("type_yn <=", value, "typeYn");
            return (Criteria) this;
        }

        public Criteria andTypeYnLike(String value) {
            addCriterion("type_yn like", value, "typeYn");
            return (Criteria) this;
        }

        public Criteria andTypeYnNotLike(String value) {
            addCriterion("type_yn not like", value, "typeYn");
            return (Criteria) this;
        }

        public Criteria andTypeYnIn(List<String> values) {
            addCriterion("type_yn in", values, "typeYn");
            return (Criteria) this;
        }

        public Criteria andTypeYnNotIn(List<String> values) {
            addCriterion("type_yn not in", values, "typeYn");
            return (Criteria) this;
        }

        public Criteria andTypeYnBetween(String value1, String value2) {
            addCriterion("type_yn between", value1, value2, "typeYn");
            return (Criteria) this;
        }

        public Criteria andTypeYnNotBetween(String value1, String value2) {
            addCriterion("type_yn not between", value1, value2, "typeYn");
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

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletIsNull() {
            addCriterion("fidelium_wallet is null");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletIsNotNull() {
            addCriterion("fidelium_wallet is not null");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletEqualTo(String value) {
            addCriterion("fidelium_wallet =", value, "fideliumWallet");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletNotEqualTo(String value) {
            addCriterion("fidelium_wallet <>", value, "fideliumWallet");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletGreaterThan(String value) {
            addCriterion("fidelium_wallet >", value, "fideliumWallet");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletGreaterThanOrEqualTo(String value) {
            addCriterion("fidelium_wallet >=", value, "fideliumWallet");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletLessThan(String value) {
            addCriterion("fidelium_wallet <", value, "fideliumWallet");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletLessThanOrEqualTo(String value) {
            addCriterion("fidelium_wallet <=", value, "fideliumWallet");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletLike(String value) {
            addCriterion("fidelium_wallet like", value, "fideliumWallet");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletNotLike(String value) {
            addCriterion("fidelium_wallet not like", value, "fideliumWallet");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletIn(List<String> values) {
            addCriterion("fidelium_wallet in", values, "fideliumWallet");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletNotIn(List<String> values) {
            addCriterion("fidelium_wallet not in", values, "fideliumWallet");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletBetween(String value1, String value2) {
            addCriterion("fidelium_wallet between", value1, value2, "fideliumWallet");
            return (Criteria) this;
        }

        public Criteria andFideliumWalletNotBetween(String value1, String value2) {
            addCriterion("fidelium_wallet not between", value1, value2, "fideliumWallet");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_info
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
     * This class corresponds to the database table user_info
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