package com.bytedance.frameworks.baselib.network.dispatcher;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class ThreadPoolConfig {
    private long mApiAliveTime;
    private int mCoreApiThreadSize;
    private int mCoreDownloadThreadSize;
    private int mCoreImmediateThreadSize;
    private int mCoreLowestThreadSize;
    private long mDownloadAliveTime;
    private ThreadPoolExecutor mDownloadThreadPool;
    private long mImmediateAliveTime;
    private ThreadPoolExecutor mImmediateThreadPool;
    private boolean mIsDynamicAdjust;
    private ThreadPoolExecutor mLocalThreadPool;
    private long mLowestAliveTime;
    private ThreadPoolExecutor mLowestThreadPool;
    private int mMaxApiThreadSize;
    private int mMaxDownloadThreadSize;
    private ThreadPoolExecutor mNormalThreadPool;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.dispatcher.ThreadPoolConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private long mApiAliveTime;
        private int mCoreApiThreadSize;
        private int mCoreDownloadThreadSize;
        private int mCoreImmediateThreadSize;
        private int mCoreLowestThreadSize;
        private long mDownloadAliveTime;
        private ThreadPoolExecutor mDownloadThreadPool;
        private long mImmediateAliveTime;
        private ThreadPoolExecutor mImmediateThreadPool;
        private boolean mIsDynamicAdjust;
        private ThreadPoolExecutor mLocalThreadPool;
        private long mLowestAliveTime;
        private ThreadPoolExecutor mLowestThreadPool;
        private int mMaxApiThreadSize;
        private int mMaxDownloadThreadSize;
        private ThreadPoolExecutor mNormalThreadPool;

        public Builder() {
            this.mIsDynamicAdjust = true;
        }

        public static /* synthetic */ ThreadPoolExecutor access$000(Builder r0) {
            return r0.mImmediateThreadPool;
        }

        public static /* synthetic */ ThreadPoolExecutor access$100(Builder r0) {
            return r0.mLocalThreadPool;
        }

        public static /* synthetic */ long access$1000(Builder r2) {
            return r2.mDownloadAliveTime;
        }

        public static /* synthetic */ long access$1100(Builder r2) {
            return r2.mImmediateAliveTime;
        }

        public static /* synthetic */ int access$1200(Builder r0) {
            return r0.mCoreImmediateThreadSize;
        }

        public static /* synthetic */ int access$1300(Builder r0) {
            return r0.mCoreLowestThreadSize;
        }

        public static /* synthetic */ long access$1400(Builder r2) {
            return r2.mLowestAliveTime;
        }

        public static /* synthetic */ boolean access$1500(Builder r0) {
            return r0.mIsDynamicAdjust;
        }

        public static /* synthetic */ ThreadPoolExecutor access$200(Builder r0) {
            return r0.mNormalThreadPool;
        }

        public static /* synthetic */ ThreadPoolExecutor access$300(Builder r0) {
            return r0.mDownloadThreadPool;
        }

        public static /* synthetic */ ThreadPoolExecutor access$400(Builder r0) {
            return r0.mLowestThreadPool;
        }

        public static /* synthetic */ int access$500(Builder r0) {
            return r0.mMaxApiThreadSize;
        }

        public static /* synthetic */ int access$600(Builder r0) {
            return r0.mMaxDownloadThreadSize;
        }

        public static /* synthetic */ int access$700(Builder r0) {
            return r0.mCoreApiThreadSize;
        }

        public static /* synthetic */ int access$800(Builder r0) {
            return r0.mCoreDownloadThreadSize;
        }

        public static /* synthetic */ long access$900(Builder r2) {
            return r2.mApiAliveTime;
        }

        public ThreadPoolConfig build() {
            return new ThreadPoolConfig(this, null);
        }

        public Builder setApiAliveTime(long r3) {
            if (r3 <= 0) goto L7;
            this.mApiAliveTime = r3;
            return this;
        L7:
            throw new IllegalArgumentException("Api keep alive time must set > 0 when allow core thread timeout.");
        }

        public Builder setApiThreadSize(int r1, int r2) {
            if (r2 <= 0) goto L10;
            if (r1 <= 0) goto L10;
            if (r1 > r2) goto L8;
            this.mMaxApiThreadSize = r2;
            this.mCoreApiThreadSize = r1;
            return this;
        L8:
            throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
        L10:
            throw new IllegalArgumentException("Api thread size must set > 0.");
        }

        public Builder setDownloadAliveTime(long r3) {
            if (r3 <= 0) goto L7;
            this.mDownloadAliveTime = r3;
            return this;
        L7:
            throw new IllegalArgumentException("Download keep alive time must set > 0 when allow core thread timeout.");
        }

        public Builder setDownloadThreadPool(ThreadPoolExecutor r1) {
            this.mDownloadThreadPool = r1;
            return this;
        }

        public Builder setDownloadThreadSize(int r1, int r2) {
            if (r2 <= 0) goto L10;
            if (r1 <= 0) goto L10;
            if (r1 > r2) goto L8;
            this.mMaxDownloadThreadSize = r2;
            this.mCoreDownloadThreadSize = r1;
            return this;
        L8:
            throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
        L10:
            throw new IllegalArgumentException("Download thread size must set > 0.");
        }

        public Builder setDynamicAdjust(boolean r1) {
            this.mIsDynamicAdjust = r1;
            return this;
        }

        public Builder setImmediateAliveTime(long r3) {
            if (r3 <= 0) goto L7;
            this.mImmediateAliveTime = r3;
            return this;
        L7:
            throw new IllegalArgumentException("Immediate keep alive time must set > 0 when allow core thread timeout.");
        }

        public Builder setImmediateThreadPool(ThreadPoolExecutor r1) {
            this.mImmediateThreadPool = r1;
            return this;
        }

        public Builder setImmediateThreadSize(int r1) {
            if (r1 < 0) goto L6;
            this.mCoreImmediateThreadSize = r1;
            return this;
        L6:
            throw new IllegalArgumentException("Immdeiate core size must set > 0");
        }

        public Builder setLocalThreadPool(ThreadPoolExecutor r1) {
            this.mLocalThreadPool = r1;
            return this;
        }

        public Builder setLowestAliveTime(long r3) {
            if (r3 <= 0) goto L7;
            this.mLowestAliveTime = r3;
            return this;
        L7:
            throw new IllegalArgumentException("Immediate keep alive time must set > 0 when allow core thread timeout.");
        }

        public Builder setLowestThreadPool(ThreadPoolExecutor r1) {
            this.mLowestThreadPool = r1;
            return this;
        }

        public Builder setLowestThreadSize(int r1) {
            if (r1 <= 0) goto L6;
            this.mCoreLowestThreadSize = r1;
            return this;
        L6:
            throw new IllegalArgumentException("Lowest thread size must set > 0.");
        }

        public Builder setNormalThreadPool(ThreadPoolExecutor r1) {
            this.mNormalThreadPool = r1;
            return this;
        }
    }

    public /* synthetic */ ThreadPoolConfig(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public long getApiAliveTime() {
        return this.mApiAliveTime;
    }

    public int getCoreApiThreadSize() {
        return this.mCoreApiThreadSize;
    }

    public int getCoreDownloadThreadSize() {
        return this.mCoreDownloadThreadSize;
    }

    public int getCoreImmediateThreadSize() {
        return this.mCoreImmediateThreadSize;
    }

    public int getCoreLowestThreadSize() {
        return this.mCoreLowestThreadSize;
    }

    public long getDownloadAliveTime() {
        return this.mDownloadAliveTime;
    }

    public ThreadPoolExecutor getDownloadThreadPool() {
        return this.mDownloadThreadPool;
    }

    public long getImmediateAliveTime() {
        return this.mImmediateAliveTime;
    }

    public ThreadPoolExecutor getImmediateThreadPool() {
        return this.mImmediateThreadPool;
    }

    public ThreadPoolExecutor getLocalThreadPool() {
        return this.mLocalThreadPool;
    }

    public long getLowestAliveTime() {
        return this.mLowestAliveTime;
    }

    public ThreadPoolExecutor getLowestThreadPool() {
        return this.mLowestThreadPool;
    }

    public int getMaxApiThreadSize() {
        return this.mMaxApiThreadSize;
    }

    public int getMaxDownloadThreadSize() {
        return this.mMaxDownloadThreadSize;
    }

    public ThreadPoolExecutor getNormalThreadPool() {
        return this.mNormalThreadPool;
    }

    public boolean isDynamicAdjust() {
        return this.mIsDynamicAdjust;
    }

    public void setDynamicAdjust(boolean r1) {
        this.mIsDynamicAdjust = r1;
    }

    private ThreadPoolConfig(Builder r7) {
        this.mCoreImmediateThreadSize = 0;
        this.mCoreApiThreadSize = 8;
        this.mCoreDownloadThreadSize = 8;
        this.mCoreLowestThreadSize = 1;
        this.mMaxApiThreadSize = 8;
        this.mMaxDownloadThreadSize = 8;
        this.mImmediateAliveTime = 10;
        this.mApiAliveTime = 30;
        this.mDownloadAliveTime = 10;
        this.mLowestAliveTime = 10;
        this.mIsDynamicAdjust = true;
        if (Builder.access$000(r7) == null) goto L6;
        this.mImmediateThreadPool = Builder.access$000(r7);
    L6:
        if (Builder.access$100(r7) == null) goto L9;
        this.mLocalThreadPool = Builder.access$100(r7);
    L9:
        if (Builder.access$200(r7) == null) goto L12;
        this.mNormalThreadPool = Builder.access$200(r7);
    L12:
        if (Builder.access$300(r7) == null) goto L15;
        this.mDownloadThreadPool = Builder.access$300(r7);
    L15:
        if (Builder.access$400(r7) == null) goto L18;
        this.mLowestThreadPool = Builder.access$400(r7);
    L18:
        if (Builder.access$500(r7) <= 0) goto L21;
        this.mMaxApiThreadSize = Builder.access$500(r7);
    L21:
        if (Builder.access$600(r7) <= 0) goto L24;
        this.mMaxDownloadThreadSize = Builder.access$600(r7);
    L24:
        if (Builder.access$700(r7) <= 0) goto L27;
        this.mCoreApiThreadSize = Builder.access$700(r7);
    L27:
        if (Builder.access$800(r7) <= 0) goto L30;
        this.mCoreDownloadThreadSize = Builder.access$800(r7);
    L30:
        if (Builder.access$900(r7) <= 0) goto L33;
        this.mApiAliveTime = Builder.access$900(r7);
    L33:
        if (Builder.access$1000(r7) <= 0) goto L36;
        this.mDownloadAliveTime = Builder.access$1000(r7);
    L36:
        if (Builder.access$1100(r7) <= 0) goto L39;
        this.mImmediateAliveTime = Builder.access$1100(r7);
    L39:
        if (Builder.access$1200(r7) < 0) goto L42;
        this.mCoreImmediateThreadSize = Builder.access$1200(r7);
    L42:
        if (Builder.access$1300(r7) <= 0) goto L45;
        this.mCoreLowestThreadSize = Builder.access$1300(r7);
    L45:
        if (Builder.access$1400(r7) <= 0) goto L47;
        this.mLowestAliveTime = Builder.access$1400(r7);
    L47:
        this.mIsDynamicAdjust = Builder.access$1500(r7);
    }
}
