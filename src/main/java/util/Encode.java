package util;

import java.security.MessageDigest;
import org.apache.tomcat.util.codec.binary.Base64;

public class Encode {
	// md5
	//sha-1 => Thường dược sử dụng
	
	public static String toSHA1(String str) {
		String salt = "gfwerfgdsgsd;fsafdffdsds"; // Tạo mã phía sau mật khẩu để encode
		String result = null;
		
		str += salt;
		
		try {
			byte[] dataTypes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataTypes));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
