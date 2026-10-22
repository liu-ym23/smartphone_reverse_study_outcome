package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {
    static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = null;
    static final int INVALID_STATUS_CODE = -1;
    private static final int MAXIMUM_REDIRECTS = 5;
    static final String REDIRECT_HEADER_FIELD = "Location";
    private static final String TAG = "HttpUrlFetcher";
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private final int timeout;
    private HttpURLConnection urlConnection;

    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection build(URL r1) throws IOException {
            return (HttpURLConnection) r1.openConnection();
        }
    }

    interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL r1) throws IOException;
    }

    static {
        DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    }

    public HttpUrlFetcher(GlideUrl r2, int r3) {
        this(r2, r3, DEFAULT_CONNECTION_FACTORY);
    }

    HttpUrlFetcher(GlideUrl r1, int r2, HttpUrlConnectionFactory r3) {
        this.glideUrl = r1;
        this.timeout = r2;
        this.connectionFactory = r3;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority r9, DataFetcher.DataCallback<? super InputStream> r10) {
        long r1 = LogTime.getLogTime();
        r10.onDataReady(loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));     // Catch: Throwable -> L7 IOException -> L9
    L5:
        if (Log.isLoggable(TAG, 2) == false) goto L26;
        StringBuilder r8 = new StringBuilder("Finished http url fetcher fetch in ");
    L18:
        Log.v(TAG, r8.append(LogTime.getElapsedMillis(r1)).toString());
        return;
    L26:
        return;
    L7:
        th = move-exception;
        if (Log.isLoggable(TAG, 2) == false) goto L23;
        Log.v(TAG, "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(r1));
    L23:
        throw th;
    L9:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L14;
        Log.d(TAG, "Failed to load data for url", e);     // Catch: Throwable -> L7
    L14:
        r10.onLoadFailed(e);     // Catch: Throwable -> L7
        if (Log.isLoggable(TAG, 2) == false) goto L27;
        r8 = new StringBuilder("Finished http url fetcher fetch in ");
        goto L18
    }

    private InputStream loadDataWithRedirects(URL r3, int r4, URL r5, Map<String, String> r6) throws HttpException {
        if (r4 >= 5) goto L44;
        if (r5 != null) goto L50;
    L10:
        HttpURLConnection r7 = buildAndConfigureConnection(r3, r6);
        this.urlConnection = r7;
        r7.connect();     // Catch: IOException -> L40
        this.stream = this.urlConnection.getInputStream();     // Catch: IOException -> L40
        if (this.isCancelled == false) goto L16;
        return null;
    L16:
        int r8 = getHttpStatusCodeOrInvalid(this.urlConnection);
        if (isHttpOk(r8) == false) goto L21;
        return getStreamForSuccessfulRequest(this.urlConnection);
    L21:
        if (isHttpRedirect(r8) == false) goto L32;
        String r0 = this.urlConnection.getHeaderField("Location");
        if (TextUtils.isEmpty(r0) == true) goto L31;
        URL r1 = new URL(r3, r0);     // Catch: MalformedURLException -> L27
        cleanup();
        return loadDataWithRedirects(r1, r4 + 1, r3, r6);
    L27:
        e = move-exception;
        throw new HttpException("Bad redirect url: " + r0, r8, e);
    L31:
        throw new HttpException("Received empty or null redirect url", r8);
    L32:
        if (r8 == (-1)) goto L34;
    L37:
        e = move-exception;
        throw new HttpException("Failed to get a response message", r8, e);
    L36:
        throw new HttpException(this.urlConnection.getResponseMessage(), r8);     // Catch: IOException -> L37
    L34:
        throw new HttpException(r8);
    L40:
        e = move-exception;
        throw new HttpException("Failed to connect or obtain data", getHttpStatusCodeOrInvalid(this.urlConnection), e);
    L50:
        if (r3.toURI().equals(r5.toURI()) == false) goto L10;
        throw new HttpException("In re-direct loop", -1);     // Catch: URISyntaxException -> L45
    L44:
        throw new HttpException("Too many (> 5) redirects!", -1);
    }

    private static int getHttpStatusCodeOrInvalid(HttpURLConnection r2) {
        return r2.getResponseCode();
    L4:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L12;
        Log.d(TAG, "Failed to get a response code", e);
        return -1;
    L12:
        return -1;
    }

    private HttpURLConnection buildAndConfigureConnection(URL r4, Map<String, String> r5) throws HttpException {
        HttpURLConnection r6 = this.connectionFactory.build(r4);     // Catch: IOException -> L10
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Map.Entry<String, String> r1 = r7.next();
        r6.addRequestProperty(r1.getKey(), r1.getValue());
        goto L6
    L8:
        r6.setConnectTimeout(this.timeout);
        r6.setReadTimeout(this.timeout);
        r6.setUseCaches(false);
        r6.setDoInput(true);
        r6.setInstanceFollowRedirects(false);
        return r6;
    L10:
        e = move-exception;
        throw new HttpException("URL.openConnection threw", 0, e);
    }

    private static boolean isHttpOk(int r1) {
        if ((r1 / 100) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isHttpRedirect(int r1) {
        if ((r1 / 100) != 3) goto L5;
        return true;
    L5:
        return false;
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection r5) throws HttpException {
    L12:
        e = move-exception;
        throw new HttpException("Failed to obtain InputStream", getHttpStatusCodeOrInvalid(r5), e);
    L4:
        if (TextUtils.isEmpty(r5.getContentEncoding()) == false) goto L7;
        this.stream = ContentLengthInputStream.obtain(r5.getInputStream(), r5.getContentLength());     // Catch: IOException -> L12
    L11:
        return this.stream;
    L7:
        if (Log.isLoggable(TAG, 3) == false) goto L9;
        Log.d(TAG, "Got non empty content encoding: " + r5.getContentEncoding());     // Catch: IOException -> L12
    L9:
        this.stream = r5.getInputStream();     // Catch: IOException -> L12
        goto L11
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream r0 = this.stream;
        if (r0 != null) goto L11;
    L5:
        HttpURLConnection r1 = this.urlConnection;
        if (r1 == null) goto L8;
        r1.disconnect();
    L8:
        this.urlConnection = null;
        return;
    L11:
        r0.close();     // Catch: IOException -> L10
        goto L5
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }
}
