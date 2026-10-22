package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.AnyThread;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleManagerCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String toLanguageTag(Locale r0) {
            return r0.toLanguageTag();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleListCompat getLocales(Configuration r0) {
            return LocaleListCompat.forLanguageTags(r0.getLocales().toLanguageTags());
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static LocaleList localeManagerGetSystemLocales(Object r0) {
            return ((LocaleManager) r0).getSystemLocales();
        }
    }

    private LocaleManagerCompat() {
    }

    @VisibleForTesting
    static LocaleListCompat getConfigurationLocales(Configuration r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 24) goto L7;
        return Api24Impl.getLocales(r2);
    L7:
        if (r0 < 21) goto L11;
        return LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(r2.locale));
    L11:
        return LocaleListCompat.create(new Locale[]{r2.locale});
    }

    @RequiresApi(33)
    private static Object getLocaleManagerForApplication(Context r1) {
        return r1.getSystemService("locale");
    }

    @NonNull
    @AnyThread
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static LocaleListCompat getSystemLocales(@NonNull Context r2) {
        LocaleListCompat r0 = LocaleListCompat.getEmptyLocaleList();
        if (BuildCompat.isAtLeastT() == false) goto L8;
        Object r3 = getLocaleManagerForApplication(r2);
        if (r3 != null) goto L10;
        return r0;
    L10:
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(r3));
    L8:
        return getConfigurationLocales(r2.getApplicationContext().getResources().getConfiguration());
    }
}
