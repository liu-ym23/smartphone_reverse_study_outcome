package com.android.settings.fingerprint;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.utils.NullSafe;
import com.android.setupwizardlib.SetupWizardLayout;
import com.android.setupwizardlib.view.NavigationBar;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintEnrollBase extends LifeHookActivity2 implements View.OnClickListener {
    protected static final int RESULT_FINISHED = 1;
    protected static final int RESULT_SKIP = 2;
    protected byte[] mToken;
    protected int mUserId;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintEnrollBase_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(this, r1);
    }

    protected void onNextButtonClick() {
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintEnrollBase_com_obric_hook_lancet_PrivacyHookActivity2_onPostCreate(this, r1);
    }

    public FingerprintEnrollBase() {
    }

    public void com_android_settings_fingerprint_FingerprintEnrollBase__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        byte[] r0 = getIntent().getByteArrayExtra("hw_auth_token");
        this.mToken = r0;
        if (r3 == null) goto L6;
        if (r0 != null) goto L6;
        this.mToken = r3.getByteArray("hw_auth_token");
    L6:
        this.mUserId = getIntent().getIntExtra("android.intent.extra.USER_ID", UserHandle.myUserId());
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putByteArray("hw_auth_token", this.mToken);
    }

    public void com_android_settings_fingerprint_FingerprintEnrollBase__onPostCreate$___twin___(Bundle r1) {
        super.onPostCreate(r1);
        initViews();
    }

    protected void initViews() {
        getWindow().addFlags(-2147417856);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        getWindow().setStatusBarColor(0);
        NavigationBar r0 = getNavigationBar();
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        Button r1 = getNextButton();
        if (r1 == null) goto L9;
        r1.setOnClickListener(this);
        return;
    }

    protected NavigationBar getNavigationBar() {
        return (NavigationBar) NullSafe.nonNull(findViewById(R.id.suw_layout_navigation_bar));
    }

    protected SetupWizardLayout getSetupWizardLayout() {
        return (SetupWizardLayout) NullSafe.nonNull(findViewById(R.id.setup_wizard_layout));
    }

    protected void setHeaderText(int r4, boolean r5) {
        SetupWizardLayout r0 = getSetupWizardLayout();
        if (r0 != null) goto L5;
        return;
    L5:
        TextView r1 = r0.getHeaderTextView();
        CharSequence r2 = r1.getText();
        CharSequence r6 = getText(r4);
        if (r2 != r6) goto L9;
        if (r5 == true) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r1.setAccessibilityLiveRegion(1);
    L11:
        r0.setHeaderText(r6);
        setTitle(r6);
    }

    protected void setHeaderText(int r2) {
        setHeaderText(r2, false);
    }

    protected Button getNextButton() {
        return (Button) NullSafe.nonNull(findViewById(R.id.next_button));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != getNextButton()) goto L6;
        onNextButtonClick();
        return;
    }

    protected Intent getEnrollingIntent() {
        Intent r0 = new Intent();
        r0.setClassName("com.android.settings", FingerprintEnrollEnrolling.class.getName());
        r0.putExtra("hw_auth_token", this.mToken);
        int r3 = this.mUserId;
        if (r3 == (-10000)) goto L5;
        r0.putExtra("android.intent.extra.USER_ID", r3);
    L5:
        return r0;
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_FingerprintEnrollBase_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(FingerprintEnrollBase r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintEnrollBase r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_FingerprintEnrollBase__onCreate$___twin___(r4);
    }

    @Insert("onPostCreate")
    public static void com_android_settings_fingerprint_FingerprintEnrollBase_com_obric_hook_lancet_PrivacyHookActivity2_onPostCreate(FingerprintEnrollBase r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintEnrollBase r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPostCreate(r4);
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintEnrollBase__onPostCreate$___twin___(r4);
    }
}
