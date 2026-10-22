package com.tt.skin.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.article.night.webview.IWebViewNightModeHelper;
import com.tt.skin.sdk.api.ISkinChangeListener;
import com.tt.skin.sdk.api.ISkinListenerInterceptor;
import com.tt.skin.sdk.api.ISkinStatusInterceptor;
import com.tt.skin.sdk.api.ISkinViewInterceptor;
import com.tt.skin.sdk.api.ISkinWebViewInterceptor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SkinManagerAdapter implements ISkinStatusInterceptor, ISkinViewInterceptor, ISkinListenerInterceptor, ISkinWebViewInterceptor {
    public static final SkinManagerAdapter INSTANCE = null;

    @Nullable
    private static Context context;

    @NotNull
    private static ISkinListenerInterceptor skinListenerInterceptor;

    @NotNull
    private static ISkinStatusInterceptor skinStatusInterceptor;

    @NotNull
    private static ISkinViewInterceptor skinViewInterceptor;

    @NotNull
    private static ISkinWebViewInterceptor skinWebViewInterceptor;

    static {
        INSTANCE = new SkinManagerAdapter();
        Default r0 = Default.INSTANCE;
        skinStatusInterceptor = r0.getDEFAULT_STATUS_INTERCEPTOR();
        skinViewInterceptor = r0.getDEFAULT_VIEW_INTERCEPTOR();
        skinListenerInterceptor = r0.getDEFAULT_LISTENER_INTERCEPTOR();
        skinWebViewInterceptor = r0.getDEFAULT_WEBVIEW_NIGHT_INTERCEPTOR();
    }

    private SkinManagerAdapter() {
    }

    @Override // com.tt.skin.sdk.api.ISkinListenerInterceptor
    public void addLifeCycleSkinChangeListener(@NotNull LifecycleOwner r1, @Nullable ISkinChangeListener r2) {
        Intrinsics.g(r1, "lifecycleOwner");
        skinListenerInterceptor.addLifeCycleSkinChangeListener(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinListenerInterceptor
    public void addSkinChangeListener(@Nullable ISkinChangeListener r1) {
        skinListenerInterceptor.addSkinChangeListener(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public int getColorFromSkinResource(int r1) {
        return skinViewInterceptor.getColorFromSkinResource(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    @Nullable
    public ColorStateList getColorStateListFromSkinResource(int r1) {
        return skinViewInterceptor.getColorStateListFromSkinResource(r1);
    }

    @Nullable
    public final Context getContext() {
        return context;
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    @Nullable
    public Drawable getDrawableFromSkinResource(int r1) {
        return skinViewInterceptor.getDrawableFromSkinResource(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinWebViewInterceptor
    @Nullable
    public IWebViewNightModeHelper getNightModeHelper(@Nullable WebView r1) {
        return skinWebViewInterceptor.getNightModeHelper(r1);
    }

    @NotNull
    public final ISkinListenerInterceptor getSkinListenerInterceptor() {
        return skinListenerInterceptor;
    }

    @NotNull
    public final ISkinStatusInterceptor getSkinStatusInterceptor() {
        return skinStatusInterceptor;
    }

    @NotNull
    public final ISkinViewInterceptor getSkinViewInterceptor() {
        return skinViewInterceptor;
    }

    @NotNull
    public final ISkinWebViewInterceptor getSkinWebViewInterceptor() {
        return skinWebViewInterceptor;
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void ignoreActivity(@NotNull Activity r1) {
        Intrinsics.g(r1, "activity");
        skinViewInterceptor.ignoreActivity(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean inWhiteList(@NotNull Activity r1) {
        Intrinsics.g(r1, "activity");
        return skinStatusInterceptor.inWhiteList(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean isCurPageNightMode(@NotNull Activity r1) {
        Intrinsics.g(r1, "activity");
        return skinStatusInterceptor.isCurPageNightMode(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean isDarkMode() {
        return skinStatusInterceptor.isDarkMode();
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean isDetailPageCssReady() {
        return skinStatusInterceptor.isDetailPageCssReady();
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean isIgnoreActivity(@NotNull Activity r1) {
        Intrinsics.g(r1, "activity");
        return skinStatusInterceptor.isIgnoreActivity(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean isJSReader() {
        return skinStatusInterceptor.isJSReader();
    }

    @Override // com.tt.skin.sdk.api.ISkinWebViewInterceptor
    @Nullable
    public IWebViewNightModeHelper judgeWebViewNightMode(@Nullable LifecycleOwner r1, @Nullable WebView r2) {
        return skinWebViewInterceptor.judgeWebViewNightMode(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public int refreshNewColor(int r1) {
        return skinViewInterceptor.refreshNewColor(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    @Nullable
    public ColorStateList refreshNewColorStateList(int r1) {
        return skinViewInterceptor.refreshNewColorStateList(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void refreshView(@Nullable View r1) {
        skinViewInterceptor.refreshView(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void registerViewOnSkinChangeListener(@Nullable View r1, @NotNull Function1<? super Boolean, Unit> r2) {
        Intrinsics.g(r2, "callback");
        skinViewInterceptor.registerViewOnSkinChangeListener(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinListenerInterceptor
    public void removeSkinChangeListener(@Nullable ISkinChangeListener r1) {
        skinListenerInterceptor.removeSkinChangeListener(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void resetViewIgnore(@Nullable View r1) {
        skinViewInterceptor.resetViewIgnore(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setBackgroundColor(@Nullable View r1, int r2) {
        skinViewInterceptor.setBackgroundColor(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setColorFilter(@Nullable ImageView r1, int r2) {
        skinViewInterceptor.setColorFilter(r1, r2);
    }

    public final void setContext(@Nullable Context r1) {
        context = r1;
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setHintTextColor(@Nullable TextView r1, int r2) {
        skinViewInterceptor.setHintTextColor(r1, r2);
    }

    public final void setSkinListenerInterceptor(@NotNull ISkinListenerInterceptor r1) {
        Intrinsics.g(r1, "<set-?>");
        skinListenerInterceptor = r1;
    }

    public final void setSkinStatusInterceptor(@NotNull ISkinStatusInterceptor r1) {
        Intrinsics.g(r1, "<set-?>");
        skinStatusInterceptor = r1;
    }

    public final void setSkinViewInterceptor(@NotNull ISkinViewInterceptor r1) {
        Intrinsics.g(r1, "<set-?>");
        skinViewInterceptor = r1;
    }

    public final void setSkinWebViewInterceptor(@NotNull ISkinWebViewInterceptor r1) {
        Intrinsics.g(r1, "<set-?>");
        skinWebViewInterceptor = r1;
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setTextColor(@Nullable TextView r1, int r2) {
        skinViewInterceptor.setTextColor(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setViewIgnore(@Nullable View r1) {
        skinViewInterceptor.setViewIgnore(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinWebViewInterceptor
    @Nullable
    public IWebViewNightModeHelper judgeWebViewNightMode(@Nullable LifecycleOwner r1, @Nullable WebView r2, boolean r3) {
        return skinWebViewInterceptor.judgeWebViewNightMode(r1, r2, r3);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void refreshView(@Nullable View r1, boolean r2) {
        skinViewInterceptor.refreshView(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setHintTextColor(@Nullable TextView r1, int r2, boolean r3) {
        skinViewInterceptor.setHintTextColor(r1, r2, r3);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setTextColor(@Nullable TextView r1, int r2, boolean r3) {
        skinViewInterceptor.setTextColor(r1, r2);
    }
}
