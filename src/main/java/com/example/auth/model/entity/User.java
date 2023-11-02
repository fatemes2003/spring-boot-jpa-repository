package com.example.auth.model.entity;

import com.example.auth.model.entity.enums.UserActive;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String username;
    private String pass;
    private String active_code;
    @Enumerated(EnumType.STRING)
    private UserActive userActive;
    private String remember_token;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updated_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deleted_at;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<GroupUser> groupUsers;

    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<BlockPermission> blockPermissions;

    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<VipPermission> vipPermissions;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getActive_code() {
        return active_code;
    }

    public void setActive_code(String active_code) {
        this.active_code = active_code;
    }

    public UserActive getUserActive() {
        return userActive;
    }

    public void setUserActive(UserActive userActive) {
        this.userActive = userActive;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Set<GroupUser> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(Set<GroupUser> groupUsers) {
        this.groupUsers = groupUsers;
    }

    public Set<BlockPermission> getBlockPermissions() {
        return blockPermissions;
    }

    public void setBlockPermissions(Set<BlockPermission> blockPermissions) {
        this.blockPermissions = blockPermissions;
    }

    public Set<VipPermission> getVipPermissions() {
        return vipPermissions;
    }

    public void setVipPermissions(Set<VipPermission> vipPermissions) {
        this.vipPermissions = vipPermissions;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", active_code='" + active_code + '\'' +
                ", userActive='" + userActive + '\'' +
                ", remember_token='" + remember_token + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
