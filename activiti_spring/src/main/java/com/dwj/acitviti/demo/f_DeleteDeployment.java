package com.dwj.acitviti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**注意事项：当我们正在执行的流程未完全执行结束，那么该流程部署信息删除无法成功
 * 删除流程部署信息
 */
public class f_DeleteDeployment {
    public static void main(String[] args) {
        //获取ProcessEngine对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        //获取repositoryService对象
        RepositoryService repositoryService = engine.getRepositoryService();
        //获取到所有的流程部署信息
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition processDefinition : list) {
            //删除所有的流程部署信息
            repositoryService.deleteDeployment(processDefinition.getDeploymentId());
        }
    }
}
