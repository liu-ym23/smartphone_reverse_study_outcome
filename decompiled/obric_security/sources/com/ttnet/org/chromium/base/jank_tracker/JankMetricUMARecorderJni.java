package com.ttnet.org.chromium.base.jank_tracker;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes4.dex */
public class JankMetricUMARecorderJni implements JankMetricUMARecorder.Natives {
    public static final JniStaticTestMocker<JankMetricUMARecorder.Natives> TEST_HOOKS = null;
    private static JankMetricUMARecorder.Natives testInstance;

    public JankMetricUMARecorderJni() {
    }

    static /* synthetic */ JankMetricUMARecorder.Natives access$002(JankMetricUMARecorder.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.base.jank_tracker.JankMetricUMARecorder.Natives
    public void recordJankMetrics(String r1, long[] r2, long[] r3, long[] r4, int r5) {
        GEN_JNI.com_ttnet_org_chromium_base_jank_1tracker_JankMetricUMARecorder_recordJankMetrics(r1, r2, r3, r4, r5);
    }

    public static JankMetricUMARecorder.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        JankMetricUMARecorder.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.jank_tracker.JankMetricUMARecorder.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new JankMetricUMARecorderJni();
    }
}
