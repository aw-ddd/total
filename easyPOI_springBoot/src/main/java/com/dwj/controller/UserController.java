package com.dwj.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.dwj.entity.User;
import com.dwj.sevice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("findAll")
    public String findAll(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "index";
    }

    @GetMapping("export")
    public String export() {
        List<User> userList = userService.findAll();
        ExportParams exportParams = new ExportParams();
        Workbook workbook = null;
        FileOutputStream outputStream = null;
        try {
            workbook = ExcelExportUtil.exportExcel(exportParams, User.class, userList);
            outputStream = new FileOutputStream("C:\\Users\\28043\\Desktop\\test.xls");
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "index";
    }

    //导入文件
    @PostMapping("imp")
    //注意此处的形参名必须要与前端传过来的参数的key完全相同，否则会出现空指针异常
    public String imp(MultipartFile excelFile){
        log.info("文件名：[{}]",excelFile.getOriginalFilename());
        ImportParams params = new ImportParams();
        List<User> userList = null;
        try {
             userList = ExcelImportUtil.importExcel(excelFile.getInputStream(), User.class, params);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (userList.size() <= 0 || userList == null){
            throw new IllegalArgumentException("参数异常");
        }
        userService.saveExcel(userList);
        return "redirect:/user/findAll";//上传成功之后重定向到原查询页面
    }
}
