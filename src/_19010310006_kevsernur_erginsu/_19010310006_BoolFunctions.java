package _19010310006_kevsernur_erginsu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class _19010310006_BoolFunctions {

    private final ArrayList<String> vars = new ArrayList<>();
    private final ArrayList<String> funcs = new ArrayList<>();
    private final BufferedReader br;

    private ArrayList<Integer> trues;
    int[][] varTable;
    int[][] funcTable;
    int lineSize;

    public _19010310006_BoolFunctions(FileReader f) throws IOException {
        br = new BufferedReader(f);

        readFile();

        lineSize = (int) Math.pow(2, vars.size());
        varTable = new int[lineSize][vars.size()];
        funcTable = new int[lineSize][funcs.size()];

        setMatrix();

    }

    public void print_all() {
        _19010310006_TermBase sum = new _19010310006_sumOfMinTerms();
        _19010310006_TermBase mul = new _19010310006_mulOfMaxTerms();

        for (int i = 0; i < funcs.size(); i++) {
            System.out.print(funcs.get(i) + " = ");
            getBoolsForFuncs(i, 1);

            sum.print_symbolType(trues, vars, varTable);

            System.out.print(" = ");
            sum.print_mType(trues, vars, varTable);

            System.out.print(" = ");
            sum.print_varType(trues, vars, varTable);

            System.out.println("");

            System.out.print(funcs.get(i) + " = ");

            getBoolsForFuncs(i, 0);

            mul.print_symbolType(trues, vars, varTable);

            System.out.print(" = ");
            mul.print_mType(trues, vars, varTable);

            System.out.print(" = ");
            mul.print_varType(trues, vars, varTable);
            System.out.println("");
            
            showVars(lineSize, varTable, vars);

        }
    }

    private void getBoolsForFuncs(int func, int bool) {
        trues = new ArrayList<>();
        for (int j = 0; j < lineSize; j++) {

            int valueOfFunc = funcTable[j][func];

            if (valueOfFunc == bool) {
                trues.add(j);
            }
        }
    }

    private void setMatrix() throws IOException {
        String line;
        int row = 0;
        while ((line = br.readLine()) != null) {
            boolean flag = false;
            int column = 0;
            for (int i = 0; i < line.length(); i++) {

                if (line.charAt(i) != ' ') {
                    if (line.charAt(i) == '|') {
                        flag = true;
                        column = 0;
                    } else {
                        if (flag == false) {
                            varTable[row][column] = Character.getNumericValue(line.charAt(i));
                            column++;
                        } else {
                            funcTable[row][column] = Character.getNumericValue(line.charAt(i));
                            column++;
                        }
                    }

                }
            }
            row++;
        }
    }

    private void readFile() throws IOException {
        String line;
        if ((line = br.readLine()) != null) {
            boolean flag = false;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) != ' ') {
                    if (line.charAt(i) == '|') {
                        flag = true;
                    } else {
                        if (flag == false) {
                            vars.add(String.valueOf(line.charAt(i)));
                        } else {
                            funcs.add(String.valueOf(line.charAt(i)));
                        }
                    }

                }
            }
        }
    }

    private void showVars(int lineSize, int[][] table, ArrayList<String> arr) {

        for (String var : arr) {
            System.out.print(var);
        }
        System.out.println();

        for (int i = 0; i < lineSize; i++) {
            for (int j = 0; j < arr.size(); j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }

}
