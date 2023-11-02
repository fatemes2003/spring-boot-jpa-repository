package com.example.auth.model.da;

import com.example.auth.model.da.contract.GroupDa;
import com.example.auth.model.entity.Group;
import com.example.auth.model.entity.Permission;
import com.example.auth.model.entity.User;

import java.util.List;
import java.util.Set;

public class GroupDaImpl implements GroupDa {
    @Override
    public Group insertGroup(Group group) {
        return null;
    }

    @Override
    public Group getGroupById(int id) {
        return null;
    }

    @Override
    public boolean deleteGroupById(int id) {
        return false;
    }

    @Override
    public boolean updateGroup(int id, Group newInfo) {
        return false;
    }

    @Override
    public List<Group> getAllGroup() {
        return null;
    }

    @Override
    public Set<Permission> getAllPermissionOfGroup(int group_id) {
        return null;
    }

    @Override
    public String assignPermissionToGroup(int group_id, int permission_id) {
        return null;
    }

    @Override
    public String deletePermissionFromGroup(int group_id, int permission_id) {
        return null;
    }

    @Override
    public boolean checkAssignedPermissionToGroup(int group_id, int permission_id) {
        return false;
    }

    @Override
    public boolean checkAssignedPermissionToGroupWithPermissionName(int group_id, int permission_name) {
        return false;
    }

    @Override
    public Set<User> getAllUserOfGroup(int group_id) {
        return null;
    }

    @Override
    public String assignUserToGroup(int group_id, int user_id) {
        return null;
    }

    @Override
    public String deleteUserFromGroup(int group_id, int user_id) {
        return null;
    }

    @Override
    public boolean checkAssignedUserToGroup(int group_id, int user_id) {
        return false;
    }

    @Override
    public boolean checkAssignedUserToGroupWithUserName(int group_id, int user_name) {
        return false;
    }
}
