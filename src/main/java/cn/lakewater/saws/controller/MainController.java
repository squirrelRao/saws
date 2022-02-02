package cn.lakewater.saws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    @GetMapping(value = {"/hello",""})
    public String hello(){
        return "hello saws";
    }

    @GetMapping(value="/time")
    public Map<String,String> getTime(){
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(Calendar.getInstance().getTime());

        Map<String,String> now = new HashMap<String,String>();
        now.put("time",time);

        return now;
    }

    @GetMapping(value={"/add/{num}"})
    public Map<String,Object> add(@PathVariable String num){
        int result = (Integer.parseInt(num))+1;

        Map<String,Object> res = new HashMap<String,Object>();
        res.put(num+"+1",result);

        return res;
    }

    @GetMapping(value="/add")
    public Map<String,Object> addNum(@RequestParam("num") String num){
        int result = (Integer.parseInt(num))+1;

        Map<String,Object> res = new HashMap<String,Object>();
        res.put(num+"+1",result);

        return res;
    }
}
