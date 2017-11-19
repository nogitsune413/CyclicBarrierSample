package sample;

import static java.lang.System.*;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

/**
 * 外部コマンド
 * @author nakam
 *
 */
class ExternalCommand {

    /** 外部コマンドを呼び出す。
    *
    * @param command 呼び出すコマンド及びコマンド引数が格納されたリスト
    */
   public static void run(List<String> command)
   {
       ProcessBuilder pb = new ProcessBuilder(command); // コマンド実行用のプロセスを準備する。
       pb.inheritIO();                                   // 外部プログラムの入出力をJavaプロセスに統合する。

       try
       {
           Process proc = pb.start();     // コマンドを実行
           int exitCode = proc.waitFor(); // コマンドの終了を待機する。

           out.println(getResultMessage(command,exitCode)); // コマンドの実行結果を表示
       }
       catch(IOException | InterruptedException e)
       {
           e.printStackTrace();
       }
   }

    /** コマンドの実行結果を表す文字列を取得する。
     *
     * @param command 実行したコマンドを表す配列
     * @param exitCode 実行コマンドの終了コード
     * @return コマンドの実行結果を表す文字列
     */
    private static String getResultMessage(List<String> command, int exitCode)
    {
        final String SPACE = " "; // コマンドリストを区切る空白文字

        return MessageFormat.format("外部コマンド「{0}」を実行しました。終了コード:{1}",
        		                      String.join(SPACE,command),
        		                      exitCode);
    }
}