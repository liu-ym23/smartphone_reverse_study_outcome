package com.ttnet.org.chromium.net.impl;

import android.net.TrafficStats;
import android.util.Log;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
final class JavaUrlRequest extends UrlRequestBase {
    private static final int DEFAULT_CHUNK_LENGTH = 8192;
    private static final String TAG = "JavaUrlRequest";
    private static final String USER_AGENT = "User-Agent";
    private static final String X_ANDROID = "X-Android";
    private static final String X_ANDROID_SELECTED_TRANSPORT = "X-Android-Selected-Transport";
    private volatile int mAdditionalStatusDetails;
    private final boolean mAllowDirectExecutor;
    private final AsyncUrlRequestCallback mCallbackAsync;
    private final int mCronetEngineId;
    private String mCurrentUrl;
    private HttpURLConnection mCurrentUrlConnection;
    private final Executor mExecutor;
    private String mInitialMethod;
    private final CronetLogger mLogger;
    private OutputStreamDataSink mOutputStreamDataSink;
    private String mPendingRedirectUrl;
    private final Map<String, String> mRequestHeaders;
    private ReadableByteChannel mResponseChannel;
    private final AtomicInteger mState;
    private VersionSafeCallbacks.UploadDataProviderWrapper mUploadDataProvider;
    private Executor mUploadExecutor;
    private final AtomicBoolean mUploadProviderClosed;
    private final List<String> mUrlChain;
    private UrlResponseInfoImpl mUrlResponseInfo;
    private final String mUserAgent;

    private final class AsyncUrlRequestCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final VersionSafeCallbacks.UrlRequestCallback mCallback;
        final Executor mFallbackExecutor;
        final Executor mUserExecutor;
        final /* synthetic */ JavaUrlRequest this$0;

        static {
        }

        static /* synthetic */ void access$3900(AsyncUrlRequestCallback r0) {
            r0.maybeReportMetrics();
        }

        AsyncUrlRequestCallback(JavaUrlRequest r2, UrlRequest.Callback r3, Executor r4) {
            this.this$0 = r2;
            this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(r3);
            if (JavaUrlRequest.access$3200(r2) == false) goto L5;
            this.mUserExecutor = r4;
            this.mFallbackExecutor = null;
            return;
        L5:
            this.mUserExecutor = new JavaUrlRequestUtils.DirectPreventingExecutor(r4);
            this.mFallbackExecutor = r4;
        }

        void sendStatus(final VersionSafeCallbacks.UrlRequestStatusListener r3, final int r4) {
            this.mUserExecutor.execute(new AnonymousClass1(this, r3, r4));
        }

        void execute(JavaUrlRequestUtils.CheckedRunnable r3) {
            this.mUserExecutor.execute(JavaUrlRequest.access$3300(this.this$0, r3));     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            JavaUrlRequest.access$3400(this.this$0, new CronetExceptionImpl("Exception posting task to executor", e));
        }

        void onRedirectReceived(final UrlResponseInfo r2, final String r3) {
            execute(new AnonymousClass2(this, r2, r3));
        }

        void onResponseStarted(UrlResponseInfo r1) {
            execute(new AnonymousClass3(this));
        }

        void onReadCompleted(final UrlResponseInfo r2, final ByteBuffer r3) {
            execute(new AnonymousClass4(this, r2, r3));
        }

