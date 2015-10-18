package com.twero.subjectchecker;

import com.twero.subjectchecker.model.Subject;
import com.twero.subjectchecker.utils.SubjectDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        SubjectDAO dao = new SubjectDAO();
        
        try {
            Subject subject = dao.getById(2);
            System.out.println("name:" + subject.getName());
            
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
}
