package com.tp.notification.service;

import com.tp.notification.component._2012.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
class NotificationFactory2012 {

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

    private List<Файл2012.Документ.УвКонтрСд.СвКонтрСд> transactionsFilling(){
        List<Файл2012.Документ.УвКонтрСд.СвКонтрСд> свКонтрСдСписок = null;
        if(transactions.size() != 0){
            свКонтрСдСписок = new ArrayList<>();
            for(String[] item : transactions){
                Файл2012.Документ.УвКонтрСд.СвКонтрСд свКонтрСд = new Файл2012.Документ.УвКонтрСд.СвКонтрСд();
                Integer numOfTransaction = Integer.parseInt(item[0]);
                свКонтрСд.setДохРасхСд(дохРасхСдМетод(numOfTransaction - 1));
                свКонтрСд.setКонтрСд(контрСдМетод(numOfTransaction - 1));
                свКонтрСд.setОснКонтрСд(оснКонтрСдМетод(numOfTransaction - 1));
                свКонтрСд.setСвПредмСд(свПредмСдМетод(numOfTransaction));
                свКонтрСд.setСвОргУчаст(свОргУчастМетод(numOfTransaction));
                свКонтрСд.setСвФЛУчаст(свФЛУчастМетод(numOfTransaction));
                свКонтрСд.setНомПорСд(BigInteger.valueOf(numOfTransaction));
                свКонтрСдСписок.add(свКонтрСд);
            }
        }
        return свКонтрСдСписок;
    }

