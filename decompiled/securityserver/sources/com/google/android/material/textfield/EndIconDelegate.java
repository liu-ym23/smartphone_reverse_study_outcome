package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes.dex */
abstract class EndIconDelegate {
    Context context;
    CheckableImageButton endIconView;
    TextInputLayout textInputLayout;

    public EndIconDelegate(@NonNull TextInputLayout r2) {
        this.textInputLayout = r2;
        this.context = r2.getContext();
        this.endIconView = r2.getEndIconView();
    }

    public abstract void initialize();

    public boolean isBoxBackgroundModeSupported(int r1) {
        return true;
    }

    public void onSuffixVisibilityChanged(boolean r1) {
    }

    public boolean shouldTintIconOnError() {
        return false;
    }
}
