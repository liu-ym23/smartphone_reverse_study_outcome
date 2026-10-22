package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes2.dex */
abstract class EndIconDelegate {
    Context context;
    CheckableImageButton endIconView;
    TextInputLayout textInputLayout;

    abstract void initialize();

    boolean isBoxBackgroundModeSupported(int r1) {
        return true;
    }

    void onSuffixVisibilityChanged(boolean r1) {
    }

    boolean shouldTintIconOnError() {
        return false;
    }

    EndIconDelegate(TextInputLayout r2) {
        this.textInputLayout = r2;
        this.context = r2.getContext();
        this.endIconView = r2.getEndIconView();
    }
}
