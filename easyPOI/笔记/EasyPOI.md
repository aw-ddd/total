### 一、 EasyPOI介绍

#### 1. 相关注解介绍

```
@Excel 作用到filed上面，是对Excel一个列的描述
@ExcelCollection 表示一个集合，主要针对的是一对多的导出，比如一个老师对应多个科目，科目就可以用集合表示
@ExcelEntity 表示一个继续升入导出的实体，但是他没有多大的意义，只是告诉系统这个对象里面同样有导出的字段
@ExcelIgnore 和名字一样表示这个字段被忽略跳过这个导出
@ExcelTarget 这个是作用于最外层的导出对象，描述这个对象的ID，以便支持一个对象可以针对不同导出做出不同的处理
```

#### 2. 详细注解描述

**@Excel**

```markdown
常用属性：
- name:[String] [生成Excel表格中的列名]
- needMerge:[boolean][是否需要纵合并单元格（用于含有list中，单个的单元格，合并list创建的多个row）]
- orderNum:[String][指定生成Excel中列的顺序，按照数字自然顺序排序]
- savePath:[String][指定导出Excel中图片的保存路径]
- type:[String][导出类型 1 文本 2 图片 3 函数 10 数字 默认是文本]
- width:[Double][指定导出Excel时列的宽度]
- isImportField:[boolean][是否是导出字段，如果没有说明是错误的Excel]
- exportFormat:[String][导出Excel的时间格式]
- importFormat:[String][导入Excel的时间格式]
- format:[String][相当于同时设置了导入导出的时间格式]
- imageType:[int][导出类型 1 从file读取 2 从数据库读取 默认是文件 同样导入也是一样]
- suffix:[String][文字后缀，设置% 90变为90%]
```





### 二、 EasyPOI导出数据

#### 1. 引入Maven依赖

```xml
 <dependencies>
        <dependency>
            <groupId>cn.afterturn</groupId>
            <artifactId>easypoi-base</artifactId>
            <version>4.0.0</version>
        </dependency>
        <dependency>
            <groupId>cn.afterturn</groupId>
            <artifactId>easypoi-web</artifactId>
            <version>4.0.0</version>
        </dependency>
        <dependency>
            <groupId>cn.afterturn</groupId>
            <artifactId>easypoi-annotation</artifactId>
            <version>4.0.0</version>
        </dependency>
    </dependencies>
```

#### 2. 配置需要导出的映射实体类

```java
@Data
@ExcelTarget("goods")
public class Goods {

    @Excel(name="编号")
    private Integer goodsId;
    //orderNum默认为0，数值越大该列越靠前，需要注意的是该值是String类型
    @Excel(name="商品名称" ,orderNum = "1")
    private String goodsName;
    @Excel(name="商品价格" ,orderNum="3",suffix = "元")
    private BigDecimal goodsPrice;
    @Excel(name="商品数量" ,orderNum = "2")
    private Integer goodsNumber;
    @Excel(name="商品重量")
    private Integer goodsWeight;
    @Excel(name="类型ID")
    private Integer catId;
    @Excel(name="商品详情介绍")
    private String goodsIntroduce;
    //replace中的 _ 的前一部分表示替换成的值，后一部分表示需要替换的值
    @Excel(name="热卖数量",replace = {"激活_1000"})
    private Integer hotNumber;
}
```

#### 3. 导出数据

- **获取数据**

```java
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
            goodsList.add(goods);
        }
        return goodsList;
    }
```

- 导出数据

```java
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
```

