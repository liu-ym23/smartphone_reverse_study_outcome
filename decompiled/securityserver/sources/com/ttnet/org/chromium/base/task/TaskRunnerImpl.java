package com.ttnet.org.chromium.base.task;

import android.os.Process;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace(TraceStatsConsts.STATS_BASE_MODULE)
public class TaskRunnerImpl implements TaskRunner {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @GuardedBy
    private static final Set<TaskRunnerCleaner> sCleaners = null;
    private static final ReferenceQueue<Object> sQueue = null;

    @GuardedBy
    private boolean mDidOneTimeInitialization;
    private volatile long mNativeTaskRunnerAndroid;

    @Nullable
    @GuardedBy
    private List<Pair<Runnable, Long>> mPreNativeDelayedTasks;
    private final Object mPreNativeTaskLock;

    @Nullable
    @GuardedBy
    private LinkedList<Runnable> mPreNativeTasks;
    protected final Runnable mRunPreNativeTaskClosure;
    private final int mTaskRunnerType;
    private final TaskTraits mTaskTraits;
    private final String mTraceEvent;

    public interface Natives {
        boolean belongsToCurrentThread(long r1);

        void destroy(long r1);

        long init(int r1, int r2, boolean r3, boolean r4, byte r5, byte[] r6);

        void postDelayedTask(long r1, Runnable r3, long r4, String r6);
    }

    public static class TaskRunnerCleaner extends WeakReference<TaskRunnerImpl> {
        final long mNativePtr;

        public TaskRunnerCleaner(TaskRunnerImpl r3) {
            super(r3, TaskRunnerImpl.access$000());
            this.mNativePtr = TaskRunnerImpl.access$100(r3);
        }

        public void destroy() {
            TaskRunnerImplJni.get().destroy(this.mNativePtr);
        }
    }

    static {
        sQueue = new ReferenceQueue();
        sCleaners = new HashSet();
    }

    public TaskRunnerImpl(TaskTraits r3) {
        this(r3, "TaskRunnerImpl", 0);
        destroyGarbageCollectedTaskRunners();
    }

    public static /* synthetic */ ReferenceQueue access$000() {
        return sQueue;
    }

    public static /* synthetic */ long access$100(TaskRunnerImpl r2) {
        return r2.mNativeTaskRunnerAndroid;
    }

