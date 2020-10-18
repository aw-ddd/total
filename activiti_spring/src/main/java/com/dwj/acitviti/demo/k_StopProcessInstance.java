package com.dwj.acitviti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;

/**
 * 挂起单个流程实例
 */
public class k_StopProcessInstance {
    public static void main(String[] args) {
        String processInstanceId = "";
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = engine.getRuntimeService();
        //获取流程实例查询器
        ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();
        //获取流程实例
        ProcessInstance processInstance = processInstanceQuery.processInstanceId("15001").singleResult();
        //获取ProcessInstance实例的id
        processInstanceId  = processInstance.getId();
        //获取当前实例的暂停状态
        boolean suspended = processInstance.isSuspended();
        if (suspended){
            //如果处于挂起状态，则可以进行激活
            runtimeService.activateProcessInstanceById(processInstance.getId());
            System.out.println("激活实例Id为"+processInstanceId+"的流程");
        }else {
            //如果处于激活状态则可以进行挂起
            runtimeService.suspendProcessInstanceById(processInstance.getId());
            System.out.println("挂起实例Id为"+processInstanceId+"的流程");

        }


    }
}
