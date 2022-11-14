package com.company.NginxTest;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
/*加权轮询法*/
public class Nginx1 {
        //    1.map, key-ip,value-weight
        static Map<String,Integer> ipMap=new HashMap<>();
        static {
            ipMap.put("192.168.13.1",1);
            /*权重为2*/
            ipMap.put("192.168.13.2",2);
            /*权重为4*/
            ipMap.put("192.168.13.3",4);

        }
        Integer pos=0;
        public int WeightRobin(int a){
            return 1;
        }
        public String WeightRobin(){
            Map<String,Integer> ipServerMap=new ConcurrentHashMap<>();
            ipServerMap.putAll(ipMap);

            Set<String> ipSet=ipServerMap.keySet();
            Iterator<String> ipIterator=ipSet.iterator();

            //定义一个list放所有server
            ArrayList<String> ipArrayList=new ArrayList<String>();

            //循环set，根据set中的可以去得知map中的value，给list中添加对应数字的server数量
            while (ipIterator.hasNext()){
                String serverName=ipIterator.next();
                Integer weight=ipServerMap.get(serverName);
                for (int i = 0;i < weight ;i++){
                    ipArrayList.add(serverName);
                }
            }
            String serverName=null;
            if (pos>=ipArrayList.size()){
                pos=0;
            }
            serverName=ipArrayList.get(pos);
            //轮询+1
            pos ++;

            return  serverName;
        }

    /*ip——hash算法*/
     static class ipHash {
        //    1.定义map, key-ip,value-weight
        static Map<String,Integer> ipMap=new HashMap<>();
        static {
            ipMap.put("192.168.13.1",1);
            ipMap.put("192.168.13.2",2);
            ipMap.put("192.168.13.3",4);
        }
        public String ipHash(String clientIP){
            Map<String,Integer> ipServerMap=new ConcurrentHashMap<>();
            ipServerMap.putAll(ipMap);

            //    2.取出来key,放到set中
            Set<String> ipset=ipServerMap.keySet();

            //    3.set放到list，要循环list取出
            ArrayList<String> iplist=new ArrayList<String>();
            iplist.addAll(ipset);

            //对ip的hashcode值取余数，每次都一样的
            int hashCode=clientIP.hashCode();
            int serverListsize=iplist.size();
            int pos=hashCode%serverListsize;
            return iplist.get(pos);

        }
    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ipHash iphash=new ipHash();
        Class<Nginx1> clazz =  Nginx1.class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
       String str =  clazz.newInstance().WeightRobin();
        for (int i = 0; i<10 ;i++) {
            String ip = "192.168.21."+i;
            String servername = iphash.ipHash(ip);
            System.out.println(servername);
        }
    }
    }
