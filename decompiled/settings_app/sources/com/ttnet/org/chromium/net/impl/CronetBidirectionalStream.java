package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
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

/* JADX INFO: loaded from: classes5.dex */
@JNINamespace("cronet")
public class CronetBidirectionalStream extends ExperimentalBidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final VersionSafeCallbacks.BidirectionalStreamCallback mCallback;
    private final boolean mDelayRequestHeadersUntilFirstFlush;
    private boolean mEndOfStreamWritten;
    private CronetException mException;
    private final Executor mExecutor;
    private LinkedList<ByteBuffer> mFlushData;
    private final String mInitialMethod;
    private final int mInitialPriority;
    private final String mInitialUrl;
    private RequestFinishedInfo.Metrics mMetrics;
    private long mNativeStream;
    private final Object mNativeStreamLock;
    private final long mNetworkHandle;
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;
    private LinkedList<ByteBuffer> mPendingData;
    private int mReadState;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private final String[] mRequestHeaders;
    private boolean mRequestHeadersSent;
    private UrlResponseInfoImpl mResponseInfo;
    private final int mTrafficStatsTag;
    private final boolean mTrafficStatsTagSet;
    private final int mTrafficStatsUid;
    private final boolean mTrafficStatsUidSet;
    private int mWriteState;

    interface Natives {
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

    private final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;
        boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream this$0;

        private OnReadCompletedRunnable(CronetBidirectionalStream r1) {
            this.this$0 = r1;
        }

        /* synthetic */ OnReadCompletedRunnable(CronetBidirectionalStream r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer r0 = this.mByteBuffer;     // Catch: Exception -> L22
            this.mByteBuffer = null;     // Catch: Exception -> L22
            Object r1 = CronetBidirectionalStream.access$000(this.this$0);     // Catch: Exception -> L22
            monitor-enter(r1);     // Catch: Exception -> L22
        L19:
            th = move-exception;
            throw th;     // Catch: Exception -> L22
        L5:
            if (CronetBidirectionalStream.access$100(this.this$0) == false) goto L8;
            monitor-exit(r1);     // Catch: Throwable -> L19
            return;
        L8:
            boolean r3 = false;
            if (this.mEndOfStream == false) goto L13;
            CronetBidirectionalStream.access$202(this.this$0, 4);     // Catch: Throwable -> L19
            if (CronetBidirectionalStream.access$300(this.this$0) != 10) goto L14;
            r3 = true;
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L19
            VersionSafeCallbacks.BidirectionalStreamCallback r2 = CronetBidirectionalStream.access$500(this.this$0);     // Catch: Exception -> L22
            CronetBidirectionalStream r4 = this.this$0;     // Catch: Exception -> L22
            r2.onReadCompleted(r4, CronetBidirectionalStream.access$400(r4), r0, this.mEndOfStream);     // Catch: Exception -> L22
            if (r3 == false) goto L27;
            CronetBidirectionalStream.access$600(this.this$0);     // Catch: Exception -> L22
            return;
        L27:
            return;
        L13:
            CronetBidirectionalStream.access$202(this.this$0, 2);     // Catch: Throwable -> L19
        L22:
            e = move-exception;
            CronetBidirectionalStream.access$700(this.this$0, e);
        }
    }

    private final class OnWriteCompletedRunnable implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream this$0;

        OnWriteCompletedRunnable(CronetBidirectionalStream r1, ByteBuffer r2, boolean r3) {
            this.this$0 = r1;
            this.mByteBuffer = r2;
            this.mEndOfStream = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer r0 = this.mByteBuffer;     // Catch: Exception -> L21
            this.mByteBuffer = null;     // Catch: Exception -> L21
            Object r1 = CronetBidirectionalStream.access$000(this.this$0);     // Catch: Exception -> L21
            monitor-enter(r1);     // Catch: Exception -> L21
        L18:
            th = move-exception;
            throw th;     // Catch: Exception -> L21
        L5:
            if (CronetBidirectionalStream.access$100(this.this$0) == false) goto L8;
            monitor-exit(r1);     // Catch: Throwable -> L18
            return;
        L8:
            boolean r3 = false;
            if (this.mEndOfStream == false) goto L13;
            CronetBidirectionalStream.access$302(this.this$0, 10);     // Catch: Throwable -> L18
            if (CronetBidirectionalStream.access$200(this.this$0) != 4) goto L13;
            r3 = true;
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L18
            VersionSafeCallbacks.BidirectionalStreamCallback r2 = CronetBidirectionalStream.access$500(this.this$0);     // Catch: Exception -> L21
            CronetBidirectionalStream r4 = this.this$0;     // Catch: Exception -> L21
            r2.onWriteCompleted(r4, CronetBidirectionalStream.access$400(r4), r0, this.mEndOfStream);     // Catch: Exception -> L21
            if (r3 == false) goto L26;
            CronetBidirectionalStream.access$600(this.this$0);     // Catch: Exception -> L21
            return;
        L26:
            return;
        L21:
            e = move-exception;
            CronetBidirectionalStream.access$700(this.this$0, e);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
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

    static {
    }

    static /* synthetic */ Object access$000(CronetBidirectionalStream r0) {
        return r0.mNativeStreamLock;
    }

    static /* synthetic */ boolean access$100(CronetBidirectionalStream r0) {
        return r0.isDoneLocked();
    }

    static /* synthetic */ String access$1000(CronetBidirectionalStream r0) {
        return r0.mInitialMethod;
    }

    static /* synthetic */ boolean access$1100(String r0) {
        return doesMethodAllowWriteData(r0);
    }

    static /* synthetic */ void access$1200(CronetBidirectionalStream r0, CronetException r1) {
        r0.failWithExceptionOnExecutor(r1);
    }

    static /* synthetic */ int access$200(CronetBidirectionalStream r0) {
        return r0.mReadState;
    }

    static /* synthetic */ int access$202(CronetBidirectionalStream r0, int r1) {
        r0.mReadState = r1;
        return r1;
    }

    static /* synthetic */ int access$300(CronetBidirectionalStream r0) {
        return r0.mWriteState;
    }

    static /* synthetic */ int access$302(CronetBidirectionalStream r0, int r1) {
        r0.mWriteState = r1;
        return r1;
    }

    static /* synthetic */ UrlResponseInfoImpl access$400(CronetBidirectionalStream r0) {
        return r0.mResponseInfo;
    }

    static /* synthetic */ VersionSafeCallbacks.BidirectionalStreamCallback access$500(CronetBidirectionalStream r0) {
        return r0.mCallback;
    }

    static /* synthetic */ void access$600(CronetBidirectionalStream r0) {
        r0.maybeOnSucceededOnExecutor();
    }

    static /* synthetic */ void access$700(CronetBidirectionalStream r0, Exception r1) {
        r0.onCallbackException(r1);
    }

    static /* synthetic */ boolean access$900(CronetBidirectionalStream r0) {
        return r0.mRequestHeadersSent;
    }

    static /* synthetic */ boolean access$902(CronetBidirectionalStream r0, boolean r1) {
        r0.mRequestHeadersSent = r1;
        return r1;
    }

    CronetBidirectionalStream(CronetUrlRequestContext r4, String r5, int r6, BidirectionalStream.Callback r7, Executor r8, String r9, List<Map.Entry<String, String>> r10, boolean r11, Collection<Object> r12, boolean r13, int r14, boolean r15, int r16, long r17) {
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

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void start() {
        Object r14 = this.mNativeStreamLock;
        monitor-enter(r14);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.mReadState != 0) goto L30;
        Natives r1 = CronetBidirectionalStreamJni.get();     // Catch: RuntimeException -> L25 Throwable -> L31
        long r3 = this.mRequestContext.getUrlRequestContextAdapter();     // Catch: RuntimeException -> L25 Throwable -> L31
        if (this.mDelayRequestHeadersUntilFirstFlush == true) goto L9;
        boolean r5 = true;
    L10:
        this.mNativeStream = r1.createBidirectionalStream(this, r3, r5, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mNetworkHandle);     // Catch: RuntimeException -> L25 Throwable -> L31
        this.mRequestContext.onRequestStarted();     // Catch: RuntimeException -> L25 Throwable -> L31
        Natives r2 = CronetBidirectionalStreamJni.get();     // Catch: RuntimeException -> L25 Throwable -> L31
        long r4 = this.mNativeStream;     // Catch: RuntimeException -> L25 Throwable -> L31
        String r6 = this.mInitialUrl;     // Catch: RuntimeException -> L25 Throwable -> L31
        int r7 = this.mInitialPriority;     // Catch: RuntimeException -> L25 Throwable -> L31
        String r8 = this.mInitialMethod;     // Catch: RuntimeException -> L25 Throwable -> L31
        String[] r9 = this.mRequestHeaders;     // Catch: RuntimeException -> L25 Throwable -> L31
        if (doesMethodAllowWriteData(r8) == true) goto L13;
        boolean r10 = true;
    L14:
        int r11 = r2.start(r4, this, r6, r7, r8, r9, r10);     // Catch: RuntimeException -> L25 Throwable -> L31
        if (r11 == (-1)) goto L24;
        if (r11 > 0) goto L20;
        this.mWriteState = 1;     // Catch: RuntimeException -> L25 Throwable -> L31
        this.mReadState = 1;     // Catch: RuntimeException -> L25 Throwable -> L31
        monitor-exit(r14);     // Catch: Throwable -> L31
        return;
    L20:
        int r12 = r11 - 1;
        throw new IllegalArgumentException("Invalid header " + this.mRequestHeaders[r12] + "=" + this.mRequestHeaders[r12 + 1]);     // Catch: RuntimeException -> L25 Throwable -> L31
    L24:
        throw new IllegalArgumentException("Invalid http method " + this.mInitialMethod);     // Catch: RuntimeException -> L25 Throwable -> L31
    L13:
        r10 = false;
        goto L14
    L9:
        r5 = false;
    L25:
        e = move-exception;
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L31
        throw e;     // Catch: Throwable -> L31
    L30:
        throw new IllegalStateException("Stream is already started.");     // Catch: Throwable -> L31
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void read(ByteBuffer r11) {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
        Preconditions.checkHasRemaining(r11);     // Catch: Throwable -> L21
        Preconditions.checkDirect(r11);     // Catch: Throwable -> L21
        if (this.mReadState != 2) goto L20;
        if (isDoneLocked() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L11:
        if (this.mOnReadCompletedTask != null) goto L13;
        this.mOnReadCompletedTask = new OnReadCompletedRunnable(this, null);     // Catch: Throwable -> L21
    L13:
        this.mReadState = 3;     // Catch: Throwable -> L21
        if (CronetBidirectionalStreamJni.get().readData(this.mNativeStream, this, r11, r11.position(), r11.limit()) == false) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L17:
        this.mReadState = 2;     // Catch: Throwable -> L21
        throw new IllegalArgumentException("Unable to call native read");     // Catch: Throwable -> L21
    L20:
        throw new IllegalStateException("Unexpected read attempt.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void write(ByteBuffer r3, boolean r4) {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
        Preconditions.checkDirect(r3);     // Catch: Throwable -> L23
        if (r3.hasRemaining() == true) goto L11;
        if (r4 == true) goto L11;
        throw new IllegalArgumentException("Empty buffer before end of stream.");     // Catch: Throwable -> L23
    L11:
        if (this.mEndOfStreamWritten == true) goto L22;
        if (isDoneLocked() == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L16:
        this.mPendingData.add(r3);     // Catch: Throwable -> L23
        if (r4 == false) goto L19;
        this.mEndOfStreamWritten = true;     // Catch: Throwable -> L23
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L22:
        throw new IllegalArgumentException("Write after writing end of stream.");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void flush() {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == true) goto L31;
        int r1 = this.mWriteState;     // Catch: Throwable -> L33
        if (r1 == 8) goto L11;
        if (r1 != 9) goto L31;
    L11:
        if (this.mPendingData.isEmpty() == false) goto L22;
        if (this.mFlushData.isEmpty() == false) goto L22;
        if (this.mRequestHeadersSent == true) goto L19;
        this.mRequestHeadersSent = true;     // Catch: Throwable -> L33
        CronetBidirectionalStreamJni.get().sendRequestHeaders(this.mNativeStream, this);     // Catch: Throwable -> L33
        if (doesMethodAllowWriteData(this.mInitialMethod) == true) goto L19;
        this.mWriteState = 10;     // Catch: Throwable -> L33
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L33
        return;
    L22:
        if (this.mPendingData.isEmpty() == true) goto L25;
        this.mFlushData.addAll(this.mPendingData);     // Catch: Throwable -> L33
        this.mPendingData.clear();     // Catch: Throwable -> L33
    L25:
        if (this.mWriteState != 9) goto L28;
        monitor-exit(r0);     // Catch: Throwable -> L33
        return;
    L28:
        sendFlushDataLocked();     // Catch: Throwable -> L33
        monitor-exit(r0);     // Catch: Throwable -> L33
        return;
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L33
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

    public List<ByteBuffer> getPendingDataForTesting() {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
        LinkedList r1 = new LinkedList();     // Catch: Throwable -> L10
        Iterator<ByteBuffer> r3 = this.mPendingData.iterator();     // Catch: Throwable -> L10
    L6:
        if (r3.hasNext() == false) goto L8;
        r1.add(r3.next().asReadOnlyBuffer());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public List<ByteBuffer> getFlushDataForTesting() {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
        LinkedList r1 = new LinkedList();     // Catch: Throwable -> L10
        Iterator<ByteBuffer> r3 = this.mFlushData.iterator();     // Catch: Throwable -> L10
    L6:
        if (r3.hasNext() == false) goto L8;
        r1.add(r3.next().asReadOnlyBuffer());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void cancel() {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mReadState == 0) goto L12;
        this.mWriteState = 5;     // Catch: Throwable -> L14
        this.mReadState = 5;     // Catch: Throwable -> L14
        destroyNativeStreamLocked(true);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
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
    L22:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L9:
        if (this.mWriteState == 10) goto L11;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.mReadState != 4) goto L20;
        this.mWriteState = 7;     // Catch: Throwable -> L22
        this.mReadState = 7;     // Catch: Throwable -> L22
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        this.mCallback.onSucceeded(this, this.mResponseInfo);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onSucceeded method", new Object[]{e});
    }

    private void onStreamReady(final boolean r2) {
        postTaskToExecutor(new AnonymousClass1(this, r2));
    }

    private void onResponseHeadersReceived(int r1, String r2, String[] r3, long r4) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(r1, r2, r3, r4);     // Catch: Exception -> L5
        postTaskToExecutor(new AnonymousClass2(this));
        return;
    L5:
        failWithException(new CronetExceptionImpl("Cannot prepare ResponseInfo", null));
    }

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
        this.mOnReadCompletedTask.mByteBuffer = r2;
        OnReadCompletedRunnable r8 = this.mOnReadCompletedTask;
        if (r3 != 0) goto L14;
        boolean r9 = true;
    L15:
        r8.mEndOfStream = r9;
        postTaskToExecutor(this.mOnReadCompletedTask);
        return;
    L14:
        r9 = false;
    L17:
        failWithException(new CronetExceptionImpl("Invalid number of bytes read", null));
    }

    private void onWritevCompleted(ByteBuffer[] r7, int[] r8, int[] r9, boolean r10) {
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L29
        return;
    L8:
        this.mWriteState = 8;     // Catch: Throwable -> L29
        if (this.mFlushData.isEmpty() == true) goto L11;
        sendFlushDataLocked();     // Catch: Throwable -> L29
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L29
        int r1 = 0;
    L14:
        if (r1 >= r7.length) goto L38;
        ByteBuffer r2 = r7[r1];
        if (r2.position() != r8[r1]) goto L27;
        if (r2.limit() != r9[r1]) goto L27;
        r2.position(r2.limit());
        if (r10 == false) goto L25;
        boolean r5 = true;
        if (r1 != (r7.length - 1)) goto L25;
    L26:
        postTaskToExecutor(new OnWriteCompletedRunnable(this, r2, r5));
        r1 = r1 + 1;
    L25:
        r5 = false;
    L27:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during write", null));
        return;
    }

    private void onResponseTrailersReceived(String[] r2) {
        final UrlResponseInfoImpl.HeaderBlockImpl r0 = new UrlResponseInfoImpl.HeaderBlockImpl(headersListFromStrings(r2));
        postTaskToExecutor(new AnonymousClass3(this, r0));
    }

    private void onError(int r2, int r3, int r4, String r5, long r6) {
        UrlResponseInfoImpl r0 = this.mResponseInfo;
        if (r0 == null) goto L6;
        r0.setReceivedByteCount(r6);
    L6:
        if (r2 != 10) goto L8;
    L11:
        failWithException(new QuicExceptionImpl("Exception in BidirectionalStream: " + r5, r2, r3, r4));
        return;
    L8:
        if (r2 == 3) goto L11;
        failWithException(new BidirectionalStreamNetworkException("Exception in BidirectionalStream: " + r5, r2, r3));
    }

    private void onCanceled() {
        postTaskToExecutor(new AnonymousClass4(this));
    }

    private void onMetricsCollected(long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, boolean r76, long r77, long r79, String r81, long r82) {
        Object r1 = this.mNativeStreamLock;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mMetrics != null) goto L17;
        this.mMetrics = new CronetMetrics(r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r77, r79, -1, r81, r82, 0, "", "", 0, 0, -1);     // Catch: Throwable -> L18
        int r2 = this.mReadState;     // Catch: Throwable -> L18
        if (r2 != 7) goto L10;
        int r3 = 0;
    L13:
        int r55 = r3;
        RequestFinishedInfoImpl r4 = new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, r55, this.mResponseInfo, this.mException);     // Catch: Throwable -> L18
        this.mRequestContext.reportRequestFinished(r4);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L10:
        if (r2 != 5) goto L12;
        r3 = 2;
        goto L13
    L12:
        r3 = 1;
        goto L13
    L17:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L18
    }

    public void setOnDestroyedCallbackForTesting(Runnable r1) {
        this.mOnDestroyedCallbackForTesting = r1;
    }

    private static boolean doesMethodAllowWriteData(String r1) {
        if (r1.equals("GET") == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.equals("HEAD") == true) goto L7;
        return true;
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

    private static String[] stringsFromHeaderList(List<Map.Entry<String, String>> r5) {
        String[] r0 = new String[r5.size() * 2];
        Iterator<Map.Entry<String, String>> r6 = r5.iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, String> r2 = r6.next();
        int r3 = r1 + 1;
        r0[r1] = r2.getKey();
        r1 = r3 + 1;
        r0[r3] = r2.getValue();
        goto L4
    L6:
        return r0;
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

    private void postTaskToExecutor(Runnable r5) {
        this.mExecutor.execute(r5);     // Catch: RejectedExecutionException -> L4
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

    private void failWithExceptionOnExecutor(CronetException r4) {
        this.mException = r4;
        Object r0 = this.mNativeStreamLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        this.mWriteState = 6;     // Catch: Throwable -> L15
        this.mReadState = 6;     // Catch: Throwable -> L15
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        this.mCallback.onFailed(this, this.mResponseInfo, r4);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception notifying of failed request", new Object[]{e});
    }

    private void onCallbackException(Exception r5) {
        CallbackExceptionImpl r0 = new CallbackExceptionImpl("CalledByNative method has thrown an exception", r5);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", new Object[]{r5});
        failWithExceptionOnExecutor(r0);
    }

    private void failWithException(final CronetException r2) {
        postTaskToExecutor(new AnonymousClass5(this, r2));
    }
}
