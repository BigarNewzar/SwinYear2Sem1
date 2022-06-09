/**
 * EX - JDBC - demo
 *
 * Embedded SQL programming - CustomerDB
 *
 * File: CustomerRecord.java 
 *
 */
package ex.jdbc;

/**
 * Helper class for DB.java
 */
public class Customer {
    private String custId;
    private String name;
    private String tel;
    private int age;

    public Customer() {
        custId = null;
        name = null;
        tel = null;
        age = 0;
    }

    public Customer(String custId, String name, String tel, int age) {
        setCustId(custId);
        setName(name);
        setTel(tel);
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
