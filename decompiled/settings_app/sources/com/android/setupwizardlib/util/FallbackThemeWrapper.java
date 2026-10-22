package com.android.setupwizardlib.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes.dex */
public class FallbackThemeWrapper extends ContextThemeWrapper {
    public FallbackThemeWrapper(Context r1, int r2) {
        super(r1, r2);
    }

    @Override // android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme r1, int r2, boolean r3) {
        r1.applyStyle(r2, false);
    }
}
