/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancov4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Guibson
 */
public class Interface
  {
    Scanner ler = new Scanner(System.in);
    
// Atributos
    private int opmenu;
    private int opTipoConta;
    private String nome;
    private double limite;
    private float saldo;
    private int opConta;
    private int manipTipoConta;
    private String numeroConta;

    Map<String, Conta> hashConta = new HashMap<>(); // HashMap de Conta
    Map<String, ContaEspecial> hashContaEspecial = new HashMap<>(); // HashMap de Conta Especial

// Getter e Setter       
    public String getNumeroConta()
      {
        return numeroConta;
      }

    public void setNumeroConta(String numeroConta)
      {
        this.numeroConta = numeroConta;
      }

    public Map<String, Conta> getHashConta()
      {
        return hashConta;
      }

    public void setHashConta(Map<String, Conta> hashConta)
      {
        this.hashConta = hashConta;
      }

    public Map<String, ContaEspecial> getHashContaEspecial()
      {
        return hashContaEspecial;
      }

    public void setHashContaEspecial(Map<String, ContaEspecial> hashContaEspecial)
      {
        this.hashContaEspecial = hashContaEspecial;
      }

    public String getNome()
      {
        return nome;
      }

    public void setNome(String nome)
      {
        this.nome = nome;
      }

    public double getLimite()
      {
        return limite;
      }

    public void setLimite(double limite)
      {
        this.limite = limite;
      }

    public double getSaldo()
      {
        return saldo;
      }

    public void setSaldo(float saldo)
      {
        this.saldo = saldo;
      }

    public int getManipTipoConta()
      {
        return manipTipoConta;
      }

    public void setManipTipoConta(int manipTipoConta)
      {
        this.manipTipoConta = manipTipoConta;
      }

    public int getOpConta()
      {
        return opConta;
      }

    public void setOpConta(int opConta)
      {
        this.opConta = opConta;
      }

    public int getOpTipoConta()
      {
        return opTipoConta;
      }

    public void setOpTipoConta(int opTipoConta)
      {
        this.opTipoConta = opTipoConta;
      }

    public int getOpmenu()
      {
        return opmenu;
      }

    public void setOpmenu(int opmenu)
      {
        System.out.println("Digite o Numero da Operação");
        this.opmenu = opmenu;
      }

    public void criarContaMenu()
      {
        System.out.println("Digite a Operação desejada:");
        System.out.println("1 - Para Conta Normal");
        System.out.println("2 - Para Conta Especial");
        System.out.println("0 - Para Sair");
      }

    public void criarMenu()
      {
        System.out.println("Digite o numero da operação deseja:");
        System.out.println("1 - Dados Bancários:");
        System.out.println("2 - Depósito:");
        System.out.println("3 - Saque:");
        System.out.println("0 - Sair:");
      }

    public void opTipoConta()
      {
        do
          {
            System.out.println("Digite o Tipo de conta que você deseja criar:");
            System.out.println("");
            criarContaMenu();
            if (ler.hasNextInt())
              {
                this.opTipoConta = ler.nextInt();

                switch (this.opTipoConta)
                  {
                    case 1:
                          {
                            System.out.println("Digite o numero da conta desejada:");
                            this.numeroConta = ler.next();
                            
                            System.out.println("Digite o nome do usuário da conta:");
                            this.nome = ler.next();
                            
                            System.out.println("Digite o saldo:");
                            this.saldo = ler.nextFloat();
                            
                            Conta c1 = new Conta(nome, saldo, numeroConta);
                            hashConta.put(numeroConta, c1);
                            break;
                          }
                    case 2:
                          {
                            System.out.println("Digite o numero da conta desejada:");
                            this.numeroConta = ler.next();
                            
                            System.out.println("Digite o nome do usuário:");
                            this.nome = ler.next();
                            
                            System.out.println("Digite o saldo:");
                            this.saldo = ler.nextFloat();
                            
                            System.out.println("Informe o limite:");
                            this.limite = ler.nextDouble();
                            
                            ContaEspecial c1 = new ContaEspecial(nome, saldo, limite, numeroConta);
                            hashContaEspecial.put(numeroConta, c1);
                            break;
                          }
                    case 0:
                        this.opTipoConta = 0;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        this.opTipoConta = 0;
                        break;
                  }

              }
          } while (this.opTipoConta != 0);
        System.out.println("");
        System.out.println("Digite o tipo de conta que deseja manipular");
        
        criarContaMenu();
        int numDeConta = 0, conta = 1, contaEspecial = 1;

        if (ler.hasNextInt())
          {
            this.manipTipoConta = ler.nextInt();

            if (this.manipTipoConta == 1)
              {
                numDeConta = hashConta.size();

                System.out.println("Contas existentes:");

                for (int i = 0; i < numDeConta; i++)
                  {
                    System.out.println("Conta: " + conta);
                    conta++;
                  }

                System.out.println("Digite o numero da conta:");
                String numero = ler.nextLine();
                numero = ler.nextLine();
                
                if (hashConta.containsKey(numero))
                  {
                    System.out.println("");
                    criarMenu();
                    int a = op(getOpmenu());
                    while (a != 0)
                      {
                        switch (a)
                          {
                            case 0:
                                System.exit(0);
                                break;
                            case 1:
                                getHashConta().get(numero).dadosBancarios();
                                opTipoConta();
                                break;
                            case 2:
                                getHashConta().get(numero).depositar();
                                opTipoConta();
                                break;
                            case 3:
                                getHashConta().get(numero).sacar();
                                opTipoConta();
                                break;
                          }
                      }
                  } else
                  {
                    System.out.println("Conta não encontrada!");
                  }

                if (this.opConta == 0)
                  {
                    System.exit(0);
                  }

                if (this.opConta < 1 || this.opConta > numDeConta)
                  {
                    System.out.println("Conta inexistente");
                    System.exit(0);
                  }

                criarMenu();

                if (ler.hasNextInt())
                  {
                    this.opmenu = ler.nextInt();
                  } else
                  {
                    System.out.println("Opção inválida!");
                    System.exit(0);
                  }
              }
            
            int numDeContaEsp = 0;
            if (this.manipTipoConta == 2)
              {
                numDeContaEsp = hashContaEspecial.size();
                
                System.out.println("Contas existentes:");

                for (int i = 0; i < numDeContaEsp; i++)
                  {
                    System.out.println("Conta Especial: " + contaEspecial);
                    contaEspecial++;
                  }

                System.out.println("Digite o numero da conta:");
                String numero = ler.nextLine();
                numero = ler.nextLine();

                if (hashContaEspecial.containsKey(numero))
                  {
                    int a = op(getOpmenu());
                    while (a != 0)
                      {
                        switch (a)
                          {
                            case 0:
                                System.exit(0);
                                break;
                            case 1:
                                getHashContaEspecial().get(numero).dadosBancarios();
                                opTipoConta();
                                break;
                            case 2:
                                getHashContaEspecial().get(numero).depositar();
                                opTipoConta();
                                break;
                            case 3:
                                getHashContaEspecial().get(numero).sacar();
                                opTipoConta();
                                break;
                          }
                      }
                  } else
                  {
                    System.out.println("Conta não encontrada:");
                  }

                if (this.opConta == 0)
                  {
                    System.exit(0);
                  }

                if (this.opConta < 1 || this.opConta > numDeContaEsp)
                  {
                    System.out.println("Essa conta não existe");
                    System.exit(0);
                  }

                criarMenu();

                if (ler.hasNextInt())
                  {
                    this.opmenu = ler.nextInt();
                  } else
                  {
                    System.out.println("Opção inválida!");
                    System.exit(0);
                  }
              }
          } else
          {
            System.out.println("Opção inválida!");
            System.exit(0);
          }
      }

    public int op(int setOpmenu)
      {
        if (ler.hasNextInt())
          {
            return setOpmenu = ler.nextInt();
          } else
          {
            System.out.println("Opção invalida\n");
            return 0;
          }
      }
  }
