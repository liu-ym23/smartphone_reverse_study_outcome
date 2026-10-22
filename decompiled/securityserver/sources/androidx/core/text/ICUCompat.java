package androidx.core.text;

import android.icu.util.ULocale;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    private ICUCompat() {
    }

    private static String addLikelySubtags(Locale r4) {
        String r5 = r4.toString();
        Method r1 = sAddLikelySubtagsMethod;     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
        if (r1 == null) goto L13;
        return (String) r1.invoke(null, new Object[]{r5});
    L13:
        return r5;
    L9:
        e = move-exception;
        Log.w(TAG, e);
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L13
    }

    private static String getScript(String r3) {
        Method r2 = sGetScriptMethod;     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
        if (r2 == null) goto L13;
        return (String) r2.invoke(null, new Object[]{r3});
    L13:
        return null;
    L9:
        e = move-exception;
        Log.w(TAG, e);
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L13
    }

    @Nullable
    public static String maximizeAndGetScript(Locale r0) {
        return ULocale.addLikelySubtags(ULocale.forLocale(r0)).getScript();
    }
}
