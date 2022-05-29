package dao.impl;

import dao.BaseDAO;
import dao.UserDAO;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zard
 * @date Created in 27/05/2022 02:30
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {

    public UserDAOImpl(){
        super();
    }
    @Override
    public void save(User user) {
        conn();
        PreparedStatement pstmt = null;
        try {
            String sql = "insert into user (name, type, student_id, pwd) values (?,?,?,?)";
            pstmt= (PreparedStatement) MyODBC.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getType());
            pstmt.setString(3, user.getStudentId());
            if(user.getPwd() == null)
                pstmt.setString(4, "123456");
            else
                pstmt.setString(4, user.getPwd());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn_close();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> getAll() {
        conn();
        String sql="SELECT * from user";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        User user = null;
        try {
            pstmt= (PreparedStatement) MyODBC.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                user = new User(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name"),
                        Integer.parseInt(resultSet.getString("type")), resultSet.getString("pwd"),
                        resultSet.getString("student_id"));
                if(Integer.parseInt(resultSet.getString("type")) == 1){
                    user.setTypeName("管理员用户");
                }
                else if(Integer.parseInt(resultSet.getString("type")) == 2){
                    user.setTypeName("核酸采集大白用户");
                }
                else if(Integer.parseInt(resultSet.getString("type")) == 3){
                    user.setTypeName("检测结果上传用户");
                }
                else if(Integer.parseInt(resultSet.getString("type")) == 4){
                    user.setTypeName("被检测者学生用户");
                }
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn_close();
        return list;
    }

    @Override
    public User getByID(Integer id) {
        conn();
        String sql="SELECT * from user where id=?";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            pstmt= (PreparedStatement) MyODBC.prepareStatement(sql);
            pstmt.setInt(1, id);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                user = new User(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name"),
                        Integer.parseInt(resultSet.getString("type")), resultSet.getString("pwd"),
                        resultSet.getString("student_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn_close();
        return user;
    }

    @Override
    public User getByName(String name) {
        conn();
        String sql="SELECT * from user where name=?";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            pstmt= (PreparedStatement) MyODBC.prepareStatement(sql);
            pstmt.setString(1, name);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                user = new User(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name"),
                        Integer.parseInt(resultSet.getString("type")), resultSet.getString("pwd"),
                        resultSet.getString("student_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn_close();
        return user;
    }

    @Override
    public User getByNameAndStudentId(String name, String studentId) {
        conn();
        String sql="SELECT * from user where name=? and student_id=? and type = 4";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            pstmt= (PreparedStatement) MyODBC.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, studentId);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                user = new User(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name"),
                        Integer.parseInt(resultSet.getString("type")), resultSet.getString("pwd"),
                        resultSet.getString("student_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn_close();
        return user;
    }

    @Override
    public User getByStudentId(String studentId) {
        conn();
        String sql="SELECT * from user where student_id=? and type = 4";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            pstmt= (PreparedStatement) MyODBC.prepareStatement(sql);
            pstmt.setString(1, studentId);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                user = new User(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name"),
                        Integer.parseInt(resultSet.getString("type")), resultSet.getString("pwd"),
                        resultSet.getString("student_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn_close();
        return user;
    }

    @Override
    public List<User> getAllStudent() {
        conn();
        String sql="SELECT * from user where type = 4";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        User user = null;
        try {
            pstmt= (PreparedStatement) MyODBC.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                user = new User(Integer.parseInt(resultSet.getString("id")), resultSet.getString("name"),
                        Integer.parseInt(resultSet.getString("type")), resultSet.getString("pwd"),
                        resultSet.getString("student_id"));
                if(Integer.parseInt(resultSet.getString("type")) == 1){
                    user.setTypeName("管理员用户");
                }
                else if(Integer.parseInt(resultSet.getString("type")) == 2){
                    user.setTypeName("核酸采集大白用户");
                }
                else if(Integer.parseInt(resultSet.getString("type")) == 3){
                    user.setTypeName("检测结果上传用户");
                }
                else if(Integer.parseInt(resultSet.getString("type")) == 4){
                    user.setTypeName("被检测者学生用户");
                }
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        conn_close();
        return list;
    }
}
