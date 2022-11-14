package com.untils.myComponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName RequestParamUtil
 * @Description 请求参数处理
 * @Author 王群勇
 * @Date 2021/9/13 16:32
 * @Version 1.0
 */
public class RequestParamUtil {
    /**
     * @Author: 王群勇
     * @Description: 获取参数
     * @Date: 2020/11/28 11:33
     * @param request
     * @Return :
     **/
//    public static Map<String, String> requestToMap(HttpServletRequest request) {
//        Map<String, String[]> map2 = request.getParameterMap();
//        HashMap<String, String> map = new HashMap<>();
//        for (Map.Entry<String, String[]> entry : map2.entrySet()) {
//            map.put(entry.getKey(), entry.getValue()[0]);
//        }
//        return map;
//    }
    /**
     *@MethodName buildRequestParamMap
     *@Author 王群勇
     *@Description 将JSON参数转成Map对象
     *@Date 2020/11/16 17:39
     *@param request request
     *@return Map<String,Object>
     **/
//    public static Map<String, Object> buildRequestParamMap(HttpServletRequest request) throws IOException {
//        Map<String, Object> requestParamMap = new HashMap<>();
//        try {
//            BufferedReader br = request.getReader();
//            String str, wholeStr = "";
//            while ((str = br.readLine()) != null) {
//                wholeStr += str;
//            }
//            br.close();
//            JSONObject jsonObject = JSONObject.parseObject(wholeStr);
//            if (null != jsonObject) {
//                Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
//                if (!entries.isEmpty()) {
//                    for (Map.Entry<String, Object> entry : entries) {
//                        requestParamMap.put(entry.getKey(), entry.getValue());
//                    }
//                }
//            } else {
//                System.err.println("入参为空...");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return requestParamMap;
//    }
}
