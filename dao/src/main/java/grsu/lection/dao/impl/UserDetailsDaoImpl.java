package grsu.lection.dao.impl;

import grsu.lection.dao.api.UserDetailsDao;
import grsu.lection.model.AppUser;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class UserDetailsDaoImpl extends AbstractDao<AppUser> implements UserDetailsDao {

    private static final String GET_BY_NAME_QUERY = "select au from AppUser au where au.username = :username";

    @Override
    protected Class<AppUser> getEntityClass() {
        return AppUser.class;
    }

    @Override
    public AppUser getByName(String username) {
        try {
            Query query = getEntityManager().createQuery(GET_BY_NAME_QUERY);
            query.setParameter("username", username);
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
