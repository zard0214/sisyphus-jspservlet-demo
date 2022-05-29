package dao.impl;

import dao.BaseDAO;
import dao.SamplesDAO;
import model.Samples;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author zard
 * @date Created in 27/05/2022 02:30
 */
public class SamplesDAOImpl extends BaseDAO implements SamplesDAO {

    public SamplesDAOImpl(){
        super();
    }

    @Override
    public void save(Samples samples) {
        conn();
        PreparedStatement pstmt = null;
        try {
            String sql = "insert into samples (tube_number, user_ids) values (?,?)";
            pstmt= (PreparedStatement) MyODBC.prepareStatement(sql);
            pstmt.setString(1, samples.getTubeNumber());
            pstmt.setString(2, samples.getUserIds());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn_close();
    }

    @Override
    public void update(Samples samples) {
        conn();
        PreparedStatement pstmt = null;
        try {
            String sql = "update samples set result=? where tube_number=?";
            pstmt= (PreparedStatement) MyODBC.prepareStatement(sql);
            pstmt.setInt(1, samples.getResult());
            pstmt.setString(2, samples.getTubeNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn_close();
    }

    @Override
    public void delete(Samples samples) {

    }

    @Override
    public List<Samples> getAll() {
        return null;
    }

    @Override
    public Samples getByID(Integer uuid) {
        return null;
    }

    @Override
    public Samples getByStudentId(String studentId) {
        conn();
        String sql="SELECT * from samples where user_ids like ?";
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Samples samples = null;
        try {
            pstmt= (PreparedStatement) MyODBC.prepareStatement(sql);
            pstmt.setString(1, studentId + "/");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Date gmt_created = resultSet.getDate("gmt_created");
                String gmtCreatedStr = formatter.format(gmt_created);
                Date gmt_modified = resultSet.getDate("gmt_modified");
                String gmtModifiedStr = formatter.format(gmt_modified);
                int result = resultSet.getInt("result");
                String resultStr = "未检测";
                if(result == 0){

                }else if(result == 1){
                    resultStr = "阴性";
                }else if(result == 2){
                    resultStr = "阳性";
                }
                samples = new Samples(resultSet.getString("tube_number"), gmtCreatedStr,
                        gmtModifiedStr, resultStr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn_close();
        return samples;
    }
}
