package com.fidelium.domain2;

public class UserRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_role.id
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_role.role
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    private String role;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_role.id
     *
     * @return the value of user_role.id
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_role.id
     *
     * @param id the value for user_role.id
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_role.role
     *
     * @return the value of user_role.role
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public String getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_role.role
     *
     * @param role the value for user_role.role
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void setRole(String role) {
        this.role = role;
    }
}