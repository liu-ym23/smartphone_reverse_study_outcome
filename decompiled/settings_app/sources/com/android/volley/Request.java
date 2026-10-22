package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.settings.utils.HanziToPinyin;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public abstract class Request<T> implements Comparable<Request<T>> {
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private Cache.Entry mCacheEntry;
    private boolean mCanceled;
    private final int mDefaultTrafficStatsTag;
    private Response.ErrorListener mErrorListener;
    private final VolleyLog.MarkerLog mEventLog;
    private final Object mLock;
    private final int mMethod;
    private NetworkRequestCompleteListener mRequestCompleteListener;
    private RequestQueue mRequestQueue;
    private boolean mResponseDelivered;
    private RetryPolicy mRetryPolicy;
    private Integer mSequence;
    private boolean mShouldCache;
    private boolean mShouldRetryConnectionErrors;
    private boolean mShouldRetryServerErrors;
    private Object mTag;
    private final String mUrl;

    public interface Method {
        public static final int DELETE = 3;
        public static final int DEPRECATED_GET_OR_POST = -1;
        public static final int GET = 0;
        public static final int HEAD = 4;
        public static final int OPTIONS = 5;
        public static final int PATCH = 7;
        public static final int POST = 1;
        public static final int PUT = 2;
        public static final int TRACE = 6;
    }

    interface NetworkRequestCompleteListener {
        void onNoUsableResponseReceived(Request<?> r1);

        void onResponseReceived(Request<?> r1, Response<?> r2);
    }

    public static final enum Priority extends Enum<Priority> {
        private static final /* synthetic */ Priority[] $VALUES = null;
        public static final Priority HIGH = null;
        public static final Priority IMMEDIATE = null;
        public static final Priority LOW = null;
        public static final Priority NORMAL = null;

        private Priority(String r1, int r2) {
            super(r1, r2);
        }

        public static Priority valueOf(String r1) {
            return (Priority) Enum.valueOf(Priority.class, r1);
        }

        public static Priority[] values() {
            return (Priority[]) $VALUES.clone();
        }

        static {
            Priority r0 = new Priority("LOW", 0);
            LOW = r0;
            Priority r1 = new Priority("NORMAL", 1);
            NORMAL = r1;
            Priority r3 = new Priority("HIGH", 2);
            HIGH = r3;
            Priority r5 = new Priority("IMMEDIATE", 3);
            IMMEDIATE = r5;
            $VALUES = new Priority[]{r0, r1, r3, r5};
        }
    }

    protected abstract void deliverResponse(T r1);

    protected Map<String, String> getParams() throws AuthFailureError {
        return null;
    }

    protected String getParamsEncoding() {
        return "UTF-8";
    }

    protected VolleyError parseNetworkError(VolleyError r1) {
        return r1;
    }

    protected abstract Response<T> parseNetworkResponse(NetworkResponse r1);

    static /* synthetic */ VolleyLog.MarkerLog access$000(Request r0) {
        return r0.mEventLog;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r1) {
        return compareTo((Request) r1);
    }

    @Deprecated
    public Request(String r2, Response.ErrorListener r3) {
        this(-1, r2, r3);
    }

    public Request(int r3, String r4, Response.ErrorListener r5) {
        if (VolleyLog.MarkerLog.ENABLED == false) goto L5;
        VolleyLog.MarkerLog r0 = new VolleyLog.MarkerLog();
    L6:
        this.mEventLog = r0;
        this.mLock = new Object();
        this.mShouldCache = true;
        this.mCanceled = false;
        this.mResponseDelivered = false;
        this.mShouldRetryServerErrors = false;
        this.mShouldRetryConnectionErrors = false;
        this.mCacheEntry = null;
        this.mMethod = r3;
        this.mUrl = r4;
        this.mErrorListener = r5;
        setRetryPolicy(new DefaultRetryPolicy());
        this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public int getMethod() {
        return this.mMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object r1) {
        this.mTag = r1;
        return this;
    }

    public Object getTag() {
        return this.mTag;
    }

    public Response.ErrorListener getErrorListener() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Response.ErrorListener r1 = this.mErrorListener;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getTrafficStatsTag() {
        return this.mDefaultTrafficStatsTag;
    }

    private static int findDefaultTrafficStatsTag(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L10;
        Uri r2 = Uri.parse(r1);
        if (r2 == null) goto L12;
        String r3 = r2.getHost();
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.hashCode();
    L12:
        return 0;
    L10:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(RetryPolicy r1) {
        this.mRetryPolicy = r1;
        return this;
    }

    public void addMarker(String r3) {
        if (VolleyLog.MarkerLog.ENABLED == false) goto L6;
        this.mEventLog.add(r3, Thread.currentThread().getId());
        return;
    }

    void finish(final String r5) {
        RequestQueue r0 = this.mRequestQueue;
        if (r0 == null) goto L6;
        r0.finish(this);
    L6:
        if (VolleyLog.MarkerLog.ENABLED == false) goto L13;
        final long r1 = Thread.currentThread().getId();
        if (Looper.myLooper() == Looper.getMainLooper()) goto L11;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this, r5, r1));
        return;
    L11:
        this.mEventLog.add(r5, r1);
        this.mEventLog.finish(toString());
        return;
    }

    void sendEvent(int r2) {
        RequestQueue r0 = this.mRequestQueue;
        if (r0 == null) goto L6;
        r0.sendRequestEvent(this, r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(RequestQueue r1) {
        this.mRequestQueue = r1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int r1) {
        this.mSequence = Integer.valueOf(r1);
        return this;
    }

    public final int getSequence() {
        Integer r1 = this.mSequence;
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getCacheKey() {
        String r0 = getUrl();
        int r2 = getMethod();
        if (r2 != 0) goto L5;
    L9:
        return r0;
    L5:
        if (r2 == (-1)) goto L9;
        return Integer.toString(r2) + '-' + r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(Cache.Entry r1) {
        this.mCacheEntry = r1;
        return this;
    }

    public Cache.Entry getCacheEntry() {
        return this.mCacheEntry;
    }

    public void cancel() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCanceled = true;     // Catch: Throwable -> L8
        this.mErrorListener = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isCanceled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mCanceled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return Collections.emptyMap();
    }

    @Deprecated
    protected Map<String, String> getPostParams() throws AuthFailureError {
        return getParams();
    }

    @Deprecated
    protected String getPostParamsEncoding() {
        return getParamsEncoding();
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Deprecated
    public byte[] getPostBody() throws AuthFailureError {
        Map<String, String> r0 = getPostParams();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() > 0) goto L7;
        return null;
    L7:
        return encodeParameters(r0, getPostParamsEncoding());
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }

    public byte[] getBody() throws AuthFailureError {
        Map<String, String> r0 = getParams();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.size() > 0) goto L7;
        return null;
    L7:
        return encodeParameters(r0, getParamsEncoding());
    }

    private byte[] encodeParameters(Map<String, String> r5, String r6) {
        StringBuilder r4 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r7 = r5.entrySet().iterator();     // Catch: UnsupportedEncodingException -> L15
    L5:
        if (r7.hasNext() == false) goto L14;
        Map.Entry<String, String> r0 = r7.next();     // Catch: UnsupportedEncodingException -> L15
        if (r0.getKey() == null) goto L12;
        if (r0.getValue() == null) goto L12;
        r4.append(URLEncoder.encode(r0.getKey(), r6));     // Catch: UnsupportedEncodingException -> L15
        r4.append('=');     // Catch: UnsupportedEncodingException -> L15
        r4.append(URLEncoder.encode(r0.getValue(), r6));     // Catch: UnsupportedEncodingException -> L15
        r4.append(Typography.amp);     // Catch: UnsupportedEncodingException -> L15
    L12:
        throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", new Object[]{r0.getKey(), r0.getValue()}));     // Catch: UnsupportedEncodingException -> L15
    L14:
        return r4.toString().getBytes(r6);
    L15:
        e = move-exception;
        throw new RuntimeException("Encoding not supported: " + r6, e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean r1) {
        this.mShouldCache = r1;
        return this;
    }

    public final boolean shouldCache() {
        return this.mShouldCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldRetryServerErrors(boolean r1) {
        this.mShouldRetryServerErrors = r1;
        return this;
    }

    public final boolean shouldRetryServerErrors() {
        return this.mShouldRetryServerErrors;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldRetryConnectionErrors(boolean r1) {
        this.mShouldRetryConnectionErrors = r1;
        return this;
    }

    public final boolean shouldRetryConnectionErrors() {
        return this.mShouldRetryConnectionErrors;
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public final int getTimeoutMs() {
        return getRetryPolicy().getCurrentTimeout();
    }

    public RetryPolicy getRetryPolicy() {
        return this.mRetryPolicy;
    }

    public void markDelivered() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mResponseDelivered = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean hasHadResponseDelivered() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mResponseDelivered;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void deliverError(VolleyError r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Response.ErrorListener r1 = this.mErrorListener;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        r1.onErrorResponse(r2);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void setNetworkRequestCompleteListener(NetworkRequestCompleteListener r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRequestCompleteListener = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void notifyListenerResponseReceived(Response<?> r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        NetworkRequestCompleteListener r1 = this.mRequestCompleteListener;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        r1.onResponseReceived(this, r3);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void notifyListenerResponseNotUsable() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        NetworkRequestCompleteListener r1 = this.mRequestCompleteListener;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        r1.onNoUsableResponseReceived(this);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public int compareTo(Request<T> r3) {
        Priority r0 = getPriority();
        Priority r1 = r3.getPriority();
        if (r0 != r1) goto L5;
        int r2 = this.mSequence.intValue();
        int r4 = r3.mSequence.intValue();
    L7:
        return r2 - r4;
    L5:
        r2 = r1.ordinal();
        r4 = r0.ordinal();
        goto L7
    }

    public String toString() {
        String r0 = "0x" + Integer.toHexString(getTrafficStatsTag());
        StringBuilder r1 = new StringBuilder();
        if (isCanceled() == false) goto L5;
        String r2 = "[X] ";
    L7:
        return r1.append(r2).append(getUrl()).append(HanziToPinyin.Token.SEPARATOR).append(r0).append(HanziToPinyin.Token.SEPARATOR).append(getPriority()).append(HanziToPinyin.Token.SEPARATOR).append(this.mSequence).toString();
    L5:
        r2 = "[ ] ";
        goto L7
    }
}
