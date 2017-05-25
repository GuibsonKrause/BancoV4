/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancov4;

import java.util.Scanner;

/**
 *
 * @author Guibson
 */
public class Conta
  {
    Scanner ler = new Scanner(System.in);
// Atributos
    private String numero;
    private String titular;
    private double saldo;
    private static int quantContas;

// Construtor    
    public Conta(String titular, double saldo, String numero)
      {
        this.titular = titular;
        this.saldo = saldo;
        this.numero = numero;
      }

    public Conta(String titular, String numero)
      {
        this.titular = titular;
        this.saldo = 0;
        this.numero = numero;
      }

// Getter e Setter     
    public String getNumero()
      {
        return numero;
      }

    public void setNumero(String numero)
      {
        this.numero = numero;
      }

    public String getTitular()
      {
        return titular;
      }

    public void setTitular(String titular)
      {
        this.titular = titular;
      }

    public double getSaldo()
      {
        return saldo;
      }

    public void setSaldo(double saldo)
      {
        this.saldo = saldo;
      }

// Metodos    
    public void depositar()
      {
        System.out.println("Digite o valor a ser Depositado:");
        double valor;
        valor = ler.nextDouble();

        if (valor > 0)
          {
            this.saldo += valor;
          }
      }

    public void sacar()
      {
        System.out.println("Digite o valor a ser sacado:");

        double valor = 0;

        if (ler.hasNextDouble()) // Tratamento de erro do tipo na leitura
          {
            valor = ler.nextDouble();
          } else
          {
            System.out.println("Caracter inválido!");
            System.exit(0);
          }

        if (valor <= saldo && valor > 0)
          {
            this.saldo -= valor;
            System.out.println("Valor sacado com sucesso\n");
          } else
          {
            System.out.println("O seu saldo é insuficiente\n");
          }
      }

    public void dadosBancarios()
      {
          System.out.println("");
        System.out.println("Número da conta:" + getNumero());
        System.out.println("Titular da conta:" + getTitular());
        System.out.println("Saldo da conta:" + getSaldo());
        System.out.println("\n");
      }
  }
