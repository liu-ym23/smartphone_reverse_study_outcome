package com.bytedance.article.common.monitor.backfetch;

import a.a;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.PermissionUtils;
import com.bytedance.article.common.monitor.file.FileUploadManager;
import com.bytedance.librarian.LibrarianImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class SDCardDirFetch {
    public static final String SD_CARD_DIR_BACK_TYPE = "sd_card_dir_back";
    private static long lastFetchTime;

    public SDCardDirFetch() {
    }

    private static boolean copyFiles(Context r3) {
        boolean r0 = writeSDCardInfo(r3);
        if (r0 == true) goto L5;
        return r0;
    L5:
        boolean r1 = writeAppDataInfo(r3);
        if (r1 == true) goto L8;
        return r1;
    L8:
        StringBuilder r2 = new StringBuilder();
        r2.append(FileUtils.getExternalRootDir(r3).getAbsolutePath());
        String r4 = File.separator;
        r2.append(r4);
        r2.append("backfetch");
        r2.append(r4);
        r2.append("sdcardinfo");
        File r5 = new File(a.o(r2, r4, "tmp"));
        FileUtils.compress(r5.getParentFile().getAbsolutePath() + r4 + generateUploadFileName(), new String[]{r5.getAbsolutePath()});     // Catch: Exception -> L12
        FileUtils.removeDir(r5.getAbsolutePath());
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static String generateUploadFileName() {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String r1 = FetchUtils.getVersionName(ApmContext.getHeader());
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return a.j(r0.format(new Date(System.currentTimeMillis())), "_sdcardinfo.zip");
    L7:
        return r0.format(new Date(System.currentTimeMillis())) + "_sdcardinfo_" + r1 + ".zip";
    }

    @Deprecated
    public static void getDeptTree(File r7, String r8, int r9, BufferedWriter r10) {
        if (r7.isDirectory() == false) goto L5;
        File[] r11 = r7.listFiles();
        int r0 = 0;
    L11:
        if (r0 >= r11.length) goto L40;
        if (r9 > 0) goto L14;
        String r4 = "";
        String r5 = "";
    L20:
        if (r11[r0].getName().startsWith(LibrarianImpl.Constants.DOT) == true) goto L28;
        if (r11[r0].canRead() == false) goto L28;
        StringBuilder r6 = a.q(r5);
        r6.append(r11[r0].getName());
        r10.write(r6.toString());
        if (r11[r0].isDirectory() == true) goto L26;
        r10.write("(size: " + FileUtils.getFormatSize(r11[r0].length()) + ")");
    L26:
        r10.newLine();
    L28:
        if (r11[r0].isDirectory() == false) goto L32;
        if (r11[r0].getPath().indexOf("/.") != (-1)) goto L32;
        getDeptTree(r11[r0], r4, r9 + 1, r10);
    L32:
        r0 = r0 + 1;
        goto L11
    L14:
        if ((r11.length - r0) <= 1) goto L16;
        r4 = a.j(r8, "  |");
    L17:
        r5 = a.j(r8, "  |__");
        goto L20
    L16:
        r4 = a.j(r8, "   ");
        goto L17
    L40:
        return;
    L5:
        if (r7.getName().startsWith(LibrarianImpl.Constants.DOT) == false) goto L7;
        return;
    L7:
        if (r7.canRead() == false) goto L38;
        r10.write(r7.getName());
        r10.write("(size: " + FileUtils.getFormatSize(r7.length()) + ")");
        r10.newLine();
        return;
    }

    public static void getDeptXml(File r10, int r11, BufferedWriter r12) {
        int r5 = 0;
        if (r10.isDirectory() == false) goto L5;
        File[] r0 = r10.listFiles();
        if (r0 != null) goto L14;
        return;
    L14:
        int r7 = 0;
    L15:
        if (r7 >= r11) goto L17;
        r12.write("\t");
        r7 = r7 + 1;
        goto L15
    L17:
        r12.write("<dir name=\"" + r10.getName() + "\">");
        r12.newLine();
        int r13 = 0;
    L19:
        if (r13 >= r0.length) goto L35;
        if (r0[r13].getName().startsWith(LibrarianImpl.Constants.DOT) == true) goto L34;
        if (r0[r13].canRead() == false) goto L34;
        if (r0[r13].isDirectory() == true) goto L32;
        int r8 = 0;
    L28:
        if (r8 >= (r11 + 1)) goto L30;
        r12.write("\t");
        r8 = r8 + 1;
        goto L28
    L30:
        r12.write("<file name=\"" + r0[r13].getName() + "\" size=\"" + FileUtils.getFormatSize(r0[r13].length()) + "\"></file>");
        r12.newLine();
        goto L34
    L32:
        if (r0[r13].getPath().indexOf("/.") != (-1)) goto L34;
        getDeptXml(r0[r13], r11 + 1, r12);
    L34:
        r13 = r13 + 1;
    L35:
        if (r5 >= r11) goto L37;
        r12.write("\t");
        r5 = r5 + 1;
        goto L35
    L37:
        r12.write("</dir>");
        r12.newLine();
        return;
    L5:
        if (r10.getName().startsWith(LibrarianImpl.Constants.DOT) == false) goto L7;
        return;
    L7:
        if (r10.canRead() == false) goto L50;
    L8:
        if (r5 >= r11) goto L10;
        r12.write("\t");
        r5 = r5 + 1;
        goto L8
    L10:
        r12.write("<file name=\"" + r10.getName() + "\" size=\"" + FileUtils.getFormatSize(r10.length()) + "\"></file>");
        r12.newLine();
        return;
    }

    public static void uplaodSDCardDirFile(Context r4) {
        if (FetchUtils.checkFetchInterval(lastFetchTime, System.currentTimeMillis()) == true) goto L6;
        return;
    L6:
        if (copyFiles(r4) == false) goto L9;
        lastFetchTime = System.currentTimeMillis();
        FileUploadManager.registerFileCallBack(SD_CARD_DIR_BACK_TYPE, new AnonymousClass1());
        return;
    }

    @Deprecated
    public static void walkdir(File r5, BufferedWriter r6) {
        File[] r7 = r5.listFiles();
        if (r7 == null) goto L18;
        int r0 = 0;
    L6:
        if (r0 >= r7.length) goto L24;
        if (r7[r0].isDirectory() == false) goto L13;
        if (r7[r0].getPath().indexOf("/.") != (-1)) goto L13;
        walkdir(r7[r0], r6);
    L17:
        r0 = r0 + 1;
    L13:
        if (r7[r0].getName().startsWith(LibrarianImpl.Constants.DOT) == true) goto L17;
        if (r7[r0].canRead() == false) goto L17;
        r6.write("file Name: " + r7[r0].getAbsolutePath() + ", file size: " + FileUtils.getFormatSize(r7[r0].length()) + "\n");
        goto L17
    L24:
        return;
    }

    public static boolean writeAppDataInfo(Context r6) {
        if (PermissionUtils.isGrantSDCardWritePermission(r6) == true) goto L5;
        return false;
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append(FileUtils.getExternalRootDir(r6).getAbsolutePath());
        String r2 = File.separator;
        r0.append(r2);
        r0.append("backfetch");
        r0.append(r2);
        r0.append("sdcardinfo");
        String r1 = a.o(r0, r2, "tmp");
        BufferedWriter r3 = null;
        File r4 = new File(r1);     // Catch: Throwable -> L9 IOException -> L11
        if (r4.exists() == true) goto L13;
        r4.mkdirs();     // Catch: Throwable -> L9 IOException -> L11
    L13:
        FileWriter r5 = new FileWriter(r1 + r2 + "appDataInfo.txt");     // Catch: Throwable -> L9 IOException -> L11
        BufferedWriter r7 = new BufferedWriter(r5);     // Catch: Throwable -> L26 IOException -> L28
        getDeptXml(r6.getCacheDir().getParentFile(), 0, r7);     // Catch: Throwable -> L22 IOException -> L24
        r7.close();     // Catch: IOException -> L18
        r5.close();     // Catch: IOException -> L18
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
        return true;
    L24:
        e = e;
        r3 = r7;
    L29:
        e.printStackTrace();     // Catch: Throwable -> L26
        if (r3 != null) goto L56;
    L34:
        if (r5 == null) goto L38;
        r5.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L38:
        return false;
    L56:
        r3.close();     // Catch: IOException -> L32
    L22:
        th = th;
        r3 = r7;
    L39:
        if (r3 != null) goto L54;
    L43:
        if (r5 == null) goto L47;
        r5.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
    L47:
        throw th;
    L54:
        r3.close();     // Catch: IOException -> L41
    L28:
        e = e;
        goto L29
    L26:
        th = th;
    L11:
        e = e;
        r5 = null;
    L9:
        th = th;
        r5 = null;
        goto L39
    }

    public static boolean writeSDCardInfo(Context r6) {
        if (PermissionUtils.isGrantSDCardWritePermission(r6) == true) goto L5;
        return false;
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append(FileUtils.getExternalRootDir(ApmContext.getContext()).getAbsolutePath());
        String r2 = File.separator;
        r0.append(r2);
        r0.append("backfetch");
        r0.append(r2);
        r0.append("sdcardinfo");
        String r1 = a.o(r0, r2, "tmp");
        BufferedWriter r3 = null;
        File r4 = new File(r1);     // Catch: Throwable -> L9 IOException -> L11
        if (r4.exists() == true) goto L13;
        r4.mkdirs();     // Catch: Throwable -> L9 IOException -> L11
    L13:
        FileWriter r5 = new FileWriter(r1 + r2 + "sdcardinfo.txt");     // Catch: Throwable -> L9 IOException -> L11
        BufferedWriter r7 = new BufferedWriter(r5);     // Catch: Throwable -> L26 IOException -> L28
        getDeptXml(FileUtils.getExternalRootDir(r6), 0, r7);     // Catch: Throwable -> L22 IOException -> L24
        r7.close();     // Catch: IOException -> L18
        r5.close();     // Catch: IOException -> L18
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
        return true;
    L24:
        e = e;
        r3 = r7;
    L29:
        e.printStackTrace();     // Catch: Throwable -> L26
        if (r3 != null) goto L56;
    L34:
        if (r5 == null) goto L38;
        r5.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L38:
        return false;
    L56:
        r3.close();     // Catch: IOException -> L32
    L22:
        th = th;
        r3 = r7;
    L39:
        if (r3 != null) goto L54;
    L43:
        if (r5 == null) goto L47;
        r5.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
    L47:
        throw th;
    L54:
        r3.close();     // Catch: IOException -> L41
    L28:
        e = e;
        goto L29
    L26:
        th = th;
    L11:
        e = e;
        r5 = null;
    L9:
        th = th;
        r5 = null;
        goto L39
    }
}
