package grsu.lection.dao.api;

import grsu.lection.model.AppUser;

public interface UserDetailsDao extends Dao<AppUser> {
    AppUser getByName(String username);
}
