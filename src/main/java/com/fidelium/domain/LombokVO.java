package com.fidelium.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Builder;

import java.util.Date;

/**
 * Created by Administrator on 2017-11-15.
 */

@Data
@Getter
@Setter
@Builder
public class LombokVO {

    private long no;

    private String subject;

    private String text;

    private String link;

    private Date date;

}
