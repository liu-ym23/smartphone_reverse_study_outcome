package com.android.internal.inputmethod;

import android.view.textservice.SpellCheckerInfo;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes.dex */
public abstract class TextServicesManagerInternal {
    private static final TextServicesManagerInternal NOP = null;

    public abstract SpellCheckerInfo getCurrentSpellCheckerForUser(int r1);

    public TextServicesManagerInternal() {
    }

    static {
        NOP = new AnonymousClass1();
    }

    public static TextServicesManagerInternal get() {
        TextServicesManagerInternal r0 = (TextServicesManagerInternal) LocalServices.getService(TextServicesManagerInternal.class);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return NOP;
    }
}
