package com.android.settings;

import android.app.LauncherActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class CreateShortcut extends LauncherActivity {
    public void com_android_settings_CreateShortcut__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_CreateShortcut__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_CreateShortcut__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_CreateShortcut__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_CreateShortcut__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.LauncherActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_CreateShortcut_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    protected boolean onEvaluateShowIcons() {
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        com_android_settings_CreateShortcut_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        com_android_settings_CreateShortcut_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_settings_CreateShortcut_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_CreateShortcut_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public CreateShortcut() {
    }

    @Override // android.app.LauncherActivity
    protected Intent getTargetIntent() {
        Intent r2 = new Intent("android.intent.action.MAIN", null);
        r2.addCategory("com.android.settings.SHORTCUT");
        r2.addFlags(268435456);
        return r2;
    }

    @Override // android.app.LauncherActivity, android.app.ListActivity
    protected void onListItemClick(ListView r1, View r2, int r3, long r4) {
        Intent r5 = (Intent) NullSafe.nonNull(intentForPosition(r3));
        r5.setFlags(2097152);
        Intent r6 = new Intent();
        r6.putExtra("android.intent.extra.shortcut.INTENT", r5);
        r6.putExtra("android.intent.extra.shortcut.NAME", itemForPosition(r3).label);
        ActivityInfo r7 = itemForPosition(r3).resolveInfo.activityInfo;
        if (r7.icon == 0) goto L5;
        r6.putExtra("android.intent.extra.shortcut.ICON", createIcon(r7.icon));
    L5:
        setResult(-1, r6);
        finish();
    }

    private Bitmap createIcon(int r5) {
        View r4 = LayoutInflater.from(new ContextThemeWrapper(this, android.R.style.Theme.Material)).inflate(R.layout.shortcut_badge, null);
        ((ImageView) r4.findViewById(android.R.id.icon)).setImageResource(r5);
        int r0 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r4.measure(r0, r0);
        Bitmap r1 = Bitmap.createBitmap(r4.getMeasuredWidth(), r4.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r1);
        r4.layout(0, 0, r4.getMeasuredWidth(), r4.getMeasuredHeight());
        r4.draw(r2);
        return r1;
    }

    @Override // android.app.LauncherActivity
    protected List<ResolveInfo> onQueryPackageManager(Intent r3) {
        List<ResolveInfo> r4 = getPackageManager().queryIntentActivities(r3, 128);
        ConnectivityManager r2 = (ConnectivityManager) getSystemService("connectivity");
        if (r4 != null) goto L6;
        return null;
    L6:
        int r5 = r4.size() - 1;
    L7:
        if (r5 < 0) goto L9;
        ResolveInfo r0 = r4.get(r5);
        r5 = r5 - 1;
        goto L7
    L9:
        return r4;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_CreateShortcut_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CreateShortcut r1) {
        r1.com_android_settings_CreateShortcut__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_CreateShortcut_com_obric_hook_lancet_BatchedActivityLancet_onResume(CreateShortcut r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_CreateShortcut_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_CreateShortcut_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(CreateShortcut r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_CreateShortcut__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        CreateShortcut r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_CreateShortcut_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(CreateShortcut r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_CreateShortcut__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_CreateShortcut_com_obric_hook_lancet_BatchedActivityLancet_onStop(CreateShortcut r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_CreateShortcut_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_CreateShortcut_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(CreateShortcut r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_CreateShortcut__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_CreateShortcut_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(CreateShortcut r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_CreateShortcut__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        CreateShortcut r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }
}
