package com.tp.notification.component._2018;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "��������"
})
@XmlRootElement(name = "����")
public class ����2018 {

    @XmlElement(name = "��������", required = true)
    protected ����2018.�������� ��������;

    @XmlAttribute(name = "xmlns:xsi", required = true)
    protected String xmlnsXsi = "http://www.w3.org/2001/XMLSchema-instance";
    @XmlAttribute(name = "������", required = true)
    protected String ������;
    @XmlAttribute(name = "��������", required = true)
    protected String ��������;
    @XmlAttribute(name = "��������", required = true)
    protected String ��������;
    @XmlAttribute(name = "���������", required = true)
    protected String ���������;
    @XmlAttribute(name = "����������", required = true)
    protected String ����������;
    @XmlAttribute(name = "�������", required = true)
    protected String �������;
    @XmlAttribute(name = "�������", required = true)
    protected String �������;

    public ����2018.�������� get��������() {
        return ��������;
    }
    public void set��������(����2018.�������� value) {
        this.�������� = value;
    }
    public String get������() {
        return ������;
    }
    public void set������(String value) {
        this.������ = value;
    }
    public String get��������() {
        return ��������;
    }
    public void set��������(String value) {
        this.�������� = value;
    }
    public String get��������() {
        return ��������;
    }
    public void set��������(String value) {
        this.�������� = value;
    }
    public String get���������() {
        return ���������;
    }
    public void set���������(String value) {
        this.��������� = value;
    }
    public String get����������() {
        return ����������;
    }
    public void set����������(String value) {
        this.���������� = value;
    }
    public String get�������() {
        return �������;
    }
    public void set�������(String value) {
        this.������� = value;
    }
    public String get�������() {
        return �������;
    }
    public void set�������(String value) {
        this.������� = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "����",
            "���������",
            "���������"
    })
    public static class �������� {

        @XmlElement(name = "����", required = true)
        protected ����2018.��������.���� ����;
        @XmlElement(name = "���������", required = true)
        protected ����2018.��������.��������� ���������;
        @XmlElement(name = "���������", required = true)
        protected ����2018.��������.��������� ���������;

        @XmlAttribute(name = "���", required = true)
        protected String ���;
        @XmlAttribute(name = "�������", required = true)
        protected String �������;
        @XmlAttribute(name = "��������", required = true)
        @XmlSchemaType(name = "gYear")
        protected String ��������;
        @XmlAttribute(name = "�����", required = true)
        protected String �����;
        @XmlAttribute(name = "�������", required = true)
        protected String �������;
        @XmlAttribute(name = "�������", required = true)
        protected String �������;

        public ����2018.��������.���� get����() {
            return ����;
        }
        public void set����(����2018.��������.���� value) {
            this.���� = value;
        }
        public ����2018.��������.��������� get���������() {
            return ���������;
        }
        public void set���������(����2018.��������.��������� value) {
            this.��������� = value;
        }
        public ����2018.��������.��������� get���������() {
            return ���������;
        }
        public void set���������(����2018.��������.��������� value) {
            this.��������� = value;
        }
        public String get���() {
            return ���;
        }
        public void set���(String value) {
            this.��� = value;
        }
        public String get�������() {
            return �������;
        }
        public void set�������(String value) {
            this.������� = value;
        }
        public String get��������() {
            return ��������;
        }
        public void set��������(String value) {
            this.�������� = value;
        }
        public String get�����() {
            return �����;
        }
        public void set�����(String value) {
            this.����� = value;
        }
        public String get�������() {
            return �������;
        }
        public void set�������(String value) {
            this.������� = value;
        }
        public String get�������() {
            return �������;
        }
        public void set�������(String value) {
            this.������� = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "���",
                "������"
        })
        public static class ��������� {

            @XmlElement(name = "���")
            protected ������ ���;
            @XmlElement(name = "������")
            protected ����2018.��������.���������.������ ������;

            @XmlAttribute(name = "������", required = true)
            protected String ������;

            public ������ get���() {
                return ���;
            }
            public void set���(������ value) {
                this.��� = value;
            }
            public ����2018.��������.���������.������ get������() {
                return ������;
            }
            public void set������(����2018.��������.���������.������ value) {
                this.������ = value;
            }
            public String get������() {
                return ������;
            }
            public void set������(String value) {
                this.������ = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class ������ {

                @XmlAttribute(name = "�������", required = true)
                protected String �������;
                @XmlAttribute(name = "�������")
                protected String �������;

                public String get�������() {
                    return �������;
                }
                public void set�������(String value) {
                    this.������� = value;
                }
                public String get�������() {
                    return �������;
                }
                public void set�������(String value) {
                    this.������� = value;
                }
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "����",
                "����"
        })
        public static class ���� {

            @XmlElement(name = "����")
            protected ����2018.��������.����.���� ����;
            @XmlElement(name = "����")
            protected ����2018.��������.����.���� ����;

            @XmlAttribute(name = "�����", required = true)
            protected String �����;
            @XmlAttribute(name = "���")
            protected String ���;
            @XmlAttribute(name = "E-mail")
            protected String eMail;

            public ����2018.��������.����.���� get����() {
                return ����;
            }
            public void set����(����2018.��������.����.���� value) {
                this.���� = value;
            }
            public ����2018.��������.����.���� get����() {
                return ����;
            }
            public void set����(����2018.��������.����.���� value) {
                this.���� = value;
            }
            public String get�����() {
                return �����;
            }
            public void set�����(String value) {
                this.����� = value;
            }
            public String get���() {
                return ���;
            }
            public void set���(String value) {
                this.��� = value;
            }
            public String getEMail() {
                return eMail;
            }
            public void setEMail(String value) {
                this.eMail = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "���",
                    "�����",
                    "����"
            })
            public static class ���� {

                @XmlElement(name = "���", required = true)
                protected ������ ���;
                @XmlElement(name = "�����")
                protected String �����;
                @XmlElement(name = "����")
                protected ����2018.��������.����.����.���� ����;

                public ������ get���() {
                    return ���;
                }
                public void set���(������ value) {
                    this.��� = value;
                }
                public String get�����() {
                    return �����;
                }
                public void set�����(String value) {
                    this.����� = value;
                }
                public ����2018.��������.����.����.���� get����() {
                    return ����;
                }
                public void set����(����2018.��������.����.����.���� value) {
                    this.���� = value;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "��������",
                        "�����"
                })
                public static class ���� {

                    @XmlElement(name = "��������", required = true)
                    protected ����������� ��������;
                    @XmlElement(name = "�����")
                    protected �������� �����;

                    @XmlAttribute(name = "��������", required = true)
                    protected String ��������;
                    @XmlAttribute(name = "���������", required = true)
                    protected String ���������;
                    @XmlAttribute(name = "�����", required = true)
                    protected String �����;
                    @XmlAttribute(name = "����", required = true)
                    protected String ����;
                    @XmlAttribute(name = "��������", required = true)
                    protected String ��������;

                    public ����������� get��������() {
                        return ��������;
                    }
                    public void set��������(����������� value) {
                        this.�������� = value;
                    }
                    public �������� get�����() {
                        return �����;
                    }
                    public void set�����(�������� value) {
                        this.����� = value;
                    }
                    public String get��������() {
                        return ��������;
                    }
                    public void set��������(String value) {
                        this.�������� = value;
                    }
                    public String get���������() {
                        return ���������;
                    }
                    public void set���������(String value) {
                        this.��������� = value;
                    }
                    public String get�����() {
                        return �����;
                    }
                    public void set�����(String value) {
                        this.����� = value;
                    }
                    public String get����() {
                        return ����;
                    }
                    public void set����(String value) {
                        this.���� = value;
                    }
                    public String get��������() {
                        return ��������;
                    }
                    public void set��������(String value) {
                        this.�������� = value;
                    }
                }
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "���������"
            })
            public static class ���� {

                @XmlElement(name = "���������")
                protected ����2018.��������.����.����.��������� ���������;

                @XmlAttribute(name = "�������", required = true)
                protected String �������;
                @XmlAttribute(name = "�����", required = true)
                protected String �����;
                @XmlAttribute(name = "���", required = true)
                protected String ���;

                public ����2018.��������.����.����.��������� get���������() {
                    return ���������;
                }
                public void set���������(����2018.��������.����.����.��������� value) {
                    this.��������� = value;
                }
                public String get�������() {
                    return �������;
                }
                public void set�������(String value) {
                    this.������� = value;
                }
                public String get�����() {
                    return �����;
                }
                public void set�����(String value) {
                    this.����� = value;
                }
                public String get���() {
                    return ���;
                }
                public void set���(String value) {
                    this.��� = value;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class ��������� {

                    @XmlAttribute(name = "���������", required = true)
                    protected String ���������;
                    @XmlAttribute(name = "�����")
                    protected String �����;
                    @XmlAttribute(name = "���")
                    protected String ���;

                    public String get���������() {
                        return ���������;
                    }
                    public void set���������(String value) {
                        this.��������� = value;
                    }
                    public String get�����() {
                        return �����;
                    }
                    public void set�����(String value) {
                        this.����� = value;
                    }
                    public String get���() {
                        return ���;
                    }
                    public void set���(String value) {
                        this.��� = value;
                    }
                }
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "���������"
        })
        public static class ��������� {

            @XmlElement(name = "���������", required = true)
            protected List<����2018.��������.���������.���������> ���������;

            public List<����2018.��������.���������.���������> get���������() {
                if (��������� == null) {
                    ��������� = new ArrayList<����2018.��������.���������.���������>();
                }
                return this.���������;
            }

            public void set���������(List<����2018.��������.���������.���������> value) {
                this.��������� = value;
            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "����������",
                    "�������",
                    "���������",
                    "����������",
                    "����������",
                    "���������"
            })
            public static class ��������� {

                @XmlElement(name = "����������", required = true)
                protected ����2018.��������.���������.���������.���������� ����������;
                @XmlElement(name = "�������", required = true)
                protected ����2018.��������.���������.���������.������� �������;
                @XmlElement(name = "���������", required = true)
                protected ����2018.��������.���������.���������.��������� ���������;
                @XmlElement(name = "����������", required = true)
                protected List<����2018.��������.���������.���������.����������> ����������;
                @XmlElement(name = "����������")
                protected List<����2018.��������.���������.���������.����������> ����������;
                @XmlElement(name = "���������")
                protected List<����2018.��������.���������.���������.���������> ���������;
                @XmlAttribute(name = "��������", required = true)
                protected BigInteger ��������;
                @XmlAttribute(name = "��������������", required = true)
                protected String ��������������;

                public ����2018.��������.���������.���������.���������� get����������() {
                    return ����������;
                }
                public void set����������(����2018.��������.���������.���������.���������� value) {
                    this.���������� = value;
                }
                public ����2018.��������.���������.���������.������� get�������() {
                    return �������;
                }
                public void set�������(����2018.��������.���������.���������.������� value) {
                    this.������� = value;
                }
                public ����2018.��������.���������.���������.��������� get���������() {
                    return ���������;
                }
                public void set���������(����2018.��������.���������.���������.��������� value) {
                    this.��������� = value;
                }

                public List<����2018.��������.���������.���������.����������> get����������() {
                    if (���������� == null) {
                        ���������� = new ArrayList<����2018.��������.���������.���������.����������>();
                    }
                    return this.����������;
                }
                public void set����������(List<����2018.��������.���������.���������.����������> value){
                    this.���������� = value;
                }

                public List<����2018.��������.���������.���������.����������> get����������() {
                    if (���������� == null) {
                        ���������� = new ArrayList<����2018.��������.���������.���������.����������>();
                    }
                    return this.����������;
                }
                public void set����������(List<����2018.��������.���������.���������.����������> value){
                    this.���������� = value;
                }

                public List<����2018.��������.���������.���������.���������> get���������() {
                    if (��������� == null) {
                        ��������� = new ArrayList<����2018.��������.���������.���������.���������>();
                    }
                    return this.���������;
                }
                public void set���������(List<����2018.��������.���������.���������.���������> value){
                    this.��������� = value;
                }

                public BigInteger get��������() {
                    return ��������;
                }
                public void set��������(BigInteger value) {
                    this.�������� = value;
                }
                public String get��������������() {
                    return ��������������;
                }
                public void set��������������(String value) {
                    this.�������������� = value;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class ��������� {

                    @XmlAttribute(name = "��������", required = true)
                    protected BigInteger ��������;
                    @XmlAttribute(name = "�����������")
                    protected BigInteger �����������;
                    @XmlAttribute(name = "���������", required = true)
                    protected BigInteger ���������;
                    @XmlAttribute(name = "������������")
                    protected BigInteger ������������;

                    public BigInteger get��������() {
                        return ��������;
                    }
                    public void set��������(BigInteger value) {
                        this.�������� = value;
                    }
                    public BigInteger get�����������() {
                        return �����������;
                    }
                    public void set�����������(BigInteger value) {
                        this.����������� = value;
                    }
                    public BigInteger get���������() {
                        return ���������;
                    }
                    public void set���������(BigInteger value) {
                        this.��������� = value;
                    }
                    public BigInteger get������������() {
                        return ������������;
                    }
                    public void set������������(BigInteger value) {
                        this.������������ = value;
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "���������"
                })
                public static class ������� {

                    @XmlElement(name = "���������")
                    protected ����2018.��������.���������.���������.�������.��������� ���������;

                    @XmlAttribute(name = "������", required = true)
                    protected String ������;
                    @XmlAttribute(name = "���������", required = true)
                    protected String ���������;
                    @XmlAttribute(name = "���������", required = true)
                    protected String ���������;
                    @XmlAttribute(name = "��������", required = true)
                    protected String ��������;
                    @XmlAttribute(name = "�����������")
                    protected String �����������;
                    @XmlAttribute(name = "���������", required = true)
                    protected String ���������;
                    @XmlAttribute(name = "������������")
                    protected String ������������;
                    @XmlAttribute(name = "���������")
                    protected String ���������;
                    @XmlAttribute(name = "������������")
                    protected String ������������;
                    @XmlAttribute(name = "�������", required = true)
                    protected BigInteger �������;
                    @XmlAttribute(name = "����������")
                    protected String ����������;

                    public ����2018.��������.���������.���������.�������.��������� get���������() {
                        return ���������;
                    }
                    public void set���������(����2018.��������.���������.���������.�������.��������� value) {
                        this.��������� = value;
                    }
                    public String get������() {
                        return ������;
                    }
                    public void set������(String value) {
                        this.������ = value;
                    }
                    public String get���������() {
                        return ���������;
                    }
                    public void set���������(String value) {
                        this.��������� = value;
                    }
                    public String get���������() {
                        return ���������;
                    }
                    public void set���������(String value) {
                        this.��������� = value;
                    }
                    public String get��������() {
                        return ��������;
                    }
                    public void set��������(String value) {
                        this.�������� = value;
                    }
                    public String get�����������() {
                        return �����������;
                    }
                    public void set�����������(String value) {
                        this.����������� = value;
                    }
                    public String get���������() {
                        return ���������;
                    }
                    public void set���������(String value) {
                        this.��������� = value;
                    }
                    public String get������������() {
                        return ������������;
                    }
                    public void set������������(String value) {
                        this.������������ = value;
                    }
                    public String get���������() {
                        return ���������;
                    }
                    public void set���������(String value) {
                        this.��������� = value;
                    }
                    public String get������������() {
                        return ������������;
                    }
                    public void set������������(String value) {
                        this.������������ = value;
                    }
                    public BigInteger get�������() {
                        return �������;
                    }
                    public void set�������(BigInteger value) {
                        this.������� = value;
                    }
                    public String get����������() {
                        return ����������;
                    }
                    public void set����������(String value) {
                        this.���������� = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class ��������� {

                        @XmlAttribute(name = "���251", required = true)
                        protected String ���251;
                        @XmlAttribute(name = "���252", required = true)
                        protected String ���252;
                        @XmlAttribute(name = "���253", required = true)
                        protected String ���253;
                        @XmlAttribute(name = "���254", required = true)
                        protected String ���254;
                        @XmlAttribute(name = "���255", required = true)
                        protected String ���255;
                        @XmlAttribute(name = "���256", required = true)
                        protected String ���256;
                        @XmlAttribute(name = "���257", required = true)
                        protected String ���257;
                        @XmlAttribute(name = "���258", required = true)
                        protected String ���258;
                        @XmlAttribute(name = "���259", required = true)
                        protected String ���259;

                        public String get���251() {
                            return ���251;
                        }
                        public void set���251(String value) {
                            this.���251 = value;
                        }
                        public String get���252() {
                            return ���252;
                        }
                        public void set���252(String value) {
                            this.���252 = value;
                        }
                        public String get���253() {
                            return ���253;
                        }
                        public void set���253(String value) {
                            this.���253 = value;
                        }
                        public String get���254() {
                            return ���254;
                        }
                        public void set���254(String value) {
                            this.���254 = value;
                        }
                        public String get���255() {
                            return ���255;
                        }
                        public void set���255(String value) {
                            this.���255 = value;
                        }
                        public String get���256() {
                            return ���256;
                        }
                        public void set���256(String value) {
                            this.���256 = value;
                        }
                        public String get���257() {
                            return ���257;
                        }
                        public void set���257(String value) {
                            this.���257 = value;
                        }
                        public String get���258() {
                            return ���258;
                        }
                        public void set���258(String value) {
                            this.���258 = value;
                        }
                        public String get���259() {
                            return ���259;
                        }
                        public void set���259(String value) {
                            this.���259 = value;
                        }
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "���10514",
                        "�����10514"
                })
                public static class ���������� {

                    @XmlElement(name = "���105.14", required = true)
                    protected ����2018.��������.���������.���������.����������.���10514 ���10514;
                    @XmlElement(name = "�����105.14", required = true)
                    protected ����2018.��������.���������.���������.����������.�����10514 �����10514;
                    @XmlAttribute(name = "�������")
                    protected String �������;

                    public ����2018.��������.���������.���������.����������.���10514 get���10514() {
                        return ���10514;
                    }
                    public void set���10514(����2018.��������.���������.���������.����������.���10514 value) {
                        this.���10514 = value;
                    }
                    public ����2018.��������.���������.���������.����������.�����10514 get�����10514() {
                        return �����10514;
                    }
                    public void set�����10514(����2018.��������.���������.���������.����������.�����10514 value) {
                        this.�����10514 = value;
                    }
                    public String get�������() {
                        return �������;
                    }
                    public void set�������(String value) {
                        this.������� = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class ���10514 {

                        @XmlAttribute(name = "���121", required = true)
                        protected String ���121;
                        @XmlAttribute(name = "���122", required = true)
                        protected String ���122;
                        @XmlAttribute(name = "���123", required = true)
                        protected String ���123;
                        @XmlAttribute(name = "���124", required = true)
                        protected String ���124;

                        public String get���121() {
                            return ���121;
                        }
                        public void set���121(String value) {
                            this.���121 = value;
                        }
                        public String get���122() {
                            return ���122;
                        }
                        public void set���122(String value) {
                            this.���122 = value;
                        }
                        public String get���123() {
                            return ���123;
                        }
                        public void set���123(String value) {
                            this.���123 = value;
                        }
                        public String get���124() {
                            return ���124;
                        }
                        public void set���124(String value) {
                            this.���124 = value;
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class �����10514 {

                        @XmlAttribute(name = "���131", required = true)
                        protected String ���131;
                        @XmlAttribute(name = "���132", required = true)
                        protected String ���132;
                        @XmlAttribute(name = "���133", required = true)
                        protected String ���133;
                        @XmlAttribute(name = "���134", required = true)
                        protected String ���134;
                        @XmlAttribute(name = "���135", required = true)
                        protected String ���135;
                        @XmlAttribute(name = "���136", required = true)
                        protected String ���136;
                        @XmlAttribute(name = "���137", required = true)
                        protected String ���137;
                        @XmlAttribute(name = "���138", required = true)
                        protected String ���138;
                        @XmlAttribute(name = "���139", required = true)
                        protected String ���139;
                        @XmlAttribute(name = "���140", required = true)
                        protected String ���140;

                        public String get���131() {
                            return ���131;
                        }
                        public void set���131(String value) {
                            this.���131 = value;
                        }
                        public String get���132() {
                            return ���132;
                        }
                        public void set���132(String value) {
                            this.���132 = value;
                        }
                        public String get���133() {
                            return ���133;
                        }
                        public void set���133(String value) {
                            this.���133 = value;
                        }
                        public String get���134() {
                            return ���134;
                        }
                        public void set���134(String value) {
                            this.���134 = value;
                        }
                        public String get���135() {
                            return ���135;
                        }
                        public void set���135(String value) {
                            this.���135 = value;
                        }
                        public String get���136() {
                            return ���136;
                        }
                        public void set���136(String value) {
                            this.���136 = value;
                        }
                        public String get���137() {
                            return ���137;
                        }
                        public void set���137(String value) {
                            this.���137 = value;
                        }
                        public String get���138() {
                            return ���138;
                        }
                        public void set���138(String value) {
                            this.���138 = value;
                        }
                        public String get���139() {
                            return ���139;
                        }
                        public void set���139(String value) {
                            this.���139 = value;
                        }
                        public String get���140() {
                            return ���140;
                        }
                        public void set���140(String value) {
                            this.���140 = value;
                        }

                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class ���������� {

                    @XmlAttribute(name = "��������", required = true)
                    protected BigInteger ��������;
                    @XmlAttribute(name = "������������", required = true)
                    protected String ������������;
                    @XmlAttribute(name = "�����", required = true)
                    protected String �����;
                    @XmlAttribute(name = "����", required = true)
                    protected String ����;
                    @XmlAttribute(name = "����������", required = true)
                    protected String ����������;
                    @XmlAttribute(name = "����������")
                    protected String ����������;
                    @XmlAttribute(name = "�����")
                    protected String �����;
                    @XmlAttribute(name = "���")
                    protected String ���;
                    @XmlAttribute(name = "��������")
                    protected String ��������;
                    @XmlAttribute(name = "��������")
                    protected String ��������;
                    @XmlAttribute(name = "����������")
                    protected String ����������;

                    public BigInteger get��������() {
                        return ��������;
                    }
                    public void set��������(BigInteger value) {
                        this.�������� = value;
                    }
                    public String get������������() {
                        return ������������;
                    }
                    public void set������������(String value) {
                        this.������������ = value;
                    }
                    public String get�����() {
                        return �����;
                    }
                    public void set�����(String value) {
                        this.����� = value;
                    }
                    public String get����() {
                        return ����;
                    }
                    public void set����(String value) {
                        this.���� = value;
                    }
                    public String get����������() {
                        return ����������;
                    }
                    public void set����������(String value) {
                        this.���������� = value;
                    }
                    public String get����������() {
                        return ����������;
                    }
                    public void set����������(String value) {
                        this.���������� = value;
                    }
                    public String get�����() {
                        return �����;
                    }
                    public void set�����(String value) {
                        this.����� = value;
                    }
                    public String get���() {
                        return ���;
                    }
                    public void set���(String value) {
                        this.��� = value;
                    }
                    public String get��������() {
                        return ��������;
                    }
                    public void set��������(String value) {
                        this.�������� = value;
                    }
                    public String get��������() {
                        return ��������;
                    }
                    public void set��������(String value) {
                        this.�������� = value;
                    }
                    public String get����������() {
                        return ����������;
                    }
                    public void set����������(String value) {
                        this.���������� = value;
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "���������"
                })
                public static class ���������� {

                    @XmlElement(name = "���������", required = true)
                    protected List<����2018.��������.���������.���������.����������.���������> ���������;

                    @XmlAttribute(name = "���������", required = true)
                    protected String ���������;

                    public List<����2018.��������.���������.���������.����������.���������> get���������() {
                        if (��������� == null) {
                            ��������� = new ArrayList<����2018.��������.���������.���������.����������.���������>();
                        }
                        return this.���������;
                    }
                    public void set���������(List<����2018.��������.���������.���������.����������.���������> value){
                        this.��������� = value;
                    }

                    public String get���������() {
                        return ���������;
                    }
                    public void set���������(String value) {
                        this.��������� = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                            "�����������",
                            "���������"
                    })
                    public static class ��������� {

                        @XmlElement(name = "�����������")
                        protected �������� �����������;
                        @XmlElement(name = "���������")
                        protected �������� ���������;

                        @XmlAttribute(name = "����������", required = true)
                        protected String ����������;
                        @XmlAttribute(name = "�����")
                        protected String �����;
                        @XmlAttribute(name = "����2")
                        protected String ����2;
                        @XmlAttribute(name = "�����2")
                        protected String �����2;
                        @XmlAttribute(name = "�������", required = true)
                        protected BigInteger �������;
                        @XmlAttribute(name = "������", required = true)
                        protected String ������;
                        @XmlAttribute(name = "�������", required = true)
                        protected String �������;
                        @XmlAttribute(name = "����")
                        protected String ����;
                        @XmlAttribute(name = "������������")
                        protected String ������������;
                        @XmlAttribute(name = "����")
                        protected String ����;
                        @XmlAttribute(name = "����������", required = true)
                        protected BigDecimal ����������;
                        @XmlAttribute(name = "��������")
                        protected BigDecimal ��������;
                        @XmlAttribute(name = "��������")
                        protected String ��������;
                        @XmlAttribute(name = "��������")
                        protected BigDecimal ��������;
                        @XmlAttribute(name = "���������")
                        protected BigInteger ���������;
                        @XmlAttribute(name = "���������", required = true)
                        protected String ���������;

                        public �������� get�����������() {
                            return �����������;
                        }
                        public void set�����������(�������� value) {
                            this.����������� = value;
                        }
                        public �������� get���������() {
                            return ���������;
                        }
                        public void set���������(�������� value) {
                            this.��������� = value;
                        }
                        public String get����������() {
                            return ����������;
                        }
                        public void set����������(String value) {
                            this.���������� = value;
                        }
                        public String get�����() {
                            return �����;
                        }
                        public void set�����(String value) {
                            this.����� = value;
                        }
                        public String get����2() {
                            return ����2;
                        }
                        public void set����2(String value) {
                            this.����2 = value;
                        }
                        public String get�����2() {
                            return �����2;
                        }
                        public void set�����2(String value) {
                            this.�����2 = value;
                        }
                        public BigInteger get�������() {
                            return �������;
                        }
                        public void set�������(BigInteger value) {
                            this.������� = value;
                        }
                        public String get������() {
                            return ������;
                        }
                        public void set������(String value) {
                            this.������ = value;
                        }
                        public String get�������() {
                            return �������;
                        }
                        public void set�������(String value) {
                            this.������� = value;
                        }
                        public String get����() {
                            return ����;
                        }
                        public void set����(String value) {
                            this.���� = value;
                        }
                        public String get������������() {
                            return ������������;
                        }
                        public void set������������(String value) {
                            this.������������ = value;
                        }
                        public String get����() {
                            return ����;
                        }
                        public void set����(String value) {
                            this.���� = value;
                        }
                        public BigDecimal get����������() {
                            return ����������;
                        }
                        public void set����������(BigDecimal value) {
                            this.���������� = value;
                        }
                        public BigDecimal get��������() {
                            return ��������;
                        }
                        public void set��������(BigDecimal value) {
                            this.�������� = value;
                        }
                        public String get��������() {
                            return ��������;
                        }
                        public void set��������(String value) {
                            this.�������� = value;
                        }
                        public BigDecimal get��������() {
                            return ��������;
                        }
                        public void set��������(BigDecimal value) {
                            this.�������� = value;
                        }
                        public BigInteger get���������() {
                            return ���������;
                        }
                        public void set���������(BigInteger value) {
                            this.��������� = value;
                        }
                        public String get���������() {
                            return ���������;
                        }
                        public void set���������(String value) {
                            this.��������� = value;
                        }
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "���",
                        "�����",
                        "����"
                })
                public static class ��������� {

                    @XmlElement(name = "���", required = true)
                    protected ������ ���;
                    @XmlElement(name = "�����")
                    protected String �����;

                    @XmlElement(name = "����")
                    protected ����2018.��������.���������.���������.���������.���� ����;

                    @XmlAttribute(name = "��������", required = true)
                    protected BigInteger ��������;
                    @XmlAttribute(name = "������������", required = true)
                    protected String ������������;
                    @XmlAttribute(name = "�����", required = true)
                    protected String �����;

                    public ������ get���() {
                        return ���;
                    }
                    public void set���(������ value) {
                        this.��� = value;
                    }
                    public String get�����() {
                        return �����;
                    }
                    public void set�����(String value) {
                        this.����� = value;
                    }
                    public ����2018.��������.���������.���������.���������.���� get����() {
                        return ����;
                    }
                    public void set����(����2018.��������.���������.���������.���������.���� value) {
                        this.���� = value;
                    }
                    public BigInteger get��������() {
                        return ��������;
                    }
                    public void set��������(BigInteger value) {
                        this.�������� = value;
                    }
                    public String get������������() {
                        return ������������;
                    }
                    public void set������������(String value) {
                        this.������������ = value;
                    }
                    public String get�����() {
                        return �����;
                    }
                    public void set�����(String value) {
                        this.����� = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                            "��������",
                            "�����"
                    })
                    public static class ���� {

                        @XmlElement(name = "��������", required = true)
                        protected ����������� ��������;
                        @XmlElement(name = "�����")
                        protected �������� �����;

                        @XmlAttribute(name = "��������", required = true)
                        protected String ��������;
                        @XmlAttribute(name = "���������", required = true)
                        protected String ���������;
                        @XmlAttribute(name = "�����", required = true)
                        protected String �����;
                        @XmlAttribute(name = "����")
                        protected String ����;

                        public ����������� get��������() {
                            return ��������;
                        }
                        public void set��������(����������� value) {
                            this.�������� = value;
                        }
                        public �������� get�����() {
                            return �����;
                        }
                        public void set�����(�������� value) {
                            this.����� = value;
                        }
                        public String get��������() {
                            return ��������;
                        }
                        public void set��������(String value) {
                            this.�������� = value;
                        }
                        public String get���������() {
                            return ���������;
                        }
                        public void set���������(String value) {
                            this.��������� = value;
                        }
                        public String get�����() {
                            return �����;
                        }
                        public void set�����(String value) {
                            this.����� = value;
                        }
                        public String get����() {
                            return ����;
                        }
                        public void set����(String value) {
                            this.���� = value;
                        }
                    }
                }
            }
        }
    }
}
