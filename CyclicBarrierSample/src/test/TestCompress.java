package test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import sample.Compress;

public class TestCompress {

	/**
	 * 圧縮をテストする
	 * @param args
	 */
	public static void main(String[] args){

		final Path archive = Paths.get("C:\\test\\archive\\archive_20171001");

		List<Path> srcFiles = new ArrayList<>();
		srcFiles.add(Paths.get("C:\\test\\work\\coupon_20171001.csv"));
		srcFiles.add(Paths.get("C:\\test\\work\\sales_20171001.csv"));
		srcFiles.add(Paths.get("C:\\test\\work\\stock_20171001.csv"));

		Compress.execute(srcFiles, archive);
	}
}
