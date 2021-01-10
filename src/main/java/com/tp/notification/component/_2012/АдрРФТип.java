package com.tp.notification.component._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "АдрРФТип")
public class АдрРФТип {

    @XmlAttribute(name = "Индекс")
    protected String индекс;
    @XmlAttribute(name = "КодРегион", required = true)
    protected String кодРегион;
    @XmlAttribute(name = "Район")
    protected String район;
    @XmlAttribute(name = "Город")
    protected String город;
    @XmlAttribute(name = "НаселПункт")
    protected String населПункт;
    @XmlAttribute(name = "Улица")
    protected String улица;
    @XmlAttribute(name = "Дом")
    protected String дом;
    @XmlAttribute(name = "Корпус")
    protected String корпус;
    @XmlAttribute(name = "Кварт")
    protected String кварт;

    public String getИндекс() {
        return индекс;
    }
    public void setИндекс(String value) {
        this.индекс = value;
    }
    public String getКодРегион() {
        return кодРегион;
    }
    public void setКодРегион(String value) {
        this.кодРегион = value;
    }
    public String getРайон() {
        return район;
    }
    public void setРайон(String value) {
        this.район = value;
    }
    public String getГород() {
        return город;
    }
    public void setГород(String value) {
        this.город = value;
    }
    public String getНаселПункт() {
        return населПункт;
    }
    public void setНаселПункт(String value) {
        this.населПункт = value;
    }
    public String getУлица() {
        return улица;
    }
    public void setУлица(String value) {
        this.улица = value;
    }
    public String getДом() {
        return дом;
    }
    public void setДом(String value) {
        this.дом = value;
    }
    public String getКорпус() {
        return корпус;
    }
    public void setКорпус(String value) {
        this.корпус = value;
    }
    public String getКварт() {
        return кварт;
    }
    public void setКварт(String value) {
        this.кварт = value;
    }
}