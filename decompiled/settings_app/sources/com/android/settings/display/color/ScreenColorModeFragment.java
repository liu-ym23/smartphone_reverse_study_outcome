package com.android.settings.display.color;

import android.content.res.Resources;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.android.settings.R;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.databinding.LayoutScreenClolorModeBinding;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ThreadUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: ScreenColorModeFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/android/settings/display/color/ScreenColorModeFragment;", "Lcom/android/settings/base/BaseFragment;", "()V", "eyeProtectedModeObserver", "com/android/settings/display/color/ScreenColorModeFragment$eyeProtectedModeObserver$1", "Lcom/android/settings/display/color/ScreenColorModeFragment$eyeProtectedModeObserver$1;", "viewBinding", "Lcom/android/settings/databinding/LayoutScreenClolorModeBinding;", "viewModel", "Lcom/android/settings/display/color/ScreenColorModeViewModel;", "getViewModel", "()Lcom/android/settings/display/color/ScreenColorModeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScreenColorModeFragment extends BaseFragment {
    private final ScreenColorModeFragment$eyeProtectedModeObserver$1 eyeProtectedModeObserver;
    private LayoutScreenClolorModeBinding viewBinding;
    private final Lazy viewModel$delegate;

    public static /* synthetic */ void $r8$lambda$Ak8NZBmUsNfTh0p1oWoBm7aRbM0(ScreenColorModeFragment r0, View r1) {
        initView$lambda$4$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$DDxIjtZzUsqw7E3I0HAASH-7HIg, reason: not valid java name */
    public static /* synthetic */ void m448$r8$lambda$DDxIjtZzUsqw7E3I0HAASH7HIg(ScreenColorModeFragment r0, CompoundButton r1, boolean r2) {
        initView$lambda$8$lambda$7(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$JsiRilG-4133CtLgGppQz0M8Vf8, reason: not valid java name */
    public static /* synthetic */ void m449$r8$lambda$JsiRilG4133CtLgGppQz0M8Vf8(ScreenColorModeFragment r0, View r1) {
        initView$lambda$2$lambda$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$WwlLVdM6TE4t3MY2q0KlpXbdgIg(ScreenColorModeFragment r0, View r1) {
        initView$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$_K-uZQUJ03nB366L-XF3gSUdrS8, reason: not valid java name */
    public static /* synthetic */ void m450$r8$lambda$_KuZQUJ03nB366LXF3gSUdrS8(ScreenColorModeFragment r0, View r1) {
        initView$lambda$6$lambda$5(r0, r1);
    }

    public void com_android_settings_display_color_ScreenColorModeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_display_color_ScreenColorModeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_display_color_ScreenColorModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_display_color_ScreenColorModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.android.settings.display.color.ScreenColorModeFragment$eyeProtectedModeObserver$1] */
    public ScreenColorModeFragment() {
        final ScreenColorModeFragment r0 = this;
        final Function0<Fragment> r1 = new ScreenColorModeFragment$special$$inlined$viewModels$default$1(r0);
        final Lazy r2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ScreenColorModeFragment$special$$inlined$viewModels$default$2(r1));
        final Function0 r5 = null;
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(r0, Reflection.getOrCreateKotlinClass(ScreenColorModeViewModel.class), new ScreenColorModeFragment$special$$inlined$viewModels$default$3(r2), new ScreenColorModeFragment$special$$inlined$viewModels$default$4(r5, r2), new ScreenColorModeFragment$special$$inlined$viewModels$default$5(r0, r2));
        final Handler r3 = ThreadUtils.getUiThreadHandler();
        this.eyeProtectedModeObserver = new ScreenColorModeFragment$eyeProtectedModeObserver$1(this, r3);
    }

    public static final /* synthetic */ ScreenColorModeFragment$eyeProtectedModeObserver$1 access$getEyeProtectedModeObserver$p(ScreenColorModeFragment r0) {
        return r0.eyeProtectedModeObserver;
    }

    public static final /* synthetic */ ScreenColorModeViewModel access$getViewModel(ScreenColorModeFragment r0) {
        return r0.getViewModel();
    }

    private final ScreenColorModeViewModel getViewModel() {
        return (ScreenColorModeViewModel) this.viewModel$delegate.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        LayoutScreenClolorModeBinding r5 = LayoutScreenClolorModeBinding.inflate(r2);
        Intrinsics.checkNotNullExpressionValue(r5, "inflate(...)");
        this.viewBinding = r5;
        View r6 = UIUtils.buildNoScaledView(this.mContext, R.layout.view_banner_screen_color);
        LayoutScreenClolorModeBinding r7 = this.viewBinding;
        LayoutScreenClolorModeBinding r8 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L5:
        r7.banner.addView(r6);
        LayoutScreenClolorModeBinding r1 = this.viewBinding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L9:
        RelativeLayout r9 = r8.getRoot();
        Intrinsics.checkNotNullExpressionValue(r9, "getRoot(...)");
        return r9;
    L8:
        r8 = r1;
        goto L9
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        initView();
        getViewLifecycleOwner().getLifecycle().addObserver(new AnonymousClass1(this));
    }

    private final void initView() {
        if (getContext() != null) goto L5;
        return;
    L5:
        LayoutScreenClolorModeBinding r0 = this.viewBinding;
        LayoutScreenClolorModeBinding r2 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L8:
        OFloatingTitleBar r3 = r0.titleBar;
        Intrinsics.checkNotNullExpressionValue(r3, "titleBar");
        OFloatingTitleBar.addStartAction$default(r3, R.drawable.o_floating_title_bar_icon_back, 0, null, 6, null).setOnClickListener(new ScreenColorModeFragment$$ExternalSyntheticLambda0(this));
        LayoutScreenClolorModeBinding r1 = this.viewBinding;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L11:
        final OCardListItem r4 = r1.adaptive;
        OCardListItemUtils.setCustomEndImageView(r4);
        r4.showCustomEnd(false);
        getViewModel().getCurrentColorModeLv().observe(getViewLifecycleOwner(), new ScreenColorModeFragment$sam$androidx_lifecycle_Observer$0(new ScreenColorModeFragment$initView$2$1(r4)));
        r4.getTitleView().setMaxWidth(MathKt.roundToInt(TypedValue.applyDimension(1, UCharacter.UnicodeBlock.TAKRI_ID, Resources.getSystem().getDisplayMetrics())));
        r4.setOnContentClickListener(new ScreenColorModeFragment$$ExternalSyntheticLambda1(this));
        LayoutScreenClolorModeBinding r5 = this.viewBinding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L14:
        final OCardListItem r6 = r5.standard;
        OCardListItemUtils.setCustomEndImageView(r6);
        r6.showCustomEnd(false);
        getViewModel().getCurrentColorModeLv().observe(getViewLifecycleOwner(), new ScreenColorModeFragment$sam$androidx_lifecycle_Observer$0(new ScreenColorModeFragment$initView$3$1(r6)));
        r6.setOnContentClickListener(new ScreenColorModeFragment$$ExternalSyntheticLambda2(this));
        LayoutScreenClolorModeBinding r7 = this.viewBinding;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L17:
        final OCardListItem r8 = r7.professional;
        OCardListItemUtils.setCustomEndImageView(r8);
        r8.showCustomEnd(false);
        getViewModel().getCurrentColorModeLv().observe(getViewLifecycleOwner(), new ScreenColorModeFragment$sam$androidx_lifecycle_Observer$0(new ScreenColorModeFragment$initView$4$1(r8)));
        r8.setOnContentClickListener(new ScreenColorModeFragment$$ExternalSyntheticLambda3(this));
        LayoutScreenClolorModeBinding r9 = this.viewBinding;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r9 = null;
    L20:
        r9.adaptiveTemperature.getContentContainer().setClickable(false);
        LayoutScreenClolorModeBinding r10 = this.viewBinding;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r10 = null;
    L23:
        View r11 = r10.adaptiveTemperature.getCustomEndView();
        if ((r11 instanceof OSwitch) == false) goto L26;
        final OSwitch r12 = (OSwitch) r11;
    L27:
        if (r12 == null) goto L29;
        r12.setOnCheckedChangeListener(new ScreenColorModeFragment$$ExternalSyntheticLambda4(this));
        getViewModel().getEnableAdaptiveTemperatureLv().observe(getViewLifecycleOwner(), new ScreenColorModeFragment$sam$androidx_lifecycle_Observer$0(new ScreenColorModeFragment$initView$5$2(r12)));
    L29:
        LayoutScreenClolorModeBinding r13 = this.viewBinding;
        if (r13 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r13 = null;
    L32:
        final LinearLayout r14 = r13.colorTemperatureContainer;
        getViewModel().getEnableAdaptiveTemperatureLv().observe(getViewLifecycleOwner(), new ScreenColorModeFragment$sam$androidx_lifecycle_Observer$0(new ScreenColorModeFragment$initView$6$1(r14)));
        LayoutScreenClolorModeBinding r15 = this.viewBinding;
        if (r15 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r15 = null;
    L35:
        final ScreenTemperatureView r16 = r15.colorTemperatureView;
        getViewModel().getEyeProtectedModeEnabledLv().observe(getViewLifecycleOwner(), new ScreenColorModeFragment$sam$androidx_lifecycle_Observer$0(new ScreenColorModeFragment$initView$7$1(r16)));
        MutableLiveData<ScreenColorModeViewModel.TemperatureMode> r17 = getViewModel().getCurrentTemperatureModeLv();
        LifecycleOwner r18 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r18, "getViewLifecycleOwner(...)");
        r16.initView(r17, r18, getViewModel().getCurrentTemperaturePointPositionLv(), new ScreenColorModeFragment$initView$7$2(getViewModel()), new ScreenColorModeFragment$initView$7$3(getViewModel()));
        LayoutScreenClolorModeBinding r19 = this.viewBinding;
        if (r19 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L39:
        final OSectionSupportiveText r20 = r2.eyeProtectedTips;
        getViewModel().getShowEyeProtectedTipsLv().observe(getViewLifecycleOwner(), new ScreenColorModeFragment$sam$androidx_lifecycle_Observer$0(new ScreenColorModeFragment$initView$8$1(r20)));
        return;
    L38:
        r2 = r19;
        goto L39
    L26:
        r12 = null;
        goto L27
    }

    private static final void initView$lambda$0(ScreenColorModeFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L6;
        r2.onBackPressed();
        return;
    }

    private static final void initView$lambda$2$lambda$1(ScreenColorModeFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.getViewModel().updateColorMode(ScreenColorModeViewModel.ColorMode.Adaptive.INSTANCE);
    }

    private static final void initView$lambda$4$lambda$3(ScreenColorModeFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.getViewModel().updateColorMode(ScreenColorModeViewModel.ColorMode.Standard.INSTANCE);
    }

    private static final void initView$lambda$6$lambda$5(ScreenColorModeFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.getViewModel().updateColorMode(ScreenColorModeViewModel.ColorMode.Professional.INSTANCE);
    }

    private static final void initView$lambda$8$lambda$7(ScreenColorModeFragment r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        r1.getViewModel().updateEnableAdaptiveTemperature(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_display_color_ScreenColorModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ScreenColorModeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_display_color_ScreenColorModeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_display_color_ScreenColorModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ScreenColorModeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_display_color_ScreenColorModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_display_color_ScreenColorModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ScreenColorModeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_display_color_ScreenColorModeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
