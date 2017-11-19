package sample;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

public class Status {

	/**
	 * 対象期間
	 */
	public ConcurrentLinkedQueue<LocalDate> dateQueue;

	/**
	 * WORKフォルダ内の帳票ファイル
	 */
	public ConcurrentSkipListSet<Path> reportPathSetInWorkDir;
}
