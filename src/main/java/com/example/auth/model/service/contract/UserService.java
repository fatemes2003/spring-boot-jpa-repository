package com.example.auth.model.service.contract;

import com.example.auth.model.entity.Group;
import com.example.auth.model.entity.Permission;
import com.example.auth.model.entity.User;

import java.util.List;

public interface UserService {
    //user
    public User insertUser(User user);
    public User getUserById(int id);
    public void deleteUserById(int id);
    public void updateUser(int id, User newInfo);
    public List<User> getAllUser();

    //group
    public List<Group> getAllGroupOfUser(int userId);
    public void assignGroupToUser(int userId, int groupId);
    public void deleteGroupFromUser(int userId, int groupId);
    public void checkAssignGroupToUser(int userId, int groupId);
    public void checkAssignGroupToUserWithGroupName(int userId, String groupName);

    //vipPermission
    public List<Permission> getAllVipPermissionOfUser(int userId);
    public void assignVipPermissionToUser(int userId, int vipPermissionId);
    public void deleteVipPermissionFromUser(int userId, int vipPermissionId);
    public void checkAssignedVipPermissionToUser(int userId, int vipPermissionId);
    public void checkAssignedVipPermissionToUserWithPermissionName(int userId, String vipPermissionName);

    //blockPermission
    public List<Permission> getAllBlockPermissionOfUser(int userId);
    public void assignBlockPermissionToUser(int userId, int blockPermissionId);
    public void deleteBlockPermissionFromUser(int userId, int blockPermissionId);
    public void checkAssignedBlockPermissionToUser(int userId, int blockPermissionId);
    public void checkAssignedBlockPermissionToUserWithPermissionName(int userId, String blockPermissionName);

}
