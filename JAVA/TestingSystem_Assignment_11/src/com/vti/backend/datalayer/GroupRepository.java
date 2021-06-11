package com.vti.backend.datalayer;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vti.entity.Group;
import com.vti.ultis.jdbcUltis;

public class GroupRepository {
	private jdbcUltis jdbc;

	public GroupRepository() throws FileNotFoundException, IOException {
		super();
		jdbc = new jdbcUltis();
	}

	public List<Group> GetlistGroup() throws ClassNotFoundException, SQLException {
		ArrayList<Group> groups = new ArrayList<Group>();

		String sql = "SELECT * FROM `Group`";

		ResultSet resultSet = jdbc.executeQuery(sql);

		while (resultSet.next()) {
			Group group = new Group(resultSet.getInt("GroupID"), resultSet.getString("GroupName"));
			groups.add(group);
		}
		jdbc.disConnection();
		return groups;
	}
}
