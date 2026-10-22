package com.obric.securitycenter.nodisturb.manager;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.obric.securitycenter.api.ApplicationContainer;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WhiteListManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/WhiteListManager;", "", "()V", "isInWhiteList", "", "targetPhone", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WhiteListManager {
    public WhiteListManager() {
    }

    public final boolean isInWhiteList(String r9) {
        Intrinsics.checkNotNullParameter(r9, "targetPhone");
        if (StringsKt.isBlank(r9) == false) goto L5;
        return false;
    L5:
        Context r8 = ApplicationContainer.INSTANCE.getApplication();
        if (r8 == null) goto L8;
        ContentResolver r2 = r8.getContentResolver();
    L9:
        if (r2 != null) goto L30;
        return false;
    L30:
        Cursor r10 = r2.query(Uri.withAppendedPath(ProviderConstants.INSTANCE.getIN_WHITE_LIST_URI(), r9), new String[]{"_id"}, null, null, null);     // Catch: Exception -> L23
        if (r10 == null) goto L31;
        Cursor r11 = r10;     // Catch: Exception -> L23
        boolean r12 = r11.moveToFirst();     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r11, null);     // Catch: Exception -> L23
        return r12;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Exception -> L23
        throw th;     // Catch: Exception -> L23
    L31:
        return false;
    L23:
        e = move-exception;
        e.printStackTrace();
        return false;
    L8:
        r2 = null;
        goto L9
    }
}
