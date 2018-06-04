package com.cn.frank.test.oauth2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: frank_du
 * Time : 2018/5/24 下午3:09
 */
public class UserJsonDto implements Serializable {

    private String guid;
    private boolean archived;

    private String username;
    private String phone;
    private String email;

    private List<String> privileges = new ArrayList<>();

    public UserJsonDto() {
    }

    public UserJsonDto(User user) {
        this.guid = user.getGuid();
        this.archived = user.getArchived();
        this.username = user.getUsername();

        this.phone = user.getPhone();
        this.email = user.getEmail();

        final List<Privilege> privilegeList = user.getPrivileges();
        for (Privilege privilege : privilegeList) {
            this.privileges.add(privilege.name());
        }
    }

    public boolean getArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<String> privileges) {
        this.privileges = privileges;
    }

}
