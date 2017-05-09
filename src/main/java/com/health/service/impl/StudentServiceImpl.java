package com.health.service.impl;

import java.util.List;

import com.health.model.po.TestData;
import com.health.model.vo.ProgramVO;
import com.health.service.ProgramService;
import com.health.service.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.po.Student;
import com.health.service.StudentService;
import com.health.util.SQLManager;

@Service
public class StudentServiceImpl implements StudentService{

	/*@Autowired
	private StudentDao studentDao;*/
	
	@Autowired
   	private SQLManager sqlManager;

	@Autowired
	private ProgramService programService;

	@Autowired
	private TestDataService testDataService;
	
	/**
	 * 根据ID删除
	 */
	public boolean deleteByPrimaryKey(Integer id) {
		
		return sqlManager.delete("student.deleteByPrimaryKey", id) > 0 ? true :false;
	}

	/**
	 * 添加
	 */
	public int insert(Student student) {
		
		String no = (sqlManager.count("student.count", null)+1)+"";
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<(8-no.length());i++){
			sb.append("0");
		}
		sb.append(no);
		student.setNo(sb.toString());
		return sqlManager.insert("student.insert", student);
	}

	/**
	 * 根据ID查询
	 */
	public Student selectByPrimaryKey(Integer id) {
		
		return (Student) sqlManager.query("student.selectByPrimaryKey", id);
	}
	
	/**
	 * 根据ID查询
	 */
	public Student selectByLoginId(Integer loginId) {
		
		return (Student) sqlManager.query("student.selectByLoginId", loginId);
	}

	/**
	 * 修改
	 */
	public boolean update(Student student) {
		
		return sqlManager.update("student.updateByPrimaryKeySelective", student) > 0 ? true :false;
	}
	
	/**
	 * 分页查询
	 */
	public List<Student> page(Student student, Integer page, Integer pageSize) {
		
		return (List<Student>) sqlManager.list("student.selectByStr", student, page, pageSize);
	}

	public List<ProgramVO> getProgram(Integer studentId) {

		Student student = selectByPrimaryKey(studentId);
		if(student.getJsfaid() == null){

			TestData testData = testDataService.queryByStudentLast(studentId);
			return null;
		}
		String jsid = student.getJsfaid();

		List<ProgramVO> list = programService.selectByNo(jsid);

		return list;
	}
}
