package my.study.ch6.advice.myexample.advice;

import java.util.Calendar;
import java.util.Date;

import my.study.ch6.advice.myexample.service.MonitorSettingService;
import my.study.ch6.proxy.PerformanceMonitor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;

public class MonitorInterceptor implements MethodInterceptor {
	
	private Date lastSearchTime;
	private boolean monitorAble;
	private int monitorSettingRefreshOffset = 30 * 1000;
	
	@Autowired
	private MonitorSettingService monitorService;
	
	public void init() {
		monitorAble = monitorService.isMonitorAble("monitor_prg_1");
		
		lastSearchTime = new Date(System.currentTimeMillis());
	}
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		if (lastSearchTime==null || Calendar.getInstance().getTimeInMillis() - lastSearchTime.getTime() > monitorSettingRefreshOffset) {
			init();
		}
		
		Object obj = null;
		if (monitorAble) {
			PerformanceMonitor.begin(mi.getClass().getName() + "."
					+ mi.getMethod().getName());
			obj = mi.proceed();
			PerformanceMonitor.end();
		} else {
			obj = mi.proceed();
		}
		
		return obj;
	}

	public MonitorSettingService getMonitorService() {
		return monitorService;
	}

	public void setMonitorService(MonitorSettingService monitorService) {
		this.monitorService = monitorService;
	}

}
