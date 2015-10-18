/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twero.subjectchecker;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author twero
 */
public class SubjectDAO {

    final static String DRIVER_NAME = "org.h2.Driver";
    final static String URL = "jdbc:h2:tcp://localhost/~/subjectsDB";

    public SubjectDAO() {
        init();
    }

    private void init() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, "sa", "");

        } catch (SQLException | ClassNotFoundException exc) {
            System.err.println(String.format("Error connecting to the database %s \n%s", URL, exc));
            return null;
        }

        return conn;
    }
    
    
}
