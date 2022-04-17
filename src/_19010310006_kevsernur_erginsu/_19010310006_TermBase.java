
package _19010310006_kevsernur_erginsu;

import static java.lang.Math.pow;
import java.util.ArrayList;

public abstract class _19010310006_TermBase {

    protected char symbol;
    protected char transaction;
    protected char letter;

    protected void print_mType(ArrayList<Integer> trues, ArrayList<String> vars, int[][] varTable) {
        int counter = 0;
        for (int val : trues) {
            counter++;
            int sum = calculatePower(vars, varTable, val);

            System.out.print(letter + "" + sum);
            if (counter < trues.size()) {
                System.out.print(" " + transaction + " ");
            }
        }
    }

    protected void print_symbolType(ArrayList<Integer> trues, ArrayList<String> vars, int[][] varTable) {
        int counter = 0;
        System.out.print(symbol + "(");
        for (int val : trues) {
            counter++;
           
            int sum = calculatePower(vars, varTable, val);

            System.out.print(sum);
            if (counter < trues.size()) {
                System.out.print(", ");
            }
        }
        System.out.print(")");
    }

    private int calculatePower(ArrayList<String> vars, int[][] varTable, int val) {
        int sum = 0;
        int j = 0;
        for (int i = vars.size() - 1; i > -1; i--) {
            
            if (varTable[val][i] == 1) {
                sum += pow(2, j);
            }
            j++;
        }
        return sum;
    }

    protected abstract void print_varType(ArrayList<Integer> trues, ArrayList<String> vars, int[][] varTable);
}
