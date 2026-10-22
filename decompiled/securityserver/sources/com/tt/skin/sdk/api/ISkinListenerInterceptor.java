package com.tt.skin.sdk.api;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ISkinListenerInterceptor {
    void addLifeCycleSkinChangeListener(@NotNull LifecycleOwner r1, @Nullable ISkinChangeListener r2);

    void addSkinChangeListener(@Nullable ISkinChangeListener r1);

    void removeSkinChangeListener(@Nullable ISkinChangeListener r1);
}
