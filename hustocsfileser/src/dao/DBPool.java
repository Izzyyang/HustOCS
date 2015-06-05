package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.beans.PropertyVetoException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBPool {
	private ComboPooledDataSource dataSource;

	private static class Holder {
		private static final DBPool instance = new DBPool();
	}

	public DBPool() {
		try {
			dataSource = new ComboPooledDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("root ");
			dataSource
					.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/hustocs?autoReconnect=true&useUnicode=true&characterEncoding=UTF8");
			dataSource.setDriverClass("com.mysql.jdbc.Driver ");
			dataSource.setInitialPoolSize(2);
			dataSource.setMinPoolSize(1);
			dataSource.setMaxPoolSize(16);
			dataSource.setMaxStatements(50);
			dataSource.setMaxIdleTime(60);
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
	}

	public static DBPool getInstance() {
		return Holder.instance;
	}

	public final Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("无法从数据源获取连接 ", e);
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			con = DBPool.getInstance().getConnection();
		} catch (Exception e) {
		} finally {
			if (con != null)
				con.close();
		}
	}
}
