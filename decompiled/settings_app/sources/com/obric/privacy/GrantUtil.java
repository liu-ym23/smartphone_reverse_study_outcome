package com.obric.privacy;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import com.android.settings.BandMode;
import com.android.settings.ConfirmDeviceCredentialActivityNew;
import com.android.settings.ConfirmLockPassword;
import com.android.settings.ConfirmLockPattern;
import com.android.settings.MultiSimSelectSubscription;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;
import com.android.settings.RadioInfo;
import com.android.settings.SettingsApplication;
import com.android.settings.SimPinSettingsActivity;
import com.android.settings.devicecredential.ConfirmDeviceCredentialActivity;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.privacy.OPrivacySheet;
import com.obric.oui.privacy.OPrivacySheetConfig;
import com.obric.oui.privacy.PrivacyItem;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GrantUtil.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u0018J\b\u0010!\u001a\u00020\u0018H\u0002J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010$\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0004J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010'\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0018H\u0002J\u001c\u0010,\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007J\"\u0010/\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010.H\u0002JE\u00103\u001a\b\u0012\u0004\u0012\u00020\u0016042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000407ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"Lcom/obric/privacy/GrantUtil;", "", "()V", "TAG", "", "URL_PRIVACY_POLICY", "applicationInitCallback", "Ljava/lang/Runnable;", "getApplicationInitCallback", "()Ljava/lang/Runnable;", "setApplicationInitCallback", "(Ljava/lang/Runnable;)V", "callback", "getCallback", "setCallback", "hasAgreed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mActToDialog", "", "", "Lcom/obric/oui/privacy/OPrivacySheet;", "applicationInit", "", "getResult", "", "context", "Landroid/content/Context;", "isActivityWhiteList", "activity", "Landroid/app/Activity;", "isHookAllowed", "isLaunchModeStandard", "isPrivacyAllowed", "isSettingsProcess", "isSetupCompelete", "launchMode", "openBrowser", "url", "recreateActivity", "requestGrant", "grantListener", "Lcom/obric/privacy/IGrantListener;", "setResult", "result", "startActivity", "savedInstanceState", "Landroid/os/Bundle;", "startActivitySafely", "intent", "Landroid/content/Intent;", "options", "textToOpenBrowser", "Lkotlin/Result;", "linkText", "linkTexts", "", "urls", "textToOpenBrowser-BWLJW6A", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Ljava/lang/Object;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GrantUtil {
    public static final GrantUtil INSTANCE = null;
    private static final String TAG = null;
    public static final String URL_PRIVACY_POLICY = "https://os.oceancloudapi.com/agreement/settings_privacy";
    private static Runnable applicationInitCallback;
    private static Runnable callback;
    private static final AtomicBoolean hasAgreed = null;
    private static final Map<Integer, OPrivacySheet> mActToDialog = null;

    @JvmStatic
    public static final void startActivity(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        startActivity$default(r2, null, 2, null);
    }

    private GrantUtil() {
    }

    public static final /* synthetic */ AtomicBoolean access$getHasAgreed$p() {
        return hasAgreed;
    }

    public static final /* synthetic */ Map access$getMActToDialog$p() {
        return mActToDialog;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static final /* synthetic */ void access$setResult(GrantUtil r0, Context r1, boolean r2) {
        r0.setResult(r1, r2);
    }

    static {
        INSTANCE = new GrantUtil();
        TAG = "GrantUtil";
        mActToDialog = new LinkedHashMap();
        hasAgreed = new AtomicBoolean(false);
    }

    public final Runnable getCallback() {
        return callback;
    }

    public final void setCallback(Runnable r1) {
        callback = r1;
    }

    public final Runnable getApplicationInitCallback() {
        return applicationInitCallback;
    }

    public final void setApplicationInitCallback(Runnable r1) {
        applicationInitCallback = r1;
    }

    public final void applicationInit() {
        if (INSTANCE.isPrivacyAllowed() == false) goto L9;
        Runnable r0 = applicationInitCallback;
        if (r0 == null) goto L7;
        r0.run();
    L7:
        applicationInitCallback = null;
        return;
    }

    public final void requestGrant(final Activity r23, final IGrantListener r24) {
        Intrinsics.checkNotNullParameter(r23, "activity");
        Intrinsics.checkNotNullParameter(r24, "grantListener");
        String r0 = TAG;
        OLog.e(r0, "requestGrant");
        if (isPrivacyAllowed() == false) goto L6;
        r24.agreeGrant();
        r23.finish();
        OLog.e(r0, "requestGrant:isPrivacyAllowed");
        return;
    L6:
        Map<Integer, OPrivacySheet> r7 = mActToDialog;
        if (r7.get(Integer.valueOf(r23.hashCode())) == null) goto L10;
        OLog.e(r0, "requestGrant:privacyDialog show");
        return;
    L10:
        String r10 = r23.getString(R.string.settings_label);
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");
        Resources r1 = r23.getResources();
        String[] r2 = r1.getStringArray(R.array.boot_privacy_dialog_permissions);
        Intrinsics.checkNotNullExpressionValue(r2, "getStringArray(...)");
        final String[] r5 = r1.getStringArray(R.array.boot_privacy_dialog_link_urls);
        Intrinsics.checkNotNullExpressionValue(r5, "getStringArray(...)");
        final String[] r15 = r1.getStringArray(R.array.boot_privacy_dialog_link);
        Intrinsics.checkNotNullExpressionValue(r15, "getStringArray(...)");
        String r13 = r1.getString(R.string.boot_privacy_dialog_text);
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        String r8 = r23.getString(R.string.boot_privacy_dialog_des);
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
        List r12 = CollectionsKt.listOf(new PrivacyItem.PermissionItem(r8, ArraysKt.toList(r2)));
        OPrivacySheetConfig r3 = new OPrivacySheetConfig(r23.getPackageName(), r10, r1.getString(R.string.boot_privacy_dialog_subtitle), r12, r13, ArraysKt.toList(r15), null, null, true, false, false, 1728, null);
        final OPrivacySheet r9 = new OPrivacySheet(r23, r3);
        r9.setListener(new AnonymousClass1(r23, r9, r24, r15, r5));
        r9.show();
        r7.put(Integer.valueOf(r23.hashCode()), r9);
    }

    private final void setResult(Context r3, boolean r4) {
        PreferenceMgr r2 = PreferenceMgr.getInstance(r3);
        OLog.d(TAG, "setResult privacy_has_allowed = " + r4);
        r2.putBoolean(PreferenceMgr.SETTINGS_PREFERENCES_PRIVACY_ALLOWED, r4);
        if (r4 == false) goto L6;
        mActToDialog.clear();
        return;
    }

    private final boolean getResult(Context r3) {
        boolean r2 = PreferenceMgr.getInstance(r3).getBoolean(PreferenceMgr.SETTINGS_PREFERENCES_PRIVACY_ALLOWED, false);
        OLog.d(TAG, "getResult privacy_has_allowed = " + r2);
        return r2;
    }

    public final boolean isSetupCompelete(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Settings.Secure.getInt(r2.getContentResolver(), "user_setup_complete", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private final boolean isSettingsProcess() {
        int r0 = Process.myPid();     // Catch: Exception -> L10
        Object r1 = SettingsApplication.getApplication().getSystemService("activity");     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L10
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = ((ActivityManager) r1).getRunningAppProcesses().iterator();     // Catch: Exception -> L10
    L5:
        if (r2.hasNext() == false) goto L12;
        ActivityManager.RunningAppProcessInfo r3 = r2.next();     // Catch: Exception -> L10
        if (r3.pid != r0) goto L5;
        String r4 = r3.processName;     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r4, "processName");     // Catch: Exception -> L10
        return StringsKt.startsWith$default(r4, "com.android.settings", false, 2, null);
    L12:
        return false;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public final boolean isPrivacyAllowed() {
        Application r0 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r0, "getApplication(...)");
        return getResult(r0);
    }

    private final boolean isActivityWhiteList(Activity r3) {
        if ((r3 instanceof RadioInfo) == false) goto L5;
    L24:
        return true;
    L5:
        if ((r3 instanceof BandMode) == true) goto L24;
        if ((r3 instanceof SimPinSettingsActivity) == true) goto L24;
        if ((r3 instanceof MultiSimSelectSubscription) == true) goto L24;
        if ((r3 instanceof ConfirmDeviceCredentialActivity) == true) goto L24;
        if ((r3 instanceof ConfirmDeviceCredentialActivityNew) == true) goto L24;
        if ((r3 instanceof ConfirmLockPattern) == true) goto L24;
        if ((r3 instanceof ConfirmLockPassword) == true) goto L24;
        if (isSetupCompelete(r3) == true) goto L22;
        return true;
    L22:
        return false;
    }

    public final boolean isHookAllowed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (isActivityWhiteList(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (isPrivacyAllowed() == true) goto L7;
        return true;
    }

    public static /* synthetic */ void startActivity$default(Activity r0, Bundle r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = null;
    L5:
        startActivity(r0, r1);
    }

    @JvmStatic
    public static final void startActivity(Activity r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intent r0 = r6.getIntent();
        Intrinsics.checkNotNullExpressionValue(r0, "getIntent(...)");
        GrantUtil r1 = INSTANCE;
        boolean r2 = r1.isLaunchModeStandard(r6);
        OLog.d(TAG, "startActivity:" + r0 + " LaunchMode:" + r2);
        if (r2 == true) goto L6;
        r0.addFlags(16777216);
    L6:
        if ((r6 instanceof com.android.settings.Settings) == false) goto L11;
        Intent r8 = new Intent(r6, com.android.settings.Settings.class);
        if (r2 == true) goto L10;
        r8.addFlags(16777216);
    L10:
        r8.addFlags(268533760);
        boolean r9 = r1.startActivitySafely(r6, r8, null);
    L12:
        if (r9 == false) goto L14;
        r6.finish();
        return;
    L14:
        r1.recreateActivity(r6);
        return;
    L11:
        r0.addFlags(268533760);
        r9 = r1.startActivitySafely(r6, r0, r7);
        goto L12
    }

    private final boolean recreateActivity(Activity r5) {
        if (r5.isFinishing() == false) goto L5;
        return false;
    L5:
        if (r5.isDestroyed() == true) goto L16;
        r5.recreate();     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        OLog.e(TAG, "recreate after privacy grant failed, activity=" + r5, e);
        return false;
    L16:
        return false;
    }

    private final boolean startActivitySafely(Activity r2, Intent r3, Bundle r4) {
        if (r4 != null) goto L4;
        r2.startActivity(r3);     // Catch: Exception -> L6
    L5:
        return true;
    L4:
        r2.startActivity(r3, r4);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        OLog.e(TAG, "startActivity after privacy grant failed, intent=" + r3, e);
        return false;
    }

    /* JADX INFO: renamed from: textToOpenBrowser-BWLJW6A, reason: not valid java name */
    public final Object m1466textToOpenBrowserBWLJW6A(final Activity r5, String r6, List<String> r7, List<String> r8) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, "linkText");
        Intrinsics.checkNotNullParameter(r7, "linkTexts");
        Intrinsics.checkNotNullParameter(r8, "urls");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        GrantUtil r2 = this;     // Catch: Throwable -> L9
        final String r9 = r8.get(r7.indexOf(r6));     // Catch: Throwable -> L9
        if (hasAgreed.get() == true) goto L6;
        OAlertDialogBuilder r10 = OAlertDialogBuilder.title$default(new OAlertDialogBuilder(r5).autoDismiss(false), r5.getString(R.string.privacy_permisssion_dialog_title), false, 2, null).message(r5.getString(R.string.privacy_permisssion_dialog_message));     // Catch: Throwable -> L9
        String r11 = r5.getString(R.string.oui_agree);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");     // Catch: Throwable -> L9
        OAlertDialogBuilder r4 = r10.positiveButton(r11, new GrantUtil$textToOpenBrowser$1$1(this, r5, r9));     // Catch: Throwable -> L9
        String r12 = r5.getString(R.string.oui_cancel_only);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");     // Catch: Throwable -> L9
        r4.negativeButton(r12, GrantUtil$textToOpenBrowser$1$2.INSTANCE).build().show();     // Catch: Throwable -> L9
    L7:
        return Result.m1508constructorimpl(Unit.INSTANCE);
    L6:
        openBrowser(r5, r9);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(th));
    }

    public final void openBrowser(Activity r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intent r2 = new Intent("android.intent.action.VIEW");
        r2.setPackage("com.obric.browser");
        r2.putExtra("create_new_tab", true);
        r2.putExtra("support_dark_mode", true);
        r2.addCategory("android.intent.category.BROWSABLE");
        r2.setData(Uri.parse(r4));
        r2.addFlags(268435456);
        r3.startActivity(r2);
    }

    public final int launchMode(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        GrantUtil r1 = this;     // Catch: Throwable -> L5
        Intent r3 = r2.getIntent();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r3, "getIntent(...)");     // Catch: Throwable -> L5
        PackageManager r4 = r2.getPackageManager();     // Catch: Throwable -> L5
        ComponentName r5 = r3.getComponent();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L5
        ActivityInfo r6 = r4.getActivityInfo(r5, 128);     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r6, "getActivityInfo(...)");     // Catch: Throwable -> L5
        Object r7 = Result.m1508constructorimpl(Integer.valueOf(r6.launchMode));     // Catch: Throwable -> L5
    L8:
        if (Result.m1515isSuccessimpl(r7) == true) goto L10;
        return 0;
    L10:
        if (Result.m1514isFailureimpl(r7) == false) goto L12;
        r7 = null;
    L12:
        Intrinsics.checkNotNull(r7);
        return ((Number) r7).intValue();
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final boolean isLaunchModeStandard(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (launchMode(r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
