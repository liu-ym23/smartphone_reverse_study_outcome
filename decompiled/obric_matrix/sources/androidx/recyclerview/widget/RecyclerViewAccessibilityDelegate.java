package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    private final ItemDelegate mItemDelegate;
    final RecyclerView mRecyclerView;

    public static class ItemDelegate extends AccessibilityDelegateCompat {
        private Map<View, AccessibilityDelegateCompat> mOriginalItemDelegates;
        final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;

        public ItemDelegate(@NonNull RecyclerViewAccessibilityDelegate r2) {
            this.mOriginalItemDelegates = new WeakHashMap();
            this.mRecyclerViewDelegate = r2;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(@NonNull View r2, @NonNull AccessibilityEvent r3) {
            AccessibilityDelegateCompat r0 = this.mOriginalItemDelegates.get(r2);
            if (r0 == null) goto L7;
            return r0.dispatchPopulateAccessibilityEvent(r2, r3);
        L7:
            return super.dispatchPopulateAccessibilityEvent(r2, r3);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        @Nullable
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View r2) {
            AccessibilityDelegateCompat r0 = this.mOriginalItemDelegates.get(r2);
            if (r0 == null) goto L7;
            return r0.getAccessibilityNodeProvider(r2);
        L7:
            return super.getAccessibilityNodeProvider(r2);
        }

        AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View r1) {
            return this.mOriginalItemDelegates.remove(r1);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(@NonNull View r2, @NonNull AccessibilityEvent r3) {
            AccessibilityDelegateCompat r0 = this.mOriginalItemDelegates.get(r2);
            if (r0 == null) goto L5;
            r0.onInitializeAccessibilityEvent(r2, r3);
            return;
        L5:
            super.onInitializeAccessibilityEvent(r2, r3);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
            if (this.mRecyclerViewDelegate.shouldIgnore() == false) goto L5;
        L9:
            super.onInitializeAccessibilityNodeInfo(r2, r3);
            return;
        L5:
            if (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) goto L9;
            this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(r2, r3);
            AccessibilityDelegateCompat r0 = this.mOriginalItemDelegates.get(r2);
            if (r0 == null) goto L9;
            r0.onInitializeAccessibilityNodeInfo(r2, r3);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(@NonNull View r2, @NonNull AccessibilityEvent r3) {
            AccessibilityDelegateCompat r0 = this.mOriginalItemDelegates.get(r2);
            if (r0 == null) goto L5;
            r0.onPopulateAccessibilityEvent(r2, r3);
            return;
        L5:
            super.onPopulateAccessibilityEvent(r2, r3);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup r2, @NonNull View r3, @NonNull AccessibilityEvent r4) {
            AccessibilityDelegateCompat r0 = this.mOriginalItemDelegates.get(r2);
            if (r0 == null) goto L7;
            return r0.onRequestSendAccessibilityEvent(r2, r3, r4);
        L7:
            return super.onRequestSendAccessibilityEvent(r2, r3, r4);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r3, int r4, Bundle r5) {
            if (this.mRecyclerViewDelegate.shouldIgnore() == true) goto L17;
            if (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() == null) goto L17;
            AccessibilityDelegateCompat r0 = this.mOriginalItemDelegates.get(r3);
            if (r0 == null) goto L12;
            if (r0.performAccessibilityAction(r3, r4, r5) == false) goto L15;
            return true;
        L15:
            return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(r3, r4, r5);
        L12:
            if (super.performAccessibilityAction(r3, r4, r5) == false) goto L15;
            return true;
        L17:
            return super.performAccessibilityAction(r3, r4, r5);
        }

        void saveOriginalDelegate(View r2) {
            AccessibilityDelegateCompat r0 = ViewCompat.getAccessibilityDelegate(r2);
            if (r0 == null) goto L7;
            if (r0 == this) goto L8;
            this.mOriginalItemDelegates.put(r2, r0);
            return;
        L8:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEvent(@NonNull View r2, int r3) {
            AccessibilityDelegateCompat r0 = this.mOriginalItemDelegates.get(r2);
            if (r0 == null) goto L5;
            r0.sendAccessibilityEvent(r2, r3);
            return;
        L5:
            super.sendAccessibilityEvent(r2, r3);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void sendAccessibilityEventUnchecked(@NonNull View r2, @NonNull AccessibilityEvent r3) {
            AccessibilityDelegateCompat r0 = this.mOriginalItemDelegates.get(r2);
            if (r0 == null) goto L5;
            r0.sendAccessibilityEventUnchecked(r2, r3);
            return;
        L5:
            super.sendAccessibilityEventUnchecked(r2, r3);
        }
    }

    public RecyclerViewAccessibilityDelegate(@NonNull RecyclerView r2) {
        this.mRecyclerView = r2;
        AccessibilityDelegateCompat r3 = getItemDelegate();
        if (r3 != null) goto L5;
    L7:
        ItemDelegate r4 = new ItemDelegate(this);
    L8:
        this.mItemDelegate = r4;
        return;
    L5:
        if ((r3 instanceof ItemDelegate) == false) goto L7;
        r4 = (ItemDelegate) r3;
        goto L8
    }

    @NonNull
    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View r2, AccessibilityEvent r3) {
        super.onInitializeAccessibilityEvent(r2, r3);
        if ((r2 instanceof RecyclerView) == true) goto L5;
        return;
    L5:
        if (shouldIgnore() == true) goto L11;
        RecyclerView r4 = (RecyclerView) r2;
        if (r4.getLayoutManager() == null) goto L12;
        r4.getLayoutManager().onInitializeAccessibilityEvent(r3);
        return;
    L12:
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
        super.onInitializeAccessibilityNodeInfo(r1, r2);
        if (shouldIgnore() == false) goto L5;
        return;
    L5:
        if (this.mRecyclerView.getLayoutManager() == null) goto L9;
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(r2);
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View r1, int r2, Bundle r3) {
        if (super.performAccessibilityAction(r1, r2, r3) == false) goto L7;
        return true;
    L7:
        if (shouldIgnore() == false) goto L9;
        return false;
    L9:
        if (this.mRecyclerView.getLayoutManager() != null) goto L11;
        return false;
    L11:
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(r2, r3);
    }

    boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
