package com.bytedance.frameworks.baselib.network.http.cronet;

/* JADX INFO: loaded from: classes3.dex */
public class TTNetThreadConfig {
    private static final int INVALID_THREAD_PRIORITY = 20;
    public int mThreadPriority;
    public ThreadType mThreadType;

    public interface Callback {
        void bindBigCore(int r1);

        void bindLittleCore(int r1);

        void resetCoreBind(int r1);
    }

    public static final enum ThreadType extends Enum<ThreadType> {
        private static final /* synthetic */ ThreadType[] $VALUES = null;
        public static final ThreadType FILE_THREAD = null;
        public static final ThreadType INIT_THREAD = null;
        public static final ThreadType NETWORK_THREAD = null;

        private ThreadType(String r1, int r2) {
            super(r1, r2);
        }

        public static ThreadType valueOf(String r1) {
            return (ThreadType) Enum.valueOf(ThreadType.class, r1);
        }

        public static ThreadType[] values() {
            return (ThreadType[]) $VALUES.clone();
        }

        static {
            ThreadType r0 = new ThreadType("INIT_THREAD", 0);
            INIT_THREAD = r0;
            ThreadType r1 = new ThreadType("NETWORK_THREAD", 1);
            NETWORK_THREAD = r1;
            ThreadType r3 = new ThreadType("FILE_THREAD", 2);
            FILE_THREAD = r3;
            $VALUES = new ThreadType[]{r0, r1, r3};
        }
    }

    public TTNetThreadConfig() {
        this.mThreadPriority = 20;
    }
}
