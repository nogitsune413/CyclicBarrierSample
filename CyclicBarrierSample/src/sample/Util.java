package sample;

import java.time.LocalDate;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Util {

	/**
	 * 対象日付のQueueを返す。
	 * @param startDate 開始日
	 * @param endDate   終了日
	 * @return 対象日付のQueue
	 */
	public static ConcurrentLinkedQueue<LocalDate> createDateQueue(LocalDate startDate, LocalDate endDate){

		ConcurrentLinkedQueue<LocalDate> queue = new ConcurrentLinkedQueue<LocalDate>();

		for(LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)){
			queue.add(date);
		}
		return queue;
	}
}
