/*
package com.waterpro.service.report;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.waterpro.domain.device.Group;
import com.waterpro.domain.device.Groups;
import com.waterpro.domain.device.Wisedata;
import com.waterpro.domain.report.*;
import com.waterpro.repository.quality.GroupRepository;
import com.waterpro.repository.quality.GroupsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MonitorService {

    @Resource
    private QualitysService qualitysService;

    @Resource
    private SlopesPumpService slopesPumpService;

    @Resource
    private Pump1Service pump1Service;

    @Resource
    private Pump2Service pump2Service;

    @Resource
    private Pump3Service pump3Service;

    @Resource
    private Pump4Service pump4Service;

    @Resource
    private Pump5Service pump5Service;

    @Resource
    private Pump6Service pump6Service;

    @Resource
    private Transducer1Service transducer1Service;

    @Resource
    private Transducer2Service transducer2Service;

    @Resource
    private Transducer3Service transducer3Service;

    @Resource
    private Transducer4Service transducer4Service;

    @Resource
    private Transducer5Service transducer5Service;

    @Resource
    private Transducer6Service transducer6Service;

    @Resource
    private BoxService boxService;

    @Resource
    private PipeService pipeService;

    @Resource
    private SystemsService systemsService;

    @Resource
    private GroupsRepository groupsRepository;

    @Resource
    private GroupRepository groupRepository;

    public JSONArray getHuanjingValue(String dateStr, Wisedata model) {
        JSONArray array = new JSONArray();
        JSONObject show = isShow(model);
        JSONObject object1 = new JSONObject();
        object1.put("have", show.get("shuizhi"));
        object1.put("data", qualitysService.countQualitys(dateStr, model));
        array.add(object1);
        JSONObject object2 = new JSONObject();
        object2.put("have", show.get("paiwu"));
        object2.put("data", slopesPumpService.countSlopesPump(dateStr, model));
        array.add(object2);
        return array;
    }

    public JSONArray getJizuValue(String dateStr, Wisedata model) {
        JSONArray array = new JSONArray();
        JSONObject object1 = new JSONObject();
        JSONObject show = isShowJizu(model);
        //水泵0-5
        object1.put("have", show.get("ch0"));
        object1.put("data", pump1Service.countPump1(dateStr, model));
        array.add(object1);
        JSONObject object2 = new JSONObject();
        object2.put("have", show.get("ch1"));
        object2.put("data", pump2Service.countPump2(dateStr, model));
        array.add(object2);
        JSONObject object3 = new JSONObject();
        object3.put("have", show.get("ch2"));
        object3.put("data", pump3Service.countPump3(dateStr, model));
        array.add(object3);
        JSONObject object4 = new JSONObject();
        object4.put("have", show.get("ch3"));
        object4.put("data", pump4Service.countPump4(dateStr, model));
        array.add(object4);
        JSONObject object5 = new JSONObject();
        object5.put("have", show.get("ch4"));
        object5.put("data", pump5Service.countPump5(dateStr, model));
        array.add(object5);
        JSONObject object6 = new JSONObject();
        object6.put("have", show.get("ch5"));
        object6.put("data", pump6Service.countPump6(dateStr, model));
        array.add(object6);
        //变频器1-6
        JSONObject object9 = new JSONObject();
        object9.put("have", show.get("ch6"));
        object9.put("data", transducer1Service.countTransducer1(dateStr, model));
        array.add(object9);
        JSONObject object10 = new JSONObject();
        object10.put("have", show.get("ch7"));
        object10.put("data", transducer2Service.countTransducer2(dateStr, model));
        array.add(object10);
        JSONObject object11 = new JSONObject();
        object11.put("have", show.get("ch8"));
        object11.put("data", transducer3Service.countTransducer3(dateStr, model));
        array.add(object11);
        JSONObject object12 = new JSONObject();
        object12.put("have", show.get("ch9"));
        object12.put("data", transducer4Service.countTransducer4(dateStr, model));
        array.add(object12);
        JSONObject object13 = new JSONObject();
        object13.put("have", show.get("ch10"));
        object13.put("data", transducer5Service.countTransducer5(dateStr, model));
        array.add(object13);
        JSONObject object14 = new JSONObject();
        object14.put("have", show.get("ch11"));
        object14.put("data", transducer6Service.countTransducer6(dateStr, model));
        array.add(object14);
        //系统
        JSONObject object15 = new JSONObject();
        object15.put("have", show.get("ch12"));
        object15.put("data", systemsService.countSystems(dateStr, model));
        array.add(object15);
        //水箱
        JSONObject object7 = new JSONObject();
        object7.put("have", show.get("ch13"));
        object7.put("data", boxService.countBox(dateStr, model));
        array.add(object7);
        //管道
        JSONObject object8 = new JSONObject();
        object8.put("have", show.get("ch14"));
        object8.put("data", pipeService.countPipe(dateStr, model));
        array.add(object8);
        //能耗
        JSONObject object22 = new JSONObject();
        object22.put("have", show.get("ch15"));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(systemsService.getEconsumption(dateStr, model));
        stringBuffer.append(",");
        stringBuffer.append(pipeService.getTachometerAll(dateStr, model));
        object22.put("data", stringBuffer.toString());
        array.add(object22);
        //水泵运行时间
        JSONObject object16 = new JSONObject();
        object16.put("have", show.get("ch0"));
        object16.put("data", pump1Service.countTime(dateStr, model));
        array.add(object16);
        JSONObject object17 = new JSONObject();
        object17.put("have", show.get("ch1"));
        object17.put("data", pump2Service.countTime(dateStr, model));
        array.add(object17);
        JSONObject object18 = new JSONObject();
        object18.put("have", show.get("ch2"));
        object18.put("data", pump3Service.countTime(dateStr, model));
        array.add(object18);
        JSONObject object19 = new JSONObject();
        object19.put("have", show.get("ch3"));
        object19.put("data", pump4Service.countTime(dateStr, model));
        array.add(object19);
        JSONObject object20 = new JSONObject();
        object20.put("have", show.get("ch4"));
        object20.put("data", pump5Service.countTime(dateStr, model));
        array.add(object20);
        JSONObject object21 = new JSONObject();
        object21.put("have", show.get("ch5"));
        object21.put("data", pump6Service.countTime(dateStr, model));
        array.add(object21);

        return array;
    }

    public JSONObject isShowJizu(Wisedata model) {
        JSONObject object = new JSONObject();
        //是否显示
        String groupStr = "group_jizu_" + model.getUsername() + "_" + model.getPumpid();
        Groups groups = groupsRepository.findGroupsList(groupStr);
        if (!groups.getPump1().equals("无")) {
            object.put("ch0", 1);
        } else {
            object.put("ch0", 0);
        }
        if (!groups.getPump2().equals("无")) {
            object.put("ch1", 1);
        } else {
            object.put("ch1", 0);
        }
        if (!groups.getPump3().equals("无")) {
            object.put("ch2", 1);
        } else {
            object.put("ch2", 0);
        }
        if (!groups.getPump4().equals("无")) {
            object.put("ch3", 1);
        } else {
            object.put("ch3", 0);
        }
        if (!groups.getPump5().equals("无")) {
            object.put("ch4", 1);
        } else {
            object.put("ch4", 0);
        }
        if (!groups.getPump6().equals("无")) {
            object.put("ch5", 1);
        } else {
            object.put("ch5", 0);
        }
        if (!groups.getInverter1().equals("无")) {
            object.put("ch6", 1);
        } else {
            object.put("ch6", 0);
        }
        if (!groups.getInverter2().equals("无")) {
            object.put("ch7", 1);
        } else {
            object.put("ch7", 0);
        }
        if (!groups.getInverter3().equals("无")) {
            object.put("ch8", 1);
        } else {
            object.put("ch8", 0);
        }
        if (!groups.getInverter4().equals("无")) {
            object.put("ch9", 1);
        } else {
            object.put("ch9", 0);
        }
        if (!groups.getInverter5().equals("无")) {
            object.put("ch10", 1);
        } else {
            object.put("ch10", 0);
        }
        if (!groups.getInverter6().equals("无")) {
            object.put("ch11", 1);
        } else {
            object.put("ch11", 0);
        }
        if (!groups.getSystem().equals("无")) {
            object.put("ch12", 1);
            object.put("ch15", 1);
        } else {
            object.put("ch12", 0);
            object.put("ch15", 0);
        }
        if (!groups.getWatertank().equals("无")) {
            object.put("ch13", 1);
        } else {
            object.put("ch13", 0);
        }
        if (!groups.getPipe().equals("无")) {
            object.put("ch14", 1);
        } else {
            object.put("ch14", 0);
        }
        int a = (int) object.get("ch0");
        int b = (int) object.get("ch1");
        int c = (int) object.get("ch2");
        int d = (int) object.get("ch3");
        int e = (int) object.get("ch4");
        int f = (int) object.get("ch5");
        if (a == 0 && b == 0 && c == 0 && d == 0 && e == 0 && f == 0) {
            object.put("ch16", 0);
        } else {
            object.put("ch16", 1);
        }
        return object;
    }

    public JSONObject isShow(Wisedata model) {
        JSONObject object = new JSONObject();
        //是否显示
        String groupStr = "group_huanjing_" + model.getUsername() + "_" + model.getPumpid();
        List<Group> group = groupRepository.findGroupList(groupStr);
        for (Group temp : group) {
            if (temp.getHuanjingname().equals(model.getHuanjingname())) {
                if (temp.getPaiwubeng() != null) {
                    object.put("paiwu", 1);
                } else {
                    object.put("paiwu", 0);
                }
                if (temp.getShuizhi() != null) {
                    object.put("shuizhi", 1);
                } else {
                    object.put("shuizhi", 0);
                }
            }
        }
        return object;
    }

    public List<Qualitys> avgQualitys(String month, Wisedata model) {
        return qualitysService.avgs(month, model);
    }

    public List<SlopesPump> avgSlopesPump(String month, Wisedata model) {
        return slopesPumpService.avgs(month, model);
    }

    public List<Pump1> avgPump1(String month, Wisedata model) {
        return pump1Service.avgs(month, model);
    }

    public List<Pump2> avgPump2(String month, Wisedata model) {
        return pump2Service.avgs(month, model);
    }

    public List<Pump3> avgPump3(String month, Wisedata model) {
        return pump3Service.avgs(month, model);
    }

    public List<Pump4> avgPump4(String month, Wisedata model) {
        return pump4Service.avgs(month, model);
    }

    public List<Pump5> avgPump5(String month, Wisedata model) {
        return pump5Service.avgs(month, model);
    }

    public List<Pump6> avgPump6(String month, Wisedata model) {
        return pump6Service.avgs(month, model);
    }

    public List<Transducer1> avgTransducer1(String month, Wisedata model) {
        return transducer1Service.avgs(month, model);
    }

    public List<Transducer2> avgTransducer2(String month, Wisedata model) {
        return transducer2Service.avgs(month, model);
    }

    public List<Transducer3> avgTransducer3(String month, Wisedata model) {
        return transducer3Service.avgs(month, model);
    }

    public List<Transducer4> avgTransducer4(String month, Wisedata model) {
        return transducer4Service.avgs(month, model);
    }

    public List<Transducer5> avgTransducer5(String month, Wisedata model) {
        return transducer5Service.avgs(month, model);
    }

    public List<Transducer6> avgTransducer6(String month, Wisedata model) {
        return transducer6Service.avgs(month, model);
    }

    public List<Systems> avgSystems(String month, Wisedata model) {
        return systemsService.avgs(month, model);
    }

    public List<Box> avgBox(String month, Wisedata model) {
        return boxService.avgs(month, model);
    }

    public List<Pipe> avgPipe(String month, Wisedata model) {
        return pipeService.avgs(month, model);
    }

    public JSONObject avgElec(String month, Wisedata model) {
        String a = systemsService.getEconsumptionMonth(month, model);
        String b = pipeService.getTachometerMonth(month, model);
        String c = a + ";" + b;
        JSONObject object = new JSONObject();
        object.put("data", c);
        return object;
    }

    public String avgPump1RunTime(String month, Wisedata model) {
        StringBuffer stringBuffer = new StringBuffer();
        List<Pump1> list = pump1Service.runTimeMonth(month, model);
        if (list.size() != 0) {
            if (list.get(0).getInverterTime() != null && list.get(list.size() - 1).getInverterTime() != null) {
                Double a = list.get(list.size() - 1).getInverterTime() - list.get(0).getInverterTime();
                stringBuffer.append(a);
            }
        }
        return stringBuffer.toString();
    }

    public String avgPump2RunTime(String month, Wisedata model) {
        StringBuffer stringBuffer = new StringBuffer();
        List<Pump2> list = pump2Service.runTimeMonth(month, model);
        if (list.size() != 0) {
            if (list.get(0).getInverterTime() != null && list.get(list.size() - 1).getInverterTime() != null) {
                Double a = list.get(list.size() - 1).getInverterTime() - list.get(0).getInverterTime();
                stringBuffer.append(a);
            }
        }
        return stringBuffer.toString();
    }

    public String avgPump3RunTime(String month, Wisedata model) {
        StringBuffer stringBuffer = new StringBuffer();
        List<Pump3> list = pump3Service.runTimeMonth(month, model);
        if (list.size() != 0) {
            if (list.get(0).getInverterTime() != null && list.get(list.size() - 1).getInverterTime() != null) {
                Double a = list.get(list.size() - 1).getInverterTime() - list.get(0).getInverterTime();
                stringBuffer.append(a);
            }
        }
        return stringBuffer.toString();
    }

    public String avgPump4RunTime(String month, Wisedata model) {
        StringBuffer stringBuffer = new StringBuffer();
        List<Pump4> list = pump4Service.runTimeMonth(month, model);
        if (list.size() != 0) {
            if (list.get(0).getInverterTime() != null && list.get(list.size() - 1).getInverterTime() != null) {
                Double a = list.get(list.size() - 1).getInverterTime() - list.get(0).getInverterTime();
                stringBuffer.append(a);
            }
        }
        return stringBuffer.toString();
    }

    public String avgPump5RunTime(String month, Wisedata model) {
        StringBuffer stringBuffer = new StringBuffer();
        List<Pump5> list = pump5Service.runTimeMonth(month, model);
        if (list.size() != 0) {
            if (list.get(0).getInverterTime() != null && list.get(list.size() - 1).getInverterTime() != null) {
                Double a = list.get(list.size() - 1).getInverterTime() - list.get(0).getInverterTime();
                stringBuffer.append(a);
            }
        }
        return stringBuffer.toString();
    }

    public String avgPump6RunTime(String month, Wisedata model) {
        StringBuffer stringBuffer = new StringBuffer();
        List<Pump6> list = pump6Service.runTimeMonth(month, model);
        if (list.size() != 0) {
            if (list.get(0).getInverterTime() != null && list.get(list.size() - 1).getInverterTime() != null) {
                Double a = list.get(list.size() - 1).getInverterTime() - list.get(0).getInverterTime();
                stringBuffer.append(a);
            }
        }
        return stringBuffer.toString();
    }
}
*/
