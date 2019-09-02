/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author AARON
 */
public class Person {
    
    private final String unam;

    private final String country;
    private final String province;
    private final String city_location;
    private final String city;
    
    private final String hob1;
    private final String hob2;
    private final String hob3;
    
   public Person(String username,String country,String city,String province,String city_location,String hob1,String hob2,String hob3){
        this.unam=username;
        this.country=country;
        this.province=province;
        this.city_location=city_location;
        this.city=city;
        this.hob1=hob1;
        this.hob2=hob2;
        this.hob3=hob3;
        
    }

    public String getCity() {
        return city;
    }

    public String getUnam() {
        return unam;
    }
    
    
    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity_location() {
        return city_location;
    }

    public String getHob1() {
        return hob1;
    }

    public String getHob2() {
        return hob2;
    }

    public String getHob3() {
        return hob3;
    }
    
}
