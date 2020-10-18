package com.dwj.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class Test1 {

    /**
     * 测试使用Activiti工作流创建所需要的25张表
     */
    @Test
    public void test(){
        //创建ProcessEngine引擎
        ProcessEngineConfiguration processEngineConfigurationFromResource = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //创建ProcessEngine对象
        ProcessEngine engine = processEngineConfigurationFromResource.buildProcessEngine();
        System.out.println(engine);
    }

}
