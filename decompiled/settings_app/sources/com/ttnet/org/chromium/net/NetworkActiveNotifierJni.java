package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes5.dex */
class NetworkActiveNotifierJni implements NetworkActiveNotifier.Natives {
    public static final JniStaticTestMocker<NetworkActiveNotifier.Natives> TEST_HOOKS = null;
    private static NetworkActiveNotifier.Natives testInstance;

    NetworkActiveNotifierJni() {
    }

    static /* synthetic */ NetworkActiveNotifier.Natives access$002(NetworkActiveNotifier.Natives r0) {
        testInstance = r0;
        return r0;
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    @Override // com.ttnet.org.chromium.net.NetworkActiveNotifier.Natives
    public void notifyOfDefaultNetworkActive(long r1) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkActiveNotifier_notifyOfDefaultNetworkActive(r1);
    }

    public static NetworkActiveNotifier.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        NetworkActiveNotifier.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.NetworkActiveNotifier.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new NetworkActiveNotifierJni();
    }
}
