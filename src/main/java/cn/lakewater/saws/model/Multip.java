package cn.lakewater.saws.model;

import org.springframework.context.annotation.Bean;

public class Multip {

    private Number a;
    private Number b;

    public Number getResult(){

        return a.doubleValue() * b.doubleValue();

    }

    public Number getA() {
        return a;
    }

    public void setA(Number a) {
        this.a = a;
    }

    public Number getB() {
        return b;
    }

    public void setB(Number b) {
        this.b = b;
    }
}
