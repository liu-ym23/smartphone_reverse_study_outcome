package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;

    @Nullable
    private final Object mProvider;

    @RequiresApi(16)
    static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat mCompat;

        AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat r1) {
            this.mCompat = r1;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int r1) {
            AccessibilityNodeInfoCompat r0 = this.mCompat.createAccessibilityNodeInfo(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String r3, int r4) {
            List<AccessibilityNodeInfoCompat> r2 = this.mCompat.findAccessibilityNodeInfosByText(r3, r4);
            if (r2 != null) goto L6;
            return null;
        L6:
            ArrayList r5 = new ArrayList();
            int r6 = r2.size();
            int r0 = 0;
        L7:
            if (r0 >= r6) goto L9;
            r5.add(r2.get(r0).unwrap());
            r0 = r0 + 1;
            goto L7
        L9:
            return r5;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int r1, int r2, Bundle r3) {
            return this.mCompat.performAction(r1, r2, r3);
        }
    }

    @RequiresApi(19)
    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat r1) {
            super(r1);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int r1) {
            AccessibilityNodeInfoCompat r0 = this.mCompat.findFocus(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.unwrap();
        }
    }

    @RequiresApi(26)
    static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat r1) {
            super(r1);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int r1, AccessibilityNodeInfo r2, String r3, Bundle r4) {
            this.mCompat.addExtraDataToAccessibilityNodeInfo(r1, AccessibilityNodeInfoCompat.wrap(r2), r3, r4);
        }
    }

    public AccessibilityNodeProviderCompat() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L7;
        Object r1 = new AccessibilityNodeProviderApi26(this);
    L5:
        this.mProvider = r1;
        return;
    L7:
        if (r0 < 19) goto L10;
        r1 = new AccessibilityNodeProviderApi19(this);
        goto L5
    L10:
        if (r0 < 16) goto L12;
        r1 = new AccessibilityNodeProviderApi16(this);
        goto L5
    L12:
        r1 = null;
        goto L5
    }

    public AccessibilityNodeProviderCompat(@Nullable Object r1) {
        this.mProvider = r1;
    }

    public void addExtraDataToAccessibilityNodeInfo(int r1, @NonNull AccessibilityNodeInfoCompat r2, @NonNull String r3, @Nullable Bundle r4) {
    }

    @Nullable
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r1) {
        return null;
    }

    @Nullable
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(@NonNull String r1, int r2) {
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat findFocus(int r1) {
        return null;
    }

    @Nullable
    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int r1, int r2, @Nullable Bundle r3) {
        return false;
    }
}
