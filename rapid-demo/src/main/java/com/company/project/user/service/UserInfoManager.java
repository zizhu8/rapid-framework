/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.company.project.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.company.project.user.dao.UserInfoDao;
import com.company.project.user.model.UserInfo;
import com.company.project.user.query.UserInfoQuery;

import cn.org.rapid_framework.page.Page;


/**
 *
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 * */
@Service
@Transactional
public class UserInfoManager {

	private UserInfoDao userInfoDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUserInfoDao(UserInfoDao dao) {
		this.userInfoDao = dao;
	}
	
	/** 
	 * 创建UserInfo
	 **/
	public UserInfo save(UserInfo userInfo) {
	    Assert.notNull(userInfo,"'userInfo' must be not null");
	    initDefaultValuesForCreate(userInfo);
	    new UserInfoChecker().checkCreateUserInfo(userInfo);
	    this.userInfoDao.save(userInfo);
	    return userInfo;
	}
	
	/** 
	 * 更新UserInfo
	 **/	
    public UserInfo update(UserInfo userInfo) {
        Assert.notNull(userInfo,"'userInfo' must be not null");
        new UserInfoChecker().checkUpdateUserInfo(userInfo);
        this.userInfoDao.update(userInfo);
        return userInfo;
    }	
    
	/** 
	 * 删除UserInfo
	 **/
    public void removeById(java.lang.Long id) {
        this.userInfoDao.deleteById(id);
    }
    
	/** 
	 * 根据ID得到UserInfo
	 **/    
    public UserInfo getById(java.lang.Long id) {
        return this.userInfoDao.getById(id);
    }
    
	/** 
	 * 分页查询: UserInfo
	 **/      
	@Transactional(readOnly=true)
	public Page findPage(UserInfoQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return userInfoDao.findPage(query);
	}
	
    
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(UserInfo v) {
    }
    
    /**
     * UserInfo的属性检查类,根据自己需要编写自定义检查
     **/
    public class UserInfoChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateUserInfo(UserInfo v) {
            checkUserInfo(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateUserInfo(UserInfo v) {
            checkUserInfo(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkUserInfo(UserInfo v) {
        	// Bean Validator检查,属性检查失败将抛异常
//            validateWithException(v);
            
        	//复杂的属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
