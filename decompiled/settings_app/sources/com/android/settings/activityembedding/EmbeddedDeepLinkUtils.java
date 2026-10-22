package com.android.settings.activityembedding;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddedDeepLinkUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/settings/activityembedding/EmbeddedDeepLinkUtils;", "", "()V", "TAG", "", "tryStartMultiPaneDeepLink", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "highlightMenuKey", "isSearch", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EmbeddedDeepLinkUtils {
    public static final EmbeddedDeepLinkUtils INSTANCE = null;
    private static final String TAG = "EmbeddedDeepLinkUtils";

    static {
        INSTANCE = new EmbeddedDeepLinkUtils();
    }

    @JvmStatic
    public static final boolean tryStartMultiPaneDeepLink(Context r7, Intent r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "intent");
        return tryStartMultiPaneDeepLink$default(r7, r8, null, false, 12, null);
    }

    @JvmStatic
    public static final boolean tryStartMultiPaneDeepLink(Context r7, Intent r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "intent");
        return tryStartMultiPaneDeepLink$default(r7, r8, r9, false, 8, null);
    }

    @JvmStatic
    public static final boolean tryStartMultiPaneDeepLink(Context r0, Intent r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "intent");
        return false;
    }

    private EmbeddedDeepLinkUtils() {
    }

    public static /* synthetic */ boolean tryStartMultiPaneDeepLink$default(Context r0, Intent r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 8) == 0) goto L9;
        r3 = false;
    L9:
        return tryStartMultiPaneDeepLink(r0, r1, r2, r3);
    }
}
