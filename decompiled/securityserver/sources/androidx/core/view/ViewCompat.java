package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.SimpleArrayMap;
import androidx.core.R;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ViewCompat {
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = null;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;

    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;

    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;

    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;

    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;

    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;

    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;

    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;

    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;

    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;

    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static boolean sAccessibilityDelegateCheckFailed;
    private static Field sAccessibilityDelegateField;
    private static AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static final AtomicInteger sNextGeneratedId = null;
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;

    public static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private WeakHashMap<View, Boolean> mPanesToVisible;

        public AccessibilityPaneVisibilityManager() {
            this.mPanesToVisible = new WeakHashMap();
        }

        @RequiresApi(19)
        private void checkPaneVisibility(View r2, boolean r3) {
            if (r2.getVisibility() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r3 == r0) goto L11;
            if (r0 == false) goto L9;
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r2, 16);
        L9:
            this.mPanesToVisible.put(r2, Boolean.valueOf(r0));
            return;
        L11:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @RequiresApi(19)
        private void registerForLayoutCallback(View r1) {
            r1.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        private void unregisterForLayoutCallback(View r1) {
            r1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        public void addAccessibilityPane(View r3) {
            WeakHashMap<View, Boolean> r0 = this.mPanesToVisible;
            if (r3.getVisibility() != 0) goto L5;
            boolean r1 = true;
        L6:
            r0.put(r3, Boolean.valueOf(r1));
            r3.addOnAttachStateChangeListener(this);
            if (r3.isAttachedToWindow() == false) goto L10;
            registerForLayoutCallback(r3);
            return;
        L10:
            return;
        L5:
            r1 = false;
            goto L6
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(19)
        public void onGlobalLayout() {
            Iterator<Map.Entry<View, Boolean>> r0 = this.mPanesToVisible.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Map.Entry<View, Boolean> r1 = r0.next();
            checkPaneVisibility(r1.getKey(), r1.getValue().booleanValue());
            goto L4
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @RequiresApi(19)
        public void onViewAttachedToWindow(View r1) {
            registerForLayoutCallback(r1);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r1) {
        }

        @RequiresApi(19)
        public void removeAccessibilityPane(View r2) {
            this.mPanesToVisible.remove(r2);
            r2.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(r2);
        }
    }

    public static abstract class AccessibilityViewProperty<T> {
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;

        public AccessibilityViewProperty(int r2, Class<T> r3, int r4) {
            this(r2, r3, 0, r4);
        }

        private boolean extrasAvailable() {
            return true;
        }

        private boolean frameworkAvailable() {
            if (Build.VERSION.SDK_INT < this.mFrameworkMinimumSdk) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean booleanNullToFalseEquals(Boolean r1, Boolean r2) {
            if (r1 != null) goto L5;
            boolean r3 = false;
        L6:
            if (r2 != null) goto L8;
            boolean r4 = false;
        L9:
            if (r3 != r4) goto L12;
            return true;
        L12:
            return false;
        L8:
            r4 = r2.booleanValue();
            goto L9
        L5:
            r3 = r1.booleanValue();
            goto L6
        }

        public abstract T frameworkGet(View r1);

        public abstract void frameworkSet(View r1, T r2);

        public T get(View r2) {
            if (frameworkAvailable() == false) goto L7;
            return frameworkGet(r2);
        L7:
            if (extrasAvailable() == false) goto L11;
            T r3 = (T) r2.getTag(this.mTagKey);
            if (this.mType.isInstance(r3) == false) goto L13;
            return r3;
        L13:
            return null;
        L11:
            return null;
        }

        public void set(View r2, T r3) {
            if (frameworkAvailable() == false) goto L6;
            frameworkSet(r2, r3);
            return;
        L6:
            if (extrasAvailable() == true) goto L8;
            return;
        L8:
            if (shouldUpdate(get(r2), r3) == false) goto L13;
            ViewCompat.getOrCreateAccessibilityDelegateCompat(r2);
            r2.setTag(this.mTagKey, r3);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r2, 0);
            return;
        }

        public boolean shouldUpdate(T r1, T r2) {
            return !r2.equals(r1);
        }

        public AccessibilityViewProperty(int r1, Class<T> r2, int r3, int r4) {
            this.mTagKey = r1;
            this.mType = r2;
            this.mFrameworkMinimumSdk = r4;
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View r1, @NonNull WindowInsetsCompat r2, @NonNull Rect r3) {
            WindowInsets r0 = r2.toWindowInsets();
            if (r0 != null) goto L5;
            r3.setEmpty();
            return r2;
        L5:
            return WindowInsetsCompat.toWindowInsetsCompat(r1.computeSystemWindowInsets(r0, r3));
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static WindowInsets getRootWindowInsets(View r0) {
            return r0.getRootWindowInsets();
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void saveAttributeDataForStyleable(@NonNull View r0, @NonNull Context r1, @NonNull int[] r2, @Nullable AttributeSet r3, @NonNull TypedArray r4, int r5, int r6) {
            r0.saveAttributeDataForStyleable(r1, r2, r3, r4, r5, r6);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusRealDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NestedScrollType {
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(View r1, KeyEvent r2);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollIndicators {
    }

    public static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = null;
        private SparseArray<WeakReference<View>> mCapturedKeys;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent;

        @Nullable
        private WeakHashMap<View, Boolean> mViewsContainingListeners;

        static {
            sViewsWithListeners = new ArrayList();
        }

        public UnhandledKeyEventManager() {
            this.mViewsContainingListeners = null;
            this.mCapturedKeys = null;
            this.mLastDispatchedPreViewKeyEvent = null;
        }

        public static UnhandledKeyEventManager at(View r2) {
            UnhandledKeyEventManager r0 = (UnhandledKeyEventManager) r2.getTag(R.id.tag_unhandled_key_event_manager);
            if (r0 != null) goto L6;
            UnhandledKeyEventManager r1 = new UnhandledKeyEventManager();
            r2.setTag(R.id.tag_unhandled_key_event_manager, r1);
            return r1;
        L6:
            return r0;
        }

        @Nullable
        private View dispatchInOrder(View r5, KeyEvent r6) {
            WeakHashMap<View, Boolean> r0 = this.mViewsContainingListeners;
            if (r0 != null) goto L5;
        L18:
            return null;
        L5:
            if (r0.containsKey(r5) == false) goto L18;
            if ((r5 instanceof ViewGroup) == false) goto L16;
            ViewGroup r1 = (ViewGroup) r5;
            int r2 = r1.getChildCount() - 1;
        L10:
            if (r2 < 0) goto L16;
            View r3 = dispatchInOrder(r1.getChildAt(r2), r6);
            if (r3 != null) goto L13;
            r2 = r2 - 1;
            goto L10
        L13:
            return r3;
        L16:
            if (onUnhandledKeyEvent(r5, r6) == false) goto L18;
            return r5;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys != null) goto L6;
            this.mCapturedKeys = new SparseArray();
        L6:
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(@NonNull View r4, @NonNull KeyEvent r5) {
            ArrayList r3 = (ArrayList) r4.getTag(R.id.tag_unhandled_key_listeners);
            if (r3 == null) goto L10;
            int r0 = r3.size() - 1;
        L5:
            if (r0 < 0) goto L14;
            if (((OnUnhandledKeyEventListenerCompat) r3.get(r0)).onUnhandledKeyEvent(r4, r5) == true) goto L8;
            r0 = r0 - 1;
            goto L5
        L8:
            return true;
        L14:
            return false;
        L10:
            return false;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap<View, Boolean> r0 = this.mViewsContainingListeners;
            if (r0 == null) goto L5;
            r0.clear();
        L5:
            ArrayList<WeakReference<View>> r1 = sViewsWithListeners;
            if (r1.isEmpty() == false) goto L8;
            return;
        L8:
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L10:
            if (this.mViewsContainingListeners != null) goto L14;
            this.mViewsContainingListeners = new WeakHashMap();     // Catch: Throwable -> L12
        L14:
            int r2 = r1.size() - 1;     // Catch: Throwable -> L12
        L15:
            if (r2 < 0) goto L24;
            ArrayList<WeakReference<View>> r3 = sViewsWithListeners;     // Catch: Throwable -> L12
            View r4 = r3.get(r2).get();     // Catch: Throwable -> L12
            if (r4 != null) goto L19;
            r3.remove(r2);     // Catch: Throwable -> L12
        L23:
            r2 = r2 - 1;     // Catch: Throwable -> L12
            goto L15
        L19:
            this.mViewsContainingListeners.put(r4, Boolean.TRUE);     // Catch: Throwable -> L12
            ViewParent r5 = r4.getParent();     // Catch: Throwable -> L12
        L21:
            if ((r5 instanceof View) == false) goto L23;
            this.mViewsContainingListeners.put((View) r5, Boolean.TRUE);     // Catch: Throwable -> L12
            r5 = r5.getParent();     // Catch: Throwable -> L12
            goto L21
        L24:
            monitor-exit(r1);     // Catch: Throwable -> L12
        }

        public static void registerListeningView(View r3) {
            ArrayList<WeakReference<View>> r0 = sViewsWithListeners;
            monitor-enter(r0);
            Iterator<WeakReference<View>> r1 = r0.iterator();     // Catch: Throwable -> L11
        L6:
            if (r1.hasNext() == false) goto L13;
            if (r1.next().get() != r3) goto L6;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            sViewsWithListeners.add(new WeakReference(r3));     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public static void unregisterListeningView(View r4) {
            ArrayList<WeakReference<View>> r0 = sViewsWithListeners;
            monitor-enter(r0);
            int r1 = 0;
        L19:
            ArrayList<WeakReference<View>> r2 = sViewsWithListeners;     // Catch: Throwable -> L12
            if (r1 >= r2.size()) goto L15;
            if (r2.get(r1).get() == r4) goto L9;
            r1 = r1 + 1;     // Catch: Throwable -> L12
            goto L19
        L9:
            r2.remove(r1);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public boolean dispatch(View r2, KeyEvent r3) {
            if (r3.getAction() != 0) goto L5;
            recalcViewsWithUnhandled();
        L5:
            View r4 = dispatchInOrder(r2, r3);
            if (r3.getAction() != 0) goto L12;
            int r5 = r3.getKeyCode();
            if (r4 == null) goto L12;
            if (KeyEvent.isModifierKey(r5) == true) goto L12;
            getCapturedKeys().put(r5, new WeakReference(r4));
        L12:
            if (r4 == null) goto L14;
            return true;
        L14:
            return false;
        }

        public boolean preDispatch(KeyEvent r6) {
            WeakReference<KeyEvent> r0 = this.mLastDispatchedPreViewKeyEvent;
            if (r0 != null) goto L5;
        L7:
            this.mLastDispatchedPreViewKeyEvent = new WeakReference(r6);
            SparseArray<WeakReference<View>> r1 = getCapturedKeys();
            if (r6.getAction() != 1) goto L12;
            int r2 = r1.indexOfKey(r6.getKeyCode());
            if (r2 < 0) goto L12;
            WeakReference<View> r4 = r1.valueAt(r2);
            r1.removeAt(r2);
        L13:
            if (r4 != null) goto L15;
            r4 = r1.get(r6.getKeyCode());
        L15:
            if (r4 == null) goto L22;
            View r3 = r4.get();
            if (r3 != null) goto L19;
        L21:
            return true;
        L19:
            if (ViewCompat.isAttachedToWindow(r3) == false) goto L21;
            onUnhandledKeyEvent(r3, r6);
            goto L21
        L22:
            return false;
        L12:
            r4 = null;
            goto L13
        L5:
            if (r0.get() != r6) goto L7;
            return false;
        }
    }

    static {
        sNextGeneratedId = new AtomicInteger(1);
        sViewPropertyAnimatorMap = null;
        sAccessibilityDelegateCheckFailed = false;
        ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    public ViewCompat() {
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        final int r1 = R.id.tag_accessibility_heading;
        final Class<Boolean> r2 = Boolean.class;
        final int r3 = 28;
        return new AnonymousClass5(r1, r2, r3);
    }

    public static int addAccessibilityAction(@NonNull View r2, @NonNull CharSequence r3, @NonNull AccessibilityViewCommand r4) {
        int r0 = getAvailableActionIdFromResources(r2);
        if (r0 == (-1)) goto L5;
        addAccessibilityAction(r2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r0, r3, r4));
    L5:
        return r0;
    }

    public static void addKeyboardNavigationClusters(@NonNull View r0, @NonNull Collection<View> r1, int r2) {
        r0.addKeyboardNavigationClusters(r1, r2);
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View r2, @NonNull final OnUnhandledKeyEventListenerCompat r3) {
        SimpleArrayMap r0 = (SimpleArrayMap) r2.getTag(R.id.tag_unhandled_key_listeners);
        if (r0 != null) goto L5;
        r0 = new SimpleArrayMap();
        r2.setTag(R.id.tag_unhandled_key_listeners, r0);
    L5:
        View.OnUnhandledKeyEventListener r1 = new AnonymousClass2(r3);
        r0.put(r3, r1);
        r2.addOnUnhandledKeyEventListener(r1);
    }

    @NonNull
    public static ViewPropertyAnimatorCompat animate(@NonNull View r2) {
        if (sViewPropertyAnimatorMap != null) goto L5;
        sViewPropertyAnimatorMap = new WeakHashMap();
    L5:
        ViewPropertyAnimatorCompat r0 = sViewPropertyAnimatorMap.get(r2);
        if (r0 != null) goto L9;
        ViewPropertyAnimatorCompat r1 = new ViewPropertyAnimatorCompat(r2);
        sViewPropertyAnimatorMap.put(r2, r1);
        return r1;
    L9:
        return r0;
    }

    private static void bindTempDetach() {
        sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", null);     // Catch: NoSuchMethodException -> L5
        sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", null);     // Catch: NoSuchMethodException -> L5
    L7:
        sTempDetachBound = true;
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Couldn't find method", e);
        goto L7
    }

    @Deprecated
    public static boolean canScrollHorizontally(View r0, int r1) {
        return r0.canScrollHorizontally(r1);
    }

    @Deprecated
    public static boolean canScrollVertically(View r0, int r1) {
        return r0.canScrollVertically(r1);
    }

    public static void cancelDragAndDrop(@NonNull View r0) {
        r0.cancelDragAndDrop();
    }

    @Deprecated
    public static int combineMeasuredStates(int r0, int r1) {
        return View.combineMeasuredStates(r0, r1);
    }

    private static void compatOffsetLeftAndRight(View r0, int r1) {
        r0.offsetLeftAndRight(r1);
        if (r0.getVisibility() != 0) goto L8;
        tickleInvalidationFlag(r0);
        Object r2 = r0.getParent();
        if ((r2 instanceof View) == false) goto L9;
        tickleInvalidationFlag((View) r2);
        return;
    L9:
        return;
    }

    private static void compatOffsetTopAndBottom(View r0, int r1) {
        r0.offsetTopAndBottom(r1);
        if (r0.getVisibility() != 0) goto L8;
        tickleInvalidationFlag(r0);
        Object r2 = r0.getParent();
        if ((r2 instanceof View) == false) goto L9;
        tickleInvalidationFlag((View) r2);
        return;
    L9:
        return;
    }

    @NonNull
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View r0, @NonNull WindowInsetsCompat r1, @NonNull Rect r2) {
        return Api21Impl.computeSystemWindowInsets(r0, r1, r2);
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View r1, @NonNull WindowInsetsCompat r2) {
        WindowInsets r0 = r2.toWindowInsets();
        if (r0 != null) goto L5;
    L8:
        return r2;
    L5:
        if (r1.dispatchApplyWindowInsets(r0).equals(r0) == true) goto L8;
        return WindowInsetsCompat.toWindowInsetsCompat(r0);
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View r0) {
        r0.dispatchFinishTemporaryDetach();
    }

    public static boolean dispatchNestedFling(@NonNull View r0, float r1, float r2, boolean r3) {
        return r0.dispatchNestedFling(r1, r2, r3);
    }

    public static boolean dispatchNestedPreFling(@NonNull View r0, float r1, float r2) {
        return r0.dispatchNestedPreFling(r1, r2);
    }

    public static boolean dispatchNestedPreScroll(@NonNull View r0, int r1, int r2, @Nullable int[] r3, @Nullable int[] r4) {
        return r0.dispatchNestedPreScroll(r1, r2, r3, r4);
    }

    public static boolean dispatchNestedScroll(@NonNull View r0, int r1, int r2, int r3, int r4, @Nullable int[] r5) {
        return r0.dispatchNestedScroll(r1, r2, r3, r4, r5);
    }

    public static void dispatchStartTemporaryDetach(@NonNull View r0) {
        r0.dispatchStartTemporaryDetach();
    }

    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeCallback(View r0, KeyEvent r1) {
        return false;
    }

    @UiThread
    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(View r0, KeyEvent r1) {
        return false;
    }

    public static void enableAccessibleClickableSpanSupport(View r0) {
        getOrCreateAccessibilityDelegateCompat(r0);
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    @Nullable
    public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View r1) {
        View.AccessibilityDelegate r2 = getAccessibilityDelegateInternal(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        if ((r2 instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) == false) goto L11;
        return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) r2).mCompat;
    L11:
        return new AccessibilityDelegateCompat(r2);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View r0) {
        return r0.getAccessibilityDelegate();
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(@NonNull View r4) {
        if (sAccessibilityDelegateCheckFailed == false) goto L6;
        return null;
    L6:
        if (sAccessibilityDelegateField != null) goto L20;
        Field r0 = View.class.getDeclaredField("mAccessibilityDelegate");     // Catch: Throwable -> L9
        sAccessibilityDelegateField = r0;     // Catch: Throwable -> L9
        r0.setAccessible(true);     // Catch: Throwable -> L9
    L9:
        sAccessibilityDelegateCheckFailed = true;
        return null;
    L20:
        Object r5 = sAccessibilityDelegateField.get(r4);     // Catch: Throwable -> L16
        if ((r5 instanceof View.AccessibilityDelegate) == false) goto L15;
        return (View.AccessibilityDelegate) r5;
    L15:
        return null;
    L16:
        sAccessibilityDelegateCheckFailed = true;
        return null;
    }

    public static int getAccessibilityLiveRegion(@NonNull View r0) {
        return r0.getAccessibilityLiveRegion();
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View r1) {
        AccessibilityNodeProvider r2 = r1.getAccessibilityNodeProvider();
        if (r2 != null) goto L5;
        return null;
    L5:
        return new AccessibilityNodeProviderCompat(r2);
    }

    @UiThread
    public static CharSequence getAccessibilityPaneTitle(View r1) {
        return paneTitleProperty().get(r1);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View r2) {
        ArrayList r0 = (ArrayList) r2.getTag(R.id.tag_accessibility_actions);
        if (r0 != null) goto L6;
        ArrayList r1 = new ArrayList();
        r2.setTag(R.id.tag_accessibility_actions, r1);
        return r1;
    L6:
        return r0;
    }

    @Deprecated
    public static float getAlpha(View r0) {
        return r0.getAlpha();
    }

    private static int getAvailableActionIdFromResources(View r9) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r10 = getActionList(r9);
        int r3 = -1;
        int r2 = 0;
    L3:
        int[] r4 = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
        if (r2 >= r4.length) goto L17;
        if (r3 != (-1)) goto L17;
        int r5 = r4[r2];
        int r6 = 0;
        boolean r7 = true;
    L8:
        if (r6 >= r10.size()) goto L14;
        if (r10.get(r6).getId() == r5) goto L12;
        boolean r8 = true;
    L13:
        r7 = r7 & r8;
        r6 = r6 + 1;
        goto L8
    L12:
        r8 = false;
        goto L13
    L14:
        if (r7 == false) goto L16;
        r3 = r5;
    L16:
        r2 = r2 + 1;
    L17:
        return r3;
    }

    public static ColorStateList getBackgroundTintList(@NonNull View r0) {
        return r0.getBackgroundTintList();
    }

    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View r0) {
        return r0.getBackgroundTintMode();
    }

    @Nullable
    public static Rect getClipBounds(@NonNull View r0) {
        return r0.getClipBounds();
    }

    @Nullable
    public static Display getDisplay(@NonNull View r0) {
        return r0.getDisplay();
    }

    public static float getElevation(@NonNull View r0) {
        return r0.getElevation();
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect != null) goto L5;
        sThreadLocalRect = new ThreadLocal();
    L5:
        Rect r0 = sThreadLocalRect.get();
        if (r0 != null) goto L8;
        r0 = new Rect();
        sThreadLocalRect.set(r0);
    L8:
        r0.setEmpty();
        return r0;
    }

    public static boolean getFitsSystemWindows(@NonNull View r0) {
        return r0.getFitsSystemWindows();
    }

    public static int getImportantForAccessibility(@NonNull View r0) {
        return r0.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View r0) {
        return r0.getImportantForAutofill();
    }

    public static int getLabelFor(@NonNull View r0) {
        return r0.getLabelFor();
    }

    @Deprecated
    public static int getLayerType(View r0) {
        return r0.getLayerType();
    }

    public static int getLayoutDirection(@NonNull View r0) {
        return r0.getLayoutDirection();
    }

    @Nullable
    @Deprecated
    public static Matrix getMatrix(View r0) {
        return r0.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View r0) {
        return r0.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View r0) {
        return r0.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View r0) {
        return r0.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(@NonNull View r0) {
        return r0.getMinimumHeight();
    }

    public static int getMinimumWidth(@NonNull View r0) {
        return r0.getMinimumWidth();
    }

    public static int getNextClusterForwardId(@NonNull View r0) {
        return r0.getNextClusterForwardId();
    }

    public static AccessibilityDelegateCompat getOrCreateAccessibilityDelegateCompat(@NonNull View r1) {
        AccessibilityDelegateCompat r0 = getAccessibilityDelegate(r1);
        if (r0 != null) goto L5;
        r0 = new AccessibilityDelegateCompat();
    L5:
        setAccessibilityDelegate(r1, r0);
        return r0;
    }

    @Deprecated
    public static int getOverScrollMode(View r0) {
        return r0.getOverScrollMode();
    }

    @Px
    public static int getPaddingEnd(@NonNull View r0) {
        return r0.getPaddingEnd();
    }

    @Px
    public static int getPaddingStart(@NonNull View r0) {
        return r0.getPaddingStart();
    }

    public static ViewParent getParentForAccessibility(@NonNull View r0) {
        return r0.getParentForAccessibility();
    }

    @Deprecated
    public static float getPivotX(View r0) {
        return r0.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View r0) {
        return r0.getPivotY();
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View r0) {
        return WindowInsetsCompat.toWindowInsetsCompat(Api23Impl.getRootWindowInsets(r0));
    }

    @Deprecated
    public static float getRotation(View r0) {
        return r0.getRotation();
    }

    @Deprecated
    public static float getRotationX(View r0) {
        return r0.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View r0) {
        return r0.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View r0) {
        return r0.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View r0) {
        return r0.getScaleY();
    }

    public static int getScrollIndicators(@NonNull View r0) {
        return r0.getScrollIndicators();
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View r0) {
        return r0.getSystemGestureExclusionRects();
    }

    @Nullable
    public static String getTransitionName(@NonNull View r0) {
        return r0.getTransitionName();
    }

    @Deprecated
    public static float getTranslationX(View r0) {
        return r0.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View r0) {
        return r0.getTranslationY();
    }

    public static float getTranslationZ(@NonNull View r0) {
        return r0.getTranslationZ();
    }

    public static int getWindowSystemUiVisibility(@NonNull View r0) {
        return r0.getWindowSystemUiVisibility();
    }

    @Deprecated
    public static float getX(View r0) {
        return r0.getX();
    }

    @Deprecated
    public static float getY(View r0) {
        return r0.getY();
    }

    public static float getZ(@NonNull View r0) {
        return r0.getZ();
    }

    public static boolean hasAccessibilityDelegate(@NonNull View r0) {
        if (getAccessibilityDelegateInternal(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasExplicitFocusable(@NonNull View r0) {
        return r0.hasExplicitFocusable();
    }

    public static boolean hasNestedScrollingParent(@NonNull View r0) {
        return r0.hasNestedScrollingParent();
    }

    public static boolean hasOnClickListeners(@NonNull View r0) {
        return r0.hasOnClickListeners();
    }

    public static boolean hasOverlappingRendering(@NonNull View r0) {
        return r0.hasOverlappingRendering();
    }

    public static boolean hasTransientState(@NonNull View r0) {
        return r0.hasTransientState();
    }

    @UiThread
    public static boolean isAccessibilityHeading(View r1) {
        Boolean r2 = accessibilityHeadingProperty().get(r1);
        if (r2 != null) goto L6;
        return false;
    L6:
        return r2.booleanValue();
    }

    public static boolean isAttachedToWindow(@NonNull View r0) {
        return r0.isAttachedToWindow();
    }

    public static boolean isFocusedByDefault(@NonNull View r0) {
        return r0.isFocusedByDefault();
    }

    public static boolean isImportantForAccessibility(@NonNull View r0) {
        return r0.isImportantForAccessibility();
    }

    public static boolean isImportantForAutofill(@NonNull View r0) {
        return r0.isImportantForAutofill();
    }

    public static boolean isInLayout(@NonNull View r0) {
        return r0.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View r0) {
        return r0.isKeyboardNavigationCluster();
    }

    public static boolean isLaidOut(@NonNull View r0) {
        return r0.isLaidOut();
    }

    public static boolean isLayoutDirectionResolved(@NonNull View r0) {
        return r0.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(@NonNull View r0) {
        return r0.isNestedScrollingEnabled();
    }

    @Deprecated
    public static boolean isOpaque(View r0) {
        return r0.isOpaque();
    }

    public static boolean isPaddingRelative(@NonNull View r0) {
        return r0.isPaddingRelative();
    }

    @UiThread
    public static boolean isScreenReaderFocusable(View r1) {
        Boolean r2 = screenReaderFocusableProperty().get(r1);
        if (r2 != null) goto L6;
        return false;
    L6:
        return r2.booleanValue();
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View r0) {
        r0.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(@NonNull View r0, View r1, int r2) {
        return r0.keyboardNavigationClusterSearch(r1, r2);
    }

    @RequiresApi(19)
    public static void notifyViewAccessibilityStateChangedIfNeeded(View r2, int r3) {
        if (((AccessibilityManager) r2.getContext().getSystemService("accessibility")).isEnabled() == true) goto L6;
        return;
    L6:
        if (getAccessibilityPaneTitle(r2) == null) goto L8;
        boolean r0 = true;
    L10:
        if (getAccessibilityLiveRegion(r2) != 0) goto L21;
        if (r0 == false) goto L16;
        if (r2.getVisibility() == 0) goto L21;
    L16:
        if (r2.getParent() == null) goto L29;
        r2.getParent().notifySubtreeAccessibilityStateChanged(r2, r2, r3);     // Catch: AbstractMethodError -> L19
        return;
    L19:
        e = move-exception;
        Log.e(TAG, r2.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e);
        return;
    L29:
        return;
    L21:
        AccessibilityEvent r1 = AccessibilityEvent.obtain();
        if (r0 == false) goto L24;
        int r4 = 32;
    L25:
        r1.setEventType(r4);
        r1.setContentChangeTypes(r3);
        r2.sendAccessibilityEventUnchecked(r1);
        return;
    L24:
        r4 = 2048;
        goto L25
    L8:
        r0 = false;
        goto L10
    }

    public static void offsetLeftAndRight(@NonNull View r0, int r1) {
        r0.offsetLeftAndRight(r1);
    }

    public static void offsetTopAndBottom(@NonNull View r0, int r1) {
        r0.offsetTopAndBottom(r1);
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View r1, @NonNull WindowInsetsCompat r2) {
        WindowInsets r0 = r2.toWindowInsets();
        if (r0 == null) goto L8;
        WindowInsets r3 = r1.onApplyWindowInsets(r0);
        if (r3.equals(r0) == true) goto L8;
        return WindowInsetsCompat.toWindowInsetsCompat(r3);
    L8:
        return r2;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View r0, AccessibilityEvent r1) {
        r0.onInitializeAccessibilityEvent(r1);
    }

    public static void onInitializeAccessibilityNodeInfo(@NonNull View r0, AccessibilityNodeInfoCompat r1) {
        r0.onInitializeAccessibilityNodeInfo(r1.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View r0, AccessibilityEvent r1) {
        r0.onPopulateAccessibilityEvent(r1);
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        final int r1 = R.id.tag_accessibility_pane_title;
        final int r2 = 8;
        final int r3 = 28;
        final Class<CharSequence> r4 = CharSequence.class;
        return new AnonymousClass4(r1, r4, r2, r3);
    }

    public static boolean performAccessibilityAction(@NonNull View r0, int r1, Bundle r2) {
        return r0.performAccessibilityAction(r1, r2);
    }

    public static void postInvalidateOnAnimation(@NonNull View r0) {
        r0.postInvalidateOnAnimation();
    }

    public static void postOnAnimation(@NonNull View r0, Runnable r1) {
        r0.postOnAnimation(r1);
    }

    public static void postOnAnimationDelayed(@NonNull View r0, Runnable r1, long r2) {
        r0.postOnAnimationDelayed(r1, r2);
    }

    public static void removeAccessibilityAction(@NonNull View r0, int r1) {
        removeActionWithId(r1, r0);
        notifyViewAccessibilityStateChangedIfNeeded(r0, 0);
    }

    private static void removeActionWithId(int r2, View r3) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r4 = getActionList(r3);
        int r0 = 0;
    L4:
        if (r0 >= r4.size()) goto L12;
        if (r4.get(r0).getId() == r2) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        r4.remove(r0);
        return;
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View r1, @NonNull OnUnhandledKeyEventListenerCompat r2) {
        SimpleArrayMap r0 = (SimpleArrayMap) r1.getTag(R.id.tag_unhandled_key_listeners);
        if (r0 != null) goto L5;
        return;
    L5:
        View.OnUnhandledKeyEventListener r3 = (View.OnUnhandledKeyEventListener) r0.get(r2);
        if (r3 == null) goto L9;
        r1.removeOnUnhandledKeyEventListener(r3);
        return;
    }

    public static void replaceAccessibilityAction(@NonNull View r0, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat r1, @Nullable CharSequence r2, @Nullable AccessibilityViewCommand r3) {
        if (r3 != null) goto L5;
        if (r2 != null) goto L5;
        removeAccessibilityAction(r0, r1.getId());
        return;
    L5:
        addAccessibilityAction(r0, r1.createReplacementAction(r2, r3));
    }

    public static void requestApplyInsets(@NonNull View r0) {
        r0.requestApplyInsets();
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View r0, @IdRes int r1) {
        return (T) r0.requireViewById(r1);
    }

    @Deprecated
    public static int resolveSizeAndState(int r0, int r1, int r2) {
        return View.resolveSizeAndState(r0, r1, r2);
    }

    public static boolean restoreDefaultFocus(@NonNull View r0) {
        return r0.restoreDefaultFocus();
    }

    public static void saveAttributeDataForStyleable(@NonNull View r0, @NonNull @SuppressLint({"ContextFirst"}) Context r1, @NonNull int[] r2, @Nullable AttributeSet r3, @NonNull TypedArray r4, int r5, int r6) {
        Api29Impl.saveAttributeDataForStyleable(r0, r1, r2, r3, r4, r5, r6);
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        final int r1 = R.id.tag_screen_reader_focusable;
        final Class<Boolean> r2 = Boolean.class;
        final int r3 = 28;
        return new AnonymousClass3(r1, r2, r3);
    }

    public static void setAccessibilityDelegate(@NonNull View r1, AccessibilityDelegateCompat r2) {
        if (r2 == null) goto L4;
    L6:
        if (r2 != null) goto L8;
        View.AccessibilityDelegate r3 = null;
    L9:
        r1.setAccessibilityDelegate(r3);
        return;
    L8:
        r3 = r2.getBridge();
        goto L9
    L4:
        if ((getAccessibilityDelegateInternal(r1) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) == false) goto L6;
        r2 = new AccessibilityDelegateCompat();
        goto L6
    }

    @UiThread
    public static void setAccessibilityHeading(View r1, boolean r2) {
        accessibilityHeadingProperty().set(r1, Boolean.valueOf(r2));
    }

    public static void setAccessibilityLiveRegion(@NonNull View r0, int r1) {
        r0.setAccessibilityLiveRegion(r1);
    }

    @UiThread
    public static void setAccessibilityPaneTitle(View r1, CharSequence r2) {
        paneTitleProperty().set(r1, r2);
        if (r2 == null) goto L5;
        sAccessibilityPaneVisibilityManager.addAccessibilityPane(r1);
        return;
    L5:
        sAccessibilityPaneVisibilityManager.removeAccessibilityPane(r1);
    }

    @Deprecated
    public static void setActivated(View r0, boolean r1) {
        r0.setActivated(r1);
    }

    @Deprecated
    public static void setAlpha(View r0, @FloatRange(from = 0.0d, to = 1.0d) float r1) {
        r0.setAlpha(r1);
    }

    public static void setAutofillHints(@NonNull View r0, @Nullable String... r1) {
        r0.setAutofillHints(r1);
    }

    public static void setBackground(@NonNull View r0, @Nullable Drawable r1) {
        r0.setBackground(r1);
    }

    public static void setBackgroundTintList(@NonNull View r0, ColorStateList r1) {
        r0.setBackgroundTintList(r1);
    }

    public static void setBackgroundTintMode(@NonNull View r0, PorterDuff.Mode r1) {
        r0.setBackgroundTintMode(r1);
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup r5, boolean r6) {
        if (sChildrenDrawingOrderMethod != null) goto L23;
        sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
    L8:
        sChildrenDrawingOrderMethod.setAccessible(true);
    L6:
        e = move-exception;
        Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e);
    L23:
        sChildrenDrawingOrderMethod.invoke(r5, new Object[]{Boolean.valueOf(r6)});     // Catch: InvocationTargetException -> L11 IllegalArgumentException -> L13 IllegalAccessException -> L15
    L27:
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e);
        return;
    L13:
        e = move-exception;
        Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e);
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e);
    }

    public static void setClipBounds(@NonNull View r0, Rect r1) {
        r0.setClipBounds(r1);
    }

    public static void setElevation(@NonNull View r0, float r1) {
        r0.setElevation(r1);
    }

    @Deprecated
    public static void setFitsSystemWindows(View r0, boolean r1) {
        r0.setFitsSystemWindows(r1);
    }

    public static void setFocusedByDefault(@NonNull View r0, boolean r1) {
        r0.setFocusedByDefault(r1);
    }

    public static void setHasTransientState(@NonNull View r0, boolean r1) {
        r0.setHasTransientState(r1);
    }

    public static void setImportantForAccessibility(@NonNull View r0, int r1) {
        r0.setImportantForAccessibility(r1);
    }

    public static void setImportantForAutofill(@NonNull View r0, int r1) {
        r0.setImportantForAutofill(r1);
    }

    public static void setKeyboardNavigationCluster(@NonNull View r0, boolean r1) {
        r0.setKeyboardNavigationCluster(r1);
    }

    public static void setLabelFor(@NonNull View r0, @IdRes int r1) {
        r0.setLabelFor(r1);
    }

    public static void setLayerPaint(@NonNull View r0, Paint r1) {
        r0.setLayerPaint(r1);
    }

    @Deprecated
    public static void setLayerType(View r0, int r1, Paint r2) {
        r0.setLayerType(r1, r2);
    }

    public static void setLayoutDirection(@NonNull View r0, int r1) {
        r0.setLayoutDirection(r1);
    }

    public static void setNestedScrollingEnabled(@NonNull View r0, boolean r1) {
        r0.setNestedScrollingEnabled(r1);
    }

    public static void setNextClusterForwardId(@NonNull View r0, int r1) {
        r0.setNextClusterForwardId(r1);
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View r1, @Nullable final OnApplyWindowInsetsListener r2) {
        if (r2 != null) goto L5;
        r1.setOnApplyWindowInsetsListener(null);
        return;
    L5:
        r1.setOnApplyWindowInsetsListener(new AnonymousClass1(r2));
    }

    @Deprecated
    public static void setOverScrollMode(View r0, int r1) {
        r0.setOverScrollMode(r1);
    }

    public static void setPaddingRelative(@NonNull View r0, @Px int r1, @Px int r2, @Px int r3, @Px int r4) {
        r0.setPaddingRelative(r1, r2, r3, r4);
    }

    @Deprecated
    public static void setPivotX(View r0, float r1) {
        r0.setPivotX(r1);
    }

    @Deprecated
    public static void setPivotY(View r0, float r1) {
        r0.setPivotY(r1);
    }

    public static void setPointerIcon(@NonNull View r0, PointerIconCompat r1) {
        if (r1 == null) goto L4;
        Object r2 = r1.getPointerIcon();
    L5:
        r0.setPointerIcon((PointerIcon) r2);
        return;
    L4:
        r2 = null;
        goto L5
    }

    @Deprecated
    public static void setRotation(View r0, float r1) {
        r0.setRotation(r1);
    }

    @Deprecated
    public static void setRotationX(View r0, float r1) {
        r0.setRotationX(r1);
    }

    @Deprecated
    public static void setRotationY(View r0, float r1) {
        r0.setRotationY(r1);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View r0, boolean r1) {
        r0.setSaveFromParentEnabled(r1);
    }

    @Deprecated
    public static void setScaleX(View r0, float r1) {
        r0.setScaleX(r1);
    }

    @Deprecated
    public static void setScaleY(View r0, float r1) {
        r0.setScaleY(r1);
    }

    @UiThread
    public static void setScreenReaderFocusable(View r1, boolean r2) {
        screenReaderFocusableProperty().set(r1, Boolean.valueOf(r2));
    }

    public static void setScrollIndicators(@NonNull View r0, int r1) {
        r0.setScrollIndicators(r1);
    }

    public static void setSystemGestureExclusionRects(@NonNull View r0, @NonNull List<Rect> r1) {
        r0.setSystemGestureExclusionRects(r1);
    }

    public static void setTooltipText(@NonNull View r0, @Nullable CharSequence r1) {
        r0.setTooltipText(r1);
    }

    public static void setTransitionName(@NonNull View r0, String r1) {
        r0.setTransitionName(r1);
    }

    @Deprecated
    public static void setTranslationX(View r0, float r1) {
        r0.setTranslationX(r1);
    }

    @Deprecated
    public static void setTranslationY(View r0, float r1) {
        r0.setTranslationY(r1);
    }

    public static void setTranslationZ(@NonNull View r0, float r1) {
        r0.setTranslationZ(r1);
    }

    @Deprecated
    public static void setX(View r0, float r1) {
        r0.setX(r1);
    }

    @Deprecated
    public static void setY(View r0, float r1) {
        r0.setY(r1);
    }

    public static void setZ(@NonNull View r0, float r1) {
        r0.setZ(r1);
    }

    public static boolean startDragAndDrop(@NonNull View r0, ClipData r1, View.DragShadowBuilder r2, Object r3, int r4) {
        return r0.startDragAndDrop(r1, r2, r3, r4);
    }

    public static boolean startNestedScroll(@NonNull View r0, int r1) {
        return r0.startNestedScroll(r1);
    }

    public static void stopNestedScroll(@NonNull View r0) {
        r0.stopNestedScroll();
    }

    private static void tickleInvalidationFlag(View r2) {
        float r0 = r2.getTranslationY();
        r2.setTranslationY(1.0f + r0);
        r2.setTranslationY(r0);
    }

    public static void updateDragShadow(@NonNull View r0, View.DragShadowBuilder r1) {
        r0.updateDragShadow(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(@NonNull View r7, int r8, int r9, @Nullable int[] r10, @Nullable int[] r11, int r12) {
        if ((r7 instanceof NestedScrollingChild2) == true) goto L5;
        if (r12 == 0) goto L8;
        return false;
    L8:
        return dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    L5:
        return ((NestedScrollingChild2) r7).dispatchNestedPreScroll(r8, r9, r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void dispatchNestedScroll(@NonNull View r10, int r11, int r12, int r13, int r14, @Nullable int[] r15, int r16, @NonNull int[] r17) {
        if ((r10 instanceof NestedScrollingChild3) == false) goto L5;
        ((NestedScrollingChild3) r10).dispatchNestedScroll(r11, r12, r13, r14, r15, r16, r17);
        return;
    L5:
        dispatchNestedScroll(r10, r11, r12, r13, r14, r15, r16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(@NonNull View r1, int r2) {
        if ((r1 instanceof NestedScrollingChild2) == false) goto L5;
        ((NestedScrollingChild2) r1).hasNestedScrollingParent(r2);
        return false;
    L5:
        if (r2 == 0) goto L7;
        return false;
    L7:
        return hasNestedScrollingParent(r1);
    }

    public static void postInvalidateOnAnimation(@NonNull View r0, int r1, int r2, int r3, int r4) {
        r0.postInvalidateOnAnimation(r1, r2, r3, r4);
    }

    public static void setScrollIndicators(@NonNull View r0, int r1, int r2) {
        r0.setScrollIndicators(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(@NonNull View r1, int r2, int r3) {
        if ((r1 instanceof NestedScrollingChild2) == true) goto L5;
        if (r3 == 0) goto L8;
        return false;
    L8:
        return startNestedScroll(r1, r2);
    L5:
        return ((NestedScrollingChild2) r1).startNestedScroll(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(@NonNull View r1, int r2) {
        if ((r1 instanceof NestedScrollingChild2) == false) goto L5;
        ((NestedScrollingChild2) r1).stopNestedScroll(r2);
        return;
    L5:
        if (r2 != 0) goto L9;
        stopNestedScroll(r1);
        return;
    }

    private static void addAccessibilityAction(@NonNull View r1, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat r2) {
        getOrCreateAccessibilityDelegateCompat(r1);
        removeActionWithId(r2.getId(), r1);
        getActionList(r1).add(r2);
        notifyViewAccessibilityStateChangedIfNeeded(r1, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedScroll(@NonNull View r8, int r9, int r10, int r11, int r12, @Nullable int[] r13, int r14) {
        if ((r8 instanceof NestedScrollingChild2) == true) goto L5;
        if (r14 == 0) goto L8;
        return false;
    L8:
        return dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    L5:
        return ((NestedScrollingChild2) r8).dispatchNestedScroll(r9, r10, r11, r12, r13, r14);
    }
}
