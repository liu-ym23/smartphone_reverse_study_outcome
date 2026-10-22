package com.bytedanceos.security.reflect;

import android.content.Context;
import android.os.Vibrator;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class BytedanceOSHelper {
    private static final boolean ENABLE_PRINT_TRACE = false;
    private static final String LOGTAG = "BytedanceOSHelper";

    public static class xVibEffectSmt {
        public xVibEffectSmt() {
        }

        public static int getConstantValue(String contstantName) {
            Field r1 = Class.forName("bytedanceos.api.VibEffectSmt").getField(contstantName);     // Catch: Exception -> L4
            r1.setAccessible(true);     // Catch: Exception -> L4
            return r1.getInt(null);
        L4:
            return -1;
        }
    }

    public BytedanceOSHelper() {
    }

    public static boolean isValidExtDisplayId(Context context) {
        return ((Boolean) Class.forName("android.app.SmtPCUtils").getMethod("isValidExtDisplayId", new Class[]{Context.class}).invoke(null, new Object[]{context})).booleanValue();
    L5:
        return false;
    }

    public static void vibrateEffect(Vibrator vibrator, int effectId) {
        Class.forName("bytedanceos.api.VibratorSmt").getMethod("vibrateEffect", new Class[]{Vibrator.class, Integer.TYPE}).invoke(null, new Object[]{vibrator, Integer.valueOf(effectId)});     // Catch: Exception -> L4
        return;
    }
}
