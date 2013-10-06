package org.codeset.moony.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.codeset.moony.bean.Post;
import org.codeset.moony.db.PoolUtil;

public class PostDao {
	public List<Post> getPosts() {
		List<Post> list = new ArrayList<Post>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = PoolUtil.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from cs_posts");
			while (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				Post p = new Post();
				p.setTitle(title);
				p.setContent(content);
				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != stmt) {
					stmt.close();
				}
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
