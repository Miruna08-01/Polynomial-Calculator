import java.util.Comparator;

public class Monom implements Comparable<Monom> {
    private int grad;
    private double coef;

    public Monom( double coef,int grad)
    {
        this.grad=grad;
        this.coef=coef;
    }
    public Monom( )
    {

    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public  Monom citireMonom(String m) //3x^2 // x^2
    {
        int grad=0;
        double coef=0;
        int poz=m.indexOf("x");
        if (poz==1 && m.charAt(0)=='-' && m.length()<=2) //-x
            {
            coef=-1;
            grad=1;}
        if (poz!=-1 && poz!=0 && m.charAt(0)!='-') {  //3x^2
            if (m.length()>2 ) {
                String aux1 = m.substring(0, poz);
                String aux2 = m.substring(poz);
                coef = Double.parseDouble(aux1);
                if (aux2.equals("x")){
                    aux2="1";
                    grad = Integer.parseInt(aux2);}
                else{
                String aux3 = aux2.substring(2);
                grad = Integer.parseInt(aux3);}}
            else //2x
            {
                grad=1;
                String aux5=m.substring(0,poz);
                coef=Double.parseDouble(aux5);}}
    if(m.charAt(0)=='-' && poz>=2 &&  3>=m.length()){ //-2x
        grad=1;
        coef=Double.parseDouble(String.valueOf(m.substring(0,poz)));}
        if (poz!=-1 && poz!=0 && poz>=3 && m.charAt(0)=='-' && m.length()>2) {  //-6x^2
            if (m.length()>2 ) {
                String aux1 = m.substring(0, poz);
                String aux2 = m.substring(poz);
                coef = Double.parseDouble(aux1);
                if (aux2.equals("x")){
                    aux2="1";
                    grad = Integer.parseInt(aux2);}
                else{
                    String aux3 = aux2.substring(2);
                    grad = Integer.parseInt(aux3);}}
            else //2x
            {
                grad=1;
                String aux5=m.substring(0,poz);
                coef=Double.parseDouble(aux5);}}
        if (poz==0){  //x^2
            coef=1;
            if (m.length()==1){
                grad=1;
            }else{
            String aux4=m.substring(2, m.length());
            grad=Integer.parseInt(aux4);}}
        if (poz==-1){ //2
            grad=0;
            coef=Double.parseDouble(m);}
        return new Monom(coef,grad);}


    @Override
        public int compareTo(Monom o1) {
            if (o1.getGrad()>this.getGrad())
                return 1;
            else if(o1.getGrad()==this.getGrad())
                return 0;
            else
                return -1;

        }
    }

