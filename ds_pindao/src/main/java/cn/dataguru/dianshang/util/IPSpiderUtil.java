package cn.dataguru.dianshang.util;

import cn.dataguru.dianshang.service.RedisService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class IPSpiderUtil {

    public static  boolean isPrev(HttpServletRequest request, RedisService redisService){
        String ip = IpUtil.getIpAddress(request);
        List<String> list = redisService.rangekeyvalue("ipSpider");
        boolean prev = false;
        for(String temp :list){
            if(temp.equals(ip)){
                prev = true;
                break;
            }
        }
        if(!prev){
            String value = redisService.getStr(ip);
            Long times = Long.valueOf(value);
            if (times > 100) {
                redisService.pushkeyvalue("ipSpider",ip);
            }
            times = times + 1;
            redisService.setStr(ip,times+"");
            redisService.setkeybypire(ip,5);
        }

        return prev;
    }
}
