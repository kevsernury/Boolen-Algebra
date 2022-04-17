package _19010310006_kevsernur_erginsu;

import java.util.ArrayList;

public class _19010310006_mulOfMaxTerms extends _19010310006_TermBase {

    private char symbol = '∏';
    private char transaction = '.';
    private char letter = 'M';

    public _19010310006_mulOfMaxTerms() {
        super.symbol = this.symbol;
        super.letter = this.letter;
        super.transaction = this.transaction;
    }

    @Override
    protected void print_varType(ArrayList<Integer> trues, ArrayList<String> vars, int[][] varTable) {
        int counter = 0;

        for (int val : trues) {
            System.out.print("(");
            counter++;
            for (int j = 0; j < vars.size(); j++) {
                int var = varTable[val][j];
                System.out.print(vars.get(j));
                if (var == 1) {
                    System.out.print("'");
                }
                if (j < vars.size() - 1) {
                    System.out.print("+");
                }

            }
            System.out.print(")");
            if (counter < trues.size()) {
                System.out.print(" . ");
            }

        }
    }

}
