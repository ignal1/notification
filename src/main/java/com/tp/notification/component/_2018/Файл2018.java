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
@XmlRootElement(name = "‘айл")
public class ‘айл2018 {

    @XmlElement(name = "ƒокумент", required = true)
    protected ‘айл2018.ƒокумент документ;

    @XmlAttribute(name = "xmlns:xsi", required = true)
    protected String xmlnsXsi = "http://www.w3.org/2001/XMLSchema-instance";
    @XmlAttribute(name = "»д‘айл", required = true)
    protected String ид‘айл;
    @XmlAttribute(name = "¬ерсѕрог", required = true)
    protected String версѕрог;
    @XmlAttribute(name = "¬ерс‘орм", required = true)
    protected String верс‘орм;
    @XmlAttribute(name = "»д‘айл»сх", required = true)
    protected String ид‘айл»сх;
    @XmlAttribute(name = "»д‘айлѕерв", required = true)
    protected String ид‘айлѕерв;
    @XmlAttribute(name = " ол‘айл", required = true)
    protected String кол‘айл;
    @XmlAttribute(name = "Ќом‘айл", required = true)
    protected String ном‘айл;

    public ‘айл2018.ƒокумент getƒокумент() {
        return документ;
    }
    public void setƒокумент(‘айл2018.ƒокумент value) {
        this.документ = value;
    }
    public String get»д‘айл() {
        return ид‘айл;
    }
    public void set»д‘айл(String value) {
        this.ид‘айл = value;
    }
    public String get¬ерсѕрог() {
        return версѕрог;
    }
    public void set¬ерсѕрог(String value) {
        this.версѕрог = value;
    }
    public String get¬ерс‘орм() {
        return верс‘орм;
    }
    public void set¬ерс‘орм(String value) {
        this.верс‘орм = value;
    }
    public String get»д‘айл»сх() {
        return ид‘айл»сх;
    }
    public void set»д‘айл»сх(String value) {
        this.ид‘айл»сх = value;
    }
    public String get»д‘айлѕерв() {
        return ид‘айлѕерв;
    }
    public void set»д‘айлѕерв(String value) {
        this.ид‘айлѕерв = value;
    }
    public String get ол‘айл() {
        return кол‘айл;
    }
    public void set ол‘айл(String value) {
        this.кол‘айл = value;
    }
    public String getЌом‘айл() {
        return ном‘айл;
    }
    public void setЌом‘айл(String value) {
        this.ном‘айл = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "свЌѕ",
            "подписант",
            "ув онтр—д"
    })
    public static class ƒокумент {

        @XmlElement(name = "—вЌѕ", required = true)
        protected ‘айл2018.ƒокумент.—вЌѕ свЌѕ;
        @XmlElement(name = "ѕодписант", required = true)
        protected ‘айл2018.ƒокумент.ѕодписант подписант;
        @XmlElement(name = "”в онтр—д", required = true)
        protected ‘айл2018.ƒокумент.”в онтр—д ув онтр—д;

        @XmlAttribute(name = " Ќƒ", required = true)
        protected String кнд;
        @XmlAttribute(name = "ƒатаƒок", required = true)
        protected String датаƒок;
        @XmlAttribute(name = "ќтчет√од", required = true)
        @XmlSchemaType(name = "gYear")
        protected String отчет√од;
        @XmlAttribute(name = " одЌќ", required = true)
        protected String кодЌќ;
        @XmlAttribute(name = "Ќом орр", required = true)
        protected String ном орр;
        @XmlAttribute(name = "ѕоћесту", required = true)
        protected String поћесту;

        public ‘айл2018.ƒокумент.—вЌѕ get—вЌѕ() {
            return свЌѕ;
        }
        public void set—вЌѕ(‘айл2018.ƒокумент.—вЌѕ value) {
            this.свЌѕ = value;
        }
        public ‘айл2018.ƒокумент.ѕодписант getѕодписант() {
            return подписант;
        }
        public void setѕодписант(‘айл2018.ƒокумент.ѕодписант value) {
            this.подписант = value;
        }
        public ‘айл2018.ƒокумент.”в онтр—д get”в онтр—д() {
            return ув онтр—д;
        }
        public void set”в онтр—д(‘айл2018.ƒокумент.”в онтр—д value) {
            this.ув онтр—д = value;
        }
        public String get Ќƒ() {
            return кнд;
        }
        public void set Ќƒ(String value) {
            this.кнд = value;
        }
        public String getƒатаƒок() {
            return датаƒок;
        }
        public void setƒатаƒок(String value) {
            this.датаƒок = value;
        }
        public String getќтчет√од() {
            return отчет√од;
        }
        public void setќтчет√од(String value) {
            this.отчет√од = value;
        }
        public String get одЌќ() {
            return кодЌќ;
        }
        public void set одЌќ(String value) {
            this.кодЌќ = value;
        }
        public String getЌом орр() {
            return ном орр;
        }
        public void setЌом орр(String value) {
            this.ном орр = value;
        }
        public String getѕоћесту() {
            return поћесту;
        }
        public void setѕоћесту(String value) {
            this.поћесту = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "фио",
                "свѕред"
        })
        public static class ѕодписант {

            @XmlElement(name = "‘»ќ")
            protected ‘»ќ“ип фио;
            @XmlElement(name = "—вѕред")
            protected ‘айл2018.ƒокумент.ѕодписант.—вѕред свѕред;

            @XmlAttribute(name = "ѕрѕодп", required = true)
            protected String прѕодп;

            public ‘»ќ“ип get‘»ќ() {
                return фио;
            }
            public void set‘»ќ(‘»ќ“ип value) {
                this.фио = value;
            }
            public ‘айл2018.ƒокумент.ѕодписант.—вѕред get—вѕред() {
                return свѕред;
            }
            public void set—вѕред(‘айл2018.ƒокумент.ѕодписант.—вѕред value) {
                this.свѕред = value;
            }
            public String getѕрѕодп() {
                return прѕодп;
            }
            public void setѕрѕодп(String value) {
                this.прѕодп = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class —вѕред {

                @XmlAttribute(name = "Ќаимƒок", required = true)
                protected String наимƒок;
                @XmlAttribute(name = "Ќаимќрг")
                protected String наимќрг;

                public String getЌаимƒок() {
                    return наимƒок;
                }
                public void setЌаимƒок(String value) {
                    this.наимƒок = value;
                }
                public String getЌаимќрг() {
                    return наимќрг;
                }
                public void setЌаимќрг(String value) {
                    this.наимќрг = value;
                }
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "нпюл",
                "нпфл"
        })
        public static class —вЌѕ {

            @XmlElement(name = "ЌѕёЋ")
            protected ‘айл2018.ƒокумент.—вЌѕ.ЌѕёЋ нпюл;
            @XmlElement(name = "Ќѕ‘Ћ")
            protected ‘айл2018.ƒокумент.—вЌѕ.Ќѕ‘Ћ нпфл;

            @XmlAttribute(name = "ќ “ћќ", required = true)
            protected String октмо;
            @XmlAttribute(name = "“лф")
            protected String тлф;
            @XmlAttribute(name = "E-mail")
            protected String eMail;

            public ‘айл2018.ƒокумент.—вЌѕ.ЌѕёЋ getЌѕёЋ() {
                return нпюл;
            }
            public void setЌѕёЋ(‘айл2018.ƒокумент.—вЌѕ.ЌѕёЋ value) {
                this.нпюл = value;
            }
            public ‘айл2018.ƒокумент.—вЌѕ.Ќѕ‘Ћ getЌѕ‘Ћ() {
                return нпфл;
            }
            public void setЌѕ‘Ћ(‘айл2018.ƒокумент.—вЌѕ.Ќѕ‘Ћ value) {
                this.нпфл = value;
            }
            public String getќ “ћќ() {
                return октмо;
            }
            public void setќ “ћќ(String value) {
                this.октмо = value;
            }
            public String get“лф() {
                return тлф;
            }
            public void set“лф(String value) {
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
                    "св‘Ћ"
            })
            public static class Ќѕ‘Ћ {

                @XmlElement(name = "‘»ќ", required = true)
                protected ‘»ќ“ип фио;
                @XmlElement(name = "»ЌЌ‘Ћ")
                protected String иннфл;
                @XmlElement(name = "—в‘Ћ")
                protected ‘айл2018.ƒокумент.—вЌѕ.Ќѕ‘Ћ.—в‘Ћ св‘Ћ;

                public ‘»ќ“ип get‘»ќ() {
                    return фио;
                }
                public void set‘»ќ(‘»ќ“ип value) {
                    this.фио = value;
                }
                public String get»ЌЌ‘Ћ() {
                    return иннфл;
                }
                public void set»ЌЌ‘Ћ(String value) {
                    this.иннфл = value;
                }
                public ‘айл2018.ƒокумент.—вЌѕ.Ќѕ‘Ћ.—в‘Ћ get—в‘Ћ() {
                    return св‘Ћ;
                }
                public void set—в‘Ћ(‘айл2018.ƒокумент.—вЌѕ.Ќѕ‘Ћ.—в‘Ћ value) {
                    this.св‘Ћ = value;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "удЋичн‘Ћ",
                        "адр»н"
                })
                public static class —в‘Ћ {

                    @XmlElement(name = "”дЋичн‘Ћ", required = true)
                    protected ”дЋичн‘Ћ“ип удЋичн‘Ћ;
                    @XmlElement(name = "јдр»н")
                    protected јдр»н“ип адр»н;

                    @XmlAttribute(name = "ƒата–ожд", required = true)
                    protected String дата–ожд;
                    @XmlAttribute(name = "ћесто–ожд", required = true)
                    protected String место–ожд;
                    @XmlAttribute(name = "√ражд", required = true)
                    protected String гражд;
                    @XmlAttribute(name = "ќ —ћ", required = true)
                    protected String оксм;
                    @XmlAttribute(name = "—татусЌѕ", required = true)
                    protected String статусЌѕ;

                    public ”дЋичн‘Ћ“ип get”дЋичн‘Ћ() {
                        return удЋичн‘Ћ;
                    }
                    public void set”дЋичн‘Ћ(”дЋичн‘Ћ“ип value) {
                        this.удЋичн‘Ћ = value;
                    }
                    public јдр»н“ип getјдр»н() {
                        return адр»н;
                    }
                    public void setјдр»н(јдр»н“ип value) {
                        this.адр»н = value;
                    }
                    public String getƒата–ожд() {
                        return дата–ожд;
                    }
                    public void setƒата–ожд(String value) {
                        this.дата–ожд = value;
                    }
                    public String getћесто–ожд() {
                        return место–ожд;
                    }
                    public void setћесто–ожд(String value) {
                        this.место–ожд = value;
                    }
                    public String get√ражд() {
                        return гражд;
                    }
                    public void set√ражд(String value) {
                        this.гражд = value;
                    }
                    public String getќ —ћ() {
                        return оксм;
                    }
                    public void setќ —ћ(String value) {
                        this.оксм = value;
                    }
                    public String get—татусЌѕ() {
                        return статусЌѕ;
                    }
                    public void set—татусЌѕ(String value) {
                        this.статусЌѕ = value;
                    }
                }
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "св–еоргёЋ"
            })
            public static class ЌѕёЋ {

                @XmlElement(name = "—в–еоргёЋ")
                protected ‘айл2018.ƒокумент.—вЌѕ.ЌѕёЋ.—в–еоргёЋ св–еоргёЋ;

                @XmlAttribute(name = "Ќаимќрг", required = true)
                protected String наимќрг;
                @XmlAttribute(name = "»ЌЌёЋ", required = true)
                protected String иннюл;
                @XmlAttribute(name = " ѕѕ", required = true)
                protected String кпп;

                public ‘айл2018.ƒокумент.—вЌѕ.ЌѕёЋ.—в–еоргёЋ get—в–еоргёЋ() {
                    return св–еоргёЋ;
                }
                public void set—в–еоргёЋ(‘айл2018.ƒокумент.—вЌѕ.ЌѕёЋ.—в–еоргёЋ value) {
                    this.св–еоргёЋ = value;
                }
                public String getЌаимќрг() {
                    return наимќрг;
                }
                public void setЌаимќрг(String value) {
                    this.наимќрг = value;
                }
                public String get»ЌЌёЋ() {
                    return иннюл;
                }
                public void set»ЌЌёЋ(String value) {
                    this.иннюл = value;
                }
                public String get ѕѕ() {
                    return кпп;
                }
                public void set ѕѕ(String value) {
                    this.кпп = value;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class —в–еоргёЋ {

                    @XmlAttribute(name = "‘орм–еорг", required = true)
                    protected String форм–еорг;
                    @XmlAttribute(name = "»ЌЌёЋ")
                    protected String иннюл;
                    @XmlAttribute(name = " ѕѕ")
                    protected String кпп;

                    public String get‘орм–еорг() {
                        return форм–еорг;
                    }
                    public void set‘орм–еорг(String value) {
                        this.форм–еорг = value;
                    }
                    public String get»ЌЌёЋ() {
                        return иннюл;
                    }
                    public void set»ЌЌёЋ(String value) {
                        this.иннюл = value;
                    }
                    public String get ѕѕ() {
                        return кпп;
                    }
                    public void set ѕѕ(String value) {
                        this.кпп = value;
                    }
                }
            }
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "св онтр—д"
        })
        public static class ”в онтр—д {

            @XmlElement(name = "—в онтр—д", required = true)
            protected List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д> св онтр—д;

            public List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д> get—в онтр—д() {
                if (св онтр—д == null) {
                    св онтр—д = new ArrayList<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д>();
                }
                return this.св онтр—д;
            }

            public void set—в онтр—д(List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д> value) {
                this.св онтр—д = value;
            }


            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "осн онтр—д",
                    "контр—д",
                    "дох–асх—д",
                    "свѕредм—дЌ",
                    "свќрг”част",
                    "св‘Ћ”част"
            })
            public static class —в онтр—д {

                @XmlElement(name = "ќсн онтр—д", required = true)
                protected ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д осн онтр—д;
                @XmlElement(name = " онтр—д", required = true)
                protected ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д контр—д;
                @XmlElement(name = "ƒох–асх—д", required = true)
                protected ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ƒох–асх—д дох–асх—д;
                @XmlElement(name = "—вѕредм—дЌ", required = true)
                protected List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ> свѕредм—дЌ;
                @XmlElement(name = "—вќрг”част")
                protected List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част> свќрг”част;
                @XmlElement(name = "—в‘Ћ”част")
                protected List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част> св‘Ћ”част;
                @XmlAttribute(name = "Ќомѕор—д", required = true)
                protected BigInteger номѕор—д;
                @XmlAttribute(name = "—делка—овјгент", required = true)
                protected String сделка—овјгент;

                public ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д getќсн онтр—д() {
                    return осн онтр—д;
                }
                public void setќсн онтр—д(‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д value) {
                    this.осн онтр—д = value;
                }
                public ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д get онтр—д() {
                    return контр—д;
                }
                public void set онтр—д(‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д value) {
                    this.контр—д = value;
                }
                public ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ƒох–асх—д getƒох–асх—д() {
                    return дох–асх—д;
                }
                public void setƒох–асх—д(‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ƒох–асх—д value) {
                    this.дох–асх—д = value;
                }

                public List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ> get—вѕредм—дЌ() {
                    if (свѕредм—дЌ == null) {
                        свѕредм—дЌ = new ArrayList<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ>();
                    }
                    return this.свѕредм—дЌ;
                }
                public void set—вѕредм—дЌ(List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ> value){
                    this.свѕредм—дЌ = value;
                }

                public List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част> get—вќрг”част() {
                    if (свќрг”част == null) {
                        свќрг”част = new ArrayList<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част>();
                    }
                    return this.свќрг”част;
                }
                public void set—вќрг”част(List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част> value){
                    this.свќрг”част = value;
                }

                public List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част> get—в‘Ћ”част() {
                    if (св‘Ћ”част == null) {
                        св‘Ћ”част = new ArrayList<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част>();
                    }
                    return this.св‘Ћ”част;
                }
                public void set—в‘Ћ”част(List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част> value){
                    this.св‘Ћ”част = value;
                }

                public BigInteger getЌомѕор—д() {
                    return номѕор—д;
                }
                public void setЌомѕор—д(BigInteger value) {
                    this.номѕор—д = value;
                }
                public String get—делка—овјгент() {
                    return сделка—овјгент;
                }
                public void set—делка—овјгент(String value) {
                    this.сделка—овјгент = value;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class ƒох–асх—д {

                    @XmlAttribute(name = "—умƒох—д", required = true)
                    protected BigInteger сумƒох—д;
                    @XmlAttribute(name = "—умƒох—д–ег")
                    protected BigInteger сумƒох—д–ег;
                    @XmlAttribute(name = "—ум–асх—д", required = true)
                    protected BigInteger сум–асх—д;
                    @XmlAttribute(name = "—ум–асх—д–ег")
                    protected BigInteger сум–асх—д–ег;

                    public BigInteger get—умƒох—д() {
                        return сумƒох—д;
                    }
                    public void set—умƒох—д(BigInteger value) {
                        this.сумƒох—д = value;
                    }
                    public BigInteger get—умƒох—д–ег() {
                        return сумƒох—д–ег;
                    }
                    public void set—умƒох—д–ег(BigInteger value) {
                        this.сумƒох—д–ег = value;
                    }
                    public BigInteger get—ум–асх—д() {
                        return сум–асх—д;
                    }
                    public void set—ум–асх—д(BigInteger value) {
                        this.сум–асх—д = value;
                    }
                    public BigInteger get—ум–асх—д–ег() {
                        return сум–асх—д–ег;
                    }
                    public void set—ум–асх—д–ег(BigInteger value) {
                        this.сум–асх—д–ег = value;
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "код»ст»нф"
                })
                public static class  онтр—д {

                    @XmlElement(name = " од»ст»нф")
                    protected ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д. од»ст»нф код»ст»нф;

                    @XmlAttribute(name = "√рупќ—", required = true)
                    protected String групќ—;
                    @XmlAttribute(name = " одЌаим—д", required = true)
                    protected String кодЌаим—д;
                    @XmlAttribute(name = " од—тор—д", required = true)
                    protected String код—тор—д;
                    @XmlAttribute(name = "ѕрќпр÷ен", required = true)
                    protected String прќпр÷ен;
                    @XmlAttribute(name = " омѕрќпр÷ен")
                    protected String комѕрќпр÷ен;
                    @XmlAttribute(name = " одќпр÷ен", required = true)
                    protected String кодќпр÷ен;
                    @XmlAttribute(name = " ом одќпр÷ен")
                    protected String ком одќпр÷ен;
                    @XmlAttribute(name = " одћет÷ен")
                    protected String кодћет÷ен;
                    @XmlAttribute(name = " ом одћет÷ен")
                    protected String ком одћет÷ен;
                    @XmlAttribute(name = " ол”ч—д", required = true)
                    protected BigInteger кол”ч—д;
                    @XmlAttribute(name = " ом ол”ч—д")
                    protected String ком ол”ч—д;

                    public ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д. од»ст»нф get од»ст»нф() {
                        return код»ст»нф;
                    }
                    public void set од»ст»нф(‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д. од»ст»нф value) {
                        this.код»ст»нф = value;
                    }
                    public String get√рупќ—() {
                        return групќ—;
                    }
                    public void set√рупќ—(String value) {
                        this.групќ— = value;
                    }
                    public String get одЌаим—д() {
                        return кодЌаим—д;
                    }
                    public void set одЌаим—д(String value) {
                        this.кодЌаим—д = value;
                    }
                    public String get од—тор—д() {
                        return код—тор—д;
                    }
                    public void set од—тор—д(String value) {
                        this.код—тор—д = value;
                    }
                    public String getѕрќпр÷ен() {
                        return прќпр÷ен;
                    }
                    public void setѕрќпр÷ен(String value) {
                        this.прќпр÷ен = value;
                    }
                    public String get омѕрќпр÷ен() {
                        return комѕрќпр÷ен;
                    }
                    public void set омѕрќпр÷ен(String value) {
                        this.комѕрќпр÷ен = value;
                    }
                    public String get одќпр÷ен() {
                        return кодќпр÷ен;
                    }
                    public void set одќпр÷ен(String value) {
                        this.кодќпр÷ен = value;
                    }
                    public String get ом одќпр÷ен() {
                        return ком одќпр÷ен;
                    }
                    public void set ом одќпр÷ен(String value) {
                        this.ком одќпр÷ен = value;
                    }
                    public String get одћет÷ен() {
                        return кодћет÷ен;
                    }
                    public void set одћет÷ен(String value) {
                        this.кодћет÷ен = value;
                    }
                    public String get ом одћет÷ен() {
                        return ком одћет÷ен;
                    }
                    public void set ом одћет÷ен(String value) {
                        this.ком одћет÷ен = value;
                    }
                    public BigInteger get ол”ч—д() {
                        return кол”ч—д;
                    }
                    public void set ол”ч—д(BigInteger value) {
                        this.кол”ч—д = value;
                    }
                    public String get ом ол”ч—д() {
                        return ком ол”ч—д;
                    }
                    public void set ом ол”ч—д(String value) {
                        this.ком ол”ч—д = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class  од»ст»нф {

                        @XmlAttribute(name = "»ст251", required = true)
                        protected String ист251;
                        @XmlAttribute(name = "»ст252", required = true)
                        protected String ист252;
                        @XmlAttribute(name = "»ст253", required = true)
                        protected String ист253;
                        @XmlAttribute(name = "»ст254", required = true)
                        protected String ист254;
                        @XmlAttribute(name = "»ст255", required = true)
                        protected String ист255;
                        @XmlAttribute(name = "»ст256", required = true)
                        protected String ист256;
                        @XmlAttribute(name = "»ст257", required = true)
                        protected String ист257;
                        @XmlAttribute(name = "»ст258", required = true)
                        protected String ист258;
                        @XmlAttribute(name = "»ст259", required = true)
                        protected String ист259;

                        public String get»ст251() {
                            return ист251;
                        }
                        public void set»ст251(String value) {
                            this.ист251 = value;
                        }
                        public String get»ст252() {
                            return ист252;
                        }
                        public void set»ст252(String value) {
                            this.ист252 = value;
                        }
                        public String get»ст253() {
                            return ист253;
                        }
                        public void set»ст253(String value) {
                            this.ист253 = value;
                        }
                        public String get»ст254() {
                            return ист254;
                        }
                        public void set»ст254(String value) {
                            this.ист254 = value;
                        }
                        public String get»ст255() {
                            return ист255;
                        }
                        public void set»ст255(String value) {
                            this.ист255 = value;
                        }
                        public String get»ст256() {
                            return ист256;
                        }
                        public void set»ст256(String value) {
                            this.ист256 = value;
                        }
                        public String get»ст257() {
                            return ист257;
                        }
                        public void set»ст257(String value) {
                            this.ист257 = value;
                        }
                        public String get»ст258() {
                            return ист258;
                        }
                        public void set»ст258(String value) {
                            this.ист258 = value;
                        }
                        public String get»ст259() {
                            return ист259;
                        }
                        public void set»ст259(String value) {
                            this.ист259 = value;
                        }
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "осн10514",
                        "осн–‘10514"
                })
                public static class ќсн онтр—д {

                    @XmlElement(name = "ќсн105.14", required = true)
                    protected ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн10514 осн10514;
                    @XmlElement(name = "ќсн–‘105.14", required = true)
                    protected ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн–‘10514 осн–‘10514;
                    @XmlAttribute(name = "¬з«авис")
                    protected String вз«авис;

                    public ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн10514 getќсн10514() {
                        return осн10514;
                    }
                    public void setќсн10514(‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн10514 value) {
                        this.осн10514 = value;
                    }
                    public ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн–‘10514 getќсн–‘10514() {
                        return осн–‘10514;
                    }
                    public void setќсн–‘10514(‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн–‘10514 value) {
                        this.осн–‘10514 = value;
                    }
                    public String get¬з«авис() {
                        return вз«авис;
                    }
                    public void set¬з«авис(String value) {
                        this.вз«авис = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class ќсн10514 {

                        @XmlAttribute(name = "ќсн121", required = true)
                        protected String осн121;
                        @XmlAttribute(name = "ќсн122", required = true)
                        protected String осн122;
                        @XmlAttribute(name = "ќсн123", required = true)
                        protected String осн123;
                        @XmlAttribute(name = "ќсн124", required = true)
                        protected String осн124;

                        public String getќсн121() {
                            return осн121;
                        }
                        public void setќсн121(String value) {
                            this.осн121 = value;
                        }
                        public String getќсн122() {
                            return осн122;
                        }
                        public void setќсн122(String value) {
                            this.осн122 = value;
                        }
                        public String getќсн123() {
                            return осн123;
                        }
                        public void setќсн123(String value) {
                            this.осн123 = value;
                        }
                        public String getќсн124() {
                            return осн124;
                        }
                        public void setќсн124(String value) {
                            this.осн124 = value;
                        }
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class ќсн–‘10514 {

                        @XmlAttribute(name = "ќсн131", required = true)
                        protected String осн131;
                        @XmlAttribute(name = "ќсн132", required = true)
                        protected String осн132;
                        @XmlAttribute(name = "ќсн133", required = true)
                        protected String осн133;
                        @XmlAttribute(name = "ќсн134", required = true)
                        protected String осн134;
                        @XmlAttribute(name = "ќсн135", required = true)
                        protected String осн135;
                        @XmlAttribute(name = "ќсн136", required = true)
                        protected String осн136;
                        @XmlAttribute(name = "ќсн137", required = true)
                        protected String осн137;
                        @XmlAttribute(name = "ќсн138", required = true)
                        protected String осн138;
                        @XmlAttribute(name = "ќсн139", required = true)
                        protected String осн139;
                        @XmlAttribute(name = "ќсн140", required = true)
                        protected String осн140;

                        public String getќсн131() {
                            return осн131;
                        }
                        public void setќсн131(String value) {
                            this.осн131 = value;
                        }
                        public String getќсн132() {
                            return осн132;
                        }
                        public void setќсн132(String value) {
                            this.осн132 = value;
                        }
                        public String getќсн133() {
                            return осн133;
                        }
                        public void setќсн133(String value) {
                            this.осн133 = value;
                        }
                        public String getќсн134() {
                            return осн134;
                        }
                        public void setќсн134(String value) {
                            this.осн134 = value;
                        }
                        public String getќсн135() {
                            return осн135;
                        }
                        public void setќсн135(String value) {
                            this.осн135 = value;
                        }
                        public String getќсн136() {
                            return осн136;
                        }
                        public void setќсн136(String value) {
                            this.осн136 = value;
                        }
                        public String getќсн137() {
                            return осн137;
                        }
                        public void setќсн137(String value) {
                            this.осн137 = value;
                        }
                        public String getќсн138() {
                            return осн138;
                        }
                        public void setќсн138(String value) {
                            this.осн138 = value;
                        }
                        public String getќсн139() {
                            return осн139;
                        }
                        public void setќсн139(String value) {
                            this.осн139 = value;
                        }
                        public String getќсн140() {
                            return осн140;
                        }
                        public void setќсн140(String value) {
                            this.осн140 = value;
                        }

                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class —вќрг”част {

                    @XmlAttribute(name = "Ќомѕор—д", required = true)
                    protected BigInteger номѕор—д;
                    @XmlAttribute(name = "—ведќтнјгент", required = true)
                    protected String сведќтнјгент;
                    @XmlAttribute(name = "ѕрќрг", required = true)
                    protected String прќрг;
                    @XmlAttribute(name = "ќ —ћ", required = true)
                    protected String оксм;
                    @XmlAttribute(name = "Ќаимќрг–ус", required = true)
                    protected String наимќрг–ус;
                    @XmlAttribute(name = "ЌаимќргЋат")
                    protected String наимќргЋат;
                    @XmlAttribute(name = "»ЌЌёЋ")
                    protected String иннюл;
                    @XmlAttribute(name = " ѕѕ")
                    protected String кпп;
                    @XmlAttribute(name = "–егЌом»н")
                    protected String регЌом»н;
                    @XmlAttribute(name = " одЌѕ–ег")
                    protected String кодЌѕ–ег;
                    @XmlAttribute(name = "јдр»н“екст")
                    protected String адр»н“екст;

                    public BigInteger getЌомѕор—д() {
                        return номѕор—д;
                    }
                    public void setЌомѕор—д(BigInteger value) {
                        this.номѕор—д = value;
                    }
                    public String get—ведќтнјгент() {
                        return сведќтнјгент;
                    }
                    public void set—ведќтнјгент(String value) {
                        this.сведќтнјгент = value;
                    }
                    public String getѕрќрг() {
                        return прќрг;
                    }
                    public void setѕрќрг(String value) {
                        this.прќрг = value;
                    }
                    public String getќ —ћ() {
                        return оксм;
                    }
                    public void setќ —ћ(String value) {
                        this.оксм = value;
                    }
                    public String getЌаимќрг–ус() {
                        return наимќрг–ус;
                    }
                    public void setЌаимќрг–ус(String value) {
                        this.наимќрг–ус = value;
                    }
                    public String getЌаимќргЋат() {
                        return наимќргЋат;
                    }
                    public void setЌаимќргЋат(String value) {
                        this.наимќргЋат = value;
                    }
                    public String get»ЌЌёЋ() {
                        return иннюл;
                    }
                    public void set»ЌЌёЋ(String value) {
                        this.иннюл = value;
                    }
                    public String get ѕѕ() {
                        return кпп;
                    }
                    public void set ѕѕ(String value) {
                        this.кпп = value;
                    }
                    public String get–егЌом»н() {
                        return регЌом»н;
                    }
                    public void set–егЌом»н(String value) {
                        this.регЌом»н = value;
                    }
                    public String get одЌѕ–ег() {
                        return кодЌѕ–ег;
                    }
                    public void set одЌѕ–ег(String value) {
                        this.кодЌѕ–ег = value;
                    }
                    public String getјдр»н“екст() {
                        return адр»н“екст;
                    }
                    public void setјдр»н“екст(String value) {
                        this.адр»н“екст = value;
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "перѕред—д"
                })
                public static class —вѕредм—дЌ {

                    @XmlElement(name = "ѕерѕред—д", required = true)
                    protected List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ.ѕерѕред—д> перѕред—д;

                    @XmlAttribute(name = "“ипѕред—д", required = true)
                    protected String типѕред—д;

                    public List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ.ѕерѕред—д> getѕерѕред—д() {
                        if (перѕред—д == null) {
                            перѕред—д = new ArrayList<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ.ѕерѕред—д>();
                        }
                        return this.перѕред—д;
                    }
                    public void setѕерѕред—д(List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ.ѕерѕред—д> value){
                        this.перѕред—д = value;
                    }

                    public String get“ипѕред—д() {
                        return типѕред—д;
                    }
                    public void set“ипѕред—д(String value) {
                        this.типѕред—д = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                            "местќтпр“ов",
                            "мест—ов—д"
                    })
                    public static class ѕерѕред—д {

                        @XmlElement(name = "ћестќтпр“ов")
                        protected ћесто“ип местќтпр“ов;
                        @XmlElement(name = "ћест—ов—д")
                        protected ћесто“ип мест—ов—д;

                        @XmlAttribute(name = "Ќаимѕред—д", required = true)
                        protected String наимѕред—д;
                        @XmlAttribute(name = "“Ќ¬Ёƒ")
                        protected String тнвэд;
                        @XmlAttribute(name = "ќ ѕƒ2")
                        protected String окпд2;
                        @XmlAttribute(name = "ќ ¬Ёƒ2")
                        protected String оквэд2;
                        @XmlAttribute(name = "Ќом”ч—д", required = true)
                        protected BigInteger ном”ч—д;
                        @XmlAttribute(name = "Ќомƒог", required = true)
                        protected String номƒог;
                        @XmlAttribute(name = "ƒатаƒог", required = true)
                        protected String датаƒог;
                        @XmlAttribute(name = "ќ —ћ")
                        protected String оксм;
                        @XmlAttribute(name = " од”словѕост")
                        protected String код”словѕост;
                        @XmlAttribute(name = "ќ ≈»")
                        protected String океи;
                        @XmlAttribute(name = " оличество", required = true)
                        protected BigDecimal количество;
                        @XmlAttribute(name = "÷ена≈дин")
                        protected BigDecimal цена≈дин;
                        @XmlAttribute(name = " од¬алют")
                        protected String код¬алют;
                        @XmlAttribute(name = "ѕроц—тав")
                        protected BigDecimal проц—тав;
                        @XmlAttribute(name = "—тоим»тог")
                        protected BigInteger стоим»тог;
                        @XmlAttribute(name = "ƒата—ов—д", required = true)
                        protected String дата—ов—д;

                        public ћесто“ип getћестќтпр“ов() {
                            return местќтпр“ов;
                        }
                        public void setћестќтпр“ов(ћесто“ип value) {
                            this.местќтпр“ов = value;
                        }
                        public ћесто“ип getћест—ов—д() {
                            return мест—ов—д;
                        }
                        public void setћест—ов—д(ћесто“ип value) {
                            this.мест—ов—д = value;
                        }
                        public String getЌаимѕред—д() {
                            return наимѕред—д;
                        }
                        public void setЌаимѕред—д(String value) {
                            this.наимѕред—д = value;
                        }
                        public String get“Ќ¬Ёƒ() {
                            return тнвэд;
                        }
                        public void set“Ќ¬Ёƒ(String value) {
                            this.тнвэд = value;
                        }
                        public String getќ ѕƒ2() {
                            return окпд2;
                        }
                        public void setќ ѕƒ2(String value) {
                            this.окпд2 = value;
                        }
                        public String getќ ¬Ёƒ2() {
                            return оквэд2;
                        }
                        public void setќ ¬Ёƒ2(String value) {
                            this.оквэд2 = value;
                        }
                        public BigInteger getЌом”ч—д() {
                            return ном”ч—д;
                        }
                        public void setЌом”ч—д(BigInteger value) {
                            this.ном”ч—д = value;
                        }
                        public String getЌомƒог() {
                            return номƒог;
                        }
                        public void setЌомƒог(String value) {
                            this.номƒог = value;
                        }
                        public String getƒатаƒог() {
                            return датаƒог;
                        }
                        public void setƒатаƒог(String value) {
                            this.датаƒог = value;
                        }
                        public String getќ —ћ() {
                            return оксм;
                        }
                        public void setќ —ћ(String value) {
                            this.оксм = value;
                        }
                        public String get од”словѕост() {
                            return код”словѕост;
                        }
                        public void set од”словѕост(String value) {
                            this.код”словѕост = value;
                        }
                        public String getќ ≈»() {
                            return океи;
                        }
                        public void setќ ≈»(String value) {
                            this.океи = value;
                        }
                        public BigDecimal get оличество() {
                            return количество;
                        }
                        public void set оличество(BigDecimal value) {
                            this.количество = value;
                        }
                        public BigDecimal get÷ена≈дин() {
                            return цена≈дин;
                        }
                        public void set÷ена≈дин(BigDecimal value) {
                            this.цена≈дин = value;
                        }
                        public String get од¬алют() {
                            return код¬алют;
                        }
                        public void set од¬алют(String value) {
                            this.код¬алют = value;
                        }
                        public BigDecimal getѕроц—тав() {
                            return проц—тав;
                        }
                        public void setѕроц—тав(BigDecimal value) {
                            this.проц—тав = value;
                        }
                        public BigInteger get—тоим»тог() {
                            return стоим»тог;
                        }
                        public void set—тоим»тог(BigInteger value) {
                            this.стоим»тог = value;
                        }
                        public String getƒата—ов—д() {
                            return дата—ов—д;
                        }
                        public void setƒата—ов—д(String value) {
                            this.дата—ов—д = value;
                        }
                    }
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "фио",
                        "иннфл",
                        "св‘Ћ"
                })
                public static class —в‘Ћ”част {

                    @XmlElement(name = "‘»ќ", required = true)
                    protected ‘»ќ“ип фио;
                    @XmlElement(name = "»ЌЌ‘Ћ")
                    protected String иннфл;

                    @XmlElement(name = "—в‘Ћ")
                    protected ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част.—в‘Ћ св‘Ћ;

                    @XmlAttribute(name = "Ќомѕор—д", required = true)
                    protected BigInteger номѕор—д;
                    @XmlAttribute(name = "—ведќтнјгент", required = true)
                    protected String сведќтнјгент;
                    @XmlAttribute(name = " од¬ƒ", required = true)
                    protected String код¬ƒ;

                    public ‘»ќ“ип get‘»ќ() {
                        return фио;
                    }
                    public void set‘»ќ(‘»ќ“ип value) {
                        this.фио = value;
                    }
                    public String get»ЌЌ‘Ћ() {
                        return иннфл;
                    }
                    public void set»ЌЌ‘Ћ(String value) {
                        this.иннфл = value;
                    }
                    public ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част.—в‘Ћ get—в‘Ћ() {
                        return св‘Ћ;
                    }
                    public void set—в‘Ћ(‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част.—в‘Ћ value) {
                        this.св‘Ћ = value;
                    }
                    public BigInteger getЌомѕор—д() {
                        return номѕор—д;
                    }
                    public void setЌомѕор—д(BigInteger value) {
                        this.номѕор—д = value;
                    }
                    public String get—ведќтнјгент() {
                        return сведќтнјгент;
                    }
                    public void set—ведќтнјгент(String value) {
                        this.сведќтнјгент = value;
                    }
                    public String get од¬ƒ() {
                        return код¬ƒ;
                    }
                    public void set од¬ƒ(String value) {
                        this.код¬ƒ = value;
                    }

                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                            "удЋичн‘Ћ",
                            "адр»н"
                    })
                    public static class —в‘Ћ {

                        @XmlElement(name = "”дЋичн‘Ћ", required = true)
                        protected ”дЋичн‘Ћ“ип удЋичн‘Ћ;
                        @XmlElement(name = "јдр»н")
                        protected јдр»н“ип адр»н;

                        @XmlAttribute(name = "ƒата–ожд", required = true)
                        protected String дата–ожд;
                        @XmlAttribute(name = "ћесто–ожд", required = true)
                        protected String место–ожд;
                        @XmlAttribute(name = "√ражд", required = true)
                        protected String гражд;
                        @XmlAttribute(name = "ќ —ћ")
                        protected String оксм;

                        public ”дЋичн‘Ћ“ип get”дЋичн‘Ћ() {
                            return удЋичн‘Ћ;
                        }
                        public void set”дЋичн‘Ћ(”дЋичн‘Ћ“ип value) {
                            this.удЋичн‘Ћ = value;
                        }
                        public јдр»н“ип getјдр»н() {
                            return адр»н;
                        }
                        public void setјдр»н(јдр»н“ип value) {
                            this.адр»н = value;
                        }
                        public String getƒата–ожд() {
                            return дата–ожд;
                        }
                        public void setƒата–ожд(String value) {
                            this.дата–ожд = value;
                        }
                        public String getћесто–ожд() {
                            return место–ожд;
                        }
                        public void setћесто–ожд(String value) {
                            this.место–ожд = value;
                        }
                        public String get√ражд() {
                            return гражд;
                        }
                        public void set√ражд(String value) {
                            this.гражд = value;
                        }
                        public String getќ —ћ() {
                            return оксм;
                        }
                        public void setќ —ћ(String value) {
                            this.оксм = value;
                        }
                    }
                }
            }
        }
    }
}
