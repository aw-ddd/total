package com.dwj.acitviti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

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
public class d_ActivitiCompleteTask {
    public static void main(String[] args) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = engine.getTaskService();
        //直接输入任务的ID即可以对应的任务
        taskService.complete("15005");
    }
}
