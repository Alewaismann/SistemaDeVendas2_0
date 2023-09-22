/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controle;

import com.mycompany.modelo.Computador;
import com.mycompany.modelo.VideoGame;
import com.mycompany.outros.Constante;
import com.mycompany.visao.VisaoComputador;
import com.mycompany.visao.VisaoMenu;
import com.mycompany.visao.VisaoVideoGame;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alexandre.9930
 */
public class ControleSistema {
    public static ArrayList<Object> produtos = new ArrayList<>();
    
    public static void cadastrar(){
        int opcaoProduto = VisaoMenu.menuEscolhaProduto();
        
        if(opcaoProduto == Constante.CATEGORIA_VIDEO_GAME){
            produtos.add(VisaoVideoGame.telaCadastroVideoGame());
        
        
        }else if(opcaoProduto == Constante.CATEGORIA_COMPUTADOR){
            produtos.add(VisaoComputador.telaCadastroComputador());
        
        }
    
    }
    
    public static void alterar(int indiceProduto){
        indiceProduto = indiceProduto - 1;
        
        Object object = produtos.get(indiceProduto);
        
        if(object instanceof VideoGame){
            VideoGame videoGame = new VideoGame();
            videoGame = (VideoGame) object;
            
            System.out.println("Alterando o produto: " + videoGame.toString());
            
            videoGame = (VideoGame) VisaoMenu.menuAlteracaoProdutoInformacoes(videoGame);
            
            ControleSistema.produtos.set(indiceProduto, videoGame);
        
        }else if(object instanceof Computador ){
            Computador computador = new Computador();
            computador = (Computador) object;
            
            System.out.println("Alterando o produto: " + computador.toString());
            
            computador = (Computador) VisaoMenu.menuAlteracaoProdutoInformacoes(computador);
            
            ControleSistema.produtos.set(indiceProduto, computador);
        
        }
    }
     
    public static void listar(ArrayList<Object> produtos){
        System.out.println("============LISTAGEM DE PRODUTOS=============");
        for(int i = 0; i < produtos.size(); i++){
            Object object = produtos.get(i);
            
            if(object instanceof VideoGame){
                VideoGame videoGame = (VideoGame) object;
                System.out.println(videoGame.toString());
                
            }else if(object instanceof Computador){
                Computador computador = (Computador) object;
                System.out.println(computador.toString());
            }
        }
        System.out.println("=============================================");
    }
    
    public static void remover(int indiceProduto){
        System.out.println("==============REMOVER PRODUTO================");    
        indiceProduto = indiceProduto -1;
        Object object = null;
        
         try{
          object = produtos.get(indiceProduto);
         }
        catch(Exception e){}
        
         if(object != null){
            if(object instanceof VideoGame){
                VideoGame videoGame = (VideoGame) object;
                System.out.println("Deseja remover o produto " + videoGame.getNome() + " ? (S/N)");

            }else if(object instanceof Computador){
                Computador computador = (Computador) object;
                System.out.println("Deseja remover o produto " + computador.getNome() + " ? (S/N)");

            }
            String sn = new Scanner(System.in).next().toLowerCase();

            if(sn.equals(Constante.REMOVER_SIM)){
                    produtos.remove(indiceProduto);
                    System.out.println("Produto removido com sucesso! ");

           }
        }else{
             System.out.println("Produto inexistente! ");
           }
        System.out.println("============================================="); 
     }
  }
 