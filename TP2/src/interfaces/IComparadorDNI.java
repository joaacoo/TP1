package interfaces;

import modelo.Persona;
import java.util.Comparator;

public class IComparadorDNI implements Comparator<Persona> {

    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getDni().compareTo(p2.getDni());
    }
}
