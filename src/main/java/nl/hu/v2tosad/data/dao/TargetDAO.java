package nl.hu.v2tosad.data.dao;

import java.sql.Connection;

import nl.hu.v2tosad.data.model.BusinessRule;

public interface TargetDAO {
	
	public abstract void generateConstraint(BusinessRule br);
	
	public abstract void generateTrigger(BusinessRule br);
	
	public abstract Connection getConnection();

}
