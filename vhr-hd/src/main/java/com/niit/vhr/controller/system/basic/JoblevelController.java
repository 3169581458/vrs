package com.niit.vhr.controller.system.basic;

import com.niit.vhr.model.JobLevel;
import com.niit.vhr.model.RespBean;
import com.niit.vhr.service.system.basic.JoblevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ABC
 * @date 2020/4/27 10:47
 */
@RestController
@RequestMapping("/system/basic/joblevel")
@Api(value = "JobLevelController", tags = {"职称数据管理"})
public class JoblevelController {
    @Autowired
    JoblevelService jobLevelService;

    @GetMapping("/")
    @ApiOperation(value = "获取所有职称", notes = "所有职称信息列表", produces = "application/json")
    public RespBean getAllJobLevel() {
        List<JobLevel> jobLevels = jobLevelService.getAllJobLevel();
        return RespBean.ok("获取成功", jobLevels);
    }

    @PostMapping("/")
    @ApiOperation(value = "新增职称", notes = "根据传入的职称添加一个新职位")
    @ApiImplicitParam(name = "jobLevel", value = "jobLevel对象", required = true)
    public RespBean addPosition(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    @ApiOperation(value = "修改职称", notes = "传入职称信息进行更新修改" )
    public RespBean updatePosition(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevel(jobLevel) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除职称", notes = "根据 id 删除职称")
    public RespBean deletePosition(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevel(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    @ApiOperation(value = "批量删除职称", notes = "根据 id 数组删除职称" )
    @ApiImplicitParam(name = "ids", value = "id数组", required = true)
    public RespBean deletePosition(Integer[] ids) {
        if (jobLevelService.deleteJobLevel(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}

