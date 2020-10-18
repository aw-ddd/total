package com.dwj.acitviti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * 操作流程定义为挂起状态，该流程定义下边的流程实例则全部暂停
 * 流程定义为挂起状态该流程定义将不允许启动新的流程实例，同时该流程定义下的所有流程实例将全部挂起暂停执行
 */
public class j_StopProcessDefinition {
    public static void main(String[] args) {
        String processDefinitionId = "";
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = engine.getRepositoryService();
        //获取流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .singleResult();
        processDefinitionId = processDefinition.getId();
        //获取当前流程定义的实例是否都为暂停状态
        boolean suspended = processDefinition.isSuspended();
        //判断
        if (suspended){
            //如果是暂停状态，则可以进行激活操作
            repositoryService.activateProcessDefinitionById(processDefinitionId,true,null);
            System.out.println("流程定义ID为："+processDefinitionId+"被激活");
        }else {
            //如果处于激活状态则进行挂起操作
            repositoryService.suspendProcessDefinitionById(processDefinitionId,true,null);
            System.out.println("流程定义ID为："+processDefinitionId+"被挂起");
        }
    }
}
