package obric.util;

import android.os.Vibrator;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: compiled from: VibratorHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lobric/util/VibratorSmtForSettings;", "", "()V", "TAG", "", "vibrateEffectWithHapticPlayer", "", "target", "Landroid/os/Vibrator;", "effectId", "", "intensityScale", "", "flag", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VibratorSmtForSettings {
    public static final VibratorSmtForSettings INSTANCE = null;
    private static final String TAG = "VibratorSmtForSettings";

    static {
        INSTANCE = new VibratorSmtForSettings();
    }

    private VibratorSmtForSettings() {
    }

    public final void vibrateEffectWithHapticPlayer(Vibrator r1, int r2, double r3, int r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        bytedanceos.api.VibratorSmt.vibrateEffectWithHapticPlayer(r1, r2, r3, r5);     // Catch: Throwable -> L4
        Object r4 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.m1511exceptionOrNullimpl(r4);
        if (r6 == null) goto L13;
        r6.printStackTrace();
        OLog.e(TAG, "vibrateEffectWithHapticPlayer error: " + r6);
        return;
    L13:
        return;
    L4:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}
