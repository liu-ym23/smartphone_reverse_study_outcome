package com.tt.skin.sdk.api;

import android.app.Activity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ISkinStatusInterceptor {
    boolean inWhiteList(@NotNull Activity r1);

    boolean isCurPageNightMode(@NotNull Activity r1);

    boolean isDarkMode();

    boolean isDetailPageCssReady();

    boolean isIgnoreActivity(@NotNull Activity r1);

    boolean isJSReader();
}
