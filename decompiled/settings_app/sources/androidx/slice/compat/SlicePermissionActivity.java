package androidx.slice.compat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.text.BidiFormatter;
import androidx.slice.core.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class SlicePermissionActivity extends Activity implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
    private static final float MAX_LABEL_SIZE_PX = 500.0f;
    private static final String TAG = "SlicePermissionActivity";
    private String mCallingPkg;
    private AlertDialog mDialog;
    private String mProviderPkg;
    private Uri mUri;

    public void androidx_slice_compat_SlicePermissionActivity__onPause$___twin___() {
        super.onPause();
    }

    public void androidx_slice_compat_SlicePermissionActivity__onResume$___twin___() {
        super.onResume();
    }

    public void androidx_slice_compat_SlicePermissionActivity__onStop$___twin___() {
        super.onStop();
    }

    public void androidx_slice_compat_SlicePermissionActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r1) {
        androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // android.app.Activity
    public void onPause() {
        androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public SlicePermissionActivity() {
    }

    public void androidx_slice_compat_SlicePermissionActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        this.mUri = (Uri) getIntent().getParcelableExtra("slice_uri");
        this.mCallingPkg = getIntent().getStringExtra("pkg");
        this.mProviderPkg = getIntent().getStringExtra(SliceProviderCompat.EXTRA_PROVIDER_PKG);
        PackageManager r7 = getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L5
        String r0 = BidiFormatter.getInstance().unicodeWrap(loadSafeLabel(r7, r7.getApplicationInfo(this.mCallingPkg, 0)).toString());     // Catch: PackageManager.NameNotFoundException -> L5
        String r8 = BidiFormatter.getInstance().unicodeWrap(loadSafeLabel(r7, r7.getApplicationInfo(this.mProviderPkg, 0)).toString());     // Catch: PackageManager.NameNotFoundException -> L5
        AlertDialog r1 = new AlertDialog.Builder(this).setTitle(getString(R.string.abc_slice_permission_title, new Object[]{r0, r8})).setView(R.layout.abc_slice_permission_request).setNegativeButton(R.string.abc_slice_permission_deny, this).setPositiveButton(R.string.abc_slice_permission_allow, this).setOnDismissListener(this).show();     // Catch: PackageManager.NameNotFoundException -> L5
        this.mDialog = r1;     // Catch: PackageManager.NameNotFoundException -> L5
        ((TextView) r1.getWindow().getDecorView().findViewById(R.id.text1)).setText(getString(R.string.abc_slice_permission_text_1, new Object[]{r8}));     // Catch: PackageManager.NameNotFoundException -> L5
        ((TextView) this.mDialog.getWindow().getDecorView().findViewById(R.id.text2)).setText(getString(R.string.abc_slice_permission_text_2, new Object[]{r8}));     // Catch: PackageManager.NameNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Couldn't find package", e);
        finish();
    }

    private CharSequence loadSafeLabel(PackageManager r6, ApplicationInfo r7) {
        String r5 = Html.fromHtml(r7.loadLabel(r6).toString()).toString();
        int r8 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L16;
        int r2 = r5.codePointAt(r1);
        int r3 = Character.getType(r2);
        if (r3 == 13) goto L15;
        if (r3 == 15) goto L15;
        if (r3 == 14) goto L15;
        if (r3 != 12) goto L14;
        r5 = r5.substring(0, r1) + HanziToPinyin.Token.SEPARATOR + r5.substring(Character.charCount(r2) + r1);
    L14:
        r1 = r1 + Character.charCount(r2);
    L15:
        r5 = r5.substring(0, r1);
    L16:
        String r9 = r5.trim();
        if (r9.isEmpty() == true) goto L19;
        TextPaint r10 = new TextPaint();
        r10.setTextSize(42.0f);
        return TextUtils.ellipsize(r9, r10, MAX_LABEL_SIZE_PX, TextUtils.TruncateAt.END);
    L19:
        return r7.packageName;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r3, int r4) {
        if (r4 != (-1)) goto L5;
        SliceProviderCompat.grantSlicePermission(this, getPackageName(), this.mCallingPkg, this.mUri.buildUpon().path("").build());
    L5:
        finish();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mDialog.cancel();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void androidx_slice_compat_SlicePermissionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SlicePermissionActivity r1) {
        r1.androidx_slice_compat_SlicePermissionActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(SlicePermissionActivity r1) {
        String r0 = r1.getClass().getName();
        androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SlicePermissionActivity r4) {
        String r0 = r4.getClass().getName();
        r4.androidx_slice_compat_SlicePermissionActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SlicePermissionActivity r5 = r4;
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
    public static void androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SlicePermissionActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.androidx_slice_compat_SlicePermissionActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(SlicePermissionActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        androidx_slice_compat_SlicePermissionActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SlicePermissionActivity r4) {
        String r0 = r4.getClass().getName();
        r4.androidx_slice_compat_SlicePermissionActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void androidx_slice_compat_SlicePermissionActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SlicePermissionActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.androidx_slice_compat_SlicePermissionActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SlicePermissionActivity r5 = r3;
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
