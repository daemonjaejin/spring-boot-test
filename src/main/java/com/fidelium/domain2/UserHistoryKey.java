package com.fidelium.domain2;

import java.util.Date;

public class UserHistoryKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_history.id
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_history.user_datetime
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    private Date userDatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_history.id
     *
     * @return the value of user_history.id
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_history.id
     *
     * @param id the value for user_history.id
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_history.user_datetime
     *
     * @return the value of user_history.user_datetime
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public Date getUserDatetime() {
        return userDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_history.user_datetime
     *
     * @param userDatetime the value for user_history.user_datetime
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void setUserDatetime(Date userDatetime) {
        this.userDatetime = userDatetime;
    }
}