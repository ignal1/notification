package com.tp.notification.component._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "јдр»н“ип")
public class јдр»н“ип {

    @XmlAttribute(name = "ќ —ћ", required = true)
    protected String оксм;
    @XmlAttribute(name = "јдр»н“екст", required = true)
    protected String адр»н“екст;

    public String getќ —ћ() {
        return оксм;
    }
    public void setќ —ћ(String value) {
        this.оксм = value;
    }
    public String getјдр»н“екст() {
        return адр»н“екст;
    }
    public void setјдр»н“екст(String value) {
        this.адр»н“екст = value;
    }
}
