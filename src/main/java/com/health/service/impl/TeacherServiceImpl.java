package com.health.service.impl;

import com.health.model.po.Teacher;
import com.health.service.TeacherService;
import com.health.util.SQLManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

	/*@Autowired
	private TeacherDao teacherdao;*/

    @Autowired
    private SQLManager sqlManager;

    /**
     * 根据ID删除
     */
    public boolean deleteByPrimaryKey(Integer id) {

        return sqlManager.delete("teacher.deleteByPrimaryKey", id) > 0 ? true : false;
    }

    /**
     * 添加教练
     */
    public int insert(Teacher teacher) {

        String no = (sqlManager.count("teacher.count", null) + 1) + "";
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < (8 - no.length()); i++) {
            sb.append("0");
        }
        sb.append(no);
        teacher.setNo(sb.toString());
        return sqlManager.insert("teacher.insert", teacher);
    }

    /**
     * 根据ID查询
     */
    public Teacher selectByPrimaryKey(Integer id) {

        return (Teacher) sqlManager.query("teacher.selectByPrimaryKey", id);
    }

    /**
     * 根据登录ID查询
     */
    public Teacher selectByLoginId(Integer loginId) {

        return (Teacher) sqlManager.query("teacher.selectByLoginId", loginId);
    }

    /**
     * 修改
     */
    public boolean updateByPrimaryKeySelective(Teacher teacher) {

        return sqlManager.update("teacher.updateByPrimaryKeySelective", teacher) > 0 ? true : false;
    }

    /**
     * 获取列表
     */
    public List<Teacher> page(Teacher teacher, Integer page, Integer pageSize) {

        return (List<Teacher>) sqlManager.list("teacher.selectByStr", teacher, page, pageSize);
    }

	public Teacher login(String username, String password) {
		Teacher teacher = new Teacher();
		teacher.setPhone(username);
		teacher.setPassword(password);
		return (Teacher) sqlManager.query("teacher.login", teacher);
	}

}
