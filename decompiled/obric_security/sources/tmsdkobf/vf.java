package tmsdkobf;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Process;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.OfflineVideo;

/* JADX INFO: loaded from: classes5.dex */
public abstract class vf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f582a = "vf";

    static {
    }

    private static void a(OfflineVideo r13) {
        String r1 = r13.mPath;
        if (r1 != null) goto L5;
        return;
    L5:
        String r2 = a(r1);
        SQLiteDatabase r3 = SQLiteDatabase.openDatabase("/data/data/com.tencent.qqlive/databases/download_db", null, 0);
        if (r3 != null) goto L8;
        return;
    L8:
        Cursor r4 = r3.query("download_db", null, "recordid = ?", new String[]{r2}, null, null, null);
        if (r4 != null) goto L36;
    L31:
        r3.close();
        return;
    L36:
    L26:
        e = move-exception;
        q8.d(f582a, "fillQQLiveVideoInfo " + e.getMessage());     // Catch: Throwable -> L24
    L23:
        r4.close();
        goto L31
    L11:
        if (r4.moveToFirst() == false) goto L35;
        String r5 = r4.getString(r4.getColumnIndex("covername"));     // Catch: Throwable -> L24 Exception -> L26
        String r6 = r4.getString(r4.getColumnIndex("episodename"));     // Catch: Throwable -> L24 Exception -> L26
        long r7 = r4.getLong(r4.getColumnIndex("videosize"));     // Catch: Throwable -> L24 Exception -> L26
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L24 Exception -> L26
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        StringBuilder r9 = r8.append(r5);     // Catch: Throwable -> L24 Exception -> L26
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        r13.mTitle = r9.append(r6).toString();     // Catch: Throwable -> L24 Exception -> L26
        if (r7 <= 0) goto L22;
        r13.mDownProgress = (int) ((r13.mSize * 100) / r7);     // Catch: Throwable -> L24 Exception -> L26
        goto L35
    L22:
        r13.mDownProgress = -1;     // Catch: Throwable -> L24 Exception -> L26
    L35:
    L24:
        th = move-exception;
        r4.close();
        throw th;
    }

    private static void b(OfflineVideo r13) {
        String r0 = r13.mPath;
        if (r0 != null) goto L5;
        return;
    L5:
        String[] r1 = a(r0).split("_");
        if (r1.length == 2) goto L8;
        return;
    L8:
        int r2 = 0;
        String r3 = r1[0];
        String r4 = r1[1];
        SQLiteDatabase r5 = SQLiteDatabase.openDatabase("/data/data/com.qiyi.video/databases/qyvideo.db", null, 0);
        if (r5 != null) goto L11;
        return;
    L11:
        Cursor r6 = r5.query("rc_tbl", null, "tvId = ?", new String[]{r4}, null, null, null);
        if (r6 != null) goto L30;
    L27:
        r5.close();
        return;
    L30:
    L23:
        th = move-exception;
        r6.close();
        throw th;
    L14:
        if (r6.moveToFirst() == false) goto L21;
        int r7 = r6.getColumnIndex("videoPlayTime");     // Catch: Throwable -> L23 Exception -> L29
        int r8 = r6.getColumnIndex("videoDuration");     // Catch: Throwable -> L23 Exception -> L29
        r6.moveToFirst();     // Catch: Throwable -> L23 Exception -> L29
        int r9 = r6.getInt(r7);     // Catch: Throwable -> L23 Exception -> L29
        int r10 = r6.getInt(r8);     // Catch: Throwable -> L23 Exception -> L29
        if (r9 != 0) goto L18;
        r13.mPlayProgress = 100;     // Catch: Throwable -> L23 Exception -> L29
        goto L26
    L18:
        if (r10 > 0) goto L20;
        r2 = -1;
        goto L21
    L20:
        r2 = (r9 * 100) / r10;     // Catch: Throwable -> L23 Exception -> L29
    L21:
        r13.mPlayProgress = r2;     // Catch: Throwable -> L23 Exception -> L29
    L26:
        r6.close();
        goto L27
    }

    private static void c(OfflineVideo r19) {
        String r4 = a(r19.mPath);
        if (r4 != null) goto L5;
        return;
    L5:
        SQLiteDatabase r5 = SQLiteDatabase.openDatabase("/data/data/com.sohu.sohuvideo/files/databases/sohutv.db", null, 0);
        if (r5 == null) goto L31;
        String r6 = "fillSohuVideoInfo ";
        Cursor r8 = r5.query("t_videodownload", null, "save_filename = ?", new String[]{r4}, null, null, null);
        if (r8 != null) goto L59;
        int r10 = 0;
        String r9 = null;
    L30:
        r5.close();
    L32:
        if (r9 == null) goto L65;
        if (r10 <= 0) goto L67;
        SQLiteDatabase r2 = SQLiteDatabase.openDatabase("/data/data/com.sohu.sohuvideo/files/databases/other.db", null, 0);
        if (r2 == null) goto L66;
        Cursor r7 = r2.query("sohu_video_history", null, "playId = ?", new String[]{r9}, null, null, null);
        if (r7 != null) goto L62;
    L51:
        r2.close();
        return;
    L62:
    L46:
        e = move-exception;
        q8.d(f582a, r6 + e.getMessage());     // Catch: Throwable -> L44
    L43:
        r7.close();
    L44:
        th = move-exception;
        r7.close();
        throw th;
    L40:
        if (r7.moveToFirst() == false) goto L42;
        int r0 = r7.getInt(r7.getColumnIndex("playedTime"));     // Catch: Throwable -> L44 Exception -> L46
        r19.mPlayProgress = (r0 * 100) / r10;     // Catch: Throwable -> L44 Exception -> L46
        q8.d(f582a, "play time " + r0);     // Catch: Throwable -> L44 Exception -> L46
    L61:
    L42:
        r19.mPlayProgress = 0;     // Catch: Throwable -> L44 Exception -> L46
        goto L61
    L66:
        return;
    L67:
        return;
    L65:
        return;
    L59:
    L23:
        e = e;
        r10 = 0;
        r9 = null;
    L25:
        q8.d(f582a, r6 + e.getMessage());     // Catch: Throwable -> L21
    L20:
        r8.close();
        goto L30
    L10:
        if (r8.moveToFirst() == false) goto L19;
        r9 = r8.getString(r8.getColumnIndex("play_id"));     // Catch: Throwable -> L21 Exception -> L23
        r10 = r8.getInt(r8.getColumnIndex("time_length"));     // Catch: Exception -> L17 Throwable -> L21
        r19.mTitle = r8.getString(r8.getColumnIndex("vd_titile"));     // Catch: Exception -> L15 Throwable -> L21
        r19.mDownProgress = r8.getInt(r8.getColumnIndex("download_percent"));     // Catch: Exception -> L15 Throwable -> L21
        q8.d(f582a, "" + r9 + " " + r10 + " " + r19.mTitle + " " + r19.mDownProgress);     // Catch: Exception -> L15 Throwable -> L21
    L15:
        e = e;
    L17:
        e = e;
        r10 = 0;
        goto L25
    L19:
        r10 = 0;
        r9 = null;
    L21:
        th = move-exception;
        r8.close();
        throw th;
    L31:
        r6 = "fillSohuVideoInfo ";
        r10 = 0;
        r9 = null;
        goto L32
    }

    private static void d(OfflineVideo r2) {
        q8.d(f582a, r2.mPath);
    L17:
        e = move-exception;
        e.printStackTrace();
        q8.d(f582a, e.getMessage());
        return;
    L4:
        if ("qiyi".equals(r2.mAdapter) == false) goto L7;
        b(r2);     // Catch: Exception -> L17
    L20:
        return;
    L7:
        if ("qqlive".equals(r2.mAdapter) == false) goto L14;
        a(r2);     // Catch: Exception -> L17
        String r0 = r2.mTitle;     // Catch: Exception -> L17
        if (r0 != null) goto L11;
    L12:
        r2.mTitle = a(r2.mPath);     // Catch: Exception -> L17
        goto L20
    L11:
        if ("".equals(r0) == false) goto L20;
    L14:
        if ("sohu".equals(r2.mAdapter) == false) goto L20;
        c(r2);     // Catch: Exception -> L17
        goto L20
    }

    private static String a(String r2) {
        int r0 = r2.lastIndexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r0 > 0) goto L9;
        if (r0 >= (r2.length() - 1)) goto L9;
        return null;
    L9:
        return r2.substring(r0 + 1);
    }

    public static void a(String[] r3) {
        if (r3.length >= 1) goto L5;
        return;
    L5:
        q8.d(f582a, "uid " + Process.myUid());
        String r4 = r3[0];
        List<OfflineVideo> r0 = OfflineVideo.readOfflineVideos(r4);
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.size() == 0) goto L18;
        Iterator<OfflineVideo> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        d(r1.next());
        goto L12
    L14:
        OfflineVideo.dumpToFile(r0, r4);
        return;
    }
}
