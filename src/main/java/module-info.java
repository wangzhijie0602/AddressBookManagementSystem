module club.wangzhijie {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires junit;
    requires org.mapstruct;


    opens club.wangzhijie.view to javafx.fxml;
    exports club.wangzhijie.view;
    exports club.wangzhijie.test;
    exports club.wangzhijie.dao;
    exports club.wangzhijie.dao.impl;
    exports club.wangzhijie.dao.po;
    exports club.wangzhijie.dao.vo;
}