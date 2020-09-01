package cn.dataguru.dianshang.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpiderPreUtil {

    public static boolean valiRefer(HttpServletRequest request){
        boolean result = false;
        String referer = request.getHeader("Referer");
        if(StringUtils.isNotBlank(referer)){
            result = referer.contains("productlist/indexproduct");
        }
        return result;
    }

    public  static void setCookies(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        boolean hasfenduan1 = false;
        boolean hasfenduan2 = false;
        boolean hasfenduan3 = false;
        if(cookies != null){
            for(Cookie cookie:cookies){
                String key = cookie.getName();
                String value = cookie.getValue();
                if("fenduan1".equals(key)){
                    hasfenduan1 = true;
                }
                if("fenduan2".equals(key)){
                    hasfenduan2 = true;
                }
                if("fenduan3".equals(key)){
                    hasfenduan3 = true;
                }
            }
        }
        if(!hasfenduan1){
            Cookie cookie1 = new Cookie("fenduan1","value1");
            response.addCookie(cookie1);
        }
        if(!hasfenduan2){
            Cookie cookie2 = new Cookie("fenduan2","value2");
            response.addCookie(cookie2);
        }
        if(!hasfenduan3){
            Cookie cookie3 = new Cookie("fenduan3","value3");
            response.addCookie(cookie3);
        }
    }

    public static boolean valiCookie(HttpServletRequest request, HttpServletResponse response){
        boolean result = false;
        Cookie[] cookies = request.getCookies();
        boolean hasfenduan1 = false;
        boolean hasfenduan2 = false;
        boolean hasfenduan3 = false;
        if(cookies != null){
            for(Cookie cookie:cookies){
                String key = cookie.getName();
                String value = cookie.getValue();
                if("fenduan1".equals(key)&&"value1".equals(value)){
                    hasfenduan1 = true;
                }
                if("fenduan2".equals(key)&&"value2".equals(value)){
                    hasfenduan2 = true;
                }
                if("fenduan3".equals(key)&&"value3".equals(value)){
                    hasfenduan3 = true;
                }
            }
        }
        if(hasfenduan1&&hasfenduan2&&hasfenduan3){
            result = true;
        }
        return result;
    }


}
