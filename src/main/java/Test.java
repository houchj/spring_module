import java.io.UnsupportedEncodingException;

import org.springframework.web.util.UriUtils;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println("test");
		String encoded = UriUtils.encode("http://68.2.93.93:9999/sap/rmr/x.224%2050%20JHP%20Pld.jpg", "UTF-8");
		System.out.println("encoded is " + encoded);
		
		String decoded = UriUtils.decode("http://68.2.93.93:9999/sap/rmr/x.224%2050%20JHP%20Pld.jpg", "UTF-8");
		System.out.println("decoded is " + decoded);

		encoded = UriUtils.encode(decoded, "UTF-8");
		System.out.println("encoded again is " + encoded);

		
	}

}
