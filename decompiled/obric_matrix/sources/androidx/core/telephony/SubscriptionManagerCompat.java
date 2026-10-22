package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int getSlotIndex(int r0) {
            return SubscriptionManager.getSlotIndex(r0);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int r7) {
        if (r7 != (-1)) goto L5;
        return -1;
    L5:
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 29) goto L8;
        if (sGetSlotIndexMethod == null) goto L12;
    L17:
        Integer r8 = (Integer) sGetSlotIndexMethod.invoke(null, new Object[]{Integer.valueOf(r7)});     // Catch: Throwable -> L22
        if (r8 == null) goto L21;
        return r8.intValue();
    L12:
        if (r1 < 26) goto L15;
        Method r2 = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", new Class[]{Integer.TYPE});     // Catch: Throwable -> L22
    L14:
        sGetSlotIndexMethod = r2;     // Catch: Throwable -> L22
        sGetSlotIndexMethod.setAccessible(true);     // Catch: Throwable -> L22
        goto L17
    L15:
        r2 = SubscriptionManager.class.getDeclaredMethod("getSlotId", new Class[]{Integer.TYPE});     // Catch: Throwable -> L22
    L21:
        return -1;
    L8:
        return Api29Impl.getSlotIndex(r7);
    }
}