    private static void destroyGarbageCollectedTaskRunners() {
    L2:
        TaskRunnerCleaner r0 = (TaskRunnerCleaner) sQueue.poll();
        if (r0 == null) goto L4;
        r0.destroy();
        Set<TaskRunnerCleaner> r1 = sCleaners;
        monitor-enter(r1);
        r1.remove(r0);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @GuardedBy
    private void oneTimeInitialization() {
        if (this.mDidOneTimeInitialization == false) goto L5;
        return;
    L5:
        this.mDidOneTimeInitialization = true;
        if (PostTask.registerPreNativeTaskRunner(this) == true) goto L8;
        initNativeTaskRunner();
        return;
    L8:
        this.mPreNativeTasks = new LinkedList();
        this.mPreNativeDelayedTasks = new ArrayList();
    }

    public Boolean belongsToCurrentThreadInternal() {
        Object r0 = this.mPreNativeTaskLock;
        monitor-enter(r0);
        oneTimeInitialization();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (this.mNativeTaskRunnerAndroid != 0) goto L11;
        return null;
    L11:
        return Boolean.valueOf(TaskRunnerImplJni.get().belongsToCurrentThread(this.mNativeTaskRunnerAndroid));
    L12:
        th = move-exception;
        throw th;
    }

    public void initNativeTaskRunner() {
        Natives r0 = TaskRunnerImplJni.get();
        int r1 = this.mTaskRunnerType;
        TaskTraits r2 = this.mTaskTraits;
        long r3 = r0.init(r1, r2.mPriority, r2.mMayBlock, r2.mUseThreadPool, r2.mExtensionId, r2.mExtensionData);
        Object r4 = this.mPreNativeTaskLock;
        monitor-enter(r4);
        LinkedList<Runnable> r5 = this.mPreNativeTasks;     // Catch: Throwable -> L10
        if (r5 == null) goto L13;
        Iterator<Runnable> r6 = r5.iterator();     // Catch: Throwable -> L10
    L8:
        if (r6.hasNext() == false) goto L12;
        Runnable r11 = r6.next();     // Catch: Throwable -> L10
        TaskRunnerImplJni.get().postDelayedTask(r3, r11, 0, r11.getClass().getName());     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mPreNativeTasks = null;     // Catch: Throwable -> L10
    L13:
        List<Pair<Runnable, Long>> r7 = this.mPreNativeDelayedTasks;     // Catch: Throwable -> L10
        if (r7 == null) goto L20;
        Iterator<Pair<Runnable, Long>> r8 = r7.iterator();     // Catch: Throwable -> L10
    L17:
        if (r8.hasNext() == false) goto L19;
        Pair<Runnable, Long> r9 = r8.next();     // Catch: Throwable -> L10
        TaskRunnerImplJni.get().postDelayedTask(r3, (Runnable) r9.first, ((Long) r9.second).longValue(), r9.getClass().getName());     // Catch: Throwable -> L10
        goto L17
    L19:
        this.mPreNativeDelayedTasks = null;     // Catch: Throwable -> L10
    L20:
        this.mNativeTaskRunnerAndroid = r3;     // Catch: Throwable -> L10
        monitor-exit(r4);     // Catch: Throwable -> L10
        Set<TaskRunnerCleaner> r10 = sCleaners;
        monitor-enter(r10);
        r10.add(new TaskRunnerCleaner(this));     // Catch: Throwable -> L28
        monitor-exit(r10);     // Catch: Throwable -> L28
        destroyGarbageCollectedTaskRunners();
        return;
    L28:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postDelayedTask(Runnable r12, long r13) {
        if (this.mNativeTaskRunnerAndroid == 0) goto L6;
        TaskRunnerImplJni.get().postDelayedTask(this.mNativeTaskRunnerAndroid, r12, r13, r12.getClass().getName());
        return;
    L6:
        Object r0 = this.mPreNativeTaskLock;
        monitor-enter(r0);
        oneTimeInitialization();     // Catch: Throwable -> L13
        if (this.mNativeTaskRunnerAndroid == 0) goto L16;
        TaskRunnerImplJni.get().postDelayedTask(this.mNativeTaskRunnerAndroid, r12, r13, r12.getClass().getName());     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
        if (r13 != 0) goto L18;
        this.mPreNativeTasks.add(r12);     // Catch: Throwable -> L13
        schedulePreNativeTask();     // Catch: Throwable -> L13
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L18:
        Pair<Runnable, Long> r1 = new Pair(r12, Long.valueOf(r13));     // Catch: Throwable -> L13
        this.mPreNativeDelayedTasks.add(r1);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postTask(Runnable r3) {
        postDelayedTask(r3, 0);
    }

    public void runPreNativeTask() {
        TraceEvent r0 = TraceEvent.scoped(this.mTraceEvent);
        Object r1 = this.mPreNativeTaskLock;     // Catch: Throwable -> L20
        monitor-enter(r1);     // Catch: Throwable -> L20
        LinkedList<Runnable> r2 = this.mPreNativeTasks;     // Catch: Throwable -> L11
        if (r2 != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L11
        if (r0 == null) goto L40;
        r0.close();
        return;
    L40:
        return;
    L13:
        Runnable r3 = r2.poll();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        int r4 = this.mTaskTraits.mPriority;     // Catch: Throwable -> L20
        if (r4 != 1) goto L18;
        Process.setThreadPriority(0);     // Catch: Throwable -> L20
    L24:
        r3.run();     // Catch: Throwable -> L20
        if (r0 == null) goto L41;
        r0.close();
        return;
    L41:
        return;
    L18:
        if (r4 == 2) goto L22;
        Process.setThreadPriority(10);     // Catch: Throwable -> L20
        goto L24
    L22:
        Process.setThreadPriority(-1);     // Catch: Throwable -> L20
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r0 != null) goto L37;
    L35:
        throw th;
    L37:
        r0.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);
        goto L35
    }

    public void schedulePreNativeTask() {
        PostTask.getPrenativeThreadPoolExecutor().execute(this.mRunPreNativeTaskClosure);
    }

    public TaskRunnerImpl(TaskTraits r3, String r4, int r5) {
        this.mRunPreNativeTaskClosure = new b(2, this);
        this.mPreNativeTaskLock = new Object();
        this.mTaskTraits = r3.withExplicitDestination();
        this.mTraceEvent = a.a.j(r4, ".PreNativeTask.run");
        this.mTaskRunnerType = r5;
    }
}
