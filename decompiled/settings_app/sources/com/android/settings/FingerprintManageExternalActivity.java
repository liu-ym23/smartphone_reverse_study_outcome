package com.android.settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.view.Window;
import com.android.settings.applications.utils.ODialogUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.view.WindowManagerHelper;

/* JADX INFO: compiled from: FingerprintManageExternalActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u0006\u0010\u0017\u001a\u00020\u0010J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/settings/FingerprintManageExternalActivity;", "Lcom/obric/privacy/LifeHookActivity2;", "()V", "mChooseLockTypeDialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "mIsChooseLockTypeDialogShowing", "", "mSetupLockscreenDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "getLockTypeSelectionOnclickListener", "Landroid/view/View$OnClickListener;", "quality", "", "pinLength", "isSecure", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSaveInstanceState", "outState", "showChooseLockMenuDialog", "showSetupLockscreenDialog", "startChooseLockTypeActivity", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FingerprintManageExternalActivity extends LifeHookActivity2 {
    public static final Companion Companion = null;
    public static final String DIALOG_MESSAGE = "dialog_message";
    public static final String FROM = "from";
    public static final String FROM_DEFAULT = "from_default";
    public static final String FROM_DOUBAO_ASSISTANT_MENU_FINGERPRINT = "from_doubao_assistant_menu_fingerprint";
    public static final String FROM_ENROLL_FINGERPRINT_DATA = "from_enroll_fingerprint_data";
    public static final String FROM_NOTIFICATION = "from_notification";
    private static final String KEY_CHOOSE_LOCK_TYPE_DIALOG_SHOWING = "is_choose_lock_type_dialog_showing";
    private OActionDialog mChooseLockTypeDialog;
    private boolean mIsChooseLockTypeDialogShowing;
    private OAlertDialog mSetupLockscreenDialog;

    /* JADX INFO: compiled from: FingerprintManageExternalActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/settings/FingerprintManageExternalActivity$Companion;", "", "()V", "DIALOG_MESSAGE", "", "FROM", "FROM_DEFAULT", "FROM_DOUBAO_ASSISTANT_MENU_FINGERPRINT", "FROM_ENROLL_FINGERPRINT_DATA", "FROM_NOTIFICATION", "KEY_CHOOSE_LOCK_TYPE_DIALOG_SHOWING", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$2CR1zlTSFxxlh1oneWPMR20DEdQ(FingerprintManageExternalActivity r0, DialogInterface r1) {
        showSetupLockscreenDialog$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$9LxXh7wgvfm54mA2yZyFu-BSOgY, reason: not valid java name */
    public static /* synthetic */ void m140$r8$lambda$9LxXh7wgvfm54mA2yZyFuBSOgY(FingerprintManageExternalActivity r0, View r1) {
        showChooseLockMenuDialog$lambda$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JTEj4M6S0eoQxVMnb1nAjB93tPA(DialogInterface r0) {
        onDestroy$lambda$13(r0);
    }

    public static /* synthetic */ void $r8$lambda$LBPkm84syXISY8cO1kqkOAZAChU(FingerprintManageExternalActivity r0, DialogInterface r1) {
        showChooseLockMenuDialog$lambda$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$TkHomyCIbr-F5g6YcY-tqx2Qox8, reason: not valid java name */
    public static /* synthetic */ void m141$r8$lambda$TkHomyCIbrF5g6YcYtqx2Qox8(DialogInterface r0) {
        onDestroy$lambda$12(r0);
    }

    public static /* synthetic */ void $r8$lambda$a0DH1R3yFp__jjSETF3Q28ifD_E(FingerprintManageExternalActivity r0, int r1, int r2, View r3) {
        getLockTypeSelectionOnclickListener$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$dSsDL6GVB3wKsqodz5TWJbwcoqw(FingerprintManageExternalActivity r0, View r1) {
        showChooseLockMenuDialog$lambda$5(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    private static final void onDestroy$lambda$12(DialogInterface r0) {
    }

    private static final void onDestroy$lambda$13(DialogInterface r0) {
    }

    public void com_android_settings_FingerprintManageExternalActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_FingerprintManageExternalActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_FingerprintManageExternalActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_FingerprintManageExternalActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public FingerprintManageExternalActivity() {
    }

    public static final /* synthetic */ void access$showChooseLockMenuDialog(FingerprintManageExternalActivity r0) {
        r0.showChooseLockMenuDialog();
    }

    public void com_android_settings_FingerprintManageExternalActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        String r0 = getTAG();
        StringBuilder r1 = new StringBuilder("onCreate, from: ");
        Bundle r2 = getIntent().getExtras();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getString("from");
    L6:
        StringBuilder r5 = r1.append(r4).append(", dialog_message: ");
        Bundle r7 = getIntent().getExtras();
        if (r7 == null) goto L9;
        r3 = r7.getString(DIALOG_MESSAGE);
    L9:
        OLog.i(r0, r5.append(r3).toString());
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        if (isSecure() == false) goto L12;
    L20:
        FingerprintManageExternalActivity r8 = this;
        Utils.startActivity(r8, new Intent(r8, Settings.FingerprintManageActivity.class), 0);
        finish();
        return;
    L12:
        if (Utils.isFingerprintExists(this) == true) goto L20;
        if (r6 == null) goto L17;
        this.mIsChooseLockTypeDialogShowing = r6.getBoolean(KEY_CHOOSE_LOCK_TYPE_DIALOG_SHOWING, false);
    L17:
        if (this.mIsChooseLockTypeDialogShowing == false) goto L19;
        showChooseLockMenuDialog();
        return;
    L19:
        showSetupLockscreenDialog();
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final boolean isSecure() {
        return new ChooseLockSettingsHelper(this).utils().isSecure(UserHandle.myUserId());
    }

    public final void showSetupLockscreenDialog() {
        OAlertDialog r0 = this.mSetupLockscreenDialog;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        OAlertDialog r2 = this.mSetupLockscreenDialog;
        if (r2 == null) goto L12;
        r2.dismiss();
    L12:
        Bundle r3 = getIntent().getExtras();
        if (r3 == null) goto L16;
        String r4 = r3.getString("from");
        if (r4 == null) goto L16;
    L17:
        int r5 = r4.hashCode();
        if (r5 == (-608740535)) goto L33;
        if (r5 == (-254288119)) goto L29;
        if (r5 == 1582243680) goto L25;
    L34:
        Bundle r6 = getIntent().getExtras();
        if (r6 == null) goto L46;
        String r7 = r6.getString(DIALOG_MESSAGE);
        if (r7 == null) goto L46;
        if (r7.length() <= 0) goto L41;
        boolean r8 = true;
    L42:
        if (r8 == true) goto L45;
        r7 = null;
    L45:
        if (r7 == null) goto L46;
    L48:
        Intrinsics.checkNotNull(r7);
        OAlertDialog r9 = (OAlertDialog) OAlertDialogBuilder.horizontalButton$default(new OAlertDialogBuilder(this).autoDismiss(false), false, 1, null).title(R.string.setup_lockscreen_title).message(r7).positiveButton(R.string.setup_lockscreen_ok_button, new FingerprintManageExternalActivity$showSetupLockscreenDialog$dialog$1(this)).negativeButton(R.string.cancel, FingerprintManageExternalActivity$showSetupLockscreenDialog$dialog$2.INSTANCE).onDismiss(new FingerprintManageExternalActivity$$ExternalSyntheticLambda4(this)).cancelable(false).build();
        this.mSetupLockscreenDialog = r9;
        if (r9.getWindow() == null) goto L53;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L53;
        r10.setType(WindowManagerHelper.LayoutParamsSmt.TYPE_APPLICATION_OVERLAY);
    L53:
        r9.show();
        return;
    L41:
        r8 = false;
    L46:
        r7 = getString(R.string.setup_lockscreen_message_when_from_notification);
        goto L48
    L25:
        if (r4.equals(FROM_NOTIFICATION) == false) goto L34;
        r7 = getString(R.string.setup_lockscreen_message_when_from_notification);
        goto L48
    L29:
        if (r4.equals(FROM_ENROLL_FINGERPRINT_DATA) == false) goto L34;
        r7 = getString(R.string.setup_lockscreen_message);
        goto L48
    L33:
        if (r4.equals(FROM_DOUBAO_ASSISTANT_MENU_FINGERPRINT) == false) goto L34;
        r7 = getString(R.string.setup_lockscreen_message_when_click_ai_key_fingerprint_management);
    L16:
        r4 = FROM_DEFAULT;
        goto L17
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L8
    }

    private static final void showSetupLockscreenDialog$lambda$1(FingerprintManageExternalActivity r2, DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.mSetupLockscreenDialog = null;
        OActionDialog r4 = r2.mChooseLockTypeDialog;
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == true) goto L10;
        r2.finish();
        return;
    L10:
        return;
    L5:
        if (r4.isShowing() != true) goto L7;
        r0 = true;
        goto L7
    }

    private final void showChooseLockMenuDialog() {
        OActionDialog r0 = this.mChooseLockTypeDialog;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        OActionDialog r2 = this.mChooseLockTypeDialog;
        if (r2 == null) goto L12;
        r2.dismiss();
    L12:
        List<String> r10 = CollectionsKt.mutableListOf(new String[]{getString(R.string.lockscreen_mode_item_title_pattern), getString(R.string.lockscreen_mode_pin_four), getString(R.string.lockscreen_mode_pin_six), getString(R.string.lockscreen_mode_item_title_hard)});
        List<? extends View.OnClickListener> r11 = CollectionsKt.mutableListOf(new View.OnClickListener[]{getLockTypeSelectionOnclickListener$default(this, 65536, 0, 2, null), getLockTypeSelectionOnclickListener(131072, 4), getLockTypeSelectionOnclickListener(131072, 6), getLockTypeSelectionOnclickListener$default(this, 262144, 0, 2, null), new FingerprintManageExternalActivity$$ExternalSyntheticLambda0(this)});
        String r9 = getString(R.string.choose_lock_type_title);
        Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
        OActionDialog r3 = ODialogUtils.INSTANCE.showActionDialog(this, r9, r10, r11, new FingerprintManageExternalActivity$$ExternalSyntheticLambda1(this));
        this.mChooseLockTypeDialog = r3;
        this.mIsChooseLockTypeDialogShowing = true;
        if (r3 == null) goto L16;
        r3.setOnDismissListener(new FingerprintManageExternalActivity$$ExternalSyntheticLambda2(this));
        return;
    L16:
        return;
    L5:
        if (r0.isShowing() != true) goto L7;
        r1 = true;
        goto L8
    }

    private static final void showChooseLockMenuDialog$lambda$3(FingerprintManageExternalActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.mIsChooseLockTypeDialogShowing = false;
        OActionDialog r2 = r0.mChooseLockTypeDialog;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isShowing() == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L12;
        r2.dismiss();
        return;
    }

    private static final void showChooseLockMenuDialog$lambda$5(FingerprintManageExternalActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OActionDialog r2 = r0.mChooseLockTypeDialog;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isShowing() == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L12;
        r2.dismiss();
        return;
    }

    private static final void showChooseLockMenuDialog$lambda$6(FingerprintManageExternalActivity r0, DialogInterface r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.mChooseLockTypeDialog = null;
        r0.finish();
    }

    static /* synthetic */ View.OnClickListener getLockTypeSelectionOnclickListener$default(FingerprintManageExternalActivity r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 4;
    L6:
        return r0.getLockTypeSelectionOnclickListener(r1, r2);
    }

    private final View.OnClickListener getLockTypeSelectionOnclickListener(final int r2, final int r3) {
        return new FingerprintManageExternalActivity$$ExternalSyntheticLambda3(this, r2, r3);
    }

    private static final void getLockTypeSelectionOnclickListener$lambda$8(FingerprintManageExternalActivity r0, int r1, int r2, View r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.startChooseLockTypeActivity(r1, r2);
        OActionDialog r4 = r0.mChooseLockTypeDialog;
        if (r4 != null) goto L5;
    L10:
        r0.mIsChooseLockTypeDialogShowing = false;
        return;
    L5:
        if (r4.isShowing() == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L10;
        r4.dismiss();
        goto L10
    }

    private final void startChooseLockTypeActivity(int r4, int r5) {
        if (r4 < 131072) goto L6;
        Intent r0 = new Intent(this, ChooseLockPassword.class);
        r0.putExtra("lockscreen.password_type", r4);
        r0.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, 4);
        r0.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r5);
    L9:
        r0.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        OLog.i(getTAG(), "startChooseLockTypeActivity challenge 0");
        r0.putExtra("challenge", 0);
        r0.putExtra("for_fingerprint", true);
        r0.putExtra("alert_type", 0);
        r0.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, false);
        r0.putExtra(TrustedNetworkHelper.EXTRA_REQUEST_RESULT, true);
        Utils.startActivity(this, r0, 2, 200);
        return;
    L6:
        if (r4 != 65536) goto L8;
        r0 = new Intent(this, ChooseLockPattern.class);
        r0.putExtra("pattern_size", 3);
        r0.putExtra("key_lock_method", "pattern");
        goto L9
    L8:
        r0 = new Intent();
        goto L9
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super.onSaveInstanceState(r2);
        r2.putBoolean(KEY_CHOOSE_LOCK_TYPE_DIALOG_SHOWING, this.mIsChooseLockTypeDialogShowing);
    }

    public void com_android_settings_FingerprintManageExternalActivity__onDestroy$___twin___() {
        super.onDestroy();
        OAlertDialog r0 = this.mSetupLockscreenDialog;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L15;
        OAlertDialog r3 = this.mSetupLockscreenDialog;
        if (r3 == null) goto L12;
        r3.setOnDismissListener(new FingerprintManageExternalActivity$$ExternalSyntheticLambda5());
    L12:
        OAlertDialog r4 = this.mSetupLockscreenDialog;
        if (r4 == null) goto L15;
        r4.dismiss();
    L15:
        OActionDialog r5 = this.mChooseLockTypeDialog;
        if (r5 != null) goto L18;
    L20:
        r1 = false;
    L21:
        if (r1 == false) goto L29;
        OActionDialog r6 = this.mChooseLockTypeDialog;
        if (r6 == null) goto L25;
        r6.setOnDismissListener(new FingerprintManageExternalActivity$$ExternalSyntheticLambda6());
    L25:
        OActionDialog r7 = this.mChooseLockTypeDialog;
        if (r7 == null) goto L30;
        r7.dismiss();
        return;
    L30:
        return;
    L29:
        return;
    L18:
        if (r5.isShowing() != true) goto L20;
    L5:
        if (r0.isShowing() != true) goto L7;
        r2 = true;
        goto L8
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FingerprintManageExternalActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(FingerprintManageExternalActivity r1) {
        com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(FingerprintManageExternalActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintManageExternalActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_FingerprintManageExternalActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(FingerprintManageExternalActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(FingerprintManageExternalActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        FingerprintManageExternalActivity r5 = r4;
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
    public static void com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(FingerprintManageExternalActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_FingerprintManageExternalActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(FingerprintManageExternalActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_FingerprintManageExternalActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(FingerprintManageExternalActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintManageExternalActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_FingerprintManageExternalActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(FingerprintManageExternalActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(FingerprintManageExternalActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintManageExternalActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_FingerprintManageExternalActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(FingerprintManageExternalActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        FingerprintManageExternalActivity r5 = r3;
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

    @Insert("onStop")
    public static void com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(FingerprintManageExternalActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintManageExternalActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_FingerprintManageExternalActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_FingerprintManageExternalActivity_com_obric_hook_lancet_PrivacyHookActivity2_onDestroy(FingerprintManageExternalActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintManageExternalActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_FingerprintManageExternalActivity__onDestroy$___twin___();
    }
}
