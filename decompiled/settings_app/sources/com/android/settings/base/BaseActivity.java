package com.android.settings.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.window.OnBackInvokedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.GlobalProxyLancet;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.BiometricsLicenseActivity;
import com.android.settings.ChooseLockPassword;
import com.android.settings.ChooseLockPattern;
import com.android.settings.ConfirmDeviceCredentialActivityNew;
import com.android.settings.ConfirmLockBaseActivity;
import com.android.settings.ConfirmLockExtendActivity;
import com.android.settings.ConfirmLockPassword;
import com.android.settings.ConfirmLockPattern;
import com.android.settings.Constants;
import com.android.settings.DeviceAdminAdd;
import com.android.settings.FindPasswordActivity;
import com.android.settings.FindPasswordQuestionSettingsActivity;
import com.android.settings.FindPasswordWaysActivity;
import com.android.settings.FindingPasswordActivity;
import com.android.settings.LockScreenModeActivity;
import com.android.settings.ModifyOrFindPassword;
import com.android.settings.R;
import com.android.settings.SecurityTypeActivity;
import com.android.settings.SendPassword;
import com.android.settings.Settings;
import com.android.settings.SettingsTracker;
import com.android.settings.Utils;
import com.android.settings.applications.ApplicationLabelCache;
import com.android.settings.applock.view.PrivacyPasswordSettingActivity;
import com.android.settings.biometrics.ocean.face.FaceEnrollEnrollingActivity;
import com.android.settings.fingerprint.BackFingerprintEnrollingActivity;
import com.android.settings.fingerprint.FingerprintEnrollWizardActivity;
import com.android.settings.fingerprint.FrontFingerprintEnrollingActivity;
import com.android.settings.fingerprint.RightSideFingerprintEnrollingActivity;
import com.android.settings.provision.NextPageRouting.RoutingUtils;
import com.android.settings.provision.ProvisionConstants;
import com.android.settings.provision.WizardManagerHelper;
import com.android.settings.security.CredentialStorage;
import com.android.settings.wifi.TrustedNetworkSettingsActivity;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: compiled from: BaseActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b *\u0002\u0010!\b&\u0018\u0000 t2\u00020\u00012\u00020\u0002:\u0001tB\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020)H\u0007J\b\u0010*\u001a\u00020&H\u0002J \u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010\bJ\u0012\u0010/\u001a\u00020\u00132\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0018\u00102\u001a\u0004\u0018\u0001012\u000e\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u0002010\u0017J\b\u00104\u001a\u00020&H\u0016J\u0012\u00105\u001a\u0004\u0018\u0001012\u0006\u00106\u001a\u000207H\u0002J\u0017\u00108\u001a\u0002H9\"\b\b\u0000\u00109*\u000201H\u0016¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00172\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020)H\u0016J\b\u0010?\u001a\u00020)H\u0002J\n\u0010@\u001a\u0004\u0018\u00010AH\u0016J\n\u0010B\u001a\u0004\u0018\u00010\u001fH\u0004J\b\u0010C\u001a\u0004\u0018\u000101J\u0010\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\u0013H\u0014J\b\u0010F\u001a\u00020&H\u0002J\b\u0010G\u001a\u00020&H\u0002J\b\u0010H\u001a\u00020\u0013H\u0016J\u0016\u0010I\u001a\u00020\u00132\f\u0010J\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017H\u0002J\u0012\u0010K\u001a\u00020\u00132\b\u0010L\u001a\u0004\u0018\u00010=H\u0014J\b\u0010M\u001a\u00020\u0013H\u0014J\u0016\u0010N\u001a\u00020&2\u0006\u0010O\u001a\u00020)2\u0006\u0010P\u001a\u000201J\b\u0010Q\u001a\u00020&H\u0016J\b\u0010R\u001a\u00020&H\u0016J\u0012\u0010S\u001a\u00020&2\b\u0010T\u001a\u0004\u0018\u00010UH\u0014J\u0012\u0010V\u001a\u00020&2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\"\u0010W\u001a\u00020&2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010X\u001a\u00020&H\u0014J\u0012\u0010Y\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010Z\u001a\u00020&H\u0014J\u0006\u0010[\u001a\u00020&J\b\u0010\\\u001a\u00020&H\u0004J\u0006\u0010]\u001a\u00020&J\u0016\u0010^\u001a\u00020&2\u0006\u0010P\u001a\u0002012\u0006\u0010_\u001a\u00020\u0013J\u0010\u0010`\u001a\u00020&2\u0006\u0010a\u001a\u00020)H\u0016J\u0010\u0010b\u001a\u00020&2\u0006\u0010c\u001a\u00020\u0013H\u0002J\u0012\u0010d\u001a\u00020&2\b\u0010e\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010d\u001a\u00020&2\u0006\u0010f\u001a\u00020)H\u0016J\u0010\u0010g\u001a\u00020&2\u0006\u0010e\u001a\u00020\u001fH\u0014J\u0010\u0010h\u001a\u00020&2\u0006\u0010i\u001a\u00020)H\u0004J\n\u0010j\u001a\u0004\u0018\u00010\u001fH\u0004J\u0012\u0010j\u001a\u0004\u0018\u00010\u001f2\u0006\u0010k\u001a\u00020\u0013H\u0004J\b\u0010l\u001a\u00020\u0013H\u0016J\u000e\u0010m\u001a\u00020&2\u0006\u0010P\u001a\u000201J\u0018\u0010n\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\u0006\u0010,\u001a\u00020)H\u0016J\u000e\u0010o\u001a\u00020&2\u0006\u0010P\u001a\u000201J\b\u0010p\u001a\u00020&H\u0004J\u0006\u0010q\u001a\u00020&J\b\u0010r\u001a\u00020&H\u0004J\f\u0010s\u001a\u00020\u0013*\u000201H\u0002R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u00138\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00138\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00138\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00138\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u00020$8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/android/settings/base/BaseActivity;", "Lcom/obric/privacy/LifeHookActivity;", "Landroid/window/OnBackInvokedCallback;", "()V", "TAG", "", "activityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "mActivity", "Landroid/app/Activity;", "mBackView", "Landroid/view/View;", "mContext", "Landroid/content/Context;", "mFinishWizardReceiver", "com/android/settings/base/BaseActivity$mFinishWizardReceiver$1", "Lcom/android/settings/base/BaseActivity$mFinishWizardReceiver$1;", "mForceFinish", "", "mFromSecurityCenter", "mInsidePasswordSettingsActivities", "", "Ljava/lang/Class;", "mIsExtDisplaying", "mIsFinishReceiverRegistered", "mIsLandScreen", "mIsLaunchFromActivityStackView", "mRightBtn", "mSetupWizardMode", "mTitle", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "mUserLeavePasswordSettingsReceiver", "com/android/settings/base/BaseActivity$mUserLeavePasswordSettingsReceiver$1", "Lcom/android/settings/base/BaseActivity$mUserLeavePasswordSettingsReceiver$1;", "sdUnmountReceiver", "Landroid/content/BroadcastReceiver;", "customStartActivityForResult", "", "intent", "animFlag", "", "disableSavedStateRecreator", "dispatchActivityResultToFragment", "requestCode", "resultCode", "data", "dispatchBackPressedEvent", "activeFragment", "Landroidx/fragment/app/Fragment;", "findFragment", "fragmentClass", "finish", "getActiveFragment", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getBindFragment", ExifInterface.GPS_DIRECTION_TRUE, "()Landroidx/fragment/app/Fragment;", "getCompClass", "cn", "Landroid/content/ComponentName;", "getContentLayoutResId", "getSecureTargetUserId", "getTitleName", "", "getTitleView", "getTopFragment", "handleUserLeavePasswordSettingsIfNeeded", "isScreenOn", "initNavigationBar", "initStartActivityForResultLauncher", "isFromSecurityCenter", "isInsidePasswordSettingsActivity", "targetClass", "isInsideWebView", "topActivity", "isLightStatusBar", "loadRootFragment", "containerId", "fragment", "onBackInvoked", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateWhenPrivacyNotOk", "onCustomActivityResult", "onDestroy", "onNewIntentWhenPrivacyNotOk", "onStop", "originFinish", "registerUserLeavePasswordSettingsIfNeeded", "registerWizardFinishReceiver", "replaceFragment", "addToBackStack", "setContentView", "layoutResID", "setLightStatusBarIcon", "lightMode", "setTitle", "title", "titleId", "setTitleByIntent", "setTitleName", "stringId", "setupBackBtnOnTitle", "removeWinBackground", "shouldAutoBindFragment", "start", "startActivityForResult", "startFragment", "unRegisterUserLeavePasswordSettingsIfNeeded", "unregisterWizardFinishReceiver", "updateTitleSecurityShadow", "isActiveFragment", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseActivity extends LifeHookActivity implements OnBackInvokedCallback {
    public static final String ACTION_USER_LEAVE_PASSWORD_SETTINGS = "com.bytedanceos.action.intent.USER_LEAVE_PASSWORD_SETTINGS";
    public static final Companion Companion = null;
    public static final String EXTRA_FROM_SECURITY = "from_security_center";
    public static final String EXTRA_SHOW_TITLE_BACK_BTN = "show_title_back_btn";
    public static final String FROM_ACTIVITY = "from_activity";
    private static final String FROM_SEARCH = "from_search";
    private static final String VIEW_ID = "view_id";
    private static boolean sAppLabelCacheLoaded;
    public static boolean sIsUserEnterPasswordSettings;
    public final String TAG;
    private ActivityResultLauncher<Intent> activityLauncher;
    public Activity mActivity;
    protected View mBackView;
    public Context mContext;
    private final BaseActivity$mFinishWizardReceiver$1 mFinishWizardReceiver;
    protected boolean mForceFinish;
    public boolean mFromSecurityCenter;
    private final List<Class<?>> mInsidePasswordSettingsActivities;
    protected boolean mIsExtDisplaying;
    private boolean mIsFinishReceiverRegistered;
    protected boolean mIsLandScreen;
    protected boolean mIsLaunchFromActivityStackView;
    protected View mRightBtn;
    public boolean mSetupWizardMode;
    protected OFloatingTitleBar mTitle;
    private final BaseActivity$mUserLeavePasswordSettingsReceiver$1 mUserLeavePasswordSettingsReceiver;
    protected final BroadcastReceiver sdUnmountReceiver;

    /* JADX INFO: compiled from: BaseActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/settings/base/BaseActivity$Companion;", "", "()V", "ACTION_USER_LEAVE_PASSWORD_SETTINGS", "", "EXTRA_FROM_SECURITY", "EXTRA_SHOW_TITLE_BACK_BTN", "FROM_ACTIVITY", "FROM_SEARCH", "VIEW_ID", "sAppLabelCacheLoaded", "", "sIsUserEnterPasswordSettings", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$dcGPwoc_vdPVahrGgAegwQXyjpk(BaseActivity r0, ActivityResult r1) {
        initStartActivityForResultLauncher$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$m7s3fP1JzK5l373Xz-0kCbBirWs, reason: not valid java name */
    public static /* synthetic */ void m331$r8$lambda$m7s3fP1JzK5l373Xz0kCbBirWs(BaseActivity r0, View r1) {
        setupBackBtnOnTitle$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public final void customStartActivityForResult(Intent r4) {
        Intrinsics.checkNotNullParameter(r4, "intent");
        customStartActivityForResult$default(this, r4, 0, 2, null);
    }

    @Override // android.app.Activity
    public void finish() {
        com_android_settings_base_BaseActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    public int getContentLayoutResId() {
        return R.layout.base_activity_layout;
    }

    protected boolean isInsideWebView(ComponentName r1) {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_base_BaseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_base_BaseActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_base_BaseActivity_com_obric_hook_lancet_PrivacyHook_onStop(this);
    }

    public boolean shouldAutoBindFragment() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.android.settings.base.BaseActivity$mFinishWizardReceiver$1] */
    public BaseActivity() {
        String r0 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r0, "getSimpleName(...)");
        this.TAG = r0;
        this.mInsidePasswordSettingsActivities = CollectionsKt.listOf(new Class[]{Settings.SecuritySettingsActivity.class, Settings.FaceRecognitionEnrollCompletedActivity.class, FingerprintEnrollWizardActivity.class, BackFingerprintEnrollingActivity.class, FrontFingerprintEnrollingActivity.class, RightSideFingerprintEnrollingActivity.class, Settings.FaceRecognitionEnrollTipActivity.class, FaceEnrollEnrollingActivity.class, LockScreenModeActivity.class, ChooseLockPattern.class, ChooseLockPassword.class, TrustedNetworkSettingsActivity.class, Settings.OptionsActivity.class, ConfirmLockPassword.class, ConfirmLockPassword.InternalActivity.class, ConfirmLockPattern.class, ConfirmLockPattern.InternalActivity.class, FindingPasswordActivity.class, ModifyOrFindPassword.class, SendPassword.class, FindPasswordActivity.class, FindPasswordWaysActivity.class, FindPasswordQuestionSettingsActivity.class, Settings.QuickPaymentViaFingerprintActivity.class, Settings.FingerprintSetupForPaymentActivity.class, DeviceAdminAdd.class, CredentialStorage.class, ConfirmDeviceCredentialActivityNew.class, PrivacyPasswordSettingActivity.class, BiometricsLicenseActivity.class});
        this.mUserLeavePasswordSettingsReceiver = new BaseActivity$mUserLeavePasswordSettingsReceiver$1(this);
        this.mFinishWizardReceiver = new BaseActivity$mFinishWizardReceiver$1(this);
        this.sdUnmountReceiver = new BaseActivity$sdUnmountReceiver$1(this);
    }

    public static final /* synthetic */ int access$getSecureTargetUserId(BaseActivity r0) {
        return r0.getSecureTargetUserId();
    }

    public void com_android_settings_base_BaseActivity__onCreate$___twin___(Bundle r5) {
        disableSavedStateRecreator();
        super.onCreate(r5);
        if (sAppLabelCacheLoaded == false) goto L5;
    L7:
        this.mContext = this;
        this.mActivity = this;
        this.mFromSecurityCenter = Utils.getBooleanExtraSafely(getIntent(), EXTRA_FROM_SECURITY, false);
        if (Utils.getBooleanExtraSafely(getIntent(), ProvisionConstants.EXTRA_SETUPWIZARD, false) == false) goto L10;
    L13:
        boolean r0 = true;
    L14:
        this.mSetupWizardMode = r0;
        if (shouldAutoBindFragment() == false) goto L19;
        setContentView(getContentLayoutResId());
        if (r5 != null) goto L19;
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.animator.h_fragment_enter, R.animator.h_fragment_pop_exit).replace(R.id.fragment_container_view, getBindFragment()).setReorderingAllowed(true).commit();
    L19:
        initNavigationBar();
        registerUserLeavePasswordSettingsIfNeeded();
        getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this);
        initStartActivityForResultLauncher();
        return;
    L10:
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == true) goto L13;
        r0 = false;
        goto L14
    L5:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L7;
        sAppLabelCacheLoaded = true;
        ApplicationLabelCache.getInstance().init();
        goto L7
    }

    private final void initNavigationBar() {
        getWindow().getDecorView().setSystemUiVisibility(1792);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        Window r0 = getWindow();
        if (Utils.isThreeButtonNavBarEnabled(this) == false) goto L5;
        int r2 = getColor(R.color.oui_bg_base_1);
    L6:
        r0.setNavigationBarColor(r2);
        getWindow().setNavigationBarContrastEnforced(false);
        setLightStatusBarIcon(isLightStatusBar());
        Utils.setNavigationBarBtnColor(getWindow(), Boolean.valueOf(isLightStatusBar()));
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public void com_android_settings_base_BaseActivity__onStop$___twin___() {
        super.onStop();
        boolean r0 = Utils.isScreenOn(this);
        OLog.i(this.TAG, "onStop isScreenOn = " + r0);
        handleUserLeavePasswordSettingsIfNeeded(r0);
    }

    public void com_android_settings_base_BaseActivity__onDestroy$___twin___() {
        super.onDestroy();
        unregisterWizardFinishReceiver();
        unRegisterUserLeavePasswordSettingsIfNeeded();
        getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this);
        SettingsTracker.flush();
    }

    protected boolean isLightStatusBar() {
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L5;
        return true;
    L5:
        return false;
    }

    private final void setLightStatusBarIcon(boolean r2) {
        int r0 = getWindow().getDecorView().getSystemUiVisibility();
        if (r2 == false) goto L5;
        int r3 = r0 | 8192;
    L6:
        getWindow().getDecorView().setSystemUiVisibility(r3);
        return;
    L5:
        r3 = r0 & (-8193);
        goto L6
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int r1) {
        super.setContentView(r1);
        this.mTitle = (OFloatingTitleBar) findViewById(R.id.view_title);
    }

    protected final void updateTitleSecurityShadow() {
        View r1 = this.mRightBtn;
        if (r1 == null) goto L6;
        r1.setBackgroundResource(R.drawable.title_btn_ok);
        return;
    }

    public boolean isFromSecurityCenter() {
        return this.mFromSecurityCenter;
    }

    protected final OFloatingTitleBar setupBackBtnOnTitle() {
        return setupBackBtnOnTitle(true);
    }

    protected void setTitleByIntent(OFloatingTitleBar r3) {
        Intrinsics.checkNotNullParameter(r3, "title");
        if (Utils.hasExtraSafely(getIntent(), "title") == false) goto L8;
        String r4 = Utils.getStringExtraSafely(getIntent(), "title");
        if (TextUtils.isEmpty(r4) == false) goto L16;
    L15:
        r4 = null;
    L16:
        if (r4 == null) goto L18;
        setTitle(r4);
        return;
    L18:
        setTitle(getTitleName());
        return;
    L8:
        if (Utils.hasExtraSafely(getIntent(), "title_id") == false) goto L15;
        int r5 = Utils.getIntExtraSafely(getIntent(), "title_id", -1);
        if (r5 <= 0) goto L15;
        r4 = getString(r5);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    protected final OFloatingTitleBar setupBackBtnOnTitle(boolean r5) {
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.view_title);
        if (Utils.getBooleanExtraSafely(getIntent(), EXTRA_SHOW_TITLE_BACK_BTN, true) == false) goto L10;
        View r1 = null;
        if (r0 == null) goto L7;
        r1 = r0.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
    L7:
        this.mBackView = r1;
        if (r1 == null) goto L10;
        r1.setOnClickListener(new BaseActivity$$ExternalSyntheticLambda1(this));
    L10:
        if (r0 == null) goto L12;
        setTitleByIntent(r0);
    L12:
        if (r5 == true) goto L14;
    L16:
        return r0;
    L14:
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == true) goto L16;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        goto L16
    }

    private static final void setupBackBtnOnTitle$lambda$0(BaseActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onBackPressed();
    }

    protected final void setTitleName(int r2) {
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.view_title);
        if (r0 == null) goto L6;
        r0.setCenterTitle(getString(r2));
        return;
    }

    protected final OFloatingTitleBar getTitleView() {
        return this.mTitle;
    }

    public CharSequence getTitleName() {
        return "";
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence r2) {
        super.setTitle(r2);
        OFloatingTitleBar r1 = this.mTitle;
        if (r1 == null) goto L13;
        if (r2 == null) goto L6;
        String r0 = r2.toString();
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L10;
        String r3 = "";
    L11:
        r1.setCenterTitle(r3);
        return;
    L10:
        r3 = String.valueOf(r2);
        goto L11
    L6:
        r0 = null;
        goto L8
    }

    @Override // android.app.Activity
    public void setTitle(int r1) {
        super.setTitle(r1);
        OFloatingTitleBar r0 = this.mTitle;
        if (r0 == null) goto L6;
        r0.setCenterTitle(r1);
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FragmentManager r0 = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r0, "getSupportFragmentManager(...)");
        if (dispatchBackPressedEvent(getActiveFragment(r0)) == false) goto L5;
        return;
    L5:
        super.onBackPressed();
    }

    private final boolean dispatchBackPressedEvent(Fragment r4) {
        if ((r4 instanceof BaseFragment) == false) goto L11;
        BaseFragment r5 = (BaseFragment) r4;
        if (r5.onBackPressedSupport() == false) goto L9;
        r5.setFinishing(false);
        return true;
    L9:
        if (dispatchBackPressedEvent(r5.getParentFragment()) == false) goto L11;
        return true;
    L11:
        return false;
    }

    private final Fragment getActiveFragment(FragmentManager r3) {
        List<Fragment> r4 = r3.getFragments();
        Intrinsics.checkNotNullExpressionValue(r4, "getFragments(...)");
        Iterator r5 = CollectionsKt.asReversedMutable(r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Fragment r0 = (Fragment) r5.next();
        Intrinsics.checkNotNull(r0);
        if (isActiveFragment(r0) == false) goto L4;
        FragmentManager r6 = r0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r6, "getChildFragmentManager(...)");
        Fragment r2 = getActiveFragment(r6);
        if (r2 == null) goto L11;
        return r2;
    L11:
        return r0;
    L12:
        return null;
    }

    private final boolean isActiveFragment(Fragment r1) {
        if (r1.isVisible() == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.isDetached() == true) goto L9;
        if (r1.isRemoving() == true) goto L9;
        return true;
    }

    @Override // android.window.OnBackInvokedCallback
    public void onBackInvoked() {
        onBackPressed();
    }

    public final void registerWizardFinishReceiver() {
        IntentFilter r0 = new IntentFilter("com.bytedanceos.FINISH_WIZARD");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mFinishWizardReceiver, r0, 2);
        this.mIsFinishReceiverRegistered = true;
    }

    public final void unregisterWizardFinishReceiver() {
        if (this.mIsFinishReceiverRegistered == false) goto L6;
        unregisterReceiver(this.mFinishWizardReceiver);
        this.mIsFinishReceiverRegistered = false;
        return;
    }

    protected final void registerUserLeavePasswordSettingsIfNeeded() {
        if (isInsidePasswordSettingsActivity(getClass()) == false) goto L6;
        OLog.d(this.TAG, "registerUserLeavePasswordSettingss");
        IntentFilter r0 = new IntentFilter(ACTION_USER_LEAVE_PASSWORD_SETTINGS);
        r0.addAction("android.intent.action.SCREEN_OFF");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mUserLeavePasswordSettingsReceiver, r0, 2);
        return;
    }

    protected final void unRegisterUserLeavePasswordSettingsIfNeeded() {
        if (isInsidePasswordSettingsActivity(getClass()) == false) goto L11;
        OLog.d(this.TAG, "unRegisterUserLeavePasswordSettingsIfNeeded");     // Catch: IllegalArgumentException -> L6
        unregisterReceiver(this.mUserLeavePasswordSettingsReceiver);     // Catch: IllegalArgumentException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private final boolean isInsidePasswordSettingsActivity(Class<?> r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (sIsUserEnterPasswordSettings == true) goto L8;
        return false;
    L8:
        if (SecurityTypeActivity.class.isAssignableFrom(r5) == false) goto L12;
        OLog.d("Settings", "isAssignableFrom SecurityTypeActivity for " + r5);
        return true;
    L12:
        if (ConfirmLockExtendActivity.class.isAssignableFrom(r5) == false) goto L15;
        return true;
    L15:
        if (ConfirmLockBaseActivity.class.isAssignableFrom(r5) == false) goto L17;
        return true;
    L17:
        Iterator<Class<?>> r4 = this.mInsidePasswordSettingsActivities.iterator();
    L19:
        if (r4.hasNext() == false) goto L28;
        if (Intrinsics.areEqual(r5, r4.next()) == false) goto L19;
        OLog.d("Settings", "isInsidePasswordSettingsActivity for " + r5);
        return true;
    L28:
        return false;
    }

    protected void handleUserLeavePasswordSettingsIfNeeded(boolean r9) {
        if (isInsidePasswordSettingsActivity(getClass()) == false) goto L36;
        BaseActivity r1 = this;
        if (new LockPatternUtils(r1).isSecure(getSecureTargetUserId()) == true) goto L7;
        return;
    L7:
        ComponentName r0 = Utils.getTopActivity(r1);
        boolean r2 = false;
        if (r0 == null) goto L27;
        OLog.i(this.TAG, "top Activity: " + r0.getClassName());
        String r3 = r0.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r3, "getPackageName(...)");
        if (isInsidePasswordSettingsActivity(getCompClass(r0)) == true) goto L28;
        String r4 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        if (StringsKt.contains$default(r4, "com.android.settings.SecuritySettingsActivity", false, 2, null) == true) goto L28;
        if (Intrinsics.areEqual("com.bytedanceos.cloudsync", r3) == true) goto L28;
        if (Intrinsics.areEqual("com.obric.autoaction", r3) == true) goto L28;
        if (Intrinsics.areEqual("com.bytedance.facerecognition", r3) == true) goto L28;
        if (Intrinsics.areEqual("com.android.certinstaller", r3) == true) goto L28;
        if (Intrinsics.areEqual("com.obric.vault", r3) == true) goto L28;
        if (isInsideWebView(r0) == true) goto L28;
        boolean r5 = false;
    L29:
        if (r9 == false) goto L31;
        if (r5 == false) goto L31;
    L32:
        OLog.i(this.TAG, "isUserLeavePasswordSettings " + r2 + " , isScreenOn = " + r9);
        if (r2 == false) goto L37;
        OLog.i(this.TAG, "send ACTION_USER_LEAVE_PASSWORD_SETTINGS");
        Intent r6 = new Intent(ACTION_USER_LEAVE_PASSWORD_SETTINGS);
        r6.putExtra("isScreenOn", r9);
        sendBroadcast(r6);
        return;
    L37:
        return;
    L31:
        r2 = true;
    L28:
        r5 = true;
        goto L29
    L27:
        OLog.i(this.TAG, "top Activity is null, isStillInsideSettings?");
        goto L28
    }

    private final int getSecureTargetUserId() {
        return Utils.getSecureTargetUser(getActivityToken(), UserManager.get(this), null, getIntent().getExtras()).getIdentifier();
    }

    private final Class<?> getCompClass(ComponentName r2) {
        Class<?> r1 = Class.forName(r2.getClassName());     // Catch: ClassNotFoundException -> L4
    L6:
        OLog.d("Settings", "get comp class: " + r1);
        return r1;
    L4:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L6
    }

    private final void initStartActivityForResultLauncher() {
        ActivityResultLauncher<Intent> r0 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new BaseActivity$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(r0, "registerForActivityResult(...)");
        this.activityLauncher = r0;
    }

    private static final void initStartActivityForResultLauncher$lambda$2(BaseActivity r5, ActivityResult r6) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intent r0 = r6.getData();
        int r2 = -1;
        if (r0 == null) goto L7;
        Bundle r1 = r0.getExtras();
        if (r1 == null) goto L7;
        int r3 = r1.getInt("request_code");
    L8:
        r5.onCustomActivityResult(r3, r6.getResultCode(), r6.getData());
        Intent r4 = r6.getData();
        if (r4 == null) goto L13;
        Bundle r7 = r4.getExtras();
        if (r7 == null) goto L13;
        r2 = r7.getInt("request_code");
    L13:
        r5.dispatchActivityResultToFragment(r2, r6.getResultCode(), r6.getData());
        return;
    L7:
        r3 = -1;
        goto L8
    }

    public void onCustomActivityResult(int r2, int r3, Intent r4) {
        OLog.i(this.TAG, "onCustomActivityResult, request_code: " + r2 + ", result_code: " + r3);
    }

    public static /* synthetic */ void customStartActivityForResult$default(BaseActivity r0, Intent r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        r0.customStartActivityForResult(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: customStartActivityForResult");
    }

    public final void customStartActivityForResult(Intent r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        ActivityResultLauncher<Intent> r0 = this.activityLauncher;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("activityLauncher");
        r0 = null;
    L5:
        r0.launch(r2);
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L10;
        overridePendingTransition(0, 0);
        return;
    L10:
        if (r3 == 2) goto L17;
        if (r3 != 3) goto L24;
        TransitionAnimHelper.overrideEnterAnim(this, TransitionAnimStyle.Modal);
        return;
    L24:
        return;
    L17:
        if (Utils.isSetupCompelete(this) == false) goto L19;
        TransitionAnimHelper.overrideEnterAnim(this, TransitionAnimStyle.Standard);
        return;
    L19:
        RoutingUtils.overrideStarting(this);
    }

    public final void dispatchActivityResultToFragment(int r4, int r5, Intent r6) {
        OLog.i(this.TAG, "dispatchActivityResultToFragment, request_code: " + r4 + ", result_code: " + r5);
        List<Fragment> r3 = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r3, "getFragments(...)");
        if ((!r3.isEmpty()) == false) goto L13;
        Iterator<Fragment> r7 = r3.iterator();
    L6:
        if (r7.hasNext() == false) goto L19;
        Fragment r0 = r7.next();
        if ((r0 instanceof BaseFragment) == false) goto L10;
        BaseFragment r1 = (BaseFragment) r0;
    L11:
        if (r1 == null) goto L6;
        r1.onCustomActivityResult(r4, r5, r6);
        goto L6
    L10:
        r1 = null;
        goto L11
    L19:
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        if (r3.hasExtra(Constants.EXTRA_OUTER) == true) goto L6;
        r3.putExtra(Constants.EXTRA_OUTER, false);
    L6:
        if (r3.hasExtra("back_text") == false) goto L8;
    L10:
        super.startActivityForResult(r3, r4);
        return;
    L8:
        if (getTitleName() == null) goto L10;
        r3.putExtra("back_text", getTitleName());
        goto L10
    }

    public <T extends Fragment> T getBindFragment() {
        throw new RuntimeException("subclass of BaseActivity must overwrite getBindFragment method,and return real fragment instance");
    }

    public final Fragment findFragment(Class<? extends Fragment> r2) {
        Intrinsics.checkNotNullParameter(r2, "fragmentClass");
        return getSupportFragmentManager().findFragmentByTag(r2.getSimpleName());
    }

    public final void loadRootFragment(int r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        getSupportFragmentManager().beginTransaction().replace(r2, r3, r3.getClass().getSimpleName()).setReorderingAllowed(true).commit();
    }

    public final Fragment getTopFragment() {
        FragmentManager r0 = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r0, "getSupportFragmentManager(...)");
        Fragment r1 = getActiveFragment(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        List<Fragment> r2 = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r2, "getFragments(...)");
        if ((!r2.isEmpty()) == false) goto L9;
        List<Fragment> r3 = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(r3, "getFragments(...)");
        return (Fragment) CollectionsKt.last(r3);
    L9:
        return null;
    }

    public final void startFragment(Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        if (Utils.isFastDoubleClick(hashCode(), 300) == false) goto L5;
        return;
    L5:
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.animator.h_fragment_enter, R.animator.h_fragment_pop_exit).replace(R.id.fragment_container_view, r4).setReorderingAllowed(true).commit();
    }

    public final void start(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        startFragment(r2);
    }

    public final void replaceFragment(Fragment r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        if (Utils.isFastDoubleClick(hashCode(), 300) == false) goto L5;
        return;
    L5:
        FragmentTransaction r4 = getSupportFragmentManager().beginTransaction().setCustomAnimations(R.animator.h_fragment_enter, R.animator.h_fragment_pop_exit, R.animator.h_fragment_pop_enter, R.animator.h_fragment_exit).replace(R.id.fragment_container_view, r5, r5.getClass().getSimpleName()).setReorderingAllowed(true);
        Intrinsics.checkNotNullExpressionValue(r4, "setReorderingAllowed(...)");
        if (r6 == false) goto L8;
        r4.addToBackStack(r5.getClass().getSimpleName());
    L8:
        r4.commit();
    }

    public void com_android_settings_base_BaseActivity__finish$___twin___() {
        super.finish();
        if (this.mSetupWizardMode == false) goto L5;
        overridePendingTransition(0, R.anim.slide_out_to_right);
        return;
    L5:
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }

    public final void originFinish() {
        super.finish();
    }

    @Override // com.obric.privacy.LifeHookActivity
    public void onCreateWhenPrivacyNotOk(final Bundle r5) {
        super.onCreateWhenPrivacyNotOk(r5);
        Intent r0 = getIntent();
        if (r0 == null) goto L5;
        OLog.d(this.TAG, "onCreateWhenPrivacyNotOk intent action=" + r0.getAction() + ", flags=" + r0.getFlags());
    L5:
        GrantUtil.INSTANCE.requestGrant(this, new AnonymousClass1(this, r5));
        OLog.i(this.TAG, "onCreateWhenPrivacyNotOk, finish");
        this.mForceFinish = true;
    }

    @Override // com.obric.privacy.LifeHookActivity
    public void onNewIntentWhenPrivacyNotOk(Intent r4) {
        super.onNewIntentWhenPrivacyNotOk(r4);
        Intent r5 = getIntent();
        OLog.i(this.TAG, "onNewIntentWhenPrivacyNotOk");
        if (r5 == null) goto L5;
        OLog.d(this.TAG, "onNewIntentWhenPrivacyNotOk intent action=" + r5.getAction() + ", flags=" + r5.getFlags());
    L5:
        GrantUtil.INSTANCE.requestGrant(this, new C01431(this));
        OLog.i(this.TAG, "onNewIntentWhenPrivacyNotOk, finish");
        this.mForceFinish = true;
    }

    private final void disableSavedStateRecreator() {
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        Class<?> r5 = Class.forName("androidx.savedstate.Recreator");     // Catch: Throwable -> L9
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L6
        Field r3 = r5.getDeclaredField("sRan");     // Catch: Throwable -> L6
        r3.setAccessible(true);     // Catch: Throwable -> L6
        r3.set(null, true);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
        Result.m1508constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L9
        Field r7 = r5.getDeclaredField("ALREADY_CREATED");     // Catch: Throwable -> L9
        r7.setAccessible(true);     // Catch: Throwable -> L9
        r7.set(null, true);     // Catch: Throwable -> L9
        Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.m1508constructorimpl(ResultKt.createFailure(th));
    }

    @Insert("onCreate")
    public static void com_android_settings_base_BaseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(BaseActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_base_BaseActivity__onCreate$___twin___(r4);
    }

    @Insert("onStop")
    public static void com_android_settings_base_BaseActivity_com_obric_hook_lancet_PrivacyHook_onStop(BaseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_base_BaseActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_base_BaseActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(BaseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_base_BaseActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_base_BaseActivity_com_obric_hook_lancet_PrivacyHook_finish(BaseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_base_BaseActivity__finish$___twin___();
    }
}
