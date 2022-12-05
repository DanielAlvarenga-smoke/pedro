package codigoFonte;

import java.util.*;
import java.time.LocalDate;

public class BD {

    private static List<Conta> contas = new LinkedList<>();
    private static int id = 1;

    public static void cadastra(Conta c) {
        c.setnConta(id++);
        c.setData(LocalDate.now());
        contas.add(c);
    }

    public static void deleta(Conta c) {
        contas.remove(c);
    }

    public static List<Conta> contas() {
        return contas;
    }

    public static void transfere() {
        contas.sort((c1, c2) -> Double.compare(c2.getSaldo(), c1.getSaldo()));
    }

    public static Conta procura(int id) {
        for (Conta c : contas) {
            if (c.getnConta() == id) {
                return c;
            }
        }
        return null;
    }

    public static Conta procura(String Cpf) {
        for (Conta c : contas) {
            if (c.getCpf().equals(Cpf)) {
                return c;
            }
        }
        return null;
    }

    public static void add(Conta conta) {
        throw new UnsupportedOperationException("Adicionado"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
