package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Bank;
import com.util.DBUtil;

public class BankDalImp implements BankDal {
	private Connection con;
	private Statement stmt;
	private ResultSet rset;
	private PreparedStatement pstmt1,pstmt2,pstmt3;
	
	
	public BankDalImp() throws SQLException {
		con=DBUtil.getCon();
		stmt=con.createStatement();
		
		pstmt1=con.prepareStatement("insert into bank values(?,?,?,?)");
		pstmt2=con.prepareStatement("update bank set acctype=? ,branch=? , where bankname=?");
		pstmt3=con.prepareStatement("delete from  bank  where bankname=?");	
		
		
	}

	
	public List<Bank> getallbank() {
		
		try {
		List<Bank> bk=new ArrayList<Bank>();	
		
	
			rset=stmt.executeQuery("select * from bank");
		
		while(rset.next())
		{
			bk.add(new Bank(rset.getString("bankname"),rset.getNString("acctype"),rset.getNString("branch")));
		}
		return bk;
		}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}
	

	@Override
	public int addacc(Bank obj) {
		try {
			
			pstmt1.setString(1, obj.getBankname());
			
			pstmt1.setString(2, obj.getAcctype());
			
			pstmt1.setString(3, obj.getBranch());
		
			int i=pstmt1.executeUpdate();//Write: Insert ,Update Delete
			System.out.println("---inserted obj:"+obj);
			return i;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateacc(Bank obj) {
		try {
			//add 1st  parameter to pstmt1 : 
			pstmt2.setString(1, obj.getBankname());
			//add 2  parameter to pstmt1 :
			pstmt2.setString(2, obj.getAcctype());
					 		
			pstmt2.setString(3, obj.getBranch());
			
			
			int i=pstmt2.executeUpdate();//Write: Insert ,Update Delete
			System.out.println("---updated obj:"+obj);
			return i;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteacc(String bankname) {
		try {
			pstmt3.setString(1, bankname);
			int i=pstmt3.executeUpdate();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	

}
