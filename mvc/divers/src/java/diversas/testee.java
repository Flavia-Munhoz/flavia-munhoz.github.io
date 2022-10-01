/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diversas;

import br.com.diversasDAO.CadastroDAO;
import br.com.diversasDAO.SugestaoDAO;
import java.sql.SQLException;

public class testee {
    
    public static void main(String[] args) throws SQLException{
        
        //USANDO SAVE CADASTRO
        
          SugestaoDAO sugestaoDao = new SugestaoDAO();
        
          //Sugestao sugestao = new   Sugestao();
        
          //sugestao.setNome("lucas uanderson");
          //sugestao.setEmail("lucasu@live.com");
          //sugestao.setSugestao("lovelovelovelovelovelove");
          
        
         //sugestaoDao.save(sugestao);
         
         
         

         // Deletando dado do banco por id
         
         // sugestaoDao.deleteByID(2);
         
          
          Sugestao p1 = new Sugestao();
         
          p1.setNome("lucas ferreira");
          p1.setEmail("llll@gmail");
          p1.setSugestao("amoramoramoramoramoramor");
          p1.setId_sugestao(1);
          
          sugestaoDao.updateS(p1);
         
    }
}
