package sample;

import static java.lang.System.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CyclicBarrier;

/**
 * ファイルコピーを行うワーカースレッド
 * @author nakam
 *
 */
public class CopyFile implements Runnable {

	/** 担当する帳票 */
	private Report report;

	/** 対象期間 */
	private ConcurrentLinkedQueue<LocalDate> dateQueue;

	/** WORKフォルダ内の帳票ファイル */
	private ConcurrentSkipListSet<Path> reportPathSetInWorkDir;

	/** CyclicBarrierで同期を取る */
	private CyclicBarrier barrier;

	public CopyFile(Report report, ConcurrentLinkedQueue<LocalDate> dateQueue,ConcurrentSkipListSet<Path> reportPathSetInWorkDir, CyclicBarrier barrier) {
		this.report = report;
		this.dateQueue = dateQueue;
		this.reportPathSetInWorkDir = reportPathSetInWorkDir;
		this.barrier = barrier;
	}

	@Override
	public void run(){

		FilePath filePath = new FilePath();

		while(!dateQueue.isEmpty()){

			try {
				Path src = filePath.getReportPath(report.getConfigKey(), dateQueue.peek());
				Path dst = filePath.getWorkDirPath().resolve(src.getFileName());

				// WORKフォルダに帳票ファイルをコピーする
				Files.copy(src, dst);
				out.println(MessageFormat.format("ファイルをコピーしました。コピー元：{0} コピー先：{1}",src,dst));
				reportPathSetInWorkDir.add(dst);

				// サイクリックバリアを使って待機する
				barrier.await();
			} catch (IOException | InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}
}
