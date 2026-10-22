package androidx.core.telephony;

import android.telephony.SubscriptionManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    private static class Api29Impl {
        private Api29Impl() {
        }

        static int getSlotIndex(int r0) {
            return SubscriptionManager.getSlotIndex(r0);
        }
    }

    public static int getSlotIndex(int r1) {
        if (r1 != (-1)) goto L6;
        return -1;
    L6:
        return Api29Impl.getSlotIndex(r1);
    }

    private SubscriptionManagerCompat() {
    }
}
