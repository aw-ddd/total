package com.dwj.acitviti.demo;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;

import java.util.List;

/**
 * 查询历史流程执行信息
 */
public class h_QueryActivitiHistory {
    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        HistoryService historyService = engine.getHistoryService();
        //获取历史流程信息查询器
        HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();
        //设置流程实例的ID（也可以根据流程定义的ID来查询LIst）
        List<HistoricActivityInstance> historyList = historicActivityInstanceQuery
                .processInstanceId("2501")
                .orderByHistoricActivityInstanceStartTime() //根据开始的时间进行排序
                .asc() //升序排序
                .list();
        for (HistoricActivityInstance historicActivityInstance : historyList) {
            System.out.println("历史流程的ID：" + historicActivityInstance.getActivityId());
            System.out.println("历史流程名称：" + historicActivityInstance.getActivityName());
        }
    }
}
