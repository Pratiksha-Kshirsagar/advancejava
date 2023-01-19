package tester;

import java.sql.SQLException;
import java.util.List;

import com.dal.BankDalImp;
import com.pojo.Bank;
//import com.pojo.Book;
import com.util.DBUtil;

public class Test_CRUD_Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DBUtil.openConnection();
			
			BankDalImp bankDal = new BankDalImp();
			List<Bank> list = bankDal.getallbank();
			list.forEach(b -> System.out.println(b));
			
			Bank b=new Bank("sbi", "saving", "alandi");
			  int i=bankDal.updateacc(b);
				if(i>0)
				{
					System.out.println("Updated");
				}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
