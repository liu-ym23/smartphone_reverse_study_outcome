package com.android.settings.fingerprint;

import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.R;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintEnrollFindSensor extends FingerprintEnrollBase {
    private static final int CONFIRM_REQUEST = 1;
    private static final int ENROLLING = 2;
    private FingerprintLocationAnimationView mAnimation;
    private boolean mNextClicked;
    private FingerprintEnrollSidecar mSidecar;

    @Override // com.android.settings.fingerprint.FingerprintEnrollBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintEnrollFindSensor_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_settings_fingerprint_FingerprintEnrollFindSensor_com_obric_hook_lancet_PrivacyHookActivity2_onStart(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_fingerprint_FingerprintEnrollFindSensor_com_obric_hook_lancet_PrivacyHookActivity2_onStop(this);
    }

    public FingerprintEnrollFindSensor() {
    }

    public void com_android_settings_fingerprint_FingerprintEnrollFindSensor__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setContentView(R.layout.fingerprint_enroll_find_sensor);
        setHeaderText(R.string.security_settings_fingerprint_enroll_find_sensor_title);
        if (this.mToken != null) goto L5;
        launchConfirmLock();
    L5:
        this.mAnimation = (FingerprintLocationAnimationView) findViewById(R.id.fingerprint_sensor_location_animation);
    }

    public void com_android_settings_fingerprint_FingerprintEnrollFindSensor__onStart$___twin___() {
        super.onStart();
        this.mAnimation.startAnimation();
    }

    public void com_android_settings_fingerprint_FingerprintEnrollFindSensor__onStop$___twin___() {
        super.onStop();
        this.mAnimation.stopAnimation();
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollBase
    protected void onNextButtonClick() {
        startActivityForResult(getEnrollingIntent(), 2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r3, int r4, Intent r5) {
        if (r3 != 1) goto L9;
        if (r4 != (-1)) goto L7;
        this.mToken = r5.getByteArrayExtra("hw_auth_token");
        return;
    L7:
        finish();
        return;
    L9:
        if (r3 != 2) goto L17;
        if (r4 != 1) goto L12;
        setResult(1);
        finish();
        return;
    L12:
        if (r4 != 2) goto L15;
        setResult(2);
        finish();
        return;
    L15:
        if (((FingerprintManager) getSystemService(FingerprintManager.class)).getEnrolledFingerprints().size() < FingerprintHelper.getMaxFingerprintPerUser(getResources())) goto L23;
        finish();
        return;
    L23:
        return;
    L17:
        super.onActivityResult(r3, r4, r5);
    }

    private void launchConfirmLock() {
        OLog.i("FingerprintEnrollFindSensor", "launchConfirmLock challenge 0");
        if (new ChooseLockSettingsHelper(this).launchConfirmationActivity(1, getString(R.string.security_settings_fingerprint_preference_title), null, null, 0, 2) == true) goto L6;
        finish();
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_FingerprintEnrollFindSensor_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(FingerprintEnrollFindSensor r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintEnrollFindSensor r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_FingerprintEnrollFindSensor__onCreate$___twin___(r4);
    }

    @Insert("onStart")
    public static void com_android_settings_fingerprint_FingerprintEnrollFindSensor_com_obric_hook_lancet_PrivacyHookActivity2_onStart(FingerprintEnrollFindSensor r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintEnrollFindSensor r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintEnrollFindSensor__onStart$___twin___();
    }

    @Insert("onStop")
    public static void com_android_settings_fingerprint_FingerprintEnrollFindSensor_com_obric_hook_lancet_PrivacyHookActivity2_onStop(FingerprintEnrollFindSensor r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintEnrollFindSensor r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintEnrollFindSensor__onStop$___twin___();
    }
}
