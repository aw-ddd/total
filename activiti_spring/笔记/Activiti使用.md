### 一、Activiti使用步骤

#### 1. 引入Acitviti相关依赖

```xml
 <dependency>
            <groupId>org.activiti</groupId>
            <artifactId>activiti-engine</artifactId>
            <version>7.0.0.Beta1</version>
        </dependency>
        <dependency>
            <groupId>org.activiti</groupId>
            <artifactId>activiti-spring</artifactId>
            <version>7.0.0.Beta1</version>
        </dependency>
        <dependency>
            <groupId>org.activiti</groupId>
            <artifactId>activiti-bpmn-model</artifactId>
            <version>7.0.0.Beta1</version>
        </dependency>

        <dependency>
            <groupId>org.activiti</groupId>
            <artifactId>activiti-bpmn-converter</artifactId>
            <version>7.0.0.Beta1</version>
        </dependency>
        <dependency>
            <groupId>org.activiti</groupId>
            <artifactId>activiti-json-converter</artifactId>
            <version>7.0.0.Beta1</version>
        </dependency>
        <dependency>
            <groupId>org.activiti</groupId>
            <artifactId>activiti-bpmn-layout</artifactId>
            <version>7.0.0.Beta1</version>
        </dependency>
        <dependency>
            <groupId>org.activiti.cloud</groupId>
            <artifactId>activiti-cloud-services-api</artifactId>
            <version>7.0.0.Beta1</version>
        </dependency>
```

#### 2. 引入activiti配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:tx="http://www.springframework.org/schema/tx"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd">


    <!--数据源配置-->
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/activiti?serverTimezone=UTC"/>
        <property name="username" value="root"/>
        <property name="password" value="root"/>
    </bean>

    <!--Activiti单独运行的ProcessEngine-->
    <bean id="processEngineConfiguration" class="org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration">
        <property name="dataSource" ref="dataSource"></property>
        <property name="databaseSchemaUpdate" value="true"></property>
    </bean>



</beans>
```

#### 3. 画流程图

![流程图](D:\total\activiti_spring\笔记\流程图.png)

#### 4. 使用Java生成工作流所需要的所有表

```java
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
```

#### 5. 流程定义部署

```java
/**
 * 流程定义部署
 * 背后影响的表
 * act_re_deployment
 * act_re_procdef
 * act_ge_bytearray
 */
public class ActivitiDeployment {
    public static void main(String[] args) {
        //获取ProcessEngine对象
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        //获取repositoryService对象
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
        //部署
        Deployment deploy = repositoryService.createDeployment().addClasspathResource("diagram/holiday.bpmn")
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

```

#### 6. 启动流程实例

```java
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
public class ActivitiStartInstance {

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
```

#### 7. 查询当前正在执行的任务

```java
/**
 * 查询当前正在执行的任务
 */
public class ActivitiTaskQuery {
    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("myProcess_1")
                .list();
        for (Task task : taskList) {
            System.out.println("流程实例ID:"+task.getProcessInstanceId());
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务负责人:" + task.getAssignee());
            System.out.println("任务名称:" + task.getName());
        }
    }
}
```

#### 8. 执行任务

```java
/**
 * 执行任务
 *
 * 背后操作的表
 * act_hi_actinst 执行的任务节点的信息
 * act_hi_identitylink
 * act_hi_taskinst 执行的任务实例
 * act_ru_execution
 * act_ru_identitylink
 * act_ru_task 此时正在执行的任务
 */
public class ActivitiCompleteTask {
    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        //直接输入任务的ID即可以对应的任务
        taskService.complete("7502");
    }
}
```

### 二、Activiti介绍

#### 1.Activiti的一些类介绍

```
ProcessEngineConfigure类：主要使用来加载activiti.cfg.xml配置文件
ProcessEngines类：主要是帮助我们可以快速的得到各个的Service接口
Service接口：可以帮助我们快速操作数据库中的各个表
```

#### 2.流程定义与流程实例之间的关系

![流程定义与流程实例的关系](D:\total\activiti_spring\笔记\流程定义与流程实例的关系.png)

### 补充：Activiti使用过程中遇到的一些问题

- 在创建流程实例过程中使用在进行流程定义部署的中命名的key来作为启动流程实例的key是不对的。应该使用act_re_procdef中设置的key_字段的值

```
流程实例id是act_ru_execution表的PROC_INST_ID_
流程定义的key是act_re_procdef表的KEY_
```