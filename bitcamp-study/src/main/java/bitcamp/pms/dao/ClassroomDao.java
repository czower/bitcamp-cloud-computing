package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.pms.domain.Classroom;

public class ClassroomDao {
    
    SqlSessionFactory sqlsessionFactory;  
    
    public ClassroomDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlsessionFactory = sqlSessionFactory;
    }
    
    public List<Classroom> selectList(Map<String,Object> params) throws Exception {
        try ( SqlSession sqlSession = sqlsessionFactory.openSession()){
            return sqlSession.selectList("classroom.selectList", params);
        }
    }
    
    public Classroom selectOne(String title) throws Exception {
        try ( SqlSession sqlSession = sqlsessionFactory.openSession()){
            return sqlSession.selectOne("classroom.selectOne", title);
        }  
    }
    
    public int update(Classroom classroom) throws Exception {
        try ( SqlSession sqlSession = sqlsessionFactory.openSession()){
            return sqlSession.update("classroom.update", classroom);
        }
    }
    
    public int delete(int createNo) throws Exception {
        try ( SqlSession sqlSession = sqlsessionFactory.openSession()){
            int count = sqlSession.delete("classroom.delete", createNo);
            sqlSession.commit();
            return count;
        } 
    }
    
    public int insert(Classroom classroom) throws Exception {
        try ( SqlSession sqlSession = sqlsessionFactory.openSession()){
            int count = sqlSession.insert("classroom.insert", classroom);
            sqlSession.commit();
            return count;
        }
    }
}
