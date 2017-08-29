import com.qfedu.house.cipher.ThyCipher;
import com.qfedu.house.cipher.ThyCiphers;

public class Test02 {

	public static void main(String[] args) {
		ThyCipher cipher = ThyCiphers.getThyCipher("rsa");
		String string = cipher.encodeString("123456");
		System.out.println(string);
		System.out.println(cipher.decodeString(string));
	}
}
