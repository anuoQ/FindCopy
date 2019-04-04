package top.qiaojianyong.findcopy;

import java.util.Arrays;
import java.util.List;

public class Concat {
    
    static String str =
            "','/images/**=anon')\r\n" +
                    "','/css/**=anon')\r\n" +
                    "','/libs/**=anon')\r\n" +
                    "','/login.html=anon')\r\n" +
                    "','/sys/login=anon')\r\n" +
                    "','/kaptcha.jpg=anon')\r\n" +
                    "','/**=user')";
    
    public static void main(String[] args) {
        List<String> list = Arrays.asList(str.split("\\r\\n"));
        for (int i = 1; i <= list.size(); i++) {
            System.out.println("INSERT INTO `sys_config` (`key`,`value`) VALUE ('SHIRO_FILTER_CONFIG_" + (33 + i) + list.get(i - 1) + ";");
        }
    }
}