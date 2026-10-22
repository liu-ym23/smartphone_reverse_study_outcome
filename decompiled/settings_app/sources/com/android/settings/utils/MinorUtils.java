package com.android.settings.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Messenger;
import android.provider.Settings;
import com.android.settings.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MinorUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00182\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/android/settings/utils/MinorUtils;", "", "()V", "ACTION_PARENTAL_CREDENTIAL_CONFIRM", "", "KEY_AUTHENTICATE_MESSAGE", "KEY_AUTHENTICATE_TYPE", "KEY_AUTHENTICATION_MESSENGER", "KEY_AUTHENTICATION_RESULT_CODE", "MINORS_MODE_ENABLE", "PACKAGE_NAME", "REQUEST_PARENTAL_CREDENTIAL_CONFIRM", "", "RESULT_ERROR", "RESULT_FAILED", "RESULT_HELP", "RESULT_SUCCEEDED", "getMinorsModeState", "", "context", "Landroid/content/Context;", "jumpToMinorApp", "", "activity", "Landroid/app/Activity;", "launchCredentialConfirmController", "callback", "Lkotlin/Function0;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MinorUtils {
    public static final String ACTION_PARENTAL_CREDENTIAL_CONFIRM = "com.android.action.PARENTAL_CREDENTIAL_AUTHENTICATE";
    public static final MinorUtils INSTANCE = null;
    private static final String KEY_AUTHENTICATE_MESSAGE = "key_authentication_message";
    private static final String KEY_AUTHENTICATE_TYPE = "key_authentication_type";
    private static final String KEY_AUTHENTICATION_MESSENGER = "key_authentication_messenger";
    private static final String KEY_AUTHENTICATION_RESULT_CODE = "key_authentication_result_code";
    public static final String MINORS_MODE_ENABLE = "minors_mode_enabled";
    public static final String PACKAGE_NAME = "com.zte.usebalance";
    private static final int REQUEST_PARENTAL_CREDENTIAL_CONFIRM = 999;
    private static final int RESULT_ERROR = 102;
    private static final int RESULT_FAILED = 101;
    private static final int RESULT_HELP = 103;
    private static final int RESULT_SUCCEEDED = 100;

    static {
        INSTANCE = new MinorUtils();
    }

    private MinorUtils() {
    }

    public final boolean getMinorsModeState(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Settings.Secure.getInt(r2.getContentResolver(), MINORS_MODE_ENABLE, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public final void jumpToMinorApp(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intent r3 = new Intent();
        r3.setComponent(new ComponentName("com.zte.usebalance", "com.zte.usebalance.activity.home.HealthyUsePhoneActivity"));
        r3.setAction("android.intent.action.MAIN");
        Utils.startActivity(r4, r3);
    }

    public final void launchCredentialConfirmController(Activity r3, final Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (getMinorsModeState(r3) == true) goto L7;
        if (r4 == null) goto L9;
        r4.invoke();
        return;
    L9:
        return;
    L7:
        Intent r2 = new Intent(ACTION_PARENTAL_CREDENTIAL_CONFIRM);
        final Looper r0 = Looper.getMainLooper();
        r2.putExtra(KEY_AUTHENTICATION_MESSENGER, new Messenger(new MinorUtils$launchCredentialConfirmController$messengerHandler$1(r4, r0)));
        r3.startActivityForResult(r2, 999);
    }
}
