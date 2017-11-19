package sample;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Compress {

	/**
	 * 7-zipのコマンドラインツール
	 */
    private static final Path sevenZipTool  = Paths.get("C:\\Program Files\\7-Zip\\7z.exe");

    /**
     * 圧縮を行う。
     * @param srcFiles 圧縮対象ファイル
     * @param archive  アーカイブファイル
     */
    public static void execute(List<Path> srcFiles,Path archive)
    {
         // 圧縮コマンドを取得する。
        List<String> unZipCmd = getZipCommand(srcFiles,archive);

        // 外部コマンドを実行する。
        ExternalCommand.run(unZipCmd);
    }

    /**
     * 圧縮コマンドを取得する
     *
     * @param srcFiles 圧縮するファイル
     * @param archive  圧縮先のアーカイブ
     * @return         解凍コマンドリスト
     */
    private static List<String> getZipCommand(List<Path> srcFiles,Path archive)
    {
        final String ADD = "a";
        final String DELETE_FILES_AFTER_COMPRESSION = "-sdel";

        List<String> cmd = new ArrayList<>();

        cmd.add(sevenZipTool.toString());        // 7-zipのコマンドラインツール
        cmd.add(ADD);                              // ファイルをアーカイブに追加する
        cmd.add(DELETE_FILES_AFTER_COMPRESSION);   // 圧縮後に圧縮元ファイルを削除する
        cmd.add(archive.toString());               // 圧縮先のアーカイブ
        for(Path file : srcFiles){
            cmd.add(file.toString());              // 圧縮するファイル
        }
        return cmd;
    }
}