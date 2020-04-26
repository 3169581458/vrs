package com.niit.vhr.model;

import lombok.Data;

import java.io.Serializable;

/**
 * hr_role
 * @author 
 */
@Data
public class HrRole implements Serializable {
    private Integer id;

    private Integer hrid;

    private Integer rid;
}
