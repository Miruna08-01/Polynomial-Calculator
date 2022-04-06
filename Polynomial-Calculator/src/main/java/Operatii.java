import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Operatii {



    public List<Polinom>reset(){
        Polinom c=new Polinom();
        Polinom d=new Polinom();
        List<Polinom>rez=new ArrayList<Polinom>();
        c = new Polinom();
        d= new Polinom();
        rez.add(c);rez.add(d);
        return rez;
    }

    public  Polinom adunarePolinom(Polinom p, Polinom q) {
       double coef; double grad;
       int i=0; int j=0;
        Polinom c=new Polinom();
        if(p.getPolinom().get(0).getCoef()==0 && p.getPolinom().get(0).getGrad()==0){
            c.setPolinom(q.getPolinom());
            return c;
        }
        if(q.getPolinom().get(0).getCoef()==0 && q.getPolinom().get(0).getGrad()==0){
            c.setPolinom(p.getPolinom());
            return c;
        }

       while(i<p.getPolinom().size() && j<q.getPolinom().size()) {
           if (p.getPolinom().get(i).getGrad() > q.getPolinom().get(j).getGrad()) {
               c.getPolinom().add(p.getPolinom().get(i)); i++;
           }
           if (p.getPolinom().get(i).getGrad() < q.getPolinom().get(j).getGrad()) {
               c.getPolinom().add(q.getPolinom().get(j)); j++;
           }
          else{
              coef=p.getPolinom().get(i).getCoef()+q.getPolinom().get(j).getCoef();
              if (coef!=0){
                  c.getPolinom().add(new Monom(coef,p.getPolinom().get(i).getGrad()));
              }
              i++;j++;
           }
       }
        for (; i < p.getPolinom().size(); i++) {
            c.getPolinom().add(new Monom(p.getPolinom().get(i).getCoef(),
                    p.getPolinom().get(i).getGrad()));
        }

        for (; j < q.getPolinom().size(); j++) {

            c.getPolinom().add(new Monom(q.getPolinom().get(j).getCoef(),
                    q.getPolinom().get(j).getGrad()));
        }
        Collections.sort(c.getPolinom());
        return c;
    }

	public Polinom scaderePolinom(Polinom p, Polinom q) {
        double coef=0; double grad=0;
        int i=0; int j=0;
        Polinom c=new Polinom();
        Polinom d=new Polinom();
        if(p.getPolinom().get(0).getCoef()==0 && p.getPolinom().get(0).getGrad()==0){
            for (int k=0;k<q.getPolinom().size();k++){
                q.getPolinom().get(k).setCoef((-1)*q.getPolinom().get(k).getCoef());
            }
            c.setPolinom(q.getPolinom());
            return c;
        }
        if(q.getPolinom().get(0).getCoef()==0 && q.getPolinom().get(0).getGrad()==0){
            c.setPolinom(p.getPolinom());
            return c;
        }
        for (int k=0;k<q.getPolinom().size();k++){
            q.getPolinom().get(k).setCoef((-1)*q.getPolinom().get(k).getCoef());
        }

        while(i<p.getPolinom().size() && j<q.getPolinom().size()) {
            if (p.getPolinom().get(i).getGrad() > q.getPolinom().get(j).getGrad()) {
                c.getPolinom().add(p.getPolinom().get(i)); i++;
            }
            if (p.getPolinom().get(i).getGrad() < q.getPolinom().get(j).getGrad()) {
                c.getPolinom().add(q.getPolinom().get(j)); j++;
            }
            else{
                coef=p.getPolinom().get(i).getCoef()+q.getPolinom().get(j).getCoef();
                if (coef!=0){
                    c.getPolinom().add(new Monom(coef,p.getPolinom().get(i).getGrad()));
                }
                i++;j++;
            }
        }
        for (; i < p.getPolinom().size(); i++) {
            c.getPolinom().add(new Monom(p.getPolinom().get(i).getCoef(),
                    p.getPolinom().get(i).getGrad()));
        }

        for (; j < q.getPolinom().size(); j++) {

            c.getPolinom().add(new Monom(q.getPolinom().get(j).getCoef(),
                    q.getPolinom().get(j).getGrad()));
        }
        Collections.sort(c.getPolinom());
        return c;
    }


    public Polinom inmultirePolinom(Polinom p, Polinom q) {
        Polinom c=new Polinom();
        Polinom d=new Polinom();

        for (Monom a:p.getPolinom()){
            for (Monom b:q.getPolinom()){
                c.getPolinom().add(new Monom(a.getCoef()*b.getCoef(),a.getGrad()+b.getGrad()));
            }
        }
        for(int i=0;i<c.getPolinom().size()-1;i++){
            for (int j=i+1;j<c.getPolinom().size();j++){
                if(c.getPolinom().get(i).getGrad()==c.getPolinom().get(j).getGrad()){
                    c.getPolinom().get(i).setCoef( c.getPolinom().get(i).getCoef()+ c.getPolinom().get(j).getCoef());
                    c.getPolinom().remove(j);
                }
            }
        }
        Collections.sort(c.getPolinom());
        return c;
    }

    public Polinom derivarePolinom(Polinom p) {
        Polinom c=new Polinom();
        Polinom d=new Polinom();
        for (int i=0;i<p.getPolinom().size();i++){
            c.getPolinom().add(new Monom(p.getPolinom().get(i).getCoef()*p.getPolinom().get(i).getGrad(), p.getPolinom().get(i).getGrad()-1));
        }
        Collections.sort(c.getPolinom());
        return c;
    }

    public Polinom integrarePolinom(Polinom p){
        Polinom c=new Polinom();
        Polinom d=new Polinom();
        for(int i=0;i<p.getPolinom().size();i++){
            c.getPolinom().add(new Monom((p.getPolinom().get(i).getCoef())/(p.getPolinom().get(i).getGrad()+1),p.getPolinom().get(i).getGrad()+1));
        }
        Collections.sort(c.getPolinom());
        return c;
    }

   public List<Polinom> impartire(Polinom p, Polinom q){
        List<Polinom> rez=new ArrayList<Polinom>();
        Polinom w=new Polinom();
       while(p.getPolinom().get(0).getGrad()>=q.getPolinom().get(0).getGrad()){
           Monom a=p.getMonomMax();
           Monom b=q.getMonomMax();
           Monom x=new Monom(p.getPolinom().get(0).getCoef()/q.getPolinom().get(0).getCoef(),p.getPolinom().get(0).getGrad()-q.getPolinom().get(0).getGrad());
           w.getPolinom().add(x);
           Polinom t=new Polinom();
           t.getPolinom().add(x);
           Polinom aux=this.inmultirePolinom(q,t);
           p=this.scaderePolinom(p,aux);

       }
       rez.add(w);
       rez.add(p);
       Collections.sort(rez.get(0).getPolinom());
       Collections.sort(rez.get(1).getPolinom());
        return rez;
    }



}
