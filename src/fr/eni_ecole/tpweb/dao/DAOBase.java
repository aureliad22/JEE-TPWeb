/**
 * @author adelaune2017
 * @date 19 juil. 2017
 * @version TPWeb V1.0
 */
package fr.eni_ecole.tpweb.dao;

import java.util.List;

/**
 * @author adelaune2017
 * @date 19 juil. 2017
 * @version TPWeb V1.0
 */
public interface DAOBase<T> {

	public void update(T data) throws Exception;
	public void insert(T data) throws Exception;
	public void delete(T data) throws Exception;
	public <Type> T selectById(Type id) throws Exception;
	public List<T> selectAll() throws Exception;
}
