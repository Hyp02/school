package com.hyp.contorller.teskController;

import java.sql.*;

/**
 * @author Han
 * @data 2023/4/22
 * @apiNode
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection root = DriverManager.getConnection("jdbc:mysql://8.130.117.245:3306/school_p?useSSL=false", "root", "123456789*Gyc");
        PreparedStatement preparedStatement = root.prepareStatement("select * from t_k");
        ResultSet resultSet = preparedStatement.executeQuery();
        //System.out.println(resultSet.getMetaData().getColumnName(1));
        System.out.println(resultSet.getInt(1));
       /* int string = resultSet.getInt(1);
        System.out.println(string);*/
    }
}
