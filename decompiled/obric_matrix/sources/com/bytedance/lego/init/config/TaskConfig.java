package com.bytedance.lego.init.config;

import a.b.a.a.l.b;
import android.content.Context;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.lego.init.IdleTaskConfig;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001;By\b\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\"\u001a\u00020\u0014\u0012\u0006\u0010*\u001a\u00020\u0010\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010#\u001a\u00020\u0010\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007R\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0019\u0010\u0015\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0019\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0019\u0010#\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0013R\u0019\u0010&\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010*\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b*\u0010\u0013R$\u0010+\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000f\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010.R\u0019\u00100\u001a\u00020/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0019\u00105\u001a\u0002048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig;", "", "Ljava/util/concurrent/ThreadPoolExecutor;", "getDefaultExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/util/concurrent/ThreadFactory;", "getThreadFactory", "()Ljava/util/concurrent/ThreadFactory;", "getDefaultThreadFactory", "Lcom/bytedance/lego/init/IdleTaskConfig;", "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "getIdleTaskConfig", "()Lcom/bytedance/lego/init/IdleTaskConfig;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "", "isDebug", "Z", "()Z", "", LocationMonitorConst.TIMEOUT, "I", "getTimeout", "()I", "agreePrivacyPopupWindow", "getAgreePrivacyPopupWindow", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "mode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getMode", "()Lcom/bytedance/lego/init/config/ProcessMatchMode;", "coreThreadNum", "catchException", "getCatchException", "Landroid/content/Context;", "base", "Landroid/content/Context;", "getBase", "()Landroid/content/Context;", "isMainProcess", "taskExecutor", "getTaskExecutor", "setTaskExecutor", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "", "processName", "Ljava/lang/String;", "getProcessName", "()Ljava/lang/String;", "", "applicationStartTime", "J", "getApplicationStartTime", "()J", "<init>", "(ZLandroid/content/Context;Lcom/bytedance/lego/init/config/ProcessMatchMode;Ljava/util/concurrent/ThreadPoolExecutor;Ljava/util/concurrent/ThreadFactory;IZLjava/lang/String;IZJLcom/bytedance/lego/init/IdleTaskConfig;Z)V", "Builder", "initscheduler_release"}, k = 1, mv = {1, 1, 15})
public final class TaskConfig {
    public final boolean agreePrivacyPopupWindow;
    public final long applicationStartTime;
    public final Context base;
    public final boolean catchException;
    public final int coreThreadNum;
    public final ThreadPoolExecutor executor;
    public final IdleTaskConfig idleTaskConfig;
    public final boolean isDebug;
    public final boolean isMainProcess;
    public final ProcessMatchMode mode;
    public final String processName;
    public ThreadPoolExecutor taskExecutor;
    public final ThreadFactory threadFactory;
    public final int timeout;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00104\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b6\u00107J\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\u0004J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u00100R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00101R\u0016\u00102\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00100R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00100R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u00103R\u0016\u00105\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00100¨\u00068"}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "", "", "isDebug", "(Z)Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "setExecutorService", "(Ljava/util/concurrent/ThreadPoolExecutor;)Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "mode", "setProcessMatchMode", "(Lcom/bytedance/lego/init/config/ProcessMatchMode;)Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "setThreadFactory", "(Ljava/util/concurrent/ThreadFactory;)Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "", "coreThreadNum", "setCoreThreadNum", "(I)Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "millis", "setTimeOut", "enable", "enableCatchException", "Lcom/bytedance/lego/init/IdleTaskConfig;", "idleTaskConfig", "setIdleTaskConfig", "(Lcom/bytedance/lego/init/IdleTaskConfig;)Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "", "applicationStartTime", "setApplicationStartTime", "(J)Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "agreePrivacyPopupWindow", "Lcom/bytedance/lego/init/config/TaskConfig;", "build", "()Lcom/bytedance/lego/init/config/TaskConfig;", "processMatchMode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "J", "", "processName", "Ljava/lang/String;", "Ljava/util/concurrent/ThreadPoolExecutor;", "Lcom/bytedance/lego/init/IdleTaskConfig;", "Landroid/content/Context;", "base", "Landroid/content/Context;", "Z", "Ljava/util/concurrent/ThreadFactory;", LocationMonitorConst.TIMEOUT, "I", "isMainProcess", "catchException", "<init>", "(Landroid/content/Context;ZLjava/lang/String;)V", "initscheduler_release"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        public boolean agreePrivacyPopupWindow;
        public long applicationStartTime;
        public final Context base;
        public boolean catchException;
        public int coreThreadNum;
        public ThreadPoolExecutor executor;
        public IdleTaskConfig idleTaskConfig;
        public boolean isDebug;
        public final boolean isMainProcess;
        public ProcessMatchMode processMatchMode;
        public final String processName;
        public ThreadFactory threadFactory;
        public int timeout;

        public Builder(Context r2, boolean r3, String r4) {
            o.g(r2, "base");
            o.g(r4, "processName");
            this.base = r2;
            this.isMainProcess = r3;
            this.processName = r4;
            this.processMatchMode = ProcessMatchMode.CONTAIN;
            this.coreThreadNum = Runtime.getRuntime().availableProcessors();
            this.timeout = 8000;
            this.idleTaskConfig = IdleTaskConfig.Companion.a();
            this.applicationStartTime = System.currentTimeMillis();
        }

        public final Builder agreePrivacyPopupWindow(boolean r1) {
            this.agreePrivacyPopupWindow = r1;
            return this;
        }

