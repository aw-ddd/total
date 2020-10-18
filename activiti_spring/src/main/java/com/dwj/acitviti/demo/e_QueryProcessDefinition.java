package com.dwj.acitviti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * 查询流程定义信息
 */
public class e_QueryProcessDefinition {
    public static void main(String[] args) {
        //获取ProcessEngine对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        //获取repositoryService对象
        RepositoryService repositoryService = engine.getRepositoryService();
        //获取流程定义查询器
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> holiday = processDefinitionQuery.processDefinitionKey("myProcess_1")
                .orderByProcessDefinitionVersion()//根据流程定义版本
                .desc()//降序排列
                .list();
        for (ProcessDefinition processDefinition : holiday) {
            System.out.println("流程定义ID"+processDefinition.getId());
            System.out.println("流程定义名称"+processDefinition.getName());
            System.out.println("流程定义的KEY" + processDefinition.getKey());
            System.out.println("流程定义的版本号" + processDefinition.getVersion());
            System.out.println("引擎版本号"+processDefinition.getEngineVersion());
        }
    }
}
