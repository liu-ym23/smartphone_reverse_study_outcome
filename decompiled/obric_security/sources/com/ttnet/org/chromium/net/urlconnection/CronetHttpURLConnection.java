package com.ttnet.org.chromium.net.urlconnection;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ss.android.http.legacy.cookie.SM;
import com.ss.android.http.legacy.utils.URLEncodedUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.base.Reflect;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.NetworkException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public class CronetHttpURLConnection extends HttpURLConnection {
    private static final String BYPASS_COOKIE_HEADER = "x-ttnet-bypass-cookie";
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final int DO_NOT_SEND_COOKIE = 2;
    private static final String GET_REQUEST_COOKIE_SOURCE_FLAG = "x-tt-get-cookie-source";
    public static final String SS_COOKIE = "X-SS-Cookie";
    private static final String TAG = "CronetHttpURLConnection";
    private static final String WEBVIEW_COOKIE = "webview-origin-url";
    private static final int WEBVIEW_REQUEST = 1;
    private String mAuthCertPassword;
    private String mAuthCertUsername;
    private CookieHandler mCookieHandler;
    private final CronetEngine mCronetEngine;
    private volatile boolean mDisconnected;
    private IOException mException;
    private boolean mHasResponseHeadersOrCompleted;
    private CronetInputStream mInputStream;
    private int mInputStreamBufferSize;
    private final MessageLoop mMessageLoop;
    private boolean mOnRedirectCalled;
    private CronetOutputStream mOutputStream;
    private int mOutputStreamBufferSize;
    private UrlRequest mRequest;
    private int mRequestCookieSource;
    private RequestFinishedInfo mRequestFinishedInfo;
    private int mRequestFlag;
    private final List<Pair<String, String>> mRequestHeaders;
    private volatile String mRequestLog;
    private CountDownLatch mRequestLogCountDownLatch;
    private int mRequestPriority;
    private int mRequestTimeout;
    private int mRequestTypeFlags;
    private List<Map.Entry<String, String>> mResponseHeadersList;
    private Map<String, List<String>> mResponseHeadersMap;
    private UrlResponseInfo mResponseInfo;
    private int mSocketConnectTimeout;
    private int mSocketReadTimeout;
    private int mSocketWriteTimeout;
    private long mThrottleNetSpeed;
    private int mTrafficStatsTag;
    private boolean mTrafficStatsTagSet;
    private int mTrafficStatsUid;
    private boolean mTrafficStatsUidSet;

    private class CronetUrlRequestCallback extends UrlRequest.Callback {
        final /* synthetic */ CronetHttpURLConnection this$0;

        public CronetUrlRequestCallback(CronetHttpURLConnection r1) {
            this.this$0 = r1;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onResponseStarted(UrlRequest r4, UrlResponseInfo r5, String r6) {
            CronetHttpURLConnection.access$002(this.this$0, r5);
            CronetHttpURLConnection.access$102(this.this$0, true);
            if (CronetHttpURLConnection.access$000(this.this$0) == null) goto L8;
            long r0 = System.nanoTime();
            CronetHttpURLConnection r7 = this.this$0;
            CronetHttpURLConnection.access$300(r7, r6, CronetHttpURLConnection.access$200(r7));
            long r8 = (System.nanoTime() - r0) / 1000;
            if (r4 == null) goto L8;
            r4.setSaveCookieCostUs(r8);
        L8:
            if (Logger.debug() == false) goto L10;
            Logger.d("CronetHttpURLConnection", "onResponseStarted loop quit url = " + this.this$0.getURL().toString());
        L10:
            CronetHttpURLConnection.access$400(this.this$0).quit();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onReadCompleted(UrlRequest r1, UrlResponseInfo r2, ByteBuffer r3) {
            CronetHttpURLConnection.access$002(this.this$0, r2);
            if (Logger.debug() == false) goto L5;
            Logger.d("CronetHttpURLConnection", "onReadCompleted loop quit url = " + this.this$0.getURL().toString());
        L5:
            CronetHttpURLConnection.access$400(this.this$0).quit();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRedirectReceived(UrlRequest r5, UrlResponseInfo r6, String r7, String r8) {
            boolean r0 = true;
            CronetHttpURLConnection.access$502(this.this$0, true);
            if (r6 == null) goto L5;
            CronetHttpURLConnection.access$300(this.this$0, r8, r6.getAllHeaders());
        L5:
            URL r9 = CronetHttpURLConnection.access$600(this.this$0);
            if (TextUtils.isEmpty(r8) == true) goto L47;
            r9 = new URL(r8);     // Catch: Throwable -> L43
        L47:
            URL r1 = new URL(r7);     // Catch: MalformedURLException -> L44
            if (CronetHttpURLConnection.access$700(this.this$0) == false) goto L14;
            CronetHttpURLConnection.access$802(this.this$0, r1);     // Catch: MalformedURLException -> L44
        L14:
            if (CronetHttpURLConnection.access$900(this.this$0) == false) goto L36;
            if (CronetHttpURLConnection.access$1000(this.this$0) != null) goto L18;
            return;
        L18:
            if (HttpHost.DEFAULT_SCHEME_NAME.equals(r1.getProtocol()) == true) goto L20;
        L22:
            r0 = false;
        L24:
            if (r1.getHost().equals(r9.getHost()) == false) goto L26;
            if (r0 == true) goto L26;
        L34:
            CronetHttpURLConnection.access$1000(this.this$0).followRedirect();     // Catch: MalformedURLException -> L44
            return;
        L26:
            CronetHttpURLConnection.access$1000(this.this$0).RemoveRequestCookieHeader();     // Catch: MalformedURLException -> L44
            URL r10 = new URL(r7);     // Catch: MalformedURLException -> L44
            CronetHttpURLConnection r11 = this.this$0;     // Catch: MalformedURLException -> L44
            Map r12 = CronetHttpURLConnection.access$1100(r11, r11.uri(r10));     // Catch: MalformedURLException -> L44
            if (r12 == null) goto L34;
            if (r12.isEmpty() == true) goto L34;
            Iterator r13 = r12.entrySet().iterator();     // Catch: MalformedURLException -> L44
        L32:
            if (r13.hasNext() == false) goto L34;
            Map.Entry r14 = (Map.Entry) r13.next();     // Catch: MalformedURLException -> L44
            CronetHttpURLConnection.access$1000(this.this$0).AddRequestCookieHeader((String) r14.getKey(), (String) r14.getValue());     // Catch: MalformedURLException -> L44
            goto L32
        L20:
            if ("https".equals(r9.getProtocol()) == false) goto L22;
        L36:
            CronetHttpURLConnection.access$002(this.this$0, r6);
            if (CronetHttpURLConnection.access$1000(this.this$0) == null) goto L40;
            setResponseDataCompleted(null, false);
        L40:
            if (Logger.debug() == false) goto L51;
            Logger.d("CronetHttpURLConnection", "onRedirectReceived loop quit url = " + this.this$0.getURL().toString());
            return;
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onSucceeded(UrlRequest r1, UrlResponseInfo r2) {
            CronetHttpURLConnection.access$002(this.this$0, r2);
            if (Logger.debug() == false) goto L5;
            Logger.d("CronetHttpURLConnection", "onSucceeded url = " + this.this$0.getURL().toString());
        L5:
            setResponseDataCompleted(null, true);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onFailed(UrlRequest r1, UrlResponseInfo r2, CronetException r3) {
            if (r3 == null) goto L9;
            CronetHttpURLConnection.access$002(this.this$0, r2);
            CronetHttpURLConnection r4 = this.this$0;
            CronetHttpURLConnection.access$1202(r4, CronetHttpURLConnection.access$1300(r4, r3));
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetHttpURLConnection", "onFailed url = " + this.this$0.getURL().toString());
        L6:
            setResponseDataCompleted(r3, true);
            return;
        L9:
            throw new IllegalStateException("Exception cannot be null in onFailed.");
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onCanceled(UrlRequest r2, UrlResponseInfo r3) {
            CronetHttpURLConnection.access$002(this.this$0, r3);
            if (Logger.debug() == false) goto L6;
            Logger.d("CronetHttpURLConnection", "onCanceled loop quit url = " + this.this$0.getURL().toString());
        L6:
            if (CronetHttpURLConnection.access$1200(this.this$0) != null) goto L8;
            CronetHttpURLConnection.access$1202(this.this$0, new TTRequestCanceledException("request canceled, ErrorCode=11, InternalErrorCode=-999"));
        L8:
            setResponseDataCompleted(CronetHttpURLConnection.access$1200(this.this$0), false);
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onMetricsCollected(UrlRequest r1, RequestFinishedInfo r2) {
            CronetHttpURLConnection.access$1402(this.this$0, r2);
            if (Logger.debug() == false) goto L5;
            Logger.d("CronetHttpURLConnection", "onMetricsCollected loop quit url = " + this.this$0.getURL().toString());
        L5:
            setRequestEnd();
        }

        @Override // com.ttnet.org.chromium.net.UrlRequest.Callback
        public void onRequestLogCollected(String r2, RequestFinishedInfo r3) {
            CronetHttpURLConnection.access$1502(this.this$0, r2);
            CronetHttpURLConnection.access$1402(this.this$0, r3);
            CronetHttpURLConnection.access$1600(this.this$0).countDown();
        }

        private void setRequestEnd() {
            CronetHttpURLConnection r0 = this.this$0;
            CronetHttpURLConnection.access$1502(r0, CronetHttpURLConnection.access$1000(r0).getRequestLog());
        L20:
            th = move-exception;
            th.printStackTrace();
        L22:
            CronetHttpURLConnection.access$102(this.this$0, true);
            CronetHttpURLConnection.access$400(this.this$0).quit();
            return;
        L4:
            if (CronetHttpURLConnection.access$1200(this.this$0) == null) goto L22;
            if (CronetHttpURLConnection.access$1400(this.this$0) != null) goto L8;
        L12:
            String r1 = null;
        L14:
            if (TextUtils.isEmpty(r1) == true) goto L22;
            String r2 = CronetHttpURLConnection.access$1200(this.this$0).getMessage();     // Catch: Throwable -> L20
            StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L20
            StringBuilder r4 = r3.append(r1).append("|");     // Catch: Throwable -> L20
            if (r2 != null) goto L18;
            r2 = "null";
        L18:
            r4.append(r2);     // Catch: Throwable -> L20
            Reflect.on(CronetHttpURLConnection.access$1200(this.this$0)).set("detailMessage", r3.toString());     // Catch: Throwable -> L20
            goto L22
        L8:
            if (CronetHttpURLConnection.access$1400(this.this$0).getMetrics() == null) goto L12;
            if (CronetHttpURLConnection.access$1400(this.this$0).getMetrics().getPeerAddr() == null) goto L12;
            r1 = CronetHttpURLConnection.access$1400(this.this$0).getMetrics().getPeerAddr() + ":" + CronetHttpURLConnection.access$1400(this.this$0).getMetrics().getPeerPort();     // Catch: Throwable -> L20
            goto L14
        }

        private void setResponseDataCompleted(IOException r2, boolean r3) {
            CronetHttpURLConnection.access$1202(this.this$0, r2);
            if (CronetHttpURLConnection.access$1700(this.this$0) == null) goto L6;
            CronetHttpURLConnection.access$1700(this.this$0).setResponseDataCompleted(r2);
        L6:
            if (CronetHttpURLConnection.access$1800(this.this$0) == null) goto L8;
            CronetHttpURLConnection.access$1800(this.this$0).setRequestCompleted(r2);
        L8:
            CronetHttpURLConnection.access$102(this.this$0, true);
            if (r3 == true) goto L12;
            setRequestEnd();
            return;
        }
    }

    static {
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    static /* synthetic */ UrlResponseInfo access$000(CronetHttpURLConnection r0) {
        return r0.mResponseInfo;
    }

    static /* synthetic */ UrlResponseInfo access$002(CronetHttpURLConnection r0, UrlResponseInfo r1) {
        r0.mResponseInfo = r1;
        return r1;
    }

    static /* synthetic */ UrlRequest access$1000(CronetHttpURLConnection r0) {
        return r0.mRequest;
    }

    static /* synthetic */ boolean access$102(CronetHttpURLConnection r0, boolean r1) {
        r0.mHasResponseHeadersOrCompleted = r1;
        return r1;
    }

    static /* synthetic */ Map access$1100(CronetHttpURLConnection r0, URI r1) {
        return r0.GetCookieMap(r1);
    }

    static /* synthetic */ IOException access$1200(CronetHttpURLConnection r0) {
        return r0.mException;
    }

    static /* synthetic */ IOException access$1202(CronetHttpURLConnection r0, IOException r1) {
        r0.mException = r1;
        return r1;
    }

    static /* synthetic */ IOException access$1300(CronetHttpURLConnection r0, CronetException r1) {
        return r0.tryConvertCronetException(r1);
    }

    static /* synthetic */ RequestFinishedInfo access$1400(CronetHttpURLConnection r0) {
        return r0.mRequestFinishedInfo;
    }

    static /* synthetic */ RequestFinishedInfo access$1402(CronetHttpURLConnection r0, RequestFinishedInfo r1) {
        r0.mRequestFinishedInfo = r1;
        return r1;
    }

    static /* synthetic */ String access$1502(CronetHttpURLConnection r0, String r1) {
        r0.mRequestLog = r1;
        return r1;
    }

    static /* synthetic */ CountDownLatch access$1600(CronetHttpURLConnection r0) {
        return r0.mRequestLogCountDownLatch;
    }

    static /* synthetic */ CronetInputStream access$1700(CronetHttpURLConnection r0) {
        return r0.mInputStream;
    }

    static /* synthetic */ CronetOutputStream access$1800(CronetHttpURLConnection r0) {
        return r0.mOutputStream;
    }

    static /* synthetic */ Map access$200(CronetHttpURLConnection r0) {
        return r0.getAllHeaders();
    }

    static /* synthetic */ void access$300(CronetHttpURLConnection r0, String r1, Map r2) {
        r0.saveResponseCookie(r1, r2);
    }

    static /* synthetic */ MessageLoop access$400(CronetHttpURLConnection r0) {
        return r0.mMessageLoop;
    }

    static /* synthetic */ boolean access$502(CronetHttpURLConnection r0, boolean r1) {
        r0.mOnRedirectCalled = r1;
        return r1;
    }

    static /* synthetic */ URL access$600(CronetHttpURLConnection r0) {
        return r0.url;
    }

    static /* synthetic */ boolean access$700(CronetHttpURLConnection r0) {
        return r0.instanceFollowRedirects;
    }

    static /* synthetic */ URL access$802(CronetHttpURLConnection r0, URL r1) {
        r0.url = r1;
        return r1;
    }

    static /* synthetic */ boolean access$900(CronetHttpURLConnection r0) {
        return r0.instanceFollowRedirects;
    }

    public CronetHttpURLConnection(URL r1, CronetEngine r2, boolean r3) {
        super(r1);
        this.mCronetEngine = r2;
        this.mMessageLoop = new MessageLoop();
        if (r3 == false) goto L5;
        this.mInputStream = new CronetInputStreamWithTTBuffer(this);
    L6:
        this.mRequestHeaders = new ArrayList();
        this.mCookieHandler = CookieHandler.getDefault();
        this.mRequestLogCountDownLatch = new CountDownLatch(1);
        this.mDisconnected = false;
        this.mRequestCookieSource = -1;
        return;
    L5:
        this.mInputStream = new CronetInputStream(this);
        goto L6
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        startRequest();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.connected == false) goto L8;
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L9;
        r0.cancel();
        this.mDisconnected = true;
        return;
    L9:
        return;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        getResponse();
        return this.mResponseInfo.getHttpStatusText();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        getResponse();
        return this.mResponseInfo.getHttpStatusCode();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        getResponse();     // Catch: IOException -> L5
        return getAllHeaders();
    L6:
        return Collections.emptyMap();
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String r3) {
        getResponse();     // Catch: IOException -> L9
        Map<String, List<String>> r2 = getAllHeaders();
        if (r2.containsKey(r3) == true) goto L7;
        return null;
    L7:
        List<String> r4 = r2.get(r3);
        return r4.get(r4.size() - 1);
    L9:
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int r1) {
        Map.Entry<String, String> r0 = getHeaderFieldEntry(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKey();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int r1) {
        Map.Entry<String, String> r0 = getHeaderFieldEntry(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getValue();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        getResponse();
        if (this.instanceFollowRedirects == true) goto L10;
        if (this.mOnRedirectCalled == false) goto L10;
        throw new IOException("Cannot read response body of a redirect.");
    L10:
        if (this.mResponseInfo.getHttpStatusCode() >= 400) goto L14;
        return this.mInputStream;
    L14:
        throw new FileNotFoundException(this.url.toString());
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.mOutputStream != null) goto L27;
        if (this.doOutput == false) goto L27;
        if (this.connected == true) goto L25;
        if (isChunkedUpload() == false) goto L11;
        this.mOutputStream = new CronetChunkedOutputStream(this, this.chunkLength, this.mMessageLoop);
        startRequest();
        goto L27
    L11:
        long r0 = getStreamingModeContentLength();
        if (r0 == (-1)) goto L20;
        CronetFixedModeOutputStream r2 = new CronetFixedModeOutputStream(this, r0, this.mOutputStreamBufferSize, this.mMessageLoop);
        this.mOutputStream = r2;
        if (r0 != 0) goto L19;
        setFixedLengthStreamingMode((int) r2.getUploadDataProvider().getLength());
        if (getRequestProperty("Content-Length") != null) goto L18;
        addRequestProperty("Content-Length", Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L19
    L18:
        setRequestProperty("Content-Length", Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
    L19:
        startRequest();
        goto L27
    L20:
        Log.d(TAG, "Outputstream is being buffered in memory.", new Object[0]);
        String r1 = getRequestProperty("Content-Length");
        if (r1 != null) goto L23;
        this.mOutputStream = new CronetBufferedOutputStream(this);
        goto L27
    L23:
        this.mOutputStream = new CronetBufferedOutputStream(this, Long.parseLong(r1));
        goto L27
    L25:
        throw new ProtocolException("Cannot write to OutputStream after receiving response.");
    L27:
        return this.mOutputStream;
    }

    private long getStreamingModeContentLength() {
        long r0 = this.fixedContentLength;
        if (this.fixedContentLengthLong != (-1)) goto L5;
        return r0;
    L5:
        return this.fixedContentLengthLong;
    }

    private Map<String, String> GetCookieMap(URI r9) {
        HashMap r0 = new HashMap();
        if ((this.mRequestTypeFlags & 2) > 0) goto L59;
        if (isAllowCredentials() == false) goto L59;
        HashMap r1 = new HashMap();
        List<Pair<String, String>> r2 = this.mRequestHeaders;
        if (r2 == null) goto L16;
        Iterator<Pair<String, String>> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Pair<String, String> r4 = r3.next();
        String r5 = (String) r4.first;
        String r6 = (String) r4.second;
        List r7 = (List) r1.get(r5);
        if (r7 != null) goto L15;
        r7 = new LinkedList();
    L15:
        r7.add(r6);
        r1.put(r5, r7);
    L16:
        r1.put(GET_REQUEST_COOKIE_SOURCE_FLAG, new LinkedList());
        Map<String, List<String>> r8 = null;
    L24:
        e = move-exception;
        if (Logger.debug() == false) goto L28;
        Logger.d(TAG, "Loading cookies failed for " + getURL().toString() + " e = " + e.getMessage());
    L28:
        if (r8 != null) goto L30;
    L57:
        return r0;
    L30:
        if (r8.size() <= 0) goto L57;
        Iterator<Map.Entry<String, List<String>>> r10 = r8.entrySet().iterator();
    L33:
        if (r10.hasNext() == false) goto L57;
        Map.Entry<String, List<String>> r11 = r10.next();
        String r12 = r11.getKey();
        int r13 = 0;
        if (GET_REQUEST_COOKIE_SOURCE_FLAG.equals(r12) == true) goto L37;
    L41:
        StringBuilder r14 = new StringBuilder();
        if ("X-SS-Cookie".equalsIgnoreCase(r12) == true) goto L48;
        if ("Cookie".equalsIgnoreCase(r12) == true) goto L48;
        if (SM.COOKIE2.equalsIgnoreCase(r12) == false) goto L33;
    L48:
        if (r11.getValue().isEmpty() == true) goto L33;
        Iterator<String> r15 = r11.getValue().iterator();
    L51:
        if (r15.hasNext() == false) goto L56;
        String r16 = r15.next();
        if (r13 <= 0) goto L55;
        r14.append("; ");
    L55:
        r14.append(r16);
        r13 = r13 + 1;
        goto L51
    L56:
        r0.put(r12, r14.toString());
        goto L33
    L37:
        if (r11.getValue().isEmpty() == true) goto L41;
        this.mRequestCookieSource = Integer.parseInt(r11.getValue().get(0));     // Catch: Throwable -> L40
    L40:
        this.mRequestCookieSource = -1;
        goto L41
    L18:
        if (this.mCookieHandler != null) goto L20;
        this.mCookieHandler = CookieHandler.getDefault();     // Catch: Exception -> L24
    L20:
        CookieHandler r17 = this.mCookieHandler;     // Catch: Exception -> L24
        if (r17 == null) goto L28;
        r8 = r17.get(r9, r1);     // Catch: Exception -> L24
    L59:
        if (Logger.debug() == false) goto L61;
        Logger.d(TAG, "Do not read cookie from TTNet, url:" + r9);
    L61:
        return r0;
    }

    private void saveResponseCookie(String r4, Map<String, List<String>> r5) {
        if (isAllowCredentials() == true) goto L9;
        if (Logger.debug() == false) goto L37;
        Logger.d(TAG, "Do not write cookie from TTNet, url:" + r4);
        return;
    L37:
        return;
    L9:
        if (Logger.debug() == false) goto L36;
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder("Saving cookies for url: ");
        if (TextUtils.isEmpty(r4) == false) goto L13;
        String r2 = getURL().toString();
    L14:
        Logger.d(r0, r1.append(r2).toString());
        goto L36
    L13:
        r2 = r4;
    L36:
    L28:
        e = move-exception;
        if (Logger.debug() == false) goto L41;
        String r3 = TAG;
        StringBuilder r6 = new StringBuilder("Saving cookies failed for ");
        if (TextUtils.isEmpty(r4) == false) goto L34;
        r4 = getURL().toString();
    L34:
        Logger.d(r3, r6.append(r4).append(" e = ").append(e.getMessage()).toString());
        return;
    L41:
        return;
    L16:
        if (this.mCookieHandler != null) goto L19;
        this.mCookieHandler = CookieHandler.getDefault();     // Catch: Exception -> L28
    L19:
        if (this.mCookieHandler != null) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r4) == false) goto L23;
        this.mCookieHandler.put(uri(getURL()), r5);     // Catch: Exception -> L28
        return;
    L23:
        URI r7 = uri(new URL(r4));     // Catch: Exception -> L28
        if ((this.mRequestTypeFlags & 1) != 1) goto L26;
        TreeMap r8 = new TreeMap(r5);     // Catch: Exception -> L28
        r8.put("webview-origin-url", Collections.singletonList(getURL().getHost()));     // Catch: Exception -> L28
        this.mCookieHandler.put(r7, r8);     // Catch: Exception -> L28
        return;
    L26:
        this.mCookieHandler.put(r7, r5);     // Catch: Exception -> L28
    }

    private boolean isAllowCredentials() {
        String r1 = getRequestProperty("x-ttnet-bypass-cookie");
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return true;
    L5:
        if ("0".equals(r1) == false) goto L10;
        return false;
    L10:
        return true;
    }

    public void setRequestPriority(int r1) {
        this.mRequestPriority = r1;
    }

    public void setSocketConnectTimeout(int r1) {
        this.mSocketConnectTimeout = r1;
    }

    public void setSocketReadTimeout(int r1) {
        this.mSocketReadTimeout = r1;
    }

    public void setSocketWriteTimeout(int r1) {
        this.mSocketWriteTimeout = r1;
    }

    public void setRequestTimeout(int r1) {
        this.mRequestTimeout = r1;
    }

    public void setThrottleNetSpeed(long r1) {
        this.mThrottleNetSpeed = r1;
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.setThrottleNetSpeed(r1);
        return;
    }

    public void setRequestTypeFlags(int r2) {
        this.mRequestTypeFlags = r2 | this.mRequestTypeFlags;
    }

    public void setInputStreamBufferSize(int r1) {
        this.mInputStreamBufferSize = r1;
    }

    public void setOutputStreamBufferSize(int r1) {
        this.mOutputStreamBufferSize = r1;
    }

    public int getInputStreamBufferSize() {
        return this.mInputStreamBufferSize;
    }

    public String getRequestLog() {
        if (this.mRequestLog != null) goto L5;
        return "";
    L5:
        return this.mRequestLog;
    }

    public String getFinalUrl() {
        return this.mRequest.getFinalUrl();
    }

    public void onUploadTimeout() {
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.appTimeout();
        return;
    }

    public void setRequestFlag(int r1) {
        this.mRequestFlag = r1;
    }

    public void setAuthCredentials(String r1, String r2) {
        this.mAuthCertUsername = r1;
        this.mAuthCertPassword = r2;
    }

    public void setException(IOException r2) {
        CronetInputStream r0 = this.mInputStream;
        if (r0 == null) goto L5;
        r0.setResponseDataCompleted(r2);
    L5:
        CronetOutputStream r1 = this.mOutputStream;
        if (r1 == null) goto L8;
        r1.setRequestCompleted(r2);
    L8:
        this.mHasResponseHeadersOrCompleted = true;
        this.mException = r2;
        UrlRequest r3 = this.mRequest;
        if (r3 == null) goto L12;
        r3.cancel();
        return;
    }

    public RequestFinishedInfo getRequestFinishedInfo() {
        if (this.mRequestFinishedInfo != null) goto L11;
        if (this.mDisconnected == false) goto L11;
        this.mRequestLogCountDownLatch.await(50, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    L11:
        return this.mRequestFinishedInfo;
    }

    public int getCronetInternalErrorCode() {
        IOException r1 = this.mException;
        if ((r1 instanceof NetworkException) == false) goto L7;
        return ((NetworkException) r1).getCronetInternalErrorCode();
    L7:
        if ((r1 instanceof TTRequestCanceledException) == true) goto L9;
        return 0;
    L9:
        return ((TTRequestCanceledException) r1).getCronetInternalErrorCode();
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String r2) throws ProtocolException {
        if (HttpMethodContrants.PATCH.equals(r2) == true) goto L5;
        super.setRequestMethod(r2);
        return;
    L5:
        if (this.connected == true) goto L8;
        this.method = r2;
        return;
    L8:
        throw new ProtocolException("Can't reset method: already connected");
    }

    public URI uri(URL r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        String r2 = r3.toString();
        return new URI(r2);
    L8:
        e = move-exception;
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return URI.create(r2.substring(0, r2.indexOf("?")));
    L14:
        throw new RuntimeException(e);
    }

    private IOException tryConvertCronetException(CronetException r3) {
        if ((r3 instanceof NetworkException) == true) goto L6;
        return r3;
    L6:
        switch(((NetworkException) r3).getErrorCode()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L17;
        };
    L8:
        IOException r2 = new NoRouteToHostException(r3.getMessage());
    L16:
        return r2;
    L9:
        r2 = new SocketException("reset by peer " + r3.getMessage());
        goto L16
    L10:
        r2 = new ConnectTimeoutException(r3.getMessage());
        goto L16
    L11:
        r2 = new ConnectException(r3.getMessage());
        goto L16
    L12:
        r2 = new SocketTimeoutException(r3.getMessage());
        goto L16
    L13:
        r2 = new ConnectException(r3.getMessage());
        goto L16
    L14:
        r2 = new UnknownHostException(r3.getMessage());
        goto L16
    L17:
        return r3;
    }

    private void cronet_loop(int r5) throws IOException {
        this.mMessageLoop.loop(r5);     // Catch: Exception -> L4 SocketTimeoutException -> L8
    L17:
        return;
    L8:
        UrlRequest r0 = this.mRequest;
        if (r0 == null) goto L16;
        r0.appTimeout();
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r5 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        setException(new IOException("Unexpected request usage, caught in CronetHttpURLConnection, caused by " + e));
        if (this.mRequest == null) goto L14;
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r5 / 2);
        return;
    }

    private void startRequest() throws IOException {
        if (this.connected == false) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("CronetHttpURLConnection", "start request url = " + getURL().toString());
    L8:
        ExperimentalUrlRequest.Builder r0 = (ExperimentalUrlRequest.Builder) this.mCronetEngine.newUrlRequestBuilder(getURL().toString(), new CronetUrlRequestCallback(this), this.mMessageLoop);
        if (this.doOutput == true) goto L11;
    L27:
        long r1 = System.nanoTime();
        Map<String, String> r3 = GetCookieMap(uri(getURL()));
        if (r3 != null) goto L30;
    L35:
        long r4 = (System.nanoTime() - r1) / 1000;
        Iterator<Pair<String, String>> r2 = this.mRequestHeaders.iterator();
    L37:
        if (r2.hasNext() == false) goto L40;
        Pair<String, String> r5 = r2.next();
        r0.addHeader((String) r5.first, (String) r5.second);
        goto L37
    L40:
        if (getUseCaches() == true) goto L42;
        r0.disableCache();
    L42:
        r0.setHttpMethod(this.method);
        if (checkTrafficStatsTag() == false) goto L46;
        r0.setTrafficStatsTag(this.mTrafficStatsTag);
    L46:
        if (checkTrafficStatsUid() == false) goto L48;
        r0.setTrafficStatsUid(this.mTrafficStatsUid);
    L48:
        r0.setPriority(this.mRequestPriority);
        r0.setSocketConnectTimeout(this.mSocketConnectTimeout);
        r0.setSocketReadTimeout(this.mSocketReadTimeout);
        r0.setSocketWriteTimeout(this.mSocketWriteTimeout);
        r0.setRequestTimeout(this.mRequestTimeout);
        ExperimentalUrlRequest r6 = r0.build();
        this.mRequest = r6;
        int r7 = this.mRequestFlag;
        if (r7 == 0) goto L51;
        r6.setRequestFlag(r7);
    L51:
        int r8 = this.mRequestTypeFlags;
        if (r8 <= 0) goto L54;
        this.mRequest.setRequestTypeFlags(r8);
    L54:
        String r9 = this.mAuthCertUsername;
        if (r9 == null) goto L59;
        String r10 = this.mAuthCertPassword;
        if (r10 == null) goto L59;
        this.mRequest.setAuthCredentials(r9, r10);
    L59:
        this.mRequest.setAddCookieCostUs(r4);
        this.mRequest.setRequestCookieSource(this.mRequestCookieSource);
        this.mRequest.start();
        long r11 = this.mThrottleNetSpeed;
        if (r11 <= 0) goto L62;
        this.mRequest.setThrottleNetSpeed(r11);
    L62:
        this.connected = true;
        return;
    L30:
        if (r3.isEmpty() == true) goto L35;
        Iterator<Map.Entry<String, String>> r12 = r3.entrySet().iterator();
    L33:
        if (r12.hasNext() == false) goto L35;
        Map.Entry<String, String> r13 = r12.next();
        r0.addHeader(r13.getKey(), r13.getValue());
        goto L33
    L11:
        if (this.method.equals(HttpMethodContrants.GET) == false) goto L13;
        this.method = "POST";
    L13:
        CronetOutputStream r14 = this.mOutputStream;
        if (r14 == null) goto L22;
        r0.setUploadDataProvider(r14.getUploadDataProvider(), this.mMessageLoop);
        if (getRequestProperty("Content-Length") == null) goto L18;
    L20:
        this.mOutputStream.setConnected();
    L25:
        if (getRequestProperty("Content-Type") != null) goto L27;
        addRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        goto L27
    L18:
        if (isChunkedUpload() == true) goto L20;
        addRequestProperty("Content-Length", Long.toString(this.mOutputStream.getUploadDataProvider().getLength()));
        goto L20
    L22:
        if (getRequestProperty("Content-Length") != null) goto L25;
        addRequestProperty("Content-Length", "0");
        goto L25
    }

    private boolean checkTrafficStatsTag() {
        if (this.mTrafficStatsTagSet == false) goto L5;
        return true;
    L5:
        int r0 = TrafficStats.getThreadStatsTag();
        if (r0 == (-1)) goto L9;
        this.mTrafficStatsTag = r0;
        this.mTrafficStatsTagSet = true;
    L9:
        return this.mTrafficStatsTagSet;
    }

    private boolean checkTrafficStatsUid() {
        if (this.mTrafficStatsUidSet == false) goto L5;
        return true;
    L5:
        int r0 = TrafficStats.getThreadStatsUid();
        if (r0 == (-1)) goto L9;
        this.mTrafficStatsUid = r0;
        this.mTrafficStatsUidSet = true;
    L9:
        return this.mTrafficStatsUidSet;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        getResponse();     // Catch: IOException -> L9
        if (this.mResponseInfo.getHttpStatusCode() < 400) goto L8;
        return this.mInputStream;
    L8:
        return null;
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String r2, String r3) {
        setRequestPropertyInternal(r2, r3, false);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String r2, String r3) {
        setRequestPropertyInternal(r2, r3, true);
    }

    private final void setRequestPropertyInternal(String r2, String r3, boolean r4) {
        if (this.connected == true) goto L13;
        int r0 = findRequestProperty(r2);
        if (r0 < 0) goto L10;
        if (r4 == false) goto L9;
        this.mRequestHeaders.remove(r0);
        goto L10
    L9:
        throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + r2 + ". crbug.com/432719.");
    L10:
        this.mRequestHeaders.add(Pair.create(r2, r3));
        return;
    L13:
        throw new IllegalStateException("Cannot modify request property after connection is made.");
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (this.connected == true) goto L15;
        TreeMap r0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Pair<String, String>> r4 = this.mRequestHeaders.iterator();
    L6:
        if (r4.hasNext() == false) goto L13;
        Pair<String, String> r1 = r4.next();
        if (r0.containsKey(r1.first) == true) goto L11;
        ArrayList r2 = new ArrayList();
        r2.add((String) r1.second);
        r0.put((String) r1.first, Collections.unmodifiableList(r2));
        goto L6
    L11:
        throw new IllegalStateException("Should not have multiple values.");
    L13:
        return Collections.unmodifiableMap(r0);
    L15:
        throw new IllegalStateException("Cannot access request headers after connection is set.");
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String r1) {
        int r2 = findRequestProperty(r1);
        if (r2 >= 0) goto L5;
        return null;
    L5:
        return (String) this.mRequestHeaders.get(r2).second;
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int r1) {
        super.setConnectTimeout(r1);
    }

    void getMoreData(ByteBuffer r2) throws IOException {
        UrlRequest r0 = this.mRequest;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.read(r2);
        cronet_loop(getReadTimeout());
    }

    public void setTrafficStatsTag(int r2) {
        if (this.connected == true) goto L7;
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r2;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats tag after connection is made.");
    }

    public void setTrafficStatsUid(int r2) {
        if (this.connected == true) goto L7;
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r2;
        return;
    L7:
        throw new IllegalStateException("Cannot modify traffic stats UID after connection is made.");
    }

    private int findRequestProperty(String r3) {
        int r0 = 0;
    L4:
        if (r0 >= this.mRequestHeaders.size()) goto L9;
        if (((String) this.mRequestHeaders.get(r0).first).equalsIgnoreCase(r3) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    private void getResponse() throws IOException {
        CronetOutputStream r0 = this.mOutputStream;
        if (r0 == null) goto L8;
        r0.checkReceivedEnoughContent();
        if (isChunkedUpload() == false) goto L8;
        this.mOutputStream.close();
    L8:
        if (this.mHasResponseHeadersOrCompleted == true) goto L13;
        startRequest();
        if (Logger.debug() == false) goto L12;
        Logger.d("CronetHttpURLConnection", "getResponse loop url = " + getURL().toString());
    L12:
        cronet_loop(getConnectTimeout() + getReadTimeout());
        this.mHasResponseHeadersOrCompleted = true;
    L13:
        checkHasResponseHeaders();
    }

    private void checkHasResponseHeaders() throws IOException {
        if (this.mHasResponseHeadersOrCompleted == false) goto L13;
        IOException r0 = this.mException;
        if (r0 == null) goto L7;
        throw r0;
    L7:
        if (this.mResponseInfo == null) goto L10;
        return;
    L10:
        throw new NullPointerException("Response info is null when there is no exception.");
    L13:
        throw new IllegalStateException("No response.");
    }

    private Map.Entry<String, String> getHeaderFieldEntry(int r3) {
        getResponse();     // Catch: IOException -> L9
        List<Map.Entry<String, String>> r2 = getAllHeadersAsList();
        if (r3 < r2.size()) goto L8;
        return null;
    L8:
        return r2.get(r3);
    L9:
        return null;
    }

    private boolean isChunkedUpload() {
        if (this.chunkLength <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private Map<String, List<String>> getAllHeaders() {
        Map<String, List<String>> r0 = this.mResponseHeadersMap;
        if (r0 == null) goto L5;
        return r0;
    L5:
        TreeMap r1 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Map.Entry<String, String>> r2 = getAllHeadersAsList().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        Map.Entry<String, String> r3 = r2.next();
        ArrayList r4 = new ArrayList();
        if (r1.containsKey(r3.getKey()) == false) goto L11;
        r4.addAll((Collection) r1.get(r3.getKey()));
    L11:
        r4.add(r3.getValue());
        r1.put(r3.getKey(), Collections.unmodifiableList(r4));
        goto L7
    L12:
        Map<String, List<String>> r5 = Collections.unmodifiableMap(r1);
        this.mResponseHeadersMap = r5;
        return r5;
    }

    private List<Map.Entry<String, String>> getAllHeadersAsList() {
        List<Map.Entry<String, String>> r0 = this.mResponseHeadersList;
        if (r0 == null) goto L5;
        return r0;
    L5:
        this.mResponseHeadersList = new ArrayList();
        Iterator<Map.Entry<String, String>> r1 = this.mResponseInfo.getAllHeadersAsList().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry<String, String> r2 = r1.next();
        this.mResponseHeadersList.add(new AbstractMap.SimpleImmutableEntry(r2));
        goto L7
    L9:
        List<Map.Entry<String, String>> r3 = Collections.unmodifiableList(this.mResponseHeadersList);
        this.mResponseHeadersList = r3;
        return r3;
    }
}
