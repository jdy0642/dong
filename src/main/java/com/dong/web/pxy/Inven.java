package com.dong.web.pxy;
import java.util.ArrayList;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.Data;
@Component @Data @Lazy
public class Inven<T> {
   private ArrayList<T> inven;
   
   public Inven(){inven = new ArrayList<T>();}
   
   public void add(T t) {inven.add(t);}
   public T get(int i) {return inven.get(i);}
   public ArrayList<T> get() {return inven;}
   public int size() {return inven.size();}
   public String toString() {return inven.toString();}
   public void clear() {inven.clear();}
}