        public final TaskConfig build() {
            boolean r1 = this.isDebug;
            Context r2 = this.base;
            ThreadPoolExecutor r4 = this.executor;
            ProcessMatchMode r3 = this.processMatchMode;
            int r6 = this.coreThreadNum;
            return new TaskConfig(r1, r2, r3, r4, this.threadFactory, r6, this.isMainProcess, this.processName, this.timeout, this.catchException, this.applicationStartTime, this.idleTaskConfig, this.agreePrivacyPopupWindow);
        }

        public final Builder enableCatchException(boolean r1) {
            this.catchException = r1;
            return this;
        }

        public final Builder isDebug(boolean r1) {
            this.isDebug = r1;
            return this;
        }

        public final Builder setApplicationStartTime(long r1) {
            this.applicationStartTime = r1;
            return this;
        }

        public final Builder setCoreThreadNum(int r1) {
            this.coreThreadNum = r1;
            return this;
        }

        public final Builder setExecutorService(ThreadPoolExecutor r2) {
            o.g(r2, "executor");
            this.executor = r2;
            return this;
        }

        public final Builder setIdleTaskConfig(IdleTaskConfig r2) {
            o.g(r2, "idleTaskConfig");
            this.idleTaskConfig = r2;
            return this;
        }

        public final Builder setProcessMatchMode(ProcessMatchMode r2) {
            o.g(r2, "mode");
            this.processMatchMode = r2;
            return this;
        }

        public final Builder setThreadFactory(ThreadFactory r2) {
            o.g(r2, "threadFactory");
            this.threadFactory = r2;
            return this;
        }

        public final Builder setTimeOut(int r5) {
            if (r5 >= 3000) goto L5;
            b.c(b.f72a, null, "TaskConfig.timeout must not be less than 3*1000", 1);
            this.timeout = PathInterpolatorCompat.MAX_NUM_POINTS;
        L6:
            return this;
        L5:
            this.timeout = r5;
            goto L6
        }
    }

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicInteger f4852f;

        public a() {
            this.f4852f = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r3) {
            o.g(r3, "r");
            StringBuilder r1 = b.a.a.a.a.e("AA InitThread#");
            r1.append(this.f4852f.getAndIncrement());
            return new Thread(r3, r1.toString());
        }
    }

    public TaskConfig(boolean r1, Context r2, ProcessMatchMode r3, ThreadPoolExecutor r4, ThreadFactory r5, int r6, boolean r7, String r8, int r9, boolean r10, long r11, IdleTaskConfig r13, boolean r14) {
        this.isDebug = r1;
        this.base = r2;
        this.mode = r3;
        this.executor = r4;
        this.threadFactory = r5;
        this.coreThreadNum = r6;
        this.isMainProcess = r7;
        this.processName = r8;
        this.timeout = r9;
        this.catchException = r10;
        this.applicationStartTime = r11;
        this.idleTaskConfig = r13;
        this.agreePrivacyPopupWindow = r14;
    }

    public /* synthetic */ TaskConfig(boolean r18, Context r19, ProcessMatchMode r20, ThreadPoolExecutor r21, ThreadFactory r22, int r23, boolean r24, String r25, int r26, boolean r27, long r28, IdleTaskConfig r30, boolean r31, int r32, g r33) {
        if ((r32 & 8) == 0) goto L5;
        ThreadPoolExecutor r6 = null;
    L7:
        if ((r32 & 16) == 0) goto L9;
        ThreadFactory r7 = null;
    L10:
        this(r18, r19, r20, r6, r7, r23, r24, r25, r26, r27, r28, r30, r31);
        return;
    L9:
        r7 = r22;
        goto L10
    L5:
        r6 = r21;
        goto L7
    }

    public /* synthetic */ TaskConfig(boolean r1, Context r2, ProcessMatchMode r3, ThreadPoolExecutor r4, ThreadFactory r5, int r6, boolean r7, String r8, int r9, boolean r10, long r11, IdleTaskConfig r13, boolean r14, g r15) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14);
    }

    private final ThreadPoolExecutor getDefaultExecutor() {
        int r2 = this.coreThreadNum;
        return new ThreadPoolExecutor(r2, r2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), getThreadFactory());
    }

    private final ThreadFactory getDefaultThreadFactory() {
        return new a();
    }

    private final ThreadFactory getThreadFactory() {
        ThreadFactory r0 = this.threadFactory;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new a();
    }

    public final boolean getAgreePrivacyPopupWindow() {
        return this.agreePrivacyPopupWindow;
    }

    public final long getApplicationStartTime() {
        return this.applicationStartTime;
    }

    public final Context getBase() {
        return this.base;
    }

    public final boolean getCatchException() {
        return this.catchException;
    }

    public final IdleTaskConfig getIdleTaskConfig() {
        return this.idleTaskConfig;
    }

    public final ProcessMatchMode getMode() {
        return this.mode;
    }

    public final String getProcessName() {
        return this.processName;
    }

    public final ThreadPoolExecutor getTaskExecutor() {
        ThreadPoolExecutor r0 = this.taskExecutor;
        if (r0 != null) goto L6;
        r0 = this.executor;
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        return getDefaultExecutor();
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final boolean isMainProcess() {
        return this.isMainProcess;
    }

    public final void setTaskExecutor(ThreadPoolExecutor r1) {
        this.taskExecutor = r1;
    }
}
