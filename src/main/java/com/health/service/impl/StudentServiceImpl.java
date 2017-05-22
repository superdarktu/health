package com.health.service.impl;

import com.health.model.po.Message;
import com.health.model.po.Standard;
import com.health.model.po.Student;
import com.health.model.po.TestData;
import com.health.model.vo.ProgramVO;
import com.health.service.*;
import com.health.util.SQLManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

	/*@Autowired
    private StudentDao studentDao;*/

    @Autowired
    private SQLManager sqlManager;

    @Autowired
    private ProgramService programService;

    @Autowired
    private TestDataService testDataService;

    @Autowired
    private StandardService standardService;

    @Autowired
    private MessageService messageService;

    /**
     * 根据ID删除
     */
    public boolean deleteByPrimaryKey(Integer id) {

        return sqlManager.delete("student.deleteByPrimaryKey", id) > 0 ? true : false;
    }

    /**
     * 添加
     */
    public int insert(Student student) {

        student.setNo(student.getPhone());
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

        return sqlManager.update("student.updateByPrimaryKeySelective", student) > 0 ? true : false;
    }

    /**
     * 分页查询
     */
    public List<Student> page(Student student, Integer page, Integer pageSize) {

        return (List<Student>) sqlManager.list("student.selectByStr", student, page, pageSize);
    }

    @Transactional
    public List<ProgramVO> getProgram(Integer studentId) {

        Student student = selectByPrimaryKey(studentId);
        if (student.getJsfaid() == null) {

            TestData testData = testDataService.queryByStudentLast(studentId);
            Integer age = getAge(student.getAge());
            if (age == 0) return null;
            List<Standard> sds = standardService.selectByAge(age, student.getSex());

            Map<String, Standard> map = new HashMap<String, Standard>();
            for (int i = 0; i < sds.size(); i++) {
                Standard standard = sds.get(i);
                map.put(standard.getName(), standard);
            }

            String no = "";

            no += xiao(map.get("bmi"), testData.getBmi());
            no += da(map.get("pulmonary"), testData.getPulmonary().doubleValue());
            no += da(map.get("tjsy"), testData.getTjsy());
            no += da(map.get("wl"), testData.getWl());
            no += da(map.get("ywqz"), testData.getYwqz().doubleValue());
            no += da(map.get("fwc"), testData.getFwc().doubleValue());
            no += da(map.get("zwtqq"), testData.getZwtqq());

            student.setJsfaid(no);
            update(student);
            Message message = new Message();
            message.setNo(no);
            messageService.insert(message);

            return null;
        }
        String jsid = student.getJsfaid();

        List<ProgramVO> list = programService.selectByNo(jsid);

        return list;
    }

    public Integer getAge(Integer age) {

        if (age > 54) {
            return 0;
        } else if (age > 44) {
            return 4;
        } else if (age > 34) {
            return 3;
        } else if (age > 24) {
            return 2;
        } else if (age > 14) {
            return 1;
        } else {
            return 0;
        }
    }

    public String da(Standard sd, Double fenshu) {
        if (fenshu >= sd.getFive()) {
            return "5";
        } else if (fenshu >= sd.getFour()) {
            return "4";
        } else if (fenshu >= sd.getThree()) {
            return "3";
        } else if (fenshu >= sd.getTwo()) {
            return "2";
        } else if (fenshu >= sd.getOne()) {
            return "1";
        } else {
            return "0";
        }
    }

    public String xiao(Standard sd, Double fenshu) {
        if (fenshu <= sd.getFive()) {
            return "5";
        } else if (fenshu <= sd.getFour()) {
            return "4";
        } else if (fenshu <= sd.getThree()) {
            return "3";
        } else if (fenshu <= sd.getTwo()) {
            return "2";
        } else if (fenshu <= sd.getOne()) {
            return "1";
        } else {
            return "0";
        }
    }

	public Student login(String username, String password) {
		
		Student student  = new Student();
		student.setPhone(username);
		student.setPassword(password);
		return (Student) sqlManager.query("student.login", student);
	}

	public Student findByNo(String no) {
		
		return (Student) sqlManager.query("student.findByNo", no);
	}
}
