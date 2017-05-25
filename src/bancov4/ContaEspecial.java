/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancov4;

/**
 *
 * @author Guibson
 */
class ContaEspecial extends Conta // Herança
  {

    private double limite;

// Construtor        
    public ContaEspecial(String titular, double saldo, double limite, String numero)
      {
        super(titular, saldo, numero);

        this.limite = limite;
      }

// Getter e Setter  
    public double getLimite()
      {
        return limite;
      }

    public void setLimite(double limite)
      {
        this.limite = limite;
      }

// Metodos herdados    
    @Override // Sobrescrita
    public void sacar()
      {
        double valor = 0;

        System.out.println("Digite o valor a ser sacado:");
        if (ler.hasNextDouble())
          {
            valor = ler.nextDouble();
          } else
          {
            System.out.println("Caracter inválido!");
            System.exit(0);
          }
        double limiteMaisSaldo = this.getSaldo() + this.limite;

        if (valor <= limiteMaisSaldo)
          {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque realizado com sucesso");

          } else
          {
            System.out.println("O seu saldo é insuficiente");
          }
      }

    @Override
    public void dadosBancarios()
      {
        System.out.println("");
        System.out.println("Número da conta:" + getNumero());
        System.out.println("Titular da conta:" + getTitular());
        System.out.println("Saldo da conta:" + getSaldo());
        System.out.println("Limite da conta:" + getLimite());
        System.out.println("\n");
      }

  }
