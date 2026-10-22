package com.obric.oui.dialog.input;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class InputBodyController$$special$$inlined$addTextChangedListener$1 implements TextWatcher {
    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
        if (r1 != null) goto L5;
        throw null;
    L5:
        if (TextUtils.isEmpty(r1.toString()) == true) goto L8;
        throw null;
    L8:
        throw null;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }
}
