package androidx.core.text;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String getScript(Locale r0) {
            return r0.getScript();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static ULocale addLikelySubtags(Object r0) {
            return ULocale.addLikelySubtags((ULocale) r0);
        }

        @DoNotInline
        static ULocale forLocale(Locale r0) {
            return ULocale.forLocale(r0);
        }

        @DoNotInline
        static String getScript(Object r0) {
            return ((ULocale) r0).getScript();
        }
    }

    static {
        int r2 = Build.VERSION.SDK_INT;
        if (r2 >= 21) goto L9;
        Class<?> r1 = Class.forName("libcore.icu.ICU");     // Catch: Exception -> L6
        sGetScriptMethod = r1.getMethod("getScript", new Class[]{String.class});     // Catch: Exception -> L6
        sAddLikelySubtagsMethod = r1.getMethod("addLikelySubtags", new Class[]{String.class});     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        sGetScriptMethod = null;
        sAddLikelySubtagsMethod = null;
        Log.w(TAG, e);
        return;
    L9:
        if (r2 >= 24) goto L20;
        sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private ICUCompat() {
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String addLikelySubtagsBelowApi21(Locale r4) {
        String r5 = r4.toString();
        Method r1 = sAddLikelySubtagsMethod;     // Catch: Throwable -> L7
        if (r1 == null) goto L9;
        return (String) r1.invoke(null, new Object[]{r5});
    L9:
        return r5;
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L9
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String getScriptBelowApi21(String r5) {
        Method r2 = sGetScriptMethod;     // Catch: Throwable -> L7
        if (r2 == null) goto L9;
        return (String) r2.invoke(null, new Object[]{r5});
    L9:
        return null;
    L7:
        e = move-exception;
        Log.w(TAG, e);
        goto L9
    }

    @Nullable
    public static String maximizeAndGetScript(@NonNull Locale r4) {
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 24) goto L7;
        return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(r4)));
    L7:
        if (r1 >= 21) goto L19;
        String r5 = addLikelySubtagsBelowApi21(r4);
        if (r5 != null) goto L17;
        return null;
    L17:
        return getScriptBelowApi21(r5);
    L19:
        return Api21Impl.getScript((Locale) sAddLikelySubtagsMethod.invoke(null, new Object[]{r4}));
    L11:
        e = move-exception;
        Log.w(TAG, e);
        return Api21Impl.getScript(r4);
    }
}
