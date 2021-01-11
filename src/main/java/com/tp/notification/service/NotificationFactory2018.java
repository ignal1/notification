package com.tp.notification.service;

import com.tp.notification.component._2018.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
class NotificationFactory2018 {

    @Autowired
    FileService fileService;

    private List<String[]> transactions;
    private List<String[]> partiesOrganizations;
    private List<String[]> partiesPersons;
    private List<String[]> subjects;
    private List<String> taxpayer;

    public void setFields(){
        transactions = fileService.getTransactions();
        partiesOrganizations = fileService.getPartiesOrganizations();
        partiesPersons = fileService.getPartiesPersons();
        subjects = fileService.getSubjects();
        taxpayer = fileService.getTaxpayer();
    }

    private List<Файл2018.Документ.УвКонтрСд.СвКонтрСд> transactionsFilling(){
        List<Файл2018.Документ.УвКонтрСд.СвКонтрСд> свКонтрСдСписок = null;
        if(transactions.size() != 0){
            свКонтрСдСписок = new ArrayList<>();
            for(String[] item : transactions){
                Файл2018.Документ.УвКонтрСд.СвКонтрСд свКонтрСд = new Файл2018.Документ.УвКонтрСд.СвКонтрСд();
                Integer numOfTransaction = Integer.parseInt(item[0]);
                свКонтрСд.setДохРасхСд(дохРасхСдМетод(numOfTransaction - 1));
                свКонтрСд.setКонтрСд(контрСдМетод(numOfTransaction - 1));
                свКонтрСд.setОснКонтрСд(оснКонтрСдМетод(numOfTransaction - 1));
                свКонтрСд.setСвПредмСдН(свПредмСдНМетод(numOfTransaction));
                свКонтрСд.setСвОргУчаст(свОргУчастМетод(numOfTransaction));
                свКонтрСд.setСвФЛУчаст(свФЛУчастМетод(numOfTransaction));
                свКонтрСд.setНомПорСд(BigInteger.valueOf(numOfTransaction));
                свКонтрСд.setСделкаСовАгент(item[1]);
                свКонтрСдСписок.add(свКонтрСд);
            }
        }
        return свКонтрСдСписок;
    }

