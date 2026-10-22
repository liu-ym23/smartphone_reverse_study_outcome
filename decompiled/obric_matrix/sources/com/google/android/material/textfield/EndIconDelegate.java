package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes2.dex */
abstract class EndIconDelegate {
    Context context;

    @DrawableRes
    final int customEndIcon;
    CheckableImageButton endIconView;
    TextInputLayout textInputLayout;

    EndIconDelegate(@NonNull TextInputLayout r2, @DrawableRes int r3) {
        this.textInputLayout = r2;
        this.context = r2.getContext();
        this.endIconView = r2.getEndIconView();
        this.customEndIcon = r3;
    }

    abstract void initialize();

    boolean isBoxBackgroundModeSupported(int r1) {
        return true;
    }

    void onSuffixVisibilityChanged(boolean r1) {
    }

    boolean shouldTintIconOnError() {
        return false;
    }
}
