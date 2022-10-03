
package br.com.diversas.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.diversas.model.Sugestao;
import br.com.diversasFactory.ConnectionFactory;

public class SugestaoDAO {
    
    
    //Aqui é onde funciona o INSERT ficara como SAVE para fazer registros 
    public void save (Sugestao sugestao ) throws SQLException {
         String sql = "INSERT INTO sugestao (nome, email, sugestao)VALUES(?,?,?)";
         Connection conn = null;
         PreparedStatement pstm = null;
         
          try {
            //Criar uma conexao com o Bd
            conn = ConnectionFactory.createConnectionToMySQl();
            // Criamos um prepareStatement para criar uma query
            pstm =(PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setString(1, sugestao.getNome());
            pstm.setString(2, sugestao.getEmail());
            pstm.setString(3, sugestao.getSugestao());
            
            //Executar a query
            pstm.execute();
          }   catch(Exception e){
            
            e.printStackTrace();
            
        }finally{
            
            try {
                if (pstm != null) {     
                    pstm.close();
                }
                
                if (conn != null) {
                    conn.close();
                    
                }
                
            }catch(Exception e){
            
            e.printStackTrace();
    }
    
          }
    }
 
    
     //Aqui é onde funciona o SELECT ficara como getSugestao para fazer consulta de dados 
    public List<Sugestao> getSugestao() throws SQLException{
     
        String sql = "SELECT * FROM sugestao";
        
        List<Sugestao> sugestao = new ArrayList<Sugestao>();
        
        Connection conn = null;
         
        PreparedStatement pstm = null;
         
        ResultSet rset = null;
          
          try{
              conn = ConnectionFactory.createConnectionToMySQl();
             
              pstm = (PreparedStatement) conn.prepareStatement(sql);
              
              rset = pstm.executeQuery();
              
              while(rset.next()){
                  
               Sugestao sugestaoslct = new Sugestao();
                 
                 //Recuperar nome
                 sugestaoslct.setNome(rset.getString("nome"));
                 //Recuperar email
                 sugestaoslct.setEmail(rset.getString("email"));
                 //Recuperar sugestao      
                 sugestaoslct.setSugestao(rset.getString("sugestao"));
                 
                 sugestao.add (sugestaoslct);
              }
          }catch(Exception e){
              e.printStackTrace();
          }finally{
        try{
            if(rset != null){
                
                rset.close();
                
            }
            if(pstm != null){
                pstm.close();  
            }
            
            if(conn != null){
                conn.close();      
            }
            
        }catch(Exception e){
            e.printStackTrace();
        } 
        return sugestao;
         
        
    }
    }

    
     //Aqui é onde funciona o UPDATE para atualizar os dados 
    public void updateS(Sugestao sugestao) throws SQLException{
     String sql = "UPDATE sugestao SET  nome= ?,email= ?,sugestao= ?"+
        "WHERE id_sugestao= ?";
     
       Connection conn = null;
       
       PreparedStatement pstm = null;
       
       try{
            
            conn = ConnectionFactory.createConnectionToMySQl();
           
            pstm = (PreparedStatement) 
            
            conn.prepareStatement(sql);
            
            // Adiacionar os valores para atualizar 
            pstm.setString(1, sugestao.getNome());
            pstm.setString(2, sugestao.getEmail());
            pstm.setString(3, sugestao.getSugestao());
            pstm.setInt(4,sugestao.getId_sugestao());
            
            pstm.execute();
       }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();   
                }
            }catch(Exception e){
             e.printStackTrace();
            }
        }   
 }


    //Deletar dados da tabela
    public void deleteByID( int id_sugestao){
        String sql = "DELETE FROM sugestao WHERE id_sugestao = ?";
        
         Connection conn = null;
         
         PreparedStatement pstm = null;
         
         try{
            
            conn = ConnectionFactory.createConnectionToMySQl();
            
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setInt(1, id_sugestao);
            
            pstm.execute();
            
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            try{
                if(conn != null){
                    conn.close();
                }
                if(pstm != null)
                    pstm.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
         

    
