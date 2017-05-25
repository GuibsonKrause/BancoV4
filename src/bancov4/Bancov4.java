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
public class Bancov4
  {
    /**
     * @param args the command line arguments
     */
    // TODO code application logic here
    public static void main(String[] args)
      {

        Scanner scan = new Scanner(System.in);

        Interface i1 = new Interface();

        i1.opTipoConta();
      }
  }
