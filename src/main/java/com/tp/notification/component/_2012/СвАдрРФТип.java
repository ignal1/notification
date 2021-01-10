package com.tp.notification.component._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "—вјдр–‘“ип", propOrder = {
        "адр–‘"
})
public class —вјдр–‘“ип {

    @XmlElement(name = "јдр–‘", required = true)
    protected јдр–‘“ип адр–‘;

    @XmlAttribute(name = "ѕрјдр", required = true)
    protected String прјдр;

    public јдр–‘“ип getјдр–‘() {
        return адр–‘;
    }
    public void setјдр–‘(јдр–‘“ип value) {
        this.адр–‘ = value;
    }
    public String getѕрјдр() {
        return прјдр;
    }
    public void setѕрјдр(String value) {
        this.прјдр = value;
    }
}