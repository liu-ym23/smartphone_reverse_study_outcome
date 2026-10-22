package com.ss.android.article.night.webview;

import android.webkit.WebView;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface IWebViewNightModeHelper {
    void injectNightModeJS(@Nullable WebView r1, @Nullable String r2);

    void reBindLifecycle(@Nullable LifecycleOwner r1);
}
