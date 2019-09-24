package com.xu.springbootdemo.entity;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//Spring的注解形式：@Repository、@Service、@Controller，它们分别对应存储层Bean，业务层Bean，和展示层Bean。
//@Repository注解便属于最先引入的一批，它用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean
@Repository
public class TestDB_getUsername {
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	JdbcTemplate db1;
	public  String getUserName(String oaUsername){
		//DataSource ds=new DataSourceConfig().primaryDataSource();
		String datamap_username="";
		String get_sql="select login_name from SYS_PORTAL_APPLICATION_USER "
				+ "where app_id='10180' and card_no=(select distinct card_no  from SYS_PORTAL_APPLICATION_USER where app_id='10040' "
				+ "and login_name ='"+oaUsername+ "')";
		
		System.out.println("执行语句\n"+get_sql);
		//ResultSet rs =m.getReslut(get_sql);
		
		List<Map<String, Object>> resultList = db1.queryForList(get_sql);
		//SqlRowSet rs= db1.queryForRowSet(get_sql);
		Map<String, Object> map = null;
		for (int i = 0; i < resultList.size(); i++) {
			map = resultList.get(i);
			System.out.println(map.get("login_name"));

		}
		
		//datamap_username=rs.getString("login_name");//rs.getvalue(rs, "login_name");
		return datamap_username;
	}

	

}



