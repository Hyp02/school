package com.hyp.service.KdService;

import com.hyp.pojo.KD;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/8
 * @apiNode
 */
public interface KdService {
    List<KD> getAllKdInfo();
    int issuedKD(KD kd);
    KD getKdByName(String name);
    int deleteKdByKdId(String Kdid);
}
