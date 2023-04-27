package com.hyp.dao.HelpGetDao;

import com.hyp.pojo.HelpGet;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/10
 * @apiNode
 */

public interface HelpGetDao {

    //点击帮取后，将数据存到t_help_user表中
    int saveHelpInfo(HelpGet helpGet);
    //当用户点击已收到货而后，从表中根据kdid删除
    int deleteById(String id);
    //根据取货码获取帮取人的信息
    List<HelpGet> getHelpUserInfo(String helpName);

}
