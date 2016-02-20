/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class BookDAO extends DAO {

    static int counter = 0;
    PreparedStatement ps;
    Connection conn;

    public int newBook(String isbn, String title, String author, Float price) {
        try {

            conn = getConnection();
            String query = "INSERT INTO books(isbn, title, authors, price)" + "values(?,?,?,?);";
            ps = conn.prepareStatement(query);
            ps.setString(1, isbn);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setFloat(4, price);

            int result = ps.executeUpdate();
            if (result > 0) {
                counter++;
            }

            ps.close();

        } catch (Exception ex) {
        }
        return counter;
    }
}
