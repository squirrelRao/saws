package cn.lakewater.saws.controller;
import cn.lakewater.saws.model.Multip;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/mul")
    public Map<String,Object> mul(@RequestBody String params){

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Multip multip = gson.fromJson(params,Multip.class);
        Map<String,Object> res = new HashMap<>();

        res.put("a",multip.getA());
        res.put("b",multip.getB());
        res.put("a * b",multip.getResult());
        return res;
    }

}
