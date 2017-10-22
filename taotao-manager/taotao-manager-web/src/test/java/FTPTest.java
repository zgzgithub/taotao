import java.io.File;
import java.io.FileInputStream;

import com.taotao.common.utils.FtpUtil;
import org.junit.Test;



public class FTPTest {

	@Test
	public void testFtpUtil() throws Exception {
//		上传
		FileInputStream inputStream = new FileInputStream(new File("D:\\Yosemite.jpg"));
		FtpUtil.uploadFile("192.168.190.128", 21, "uftp", "a63886148", "/home/uftp/image", "/2015/09/04", "hello.jpg", inputStream);
//		下载
//		FtpUtil.downloadFile("192.168.190.128",21,"uftp","a63886148","/home/uftp/image","hello1.jpg","D:\\");
	}
}
