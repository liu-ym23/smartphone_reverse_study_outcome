package androidx.fragment.app;

import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class FragmentTransition {
    static final FragmentTransitionImpl PLATFORM_IMPL = null;
    static final FragmentTransitionImpl SUPPORT_IMPL = null;

    static {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        FragmentTransitionCompat21 r0 = new FragmentTransitionCompat21();
    L6:
        PLATFORM_IMPL = r0;
        SUPPORT_IMPL = resolveSupportImpl();
        return;
    L5:
        r0 = null;
        goto L6
    }

    private FragmentTransition() {
    }

    static void callSharedElementStartEnd(Fragment r3, Fragment r4, boolean r5, ArrayMap<String, View> r6, boolean r7) {
        if (r5 == false) goto L4;
        SharedElementCallback r8 = r4.getEnterTransitionCallback();
    L5:
        if (r8 == null) goto L19;
        ArrayList r9 = new ArrayList();
        ArrayList r10 = new ArrayList();
        int r0 = 0;
        if (r6 != null) goto L9;
        int r1 = 0;
    L10:
        if (r0 >= r1) goto L13;
        r10.add(r6.keyAt(r0));
        r9.add(r6.valueAt(r0));
        r0 = r0 + 1;
        goto L10
    L13:
        if (r7 == false) goto L15;
        r8.onSharedElementStart(r10, r9, null);
        return;
    L15:
        r8.onSharedElementEnd(r10, r9, null);
        return;
    L9:
        r1 = r6.size();
        goto L10
    L19:
        return;
    L4:
        r8 = r3.getEnterTransitionCallback();
        goto L5
    }

    static String findKeyForValue(ArrayMap<String, String> r3, String r4) {
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (r4.equals(r3.valueAt(r1)) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r3.keyAt(r1);
    L9:
        return null;
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        return (FragmentTransitionImpl) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L4:
        return null;
    }

    static void retainValues(@NonNull ArrayMap<String, String> r2, @NonNull ArrayMap<String, View> r3) {
        int r0 = r2.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r3.containsKey(r2.valueAt(r0)) == true) goto L7;
        r2.removeAt(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    static void setViewVisibility(ArrayList<View> r2, int r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        int r0 = r2.size() - 1;
    L5:
        if (r0 < 0) goto L7;
        r2.get(r0).setVisibility(r3);
        r0 = r0 - 1;
        goto L5
    }

    static boolean supportsTransition() {
        if (PLATFORM_IMPL == null) goto L5;
    L8:
        return true;
    L5:
        if (SUPPORT_IMPL != null) goto L8;
        return false;
    }
}
