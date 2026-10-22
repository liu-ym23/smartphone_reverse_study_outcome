package com.bytedance.monitor.util.thread.inner;

import a.a;
import androidx.annotation.NonNull;
import com.bytedance.monitor.util.thread.ThreadLogListener;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class ApmInnerThreadFactory implements ThreadFactory {
    public final String TAG;
    private ThreadLogListener mLogListener;
    private IThreadIdCallback mThreadIdCallback;
    private final String mThreadName;

    public interface IThreadIdCallback {
        void onTid(long r1);
    }

    public ApmInnerThreadFactory(@NonNull String r2) {
        this.TAG = getClass().getSimpleName();
        this.mThreadName = a.A("APM_", r2);
    }

    public static /* synthetic */ IThreadIdCallback access$000(ApmInnerThreadFactory r0) {
        return r0.mThreadIdCallback;
    }

    public static /* synthetic */ ThreadLogListener access$100(ApmInnerThreadFactory r0) {
        return r0.mLogListener;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r3) {
        return new Thread(new AnonymousClass1(this, r3), this.mThreadName);
    }

    public void setLogListener(ThreadLogListener r1) {
        this.mLogListener = r1;
    }

    public void setThreadIdCallback(IThreadIdCallback r1) {
        this.mThreadIdCallback = r1;
    }
}
