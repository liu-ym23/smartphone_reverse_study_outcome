package com.tt.skin.sdk.android;

import androidx.annotation.ColorRes;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ISkinPaint {
    void destroy();

    void setAppChangeListener();

    void setColorRes(@ColorRes int r1);

    void setLifecyclerOnwer(@NotNull LifecycleOwner r1);
}
