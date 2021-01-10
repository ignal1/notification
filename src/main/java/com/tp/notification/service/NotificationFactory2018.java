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

    private List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д> transactionsFilling(){
        List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д> св онтр—д—писок = null;
        if(transactions.size() != 0){
            св онтр—д—писок = new ArrayList<>();
            for(String[] item : transactions){
                ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д св онтр—д = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д();
                Integer numOfTransaction = Integer.parseInt(item[0]);
                св онтр—д.setƒох–асх—д(дох–асх—дћетод(numOfTransaction - 1));
                св онтр—д.set онтр—д(контр—дћетод(numOfTransaction - 1));
                св онтр—д.setќсн онтр—д(осн онтр—дћетод(numOfTransaction - 1));
                св онтр—д.set—вѕредм—дЌ(свѕредм—дЌћетод(numOfTransaction));
                св онтр—д.set—вќрг”част(свќрг”частћетод(numOfTransaction));
                св онтр—д.set—в‘Ћ”част(св‘Ћ”частћетод(numOfTransaction));
                св онтр—д.setЌомѕор—д(BigInteger.valueOf(numOfTransaction));
                св онтр—д.set—делка—овјгент(item[1]);
                св онтр—д—писок.add(св онтр—д);
            }
        }
        return св онтр—д—писок;
    }

    private List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част> свќрг”частћетод(Integer numOfTransaction){
        List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част> свќрг”част—писок = null;
        if(partiesOrganizations.size() != 0){
            свќрг”част—писок = new ArrayList<>();
            for(String[] item : partiesOrganizations){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част свќрг”част = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вќрг”част();
                    свќрг”част.setЌомѕор—д(item[1] == null ? null : new BigInteger(item[1]));
                    свќрг”част.set—ведќтнјгент(item[2]);
                    свќрг”част.setѕрќрг(item[3]);
                    свќрг”част. setќ —ћ(ServiceUtils.threeDigitCheck(item[4]));
                    свќрг”част.setЌаимќрг–ус(item[5]);
                    свќрг”част.setЌаимќргЋат(item[6]);
                    свќрг”част.set»ЌЌёЋ(item[7]);
                    свќрг”част.set ѕѕ(item[8]);
                    свќрг”част.set–егЌом»н(item[9]);
                    свќрг”част.set одЌѕ–ег(item[10]);
                    свќрг”част.setјдр»н“екст(item[11]);
                    свќрг”част—писок.add(свќрг”част);
                }
            }
        }
        return свќрг”част—писок;
    }

    private ‘»ќ“ип фио“ипћетод(int index){
        ‘»ќ“ип фио“ип = null;
        String фамили€ = partiesPersons.get(index)[4];
        String им€ = partiesPersons.get(index)[5];
        String отчество = partiesPersons.get(index)[6];
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
        String код¬идƒок = partiesPersons.get(index)[12];
        String серЌомƒок = partiesPersons.get(index)[13];
        String датаƒок = partiesPersons.get(index)[14];
        String выдƒок = partiesPersons.get(index)[15];
        if (код¬идƒок != null || серЌомƒок != null || датаƒок != null || выдƒок != null){
            удЋичн‘Ћ“ип = new ”дЋичн‘Ћ“ип();
            удЋичн‘Ћ“ип.set од¬идƒок(код¬идƒок);
            удЋичн‘Ћ“ип.set—ерЌомƒок(серЌомƒок);
            удЋичн‘Ћ“ип.setƒатаƒок(датаƒок);
            удЋичн‘Ћ“ип.set¬ыдƒок(выдƒок);
        }
        return удЋичн‘Ћ“ип;
    }

    private јдр»н“ип адр»н“ипћетод(int index){
        јдр»н“ип адр»н“ип = null;
        String оксм = partiesPersons.get(index)[16];
        String адр»н“екст = partiesPersons.get(index)[17];
        if(оксм != null || адр»н“екст != null){
            адр»н“ип = new јдр»н“ип();
            адр»н“ип.setќ —ћ(оксм);
            адр»н“ип.setјдр»н“екст(адр»н“екст);
        }
        return адр»н“ип;
    }

    private ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част.—в‘Ћ св‘Ћћетод(int index){
        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част.—в‘Ћ св‘Ћ = null;
        String дата–ожд = partiesPersons.get(index)[8];
        String место–ожд = partiesPersons.get(index)[9];
        String гражд = partiesPersons.get(index)[10];
        String оксм = partiesPersons.get(index)[11];
        ”дЋичн‘Ћ“ип удЋичн‘Ћ“ип = удЋичн‘Ћ“ипћетод(index);
        јдр»н“ип адр»н“ип = адр»н“ипћетод(index);
        if(дата–ожд != null || место–ожд != null || гражд != null || оксм != null ||
                удЋичн‘Ћ“ип != null || адр»н“ип != null){
            св‘Ћ = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част.—в‘Ћ();
            св‘Ћ.setƒата–ожд(дата–ожд);
            св‘Ћ.setћесто–ожд(место–ожд);
            св‘Ћ.set√ражд(гражд);
            св‘Ћ.setќ —ћ(оксм);
            св‘Ћ.set”дЋичн‘Ћ(удЋичн‘Ћ“ип);
            св‘Ћ.setјдр»н(адр»н“ип);
        }
        return св‘Ћ;
    }

    private List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част> св‘Ћ”частћетод(Integer numOfTransaction){
        List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част> св‘Ћ”част—писок = null;
        if(partiesPersons.size() != 0){
            св‘Ћ”част—писок = new ArrayList<>();
            int counter = 0;
            for(String[] item : partiesPersons){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част св‘Ћ”част = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—в‘Ћ”част();
                    св‘Ћ”част.setЌомѕор—д(item[1] == null ? null : new BigInteger(item[1]));
                    св‘Ћ”част.set—ведќтнјгент(item[2]);
                    св‘Ћ”част.set од¬ƒ(item[3]);
                    св‘Ћ”част.set‘»ќ(фио“ипћетод(counter));
                    св‘Ћ”част.set»ЌЌ‘Ћ(item[7]);
                    св‘Ћ”част.set—в‘Ћ(св‘Ћћетод(counter));
                    св‘Ћ”част—писок.add(св‘Ћ”част);
                }
                counter++;
            }
        }
        return св‘Ћ”част—писок;
    }

    private ћесто“ип место“ипћетод(String оксм, String код–егион, String населѕункт){
        ћесто“ип место“ип = null;
        if(оксм != null || код–егион != null || населѕункт != null){
            место“ип = new ћесто“ип();
            место“ип.setќ —ћ(ServiceUtils.threeDigitCheck(оксм));
            место“ип.set од–егион(ServiceUtils.twoDigitCheck(код–егион));
            место“ип.setЌаселѕункт(населѕункт);
        }
        return место“ип;
    }

    private ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ.ѕерѕред—д перѕред—дћетод(int index){
        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ.ѕерѕред—д перѕред—д = null;
        String наимѕред—д = subjects.get(index)[2];
        String тнвэд = subjects.get(index)[3];
        String окпд2 = subjects.get(index)[4];
        String оквэд2 = subjects.get(index)[5];
        String ном”ч—д = subjects.get(index)[6];
        String номƒог = subjects.get(index)[7];
        String датаƒог = subjects.get(index)[8];
        String оксм = subjects.get(index)[9];
        String код”словѕост = subjects.get(index)[10];
        String океи = subjects.get(index)[11];
        String количество = subjects.get(index)[12];
        String цена≈дин = subjects.get(index)[13];
        String код¬алют = subjects.get(index)[14];
        String проц—тав = subjects.get(index)[15];
        String стоим»тог = subjects.get(index)[16];
        String дата—ов—д = subjects.get(index)[17];
        String оксм1 = subjects.get(index)[18];
        String код–егион1 = subjects.get(index)[19];
        String населѕункт1 = subjects.get(index)[20];
        ћесто“ип местќтпр“ов = место“ипћетод(оксм1, код–егион1, населѕункт1);
        String оксм2 = subjects.get(index)[18];
        String код–егион2 = subjects.get(index)[19];
        String населѕункт2 = subjects.get(index)[20];
        ћесто“ип мест—ов—д = место“ипћетод(оксм2, код–егион2, населѕункт2);
        if(наимѕред—д != null || тнвэд != null || окпд2 != null || оквэд2 != null
                || ном”ч—д != null || номƒог != null || датаƒог != null || оксм != null
                || код”словѕост != null || океи != null || количество != null || цена≈дин != null
                || код¬алют != null || проц—тав != null || стоим»тог != null || дата—ов—д != null
                || местќтпр“ов != null || мест—ов—д != null){
            перѕред—д = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ.ѕерѕред—д();
            перѕред—д.setЌаимѕред—д(наимѕред—д);
            перѕред—д.set“Ќ¬Ёƒ(тнвэд);
            перѕред—д.setќ ѕƒ2(окпд2);
            перѕред—д.setќ ¬Ёƒ2(оквэд2);
            перѕред—д.setЌом”ч—д(ном”ч—д == null ? null : new BigInteger(ном”ч—д));
            перѕред—д.setЌомƒог(номƒог);
            перѕред—д.setƒатаƒог(датаƒог);
            перѕред—д.setќ —ћ(ServiceUtils.threeDigitCheck(оксм));
            перѕред—д.set од”словѕост(код”словѕост);
            перѕред—д.setќ ≈»(ServiceUtils.threeDigitCheck(океи));
            перѕред—д.set оличество(количество == null ? null : new BigDecimal(количество));
            перѕред—д.set÷ена≈дин(цена≈дин == null ? null : new BigDecimal(цена≈дин));
            перѕред—д.set од¬алют(ServiceUtils.threeDigitCheck(код¬алют));
            перѕред—д.setѕроц—тав(проц—тав == null ? null : new BigDecimal(проц—тав));
            перѕред—д.set—тоим»тог(стоим»тог == null ? null : new BigInteger(стоим»тог));
            перѕред—д.setƒата—ов—д(дата—ов—д);
            перѕред—д.setћестќтпр“ов(местќтпр“ов);
            перѕред—д.setћест—ов—д(мест—ов—д);
        }
        return перѕред—д;
    }

    private List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ> свѕредм—дЌћетод(Integer numOfTransaction){
        List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ> свѕредм—дЌ—писок = null;
        if(subjects.size() != 0){
            свѕредм—дЌ—писок = new ArrayList<>();
            Map<String, ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ> map = new HashMap<>();
            int counter = 0;
            for(String[] item : subjects){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    if(!map.containsKey(item[1])){
                        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ свѕредм—дЌ = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ();
                        свѕредм—дЌ.set“ипѕред—д(item[1]);
                        List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ.ѕерѕред—д> перѕред—д—писок = new ArrayList<>();
                        перѕред—д—писок.add(перѕред—дћетод(counter));
                        свѕредм—дЌ.setѕерѕред—д(перѕред—д—писок);
                        map.put(item[1], свѕредм—дЌ);
                    }
                    else{
                        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ свѕредм—дЌ = map.get(item[1]);
                        свѕредм—дЌ.getѕерѕред—д().add(перѕред—дћетод(counter));
                    }
                }
                counter++;
            }
            for(Map.Entry<String, ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.—вѕредм—дЌ> item : map.entrySet()){
                свѕредм—дЌ—писок.add(item.getValue());
            }
            String numOfTransactionString = numOfTransaction.toString();
            subjects = subjects.stream().filter(p -> !p[0].equals(numOfTransactionString)).collect(Collectors.toList());
        }
        return свѕредм—дЌ—писок;
    }

    private ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ƒох–асх—д дох–асх—дћетод(Integer numOfTransaction){
        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ƒох–асх—д дох–асх—д = null;
        String сумƒох—д = transactions.get(numOfTransaction)[37];
        String сумƒох—д–ег = transactions.get(numOfTransaction)[38];
        String сум–асх—д = transactions.get(numOfTransaction)[39];
        String сум–асх—д–ег = transactions.get(numOfTransaction)[40];
        if(сумƒох—д != null || сумƒох—д–ег != null || сум–асх—д != null || сум–асх—д–ег != null){
            дох–асх—д = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ƒох–асх—д();
            дох–асх—д.set—умƒох—д(сумƒох—д == null ? null : new BigInteger(сумƒох—д));
            дох–асх—д.set—умƒох—д–ег(сумƒох—д–ег == null ? null : new BigInteger(сумƒох—д–ег));
            дох–асх—д.set—ум–асх—д(сум–асх—д == null ? null : new BigInteger(сум–асх—д));
            дох–асх—д.set—ум–асх—д–ег(сум–асх—д–ег == null ? null : new BigInteger(сум–асх—д–ег));
        }
        return дох–асх—д;
    }

    private ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д. од»ст»нф код»ст»нфћетод(Integer numOfTransaction){
        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д. од»ст»нф код»ст»нф = null;
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
            код»ст»нф = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д. од»ст»нф();
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

    private ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д контр—дћетод(Integer numOfTransaction){
        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д контр—д = null;
        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д. од»ст»нф код»ст»нф = код»ст»нфћетод(numOfTransaction);
        String групќ— = transactions.get(numOfTransaction)[17];
        String кодЌаим—д = transactions.get(numOfTransaction)[18];
        String код—тор—д = transactions.get(numOfTransaction)[19];
        String прќпр÷ен = transactions.get(numOfTransaction)[20];
        String комѕрќпр÷ен = transactions.get(numOfTransaction)[21];
        String кодќпр÷ен = transactions.get(numOfTransaction)[22];
        String ком одќпр÷ен = transactions.get(numOfTransaction)[23];
        String кодћет÷ен = transactions.get(numOfTransaction)[24];
        String ком одћет÷ен = transactions.get(numOfTransaction)[25];
        String кол”ч—д = transactions.get(numOfTransaction)[26];
        String ком ол”ч—д = transactions.get(numOfTransaction)[27];
        if(код»ст»нф != null || групќ— != null || кодЌаим—д != null || код—тор—д != null || прќпр÷ен != null ||
                комѕрќпр÷ен != null || кодќпр÷ен != null || ком одќпр÷ен != null || кодћет÷ен != null ||
                ком одћет÷ен != null || кол”ч—д != null || ком ол”ч—д != null){
            контр—д = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д. онтр—д();
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

    private ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн10514 осн10514ћетод(Integer numOfTransaction){
        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн10514 осн10514 = null;
        String осн121 = transactions.get(numOfTransaction)[3];
        String осн122 = transactions.get(numOfTransaction)[4];
        String осн123 = transactions.get(numOfTransaction)[5];
        String осн124 = transactions.get(numOfTransaction)[6];
        if(осн121 != null || осн122 != null || осн123 != null || осн124 != null){
            осн10514 = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн10514();
            осн10514.setќсн121(осн121);
            осн10514.setќсн122(осн122);
            осн10514.setќсн123(осн123);
            осн10514.setќсн124(осн124);
        }
        return осн10514;
    }

    private ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн–‘10514 осн–‘10514ћетод(Integer numOfTransaction){
        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн–‘10514 осн–‘10514 = null;
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
            осн–‘10514 = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн–‘10514();
            осн–‘10514.setќсн131(осн131);
            осн–‘10514.setќсн132(осн132);
            осн–‘10514.setќсн133(осн133);
            осн–‘10514.setќсн134(осн134);
            осн–‘10514.setќсн135(осн135);
            осн–‘10514.setќсн136(осн136);
            осн–‘10514.setќсн137(осн137);
            осн–‘10514.setќсн138(осн138);
            осн–‘10514.setќсн139(осн139);
            осн–‘10514.setќсн140(осн140);
        }
        return осн–‘10514;
    }

    private ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д осн онтр—дћетод(Integer numOfTransaction){
        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д осн онтр—д = null;
        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн10514 осн10514 = осн10514ћетод(numOfTransaction);
        ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д.ќсн–‘10514 осн–‘10514 = осн–‘10514ћетод(numOfTransaction);
        String вз«авис = transactions.get(numOfTransaction)[2];
        if(осн10514 != null || осн–‘10514 != null || вз«авис != null){
            осн онтр—д = new ‘айл2018.ƒокумент.”в онтр—д.—в онтр—д.ќсн онтр—д();
            осн онтр—д.setќсн10514(осн10514);
            осн онтр—д.setќсн–‘10514(осн–‘10514);
            осн онтр—д.set¬з«авис(вз«авис);
        }
        return осн онтр—д;
    }


    ‘айл2018 populateClasses(){

        јдр»н“ип адр»н“ип = null;
        if (taxpayer.get(54) != null || taxpayer.get(55) != null ){
            адр»н“ип = new јдр»н“ип();
            адр»н“ип.setќ —ћ(taxpayer.get(54));
            адр»н“ип.setјдр»н“екст(taxpayer.get(55));
        }

        ”дЋичн‘Ћ“ип удЋичн‘Ћ“ип = null;
        if(taxpayer.get(49) != null || taxpayer.get(50) != null || taxpayer.get(51) != null || taxpayer.get(52) != null){
            удЋичн‘Ћ“ип = new ”дЋичн‘Ћ“ип();
            удЋичн‘Ћ“ип.set од¬идƒок(taxpayer.get(49));
            удЋичн‘Ћ“ип.set—ерЌомƒок(taxpayer.get(50));
            удЋичн‘Ћ“ип.setƒатаƒок(taxpayer.get(51));
            удЋичн‘Ћ“ип.set¬ыдƒок(taxpayer.get(52));
        }

        ‘айл2018.ƒокумент.—вЌѕ.Ќѕ‘Ћ.—в‘Ћ св‘Ћ = null;
        if(удЋичн‘Ћ“ип != null || адр»н“ип != null || taxpayer.get(43) != null
                || taxpayer.get(44) != null || taxpayer.get(45) != null
                || taxpayer.get(46) != null || taxpayer.get(47) != null){
            св‘Ћ = new ‘айл2018.ƒокумент.—вЌѕ.Ќѕ‘Ћ.—в‘Ћ();
            св‘Ћ.set”дЋичн‘Ћ(удЋичн‘Ћ“ип);
            св‘Ћ.setјдр»н(адр»н“ип);
            св‘Ћ.setƒата–ожд(taxpayer.get(43));
            св‘Ћ.setћесто–ожд(taxpayer.get(44));
            св‘Ћ.set√ражд(taxpayer.get(45));
            св‘Ћ.setќ —ћ(taxpayer.get(46));
            св‘Ћ.set—татусЌѕ(taxpayer.get(47));
        }

        ‘»ќ“ип фио“ип = null;
        if (taxpayer.get(39) != null || taxpayer.get(40) != null
                || taxpayer.get(41) != null){
            фио“ип = new ‘»ќ“ип();
            фио“ип.set‘амили€(taxpayer.get(39));
            фио“ип.set»м€(taxpayer.get(40));
            фио“ип.setќтчество(taxpayer.get(41));
        }

        ‘айл2018.ƒокумент.—вЌѕ.Ќѕ‘Ћ нпфл = null;
        if (фио“ип != null || taxpayer.get(37) != null || св‘Ћ != null){
            нпфл = new ‘айл2018.ƒокумент.—вЌѕ.Ќѕ‘Ћ();
            нпфл.set‘»ќ(фио“ип);
            нпфл.set»ЌЌ‘Ћ(taxpayer.get(37));
            нпфл.set—в‘Ћ(св‘Ћ);
        }

        ‘айл2018.ƒокумент.—вЌѕ.ЌѕёЋ.—в–еоргёЋ св–еоргёЋ = null;
        if (taxpayer.get(33) != null || taxpayer.get(34) != null
                || taxpayer.get(35) != null){
            св–еоргёЋ = new ‘айл2018.ƒокумент.—вЌѕ.ЌѕёЋ.—в–еоргёЋ();
            св–еоргёЋ.set‘орм–еорг(taxpayer.get(33));
            св–еоргёЋ.set»ЌЌёЋ(taxpayer.get(34));
            св–еоргёЋ.set ѕѕ(taxpayer.get(35));
        }

        ‘айл2018.ƒокумент.—вЌѕ.ЌѕёЋ нпюл = null;
        if (св–еоргёЋ != null || taxpayer.get(29) != null
                || taxpayer.get(30) != null || taxpayer.get(31) != null){
            нпюл = new ‘айл2018.ƒокумент.—вЌѕ.ЌѕёЋ();
            нпюл.set—в–еоргёЋ(св–еоргёЋ);
            нпюл.setЌаимќрг(taxpayer.get(29));
            нпюл.set»ЌЌёЋ(taxpayer.get(30));
            нпюл.set ѕѕ(taxpayer.get(31));
        }

        ‘айл2018.ƒокумент.—вЌѕ свЌѕ = null;
        if (нпюл != null || нпфл != null || taxpayer.get(16) != null
                || taxpayer.get(17) != null || taxpayer.get(18) != null){
            свЌѕ = new ‘айл2018.ƒокумент.—вЌѕ();
            свЌѕ.setЌѕёЋ(нпюл);
            свЌѕ.setЌѕ‘Ћ(нпфл);
            свЌѕ.setќ “ћќ(taxpayer.get(16));
            свЌѕ.set“лф(taxpayer.get(17));
            свЌѕ.setEMail(taxpayer.get(18));
        }

        ‘айл2018.ƒокумент.ѕодписант.—вѕред свѕред = null;
        if (taxpayer.get(26) != null || taxpayer.get(27) != null){
            свѕред = new ‘айл2018.ƒокумент.ѕодписант.—вѕред();
            свѕред.setЌаимƒок(taxpayer.get(26));
            свѕред.setЌаимќрг(taxpayer.get(27));
        }

        ‘»ќ“ип фио“ип1 = null;
        if (taxpayer.get(22) != null || taxpayer.get(23) != null || taxpayer.get(24) != null){
            фио“ип1 = new ‘»ќ“ип();
            фио“ип1.set‘амили€(taxpayer.get(22));
            фио“ип1.set»м€(taxpayer.get(23));
            фио“ип1.setќтчество(taxpayer.get(24));
        }

        ‘айл2018.ƒокумент.ѕодписант подписант = null;
        if (фио“ип1 != null || свѕред != null || taxpayer.get(20) != null){
            подписант = new ‘айл2018.ƒокумент.ѕодписант();
            подписант.set‘»ќ(фио“ип1);
            подписант.set—вѕред(свѕред);
            подписант.setѕрѕодп(taxpayer.get(20));
        }

        List<‘айл2018.ƒокумент.”в онтр—д.—в онтр—д> св онтр—д = transactionsFilling();
        ‘айл2018.ƒокумент.”в онтр—д ув онтр—д = null;
        if(св онтр—д != null){
            ув онтр—д = new ‘айл2018.ƒокумент.”в онтр—д();
            ув онтр—д.set—в онтр—д(св онтр—д);
        }

        ‘айл2018.ƒокумент документ = null;
        if (свЌѕ != null || подписант != null || ув онтр—д != null || taxpayer.get(9) != null ||
                taxpayer.get(10) != null || taxpayer.get(11) != null || taxpayer.get(12) != null ||
                taxpayer.get(13) != null || taxpayer.get(14) != null){
            документ = new ‘айл2018.ƒокумент();
            документ.set—вЌѕ(свЌѕ);
            документ.setѕодписант(подписант);
            документ.set”в онтр—д(ув онтр—д);
            документ.set Ќƒ(taxpayer.get(9));
            документ.setƒатаƒок(taxpayer.get(10));
            документ.setќтчет√од(taxpayer.get(11));
            документ.set одЌќ(taxpayer.get(12));
            документ.setЌом орр(taxpayer.get(13));
            документ.setѕоћесту(taxpayer.get(14));
        }

        ‘айл2018 файл2018 = null;
        if (документ != null || taxpayer.get(1) != null || taxpayer.get(2) != null
                || taxpayer.get(3) != null || taxpayer.get(4) != null || taxpayer.get(5) != null
                || taxpayer.get(6) != null || taxpayer.get(7) != null){
            файл2018 = new ‘айл2018();
            файл2018.setƒокумент(документ);
            файл2018.set»д‘айл(taxpayer.get(1));
            файл2018.set¬ерсѕрог(taxpayer.get(2));
            файл2018.set¬ерс‘орм(taxpayer.get(3));
            файл2018.set»д‘айл»сх(taxpayer.get(4));
            файл2018.set»д‘айлѕерв(taxpayer.get(5));
            файл2018.set ол‘айл(taxpayer.get(6));
            файл2018.setЌом‘айл(taxpayer.get(7));
        }
        return файл2018;
    }
}

