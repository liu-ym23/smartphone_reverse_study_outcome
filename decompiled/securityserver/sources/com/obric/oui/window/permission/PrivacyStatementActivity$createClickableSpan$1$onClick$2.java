package com.obric.oui.window.permission;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class PrivacyStatementActivity$createClickableSpan$1$onClick$2 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    public static final PrivacyStatementActivity$createClickableSpan$1$onClick$2 b = null;

    static {
        b = new PrivacyStatementActivity$createClickableSpan$1$onClick$2(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        DialogInterface r3 = (DialogInterface) r1;
        ((Number) r2).intValue();
        Intrinsics.f(r3, "dialog");
        r3.dismiss();
        return Unit.f330a;
    }
}
