package com.obric.oui.stepper;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSteppers$registerEvent$5 implements TextWatcher {
    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        if (r2 == null) goto L5;
        String r0 = r2.toString();
    L6:
        if (r0 != null) goto L8;
        throw null;
    L8:
        if (StringsKt.t(r0) == true) goto L20;
        if (r2 != null) goto L18;
    L13:
        int r3 = OSteppers.p;     // Catch: Exception -> L15
        throw null;     // Catch: Exception -> L15
    L15:
        Log.e("OSteppers", "input type error", null);
        int r4 = OSteppers.p;
        throw null;
    L18:
        String r5 = r2.toString();     // Catch: Exception -> L15
        if (r5 == null) goto L13;
        StringsKt.I(r5);     // Catch: Exception -> L15
        goto L13
    L20:
        throw null;
    L5:
        r0 = null;
        goto L6
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }
}
