package com.hyp.dao.KdDao;

import com.hyp.pojo.KD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author Han
 * @data 2023/4/8
 * @apiNode
 */
@Component
@Repository
public class KdDaoImpl implements KdDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<KD> getAllKd() {
        String sql = "SELECT * FROM t_k";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            KD kd = new KD();
            // 通过 setter 方法将其他属性值赋值到kd对象中。
            kd.setNo(rs.getInt("no"));
            kd.setKdId(rs.getString("KdId"));
            kd.setKdName(rs.getString("kdName"));
            kd.setPhone(rs.getString("phone"));
            kd.setName(rs.getString("name"));
            kd.setAddress(rs.getString("address"));
            return kd;
        });
    }

    @Override
    public KD getKdByName(String name) {
        String sql = "select * from t_k where name = ?";
        KD kd = jdbcTemplate.query(sql, new Object[]{name}, rs -> {
            if (rs.next()) {
                KD k = new KD();
                k.setNo(rs.getInt("no"));
                k.setName(rs.getString("name"));
                k.setPhone(rs.getString("phone"));
                k.setKdName(rs.getString("kdName"));
                k.setKdId(rs.getString("KdId"));
                k.setAddress(rs.getString("address"));
                return k;
            } else {
                return null;
            }
        });
        return kd;
    }

    @Override
    public int addKd(KD kd) {
        String sql = "insert into t_k(no,name,kdName,phone,KdId,address) value(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, null, kd.getName().getBytes(StandardCharsets.UTF_8), kd.getKdName().getBytes(StandardCharsets.UTF_8),
                kd.getPhone().getBytes(StandardCharsets.UTF_8), kd.getKdId().getBytes(StandardCharsets.UTF_8),kd.getAddress().getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public int deleteKdByKdId(String kdid) {
        String sql = "delete from t_k where KdId = ?";
        return jdbcTemplate.update(sql,kdid);
    }

}
