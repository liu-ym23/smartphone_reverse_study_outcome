package com.android.settings;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class EmergencyDashboardFragment extends BaseFragment {
    private static final String ACTION_EMERGENCY_GESTURE_SETTINGS = "com.android.settings.action.emergency_gesture_settings";
    private static String EMERGENCY_PKG = "com.google.android.apps.safetyhub";
    private static final String EXTRA_KEY_ATTRIBUTION = "attribution";
    Intent mIntent;

    static {
    }

    public void com_android_settings_EmergencyDashboardFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_EmergencyDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_EmergencyDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public EmergencyDashboardFragment() {
    }

    public void com_android_settings_EmergencyDashboardFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.fragment_emergency_dashboard, r3, false);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        initSafetyItem();
    }

    private void initSafetyItem() {
        String r0 = EMERGENCY_PKG;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        this.mIntent = new Intent("android.intent.action.MAIN").setPackage(r0);
        List<ResolveInfo> r1 = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 1048576);
        if (r1 != null) goto L8;
    L10:
        this.mIntent = null;
    L11:
        addSafetyItem();
        return;
    L8:
        if (r1.isEmpty() == true) goto L10;
        this.mIntent.setClassName(r0, r1.get(0).activityInfo.name);
        goto L11
    }

    private void addSafetyItem() {
        ViewGroup r0 = (ViewGroup) Objects.requireNonNull(getPageContainerView());
        OCardListItem r1 = new OCardListItem(this.mContext);
        r1.setAppIcon(getIcon());
        r1.showIcon(true);
        r1.setTitle(getButtonText());
        r1.setCardPosition(1);
        r1.showTailIcon(true);
        r1.setDefaultTailIcon(0);
        r1.setOnContentClickListener(new EmergencyDashboardFragment$$ExternalSyntheticLambda0(this));
        OCardListItem r4 = new OCardListItem(this.mContext);
        r4.setAppIcon(R.drawable.ic_emergency_gesture_24dp);
        r4.showIcon(true);
        r4.setTitle(this.mContext.getString(R.string.emergency_gesture_screen_title));
        r4.setCardPosition(3);
        r4.showTailIcon(true);
        r4.setDefaultTailIcon(0);
        r4.setOnContentClickListener(new EmergencyDashboardFragment$$ExternalSyntheticLambda1(this));
        r0.addView(r1, 0, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, -2);
        r2.bottomMargin = Utils.dp2Pixels(this.mContext, 16.0f);
        r0.addView(r4, 1, r2);
    }

    /* JADX INFO: renamed from: lambda$addSafetyItem$0$com-android-settings-EmergencyDashboardFragment, reason: not valid java name */
    /* synthetic */ void m132xf8970ae4(View r4) {
        Intent r5 = new Intent(this.mIntent).addCategory("android.intent.category.LAUNCHER").setFlags(335544320);
        Bundle r0 = new Bundle();
        r0.putString(EXTRA_KEY_ATTRIBUTION, this.mContext.getPackageName());
        this.mContext.startActivity(r5, r0);
    }

    /* JADX INFO: renamed from: lambda$addSafetyItem$1$com-android-settings-EmergencyDashboardFragment, reason: not valid java name */
    /* synthetic */ void m133xf820a4e5(View r2) {
        Intent r3 = new Intent(ACTION_EMERGENCY_GESTURE_SETTINGS).setPackage(EMERGENCY_PKG);
        if (canResolveIntent(r3) == false) goto L5;
        this.mContext.startActivity(r3);
        return;
    L5:
        ToastUtils.show(this.mContext, R.string.activity_not_found);
    }

    private boolean canResolveIntent(Intent r2) {
        if (this.mContext.getPackageManager().resolveActivity(r2, 0) == null) goto L6;
        return true;
    L6:
        return false;
    }

    private CharSequence getButtonText() {
        PackageManager r0 = this.mContext.getPackageManager();     // Catch: Exception -> L4
        ApplicationInfo r1 = r0.getApplicationInfo(EMERGENCY_PKG, 33280);     // Catch: Exception -> L4
        return this.mContext.getString(R.string.open_app_button, new Object[]{r1.loadLabel(r0)});
    L4:
        OLog.e(this.TAG, "Failed to get open app button text, falling back.");
        return "";
    }

    private Drawable getIcon() {
        ApplicationInfo r0 = this.mContext.getPackageManager().getApplicationInfo(EMERGENCY_PKG, 33280);     // Catch: Exception -> L4
        return Utils.getBadgedIcon(this.mContext, r0);
    L4:
        e = move-exception;
        OLog.d(this.TAG, "Failed to get open app button icon", e);
        return null;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_EmergencyDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(EmergencyDashboardFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_EmergencyDashboardFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_EmergencyDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(EmergencyDashboardFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_EmergencyDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_EmergencyDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(EmergencyDashboardFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_EmergencyDashboardFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
