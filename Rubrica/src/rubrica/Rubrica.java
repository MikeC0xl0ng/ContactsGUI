package rubrica;

import java.util.HashMap;

public class Rubrica {
    
    public static Rubrica_ r = new Rubrica_();
    public static Interface window = new Interface();
    
    public static void main(String[] args) {
        r.load();
        window.setTitle("Rubrica");
        window.setVisible(true);
    }
    
}