/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemavendas_2_0;

import com.mycompany.controle.ControleSistema;
import com.mycompany.outros.Constante;
import com.mycompany.visao.VisaoMenu;

/**
 *
 * @author alexandre.9930
 */
public class SistemaVendas_2_0 {

    public static void main(String[] args) {
       int opcaoMenu;
       
       while(true){
           opcaoMenu = VisaoMenu.menuPrincipal();
           
           if(opcaoMenu == Constante.CADASTRAR){
               ControleSistema.cadastrar();
           }else if(opcaoMenu == Constante.ALTERAR){
               ControleSistema.alterar(VisaoMenu.menuAlteracaoProduto());
           
           }else if(opcaoMenu == Constante.LISTAR){
               ControleSistema.listar(ControleSistema.produtos);
           
           }
                
           }
        }
    }

