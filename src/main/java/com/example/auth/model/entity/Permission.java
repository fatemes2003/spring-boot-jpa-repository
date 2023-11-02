package com.example.auth.model.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "permissions")
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name_fa;
    private String name_en;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updated_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp deleted_at;

    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<GroupPermission> groupPermissions;

    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<BlockPermission> blockPermissions;

    @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<VipPermission> vipPermissions;

    public Permission() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_fa() {
        return name_fa;
    }

    public void setName_fa(String name_fa) {
        this.name_fa = name_fa;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
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

    public Set<GroupPermission> getGroupPermissions() {
        return groupPermissions;
    }

    public void setGroupPermissions(Set<GroupPermission> groupPermissions) {
        this.groupPermissions = groupPermissions;
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
        return "Permission{" +
                "id=" + id +
                ", name_fa='" + name_fa + '\'' +
                ", name_en='" + name_en + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
