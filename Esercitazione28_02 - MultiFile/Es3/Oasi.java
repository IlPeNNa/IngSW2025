package Es3;

import java.util.ArrayList;
import java.util.List;

public class Oasi {
    public static void main(String[] args) {
        List<Animale> animali = new ArrayList<>();

        //Aggiungo animali alla lista
        animali.add(new Cane("Scooby Doo"));
        animali.add(new Cane("Pluto"));
        animali.add(new Gatto("Tom"));
        animali.add(new Gatto("Silvestro"));

        for(Animale animale : animali){
            animale.emettiVerso();
            animale.muoviti();
            System.out.println();
        }
    }
}
