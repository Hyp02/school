package com.hyp.service.HelpGetService;

import com.hyp.pojo.HelpGet;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/11
 * @apiNode
 */
public interface HelpGetService {
    //将帮取人信息添加到t_help-user中
    int saveHelpUserInfo(HelpGet helpGet);
    //根据快递取货码从t_help_user中删除
    int deleteHelpUserById(String id);
    List<HelpGet> getHelpGet(String helpName);
}
