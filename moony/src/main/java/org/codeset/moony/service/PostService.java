package org.codeset.moony.service;

import java.util.List;

import org.codeset.moony.bean.Post;
import org.codeset.moony.dao.PostDao;

public class PostService {
	public List<Post> getPosts() {
		PostDao postDao = new PostDao();
		List<Post> list = postDao.getPosts();
		return list;
	}
}
