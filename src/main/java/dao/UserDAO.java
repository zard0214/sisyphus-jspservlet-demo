package dao;

import model.User;

import java.util.List;

/**
 * @author zard
 * @date Created in 27/05/2022 02:29
 */
public interface UserDAO extends GenericDAO<User, Integer> {

    User getByName(String name);

    User getByNameAndStudentId(String name, String studentId);

    User getByStudentId(String studentId);

    List<User> getAllStudent();
}
