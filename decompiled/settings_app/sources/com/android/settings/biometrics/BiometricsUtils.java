package com.android.settings.biometrics;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.os.UserHandle;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.SettingsFeature;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.utils.DisplayUtils;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: BiometricsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/settings/biometrics/BiometricsUtils;", "", "()V", "ALERT_TYPE_FACE_RECOGNITION", "", "ALERT_TYPE_FINGERPRINT", "ALERT_TYPE_NONE", "TAG", "", "handleEnrolling", "", "activity", "Landroid/app/Activity;", "password", "Lcom/android/internal/widget/LockscreenCredential;", "isSecure", "", "routeToFingerprintManagerActivity", "startEnrollFaceRecognition", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BiometricsUtils {
    public static final int ALERT_TYPE_FACE_RECOGNITION = 1;
    public static final int ALERT_TYPE_FINGERPRINT = 0;
    public static final int ALERT_TYPE_NONE = -1;
    public static final BiometricsUtils INSTANCE = null;
    private static final String TAG = null;

    private BiometricsUtils() {
    }

    static {
        INSTANCE = new BiometricsUtils();
        TAG = Reflection.getOrCreateKotlinClass(BiometricsUtils.class).getSimpleName();
    }

    private final void routeToFingerprintManagerActivity(Activity r4, LockscreenCredential r5) {
        String r3 = TAG;
        StringBuilder r0 = new StringBuilder("routeToFingerprintManagerActivity EXTRA_PWD: password==null ");
        if (r5 != null) goto L5;
        boolean r2 = true;
    L6:
        OLog.i(r3, r0.append(r2).toString());
        Activity r6 = r4;
        Intent r7 = new Intent(r6, Settings.FingerprintManageActivity.class);
        if (r5 != null) goto L9;
    L11:
        Utils.startActivity(r6, r7, 2);
        return;
    L9:
        if (r5.isNone() == true) goto L11;
        r7.putExtra("password", (Parcelable) r5);
        r7.putExtra("password_confirmed", true);
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    private final void startEnrollFaceRecognition(Activity r2, LockscreenCredential r3) {
        OLog.i(TAG, "startEnrollFaceRecognition");
        Activity r4 = r2;
        Intent r1 = new Intent(r4, Settings.FaceRecognitionEnrollTipActivity.class);
        if (r3 != null) goto L5;
    L7:
        Utils.startActivity(r4, r1, 0);
        return;
    L5:
        if (r3.isNone() == true) goto L7;
        r1.putExtra("password", (Parcelable) r3);
        r1.putExtra("password_confirmed", true);
        goto L7
    }

    private final boolean isSecure(Activity r1) {
        return new LockPatternUtils(r1).isSecure(UserHandle.myUserId());
    }

    public final void handleEnrolling(Activity r5, LockscreenCredential r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getIntent() == null) goto L26;
        Intent r0 = r5.getIntent();
        Intrinsics.checkNotNullExpressionValue(r0, "getIntent(...)");
        int r1 = r0.getIntExtra("alert_type", -1);
        if (r1 != (-1)) goto L9;
        return;
    L9:
        if (isSecure(r5) == false) goto L27;
        OLog.i(TAG, "handleEnrolling=" + r1);
        if (SettingsFeature.isDarwin() == false) goto L14;
        int r2 = 0;
    L15:
        ToastUtils.showToastWithOffset(r5, R.string.lock_pwd_setup_success, r2);
        if (r1 != 0) goto L18;
        routeToFingerprintManagerActivity(r5, r6);
        return;
    L18:
        if (r1 != 1) goto L28;
        startEnrollFaceRecognition(r5, r6);
        return;
    L28:
        return;
    L14:
        r2 = (int) DisplayUtils.dip2px(60.0f);
        goto L15
    L27:
        return;
    }
}
