package com.tp.notification.component._2018;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "документ"
})
@XmlRootElement(name = "Файл")
public class Файл2018 {

    @XmlElement(name = "Документ", required = true)
    protected Файл2018.Документ документ;

    @XmlAttribute(name = "xmlns:xsi", required = true)
    protected String xmlnsXsi = "http://www.w3.org/2001/XMLSchema-instance";
    @XmlAttribute(name = "ИдФайл", required = true)
    protected String идФайл;
    @XmlAttribute(name = "ВерсПрог", required = true)
    protected String версПрог;
    @XmlAttribute(name = "ВерсФорм", required = true)
    protected String версФорм;
    @XmlAttribute(name = "ИдФайлИсх", required = true)
    protected String идФайлИсх;
    @XmlAttribute(name = "ИдФайлПерв", required = true)
    protected String идФайлПерв;
    @XmlAttribute(name = "КолФайл", required = true)
    protected String колФайл;
    @XmlAttribute(name = "НомФайл", required = true)
    protected String номФайл;

    public Файл2018.Документ getДокумент() {
        return документ;
    }
    public void setДокумент(Файл2018.Документ value) {
        this.документ = value;
    }
    public String getИдФайл() {
        return идФайл;
    }
    public void setИдФайл(String value) {
        this.идФайл = value;
    }
    public String getВерсПрог() {
        return версПрог;
    }
    public void setВерсПрог(String value) {
        this.версПрог = value;
    }
    public String getВерсФорм() {
        return версФорм;
    }
    public void setВерсФорм(String value) {
        this.версФорм = value;
    }
    public String getИдФайлИсх() {
        return идФайлИсх;
    }
    public void setИдФайлИсх(String value) {
        this.идФайлИсх = value;
    }
    public String getИдФайлПерв() {
        return идФайлПерв;
    }
    public void setИдФайлПерв(String value) {
        this.идФайлПерв = value;
    }
    public String getКолФайл() {
        return колФайл;
    }
    public void setКолФайл(String value) {
        this.колФайл = value;
    }
    public String getНомФайл() {
        return номФайл;
    }
    public void setНомФайл(String value) {
        this.номФайл = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "свНП",
            "подписант",
            "увКонтрСд"
    })
    public static class Документ {

        @XmlElement(name = "СвНП", required = true)
        protected Файл2018.Документ.СвНП свНП;
        @XmlElement(name = "Подписант", required = true)
        protected Файл2018.Документ.Подписант подписант;
        @XmlElement(name = "УвКонтрСд", required = true)
        protected Файл2018.Документ.УвКонтрСд увКонтрСд;

        @XmlAttribute(name = "КНД", required = true)
        protected String кнд;
        @XmlAttribute(name = "ДатаДок", required = true)
        protected String датаДок;
        @XmlAttribute(name = "ОтчетГод", required = true)
        @XmlSchemaType(name = "gYear")
        protected String отчетГод;
        @XmlAttribute(name = "КодНО", required = true)
        protected String кодНО;
        @XmlAttribute(name = "НомКорр", required = true)
        protected String номКорр;
        @XmlAttribute(name = "ПоМесту", required = true)
        protected String поМесту;

        public Файл2018.Документ.СвНП getСвНП() {
            return свНП;
        }
        public void setСвНП(Файл2018.Документ.СвНП value) {
            this.свНП = value;
        }
        public Файл2018.Документ.Подписант getПодписант() {
            return подписант;
        }
        public void setПодписант(Файл2018.Документ.Подписант value) {
            this.подписант = value;
        }
        public Файл2018.Документ.УвКонтрСд getУвКонтрСд() {
            return увКонтрСд;
        }
        public void setУвКонтрСд(Файл2018.Документ.УвКонтрСд value) {
            this.увКонтрСд = value;
        }
        public String getКНД() {
            return кнд;
        }
        public void setКНД(String value) {
            this.кнд = value;
        }
        public String getДатаДок() {
            return датаДок;
        }
        public void setДатаДок(String value) {
            this.датаДок = value;
        }
        public String getОтчетГод() {
            return отчетГод;
        }
        public void setОтчетГод(String value) {
            this.отчетГод = value;
        }
        public String getКодНО() {
            return кодНО;
        }
        public void setКодНО(String value) {
            this.кодНО = value;
        }
        public String getНомКорр() {
            return номКорр;
        }
        public void setНомКорр(String value) {
            this.номКорр = value;
        }
        public String getПоМесту() {
            return поМесту;
        }
        public void setПоМесту(String value) {
            this.поМесту = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "фио",
                "свПред"
        })
        public static class Подписант {

            @XmlElement(name = "ФИО")
            protected ФИОТип фио;
            @XmlElement(name = "СвПред")
            protected Файл2018.Документ.Подписант.СвПред свПред;

            @XmlAttribute(name = "ПрПодп", required = true)
            protected String прПодп;

            public ФИОТип getФИО() {
                return фио;
            }
            public void setФИО(ФИОТип value) {
                this.фио = value;
            }
            public Файл2018.Документ.Подписант.СвПред getСвПред() {
                return свПред;
            }
            public void setСвПред(Файл2018.Документ.Подписант.СвПред value) {
                this.свПред = value;
            }
            public String getПрПодп() {
                return прПодп;
            }
            public void setПрПодп(String value) {
                this.прПодп = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class СвПред {

                @XmlAttribute(name = "НаимДок", required = true)
                protected String наимДок;
                @XmlAttribute(name = "НаимОрг")
                protected String наимОрг;

                public String getНаимДок() {
                    return наимДок;
                }
                public void setНаимДок(String value) {
                    this.наимДок = value;
                }
                public String getНаимОрг() {
                    return наимОрг;
                }
                public void setНаимОрг(String value) {
                    this.наимОрг = value;
                }
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "нпюл",
                "нпфл"
        })
        public static class СвНП {

            @XmlElement(name = "НПЮЛ")
            protected Файл2018.Документ.СвНП.НПЮЛ нпюл;
            @XmlElement(name = "НПФЛ")
            protected Файл2018.Документ.СвНП.НПФЛ нпфл;

            @XmlAttribute(name = "ОКТМО", required = true)
            protected String октмо;
            @XmlAttribute(name = "Тлф")
            protected String тлф;
            @XmlAttribute(name = "E-mail")
            protected String eMail;

            public Файл2018.Документ.СвНП.НПЮЛ getНПЮЛ() {
                return нпюл;
            }
            public void setНПЮЛ(Файл2018.Документ.СвНП.НПЮЛ value) {
                this.нпюл = value;
            }
            public Файл2018.Документ.СвНП.НПФЛ getНПФЛ() {
                return нпфл;
            }
            public void setНПФЛ(Файл2018.Документ.СвНП.НПФЛ value) {
                this.нпфл = value;
            }
            public String getОКТМО() {
                return октмо;
            }
            public void setОКТМО(String value) {
                this.октмо = value;
            }
            public String getТлф() {
                return тлф;
            }
            public void setТлф(String value) {
                this.тлф = value;
            }
            public String getEMail() {
                return eMail;
            }
            public void setEMail(String value) {
                this.eMail = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "фио",
                    "иннфл",
                    "свФЛ"
            })
            public static class НПФЛ {

                @XmlElement(name = "ФИО", required = true)
                protected ФИОТип фио;
                @XmlElement(name = "ИННФЛ")
                protected String иннфл;
                @XmlElement(name = "СвФЛ")
                protected Файл2018.Документ.СвНП.НПФЛ.СвФЛ свФЛ;

                public ФИОТип getФИО() {
                    return фио;
                }
                public void setФИО(ФИОТип value) {
                    this.фио = value;
                }
                public String getИННФЛ() {
                    return иннфл;
                }
                public void setИННФЛ(String value) {
                    this.иннфл = value;
                }
                public Файл2018.Документ.СвНП.НПФЛ.СвФЛ getСвФЛ() {
                    return свФЛ;
                }
                public void setСвФЛ(Файл2018.Документ.СвНП.НПФЛ.СвФЛ value) {
                    this.свФЛ = value;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "удЛичнФЛ",
                        "адрИн"
                })
                public static class СвФЛ {

                    @XmlElement(name = "УдЛичнФЛ", required = true)
                    protected УдЛичнФЛТип удЛичнФЛ;
                    @XmlElement(name = "АдрИн")
                    protected АдрИнТип адрИн;

                    @XmlAttribute(name = "ДатаРожд", required = true)
                    protected String датаРожд;
                    @XmlAttribute(name = "МестоРожд", required = true)
                    protected String местоРожд;
                    @XmlAttribute(name = "Гражд", required = true)
                    protected String гражд;
                    @XmlAttribute(name = "ОКСМ", required = true)
                    protected String оксм;
                    @XmlAttribute(name = "СтатусНП", required = true)
                    protected String статусНП;

                    public УдЛичнФЛТип getУдЛичнФЛ() {
                        return удЛичнФЛ;
                    }
                    public void setУдЛичнФЛ(УдЛичнФЛТип value) {
                        this.удЛичнФЛ = value;
                    }
                    public АдрИнТип getАдрИн() {
                        return адрИн;
                    }
                    public void setАдрИн(АдрИнТип value) {
                        this.адрИн = value;
                    }
                    public String getДатаРожд() {
                        return датаРожд;
                    }
                    public void setДатаРожд(String value) {
                        this.датаРожд = value;
                    }
                    public String getМестоРожд() {
                        return местоРожд;
                    }
                    public void setМестоРожд(String value) {
                        this.местоРожд = value;
                    }
                    public String getГражд() {
                        return гражд;
                    }
                    public void setГражд(String value) {
                        this.гражд = value;
                    }
                    public String getОКСМ() {
                        return оксм;
                    }
                    public void setОКСМ(String value) {
                        this.оксм = value;
                    }
                    public String getСтатусНП() {
                        return статусНП;
                    }
                    public void setСтатусНП(String value) {
                        this.статусНП = value;
                    }
                }
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "свРеоргЮЛ"
            })
            public static class НПЮЛ {

                @XmlElement(name = "СвРеоргЮЛ")
                protected Файл2018.Документ.СвНП.НПЮЛ.СвРеоргЮЛ свРеоргЮЛ;

                @XmlAttribute(name = "НаимОрг", required = true)
                protected String наимОрг;
                @XmlAttribute(name = "ИННЮЛ", required = true)
                protected String иннюл;
                @XmlAttribute(name = "КПП", required = true)
                protected String кпп;

                public Файл2018.Документ.СвНП.НПЮЛ.СвРеоргЮЛ getСвРеоргЮЛ() {
                    return свРеоргЮЛ;
                }
                public void setСвРеоргЮЛ(Файл2018.Документ.СвНП.НПЮЛ.СвРеоргЮЛ value) {
                    this.свРеоргЮЛ = value;
                }
                public String getНаимОрг() {
                    return наимОрг;
                }
                public void setНаимОрг(String value) {
                    this.наимОрг = value;
                }
                public String getИННЮЛ() {
                    return иннюл;
                }
                public void setИННЮЛ(String value) {
                    this.иннюл = value;
                }
                public String getКПП() {
                    return кпп;
                }
                public void setКПП(String value) {
                    this.кпп = value;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class СвРеоргЮЛ {

                    @XmlAttribute(name = "ФормРеорг", required = true)
                    protected String формРеорг;
                    @XmlAttribute(name = "ИННЮЛ")
                    protected String иннюл;
                    @XmlAttribute(name = "КПП")
                    protected String кпп;

                    public String getФормРеорг() {
                        return формРеорг;
                    }
                    public void setФормРеорг(String value) {
                        this.формРеорг = value;
                    }
                    public String getИННЮЛ() {
                        return иннюл;
                    }
                    public void setИННЮЛ(String value) {
                        this.иннюл = value;
                    }
                    public String getКПП() {
                        return кпп;
                    }
                    public void setКПП(String value) {
                        this.кпп = value;
                    }
                }
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "свКонтрСд"
        })
        public static class УвКонтрСд {

            @XmlElement(name = "СвКонтрСд", required = true)
            protected List<Файл2018.Документ.УвКонтрСд.СвКонтрСд> свКонтрСд;

            public List<Файл2018.Документ.УвКонтрСд.СвКонтрСд> getСвКонтрСд() {
                if (свКонтрСд == null) {
                    свКонтрСд = new ArrayList<Файл2018.Документ.УвКонтрСд.СвКонтрСд>();
                }
                return this.свКонтрСд;
            }

            public void setСвКонтрСд(List<Файл2018.Документ.УвКонтрСд.СвКонтрСд> value) {
                this.свКонтрСд = value;
            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "оснКонтрСд",
                    "контрСд",
                    "дохРасхСд",
                    "свПредмСдН",
                    "свОргУчаст",
                    "свФЛУчаст"
            })
            public static class СвКонтрСд {

                @XmlElement(name = "ОснКонтрСд", required = true)
                protected Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд оснКонтрСд;
                @XmlElement(name = "КонтрСд", required = true)
                protected Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд контрСд;
                @XmlElement(name = "ДохРасхСд", required = true)
                protected Файл2018.Документ.УвКонтрСд.СвКонтрСд.ДохРасхСд дохРасхСд;
                @XmlElement(name = "СвПредмСдН", required = true)
                protected List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН> свПредмСдН;
                @XmlElement(name = "СвОргУчаст")
                protected List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст> свОргУчаст;
                @XmlElement(name = "СвФЛУчаст")
                protected List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст> свФЛУчаст;
                @XmlAttribute(name = "НомПорСд", required = true)
                protected BigInteger номПорСд;
                @XmlAttribute(name = "СделкаСовАгент", required = true)
                protected String сделкаСовАгент;

                public Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд getОснКонтрСд() {
                    return оснКонтрСд;
                }
                public void setОснКонтрСд(Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд value) {
                    this.оснКонтрСд = value;
                }
                public Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд getКонтрСд() {
                    return контрСд;
                }
                public void setКонтрСд(Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд value) {
                    this.контрСд = value;
                }
                public Файл2018.Документ.УвКонтрСд.СвКонтрСд.ДохРасхСд getДохРасхСд() {
                    return дохРасхСд;
                }
                public void setДохРасхСд(Файл2018.Документ.УвКонтрСд.СвКонтрСд.ДохРасхСд value) {
                    this.дохРасхСд = value;
                }

                public List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН> getСвПредмСдН() {
                    if (свПредмСдН == null) {
                        свПредмСдН = new ArrayList<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН>();
                    }
                    return this.свПредмСдН;
                }
                public void setСвПредмСдН(List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН> value){
                    this.свПредмСдН = value;
                }

                public List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст> getСвОргУчаст() {
                    if (свОргУчаст == null) {
                        свОргУчаст = new ArrayList<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст>();
                    }
                    return this.свОргУчаст;
                }
                public void setСвОргУчаст(List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст> value){
                    this.свОргУчаст = value;
                }

                public List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст> getСвФЛУчаст() {
                    if (свФЛУчаст == null) {
                        свФЛУчаст = new ArrayList<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст>();
                    }
                    return this.свФЛУчаст;
                }
                public void setСвФЛУчаст(List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст> value){
                    this.свФЛУчаст = value;
                }

                public BigInteger getНомПорСд() {
                    return номПорСд;
                }
                public void setНомПорСд(BigInteger value) {
                    this.номПорСд = value;
                }
                public String getСделкаСовАгент() {
                    return сделкаСовАгент;
                }
                public void setСделкаСовАгент(String value) {
                    this.сделкаСовАгент = value;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class ДохРасхСд {

                    @XmlAttribute(name = "СумДохСд", required = true)
                    protected BigInteger сумДохСд;
                    @XmlAttribute(name = "СумДохСдРег")
                    protected BigInteger сумДохСдРег;
                    @XmlAttribute(name = "СумРасхСд", required = true)
                    protected BigInteger сумРасхСд;
                    @XmlAttribute(name = "СумРасхСдРег")
                    protected BigInteger сумРасхСдРег;

                    public BigInteger getСумДохСд() {
                        return сумДохСд;
                    }
                    public void setСумДохСд(BigInteger value) {
                        this.сумДохСд = value;
                    }
                    public BigInteger getСумДохСдРег() {
                        return сумДохСдРег;
                    }
                    public void setСумДохСдРег(BigInteger value) {
                        this.сумДохСдРег = value;
                    }
                    public BigInteger getСумРасхСд() {
                        return сумРасхСд;
                    }
                    public void setСумРасхСд(BigInteger value) {
                        this.сумРасхСд = value;
                    }
                    public BigInteger getСумРасхСдРег() {
                        return сумРасхСдРег;
                    }
                    public void setСумРасхСдРег(BigInteger value) {
                        this.сумРасхСдРег = value;
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "кодИстИнф"
                })
                public static class КонтрСд {

                    @XmlElement(name = "КодИстИнф")
                    protected Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд.КодИстИнф кодИстИнф;

                    @XmlAttribute(name = "ГрупОС", required = true)
                    protected String групОС;
                    @XmlAttribute(name = "КодНаимСд", required = true)
                    protected String кодНаимСд;
                    @XmlAttribute(name = "КодСторСд", required = true)
                    protected String кодСторСд;
                    @XmlAttribute(name = "ПрОпрЦен", required = true)
                    protected String прОпрЦен;
                    @XmlAttribute(name = "КомПрОпрЦен")
                    protected String комПрОпрЦен;
                    @XmlAttribute(name = "КодОпрЦен", required = true)
                    protected String кодОпрЦен;
                    @XmlAttribute(name = "КомКодОпрЦен")
                    protected String комКодОпрЦен;
                    @XmlAttribute(name = "КодМетЦен")
                    protected String кодМетЦен;
                    @XmlAttribute(name = "КомКодМетЦен")
                    protected String комКодМетЦен;
                    @XmlAttribute(name = "КолУчСд", required = true)
                    protected BigInteger колУчСд;
                    @XmlAttribute(name = "КомКолУчСд")
                    protected String комКолУчСд;

                    public Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд.КодИстИнф getКодИстИнф() {
                        return кодИстИнф;
                    }
                    public void setКодИстИнф(Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд.КодИстИнф value) {
                        this.кодИстИнф = value;
                    }
                    public String getГрупОС() {
                        return групОС;
                    }
                    public void setГрупОС(String value) {
                        this.групОС = value;
                    }
                    public String getКодНаимСд() {
                        return кодНаимСд;
                    }
                    public void setКодНаимСд(String value) {
                        this.кодНаимСд = value;
                    }
                    public String getКодСторСд() {
                        return кодСторСд;
                    }
                    public void setКодСторСд(String value) {
                        this.кодСторСд = value;
                    }
                    public String getПрОпрЦен() {
                        return прОпрЦен;
                    }
                    public void setПрОпрЦен(String value) {
                        this.прОпрЦен = value;
                    }
                    public String getКомПрОпрЦен() {
                        return комПрОпрЦен;
                    }
                    public void setКомПрОпрЦен(String value) {
                        this.комПрОпрЦен = value;
                    }
                    public String getКодОпрЦен() {
                        return кодОпрЦен;
                    }
                    public void setКодОпрЦен(String value) {
                        this.кодОпрЦен = value;
                    }
                    public String getКомКодОпрЦен() {
                        return комКодОпрЦен;
                    }
                    public void setКомКодОпрЦен(String value) {
                        this.комКодОпрЦен = value;
                    }
                    public String getКодМетЦен() {
                        return кодМетЦен;
                    }
                    public void setКодМетЦен(String value) {
                        this.кодМетЦен = value;
                    }
                    public String getКомКодМетЦен() {
                        return комКодМетЦен;
                    }
                    public void setКомКодМетЦен(String value) {
                        this.комКодМетЦен = value;
                    }
                    public BigInteger getКолУчСд() {
                        return колУчСд;
                    }
                    public void setКолУчСд(BigInteger value) {
                        this.колУчСд = value;
                    }
                    public String getКомКолУчСд() {
                        return комКолУчСд;
                    }
                    public void setКомКолУчСд(String value) {
                        this.комКолУчСд = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class КодИстИнф {

                        @XmlAttribute(name = "Ист251", required = true)
                        protected String ист251;
                        @XmlAttribute(name = "Ист252", required = true)
                        protected String ист252;
                        @XmlAttribute(name = "Ист253", required = true)
                        protected String ист253;
                        @XmlAttribute(name = "Ист254", required = true)
                        protected String ист254;
                        @XmlAttribute(name = "Ист255", required = true)
                        protected String ист255;
                        @XmlAttribute(name = "Ист256", required = true)
                        protected String ист256;
                        @XmlAttribute(name = "Ист257", required = true)
                        protected String ист257;
                        @XmlAttribute(name = "Ист258", required = true)
                        protected String ист258;
                        @XmlAttribute(name = "Ист259", required = true)
                        protected String ист259;

                        public String getИст251() {
                            return ист251;
                        }
                        public void setИст251(String value) {
                            this.ист251 = value;
                        }
                        public String getИст252() {
                            return ист252;
                        }
                        public void setИст252(String value) {
                            this.ист252 = value;
                        }
                        public String getИст253() {
                            return ист253;
                        }
                        public void setИст253(String value) {
                            this.ист253 = value;
                        }
                        public String getИст254() {
                            return ист254;
                        }
                        public void setИст254(String value) {
                            this.ист254 = value;
                        }
                        public String getИст255() {
                            return ист255;
                        }
                        public void setИст255(String value) {
                            this.ист255 = value;
                        }
                        public String getИст256() {
                            return ист256;
                        }
                        public void setИст256(String value) {
                            this.ист256 = value;
                        }
                        public String getИст257() {
                            return ист257;
                        }
                        public void setИст257(String value) {
                            this.ист257 = value;
                        }
                        public String getИст258() {
                            return ист258;
                        }
                        public void setИст258(String value) {
                            this.ист258 = value;
                        }
                        public String getИст259() {
                            return ист259;
                        }
                        public void setИст259(String value) {
                            this.ист259 = value;
                        }
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "осн10514",
                        "оснРФ10514"
                })
                public static class ОснКонтрСд {

                    @XmlElement(name = "Осн105.14", required = true)
                    protected Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.Осн10514 осн10514;
                    @XmlElement(name = "ОснРФ105.14", required = true)
                    protected Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.ОснРФ10514 оснРФ10514;
                    @XmlAttribute(name = "ВзЗавис")
                    protected String взЗавис;

                    public Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.Осн10514 getОсн10514() {
                        return осн10514;
                    }
                    public void setОсн10514(Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.Осн10514 value) {
                        this.осн10514 = value;
                    }
                    public Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.ОснРФ10514 getОснРФ10514() {
                        return оснРФ10514;
                    }
                    public void setОснРФ10514(Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.ОснРФ10514 value) {
                        this.оснРФ10514 = value;
                    }
                    public String getВзЗавис() {
                        return взЗавис;
                    }
                    public void setВзЗавис(String value) {
                        this.взЗавис = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class Осн10514 {

                        @XmlAttribute(name = "Осн121", required = true)
                        protected String осн121;
                        @XmlAttribute(name = "Осн122", required = true)
                        protected String осн122;
                        @XmlAttribute(name = "Осн123", required = true)
                        protected String осн123;
                        @XmlAttribute(name = "Осн124", required = true)
                        protected String осн124;

                        public String getОсн121() {
                            return осн121;
                        }
                        public void setОсн121(String value) {
                            this.осн121 = value;
                        }
                        public String getОсн122() {
                            return осн122;
                        }
                        public void setОсн122(String value) {
                            this.осн122 = value;
                        }
                        public String getОсн123() {
                            return осн123;
                        }
                        public void setОсн123(String value) {
                            this.осн123 = value;
                        }
                        public String getОсн124() {
                            return осн124;
                        }
                        public void setОсн124(String value) {
                            this.осн124 = value;
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class ОснРФ10514 {

                        @XmlAttribute(name = "Осн131", required = true)
                        protected String осн131;
                        @XmlAttribute(name = "Осн132", required = true)
                        protected String осн132;
                        @XmlAttribute(name = "Осн133", required = true)
                        protected String осн133;
                        @XmlAttribute(name = "Осн134", required = true)
                        protected String осн134;
                        @XmlAttribute(name = "Осн135", required = true)
                        protected String осн135;
                        @XmlAttribute(name = "Осн136", required = true)
                        protected String осн136;
                        @XmlAttribute(name = "Осн137", required = true)
                        protected String осн137;
                        @XmlAttribute(name = "Осн138", required = true)
                        protected String осн138;
                        @XmlAttribute(name = "Осн139", required = true)
                        protected String осн139;
                        @XmlAttribute(name = "Осн140", required = true)
                        protected String осн140;

                        public String getОсн131() {
                            return осн131;
                        }
                        public void setОсн131(String value) {
                            this.осн131 = value;
                        }
                        public String getОсн132() {
                            return осн132;
                        }
                        public void setОсн132(String value) {
                            this.осн132 = value;
                        }
                        public String getОсн133() {
                            return осн133;
                        }
                        public void setОсн133(String value) {
                            this.осн133 = value;
                        }
                        public String getОсн134() {
                            return осн134;
                        }
                        public void setОсн134(String value) {
                            this.осн134 = value;
                        }
                        public String getОсн135() {
                            return осн135;
                        }
                        public void setОсн135(String value) {
                            this.осн135 = value;
                        }
                        public String getОсн136() {
                            return осн136;
                        }
                        public void setОсн136(String value) {
                            this.осн136 = value;
                        }
                        public String getОсн137() {
                            return осн137;
                        }
                        public void setОсн137(String value) {
                            this.осн137 = value;
                        }
                        public String getОсн138() {
                            return осн138;
                        }
                        public void setОсн138(String value) {
                            this.осн138 = value;
                        }
                        public String getОсн139() {
                            return осн139;
                        }
                        public void setОсн139(String value) {
                            this.осн139 = value;
                        }
                        public String getОсн140() {
                            return осн140;
                        }
                        public void setОсн140(String value) {
                            this.осн140 = value;
                        }

                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class СвОргУчаст {

                    @XmlAttribute(name = "НомПорСд", required = true)
                    protected BigInteger номПорСд;
                    @XmlAttribute(name = "СведОтнАгент", required = true)
                    protected String сведОтнАгент;
                    @XmlAttribute(name = "ПрОрг", required = true)
                    protected String прОрг;
                    @XmlAttribute(name = "ОКСМ", required = true)
                    protected String оксм;
                    @XmlAttribute(name = "НаимОргРус", required = true)
                    protected String наимОргРус;
                    @XmlAttribute(name = "НаимОргЛат")
                    protected String наимОргЛат;
                    @XmlAttribute(name = "ИННЮЛ")
                    protected String иннюл;
                    @XmlAttribute(name = "КПП")
                    protected String кпп;
                    @XmlAttribute(name = "РегНомИн")
                    protected String регНомИн;
                    @XmlAttribute(name = "КодНПРег")
                    protected String кодНПРег;
                    @XmlAttribute(name = "АдрИнТекст")
                    protected String адрИнТекст;

                    public BigInteger getНомПорСд() {
                        return номПорСд;
                    }
                    public void setНомПорСд(BigInteger value) {
                        this.номПорСд = value;
                    }
                    public String getСведОтнАгент() {
                        return сведОтнАгент;
                    }
                    public void setСведОтнАгент(String value) {
                        this.сведОтнАгент = value;
                    }
                    public String getПрОрг() {
                        return прОрг;
                    }
                    public void setПрОрг(String value) {
                        this.прОрг = value;
                    }
                    public String getОКСМ() {
                        return оксм;
                    }
                    public void setОКСМ(String value) {
                        this.оксм = value;
                    }
                    public String getНаимОргРус() {
                        return наимОргРус;
                    }
                    public void setНаимОргРус(String value) {
                        this.наимОргРус = value;
                    }
                    public String getНаимОргЛат() {
                        return наимОргЛат;
                    }
                    public void setНаимОргЛат(String value) {
                        this.наимОргЛат = value;
                    }
                    public String getИННЮЛ() {
                        return иннюл;
                    }
                    public void setИННЮЛ(String value) {
                        this.иннюл = value;
                    }
                    public String getКПП() {
                        return кпп;
                    }
                    public void setКПП(String value) {
                        this.кпп = value;
                    }
                    public String getРегНомИн() {
                        return регНомИн;
                    }
                    public void setРегНомИн(String value) {
                        this.регНомИн = value;
                    }
                    public String getКодНПРег() {
                        return кодНПРег;
                    }
                    public void setКодНПРег(String value) {
                        this.кодНПРег = value;
                    }
                    public String getАдрИнТекст() {
                        return адрИнТекст;
                    }
                    public void setАдрИнТекст(String value) {
                        this.адрИнТекст = value;
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "перПредСд"
                })
                public static class СвПредмСдН {

                    @XmlElement(name = "ПерПредСд", required = true)
                    protected List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН.ПерПредСд> перПредСд;

                    @XmlAttribute(name = "ТипПредСд", required = true)
                    protected String типПредСд;

                    public List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН.ПерПредСд> getПерПредСд() {
                        if (перПредСд == null) {
                            перПредСд = new ArrayList<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН.ПерПредСд>();
                        }
                        return this.перПредСд;
                    }
                    public void setПерПредСд(List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН.ПерПредСд> value){
                        this.перПредСд = value;
                    }

                    public String getТипПредСд() {
                        return типПредСд;
                    }
                    public void setТипПредСд(String value) {
                        this.типПредСд = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                            "местОтпрТов",
                            "местСовСд"
                    })
                    public static class ПерПредСд {

                        @XmlElement(name = "МестОтпрТов")
                        protected МестоТип местОтпрТов;
                        @XmlElement(name = "МестСовСд")
                        protected МестоТип местСовСд;

                        @XmlAttribute(name = "НаимПредСд", required = true)
                        protected String наимПредСд;
                        @XmlAttribute(name = "ТНВЭД")
                        protected String тнвэд;
                        @XmlAttribute(name = "ОКПД2")
                        protected String окпд2;
                        @XmlAttribute(name = "ОКВЭД2")
                        protected String оквэд2;
                        @XmlAttribute(name = "НомУчСд", required = true)
                        protected BigInteger номУчСд;
                        @XmlAttribute(name = "НомДог", required = true)
                        protected String номДог;
                        @XmlAttribute(name = "ДатаДог", required = true)
                        protected String датаДог;
                        @XmlAttribute(name = "ОКСМ")
                        protected String оксм;
                        @XmlAttribute(name = "КодУсловПост")
                        protected String кодУсловПост;
                        @XmlAttribute(name = "ОКЕИ")
                        protected String океи;
                        @XmlAttribute(name = "Количество", required = true)
                        protected BigDecimal количество;
                        @XmlAttribute(name = "ЦенаЕдин")
                        protected BigDecimal ценаЕдин;
                        @XmlAttribute(name = "КодВалют")
                        protected String кодВалют;
                        @XmlAttribute(name = "ПроцСтав")
                        protected BigDecimal процСтав;
                        @XmlAttribute(name = "СтоимИтог")
                        protected BigInteger стоимИтог;
                        @XmlAttribute(name = "ДатаСовСд", required = true)
                        protected String датаСовСд;

                        public МестоТип getМестОтпрТов() {
                            return местОтпрТов;
                        }
                        public void setМестОтпрТов(МестоТип value) {
                            this.местОтпрТов = value;
                        }
                        public МестоТип getМестСовСд() {
                            return местСовСд;
                        }
                        public void setМестСовСд(МестоТип value) {
                            this.местСовСд = value;
                        }
                        public String getНаимПредСд() {
                            return наимПредСд;
                        }
                        public void setНаимПредСд(String value) {
                            this.наимПредСд = value;
                        }
                        public String getТНВЭД() {
                            return тнвэд;
                        }
                        public void setТНВЭД(String value) {
                            this.тнвэд = value;
                        }
                        public String getОКПД2() {
                            return окпд2;
                        }
                        public void setОКПД2(String value) {
                            this.окпд2 = value;
                        }
                        public String getОКВЭД2() {
                            return оквэд2;
                        }
                        public void setОКВЭД2(String value) {
                            this.оквэд2 = value;
                        }
                        public BigInteger getНомУчСд() {
                            return номУчСд;
                        }
                        public void setНомУчСд(BigInteger value) {
                            this.номУчСд = value;
                        }
                        public String getНомДог() {
                            return номДог;
                        }
                        public void setНомДог(String value) {
                            this.номДог = value;
                        }
                        public String getДатаДог() {
                            return датаДог;
                        }
                        public void setДатаДог(String value) {
                            this.датаДог = value;
                        }
                        public String getОКСМ() {
                            return оксм;
                        }
                        public void setОКСМ(String value) {
                            this.оксм = value;
                        }
                        public String getКодУсловПост() {
                            return кодУсловПост;
                        }
                        public void setКодУсловПост(String value) {
                            this.кодУсловПост = value;
                        }
                        public String getОКЕИ() {
                            return океи;
                        }
                        public void setОКЕИ(String value) {
                            this.океи = value;
                        }
                        public BigDecimal getКоличество() {
                            return количество;
                        }
                        public void setКоличество(BigDecimal value) {
                            this.количество = value;
                        }
                        public BigDecimal getЦенаЕдин() {
                            return ценаЕдин;
                        }
                        public void setЦенаЕдин(BigDecimal value) {
                            this.ценаЕдин = value;
                        }
                        public String getКодВалют() {
                            return кодВалют;
                        }
                        public void setКодВалют(String value) {
                            this.кодВалют = value;
                        }
                        public BigDecimal getПроцСтав() {
                            return процСтав;
                        }
                        public void setПроцСтав(BigDecimal value) {
                            this.процСтав = value;
                        }
                        public BigInteger getСтоимИтог() {
                            return стоимИтог;
                        }
                        public void setСтоимИтог(BigInteger value) {
                            this.стоимИтог = value;
                        }
                        public String getДатаСовСд() {
                            return датаСовСд;
                        }
                        public void setДатаСовСд(String value) {
                            this.датаСовСд = value;
                        }
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "фио",
                        "иннфл",
                        "свФЛ"
                })
                public static class СвФЛУчаст {

                    @XmlElement(name = "ФИО", required = true)
                    protected ФИОТип фио;
                    @XmlElement(name = "ИННФЛ")
                    protected String иннфл;

                    @XmlElement(name = "СвФЛ")
                    protected Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст.СвФЛ свФЛ;

                    @XmlAttribute(name = "НомПорСд", required = true)
                    protected BigInteger номПорСд;
                    @XmlAttribute(name = "СведОтнАгент", required = true)
                    protected String сведОтнАгент;
                    @XmlAttribute(name = "КодВД", required = true)
                    protected String кодВД;

                    public ФИОТип getФИО() {
                        return фио;
                    }
                    public void setФИО(ФИОТип value) {
                        this.фио = value;
                    }
                    public String getИННФЛ() {
                        return иннфл;
                    }
                    public void setИННФЛ(String value) {
                        this.иннфл = value;
                    }
                    public Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст.СвФЛ getСвФЛ() {
                        return свФЛ;
                    }
                    public void setСвФЛ(Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст.СвФЛ value) {
                        this.свФЛ = value;
                    }
                    public BigInteger getНомПорСд() {
                        return номПорСд;
                    }
                    public void setНомПорСд(BigInteger value) {
                        this.номПорСд = value;
                    }
                    public String getСведОтнАгент() {
                        return сведОтнАгент;
                    }
                    public void setСведОтнАгент(String value) {
                        this.сведОтнАгент = value;
                    }
                    public String getКодВД() {
                        return кодВД;
                    }
                    public void setКодВД(String value) {
                        this.кодВД = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                            "удЛичнФЛ",
                            "адрИн"
                    })
                    public static class СвФЛ {

                        @XmlElement(name = "УдЛичнФЛ", required = true)
                        protected УдЛичнФЛТип удЛичнФЛ;
                        @XmlElement(name = "АдрИн")
                        protected АдрИнТип адрИн;

                        @XmlAttribute(name = "ДатаРожд", required = true)
                        protected String датаРожд;
                        @XmlAttribute(name = "МестоРожд", required = true)
                        protected String местоРожд;
                        @XmlAttribute(name = "Гражд", required = true)
                        protected String гражд;
                        @XmlAttribute(name = "ОКСМ")
                        protected String оксм;

                        public УдЛичнФЛТип getУдЛичнФЛ() {
                            return удЛичнФЛ;
                        }
                        public void setУдЛичнФЛ(УдЛичнФЛТип value) {
                            this.удЛичнФЛ = value;
                        }
                        public АдрИнТип getАдрИн() {
                            return адрИн;
                        }
                        public void setАдрИн(АдрИнТип value) {
                            this.адрИн = value;
                        }
                        public String getДатаРожд() {
                            return датаРожд;
                        }
                        public void setДатаРожд(String value) {
                            this.датаРожд = value;
                        }
                        public String getМестоРожд() {
                            return местоРожд;
                        }
                        public void setМестоРожд(String value) {
                            this.местоРожд = value;
                        }
                        public String getГражд() {
                            return гражд;
                        }
                        public void setГражд(String value) {
                            this.гражд = value;
                        }
                        public String getОКСМ() {
                            return оксм;
                        }
                        public void setОКСМ(String value) {
                            this.оксм = value;
                        }
                    }
                }
            }
        }
    }
}
