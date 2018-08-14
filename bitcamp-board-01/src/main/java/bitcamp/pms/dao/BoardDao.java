package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.pms.domain.Board;

public class BoardDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public BoardDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public List<Board> selectList(Map<String,Object> params) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("board.selectList", params);
        }        
    }
    
    public Board selectOne(String title) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) { 
            return sqlSession.selectOne("board.selectOne", title);
        }
    }
    
    public int update(Board board) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.update("board.update", board);
            sqlSession.commit();
            return count;
        }
    }
    
    public int delete(String title) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.delete("board.delete", title);
            sqlSession.commit();
            return count;
        }
    }
    
    public int insert(Board board) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int count = sqlSession.insert("board.insert", board);
            sqlSession.commit();
            return count;
        }
    }
    
}
