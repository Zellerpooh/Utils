package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DaoMaker {
    public static void main(String[] args) throws Exception {

        /**
         * 生成数据库的实体类XXentity对应的是数据库的表
         */
        Schema schema = new Schema(1, "com.student.entity");
        addStudent(schema);
        schema.setDefaultJavaPackageDao("com.student.dao");
        try {
            new DaoGenerator().generateAll(schema,"/Users/Zellerpooh/AndroidStudioProjects/Utils/greendaodemo/src/main/java-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void addStudent(Schema schema){
        Entity entity=schema.addEntity("Student");//创建数据库的表
        entity.addIdProperty();  //主键是ID int类型
        entity.addStringProperty("name");
        entity.addStringProperty("address");
        entity.addIntProperty("age");
    }
}
