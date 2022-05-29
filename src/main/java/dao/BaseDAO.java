package dao;


import java.sql.*;

public class BaseDAO {

    private static final long serialVersionUID = 1L;

    public Connection MyODBC;

    public void conn() {
        String url="jdbc:mysql://localhost:3307/sisyphus_uac?serverTimezone=GMT%2B8&useSSL=false&useUnicode=true&charcterEncoding=UTF-8";
        String userName = "root";
        String userPwd = "123456";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            MyODBC = DriverManager.getConnection(url, userName, userPwd);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void conn_close(){
        try {
            MyODBC.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}