package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes6.dex */
public final enum ThreadMode extends Enum<ThreadMode> {
    private static final /* synthetic */ ThreadMode[] $VALUES = null;
    public static final ThreadMode ASYNC = null;
    public static final ThreadMode BACKGROUND = null;
    public static final ThreadMode MAIN = null;
    public static final ThreadMode MAIN_ORDERED = null;
    public static final ThreadMode POSTING = null;

    private ThreadMode(String r1, int r2) {
        super(r1, r2);
    }

    public static ThreadMode valueOf(String r1) {
        return (ThreadMode) Enum.valueOf(ThreadMode.class, r1);
    }

    public static ThreadMode[] values() {
        return (ThreadMode[]) $VALUES.clone();
    }

    static {
        ThreadMode r0 = new ThreadMode("POSTING", 0);
        POSTING = r0;
        ThreadMode r1 = new ThreadMode("MAIN", 1);
        MAIN = r1;
        ThreadMode r3 = new ThreadMode("MAIN_ORDERED", 2);
        MAIN_ORDERED = r3;
        ThreadMode r5 = new ThreadMode("BACKGROUND", 3);
        BACKGROUND = r5;
        ThreadMode r7 = new ThreadMode("ASYNC", 4);
        ASYNC = r7;
        $VALUES = new ThreadMode[]{r0, r1, r3, r5, r7};
    }
}
