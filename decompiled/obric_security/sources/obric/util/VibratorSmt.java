package obric.util;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Singleton;

/* JADX INFO: loaded from: classes5.dex */
public class VibratorSmt {
    public static final int EFFECT_SWITCH = 0;
    public static final int PRIVILEGE_TYPE_ALWAYS = 1;
    public static final int PRIVILEGE_TYPE_NORMAL = 0;
    static final String TAG = "VibratorSmt";
    static final Singleton<VibratorSmt> sVibratorSmt = null;

    public VibratorSmt() {
    }

    static {
        sVibratorSmt = new AnonymousClass1();
    }

    public static VibratorSmt getInstance() {
        return (VibratorSmt) sVibratorSmt.get();
    }

    public static void vibrateEffect(Vibrator target, int effectId) {
        target.vibrate(VibrationEffect.get(effectId));
    }
}
