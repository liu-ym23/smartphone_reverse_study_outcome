package obric.util;

import android.content.Context;
import android.os.Vibrator;
import android.security.bytedance.guard.BDSecurityGuardStub;
import com.obric.olog.OLog;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;

/* JADX INFO: compiled from: VibratorHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lobric/util/VibratorHelper;", "", "()V", "TAG", "", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM, "", "context", "Landroid/content/Context;", MaterialConfigFormatNames.PRESS, "reject", "rigid", "tap", "vibrate", "effect", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VibratorHelper {
    public static final VibratorHelper INSTANCE = null;
    private static final String TAG = "VibratorHelper";

    static {
        INSTANCE = new VibratorHelper();
    }

    private VibratorHelper() {
    }

    private final void vibrate(Context r7, int r8) {
        Vibrator r6 = null;
        if (r7 == null) goto L5;
        Object r9 = r7.getSystemService("vibrator");
    L7:
        if ((r9 instanceof Vibrator) == false) goto L9;
        r6 = (Vibrator) r9;
    L9:
        Vibrator r1 = r6;
        if (r1 != null) goto L12;
        return;
    L12:
        VibratorSmtForSettings.INSTANCE.vibrateEffectWithHapticPlayer(r1, r8, 1.0d, 0);
        return;
    L5:
        r9 = null;
        goto L7
    }

    public final void tap(Context r3) {
        OLog.d(TAG, "tap");
        vibrate(r3, 1);
    }

    public final void press(Context r3) {
        OLog.d(TAG, MaterialConfigFormatNames.PRESS);
        vibrate(r3, 0);
    }

    public final void rigid(Context r3) {
        OLog.d(TAG, "rigid");
        vibrate(r3, 4);
    }

    public final void confirm(Context r3) {
        OLog.d(TAG, BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM);
        vibrate(r3, 6);
    }

    public final void reject(Context r3) {
        OLog.d(TAG, "reject");
        vibrate(r3, 7);
    }
}
