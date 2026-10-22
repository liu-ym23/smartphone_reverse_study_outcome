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

/* JADX INFO: compiled from: SkinManagerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010)\u001a\u00020(H\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020(H\u0016J\u0014\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u0002072\u0006\u00104\u001a\u000205H\u0016J\u0010\u00108\u001a\u0002072\u0006\u00104\u001a\u000205H\u0016J\b\u00109\u001a\u000207H\u0016J\b\u0010:\u001a\u000207H\u0016J\u0010\u0010;\u001a\u0002072\u0006\u00104\u001a\u000205H\u0016J\b\u0010<\u001a\u000207H\u0016J\u001e\u0010=\u001a\u0004\u0018\u0001002\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u0010=\u001a\u0004\u0018\u0001002\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010>\u001a\u000207H\u0016J\u0010\u0010?\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016J\u0012\u0010@\u001a\u0004\u0018\u00010+2\u0006\u0010A\u001a\u00020(H\u0016J\u0012\u0010B\u001a\u00020!2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u001a\u0010B\u001a\u00020!2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u000207H\u0016J(\u0010F\u001a\u00020!2\b\u0010C\u001a\u0004\u0018\u00010D2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0006\u0012\u0004\u0018\u00010!0HH\u0016J\u0012\u0010I\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010J\u001a\u00020!2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u001a\u0010K\u001a\u00020!2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010)\u001a\u00020(H\u0016J\u001a\u0010L\u001a\u00020!2\b\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010)\u001a\u00020(H\u0016J\u001a\u0010O\u001a\u00020!2\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010)\u001a\u00020(H\u0016J\"\u0010O\u001a\u00020!2\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010)\u001a\u00020(2\u0006\u0010R\u001a\u000207H\u0016J\u001a\u0010S\u001a\u00020!2\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010)\u001a\u00020(H\u0016J\"\u0010S\u001a\u00020!2\b\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010)\u001a\u00020(2\u0006\u0010R\u001a\u000207H\u0016J\u0012\u0010T\u001a\u00020!2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006U"}, d2 = {"Lcom/tt/skin/sdk/SkinManagerAdapter;", "Lcom/tt/skin/sdk/api/ISkinStatusInterceptor;", "Lcom/tt/skin/sdk/api/ISkinViewInterceptor;", "Lcom/tt/skin/sdk/api/ISkinListenerInterceptor;", "Lcom/tt/skin/sdk/api/ISkinWebViewInterceptor;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "skinListenerInterceptor", "getSkinListenerInterceptor", "()Lcom/tt/skin/sdk/api/ISkinListenerInterceptor;", "setSkinListenerInterceptor", "(Lcom/tt/skin/sdk/api/ISkinListenerInterceptor;)V", "skinStatusInterceptor", "getSkinStatusInterceptor", "()Lcom/tt/skin/sdk/api/ISkinStatusInterceptor;", "setSkinStatusInterceptor", "(Lcom/tt/skin/sdk/api/ISkinStatusInterceptor;)V", "skinViewInterceptor", "getSkinViewInterceptor", "()Lcom/tt/skin/sdk/api/ISkinViewInterceptor;", "setSkinViewInterceptor", "(Lcom/tt/skin/sdk/api/ISkinViewInterceptor;)V", "skinWebViewInterceptor", "getSkinWebViewInterceptor", "()Lcom/tt/skin/sdk/api/ISkinWebViewInterceptor;", "setSkinWebViewInterceptor", "(Lcom/tt/skin/sdk/api/ISkinWebViewInterceptor;)V", "addLifeCycleSkinChangeListener", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "listener", "Lcom/tt/skin/sdk/api/ISkinChangeListener;", "addSkinChangeListener", "getColorFromSkinResource", "", "colorRes", "getColorStateListFromSkinResource", "Landroid/content/res/ColorStateList;", "getDrawableFromSkinResource", "Landroid/graphics/drawable/Drawable;", "drawableRes", "getNightModeHelper", "Lcom/ss/android/article/night/webview/IWebViewNightModeHelper;", "webView", "Landroid/webkit/WebView;", "ignoreActivity", "activity", "Landroid/app/Activity;", "inWhiteList", "", "isCurPageNightMode", "isDarkMode", "isDetailPageCssReady", "isIgnoreActivity", "isJSReader", "judgeWebViewNightMode", "isDetailPage", "refreshNewColor", "refreshNewColorStateList", "colorStateListRes", "refreshView", "view", "Landroid/view/View;", "mustMainThread", "registerViewOnSkinChangeListener", "callback", "Lkotlin/Function1;", "removeSkinChangeListener", "resetViewIgnore", "setBackgroundColor", "setColorFilter", "imageView", "Landroid/widget/ImageView;", "setHintTextColor", "textView", "Landroid/widget/TextView;", "useColorStateList", "setTextColor", "setViewIgnore", "api_release"}, k = 1, mv = {1, 1, 15})
public final class SkinManagerAdapter implements ISkinStatusInterceptor, ISkinViewInterceptor, ISkinListenerInterceptor, ISkinWebViewInterceptor {
    public static final SkinManagerAdapter INSTANCE = null;
    private static Context context;
    private static ISkinListenerInterceptor skinListenerInterceptor;
    private static ISkinStatusInterceptor skinStatusInterceptor;
    private static ISkinViewInterceptor skinViewInterceptor;
    private static ISkinWebViewInterceptor skinWebViewInterceptor;

    static {
        INSTANCE = new SkinManagerAdapter();
        skinStatusInterceptor = Default.INSTANCE.getDEFAULT_STATUS_INTERCEPTOR();
        skinViewInterceptor = Default.INSTANCE.getDEFAULT_VIEW_INTERCEPTOR();
        skinListenerInterceptor = Default.INSTANCE.getDEFAULT_LISTENER_INTERCEPTOR();
        skinWebViewInterceptor = Default.INSTANCE.getDEFAULT_WEBVIEW_NIGHT_INTERCEPTOR();
    }

    private SkinManagerAdapter() {
    }

    public final Context getContext() {
        return context;
    }

    public final void setContext(Context r1) {
        context = r1;
    }

    public final ISkinStatusInterceptor getSkinStatusInterceptor() {
        return skinStatusInterceptor;
    }

    public final void setSkinStatusInterceptor(ISkinStatusInterceptor r1) {
        Intrinsics.checkParameterIsNotNull(r1, "<set-?>");
        skinStatusInterceptor = r1;
    }

    public final ISkinViewInterceptor getSkinViewInterceptor() {
        return skinViewInterceptor;
    }

    public final void setSkinViewInterceptor(ISkinViewInterceptor r1) {
        Intrinsics.checkParameterIsNotNull(r1, "<set-?>");
        skinViewInterceptor = r1;
    }

    public final ISkinListenerInterceptor getSkinListenerInterceptor() {
        return skinListenerInterceptor;
    }

    public final void setSkinListenerInterceptor(ISkinListenerInterceptor r1) {
        Intrinsics.checkParameterIsNotNull(r1, "<set-?>");
        skinListenerInterceptor = r1;
    }

    public final ISkinWebViewInterceptor getSkinWebViewInterceptor() {
        return skinWebViewInterceptor;
    }

    public final void setSkinWebViewInterceptor(ISkinWebViewInterceptor r1) {
        Intrinsics.checkParameterIsNotNull(r1, "<set-?>");
        skinWebViewInterceptor = r1;
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean isDarkMode() {
        return skinStatusInterceptor.isDarkMode();
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean isCurPageNightMode(Activity r1) {
        Intrinsics.checkParameterIsNotNull(r1, "activity");
        return skinStatusInterceptor.isCurPageNightMode(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean isIgnoreActivity(Activity r1) {
        Intrinsics.checkParameterIsNotNull(r1, "activity");
        return skinStatusInterceptor.isIgnoreActivity(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean inWhiteList(Activity r1) {
        Intrinsics.checkParameterIsNotNull(r1, "activity");
        return skinStatusInterceptor.inWhiteList(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean isDetailPageCssReady() {
        return skinStatusInterceptor.isDetailPageCssReady();
    }

    @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
    public boolean isJSReader() {
        return skinStatusInterceptor.isJSReader();
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setTextColor(TextView r1, int r2) {
        skinViewInterceptor.setTextColor(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setTextColor(TextView r1, int r2, boolean r3) {
        skinViewInterceptor.setTextColor(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setHintTextColor(TextView r1, int r2) {
        skinViewInterceptor.setHintTextColor(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setHintTextColor(TextView r1, int r2, boolean r3) {
        skinViewInterceptor.setHintTextColor(r1, r2, r3);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setColorFilter(ImageView r1, int r2) {
        skinViewInterceptor.setColorFilter(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setBackgroundColor(View r1, int r2) {
        skinViewInterceptor.setBackgroundColor(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public int refreshNewColor(int r1) {
        return skinViewInterceptor.refreshNewColor(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public ColorStateList getColorStateListFromSkinResource(int r1) {
        return skinViewInterceptor.getColorStateListFromSkinResource(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public Drawable getDrawableFromSkinResource(int r1) {
        return skinViewInterceptor.getDrawableFromSkinResource(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public int getColorFromSkinResource(int r1) {
        return skinViewInterceptor.getColorFromSkinResource(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public ColorStateList refreshNewColorStateList(int r1) {
        return skinViewInterceptor.refreshNewColorStateList(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void setViewIgnore(View r1) {
        skinViewInterceptor.setViewIgnore(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void resetViewIgnore(View r1) {
        skinViewInterceptor.resetViewIgnore(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void ignoreActivity(Activity r1) {
        Intrinsics.checkParameterIsNotNull(r1, "activity");
        skinViewInterceptor.ignoreActivity(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void refreshView(View r1) {
        skinViewInterceptor.refreshView(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void refreshView(View r1, boolean r2) {
        skinViewInterceptor.refreshView(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
    public void registerViewOnSkinChangeListener(View r1, Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkParameterIsNotNull(r2, "callback");
        skinViewInterceptor.registerViewOnSkinChangeListener(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinListenerInterceptor
    public void addSkinChangeListener(ISkinChangeListener r1) {
        skinListenerInterceptor.addSkinChangeListener(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinListenerInterceptor
    public void removeSkinChangeListener(ISkinChangeListener r1) {
        skinListenerInterceptor.removeSkinChangeListener(r1);
    }

    @Override // com.tt.skin.sdk.api.ISkinListenerInterceptor
    public void addLifeCycleSkinChangeListener(LifecycleOwner r1, ISkinChangeListener r2) {
        Intrinsics.checkParameterIsNotNull(r1, "lifecycleOwner");
        skinListenerInterceptor.addLifeCycleSkinChangeListener(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinWebViewInterceptor
    public IWebViewNightModeHelper judgeWebViewNightMode(LifecycleOwner r1, WebView r2) {
        return skinWebViewInterceptor.judgeWebViewNightMode(r1, r2);
    }

    @Override // com.tt.skin.sdk.api.ISkinWebViewInterceptor
    public IWebViewNightModeHelper judgeWebViewNightMode(LifecycleOwner r1, WebView r2, boolean r3) {
        return skinWebViewInterceptor.judgeWebViewNightMode(r1, r2, r3);
    }

    @Override // com.tt.skin.sdk.api.ISkinWebViewInterceptor
    public IWebViewNightModeHelper getNightModeHelper(WebView r1) {
        return skinWebViewInterceptor.getNightModeHelper(r1);
    }
}
