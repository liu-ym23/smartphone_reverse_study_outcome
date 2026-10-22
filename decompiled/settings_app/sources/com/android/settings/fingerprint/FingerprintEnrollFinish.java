package com.android.settings.fingerprint;

import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.android.settings.R;
import com.android.vcard.VCardConfig;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintEnrollFinish extends FingerprintEnrollBase {
    @Override // com.android.settings.fingerprint.FingerprintEnrollBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintEnrollFinish_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(this, r1);
    }

    public FingerprintEnrollFinish() {
    }

    public void com_android_settings_fingerprint_FingerprintEnrollFinish__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.fingerprint_enroll_finish);
        setHeaderText(R.string.security_settings_fingerprint_enroll_finish_title);
        Button r4 = (Button) findViewById(R.id.add_another_button);
        if (((FingerprintManager) getSystemService("fingerprint")).getEnrolledFingerprints(this.mUserId).size() < FingerprintHelper.getMaxFingerprintPerUser(getResources())) goto L5;
        r4.setVisibility(4);
        return;
    L5:
        r4.setOnClickListener(this);
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollBase
    protected void onNextButtonClick() {
        setResult(1);
        finish();
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollBase, android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3.getId() != R.id.add_another_button) goto L5;
        Intent r0 = getEnrollingIntent();
        r0.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        startActivity(r0);
        finish();
    L5:
        super.onClick(r3);
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_FingerprintEnrollFinish_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(FingerprintEnrollFinish r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintEnrollFinish r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_FingerprintEnrollFinish__onCreate$___twin___(r4);
    }
}
