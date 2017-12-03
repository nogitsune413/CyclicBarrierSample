package sample;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * バリアーアクションとして圧縮処理を行う。
 * @author nakam
 *
 */
public class BarrierAction implements Runnable {

	/** 対象期間 */
	private ConcurrentLinkedQueue<LocalDate> dateQueue;

	/** WORKフォルダ内の帳票ファイル */
	private ConcurrentSkipListSet<Path> reportPathSetInWorkDir;

	public BarrierAction(ConcurrentLinkedQueue<LocalDate> dateQueue, ConcurrentSkipListSet<Path> reportPathSetInWorkDir) {
		this.dateQueue = dateQueue;
		this.reportPathSetInWorkDir = reportPathSetInWorkDir;
	}

	@Override
	public void run() {

		if(!dateQueue.isEmpty()){

			// WORKフォルダにある帳票ファイルを圧縮し、アーカイブフォルダに保存する
			Compress.execute(new ArrayList<Path>(reportPathSetInWorkDir), new FilePath().getArchivePath(dateQueue.poll()));
			reportPathSetInWorkDir.clear();
		}
	}
}
