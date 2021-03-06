package gov.ca.cwds.rest.jdbi;

import gov.ca.cwds.rest.api.persistence.PersistentObject;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

/**
 * Interface for {@link Dao} which provide CRUDS operations
 * 
 * @author CWDS API Team
 *
 * @param <T>	The {@link PersistentObject} the DAO implements CRUDS for
 */
public interface CrudsDao<T extends PersistentObject> extends Dao {
	/**
	 * Find {@link PersistentObject} by id
	 * 
	 * @param id
	 *            The id of the {@link PersistentObject} to find.
	 * 
	 * @return The found object, null otherwise
	 */
	public T find(String id);

	/**
	 * Delete {@link PersistentObject} by id
	 * 
	 * @param id
	 *            The id of the {@link PersistentObject} to delete.
	 * 
	 * @return The deleted {@link PersistentObject}, null if not found
	 */
	public T delete(String id);

	/**
	 * Create {@link PersistentObject}
	 * 
	 * @param object
	 *            The {@link PersistentObject} to be created
	 * 
	 * @return The created {@link PersistentObject} with a newly populated id
	 * 
	 * @throws EntityExistsException when the {@link PersistentObject} already exists
	 */
	public T create(T object) throws EntityExistsException ;

	/**
	 * Update {@link PersistentObject}
	 * 
	 * @param object
	 *            The {@link PersistentObject} to be updated
	 * 
	 * @return The updated {@link PersistentObject}
	 * 
	 * @throws EntityNotFoundException when the {@link PersistentObject} does not exist
	 */
	public T update(T object) throws EntityNotFoundException;
}
