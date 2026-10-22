package com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import com.loopj.android.http.RequestParams;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
public class NetworkFetcher {
    private final Context appContext;
    private final NetworkCache networkCache;
    private final String url;

    public static LottieResult<LottieComposition> fetchSync(Context r1, String r2) {
        return new NetworkFetcher(r1, r2).fetchSync();
    }

    private NetworkFetcher(Context r2, String r3) {
        Context r4 = r2.getApplicationContext();
        this.appContext = r4;
        this.url = r3;
        this.networkCache = new NetworkCache(r4, r3);
    }

    public LottieResult<LottieComposition> fetchSync() {
        LottieComposition r0 = fetchFromCache();
        if (r0 != null) goto L5;
        Logger.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return fetchFromNetwork();
    L5:
        return new LottieResult(r0);
    }

    private LottieComposition fetchFromCache() {
        Pair<FileExtension, InputStream> r0 = this.networkCache.fetch();
        if (r0 != null) goto L5;
        return null;
    L5:
        FileExtension r2 = r0.first;
        InputStream r1 = r0.second;
        if (r2 != FileExtension.ZIP) goto L8;
        LottieResult<LottieComposition> r4 = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(r1), this.url);
    L10:
        if (r4.getValue() != null) goto L12;
        return null;
    L12:
        return r4.getValue();
    L8:
        r4 = LottieCompositionFactory.fromJsonInputStreamSync(r1, this.url);
        goto L10
    }

    private LottieResult<LottieComposition> fetchFromNetwork() {
        return fetchFromNetworkInternal();
    L4:
        e = move-exception;
        return new LottieResult(e);
    }

    private LottieResult fetchFromNetworkInternal() throws IOException {
        Logger.debug("Fetching " + this.url);
        HttpURLConnection r2 = (HttpURLConnection) new URL(this.url).openConnection();
        r2.setRequestMethod("GET");
        r2.connect();     // Catch: Throwable -> L18 Exception -> L20
        if (r2.getErrorStream() == null) goto L6;
    L15:
        LottieResult r3 = new LottieResult(new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + r2.getResponseCode() + "\n" + getErrorFromConnection(r2)));     // Catch: Throwable -> L18 Exception -> L20
        r2.disconnect();
        return r3;
    L6:
        if (r2.getResponseCode() != 200) goto L15;
        LottieResult<LottieComposition> r6 = getResultFromConnection(r2);     // Catch: Throwable -> L18 Exception -> L20
        StringBuilder r1 = new StringBuilder("Completed fetch from network. Success: ");     // Catch: Throwable -> L18 Exception -> L20
        if (r6.getValue() == null) goto L11;
        boolean r0 = true;
    L12:
        Logger.debug(r1.append(r0).toString());     // Catch: Throwable -> L18 Exception -> L20
        r2.disconnect();
        return r6;
    L11:
        r0 = false;
    L18:
        th = move-exception;
        r2.disconnect();
        throw th;
    L20:
        e = move-exception;
        LottieResult r4 = new LottieResult(e);     // Catch: Throwable -> L18
        r2.disconnect();
        return r4;
    }

    private String getErrorFromConnection(HttpURLConnection r3) throws IOException {
        r3.getResponseCode();
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r3.getErrorStream()));
        StringBuilder r4 = new StringBuilder();
    L18:
        String r0 = r2.readLine();     // Catch: Throwable -> L10 Exception -> L12
        if (r0 == null) goto L20;
        r4.append(r0).append('\n');     // Catch: Throwable -> L10 Exception -> L12
    L20:
        r2.close();     // Catch: Exception -> L16
    L9:
        return r4.toString();
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r2.close();     // Catch: Exception -> L17
    L15:
        throw th;
    }

    private LottieResult<LottieComposition> getResultFromConnection(HttpURLConnection r4) throws IOException {
        String r0 = r4.getContentType();
        if (r0 != null) goto L6;
        r0 = RequestParams.APPLICATION_JSON;
    L6:
        if (r0.contains("application/zip") == false) goto L8;
        Logger.debug("Handling zip response.");
        FileExtension r1 = FileExtension.ZIP;
        LottieResult<LottieComposition> r5 = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(r4.getInputStream(), r1))), this.url);
    L10:
        if (r5.getValue() == null) goto L12;
        this.networkCache.renameTempFile(r1);
    L12:
        return r5;
    L8:
        Logger.debug("Received json response.");
        r1 = FileExtension.JSON;
        r5 = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.networkCache.writeTempCacheFile(r4.getInputStream(), r1).getAbsolutePath())), this.url);
        goto L10
    }
}
