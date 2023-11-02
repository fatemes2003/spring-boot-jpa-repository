package com.example.auth.model.da;

import com.example.auth.model.da.contract.UserDa;
import com.example.auth.model.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository(value = "mysql")
public class UserDaImpl implements UserDa {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User insertUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public boolean deleteUserById(int id) {

        Query query = entityManager.createNativeQuery("delete from User u where u.id=:id").setParameter("id", id);
        if (query.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void updateUser(int id, User newInfo) {
        // Todo
    }

    // group

    @Override
    public List<User> getAllUser() {
        return entityManager.createNativeQuery("select u from User u").getResultList();
    }

    @Override
    public Set<Group> getAllGroupOfUser(int userId) {
        User user = entityManager.find(User.class, userId);
        Set<GroupUser> groupUsers = user.getGroupUsers();
        Set<Group> groupsOfUser = new HashSet<>();
        Iterator iterator = groupUsers.iterator();
        while (iterator.hasNext()) {
            GroupUser groupUser = (GroupUser) iterator.next();
            Group group = groupUser.getGroup();
            groupsOfUser.add(group);
        }
        return groupsOfUser;
    }

    @Override
    public String assignGroupToUser(int userId, int groupId) {
        if (!checkAssignGroupToUser(userId, groupId)) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Query query = entityManager.createNativeQuery("insert into group_user(user_id, group_id) values(?1,?2)")
                    .setParameter(1, userId).setParameter(2, groupId);
            return (query.executeUpdate() > 0) ? "ok" : "nok";
        }
        return "assigned";
    }

    @Override
    public String deleteGroupFromUser(int userId, int groupId) {
        if (!checkAssignGroupToUser(userId, groupId)) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Query query = entityManager.createNativeQuery("delete from Group_User g where g.user.id=?1 and g.group.id=?2")
                    .setParameter(1, userId).setParameter(2, groupId);
            return (query.executeUpdate() > 0) ? "ok" : "nok";
        }
        return "not_assigned";
    }

    @Override
    public boolean checkAssignGroupToUser(int userId, int groupId) {
        Query query = entityManager.createNativeQuery("select count(g) from Group_User g where g.user.id=:uid and g.group.id=:gid")
                .setParameter("uid", userId)
                .setParameter("gid", groupId);
        return (long) query.getSingleResult() > 0;
    }

    @Override
    public boolean checkAssignGroupToUserWithGroupName(int userId, String groupName) {
        Query query_get_group_id = entityManager.createNativeQuery("select g.id from Group g where g.name_en = :name_en")
                .setParameter("name_en", groupName);
        Integer group_id = (Integer) query_get_group_id.getSingleResult();
        /////////////////////////////////
        return this.checkAssignGroupToUser(userId, group_id);
    }

    @Override
    public Set<Permission> getAllVipPermissionOfUser(int userId) {
        Set<VipPermission> vipPermissions = entityManager.find(User.class, userId).getVipPermissions();
        return vipPermissions
                .stream()
                .map((x) -> x.getPermission())
                .collect(Collectors.toSet());
    }

    @Override
    public void assignVipPermissionToUser(int userId, int vipPermissionId) {

    }

    @Override
    public void deleteVipPermissionFromUser(int userId, int vipPermissionId) {

    }

    @Override
    public boolean checkAssignedVipPermissionToUser(int userId, int vipPermissionId) {
        Query query = entityManager.createNativeQuery("select count(v) from VipPermision v where v.User.id=:uid and v.permission.id=:pid")
                .setParameter("uid", userId)
                .setParameter("pid", vipPermissionId);
        return (long) query.getSingleResult() > 0;
    }

    @Override
    public boolean checkAssignedVipPermissionToUserWithPermissionName(int userId, String vipPermissionName) {
        return false;
    }

    @Override
    public List<Permission> getAllBlockPermissionOfUser(int userId) {
        return null;
    }

    @Override
    public void assignBlockPermissionToUser(int userId, int blockPermissionId) {

    }

    @Override
    public void deleteBlockPermissionFromUser(int userId, int blockPermissionId) {

    }

    @Override
    public void checkAssignedBlockPermissionToUser(int userId, int blockPermissionId) {

    }

    @Override
    public void checkAssignedBlockPermissionToUserWithPermissionName(int userId, String blockPermissionName) {

    }
}
