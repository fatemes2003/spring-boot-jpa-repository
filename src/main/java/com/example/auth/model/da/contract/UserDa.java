package com.example.auth.model.da.contract;

import com.example.auth.model.entity.Group;
import com.example.auth.model.entity.Permission;
import com.example.auth.model.entity.User;

import java.util.List;
import java.util.Set;

public interface UserDa {
    //user
    public User insertUser(User user);
    public User getUserById(int id);
    public boolean deleteUserById(int id);
    public void updateUser(int id, User newInfo);
    public List<User> getAllUser();

    //group
    public Set<Group> getAllGroupOfUser(int userId);
    public String assignGroupToUser(int userId, int groupId);
    public String deleteGroupFromUser(int userId, int groupId);
    public boolean checkAssignGroupToUser(int userId, int groupId);
    public boolean checkAssignGroupToUserWithGroupName(int userId, String groupName);

    //vipPermission
    public Set<Permission> getAllVipPermissionOfUser(int userId);
    public void assignVipPermissionToUser(int userId, int vipPermissionId);
    public void deleteVipPermissionFromUser(int userId, int vipPermissionId);
    public boolean checkAssignedVipPermissionToUser(int userId, int vipPermissionId);
    public boolean checkAssignedVipPermissionToUserWithPermissionName(int userId, String vipPermissionName);

    //blockPermission
    public List<Permission> getAllBlockPermissionOfUser(int userId);
    public void assignBlockPermissionToUser(int userId, int blockPermissionId);
    public void deleteBlockPermissionFromUser(int userId, int blockPermissionId);
    public void checkAssignedBlockPermissionToUser(int userId, int blockPermissionId);
    public void checkAssignedBlockPermissionToUserWithPermissionName(int userId, String blockPermissionName);

}
