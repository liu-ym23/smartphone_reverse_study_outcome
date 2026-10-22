package com.obric.security.networksettings;

import android.content.Intent;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.SearchConfigType;

/* JADX INFO: compiled from: NetworkPolicySettingViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/security/networksettings/NetworkPolicySettingViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "appName", "", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", SearchConfigType.KEY_MODE, "", "getMode", "()I", "setMode", "(I)V", "packageName", "getPackageName", "setPackageName", "uid", "getUid", "setUid", "initFromIntent", "", "intent", "Landroid/content/Intent;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class NetworkPolicySettingViewModel extends ViewModel {
    private String appName;
    private int mode;
    private String packageName;
    private int uid;

    public NetworkPolicySettingViewModel() {
        this.appName = "";
        this.packageName = "";
    }

    public final int getMode() {
        return this.mode;
    }

    public final void setMode(int r1) {
        this.mode = r1;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final void setAppName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.appName = r2;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setPackageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.packageName = r2;
    }

    public final int getUid() {
        return this.uid;
    }

    public final void setUid(int r1) {
        this.uid = r1;
    }

    public final void initFromIntent(Intent r4) {
        Intrinsics.checkNotNullParameter(r4, "intent");
        this.mode = r4.getIntExtra(SearchConfigType.KEY_MODE, 0);
        String r0 = r4.getStringExtra("appName");
        String r2 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.appName = r0;
        String r1 = r4.getStringExtra("packageName");
        if (r1 == null) goto L9;
        r2 = r1;
    L9:
        this.packageName = r2;
        this.uid = r4.getIntExtra("uid", 0);
    }
}
