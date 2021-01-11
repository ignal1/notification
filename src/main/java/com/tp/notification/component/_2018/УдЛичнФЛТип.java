package com.tp.notification.component._2018;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "УдЛичнФЛТип")
public class УдЛичнФЛТип {

    @XmlAttribute(name = "КодВидДок", required = true)
    protected String кодВидДок;
    @XmlAttribute(name = "СерНомДок", required = true)
    protected String серНомДок;
    @XmlAttribute(name = "ДатаДок", required = true)
    protected String датаДок;
    @XmlAttribute(name = "ВыдДок", required = true)
    protected String выдДок;

    public String getКодВидДок() {
        return кодВидДок;
    }
    public void setКодВидДок(String value) {
        this.кодВидДок = value;
    }
    public String getСерНомДок() {
        return серНомДок;
    }
    public void setСерНомДок(String value) {
        this.серНомДок = value;
    }
    public String getДатаДок() {
        return датаДок;
    }
    public void setДатаДок(String value) {
        this.датаДок = value;
    }
    public String getВыдДок() {
        return выдДок;
    }
    public void setВыдДок(String value) {
        this.выдДок = value;
    }

}