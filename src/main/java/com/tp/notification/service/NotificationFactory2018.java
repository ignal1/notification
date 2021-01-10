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

    private List<����2018.��������.���������.���������> transactionsFilling(){
        List<����2018.��������.���������.���������> ��������������� = null;
        if(transactions.size() != 0){
            ��������������� = new ArrayList<>();
            for(String[] item : transactions){
                ����2018.��������.���������.��������� ��������� = new ����2018.��������.���������.���������();
                Integer numOfTransaction = Integer.parseInt(item[0]);
                ���������.set���������(��������������(numOfTransaction - 1));
                ���������.set�������(������������(numOfTransaction - 1));
                ���������.set����������(���������������(numOfTransaction - 1));
                ���������.set����������(���������������(numOfTransaction));
                ���������.set����������(���������������(numOfTransaction));
                ���������.set���������(��������������(numOfTransaction));
                ���������.set��������(BigInteger.valueOf(numOfTransaction));
                ���������.set��������������(item[1]);
                ���������������.add(���������);
            }
        }
        return ���������������;
    }

    private List<����2018.��������.���������.���������.����������> ���������������(Integer numOfTransaction){
        List<����2018.��������.���������.���������.����������> ���������������� = null;
        if(partiesOrganizations.size() != 0){
            ���������������� = new ArrayList<>();
            for(String[] item : partiesOrganizations){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    ����2018.��������.���������.���������.���������� ���������� = new ����2018.��������.���������.���������.����������();
                    ����������.set��������(item[1] == null ? null : new BigInteger(item[1]));
                    ����������.set������������(item[2]);
                    ����������.set�����(item[3]);
                    ����������. set����(ServiceUtils.threeDigitCheck(item[4]));
                    ����������.set����������(item[5]);
                    ����������.set����������(item[6]);
                    ����������.set�����(item[7]);
                    ����������.set���(item[8]);
                    ����������.set��������(item[9]);
                    ����������.set��������(item[10]);
                    ����������.set����������(item[11]);
                    ����������������.add(����������);
                }
            }
        }
        return ����������������;
    }

    private ������ �����������(int index){
        ������ ������ = null;
        String ������� = partiesPersons.get(index)[4];
        String ��� = partiesPersons.get(index)[5];
        String �������� = partiesPersons.get(index)[6];
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
        String ��������� = partiesPersons.get(index)[12];
        String ��������� = partiesPersons.get(index)[13];
        String ������� = partiesPersons.get(index)[14];
        String ������ = partiesPersons.get(index)[15];
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
        String ���� = partiesPersons.get(index)[16];
        String ���������� = partiesPersons.get(index)[17];
        if(���� != null || ���������� != null){
            �������� = new ��������();
            ��������.set����(����);
            ��������.set����������(����������);
        }
        return ��������;
    }

    private ����2018.��������.���������.���������.���������.���� ���������(int index){
        ����2018.��������.���������.���������.���������.���� ���� = null;
        String �������� = partiesPersons.get(index)[8];
        String ��������� = partiesPersons.get(index)[9];
        String ����� = partiesPersons.get(index)[10];
        String ���� = partiesPersons.get(index)[11];
        ����������� ����������� = ����������������(index);
        �������� �������� = �������������(index);
        if(�������� != null || ��������� != null || ����� != null || ���� != null ||
                ����������� != null || �������� != null){
            ���� = new ����2018.��������.���������.���������.���������.����();
            ����.set��������(��������);
            ����.set���������(���������);
            ����.set�����(�����);
            ����.set����(����);
            ����.set��������(�����������);
            ����.set�����(��������);
        }
        return ����;
    }

    private List<����2018.��������.���������.���������.���������> ��������������(Integer numOfTransaction){
        List<����2018.��������.���������.���������.���������> ��������������� = null;
        if(partiesPersons.size() != 0){
            ��������������� = new ArrayList<>();
            int counter = 0;
            for(String[] item : partiesPersons){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    ����2018.��������.���������.���������.��������� ��������� = new ����2018.��������.���������.���������.���������();
                    ���������.set��������(item[1] == null ? null : new BigInteger(item[1]));
                    ���������.set������������(item[2]);
                    ���������.set�����(item[3]);
                    ���������.set���(�����������(counter));
                    ���������.set�����(item[7]);
                    ���������.set����(���������(counter));
                    ���������������.add(���������);
                }
                counter++;
            }
        }
        return ���������������;
    }

    private �������� �������������(String ����, String ���������, String ����������){
        �������� �������� = null;
        if(���� != null || ��������� != null || ���������� != null){
            �������� = new ��������();
            ��������.set����(ServiceUtils.threeDigitCheck(����));
            ��������.set���������(ServiceUtils.twoDigitCheck(���������));
            ��������.set����������(����������);
        }
        return ��������;
    }

    private ����2018.��������.���������.���������.����������.��������� ��������������(int index){
        ����2018.��������.���������.���������.����������.��������� ��������� = null;
        String ���������� = subjects.get(index)[2];
        String ����� = subjects.get(index)[3];
        String ����2 = subjects.get(index)[4];
        String �����2 = subjects.get(index)[5];
        String ������� = subjects.get(index)[6];
        String ������ = subjects.get(index)[7];
        String ������� = subjects.get(index)[8];
        String ���� = subjects.get(index)[9];
        String ������������ = subjects.get(index)[10];
        String ���� = subjects.get(index)[11];
        String ���������� = subjects.get(index)[12];
        String �������� = subjects.get(index)[13];
        String �������� = subjects.get(index)[14];
        String �������� = subjects.get(index)[15];
        String ��������� = subjects.get(index)[16];
        String ��������� = subjects.get(index)[17];
        String ����1 = subjects.get(index)[18];
        String ���������1 = subjects.get(index)[19];
        String ����������1 = subjects.get(index)[20];
        �������� ����������� = �������������(����1, ���������1, ����������1);
        String ����2 = subjects.get(index)[18];
        String ���������2 = subjects.get(index)[19];
        String ����������2 = subjects.get(index)[20];
        �������� ��������� = �������������(����2, ���������2, ����������2);
        if(���������� != null || ����� != null || ����2 != null || �����2 != null
                || ������� != null || ������ != null || ������� != null || ���� != null
                || ������������ != null || ���� != null || ���������� != null || �������� != null
                || �������� != null || �������� != null || ��������� != null || ��������� != null
                || ����������� != null || ��������� != null){
            ��������� = new ����2018.��������.���������.���������.����������.���������();
            ���������.set����������(����������);
            ���������.set�����(�����);
            ���������.set����2(����2);
            ���������.set�����2(�����2);
            ���������.set�������(������� == null ? null : new BigInteger(�������));
            ���������.set������(������);
            ���������.set�������(�������);
            ���������.set����(ServiceUtils.threeDigitCheck(����));
            ���������.set������������(������������);
            ���������.set����(ServiceUtils.threeDigitCheck(����));
            ���������.set����������(���������� == null ? null : new BigDecimal(����������));
            ���������.set��������(�������� == null ? null : new BigDecimal(��������));
            ���������.set��������(ServiceUtils.threeDigitCheck(��������));
            ���������.set��������(�������� == null ? null : new BigDecimal(��������));
            ���������.set���������(��������� == null ? null : new BigInteger(���������));
            ���������.set���������(���������);
            ���������.set�����������(�����������);
            ���������.set���������(���������);
        }
        return ���������;
    }

    private List<����2018.��������.���������.���������.����������> ���������������(Integer numOfTransaction){
        List<����2018.��������.���������.���������.����������> ���������������� = null;
        if(subjects.size() != 0){
            ���������������� = new ArrayList<>();
            Map<String, ����2018.��������.���������.���������.����������> map = new HashMap<>();
            int counter = 0;
            for(String[] item : subjects){
                if(Integer.parseInt(item[0]) == numOfTransaction){
                    if(!map.containsKey(item[1])){
                        ����2018.��������.���������.���������.���������� ���������� = new ����2018.��������.���������.���������.����������();
                        ����������.set���������(item[1]);
                        List<����2018.��������.���������.���������.����������.���������> ��������������� = new ArrayList<>();
                        ���������������.add(��������������(counter));
                        ����������.set���������(���������������);
                        map.put(item[1], ����������);
                    }
                    else{
                        ����2018.��������.���������.���������.���������� ���������� = map.get(item[1]);
                        ����������.get���������().add(��������������(counter));
                    }
                }
                counter++;
            }
            for(Map.Entry<String, ����2018.��������.���������.���������.����������> item : map.entrySet()){
                ����������������.add(item.getValue());
            }
            String numOfTransactionString = numOfTransaction.toString();
            subjects = subjects.stream().filter(p -> !p[0].equals(numOfTransactionString)).collect(Collectors.toList());
        }
        return ����������������;
    }

    private ����2018.��������.���������.���������.��������� ��������������(Integer numOfTransaction){
        ����2018.��������.���������.���������.��������� ��������� = null;
        String �������� = transactions.get(numOfTransaction)[37];
        String ����������� = transactions.get(numOfTransaction)[38];
        String ��������� = transactions.get(numOfTransaction)[39];
        String ������������ = transactions.get(numOfTransaction)[40];
        if(�������� != null || ����������� != null || ��������� != null || ������������ != null){
            ��������� = new ����2018.��������.���������.���������.���������();
            ���������.set��������(�������� == null ? null : new BigInteger(��������));
            ���������.set�����������(����������� == null ? null : new BigInteger(�����������));
            ���������.set���������(��������� == null ? null : new BigInteger(���������));
            ���������.set������������(������������ == null ? null : new BigInteger(������������));
        }
        return ���������;
    }

    private ����2018.��������.���������.���������.�������.��������� ��������������(Integer numOfTransaction){
        ����2018.��������.���������.���������.�������.��������� ��������� = null;
        String ���251 = transactions.get(numOfTransaction)[28];
        String ���252 = transactions.get(numOfTransaction)[29];
        String ���253 = transactions.get(numOfTransaction)[30];
        String ���254 = transactions.get(numOfTransaction)[31];
        String ���255 = transactions.get(numOfTransaction)[32];
        String ���256 = transactions.get(numOfTransaction)[33];
        String ���257 = transactions.get(numOfTransaction)[34];
        String ���258 = transactions.get(numOfTransaction)[35];
        String ���259 = transactions.get(numOfTransaction)[36];
        if(���251 != null || ���252 != null || ���253 != null || ���254 != null || ���255 != null ||
                ���256 != null || ���257 != null || ���258 != null || ���259 != null){
            ��������� = new ����2018.��������.���������.���������.�������.���������();
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

    private ����2018.��������.���������.���������.������� ������������(Integer numOfTransaction){
        ����2018.��������.���������.���������.������� ������� = null;
        ����2018.��������.���������.���������.�������.��������� ��������� = ��������������(numOfTransaction);
        String ������ = transactions.get(numOfTransaction)[17];
        String ��������� = transactions.get(numOfTransaction)[18];
        String ��������� = transactions.get(numOfTransaction)[19];
        String �������� = transactions.get(numOfTransaction)[20];
        String ����������� = transactions.get(numOfTransaction)[21];
        String ��������� = transactions.get(numOfTransaction)[22];
        String ������������ = transactions.get(numOfTransaction)[23];
        String ��������� = transactions.get(numOfTransaction)[24];
        String ������������ = transactions.get(numOfTransaction)[25];
        String ������� = transactions.get(numOfTransaction)[26];
        String ���������� = transactions.get(numOfTransaction)[27];
        if(��������� != null || ������ != null || ��������� != null || ��������� != null || �������� != null ||
                ����������� != null || ��������� != null || ������������ != null || ��������� != null ||
                ������������ != null || ������� != null || ���������� != null){
            ������� = new ����2018.��������.���������.���������.�������();
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

    private ����2018.��������.���������.���������.����������.���10514 ���10514�����(Integer numOfTransaction){
        ����2018.��������.���������.���������.����������.���10514 ���10514 = null;
        String ���121 = transactions.get(numOfTransaction)[3];
        String ���122 = transactions.get(numOfTransaction)[4];
        String ���123 = transactions.get(numOfTransaction)[5];
        String ���124 = transactions.get(numOfTransaction)[6];
        if(���121 != null || ���122 != null || ���123 != null || ���124 != null){
            ���10514 = new ����2018.��������.���������.���������.����������.���10514();
            ���10514.set���121(���121);
            ���10514.set���122(���122);
            ���10514.set���123(���123);
            ���10514.set���124(���124);
        }
        return ���10514;
    }

    private ����2018.��������.���������.���������.����������.�����10514 �����10514�����(Integer numOfTransaction){
        ����2018.��������.���������.���������.����������.�����10514 �����10514 = null;
        String ���131 = transactions.get(numOfTransaction)[7];
        String ���132 = transactions.get(numOfTransaction)[8];
        String ���133 = transactions.get(numOfTransaction)[9];
        String ���134 = transactions.get(numOfTransaction)[10];
        String ���135 = transactions.get(numOfTransaction)[11];
        String ���136 = transactions.get(numOfTransaction)[12];
        String ���137 = transactions.get(numOfTransaction)[13];
        String ���138 = transactions.get(numOfTransaction)[14];
        String ���139 = transactions.get(numOfTransaction)[15];
        String ���140 = transactions.get(numOfTransaction)[16];
        if(���131 != null || ���132 != null || ���133 != null || ���134 != null
                || ���135 != null || ���136 != null || ���137 != null || ���138 != null
                || ���139 != null || ���140 != null){
            �����10514 = new ����2018.��������.���������.���������.����������.�����10514();
            �����10514.set���131(���131);
            �����10514.set���132(���132);
            �����10514.set���133(���133);
            �����10514.set���134(���134);
            �����10514.set���135(���135);
            �����10514.set���136(���136);
            �����10514.set���137(���137);
            �����10514.set���138(���138);
            �����10514.set���139(���139);
            �����10514.set���140(���140);
        }
        return �����10514;
    }

    private ����2018.��������.���������.���������.���������� ���������������(Integer numOfTransaction){
        ����2018.��������.���������.���������.���������� ���������� = null;
        ����2018.��������.���������.���������.����������.���10514 ���10514 = ���10514�����(numOfTransaction);
        ����2018.��������.���������.���������.����������.�����10514 �����10514 = �����10514�����(numOfTransaction);
        String ������� = transactions.get(numOfTransaction)[2];
        if(���10514 != null || �����10514 != null || ������� != null){
            ���������� = new ����2018.��������.���������.���������.����������();
            ����������.set���10514(���10514);
            ����������.set�����10514(�����10514);
            ����������.set�������(�������);
        }
        return ����������;
    }


    ����2018 populateClasses(){

        �������� �������� = null;
        if (taxpayer.get(54) != null || taxpayer.get(55) != null ){
            �������� = new ��������();
            ��������.set����(taxpayer.get(54));
            ��������.set����������(taxpayer.get(55));
        }

        ����������� ����������� = null;
        if(taxpayer.get(49) != null || taxpayer.get(50) != null || taxpayer.get(51) != null || taxpayer.get(52) != null){
            ����������� = new �����������();
            �����������.set���������(taxpayer.get(49));
            �����������.set���������(taxpayer.get(50));
            �����������.set�������(taxpayer.get(51));
            �����������.set������(taxpayer.get(52));
        }

        ����2018.��������.����.����.���� ���� = null;
        if(����������� != null || �������� != null || taxpayer.get(43) != null
                || taxpayer.get(44) != null || taxpayer.get(45) != null
                || taxpayer.get(46) != null || taxpayer.get(47) != null){
            ���� = new ����2018.��������.����.����.����();
            ����.set��������(�����������);
            ����.set�����(��������);
            ����.set��������(taxpayer.get(43));
            ����.set���������(taxpayer.get(44));
            ����.set�����(taxpayer.get(45));
            ����.set����(taxpayer.get(46));
            ����.set��������(taxpayer.get(47));
        }

        ������ ������ = null;
        if (taxpayer.get(39) != null || taxpayer.get(40) != null
                || taxpayer.get(41) != null){
            ������ = new ������();
            ������.set�������(taxpayer.get(39));
            ������.set���(taxpayer.get(40));
            ������.set��������(taxpayer.get(41));
        }

        ����2018.��������.����.���� ���� = null;
        if (������ != null || taxpayer.get(37) != null || ���� != null){
            ���� = new ����2018.��������.����.����();
            ����.set���(������);
            ����.set�����(taxpayer.get(37));
            ����.set����(����);
        }

        ����2018.��������.����.����.��������� ��������� = null;
        if (taxpayer.get(33) != null || taxpayer.get(34) != null
                || taxpayer.get(35) != null){
            ��������� = new ����2018.��������.����.����.���������();
            ���������.set���������(taxpayer.get(33));
            ���������.set�����(taxpayer.get(34));
            ���������.set���(taxpayer.get(35));
        }

        ����2018.��������.����.���� ���� = null;
        if (��������� != null || taxpayer.get(29) != null
                || taxpayer.get(30) != null || taxpayer.get(31) != null){
            ���� = new ����2018.��������.����.����();
            ����.set���������(���������);
            ����.set�������(taxpayer.get(29));
            ����.set�����(taxpayer.get(30));
            ����.set���(taxpayer.get(31));
        }

        ����2018.��������.���� ���� = null;
        if (���� != null || ���� != null || taxpayer.get(16) != null
                || taxpayer.get(17) != null || taxpayer.get(18) != null){
            ���� = new ����2018.��������.����();
            ����.set����(����);
            ����.set����(����);
            ����.set�����(taxpayer.get(16));
            ����.set���(taxpayer.get(17));
            ����.setEMail(taxpayer.get(18));
        }

        ����2018.��������.���������.������ ������ = null;
        if (taxpayer.get(26) != null || taxpayer.get(27) != null){
            ������ = new ����2018.��������.���������.������();
            ������.set�������(taxpayer.get(26));
            ������.set�������(taxpayer.get(27));
        }

        ������ ������1 = null;
        if (taxpayer.get(22) != null || taxpayer.get(23) != null || taxpayer.get(24) != null){
            ������1 = new ������();
            ������1.set�������(taxpayer.get(22));
            ������1.set���(taxpayer.get(23));
            ������1.set��������(taxpayer.get(24));
        }

        ����2018.��������.��������� ��������� = null;
        if (������1 != null || ������ != null || taxpayer.get(20) != null){
            ��������� = new ����2018.��������.���������();
            ���������.set���(������1);
            ���������.set������(������);
            ���������.set������(taxpayer.get(20));
        }

        List<����2018.��������.���������.���������> ��������� = transactionsFilling();
        ����2018.��������.��������� ��������� = null;
        if(��������� != null){
            ��������� = new ����2018.��������.���������();
            ���������.set���������(���������);
        }

        ����2018.�������� �������� = null;
        if (���� != null || ��������� != null || ��������� != null || taxpayer.get(9) != null ||
                taxpayer.get(10) != null || taxpayer.get(11) != null || taxpayer.get(12) != null ||
                taxpayer.get(13) != null || taxpayer.get(14) != null){
            �������� = new ����2018.��������();
            ��������.set����(����);
            ��������.set���������(���������);
            ��������.set���������(���������);
            ��������.set���(taxpayer.get(9));
            ��������.set�������(taxpayer.get(10));
            ��������.set��������(taxpayer.get(11));
            ��������.set�����(taxpayer.get(12));
            ��������.set�������(taxpayer.get(13));
            ��������.set�������(taxpayer.get(14));
        }

        ����2018 ����2018 = null;
        if (�������� != null || taxpayer.get(1) != null || taxpayer.get(2) != null
                || taxpayer.get(3) != null || taxpayer.get(4) != null || taxpayer.get(5) != null
                || taxpayer.get(6) != null || taxpayer.get(7) != null){
            ����2018 = new ����2018();
            ����2018.set��������(��������);
            ����2018.set������(taxpayer.get(1));
            ����2018.set��������(taxpayer.get(2));
            ����2018.set��������(taxpayer.get(3));
            ����2018.set���������(taxpayer.get(4));
            ����2018.set����������(taxpayer.get(5));
            ����2018.set�������(taxpayer.get(6));
            ����2018.set�������(taxpayer.get(7));
        }
        return ����2018;
    }
}

