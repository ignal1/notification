package com.tp.notification.component._2018;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "МестоТип")
public class МестоТип {

    @XmlAttribute(name = "ОКСМ", required = true)
    protected String оксм;
    @XmlAttribute(name = "КодРегион")
    protected String кодРегион;
    @XmlAttribute(name = "НаселПункт")
    protected String населПункт;

    public String getОКСМ() {
        return оксм;
    }
    public void setОКСМ(String value) {
        this.оксм = value;
    }
    public String getКодРегион() {
        return кодРегион;
    }
    public void setКодРегион(String value) {
        this.кодРегион = value;
    }
    public String getНаселПункт() {
        return населПункт;
    }
    public void setНаселПункт(String value) {
        this.населПункт = value;
    }

}