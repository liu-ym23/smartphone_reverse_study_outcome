package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityDelegateCompat {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = null;
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
        final AccessibilityDelegateCompat mCompat;

        AccessibilityDelegateAdapter(AccessibilityDelegateCompat r1) {
            this.mCompat = r1;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        @RequiresApi(16)
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View r1) {
            AccessibilityNodeProviderCompat r0 = this.mCompat.getAccessibilityNodeProvider(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return (AccessibilityNodeProvider) r0.getProvider();
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
            this.mCompat.onInitializeAccessibilityEvent(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r3, AccessibilityNodeInfo r4) {
            AccessibilityNodeInfoCompat r0 = AccessibilityNodeInfoCompat.wrap(r4);
            r0.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(r3));
            r0.setHeading(ViewCompat.isAccessibilityHeading(r3));
            r0.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(r3));
            r0.setStateDescription(ViewCompat.getStateDescription(r3));
            this.mCompat.onInitializeAccessibilityNodeInfo(r3, r0);
            r0.addSpansToExtras(r4.getText(), r3);
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r2 = AccessibilityDelegateCompat.getActionList(r3);
            int r5 = 0;
        L4:
            if (r5 >= r2.size()) goto L6;
            r0.addAction(r2.get(r5));
            r5 = r5 + 1;
            goto L4
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
            this.mCompat.onPopulateAccessibilityEvent(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup r1, View r2, AccessibilityEvent r3) {
            return this.mCompat.onRequestSendAccessibilityEvent(r1, r2, r3);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View r1, int r2, Bundle r3) {
            return this.mCompat.performAccessibilityAction(r1, r2, r3);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View r1, int r2) {
            this.mCompat.sendAccessibilityEvent(r1, r2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View r1, AccessibilityEvent r2) {
            this.mCompat.sendAccessibilityEventUnchecked(r1, r2);
        }
    }

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static AccessibilityNodeProvider getAccessibilityNodeProvider(View.AccessibilityDelegate r0, View r1) {
            return r0.getAccessibilityNodeProvider(r1);
        }

        @DoNotInline
        static boolean performAccessibilityAction(View.AccessibilityDelegate r0, View r1, int r2, Bundle r3) {
            return r0.performAccessibilityAction(r1, r2, r3);
        }
    }

    static {
        DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityDelegateCompat(@NonNull View.AccessibilityDelegate r1) {
        this.mOriginalDelegate = r1;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }

    static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View r1) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r2 = (List) r1.getTag(R.id.tag_accessibility_actions);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return Collections.emptyList();
    }

    private boolean isSpanStillValid(ClickableSpan r3, View r4) {
        if (r3 == null) goto L13;
        ClickableSpan[] r5 = AccessibilityNodeInfoCompat.getClickableSpans(r4.createAccessibilityNodeInfo().getText());
        int r0 = 0;
    L5:
        if (r5 == null) goto L13;
        if (r0 >= r5.length) goto L13;
        if (r3.equals(r5[r0]) == true) goto L10;
        r0 = r0 + 1;
        goto L5
    L10:
        return true;
    L13:
        return false;
    }

    private boolean performClickableSpanAction(int r2, View r3) {
        SparseArray r0 = (SparseArray) r3.getTag(R.id.tag_accessibility_clickable_spans);
        if (r0 == null) goto L10;
        WeakReference r4 = (WeakReference) r0.get(r2);
        if (r4 == null) goto L12;
        ClickableSpan r5 = (ClickableSpan) r4.get();
        if (isSpanStillValid(r5, r3) == false) goto L13;
        r5.onClick(r3);
        return true;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(@NonNull View r1, @NonNull AccessibilityEvent r2) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(r1, r2);
    }

    @Nullable
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View r3) {
        if (Build.VERSION.SDK_INT < 16) goto L8;
        AccessibilityNodeProvider r2 = Api16Impl.getAccessibilityNodeProvider(this.mOriginalDelegate, r3);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new AccessibilityNodeProviderCompat(r2);
    L8:
        return null;
    }

    View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(@NonNull View r1, @NonNull AccessibilityEvent r2) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(r1, r2);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull View r1, @NonNull AccessibilityNodeInfoCompat r2) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(r1, r2.unwrap());
    }

    public void onPopulateAccessibilityEvent(@NonNull View r1, @NonNull AccessibilityEvent r2) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(r1, r2);
    }

    public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup r1, @NonNull View r2, @NonNull AccessibilityEvent r3) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(r1, r2, r3);
    }

    public boolean performAccessibilityAction(@NonNull View r6, int r7, @Nullable Bundle r8) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r0 = getActionList(r6);
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L9;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r3 = r0.get(r2);
        if (r3.getId() == r7) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        r1 = r3.perform(r6, r8);
    L9:
        if (r1 == false) goto L11;
    L13:
        if (r1 == false) goto L15;
        return r1;
    L15:
        if (r7 != R.id.accessibility_action_clickable_span) goto L22;
        if (r8 != null) goto L18;
        return r1;
    L18:
        return performClickableSpanAction(r8.getInt(AccessibilityClickableSpanCompat.SPAN_ID, -1), r6);
    L22:
        return r1;
    L11:
        if (Build.VERSION.SDK_INT < 16) goto L13;
        r1 = Api16Impl.performAccessibilityAction(this.mOriginalDelegate, r6, r7, r8);
        goto L13
    }

    public void sendAccessibilityEvent(@NonNull View r1, int r2) {
        this.mOriginalDelegate.sendAccessibilityEvent(r1, r2);
    }

    public void sendAccessibilityEventUnchecked(@NonNull View r1, @NonNull AccessibilityEvent r2) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(r1, r2);
    }
}
