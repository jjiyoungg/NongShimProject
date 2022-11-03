package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import model.DataSourceManager;



public class NongShimMemberDAO {
	private static NongShimMemberDAO instance=new NongShimMemberDAO();
	private DataSource dataSource;
	private NongShimMemberDAO() {
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static NongShimMemberDAO getInstance() {
		return instance;
	}
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException {
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close(); 
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException {
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public Connection getConnection() throws SQLException {
		 return dataSource.getConnection();
	}
	
	public NongShimMemberVO login(String id, String password) throws SQLException{
		NongShimMemberVO nongShimMemberVO=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select id,password,name from NongShim_Member where id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
			 nongShimMemberVO=new NongShimMemberVO(id,rs.getString(2),password);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return nongShimMemberVO;
	}	
	
	
	
}
