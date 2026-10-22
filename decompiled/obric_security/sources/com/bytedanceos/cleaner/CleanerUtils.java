package com.bytedanceos.cleaner;

import android.content.Context;
import android.os.SystemClock;
import android.widget.Toast;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CleanerUtils {
    private static final String BIG_FILE_SCANNING_STATE = "BigFileScanningState";
    private static boolean DBG = false;
    private static final int DELETE_FILES_NUMBER_BEFORE_SLEEP = 50;
    private static final long DELETE_FILES_TIME_BEFORE_SLEEP = 500;
    private static final long DIR_SIZE = 4096;
    private static final boolean FAKE_DELETE = false;
    public static final String FROM_CLEAR_DETIAL = "from_detial";
    public static final String HAS_CLEAN_ALL = "clean_all";
    public static final long NOUSE_SIZE = 32768;
    private static final long SLEEP_TIME_DURING_DELETION = 20;
    public static final int STATUS_ALLCLEAN = 5;
    public static final int STATUS_CLEANNED = 4;
    public static final int STATUS_CLEANNING = 3;
    public static final int STATUS_IDLE = 0;
    public static final int STATUS_SCANNED = 2;
    public static final int STATUS_SCANNING = 1;
    public static final String TAG = "CleanerUtils";
    public static final String TRASH_TYPE = "mtype";
    private static String mOldMsg = null;
    private static long mOneTime = 0;
    protected static Toast mToast = null;
    private static long mTwoTime = 0;
    private static int sDeletedFiles = 0;
    private static long sLastSleepTime = -1;

    static {
    }

    public CleanerUtils() {
    }

    public static String formatFileSize(Context context, long size, boolean seperate) {
        ByteUnitPair r0 = ByteConverter.convert(size, "B", 1000);
        return r0.getValue() + r0.getUnit();
    }

    public static void showToast(Context context, String s) {
        if (mToast != null) goto L5;
        Toast r2 = Toast.makeText(context, s, 0);
        mToast = r2;
        r2.show();
        mOneTime = System.currentTimeMillis();
    L11:
        mOneTime = mTwoTime;
        return;
    L5:
        mTwoTime = System.currentTimeMillis();
        if (s.equals(mOldMsg) == true) goto L8;
        mOldMsg = s;
        mToast.setText(s);
        mToast.show();
        goto L11
    L8:
        if ((mTwoTime - mOneTime) <= 0) goto L11;
        mToast.show();
        goto L11
    }

    public static void showToast(Context context, int resId) {
        showToast(context, context.getString(resId));
    }

    public static void showErrorToast(Context context, int error) {
        if (error != (-4)) goto L5;
        showToast(context, R.string.error_4);
        return;
    L5:
        if (error != (-3)) goto L7;
        showToast(context, R.string.error_3);
        return;
    L7:
        if (error != (-2)) goto L9;
        showToast(context, R.string.error_2);
        return;
    L9:
        if (error == (-1)) goto L11;
        showToast(context, R.string.error_other);
        return;
    L11:
        showToast(context, R.string.error_1);
    }

    public static long deleteFile(File file, FileFilter filter, FileDeleteListener listener, boolean includeRoot) {
        long r0 = 0;
        if (file != null) goto L5;
        return 0;
    L5:
        if (file.exists() == false) goto L29;
    L21:
        th = move-exception;
        th.printStackTrace();
        OLog.e(TAG, " deleteFile error , might cause by too deep dir layer :" + th.getMessage() + " using file:" + file);
        return 0;
    L8:
        if (file.isDirectory() == false) goto L19;
        File[] r2 = file.listFiles(filter);     // Catch: Throwable -> L21
        if (r2 != null) goto L12;
    L17:
        if (includeRoot == false) goto L27;
        long r1 = r0 + 4096;     // Catch: Throwable -> L21
        deleteSingleFile(file, listener, 4096);     // Catch: Throwable -> L21
        return r1;
    L27:
        return r0;
    L12:
        if (r2.length <= 0) goto L17;
        int r3 = r2.length;     // Catch: Throwable -> L21
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L17;
        r0 = r0 + deleteFile(r2[r4], filter, listener, true);     // Catch: Throwable -> L21
        r4 = r4 + 1;     // Catch: Throwable -> L21
        goto L15
    L19:
        long r5 = file.length();     // Catch: Throwable -> L21
        long r6 = 0 + r5;     // Catch: Throwable -> L21
        deleteSingleFile(file, listener, r5);     // Catch: Throwable -> L21
        return r6;
    L29:
        return 0;
    }

    private static void deleteSingleFile(File file, FileDeleteListener listener, long size) {
        file.delete();
        if (listener == null) goto L5;
        listener.onFileDeleted(size);
    L5:
        int r0 = sDeletedFiles + 1;
        sDeletedFiles = r0;
        if (r0 >= 50) goto L8;
        return;
    L8:
        if ((SystemClock.elapsedRealtime() - sLastSleepTime) > 500) goto L10;
    L15:
        sDeletedFiles = 0;
        return;
    L10:
        if (DBG == false) goto L18;
        OLog.d(TAG, "need to sleep for a while");
    L18:
        Thread.sleep(SLEEP_TIME_DURING_DELETION);     // Catch: Exception -> L17
    L14:
        sLastSleepTime = SystemClock.elapsedRealtime();
        goto L15
    }

    public static long deleteFiles(Context context, List<String> filePaths, FileDeleteListener listener, FileFilter filter, boolean excludeRoot) {
        if (DBG == false) goto L5;
        OLog.i(TAG, " deleteFiles start :" + filePaths);
    L5:
        long r1 = 0;
        if (filePaths != null) goto L8;
    L29:
        if (listener == null) goto L31;
        listener.onDeleteFinish(0);
    L31:
        return 0;
    L8:
        if (filePaths.size() == 0) goto L29;
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L26
        Iterator<String> r8 = filePaths.iterator();     // Catch: Throwable -> L26
    L12:
        if (r8.hasNext() == false) goto L20;
        String r5 = r8.next();     // Catch: Throwable -> L26
        boolean r7 = false;
        if (r5.endsWith("/*") == false) goto L16;
        r5 = r5.substring(0, r5.length() - 2);     // Catch: Throwable -> L26
    L16:
        File r6 = new File(r5);     // Catch: Throwable -> L26
        if (excludeRoot == true) goto L19;
        r7 = true;
    L19:
        r1 = r1 + deleteFile(r6, filter, listener, r7);     // Catch: Throwable -> L26
        goto L12
    L20:
        if (listener == null) goto L22;
        listener.onDeleteFinish(r1);     // Catch: Throwable -> L26
    L22:
        System.currentTimeMillis();     // Catch: Throwable -> L26
        if (DBG == false) goto L28;
        OLog.i(TAG, " deleteFiles end costing total time :" + (System.currentTimeMillis() - r3) + " millsecs");     // Catch: Throwable -> L26
    L28:
        return r1;
    L26:
        th = move-exception;
        th.printStackTrace();
        OLog.e(TAG, " deleteFiles error , might cause by too deep dir layer :" + th.getMessage() + " using file:" + filePaths);
        goto L28
    }
}
