package com.tp.notification.component._2019;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ФИОТип")
public class ФИОТип {

    @XmlAttribute(name = "Фамилия", required = true)
    protected String фамилия;
    @XmlAttribute(name = "Имя", required = true)
    protected String имя;
    @XmlAttribute(name = "Отчество")
    protected String отчество;

    public String getФамилия() {
        return фамилия;
    }
    public void setФамилия(String value) {
        this.фамилия = value;
    }
    public String getИмя() {
        return имя;
    }
    public void setИмя(String value) {
        this.имя = value;
    }
    public String getОтчество() {
        return отчество;
    }
    public void setОтчество(String value) {
        this.отчество = value;
    }

}

