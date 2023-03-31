package Com.Example;

import org.springframework.jdbc.core.JdbcTemplate;

public class AgentsDoa {
	JdbcTemplate jdbcTemplate;
	public void setjdbcTemplate(JdbcTemplate jdbcTemplate) //JdbcTemplate method/connection
	{
		this.jdbcTemplate=jdbcTemplate;
		
	}
	
	public int saveAgents(Agents a) // Insert  method
	{
		String query="insert into Agents values('"+a.getId()+"','"+a.getName()+"','"+a.getSalary()+"')";
		return jdbcTemplate.update(query);
		
	}
	
	public int updateAgents(Agents a) // update method
	{
		String query="update Agents set salary='"+a.getSalary()+"'where id='"+a.getId()+"'";
		return jdbcTemplate.update(query);
		
	}
	public int deleteAgents(Agents a)  // delete method
	{
		String query="delete from Agents where id='"+a.getId()+"'";
		return jdbcTemplate.update(query);
		
	}

}