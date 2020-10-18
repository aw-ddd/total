package com.dwj.acitviti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 将业务标识BusinessKey值加入Activiti工作流的表中
 */
public class i_AddBusinessKey {
    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = engine.getRuntimeService();
        //启动流程实例
        //第一个参数：流程实例的key值
        //第二个参数：业务标识businesskey
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1", "1001");
        //根据流程实例获取businessKey
        System.out.println("BusinessKey值为：" + processInstance.getBusinessKey());
    }


}
