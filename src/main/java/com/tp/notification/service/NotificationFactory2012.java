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

    private List<‘айл2012.ƒокумент.”в онтр—д.—в онтр—д> transactionsFilling(){
        List<‘айл2012.ƒокумент.”в онтр—д.—в онтр—д> св онтр—д—писок = null;
        if(transactions.size() != 0){
            св онтр—д—писок = new ArrayList<>();
            for(String[] item : transactions){
                ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д св онтр—д = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д();
                Integer numOfTransaction = Integer.parseInt(item[0]);
                св онтр—д.setƒох–асх—д(дох–асх—дћетод(numOfTransaction - 1));
                св онтр—д.set онтр—д(контр—дћетод(numOfTransaction - 1));
                св онтр—д.setќсн онтр—д(осн онтр—дћетод(numOfTransaction - 1));
                св онтр—д.set—вѕредм—д(свѕредм—дћетод(numOfTransaction));
                св онтр—д.set—вќрг”част(свќрг”частћетод(numOfTransaction));
                св онтр—д.set—в‘Ћ”част(св‘Ћ”частћетод(numOfTransaction));
                св онтр—д.setЌомѕор—д(BigInteger.valueOf(numOfTransaction));
                св онтр—д—писок.add(св онтр—д);
            }
        }
        return св онтр—д—писок;
    }

    private List<‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част> свќрг”частћетод(Integer numOfTransaction){
        List<‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част> свќрг”част—писок = null;
        if(partiesOrganizations.size() != 0){
            свќрг”част—писок = new ArrayList<>();
            for(String[] item : partiesOrganizations){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част свќрг”част = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част();
                    свќрг”част.setЌомѕор—д(item[1] == null ? null : new BigInteger(item[1]));
                    свќрг”част.setѕрќрг(item[2]);
                    свќрг”част.setќ —ћ(ServiceUtils.threeDigitCheck(item[3]));
                    свќрг”част.setЌаимќрг(item[4]);
                    свќрг”част.set»ЌЌёЋ(item[5]);
                    свќрг”част.set ѕѕ(item[6]);
                    свќрг”част.set–егЌом»н(item[7]);
                    свќрг”част.set одЌѕ–ег(item[8]);
                    свќрг”част.setјдр»н“екст(item[9]);
                    свќрг”част—писок.add(свќрг”част);
                }
            }
        }
        return свќрг”част—писок;
    }

    private ‘»ќ“ип фио“ипћетод(int index){
        ‘»ќ“ип фио“ип = null;
        String фамили€ = partiesPersons.get(index)[3];
        String им€ = partiesPersons.get(index)[4];
        String отчество = partiesPersons.get(index)[5];
        if (фамили€ != null || им€ != null || отчество != null){
            фио“ип = new ‘»ќ“ип();
            фио“ип.set‘амили€(фамили€);
            фио“ип.set»м€(им€);
            фио“ип.setќтчество(отчество);
        }
        return фио“ип;
    }

    private ”дЋичн‘Ћ“ип удЋичн‘Ћ“ипћетод(int index){
        ”дЋичн‘Ћ“ип удЋичн‘Ћ“ип = null;
        String код¬идƒок = partiesPersons.get(index)[11];
        String серЌомƒок = partiesPersons.get(index)[12];
        String датаƒок = partiesPersons.get(index)[13];
        String выдƒок = partiesPersons.get(index)[14];
        if (код¬идƒок != null || серЌомƒок != null || датаƒок != null || выдƒок != null){
            удЋичн‘Ћ“ип = new ”дЋичн‘Ћ“ип();
            удЋичн‘Ћ“ип.set од¬идƒок(код¬идƒок);
            удЋичн‘Ћ“ип.set—ерЌомƒок(серЌомƒок);
            удЋичн‘Ћ“ип.setƒатаƒок(датаƒок);
            удЋичн‘Ћ“ип.set¬ыдƒок(выдƒок);
        }
        return удЋичн‘Ћ“ип;
    }

    private јдр–‘“ип адр–‘“ипћетод(int index){
        јдр–‘“ип адр–‘“ип = null;
        String индекс = partiesPersons.get(index)[16];
        String код–егион = partiesPersons.get(index)[17];
        String район = partiesPersons.get(index)[18];
        String город = partiesPersons.get(index)[19];
        String населѕункт = partiesPersons.get(index)[20];
        String улица = partiesPersons.get(index)[21];
        String дом = partiesPersons.get(index)[22];
        String корпус = partiesPersons.get(index)[23];
        String кварт = partiesPersons.get(index)[24];
        if(индекс != null || код–егион != null || район != null || город != null || населѕункт != null ||
                улица != null  || дом != null || корпус != null || кварт != null ){
            адр–‘“ип = new јдр–‘“ип();
            адр–‘“ип.set»ндекс(индекс);
            адр–‘“ип.set од–егион(код–егион);
            адр–‘“ип.set–айон(район);
            адр–‘“ип.set√ород(город);
            адр–‘“ип.setЌаселѕункт(населѕункт);
            адр–‘“ип.set”лица(улица);
            адр–‘“ип.setƒом(дом);
            адр–‘“ип.set орпус(корпус);
            адр–‘“ип.set варт(кварт);
        }
        return адр–‘“ип;
    }

    private —вјдр–‘“ип свјдр–‘“ипћетод(int index){
        —вјдр–‘“ип свјдр–‘“ип = null;
        String прјдр = partiesPersons.get(index)[15];
        јдр–‘“ип адр–‘“ип = адр–‘“ипћетод(index);
        if(прјдр != null || адр–‘“ип != null){
            свјдр–‘“ип = new —вјдр–‘“ип();
            свјдр–‘“ип.setѕрјдр(прјдр);
            свјдр–‘“ип.setјдр–‘(адр–‘“ип);
        }
        return свјдр–‘“ип;
    }

    private јдр»н“ип адр»н“ипћетод(int index){
        јдр»н“ип адр»н“ип = null;
        String оксм = partiesPersons.get(index)[25];
        String адр»н“екст = partiesPersons.get(index)[26];
        if(оксм != null || адр»н“екст != null){
            адр»н“ип = new јдр»н“ип();
            адр»н“ип.setќ —ћ(оксм);
            адр»н“ип.setјдр»н“екст(адр»н“екст);
        }
        return адр»н“ип;
    }

    private ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част.—в‘Ћ св‘Ћћетод(int index){
        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част.—в‘Ћ св‘Ћ = null;
        String дата–ожд = partiesPersons.get(index)[7];
        String место–ожд = partiesPersons.get(index)[8];
        String нал√ражд = partiesPersons.get(index)[9];
        String оксм = partiesPersons.get(index)[10];
        ”дЋичн‘Ћ“ип удЋичн‘Ћ“ип = удЋичн‘Ћ“ипћетод(index);
        —вјдр–‘“ип свјдр–‘“ип = свјдр–‘“ипћетод(index);
        јдр»н“ип адр»н“ип = адр»н“ипћетод(index);
        if(дата–ожд != null || место–ожд != null || нал√ражд != null || оксм != null ||
                удЋичн‘Ћ“ип != null || свјдр–‘“ип != null || адр»н“ип != null){
            св‘Ћ = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част.—в‘Ћ();
            св‘Ћ.setƒата–ожд(дата–ожд);
            св‘Ћ.setћесто–ожд(место–ожд);
            св‘Ћ.setЌал√ражд(нал√ражд);
            св‘Ћ.setќ —ћ(оксм);
            св‘Ћ.set”дЋичн‘Ћ(удЋичн‘Ћ“ип);
            св‘Ћ.set—вјдр–‘(свјдр–‘“ип);
            св‘Ћ.setјдр»н(адр»н“ип);
        }
        return св‘Ћ;
    }

    private List<‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част> св‘Ћ”частћетод(Integer numOfTransaction){
        List<‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част> св‘Ћ”част—писок = null;
        if(partiesPersons.size() != 0){
            св‘Ћ”част—писок = new ArrayList<>();
            int counter = 0;
            for(String[] item : partiesPersons){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част св‘Ћ”част = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част();
                    св‘Ћ”част.setЌомѕор—д(item[1] == null ? null : new BigInteger(item[1]));
                    св‘Ћ”част.set од¬ƒ(item[2]);
                    св‘Ћ”част.set‘»ќ(фио“ипћетод(counter));
                    св‘Ћ”част.set»ЌЌ‘Ћ(item[6]);
                    св‘Ћ”част.set—в‘Ћ(св‘Ћћетод(counter));
                    св‘Ћ”част—писок.add(св‘Ћ”част);
                }
                counter++;
            }
        }
        return св‘Ћ”част—писок;
    }

    private ћесто“ип место“ипћетод(String оксм, String код–егион, String город, String населѕункт){
        ћесто“ип место“ип = null;
        if(оксм != null || код–егион != null || город != null || населѕункт != null){
            место“ип = new ћесто“ип();
            место“ип.setќ —ћ(ServiceUtils.threeDigitCheck(оксм));
            место“ип.set од–егион(ServiceUtils.twoDigitCheck(код–егион));
            место“ип.set√ород(город);
            место“ип.setЌаселѕункт(населѕункт);
        }
        return место“ип;
    }

    private ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—д.ѕерѕред—д перѕред—дћетод(int index){
        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—д.ѕерѕред—д перѕред—д = null;
        String наимѕред—д = subjects.get(index)[2];
        String тнвэд = subjects.get(index)[3];
        String окп = subjects.get(index)[4];
        String оквэд = subjects.get(index)[5];
        String ном”ч—д = subjects.get(index)[6];
        String номƒог = subjects.get(index)[7];
        String датаƒог = subjects.get(index)[8];
        String оксм = subjects.get(index)[9];
        String код”словѕост = subjects.get(index)[10];
        String океи = subjects.get(index)[11];
        String количество = subjects.get(index)[12];
        String цена≈дин = subjects.get(index)[13];
        String стоим»тог = subjects.get(index)[14];
        String дата—ов—д = subjects.get(index)[15];
        String оксм1 = subjects.get(index)[16];
        String код–егион1 = subjects.get(index)[17];
        String город1 = subjects.get(index)[18];
        String населѕункт1 = subjects.get(index)[19];
        ћесто“ип местќтпр“ов = место“ипћетод(оксм1, код–егион1, город1, населѕункт1);
        String оксм2 = subjects.get(index)[20];
        String код–егион2 = subjects.get(index)[21];
        String город2 = subjects.get(index)[22];
        String населѕункт2 = subjects.get(index)[23];
        ћесто“ип мест—ов—д = место“ипћетод(оксм2, код–егион2, город2, населѕункт2);
        if(наимѕред—д != null || тнвэд != null || окп != null || оквэд != null || ном”ч—д != null || номƒог != null
                || датаƒог != null || оксм != null || код”словѕост != null || океи != null || количество != null
                || цена≈дин != null || стоим»тог != null || дата—ов—д != null || местќтпр“ов != null || мест—ов—д != null){
            перѕред—д = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—д.ѕерѕред—д();
            перѕред—д.setЌаимѕред—д(наимѕред—д);
            перѕред—д.set“Ќ¬Ёƒ(тнвэд);
            перѕред—д.setќ ѕ(окп);
            перѕред—д.setќ ¬Ёƒ(оквэд);
            перѕред—д.setЌом”ч—д(ном”ч—д == null ? null : new BigInteger(ном”ч—д));
            перѕред—д.setЌомƒог(номƒог);
            перѕред—д.setƒатаƒог(датаƒог);
            перѕред—д.setќ —ћ(ServiceUtils.threeDigitCheck(оксм));
            перѕред—д.set од”словѕост(код”словѕост);
            перѕред—д.setќ ≈»(ServiceUtils.threeDigitCheck(океи));
            перѕред—д.set оличество(количество == null ? null : new BigInteger(количество));
            перѕред—д.set÷ена≈дин(цена≈дин == null ? null : new BigInteger(цена≈дин));
            перѕред—д.set—тоим»тог(стоим»тог == null ? null : new BigInteger(стоим»тог));
            перѕред—д.setƒата—ов—д(дата—ов—д);
            перѕред—д.setћестќтпр“ов(местќтпр“ов);
            перѕред—д.setћест—ов—д(мест—ов—д);
        }
        return перѕред—д;
    }

    private List<‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—д> свѕредм—дћетод(Integer numOfTransaction){
        List<‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—д> свѕредм—д—писок = null;
        if(subjects.size() != 0){
            свѕредм—д—писок = new ArrayList<>();
            Map<String, ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—д> map = new HashMap<>();
            int counter = 0;
            for(String[] item : subjects){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    if(!map.containsKey(item[1])){
                        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—д свѕредм—д = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—д();
                        свѕредм—д.set“ипѕред—д(item[1]);
                        List<‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—д.ѕерѕред—д> перѕред—д—писок = new ArrayList<>();
                        перѕред—д—писок.add(перѕред—дћетод(counter));
                        свѕредм—д.setѕерѕред—д(перѕред—д—писок);
                        map.put(item[1], свѕредм—д);
                    }
                    else{
                        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—д свѕредм—д = map.get(item[1]);
                        свѕредм—д.getѕерѕред—д().add(перѕред—дћетод(counter));
                    }
                }
                counter++;
            }
            for(Map.Entry<String, ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—д> item : map.entrySet()){
                свѕредм—д—писок.add(item.getValue());
            }
            String numOfTransactionString = numOfTransaction.toString();
            subjects = subjects.stream().filter(p -> !p[0].equals(numOfTransactionString)).collect(Collectors.toList());
        }
        return свѕредм—д—писок;
    }

    private ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ƒох–асх—д дох–асх—дћетод(Integer numOfTransaction){
        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ƒох–асх—д дох–асх—д = null;
        String сумƒох—д = transactions.get(numOfTransaction)[31];
        String сумƒох—д–ег = transactions.get(numOfTransaction)[32];
        String сум–асх—д = transactions.get(numOfTransaction)[33];
        String сум–асх—д–ег = transactions.get(numOfTransaction)[34];
        if(сумƒох—д != null || сумƒох—д–ег != null || сум–асх—д != null || сум–асх—д–ег != null){
            дох–асх—д = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ƒох–асх—д();
            дох–асх—д.set—умƒох—д(сумƒох—д == null ? null : new BigInteger(сумƒох—д));
            дох–асх—д.set—умƒох—д–ег(сумƒох—д–ег == null ? null : new BigInteger(сумƒох—д–ег));
            дох–асх—д.set—ум–асх—д(сум–асх—д == null ? null : new BigInteger(сум–асх—д));
            дох–асх—д.set—ум–асх—д–ег(сум–асх—д–ег == null ? null : new BigInteger(сум–асх—д–ег));
        }
        return дох–асх—д;
    }

    private ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д. онтр—д. од»ст»нф код»ст»нфћетод(Integer numOfTransaction){
        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д. онтр—д. од»ст»нф код»ст»нф = null;
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
            код»ст»нф = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д. онтр—д. од»ст»нф();
            код»ст»нф.set»ст251(ист251);
            код»ст»нф.set»ст252(ист252);
            код»ст»нф.set»ст253(ист253);
            код»ст»нф.set»ст254(ист254);
            код»ст»нф.set»ст255(ист255);
            код»ст»нф.set»ст256(ист256);
            код»ст»нф.set»ст257(ист257);
            код»ст»нф.set»ст258(ист258);
            код»ст»нф.set»ст259(ист259);
        }
        return код»ст»нф;
    }

    private ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д. онтр—д контр—дћетод(Integer numOfTransaction){
        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д. онтр—д контр—д = null;
        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д. онтр—д. од»ст»нф код»ст»нф = код»ст»нфћетод(numOfTransaction);
        String групќ— = transactions.get(numOfTransaction)[11];
        String кодЌаим—д = transactions.get(numOfTransaction)[12];
        String код—тор—д = transactions.get(numOfTransaction)[13];
        String прќпр÷ен = transactions.get(numOfTransaction)[14];
        String комѕрќпр÷ен = transactions.get(numOfTransaction)[15];
        String кодќпр÷ен = transactions.get(numOfTransaction)[16];
        String ком одќпр÷ен = transactions.get(numOfTransaction)[17];
        String кодћет÷ен = transactions.get(numOfTransaction)[18];
        String ком одћет÷ен = transactions.get(numOfTransaction)[19];
        String кол”ч—д = transactions.get(numOfTransaction)[20];
        String ком ол”ч—д = transactions.get(numOfTransaction)[21];
        if(код»ст»нф != null || групќ— != null || кодЌаим—д != null || код—тор—д != null || прќпр÷ен != null ||
                комѕрќпр÷ен != null || кодќпр÷ен != null || ком одќпр÷ен != null || кодћет÷ен != null ||
                ком одћет÷ен != null || кол”ч—д != null || ком ол”ч—д != null){
            контр—д = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д. онтр—д();
            контр—д.set од»ст»нф(код»ст»нф);
            контр—д.set√рупќ—(групќ—);
            контр—д.set одЌаим—д(ServiceUtils.threeDigitCheck(кодЌаим—д));
            контр—д.set од—тор—д(ServiceUtils.threeDigitCheck(код—тор—д));
            контр—д.setѕрќпр÷ен(прќпр÷ен);
            контр—д.set омѕрќпр÷ен(комѕрќпр÷ен);
            контр—д.set одќпр÷ен(кодќпр÷ен);
            контр—д.set ом одќпр÷ен(ком одќпр÷ен);
            контр—д.set одћет÷ен(ServiceUtils.twoDigitCheck(кодћет÷ен));
            контр—д.set ом одћет÷ен(ком одћет÷ен);
            контр—д.set ол”ч—д(кол”ч—д == null ? null : new BigInteger(кол”ч—д));
            контр—д.set ом ол”ч—д(ком ол”ч—д);
        }
        return контр—д;
    }

    private ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн10514 осн10514ћетод(Integer numOfTransaction){
        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн10514 осн10514 = null;
        String осн121 = transactions.get(numOfTransaction)[2];
        String осн122 = transactions.get(numOfTransaction)[3];
        String осн123 = transactions.get(numOfTransaction)[4];
        String осн124 = transactions.get(numOfTransaction)[5];
        if(осн121 != null || осн122 != null || осн123 != null || осн124 != null){
            осн10514 = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн10514();
            осн10514.setќсн121(осн121);
            осн10514.setќсн122(осн122);
            осн10514.setќсн123(осн123);
            осн10514.setќсн124(осн124);
        }
        return осн10514;
    }

    private ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн–‘10514 осн–‘10514ћетод(Integer numOfTransaction){
        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн–‘10514 осн–‘10514 = null;
        String осн131 = transactions.get(numOfTransaction)[6];
        String осн132 = transactions.get(numOfTransaction)[7];
        String осн133 = transactions.get(numOfTransaction)[8];
        String осн134 = transactions.get(numOfTransaction)[9];
        String осн135 = transactions.get(numOfTransaction)[10];
        if(осн131 != null || осн132 != null || осн133 != null || осн134 != null || осн135 != null){
            осн–‘10514 = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн–‘10514();
            осн–‘10514.setќсн131(осн131);
            осн–‘10514.setќсн132(осн132);
            осн–‘10514.setќсн133(осн133);
            осн–‘10514.setќсн134(осн134);
            осн–‘10514.setќсн135(осн135);
        }
        return осн–‘10514;
    }

    private ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д осн онтр—дћетод(Integer numOfTransaction){
        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д осн онтр—д = null;
        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн10514 осн10514 = осн10514ћетод(numOfTransaction);
        ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн–‘10514 осн–‘10514 = осн–‘10514ћетод(numOfTransaction);
        String вз«авис = transactions.get(numOfTransaction)[1];
        if(осн10514 != null || осн–‘10514 != null || вз«авис != null){
            осн онтр—д = new ‘айл2012.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д();
            осн онтр—д.setќсн10514(осн10514);
            осн онтр—д.setќсн–‘10514(осн–‘10514);
            осн онтр—д.set¬з«авис(вз«авис);
        }
        return осн онтр—д;
    }

    ‘айл2012 populateClasses(){
        јдр»н“ип адр»н“ип = null;
        if (taxpayer.get(63) != null || taxpayer.get(64) != null ){
            адр»н“ип = new јдр»н“ип();
            адр»н“ип.setќ —ћ(taxpayer.get(63));
            адр»н“ип.setјдр»н“екст(taxpayer.get(64));
        }
        јдр–‘“ип адр–‘“ип = null;
        if (taxpayer.get(53) != null || taxpayer.get(54) != null || taxpayer.get(55) != null ||
                taxpayer.get(56) != null || taxpayer.get(57) != null || taxpayer.get(58) != null ||
                taxpayer.get(59) != null || taxpayer.get(60) != null || taxpayer.get(61) != null){
            адр–‘“ип = new јдр–‘“ип();
            адр–‘“ип.set»ндекс(taxpayer.get(53));
            адр–‘“ип.set од–егион(taxpayer.get(54));
            адр–‘“ип.set–айон(taxpayer.get(55));
            адр–‘“ип.set√ород(taxpayer.get(56));
            адр–‘“ип.setЌаселѕункт(taxpayer.get(57));
            адр–‘“ип.set”лица(taxpayer.get(58));
            адр–‘“ип.setƒом(taxpayer.get(59));
            адр–‘“ип.set орпус(taxpayer.get(60));
            адр–‘“ип.set варт(taxpayer.get(61));
        }

        —вјдр–‘“ип свјдр–‘“ип = null;
        if(адр–‘“ип != null || taxpayer.get(51) != null){
            свјдр–‘“ип = new —вјдр–‘“ип();
            свјдр–‘“ип.setјдр–‘(адр–‘“ип);
            свјдр–‘“ип.setѕрјдр(taxpayer.get(51));
        }

        ”дЋичн‘Ћ“ип удЋичн‘Ћ“ип = null;
        if(taxpayer.get(46) != null || taxpayer.get(47) != null || taxpayer.get(48) != null || taxpayer.get(49) != null){
            удЋичн‘Ћ“ип = new ”дЋичн‘Ћ“ип();
            удЋичн‘Ћ“ип.set од¬идƒок(taxpayer.get(46));
            удЋичн‘Ћ“ип.set—ерЌомƒок(taxpayer.get(47));
            удЋичн‘Ћ“ип.setƒатаƒок(taxpayer.get(48));
            удЋичн‘Ћ“ип.set¬ыдƒок(taxpayer.get(49));
        }

        ‘айл2012.ƒокумент.—вЌѕ.Ќѕ‘Ћ.—в‘Ћ св‘Ћ = null;
        if(удЋичн‘Ћ“ип != null || свјдр–‘“ип != null || адр»н“ип != null || taxpayer.get(40) != null ||
                taxpayer.get(41) != null || taxpayer.get(42) != null || taxpayer.get(43) != null ||
                taxpayer.get(44) != null){
            св‘Ћ = new ‘айл2012.ƒокумент.—вЌѕ.Ќѕ‘Ћ.—в‘Ћ();
            св‘Ћ.set”дЋичн‘Ћ(удЋичн‘Ћ“ип);
            св‘Ћ.set—вјдр–‘(свјдр–‘“ип);
            св‘Ћ.setјдр»н(адр»н“ип);
            св‘Ћ.setƒата–ожд(taxpayer.get(40));
            св‘Ћ.setћесто–ожд(taxpayer.get(41));
            св‘Ћ.setЌал√ражд(taxpayer.get(42));
            св‘Ћ.setќ —ћ(taxpayer.get(43));
            св‘Ћ.set—татусЌѕ(taxpayer.get(44));
        }

        ‘»ќ“ип фио“ип = null;
        if (taxpayer.get(36) != null || taxpayer.get(37) != null || taxpayer.get(38) != null){
            фио“ип = new ‘»ќ“ип();
            фио“ип.set‘амили€(taxpayer.get(36));
            фио“ип.set»м€(taxpayer.get(37));
            фио“ип.setќтчество(taxpayer.get(38));
        }

        ‘айл2012.ƒокумент.—вЌѕ.Ќѕ‘Ћ нпфл = null;
        if (фио“ип != null || taxpayer.get(34) != null || св‘Ћ != null){
            нпфл = new ‘айл2012.ƒокумент.—вЌѕ.Ќѕ‘Ћ();
            нпфл.set‘»ќ(фио“ип);
            нпфл.set»ЌЌ‘Ћ(taxpayer.get(34));
            нпфл.set—в‘Ћ(св‘Ћ);
        }

        ‘айл2012.ƒокумент.—вЌѕ.ЌѕёЋ.—в–еоргёЋ св–еоргёЋ = null;
        if (taxpayer.get(30) != null || taxpayer.get(31) != null || taxpayer.get(32) != null){
            св–еоргёЋ = new ‘айл2012.ƒокумент.—вЌѕ.ЌѕёЋ.—в–еоргёЋ();
            св–еоргёЋ.set‘орм–еорг(taxpayer.get(30));
            св–еоргёЋ.set»ЌЌёЋ(taxpayer.get(31));
            св–еоргёЋ.set ѕѕ(taxpayer.get(32));
        }

        ‘айл2012.ƒокумент.—вЌѕ.ЌѕёЋ нпюл = null;
        if (св–еоргёЋ != null || taxpayer.get(26) != null || taxpayer.get(27) != null || taxpayer.get(28) != null){
            нпюл = new ‘айл2012.ƒокумент.—вЌѕ.ЌѕёЋ();
            нпюл.set—в–еоргёЋ(св–еоргёЋ);
            нпюл.setЌаимќрг(taxpayer.get(26));
            нпюл.set»ЌЌёЋ(taxpayer.get(27));
            нпюл.set ѕѕ(taxpayer.get(28));
        }

        ‘айл2012.ƒокумент.—вЌѕ свЌѕ = null;
        if (нпюл != null || нпфл != null || taxpayer.get(12) != null || taxpayer.get(13) != null ||
                taxpayer.get(14) != null || taxpayer.get(15) != null){
            свЌѕ = new ‘айл2012.ƒокумент.—вЌѕ();
            свЌѕ.setЌѕёЋ(нпюл);
            свЌѕ.setЌѕ‘Ћ(нпфл);
            свЌѕ.setќ ј“ќ(taxpayer.get(12));
            свЌѕ.setќ ¬Ёƒ(taxpayer.get(13));
            свЌѕ.set“лф(taxpayer.get(14));
            свЌѕ.setEMail(taxpayer.get(15));
        }

        ‘айл2012.ƒокумент.ѕодписант.—вѕред свѕред = null;
        if (taxpayer.get(23) != null || taxpayer.get(24) != null){
            свѕред = new ‘айл2012.ƒокумент.ѕодписант.—вѕред();
            свѕред.setЌаимƒок(taxpayer.get(23));
            свѕред.setЌаимќрг(taxpayer.get(24));
        }

        ‘»ќ“ип фио“ип1 = null;
        if (taxpayer.get(19) != null || taxpayer.get(20) != null || taxpayer.get(21) != null){
            фио“ип1 = new ‘»ќ“ип();
            фио“ип1.set‘амили€(taxpayer.get(19));
            фио“ип1.set»м€(taxpayer.get(20));
            фио“ип1.setќтчество(taxpayer.get(21));
        }

        ‘айл2012.ƒокумент.ѕодписант подписант = null;
        if (фио“ип1 != null || свѕред != null || taxpayer.get(17) != null){
            подписант = new ‘айл2012.ƒокумент.ѕодписант();
            подписант.set‘»ќ(фио“ип1);
            подписант.set—вѕред(свѕред);
            подписант.setѕрѕодп(taxpayer.get(17));
        }

        List<‘айл2012.ƒокумент.”в онтр—д.—в онтр—д> св онтр—д = transactionsFilling();
        ‘айл2012.ƒокумент.”в онтр—д ув онтр—д = null;
        if(св онтр—д != null){
            ув онтр—д = new ‘айл2012.ƒокумент.”в онтр—д();
            ув онтр—д.set—в онтр—д(св онтр—д);
        }

        ‘айл2012.ƒокумент документ = null;
        if (свЌѕ != null || подписант != null || ув онтр—д != null || taxpayer.get(5) != null ||
                taxpayer.get(6) != null || taxpayer.get(7) != null || taxpayer.get(8) != null ||
                taxpayer.get(9) != null || taxpayer.get(10) != null){
            документ = new ‘айл2012.ƒокумент();
            документ.set—вЌѕ(свЌѕ);
            документ.setѕодписант(подписант);
            документ.set”в онтр—д(ув онтр—д);
            документ.set Ќƒ(taxpayer.get(5));
            документ.setƒатаƒок(taxpayer.get(6));
            документ.setќтчет√од(taxpayer.get(7));
            документ.set одЌќ(taxpayer.get(8));
            документ.setЌом орр(taxpayer.get(9));
            документ.setѕоћесту(taxpayer.get(10));
        }

        ‘айл2012 файл2012 = null;
        if (документ != null || taxpayer.get(1) != null || taxpayer.get(2) != null || taxpayer.get(3) != null){
            файл2012 = new ‘айл2012();
            файл2012.setƒокумент(документ);
            файл2012.set»д‘айл(taxpayer.get(1));
            файл2012.set¬ерсѕрог(taxpayer.get(2));
            файл2012.set¬ерс‘орм(taxpayer.get(3));
        }

        return файл2012;
    }
}
