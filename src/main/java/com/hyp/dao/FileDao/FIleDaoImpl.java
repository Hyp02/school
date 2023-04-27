package com.hyp.dao.FileDao;

import com.hyp.pojo.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Han
 * @data 2023/4/15
 * @apiNode
 */
@Repository
public class FIleDaoImpl implements FIleDao {
    @Autowired
    JdbcTemplate jdbcTemplate;



    @Override
    public int saveFile(Integer id, String fileName, String fileType, String filePath) {
        String sql = "insert into files(id,fileName,fileType,filePath)" +
                "value(?,?,?,?)";
        return jdbcTemplate.update(sql, null, fileName,fileType,filePath);

    }

    @Override
    public List<Files> getAllFiles() {
        String sql = "select id,fileName,fileType,filePath from files";
        return jdbcTemplate.query(sql, (rs, row) -> {
            Files f = new Files();
            f.setId(rs.getInt("id"));
            f.setFileName(rs.getString("fileName"));
            f.setFileType(rs.getString("fileType"));
            f.setFilePath(rs.getString("filePath"));
            return f;

        });
    }

    @Override
    public int deleteByFileName(String fileName) {
        String sql = "delete from files where fileName = ?";
        return jdbcTemplate.update(sql,fileName);
    }


}
