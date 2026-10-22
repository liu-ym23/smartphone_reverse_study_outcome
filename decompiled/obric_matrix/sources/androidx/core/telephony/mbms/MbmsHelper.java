package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MbmsHelper {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        static CharSequence getBestNameForService(Context r5, ServiceInfo r6) {
            Set<Locale> r0 = r6.getNamedContentLocales();
            if (r0.isEmpty() == false) goto L5;
            return null;
        L5:
            String[] r1 = new String[r0.size()];
            int r2 = 0;
            Iterator<Locale> r3 = r6.getNamedContentLocales().iterator();
        L7:
            if (r3.hasNext() == false) goto L9;
            r1[r2] = r3.next().toLanguageTag();
            r2 = r2 + 1;
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

    @Nullable
    public static CharSequence getBestNameForService(@NonNull Context r2, @NonNull ServiceInfo r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return null;
    L5:
        return Api28Impl.getBestNameForService(r2, r3);
    }
}
