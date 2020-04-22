package com.niit.vhr.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class HrRole implements Serializable {
    private Integer id;

    private Integer hrid;

    private Integer rid;
}
