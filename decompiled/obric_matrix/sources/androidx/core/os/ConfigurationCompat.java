package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ConfigurationCompat {

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList getLocales(Configuration r0) {
            return r0.getLocales();
        }
    }

    private ConfigurationCompat() {
    }

    @NonNull
    public static LocaleListCompat getLocales(@NonNull Configuration r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return LocaleListCompat.wrap(Api24Impl.getLocales(r2));
    L7:
        return LocaleListCompat.create(new Locale[]{r2.locale});
    }
}
