package com.hyp.dao.HelpGetDao;

import com.hyp.pojo.HelpGet;
import com.hyp.service.KdService.KdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/10
 * @apiNode
 */
@Component
@Repository
public class HelpGetDaoImpl implements HelpGetDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    KdService kdService;


    /**
     * 将帮取人的信息保存到t_help_user表中
     * 并且将快递信息从t-k表中删除
     * 然后根据kdid将帮取人信息从t-help-user表中取出来，
     * 存到model中，用来在发布这个信息的人的“我的信息”页面中显示报帮取人的信息
     *
     * @param helpGet
     * @return
     */
    @Override
    public int saveHelpInfo(HelpGet helpGet) {
        String sql = "insert into t_help_user (id,helpName,taskName,issuedName,helpPhone,kdid)" +
                "value(?,?,?,?,?,?)";
        //将helpUser的信息保存
        int update = jdbcTemplate.update(sql, null, helpGet.getHelpName(), helpGet.getTaskName(), helpGet.getIssuedName(), helpGet.getHelpPhone(),
                helpGet.getKdid());
        //从t-k表中将发布的信息删除
        int i = kdService.deleteKdByKdId(helpGet.getKdid());
        if (update > 0 && i > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteById(String id) {
        String sql = "delete from t_help_user where id = ?";

        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<HelpGet> getHelpUserInfo(String helpName) {
        String sql = "select * from t_help_user where issuedName = ?";
        //根据取货码将帮取人信息取出，用于在发布快递的人的页面显示
        return jdbcTemplate.query(sql, new Object[]{helpName}, (rs, rowNum) -> {
            HelpGet hg = new HelpGet();
            hg.setId(rs.getInt("id"));
            hg.setHelpName(rs.getString("helpName"));
            hg.setTaskName(rs.getString("taskName"));
            hg.setIssuedName(rs.getString("issuedName"));
            hg.setHelpPhone(rs.getString("helpPhone"));
            hg.setKdid(rs.getString("kdid"));
            return hg;
        });
    }
}
