package cn.dataguru.dianshang.service;


import cn.dataguru.dianshang.entity.ProductTotal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "youfands-redis")
public interface RedisService {

    /**
     * 设置Str缓存
     * @param key
     * @param val
     * @return
     */
    @RequestMapping(value = "redis/setStr")
    public String setStr(@RequestParam(value = "key") String key, @RequestParam(value = "val") String val);

    /**
     * 根据key查询Str缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "redis/getStr")
    public String getStr(@RequestParam(value = "key") String key);


    /**
     * @param key
     * @return
     */
    @RequestMapping(value = "redis/delStr")
    public String delStr(@RequestParam(value = "key") String key);


    /**
     * 设置obj缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "redis/setObj")
    public String setObj(@RequestParam(value = "key") String key, @RequestBody ProductTotal productTotal);

    /**
     * 获取obj缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "redis/getObj")
    public Object getObj(@RequestParam(value = "key") String key);


    /**
     * 删除obj缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "redis/delObj")
    public Object delObj(@RequestParam(value = "key") String key);

    @RequestMapping(value = "redis/setkeybypire")
    public  void setkeybypire(@RequestParam(value = "key")String key,@RequestParam(value = "seconds")long seconds);

    @RequestMapping(value = "redis/pushkeyvalue")
    public void pushkeyvalue(@RequestParam(value = "key")String key ,@RequestParam(value = "value")String value);

    @RequestMapping(value = "redis/rangekeyvalue")
    public List<String> rangekeyvalue(@RequestParam(value = "key") String key );

}