        private CronetLogger.CronetTrafficInfo buildCronetTrafficInfo() {
            if (JavaUrlRequest.access$1400(this.this$0) == null) goto L5;
            Map<String, List<String>> r1 = JavaUrlRequest.access$1400(this.this$0).getAllHeaders();
            String r3 = JavaUrlRequest.access$1400(this.this$0).getNegotiatedProtocol();
            int r4 = JavaUrlRequest.access$1400(this.this$0).getHttpStatusCode();
            boolean r5 = JavaUrlRequest.access$1400(this.this$0).wasCached();
            String r15 = r3;
            int r12 = r4;
        L7:
            if (r5 == false) goto L9;
            long r8 = 0;
            long r10 = 0;
        L10:
            if (r5 == false) goto L12;
            long r0 = 0;
            long r13 = 0;
        L17:
            return new CronetLogger.CronetTrafficInfo(r8, r10, r13, r0, r12, Duration.ofSeconds(0), Duration.ofSeconds(0), r15, false, false);
        L12:
            r13 = JavaUrlRequest.estimateHeadersSizeInBytesList(r1);
            if (r1.containsKey("Content-Length") == false) goto L15;
            r0 = JavaUrlRequest.access$3500(r1.get("Content-Length").get(0));
            goto L17
        L15:
            r0 = -1;
            goto L17
        L9:
            r8 = JavaUrlRequest.estimateHeadersSizeInBytes(JavaUrlRequest.access$2200(this.this$0));
            r10 = -1;
            goto L10
        L5:
            r1 = Collections.emptyMap();
            r5 = false;
            r12 = 0;
            r15 = "";
            goto L7
        }

        private void maybeReportMetrics() {
            JavaUrlRequest.access$3700(this.this$0).logCronetTrafficInfo(JavaUrlRequest.access$3600(this.this$0), buildCronetTrafficInfo());     // Catch: RuntimeException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(JavaUrlRequest.access$3100(), "Error while trying to log CronetTrafficInfo: ", e);
        }

        void onCanceled(final UrlResponseInfo r3) {
            JavaUrlRequest.access$3800(this.this$0);
            this.mUserExecutor.execute(new AnonymousClass5(this, r3));
        }

        void onSucceeded(final UrlResponseInfo r3) {
            this.mUserExecutor.execute(new AnonymousClass6(this, r3));
        }

