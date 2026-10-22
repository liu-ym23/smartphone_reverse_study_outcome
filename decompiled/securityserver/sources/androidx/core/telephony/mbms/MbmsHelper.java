package androidx.core.telephony.mbms;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.LocaleList;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class MbmsHelper {
    private MbmsHelper() {
    }

    @Nullable
    @SuppressLint({"BanTargetApiAnnotation"})
    @TargetApi(28)
    public static CharSequence getBestNameForService(@NonNull Context r5, @NonNull ServiceInfo r6) {
        LocaleList r7 = r5.getResources().getConfiguration().getLocales();
        int r0 = r6.getNamedContentLocales().size();
        if (r0 != 0) goto L5;
        return null;
    L5:
        String[] r1 = new String[r0];
        Iterator<Locale> r2 = r6.getNamedContentLocales().iterator();
        int r3 = 0;
    L7:
        if (r2.hasNext() == false) goto L9;
        r1[r3] = r2.next().toLanguageTag();
        r3 = r3 + 1;
        goto L7
    L9:
        Locale r8 = r7.getFirstMatch(r1);
        if (r8 != null) goto L13;
        return null;
    L13:
        return r6.getNameForLocale(r8);
    }
}
