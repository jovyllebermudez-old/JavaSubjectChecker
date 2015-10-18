/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twero.subjectchecker.utils;

import com.twero.subjectchecker.model.Subject;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public Subject getById(final int id) throws SQLException {

        Connection connection = null;
        ResultSet rs = null;
        Subject subject = new Subject();
        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();

            final String sql = String.format("SELECT id, name, time, room FROM subjects WHERE id=%d", id);
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                subject.setId(rs.getInt("id"));
                subject.setName(rs.getString("name"));
                subject.setTime(rs.getDate("time"));
                subject.setRooom(rs.getString("room"));

            } else {
                return null;
            }

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return subject;
    }
    
    
}
