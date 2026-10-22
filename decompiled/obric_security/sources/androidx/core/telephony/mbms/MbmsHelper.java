package androidx.core.telephony.mbms;

import android.content.Context;
import android.telephony.mbms.ServiceInfo;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MbmsHelper {

    static class Api28Impl {
        private Api28Impl() {
        }

        static CharSequence getBestNameForService(Context r5, ServiceInfo r6) {
            Set<Locale> r0 = r6.getNamedContentLocales();
            if (r0.isEmpty() == false) goto L5;
            return null;
        L5:
            String[] r1 = new String[r0.size()];
            Iterator<Locale> r2 = r6.getNamedContentLocales().iterator();
            int r3 = 0;
        L7:
            if (r2.hasNext() == false) goto L9;
            r1[r3] = r2.next().toLanguageTag();
            r3 = r3 + 1;
            goto L7
        L9:
            Locale r7 = r5.getResources().getConfiguration().getLocales().getFirstMatch(r1);
            if (r7 != null) goto L13;
            return null;
        L13:
            return r6.getNameForLocale(r7);
        }
    }

    private MbmsHelper() {
    }

    public static CharSequence getBestNameForService(Context r0, ServiceInfo r1) {
        return Api28Impl.getBestNameForService(r0, r1);
    }
}
