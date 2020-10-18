package com.dwj.acitviti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 保存流程控制文件到本地
 */
public class g_SaveBpmnFile {
    public static void main(String[] args) throws IOException {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = engine.getRepositoryService();
        ProcessDefinitionQuery definitionQuery = repositoryService.createProcessDefinitionQuery();
        //获取查询器
        ProcessDefinition processDefinition = definitionQuery.singleResult();
        //获取流程部署ID
        String deploymentId = processDefinition.getDeploymentId();
        //获取图片的输入流
        InputStream pngIs = repositoryService.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        //获取bpmn文件的输入流
        InputStream bpmnIs = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());

        //获取图片的输出流
        FileOutputStream pngOut = new FileOutputStream("C:\\Users\\28043\\Desktop\\" + processDefinition.getDiagramResourceName());
        //获取BPMN文件的输出流
        FileOutputStream bpmnOut = new FileOutputStream("C:\\Users\\28043\\Desktop\\" + processDefinition.getResourceName());
        //进行读写操作
        IOUtils.copy(pngIs,pngOut);
        IOUtils.copy(bpmnIs,bpmnOut);
        //关流
        pngIs.close();
        bpmnIs.close();
        pngOut.close();
        bpmnOut.close();
    }


}
