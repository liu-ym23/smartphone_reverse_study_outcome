package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class NetworkChangeNotifierJni implements NetworkChangeNotifier.Natives {
    public static final JniStaticTestMocker<NetworkChangeNotifier.Natives> TEST_HOOKS = null;
    private static NetworkChangeNotifier.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public NetworkChangeNotifierJni() {
    }

    public static /* synthetic */ NetworkChangeNotifier.Natives access$002(NetworkChangeNotifier.Natives r0) {
        testInstance = r0;
        return r0;
    }

    public static NetworkChangeNotifier.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        NetworkChangeNotifier.Natives r0 = testInstance;
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new NetworkChangeNotifierJni();
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyConnectionCostChanged(long r1, NetworkChangeNotifier r3, int r4) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionCostChanged(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyConnectionTypeChanged(long r1, NetworkChangeNotifier r3, int r4, long r5) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionTypeChanged(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyMaxBandwidthChanged(long r1, NetworkChangeNotifier r3, int r4) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyMaxBandwidthChanged(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkConnect(long r1, NetworkChangeNotifier r3, long r4, boolean r6, int r7) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkConnect(r1, r3, r4, r6, r7);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkDisconnect(long r1, NetworkChangeNotifier r3, boolean r4, long r5) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkDisconnect(r1, r3, r4, r5);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkSoonToDisconnect(long r1, NetworkChangeNotifier r3, long r4) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkSoonToDisconnect(r1, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyPurgeActiveNetworkList(long r1, NetworkChangeNotifier r3, long[] r4) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyPurgeActiveNetworkList(r1, r3, r4);
    }
}
