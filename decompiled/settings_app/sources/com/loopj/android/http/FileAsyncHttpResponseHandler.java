package com.loopj.android.http;

import android.content.Context;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FileAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "FileAsyncHttpRH";
    protected final boolean append;
    protected final File file;
    protected File frontendFile;
    protected final boolean renameIfExists;

    public abstract void onFailure(int r1, Header[] r2, Throwable r3, File r4);

    public abstract void onSuccess(int r1, Header[] r2, File r3);

    public FileAsyncHttpResponseHandler(File r2) {
        this(r2, false);
    }

    public FileAsyncHttpResponseHandler(File r2, boolean r3) {
        this(r2, r3, false);
    }

    public FileAsyncHttpResponseHandler(File r2, boolean r3, boolean r4) {
        this(r2, r3, r4, false);
    }

    public FileAsyncHttpResponseHandler(File r3, boolean r4, boolean r5, boolean r6) {
        super(r6);
        if (r3 == null) goto L5;
        boolean r7 = true;
    L6:
        Utils.asserts(r7, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
        if (r3.isDirectory() == true) goto L12;
        if (r3.getParentFile().isDirectory() == true) goto L12;
        Utils.asserts(r3.getParentFile().mkdirs(), "Cannot create parent directories for requested File location");
    L12:
        if (r3.isDirectory() == true) goto L14;
    L16:
        this.file = r3;
        this.append = r4;
        this.renameIfExists = r5;
        return;
    L14:
        if (r3.mkdirs() == true) goto L16;
        AsyncHttpClient.log.d(LOG_TAG, "Cannot create directories for requested Directory location, might not be a problem");
        goto L16
    L5:
        r7 = false;
        goto L6
    }

    public FileAsyncHttpResponseHandler(Context r1) {
        this.file = getTemporaryFile(r1);
        this.append = false;
        this.renameIfExists = false;
    }

    public boolean deleteTargetFile() {
        if (getTargetFile() != null) goto L5;
    L7:
        return false;
    L5:
        if (getTargetFile().delete() == false) goto L7;
        return true;
    }

    protected File getTemporaryFile(Context r3) {
        if (r3 == null) goto L4;
        boolean r2 = true;
    L5:
        Utils.asserts(r2, "Tried creating temporary file without having Context");
        return File.createTempFile("temp_", "_handled", r3.getCacheDir());
    L8:
        e = move-exception;
        AsyncHttpClient.log.e(LOG_TAG, "Cannot create temporary file", e);
        return null;
    L4:
        r2 = false;
        goto L5
    }

    protected File getOriginalFile() {
        if (this.file == null) goto L5;
        boolean r0 = true;
    L6:
        Utils.asserts(r0, "Target file is null, fatal!");
        return this.file;
    L5:
        r0 = false;
        goto L6
    }

    public File getTargetFile() {
        if (this.frontendFile != null) goto L10;
        if (getOriginalFile().isDirectory() == false) goto L7;
        File r0 = getTargetFileByParsingURL();
    L8:
        this.frontendFile = r0;
        goto L10
    L7:
        r0 = getOriginalFile();
    L10:
        return this.frontendFile;
    }

    protected File getTargetFileByParsingURL() {
        Utils.asserts(getOriginalFile().isDirectory(), "Target file is not a directory, cannot proceed");
        if (getRequestURI() == null) goto L5;
        boolean r0 = true;
    L6:
        Utils.asserts(r0, "RequestURI is null, cannot proceed");
        String r1 = getRequestURI().toString();
        String r2 = r1.substring(r1.lastIndexOf(47) + 1, r1.length());
        File r3 = new File(getOriginalFile(), r2);
        if (r3.exists() == true) goto L9;
    L19:
        return r3;
    L9:
        if (this.renameIfExists == false) goto L19;
        if (r2.contains(".") == true) goto L13;
        String r4 = r2 + " (%d)";
    L14:
        int r5 = 0;
    L15:
        File r6 = new File(getOriginalFile(), String.format(r4, new Object[]{Integer.valueOf(r5)}));
        if (r6.exists() == false) goto L17;
        r5 = r5 + 1;
        goto L15
    L17:
        return r6;
    L13:
        r4 = r2.substring(0, r2.lastIndexOf(46)) + " (%d)" + r2.substring(r2.lastIndexOf(46), r2.length());
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public final void onFailure(int r1, Header[] r2, byte[] r3, Throwable r4) {
        onFailure(r1, r2, r4, getTargetFile());
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    public final void onSuccess(int r1, Header[] r2, byte[] r3) {
        onSuccess(r1, r2, getTargetFile());
    }

    @Override // com.loopj.android.http.AsyncHttpResponseHandler
    protected byte[] getResponseData(HttpEntity r9) throws IOException {
        if (r9 == null) goto L17;
        InputStream r0 = r9.getContent();
        long r1 = r9.getContentLength();
        FileOutputStream r10 = new FileOutputStream(getTargetFile(), this.append);
        if (r0 != null) goto L19;
        return null;
    L19:
        byte[] r3 = new byte[4096];     // Catch: Throwable -> L14
        int r5 = 0;
    L7:
        int r6 = r0.read(r3);     // Catch: Throwable -> L14
        if (r6 == (-1)) goto L13;
        if (Thread.currentThread().isInterrupted() == true) goto L13;
        r5 = r5 + r6;     // Catch: Throwable -> L14
        r10.write(r3, 0, r6);     // Catch: Throwable -> L14
        sendProgressMessage(r5, r1);     // Catch: Throwable -> L14
    L13:
        AsyncHttpClient.silentCloseInputStream(r0);
        r10.flush();
        AsyncHttpClient.silentCloseOutputStream(r10);
        return null;
    L14:
        th = move-exception;
        AsyncHttpClient.silentCloseInputStream(r0);
        r10.flush();
        AsyncHttpClient.silentCloseOutputStream(r10);
        throw th;
    L17:
        return null;
    }
}
