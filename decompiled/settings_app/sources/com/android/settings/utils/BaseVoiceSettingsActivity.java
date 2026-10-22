package com.android.settings.utils;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseVoiceSettingsActivity extends LifeHookActivity2 {
    private static final String TAG = "VoiceSettingsActivity";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_utils_BaseVoiceSettingsActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(this, r1);
    }

    protected abstract boolean onVoiceSettingInteraction(Intent r1);

    public BaseVoiceSettingsActivity() {
    }

    public void com_android_settings_utils_BaseVoiceSettingsActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        if (isVoiceInteractionRoot() == true) goto L5;
        OLog.v(TAG, "Cannot modify settings without voice interaction");
        finish();
        return;
    L5:
        if (onVoiceSettingInteraction(getIntent()) == false) goto L9;
        finish();
        return;
    }

    protected void notifySuccess(final CharSequence r4) {
        if (getVoiceInteractor() == null) goto L6;
        final Bundle r2 = null;
        getVoiceInteractor().submitRequest(new AnonymousClass1(this, r4, r2));
        return;
    }

    protected void notifyFailure(CharSequence r3) {
        if (getVoiceInteractor() == null) goto L6;
        getVoiceInteractor().submitRequest(new VoiceInteractor.AbortVoiceRequest(r3, null));
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_utils_BaseVoiceSettingsActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(BaseVoiceSettingsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        BaseVoiceSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_utils_BaseVoiceSettingsActivity__onCreate$___twin___(r4);
    }
}
