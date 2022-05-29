package dao;

import model.Samples;

/**
 * @author zard
 * @date Created in 27/05/2022 02:29
 */
public interface SamplesDAO extends GenericDAO<Samples, Integer> {

    Samples getByStudentId(String studentId);
}
