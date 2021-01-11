package com.tp.notification.component._2019;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "АдрИнТип")
public class АдрИнТип {

    @XmlAttribute(name = "ОКСМ", required = true)
    protected String оксм;
    @XmlAttribute(name = "АдрИнТекст", required = true)
    protected String адрИнТекст;

    public String getОКСМ() {
        return оксм;
    }
    public void setОКСМ(String value) {
        this.оксм = value;
    }
    public String getАдрИнТекст() {
        return адрИнТекст;
    }
    public void setАдрИнТекст(String value) {
        this.адрИнТекст = value;
    }

}
