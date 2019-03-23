package com.springboot.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author lizq
 * @date 2019/03/23 21:18 
 */
@Component
public class ScheduledTasks {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println("现在时间：" + dateFormat.format(new Date()));
	}

}
