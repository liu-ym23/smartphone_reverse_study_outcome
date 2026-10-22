package com.bytedance.privacy.pseudoid.account;

import com.bytedance.privacy.bridge.IAccountBridge;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import obric.util.Utils;

/* JADX INFO: compiled from: AccountApi.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/privacy/pseudoid/account/AccountApi;", "", "()V", "TAG", "", "mAccountBridge", "Lcom/bytedance/privacy/bridge/IAccountBridge;", Utils.METHOD_GET_DEVICE_ID, "getUDID", "getUserId", "getXttTokenMap", "", "init", "", "callback", "isLogin", "", "privacysdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AccountApi {
    public static final AccountApi INSTANCE = null;
    private static final String TAG = "AccountApi";
    private static IAccountBridge mAccountBridge;

    static {
        INSTANCE = new AccountApi();
    }

    private AccountApi() {
    }

    @JvmStatic
    public static final void init(IAccountBridge r1) {
        Intrinsics.checkNotNullParameter(r1, "callback");
        mAccountBridge = r1;
    }

    public final String getUserId() {
        IAccountBridge r0 = mAccountBridge;
        if (r0 == null) goto L5;
        String r1 = r0.onGetUserId();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean isLogin() {
        IAccountBridge r0 = mAccountBridge;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onIsAccountLogin();
    }

    public final Map<String, String> getXttTokenMap() {
        Map<String, String> r1 = MapsKt.emptyMap();
        IAccountBridge r0 = mAccountBridge;
        if (r0 == null) goto L5;
        Map<String, String> r2 = r0.onGetXttTokenMap();
    L6:
        if (r2 != null) goto L9;
        return r1;
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public final String getDeviceId() {
        IAccountBridge r0 = mAccountBridge;
        if (r0 == null) goto L5;
        String r1 = r0.onGetDeviceId();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String getUDID() {
        IAccountBridge r0 = mAccountBridge;
        if (r0 == null) goto L5;
        String r1 = r0.onGetUDID();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}
