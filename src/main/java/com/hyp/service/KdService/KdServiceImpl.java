package com.hyp.service.KdService;

import com.hyp.dao.KdDao.KdDao;
import com.hyp.pojo.KD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/8
 * @apiNode
 */
@Service
public class KdServiceImpl implements KdService {
    @Autowired
    private KdDao kdDao;

    @Override
    public List<KD> getAllKdInfo() {
        return kdDao.getAllKd();
    }

    @Override
    public int issuedKD(KD kd) {
        return kdDao.addKd(kd);
    }

    @Override
    public KD getKdByName(String name) {
        return kdDao.getKdByName(name);
    }

    @Override
    public int deleteKdByKdId(String kdid) {
        return kdDao.deleteKdByKdId(kdid);
    }
}
