package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = null;
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = null;
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = null;
    int mAccessibilityFocusedVirtualViewId;
    private final View mHost;
    private int mHoveredVirtualViewId;
    int mKeyboardFocusedVirtualViewId;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;

    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        final /* synthetic */ ExploreByTouchHelper this$0;

        MyNodeProvider(ExploreByTouchHelper r1) {
            this.this$0 = r1;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r1) {
            return AccessibilityNodeInfoCompat.obtain(this.this$0.obtainAccessibilityNodeInfo(r1));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int r2) {
            if (r2 != 2) goto L5;
            int r3 = this.this$0.mAccessibilityFocusedVirtualViewId;
        L7:
            if (r3 != Integer.MIN_VALUE) goto L11;
            return null;
        L11:
            return createAccessibilityNodeInfo(r3);
        L5:
            r3 = this.this$0.mKeyboardFocusedVirtualViewId;
            goto L7
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int r1, int r2, Bundle r3) {
            return this.this$0.performAction(r1, r2, r3);
        }
    }

    static {
        INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        NODE_ADAPTER = new AnonymousClass1();
        SPARSE_VALUES_ADAPTER = new AnonymousClass2();
    }

    public ExploreByTouchHelper(@NonNull View r3) {
        this.mTempScreenRect = new Rect();
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHoveredVirtualViewId = Integer.MIN_VALUE;
        if (r3 == null) goto L9;
        this.mHost = r3;
        this.mManager = (AccessibilityManager) r3.getContext().getSystemService("accessibility");
        r3.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(r3) != 0) goto L10;
        ViewCompat.setImportantForAccessibility(r3, 1);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int r2) {
        if (this.mAccessibilityFocusedVirtualViewId != r2) goto L6;
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(r2, 65536);
        return true;
    L6:
        return false;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int r0 = this.mKeyboardFocusedVirtualViewId;
        if (r0 != Integer.MIN_VALUE) goto L5;
    L7:
        return false;
    L5:
        if (onPerformActionForVirtualView(r0, 16, null) == false) goto L7;
        return true;
    }

    private AccessibilityEvent createEvent(int r2, int r3) {
        if (r2 == (-1)) goto L7;
        return createEventForChild(r2, r3);
    L7:
        return createEventForHost(r3);
    }

    private AccessibilityEvent createEventForChild(int r4, int r5) {
        AccessibilityEvent r6 = AccessibilityEvent.obtain(r5);
        AccessibilityNodeInfoCompat r0 = obtainAccessibilityNodeInfo(r4);
        r6.getText().add(r0.getText());
        r6.setContentDescription(r0.getContentDescription());
        r6.setScrollable(r0.isScrollable());
        r6.setPassword(r0.isPassword());
        r6.setEnabled(r0.isEnabled());
        r6.setChecked(r0.isChecked());
        onPopulateEventForVirtualView(r4, r6);
        if (r6.getText().isEmpty() == true) goto L5;
    L9:
        r6.setClassName(r0.getClassName());
        AccessibilityRecordCompat.setSource(r6, this.mHost, r4);
        r6.setPackageName(this.mHost.getContext().getPackageName());
        return r6;
    L5:
        if (r6.getContentDescription() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent createEventForHost(int r1) {
        AccessibilityEvent r2 = AccessibilityEvent.obtain(r1);
        this.mHost.onInitializeAccessibilityEvent(r2);
        return r2;
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForChild(int r8) {
        AccessibilityNodeInfoCompat r0 = AccessibilityNodeInfoCompat.obtain();
        r0.setEnabled(true);
        r0.setFocusable(true);
        r0.setClassName(DEFAULT_CLASS_NAME);
        Rect r2 = INVALID_PARENT_BOUNDS;
        r0.setBoundsInParent(r2);
        r0.setBoundsInScreen(r2);
        r0.setParent(this.mHost);
        onPopulateNodeForVirtualView(r8, r0);
        if (r0.getText() == null) goto L5;
    L9:
        r0.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.equals(r2) == true) goto L50;
        int r3 = r0.getActions();
        if ((r3 & 64) != 0) goto L48;
        if ((r3 & 128) != 0) goto L46;
        r0.setPackageName(this.mHost.getContext().getPackageName());
        r0.setSource(this.mHost, r8);
        if (this.mAccessibilityFocusedVirtualViewId != r8) goto L18;
        r0.setAccessibilityFocused(true);
        r0.addAction(128);
    L20:
        if (this.mKeyboardFocusedVirtualViewId != r8) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L26;
        r0.addAction(2);
    L28:
        r0.setFocused(r9);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        r0.getBoundsInScreen(this.mTempScreenRect);
        if (this.mTempScreenRect.equals(r2) == false) goto L38;
        r0.getBoundsInParent(this.mTempScreenRect);
        if (r0.mParentVirtualDescendantId == (-1)) goto L36;
        AccessibilityNodeInfoCompat r10 = AccessibilityNodeInfoCompat.obtain();
        int r4 = r0.mParentVirtualDescendantId;
    L33:
        if (r4 == (-1)) goto L35;
        r10.setParent(this.mHost, -1);
        r10.setBoundsInParent(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(r4, r10);
        r10.getBoundsInParent(this.mTempParentRect);
        Rect r5 = this.mTempScreenRect;
        Rect r6 = this.mTempParentRect;
        r5.offset(r6.left, r6.top);
        r4 = r10.mParentVirtualDescendantId;
        goto L33
    L35:
        r10.recycle();
    L36:
        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
    L38:
        if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect) == false) goto L44;
        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        if (this.mTempScreenRect.intersect(this.mTempVisibleRect) == false) goto L44;
        r0.setBoundsInScreen(this.mTempScreenRect);
        if (isVisibleToUser(this.mTempScreenRect) == false) goto L44;
        r0.setVisibleToUser(true);
    L44:
        return r0;
    L26:
        if (r0.isFocusable() == false) goto L28;
        r0.addAction(1);
        goto L28
    L22:
        r9 = false;
        goto L23
    L18:
        r0.setAccessibilityFocused(false);
        r0.addAction(64);
        goto L20
    L46:
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L48:
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L50:
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    L5:
        if (r0.getContentDescription() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat r0 = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, r0);
        ArrayList r1 = new ArrayList();
        getVisibleVirtualViews(r1);
        if (r0.getChildCount() > 0) goto L5;
    L9:
        int r2 = 0;
        int r3 = r1.size();
    L10:
        if (r2 >= r3) goto L12;
        r0.addChild(this.mHost, ((Integer) r1.get(r2)).intValue());
        r2 = r2 + 1;
        goto L10
    L12:
        return r0;
    L5:
        if (r1.size() <= 0) goto L9;
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList r0 = new ArrayList();
        getVisibleVirtualViews(r0);
        SparseArrayCompat<AccessibilityNodeInfoCompat> r1 = new SparseArrayCompat();
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L6;
        AccessibilityNodeInfoCompat r3 = createNodeForChild(r0.get(r2).intValue());
        r1.put(r0.get(r2).intValue(), r3);
        r2 = r2 + 1;
        goto L4
    L6:
        return r1;
    }

    private void getBoundsInParent(int r1, Rect r2) {
        obtainAccessibilityNodeInfo(r1).getBoundsInParent(r2);
    }

    private static Rect guessPreviouslyFocusedRect(@NonNull View r4, int r5, @NonNull Rect r6) {
        int r0 = r4.getWidth();
        int r7 = r4.getHeight();
        if (r5 != 17) goto L5;
        r6.set(r0, 0, r0, r7);
    L16:
        return r6;
    L5:
        if (r5 != 33) goto L7;
        r6.set(0, r7, r0, r7);
        goto L16
    L7:
        if (r5 != 66) goto L9;
        r6.set(-1, 0, -1, r7);
        goto L16
    L9:
        if (r5 != 130) goto L12;
        r6.set(0, -1, r0, -1);
        goto L16
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private boolean isVisibleToUser(Rect r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.isEmpty() == false) goto L8;
        return false;
    L8:
        if (this.mHost.getWindowVisibility() == 0) goto L10;
        return false;
    L10:
        View r2 = this.mHost;
    L11:
        Object r4 = r2.getParent();
        if ((r4 instanceof View) == false) goto L18;
        r2 = (View) r4;
        if (r2.getAlpha() <= 0.0f) goto L17;
        if (r2.getVisibility() == 0) goto L11;
    L17:
        return false;
    L18:
        if (r4 == null) goto L26;
        return true;
    L26:
        return false;
    }

    private static int keyToDirection(int r1) {
        if (r1 != 19) goto L5;
        return 33;
    L5:
        if (r1 != 21) goto L7;
        return 17;
    L7:
        if (r1 == 22) goto L10;
        return 130;
    L10:
        return 66;
    }

    private boolean moveFocus(int r10, @Nullable Rect r11) {
        SparseArrayCompat<AccessibilityNodeInfoCompat> r7 = getAllNodes();
        int r0 = this.mKeyboardFocusedVirtualViewId;
        int r8 = Integer.MIN_VALUE;
        if (r0 != Integer.MIN_VALUE) goto L5;
        AccessibilityNodeInfoCompat r1 = null;
    L6:
        AccessibilityNodeInfoCompat r3 = r1;
        if (r10 == 1) goto L29;
        if (r10 == 2) goto L29;
        if (r10 != 17) goto L13;
    L21:
        Rect r4 = new Rect();
        int r2 = this.mKeyboardFocusedVirtualViewId;
        if (r2 == Integer.MIN_VALUE) goto L24;
        getBoundsInParent(r2, r4);
    L27:
        Object r12 = FocusStrategy.findNextFocusInAbsoluteDirection(r7, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, r3, r4, r10);
    L33:
        AccessibilityNodeInfoCompat r13 = (AccessibilityNodeInfoCompat) r12;
        if (r13 == null) goto L38;
        r8 = r7.keyAt(r7.indexOfValue(r13));
    L38:
        return requestKeyboardFocusForVirtualView(r8);
    L24:
        if (r11 == null) goto L26;
        r4.set(r11);
        goto L27
    L26:
        guessPreviouslyFocusedRect(this.mHost, r10, r4);
        goto L27
    L13:
        if (r10 == 33) goto L21;
        if (r10 == 66) goto L21;
        if (r10 == 130) goto L21;
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L29:
        if (ViewCompat.getLayoutDirection(this.mHost) != 1) goto L31;
        boolean r5 = true;
    L32:
        r12 = FocusStrategy.findNextFocusInRelativeDirection(r7, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, r3, r10, r5, false);
        goto L33
    L31:
        r5 = false;
        goto L32
    L5:
        r1 = r7.get(r0);
        goto L6
    }

    private boolean performActionForChild(int r2, int r3, Bundle r4) {
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L17;
        if (r3 == 64) goto L15;
        if (r3 == 128) goto L13;
        return onPerformActionForVirtualView(r2, r3, r4);
    L13:
        return clearAccessibilityFocus(r2);
    L15:
        return requestAccessibilityFocus(r2);
    L17:
        return clearKeyboardFocusForVirtualView(r2);
    L19:
        return requestKeyboardFocusForVirtualView(r2);
    }

    private boolean performActionForHost(int r1, Bundle r2) {
        return ViewCompat.performAccessibilityAction(this.mHost, r1, r2);
    }

    private boolean requestAccessibilityFocus(int r3) {
        if (this.mManager.isEnabled() == true) goto L5;
    L14:
        return false;
    L5:
        if (this.mManager.isTouchExplorationEnabled() == false) goto L14;
        int r0 = this.mAccessibilityFocusedVirtualViewId;
        if (r0 == r3) goto L14;
        if (r0 == Integer.MIN_VALUE) goto L12;
        clearAccessibilityFocus(r0);
    L12:
        this.mAccessibilityFocusedVirtualViewId = r3;
        this.mHost.invalidate();
        sendEventForVirtualView(r3, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int r3) {
        int r0 = this.mHoveredVirtualViewId;
        if (r0 != r3) goto L5;
        return;
    L5:
        this.mHoveredVirtualViewId = r3;
        sendEventForVirtualView(r3, 128);
        sendEventForVirtualView(r0, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int r3) {
        if (this.mKeyboardFocusedVirtualViewId == r3) goto L5;
        return false;
    L5:
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(r3, false);
        sendEventForVirtualView(r3, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent r6) {
        if (this.mManager.isEnabled() == true) goto L5;
        return false;
    L5:
        if (this.mManager.isTouchExplorationEnabled() == false) goto L25;
        int r0 = r6.getAction();
        if (r0 != 7) goto L10;
    L19:
        int r7 = getVirtualViewAt(r6.getX(), r6.getY());
        updateHoveredVirtualView(r7);
        if (r7 != Integer.MIN_VALUE) goto L22;
        return false;
    L22:
        return true;
    L10:
        if (r0 == 9) goto L19;
        if (r0 == 10) goto L15;
        return false;
    L15:
        if (this.mHoveredVirtualViewId == Integer.MIN_VALUE) goto L18;
        updateHoveredVirtualView(Integer.MIN_VALUE);
        return true;
    L18:
        return false;
    L25:
        return false;
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent r7) {
        int r1 = 0;
        if (r7.getAction() == 1) goto L32;
        int r0 = r7.getKeyCode();
        if (r0 == 61) goto L24;
        if (r0 == 66) goto L19;
        switch(r0) {
            case 19: goto L11;
            case 20: goto L11;
            case 21: goto L11;
            case 22: goto L11;
            case 23: goto L19;
            default: goto L40;
        };
    L40:
        return false;
    L11:
        if (r7.hasNoModifiers() == false) goto L33;
        int r2 = keyToDirection(r0);
        int r8 = r7.getRepeatCount() + 1;
        boolean r3 = false;
    L13:
        if (r1 >= r8) goto L34;
        if (moveFocus(r2, null) == false) goto L34;
        r1 = r1 + 1;
        r3 = true;
    L34:
        return r3;
    L33:
        return false;
    L19:
        if (r7.hasNoModifiers() == true) goto L21;
        return false;
    L21:
        if (r7.getRepeatCount() != 0) goto L36;
        clickKeyboardFocusedVirtualView();
        return true;
    L36:
        return false;
    L24:
        if (r7.hasNoModifiers() == false) goto L27;
        return moveFocus(2, null);
    L27:
        if (r7.hasModifiers(1) == true) goto L29;
        return false;
    L29:
        return moveFocus(1, null);
    L32:
        return false;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View r1) {
        if (this.mNodeProvider != null) goto L6;
        this.mNodeProvider = new MyNodeProvider(this);
    L6:
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    protected abstract int getVirtualViewAt(float r1, float r2);

    protected abstract void getVisibleVirtualViews(List<Integer> r1);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int r2) {
        invalidateVirtualView(r2, 0);
    }

    public final void invalidateVirtualView(int r3, int r4) {
        if (r3 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (this.mManager.isEnabled() == false) goto L11;
        ViewParent r0 = this.mHost.getParent();
        if (r0 == null) goto L12;
        AccessibilityEvent r5 = createEvent(r3, 2048);
        AccessibilityEventCompat.setContentChangeTypes(r5, r4);
        r0.requestSendAccessibilityEvent(this.mHost, r5);
        return;
    L12:
        return;
    }

    @NonNull
    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int r2) {
        if (r2 != (-1)) goto L7;
        return createNodeForHost();
    L7:
        return createNodeForChild(r2);
    }

    public final void onFocusChanged(boolean r3, int r4, @Nullable Rect r5) {
        int r0 = this.mKeyboardFocusedVirtualViewId;
        if (r0 == Integer.MIN_VALUE) goto L5;
        clearKeyboardFocusForVirtualView(r0);
    L5:
        if (r3 == false) goto L8;
        moveFocus(r4, r5);
        return;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
        super.onInitializeAccessibilityEvent(r1, r2);
        onPopulateEventForHost(r2);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
        super.onInitializeAccessibilityNodeInfo(r1, r2);
        onPopulateNodeForHost(r2);
    }

    protected abstract boolean onPerformActionForVirtualView(int r1, int r2, @Nullable Bundle r3);

    protected void onPopulateEventForHost(@NonNull AccessibilityEvent r1) {
    }

    protected void onPopulateEventForVirtualView(int r1, @NonNull AccessibilityEvent r2) {
    }

    protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat r1) {
    }

    protected abstract void onPopulateNodeForVirtualView(int r1, @NonNull AccessibilityNodeInfoCompat r2);

    protected void onVirtualViewKeyboardFocusChanged(int r1, boolean r2) {
    }

    boolean performAction(int r2, int r3, Bundle r4) {
        if (r2 == (-1)) goto L7;
        return performActionForChild(r2, r3, r4);
    L7:
        return performActionForHost(r3, r4);
    }

    public final boolean requestKeyboardFocusForVirtualView(int r4) {
        if (this.mHost.isFocused() == false) goto L5;
    L7:
        int r0 = this.mKeyboardFocusedVirtualViewId;
        if (r0 != r4) goto L11;
        return false;
    L11:
        if (r0 == Integer.MIN_VALUE) goto L13;
        clearKeyboardFocusForVirtualView(r0);
    L13:
        if (r4 != Integer.MIN_VALUE) goto L15;
        return false;
    L15:
        this.mKeyboardFocusedVirtualViewId = r4;
        onVirtualViewKeyboardFocusChanged(r4, true);
        sendEventForVirtualView(r4, 8);
        return true;
    L5:
        if (this.mHost.requestFocus() == true) goto L7;
        return false;
    }

    public final boolean sendEventForVirtualView(int r3, int r4) {
        if (r3 != Integer.MIN_VALUE) goto L5;
    L12:
        return false;
    L5:
        if (this.mManager.isEnabled() == false) goto L12;
        ViewParent r1 = this.mHost.getParent();
        if (r1 != null) goto L10;
        return false;
    L10:
        AccessibilityEvent r5 = createEvent(r3, r4);
        return r1.requestSendAccessibilityEvent(this.mHost, r5);
    }
}
