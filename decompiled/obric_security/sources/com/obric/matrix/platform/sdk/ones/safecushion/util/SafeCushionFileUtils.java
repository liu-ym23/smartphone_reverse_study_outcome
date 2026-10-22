package com.obric.matrix.platform.sdk.ones.safecushion.util;

import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.sdk.ones.safecushion.MatrixCushionManager;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: SafeCushionFileUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0004J \u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012J\"\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012J\b\u0010 \u001a\u0004\u0018\u00010\bJ\u0006\u0010!\u001a\u00020\u000eJ*\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/util/SafeCushionFileUtils;", "", "()V", "TAG", "", "createOrUpdateFile", "", "currentFile", "Ljava/io/File;", "updateFile", "createOrUpdateSafeCushionFile", "fileNamePrefix", "updateFileName", "deleteDir", "", "dir", "dirPath", "getCrashCount", "", "getCrashInfo", "Lorg/json/JSONObject;", "getCrashMsg", "getExistCrashInfoDir", "getExistNormalInfoDir", "getNormalFile", "getNormalFileCount", "getSafeCushionFile", "getSafeCushionSpiltFileName", "length", "spiltIndex", "getSpiltFileName", "file", "getTempCrashInfoFile", "isRepairNotFinish", "saveCrashInfo", "crashType", "crashMsg", "threadName", "crashCount", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SafeCushionFileUtils {
    public static final SafeCushionFileUtils INSTANCE = null;
    private static final String TAG = "SafeCushionFileUtils";

    static {
        INSTANCE = new SafeCushionFileUtils();
    }

    private SafeCushionFileUtils() {
    }

    public final File getExistCrashInfoDir() {
        File r0 = new File(MatrixCushionManager.Companion.getInstance().getContext().getFilesDir(), SafeCushionConstant.DIR_NAME);
        if (r0.isDirectory() == true) goto L6;
        deleteDir(r0);
    L6:
        if (r0.exists() == true) goto L8;
        r0.mkdir();
    L8:
        return r0;
    }

    public final File getSafeCushionFile(String r9) {
        Intrinsics.checkNotNullParameter(r9, "fileNamePrefix");
        File r1 = new File(MatrixCushionManager.Companion.getInstance().getContext().getFilesDir(), SafeCushionConstant.DIR_NAME);     // Catch: Exception -> L24
        if (r1.exists() == true) goto L6;
    L26:
        return null;
    L6:
        if (r1.isDirectory() == false) goto L26;
        File[] r2 = r1.listFiles();     // Catch: Exception -> L24
        boolean r3 = true;
        if (r2 != null) goto L10;
    L16:
        if (r3 == true) goto L26;
        Intrinsics.checkNotNullExpressionValue(r2, "crashFiles");     // Catch: Exception -> L24
        int r4 = r2.length;     // Catch: Exception -> L24
        int r5 = 0;
    L18:
        if (r5 >= r4) goto L26;
        File r6 = r2[r5];     // Catch: Exception -> L24
        String r7 = r6.getName();     // Catch: Exception -> L24
        Intrinsics.checkNotNullExpressionValue(r7, "it.name");     // Catch: Exception -> L24
        if (StringsKt.startsWith$default(r7, r9, false, 2, null) == true) goto L21;
        r5 = r5 + 1;
        goto L18
    L21:
        MLog.i$default(TAG, "getSafeModeFile: " + r6.getName(), null, 4, null);     // Catch: Exception -> L24
        return r6;
    L10:
        if (r2.length != 0) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == true) goto L16;
        r3 = false;
        goto L16
    L12:
        r8 = false;
    L24:
        e = move-exception;
        MLog.e(TAG, "getSafeCushion: error", e);
        goto L26
    }

    public final void createOrUpdateSafeCushionFile(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "fileNamePrefix");
        Intrinsics.checkNotNullParameter(r6, "updateFileName");
        MLog.i$default(TAG, "createOrUpdateSafeCushionFile fileNamePrefix:" + r5 + ",updateFileName:" + r6, null, 4, null);     // Catch: Exception -> L8
        File r7 = getSafeCushionFile(r5);     // Catch: Exception -> L8
        File r1 = new File(getExistCrashInfoDir(), r6);     // Catch: Exception -> L8
        if (r7 == null) goto L6;
        createOrUpdateFile(r7, r1);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        r1.createNewFile();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        MLog.e(TAG, "createOrUpdateSafeCushionFile: error", e);
    }

    public final void createOrUpdateFile(File r2, File r3) {
        Intrinsics.checkNotNullParameter(r2, "currentFile");
        Intrinsics.checkNotNullParameter(r3, "updateFile");
        if (r2.renameTo(r3) == true) goto L6;
        deleteDir(r2);
        r3.createNewFile();
        return;
    }

    public final String getSafeCushionSpiltFileName(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "fileNamePrefix");
        return getSpiltFileName(getSafeCushionFile(r2), r3, r4);
    L5:
        e = move-exception;
        MLog.e$default(TAG, "getSafeCushionSpiltFileName: " + e, null, 4, null);
        return null;
    }

    public final boolean isRepairNotFinish() {
        File r8 = getSafeCushionFile(SafeCushionConstant.SAFE_MODE_FLAG_FILE_NAME_PREFIX);
        if (r8 != null) goto L5;
    L16:
        return true;
    L5:
        if (r8.exists() == false) goto L16;
        String r9 = r8.getName();
        Intrinsics.checkNotNullExpressionValue(r9, "file.name");
        List r10 = StringsKt.split$default(r9, new String[]{"-"}, false, 0, 6, null);
        if (r10.size() != 4) goto L15;
        String r1 = (String) r10.get(1);
        String r11 = (String) r10.get(2);
        if (Intrinsics.areEqual("repair", r1) == false) goto L14;
        if (Intrinsics.areEqual(r11, SafeCushionConstant.FINISH_STATE) == true) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public final String getSpiltFileName(File r8, int r9, int r10) {
        if (r8 != null) goto L5;
    L10:
        return null;
    L5:
        if (r8.exists() == false) goto L10;
        String r11 = r8.getName();
        Intrinsics.checkNotNullExpressionValue(r11, "file.name");
        List r12 = StringsKt.split$default(r11, new String[]{"-"}, false, 0, 6, null);
        if (r12.size() != r9) goto L10;
        String r13 = (String) r12.get(r10);
        MLog.i$default(TAG, "getSpiltFileName: " + r13, null, 4, null);
        return r13;
    }

    public final void saveCrashInfo(String r3, String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "crashType");
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L7
        r0.put(SafeCushionConstant.KEY_CRASH_TYPE, r3);     // Catch: Exception -> L7
        r0.put(SafeCushionConstant.KEY_CRASH_MSG, r4);     // Catch: Exception -> L7
        r0.put(SafeCushionConstant.KEY_CRASH_COUNT, r6);     // Catch: Exception -> L7
        r0.put("thread", r5);     // Catch: Exception -> L7
        r0.put("timestamp", String.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L7
        File r2 = getSafeCushionFile(SafeCushionConstant.CRASH_INFO_FILE_NAME_PREFIX);     // Catch: Exception -> L7
        if (r2 == null) goto L12;
        String r7 = r0.toString();     // Catch: Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r7, "jsonObject.toString()");     // Catch: Exception -> L7
        FilesKt.writeText$default(r2, r7, null, 2, null);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        MLog.e(TAG, "saveCrashInfo:error", e);
    }

    public final String getCrashMsg() {
        JSONObject r2 = getCrashInfo();
        if (r2 == null) goto L5;
        Object r3 = r2.opt(SafeCushionConstant.KEY_CRASH_MSG);
    L7:
        if ((r3 instanceof String) == true) goto L9;
        return null;
    L9:
        return (String) r3;
    L5:
        r3 = null;
        goto L7
    }

    public final int getCrashCount() {
        JSONObject r2 = getCrashInfo();
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.optInt(SafeCushionConstant.KEY_CRASH_COUNT, 0);
    }

    public final JSONObject getCrashInfo() {
        JSONObject r2 = null;
        File r3 = getSafeCushionFile(SafeCushionConstant.CRASH_INFO_FILE_NAME_PREFIX);     // Catch: Exception -> L28
        if (r3 != null) goto L6;
    L7:
        File r4 = getTempCrashInfoFile();     // Catch: Exception -> L28
        if (r4 == null) goto L16;
        long r5 = r4.length();     // Catch: Exception -> L28
        if (r3 == null) goto L12;
        long r7 = r3.length();     // Catch: Exception -> L28
    L14:
        if (r5 <= r7) goto L16;
        r3 = r4;
        goto L16
    L12:
        r7 = 0;
    L16:
        if (r3 == null) goto L41;
        boolean r6 = true;
        String r8 = FilesKt.readText$default(r3, null, 1, null);     // Catch: Exception -> L28
        String r9 = r8;     // Catch: Exception -> L28
        if (r9 != null) goto L20;
    L23:
        if (r6 == true) goto L25;
        JSONObject r10 = new JSONObject(r8);     // Catch: Exception -> L28
    L26:
        r2 = r10;
        r2.put(SafeCushionConstant.KEY_CRASH_INFO_FILE_NAME, r3.getName());     // Catch: Exception -> L28
        goto L41
    L25:
        r10 = new JSONObject();     // Catch: Exception -> L28
        goto L26
    L20:
        if (r9.length() == 0) goto L23;
        r6 = false;
    L41:
        File r11 = getSafeCushionFile(SafeCushionConstant.SUPPOSE_CRASH_FILE_NAME_PREFIX);     // Catch: Exception -> L38
        if (r11 == null) goto L40;
        if (r2 != null) goto L36;
        r2 = new JSONObject();     // Catch: Exception -> L38
    L36:
        r2.put(SafeCushionConstant.KEY_SUPPOSE_CRASH_FILE_NAME, r11.getName());     // Catch: Exception -> L38
    L40:
        return r2;
    L38:
        e = move-exception;
        MLog.e(TAG, "getSupposeCrashInfo:error", e);
        goto L40
    L6:
        if (r3.length() >= 4) goto L16;
    L28:
        e = move-exception;
        MLog.e(TAG, "getCrashInfo:error", e);
        if (r2 != null) goto L41;
        r2 = new JSONObject();
        r2.put(SafeCushionConstant.KEY_CRASH_INFO_FILE_NAME, "getCrashInfo exception:" + e.getMessage());
        goto L41
    }

    public final File getExistNormalInfoDir() {
        File r0 = new File(MatrixCushionManager.Companion.getInstance().getContext().getFilesDir(), SafeCushionConstant.NORMAL_DIR_NAME);
        if (r0.isDirectory() == true) goto L6;
        deleteDir(r0);
    L6:
        if (r0.exists() == true) goto L8;
        r0.mkdir();
    L8:
        return r0;
    }

    public final File getNormalFile(String r9) {
        Intrinsics.checkNotNullParameter(r9, "fileNamePrefix");
        File r1 = new File(MatrixCushionManager.Companion.getInstance().getContext().getFilesDir(), SafeCushionConstant.NORMAL_DIR_NAME);     // Catch: Exception -> L24
        if (r1.exists() == true) goto L6;
    L26:
        return null;
    L6:
        if (r1.isDirectory() == false) goto L26;
        File[] r2 = r1.listFiles();     // Catch: Exception -> L24
        boolean r3 = true;
        if (r2 != null) goto L10;
    L16:
        if (r3 == true) goto L26;
        Intrinsics.checkNotNullExpressionValue(r2, "normalFiles");     // Catch: Exception -> L24
        int r4 = r2.length;     // Catch: Exception -> L24
        int r5 = 0;
    L18:
        if (r5 >= r4) goto L26;
        File r6 = r2[r5];     // Catch: Exception -> L24
        String r7 = r6.getName();     // Catch: Exception -> L24
        Intrinsics.checkNotNullExpressionValue(r7, "it.name");     // Catch: Exception -> L24
        if (StringsKt.startsWith$default(r7, r9, false, 2, null) == true) goto L21;
        r5 = r5 + 1;
        goto L18
    L21:
        MLog.i$default(TAG, "getNormalFile: " + r6.getName(), null, 4, null);     // Catch: Exception -> L24
        return r6;
    L10:
        if (r2.length != 0) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == true) goto L16;
        r3 = false;
        goto L16
    L12:
        r8 = false;
    L24:
        e = move-exception;
        MLog.e(TAG, "getNormalFile: error", e);
        goto L26
    }

    public final int getNormalFileCount(String r7) {
        Intrinsics.checkNotNullParameter(r7, "fileNamePrefix");
        File r0 = getNormalFile(r7);
        int r1 = 0;
        if (r0 != null) goto L5;
    L12:
        new File(getExistNormalInfoDir(), r7 + "-1-" + System.currentTimeMillis()).createNewFile();
        return 0;
    L5:
        if (r0.exists() == false) goto L12;
        String r2 = getSpiltFileName(r0, 3, 1);
        if (r2 == null) goto L10;
        r1 = Integer.parseInt(r2);
    L10:
        createOrUpdateFile(r0, new File(getExistNormalInfoDir(), r7 + '-' + (r1 + 1) + '-' + System.currentTimeMillis()));
        return r1;
    }

    public final File getTempCrashInfoFile() {
        File r8 = MatrixCushionManager.Companion.getInstance().getContext().getFilesDir();
        if (r8.exists() == true) goto L5;
    L12:
        return null;
    L5:
        if (r8.isDirectory() == false) goto L12;
        File[] r9 = r8.listFiles();
        Intrinsics.checkNotNullExpressionValue(r9, "file.listFiles()");
        File[] r10 = r9;
        int r0 = r10.length;
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L12;
        File r4 = r10[r3];
        String r5 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "it.name");
        if (StringsKt.startsWith$default(r5, SafeCushionConstant.TEMP_CRASH_INFO_FILE_NAME_PREFIX, false, 2, null) == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return r4;
    }

    public final boolean deleteDir(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dirPath");
        return deleteDir(new File(r2));
    }

    public final boolean deleteDir(File r7) {
        Intrinsics.checkNotNullParameter(r7, "dir");
        if (r7.isDirectory() == false) goto L15;
        String[] r0 = r7.list();
        if (r0 == null) goto L7;
        int r1 = r0.length;
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L15;
        if (deleteDir(new File(r7, r0[r3])) == false) goto L12;
        r3 = r3 + 1;
        goto L9
    L12:
        return false;
    L7:
        return r7.delete();
    L15:
        return r7.delete();
    }
}
