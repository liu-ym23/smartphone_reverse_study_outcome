package com.obric.security.devenvcheck;

import android.net.ConnectivityManager;
import android.net.Network;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WlanSecurityRiskPromptActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/security/devenvcheck/WlanSecurityRiskPromptActivity$registerWifiNetworkCallback$callback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onLost", "", "network", "Landroid/net/Network;", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WlanSecurityRiskPromptActivity$registerWifiNetworkCallback$callback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ WlanSecurityRiskPromptActivity this$0;

    WlanSecurityRiskPromptActivity$registerWifiNetworkCallback$callback$1(WlanSecurityRiskPromptActivity r1) {
        this.this$0 = r1;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network r2) {
        Intrinsics.checkNotNullParameter(r2, "network");
        WlanSecurityRiskPromptActivity.access$getMainHandler$p(this.this$0).post(new WlanSecurityRiskPromptActivity$registerWifiNetworkCallback$callback$1$onLost$1(this));
    }
}
