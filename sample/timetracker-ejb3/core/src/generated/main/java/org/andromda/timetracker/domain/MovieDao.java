// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by DaoLocal.vsl overrided in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.domain;

import java.util.Collection;

/**
 * @see Movie
 */
public interface MovieDao
{
    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes no transformation will occur.
     */
    public static final int TRANSFORM_NONE = 0;

    /**
     * Loads an instance of Movie from the persistent store.
     * @param id the identifier of the entity to load.
     * @throws MovieDaoException
     */
    public Movie load(Long id)
        throws MovieDaoException;

    /**
     *   Does the same thing as {@link #load(Long)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined in this class then the result <strong>WILL BE</strong> passed through an operation which can
     *   optionally transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param id the identifier of the entity to load.
     * @return either the entity or the object transformed from the entity.
     * @throws MovieDaoException
     */
    public Object load(int transform, Long id)
        throws MovieDaoException;

    /**
     * Loads all entities of type {@link Movie}.
     *
     * @return the loaded entities.
     * @throws MovieDaoException
     */
    public Collection<Movie> loadAll()
        throws MovieDaoException;

    /**
     *   Does the same thing as {@link #loadAll()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform the flag indicating what transformation to use.
     * @return Collection of the loaded entities.
     * @throws MovieDaoException
     */
    public Collection loadAll(final int transform)
        throws MovieDaoException;

    /**
     * Creates an instance of Movie and adds it to the persistent store.
     * @param movie
     * @return Movie
     * @throws MovieDaoException
     */
    public Movie create(Movie movie)
        throws MovieDaoException;

    /**
     *   Does the same thing as {@link #create(Movie)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param movie
     * @return Object
     * @throws MovieDaoException
     */
    public Object create(int transform, Movie movie)
        throws MovieDaoException;

    /**
     * Creates a new instance of Movie and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of Movie
     *        instances to create.
     * @return the created instances. Collection<Movie>
     * @throws MovieDaoException
     */
    public Collection<Movie> create(Collection<Movie> entities)
        throws MovieDaoException;

    /**
     *   Does the same thing as {@link #create(Movie)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param entities
     * @return the created instances. Collection
     * @throws MovieDaoException
     */
    public Collection create(int transform, Collection<Movie> entities)
        throws MovieDaoException;

    /**
     *   Creates a new <code>Movie</code>
     *   instance from <strong>all</strong> attributes and adds it to
     *   the persistent store.
     * @param title
     * @param year
     * @param version
     * @param director
     * @param plot
     * @return the created instances. Movie
     * @throws MovieDaoException
     */
    public Movie create(
        String title,
        Integer year,
        Integer version,
        String director,
        String plot)
        throws MovieDaoException;

    /**
     *   Does the same thing as {@link #create(String, Integer, Integer, String, String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     *
     * @param transform
     * @param title
     * @param year
     * @param version
     * @param director
     * @param plot
     * @return the created instances. Object
     * @throws MovieDaoException
     */
    public Object create(
        int transform,
        String title,
        Integer year,
        Integer version,
        String director,
        String plot)
        throws MovieDaoException;


    /**
     * Updates the <code>movie</code> instance in the persistent store.
     * @param movie
     * @throws MovieDaoException
     */
    public void update(Movie movie)
        throws MovieDaoException;

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     * @param entities
     * @throws MovieDaoException
     */
    public void update(Collection<Movie> entities)
        throws MovieDaoException;

    /**
     * Removes the instance of Movie from the persistent store.
     * @param movie
     * @throws MovieDaoException
     */
    public void remove(Movie movie)
        throws MovieDaoException;

    /**
     * Removes the instance of Movie having the given
     * <code>identifier</code> from the persistent store.
     * @param id
     * @throws MovieDaoException
     */
    public void remove(Long id)
        throws MovieDaoException;

    /**
     * Removes all entities in the given <code>entities<code> collection.
     * @param entities
     * @throws MovieDaoException
     */
    public void remove(Collection<Movie> entities)
        throws MovieDaoException;

}
