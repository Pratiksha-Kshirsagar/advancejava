package tester;
import static com.util.DBUtil.openConnection;
public class TestConnection {

	public static void main(String[] args) {
		
		try {
			openConnection();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
