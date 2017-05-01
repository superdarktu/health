package com.health.util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.github.pagehelper.PageHelper;

@Component
public class SQLManager {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	
	/**
	 * 返回列表(不带分页)
	 * @param sqlId
	 * @param data
	 * @return
	 */
	public List<?> list(String sqlId, Object data) {
		
		return this.getSqlSessionTemplate().selectList(sqlId, data);
	}
	
	/**
	 * 返回列表(分页)
	 * @param sqlId
	 * @param data
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<?> list(String sqlId, Object data,Integer page,Integer pageSize) {
		
	//	if(page != null && pageSize != null)
		//	PageHelper.startPage(page, pageSize);
		return this.getSqlSessionTemplate().selectList(sqlId, data);
	}
	
	
	/**
	 * 新增
	 * @param sqlId
	 * @param data
	 * @return
	 */
	public Integer insert(String sqlId, Object data) {
		
		return (Integer) this.getSqlSessionTemplate().insert(sqlId, data);
	}
	
	/**
	 * 修改
	 * @param sqlId
	 * @param data
	 * @return
	 */
	public int update(String sqlId, Object data) {
		
		return this.getSqlSessionTemplate().update(sqlId, data);
	}
	
	/**
	 * 删除
	 * @param sqlId
	 * @param data
	 * @return
	 */
	public int delete(String sqlId, Object data) {
		
		return this.getSqlSessionTemplate().delete(sqlId, data);
	}
	
	/**
	 * 查询总数
	 * @param sqlId
	 * @param data
	 * @return
	 */
	public int count(String sqlId, Object data) {
		
		return (Integer) this.getSqlSessionTemplate().selectOne(sqlId, data);
	}
	
	/**
	 * 返回单条对象
	 * @param sqlId
	 * @param data
	 * @return
	 */
	public Object query(String sqlId,Object data){
		
		return this.getSqlSessionTemplate().selectOne(sqlId, data);
	}
	
	
	
	@Autowired
	public void setSqlMapClientForAutowire(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		
		return this.sqlSessionTemplate.getSqlSessionFactory();
	}
	
	public SqlSession getSqlSession() {
		
		return this.getSqlSessionFactory().openSession();
	}
}
