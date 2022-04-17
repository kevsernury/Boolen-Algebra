package _19010310006_kevsernur_erginsu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _19010310006_Kevsernur_Erginsu {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileReader f = new FileReader("dogruluk_tablosu3.txt");

        _19010310006_BoolFunctions term = new _19010310006_BoolFunctions(f);

        term.print_all();
        

    }

}
