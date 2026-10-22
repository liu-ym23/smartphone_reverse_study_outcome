package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class TextAppearanceFontCallback {
    public TextAppearanceFontCallback() {
    }

    public abstract void onFontRetrievalFailed(int r1);

    public abstract void onFontRetrieved(Typeface r1, boolean r2);
}
