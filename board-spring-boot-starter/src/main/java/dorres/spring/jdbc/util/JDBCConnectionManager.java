package dorres.spring.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
//커넥션 관련 정보를 관리하는 클래스

//	JDBCConnectionManager 클래스는 특정 데이터베이스와 커넥션을 관리하기 위한 멤버 변수를 가지고 있으며
//	멤버 변수에 값을 설정하는 Setter와 커넥션 객체를 리턴하는 getConnection()메소드가 있다.
public class JDBCConnectionManager {
	private String driverClass;
	private String url;
	private String username;
	private String password;
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Connection getConnection() {
		try {
			Class.forName(driverClass);
			return DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String toString() {
		return "JDBCConnectionManager [driverClass=" + driverClass + ", url=" + url + ", username=" + username
				+ ", password=" + password + "]";
	}
	
}
