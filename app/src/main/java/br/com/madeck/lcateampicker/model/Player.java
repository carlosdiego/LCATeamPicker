package br.com.madeck.lcateampicker.model;

import com.orm.SugarRecord;

/**
 * Created by Anderson on 05/07/2016.
 */
public class Player extends SugarRecord{
    private String name;
    private int grade;
    private String primaryRole;
    private String secundaryRole;

    public Player(){ };

    public Player(String name, int grade, String primaryRole, String secundaryRole) {
        this.name = name;
        this.grade = grade;
        this.primaryRole = primaryRole;
        this.secundaryRole = secundaryRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getPrimaryRole() {
        return primaryRole;
    }

    public void setPrimaryRole(String primaryRole) {
        this.primaryRole = primaryRole;
    }

    public String getSecundaryRole() {
        return secundaryRole;
    }

    public void setSecundaryRole(String secundaryRole) {
        this.secundaryRole = secundaryRole;
    }
}
