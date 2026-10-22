package com.tt.skin.sdk.api;

import android.webkit.WebView;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.article.night.webview.IWebViewNightModeHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ISkinWebViewInterceptor {
    @Nullable
    IWebViewNightModeHelper getNightModeHelper(@Nullable WebView r1);

    @Nullable
    IWebViewNightModeHelper judgeWebViewNightMode(@Nullable LifecycleOwner r1, @Nullable WebView r2);

    @Nullable
    IWebViewNightModeHelper judgeWebViewNightMode(@Nullable LifecycleOwner r1, @Nullable WebView r2, boolean r3);
}
