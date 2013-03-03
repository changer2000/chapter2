package my.study.ch6.advice.myexample.service;

import my.study.ch6.advice.myexample.bean.MonitorSettingPeer;
import my.study.ch6.advice.myexample.dao.MonitorSettingDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorSettingService {
	
	@Autowired
	private MonitorSettingDAO monitorSettingDao;
	
	public boolean isMonitorAble(String monitorName) {
		MonitorSettingPeer peer = monitorSettingDao.searchByKey(monitorName);
		if (peer!=null && peer.getMonitor_flg()!=null && 1==peer.getMonitor_flg().intValue()) {
			return true;
		}
		return false;
	}

	public MonitorSettingDAO getMonitorSettingDao() {
		return monitorSettingDao;
	}

	public void setMonitorSettingDao(MonitorSettingDAO monitorSettingDao) {
		this.monitorSettingDao = monitorSettingDao;
	}
	
}
