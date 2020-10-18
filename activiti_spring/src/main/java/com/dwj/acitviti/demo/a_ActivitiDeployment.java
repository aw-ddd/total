package com.dwj.acitviti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * 流程定义部署
 * 背后影响的表
 * act_re_deployment
 * act_re_procdef
 * act_ge_bytearray
 */
public class a_ActivitiDeployment {
    public static void main(String[] args) {
        //获取ProcessEngine对象
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        //获取repositoryService对象
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
        //部署
        Deployment deploy = repositoryService.createDeployment().addClasspathResource("diagram/holiday.bpmn")
                .addClasspathResource("diagram/holiday.png")
                .name("请假申请流程")
                .key("holiday")
                .deploy();
        //获取一些信息
        String name = deploy.getName();
        String id = deploy.getId();
        System.out.println(name);
        System.out.println(id);

    }
}
