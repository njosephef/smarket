package com.smarket.persistence;

import java.util.List;

import com.smarket.model.UserFriendMapping;

public interface UserFriendMappingPersistence extends GenericDAO<UserFriendMapping,Long>{
	
     List<UserFriendMapping> getAllFriends(Long userId,String status);
     UserFriendMapping getByUserIdAndFriendId(Long userId, Long friendId);
     List<UserFriendMapping> getByFriendId(Long friendId,String status);
}
