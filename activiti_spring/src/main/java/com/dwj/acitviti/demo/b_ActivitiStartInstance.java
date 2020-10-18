package com.dwj.acitviti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 启动流程实例（前提是已经定义好了流程部署）
 *
 * 背后影响的表
 * act_hi_actinst 已完成的活动信息
 * act_hi_identitylink 参与者信息
 * act_hi_procinst 流程实例
 * act_hi_taskinst 任务实例
 * act_ru_execution 执行表
 * act_ru_identitylink 参与者信息
 * act_ru_task 任务
 */
public class b_ActivitiStartInstance {

    public static void main(String[] args) {

        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = engine.getRuntimeService();
        //启动流程实例
        ProcessInstance holiday = runtimeService.startProcessInstanceByKey("myProcess_1");

        //输出实例相关的一些信息
        System.out.println("流程部署的ID"+holiday.getDeploymentId());
        System.out.println("流程定义的ID"+holiday.getProcessDefinitionId());
        System.out.println("流程实例的ID"+holiday.getId());
        System.out.println("活动的ID"+holiday.getActivityId());
    }
}
