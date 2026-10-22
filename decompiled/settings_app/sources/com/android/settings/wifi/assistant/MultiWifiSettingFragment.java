package com.android.settings.wifi.assistant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.base.BaseFragment;
import com.android.settings.databinding.MultiWifiSettingBinding;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.wifi.AccessPointInfo;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: MultiWifiSettingFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/android/settings/wifi/assistant/MultiWifiSettingFragment;", "Lcom/android/settings/base/BaseFragment;", "()V", "subWifiAdapter", "Lcom/android/settings/wifi/assistant/SubWifiAdapter;", "viewBinding", "Lcom/android/settings/databinding/MultiWifiSettingBinding;", "viewModel", "Lcom/android/settings/wifi/assistant/MultiWifiViewModel;", "getViewModel", "()Lcom/android/settings/wifi/assistant/MultiWifiViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MultiWifiSettingFragment extends BaseFragment {
    private final SubWifiAdapter subWifiAdapter;
    private MultiWifiSettingBinding viewBinding;
    private final Lazy viewModel$delegate;

    public static /* synthetic */ void $r8$lambda$DXtr8rc_1wZf7gBVVjVv5TiCqgo(MultiWifiSettingFragment r0, View r1) {
        onViewCreated$lambda$10$lambda$9(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$K3LauUXgM4k5yxeXHck-mUzoWNE, reason: not valid java name */
    public static /* synthetic */ void m717$r8$lambda$K3LauUXgM4k5yxeXHckmUzoWNE(MultiWifiSettingFragment r0, View r1) {
        onViewCreated$lambda$11(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$LTZlS9M8RvkIOeHljomtO1KuSOk(MultiWifiSettingFragment r0, CompoundButton r1, boolean r2) {
        onViewCreated$lambda$7$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$gFw88iHqLbBtt1OwiTBLXDBbU2w(MultiWifiSettingFragment r0, OCardListItem r1, View r2) {
        onViewCreated$lambda$5$lambda$4(r0, r1, r2);
    }

    public void com_android_settings_wifi_assistant_MultiWifiSettingFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_wifi_assistant_MultiWifiSettingFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_assistant_MultiWifiSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_assistant_MultiWifiSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public static final /* synthetic */ SubWifiAdapter access$getSubWifiAdapter$p(MultiWifiSettingFragment r0) {
        return r0.subWifiAdapter;
    }

    public static final /* synthetic */ String access$getTAG$p(MultiWifiSettingFragment r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ MultiWifiSettingBinding access$getViewBinding$p(MultiWifiSettingFragment r0) {
        return r0.viewBinding;
    }

    public static final /* synthetic */ MultiWifiViewModel access$getViewModel(MultiWifiSettingFragment r0) {
        return r0.getViewModel();
    }

    public MultiWifiSettingFragment() {
        final MultiWifiSettingFragment r0 = this;
        final Function0<Fragment> r1 = new MultiWifiSettingFragment$special$$inlined$viewModels$default$1(r0);
        final Lazy r2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MultiWifiSettingFragment$special$$inlined$viewModels$default$2(r1));
        final Function0 r5 = null;
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(r0, Reflection.getOrCreateKotlinClass(MultiWifiViewModel.class), new MultiWifiSettingFragment$special$$inlined$viewModels$default$3(r2), new MultiWifiSettingFragment$special$$inlined$viewModels$default$4(r5, r2), new MultiWifiSettingFragment$special$$inlined$viewModels$default$5(r0, r2));
        this.subWifiAdapter = new SubWifiAdapter(new MultiWifiSettingFragment$subWifiAdapter$1(this));
    }

    private final MultiWifiViewModel getViewModel() {
        return (MultiWifiViewModel) this.viewModel$delegate.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        MultiWifiSettingBinding r4 = MultiWifiSettingBinding.inflate(r1);
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.viewBinding = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L5:
        RelativeLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        return r0;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        MultiWifiViewModel r9 = getViewModel();
        Lifecycle r10 = getViewLifecycleOwner().getLifecycle();
        Context r0 = getContext();
        if (r0 != null) goto L5;
        r0 = SettingsApplication.getContext();
    L5:
        Intrinsics.checkNotNull(r0);
        r9.onViewCreate(r10, r0);
        MultiWifiSettingBinding r11 = this.viewBinding;
        MultiWifiSettingBinding r12 = null;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r11 = null;
    L8:
        final ODownloadProgressView r13 = r11.refreshLoading;
        getViewModel().isScanningLv().observe(getViewLifecycleOwner(), new MultiWifiSettingFragment$sam$androidx_lifecycle_Observer$0(new MultiWifiSettingFragment$onViewCreated$1$1(r13, this)));
        MultiWifiSettingBinding r14 = this.viewBinding;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r14 = null;
    L11:
        RecyclerView r15 = r14.wifiList;
        r15.setAdapter(this.subWifiAdapter);
        r15.setLayoutManager(new LinearLayoutManager(r15.getContext()));
        getViewModel().getAccessPointInfoListLv().observe(getViewLifecycleOwner(), new MultiWifiSettingFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass3(this)));
        MultiWifiSettingBinding r16 = this.viewBinding;
        if (r16 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r16 = null;
    L14:
        final OCardListItem r17 = r16.mainWifi;
        ImageView r1 = new ImageView(r17.getContext());
        r1.setImageResource(R.drawable.ic_info_button_bold);
        r17.setCustomEndView(r1);
        r17.clearCustomTitleView();
        r17.setCustomTitleView(R.layout.view_o_card_list_wifi_title_tag, 0, true);
        r17.showTitle(false);
        final TextView r2 = (TextView) r17.findViewById(R.id.custom_title_text);
        final View r3 = r17.findViewById(R.id.custom_title_tag);
        getViewModel().getConnectedAccessPointInfoLv().observe(getViewLifecycleOwner(), new MultiWifiSettingFragment$sam$androidx_lifecycle_Observer$0(new MultiWifiSettingFragment$onViewCreated$4$1(r17, this, r3, r2)));
        r17.setOnContentClickListener(new MultiWifiSettingFragment$$ExternalSyntheticLambda0(this, r17));
        MultiWifiSettingBinding r18 = this.viewBinding;
        if (r18 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r18 = null;
    L17:
        final OCardListItem r19 = r18.multiWifiAcceleration;
        OSwitch r4 = r19.getEndSwitch();
        if (r4 == null) goto L20;
        r4.setOnCheckedChangeListener(new MultiWifiSettingFragment$$ExternalSyntheticLambda1(this));
    L20:
        getViewModel().getMultiWifiEnabledLv().observe(getViewLifecycleOwner(), new MultiWifiSettingFragment$sam$androidx_lifecycle_Observer$0(new MultiWifiSettingFragment$onViewCreated$5$2(r19)));
        getViewModel().getWifiEnabledLv().observe(getViewLifecycleOwner(), new MultiWifiSettingFragment$sam$androidx_lifecycle_Observer$0(new MultiWifiSettingFragment$onViewCreated$5$3(r19)));
        MultiWifiSettingBinding r20 = this.viewBinding;
        if (r20 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r20 = null;
    L23:
        final Group r21 = r20.multiWifiGroup;
        getViewModel().getMultiWifiEnabledLv().observe(getViewLifecycleOwner(), new MultiWifiSettingFragment$sam$androidx_lifecycle_Observer$0(new MultiWifiSettingFragment$onViewCreated$6$1(this, r21)));
        MultiWifiSettingBinding r22 = this.viewBinding;
        if (r22 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r22 = null;
    L26:
        final OTextView r23 = r22.refreshBtn;
        getViewModel().isScanningLv().observe(getViewLifecycleOwner(), new MultiWifiSettingFragment$sam$androidx_lifecycle_Observer$0(new MultiWifiSettingFragment$onViewCreated$7$1(r23, this)));
        r23.setOnClickListener(new MultiWifiSettingFragment$$ExternalSyntheticLambda2(this));
        MultiWifiSettingBinding r24 = this.viewBinding;
        if (r24 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L30:
        OFloatingTitleBar r5 = r12.titleBar;
        Intrinsics.checkNotNullExpressionValue(r5, "titleBar");
        OFloatingTitleBar.addStartAction$default(r5, R.drawable.o_floating_title_bar_icon_back, 0, null, 6, null).setOnClickListener(new MultiWifiSettingFragment$$ExternalSyntheticLambda3(this));
        return;
    L29:
        r12 = r24;
        goto L30
    }

    private static final void onViewCreated$lambda$5$lambda$4(MultiWifiSettingFragment r6, OCardListItem r7, View r8) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Intrinsics.checkNotNullParameter(r7, "$this_apply");
        SubAccessPoint r9 = r6.getViewModel().getConnectedAccessPointInfoLv().getValue();
        if (r9 == null) goto L8;
        AccessPointInfo r2 = r9.getInfo();
        if (r2 == null) goto L9;
        WifiUtils r0 = WifiUtils.INSTANCE;
        Context r1 = r7.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        WifiUtils.openAccessPointDetailPage$default(r0, r1, r2, false, 4, null);
        return;
    L9:
        return;
    }

    private static final void onViewCreated$lambda$7$lambda$6(MultiWifiSettingFragment r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        MultiWifiViewModel r4 = r1.getViewModel();
        Context r5 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "getContext(...)");
        r4.setMultiWifiEnabled(r5, r3);
        TrackerEvent.switchEvent("multi_wifi", r3);
    }

    private static final void onViewCreated$lambda$10$lambda$9(MultiWifiSettingFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.getViewModel().startScan();
    }

    private static final void onViewCreated$lambda$11(MultiWifiSettingFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L6;
        r2.finish();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        getViewModel().onActivityResult(getActivity(), r2, r3, r4);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_assistant_MultiWifiSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MultiWifiSettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_assistant_MultiWifiSettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_assistant_MultiWifiSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MultiWifiSettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_assistant_MultiWifiSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_assistant_MultiWifiSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MultiWifiSettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_assistant_MultiWifiSettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
