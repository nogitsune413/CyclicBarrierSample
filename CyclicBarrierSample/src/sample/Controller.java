package sample;

import java.nio.file.Path;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {

	public static void main(String[] args){

		LocalDate startDate = LocalDate.parse(args[0]);
		LocalDate endDate = LocalDate.parse(args[1]);

		if(startDate.isAfter(endDate)){
			throw new IllegalArgumentException(MessageFormat.format("開始日付が終了日付より後になっています。 開始日付:{0}  終了日付:{1}",startDate,endDate));
		}

		ConcurrentLinkedQueue<LocalDate> dateQueue = Util.createDateQueue(startDate,endDate);
		ConcurrentSkipListSet<Path> reportPathSetInWorkDir = new ConcurrentSkipListSet<Path>();

		CyclicBarrier barrier = new CyclicBarrier(Report.values().length, new BarrierAction(dateQueue,reportPathSetInWorkDir));

		ExecutorService service = Executors.newCachedThreadPool();

		for(Report report: Report.values()){
			service.submit(new CopyFile(report, dateQueue, reportPathSetInWorkDir, barrier));
		}
		service.shutdown();
	}
}
