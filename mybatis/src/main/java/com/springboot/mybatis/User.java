package com.springboot.mybatis;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author lizq
 * @date 2019/03/18 20:56 
 */
@Data
@ToString
public class User {
	private Integer id;
	private String name;
	private Date birth;
}
