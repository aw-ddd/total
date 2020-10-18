package com.dwj.test;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.dwj.entity.Card;
import com.dwj.entity.Emp;
import com.dwj.entity.Goods;
import com.dwj.entity.Order;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EasyPoiTest {

    public List<Goods> getGoods(){
        List<Goods> goodsList = new ArrayList<Goods>();
        for (int i = 0; i < 10; i++) {
            Goods goods = new Goods();
            goods.setGoodsId(i+1);
            goods.setGoodsName("香蕉"+i);
            goods.setGoodsPrice(new BigDecimal(1000));
            goods.setGoodsWeight(100);
            goods.setCatId(i);
            goods.setGoodsIntroduce("hahhahahahhah");
            goods.setHotNumber(i+1000);

            //爱好（一列展示多条数据）
            if (i%2 == 0){
                goods.setHobby(Arrays.asList("篮球","足球","乒乓球"));
            }else {
                goods.setHobby(Arrays.asList("高尔夫","桌球","排球"));
            }

            //身份证（一对一导出）
            Card card = new Card();
            card.setNo("817328163276123132");
            card.setAddress("安徽合肥");
            goods.setCard(card);

            //订单（一对多导出）
            List<Order> orders = new ArrayList<Order>();
            orders.add(new Order("100","连衣裙"));
            orders.add(new Order("101","超短连衣裙"));
            orders.add(new Order("102","超长连衣裙"));
            goods.setOrderList(orders);

            //导出图片
            goods.setPhoto("C:\\Users\\28043\\Desktop\\111.png");
            goodsList.add(goods);
        }
        return goodsList;
    }


    //测试EasyPOI导出功能
    @Test
    public void test1 () throws IOException {
        //获取数据
        List<Goods> goodsList = getGoods();
        //参数1：配置xls文件配置对象 参数2：Excel行对应的实体类的class 参数3：数据源
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("商品列表", "所有商品"), Goods.class, goodsList);
        //aaa.xls文件已存在，则导出的数据会覆盖原来的数据
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\28043\\Desktop\\aaa.xls");
        workbook.write(outputStream);
        //关闭流
        outputStream.close();
        workbook.close();
    }

    //测试EasyPOI的导入功能
    @Test
    public void test2() throws Exception {
        //导入文件的绝对路径
        FileInputStream fileInputStream = new FileInputStream("D:\\total\\easyPOI\\src\\main\\resources\\11.xls");
        //导入文件的一些配置参数
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        List<Emp> empList = ExcelImportUtil.importExcel(fileInputStream, Emp.class, params);
        empList.forEach(System.out::println);

    }
}

