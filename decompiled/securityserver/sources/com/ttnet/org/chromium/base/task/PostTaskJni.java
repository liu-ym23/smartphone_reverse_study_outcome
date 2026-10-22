package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class PostTaskJni implements PostTask.Natives {
    public static final JniStaticTestMocker<PostTask.Natives> TEST_HOOKS = null;
    private static PostTask.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public PostTaskJni() {
    }

    public static /* synthetic */ PostTask.Natives access$002(PostTask.Natives r0) {
        testInstance = r0;
        return r0;
    }

    public static PostTask.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        PostTask.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.task.PostTask.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new PostTaskJni();
    }

    @Override // com.ttnet.org.chromium.base.task.PostTask.Natives
    public void postDelayedTask(int r1, boolean r2, boolean r3, byte r4, byte[] r5, Runnable r6, long r7, String r9) {
        GEN_JNI.com_ttnet_org_chromium_base_task_PostTask_postDelayedTask(r1, r2, r3, r4, r5, r6, r7, r9);
    }
}
