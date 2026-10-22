package com.google.android.material.transition.platform;

import a.a;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class FadeModeEvaluators {
    private static final FadeModeEvaluator CROSS = null;
    private static final FadeModeEvaluator IN = null;
    private static final FadeModeEvaluator OUT = null;
    private static final FadeModeEvaluator THROUGH = null;

    static {
        IN = new AnonymousClass1();
        OUT = new AnonymousClass2();
        CROSS = new AnonymousClass3();
        THROUGH = new AnonymousClass4();
    }

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int r1, boolean r2) {
        if (r1 != 0) goto L4;
        if (r2 == false) goto L22;
        return IN;
    L22:
        return OUT;
    L4:
        if (r1 != 1) goto L6;
        if (r2 == false) goto L18;
        return OUT;
    L18:
        return IN;
    L6:
        if (r1 == 2) goto L14;
        if (r1 != 3) goto L12;
        return THROUGH;
    L12:
        throw new IllegalArgumentException(a.e(r1, "Invalid fade mode: "));
    L14:
        return CROSS;
    }
}
