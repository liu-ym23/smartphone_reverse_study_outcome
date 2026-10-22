package com.obric.oui.common.util;

import android.content.Context;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResourceUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/common/util/ResourceUtils;", "", "()V", "TAG", "", "isLandscape", "", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResourceUtils {
    public static final ResourceUtils INSTANCE = null;
    private static final String TAG = "ResourceUtils";

    static {
        INSTANCE = new ResourceUtils();
    }

    private ResourceUtils() {
    }

    public final boolean isLandscape(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r3.getResources().getConfiguration().orientation != 2) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        L.e(TAG, "isLandscape error", e);
        return false;
    }
}
