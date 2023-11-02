package com.example.auth.model.da.contract;

import com.example.auth.model.entity.Group;
import com.example.auth.model.entity.Permission;
import com.example.auth.model.entity.User;

import java.util.List;
import java.util.Set;

public interface GroupDa {
    // group

    public Group insertGroup(Group group);
    public Group getGroupById(int id);
    public boolean deleteGroupById(int id);
    public boolean updateGroup(int id, Group newInfo);
    public List<Group> getAllGroup();

    // permission

    public Set<Permission> getAllPermissionOfGroup(int group_id);
    public String assignPermissionToGroup(int group_id, int permission_id);
    public String deletePermissionFromGroup(int group_id, int permission_id);
    public boolean checkAssignedPermissionToGroup(int group_id, int permission_id);
    public boolean checkAssignedPermissionToGroupWithPermissionName(int group_id, int permission_name);

    // user

    public Set<User> getAllUserOfGroup(int group_id);
    public String assignUserToGroup(int group_id, int user_id);
    public String deleteUserFromGroup(int group_id, int user_id);
    public boolean checkAssignedUserToGroup(int group_id, int user_id);
    public boolean checkAssignedUserToGroupWithUserName(int group_id, int user_name);
}
