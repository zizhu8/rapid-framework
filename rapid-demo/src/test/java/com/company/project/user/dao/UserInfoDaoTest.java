/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package com.company.project.user.dao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.common.base.BaseDaoTestCase;
import com.company.project.user.query.UserInfoQuery;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.test.context.TestMethodContext;


/**
 *
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 * */
public class UserInfoDaoTest extends BaseDaoTestCase{
	
	private UserInfoDao dao;
	
	@Autowired
	public void setUserInfoDao(UserInfoDao dao) {
		this.dao = dao;
	}

	@Override 
	protected String[] getDbUnitDataFiles() {
	    //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
		return new String[]{"classpath:testdata/common.xml","classpath:testdata/UserInfo.xml",
		                    "classpath:testdata/UserInfo_"+TestMethodContext.getMethodName()+".xml"};
	}
	
	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void findPage() {

		UserInfoQuery query = newUserInfoQuery();
		Page page = dao.findPage(query);
		
		assertEquals(pageNumber,page.getThisPageNumber());
		assertEquals(pageSize,page.getPageSize());
		List resultList = (List)page.getResult();
		assertNotNull(resultList);
		
	}
	
	static int pageNumber = 1;
	static int pageSize = 10;	
	public static UserInfoQuery newUserInfoQuery() {
		UserInfoQuery query = new UserInfoQuery();
		query.setPageNumber(pageNumber);
		query.setPageSize(pageSize);
		query.setSortColumns(null);
		
	  	query.setUsername(new String("1"));
	  	query.setPassword(new String("1"));
		query.setBirthDateBegin(new Date(System.currentTimeMillis()));
		query.setBirthDateEnd(new Date(System.currentTimeMillis()));
	  	query.setSex(new Integer("1"));
	  	query.setAge(new Integer("1"));
		return query;
	}
	
}
