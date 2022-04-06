import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class TestClass extends TestCase {
    @Test
    public void testAdunare() {
        Polinom P = new Polinom();
        Polinom Q = new Polinom();
        P.citire("x^2+5x+4");
        Q.citire("x^2+1");
        Operatii op=new Operatii();
        Polinom rezultat1 = new Polinom();
        rezultat1.citire("2x^2+5x+5");
        Polinom rezultat2=op.adunarePolinom(P,Q);
        assertEquals(rezultat1.toString(), rezultat2.toString());
        System.out.println("Adunarea s-a efectuat corect");
    }
    @Test
    public void testScadere() {
        Polinom P = new Polinom();
        Polinom Q = new Polinom();
        P.citire("x^2+5x+4");
        Q.citire("x^2+1");
        Operatii op=new Operatii();
        Polinom rezultat1 = new Polinom();
        rezultat1.citire("5x+3");
        Polinom rezultat2=op.scaderePolinom(P,Q);
        assertEquals(rezultat1.toString(), rezultat2.toString());
        System.out.println("Scaderea s-a efectuat corect");
    }
 @Test
    public void testInmulitire() {
        Polinom P = new Polinom();
        Polinom Q = new Polinom();
        P.citire("x^2+5x+4");
        Q.citire("x^2+1");
        Operatii op=new Operatii();
        Polinom rezultat1 = new Polinom();
        rezultat1.citire("x^4+5x^3+5x^2+5x+4");
        Polinom rezultat2=op.inmultirePolinom(P,Q);
        assertEquals(rezultat1.toString(), rezultat2.toString());
        System.out.println("Inmultirea s-a efectuat corect");
    }


    @Test
    public void testImpartire() {
        Polinom P = new Polinom();
        Polinom Q = new Polinom();
        P.citire("x^2+5x+4");
        Q.citire("x^2+1");
        Operatii op=new Operatii();
        List<Polinom> rez=op.impartire(P,Q);
        Polinom rezultat1 = new Polinom();
        rezultat1.citire("1");
        Polinom rezultat2=new Polinom();
        rezultat2.citire("5x+3");
        assertEquals(rezultat1.toString(), rez.get(0).toString());
        assertEquals(rezultat2.toString(), rez.get(1).toString());
        System.out.println("Impartirea s-a efectuat corect");
    }


    @Test
    public void testDerivare() {
        Polinom P = new Polinom();
        P.citire("x^2+1");
        Operatii op=new Operatii();
        Polinom rezultat1 = new Polinom();
        rezultat1.citire("+2x");
        Polinom rezultat2 = op.derivarePolinom(P);
        assertEquals(rezultat2.toString(), rezultat1.toString());
        System.out.println("Derivarea s-a efectuat corect");
    }

    @Test
    public void testIntegrare() {
        Polinom P = new Polinom();
        P.citire("3x^2+1");
        Operatii op=new Operatii();
        Polinom rezultat1 = new Polinom();
        rezultat1.citire("x^3+x");
        Polinom rezultat2 = op.integrarePolinom(P);
        assertEquals(rezultat2.toString(), rezultat1.toString());
        System.out.println("Integrarea s-a efectuat corect");
    }
}
