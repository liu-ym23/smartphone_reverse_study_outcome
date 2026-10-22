package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
@MainDex
class TraceEventJni implements TraceEvent.Natives {
    public static final JniStaticTestMocker<TraceEvent.Natives> TEST_HOOKS = null;
    private static TraceEvent.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public TraceEventJni() {
    }

    public static /* synthetic */ TraceEvent.Natives access$002(TraceEvent.Natives r0) {
        testInstance = r0;
        return r0;
    }

    public static TraceEvent.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TraceEvent.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.TraceEvent.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new TraceEventJni();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void addViewDump(int r1, int r2, boolean r3, boolean r4, String r5, String r6, long r7) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_addViewDump(r1, r2, r3, r4, r5, r6, r7);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void begin(String r1, String r2) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_begin(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void beginToplevel(String r1) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_beginToplevel(r1);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void end(String r1, String r2) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_end(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void endToplevel(String r1) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_endToplevel(r1);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void finishAsync(String r1, long r2) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_finishAsync(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void initViewHierarchyDump() {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_initViewHierarchyDump();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void instant(String r1, String r2) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_instant(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void instantAndroidIPC(String r1, long r2) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_instantAndroidIPC(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void registerEnabledObserver() {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_registerEnabledObserver();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void setupATraceStartupTrace(String r1) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_setupATraceStartupTrace(r1);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void startATrace(String r1) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_startATrace(r1);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public long startActivityDump(String r1, long r2) {
        return GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_startActivityDump(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void startAsync(String r1, long r2) {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_startAsync(r1, r2);
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public void stopATrace() {
        GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_stopATrace();
    }

    @Override // com.ttnet.org.chromium.base.TraceEvent.Natives
    public boolean viewHierarchyDumpEnabled() {
        return GEN_JNI.com_ttnet_org_chromium_base_TraceEvent_viewHierarchyDumpEnabled();
    }
}
