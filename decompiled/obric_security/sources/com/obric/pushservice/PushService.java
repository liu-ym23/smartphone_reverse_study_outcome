package com.obric.pushservice;

import android.content.Context;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.matrix.sdk.push.PushApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/pushservice/PushService;", "", "()V", "TAG", "", "registerPush", "", "context", "Landroid/content/Context;", "appKey", "callback", "Lcom/obric/pushservice/PushService$PushRegisterCallback;", "PushRegisterCallback", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PushService {
    public static final PushService INSTANCE = null;
    private static final String TAG = "PushService";

    /* JADX INFO: compiled from: PushService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/obric/pushservice/PushService$PushRegisterCallback;", "", "onFailed", "", AccountConst.KEY_ERROR_CODE, "", AccountConst.KEY_ERROR_MSG, "onSuccess", "deviceToken", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public interface PushRegisterCallback {
        void onFailed(String r1, String r2);

        void onSuccess(String r1);
    }

    @JvmStatic
    public static final void registerPush(Context r2, String r3) {
        registerPush$default(r2, r3, null, 4, null);
    }

    static {
        INSTANCE = new PushService();
    }

    private PushService() {
    }

    public static /* synthetic */ void registerPush$default(Context r0, String r1, PushRegisterCallback r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
        PushRegisterCallback r5 = (PushRegisterCallback) null;
    L5:
        registerPush(r0, r1, r2);
    }

    @JvmStatic
    public static final void registerPush(Context r1, String r2, final PushRegisterCallback r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "appKey");
        PushApi.registerPush(r1, r2, new AnonymousClass1(r3));
    }
}
