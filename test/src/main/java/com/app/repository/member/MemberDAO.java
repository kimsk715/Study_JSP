package com.app.repository.member;

import org.apache.ibatis.session.SqlSession;

import com.app.domain.vo.MemberVO;
import com.app.mybatis.config.MyBatisConfig;

public class MemberDAO {
public SqlSession sqlSession;
	
	public MemberDAO() {
//		auto commit
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	
	public void insert(MemberVO memberVO) {
		sqlSession.selectOne("member.insert", memberVO);
	}
}
