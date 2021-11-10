package grsu.lection.service.impl;


import grsu.lection.dao.api.Dao;
import grsu.lection.model.AbstractEntity;
import grsu.lection.service.api.Service;
import grsu.lection.service.dto.AbstractDto;

import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractService<T extends AbstractEntity, Z extends AbstractDto, D extends Dao<T>> implements Service<T, Z> {

    protected abstract D getDefaultDao();

}
