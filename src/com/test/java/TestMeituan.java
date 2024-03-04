package com.test.java;

import java.util.ArrayList;

public class TestMeituan {

    public static void main(String[] args) {
        CP cp1 = new CP("test1", 10, 101);
        CP cp2 = new CP("test2", 20, 101);
        CP cp3 = new CP("test3", 30, 102);
        ArrayList cpList = new ArrayList<CP>();
        cpList.add(cp1);
        cpList.add(cp2);
        cpList.add(cp3);

        Youhui youhui1 = new Youhui(101, 2);
        Youhui youhui2 = new Youhui(102, 3);
        ArrayList youhuiList = new ArrayList<Youhui>();
        youhuiList.add(youhui1);
        youhuiList.add(youhui2);

        float discount = 0.5f;

        System.out.println(count(cpList, youhuiList, discount));
    }

    static class CP {
        String name;
        float price;
        int youhuiId;// 101, 102

        public CP(String name, float price, int youhuiId){
            this.name = name;
            this.price = price;
            this.youhuiId = youhuiId;
        }
    }

    static class Youhui {
        int id;
        int discount;

        public Youhui(int id, int discount){
            this.id = id;
            this.discount = discount;
        }
    }

    public static float count(ArrayList<CP> cpList, ArrayList<Youhui> youhuiList, float discount){
        if(cpList.isEmpty()){
            return 0;
        }

        float totleMoney = 0l;

        for(int i = 0; i < cpList.size(); i++){
            CP cp = cpList.get(i);
            totleMoney += getPriceAfterYouhui(cp, youhuiList);
        }

        return totleMoney * discount;
    }

    public static float getPriceAfterYouhui(CP cp, ArrayList<Youhui> youhuiList) {
        if(youhuiList.isEmpty()){
            return cp.price;
        }

        for(int i = 0; i < youhuiList.size(); i++){
            Youhui youhui = youhuiList.get(i);
            if(cp.youhuiId == youhui.id){
                return cp.price - youhui.discount;
            }
        }

        return cp.price;
    }

}


