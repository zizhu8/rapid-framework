/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.company.project.user.dao;

import org.springframework.stereotype.Repository;

import com.company.project.common.base.BaseMybatisDao;
import com.company.project.common.util.MybatisPageQueryUtils;
import com.company.project.user.model.UserInfo;
import com.company.project.user.query.UserInfoQuery;

import cn.org.rapid_framework.page.Page;

/**
 *
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 * */
@Repository
public class UserInfoDao extends BaseMybatisDao<UserInfo,java.lang.Long>{
	
	@Override
	public String getMybatisMapperNamesapce() {
		return "UserInfo";
	}
	
	public void saveOrUpdate(UserInfo entity) {
		if(entity.getUserId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(UserInfoQuery query) {
		return MybatisPageQueryUtils.pageQuery(getSqlSession(),"UserInfo.findPage",query);
	}
	

}
