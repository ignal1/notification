package com.tp.notification.component._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "СвАдрРФТип", propOrder = {
        "адрРФ"
})
public class СвАдрРФТип {

    @XmlElement(name = "АдрРФ", required = true)
    protected АдрРФТип адрРФ;

    @XmlAttribute(name = "ПрАдр", required = true)
    protected String прАдр;

    public АдрРФТип getАдрРФ() {
        return адрРФ;
    }
    public void setАдрРФ(АдрРФТип value) {
        this.адрРФ = value;
    }
    public String getПрАдр() {
        return прАдр;
    }
    public void setПрАдр(String value) {
        this.прАдр = value;
    }
}