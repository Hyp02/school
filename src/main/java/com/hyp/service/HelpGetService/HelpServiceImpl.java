package com.hyp.service.HelpGetService;

import com.hyp.dao.HelpGetDao.HelpGetDao;
import com.hyp.pojo.HelpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/11
 * @apiNode
 */
@Service
public class HelpServiceImpl implements HelpGetService{
    @Autowired
    HelpGetDao helpGetDao;
    @Override
    public int saveHelpUserInfo(HelpGet helpGet) {
        return helpGetDao.saveHelpInfo(helpGet);
    }

    @Override
    public int deleteHelpUserById(String id) {
        return helpGetDao.deleteById(id);
    }

    @Override
    public List<HelpGet> getHelpGet(String helpName) {
        return helpGetDao.getHelpUserInfo(helpName);
    }
}
