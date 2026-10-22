package com.android.settings.display;

import android.content.ContentResolver;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import bytedanceos.api.WindowManagerSmt;
import com.android.settings.DisplaySizeSettingsFragment;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.ToastUtils;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.databinding.LayoutResolutionSettingsBinding;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DeviceBrand;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.ThreadUtils;
import com.android.settingslib.display.DisplayDensityUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Typography;
import kotlinx.coroutines.DebugKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: ScreenResolutionFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001fH\u0002R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u000b8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/android/settings/display/ScreenResolutionFragment;", "Lcom/android/settings/base/BaseFragment;", "()V", "value", "", "autoResolutionEnabled", "getAutoResolutionEnabled", "()Z", "setAutoResolutionEnabled", "(Z)V", "currentResolution", "Lcom/android/settings/display/ScreenResolutionFragment$Resolution;", "getCurrentResolution", "()Lcom/android/settings/display/ScreenResolutionFragment$Resolution;", "dataBinding", "Lcom/android/settings/databinding/LayoutResolutionSettingsBinding;", "getDataBinding", "()Lcom/android/settings/databinding/LayoutResolutionSettingsBinding;", "dataBinding$delegate", "Lkotlin/Lazy;", "observer", "Landroidx/lifecycle/Observer;", "disableItemClick", "", "scene", "", "initView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onItemClick", "item", "Companion", "Resolution", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScreenResolutionFragment extends BaseFragment {
    public static final Companion Companion = null;
    private static final Point HD_RESOLUTION = null;
    private static final String TAG = "ResolutionFragment";
    private static final Point UHD_RESOLUTION = null;
    private static MutableLiveData<Boolean> itemClickAbleLv;
    private boolean autoResolutionEnabled;
    private Resolution currentResolution;
    private final Lazy dataBinding$delegate;
    private final Observer<Boolean> observer;

    /* JADX INFO: compiled from: ScreenResolutionFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/settings/display/ScreenResolutionFragment$Companion;", "", "()V", "HD_RESOLUTION", "Landroid/graphics/Point;", "getHD_RESOLUTION", "()Landroid/graphics/Point;", "TAG", "", "UHD_RESOLUTION", "getUHD_RESOLUTION", "itemClickAbleLv", "Landroidx/lifecycle/MutableLiveData;", "", "getCurrentResolutionString", "contentResolver", "Landroid/content/ContentResolver;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Point getUHD_RESOLUTION() {
            return ScreenResolutionFragment.access$getUHD_RESOLUTION$cp();
        }

        public final Point getHD_RESOLUTION() {
            return ScreenResolutionFragment.access$getHD_RESOLUTION$cp();
        }

        public final String getCurrentResolutionString(ContentResolver r2) {
            Intrinsics.checkNotNullParameter(r2, "contentResolver");
            if (Settings.Global.getInt(r2, "resolution_auto", 0) == 1) goto L5;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
            Object r3 = SettingsApplication.getContext().getSystemService("window");     // Catch: Throwable -> L19
            if ((r3 instanceof WindowManager) == false) goto L9;
            WindowManager r4 = (WindowManager) r3;     // Catch: Throwable -> L19
        L10:
            if (r4 == null) goto L16;
            WindowMetrics r5 = r4.getCurrentWindowMetrics();     // Catch: Throwable -> L19
            if (r5 == null) goto L16;
            Rect r6 = r5.getBounds();     // Catch: Throwable -> L19
            if (r6 == null) goto L16;
            int r7 = r6.width() * r6.height();     // Catch: Throwable -> L19
        L17:
            Object r8 = Result.m1508constructorimpl(Integer.valueOf(r7));     // Catch: Throwable -> L19
        L22:
            if (Result.m1514isFailureimpl(r8) == false) goto L24;
            r8 = 0;
        L24:
            ((Number) r8).intValue();
            return ResourceUtils.getString(R.string.resolution_UHD);
        L16:
            r7 = 0;
            goto L17
        L9:
            r4 = null;
        L19:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r8 = Result.m1508constructorimpl(ResultKt.createFailure(th));
            goto L22
        L5:
            return ResourceUtils.getString(R.string.resolution_auto);
        }
    }

    /* JADX INFO: compiled from: ScreenResolutionFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/settings/display/ScreenResolutionFragment$Resolution;", "", "()V", "HD", "UHD", "Lcom/android/settings/display/ScreenResolutionFragment$Resolution$HD;", "Lcom/android/settings/display/ScreenResolutionFragment$Resolution$UHD;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Resolution {

        /* JADX INFO: compiled from: ScreenResolutionFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/display/ScreenResolutionFragment$Resolution$HD;", "Lcom/android/settings/display/ScreenResolutionFragment$Resolution;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class HD extends Resolution {
            public static final HD INSTANCE = null;

            static {
                INSTANCE = new HD();
            }

            private HD() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ScreenResolutionFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/display/ScreenResolutionFragment$Resolution$UHD;", "Lcom/android/settings/display/ScreenResolutionFragment$Resolution;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class UHD extends Resolution {
            public static final UHD INSTANCE = null;

            static {
                INSTANCE = new UHD();
            }

            private UHD() {
                super(null);
            }
        }

        public /* synthetic */ Resolution(DefaultConstructorMarker r1) {
            this();
        }

        private Resolution() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$B-YfSqAhH7t0ZbwOakR2oYKtZ4s, reason: not valid java name */
    public static /* synthetic */ void m445$r8$lambda$BYfSqAhH7t0ZbwOakR2oYKtZ4s(ScreenResolutionFragment r0, View r1) {
        initView$lambda$6$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$J9UagpoE0IWFFXAv64kfN5-Htfo, reason: not valid java name */
    public static /* synthetic */ void m446$r8$lambda$J9UagpoE0IWFFXAv64kfN5Htfo(ScreenResolutionFragment r0, boolean r1) {
        observer$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$NIQTV1dTfWTThAmESLELSwZeMqs() {
        disableItemClick$lambda$17();
    }

    public static /* synthetic */ void $r8$lambda$Pk5AEkPkoJGML_hy6Xgb5hDwgo0(ScreenResolutionFragment r0, View r1) {
        initView$lambda$8$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$vJaQEuncgugbbDUMzYmkIVLig-s, reason: not valid java name */
    public static /* synthetic */ void m447$r8$lambda$vJaQEuncgugbbDUMzYmkIVLigs(Ref.IntRef r0, ScreenResolutionFragment r1) {
        onItemClick$lambda$12(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ySIXQebXkhzI64vKpj4mwjsRQig(Ref.IntRef r0, ScreenResolutionFragment r1) {
        onItemClick$lambda$16(r0, r1);
    }

    public void com_android_settings_display_ScreenResolutionFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_display_ScreenResolutionFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_display_ScreenResolutionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_display_ScreenResolutionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ScreenResolutionFragment() {
        this.dataBinding$delegate = LazyKt.lazy(new ScreenResolutionFragment$dataBinding$2(this));
        this.currentResolution = Resolution.UHD.INSTANCE;
        this.observer = new ScreenResolutionFragment$$ExternalSyntheticLambda0(this);
    }

    public static final /* synthetic */ Point access$getHD_RESOLUTION$cp() {
        return HD_RESOLUTION;
    }

    public static final /* synthetic */ View access$getMRootView$p(ScreenResolutionFragment r0) {
        return r0.mRootView;
    }

    public static final /* synthetic */ Point access$getUHD_RESOLUTION$cp() {
        return UHD_RESOLUTION;
    }

    static {
        Companion = new Companion(null);
        UHD_RESOLUTION = new Point(1260, 2800);
        HD_RESOLUTION = new Point(1080, 2400);
        itemClickAbleLv = new MutableLiveData(true);
    }

    private final LayoutResolutionSettingsBinding getDataBinding() {
        return (LayoutResolutionSettingsBinding) this.dataBinding$delegate.getValue();
    }

    private final boolean getAutoResolutionEnabled() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "resolution_auto", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private final void setAutoResolutionEnabled(boolean r3) {
        Settings.Global.putInt(this.mContext.getContentResolver(), "resolution_auto", r3 ? 1 : 0);
        this.autoResolutionEnabled = r3;
    }

    private final Resolution getCurrentResolution() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        Object r1 = SettingsApplication.getContext().getSystemService("window");     // Catch: Throwable -> L16
        if ((r1 instanceof WindowManager) == false) goto L6;
        WindowManager r2 = (WindowManager) r1;     // Catch: Throwable -> L16
    L7:
        if (r2 == null) goto L13;
        WindowMetrics r3 = r2.getCurrentWindowMetrics();     // Catch: Throwable -> L16
        if (r3 == null) goto L13;
        Rect r4 = r3.getBounds();     // Catch: Throwable -> L16
        if (r4 == null) goto L13;
        int r5 = r4.width() * r4.height();     // Catch: Throwable -> L16
    L14:
        Object r6 = Result.m1508constructorimpl(Integer.valueOf(r5));     // Catch: Throwable -> L16
    L19:
        if (Result.m1514isFailureimpl(r6) == false) goto L21;
        r6 = 0;
    L21:
        int r7 = ((Number) r6).intValue();
        Point r8 = HD_RESOLUTION;
        if (r7 <= (r8.x * r8.y)) goto L25;
        return Resolution.UHD.INSTANCE;
    L25:
        return Resolution.HD.INSTANCE;
    L13:
        r5 = 0;
        goto L14
    L6:
        r2 = null;
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    private static final void observer$lambda$2(ScreenResolutionFragment r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.getDataBinding().uhdItem.setClickable(r2);
        r1.getDataBinding().autoItem.setClickable(r2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        if (r6 != null) goto L5;
        itemClickAbleLv.setValue(true);
    L5:
        this.mRootView = r4.inflate(R.layout.layout_resolution_settings, r5, false);
        initView();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L8
        Object r8 = SettingsApplication.getContext().getSystemService("window");     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: Throwable -> L8
        Rect r9 = ((WindowManager) r8).getCurrentWindowMetrics().getBounds();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r9, "getBounds(...)");     // Catch: Throwable -> L8
        DisplayMetrics r10 = this.mContext.getResources().getDisplayMetrics();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r10, "getDisplayMetrics(...)");     // Catch: Throwable -> L8
        OLog.d(TAG, "screen size: " + r9.width() + '*' + r9.height() + " dpi: " + r10.densityDpi + " xDpi=" + r10.xdpi + " yDpi=" + r10.ydpi);     // Catch: Throwable -> L8
        Object r11 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r12 = Result.m1511exceptionOrNullimpl(r11);
        if (r12 == null) goto L14;
        OLog.e(TAG, "onCreateView: ", r12);
    L14:
        return this.mRootView;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void initView() {
        OCardListItem r0 = getDataBinding().uhdItem;
        StringBuilder r1 = new StringBuilder();
        Point r2 = UHD_RESOLUTION;
        r0.setSubTitle(r1.append(r2.y).append(Typography.times).append(r2.x).append(ResourceUtils.getString(R.string.UHD_clearer)).toString());
        OCardListItemUtils.setCustomEndImageView(r0);
        r0.showCustomEnd(!getAutoResolutionEnabled());
        r0.setOnContentClickListener(new ScreenResolutionFragment$$ExternalSyntheticLambda1(this));
        OCardListItem r3 = getDataBinding().autoItem;
        OCardListItemUtils.setCustomEndImageView(r3);
        r3.showCustomEnd(getAutoResolutionEnabled());
        r3.setOnContentClickListener(new ScreenResolutionFragment$$ExternalSyntheticLambda2(this));
        itemClickAbleLv.observeForever(this.observer);
    }

    private static final void initView$lambda$6$lambda$5(ScreenResolutionFragment r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNull(r2);
        r1.onItemClick(r2);
    }

    private static final void initView$lambda$8$lambda$7(ScreenResolutionFragment r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNull(r2);
        r1.onItemClick(r2);
    }

    private final void onItemClick(View r11) {
        if (Intrinsics.areEqual(r11, getDataBinding().uhdItem.getContentContainer()) == false) goto L17;
        if (Intrinsics.areEqual(getCurrentResolution(), Resolution.UHD.INSTANCE) == true) goto L15;
        getDataBinding().uhdItem.getContentContainer().setBackground(ResourcesCompat.getDrawable(ResourceUtils.getResources(), R.drawable.setting_item_backgroud_pressed, null));
        int r0 = new DisplayDensityUtils(this._mActivity).getCurrentIndexForDefaultDisplay();
        final Ref.IntRef r8 = new Ref.IntRef();
        r8.element = 560;
        if (r0 < 0) goto L12;
        if (r0 >= DisplaySizeSettingsFragment.DISPLAY_SIZE_VALUES.length) goto L12;
        r8.element = DisplaySizeSettingsFragment.DISPLAY_SIZE_VALUES[r0];
    L12:
        if (DeviceBrand.isNubia() == false) goto L14;
        r8.element = 560;
    L14:
        ThreadUtils.getUiThreadHandler().postDelayed(new ScreenResolutionFragment$$ExternalSyntheticLambda4(r8, this), 120);
        goto L17
    L15:
        this.currentResolution = Resolution.UHD.INSTANCE;
        getDataBinding().uhdItem.showCustomEnd(true);
        getDataBinding().autoItem.showCustomEnd(false);
        setAutoResolutionEnabled(false);
    L17:
        if (Intrinsics.areEqual(r11, getDataBinding().autoItem.getContentContainer()) == true) goto L19;
        return;
    L19:
        if (getAutoResolutionEnabled() == false) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual(getCurrentResolution(), Resolution.UHD.INSTANCE) == true) goto L31;
        getDataBinding().autoItem.getContentContainer().setBackground(ResourcesCompat.getDrawable(ResourceUtils.getResources(), R.drawable.setting_item_backgroud_pressed, null));
        int r12 = new DisplayDensityUtils(this._mActivity).getCurrentIndexForDefaultDisplay();
        final Ref.IntRef r1 = new Ref.IntRef();
        r1.element = 560;
        if (r12 < 0) goto L28;
        if (r12 >= DisplaySizeSettingsFragment.DISPLAY_SIZE_VALUES.length) goto L28;
        r1.element = DisplaySizeSettingsFragment.DISPLAY_SIZE_VALUES[r12];
    L28:
        if (DeviceBrand.isNubia() == false) goto L30;
        r1.element = 560;
    L30:
        ThreadUtils.getUiThreadHandler().postDelayed(new ScreenResolutionFragment$$ExternalSyntheticLambda5(r1, this), 120);
        return;
    L31:
        this.currentResolution = Resolution.UHD.INSTANCE;
        getDataBinding().uhdItem.showCustomEnd(false);
        getDataBinding().autoItem.showCustomEnd(true);
        setAutoResolutionEnabled(true);
    }

    private static final void onItemClick$lambda$12(Ref.IntRef r4, ScreenResolutionFragment r5) {
        Intrinsics.checkNotNullParameter(r4, "$densityDpi");
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        WindowManagerSmt r2 = WindowManagerSmt.getInstance();     // Catch: Throwable -> L5
        Point r3 = UHD_RESOLUTION;     // Catch: Throwable -> L5
        r2.setForcedDisplayDensityAndSize(0, r3.x, r3.y, r4.element);     // Catch: Throwable -> L5
        r5.disableItemClick("uhd");     // Catch: Throwable -> L5
        Object r6 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1511exceptionOrNullimpl(r6);
        if (r7 == null) goto L11;
        OLog.e(TAG, "onItemClick: ", r7);
        ToastUtils.show(r5._mActivity, R.string.change_fail);
    L11:
        if (Result.m1515isSuccessimpl(r6) == false) goto L16;
        Unit r8 = (Unit) r6;
        r5.currentResolution = Resolution.UHD.INSTANCE;
        r5.getDataBinding().uhdItem.showCustomEnd(true);
        r5.getDataBinding().autoItem.showCustomEnd(false);
        r5.setAutoResolutionEnabled(false);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final void onItemClick$lambda$16(Ref.IntRef r4, ScreenResolutionFragment r5) {
        Intrinsics.checkNotNullParameter(r4, "$densityDpi");
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        WindowManagerSmt r2 = WindowManagerSmt.getInstance();     // Catch: Throwable -> L5
        Point r3 = UHD_RESOLUTION;     // Catch: Throwable -> L5
        r2.setForcedDisplayDensityAndSize(0, r3.x, r3.y, r4.element);     // Catch: Throwable -> L5
        r5.disableItemClick(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);     // Catch: Throwable -> L5
        Object r6 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1511exceptionOrNullimpl(r6);
        if (r7 == null) goto L11;
        OLog.e(TAG, "onItemClick: ", r7);
        ToastUtils.show(r5._mActivity, R.string.change_fail);
    L11:
        if (Result.m1515isSuccessimpl(r6) == false) goto L16;
        Unit r8 = (Unit) r6;
        r5.currentResolution = Resolution.UHD.INSTANCE;
        r5.getDataBinding().uhdItem.showCustomEnd(false);
        r5.getDataBinding().autoItem.showCustomEnd(true);
        r5.setAutoResolutionEnabled(true);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void disableItemClick(String r3) {
        OLog.i(TAG, "disableItemClick");
        itemClickAbleLv.setValue(false);
        ThreadUtils.getUiThreadHandler().postDelayed(new ScreenResolutionFragment$$ExternalSyntheticLambda3(), 2000);
    }

    private static final void disableItemClick$lambda$17() {
        itemClickAbleLv.setValue(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        itemClickAbleLv.removeObserver(this.observer);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        OLog.i(TAG, "onConfigurationChanged");
        initView();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_display_ScreenResolutionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ScreenResolutionFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_display_ScreenResolutionFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_display_ScreenResolutionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ScreenResolutionFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_display_ScreenResolutionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_display_ScreenResolutionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ScreenResolutionFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_display_ScreenResolutionFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
