package my.study.ch6.advice.myexample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import my.study.ch6.advice.myexample.bean.MonitorSettingPeer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public class MonitorSettingDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MonitorSettingPeer searchByKey(String monitorName) {
		String sql = "SELECT ID, MONITOR_NAME, MONITOR_FLG FROM T_MONITOR_SETTING WHERE MONITOR_NAME=?";
		final MonitorSettingPeer peer = new MonitorSettingPeer();
		jdbcTemplate.query(sql, new Object[] {monitorName}, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				peer.setId(rs.getInt("id"));
				peer.setMonitor_flg(rs.getInt("monitor_flg"));
				peer.setMonitor_name(rs.getString("monitor_name"));
			}
		});
		return peer;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