    private List<Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст> свОргУчастМетод(Integer numOfTransaction){
        List<Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст> свОргУчастСписок = null;
        if(partiesOrganizations.size() != 0){
            свОргУчастСписок = new ArrayList<>();
            for(String[] item : partiesOrganizations){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст свОргУчаст = new Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвОргУчаст();
                    свОргУчаст.setНомПорСд(item[1] == null ? null : new BigInteger(item[1]));
                    свОргУчаст.setПрОрг(item[2]);
                    свОргУчаст.setОКСМ(ServiceUtils.threeDigitCheck(item[3]));
                    свОргУчаст.setНаимОрг(item[4]);
                    свОргУчаст.setИННЮЛ(item[5]);
                    свОргУчаст.setКПП(item[6]);
                    свОргУчаст.setРегНомИн(item[7]);
                    свОргУчаст.setКодНПРег(item[8]);
                    свОргУчаст.setАдрИнТекст(item[9]);
                    свОргУчастСписок.add(свОргУчаст);
                }
            }
        }
        return свОргУчастСписок;
    }

    private ФИОТип фиоТипМетод(int index){
        ФИОТип фиоТип = null;
        String фамилия = partiesPersons.get(index)[3];
        String имя = partiesPersons.get(index)[4];
        String отчество = partiesPersons.get(index)[5];
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
        String кодВидДок = partiesPersons.get(index)[11];
        String серНомДок = partiesPersons.get(index)[12];
        String датаДок = partiesPersons.get(index)[13];
        String выдДок = partiesPersons.get(index)[14];
        if (кодВидДок != null || серНомДок != null || датаДок != null || выдДок != null){
            удЛичнФЛТип = new УдЛичнФЛТип();
            удЛичнФЛТип.setКодВидДок(кодВидДок);
            удЛичнФЛТип.setСерНомДок(серНомДок);
            удЛичнФЛТип.setДатаДок(датаДок);
            удЛичнФЛТип.setВыдДок(выдДок);
        }
        return удЛичнФЛТип;
    }

    private АдрРФТип адрРФТипМетод(int index){
        АдрРФТип адрРФТип = null;
        String индекс = partiesPersons.get(index)[16];
        String кодРегион = partiesPersons.get(index)[17];
        String район = partiesPersons.get(index)[18];
        String город = partiesPersons.get(index)[19];
        String населПункт = partiesPersons.get(index)[20];
        String улица = partiesPersons.get(index)[21];
        String дом = partiesPersons.get(index)[22];
        String корпус = partiesPersons.get(index)[23];
        String кварт = partiesPersons.get(index)[24];
        if(индекс != null || кодРегион != null || район != null || город != null || населПункт != null ||
                улица != null  || дом != null || корпус != null || кварт != null ){
            адрРФТип = new АдрРФТип();
            адрРФТип.setИндекс(индекс);
            адрРФТип.setКодРегион(кодРегион);
            адрРФТип.setРайон(район);
            адрРФТип.setГород(город);
            адрРФТип.setНаселПункт(населПункт);
            адрРФТип.setУлица(улица);
            адрРФТип.setДом(дом);
            адрРФТип.setКорпус(корпус);
            адрРФТип.setКварт(кварт);
        }
        return адрРФТип;
    }

    private СвАдрРФТип свАдрРФТипМетод(int index){
        СвАдрРФТип свАдрРФТип = null;
        String прАдр = partiesPersons.get(index)[15];
        АдрРФТип адрРФТип = адрРФТипМетод(index);
        if(прАдр != null || адрРФТип != null){
            свАдрРФТип = new СвАдрРФТип();
            свАдрРФТип.setПрАдр(прАдр);
            свАдрРФТип.setАдрРФ(адрРФТип);
        }
        return свАдрРФТип;
    }

    private АдрИнТип адрИнТипМетод(int index){
        АдрИнТип адрИнТип = null;
        String оксм = partiesPersons.get(index)[25];
        String адрИнТекст = partiesPersons.get(index)[26];
        if(оксм != null || адрИнТекст != null){
            адрИнТип = new АдрИнТип();
            адрИнТип.setОКСМ(оксм);
            адрИнТип.setАдрИнТекст(адрИнТекст);
        }
        return адрИнТип;
    }

    private Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст.СвФЛ свФЛМетод(int index){
        Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст.СвФЛ свФЛ = null;
        String датаРожд = partiesPersons.get(index)[7];
        String местоРожд = partiesPersons.get(index)[8];
        String налГражд = partiesPersons.get(index)[9];
        String оксм = partiesPersons.get(index)[10];
        УдЛичнФЛТип удЛичнФЛТип = удЛичнФЛТипМетод(index);
        СвАдрРФТип свАдрРФТип = свАдрРФТипМетод(index);
        АдрИнТип адрИнТип = адрИнТипМетод(index);
        if(датаРожд != null || местоРожд != null || налГражд != null || оксм != null ||
                удЛичнФЛТип != null || свАдрРФТип != null || адрИнТип != null){
            свФЛ = new Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст.СвФЛ();
            свФЛ.setДатаРожд(датаРожд);
            свФЛ.setМестоРожд(местоРожд);
            свФЛ.setНалГражд(налГражд);
            свФЛ.setОКСМ(оксм);
            свФЛ.setУдЛичнФЛ(удЛичнФЛТип);
            свФЛ.setСвАдрРФ(свАдрРФТип);
            свФЛ.setАдрИн(адрИнТип);
        }
        return свФЛ;
    }

    private List<Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст> свФЛУчастМетод(Integer numOfTransaction){
        List<Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст> свФЛУчастСписок = null;
        if(partiesPersons.size() != 0){
            свФЛУчастСписок = new ArrayList<>();
            int counter = 0;
            for(String[] item : partiesPersons){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст свФЛУчаст = new Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвФЛУчаст();
                    свФЛУчаст.setНомПорСд(item[1] == null ? null : new BigInteger(item[1]));
                    свФЛУчаст.setКодВД(item[2]);
                    свФЛУчаст.setФИО(фиоТипМетод(counter));
                    свФЛУчаст.setИННФЛ(item[6]);
                    свФЛУчаст.setСвФЛ(свФЛМетод(counter));
                    свФЛУчастСписок.add(свФЛУчаст);
                }
                counter++;
            }
        }
        return свФЛУчастСписок;
    }

    private МестоТип местоТипМетод(String оксм, String кодРегион, String город, String населПункт){
        МестоТип местоТип = null;
        if(оксм != null || кодРегион != null || город != null || населПункт != null){
            местоТип = new МестоТип();
            местоТип.setОКСМ(ServiceUtils.threeDigitCheck(оксм));
            местоТип.setКодРегион(ServiceUtils.twoDigitCheck(кодРегион));
            местоТип.setГород(город);
            местоТип.setНаселПункт(населПункт);
        }
        return местоТип;
    }

    private Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвПредмСд.ПерПредСд перПредСдМетод(int index){
        Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвПредмСд.ПерПредСд перПредСд = null;
        String наимПредСд = subjects.get(index)[2];
        String тнвэд = subjects.get(index)[3];
        String окп = subjects.get(index)[4];
        String оквэд = subjects.get(index)[5];
        String номУчСд = subjects.get(index)[6];
        String номДог = subjects.get(index)[7];
        String датаДог = subjects.get(index)[8];
        String оксм = subjects.get(index)[9];
        String кодУсловПост = subjects.get(index)[10];
        String океи = subjects.get(index)[11];
        String количество = subjects.get(index)[12];
        String ценаЕдин = subjects.get(index)[13];
        String стоимИтог = subjects.get(index)[14];
        String датаСовСд = subjects.get(index)[15];
        String оксм1 = subjects.get(index)[16];
        String кодРегион1 = subjects.get(index)[17];
        String город1 = subjects.get(index)[18];
        String населПункт1 = subjects.get(index)[19];
        МестоТип местОтпрТов = местоТипМетод(оксм1, кодРегион1, город1, населПункт1);
        String оксм2 = subjects.get(index)[20];
        String кодРегион2 = subjects.get(index)[21];
        String город2 = subjects.get(index)[22];
        String населПункт2 = subjects.get(index)[23];
        МестоТип местСовСд = местоТипМетод(оксм2, кодРегион2, город2, населПункт2);
        if(наимПредСд != null || тнвэд != null || окп != null || оквэд != null || номУчСд != null || номДог != null
                || датаДог != null || оксм != null || кодУсловПост != null || океи != null || количество != null
                || ценаЕдин != null || стоимИтог != null || датаСовСд != null || местОтпрТов != null || местСовСд != null){
            перПредСд = new Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвПредмСд.ПерПредСд();
            перПредСд.setНаимПредСд(наимПредСд);
            перПредСд.setТНВЭД(тнвэд);
            перПредСд.setОКП(окп);
            перПредСд.setОКВЭД(оквэд);
            перПредСд.setНомУчСд(номУчСд == null ? null : new BigInteger(номУчСд));
            перПредСд.setНомДог(номДог);
            перПредСд.setДатаДог(датаДог);
            перПредСд.setОКСМ(ServiceUtils.threeDigitCheck(оксм));
            перПредСд.setКодУсловПост(кодУсловПост);
            перПредСд.setОКЕИ(ServiceUtils.threeDigitCheck(океи));
            перПредСд.setКоличество(количество == null ? null : new BigInteger(количество));
            перПредСд.setЦенаЕдин(ценаЕдин == null ? null : new BigInteger(ценаЕдин));
            перПредСд.setСтоимИтог(стоимИтог == null ? null : new BigInteger(стоимИтог));
            перПредСд.setДатаСовСд(датаСовСд);
            перПредСд.setМестОтпрТов(местОтпрТов);
            перПредСд.setМестСовСд(местСовСд);
        }
        return перПредСд;
    }

    private List<Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвПредмСд> свПредмСдМетод(Integer numOfTransaction){
        List<Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвПредмСд> свПредмСдСписок = null;
        if(subjects.size() != 0){
            свПредмСдСписок = new ArrayList<>();
            Map<String, Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвПредмСд> map = new HashMap<>();
            int counter = 0;
            for(String[] item : subjects){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    if(!map.containsKey(item[1])){
                        Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвПредмСд свПредмСд = new Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвПредмСд();
                        свПредмСд.setТипПредСд(item[1]);
                        List<Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвПредмСд.ПерПредСд> перПредСдСписок = new ArrayList<>();
                        перПредСдСписок.add(перПредСдМетод(counter));
                        свПредмСд.setПерПредСд(перПредСдСписок);
                        map.put(item[1], свПредмСд);
                    }
                    else{
                        Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвПредмСд свПредмСд = map.get(item[1]);
                        свПредмСд.getПерПредСд().add(перПредСдМетод(counter));
                    }
                }
                counter++;
            }
            for(Map.Entry<String, Файл2012.Документ.УвКонтрСд.СвКонтрСд.СвПредмСд> item : map.entrySet()){
                свПредмСдСписок.add(item.getValue());
            }
            String numOfTransactionString = numOfTransaction.toString();
            subjects = subjects.stream().filter(p -> !p[0].equals(numOfTransactionString)).collect(Collectors.toList());
        }
        return свПредмСдСписок;
    }

    private Файл2012.Документ.УвКонтрСд.СвКонтрСд.ДохРасхСд дохРасхСдМетод(Integer numOfTransaction){
        Файл2012.Документ.УвКонтрСд.СвКонтрСд.ДохРасхСд дохРасхСд = null;
        String сумДохСд = transactions.get(numOfTransaction)[31];
        String сумДохСдРег = transactions.get(numOfTransaction)[32];
        String сумРасхСд = transactions.get(numOfTransaction)[33];
        String сумРасхСдРег = transactions.get(numOfTransaction)[34];
        if(сумДохСд != null || сумДохСдРег != null || сумРасхСд != null || сумРасхСдРег != null){
            дохРасхСд = new Файл2012.Документ.УвКонтрСд.СвКонтрСд.ДохРасхСд();
            дохРасхСд.setСумДохСд(сумДохСд == null ? null : new BigInteger(сумДохСд));
            дохРасхСд.setСумДохСдРег(сумДохСдРег == null ? null : new BigInteger(сумДохСдРег));
            дохРасхСд.setСумРасхСд(сумРасхСд == null ? null : new BigInteger(сумРасхСд));
            дохРасхСд.setСумРасхСдРег(сумРасхСдРег == null ? null : new BigInteger(сумРасхСдРег));
        }
        return дохРасхСд;
    }

    private Файл2012.Документ.УвКонтрСд.СвКонтрСд.КонтрСд.КодИстИнф кодИстИнфМетод(Integer numOfTransaction){
        Файл2012.Документ.УвКонтрСд.СвКонтрСд.КонтрСд.КодИстИнф кодИстИнф = null;
        String ист251 = transactions.get(numOfTransaction)[22];
        String ист252 = transactions.get(numOfTransaction)[23];
        String ист253 = transactions.get(numOfTransaction)[24];
        String ист254 = transactions.get(numOfTransaction)[25];
        String ист255 = transactions.get(numOfTransaction)[26];
        String ист256 = transactions.get(numOfTransaction)[27];
        String ист257 = transactions.get(numOfTransaction)[28];
        String ист258 = transactions.get(numOfTransaction)[29];
        String ист259 = transactions.get(numOfTransaction)[30];
        if(ист251 != null || ист252 != null || ист253 != null || ист254 != null || ист255 != null ||
                ист256 != null || ист257 != null || ист258 != null || ист259 != null){
            кодИстИнф = new Файл2012.Документ.УвКонтрСд.СвКонтрСд.КонтрСд.КодИстИнф();
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

    private Файл2012.Документ.УвКонтрСд.СвКонтрСд.КонтрСд контрСдМетод(Integer numOfTransaction){
        Файл2012.Документ.УвКонтрСд.СвКонтрСд.КонтрСд контрСд = null;
        Файл2012.Документ.УвКонтрСд.СвКонтрСд.КонтрСд.КодИстИнф кодИстИнф = кодИстИнфМетод(numOfTransaction);
        String групОС = transactions.get(numOfTransaction)[11];
        String кодНаимСд = transactions.get(numOfTransaction)[12];
        String кодСторСд = transactions.get(numOfTransaction)[13];
        String прОпрЦен = transactions.get(numOfTransaction)[14];
        String комПрОпрЦен = transactions.get(numOfTransaction)[15];
        String кодОпрЦен = transactions.get(numOfTransaction)[16];
        String комКодОпрЦен = transactions.get(numOfTransaction)[17];
        String кодМетЦен = transactions.get(numOfTransaction)[18];
        String комКодМетЦен = transactions.get(numOfTransaction)[19];
        String колУчСд = transactions.get(numOfTransaction)[20];
        String комКолУчСд = transactions.get(numOfTransaction)[21];
        if(кодИстИнф != null || групОС != null || кодНаимСд != null || кодСторСд != null || прОпрЦен != null ||
                комПрОпрЦен != null || кодОпрЦен != null || комКодОпрЦен != null || кодМетЦен != null ||
                комКодМетЦен != null || колУчСд != null || комКолУчСд != null){
            контрСд = new Файл2012.Документ.УвКонтрСд.СвКонтрСд.КонтрСд();
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

    private Файл2012.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.Осн10514 осн10514Метод(Integer numOfTransaction){
        Файл2012.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.Осн10514 осн10514 = null;
        String осн121 = transactions.get(numOfTransaction)[2];
        String осн122 = transactions.get(numOfTransaction)[3];
        String осн123 = transactions.get(numOfTransaction)[4];
        String осн124 = transactions.get(numOfTransaction)[5];
        if(осн121 != null || осн122 != null || осн123 != null || осн124 != null){
            осн10514 = new Файл2012.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.Осн10514();
            осн10514.setОсн121(осн121);
            осн10514.setОсн122(осн122);
            осн10514.setОсн123(осн123);
            осн10514.setОсн124(осн124);
        }
        return осн10514;
    }

    private Файл2012.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.ОснРФ10514 оснРФ10514Метод(Integer numOfTransaction){
        Файл2012.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.ОснРФ10514 оснРФ10514 = null;
        String осн131 = transactions.get(numOfTransaction)[6];
        String осн132 = transactions.get(numOfTransaction)[7];
        String осн133 = transactions.get(numOfTransaction)[8];
        String осн134 = transactions.get(numOfTransaction)[9];
        String осн135 = transactions.get(numOfTransaction)[10];
        if(осн131 != null || осн132 != null || осн133 != null || осн134 != null || осн135 != null){
            оснРФ10514 = new Файл2012.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.ОснРФ10514();
            оснРФ10514.setОсн131(осн131);
            оснРФ10514.setОсн132(осн132);
            оснРФ10514.setОсн133(осн133);
            оснРФ10514.setОсн134(осн134);
            оснРФ10514.setОсн135(осн135);
        }
        return оснРФ10514;
    }

    private Файл2012.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд оснКонтрСдМетод(Integer numOfTransaction){
        Файл2012.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд оснКонтрСд = null;
        Файл2012.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.Осн10514 осн10514 = осн10514Метод(numOfTransaction);
        Файл2012.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд.ОснРФ10514 оснРФ10514 = оснРФ10514Метод(numOfTransaction);
        String взЗавис = transactions.get(numOfTransaction)[1];
        if(осн10514 != null || оснРФ10514 != null || взЗавис != null){
            оснКонтрСд = new Файл2012.Документ.УвКонтрСд.СвКонтрСд.ОснКонтрСд();
            оснКонтрСд.setОсн10514(осн10514);
            оснКонтрСд.setОснРФ10514(оснРФ10514);
            оснКонтрСд.setВзЗавис(взЗавис);
        }
        return оснКонтрСд;
    }

    Файл2012 populateClasses(){
        АдрИнТип адрИнТип = null;
        if (taxpayer.get(63) != null || taxpayer.get(64) != null ){
            адрИнТип = new АдрИнТип();
            адрИнТип.setОКСМ(taxpayer.get(63));
            адрИнТип.setАдрИнТекст(taxpayer.get(64));
        }
        АдрРФТип адрРФТип = null;
        if (taxpayer.get(53) != null || taxpayer.get(54) != null || taxpayer.get(55) != null ||
                taxpayer.get(56) != null || taxpayer.get(57) != null || taxpayer.get(58) != null ||
                taxpayer.get(59) != null || taxpayer.get(60) != null || taxpayer.get(61) != null){
            адрРФТип = new АдрРФТип();
            адрРФТип.setИндекс(taxpayer.get(53));
            адрРФТип.setКодРегион(taxpayer.get(54));
            адрРФТип.setРайон(taxpayer.get(55));
            адрРФТип.setГород(taxpayer.get(56));
            адрРФТип.setНаселПункт(taxpayer.get(57));
            адрРФТип.setУлица(taxpayer.get(58));
            адрРФТип.setДом(taxpayer.get(59));
            адрРФТип.setКорпус(taxpayer.get(60));
            адрРФТип.setКварт(taxpayer.get(61));
        }

        СвАдрРФТип свАдрРФТип = null;
        if(адрРФТип != null || taxpayer.get(51) != null){
            свАдрРФТип = new СвАдрРФТип();
            свАдрРФТип.setАдрРФ(адрРФТип);
            свАдрРФТип.setПрАдр(taxpayer.get(51));
        }

        УдЛичнФЛТип удЛичнФЛТип = null;
        if(taxpayer.get(46) != null || taxpayer.get(47) != null || taxpayer.get(48) != null || taxpayer.get(49) != null){
            удЛичнФЛТип = new УдЛичнФЛТип();
            удЛичнФЛТип.setКодВидДок(taxpayer.get(46));
            удЛичнФЛТип.setСерНомДок(taxpayer.get(47));
            удЛичнФЛТип.setДатаДок(taxpayer.get(48));
            удЛичнФЛТип.setВыдДок(taxpayer.get(49));
        }

        Файл2012.Документ.СвНП.НПФЛ.СвФЛ свФЛ = null;
        if(удЛичнФЛТип != null || свАдрРФТип != null || адрИнТип != null || taxpayer.get(40) != null ||
                taxpayer.get(41) != null || taxpayer.get(42) != null || taxpayer.get(43) != null ||
                taxpayer.get(44) != null){
            свФЛ = new Файл2012.Документ.СвНП.НПФЛ.СвФЛ();
            свФЛ.setУдЛичнФЛ(удЛичнФЛТип);
            свФЛ.setСвАдрРФ(свАдрРФТип);
            свФЛ.setАдрИн(адрИнТип);
            свФЛ.setДатаРожд(taxpayer.get(40));
            свФЛ.setМестоРожд(taxpayer.get(41));
            свФЛ.setНалГражд(taxpayer.get(42));
            свФЛ.setОКСМ(taxpayer.get(43));
            свФЛ.setСтатусНП(taxpayer.get(44));
        }

        ФИОТип фиоТип = null;
        if (taxpayer.get(36) != null || taxpayer.get(37) != null || taxpayer.get(38) != null){
            фиоТип = new ФИОТип();
            фиоТип.setФамилия(taxpayer.get(36));
            фиоТип.setИмя(taxpayer.get(37));
            фиоТип.setОтчество(taxpayer.get(38));
        }

        Файл2012.Документ.СвНП.НПФЛ нпфл = null;
        if (фиоТип != null || taxpayer.get(34) != null || свФЛ != null){
            нпфл = new Файл2012.Документ.СвНП.НПФЛ();
            нпфл.setФИО(фиоТип);
            нпфл.setИННФЛ(taxpayer.get(34));
            нпфл.setСвФЛ(свФЛ);
        }

        Файл2012.Документ.СвНП.НПЮЛ.СвРеоргЮЛ свРеоргЮЛ = null;
        if (taxpayer.get(30) != null || taxpayer.get(31) != null || taxpayer.get(32) != null){
            свРеоргЮЛ = new Файл2012.Документ.СвНП.НПЮЛ.СвРеоргЮЛ();
            свРеоргЮЛ.setФормРеорг(taxpayer.get(30));
            свРеоргЮЛ.setИННЮЛ(taxpayer.get(31));
            свРеоргЮЛ.setКПП(taxpayer.get(32));
        }

        Файл2012.Документ.СвНП.НПЮЛ нпюл = null;
        if (свРеоргЮЛ != null || taxpayer.get(26) != null || taxpayer.get(27) != null || taxpayer.get(28) != null){
            нпюл = new Файл2012.Документ.СвНП.НПЮЛ();
            нпюл.setСвРеоргЮЛ(свРеоргЮЛ);
            нпюл.setНаимОрг(taxpayer.get(26));
            нпюл.setИННЮЛ(taxpayer.get(27));
            нпюл.setКПП(taxpayer.get(28));
        }

        Файл2012.Документ.СвНП свНП = null;
        if (нпюл != null || нпфл != null || taxpayer.get(12) != null || taxpayer.get(13) != null ||
                taxpayer.get(14) != null || taxpayer.get(15) != null){
            свНП = new Файл2012.Документ.СвНП();
            свНП.setНПЮЛ(нпюл);
            свНП.setНПФЛ(нпфл);
            свНП.setОКАТО(taxpayer.get(12));
            свНП.setОКВЭД(taxpayer.get(13));
            свНП.setТлф(taxpayer.get(14));
            свНП.setEMail(taxpayer.get(15));
        }

        Файл2012.Документ.Подписант.СвПред свПред = null;
        if (taxpayer.get(23) != null || taxpayer.get(24) != null){
            свПред = new Файл2012.Документ.Подписант.СвПред();
            свПред.setНаимДок(taxpayer.get(23));
            свПред.setНаимОрг(taxpayer.get(24));
        }

        ФИОТип фиоТип1 = null;
        if (taxpayer.get(19) != null || taxpayer.get(20) != null || taxpayer.get(21) != null){
            фиоТип1 = new ФИОТип();
            фиоТип1.setФамилия(taxpayer.get(19));
            фиоТип1.setИмя(taxpayer.get(20));
            фиоТип1.setОтчество(taxpayer.get(21));
        }

        Файл2012.Документ.Подписант подписант = null;
        if (фиоТип1 != null || свПред != null || taxpayer.get(17) != null){
            подписант = new Файл2012.Документ.Подписант();
            подписант.setФИО(фиоТип1);
            подписант.setСвПред(свПред);
            подписант.setПрПодп(taxpayer.get(17));
        }

        List<Файл2012.Документ.УвКонтрСд.СвКонтрСд> свКонтрСд = transactionsFilling();
        Файл2012.Документ.УвКонтрСд увКонтрСд = null;
        if(свКонтрСд != null){
            увКонтрСд = new Файл2012.Документ.УвКонтрСд();
            увКонтрСд.setСвКонтрСд(свКонтрСд);
        }

        Файл2012.Документ документ = null;
        if (свНП != null || подписант != null || увКонтрСд != null || taxpayer.get(5) != null ||
                taxpayer.get(6) != null || taxpayer.get(7) != null || taxpayer.get(8) != null ||
                taxpayer.get(9) != null || taxpayer.get(10) != null){
            документ = new Файл2012.Документ();
            документ.setСвНП(свНП);
            документ.setПодписант(подписант);
            документ.setУвКонтрСд(увКонтрСд);
            документ.setКНД(taxpayer.get(5));
            документ.setДатаДок(taxpayer.get(6));
            документ.setОтчетГод(taxpayer.get(7));
            документ.setКодНО(taxpayer.get(8));
            документ.setНомКорр(taxpayer.get(9));
            документ.setПоМесту(taxpayer.get(10));
        }

        Файл2012 файл2012 = null;
        if (документ != null || taxpayer.get(1) != null || taxpayer.get(2) != null || taxpayer.get(3) != null){
            файл2012 = new Файл2012();
            файл2012.setДокумент(документ);
            файл2012.setИдФайл(taxpayer.get(1));
            файл2012.setВерсПрог(taxpayer.get(2));
            файл2012.setВерсФорм(taxpayer.get(3));
        }

        return файл2012;
    }
}