    private List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст> свОргУчастМетод(Integer numOfTransaction){
        List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст> свОргУчастСписок = null;
        if(partiesOrganizations.size() != 0){
            свОргУчастСписок = new ArrayList<>();
            for(String[] item : partiesOrganizations){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст свОргУчаст = new Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст();
                    свОргУчаст.setНомПорСд(item[1] == null ? null : new BigInteger(item[1]));
                    свОргУчаст.setСведОтнАгент(item[2]);
                    свОргУчаст.setПрОрг(item[3]);
                    свОргУчаст. setОКСМ(ServiceUtils.threeDigitCheck(item[4]));
                    свОргУчаст.setНаимОргРус(item[5]);
                    свОргУчаст.setНаимОргЛат(item[6]);
                    свОргУчаст.setИННЮЛ(item[7]);
                    свОргУчаст.setКПП(item[8]);
                    свОргУчаст.setРегНомИн(item[9]);
                    свОргУчаст.setКодНПРег(item[10]);
                    свОргУчаст.setАдрИнТекст(item[11]);
                    свОргУчастСписок.add(свОргУчаст);
                }
            }
        }
        return свОргУчастСписок;
    }

    private ФИОТип фиоТипМетод(int index){
        ФИОТип фиоТип = null;
        String фамилия = partiesPersons.get(index)[4];
        String имя = partiesPersons.get(index)[5];
        String отчество = partiesPersons.get(index)[6];
        if (фамилия != null || имя != null || отчество != null){
            фиоТип = new ФИОТип();
            фиоТип.setФамилия(фамилия);
            фиоТип.setИмя(имя);
            фиоТип.setОтчество(отчество);
        }
        return фиоТип;
    }

    private УдЛичнФЛТип удЛичнФЛТипМетод(int index){
        УдЛичнФЛТип удЛичнФЛТип = null;
        String кодВидДок = partiesPersons.get(index)[12];
        String серНомДок = partiesPersons.get(index)[13];
        String датаДок = partiesPersons.get(index)[14];
        String выдДок = partiesPersons.get(index)[15];
        if (кодВидДок != null || серНомДок != null || датаДок != null || выдДок != null){
            удЛичнФЛТип = new УдЛичнФЛТип();
            удЛичнФЛТип.setКодВидДок(кодВидДок);
            удЛичнФЛТип.setСерНомДок(серНомДок);
            удЛичнФЛТип.setДатаДок(датаДок);
            удЛичнФЛТип.setВыдДок(выдДок);
        }
        return удЛичнФЛТип;
    }

    private АдрИнТип адрИнТипМетод(int index){
        АдрИнТип адрИнТип = null;
        String оксм = partiesPersons.get(index)[16];
        String адрИнТекст = partiesPersons.get(index)[17];
        if(оксм != null || адрИнТекст != null){
            адрИнТип = new АдрИнТип();
            адрИнТип.setОКСМ(оксм);
            адрИнТип.setАдрИнТекст(адрИнТекст);
        }
        return адрИнТип;
    }

    private Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст.СвФЛ свФЛМетод(int index){
        Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст.СвФЛ свФЛ = null;
        String датаРожд = partiesPersons.get(index)[8];
        String местоРожд = partiesPersons.get(index)[9];
        String гражд = partiesPersons.get(index)[10];
        String оксм = partiesPersons.get(index)[11];
        УдЛичнФЛТип удЛичнФЛТип = удЛичнФЛТипМетод(index);
        АдрИнТип адрИнТип = адрИнТипМетод(index);
        if(датаРожд != null || местоРожд != null || гражд != null || оксм != null ||
                удЛичнФЛТип != null || адрИнТип != null){
            свФЛ = new Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст.СвФЛ();
            свФЛ.setДатаРожд(датаРожд);
            свФЛ.setМестоРожд(местоРожд);
            свФЛ.setГражд(гражд);
            свФЛ.setОКСМ(оксм);
            свФЛ.setУдЛичнФЛ(удЛичнФЛТип);
            свФЛ.setАдрИн(адрИнТип);
        }
        return свФЛ;
    }

    private List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст> свФЛУчастМетод(Integer numOfTransaction){
        List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст> свФЛУчастСписок = null;
        if(partiesPersons.size() != 0){
            свФЛУчастСписок = new ArrayList<>();
            int counter = 0;
            for(String[] item : partiesPersons){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст свФЛУчаст = new Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст();
                    свФЛУчаст.setНомПорСд(item[1] == null ? null : new BigInteger(item[1]));
                    свФЛУчаст.setСведОтнАгент(item[2]);
                    свФЛУчаст.setКодВД(item[3]);
                    свФЛУчаст.setФИО(фиоТипМетод(counter));
                    свФЛУчаст.setИННФЛ(item[7]);
                    свФЛУчаст.setСвФЛ(свФЛМетод(counter));
                    свФЛУчастСписок.add(свФЛУчаст);
                }
                counter++;
            }
        }
        return свФЛУчастСписок;
    }

    private МестоТип местоТипМетод(String оксм, String кодРегион, String населПункт){
        МестоТип местоТип = null;
        if(оксм != null || кодРегион != null || населПункт != null){
            местоТип = new МестоТип();
            местоТип.setОКСМ(ServiceUtils.threeDigitCheck(оксм));
            местоТип.setКодРегион(ServiceUtils.twoDigitCheck(кодРегион));
            местоТип.setНаселПункт(населПункт);
        }
        return местоТип;
    }

    private Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН.ПерПредСд перПредСдМетод(int index){
        Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН.ПерПредСд перПредСд = null;
        String наимПредСд = subjects.get(index)[2];
        String тнвэд = subjects.get(index)[3];
        String окпд2 = subjects.get(index)[4];
        String оквэд2 = subjects.get(index)[5];
        String номУчСд = subjects.get(index)[6];
        String номДог = subjects.get(index)[7];
        String датаДог = subjects.get(index)[8];
        String оксм = subjects.get(index)[9];
        String кодУсловПост = subjects.get(index)[10];
        String океи = subjects.get(index)[11];
        String количество = subjects.get(index)[12];
        String ценаЕдин = subjects.get(index)[13];
        String кодВалют = subjects.get(index)[14];
        String процСтав = subjects.get(index)[15];
        String стоимИтог = subjects.get(index)[16];
        String датаСовСд = subjects.get(index)[17];
        String оксм1 = subjects.get(index)[18];
        String кодРегион1 = subjects.get(index)[19];
        String населПункт1 = subjects.get(index)[20];
        МестоТип местОтпрТов = местоТипМетод(оксм1, кодРегион1, населПункт1);
        String оксм2 = subjects.get(index)[18];
        String кодРегион2 = subjects.get(index)[19];
        String населПункт2 = subjects.get(index)[20];
        МестоТип местСовСд = местоТипМетод(оксм2, кодРегион2, населПункт2);
        if(наимПредСд != null || тнвэд != null || окпд2 != null || оквэд2 != null
                || номУчСд != null || номДог != null || датаДог != null || оксм != null
                || кодУсловПост != null || океи != null || количество != null || ценаЕдин != null
                || кодВалют != null || процСтав != null || стоимИтог != null || датаСовСд != null
                || местОтпрТов != null || местСовСд != null){
            перПредСд = new Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН.ПерПредСд();
            перПредСд.setНаимПредСд(наимПредСд);
            перПредСд.setТНВЭД(тнвэд);
            перПредСд.setОКПД2(окпд2);
            перПредСд.setОКВЭД2(оквэд2);
            перПредСд.setНомУчСд(номУчСд == null ? null : new BigInteger(номУчСд));
            перПредСд.setНомДог(номДог);
            перПредСд.setДатаДог(датаДог);
            перПредСд.setОКСМ(ServiceUtils.threeDigitCheck(оксм));
            перПредСд.setКодУсловПост(кодУсловПост);
            перПредСд.setОКЕИ(ServiceUtils.threeDigitCheck(океи));
            перПредСд.setКоличество(количество == null ? null : new BigDecimal(количество));
            перПредСд.setЦенаЕдин(ценаЕдин == null ? null : new BigDecimal(ценаЕдин));
            перПредСд.setКодВалют(ServiceUtils.threeDigitCheck(кодВалют));
            перПредСд.setПроцСтав(процСтав == null ? null : new BigDecimal(процСтав));
            перПредСд.setСтоимИтог(стоимИтог == null ? null : new BigInteger(стоимИтог));
            перПредСд.setДатаСовСд(датаСовСд);
            перПредСд.setМестОтпрТов(местОтпрТов);
            перПредСд.setМестСовСд(местСовСд);
        }
        return перПредСд;
    }

    private List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН> свПредмСдНМетод(Integer numOfTransaction){
        List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН> свПредмСдНСписок = null;
        if(subjects.size() != 0){
            свПредмСдНСписок = new ArrayList<>();
            Map<String, Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН> map = new HashMap<>();
            int counter = 0;
            for(String[] item : subjects){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    if(!map.containsKey(item[1])){
                        Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН свПредмСдН = new Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН();
                        свПредмСдН.setТипПредСд(item[1]);
                        List<Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН.ПерПредСд> перПредСдСписок = new ArrayList<>();
                        перПредСдСписок.add(перПредСдМетод(counter));
                        свПредмСдН.setПерПредСд(перПредСдСписок);
                        map.put(item[1], свПредмСдН);
                    }
                    else{
                        Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН свПредмСдН = map.get(item[1]);
                        свПредмСдН.getПерПредСд().add(перПредСдМетод(counter));
                    }
                }
                counter++;
            }
            for(Map.Entry<String, Файл2018.Документ.УвКонтрСд.СвКонтрСд.СвПредмСдН> item : map.entrySet()){
                свПредмСдНСписок.add(item.getValue());
            }
            String numOfTransactionString = numOfTransaction.toString();
            subjects = subjects.stream().filter(p -> !p[0].equals(numOfTransactionString)).collect(Collectors.toList());
        }
        return свПредмСдНСписок;
    }

    private Файл2018.Документ.УвКонтрСд.СвКонтрСд.ДохРасхСд дохРасхСдМетод(Integer numOfTransaction){
        Файл2018.Документ.УвКонтрСд.СвКонтрСд.ДохРасхСд дохРасхСд = null;
        String сумДохСд = transactions.get(numOfTransaction)[37];
        String сумДохСдРег = transactions.get(numOfTransaction)[38];
        String сумРасхСд = transactions.get(numOfTransaction)[39];
        String сумРасхСдРег = transactions.get(numOfTransaction)[40];
        if(сумДохСд != null || сумДохСдРег != null || сумРасхСд != null || сумРасхСдРег != null){
            дохРасхСд = new Файл2018.Документ.УвКонтрСд.СвКонтрСд.ДохРасхСд();
            дохРасхСд.setСумДохСд(сумДохСд == null ? null : new BigInteger(сумДохСд));
            дохРасхСд.setСумДохСдРег(сумДохСдРег == null ? null : new BigInteger(сумДохСдРег));
            дохРасхСд.setСумРасхСд(сумРасхСд == null ? null : new BigInteger(сумРасхСд));
            дохРасхСд.setСумРасхСдРег(сумРасхСдРег == null ? null : new BigInteger(сумРасхСдРег));
        }
        return дохРасхСд;
    }

    private Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд.КодИстИнф кодИстИнфМетод(Integer numOfTransaction){
        Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд.КодИстИнф кодИстИнф = null;
        String ист251 = transactions.get(numOfTransaction)[28];
        String ист252 = transactions.get(numOfTransaction)[29];
        String ист253 = transactions.get(numOfTransaction)[30];
        String ист254 = transactions.get(numOfTransaction)[31];
        String ист255 = transactions.get(numOfTransaction)[32];
        String ист256 = transactions.get(numOfTransaction)[33];
        String ист257 = transactions.get(numOfTransaction)[34];
        String ист258 = transactions.get(numOfTransaction)[35];
        String ист259 = transactions.get(numOfTransaction)[36];
        if(ист251 != null || ист252 != null || ист253 != null || ист254 != null || ист255 != null ||
                ист256 != null || ист257 != null || ист258 != null || ист259 != null){
            кодИстИнф = new Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд.КодИстИнф();
            кодИстИнф.setИст251(ист251);
            кодИстИнф.setИст252(ист252);
            кодИстИнф.setИст253(ист253);
            кодИстИнф.setИст254(ист254);
            кодИстИнф.setИст255(ист255);
            кодИстИнф.setИст256(ист256);
            кодИстИнф.setИст257(ист257);
            кодИстИнф.setИст258(ист258);
            кодИстИнф.setИст259(ист259);
        }
        return кодИстИнф;
    }

    private Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд контрСдМетод(Integer numOfTransaction){
        Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд контрСд = null;
        Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд.КодИстИнф кодИстИнф = кодИстИнфМетод(numOfTransaction);
        String групОС = transactions.get(numOfTransaction)[17];
        String кодНаимСд = transactions.get(numOfTransaction)[18];
        String кодСторСд = transactions.get(numOfTransaction)[19];
        String прОпрЦен = transactions.get(numOfTransaction)[20];
        String комПрОпрЦен = transactions.get(numOfTransaction)[21];
        String кодОпрЦен = transactions.get(numOfTransaction)[22];
        String комКодОпрЦен = transactions.get(numOfTransaction)[23];
        String кодМетЦен = transactions.get(numOfTransaction)[24];
        String комКодМетЦен = transactions.get(numOfTransaction)[25];
        String колУчСд = transactions.get(numOfTransaction)[26];
        String комКолУчСд = transactions.get(numOfTransaction)[27];
        if(кодИстИнф != null || групОС != null || кодНаимСд != null || кодСторСд != null || прОпрЦен != null ||
                комПрОпрЦен != null || кодОпрЦен != null || комКодОпрЦен != null || кодМетЦен != null ||
                комКодМетЦен != null || колУчСд != null || комКолУчСд != null){
            контрСд = new Файл2018.Документ.УвКонтрСд.СвКонтрСд.КонтрСд();
            контрСд.setКодИстИнф(кодИстИнф);
            контрСд.setГрупОС(групОС);
            контрСд.setКодНаимСд(ServiceUtils.threeDigitCheck(кодНаимСд));
            контрСд.setКодСторСд(ServiceUtils.threeDigitCheck(кодСторСд));
            контрСд.setПрОпрЦен(прОпрЦен);
            контрСд.setКомПрОпрЦен(комПрОпрЦен);
            контрСд.setКодОпрЦен(кодОпрЦен);
            контрСд.setКомКодОпрЦен(комКодОпрЦен);
            контрСд.setКодМетЦен(ServiceUtils.twoDigitCheck(кодМетЦен));
            контрСд.setКомКодМетЦен(комКодМетЦен);
            контрСд.setКолУчСд(колУчСд == null ? null : new BigInteger(колУчСд));
            контрСд.setКомКолУчСд(комКолУчСд);
        }
        return контрСд;
    }

    private Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.Осн10514 осн10514Метод(Integer numOfTransaction){
        Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.Осн10514 осн10514 = null;
        String осн121 = transactions.get(numOfTransaction)[3];
        String осн122 = transactions.get(numOfTransaction)[4];
        String осн123 = transactions.get(numOfTransaction)[5];
        String осн124 = transactions.get(numOfTransaction)[6];
        if(осн121 != null || осн122 != null || осн123 != null || осн124 != null){
            осн10514 = new Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.Осн10514();
            осн10514.setОсн121(осн121);
            осн10514.setОсн122(осн122);
            осн10514.setОсн123(осн123);
            осн10514.setОсн124(осн124);
        }
        return осн10514;
    }

    private Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.ОснРФ10514 оснРФ10514Метод(Integer numOfTransaction){
        Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.ОснРФ10514 оснРФ10514 = null;
        String осн131 = transactions.get(numOfTransaction)[7];
        String осн132 = transactions.get(numOfTransaction)[8];
        String осн133 = transactions.get(numOfTransaction)[9];
        String осн134 = transactions.get(numOfTransaction)[10];
        String осн135 = transactions.get(numOfTransaction)[11];
        String осн136 = transactions.get(numOfTransaction)[12];
        String осн137 = transactions.get(numOfTransaction)[13];
        String осн138 = transactions.get(numOfTransaction)[14];
        String осн139 = transactions.get(numOfTransaction)[15];
        String осн140 = transactions.get(numOfTransaction)[16];
        if(осн131 != null || осн132 != null || осн133 != null || осн134 != null
                || осн135 != null || осн136 != null || осн137 != null || осн138 != null
                || осн139 != null || осн140 != null){
            оснРФ10514 = new Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.ОснРФ10514();
            оснРФ10514.setОсн131(осн131);
            оснРФ10514.setОсн132(осн132);
            оснРФ10514.setОсн133(осн133);
            оснРФ10514.setОсн134(осн134);
            оснРФ10514.setОсн135(осн135);
            оснРФ10514.setОсн136(осн136);
            оснРФ10514.setОсн137(осн137);
            оснРФ10514.setОсн138(осн138);
            оснРФ10514.setОсн139(осн139);
            оснРФ10514.setОсн140(осн140);
        }
        return оснРФ10514;
    }

    private Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд оснКонтрСдМетод(Integer numOfTransaction){
        Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд оснКонтрСд = null;
        Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.Осн10514 осн10514 = осн10514Метод(numOfTransaction);
        Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.ОснРФ10514 оснРФ10514 = оснРФ10514Метод(numOfTransaction);
        String взЗавис = transactions.get(numOfTransaction)[2];
        if(осн10514 != null || оснРФ10514 != null || взЗавис != null){
            оснКонтрСд = new Файл2018.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд();
            оснКонтрСд.setОсн10514(осн10514);
            оснКонтрСд.setОснРФ10514(оснРФ10514);
            оснКонтрСд.setВзЗавис(взЗавис);
        }
        return оснКонтрСд;
    }


    Файл2018 populateClasses(){

        АдрИнТип адрИнТип = null;
        if (taxpayer.get(54) != null || taxpayer.get(55) != null ){
            адрИнТип = new АдрИнТип();
            адрИнТип.setОКСМ(taxpayer.get(54));
            адрИнТип.setАдрИнТекст(taxpayer.get(55));
        }

        УдЛичнФЛТип удЛичнФЛТип = null;
        if(taxpayer.get(49) != null || taxpayer.get(50) != null || taxpayer.get(51) != null || taxpayer.get(52) != null){
            удЛичнФЛТип = new УдЛичнФЛТип();
            удЛичнФЛТип.setКодВидДок(taxpayer.get(49));
            удЛичнФЛТип.setСерНомДок(taxpayer.get(50));
            удЛичнФЛТип.setДатаДок(taxpayer.get(51));
            удЛичнФЛТип.setВыдДок(taxpayer.get(52));
        }

        Файл2018.Документ.СвНП.НПФЛ.СвФЛ свФЛ = null;
        if(удЛичнФЛТип != null || адрИнТип != null || taxpayer.get(43) != null
                || taxpayer.get(44) != null || taxpayer.get(45) != null
                || taxpayer.get(46) != null || taxpayer.get(47) != null){
            свФЛ = new Файл2018.Документ.СвНП.НПФЛ.СвФЛ();
            свФЛ.setУдЛичнФЛ(удЛичнФЛТип);
            свФЛ.setАдрИн(адрИнТип);
            свФЛ.setДатаРожд(taxpayer.get(43));
            свФЛ.setМестоРожд(taxpayer.get(44));
            свФЛ.setГражд(taxpayer.get(45));
            свФЛ.setОКСМ(taxpayer.get(46));
            свФЛ.setСтатусНП(taxpayer.get(47));
        }

        ФИОТип фиоТип = null;
        if (taxpayer.get(39) != null || taxpayer.get(40) != null
                || taxpayer.get(41) != null){
            фиоТип = new ФИОТип();
            фиоТип.setФамилия(taxpayer.get(39));
            фиоТип.setИмя(taxpayer.get(40));
            фиоТип.setОтчество(taxpayer.get(41));
        }

        Файл2018.Документ.СвНП.НПФЛ нпфл = null;
        if (фиоТип != null || taxpayer.get(37) != null || свФЛ != null){
            нпфл = new Файл2018.Документ.СвНП.НПФЛ();
            нпфл.setФИО(фиоТип);
            нпфл.setИННФЛ(taxpayer.get(37));
            нпфл.setСвФЛ(свФЛ);
        }

        Файл2018.Документ.СвНП.НПЮЛ.СвРеоргЮЛ свРеоргЮЛ = null;
        if (taxpayer.get(33) != null || taxpayer.get(34) != null
                || taxpayer.get(35) != null){
            свРеоргЮЛ = new Файл2018.Документ.СвНП.НПЮЛ.СвРеоргЮЛ();
            свРеоргЮЛ.setФормРеорг(taxpayer.get(33));
            свРеоргЮЛ.setИННЮЛ(taxpayer.get(34));
            свРеоргЮЛ.setКПП(taxpayer.get(35));
        }

        Файл2018.Документ.СвНП.НПЮЛ нпюл = null;
        if (свРеоргЮЛ != null || taxpayer.get(29) != null
                || taxpayer.get(30) != null || taxpayer.get(31) != null){
            нпюл = new Файл2018.Документ.СвНП.НПЮЛ();
            нпюл.setСвРеоргЮЛ(свРеоргЮЛ);
            нпюл.setНаимОрг(taxpayer.get(29));
            нпюл.setИННЮЛ(taxpayer.get(30));
            нпюл.setКПП(taxpayer.get(31));
        }

        Файл2018.Документ.СвНП свНП = null;
        if (нпюл != null || нпфл != null || taxpayer.get(16) != null
                || taxpayer.get(17) != null || taxpayer.get(18) != null){
            свНП = new Файл2018.Документ.СвНП();
            свНП.setНПЮЛ(нпюл);
            свНП.setНПФЛ(нпфл);
            свНП.setОКТМО(taxpayer.get(16));
            свНП.setТлф(taxpayer.get(17));
            свНП.setEMail(taxpayer.get(18));
        }

        Файл2018.Документ.Подписант.СвПред свПред = null;
        if (taxpayer.get(26) != null || taxpayer.get(27) != null){
            свПред = new Файл2018.Документ.Подписант.СвПред();
            свПред.setНаимДок(taxpayer.get(26));
            свПред.setНаимОрг(taxpayer.get(27));
        }

        ФИОТип фиоТип1 = null;
        if (taxpayer.get(22) != null || taxpayer.get(23) != null || taxpayer.get(24) != null){
            фиоТип1 = new ФИОТип();
            фиоТип1.setФамилия(taxpayer.get(22));
            фиоТип1.setИмя(taxpayer.get(23));
            фиоТип1.setОтчество(taxpayer.get(24));
        }

        Файл2018.Документ.Подписант подписант = null;
        if (фиоТип1 != null || свПред != null || taxpayer.get(20) != null){
            подписант = new Файл2018.Документ.Подписант();
            подписант.setФИО(фиоТип1);
            подписант.setСвПред(свПред);
            подписант.setПрПодп(taxpayer.get(20));
        }

        List<Файл2018.Документ.УвКонтрСд.СвКонтрСд> свКонтрСд = transactionsFilling();
        Файл2018.Документ.УвКонтрСд увКонтрСд = null;
        if(свКонтрСд != null){
            увКонтрСд = new Файл2018.Документ.УвКонтрСд();
            увКонтрСд.setСвКонтрСд(свКонтрСд);
        }

        Файл2018.Документ документ = null;
        if (свНП != null || подписант != null || увКонтрСд != null || taxpayer.get(9) != null ||
                taxpayer.get(10) != null || taxpayer.get(11) != null || taxpayer.get(12) != null ||
                taxpayer.get(13) != null || taxpayer.get(14) != null){
            документ = new Файл2018.Документ();
            документ.setСвНП(свНП);
            документ.setПодписант(подписант);
            документ.setУвКонтрСд(увКонтрСд);
            документ.setКНД(taxpayer.get(9));
            документ.setДатаДок(taxpayer.get(10));
            документ.setОтчетГод(taxpayer.get(11));
            документ.setКодНО(taxpayer.get(12));
            документ.setНомКорр(taxpayer.get(13));
            документ.setПоМесту(taxpayer.get(14));
        }

        Файл2018 файл2018 = null;
        if (документ != null || taxpayer.get(1) != null || taxpayer.get(2) != null
                || taxpayer.get(3) != null || taxpayer.get(4) != null || taxpayer.get(5) != null
                || taxpayer.get(6) != null || taxpayer.get(7) != null){
            файл2018 = new Файл2018();
            файл2018.setДокумент(документ);
            файл2018.setИдФайл(taxpayer.get(1));
            файл2018.setВерсПрог(taxpayer.get(2));
            файл2018.setВерсФорм(taxpayer.get(3));
            файл2018.setИдФайлИсх(taxpayer.get(4));
            файл2018.setИдФайлПерв(taxpayer.get(5));
            файл2018.setКолФайл(taxpayer.get(6));
            файл2018.setНомФайл(taxpayer.get(7));
        }
        return файл2018;
    }
}

