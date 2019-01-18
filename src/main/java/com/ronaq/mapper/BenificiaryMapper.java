package com.ronaq.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ronaq.model.Benificiary;

public class BenificiaryMapper implements RowMapper<Benificiary>{

	public Benificiary mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Benificiary benificiary = new Benificiary();
		benificiary.setId(rs.getInt("id"));
		benificiary.setName(rs.getString("name"));
		benificiary.setAccountno(rs.getString("accountno"));
		benificiary.setAcctype(rs.getString("acctype"));
		benificiary.setBranch(rs.getString("branch"));
	    return benificiary;
	}

}
