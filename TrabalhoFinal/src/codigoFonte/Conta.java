package codigoFonte;

import java.time.LocalDate;
import javax.swing.JOptionPane;

class Conta {

    private String usuario;
    private String cpf;
    private String transferencias = "";
    private String senha;
    private LocalDate data;
    private int nConta;
    private double saldo;

    
    public boolean saca(double saque) {
        if (saque > this.saldo) {
            JOptionPane.showMessageDialog(null, "Saque maior que o saldo!Saldo: R$" + this.getSaldo() + ";Saque: R$" + saque + "!", "Alerta", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.saldo -= saque;
        this.transferencias += "\nSaque realizado,R$" + saque + " foram removisdos da conta";
        return true;
    }

    public boolean deposito(double deposito) {
        if (deposito < 0) {
            JOptionPane.showMessageDialog(null, "Deposito nao pode ser menor que R$ 0!", "Alerta", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.saldo += deposito;
        this.transferencias += "\nDeposito realizado,R$" + deposito + " foram adicionados a conta";
        return true;
    }

    void transfere(Conta c, double deposito) {
        this.saca(deposito);
        c.deposito(deposito);
        this.transferencias += "\nTransferencia realizada, R$" + deposito + " foram enviados para " + c.getUsuario();
        c.transferencias += "Transferencia recebido,R$" + deposito + " foram recebidos de " + this.getUsuario();
    }

    @Override
    public String toString() {
        return "[Titular da conta:" + this.getUsuario() + "\nId:" + this.getnConta() + "\nCpf:" + this.getCpf() + "\nSaldo: R$" + this.getSaldo() + "\nData de criacao: " + this.getData() + "]\n\n";
    }

    
    public Conta(String cliente, String cpf, String senha) {
        this.usuario = cliente;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTransferencias() {
        return this.transferencias;
    }

    public String getSenha() {
        return this.senha;
    }

    protected void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public int getnConta() {
        return nConta;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public double getSaldo() {
        return this.saldo;
    }
}
