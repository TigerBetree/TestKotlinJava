package com.test.java;

public class JavaClass {

    // 创建ThreadLocal & 初始化
    private ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "初始化值1";
        }
    };

    private ThreadLocal<String> threadLocal2 = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "初始化值2";
        }
    };

    public static void main(String[] args) {
//        KotlinClass.Companion.doWork();
//        KotlinClass.doWork();
//
//        System.out.println(KotlinClass.INTEGER_ON);
////        System.out.println(KotlinClass.Companion.getBIG_INTEGER_ONE());
//        System.out.println(KotlinClass.BIG_INTEGER_ONE);
//
//        String str = "abcd";
//        String[] strings = str.split("");
//        System.out.println(strings.length);

//        String s = "https://m.sogou.com/web/id=f2786d1b-e8a7-410c-af1e-fc87fba66610_1/keyword=%E6%AF%9B%E6%99%93%E5%BD%A4%E8%AE%A9%E6%B1%AA%E5%B3%B0%E5%A4%9A%E5%8F%91%E6%AD%8C/sec=GEVyoqlteLXAYK3SyZ1HFw../vr=100003sp/tc?rcer=QXdGqJWydsclZeB5&dp=1&pid=sogou-clse-ddcbe25988981920-2000&mid=bca3868233039302052&is_per=0&pno=1&wml=1&url=https%3A%2F%2Fk.sina.cn%2Farticle_7270497935_1b15afe8f00101fgaq.html%3Ffrom%3Dent%26subch%3Dmusic%26http%3Dfromhttp%26vt%3D4&vrid=100003sp&clk=1&vr_subpage=type=vr_subpage||spid=100003||sptid=news||spcid=zx_zixundata||spfrom=vr70123901||spvr=70123901";
//        System.out.println(s.replace("||", "%7c%7c"));

//        JavaClass obj = new JavaClass();
//        obj.threadLocal.set("test1");
//        System.out.println(obj.threadLocal.get());
//
//        obj.threadLocal2.set("test2");
//        System.out.println(obj.threadLocal2.get());
//
//        Thread thread = Thread.currentThread();
//        System.out.println(thread.com.test.kotlin.test1.getName());

        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
        System.out.println(a.equals(b));

        String a1 = new String("abc");
        String b1 = new String("abc");
        System.out.println(a1 == b1);
        System.out.println(a1.equals(b1));
    }
}
