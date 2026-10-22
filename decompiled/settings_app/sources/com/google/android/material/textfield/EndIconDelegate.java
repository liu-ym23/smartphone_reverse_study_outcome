package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes3.dex */
abstract class EndIconDelegate {
    Context context;
    final int customEndIcon;
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

    EndIconDelegate(TextInputLayout r2, int r3) {
        this.textInputLayout = r2;
        this.context = r2.getContext();
        this.endIconView = r2.getEndIconView();
        this.customEndIcon = r3;
    }
}
