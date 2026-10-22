package androidx.core.os;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public final class ConfigurationCompat {

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList getLocales(Configuration r0) {
            return r0.getLocales();
        }
    }

    private ConfigurationCompat() {
    }

    public static LocaleListCompat getLocales(Configuration r0) {
        return LocaleListCompat.wrap(Api24Impl.getLocales(r0));
    }
}
