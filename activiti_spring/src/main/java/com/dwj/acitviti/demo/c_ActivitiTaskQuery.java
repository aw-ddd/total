package com.dwj.acitviti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 查询当前正在执行的任务
 */
public class c_ActivitiTaskQuery {
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
