package com.app.repository.post;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.app.configuration.Configuration;
import com.app.domain.dto.PostDTO;
import com.app.domain.vo.MemberVO;
import com.app.domain.vo.PostVO;

public class PostDAO {
   private Connection connection;
   private PreparedStatement preparedStatement;
   private ResultSet resultSet;
   
//   추가하기
   public void insert(PostVO postVO) {
      String query = "INSERT INTO TBL_POST "
            + "(ID, POST_TITLE, POST_CONTENT, MEMBER_ID) "
            + "VALUES(SEQ_POST.NEXTVAL, ?, ?, ?)";
      
      connection = Configuration.getConnection();
      try {
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, postVO.getPostTitle());
         preparedStatement.setString(2, postVO.getPostContent());
         preparedStatement.setLong(3, postVO.getMemberId());
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException();
         }
      }
   }

//   조회하기
   public Optional<PostDTO> selectById(Long id) {
      PostDTO post = null;
      String query = "SELECT "
            + "P.ID, P.POST_TITLE, P.POST_CONTENT, P.POST_READ_COUNT, P.CREATED_DATE, P.UPDATED_DATE, "
            + "P.MEMBER_ID, M.MEMBER_NAME "
            + "FROM TBL_MEMBER M "
            + "JOIN TBL_POST P "
            + "ON M.ID = P.MEMBER_ID AND P.ID = ?";
      
      connection = Configuration.getConnection();
      try {
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setLong(1, id);
         resultSet = preparedStatement.executeQuery();
         
         if(resultSet.next()) {
            post = new PostDTO();
            
            post.setId(resultSet.getLong(1));
            post.setPostTitle(resultSet.getString(2));
            post.setPostContent(resultSet.getString(3));
            post.setPostReadCount(resultSet.getInt(4));
            post.setCreatedDate(resultSet.getString(5));
            post.setUpdatedDate(resultSet.getString(6));
            post.setMemberId(resultSet.getLong(7));
            post.setMemberName(resultSet.getString(8));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            if (resultSet != null) {
               resultSet.close();
            }
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException();
         }
      }
      
      return Optional.ofNullable(post);
   }
   
   
//   수정하기
   	public void update(PostVO postVO){
   		String query = "UPDATE TBL_POST "
   				+ "SET POST_TITLE=?, POST_CONTENT=?, UPDATED_DATE=SYSDATE "
   				+ "WHERE ID= ?";
   		
   		connection = Configuration.getConnection();
   		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, postVO.getPostTitle());
			preparedStatement.setString(2, postVO.getPostContent());
			preparedStatement.setLong(3,postVO.getId());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
   		
   	}
   
//   삭제하기
   	
   	public void delete(Long id) {
   		String query = "DELETE FROM TBL_POST "
   				+ "WHERE ID = ? ";
   		
   		connection = Configuration.getConnection();
   		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			try {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
   		
   	}
//   전체 조회하기
   	public ArrayList<PostDTO> selectAll() {		
		String query = "SELECT "
	            + "P.ID, P.POST_TITLE, P.POST_CONTENT, P.POST_READ_COUNT, P.CREATED_DATE, P.UPDATED_DATE, "
	            + "P.MEMBER_ID, M.MEMBER_NAME "
	            + "FROM TBL_MEMBER M "
	            + "JOIN TBL_POST P "
	            + "ON M.ID = P.MEMBER_ID";
				
		PostDTO post = null;
		ArrayList<PostDTO> posts = new ArrayList<PostDTO>();
		
		connection = Configuration.getConnection();
		try {
		preparedStatement = connection.prepareStatement(query);
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			post = new PostDTO();
			
			post.setId(resultSet.getLong("ID"));
            post.setPostTitle(resultSet.getString("POST_TITLE"));
            post.setPostContent(resultSet.getString("POST_CONTENT"));
            post.setPostReadCount(resultSet.getInt("POST_READ_COUNT"));
            post.setMemberId(resultSet.getLong("MEMBER_ID"));
            post.setCreatedDate(resultSet.getString("CREATED_DATE"));
            post.setUpdatedDate(resultSet.getString("UPDATED_DATE"));
            post.setMemberName(resultSet.getString("M.MEMBER_NAME"));
            
            posts.add(post);
;		}
			
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
					}
				if(preparedStatement != null) {
					preparedStatement.close();
					}
				if(connection!=null) {
					connection.close();
					} 
				}
			catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
		}
			return posts;
		
	}
   	
   	public PostVO selectByMemberIdAndPostId(Long postId, Long memberId) {
   		String query = "SELECT * "
   				+ "FROM TBL_POST "
   				+ "WHERE ID = ? AND MEMBER_ID = ?";
   		connection = Configuration.getConnection();
   		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, postId);
			preparedStatement.setLong(2, memberId);
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			try {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
   		
   		return null;
   	}
   	
}

























