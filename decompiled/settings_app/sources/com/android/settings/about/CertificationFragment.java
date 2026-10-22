package com.android.settings.about;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.databinding.ELabelLayoutBinding;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import settingssecureutils.SettingsSecureUtils;

/* JADX INFO: compiled from: CertificationFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/settings/about/CertificationFragment;", "Lcom/android/settings/base/BaseFragment;", "()V", "viewBinding", "Lcom/android/settings/databinding/ELabelLayoutBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CertificationFragment extends BaseFragment {
    private ELabelLayoutBinding viewBinding;

    public static /* synthetic */ void $r8$lambda$8t053EDThn26E56sCDaL0_aprCk(CertificationFragment r0, View r1) {
        onViewCreated$lambda$1(r0, r1);
    }

    public void com_android_settings_about_CertificationFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_about_CertificationFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_about_CertificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_about_CertificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public CertificationFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        ELabelLayoutBinding r4 = ELabelLayoutBinding.inflate(r1, r2, false);
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.viewBinding = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L5:
        ConstraintLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        return r0;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m1508constructorimpl(SettingsSecureUtils.getCertificationNum());     // Catch: Throwable -> L5
    L8:
        if (Result.m1514isFailureimpl(r12) == false) goto L10;
        r12 = "";
    L10:
        String r13 = (String) r12;
        ELabelLayoutBinding r14 = this.viewBinding;
        ELabelLayoutBinding r0 = null;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r14 = null;
    L13:
        r14.viewTitle.removeStartAction();
        ELabelLayoutBinding r15 = this.viewBinding;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r15 = null;
    L16:
        OFloatingTitleBar r2 = r15.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r2, "viewTitle");
        OFloatingTitleBar.addStartAction$default(r2, R.drawable.o_floating_title_bar_icon_back, 0, null, 6, null).setOnClickListener(new CertificationFragment$$ExternalSyntheticLambda0(this));
        ELabelLayoutBinding r16 = this.viewBinding;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r16 = null;
    L19:
        r16.cmiitId.setText("CMIIT ID: 26C311E0H632");
        ELabelLayoutBinding r17 = this.viewBinding;
        if (r17 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L22:
        r17.brand.setText(Build.MODEL);
        ELabelLayoutBinding r18 = this.viewBinding;
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r18 = null;
    L25:
        r18.cmmiitId2.setText(r13);
        ELabelLayoutBinding r8 = this.viewBinding;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L29:
        r0.descBand.setText(Build.MODEL);
        return;
    L28:
        r0 = r8;
    L5:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r12 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final void onViewCreated$lambda$1(CertificationFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L6;
        r2.onBackPressed();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_about_CertificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CertificationFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_about_CertificationFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_about_CertificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CertificationFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_about_CertificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_about_CertificationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CertificationFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_about_CertificationFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
