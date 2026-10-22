package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class TaskRunnerImplJni implements TaskRunnerImpl.Natives {
    public static final JniStaticTestMocker<TaskRunnerImpl.Natives> TEST_HOOKS = null;
    private static TaskRunnerImpl.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public TaskRunnerImplJni() {
    }

    public static /* synthetic */ TaskRunnerImpl.Natives access$002(TaskRunnerImpl.Natives r0) {
        testInstance = r0;
        return r0;
    }

    public static TaskRunnerImpl.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TaskRunnerImpl.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new TaskRunnerImplJni();
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public boolean belongsToCurrentThread(long r1) {
        return GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_belongsToCurrentThread(r1);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public void destroy(long r1) {
        GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_destroy(r1);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public long init(int r1, int r2, boolean r3, boolean r4, byte r5, byte[] r6) {
        return GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_init(r1, r2, r3, r4, r5, r6);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunnerImpl.Natives
    public void postDelayedTask(long r1, Runnable r3, long r4, String r6) {
        GEN_JNI.com_ttnet_org_chromium_base_task_TaskRunnerImpl_postDelayedTask(r1, r3, r4, r6);
    }
}