        void onFailed(final UrlResponseInfo r2, final CronetException r3) {
            JavaUrlRequest.access$3800(this.this$0);
            Runnable r0 = new AnonymousClass7(this, r2, r3);
            this.mUserExecutor.execute(r0);     // Catch: InlineExecutionProhibitedException -> L5
            return;
        L5:
            Executor r1 = this.mFallbackExecutor;
            if (r1 == null) goto L11;
            r1.execute(r0);
            return;
        }
    }

    private final class OutputStreamDataSink extends JavaUploadDataSinkBase {
        private WritableByteChannel mOutputChannel;
        private final AtomicBoolean mOutputChannelClosed;
        private final HttpURLConnection mUrlConnection;
        private OutputStream mUrlConnectionOutputStream;
        final /* synthetic */ JavaUrlRequest this$0;

        OutputStreamDataSink(JavaUrlRequest r1, Executor r2, Executor r3, HttpURLConnection r4, VersionSafeCallbacks.UploadDataProviderWrapper r5) {
            this.this$0 = r1;
            super(r2, r3, r5);
            this.mOutputChannelClosed = new AtomicBoolean(false);
            this.mUrlConnection = r4;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void initializeRead() throws IOException {
            if (this.mOutputChannel != null) goto L6;
            JavaUrlRequest.access$402(this.this$0, 10);
            this.mUrlConnection.setDoOutput(true);
            this.mUrlConnection.connect();
            JavaUrlRequest.access$402(this.this$0, 12);
            OutputStream r0 = this.mUrlConnection.getOutputStream();
            this.mUrlConnectionOutputStream = r0;
            this.mOutputChannel = Channels.newChannel(r0);
            return;
        }

        void closeOutputChannel() throws IOException {
            if (this.mOutputChannel != null) goto L5;
            return;
        L5:
            if (this.mOutputChannelClosed.compareAndSet(false, true) == false) goto L9;
            this.mOutputChannel.close();
            return;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void finish() throws IOException {
            closeOutputChannel();
            JavaUrlRequest.access$500(this.this$0);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void initializeStart(long r3) {
            if (r3 <= 0) goto L5;
            this.mUrlConnection.setFixedLengthStreamingMode(r3);
            return;
        L5:
            this.mUrlConnection.setChunkedStreamingMode(8192);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected int processSuccessfulRead(ByteBuffer r3) throws IOException {
            int r0 = 0;
        L4:
            if (r3.hasRemaining() == false) goto L6;
            r0 = r0 + this.mOutputChannel.write(r3);
            goto L4
        L6:
            this.mUrlConnectionOutputStream.flush();
            return r0;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected Runnable getErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r1) {
            return JavaUrlRequest.access$600(this.this$0, r1);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected Runnable getUploadErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r1) {
            return JavaUrlRequest.access$700(this.this$0, r1);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void processUploadError(Throwable r1) {
            JavaUrlRequest.access$800(this.this$0, r1);
        }
    }

    private static final class SerializingExecutor implements Executor {
        private final Runnable mRunTasks;
        private boolean mRunning;
        private final ArrayDeque<Runnable> mTaskQueue;
        private final Executor mUnderlyingExecutor;

        static /* synthetic */ ArrayDeque access$000(SerializingExecutor r0) {
            return r0.mTaskQueue;
        }

        static /* synthetic */ boolean access$100(SerializingExecutor r0) {
            return r0.mRunning;
        }

        static /* synthetic */ boolean access$102(SerializingExecutor r0, boolean r1) {
            r0.mRunning = r1;
            return r1;
        }

        static /* synthetic */ Runnable access$200(SerializingExecutor r0) {
            return r0.mRunTasks;
        }

        static /* synthetic */ Executor access$300(SerializingExecutor r0) {
            return r0.mUnderlyingExecutor;
        }

        SerializingExecutor(Executor r2) {
            this.mRunTasks = new AnonymousClass1(this);
            this.mTaskQueue = new ArrayDeque();
            this.mUnderlyingExecutor = r2;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            ArrayDeque<Runnable> r0 = this.mTaskQueue;
            monitor-enter(r0);
            this.mTaskQueue.addLast(r3);     // Catch: Throwable -> L10
            this.mUnderlyingExecutor.execute(this.mRunTasks);     // Catch: RejectedExecutionException -> L7 Throwable -> L10
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L7:
            this.mTaskQueue.removeLast();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void AddRequestCookieHeader(String r1, String r2) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void RemoveRequestCookieHeader() {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getFinalUrl() {
        return "";
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getRequestLog() {
        return "";
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAddCookieCostUs(long r1) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAuthCredentials(String r1, String r2) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestCookieSource(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setRequestTimeout(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestTypeFlags(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setSaveCookieCostUs(long r1) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketConnectTimeout(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketReadTimeout(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketWriteTimeout(int r1) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setThrottleNetSpeed(long r1) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void stopRedirect() {
    }

    static /* synthetic */ List access$1000(JavaUrlRequest r0) {
        return r0.mUrlChain;
    }

    static /* synthetic */ void access$1100(JavaUrlRequest r0) {
        r0.fireOpenConnection();
    }

    static /* synthetic */ String access$1200(JavaUrlRequest r0) {
        return r0.mPendingRedirectUrl;
    }

    static /* synthetic */ String access$1202(JavaUrlRequest r0, String r1) {
        r0.mPendingRedirectUrl = r1;
        return r1;
    }

    static /* synthetic */ HttpURLConnection access$1300(JavaUrlRequest r0) {
        return r0.mCurrentUrlConnection;
    }

    static /* synthetic */ HttpURLConnection access$1302(JavaUrlRequest r0, HttpURLConnection r1) {
        r0.mCurrentUrlConnection = r1;
        return r1;
    }

    static /* synthetic */ UrlResponseInfoImpl access$1400(JavaUrlRequest r0) {
        return r0.mUrlResponseInfo;
    }

    static /* synthetic */ UrlResponseInfoImpl access$1402(JavaUrlRequest r0, UrlResponseInfoImpl r1) {
        r0.mUrlResponseInfo = r1;
        return r1;
    }

    static /* synthetic */ void access$1500(JavaUrlRequest r0, String r1) {
        r0.fireRedirectReceived(r1);
    }

    static /* synthetic */ void access$1600(JavaUrlRequest r0) {
        r0.fireCloseUploadDataProvider();
    }

    static /* synthetic */ ReadableByteChannel access$1700(JavaUrlRequest r0) {
        return r0.mResponseChannel;
    }

    static /* synthetic */ ReadableByteChannel access$1702(JavaUrlRequest r0, ReadableByteChannel r1) {
        r0.mResponseChannel = r1;
        return r1;
    }

    static /* synthetic */ AsyncUrlRequestCallback access$1800(JavaUrlRequest r0) {
        return r0.mCallbackAsync;
    }

    static /* synthetic */ VersionSafeCallbacks.UploadDataProviderWrapper access$1900(JavaUrlRequest r0) {
        return r0.mUploadDataProvider;
    }

    static /* synthetic */ void access$2000(JavaUrlRequest r0, int r1, int r2, Runnable r3) {
        r0.transitionStates(r1, r2, r3);
    }

    static /* synthetic */ AtomicInteger access$2100(JavaUrlRequest r0) {
        return r0.mState;
    }

    static /* synthetic */ Map access$2200(JavaUrlRequest r0) {
        return r0.mRequestHeaders;
    }

    static /* synthetic */ String access$2300(JavaUrlRequest r0) {
        return r0.mUserAgent;
    }

    static /* synthetic */ String access$2400(JavaUrlRequest r0) {
        return r0.mInitialMethod;
    }

    static /* synthetic */ String access$2402(JavaUrlRequest r0, String r1) {
        r0.mInitialMethod = r1;
        return r1;
    }

    static /* synthetic */ OutputStreamDataSink access$2500(JavaUrlRequest r0) {
        return r0.mOutputStreamDataSink;
    }

    static /* synthetic */ OutputStreamDataSink access$2502(JavaUrlRequest r0, OutputStreamDataSink r1) {
        r0.mOutputStreamDataSink = r1;
        return r1;
    }

    static /* synthetic */ Executor access$2600(JavaUrlRequest r0) {
        return r0.mUploadExecutor;
    }

    static /* synthetic */ Executor access$2700(JavaUrlRequest r0) {
        return r0.mExecutor;
    }

    static /* synthetic */ void access$2800(JavaUrlRequest r0, Throwable r1) {
        r0.enterCronetErrorState(r1);
    }

    static /* synthetic */ void access$2900(JavaUrlRequest r0, Throwable r1) {
        r0.enterUserErrorState(r1);
    }

    static /* synthetic */ void access$3000(JavaUrlRequest r0, int r1, ByteBuffer r2) throws IOException {
        r0.processReadResult(r1, r2);
    }

    static /* synthetic */ String access$3100() {
        return TAG;
    }

    static /* synthetic */ boolean access$3200(JavaUrlRequest r0) {
        return r0.mAllowDirectExecutor;
    }

    static /* synthetic */ Runnable access$3300(JavaUrlRequest r0, JavaUrlRequestUtils.CheckedRunnable r1) {
        return r0.userErrorSetting(r1);
    }

    static /* synthetic */ void access$3400(JavaUrlRequest r0, CronetException r1) {
        r0.enterErrorState(r1);
    }

    static /* synthetic */ long access$3500(String r2) {
        return parseContentLengthString(r2);
    }

    static /* synthetic */ int access$3600(JavaUrlRequest r0) {
        return r0.mCronetEngineId;
    }

    static /* synthetic */ CronetLogger access$3700(JavaUrlRequest r0) {
        return r0.mLogger;
    }

    static /* synthetic */ void access$3800(JavaUrlRequest r0) {
        r0.closeResponseChannel();
    }

    static /* synthetic */ int access$402(JavaUrlRequest r0, int r1) {
        r0.mAdditionalStatusDetails = r1;
        return r1;
    }

    static /* synthetic */ void access$500(JavaUrlRequest r0) {
        r0.fireGetHeaders();
    }

    static /* synthetic */ Runnable access$600(JavaUrlRequest r0, JavaUrlRequestUtils.CheckedRunnable r1) {
        return r0.errorSetting(r1);
    }

    static /* synthetic */ Runnable access$700(JavaUrlRequest r0, JavaUrlRequestUtils.CheckedRunnable r1) {
        return r0.uploadErrorSetting(r1);
    }

    static /* synthetic */ void access$800(JavaUrlRequest r0, Throwable r1) {
        r0.enterUploadErrorState(r1);
    }

    static /* synthetic */ String access$900(JavaUrlRequest r0) {
        return r0.mCurrentUrl;
    }

    static /* synthetic */ String access$902(JavaUrlRequest r0, String r1) {
        r0.mCurrentUrl = r1;
        return r1;
    }

    JavaUrlRequest(JavaCronetEngine r11, UrlRequest.Callback r12, final Executor r13, Executor r14, String r15, String r16, boolean r17, boolean r18, int r19, final boolean r20, final int r21) {
        this.mRequestHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.mUrlChain = new ArrayList();
        this.mState = new AtomicInteger(0);
        this.mUploadProviderClosed = new AtomicBoolean(false);
        this.mAdditionalStatusDetails = -1;
        if (r15 == null) goto L20;
        if (r12 == null) goto L18;
        if (r13 == null) goto L16;
        if (r14 == null) goto L14;
        this.mAllowDirectExecutor = r17;
        this.mCallbackAsync = new AsyncUrlRequestCallback(this, r12, r14);
        if (r18 == false) goto L10;
        final int r3 = r19;
    L11:
        this.mExecutor = new SerializingExecutor(new AnonymousClass1(this, r13, r3, r20, r21));
        this.mCronetEngineId = r11.getCronetEngineId();
        this.mLogger = r11.getCronetLogger();
        this.mCurrentUrl = r15;
        this.mUserAgent = r16;
        return;
    L10:
        r3 = TrafficStats.getThreadStatsTag();
        goto L11
    L14:
        throw new NullPointerException("userExecutor is required");
    L16:
        throw new NullPointerException("Executor is required");
    L18:
        throw new NullPointerException("Listener is required");
    L20:
        throw new NullPointerException("URL is required");
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String r3) {
        checkNotStarted();
        if (r3 == null) goto L26;
        if ("OPTIONS".equalsIgnoreCase(r3) == false) goto L7;
    L23:
        this.mInitialMethod = r3;
        return;
    L7:
        if ("GET".equalsIgnoreCase(r3) == true) goto L23;
        if ("HEAD".equalsIgnoreCase(r3) == true) goto L23;
        if ("POST".equalsIgnoreCase(r3) == true) goto L23;
        if ("PUT".equalsIgnoreCase(r3) == true) goto L23;
        if ("DELETE".equalsIgnoreCase(r3) == true) goto L23;
        if ("TRACE".equalsIgnoreCase(r3) == true) goto L23;
        if ("PATCH".equalsIgnoreCase(r3) == true) goto L23;
        throw new IllegalArgumentException("Invalid http method " + r3);
    L26:
        throw new NullPointerException("Method is required.");
    }

    private void checkNotStarted() {
        int r3 = this.mState.get();
        if (r3 != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Request is already started. State is: " + r3);
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void addHeader(String r3, String r4) {
        checkNotStarted();
        if (isValidHeaderName(r3) == false) goto L12;
        if (r4.contains("\r\n") == true) goto L12;
        if (this.mRequestHeaders.containsKey(r3) == false) goto L9;
        this.mRequestHeaders.remove(r3);
    L9:
        this.mRequestHeaders.put(r3, r4);
        return;
    L12:
        throw new IllegalArgumentException("Invalid header " + r3 + "=" + r4);
    }

    private boolean isValidHeaderName(String r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length()) goto L23;
        char r1 = r4.charAt(r0);
        if (r1 == ',') goto L22;
        if (r1 == '/') goto L22;
        if (r1 == '{') goto L22;
        if (r1 == '}') goto L22;
        switch(r1) {
            case 39: goto L22;
            case 40: goto L22;
            case 41: goto L22;
            default: goto L14;
        };
    L14:
        switch(r1) {
            case 58: goto L22;
            case 59: goto L22;
            case 60: goto L22;
            case 61: goto L22;
            case 62: goto L22;
            case 63: goto L22;
            case 64: goto L22;
            default: goto L15;
        };
    L15:
        switch(r1) {
            case 91: goto L22;
            case 92: goto L22;
            case 93: goto L22;
            default: goto L17;
        };
    L17:
        if (Character.isISOControl(r1) == true) goto L22;
        if (Character.isWhitespace(r1) == true) goto L22;
        r0 = r0 + 1;
    L22:
        return false;
    L23:
        return true;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider r3, Executor r4) {
        if (r3 == null) goto L16;
        if (this.mRequestHeaders.containsKey("Content-Type") == false) goto L14;
        checkNotStarted();
        if (this.mInitialMethod != null) goto L8;
        this.mInitialMethod = "POST";
    L8:
        this.mUploadDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(r3);
        if (this.mAllowDirectExecutor == false) goto L11;
        this.mUploadExecutor = r4;
        return;
    L11:
        this.mUploadExecutor = new JavaUrlRequestUtils.DirectPreventingExecutor(r4);
        return;
    L14:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
    L16:
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void start() {
        this.mAdditionalStatusDetails = 10;
        transitionStates(0, 1, new AnonymousClass2(this));
    }

    private void enterErrorState(CronetException r2) {
        if (setTerminalState(6) == false) goto L6;
        fireDisconnect();
        fireCloseUploadDataProvider();
        this.mCallbackAsync.onFailed(this.mUrlResponseInfo, r2);
        return;
    }

    private boolean setTerminalState(int r3) {
    L2:
        int r0 = this.mState.get();
        if (r0 == 0) goto L17;
        if (r0 == 6) goto L14;
        if (r0 == 7) goto L24;
        if (r0 == 8) goto L25;
        if (this.mState.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L25:
        return false;
    L24:
        return false;
    L14:
        return false;
    L17:
        throw new IllegalStateException("Can't enter error state before start");
    }

    private void enterUserErrorState(Throwable r3) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UrlRequest.Callback", r3));
    }

    private void enterUploadErrorState(Throwable r3) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UploadDataProvider", r3));
    }

    private void enterCronetErrorState(Throwable r3) {
        enterErrorState(new CronetExceptionImpl("System error", r3));
    }

    private void transitionStates(int r2, int r3, Runnable r4) {
        if (this.mState.compareAndSet(r2, r3) == true) goto L11;
        int r1 = this.mState.get();
        if (r1 != 8) goto L7;
        return;
    L7:
        if (r1 != 6) goto L10;
        return;
    L10:
        throw new IllegalStateException("Invalid state transition - expected " + r2 + " but was " + r1);
    L11:
        r4.run();
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void followRedirect() {
        transitionStates(3, 1, new AnonymousClass3(this));
    }

    private void fireGetHeaders() {
        this.mAdditionalStatusDetails = 13;
        this.mExecutor.execute(errorSetting(new AnonymousClass4(this)));
    }

    private void fireCloseUploadDataProvider() {
        if (this.mUploadDataProvider != null) goto L5;
        return;
    L5:
        if (this.mUploadProviderClosed.compareAndSet(false, true) == false) goto L14;
        this.mUploadExecutor.execute(uploadErrorSetting(new AnonymousClass5(this)));     // Catch: RejectedExecutionException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "Exception when closing uploadDataProvider", e);
        return;
    }

    private void fireRedirectReceived(final String r3) {
        transitionStates(1, 2, new AnonymousClass6(this, r3));
    }

    private void fireOpenConnection() {
        this.mExecutor.execute(errorSetting(new AnonymousClass7(this)));
    }

    private Runnable errorSetting(final JavaUrlRequestUtils.CheckedRunnable r2) {
        return new AnonymousClass8(this, r2);
    }

    private Runnable userErrorSetting(final JavaUrlRequestUtils.CheckedRunnable r2) {
        return new AnonymousClass9(this, r2);
    }

    private Runnable uploadErrorSetting(final JavaUrlRequestUtils.CheckedRunnable r2) {
        return new AnonymousClass10(this, r2);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void read(final ByteBuffer r3) {
        Preconditions.checkDirect(r3);
        Preconditions.checkHasRemaining(r3);
        transitionStates(4, 5, new AnonymousClass11(this, r3));
    }

    private void processReadResult(int r2, ByteBuffer r3) throws IOException {
        if (r2 == (-1)) goto L5;
        this.mCallbackAsync.onReadCompleted(this.mUrlResponseInfo, r3);
        return;
    L5:
        ReadableByteChannel r4 = this.mResponseChannel;
        if (r4 == null) goto L9;
        r4.close();
    L9:
        if (this.mState.compareAndSet(5, 7) == false) goto L13;
        fireDisconnect();
        this.mCallbackAsync.onSucceeded(this.mUrlResponseInfo);
        return;
    }

    private void fireDisconnect() {
        this.mExecutor.execute(new AnonymousClass12(this));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void cancel() {
        int r0 = this.mState.getAndSet(8);
        if (r0 != 1) goto L5;
    L13:
        fireDisconnect();
        fireCloseUploadDataProvider();
        this.mCallbackAsync.onCanceled(this.mUrlResponseInfo);
        return;
    L5:
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L13;
        if (r0 == 5) goto L13;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public boolean isDone() {
        int r1 = this.mState.get();
        if (r1 != 7) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 6) goto L10;
        if (r1 == 8) goto L10;
        return false;
    }

    static long estimateHeadersSizeInBytesList(Map<String, List<String>> r5) {
        long r0 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, List<String>>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L20;
        Map.Entry<String, List<String>> r2 = r6.next();
        String r3 = r2.getKey();
        if (r3 == null) goto L12;
        r0 = r0 + ((long) r3.length());
    L12:
        if (r2.getValue() == null) goto L7;
        Iterator<String> r4 = r2.getValue().iterator();
    L16:
        if (r4.hasNext() == false) goto L7;
        String r7 = r4.next();
        if (r7 == null) goto L16;
        r0 = r0 + ((long) r7.length());
        goto L16
    L20:
        return r0;
    }

    static long estimateHeadersSizeInBytes(Map<String, String> r5) {
        long r0 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        Map.Entry<String, String> r2 = r6.next();
        String r3 = r2.getKey();
        if (r3 == null) goto L11;
        r0 = r0 + ((long) r3.length());
    L11:
        String r4 = r2.getValue();
        if (r4 == null) goto L7;
        r0 = r0 + ((long) r4.length());
        goto L7
    L14:
        return r0;
    }

    private static long parseContentLengthString(String r2) {
        return Long.parseLong(r2);
    L4:
        return 0;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener r3) {
        int r0 = this.mState.get();
        int r1 = this.mAdditionalStatusDetails;
        switch(r0) {
            case 0: goto L8;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            default: goto L5;
        };
    L6:
        r1 = 14;
        goto L9
    L7:
        r1 = 0;
        goto L9
    L8:
        r1 = -1;
    L9:
        this.mCallbackAsync.sendStatus(new VersionSafeCallbacks.UrlRequestStatusListener(r3), r1);
        return;
    L5:
        throw new IllegalStateException("Switch is exhaustive: " + r0);
    }

    private void closeResponseChannel() {
        this.mExecutor.execute(new AnonymousClass13(this));
    }
}
