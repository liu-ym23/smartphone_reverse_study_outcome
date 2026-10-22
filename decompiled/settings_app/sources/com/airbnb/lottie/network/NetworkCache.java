package com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
class NetworkCache {
    private final Context appContext;
    private final String url;

    NetworkCache(Context r1, String r2) {
        this.appContext = r1.getApplicationContext();
        this.url = r2;
    }

    Pair<FileExtension, InputStream> fetch() {
        File r1 = getCachedFile(this.url);     // Catch: FileNotFoundException -> L13
        if (r1 != null) goto L6;
        return null;
    L6:
        FileInputStream r2 = new FileInputStream(r1);     // Catch: FileNotFoundException -> L13
        if (r1.getAbsolutePath().endsWith(".zip") == false) goto L10;
        FileExtension r0 = FileExtension.ZIP;
    L11:
        Logger.debug("Cache hit for " + this.url + " at " + r1.getAbsolutePath());
        return new Pair(r0, r2);
    L10:
        r0 = FileExtension.JSON;
    L13:
        return null;
    }

    File writeTempCacheFile(InputStream r4, FileExtension r5) throws IOException {
        String r6 = filenameForUrl(this.url, r5, true);
        File r0 = new File(this.appContext.getCacheDir(), r6);
        FileOutputStream r3 = new FileOutputStream(r0);     // Catch: Throwable -> L16
        byte[] r7 = new byte[1024];     // Catch: Throwable -> L13
    L6:
        int r1 = r4.read(r7);     // Catch: Throwable -> L13
        if (r1 == (-1)) goto L9;
        r3.write(r7, 0, r1);     // Catch: Throwable -> L13
        goto L6
    L9:
        r3.flush();     // Catch: Throwable -> L13
        r3.close();     // Catch: Throwable -> L16
        r4.close();
        return r0;
    L13:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r4.close();
        throw th;
    }

    void renameTempFile(FileExtension r4) {
        File r0 = new File(this.appContext.getCacheDir(), filenameForUrl(this.url, r4, true));
        File r5 = new File(r0.getAbsolutePath().replace(".temp", ""));
        boolean r3 = r0.renameTo(r5);
        Logger.debug("Copying temp file to real file (" + r5 + ")");
        if (r3 == true) goto L6;
        Logger.warning("Unable to rename cache file " + r0.getAbsolutePath() + " to " + r5.getAbsolutePath() + ".");
        return;
    }

    private File getCachedFile(String r5) throws FileNotFoundException {
        File r0 = new File(this.appContext.getCacheDir(), filenameForUrl(r5, FileExtension.JSON, false));
        if (r0.exists() == false) goto L5;
        return r0;
    L5:
        File r1 = new File(this.appContext.getCacheDir(), filenameForUrl(r5, FileExtension.ZIP, false));
        if (r1.exists() == false) goto L8;
        return r1;
    L8:
        return null;
    }

    private static String filenameForUrl(String r3, FileExtension r4, boolean r5) {
        StringBuilder r6 = new StringBuilder("lottie_cache_").append(r3.replaceAll("\\W+", ""));
        if (r5 == false) goto L5;
        String r7 = r4.tempExtension();
    L7:
        return r6.append(r7).toString();
    L5:
        r7 = r4.extension;
        goto L7
    }
}
