package com.tp.notification.component._2012;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "����������", propOrder = {
        "�����"
})
public class ���������� {

    @XmlElement(name = "�����", required = true)
    protected �������� �����;

    @XmlAttribute(name = "�����", required = true)
    protected String �����;

    public �������� get�����() {
        return �����;
    }
    public void set�����(�������� value) {
        this.����� = value;
    }
    public String get�����() {
        return �����;
    }
    public void set�����(String value) {
        this.����� = value;
    }
}