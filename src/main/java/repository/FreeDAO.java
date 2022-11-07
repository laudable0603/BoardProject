package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Free;

public class FreeDAO {

	private SqlSessionFactory factory;
	
	private static FreeDAO dao = new FreeDAO();
	private FreeDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static FreeDAO getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.free.";
	
	
	// 1. 게시글 목록
	public List<Free> selectAllFrees(){
		SqlSession ss = factory.openSession();
		List<Free> free = ss.selectList(mapper + "selectAllFrees");
		ss.close();
		return free;
	}
	
	//조회수
	/*
	 * public long hitCount(String hit) {
	 * 
	 * }
	 */
	
	// 게시글 삽입
	public int insertFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertFree", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 게시글 삭제
	public int deleteFree(int freeNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "deleteFree", freeNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	//게시글 상세
	public Free selectFreeByNo(int freeNo) {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne(mapper + "selectFreeByNo", freeNo);
		ss.close();
		return free;
	}
	//게시글 수정
	public int updateFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update(mapper + "updateFree", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public List<Free> selectFreeTop1(){
		SqlSession ss = factory.openSession();
		List<Free> top1 = ss.selectList(mapper + "selectFreeTop1");
		ss.close();
		return top1;
	}
	
}