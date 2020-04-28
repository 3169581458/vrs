package com.niit.vhr.service.system.basic;

import com.niit.vhr.mapper.JobLevelMapper;
import com.niit.vhr.model.JobLevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ABC
 * @date 2020/4/27 10:48
 */
@Service
public class JoblevelService {
    @Resource
    JobLevelMapper jobLevelMapper;

    public List<JobLevel> getAllJobLevel() {
        return jobLevelMapper.selectAllJobLevel();
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setEnabled(true);
        jobLevel.setCreatedate(new Date());
        return jobLevelMapper.insertSelective(jobLevel);
    }

    public Integer updateJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    public Integer deleteJobLevel(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }
    public Integer deleteJobLevel(Integer[] ids) {
        return jobLevelMapper.deleteByIds(ids);
    }
}
