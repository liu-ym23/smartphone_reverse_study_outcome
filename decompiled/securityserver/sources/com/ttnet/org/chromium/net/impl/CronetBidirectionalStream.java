package com.ttnet.org.chromium.net.impl;

import a.a;
import androidx.annotation.VisibleForTesting;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
@VisibleForTesting
public class CronetBidirectionalStream extends ExperimentalBidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final VersionSafeCallbacks.BidirectionalStreamCallback mCallback;
    private final boolean mDelayRequestHeadersUntilFirstFlush;

    @GuardedBy
    private boolean mEndOfStreamWritten;
    private CronetException mException;
    private final Executor mExecutor;

    @GuardedBy
    private LinkedList<ByteBuffer> mFlushData;
    private final String mInitialMethod;
    private final int mInitialPriority;
    private final String mInitialUrl;

    @GuardedBy
    private RequestFinishedInfo.Metrics mMetrics;

    @GuardedBy
    private long mNativeStream;
    private final Object mNativeStreamLock;
    private final long mNetworkHandle;
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;

    @GuardedBy
    private LinkedList<ByteBuffer> mPendingData;

    @GuardedBy
    private int mReadState;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private final String[] mRequestHeaders;

    @GuardedBy
    private boolean mRequestHeadersSent;
    private UrlResponseInfoImpl mResponseInfo;
    private final int mTrafficStatsTag;
    private final boolean mTrafficStatsTagSet;
    private final int mTrafficStatsUid;
    private final boolean mTrafficStatsUidSet;

    @GuardedBy
    private int mWriteState;

    public interface Natives {
        long createBidirectionalStream(CronetBidirectionalStream r1, long r2, boolean r4, boolean r5, int r6, boolean r7, int r8, long r9);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        void destroy(long r1, CronetBidirectionalStream r3, boolean r4);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        boolean readData(long r1, CronetBidirectionalStream r3, ByteBuffer r4, int r5, int r6);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        void sendRequestHeaders(long r1, CronetBidirectionalStream r3);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        int start(long r1, CronetBidirectionalStream r3, String r4, int r5, String r6, String[] r7, boolean r8);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        boolean writevData(long r1, CronetBidirectionalStream r3, ByteBuffer[] r4, int[] r5, int[] r6, boolean r7);
    }

    public final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;
        boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream this$0;

        private OnReadCompletedRunnable(CronetBidirectionalStream r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer r0 = this.mByteBuffer;     // Catch: Exception -> L21
            this.mByteBuffer = null;     // Catch: Exception -> L21
            Object r1 = CronetBidirectionalStream.access$000(this.this$0);     // Catch: Exception -> L21
            monitor-enter(r1);     // Catch: Exception -> L21
        L8:
            th = move-exception;
            throw th;     // Catch: Exception -> L21
        L5:
            if (CronetBidirectionalStream.access$100(this.this$0) == false) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            boolean r3 = false;
            if (this.mEndOfStream == false) goto L15;
            CronetBidirectionalStream.access$202(this.this$0, 4);     // Catch: Throwable -> L8
            if (CronetBidirectionalStream.access$300(this.this$0) != 10) goto L16;
            r3 = true;
        L16:
            monitor-exit(r1);     // Catch: Throwable -> L8
            VersionSafeCallbacks.BidirectionalStreamCallback r2 = CronetBidirectionalStream.access$500(this.this$0);     // Catch: Exception -> L21
            CronetBidirectionalStream r4 = this.this$0;     // Catch: Exception -> L21
            r2.onReadCompleted(r4, CronetBidirectionalStream.access$400(r4), r0, this.mEndOfStream);     // Catch: Exception -> L21
            if (r3 == false) goto L29;
            CronetBidirectionalStream.access$600(this.this$0);     // Catch: Exception -> L21
            return;
        L29:
            return;
        L15:
            CronetBidirectionalStream.access$202(this.this$0, 2);     // Catch: Throwable -> L8
        L21:
            e = move-exception;
            CronetBidirectionalStream.access$700(this.this$0, e);
        }

        public /* synthetic */ OnReadCompletedRunnable(CronetBidirectionalStream r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public final class OnWriteCompletedRunnable implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream this$0;

        public OnWriteCompletedRunnable(CronetBidirectionalStream r1, ByteBuffer r2, boolean r3) {
            this.this$0 = r1;
            this.mByteBuffer = r2;
            this.mEndOfStream = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer r0 = this.mByteBuffer;     // Catch: Exception -> L20
            this.mByteBuffer = null;     // Catch: Exception -> L20
            Object r1 = CronetBidirectionalStream.access$000(this.this$0);     // Catch: Exception -> L20
            monitor-enter(r1);     // Catch: Exception -> L20
        L8:
            th = move-exception;
            throw th;     // Catch: Exception -> L20
        L5:
            if (CronetBidirectionalStream.access$100(this.this$0) == false) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            boolean r3 = false;
            if (this.mEndOfStream == false) goto L15;
            CronetBidirectionalStream.access$302(this.this$0, 10);     // Catch: Throwable -> L8
            if (CronetBidirectionalStream.access$200(this.this$0) != 4) goto L15;
            r3 = true;
        L15:
            monitor-exit(r1);     // Catch: Throwable -> L8
            VersionSafeCallbacks.BidirectionalStreamCallback r2 = CronetBidirectionalStream.access$500(this.this$0);     // Catch: Exception -> L20
            CronetBidirectionalStream r4 = this.this$0;     // Catch: Exception -> L20
            r2.onWriteCompleted(r4, CronetBidirectionalStream.access$400(r4), r0, this.mEndOfStream);     // Catch: Exception -> L20
            if (r3 == false) goto L28;
            CronetBidirectionalStream.access$600(this.this$0);     // Catch: Exception -> L20
            return;
        L28:
            return;
        L20:
            e = move-exception;
            CronetBidirectionalStream.access$700(this.this$0, e);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int CANCELED = 5;
        public static final int ERROR = 6;
        public static final int NOT_STARTED = 0;
        public static final int READING = 3;
        public static final int READING_DONE = 4;
        public static final int STARTED = 1;
        public static final int SUCCESS = 7;
        public static final int WAITING_FOR_FLUSH = 8;
        public static final int WAITING_FOR_READ = 2;
        public static final int WRITING = 9;
        public static final int WRITING_DONE = 10;
    }

    public CronetBidirectionalStream(CronetUrlRequestContext r4, String r5, int r6, BidirectionalStream.Callback r7, Executor r8, String r9, List<Map.Entry<String, String>> r10, boolean r11, Collection<Object> r12, boolean r13, int r14, boolean r15, int r16, long r17) {
        this.mNativeStreamLock = new Object();
        this.mReadState = 0;
        this.mWriteState = 0;
        this.mRequestContext = r4;
        this.mInitialUrl = r5;
        this.mInitialPriority = convertStreamPriority(r6);
        this.mCallback = new VersionSafeCallbacks.BidirectionalStreamCallback(r7);
        this.mExecutor = r8;
        this.mInitialMethod = r9;
        this.mRequestHeaders = stringsFromHeaderList(r10);
        this.mDelayRequestHeadersUntilFirstFlush = r11;
        this.mPendingData = new LinkedList();
        this.mFlushData = new LinkedList();
        this.mRequestAnnotations = r12;
        this.mTrafficStatsTagSet = r13;
        this.mTrafficStatsTag = r14;
        this.mTrafficStatsUidSet = r15;
        this.mTrafficStatsUid = r16;
        this.mNetworkHandle = r17;
    }

    public static /* synthetic */ Object access$000(CronetBidirectionalStream r0) {
        return r0.mNativeStreamLock;
    }

    public static /* synthetic */ boolean access$100(CronetBidirectionalStream r0) {
        return r0.isDoneLocked();
    }

    public static /* synthetic */ String access$1000(CronetBidirectionalStream r0) {
        return r0.mInitialMethod;
    }

    public static /* synthetic */ boolean access$1100(String r0) {
        return doesMethodAllowWriteData(r0);
    }

    public static /* synthetic */ void access$1200(CronetBidirectionalStream r0, CronetException r1) {
        r0.failWithExceptionOnExecutor(r1);
    }

    public static /* synthetic */ int access$200(CronetBidirectionalStream r0) {
        return r0.mReadState;
    }

    public static /* synthetic */ int access$202(CronetBidirectionalStream r0, int r1) {
        r0.mReadState = r1;
        return r1;
    }

    public static /* synthetic */ int access$300(CronetBidirectionalStream r0) {
        return r0.mWriteState;
    }

    public static /* synthetic */ int access$302(CronetBidirectionalStream r0, int r1) {
        r0.mWriteState = r1;
        return r1;
    }

    public static /* synthetic */ UrlResponseInfoImpl access$400(CronetBidirectionalStream r0) {
        return r0.mResponseInfo;
    }

    public static /* synthetic */ VersionSafeCallbacks.BidirectionalStreamCallback access$500(CronetBidirectionalStream r0) {
        return r0.mCallback;
    }

    public static /* synthetic */ void access$600(CronetBidirectionalStream r0) {
        r0.maybeOnSucceededOnExecutor();
    }

    public static /* synthetic */ void access$700(CronetBidirectionalStream r0, Exception r1) {
        r0.onCallbackException(r1);
    }

    public static /* synthetic */ boolean access$900(CronetBidirectionalStream r0) {
        return r0.mRequestHeadersSent;
    }

    public static /* synthetic */ boolean access$902(CronetBidirectionalStream r0, boolean r1) {
        r0.mRequestHeadersSent = r1;
        return r1;
    }

    private static int convertStreamPriority(int r2) {
        if (r2 != 0) goto L5;
        return 1;
    L5:
        if (r2 != 1) goto L7;
        return 2;
    L7:
        if (r2 != 2) goto L9;
        return 3;
    L9:
        if (r2 == 3) goto L15;
        if (r2 != 4) goto L14;
        return 5;
    L14:
        throw new IllegalArgumentException("Invalid stream priority.");
    L15:
        return 4;
    }

    @GuardedBy
    private void destroyNativeStreamLocked(boolean r7) {
        Log.i(CronetUrlRequestContext.LOG_TAG, "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.mNativeStream != 0) goto L5;
        return;
    L5:
        CronetBidirectionalStreamJni.get().destroy(this.mNativeStream, this, r7);
        this.mRequestContext.onRequestDestroyed();
        this.mNativeStream = 0;
        Runnable r6 = this.mOnDestroyedCallbackForTesting;
        if (r6 == null) goto L9;
        r6.run();
        return;
    }

    private static boolean doesMethodAllowWriteData(String r1) {
        if (r1.equals(HttpMethodContrants.GET) == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.equals(HttpMethodContrants.HEAD) == true) goto L7;
        return true;
    }

    private void failWithException(final CronetException r2) {
        postTaskToExecutor(new AnonymousClass5(this, r2));
    }

    private void failWithExceptionOnExecutor(CronetException r3) {
        this.mException = r3;
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mWriteState = 6;     // Catch: Throwable -> L8
        this.mReadState = 6;     // Catch: Throwable -> L8
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mCallback.onFailed(this, this.mResponseInfo, r3);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception notifying of failed request", new Object[]{e});
    }

    private static ArrayList<Map.Entry<String, String>> headersListFromStrings(String[] r5) {
        ArrayList<Map.Entry<String, String>> r0 = new ArrayList(r5.length / 2);
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L6;
        r0.add(new AbstractMap.SimpleImmutableEntry(r5[r1], r5[r1 + 1]));
        r1 = r1 + 2;
        goto L4
    L6:
        return r0;
    }

    @GuardedBy
    private boolean isDoneLocked() {
        if (this.mReadState != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mNativeStream != 0) goto L7;
        return true;
    }

    private void maybeOnSucceededOnExecutor() {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mWriteState == 10) goto L13;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        if (this.mReadState != 4) goto L22;
        this.mWriteState = 7;     // Catch: Throwable -> L8
        this.mReadState = 7;     // Catch: Throwable -> L8
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mCallback.onSucceeded(this, this.mResponseInfo);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onSucceeded method", new Object[]{e});
    }

    private void onCallbackException(Exception r4) {
        CallbackExceptionImpl r0 = new CallbackExceptionImpl("CalledByNative method has thrown an exception", r4);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", new Object[]{r4});
        failWithExceptionOnExecutor(r0);
    }

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new AnonymousClass4(this));
    }

    @CalledByNative
    private void onError(int r2, int r3, int r4, String r5, long r6) {
        UrlResponseInfoImpl r0 = this.mResponseInfo;
        if (r0 == null) goto L6;
        r0.setReceivedByteCount(r6);
    L6:
        if (r2 != 10) goto L8;
    L11:
        failWithException(new QuicExceptionImpl(a.A("Exception in BidirectionalStream: ", r5), r2, r3, r4));
        return;
    L8:
        if (r2 == 3) goto L11;
        failWithException(new BidirectionalStreamNetworkException(a.A("Exception in BidirectionalStream: ", r5), r2, r3));
    }

    @CalledByNative
    private void onMetricsCollected(long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, boolean r78, long r79, long r81, String r83, long r84) {
        Object r1 = this.mNativeStreamLock;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mMetrics != null) goto L19;
        CronetMetrics r2 = new CronetMetrics(r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r79, r81, -1, r83, r84, 0, "", "", 0, 0, -1, false, false);     // Catch: Throwable -> L16
        this.mMetrics = r2;     // Catch: Throwable -> L16
        int r3 = this.mReadState;     // Catch: Throwable -> L16
        if (r3 != 7) goto L10;
        int r4 = 0;
    L13:
        int r57 = r4;
        RequestFinishedInfoImpl r5 = new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, r2, r57, this.mResponseInfo, this.mException);     // Catch: Throwable -> L16
        this.mRequestContext.reportRequestFinished(r5);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L10:
        if (r3 != 5) goto L12;
        r4 = 2;
        goto L13
    L12:
        r4 = 1;
        goto L13
    L19:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L16
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer r2, int r3, int r4, int r5, long r6) {
        this.mResponseInfo.setReceivedByteCount(r6);
        if (r2.position() == r4) goto L5;
    L19:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r2.limit() != r5) goto L19;
        if (r3 < 0) goto L17;
        int r7 = r4 + r3;
        if (r7 > r5) goto L17;
        r2.position(r7);
        OnReadCompletedRunnable r8 = this.mOnReadCompletedTask;
        r8.mByteBuffer = r2;
        if (r3 != 0) goto L14;
        boolean r9 = true;
    L15:
        r8.mEndOfStream = r9;
        postTaskToExecutor(r8);
        return;
    L14:
        r9 = false;
    L17:
        failWithException(new CronetExceptionImpl("Invalid number of bytes read", null));
    }

    @CalledByNative
    private void onResponseHeadersReceived(int r1, String r2, String[] r3, long r4) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(r1, r2, r3, r4);     // Catch: Exception -> L5
        postTaskToExecutor(new AnonymousClass2(this));
        return;
    L5:
        failWithException(new CronetExceptionImpl("Cannot prepare ResponseInfo", null));
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] r2) {
        final UrlResponseInfoImpl.HeaderBlockImpl r0 = new UrlResponseInfoImpl.HeaderBlockImpl(headersListFromStrings(r2));
        postTaskToExecutor(new AnonymousClass3(this, r0));
    }

    @CalledByNative
    private void onStreamReady(final boolean r2) {
        postTaskToExecutor(new AnonymousClass1(this, r2));
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] r7, int[] r8, int[] r9, boolean r10) {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mWriteState = 8;     // Catch: Throwable -> L8
        if (this.mFlushData.isEmpty() == true) goto L13;
        sendFlushDataLocked();     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        int r1 = 0;
    L16:
        if (r1 >= r7.length) goto L39;
        ByteBuffer r2 = r7[r1];
        if (r2.position() != r8[r1]) goto L29;
        if (r2.limit() != r9[r1]) goto L29;
        r2.position(r2.limit());
        if (r10 == false) goto L27;
        boolean r5 = true;
        if (r1 != (r7.length - 1)) goto L27;
    L28:
        postTaskToExecutor(new OnWriteCompletedRunnable(this, r2, r5));
        r1 = r1 + 1;
    L27:
        r5 = false;
    L29:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during write", null));
        return;
    }

    private void postTaskToExecutor(Runnable r3) {
        this.mExecutor.execute(r3);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        monitor-enter(this.mNativeStreamLock);
        this.mWriteState = 6;     // Catch: Throwable -> L11
        this.mReadState = 6;     // Catch: Throwable -> L11
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int r12, String r13, String[] r14, long r15) {
        return new UrlResponseInfoImpl(Arrays.asList(new String[]{this.mInitialUrl}), r12, "", headersListFromStrings(r14), false, r13, null, r15);
    }

    private void sendFlushDataLocked() {
        int r0 = this.mFlushData.size();
        ByteBuffer[] r5 = new ByteBuffer[r0];
        int[] r6 = new int[r0];
        int[] r7 = new int[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ByteBuffer r3 = this.mFlushData.poll();
        r5[r2] = r3;
        r6[r2] = r3.position();
        r7[r2] = r3.limit();
        r2 = r2 + 1;
        goto L3
    L5:
        this.mWriteState = 9;
        this.mRequestHeadersSent = true;
        Natives r4 = CronetBidirectionalStreamJni.get();
        long r8 = this.mNativeStream;
        if (this.mEndOfStreamWritten == true) goto L8;
    L10:
        boolean r9 = false;
    L12:
        if (r4.writevData(r8, this, r5, r6, r7, r9) == false) goto L14;
        return;
    L14:
        this.mWriteState = 8;
        throw new IllegalArgumentException("Unable to call native writev.");
    L8:
        if (this.mPendingData.isEmpty() == false) goto L10;
        r9 = true;
        goto L12
    }

    private static String[] stringsFromHeaderList(List<Map.Entry<String, String>> r5) {
        String[] r0 = new String[r5.size() * 2];
        Iterator<Map.Entry<String, String>> r6 = r5.iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, String> r2 = r6.next();
        int r3 = r1 + 1;
        r0[r1] = r2.getKey();
        r1 = r1 + 2;
        r0[r3] = r2.getValue();
        goto L4
    L6:
        return r0;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void cancel() {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.mReadState == 0) goto L14;
        this.mWriteState = 5;     // Catch: Throwable -> L12
        this.mReadState = 5;     // Catch: Throwable -> L12
        destroyNativeStreamLocked(true);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void flush() {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == true) goto L33;
        int r1 = this.mWriteState;     // Catch: Throwable -> L19
        if (r1 == 8) goto L11;
        if (r1 != 9) goto L33;
    L11:
        if (this.mPendingData.isEmpty() == false) goto L24;
        if (this.mFlushData.isEmpty() == false) goto L24;
        if (this.mRequestHeadersSent == true) goto L21;
        this.mRequestHeadersSent = true;     // Catch: Throwable -> L19
        CronetBidirectionalStreamJni.get().sendRequestHeaders(this.mNativeStream, this);     // Catch: Throwable -> L19
        if (doesMethodAllowWriteData(this.mInitialMethod) == true) goto L21;
        this.mWriteState = 10;     // Catch: Throwable -> L19
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L24:
        if (this.mPendingData.isEmpty() == true) goto L27;
        this.mFlushData.addAll(this.mPendingData);     // Catch: Throwable -> L19
        this.mPendingData.clear();     // Catch: Throwable -> L19
    L27:
        if (this.mWriteState != 9) goto L30;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L30:
        sendFlushDataLocked();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L33:
        monitor-exit(r0);     // Catch: Throwable -> L19
    }

    @VisibleForTesting
    public List<ByteBuffer> getFlushDataForTesting() {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
        LinkedList r1 = new LinkedList();     // Catch: Throwable -> L8
        Iterator<ByteBuffer> r3 = this.mFlushData.iterator();     // Catch: Throwable -> L8
    L6:
        if (r3.hasNext() == false) goto L10;
        r1.add(r3.next().asReadOnlyBuffer());     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public List<ByteBuffer> getPendingDataForTesting() {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
        LinkedList r1 = new LinkedList();     // Catch: Throwable -> L8
        Iterator<ByteBuffer> r3 = this.mPendingData.iterator();     // Catch: Throwable -> L8
    L6:
        if (r3.hasNext() == false) goto L10;
        r1.add(r3.next().asReadOnlyBuffer());     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public boolean isDone() {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
        boolean r1 = isDoneLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void read(ByteBuffer r11) {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
        Preconditions.checkHasRemaining(r11);     // Catch: Throwable -> L10
        Preconditions.checkDirect(r11);     // Catch: Throwable -> L10
        if (this.mReadState != 2) goto L22;
        if (isDoneLocked() == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L13:
        if (this.mOnReadCompletedTask != null) goto L15;
        this.mOnReadCompletedTask = new OnReadCompletedRunnable(this, null);     // Catch: Throwable -> L10
    L15:
        this.mReadState = 3;     // Catch: Throwable -> L10
        if (CronetBidirectionalStreamJni.get().readData(this.mNativeStream, this, r11, r11.position(), r11.limit()) == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L19:
        this.mReadState = 2;     // Catch: Throwable -> L10
        throw new IllegalArgumentException("Unable to call native read");     // Catch: Throwable -> L10
    L22:
        throw new IllegalStateException("Unexpected read attempt.");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public void setOnDestroyedCallbackForTesting(Runnable r1) {
        this.mOnDestroyedCallbackForTesting = r1;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void start() {
        Object r14 = this.mNativeStreamLock;
        monitor-enter(r14);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mReadState != 0) goto L24;
        this.mNativeStream = CronetBidirectionalStreamJni.get().createBidirectionalStream(this, this.mRequestContext.getUrlRequestContextAdapter(), !this.mDelayRequestHeadersUntilFirstFlush, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mNetworkHandle);     // Catch: Throwable -> L12 RuntimeException -> L14
        this.mRequestContext.onRequestStarted();     // Catch: Throwable -> L12 RuntimeException -> L14
        Natives r1 = CronetBidirectionalStreamJni.get();     // Catch: Throwable -> L12 RuntimeException -> L14
        long r2 = this.mNativeStream;     // Catch: Throwable -> L12 RuntimeException -> L14
        String r5 = this.mInitialUrl;     // Catch: Throwable -> L12 RuntimeException -> L14
        int r6 = this.mInitialPriority;     // Catch: Throwable -> L12 RuntimeException -> L14
        String r7 = this.mInitialMethod;     // Catch: Throwable -> L12 RuntimeException -> L14
        int r3 = r1.start(r2, this, r5, r6, r7, this.mRequestHeaders, !doesMethodAllowWriteData(r7));     // Catch: Throwable -> L12 RuntimeException -> L14
        if (r3 == (-1)) goto L20;
        if (r3 > 0) goto L18;
        this.mWriteState = 1;     // Catch: Throwable -> L12 RuntimeException -> L14
        this.mReadState = 1;     // Catch: Throwable -> L12 RuntimeException -> L14
        monitor-exit(r14);     // Catch: Throwable -> L12
        return;
    L18:
        throw new IllegalArgumentException("Invalid header " + this.mRequestHeaders[r3 - 1] + "=" + this.mRequestHeaders[r3]);     // Catch: Throwable -> L12 RuntimeException -> L14
    L20:
        throw new IllegalArgumentException("Invalid http method " + this.mInitialMethod);     // Catch: Throwable -> L12 RuntimeException -> L14
    L14:
        e = move-exception;
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L12
        throw e;     // Catch: Throwable -> L12
    L24:
        throw new IllegalStateException("Stream is already started.");     // Catch: Throwable -> L12
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void write(ByteBuffer r3, boolean r4) {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
        Preconditions.checkDirect(r3);     // Catch: Throwable -> L10
        if (r3.hasRemaining() == true) goto L13;
        if (r4 == true) goto L13;
        throw new IllegalArgumentException("Empty buffer before end of stream.");     // Catch: Throwable -> L10
    L13:
        if (this.mEndOfStreamWritten == true) goto L24;
        if (isDoneLocked() == false) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L18:
        this.mPendingData.add(r3);     // Catch: Throwable -> L10
        if (r4 == false) goto L21;
        this.mEndOfStreamWritten = true;     // Catch: Throwable -> L10
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L24:
        throw new IllegalArgumentException("Write after writing end of stream.");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
