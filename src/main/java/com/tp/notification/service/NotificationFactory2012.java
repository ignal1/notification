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

    private List<����2012.��������.���������.���������> transactionsFilling(){
        List<����2012.��������.���������.���������> ��������������� = null;
        if(transactions.size() != 0){
            ��������������� = new ArrayList<>();
            for(String[] item : transactions){
                ����2012.��������.���������.��������� ��������� = new ����2012.��������.���������.���������();
                Integer numOfTransaction = Integer.parseInt(item[0]);
                ���������.set���������(��������������(numOfTransaction - 1));
                ���������.set�������(������������(numOfTransaction - 1));
                ���������.set����������(���������������(numOfTransaction - 1));
                ���������.set���������(��������������(numOfTransaction));
                ���������.set����������(���������������(numOfTransaction));
                ���������.set���������(��������������(numOfTransaction));
                ���������.set��������(BigInteger.valueOf(numOfTransaction));
                ���������������.add(���������);
            }
        }
        return ���������������;
    }

    private List<����2012.��������.���������.���������.����������> ���������������(Integer numOfTransaction){
        List<����2012.��������.���������.���������.����������> ���������������� = null;
        if(partiesOrganizations.size() != 0){
            ���������������� = new ArrayList<>();
            for(String[] item : partiesOrganizations){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    ����2012.��������.���������.���������.���������� ���������� = new ����2012.��������.���������.���������.����������();
                    ����������.set��������(item[1] == null ? null : new BigInteger(item[1]));
                    ����������.set�����(item[2]);
                    ����������.set����(ServiceUtils.threeDigitCheck(item[3]));
                    ����������.set�������(item[4]);
                    ����������.set�����(item[5]);
                    ����������.set���(item[6]);
                    ����������.set��������(item[7]);
                    ����������.set��������(item[8]);
                    ����������.set����������(item[9]);
                    ����������������.add(����������);
                }
            }
        }
        return ����������������;
    }

    private ������ �����������(int index){
        ������ ������ = null;
        String ������� = partiesPersons.get(index)[3];
        String ��� = partiesPersons.get(index)[4];
        String �������� = partiesPersons.get(index)[5];
        if (������� != null || ��� != null || �������� != null){
            ������ = new ������();
            ������.set�������(�������);
            ������.set���(���);
            ������.set��������(��������);
        }
        return ������;
    }

    private ����������� ����������������(int index){
        ����������� ����������� = null;
        String ��������� = partiesPersons.get(index)[11];
        String ��������� = partiesPersons.get(index)[12];
        String ������� = partiesPersons.get(index)[13];
        String ������ = partiesPersons.get(index)[14];
        if (��������� != null || ��������� != null || ������� != null || ������ != null){
            ����������� = new �����������();
            �����������.set���������(���������);
            �����������.set���������(���������);
            �����������.set�������(�������);
            �����������.set������(������);
        }
        return �����������;
    }

    private �������� �������������(int index){
        �������� �������� = null;
        String ������ = partiesPersons.get(index)[16];
        String ��������� = partiesPersons.get(index)[17];
        String ����� = partiesPersons.get(index)[18];
        String ����� = partiesPersons.get(index)[19];
        String ���������� = partiesPersons.get(index)[20];
        String ����� = partiesPersons.get(index)[21];
        String ��� = partiesPersons.get(index)[22];
        String ������ = partiesPersons.get(index)[23];
        String ����� = partiesPersons.get(index)[24];
        if(������ != null || ��������� != null || ����� != null || ����� != null || ���������� != null ||
                ����� != null  || ��� != null || ������ != null || ����� != null ){
            �������� = new ��������();
            ��������.set������(������);
            ��������.set���������(���������);
            ��������.set�����(�����);
            ��������.set�����(�����);
            ��������.set����������(����������);
            ��������.set�����(�����);
            ��������.set���(���);
            ��������.set������(������);
            ��������.set�����(�����);
        }
        return ��������;
    }

    private ���������� ���������������(int index){
        ���������� ���������� = null;
        String ����� = partiesPersons.get(index)[15];
        �������� �������� = �������������(index);
        if(����� != null || �������� != null){
            ���������� = new ����������();
            ����������.set�����(�����);
            ����������.set�����(��������);
        }
        return ����������;
    }

    private �������� �������������(int index){
        �������� �������� = null;
        String ���� = partiesPersons.get(index)[25];
        String ���������� = partiesPersons.get(index)[26];
        if(���� != null || ���������� != null){
            �������� = new ��������();
            ��������.set����(����);
            ��������.set����������(����������);
        }
        return ��������;
    }

    private ����2012.��������.���������.���������.���������.���� ���������(int index){
        ����2012.��������.���������.���������.���������.���� ���� = null;
        String �������� = partiesPersons.get(index)[7];
        String ��������� = partiesPersons.get(index)[8];
        String �������� = partiesPersons.get(index)[9];
        String ���� = partiesPersons.get(index)[10];
        ����������� ����������� = ����������������(index);
        ���������� ���������� = ���������������(index);
        �������� �������� = �������������(index);
        if(�������� != null || ��������� != null || �������� != null || ���� != null ||
                ����������� != null || ���������� != null || �������� != null){
            ���� = new ����2012.��������.���������.���������.���������.����();
            ����.set��������(��������);
            ����.set���������(���������);
            ����.set��������(��������);
            ����.set����(����);
            ����.set��������(�����������);
            ����.set�������(����������);
            ����.set�����(��������);
        }
        return ����;
    }

    private List<����2012.��������.���������.���������.���������> ��������������(Integer numOfTransaction){
        List<����2012.��������.���������.���������.���������> ��������������� = null;
        if(partiesPersons.size() != 0){
            ��������������� = new ArrayList<>();
            int counter = 0;
            for(String[] item : partiesPersons){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    ����2012.��������.���������.���������.��������� ��������� = new ����2012.��������.���������.���������.���������();
                    ���������.set��������(item[1] == null ? null : new BigInteger(item[1]));
                    ���������.set�����(item[2]);
                    ���������.set���(�����������(counter));
                    ���������.set�����(item[6]);
                    ���������.set����(���������(counter));
                    ���������������.add(���������);
                }
                counter++;
            }
        }
        return ���������������;
    }

    private �������� �������������(String ����, String ���������, String �����, String ����������){
        �������� �������� = null;
        if(���� != null || ��������� != null || ����� != null || ���������� != null){
            �������� = new ��������();
            ��������.set����(ServiceUtils.threeDigitCheck(����));
            ��������.set���������(ServiceUtils.twoDigitCheck(���������));
            ��������.set�����(�����);
            ��������.set����������(����������);
        }
        return ��������;
    }

    private ����2012.��������.���������.���������.���������.��������� ��������������(int index){
        ����2012.��������.���������.���������.���������.��������� ��������� = null;
        String ���������� = subjects.get(index)[2];
        String ����� = subjects.get(index)[3];
        String ��� = subjects.get(index)[4];
        String ����� = subjects.get(index)[5];
        String ������� = subjects.get(index)[6];
        String ������ = subjects.get(index)[7];
        String ������� = subjects.get(index)[8];
        String ���� = subjects.get(index)[9];
        String ������������ = subjects.get(index)[10];
        String ���� = subjects.get(index)[11];
        String ���������� = subjects.get(index)[12];
        String �������� = subjects.get(index)[13];
        String ��������� = subjects.get(index)[14];
        String ��������� = subjects.get(index)[15];
        String ����1 = subjects.get(index)[16];
        String ���������1 = subjects.get(index)[17];
        String �����1 = subjects.get(index)[18];
        String ����������1 = subjects.get(index)[19];
        �������� ����������� = �������������(����1, ���������1, �����1, ����������1);
        String ����2 = subjects.get(index)[20];
        String ���������2 = subjects.get(index)[21];
        String �����2 = subjects.get(index)[22];
        String ����������2 = subjects.get(index)[23];
        �������� ��������� = �������������(����2, ���������2, �����2, ����������2);
        if(���������� != null || ����� != null || ��� != null || ����� != null || ������� != null || ������ != null
                || ������� != null || ���� != null || ������������ != null || ���� != null || ���������� != null
                || �������� != null || ��������� != null || ��������� != null || ����������� != null || ��������� != null){
            ��������� = new ����2012.��������.���������.���������.���������.���������();
            ���������.set����������(����������);
            ���������.set�����(�����);
            ���������.set���(���);
            ���������.set�����(�����);
            ���������.set�������(������� == null ? null : new BigInteger(�������));
            ���������.set������(������);
            ���������.set�������(�������);
            ���������.set����(ServiceUtils.threeDigitCheck(����));
            ���������.set������������(������������);
            ���������.set����(ServiceUtils.threeDigitCheck(����));
            ���������.set����������(���������� == null ? null : new BigInteger(����������));
            ���������.set��������(�������� == null ? null : new BigInteger(��������));
            ���������.set���������(��������� == null ? null : new BigInteger(���������));
            ���������.set���������(���������);
            ���������.set�����������(�����������);
            ���������.set���������(���������);
        }
        return ���������;
    }

    private List<����2012.��������.���������.���������.���������> ��������������(Integer numOfTransaction){
        List<����2012.��������.���������.���������.���������> ��������������� = null;
        if(subjects.size() != 0){
            ��������������� = new ArrayList<>();
            Map<String, ����2012.��������.���������.���������.���������> map = new HashMap<>();
            int counter = 0;
            for(String[] item : subjects){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    if(!map.containsKey(item[1])){
                        ����2012.��������.���������.���������.��������� ��������� = new ����2012.��������.���������.���������.���������();
                        ���������.set���������(item[1]);
                        List<����2012.��������.���������.���������.���������.���������> ��������������� = new ArrayList<>();
                        ���������������.add(��������������(counter));
                        ���������.set���������(���������������);
                        map.put(item[1], ���������);
                    }
                    else{
                        ����2012.��������.���������.���������.��������� ��������� = map.get(item[1]);
                        ���������.get���������().add(��������������(counter));
                    }
                }
                counter++;
            }
            for(Map.Entry<String, ����2012.��������.���������.���������.���������> item : map.entrySet()){
                ���������������.add(item.getValue());
            }
            String numOfTransactionString = numOfTransaction.toString();
            subjects = subjects.stream().filter(p -> !p[0].equals(numOfTransactionString)).collect(Collectors.toList());
        }
        return ���������������;
    }

    private ����2012.��������.���������.���������.��������� ��������������(Integer numOfTransaction){
        ����2012.��������.���������.���������.��������� ��������� = null;
        String �������� = transactions.get(numOfTransaction)[31];
        String ����������� = transactions.get(numOfTransaction)[32];
        String ��������� = transactions.get(numOfTransaction)[33];
        String ������������ = transactions.get(numOfTransaction)[34];
        if(�������� != null || ����������� != null || ��������� != null || ������������ != null){
            ��������� = new ����2012.��������.���������.���������.���������();
            ���������.set��������(�������� == null ? null : new BigInteger(��������));
            ���������.set�����������(����������� == null ? null : new BigInteger(�����������));
            ���������.set���������(��������� == null ? null : new BigInteger(���������));
            ���������.set������������(������������ == null ? null : new BigInteger(������������));
        }
        return ���������;
    }

    private ����2012.��������.���������.���������.�������.��������� ��������������(Integer numOfTransaction){
        ����2012.��������.���������.���������.�������.��������� ��������� = null;
        String ���251 = transactions.get(numOfTransaction)[22];
        String ���252 = transactions.get(numOfTransaction)[23];
        String ���253 = transactions.get(numOfTransaction)[24];
        String ���254 = transactions.get(numOfTransaction)[25];
        String ���255 = transactions.get(numOfTransaction)[26];
        String ���256 = transactions.get(numOfTransaction)[27];
        String ���257 = transactions.get(numOfTransaction)[28];
        String ���258 = transactions.get(numOfTransaction)[29];
        String ���259 = transactions.get(numOfTransaction)[30];
        if(���251 != null || ���252 != null || ���253 != null || ���254 != null || ���255 != null ||
                ���256 != null || ���257 != null || ���258 != null || ���259 != null){
            ��������� = new ����2012.��������.���������.���������.�������.���������();
            ���������.set���251(���251);
            ���������.set���252(���252);
            ���������.set���253(���253);
            ���������.set���254(���254);
            ���������.set���255(���255);
            ���������.set���256(���256);
            ���������.set���257(���257);
            ���������.set���258(���258);
            ���������.set���259(���259);
        }
        return ���������;
    }

    private ����2012.��������.���������.���������.������� ������������(Integer numOfTransaction){
        ����2012.��������.���������.���������.������� ������� = null;
        ����2012.��������.���������.���������.�������.��������� ��������� = ��������������(numOfTransaction);
        String ������ = transactions.get(numOfTransaction)[11];
        String ��������� = transactions.get(numOfTransaction)[12];
        String ��������� = transactions.get(numOfTransaction)[13];
        String �������� = transactions.get(numOfTransaction)[14];
        String ����������� = transactions.get(numOfTransaction)[15];
        String ��������� = transactions.get(numOfTransaction)[16];
        String ������������ = transactions.get(numOfTransaction)[17];
        String ��������� = transactions.get(numOfTransaction)[18];
        String ������������ = transactions.get(numOfTransaction)[19];
        String ������� = transactions.get(numOfTransaction)[20];
        String ���������� = transactions.get(numOfTransaction)[21];
        if(��������� != null || ������ != null || ��������� != null || ��������� != null || �������� != null ||
                ����������� != null || ��������� != null || ������������ != null || ��������� != null ||
                ������������ != null || ������� != null || ���������� != null){
            ������� = new ����2012.��������.���������.���������.�������();
            �������.set���������(���������);
            �������.set������(������);
            �������.set���������(ServiceUtils.threeDigitCheck(���������));
            �������.set���������(ServiceUtils.threeDigitCheck(���������));
            �������.set��������(��������);
            �������.set�����������(�����������);
            �������.set���������(���������);
            �������.set������������(������������);
            �������.set���������(ServiceUtils.twoDigitCheck(���������));
            �������.set������������(������������);
            �������.set�������(������� == null ? null : new BigInteger(�������));
            �������.set����������(����������);
        }
        return �������;
    }

    private ����2012.��������.���������.���������.����������.���10514 ���10514�����(Integer numOfTransaction){
        ����2012.��������.���������.���������.����������.���10514 ���10514 = null;
        String ���121 = transactions.get(numOfTransaction)[2];
        String ���122 = transactions.get(numOfTransaction)[3];
        String ���123 = transactions.get(numOfTransaction)[4];
        String ���124 = transactions.get(numOfTransaction)[5];
        if(���121 != null || ���122 != null || ���123 != null || ���124 != null){
            ���10514 = new ����2012.��������.���������.���������.����������.���10514();
            ���10514.set���121(���121);
            ���10514.set���122(���122);
            ���10514.set���123(���123);
            ���10514.set���124(���124);
        }
        return ���10514;
    }

    private ����2012.��������.���������.���������.����������.�����10514 �����10514�����(Integer numOfTransaction){
        ����2012.��������.���������.���������.����������.�����10514 �����10514 = null;
        String ���131 = transactions.get(numOfTransaction)[6];
        String ���132 = transactions.get(numOfTransaction)[7];
        String ���133 = transactions.get(numOfTransaction)[8];
        String ���134 = transactions.get(numOfTransaction)[9];
        String ���135 = transactions.get(numOfTransaction)[10];
        if(���131 != null || ���132 != null || ���133 != null || ���134 != null || ���135 != null){
            �����10514 = new ����2012.��������.���������.���������.����������.�����10514();
            �����10514.set���131(���131);
            �����10514.set���132(���132);
            �����10514.set���133(���133);
            �����10514.set���134(���134);
            �����10514.set���135(���135);
        }
        return �����10514;
    }

    private ����2012.��������.���������.���������.���������� ���������������(Integer numOfTransaction){
        ����2012.��������.���������.���������.���������� ���������� = null;
        ����2012.��������.���������.���������.����������.���10514 ���10514 = ���10514�����(numOfTransaction);
        ����2012.��������.���������.���������.����������.�����10514 �����10514 = �����10514�����(numOfTransaction);
        String ������� = transactions.get(numOfTransaction)[1];
        if(���10514 != null || �����10514 != null || ������� != null){
            ���������� = new ����2012.��������.���������.���������.����������();
            ����������.set���10514(���10514);
            ����������.set�����10514(�����10514);
            ����������.set�������(�������);
        }
        return ����������;
    }

    ����2012 populateClasses(){
        �������� �������� = null;
        if (taxpayer.get(63) != null || taxpayer.get(64) != null ){
            �������� = new ��������();
            ��������.set����(taxpayer.get(63));
            ��������.set����������(taxpayer.get(64));
        }
        �������� �������� = null;
        if (taxpayer.get(53) != null || taxpayer.get(54) != null || taxpayer.get(55) != null ||
                taxpayer.get(56) != null || taxpayer.get(57) != null || taxpayer.get(58) != null ||
                taxpayer.get(59) != null || taxpayer.get(60) != null || taxpayer.get(61) != null){
            �������� = new ��������();
            ��������.set������(taxpayer.get(53));
            ��������.set���������(taxpayer.get(54));
            ��������.set�����(taxpayer.get(55));
            ��������.set�����(taxpayer.get(56));
            ��������.set����������(taxpayer.get(57));
            ��������.set�����(taxpayer.get(58));
            ��������.set���(taxpayer.get(59));
            ��������.set������(taxpayer.get(60));
            ��������.set�����(taxpayer.get(61));
        }

        ���������� ���������� = null;
        if(�������� != null || taxpayer.get(51) != null){
            ���������� = new ����������();
            ����������.set�����(��������);
            ����������.set�����(taxpayer.get(51));
        }

        ����������� ����������� = null;
        if(taxpayer.get(46) != null || taxpayer.get(47) != null || taxpayer.get(48) != null || taxpayer.get(49) != null){
            ����������� = new �����������();
            �����������.set���������(taxpayer.get(46));
            �����������.set���������(taxpayer.get(47));
            �����������.set�������(taxpayer.get(48));
            �����������.set������(taxpayer.get(49));
        }

        ����2012.��������.����.����.���� ���� = null;
        if(����������� != null || ���������� != null || �������� != null || taxpayer.get(40) != null ||
                taxpayer.get(41) != null || taxpayer.get(42) != null || taxpayer.get(43) != null ||
                taxpayer.get(44) != null){
            ���� = new ����2012.��������.����.����.����();
            ����.set��������(�����������);
            ����.set�������(����������);
            ����.set�����(��������);
            ����.set��������(taxpayer.get(40));
            ����.set���������(taxpayer.get(41));
            ����.set��������(taxpayer.get(42));
            ����.set����(taxpayer.get(43));
            ����.set��������(taxpayer.get(44));
        }

        ������ ������ = null;
        if (taxpayer.get(36) != null || taxpayer.get(37) != null || taxpayer.get(38) != null){
            ������ = new ������();
            ������.set�������(taxpayer.get(36));
            ������.set���(taxpayer.get(37));
            ������.set��������(taxpayer.get(38));
        }

        ����2012.��������.����.���� ���� = null;
        if (������ != null || taxpayer.get(34) != null || ���� != null){
            ���� = new ����2012.��������.����.����();
            ����.set���(������);
            ����.set�����(taxpayer.get(34));
            ����.set����(����);
        }

        ����2012.��������.����.����.��������� ��������� = null;
        if (taxpayer.get(30) != null || taxpayer.get(31) != null || taxpayer.get(32) != null){
            ��������� = new ����2012.��������.����.����.���������();
            ���������.set���������(taxpayer.get(30));
            ���������.set�����(taxpayer.get(31));
            ���������.set���(taxpayer.get(32));
        }

        ����2012.��������.����.���� ���� = null;
        if (��������� != null || taxpayer.get(26) != null || taxpayer.get(27) != null || taxpayer.get(28) != null){
            ���� = new ����2012.��������.����.����();
            ����.set���������(���������);
            ����.set�������(taxpayer.get(26));
            ����.set�����(taxpayer.get(27));
            ����.set���(taxpayer.get(28));
        }

        ����2012.��������.���� ���� = null;
        if (���� != null || ���� != null || taxpayer.get(12) != null || taxpayer.get(13) != null ||
                taxpayer.get(14) != null || taxpayer.get(15) != null){
            ���� = new ����2012.��������.����();
            ����.set����(����);
            ����.set����(����);
            ����.set�����(taxpayer.get(12));
            ����.set�����(taxpayer.get(13));
            ����.set���(taxpayer.get(14));
            ����.setEMail(taxpayer.get(15));
        }

        ����2012.��������.���������.������ ������ = null;
        if (taxpayer.get(23) != null || taxpayer.get(24) != null){
            ������ = new ����2012.��������.���������.������();
            ������.set�������(taxpayer.get(23));
            ������.set�������(taxpayer.get(24));
        }

        ������ ������1 = null;
        if (taxpayer.get(19) != null || taxpayer.get(20) != null || taxpayer.get(21) != null){
            ������1 = new ������();
            ������1.set�������(taxpayer.get(19));
            ������1.set���(taxpayer.get(20));
            ������1.set��������(taxpayer.get(21));
        }

        ����2012.��������.��������� ��������� = null;
        if (������1 != null || ������ != null || taxpayer.get(17) != null){
            ��������� = new ����2012.��������.���������();
            ���������.set���(������1);
            ���������.set������(������);
            ���������.set������(taxpayer.get(17));
        }

        List<����2012.��������.���������.���������> ��������� = transactionsFilling();
        ����2012.��������.��������� ��������� = null;
        if(��������� != null){
            ��������� = new ����2012.��������.���������();
            ���������.set���������(���������);
        }

        ����2012.�������� �������� = null;
        if (���� != null || ��������� != null || ��������� != null || taxpayer.get(5) != null ||
                taxpayer.get(6) != null || taxpayer.get(7) != null || taxpayer.get(8) != null ||
                taxpayer.get(9) != null || taxpayer.get(10) != null){
            �������� = new ����2012.��������();
            ��������.set����(����);
            ��������.set���������(���������);
            ��������.set���������(���������);
            ��������.set���(taxpayer.get(5));
            ��������.set�������(taxpayer.get(6));
            ��������.set��������(taxpayer.get(7));
            ��������.set�����(taxpayer.get(8));
            ��������.set�������(taxpayer.get(9));
            ��������.set�������(taxpayer.get(10));
        }

        ����2012 ����2012 = null;
        if (�������� != null || taxpayer.get(1) != null || taxpayer.get(2) != null || taxpayer.get(3) != null){
            ����2012 = new ����2012();
            ����2012.set��������(��������);
            ����2012.set������(taxpayer.get(1));
            ����2012.set��������(taxpayer.get(2));
            ����2012.set��������(taxpayer.get(3));
        }

        return ����2012;
    }
}
