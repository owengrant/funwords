/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module owen.funwords {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.media;
    requires com.jfoenix;
    requires java.logging;
    
    exports owen.funwords;
    opens owen.funwords;
    opens owen.funwords.controller;
}
