package com.android.settings;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.base.BaseFragment;
import com.android.settings.databinding.AdServiceSettingsLayoutBinding;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.StringClickBuilder;
import com.obric.olog.OLog;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: AdServiceSettingsFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\tH\u0002J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/android/settings/AdServiceSettingsFragment;", "Lcom/android/settings/base/BaseFragment;", "()V", "viewBinding", "Lcom/android/settings/databinding/AdServiceSettingsLayoutBinding;", "initOaid", "", "initPushReceive", "isReceiveBusinessMessage", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setReceiveBusinessMessage", "enable", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AdServiceSettingsFragment extends BaseFragment {
    private AdServiceSettingsLayoutBinding viewBinding;

    /* JADX INFO: renamed from: $r8$lambda$46O-fX0-bMqyV0xO8NhD1SlVYdo, reason: not valid java name */
    public static /* synthetic */ void m74$r8$lambda$46OfX0bMqyV0xO8NhD1SlVYdo(AdServiceSettingsFragment r0, View r1) {
        initPushReceive$lambda$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$iI277dErD9K4QNNAmb59qNARsEg(AdServiceSettingsFragment r0, View r1) {
        initPushReceive$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$pMp6vThM3nnOw7Ux-iTE9-AsEdI, reason: not valid java name */
    public static /* synthetic */ void m75$r8$lambda$pMp6vThM3nnOw7UxiTE9AsEdI(AdServiceSettingsFragment r0, View r1) {
        initOaid$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$vXa-d88gixSrkaLHvRSnfWo1YK0, reason: not valid java name */
    public static /* synthetic */ void m76$r8$lambda$vXad88gixSrkaLHvRSnfWo1YK0(AdServiceSettingsFragment r0, CompoundButton r1, boolean r2) {
        initPushReceive$lambda$2$lambda$1(r0, r1, r2);
    }

    public void com_android_settings_AdServiceSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_AdServiceSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_AdServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_AdServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AdServiceSettingsFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        AdServiceSettingsLayoutBinding r4 = AdServiceSettingsLayoutBinding.inflate(r1, r2, false);
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
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        initOaid();
        initPushReceive();
    }

    private final void initOaid() {
        AdServiceSettingsLayoutBinding r0 = this.viewBinding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        r0.itemOaid.setOnContentClickListener(new AdServiceSettingsFragment$$ExternalSyntheticLambda3(this));
    }

    private static final void initOaid$lambda$0(AdServiceSettingsFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        BaseFragment.start$default(r2, OAIDSettingsFragment.class, null, 2, null);
    }

    private final void initPushReceive() {
        AdServiceSettingsLayoutBinding r0 = this.viewBinding;
        AdServiceSettingsLayoutBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        r0.itemPushReceive.setDefaultCustomEndView(1);
        AdServiceSettingsLayoutBinding r1 = this.viewBinding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L8:
        OSwitch r3 = r1.itemPushReceive.getEndSwitch();
        if ((r3 instanceof OSwitch) == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L14;
        r3.setChecked(isReceiveBusinessMessage());
        r3.setOnCheckedChangeListener(new AdServiceSettingsFragment$$ExternalSyntheticLambda0(this));
    L14:
        int r4 = getResources().getColor(R.color.oui_functional_blue_6);
        AdServiceSettingsLayoutBinding r5 = this.viewBinding;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L18:
        TextView r6 = (TextView) r2.showsPushReceive.findViewById(R.id.section_des);
        StringClickBuilder r7 = new StringClickBuilder(getString(R.string.push_business_receive_lawf), r6);
        r7.onClick(R.string.push_business_receive_lawf_app_updae, r4, new AdServiceSettingsFragment$$ExternalSyntheticLambda1(this));
        r7.onClick(R.string.push_business_receive_lawf_app_msg, r4, new AdServiceSettingsFragment$$ExternalSyntheticLambda2(this));
        r6.setText(r7.build());
        r6.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L17:
        r2 = r5;
        goto L18
    }

    private static final void initPushReceive$lambda$2$lambda$1(AdServiceSettingsFragment r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        r1.setReceiveBusinessMessage(r3);
    }

    private static final void initPushReceive$lambda$3(AdServiceSettingsFragment r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Utils.loadUrlWithExplorer(r1._mActivity, r1.getString(R.string.push_business_receive_lawf_app_updae_url));
    }

    private static final void initPushReceive$lambda$4(AdServiceSettingsFragment r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Utils.loadUrlWithExplorer(r1._mActivity, r1.getString(R.string.push_business_receive_lawf_app_msg_url));
    }

    private final boolean isReceiveBusinessMessage() {
        Activity r2 = this._mActivity;
        if (r2 == null) goto L5;
        ContentResolver r3 = r2.getContentResolver();
    L7:
        if (android.provider.Settings.System.getInt(r3, "receive_business_message", 0) <= 0) goto L10;
        return true;
    L10:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    private final void setReceiveBusinessMessage(boolean r2) {
        Activity r1 = this._mActivity;
        if (r1 == null) goto L5;
        ContentResolver r3 = r1.getContentResolver();
    L6:
        android.provider.Settings.System.putInt(r3, "receive_business_message", r2 ? 1 : 0);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_AdServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AdServiceSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AdServiceSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AdServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AdServiceSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_AdServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AdServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AdServiceSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_AdServiceSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
