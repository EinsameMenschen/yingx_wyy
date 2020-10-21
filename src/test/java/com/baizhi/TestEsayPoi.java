package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.Person;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import com.baizhi.util.AliyunOssUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TestEsayPoi
 * @Author wyy
 * @Date 2020/9/2 16:59
 * @Description TOOO
 */
public class TestEsayPoi {
    /*@Test
    public void testExport() throws Exception{
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("1", "小黄", "123", new Date()));
        list.add(new Student("2", "小刘", "123", new Date()));
        list.add(new Student("3", "小黑", "123", new Date()));
        list.add(new Student("4", "小张", "123", new Date()));

        //参数：标题，表名，实体类类对象，导出的集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),Student.class, list);

        workbook.write(new FileOutputStream(new File("D:/2003班.xls")));
        workbook.close();
    }

    @Test
    public void testTeacher() throws Exception{
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("1", "小黄", "123", new Date()));
        list.add(new Student("2", "小刘", "123", new Date()));
        list.add(new Student("3", "小黑", "123", new Date()));
        list.add(new Student("4", "小张", "123", new Date()));
        List<Teacher> list1 = new ArrayList<>();
        list1.add(new Teacher("111","王老师",list));
        list1.add(new Teacher("222","刘老师",list));
        //参数：标题，表名，实体类类对象，导出的集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机系老师","老师"),Teacher.class, list1);

        workbook.write(new FileOutputStream(new File("D:/2003班.xls")));
        workbook.close();
    }

    @Test
    public void testPhoto() throws Exception{
        List<Person> list = new ArrayList<>();
        list.add(new Person("1","张三","D:\\image\\3.jpg"));
        list.add(new Person("2","李四","D:\\image\\cc.jpg"));
        list.add(new Person("3","哈哈","D:\\image\\fj.jpg"));
        //参数：标题，表名，实体类类对象，导出的集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息","用户"),Person.class, list);

        workbook.write(new FileOutputStream(new File("D:/用户.xls")));
        workbook.close();
    }


    @Test
    public void testPhoto2() throws Exception{
        List<Person> list = new ArrayList<>();
        list.add(new Person("1","小白","https://yingx-wyy.oss-cn-beijing.aliyuncs.com/photo/1598629477478-fj.jpg"));
        list.add(new Person("2","小黑","https://yingx-wyy.oss-cn-beijing.aliyuncs.com/photo/1598629477478-fj.jpg"));
        list.add(new Person("3","小兰","https://yingx-wyy.oss-cn-beijing.aliyuncs.com/photo/1598629477478-fj.jpg"));

        ArrayList<Person> list1 = new ArrayList<>();
        //网络图片下载到本地   将本地图片导出
        for (Person p:list){
            String[] split = p.getHeadImg().split("/");
            String fileName=split[4];
            String filePath="D:\\image\\"+fileName;
            AliyunOssUtil.testDownload("photo/"+fileName,filePath);
            p.setHeadImg(filePath);
            list1.add(p);
        }

        //参数：标题，表名，实体类类对象，导出的集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息","用户"),Person.class, list1);

        workbook.write(new FileOutputStream(new File("D:/用户2.xls")));
        workbook.close();
    }

    @Test
    public void testEsayPoiIn(){
        //配置导入的相关参数
        ImportParams params = new ImportParams();
        params.setTitleRows(1);//表格标题行数
        params.setHeadRows(1);//表头所占行
        try {
            FileInputStream stream=new FileInputStream(new File("D:/用户.xls"));
            List<Person> list = ExcelImportUtil.importExcel(stream, Person.class, params);
            list.forEach(person-> System.out.println(person));
            //批量入库
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     */






}
