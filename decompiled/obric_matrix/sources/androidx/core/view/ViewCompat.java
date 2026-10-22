package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;
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
import androidx.core.util.Preconditions;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
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
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = null;

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
    private static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = null;
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

    static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private final WeakHashMap<View, Boolean> mPanesToVisible;

        AccessibilityPaneVisibilityManager() {
            this.mPanesToVisible = new WeakHashMap();
        }

        @RequiresApi(19)
        private void checkPaneVisibility(View r2, boolean r3) {
            if (r2.isShown() == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r3 == r0) goto L14;
            if (r0 == false) goto L11;
            int r4 = 16;
        L12:
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r2, r4);
            this.mPanesToVisible.put(r2, Boolean.valueOf(r0));
            return;
        L11:
            r4 = 32;
            goto L12
        L14:
            return;
        L5:
            if (r2.getWindowVisibility() != 0) goto L7;
            r0 = true;
            goto L8
        }

        @RequiresApi(19)
        private void registerForLayoutCallback(View r1) {
            r1.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        private void unregisterForLayoutCallback(View r1) {
            Api16Impl.removeOnGlobalLayoutListener(r1.getViewTreeObserver(), this);
        }

        @RequiresApi(19)
        void addAccessibilityPane(View r3) {
            WeakHashMap<View, Boolean> r0 = this.mPanesToVisible;
            if (r3.isShown() == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.put(r3, Boolean.valueOf(r1));
            r3.addOnAttachStateChangeListener(this);
            if (Api19Impl.isAttachedToWindow(r3) == false) goto L12;
            registerForLayoutCallback(r3);
            return;
        L12:
            return;
        L5:
            if (r3.getWindowVisibility() != 0) goto L7;
            r1 = true;
            goto L8
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(19)
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 28) goto L8;
            Iterator<Map.Entry<View, Boolean>> r0 = this.mPanesToVisible.entrySet().iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            Map.Entry<View, Boolean> r1 = r0.next();
            checkPaneVisibility(r1.getKey(), r1.getValue().booleanValue());
            goto L6
        L10:
            return;
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
        void removeAccessibilityPane(View r2) {
            this.mPanesToVisible.remove(r2);
            r2.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(r2);
        }
    }

    static abstract class AccessibilityViewProperty<T> {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;

        AccessibilityViewProperty(int r2, Class<T> r3, int r4) {
            this(r2, r3, 0, r4);
        }

        AccessibilityViewProperty(int r1, Class<T> r2, int r3, int r4) {
            this.mTagKey = r1;
            this.mType = r2;
            this.mContentChangeType = r3;
            this.mFrameworkMinimumSdk = r4;
        }

        private boolean extrasAvailable() {
            if (Build.VERSION.SDK_INT < 19) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean frameworkAvailable() {
            if (Build.VERSION.SDK_INT < this.mFrameworkMinimumSdk) goto L5;
            return true;
        L5:
            return false;
        }

        boolean booleanNullToFalseEquals(Boolean r2, Boolean r3) {
            if (r2 != null) goto L5;
        L7:
            boolean r4 = false;
        L8:
            if (r3 != null) goto L10;
        L12:
            boolean r5 = false;
        L13:
            if (r4 != r5) goto L16;
            return true;
        L16:
            return false;
        L10:
            if (r3.booleanValue() == false) goto L12;
            r5 = true;
            goto L13
        L5:
            if (r2.booleanValue() == false) goto L7;
            r4 = true;
            goto L8
        }

        abstract T frameworkGet(View r1);

        abstract void frameworkSet(View r1, T r2);

        T get(View r2) {
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

        void set(View r2, T r3) {
            if (frameworkAvailable() == false) goto L6;
            frameworkSet(r2, r3);
            return;
        L6:
            if (extrasAvailable() == true) goto L8;
            return;
        L8:
            if (shouldUpdate(get(r2), r3) == false) goto L13;
            ViewCompat.ensureAccessibilityDelegateCompat(r2);
            r2.setTag(this.mTagKey, r3);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(r2, this.mContentChangeType);
            return;
        }

        boolean shouldUpdate(T r1, T r2) {
            return !r2.equals(r1);
        }
    }

    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static boolean hasOnClickListeners(@NonNull View r0) {
            return r0.hasOnClickListeners();
        }
    }

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static AccessibilityNodeProvider getAccessibilityNodeProvider(View r0) {
            return r0.getAccessibilityNodeProvider();
        }

        @DoNotInline
        static boolean getFitsSystemWindows(View r0) {
            return r0.getFitsSystemWindows();
        }

        @DoNotInline
        static int getImportantForAccessibility(View r0) {
            return r0.getImportantForAccessibility();
        }

        @DoNotInline
        static int getMinimumHeight(View r0) {
            return r0.getMinimumHeight();
        }

        @DoNotInline
        static int getMinimumWidth(View r0) {
            return r0.getMinimumWidth();
        }

        @DoNotInline
        static ViewParent getParentForAccessibility(View r0) {
            return r0.getParentForAccessibility();
        }

        @DoNotInline
        static int getWindowSystemUiVisibility(View r0) {
            return r0.getWindowSystemUiVisibility();
        }

        @DoNotInline
        static boolean hasOverlappingRendering(View r0) {
            return r0.hasOverlappingRendering();
        }

        @DoNotInline
        static boolean hasTransientState(View r0) {
            return r0.hasTransientState();
        }

        @DoNotInline
        static boolean performAccessibilityAction(View r0, int r1, Bundle r2) {
            return r0.performAccessibilityAction(r1, r2);
        }

        @DoNotInline
        static void postInvalidateOnAnimation(View r0) {
            r0.postInvalidateOnAnimation();
        }

        @DoNotInline
        static void postInvalidateOnAnimation(View r0, int r1, int r2, int r3, int r4) {
            r0.postInvalidateOnAnimation(r1, r2, r3, r4);
        }

        @DoNotInline
        static void postOnAnimation(View r0, Runnable r1) {
            r0.postOnAnimation(r1);
        }

        @DoNotInline
        static void postOnAnimationDelayed(View r0, Runnable r1, long r2) {
            r0.postOnAnimationDelayed(r1, r2);
        }

        @DoNotInline
        static void removeOnGlobalLayoutListener(ViewTreeObserver r0, ViewTreeObserver.OnGlobalLayoutListener r1) {
            r0.removeOnGlobalLayoutListener(r1);
        }

        @DoNotInline
        static void requestFitSystemWindows(View r0) {
            r0.requestFitSystemWindows();
        }

        @DoNotInline
        static void setBackground(View r0, Drawable r1) {
            r0.setBackground(r1);
        }

        @DoNotInline
        static void setHasTransientState(View r0, boolean r1) {
            r0.setHasTransientState(r1);
        }

        @DoNotInline
        static void setImportantForAccessibility(View r0, int r1) {
            r0.setImportantForAccessibility(r1);
        }
    }

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static int generateViewId() {
            return View.generateViewId();
        }

        @DoNotInline
        static Display getDisplay(@NonNull View r0) {
            return r0.getDisplay();
        }

        @DoNotInline
        static int getLabelFor(View r0) {
            return r0.getLabelFor();
        }

        @DoNotInline
        static int getLayoutDirection(View r0) {
            return r0.getLayoutDirection();
        }

        @DoNotInline
        static int getPaddingEnd(View r0) {
            return r0.getPaddingEnd();
        }

        @DoNotInline
        static int getPaddingStart(View r0) {
            return r0.getPaddingStart();
        }

        @DoNotInline
        static boolean isPaddingRelative(View r0) {
            return r0.isPaddingRelative();
        }

        @DoNotInline
        static void setLabelFor(View r0, int r1) {
            r0.setLabelFor(r1);
        }

        @DoNotInline
        static void setLayerPaint(View r0, Paint r1) {
            r0.setLayerPaint(r1);
        }

        @DoNotInline
        static void setLayoutDirection(View r0, int r1) {
            r0.setLayoutDirection(r1);
        }

        @DoNotInline
        static void setPaddingRelative(View r0, int r1, int r2, int r3, int r4) {
            r0.setPaddingRelative(r1, r2, r3, r4);
        }
    }

    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static Rect getClipBounds(@NonNull View r0) {
            return r0.getClipBounds();
        }

        @DoNotInline
        static boolean isInLayout(@NonNull View r0) {
            return r0.isInLayout();
        }

        @DoNotInline
        static void setClipBounds(@NonNull View r0, Rect r1) {
            r0.setClipBounds(r1);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static int getAccessibilityLiveRegion(View r0) {
            return r0.getAccessibilityLiveRegion();
        }

        @DoNotInline
        static boolean isAttachedToWindow(@NonNull View r0) {
            return r0.isAttachedToWindow();
        }

        @DoNotInline
        static boolean isLaidOut(@NonNull View r0) {
            return r0.isLaidOut();
        }

        @DoNotInline
        static boolean isLayoutDirectionResolved(@NonNull View r0) {
            return r0.isLayoutDirectionResolved();
        }

        @DoNotInline
        static void notifySubtreeAccessibilityStateChanged(ViewParent r0, View r1, View r2, int r3) {
            r0.notifySubtreeAccessibilityStateChanged(r1, r2, r3);
        }

        @DoNotInline
        static void setAccessibilityLiveRegion(View r0, int r1) {
            r0.setAccessibilityLiveRegion(r1);
        }

        @DoNotInline
        static void setContentChangeTypes(AccessibilityEvent r0, int r1) {
            r0.setContentChangeTypes(r1);
        }
    }

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static WindowInsets dispatchApplyWindowInsets(View r0, WindowInsets r1) {
            return r0.dispatchApplyWindowInsets(r1);
        }

        @DoNotInline
        static WindowInsets onApplyWindowInsets(View r0, WindowInsets r1) {
            return r0.onApplyWindowInsets(r1);
        }

        @DoNotInline
        static void requestApplyInsets(View r0) {
            r0.requestApplyInsets();
        }
    }

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void callCompatInsetAnimationCallback(@NonNull WindowInsets r1, @NonNull View r2) {
            View.OnApplyWindowInsetsListener r0 = (View.OnApplyWindowInsetsListener) r2.getTag(R.id.tag_window_insets_animation_callback);
            if (r0 == null) goto L6;
            r0.onApplyWindowInsets(r2, r1);
            return;
        }

        @DoNotInline
        static WindowInsetsCompat computeSystemWindowInsets(@NonNull View r1, @NonNull WindowInsetsCompat r2, @NonNull Rect r3) {
            WindowInsets r0 = r2.toWindowInsets();
            if (r0 != null) goto L5;
            r3.setEmpty();
            return r2;
        L5:
            return WindowInsetsCompat.toWindowInsetsCompat(r1.computeSystemWindowInsets(r0, r3), r1);
        }

        @DoNotInline
        static boolean dispatchNestedFling(@NonNull View r0, float r1, float r2, boolean r3) {
            return r0.dispatchNestedFling(r1, r2, r3);
        }

        @DoNotInline
        static boolean dispatchNestedPreFling(@NonNull View r0, float r1, float r2) {
            return r0.dispatchNestedPreFling(r1, r2);
        }

        @DoNotInline
        static boolean dispatchNestedPreScroll(View r0, int r1, int r2, int[] r3, int[] r4) {
            return r0.dispatchNestedPreScroll(r1, r2, r3, r4);
        }

        @DoNotInline
        static boolean dispatchNestedScroll(View r0, int r1, int r2, int r3, int r4, int[] r5) {
            return r0.dispatchNestedScroll(r1, r2, r3, r4, r5);
        }

        @DoNotInline
        static ColorStateList getBackgroundTintList(View r0) {
            return r0.getBackgroundTintList();
        }

        @DoNotInline
        static PorterDuff.Mode getBackgroundTintMode(View r0) {
            return r0.getBackgroundTintMode();
        }

        @DoNotInline
        static float getElevation(View r0) {
            return r0.getElevation();
        }

        @Nullable
        @DoNotInline
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View r0) {
            return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(r0);
        }

        @DoNotInline
        static String getTransitionName(View r0) {
            return r0.getTransitionName();
        }

        @DoNotInline
        static float getTranslationZ(View r0) {
            return r0.getTranslationZ();
        }

        @DoNotInline
        static float getZ(@NonNull View r0) {
            return r0.getZ();
        }

        @DoNotInline
        static boolean hasNestedScrollingParent(View r0) {
            return r0.hasNestedScrollingParent();
        }

        @DoNotInline
        static boolean isImportantForAccessibility(View r0) {
            return r0.isImportantForAccessibility();
        }

        @DoNotInline
        static boolean isNestedScrollingEnabled(View r0) {
            return r0.isNestedScrollingEnabled();
        }

        @DoNotInline
        static void setBackgroundTintList(View r0, ColorStateList r1) {
            r0.setBackgroundTintList(r1);
        }

        @DoNotInline
        static void setBackgroundTintMode(View r0, PorterDuff.Mode r1) {
            r0.setBackgroundTintMode(r1);
        }

        @DoNotInline
        static void setElevation(View r0, float r1) {
            r0.setElevation(r1);
        }

        @DoNotInline
        static void setNestedScrollingEnabled(View r0, boolean r1) {
            r0.setNestedScrollingEnabled(r1);
        }

        @DoNotInline
        static void setOnApplyWindowInsetsListener(@NonNull final View r2, @Nullable final OnApplyWindowInsetsListener r3) {
            if (Build.VERSION.SDK_INT >= 30) goto L5;
            r2.setTag(R.id.tag_on_apply_window_listener, r3);
        L5:
            if (r3 != null) goto L8;
            r2.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) r2.getTag(R.id.tag_window_insets_animation_callback));
            return;
        L8:
            r2.setOnApplyWindowInsetsListener(new AnonymousClass1(r2, r3));
        }

        @DoNotInline
        static void setTransitionName(View r0, String r1) {
            r0.setTransitionName(r1);
        }

        @DoNotInline
        static void setTranslationZ(View r0, float r1) {
            r0.setTranslationZ(r1);
        }

        @DoNotInline
        static void setZ(@NonNull View r0, float r1) {
            r0.setZ(r1);
        }

        @DoNotInline
        static boolean startNestedScroll(View r0, int r1) {
            return r0.startNestedScroll(r1);
        }

        @DoNotInline
        static void stopNestedScroll(View r0) {
            r0.stopNestedScroll();
        }
    }

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View r1) {
            WindowInsets r0 = r1.getRootWindowInsets();
            if (r0 != null) goto L6;
            return null;
        L6:
            WindowInsetsCompat r2 = WindowInsetsCompat.toWindowInsetsCompat(r0);
            r2.setRootWindowInsets(r2);
            r2.copyRootViewBounds(r1.getRootView());
            return r2;
        }

        @DoNotInline
        static int getScrollIndicators(@NonNull View r0) {
            return r0.getScrollIndicators();
        }

        @DoNotInline
        static void setScrollIndicators(@NonNull View r0, int r1) {
            r0.setScrollIndicators(r1);
        }

        @DoNotInline
        static void setScrollIndicators(@NonNull View r0, int r1, int r2) {
            r0.setScrollIndicators(r1, r2);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void cancelDragAndDrop(@NonNull View r0) {
            r0.cancelDragAndDrop();
        }

        @DoNotInline
        static void dispatchFinishTemporaryDetach(View r0) {
            r0.dispatchFinishTemporaryDetach();
        }

        @DoNotInline
        static void dispatchStartTemporaryDetach(View r0) {
            r0.dispatchStartTemporaryDetach();
        }

        @DoNotInline
        static void setPointerIcon(@NonNull View r0, PointerIcon r1) {
            r0.setPointerIcon(r1);
        }

        @DoNotInline
        static boolean startDragAndDrop(@NonNull View r0, @Nullable ClipData r1, @NonNull View.DragShadowBuilder r2, @Nullable Object r3, int r4) {
            return r0.startDragAndDrop(r1, r2, r3, r4);
        }

        @DoNotInline
        static void updateDragShadow(@NonNull View r0, @NonNull View.DragShadowBuilder r1) {
            r0.updateDragShadow(r1);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void addKeyboardNavigationClusters(@NonNull View r0, Collection<View> r1, int r2) {
            r0.addKeyboardNavigationClusters(r1, r2);
        }

        @DoNotInline
        static int getImportantForAutofill(View r0) {
            return r0.getImportantForAutofill();
        }

        @DoNotInline
        static int getNextClusterForwardId(@NonNull View r0) {
            return r0.getNextClusterForwardId();
        }

        @DoNotInline
        static boolean hasExplicitFocusable(@NonNull View r0) {
            return r0.hasExplicitFocusable();
        }

        @DoNotInline
        static boolean isFocusedByDefault(@NonNull View r0) {
            return r0.isFocusedByDefault();
        }

        @DoNotInline
        static boolean isImportantForAutofill(View r0) {
            return r0.isImportantForAutofill();
        }

        @DoNotInline
        static boolean isKeyboardNavigationCluster(@NonNull View r0) {
            return r0.isKeyboardNavigationCluster();
        }

        @DoNotInline
        static View keyboardNavigationClusterSearch(@NonNull View r0, View r1, int r2) {
            return r0.keyboardNavigationClusterSearch(r1, r2);
        }

        @DoNotInline
        static boolean restoreDefaultFocus(@NonNull View r0) {
            return r0.restoreDefaultFocus();
        }

        @DoNotInline
        static void setAutofillHints(@NonNull View r0, String... r1) {
            r0.setAutofillHints(r1);
        }

        @DoNotInline
        static void setFocusedByDefault(@NonNull View r0, boolean r1) {
            r0.setFocusedByDefault(r1);
        }

        @DoNotInline
        static void setImportantForAutofill(View r0, int r1) {
            r0.setImportantForAutofill(r1);
        }

        @DoNotInline
        static void setKeyboardNavigationCluster(@NonNull View r0, boolean r1) {
            r0.setKeyboardNavigationCluster(r1);
        }

        @DoNotInline
        static void setNextClusterForwardId(View r0, int r1) {
            r0.setNextClusterForwardId(r1);
        }

        @DoNotInline
        static void setTooltipText(@NonNull View r0, CharSequence r1) {
            r0.setTooltipText(r1);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void addOnUnhandledKeyEventListener(@NonNull View r2, @NonNull final OnUnhandledKeyEventListenerCompat r3) {
            int r0 = R.id.tag_unhandled_key_listeners;
            SimpleArrayMap r1 = (SimpleArrayMap) r2.getTag(r0);
            if (r1 != null) goto L5;
            r1 = new SimpleArrayMap();
            r2.setTag(r0, r1);
        L5:
            Objects.requireNonNull(r3);
            View.OnUnhandledKeyEventListener r4 = new j(r3);
            r1.put(r3, r4);
            r2.addOnUnhandledKeyEventListener(r4);
        }

        @DoNotInline
        static CharSequence getAccessibilityPaneTitle(View r0) {
            return r0.getAccessibilityPaneTitle();
        }

        @DoNotInline
        static boolean isAccessibilityHeading(View r0) {
            return r0.isAccessibilityHeading();
        }

        @DoNotInline
        static boolean isScreenReaderFocusable(View r0) {
            return r0.isScreenReaderFocusable();
        }

        @DoNotInline
        static void removeOnUnhandledKeyEventListener(@NonNull View r1, @NonNull OnUnhandledKeyEventListenerCompat r2) {
            SimpleArrayMap r0 = (SimpleArrayMap) r1.getTag(R.id.tag_unhandled_key_listeners);
            if (r0 != null) goto L5;
            return;
        L5:
            View.OnUnhandledKeyEventListener r3 = (View.OnUnhandledKeyEventListener) r0.get(r2);
            if (r3 == null) goto L9;
            r1.removeOnUnhandledKeyEventListener(r3);
            return;
        }

        @DoNotInline
        static <T> T requireViewById(View r0, int r1) {
            return (T) r0.requireViewById(r1);
        }

        @DoNotInline
        static void setAccessibilityHeading(View r0, boolean r1) {
            r0.setAccessibilityHeading(r1);
        }

        @DoNotInline
        static void setAccessibilityPaneTitle(View r0, CharSequence r1) {
            r0.setAccessibilityPaneTitle(r1);
        }

        @DoNotInline
        static void setScreenReaderFocusable(View r0, boolean r1) {
            r0.setScreenReaderFocusable(r1);
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static View.AccessibilityDelegate getAccessibilityDelegate(View r0) {
            return r0.getAccessibilityDelegate();
        }

        @DoNotInline
        static List<Rect> getSystemGestureExclusionRects(View r0) {
            return r0.getSystemGestureExclusionRects();
        }

        @DoNotInline
        static void saveAttributeDataForStyleable(@NonNull View r0, @NonNull Context r1, @NonNull int[] r2, @Nullable AttributeSet r3, @NonNull TypedArray r4, int r5, int r6) {
            r0.saveAttributeDataForStyleable(r1, r2, r3, r4, r5, r6);
        }

        @DoNotInline
        static void setSystemGestureExclusionRects(View r0, List<Rect> r1) {
            r0.setSystemGestureExclusionRects(r1);
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static CharSequence getStateDescription(View r0) {
            return r0.getStateDescription();
        }

        @Nullable
        public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View r0) {
            WindowInsetsController r1 = r0.getWindowInsetsController();
            if (r1 != null) goto L7;
            return null;
        L7:
            return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(r1);
        }

        @DoNotInline
        static void setStateDescription(View r0, CharSequence r1) {
            r0.setStateDescription(r1);
        }
    }

    @RequiresApi(31)
    private static final class Api31Impl {
        private Api31Impl() {
        }

        @Nullable
        @DoNotInline
        public static String[] getReceiveContentMimeTypes(@NonNull View r0) {
            return r0.getReceiveContentMimeTypes();
        }

        @Nullable
        @DoNotInline
        public static ContentInfoCompat performReceiveContent(@NonNull View r1, @NonNull ContentInfoCompat r2) {
            ContentInfo r0 = r2.toContentInfo();
            ContentInfo r3 = r1.performReceiveContent(r0);
            if (r3 != null) goto L6;
            return null;
        L6:
            if (r3 != r0) goto L9;
            return r2;
        L9:
            return ContentInfoCompat.toContentInfoCompat(r3);
        }

        @DoNotInline
        public static void setOnReceiveContentListener(@NonNull View r1, @Nullable String[] r2, @Nullable OnReceiveContentListener r3) {
            if (r3 != null) goto L4;
            r1.setOnReceiveContentListener(r2, null);
            return;
        L4:
            r1.setOnReceiveContentListener(r2, new OnReceiveContentListenerAdapter(r3));
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

    @RequiresApi(31)
    private static final class OnReceiveContentListenerAdapter implements android.view.OnReceiveContentListener {

        @NonNull
        private final OnReceiveContentListener mJetpackListener;

        OnReceiveContentListenerAdapter(@NonNull OnReceiveContentListener r1) {
            this.mJetpackListener = r1;
        }

        @Override // android.view.OnReceiveContentListener
        @Nullable
        public ContentInfo onReceiveContent(@NonNull View r2, @NonNull ContentInfo r3) {
            ContentInfoCompat r0 = ContentInfoCompat.toContentInfoCompat(r3);
            ContentInfoCompat r1 = this.mJetpackListener.onReceiveContent(r2, r0);
            if (r1 != null) goto L6;
            return null;
        L6:
            if (r1 != r0) goto L9;
            return r3;
        L9:
            return r1.toContentInfo();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(@NonNull View r1, @NonNull KeyEvent r2);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollAxis {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ScrollIndicators {
    }

    static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = null;
        private SparseArray<WeakReference<View>> mCapturedKeys;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent;

        @Nullable
        private WeakHashMap<View, Boolean> mViewsContainingListeners;

        static {
            sViewsWithListeners = new ArrayList();
        }

        UnhandledKeyEventManager() {
            this.mViewsContainingListeners = null;
            this.mCapturedKeys = null;
            this.mLastDispatchedPreViewKeyEvent = null;
        }

        static UnhandledKeyEventManager at(View r2) {
            int r0 = R.id.tag_unhandled_key_event_manager;
            UnhandledKeyEventManager r1 = (UnhandledKeyEventManager) r2.getTag(r0);
            if (r1 != null) goto L6;
            UnhandledKeyEventManager r3 = new UnhandledKeyEventManager();
            r2.setTag(r0, r3);
            return r3;
        L6:
            return r1;
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
            Boolean r0 = Boolean.TRUE;
            WeakHashMap<View, Boolean> r1 = this.mViewsContainingListeners;
            if (r1 == null) goto L5;
            r1.clear();
        L5:
            ArrayList<WeakReference<View>> r2 = sViewsWithListeners;
            if (r2.isEmpty() == false) goto L8;
            return;
        L8:
            monitor-enter(r2);
        L24:
            th = move-exception;
            throw th;
        L10:
            if (this.mViewsContainingListeners != null) goto L12;
            this.mViewsContainingListeners = new WeakHashMap();     // Catch: Throwable -> L24
        L12:
            int r3 = r2.size() - 1;     // Catch: Throwable -> L24
        L13:
            if (r3 < 0) goto L22;
            ArrayList<WeakReference<View>> r4 = sViewsWithListeners;     // Catch: Throwable -> L24
            View r5 = r4.get(r3).get();     // Catch: Throwable -> L24
            if (r5 != null) goto L17;
            r4.remove(r3);     // Catch: Throwable -> L24
        L21:
            r3 = r3 - 1;     // Catch: Throwable -> L24
            goto L13
        L17:
            this.mViewsContainingListeners.put(r5, r0);     // Catch: Throwable -> L24
            ViewParent r6 = r5.getParent();     // Catch: Throwable -> L24
        L19:
            if ((r6 instanceof View) == false) goto L21;
            this.mViewsContainingListeners.put((View) r6, r0);     // Catch: Throwable -> L24
            r6 = r6.getParent();     // Catch: Throwable -> L24
            goto L19
        L22:
            monitor-exit(r2);     // Catch: Throwable -> L24
        }

        static void registerListeningView(View r3) {
            ArrayList<WeakReference<View>> r0 = sViewsWithListeners;
            monitor-enter(r0);
            Iterator<WeakReference<View>> r1 = r0.iterator();     // Catch: Throwable -> L14
        L6:
            if (r1.hasNext() == false) goto L11;
            if (r1.next().get() != r3) goto L6;
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L11:
            sViewsWithListeners.add(new WeakReference(r3));     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        static void unregisterListeningView(View r4) {
            ArrayList<WeakReference<View>> r0 = sViewsWithListeners;
            monitor-enter(r0);
            int r1 = 0;
        L18:
            ArrayList<WeakReference<View>> r2 = sViewsWithListeners;     // Catch: Throwable -> L15
            if (r1 >= r2.size()) goto L13;
            if (r2.get(r1).get() == r4) goto L9;
            r1 = r1 + 1;     // Catch: Throwable -> L15
            goto L18
        L9:
            r2.remove(r1);     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        boolean dispatch(View r2, KeyEvent r3) {
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

        boolean preDispatch(KeyEvent r6) {
            WeakReference<KeyEvent> r0 = this.mLastDispatchedPreViewKeyEvent;
            if (r0 != null) goto L5;
        L7:
            this.mLastDispatchedPreViewKeyEvent = new WeakReference(r6);
            WeakReference<View> r1 = null;
            SparseArray<WeakReference<View>> r2 = getCapturedKeys();
            if (r6.getAction() != 1) goto L12;
            int r3 = r2.indexOfKey(r6.getKeyCode());
            if (r3 < 0) goto L12;
            r1 = r2.valueAt(r3);
            r2.removeAt(r3);
        L12:
            if (r1 != null) goto L14;
            r1 = r2.get(r6.getKeyCode());
        L14:
            if (r1 == null) goto L21;
            View r4 = r1.get();
            if (r4 != null) goto L18;
        L20:
            return true;
        L18:
            if (ViewCompat.isAttachedToWindow(r4) == false) goto L20;
            onUnhandledKeyEvent(r4, r6);
            goto L20
        L21:
            return false;
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
        NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = d.f347f;
        sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    @Deprecated
    protected ViewCompat() {
    }

    static /* synthetic */ ContentInfoCompat a(ContentInfoCompat r0) {
        return r0;
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        final int r1 = R.id.tag_accessibility_heading;
        final Class<Boolean> r2 = Boolean.class;
        final int r3 = 28;
        return new AnonymousClass4(r1, r2, r3);
    }

    public static int addAccessibilityAction(@NonNull View r2, @NonNull CharSequence r3, @NonNull AccessibilityViewCommand r4) {
        int r0 = getAvailableActionIdFromResources(r2, r3);
        if (r0 == (-1)) goto L5;
        addAccessibilityAction(r2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(r0, r3, r4));
    L5:
        return r0;
    }

    private static void addAccessibilityAction(@NonNull View r2, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        ensureAccessibilityDelegateCompat(r2);
        removeActionWithId(r3.getId(), r2);
        getActionList(r2).add(r3);
        notifyViewAccessibilityStateChangedIfNeeded(r2, 0);
        return;
    }

    public static void addKeyboardNavigationClusters(@NonNull View r2, @NonNull Collection<View> r3, int r4) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.addKeyboardNavigationClusters(r2, r3, r4);
        return;
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View r2, @NonNull OnUnhandledKeyEventListenerCompat r3) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.addOnUnhandledKeyEventListener(r2, r3);
        return;
    L6:
        int r0 = R.id.tag_unhandled_key_listeners;
        ArrayList r1 = (ArrayList) r2.getTag(r0);
        if (r1 != null) goto L9;
        r1 = new ArrayList();
        r2.setTag(r0, r1);
    L9:
        r1.add(r3);
        if (r1.size() != 1) goto L13;
        UnhandledKeyEventManager.registerListeningView(r2);
        return;
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
        sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);     // Catch: NoSuchMethodException -> L4
        sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);     // Catch: NoSuchMethodException -> L4
    L6:
        sTempDetachBound = true;
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Couldn't find method", e);
        goto L6
    }

    @Deprecated
    public static boolean canScrollHorizontally(View r0, int r1) {
        return r0.canScrollHorizontally(r1);
    }

    @Deprecated
    public static boolean canScrollVertically(View r0, int r1) {
        return r0.canScrollVertically(r1);
    }

    public static void cancelDragAndDrop(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.cancelDragAndDrop(r2);
        return;
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
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View r2, @NonNull WindowInsetsCompat r3, @NonNull Rect r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return r3;
    L5:
        return Api21Impl.computeSystemWindowInsets(r2, r3, r4);
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View r2, @NonNull WindowInsetsCompat r3) {
        if (Build.VERSION.SDK_INT < 21) goto L10;
        WindowInsets r0 = r3.toWindowInsets();
        if (r0 == null) goto L10;
        WindowInsets r1 = Api20Impl.dispatchApplyWindowInsets(r2, r0);
        if (r1.equals(r0) == true) goto L10;
        return WindowInsetsCompat.toWindowInsetsCompat(r1, r2);
    L10:
        return r3;
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.dispatchFinishTemporaryDetach(r2);
        return;
    L6:
        if (sTempDetachBound == true) goto L8;
        bindTempDetach();
    L8:
        Method r0 = sDispatchFinishTemporaryDetach;
        if (r0 != null) goto L17;
        r2.onFinishTemporaryDetach();
        return;
    L17:
        r0.invoke(r2, new Object[0]);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        Log.d(TAG, "Error calling dispatchFinishTemporaryDetach", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedFling(@NonNull View r2, float r3, float r4, boolean r5) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedFling(r2, r3, r4, r5);
    L7:
        if ((r2 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r2).dispatchNestedFling(r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreFling(@NonNull View r2, float r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedPreFling(r2, r3, r4);
    L7:
        if ((r2 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r2).dispatchNestedPreFling(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean dispatchNestedPreScroll(@NonNull View r2, int r3, int r4, @Nullable int[] r5, @Nullable int[] r6) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedPreScroll(r2, r3, r4, r5, r6);
    L7:
        if ((r2 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r2).dispatchNestedPreScroll(r3, r4, r5, r6);
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
    public static boolean dispatchNestedScroll(@NonNull View r7, int r8, int r9, int r10, int r11, @Nullable int[] r12) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.dispatchNestedScroll(r7, r8, r9, r10, r11, r12);
    L7:
        if ((r7 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r7).dispatchNestedScroll(r8, r9, r10, r11, r12);
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

    public static void dispatchStartTemporaryDetach(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.dispatchStartTemporaryDetach(r2);
        return;
    L6:
        if (sTempDetachBound == true) goto L8;
        bindTempDetach();
    L8:
        Method r0 = sDispatchStartTemporaryDetach;
        if (r0 != null) goto L17;
        r2.onStartTemporaryDetach();
        return;
    L17:
        r0.invoke(r2, new Object[0]);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        Log.d(TAG, "Error calling dispatchStartTemporaryDetach", e);
    }

    @UiThread
    static boolean dispatchUnhandledKeyEventBeforeCallback(View r2, KeyEvent r3) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return false;
    L7:
        return UnhandledKeyEventManager.at(r2).dispatch(r2, r3);
    }

    @UiThread
    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View r2, KeyEvent r3) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return false;
    L7:
        return UnhandledKeyEventManager.at(r2).preDispatch(r3);
    }

    public static void enableAccessibleClickableSpanSupport(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        ensureAccessibilityDelegateCompat(r2);
        return;
    }

    static void ensureAccessibilityDelegateCompat(@NonNull View r1) {
        AccessibilityDelegateCompat r0 = getAccessibilityDelegate(r1);
        if (r0 != null) goto L5;
        r0 = new AccessibilityDelegateCompat();
    L5:
        setAccessibilityDelegate(r1, r0);
    }

    public static int generateViewId() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
    L6:
        AtomicInteger r0 = sNextGeneratedId;
        int r1 = r0.get();
        int r2 = r1 + 1;
        if (r2 <= 16777215) goto L10;
        r2 = 1;
    L10:
        if (r0.compareAndSet(r1, r2) == false) goto L6;
        return r1;
    L5:
        return Api17Impl.generateViewId();
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
    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return Api29Impl.getAccessibilityDelegate(r2);
    L7:
        return getAccessibilityDelegateThroughReflection(r2);
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

    public static int getAccessibilityLiveRegion(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return Api19Impl.getAccessibilityLiveRegion(r2);
    }

    @Nullable
    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 16) goto L8;
        AccessibilityNodeProvider r3 = Api16Impl.getAccessibilityNodeProvider(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new AccessibilityNodeProviderCompat(r3);
    L8:
        return null;
    }

    @Nullable
    @UiThread
    public static CharSequence getAccessibilityPaneTitle(@NonNull View r1) {
        return paneTitleProperty().get(r1);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View r2) {
        int r0 = R.id.tag_accessibility_actions;
        ArrayList r1 = (ArrayList) r2.getTag(r0);
        if (r1 != null) goto L6;
        ArrayList r3 = new ArrayList();
        r2.setTag(r0, r3);
        return r3;
    L6:
        return r1;
    }

    @Deprecated
    public static float getAlpha(View r0) {
        return r0.getAlpha();
    }

    private static int getAvailableActionIdFromResources(View r8, @NonNull CharSequence r9) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> r10 = getActionList(r8);
        int r1 = 0;
    L4:
        if (r1 >= r10.size()) goto L10;
        if (TextUtils.equals(r9, r10.get(r1).getLabel()) == true) goto L8;
        r1 = r1 + 1;
        goto L4
    L8:
        return r10.get(r1).getId();
    L10:
        int r2 = -1;
        int r3 = 0;
    L11:
        int[] r4 = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
        if (r3 >= r4.length) goto L25;
        if (r2 != (-1)) goto L25;
        int r5 = r4[r3];
        int r6 = 0;
        boolean r7 = true;
    L16:
        if (r6 >= r10.size()) goto L22;
        if (r10.get(r6).getId() == r5) goto L20;
        boolean r11 = true;
    L21:
        r7 = r7 & r11;
        r6 = r6 + 1;
        goto L16
    L20:
        r11 = false;
        goto L21
    L22:
        if (r7 == false) goto L24;
        r2 = r5;
    L24:
        r3 = r3 + 1;
    L25:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getBackgroundTintList(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getBackgroundTintList(r2);
    L7:
        if ((r2 instanceof TintableBackgroundView) == true) goto L11;
        return null;
    L11:
        return ((TintableBackgroundView) r2).getSupportBackgroundTintList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getBackgroundTintMode(r2);
    L7:
        if ((r2 instanceof TintableBackgroundView) == true) goto L11;
        return null;
    L11:
        return ((TintableBackgroundView) r2).getSupportBackgroundTintMode();
    }

    @Nullable
    public static Rect getClipBounds(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return null;
    L5:
        return Api18Impl.getClipBounds(r2);
    }

    @Nullable
    public static Display getDisplay(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getDisplay(r2);
    L7:
        if (isAttachedToWindow(r2) == true) goto L9;
        return null;
    L9:
        return ((WindowManager) r2.getContext().getSystemService("window")).getDefaultDisplay();
    }

    public static float getElevation(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return Api21Impl.getElevation(r2);
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

    /* JADX WARN: Multi-variable type inference failed */
    private static OnReceiveContentViewBehavior getFallback(@NonNull View r1) {
        if ((r1 instanceof OnReceiveContentViewBehavior) == false) goto L7;
        return (OnReceiveContentViewBehavior) r1;
    L7:
        return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    public static boolean getFitsSystemWindows(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return Api16Impl.getFitsSystemWindows(r2);
    }

    public static int getImportantForAccessibility(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return Api16Impl.getImportantForAccessibility(r2);
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return 0;
    L5:
        return Api26Impl.getImportantForAutofill(r2);
    }

    public static int getLabelFor(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return 0;
    L5:
        return Api17Impl.getLabelFor(r2);
    }

    @Deprecated
    public static int getLayerType(View r0) {
        return r0.getLayerType();
    }

    public static int getLayoutDirection(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return 0;
    L5:
        return Api17Impl.getLayoutDirection(r2);
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

    public static int getMinimumHeight(@NonNull View r3) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMinimumHeight(r3);
    L7:
        if (sMinHeightFieldFetched == false) goto L21;
    L11:
        Field r0 = sMinHeightField;
        if (r0 != null) goto L19;
        return 0;
    L19:
        return ((Integer) r0.get(r3)).intValue();
    L23:
        return 0;
    L21:
        Field r1 = View.class.getDeclaredField("mMinHeight");     // Catch: NoSuchFieldException -> L17
        sMinHeightField = r1;     // Catch: NoSuchFieldException -> L17
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L17
    L10:
        sMinHeightFieldFetched = true;
        goto L11
    }

    public static int getMinimumWidth(@NonNull View r3) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMinimumWidth(r3);
    L7:
        if (sMinWidthFieldFetched == false) goto L21;
    L11:
        Field r0 = sMinWidthField;
        if (r0 != null) goto L19;
        return 0;
    L19:
        return ((Integer) r0.get(r3)).intValue();
    L23:
        return 0;
    L21:
        Field r1 = View.class.getDeclaredField("mMinWidth");     // Catch: NoSuchFieldException -> L17
        sMinWidthField = r1;     // Catch: NoSuchFieldException -> L17
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L17
    L10:
        sMinWidthFieldFetched = true;
        goto L11
    }

    public static int getNextClusterForwardId(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return -1;
    L5:
        return Api26Impl.getNextClusterForwardId(r2);
    }

    @Nullable
    public static String[] getOnReceiveContentMimeTypes(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.getReceiveContentMimeTypes(r2);
    L7:
        return (String[]) r2.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @Deprecated
    public static int getOverScrollMode(View r0) {
        return r0.getOverScrollMode();
    }

    @Px
    public static int getPaddingEnd(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getPaddingEnd(r2);
    L7:
        return r2.getPaddingRight();
    }

    @Px
    public static int getPaddingStart(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Api17Impl.getPaddingStart(r2);
    L7:
        return r2.getPaddingLeft();
    }

    @Nullable
    public static ViewParent getParentForAccessibility(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getParentForAccessibility(r2);
    L7:
        return r2.getParent();
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
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L7;
        return Api23Impl.getRootWindowInsets(r2);
    L7:
        if (r0 >= 21) goto L9;
        return null;
    L9:
        return Api21Impl.getRootWindowInsets(r2);
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

    public static int getScrollIndicators(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return 0;
    L5:
        return Api23Impl.getScrollIndicators(r2);
    }

    @Nullable
    @UiThread
    public static CharSequence getStateDescription(@NonNull View r1) {
        return stateDescriptionProperty().get(r1);
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return Api29Impl.getSystemGestureExclusionRects(r2);
    L7:
        return Collections.emptyList();
    }

    @Nullable
    public static String getTransitionName(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        WeakHashMap<View, String> r0 = sTransitionNameMap;
        if (r0 != null) goto L11;
        return null;
    L11:
        return r0.get(r2);
    L5:
        return Api21Impl.getTransitionName(r2);
    }

    @Deprecated
    public static float getTranslationX(View r0) {
        return r0.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View r0) {
        return r0.getTranslationY();
    }

    public static float getTranslationZ(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return Api21Impl.getTranslationZ(r2);
    }

    @Nullable
    @Deprecated
    public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View r3) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        Context r0 = r3.getContext();
    L8:
        if ((r0 instanceof ContextWrapper) == false) goto L16;
        if ((r0 instanceof Activity) == true) goto L11;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L8
    L11:
        Window r1 = ((Activity) r0).getWindow();
        if (r1 != null) goto L14;
        return null;
    L14:
        return WindowCompat.getInsetsController(r1, r3);
    L16:
        return null;
    L5:
        return Api30Impl.getWindowInsetsController(r3);
    }

    @Deprecated
    public static int getWindowSystemUiVisibility(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return Api16Impl.getWindowSystemUiVisibility(r2);
    }

    @Deprecated
    public static float getX(View r0) {
        return r0.getX();
    }

    @Deprecated
    public static float getY(View r0) {
        return r0.getY();
    }

    public static float getZ(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0.0f;
    L5:
        return Api21Impl.getZ(r2);
    }

    public static boolean hasAccessibilityDelegate(@NonNull View r0) {
        if (getAccessibilityDelegateInternal(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasExplicitFocusable(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.hasExplicitFocusable(r2);
    L7:
        return r2.hasFocusable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean hasNestedScrollingParent(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.hasNestedScrollingParent(r2);
    L7:
        if ((r2 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r2).hasNestedScrollingParent();
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

    public static boolean hasOnClickListeners(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 15) goto L5;
        return false;
    L5:
        return Api15Impl.hasOnClickListeners(r2);
    }

    public static boolean hasOverlappingRendering(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return true;
    L5:
        return Api16Impl.hasOverlappingRendering(r2);
    }

    public static boolean hasTransientState(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return Api16Impl.hasTransientState(r2);
    }

    @UiThread
    public static boolean isAccessibilityHeading(@NonNull View r1) {
        Boolean r2 = accessibilityHeadingProperty().get(r1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public static boolean isAttachedToWindow(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.isAttachedToWindow(r2);
    L7:
        if (r2.getWindowToken() == null) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isFocusedByDefault(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.isFocusedByDefault(r2);
    }

    public static boolean isImportantForAccessibility(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isImportantForAccessibility(r2);
    }

    public static boolean isImportantForAutofill(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return true;
    L5:
        return Api26Impl.isImportantForAutofill(r2);
    }

    public static boolean isInLayout(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return false;
    L5:
        return Api18Impl.isInLayout(r2);
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.isKeyboardNavigationCluster(r2);
    }

    public static boolean isLaidOut(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.isLaidOut(r2);
    L7:
        if (r2.getWidth() > 0) goto L9;
    L11:
        return false;
    L9:
        if (r2.getHeight() <= 0) goto L11;
        return true;
    }

    public static boolean isLayoutDirectionResolved(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return Api19Impl.isLayoutDirectionResolved(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isNestedScrollingEnabled(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.isNestedScrollingEnabled(r2);
    L7:
        if ((r2 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r2).isNestedScrollingEnabled();
    }

    @Deprecated
    public static boolean isOpaque(View r0) {
        return r0.isOpaque();
    }

    public static boolean isPaddingRelative(@NonNull View r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        return Api17Impl.isPaddingRelative(r2);
    }

    @UiThread
    public static boolean isScreenReaderFocusable(@NonNull View r1) {
        Boolean r2 = screenReaderFocusableProperty().get(r1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View r0) {
        r0.jumpDrawablesToCurrentState();
    }

    @Nullable
    public static View keyboardNavigationClusterSearch(@NonNull View r2, @Nullable View r3, int r4) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return Api26Impl.keyboardNavigationClusterSearch(r2, r3, r4);
    }

    @RequiresApi(19)
    static void notifyViewAccessibilityStateChangedIfNeeded(View r4, int r5) {
        AccessibilityManager r0 = (AccessibilityManager) r4.getContext().getSystemService("accessibility");
        if (r0.isEnabled() == true) goto L6;
        return;
    L6:
        if (getAccessibilityPaneTitle(r4) != null) goto L8;
    L12:
        boolean r1 = false;
    L13:
        int r3 = 32;
        if (getAccessibilityLiveRegion(r4) != 0) goto L26;
        if (r1 == true) goto L26;
        if (r5 != 32) goto L20;
        AccessibilityEvent r2 = AccessibilityEvent.obtain();
        r4.onInitializeAccessibilityEvent(r2);
        r2.setEventType(32);
        Api19Impl.setContentChangeTypes(r2, r5);
        r2.setSource(r4);
        r4.onPopulateAccessibilityEvent(r2);
        r2.getText().add(getAccessibilityPaneTitle(r4));
        r0.sendAccessibilityEvent(r2);
        return;
    L20:
        if (r4.getParent() != null) goto L35;
        return;
    L35:
        Api19Impl.notifySubtreeAccessibilityStateChanged(r4.getParent(), r4, r4, r5);     // Catch: AbstractMethodError -> L24
        return;
    L24:
        e = move-exception;
        Log.e(TAG, r4.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
        return;
    L26:
        AccessibilityEvent r6 = AccessibilityEvent.obtain();
        if (r1 == true) goto L30;
        r3 = 2048;
    L30:
        r6.setEventType(r3);
        Api19Impl.setContentChangeTypes(r6, r5);
        if (r1 == false) goto L33;
        r6.getText().add(getAccessibilityPaneTitle(r4));
        setViewImportanceForAccessibilityIfNeeded(r4);
    L33:
        r4.sendAccessibilityEventUnchecked(r6);
        return;
    L8:
        if (r4.isShown() == false) goto L12;
        if (r4.getWindowVisibility() != 0) goto L12;
        r1 = true;
        goto L13
    }

    public static void offsetLeftAndRight(@NonNull View r6, int r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L6;
        r6.offsetLeftAndRight(r7);
        return;
    L6:
        if (r0 < 21) goto L15;
        Rect r1 = getEmptyTempRect();
        boolean r2 = false;
        Object r3 = r6.getParent();
        if ((r3 instanceof View) == false) goto L10;
        View r4 = (View) r3;
        r1.set(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
        r2 = !r1.intersects(r6.getLeft(), r6.getTop(), r6.getRight(), r6.getBottom());
    L10:
        compatOffsetLeftAndRight(r6, r7);
        if (r2 == true) goto L13;
        return;
    L13:
        if (r1.intersect(r6.getLeft(), r6.getTop(), r6.getRight(), r6.getBottom()) == false) goto L19;
        ((View) r3).invalidate(r1);
        return;
    L19:
        return;
    L15:
        compatOffsetLeftAndRight(r6, r7);
    }

    public static void offsetTopAndBottom(@NonNull View r6, int r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L6;
        r6.offsetTopAndBottom(r7);
        return;
    L6:
        if (r0 < 21) goto L15;
        Rect r1 = getEmptyTempRect();
        boolean r2 = false;
        Object r3 = r6.getParent();
        if ((r3 instanceof View) == false) goto L10;
        View r4 = (View) r3;
        r1.set(r4.getLeft(), r4.getTop(), r4.getRight(), r4.getBottom());
        r2 = !r1.intersects(r6.getLeft(), r6.getTop(), r6.getRight(), r6.getBottom());
    L10:
        compatOffsetTopAndBottom(r6, r7);
        if (r2 == true) goto L13;
        return;
    L13:
        if (r1.intersect(r6.getLeft(), r6.getTop(), r6.getRight(), r6.getBottom()) == false) goto L19;
        ((View) r3).invalidate(r1);
        return;
    L19:
        return;
    L15:
        compatOffsetTopAndBottom(r6, r7);
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View r2, @NonNull WindowInsetsCompat r3) {
        if (Build.VERSION.SDK_INT < 21) goto L10;
        WindowInsets r0 = r3.toWindowInsets();
        if (r0 == null) goto L10;
        WindowInsets r1 = Api20Impl.onApplyWindowInsets(r2, r0);
        if (r1.equals(r0) == true) goto L10;
        return WindowInsetsCompat.toWindowInsetsCompat(r1, r2);
    L10:
        return r3;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View r0, AccessibilityEvent r1) {
        r0.onInitializeAccessibilityEvent(r1);
    }

    public static void onInitializeAccessibilityNodeInfo(@NonNull View r0, @NonNull AccessibilityNodeInfoCompat r1) {
        r0.onInitializeAccessibilityNodeInfo(r1.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View r0, AccessibilityEvent r1) {
        r0.onPopulateAccessibilityEvent(r1);
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        final int r1 = R.id.tag_accessibility_pane_title;
        final Class<CharSequence> r2 = CharSequence.class;
        final int r3 = 8;
        final int r4 = 28;
        return new AnonymousClass2(r1, r2, r3, r4);
    }

    public static boolean performAccessibilityAction(@NonNull View r2, int r3, @Nullable Bundle r4) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return Api16Impl.performAccessibilityAction(r2, r3, r4);
    }

    @Nullable
    public static ContentInfoCompat performReceiveContent(@NonNull View r3, @NonNull ContentInfoCompat r4) {
        if (Log.isLoggable(TAG, 3) == false) goto L6;
        Log.d(TAG, "performReceiveContent: " + r4 + ", view=" + r3.getClass().getSimpleName() + "[" + r3.getId() + "]");
    L6:
        if (Build.VERSION.SDK_INT >= 31) goto L8;
        OnReceiveContentListener r0 = (OnReceiveContentListener) r3.getTag(R.id.tag_on_receive_content_listener);
        if (r0 == null) goto L17;
        ContentInfoCompat r5 = r0.onReceiveContent(r3, r4);
        if (r5 != null) goto L15;
        return null;
    L15:
        return getFallback(r3).onReceiveContent(r5);
    L17:
        return getFallback(r3).onReceiveContent(r4);
    L8:
        return Api31Impl.performReceiveContent(r3, r4);
    }

    public static void postInvalidateOnAnimation(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postInvalidateOnAnimation(r2);
        return;
    L5:
        r2.postInvalidate();
    }

    public static void postInvalidateOnAnimation(@NonNull View r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postInvalidateOnAnimation(r2, r3, r4, r5, r6);
        return;
    L5:
        r2.postInvalidate(r3, r4, r5, r6);
    }

    public static void postOnAnimation(@NonNull View r2, @NonNull Runnable r3) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postOnAnimation(r2, r3);
        return;
    L5:
        r2.postDelayed(r3, ValueAnimator.getFrameDelay());
    }

    @SuppressLint({"LambdaLast"})
    public static void postOnAnimationDelayed(@NonNull View r2, @NonNull Runnable r3, long r4) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.postOnAnimationDelayed(r2, r3, r4);
        return;
    L5:
        r2.postDelayed(r3, ValueAnimator.getFrameDelay() + r4);
    }

    public static void removeAccessibilityAction(@NonNull View r2, int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        removeActionWithId(r3, r2);
        notifyViewAccessibilityStateChangedIfNeeded(r2, 0);
        return;
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

    public static void removeOnUnhandledKeyEventListener(@NonNull View r2, @NonNull OnUnhandledKeyEventListenerCompat r3) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.removeOnUnhandledKeyEventListener(r2, r3);
        return;
    L6:
        ArrayList r0 = (ArrayList) r2.getTag(R.id.tag_unhandled_key_listeners);
        if (r0 == null) goto L12;
        r0.remove(r3);
        if (r0.size() != 0) goto L13;
        UnhandledKeyEventManager.unregisterListeningView(r2);
        return;
    L13:
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

    public static void requestApplyInsets(@NonNull View r2) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 20) goto L6;
        Api20Impl.requestApplyInsets(r2);
        return;
    L6:
        if (r0 < 16) goto L10;
        Api16Impl.requestFitSystemWindows(r2);
        return;
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View r2, @IdRes int r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r4 = (T) r2.findViewById(r3);
        if (r4 == null) goto L10;
        return r4;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    L5:
        return (T) Api28Impl.requireViewById(r2, r3);
    }

    @Deprecated
    public static int resolveSizeAndState(int r0, int r1, int r2) {
        return View.resolveSizeAndState(r0, r1, r2);
    }

    public static boolean restoreDefaultFocus(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return Api26Impl.restoreDefaultFocus(r2);
    L7:
        return r2.requestFocus();
    }

    public static void saveAttributeDataForStyleable(@NonNull View r2, @NonNull @SuppressLint({"ContextFirst"}) Context r3, @NonNull int[] r4, @Nullable AttributeSet r5, @NonNull TypedArray r6, int r7, int r8) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.saveAttributeDataForStyleable(r2, r3, r4, r5, r6, r7, r8);
        return;
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        final int r1 = R.id.tag_screen_reader_focusable;
        final Class<Boolean> r2 = Boolean.class;
        final int r3 = 28;
        return new AnonymousClass1(r1, r2, r3);
    }

    public static void setAccessibilityDelegate(@NonNull View r1, @Nullable AccessibilityDelegateCompat r2) {
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
    public static void setAccessibilityHeading(@NonNull View r1, boolean r2) {
        accessibilityHeadingProperty().set(r1, Boolean.valueOf(r2));
    }

    public static void setAccessibilityLiveRegion(@NonNull View r2, int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.setAccessibilityLiveRegion(r2, r3);
        return;
    }

    @UiThread
    public static void setAccessibilityPaneTitle(@NonNull View r2, @Nullable CharSequence r3) {
        if (Build.VERSION.SDK_INT < 19) goto L9;
        paneTitleProperty().set(r2, r3);
        if (r3 == null) goto L7;
        sAccessibilityPaneVisibilityManager.addAccessibilityPane(r2);
        return;
    L7:
        sAccessibilityPaneVisibilityManager.removeAccessibilityPane(r2);
        return;
    }

    @Deprecated
    public static void setActivated(View r0, boolean r1) {
        r0.setActivated(r1);
    }

    @Deprecated
    public static void setAlpha(View r0, @FloatRange(from = 0.0d, to = 1.0d) float r1) {
        r0.setAlpha(r1);
    }

    public static void setAutofillHints(@NonNull View r2, @Nullable String... r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setAutofillHints(r2, r3);
        return;
    }

    public static void setBackground(@NonNull View r2, @Nullable Drawable r3) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.setBackground(r2, r3);
        return;
    L5:
        r2.setBackgroundDrawable(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setBackgroundTintList(@NonNull View r2, @Nullable ColorStateList r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L20;
        Api21Impl.setBackgroundTintList(r2, r3);
        if (r0 != 21) goto L23;
        Drawable r4 = r2.getBackground();
        if (Api21Impl.getBackgroundTintList(r2) == null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r4 == null) goto L24;
        if (r1 == true) goto L16;
        return;
    L16:
        if (r4.isStateful() == false) goto L18;
        r4.setState(r2.getDrawableState());
    L18:
        Api16Impl.setBackground(r2, r4);
        return;
    L24:
        return;
    L9:
        if (Api21Impl.getBackgroundTintMode(r2) != null) goto L12;
        r1 = false;
        goto L13
    L23:
        return;
    L20:
        if ((r2 instanceof TintableBackgroundView) == false) goto L27;
        ((TintableBackgroundView) r2).setSupportBackgroundTintList(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setBackgroundTintMode(@NonNull View r2, @Nullable PorterDuff.Mode r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L20;
        Api21Impl.setBackgroundTintMode(r2, r3);
        if (r0 != 21) goto L23;
        Drawable r4 = r2.getBackground();
        if (Api21Impl.getBackgroundTintList(r2) == null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r4 == null) goto L24;
        if (r1 == true) goto L16;
        return;
    L16:
        if (r4.isStateful() == false) goto L18;
        r4.setState(r2.getDrawableState());
    L18:
        Api16Impl.setBackground(r2, r4);
        return;
    L24:
        return;
    L9:
        if (Api21Impl.getBackgroundTintMode(r2) != null) goto L12;
        r1 = false;
        goto L13
    L23:
        return;
    L20:
        if ((r2 instanceof TintableBackgroundView) == false) goto L27;
        ((TintableBackgroundView) r2).setSupportBackgroundTintMode(r3);
        return;
    }

    @SuppressLint({"BanUncheckedReflection"})
    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup r8, boolean r9) {
        if (sChildrenDrawingOrderMethod != null) goto L16;
        sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
    L8:
        sChildrenDrawingOrderMethod.setAccessible(true);
    L6:
        e = move-exception;
        Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e);
    L16:
        sChildrenDrawingOrderMethod.invoke(r8, new Object[]{Boolean.valueOf(r9)});     // Catch: Throwable -> L11
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e);
    }

    public static void setClipBounds(@NonNull View r2, @Nullable Rect r3) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api18Impl.setClipBounds(r2, r3);
        return;
    }

    public static void setElevation(@NonNull View r2, float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setElevation(r2, r3);
        return;
    }

    @Deprecated
    public static void setFitsSystemWindows(View r0, boolean r1) {
        r0.setFitsSystemWindows(r1);
    }

    public static void setFocusedByDefault(@NonNull View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setFocusedByDefault(r2, r3);
        return;
    }

    public static void setHasTransientState(@NonNull View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        Api16Impl.setHasTransientState(r2, r3);
        return;
    }

    @UiThread
    public static void setImportantForAccessibility(@NonNull View r2, int r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 19) goto L6;
    L4:
        Api16Impl.setImportantForAccessibility(r2, r3);
        return;
    L6:
        if (r0 >= 16) goto L8;
        return;
    L8:
        if (r3 != 4) goto L4;
        r3 = 2;
        goto L4
    }

    public static void setImportantForAutofill(@NonNull View r2, int r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setImportantForAutofill(r2, r3);
        return;
    }

    public static void setKeyboardNavigationCluster(@NonNull View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setKeyboardNavigationCluster(r2, r3);
        return;
    }

    public static void setLabelFor(@NonNull View r2, @IdRes int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.setLabelFor(r2, r3);
        return;
    }

    public static void setLayerPaint(@NonNull View r2, @Nullable Paint r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.setLayerPaint(r2, r3);
        return;
    L5:
        r2.setLayerType(r2.getLayerType(), r3);
        r2.invalidate();
    }

    @Deprecated
    public static void setLayerType(View r0, int r1, Paint r2) {
        r0.setLayerType(r1, r2);
    }

    public static void setLayoutDirection(@NonNull View r2, int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.setLayoutDirection(r2, r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setNestedScrollingEnabled(@NonNull View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setNestedScrollingEnabled(r2, r3);
        return;
    L6:
        if ((r2 instanceof NestedScrollingChild) == false) goto L10;
        ((NestedScrollingChild) r2).setNestedScrollingEnabled(r3);
        return;
    }

    public static void setNextClusterForwardId(@NonNull View r2, int r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setNextClusterForwardId(r2, r3);
        return;
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View r2, @Nullable OnApplyWindowInsetsListener r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setOnApplyWindowInsetsListener(r2, r3);
        return;
    }

    public static void setOnReceiveContentListener(@NonNull View r6, @Nullable String[] r7, @Nullable OnReceiveContentListener r8) {
        if (Build.VERSION.SDK_INT < 31) goto L6;
        Api31Impl.setOnReceiveContentListener(r6, r7, r8);
        return;
    L6:
        if (r7 != null) goto L8;
    L9:
        r7 = null;
    L10:
        boolean r0 = false;
        if (r8 == null) goto L16;
        if (r7 == null) goto L14;
        boolean r2 = true;
    L15:
        Preconditions.checkArgument(r2, "When the listener is set, MIME types must also be set");
        goto L16
    L14:
        r2 = false;
    L16:
        if (r7 == null) goto L24;
        int r3 = r7.length;
        int r4 = 0;
    L18:
        if (r4 >= r3) goto L23;
        if (r7[r4].startsWith("*") == true) goto L21;
        r4 = r4 + 1;
        goto L18
    L21:
        r0 = true;
    L23:
        Preconditions.checkArgument(!r0, "A MIME type set here must not start with *: " + Arrays.toString(r7));
    L24:
        r6.setTag(R.id.tag_on_receive_content_mime_types, r7);
        r6.setTag(R.id.tag_on_receive_content_listener, r8);
        return;
    L8:
        if (r7.length != 0) goto L10;
        goto L9
    }

    @Deprecated
    public static void setOverScrollMode(View r0, int r1) {
        r0.setOverScrollMode(r1);
    }

    public static void setPaddingRelative(@NonNull View r2, @Px int r3, @Px int r4, @Px int r5, @Px int r6) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.setPaddingRelative(r2, r3, r4, r5, r6);
        return;
    L5:
        r2.setPadding(r3, r4, r5, r6);
    }

    @Deprecated
    public static void setPivotX(View r0, float r1) {
        r0.setPivotX(r1);
    }

    @Deprecated
    public static void setPivotY(View r0, float r1) {
        r0.setPivotY(r1);
    }

    public static void setPointerIcon(@NonNull View r2, @Nullable PointerIconCompat r3) {
        if (Build.VERSION.SDK_INT < 24) goto L9;
        if (r3 == null) goto L6;
        Object r4 = r3.getPointerIcon();
    L7:
        Api24Impl.setPointerIcon(r2, (PointerIcon) r4);
        return;
    L6:
        r4 = null;
        goto L7
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
    public static void setScreenReaderFocusable(@NonNull View r1, boolean r2) {
        screenReaderFocusableProperty().set(r1, Boolean.valueOf(r2));
    }

    public static void setScrollIndicators(@NonNull View r2, int r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setScrollIndicators(r2, r3);
        return;
    }

    public static void setScrollIndicators(@NonNull View r2, int r3, int r4) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Api23Impl.setScrollIndicators(r2, r3, r4);
        return;
    }

    @UiThread
    public static void setStateDescription(@NonNull View r2, @Nullable CharSequence r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        stateDescriptionProperty().set(r2, r3);
        return;
    }

    public static void setSystemGestureExclusionRects(@NonNull View r2, @NonNull List<Rect> r3) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.setSystemGestureExclusionRects(r2, r3);
        return;
    }

    public static void setTooltipText(@NonNull View r2, @Nullable CharSequence r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Impl.setTooltipText(r2, r3);
        return;
    }

    public static void setTransitionName(@NonNull View r2, @Nullable String r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTransitionName(r2, r3);
        return;
    L6:
        if (sTransitionNameMap != null) goto L8;
        sTransitionNameMap = new WeakHashMap();
    L8:
        sTransitionNameMap.put(r2, r3);
    }

    @Deprecated
    public static void setTranslationX(View r0, float r1) {
        r0.setTranslationX(r1);
    }

    @Deprecated
    public static void setTranslationY(View r0, float r1) {
        r0.setTranslationY(r1);
    }

    public static void setTranslationZ(@NonNull View r2, float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setTranslationZ(r2, r3);
        return;
    }

    private static void setViewImportanceForAccessibilityIfNeeded(View r3) {
        if (getImportantForAccessibility(r3) != 0) goto L5;
        setImportantForAccessibility(r3, 1);
    L5:
        ViewParent r0 = r3.getParent();
    L7:
        if ((r0 instanceof View) == false) goto L15;
        if (getImportantForAccessibility((View) r0) == 4) goto L10;
        r0 = r0.getParent();
        goto L7
    L10:
        setImportantForAccessibility(r3, 2);
        return;
    }

    public static void setWindowInsetsAnimationCallback(@NonNull View r0, @Nullable WindowInsetsAnimationCompat.Callback r1) {
        WindowInsetsAnimationCompat.setCallback(r0, r1);
    }

    @Deprecated
    public static void setX(View r0, float r1) {
        r0.setX(r1);
    }

    @Deprecated
    public static void setY(View r0, float r1) {
        r0.setY(r1);
    }

    public static void setZ(@NonNull View r2, float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.setZ(r2, r3);
        return;
    }

    public static boolean startDragAndDrop(@NonNull View r2, @Nullable ClipData r3, @NonNull View.DragShadowBuilder r4, @Nullable Object r5, int r6) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.startDragAndDrop(r2, r3, r4, r5, r6);
    L7:
        return r2.startDrag(r3, r4, r5, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean startNestedScroll(@NonNull View r2, int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.startNestedScroll(r2, r3);
    L7:
        if ((r2 instanceof NestedScrollingChild) == true) goto L9;
        return false;
    L9:
        return ((NestedScrollingChild) r2).startNestedScroll(r3);
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

    private static AccessibilityViewProperty<CharSequence> stateDescriptionProperty() {
        final int r1 = R.id.tag_state_description;
        final Class<CharSequence> r2 = CharSequence.class;
        final int r3 = 64;
        final int r4 = 30;
        return new AnonymousClass3(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void stopNestedScroll(@NonNull View r2) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.stopNestedScroll(r2);
        return;
    L6:
        if ((r2 instanceof NestedScrollingChild) == false) goto L10;
        ((NestedScrollingChild) r2).stopNestedScroll();
        return;
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

    private static void tickleInvalidationFlag(View r2) {
        float r0 = r2.getTranslationY();
        r2.setTranslationY(1.0f + r0);
        r2.setTranslationY(r0);
    }

    public static void updateDragShadow(@NonNull View r2, @NonNull View.DragShadowBuilder r3) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api24Impl.updateDragShadow(r2, r3);
        return;
    }
}
