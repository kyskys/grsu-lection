package grsu.lection.service.impl;

import grsu.lection.dao.api.BreadDao;
import grsu.lection.model.Bread;
import grsu.lection.service.api.BreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BreadServiceImpl implements BreadService {

    private final BreadDao breadDao;
//
//    @Override
//    protected BreadDao getDefaultDao() {
//        return breadDao;
//    }
//
//    @Override
//    public List<Bread> getAllSortedBy(String name) {
//        return null;
//    }
}
