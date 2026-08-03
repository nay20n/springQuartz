package com.ny.quartz;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 이 테스트는 스프링과 함께 실행하겠다는 선언.
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class DataSourceTest {
	@Autowired
	DataSource ds; // root-context.xml에 등록한 dataSource 빈을 필드에 자동 주입.
	
	@Test
	public void testConnection() {
		
		try(Connection conn  = ds.getConnection()){
			System.out.println("DB에 접속됨 : " + conn != null);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
