package com.hyp.dao.KdDao;

import com.hyp.pojo.KD;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/8
 * @apiNode
 */
public interface KdDao {
    List<KD> getAllKd();
    KD getKdByName(String name);
    int addKd(KD kd);
    int deleteKdByKdId(String kdid);
}
