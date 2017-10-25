package top.qiaojianyong.findcopy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FIndUpdate {

	// public static Pattern FILE_PATTERN = Pattern.compile("[\\\\/:*?\"<>|]");
	//	private static Pattern KEY_PATTERN = Pattern.compile("\\w+:\\w+:\\w+");
	private static String path = "C:\\_QJY\\MyDevelop\\MyJavaEE\\ttshop2";;

	public static void main(String[] args) throws Exception {
		System.out.println("start");
		System.out.println(path.replace("ttshop2", "ttshop2\\update"));
		findUpdate(new File(path));
		//print.close();
		System.out.println("end");
	}

	//一边找一边打印,驴推磨
	public static void findUpdate(File file) throws IOException {
		if (file != null)
			if (file.isFile()) {
				File newFile = new File(file.getAbsolutePath().replace("ttshop2", "ttshop2\\update"));
				PrintWriter print = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newFile), "utf-8"),
						true);
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line;
				boolean flag = false;
				while ((line = br.readLine()) != null) {
					print.println(line.replace("qiaojianyong", "qjyoung"));
				}
				if (flag) {
					print.println(file.getName());
				}
				br.close();
				print.close();
			} else {
				File newDir = new File(file.getAbsolutePath().replace("ttshop2", "ttshop2\\update"));
				if (!newDir.exists()) {
					newDir.mkdirs();
				}
				for (File f : file.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return !name.equals(".project") && !name.equals(".classpath") && !name.equals(".settings")
								&& !name.equals("target") && !name.equals("update"); // exclude
					}
				})) {
					findUpdate(f);
				}
			}
	}
}
