package com.springboot.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lizq
 * @date 2019/03/18 21:01 
 */
@Mapper
public interface UserMapper {
	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	@Transactional
	User selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> selectAllUser();
}