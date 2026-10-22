package com.android.settings.ext;

import android.view.View;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"sha256", "", "input", "setOnDebounceClickListener", "", "Landroid/view/View;", "listener", "Landroid/view/View$OnClickListener;", "app_neridaCnRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ViewExtKt {
    public static final void setOnDebounceClickListener(View r7, View.OnClickListener r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "listener");
        r7.setOnClickListener(new OnDebounceClickListener(0, r8, 1, null));
    }

    public static final String sha256(String r12) {
        String r0 = r12;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L15;
        return null;
    L15:
        MessageDigest r2 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L14
        Charset r3 = StandardCharsets.UTF_8;     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r3, "UTF_8");     // Catch: Exception -> L14
        byte[] r13 = r12.getBytes(r3);     // Catch: Exception -> L14
        Intrinsics.checkNotNullExpressionValue(r13, "getBytes(...)");     // Catch: Exception -> L14
        byte[] r4 = r2.digest(r13);     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L14
        return ArraysKt.joinToString$default(r4, "", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null);
    L17:
        return null;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }
}
