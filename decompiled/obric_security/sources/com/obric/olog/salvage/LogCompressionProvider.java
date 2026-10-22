package com.obric.olog.salvage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import com.obric.security.cleaner.bigfile.MimeType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class LogCompressionProvider extends ContentProvider {
    private static final String ACTION_DELETE_ZIP = "delete_zip";
    private static final String REQUIRED_PERMISSION = "com.obric.olog.ACCESS_LOG_COMPRESSION_PROVIDER";
    private static final Pattern SAFE_PATH_PATTERN = null;
    private static final String ZIP_FILE_NAME = "ologs.zip";
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return MimeType.ZIP;
    }

    public LogCompressionProvider() {
    }

    static {
        SAFE_PATH_PATTERN = Pattern.compile("^[a-zA-Z0-9_./-]+$");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        HandlerThread r0 = new HandlerThread("LogCompressionThread", 10);
        this.mHandlerThread = r0;
        r0.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(final Uri r8, String[] r9, String r10, final String[] r11, String r12) {
        if (checkCallingPermission() == true) goto L5;
        return null;
    L5:
        if (r11 != null) goto L7;
    L15:
        return null;
    L7:
        if (r11.length == 0) goto L15;
        final MatrixCursor r13 = new MatrixCursor(new String[]{"zip_file_uri"});
        final CountDownLatch r14 = new CountDownLatch(1);
        this.mHandler.post(new LogCompressionProvider$$ExternalSyntheticLambda0(this, r11, r8, r13, r14));
        r14.await();     // Catch: InterruptedException -> L12
    L14:
        return r13;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    /* JADX INFO: renamed from: lambda$query$0$com-obric-olog-salvage-LogCompressionProvider, reason: not valid java name */
    /* synthetic */ void m193lambda$query$0$comobricologsalvageLogCompressionProvider(String[] r8, Uri r9, MatrixCursor r10, CountDownLatch r11) {
        Context r7 = getContext();     // Catch: Throwable -> L18 Exception -> L20
        if (r7 != null) goto L31;
        r11.countDown();
        return;
    L31:
        Class.forName("com.obric.android.agilelogger.ALog").getMethod("syncFlush", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L10 Throwable -> L18
        Thread.sleep(1000);     // Catch: Exception -> L10 Throwable -> L18
    L26:
        Class.forName("com.ss.android.agilelogger.ALog").getMethod("syncFlush", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L14 Throwable -> L18
        Thread.sleep(1000);     // Catch: Exception -> L14 Throwable -> L18
    L16:
        LogFileCompressor.compressLogFiles(r7, r8, ZIP_FILE_NAME);     // Catch: Throwable -> L18 Exception -> L20
        r10.addRow(new Object[]{Uri.withAppendedPath(r9, "zip_file").toString()});     // Catch: Throwable -> L18 Exception -> L20
    L22:
        r11.countDown();
        return;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18 Exception -> L20
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18 Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r11.countDown();
        throw th;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        checkCallingPermission();
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        if (checkCallingPermission() == true) goto L6;
        return 0;
    L6:
        if (ACTION_DELETE_ZIP.equals(r2) == false) goto L16;
        Context r0 = getContext();
        if (r0 != null) goto L10;
        return 0;
    L10:
        File r4 = new File(r0.getFilesDir(), ZIP_FILE_NAME);
        if (r4.exists() == false) goto L16;
        if (r4.delete() == false) goto L16;
        return 1;
    L16:
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        checkCallingPermission();
        return 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r2, String r3) throws FileNotFoundException {
        if (checkCallingPermission() == false) goto L15;
        Context r1 = getContext();
        if (r1 == null) goto L13;
        File r4 = new File(r1.getFilesDir(), ZIP_FILE_NAME);
        if (r4.exists() == false) goto L11;
        return ParcelFileDescriptor.open(r4, 268435456);
    L11:
        throw new FileNotFoundException("ZIP file not found: " + r4.getAbsolutePath());
    L13:
        throw new FileNotFoundException("Context is null");
    L15:
        throw new SecurityException("Caller does not have the required permission");
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        super.shutdown();
        this.mHandlerThread.quitSafely();
    }

    private boolean isSafePath(String r1) {
        if (SAFE_PATH_PATTERN.matcher(r1).matches() == true) goto L7;
        return false;
    L7:
        return !r1.contains("..");
    }

    private boolean checkCallingPermission() {
        Context r2 = getContext();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.checkCallingOrSelfPermission(REQUIRED_PERMISSION) != 0) goto L9;
        return true;
    L9:
        return false;
    }
}
