import java.util.*;
import java.lang.String;

public class Polinom   {

    List<Monom> polinom=new ArrayList<Monom>();
    public Polinom(List<Monom> monom) {
        this.polinom = monom;
    }
    public Polinom() { }
    public List<Monom> getPolinom() {
        return polinom;
    }

    public void setPolinom(List<Monom> monom) {
        this.polinom = monom;
    }

    public  void citire(String p) {
        Monom w=new Monom();
        Monom n = null;
        String b[]=null;
        p = p.replace("-", "+-");
        String a[] = p.split("\\+");
        if (a[0]=="") {
            for (int i=0;i<a.length-1;i++){
                a[i]=a[i+1];
            }
            b= Arrays.copyOf(a,a.length-1);
        }
        if (a[0].substring(0,1)=="+-") {
            a[0]=a[0].replace("+-","-");
        }
        if (b!=null) {
            for (int i = 0; i < b.length; i++) {
                n = w.citireMonom(b[i]);
                polinom.add(n);
            }
        }
        else{
            for (int i = 0; i < a.length; i++) {
                n = w.citireMonom(a[i]);
                polinom.add(n);
            }
        }
        this.setPolinom(polinom);
    }

    Monom getMonomMax(){
        return polinom.get(0);
    }
    @Override
    public String toString() {
       String p="";
       if (polinom.isEmpty()){
           return "0";
       }
       else{
           for(Monom m:this.polinom){
               if(m.getCoef()>0 && m.getGrad()>=2){
                   p=p+"+"+m.getCoef()+"x^"+m.getGrad();
               }
               else if(m.getCoef()>0 && m.getGrad()==1){
                   p=p+"+"+m.getCoef()+"x";
               }
               else if(m.getCoef()>0 && m.getGrad()==0){
                   p=p+"+"+m.getCoef();
               }
               else if(m.getCoef()<0 && m.getGrad()>=2){
                   p=p+m.getCoef()+"x^"+m.getGrad();
               }
               else if(m.getCoef()<0 && m.getGrad()==1){
                   p=p+m.getCoef()+"x";
               }
               else if(m.getCoef()<0 && m.getGrad()==0){
                   p=p+String.valueOf(m.getCoef());
               }
           }

       }
       if (p.charAt(0)=='+')
        p=p.substring(1,p.length());
       if (p.charAt(0)=='-')
           p=p.substring(0,p.length());
        return p;
    }



}
