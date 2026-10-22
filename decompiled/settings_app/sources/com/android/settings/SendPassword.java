package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.core.app.NotificationCompat;
import bytedanceos.api.TextViewSmt;
import com.android.settings.base.BaseActivity;
import com.android.settings.http.RSAUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.GeoTrustManager;
import com.android.settings.widget.SettingItemButton;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.security.SecureRandom;
import java.util.HashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.BytedanceProgressDialog;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class SendPassword extends BaseActivity implements View.OnClickListener {
    private static final int CAPTCHA_MIN_LEN = 4;
    private static final String SEND_PWD_URL = "";
    private static final String TAG = "SendPassword";
    private BytedanceProgressDialog dialog;
    private String email;
    private final Handler handler;
    private EditText mCaptchaInput;
    ImageView mCatpcha;
    private SettingItemText mEmailAddress;
    private boolean mGetAppLockPasswording;
    private boolean mGetPublicKeyding;
    private String password;
    private String publicKey;
    private ImageView refresh;
    private ScrollView scrollView;
    private SettingItemButton sendBtn;

    public void com_android_settings_SendPassword__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_SendPassword__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_SendPassword__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_SendPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_SendPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_SendPassword_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_SendPassword_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_SendPassword_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public SendPassword() {
        this.handler = new Handler();
    }

    static /* synthetic */ SettingItemButton access$000(SendPassword r0) {
        return r0.sendBtn;
    }

    static /* synthetic */ void access$100(SendPassword r0, int r1) {
        r0.fullScroll(r1);
    }

    static /* synthetic */ void access$1000(SendPassword r0) {
        r0.dismissDialog();
    }

    static /* synthetic */ void access$1100(SendPassword r0) {
        r0.getCaptchaAndPubKey();
    }

    static /* synthetic */ ScrollView access$200(SendPassword r0) {
        return r0.scrollView;
    }

    static /* synthetic */ boolean access$302(SendPassword r0, boolean r1) {
        r0.mGetPublicKeyding = r1;
        return r1;
    }

    static /* synthetic */ String access$402(SendPassword r0, String r1) {
        r0.publicKey = r1;
        return r1;
    }

    static /* synthetic */ String access$502(SendPassword r0, String r1) {
        r0.password = r1;
        return r1;
    }

    static /* synthetic */ EditText access$600(SendPassword r0) {
        return r0.mCaptchaInput;
    }

    static /* synthetic */ void access$700(SendPassword r0, String r1) {
        r0.sendPassword2Email(r1);
    }

    static /* synthetic */ boolean access$802(SendPassword r0, boolean r1) {
        r0.mGetAppLockPasswording = r1;
        return r1;
    }

    static /* synthetic */ BytedanceProgressDialog access$900(SendPassword r0) {
        return r0.dialog;
    }

    private void dismissDialog() {
        BytedanceProgressDialog r0 = this.dialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    public void com_android_settings_SendPassword__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.send_password_layout);
        CookieHandler.setDefault(new CookieManager());
        SettingItemButton r5 = (SettingItemButton) findViewById(R.id.send_btn);
        this.sendBtn = r5;
        r5.setOnClickListener(this);
        ImageView r6 = (ImageView) findViewById(R.id.refresh);
        this.refresh = r6;
        r6.setOnClickListener(this);
        this.mEmailAddress = (SettingItemText) findViewById(R.id.email_address);
        ImageView r7 = (ImageView) findViewById(R.id.catpcha);
        this.mCatpcha = r7;
        r7.setOnClickListener(this);
        EditText r8 = (EditText) findViewById(R.id.captcha_input);
        this.mCaptchaInput = r8;
        r8.addTextChangedListener(new AnonymousClass1(this));
        TextViewSmt.getInstance().setMaxTextSize(this.mCaptchaInput, getResources().getDimensionPixelSize(R.dimen.send_password_edit_max_size));
        this.scrollView = (ScrollView) findViewById(R.id.scroll_view);
        final View r9 = findViewById(R.id.root_view);
        r9.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2(this, r9));
        this.dialog = new BytedanceProgressDialog(this);
        getCaptchaAndPubKey();
        setupBackBtnOnTitle(false);
    }

    private void fullScroll(final int r3) {
        this.handler.post(new AnonymousClass3(this, r3));
    }

    public void com_android_settings_SendPassword__onResume$___twin___() {
        super.onResume();
        String r0 = FindPasswordWaysActivity.getEmailAddress(this);
        this.email = r0;
        if (TextUtils.isEmpty(r0) == false) goto L6;
        finish();
        return;
    L6:
        this.mEmailAddress.getSubTitleView().setMaxWidth(Integer.MAX_VALUE);
        this.mEmailAddress.setSubTitle(this.email);
    }

    private void getCaptchaAndPubKey() {
        getCaptcha();
        if (this.publicKey == null) goto L5;
        return;
    L5:
        if (this.mGetPublicKeyding == true) goto L9;
        getPublicKey();
        return;
    }

    private void sendPassword2Email(String r4) {
        HashMap r0 = new HashMap(2);
        r0.put("password", this.password);
        r0.put(NotificationCompat.CATEGORY_EMAIL, this.email);
        sendPassword2Email(r4, getEncryptedData(RSAUtils.urlEncodeData(r0)));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.SendPassword$4] */
    private void getPublicKey() {
        new AnonymousClass4(this).execute(new Void[0]);
    }

    private String getEncryptedData(String r1) {
        return RSAUtils.getHexString(RSAUtils.encryptByPublicKey(r1, this.publicKey));
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void launch(Context r2, int r3, int r4) {
        Intent r0 = new Intent(r2, SendPassword.class);
        if (r3 <= 0) goto L5;
        r0.putExtra("back_text_id", R.string.find_password_way_title);
    L5:
        Utils.startActivity(r2, r0, 0, r4);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.android.settings.SendPassword$5] */
    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mCatpcha) goto L5;
    L16:
        getCaptchaAndPubKey();
        return;
    L5:
        if (r2 == this.refresh) goto L16;
        if (r2 == this.sendBtn) goto L10;
        return;
    L10:
        if (this.mGetAppLockPasswording == false) goto L13;
        return;
    L13:
        if (Utils.isNetworkAvailable(this) == false) goto L15;
        new AnonymousClass5(this).execute(new Void[0]);
        return;
    L15:
        Utils.showShortToast(this, getString(R.string.networkDisconnected));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.SendPassword$6] */
    private void getCaptcha() {
        new AnonymousClass6(this).execute(new Void[0]);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.SendPassword$7] */
    private void sendPassword2Email(final String r2, final String r3) {
        new AnonymousClass7(this, r3, r2).execute(new Void[0]);
    }

    public SSLContext getSSLContext() throws Exception {
        SSLContext r3 = SSLContext.getInstance("TLS");
        r3.init(null, new TrustManager[]{new GeoTrustManager()}, new SecureRandom());
        return r3;
    }

    public static byte[] convertInputstream2ByteArray(InputStream r4) throws IOException {
        byte[] r0 = new byte[8192];
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
    L3:
        int r2 = r4.read(r0);
        if (r2 == (-1)) goto L7;
        r1.write(r0, 0, r2);
        goto L3
    L7:
        return r1.toByteArray();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SendPassword_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SendPassword r1) {
        com_android_settings_SendPassword_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_SendPassword_com_obric_hook_lancet_PrivacyHook_onCreate(SendPassword r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SendPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_SendPassword__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SendPassword_com_obric_hook_lancet_BatchedActivityLancet_onResume(SendPassword r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_SendPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SendPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SendPassword r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SendPassword_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SendPassword r5 = r4;
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
    public static void com_android_settings_SendPassword_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SendPassword r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_SendPassword__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SendPassword_com_obric_hook_lancet_BatchedActivityLancet_onStop(SendPassword r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_SendPassword_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_SendPassword_com_obric_hook_lancet_PrivacyHook_onResume(SendPassword r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SendPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_SendPassword__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_SendPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SendPassword r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SendPassword_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_SendPassword_com_obric_hook_lancet_PrivacyHook_onPause(SendPassword r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SendPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_SendPassword__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SendPassword_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SendPassword r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_SendPassword_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SendPassword r5 = r3;
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
    public static void com_android_settings_SendPassword_com_obric_hook_lancet_PrivacyHook_onStop(SendPassword r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SendPassword r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_SendPassword__onStop$___twin___();
    }
}
