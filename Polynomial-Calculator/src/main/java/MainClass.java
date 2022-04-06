import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainClass {



    public static void main(String[] args)
    {
        Operatii op=new Operatii();
        Frame fr=new Frame(op);
        Controller cr=new Controller(op,fr);
        fr.setVisible(true);

       /* Polinom c=new Polinom();
        Polinom d=new Polinom();
        c.citire("3x^2+6x+1");
        d.citire("6x+2");
        List<Polinom>res=new ArrayList<Polinom>();
        res=op.impartire(c,d);

        System.out.println(res);*/

    }
}
