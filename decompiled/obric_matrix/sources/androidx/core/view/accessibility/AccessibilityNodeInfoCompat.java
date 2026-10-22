package androidx.core.view.accessibility;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";

    @SuppressLint({"ActionValue"})
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    public static final int EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH = 20000;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static final String UNIQUE_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY";
    private static int sClickableSpanId;
    private final AccessibilityNodeInfo mInfo;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mParentVirtualDescendantId;
    private int mVirtualDescendantId;

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = null;
        public static final AccessibilityActionCompat ACTION_CLICK = null;
        public static final AccessibilityActionCompat ACTION_COLLAPSE = null;
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK = null;
        public static final AccessibilityActionCompat ACTION_COPY = null;
        public static final AccessibilityActionCompat ACTION_CUT = null;
        public static final AccessibilityActionCompat ACTION_DISMISS = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_CANCEL = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_DROP = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_START = null;
        public static final AccessibilityActionCompat ACTION_EXPAND = null;
        public static final AccessibilityActionCompat ACTION_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_IME_ENTER = null;
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = null;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW = null;
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = null;
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_UP = null;
        public static final AccessibilityActionCompat ACTION_PASTE = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_PRESS_AND_HOLD = null;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = null;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP = null;
        public static final AccessibilityActionCompat ACTION_SELECT = null;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS = null;
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = null;
        public static final AccessibilityActionCompat ACTION_SET_TEXT = null;
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN = null;

        @NonNull
        public static final AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS = null;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP = null;
        private static final String TAG = "A11yActionCompat";
        final Object mAction;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected final AccessibilityViewCommand mCommand;
        private final int mId;
        private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;

        static {
            AccessibilityNodeInfo.AccessibilityAction r4 = null;
            ACTION_FOCUS = new AccessibilityActionCompat(1, null);
            ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
            ACTION_SELECT = new AccessibilityActionCompat(4, null);
            ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
            ACTION_CLICK = new AccessibilityActionCompat(16, null);
            ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
            ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
            ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
            ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null, AccessibilityViewCommand.MoveHtmlArguments.class);
            ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null, AccessibilityViewCommand.MoveHtmlArguments.class);
            ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
            ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
            ACTION_COPY = new AccessibilityActionCompat(16384, null);
            ACTION_PASTE = new AccessibilityActionCompat(32768, null);
            ACTION_CUT = new AccessibilityActionCompat(65536, null);
            ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null, AccessibilityViewCommand.SetSelectionArguments.class);
            ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
            ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
            ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
            ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null, AccessibilityViewCommand.SetTextArguments.class);
            int r1 = Build.VERSION.SDK_INT;
            if (r1 < 23) goto L5;
            AccessibilityNodeInfo.AccessibilityAction r6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        L6:
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(r6, R.id.accessibilityActionShowOnScreen, null, null, null);
            if (r1 < 23) goto L9;
            AccessibilityNodeInfo.AccessibilityAction r12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        L10:
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(r12, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            if (r1 < 23) goto L13;
            AccessibilityNodeInfo.AccessibilityAction r7 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        L14:
            ACTION_SCROLL_UP = new AccessibilityActionCompat(r7, R.id.accessibilityActionScrollUp, null, null, null);
            if (r1 < 23) goto L17;
            AccessibilityNodeInfo.AccessibilityAction r13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        L18:
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(r13, R.id.accessibilityActionScrollLeft, null, null, null);
            if (r1 < 23) goto L21;
            AccessibilityNodeInfo.AccessibilityAction r8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        L22:
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(r8, R.id.accessibilityActionScrollDown, null, null, null);
            if (r1 < 23) goto L25;
            AccessibilityNodeInfo.AccessibilityAction r14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        L26:
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(r14, R.id.accessibilityActionScrollRight, null, null, null);
            if (r1 < 29) goto L29;
            AccessibilityNodeInfo.AccessibilityAction r9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
        L30:
            ACTION_PAGE_UP = new AccessibilityActionCompat(r9, R.id.accessibilityActionPageUp, null, null, null);
            if (r1 < 29) goto L33;
            AccessibilityNodeInfo.AccessibilityAction r15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
        L34:
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(r15, R.id.accessibilityActionPageDown, null, null, null);
            if (r1 < 29) goto L37;
            AccessibilityNodeInfo.AccessibilityAction r10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
        L38:
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(r10, R.id.accessibilityActionPageLeft, null, null, null);
            if (r1 < 29) goto L41;
            AccessibilityNodeInfo.AccessibilityAction r16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
        L42:
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(r16, R.id.accessibilityActionPageRight, null, null, null);
            if (r1 < 23) goto L45;
            AccessibilityNodeInfo.AccessibilityAction r11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        L46:
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(r11, R.id.accessibilityActionContextClick, null, null, null);
            if (r1 < 24) goto L49;
            AccessibilityNodeInfo.AccessibilityAction r17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        L50:
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(r17, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            if (r1 < 26) goto L53;
            AccessibilityNodeInfo.AccessibilityAction r18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        L54:
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(r18, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            if (r1 < 28) goto L57;
            AccessibilityNodeInfo.AccessibilityAction r19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
        L58:
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(r19, R.id.accessibilityActionShowTooltip, null, null, null);
            if (r1 < 28) goto L61;
            AccessibilityNodeInfo.AccessibilityAction r20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
        L62:
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(r20, R.id.accessibilityActionHideTooltip, null, null, null);
            if (r1 < 30) goto L65;
            AccessibilityNodeInfo.AccessibilityAction r110 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
        L66:
            ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(r110, R.id.accessibilityActionPressAndHold, null, null, null);
            if (r1 < 30) goto L69;
            AccessibilityNodeInfo.AccessibilityAction r21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
        L70:
            ACTION_IME_ENTER = new AccessibilityActionCompat(r21, R.id.accessibilityActionImeEnter, null, null, null);
            if (r1 < 32) goto L73;
            AccessibilityNodeInfo.AccessibilityAction r111 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
        L74:
            ACTION_DRAG_START = new AccessibilityActionCompat(r111, R.id.accessibilityActionDragStart, null, null, null);
            if (r1 < 32) goto L77;
            AccessibilityNodeInfo.AccessibilityAction r22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
        L78:
            ACTION_DRAG_DROP = new AccessibilityActionCompat(r22, R.id.accessibilityActionDragDrop, null, null, null);
            if (r1 < 32) goto L81;
            AccessibilityNodeInfo.AccessibilityAction r112 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
        L82:
            ACTION_DRAG_CANCEL = new AccessibilityActionCompat(r112, R.id.accessibilityActionDragCancel, null, null, null);
            if (r1 < 33) goto L85;
            r4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
        L85:
            ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityActionCompat(r4, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            return;
        L81:
            r112 = null;
            goto L82
        L77:
            r22 = null;
            goto L78
        L73:
            r111 = null;
            goto L74
        L69:
            r21 = null;
            goto L70
        L65:
            r110 = null;
            goto L66
        L61:
            r20 = null;
            goto L62
        L57:
            r19 = null;
            goto L58
        L53:
            r18 = null;
            goto L54
        L49:
            r17 = null;
            goto L50
        L45:
            r11 = null;
            goto L46
        L41:
            r16 = null;
            goto L42
        L37:
            r10 = null;
            goto L38
        L33:
            r15 = null;
            goto L34
        L29:
            r9 = null;
            goto L30
        L25:
            r14 = null;
            goto L26
        L21:
            r8 = null;
            goto L22
        L17:
            r13 = null;
            goto L18
        L13:
            r7 = null;
            goto L14
        L9:
            r12 = null;
            goto L10
        L5:
            r6 = null;
            goto L6
        }

        public AccessibilityActionCompat(int r7, CharSequence r8) {
            this(null, r7, r8, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int r7, CharSequence r8, AccessibilityViewCommand r9) {
            this(null, r7, r8, r9, null);
        }

        private AccessibilityActionCompat(int r7, CharSequence r8, Class<? extends AccessibilityViewCommand.CommandArguments> r9) {
            this(null, r7, r8, null, r9);
        }

        AccessibilityActionCompat(Object r7) {
            this(r7, 0, null, null, null);
        }

        AccessibilityActionCompat(Object r2, int r3, CharSequence r4, AccessibilityViewCommand r5, Class<? extends AccessibilityViewCommand.CommandArguments> r6) {
            this.mId = r3;
            this.mCommand = r5;
            if (Build.VERSION.SDK_INT < 21) goto L6;
            if (r2 != null) goto L6;
            r2 = new AccessibilityNodeInfo.AccessibilityAction(r3, r4);
        L6:
            this.mAction = r2;
            this.mViewCommandArgumentClass = r6;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat createReplacementAction(CharSequence r8, AccessibilityViewCommand r9) {
            return new AccessibilityActionCompat(null, this.mId, r8, r9, this.mViewCommandArgumentClass);
        }

        public boolean equals(@Nullable Object r3) {
            if (r3 != null) goto L6;
            return false;
        L6:
            if ((r3 instanceof AccessibilityActionCompat) == true) goto L8;
            return false;
        L8:
            AccessibilityActionCompat r4 = (AccessibilityActionCompat) r3;
            Object r2 = this.mAction;
            if (r2 != null) goto L14;
            if (r4.mAction == null) goto L16;
            return false;
        L16:
            return true;
        L14:
            if (r2.equals(r4.mAction) == true) goto L18;
            return false;
        L18:
            return true;
        }

        public int getId() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
        }

        public CharSequence getLabel() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return null;
        L5:
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getLabel();
        }

        public int hashCode() {
            Object r0 = this.mAction;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean perform(View r5, Bundle r6) {
            if (this.mCommand == null) goto L19;
            AccessibilityViewCommand.CommandArguments r0 = null;
            Class<? extends AccessibilityViewCommand.CommandArguments> r2 = this.mViewCommandArgumentClass;
            if (r2 == null) goto L18;
            AccessibilityViewCommand.CommandArguments r1 = r2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L11
            r1.setBundle(r6);     // Catch: Exception -> L9
            r0 = r1;
        L9:
            e = e;
            r0 = r1;
        L12:
            Class<? extends AccessibilityViewCommand.CommandArguments> r3 = this.mViewCommandArgumentClass;
            if (r3 != null) goto L15;
            String r4 = "null";
        L16:
            Log.e(TAG, "Failed to execute command with argument class ViewCommandArgument: " + r4, e);
            goto L18
        L15:
            r4 = r3.getName();
        L11:
            e = e;
        L18:
            return this.mCommand.perform(r5, r0);
        L19:
            return false;
        }
    }

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo r0) {
            return r0.getExtraRenderingInfo();
        }

        @DoNotInline
        public static boolean isTextSelectable(AccessibilityNodeInfo r0) {
            return r0.isTextSelectable();
        }

        @DoNotInline
        public static void setTextSelectable(AccessibilityNodeInfo r0, boolean r1) {
            r0.setTextSelectable(r1);
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        CollectionInfoCompat(Object r1) {
            this.mInfo = r1;
        }

        public static CollectionInfoCompat obtain(int r2, int r3, boolean r4) {
            if (Build.VERSION.SDK_INT < 19) goto L7;
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r2, r3, r4));
        L7:
            return new CollectionInfoCompat(null);
        }

        public static CollectionInfoCompat obtain(int r2, int r3, boolean r4, int r5) {
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 21) goto L7;
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r2, r3, r4, r5));
        L7:
            if (r0 < 19) goto L11;
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r2, r3, r4));
        L11:
            return new CollectionInfoCompat(null);
        }

        public int getColumnCount() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return -1;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getColumnCount();
        }

        public int getRowCount() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return -1;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getRowCount();
        }

        public int getSelectionMode() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getSelectionMode();
        }

        public boolean isHierarchical() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return false;
        L5:
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).isHierarchical();
        }
    }

    public static class CollectionItemInfoCompat {
        final Object mInfo;

        CollectionItemInfoCompat(Object r1) {
            this.mInfo = r1;
        }

        public static CollectionItemInfoCompat obtain(int r2, int r3, int r4, int r5, boolean r6) {
            if (Build.VERSION.SDK_INT < 19) goto L7;
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r2, r3, r4, r5, r6));
        L7:
            return new CollectionItemInfoCompat(null);
        }

        public static CollectionItemInfoCompat obtain(int r2, int r3, int r4, int r5, boolean r6, boolean r7) {
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 21) goto L7;
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r2, r3, r4, r5, r6, r7));
        L7:
            if (r0 < 19) goto L11;
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r2, r3, r4, r5, r6));
        L11:
            return new CollectionItemInfoCompat(null);
        }

        public int getColumnIndex() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnIndex();
        }

        public int getColumnSpan() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnSpan();
        }

        public int getRowIndex() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowIndex();
        }

        public int getRowSpan() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowSpan();
        }

        @Deprecated
        public boolean isHeading() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return false;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isHeading();
        }

        public boolean isSelected() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return false;
        L5:
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isSelected();
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        RangeInfoCompat(Object r1) {
            this.mInfo = r1;
        }

        public static RangeInfoCompat obtain(int r2, float r3, float r4, float r5) {
            if (Build.VERSION.SDK_INT < 19) goto L7;
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(r2, r3, r4, r5));
        L7:
            return new RangeInfoCompat(null);
        }

        public float getCurrent() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0.0f;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getCurrent();
        }

        public float getMax() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0.0f;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMax();
        }

        public float getMin() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0.0f;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMin();
        }

        public int getType() {
            if (Build.VERSION.SDK_INT >= 19) goto L5;
            return 0;
        L5:
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getType();
        }
    }

    public static final class TouchDelegateInfoCompat {
        final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo r1) {
            this.mInfo = r1;
        }

        public TouchDelegateInfoCompat(@NonNull Map<Region, View> r3) {
            if (Build.VERSION.SDK_INT < 29) goto L5;
            this.mInfo = new AccessibilityNodeInfo.TouchDelegateInfo(r3);
            return;
        L5:
            this.mInfo = null;
        }

        @Nullable
        public Region getRegionAt(@IntRange(from = 0) int r3) {
            if (Build.VERSION.SDK_INT >= 29) goto L5;
            return null;
        L5:
            return this.mInfo.getRegionAt(r3);
        }

        @IntRange(from = 0)
        public int getRegionCount() {
            if (Build.VERSION.SDK_INT >= 29) goto L5;
            return 0;
        L5:
            return this.mInfo.getRegionCount();
        }

        @Nullable
        public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region r3) {
            if (Build.VERSION.SDK_INT < 29) goto L8;
            AccessibilityNodeInfo r2 = this.mInfo.getTargetForRegion(r3);
            if (r2 != null) goto L7;
            return null;
        L7:
            return AccessibilityNodeInfoCompat.wrap(r2);
        L8:
            return null;
        }
    }

    static {
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo r2) {
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = r2;
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object r2) {
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = (AccessibilityNodeInfo) r2;
    }

    private void addSpanLocationToExtras(ClickableSpan r3, Spanned r4, int r5) {
        extrasIntList(SPANS_START_KEY).add(Integer.valueOf(r4.getSpanStart(r3)));
        extrasIntList(SPANS_END_KEY).add(Integer.valueOf(r4.getSpanEnd(r3)));
        extrasIntList(SPANS_FLAGS_KEY).add(Integer.valueOf(r4.getSpanFlags(r3)));
        extrasIntList(SPANS_ID_KEY).add(Integer.valueOf(r5));
    }

    private void clearExtrasSpans() {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.getExtras().remove(SPANS_START_KEY);
        this.mInfo.getExtras().remove(SPANS_END_KEY);
        this.mInfo.getExtras().remove(SPANS_FLAGS_KEY);
        this.mInfo.getExtras().remove(SPANS_ID_KEY);
        return;
    }

    private List<Integer> extrasIntList(String r3) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        ArrayList<Integer> r0 = this.mInfo.getExtras().getIntegerArrayList(r3);
        if (r0 != null) goto L10;
        ArrayList<Integer> r1 = new ArrayList();
        this.mInfo.getExtras().putIntegerArrayList(r3, r1);
        return r1;
    L10:
        return r0;
    L5:
        return new ArrayList();
    }

    private static String getActionSymbolicName(int r1) {
        if (r1 != 1) goto L5;
        return "ACTION_FOCUS";
    L5:
        if (r1 == 2) goto L90;
        switch(r1) {
            case 4: goto L88;
            case 8: goto L86;
            case 16: goto L84;
            case 32: goto L82;
            case 64: goto L80;
            case 128: goto L78;
            case 256: goto L76;
            case 512: goto L74;
            case 1024: goto L72;
            case 2048: goto L70;
            case 4096: goto L68;
            case 8192: goto L66;
            case 16384: goto L64;
            case 32768: goto L62;
            case 65536: goto L60;
            case 131072: goto L58;
            case 262144: goto L56;
            case 524288: goto L54;
            case 2097152: goto L52;
            case 16908354: goto L50;
            default: goto L7;
        };
    L7:
        switch(r1) {
            case 16908342: goto L48;
            case 16908343: goto L46;
            case 16908344: goto L44;
            case 16908345: goto L42;
            case 16908346: goto L40;
            case 16908347: goto L38;
            case 16908348: goto L36;
            case 16908349: goto L34;
            default: goto L8;
        };
    L8:
        switch(r1) {
            case 16908356: goto L32;
            case 16908357: goto L30;
            case 16908358: goto L28;
            case 16908359: goto L26;
            case 16908360: goto L24;
            case 16908361: goto L22;
            case 16908362: goto L20;
            default: goto L9;
        };
    L9:
        switch(r1) {
            case 16908372: goto L18;
            case 16908373: goto L16;
            case 16908374: goto L14;
            case 16908375: goto L12;
            default: goto L10;
        };
    L10:
        return "ACTION_UNKNOWN";
    L12:
        return "ACTION_DRAG_CANCEL";
    L14:
        return "ACTION_DRAG_DROP";
    L16:
        return "ACTION_DRAG_START";
    L18:
        return "ACTION_IME_ENTER";
    L20:
        return "ACTION_PRESS_AND_HOLD";
    L22:
        return "ACTION_PAGE_RIGHT";
    L24:
        return "ACTION_PAGE_LEFT";
    L26:
        return "ACTION_PAGE_DOWN";
    L28:
        return "ACTION_PAGE_UP";
    L30:
        return "ACTION_HIDE_TOOLTIP";
    L32:
        return "ACTION_SHOW_TOOLTIP";
    L34:
        return "ACTION_SET_PROGRESS";
    L36:
        return "ACTION_CONTEXT_CLICK";
    L38:
        return "ACTION_SCROLL_RIGHT";
    L40:
        return "ACTION_SCROLL_DOWN";
    L42:
        return "ACTION_SCROLL_LEFT";
    L44:
        return "ACTION_SCROLL_UP";
    L46:
        return "ACTION_SCROLL_TO_POSITION";
    L48:
        return "ACTION_SHOW_ON_SCREEN";
    L50:
        return "ACTION_MOVE_WINDOW";
    L52:
        return "ACTION_SET_TEXT";
    L54:
        return "ACTION_COLLAPSE";
    L56:
        return "ACTION_EXPAND";
    L58:
        return "ACTION_SET_SELECTION";
    L60:
        return "ACTION_CUT";
    L62:
        return "ACTION_PASTE";
    L64:
        return "ACTION_COPY";
    L66:
        return "ACTION_SCROLL_BACKWARD";
    L68:
        return "ACTION_SCROLL_FORWARD";
    L70:
        return "ACTION_PREVIOUS_HTML_ELEMENT";
    L72:
        return "ACTION_NEXT_HTML_ELEMENT";
    L74:
        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    L76:
        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    L78:
        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    L80:
        return "ACTION_ACCESSIBILITY_FOCUS";
    L82:
        return "ACTION_LONG_CLICK";
    L84:
        return "ACTION_CLICK";
    L86:
        return "ACTION_CLEAR_SELECTION";
    L88:
        return "ACTION_SELECT";
    L90:
        return "ACTION_CLEAR_FOCUS";
    }

    private boolean getBooleanProperty(int r3) {
        Bundle r2 = getExtras();
        if (r2 != null) goto L6;
        return false;
    L6:
        if ((r2.getInt(BOOLEAN_PROPERTY_KEY, 0) & r3) != r3) goto L9;
        return true;
    L9:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] getClickableSpans(CharSequence r3) {
        if ((r3 instanceof Spanned) == true) goto L5;
        return null;
    L5:
        return (ClickableSpan[]) ((Spanned) r3).getSpans(0, r3.length(), ClickableSpan.class);
    }

    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View r2) {
        SparseArray<WeakReference<ClickableSpan>> r1 = getSpansFromViewTags(r2);
        if (r1 != null) goto L6;
        SparseArray<WeakReference<ClickableSpan>> r3 = new SparseArray();
        r2.setTag(androidx.core.R.id.tag_accessibility_clickable_spans, r3);
        return r3;
    L6:
        return r1;
    }

    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View r1) {
        return (SparseArray) r1.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
    }

    private boolean hasSpans() {
        return !extrasIntList(SPANS_START_KEY).isEmpty();
    }

    private int idForClickableSpan(ClickableSpan r2, SparseArray<WeakReference<ClickableSpan>> r3) {
        if (r3 == null) goto L11;
        int r1 = 0;
    L5:
        if (r1 >= r3.size()) goto L11;
        if (r2.equals(r3.valueAt(r1).get()) == true) goto L9;
        r1 = r1 + 1;
        goto L5
    L9:
        return r3.keyAt(r1);
    L11:
        int r4 = sClickableSpanId;
        sClickableSpanId = r4 + 1;
        return r4;
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(View r0) {
        return wrap(AccessibilityNodeInfo.obtain(r0));
    }

    public static AccessibilityNodeInfoCompat obtain(View r2, int r3) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(AccessibilityNodeInfo.obtain(r2, r3));
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat r0) {
        return wrap(AccessibilityNodeInfo.obtain(r0.mInfo));
    }

    private void removeCollectedSpans(View r4) {
        SparseArray<WeakReference<ClickableSpan>> r3 = getSpansFromViewTags(r4);
        if (r3 == null) goto L14;
        ArrayList r5 = new ArrayList();
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r1 >= r3.size()) goto L12;
        if (r3.valueAt(r1).get() != null) goto L10;
        r5.add(Integer.valueOf(r1));
    L10:
        r1 = r1 + 1;
    L12:
        if (r0 >= r5.size()) goto L19;
        r3.remove(((Integer) r5.get(r0)).intValue());
        r0 = r0 + 1;
        goto L12
    L19:
        return;
    }

    private void setBooleanProperty(int r5, boolean r6) {
        Bundle r4 = getExtras();
        if (r4 == null) goto L10;
        int r2 = r4.getInt(BOOLEAN_PROPERTY_KEY, 0) & (~r5);
        if (r6 == true) goto L8;
        r5 = 0;
    L8:
        r4.putInt(BOOLEAN_PROPERTY_KEY, r5 | r2);
        return;
    }

    public static AccessibilityNodeInfoCompat wrap(@NonNull AccessibilityNodeInfo r1) {
        return new AccessibilityNodeInfoCompat(r1);
    }

    static AccessibilityNodeInfoCompat wrapNonNullInstance(Object r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        return new AccessibilityNodeInfoCompat(r1);
    }

    public void addAction(int r1) {
        this.mInfo.addAction(r1);
    }

    public void addAction(AccessibilityActionCompat r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) r3.mAction);
        return;
    }

    public void addChild(View r1) {
        this.mInfo.addChild(r1);
    }

    public void addChild(View r3, int r4) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.addChild(r3, r4);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addSpansToExtras(CharSequence r6, View r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 19) goto L5;
        return;
    L5:
        if (r0 >= 26) goto L18;
        clearExtrasSpans();
        removeCollectedSpans(r7);
        ClickableSpan[] r1 = getClickableSpans(r6);
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.length <= 0) goto L20;
        getExtras().putInt(SPANS_ACTION_ID_KEY, androidx.core.R.id.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> r8 = getOrCreateSpansFromViewTags(r7);
        int r2 = 0;
    L11:
        if (r1 == null) goto L21;
        if (r2 >= r1.length) goto L22;
        int r3 = idForClickableSpan(r1[r2], r8);
        r8.put(r3, new WeakReference(r1[r2]));
        addSpanLocationToExtras(r1[r2], (Spanned) r6, r3);
        r2 = r2 + 1;
        goto L11
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public boolean canOpenPopup() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return this.mInfo.canOpenPopup();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if ((r5 instanceof AccessibilityNodeInfoCompat) == true) goto L11;
        return false;
    L11:
        AccessibilityNodeInfoCompat r6 = (AccessibilityNodeInfoCompat) r5;
        AccessibilityNodeInfo r2 = this.mInfo;
        if (r2 != null) goto L17;
        if (r6.mInfo == null) goto L20;
        return false;
    L20:
        if (this.mVirtualDescendantId == r6.mVirtualDescendantId) goto L23;
        return false;
    L23:
        if (this.mParentVirtualDescendantId == r6.mParentVirtualDescendantId) goto L25;
        return false;
    L25:
        return true;
    L17:
        if (r2.equals(r6.mInfo) == true) goto L20;
        return false;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String r4) {
        ArrayList r0 = new ArrayList();
        List<AccessibilityNodeInfo> r3 = this.mInfo.findAccessibilityNodeInfosByText(r4);
        int r5 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        r0.add(wrap(r3.get(r1)));
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String r3) {
        if (Build.VERSION.SDK_INT < 18) goto L10;
        List<AccessibilityNodeInfo> r2 = this.mInfo.findAccessibilityNodeInfosByViewId(r3);
        ArrayList r4 = new ArrayList();
        Iterator<AccessibilityNodeInfo> r5 = r2.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r4.add(wrap(r5.next()));
        goto L6
    L8:
        return r4;
    L10:
        return Collections.emptyList();
    }

    public AccessibilityNodeInfoCompat findFocus(int r3) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.findFocus(r3));
    }

    public AccessibilityNodeInfoCompat focusSearch(int r3) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.focusSearch(r3));
    }

    public List<AccessibilityActionCompat> getActionList() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        List<AccessibilityNodeInfo.AccessibilityAction> r5 = this.mInfo.getActionList();
    L6:
        if (r5 == null) goto L12;
        ArrayList r0 = new ArrayList();
        int r1 = r5.size();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L10;
        r0.add(new AccessibilityActionCompat(r5.get(r2)));
        r2 = r2 + 1;
        goto L8
    L10:
        return r0;
    L12:
        return Collections.emptyList();
    L5:
        r5 = null;
        goto L6
    }

    @Deprecated
    public int getActions() {
        return this.mInfo.getActions();
    }

    @NonNull
    public List<String> getAvailableExtraData() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mInfo.getAvailableExtraData();
    L7:
        return Collections.emptyList();
    }

    @Deprecated
    public void getBoundsInParent(Rect r1) {
        this.mInfo.getBoundsInParent(r1);
    }

    public void getBoundsInScreen(Rect r1) {
        this.mInfo.getBoundsInScreen(r1);
    }

    public AccessibilityNodeInfoCompat getChild(int r1) {
        return wrapNonNullInstance(this.mInfo.getChild(r1));
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public CollectionInfoCompat getCollectionInfo() {
        if (Build.VERSION.SDK_INT < 19) goto L8;
        AccessibilityNodeInfo.CollectionInfo r2 = this.mInfo.getCollectionInfo();
        if (r2 != null) goto L7;
        return null;
    L7:
        return new CollectionInfoCompat(r2);
    L8:
        return null;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        if (Build.VERSION.SDK_INT < 19) goto L8;
        AccessibilityNodeInfo.CollectionItemInfo r2 = this.mInfo.getCollectionItemInfo();
        if (r2 != null) goto L7;
        return null;
    L7:
        return new CollectionItemInfoCompat(r2);
    L8:
        return null;
    }

    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return 0;
    L5:
        return this.mInfo.getDrawingOrder();
    }

    public CharSequence getError() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return this.mInfo.getError();
    }

    @Nullable
    public AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return null;
    L5:
        return Api33Impl.getExtraRenderingInfo(this.mInfo);
    }

    public Bundle getExtras() {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return this.mInfo.getExtras();
    L7:
        return new Bundle();
    }

    @Nullable
    public CharSequence getHintText() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L7;
        return this.mInfo.getHintText();
    L7:
        if (r0 >= 19) goto L9;
        return null;
    L9:
        return this.mInfo.getExtras().getCharSequence(HINT_TEXT_KEY);
    }

    @Deprecated
    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return this.mInfo.getInputType();
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    public int getLiveRegion() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return this.mInfo.getMaxTextLength();
    }

    public int getMovementGranularities() {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return this.mInfo.getMovementGranularities();
    }

    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    @Nullable
    public CharSequence getPaneTitle() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L7;
        return this.mInfo.getPaneTitle();
    L7:
        if (r0 >= 19) goto L9;
        return null;
    L9:
        return this.mInfo.getExtras().getCharSequence(PANE_TITLE_KEY);
    }

    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    public RangeInfoCompat getRangeInfo() {
        if (Build.VERSION.SDK_INT < 19) goto L8;
        AccessibilityNodeInfo.RangeInfo r2 = this.mInfo.getRangeInfo();
        if (r2 != null) goto L7;
        return null;
    L7:
        return new RangeInfoCompat(r2);
    L8:
        return null;
    }

    @Nullable
    public CharSequence getRoleDescription() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return this.mInfo.getExtras().getCharSequence(ROLE_DESCRIPTION_KEY);
    }

    @Nullable
    public CharSequence getStateDescription() {
        if (BuildCompat.isAtLeastR() == false) goto L7;
        return this.mInfo.getStateDescription();
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return this.mInfo.getExtras().getCharSequence(STATE_DESCRIPTION_KEY);
    }

    public CharSequence getText() {
        if (hasSpans() == false) goto L10;
        List<Integer> r0 = extrasIntList(SPANS_START_KEY);
        List<Integer> r1 = extrasIntList(SPANS_END_KEY);
        List<Integer> r2 = extrasIntList(SPANS_FLAGS_KEY);
        List<Integer> r3 = extrasIntList(SPANS_ID_KEY);
        int r7 = 0;
        SpannableString r4 = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
    L6:
        if (r7 >= r0.size()) goto L8;
        r4.setSpan(new AccessibilityClickableSpanCompat(r3.get(r7).intValue(), this, getExtras().getInt(SPANS_ACTION_ID_KEY)), r0.get(r7).intValue(), r1.get(r7).intValue(), r2.get(r7).intValue());
        r7 = r7 + 1;
        goto L6
    L8:
        return r4;
    L10:
        return this.mInfo.getText();
    }

    public int getTextSelectionEnd() {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return -1;
    L5:
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return -1;
    L5:
        return this.mInfo.getTextSelectionStart();
    }

    @Nullable
    public CharSequence getTooltipText() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L7;
        return this.mInfo.getTooltipText();
    L7:
        if (r0 >= 19) goto L9;
        return null;
    L9:
        return this.mInfo.getExtras().getCharSequence(TOOLTIP_TEXT_KEY);
    }

    @Nullable
    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        AccessibilityNodeInfo.TouchDelegateInfo r2 = this.mInfo.getTouchDelegateInfo();
        if (r2 != null) goto L7;
        return null;
    L7:
        return new TouchDelegateInfoCompat(r2);
    L8:
        return null;
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.getTraversalAfter());
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.getTraversalBefore());
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public String getUniqueId() {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return this.mInfo.getUniqueId();
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return null;
    L9:
        return this.mInfo.getExtras().getString(UNIQUE_ID_KEY);
    }

    public String getViewIdResourceName() {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return null;
    L5:
        return this.mInfo.getViewIdResourceName();
    }

    public AccessibilityWindowInfoCompat getWindow() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    public int hashCode() {
        AccessibilityNodeInfo r0 = this.mInfo;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public boolean isAccessibilityFocused() {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        return this.mInfo.isContextClickable();
    }

    public boolean isDismissable() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return false;
    L5:
        return this.mInfo.isEditable();
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isHeading() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.mInfo.isHeading();
    L7:
        if (getBooleanProperty(2) == false) goto L9;
        return true;
    L9:
        CollectionItemInfoCompat r2 = getCollectionItemInfo();
        if (r2 != null) goto L12;
    L14:
        return false;
    L12:
        if (r2.isHeading() == false) goto L14;
        return true;
    }

    public boolean isImportantForAccessibility() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return true;
    L5:
        return this.mInfo.isImportantForAccessibility();
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.mInfo.isScreenReaderFocusable();
    L7:
        return getBooleanProperty(1);
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mInfo.isShowingHintText();
    L7:
        return getBooleanProperty(4);
    }

    public boolean isTextEntryKey() {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mInfo.isTextEntryKey();
    L7:
        return getBooleanProperty(8);
    }

    public boolean isTextSelectable() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        return Api33Impl.isTextSelectable(this.mInfo);
    }

    public boolean isVisibleToUser() {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return this.mInfo.isVisibleToUser();
    }

    public boolean performAction(int r1) {
        return this.mInfo.performAction(r1);
    }

    public boolean performAction(int r3, Bundle r4) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return false;
    L5:
        return this.mInfo.performAction(r3, r4);
    }

    public void recycle() {
        this.mInfo.recycle();
    }

    public boolean refresh() {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return false;
    L5:
        return this.mInfo.refresh();
    }

    public boolean removeAction(AccessibilityActionCompat r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) r3.mAction);
    }

    public boolean removeChild(View r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return this.mInfo.removeChild(r3);
    }

    public boolean removeChild(View r3, int r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return false;
    L5:
        return this.mInfo.removeChild(r3, r4);
    }

    public void setAccessibilityFocused(boolean r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setAccessibilityFocused(r3);
        return;
    }

    public void setAvailableExtraData(@NonNull List<String> r3) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mInfo.setAvailableExtraData(r3);
        return;
    }

    @Deprecated
    public void setBoundsInParent(Rect r1) {
        this.mInfo.setBoundsInParent(r1);
    }

    public void setBoundsInScreen(Rect r1) {
        this.mInfo.setBoundsInScreen(r1);
    }

    public void setCanOpenPopup(boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setCanOpenPopup(r3);
        return;
    }

    public void setCheckable(boolean r1) {
        this.mInfo.setCheckable(r1);
    }

    public void setChecked(boolean r1) {
        this.mInfo.setChecked(r1);
    }

    public void setClassName(CharSequence r1) {
        this.mInfo.setClassName(r1);
    }

    public void setClickable(boolean r1) {
        this.mInfo.setClickable(r1);
    }

    public void setCollectionInfo(Object r3) {
        if (Build.VERSION.SDK_INT < 19) goto L10;
        AccessibilityNodeInfo r2 = this.mInfo;
        if (r3 != null) goto L7;
        AccessibilityNodeInfo.CollectionInfo r4 = null;
    L8:
        r2.setCollectionInfo(r4);
        return;
    L7:
        r4 = (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) r3).mInfo;
        goto L8
    }

    public void setCollectionItemInfo(Object r3) {
        if (Build.VERSION.SDK_INT < 19) goto L10;
        AccessibilityNodeInfo r2 = this.mInfo;
        if (r3 != null) goto L7;
        AccessibilityNodeInfo.CollectionItemInfo r4 = null;
    L8:
        r2.setCollectionItemInfo(r4);
        return;
    L7:
        r4 = (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) r3).mInfo;
        goto L8
    }

    public void setContentDescription(CharSequence r1) {
        this.mInfo.setContentDescription(r1);
    }

    public void setContentInvalid(boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setContentInvalid(r3);
        return;
    }

    public void setContextClickable(boolean r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.mInfo.setContextClickable(r3);
        return;
    }

    public void setDismissable(boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setDismissable(r3);
        return;
    }

    public void setDrawingOrder(int r3) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mInfo.setDrawingOrder(r3);
        return;
    }

    public void setEditable(boolean r3) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        this.mInfo.setEditable(r3);
        return;
    }

    public void setEnabled(boolean r1) {
        this.mInfo.setEnabled(r1);
    }

    public void setError(CharSequence r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mInfo.setError(r3);
        return;
    }

    public void setFocusable(boolean r1) {
        this.mInfo.setFocusable(r1);
    }

    public void setFocused(boolean r1) {
        this.mInfo.setFocused(r1);
    }

    public void setHeading(boolean r3) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mInfo.setHeading(r3);
        return;
    L5:
        setBooleanProperty(2, r3);
    }

    public void setHintText(@Nullable CharSequence r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L6;
        this.mInfo.setHintText(r3);
        return;
    L6:
        if (r0 < 19) goto L10;
        this.mInfo.getExtras().putCharSequence(HINT_TEXT_KEY, r3);
        return;
    }

    public void setImportantForAccessibility(boolean r3) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mInfo.setImportantForAccessibility(r3);
        return;
    }

    public void setInputType(int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setInputType(r3);
        return;
    }

    public void setLabelFor(View r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabelFor(r3);
        return;
    }

    public void setLabelFor(View r3, int r4) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabelFor(r3, r4);
        return;
    }

    public void setLabeledBy(View r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabeledBy(r3);
        return;
    }

    public void setLabeledBy(View r3, int r4) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        this.mInfo.setLabeledBy(r3, r4);
        return;
    }

    public void setLiveRegion(int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setLiveRegion(r3);
        return;
    }

    public void setLongClickable(boolean r1) {
        this.mInfo.setLongClickable(r1);
    }

    public void setMaxTextLength(int r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        this.mInfo.setMaxTextLength(r3);
        return;
    }

    public void setMovementGranularities(int r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setMovementGranularities(r3);
        return;
    }

    public void setMultiLine(boolean r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setMultiLine(r3);
        return;
    }

    public void setPackageName(CharSequence r1) {
        this.mInfo.setPackageName(r1);
    }

    public void setPaneTitle(@Nullable CharSequence r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L6;
        this.mInfo.setPaneTitle(r3);
        return;
    L6:
        if (r0 < 19) goto L10;
        this.mInfo.getExtras().putCharSequence(PANE_TITLE_KEY, r3);
        return;
    }

    public void setParent(View r2) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(r2);
    }

    public void setParent(View r3, int r4) {
        this.mParentVirtualDescendantId = r4;
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setParent(r3, r4);
        return;
    }

    public void setPassword(boolean r1) {
        this.mInfo.setPassword(r1);
    }

    public void setRangeInfo(RangeInfoCompat r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo) r3.mInfo);
        return;
    }

    public void setRoleDescription(@Nullable CharSequence r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        this.mInfo.getExtras().putCharSequence(ROLE_DESCRIPTION_KEY, r3);
        return;
    }

    public void setScreenReaderFocusable(boolean r3) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mInfo.setScreenReaderFocusable(r3);
        return;
    L5:
        setBooleanProperty(1, r3);
    }

    public void setScrollable(boolean r1) {
        this.mInfo.setScrollable(r1);
    }

    public void setSelected(boolean r1) {
        this.mInfo.setSelected(r1);
    }

    public void setShowingHintText(boolean r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mInfo.setShowingHintText(r3);
        return;
    L5:
        setBooleanProperty(4, r3);
    }

    public void setSource(View r2) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(r2);
    }

    public void setSource(View r3, int r4) {
        this.mVirtualDescendantId = r4;
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setSource(r3, r4);
        return;
    }

    public void setStateDescription(@Nullable CharSequence r3) {
        if (BuildCompat.isAtLeastR() == false) goto L6;
        this.mInfo.setStateDescription(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        this.mInfo.getExtras().putCharSequence(STATE_DESCRIPTION_KEY, r3);
        return;
    }

    public void setText(CharSequence r1) {
        this.mInfo.setText(r1);
    }

    public void setTextEntryKey(boolean r3) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        this.mInfo.setTextEntryKey(r3);
        return;
    L5:
        setBooleanProperty(8, r3);
    }

    public void setTextSelectable(boolean r3) {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        Api33Impl.setTextSelectable(this.mInfo, r3);
        return;
    }

    public void setTextSelection(int r3, int r4) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        this.mInfo.setTextSelection(r3, r4);
        return;
    }

    public void setTooltipText(@Nullable CharSequence r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L6;
        this.mInfo.setTooltipText(r3);
        return;
    L6:
        if (r0 < 19) goto L10;
        this.mInfo.getExtras().putCharSequence(TOOLTIP_TEXT_KEY, r3);
        return;
    }

    public void setTouchDelegateInfo(@NonNull TouchDelegateInfoCompat r3) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        this.mInfo.setTouchDelegateInfo(r3.mInfo);
        return;
    }

    public void setTraversalAfter(View r3) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalAfter(r3);
        return;
    }

    public void setTraversalAfter(View r3, int r4) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalAfter(r3, r4);
        return;
    }

    public void setTraversalBefore(View r3) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalBefore(r3);
        return;
    }

    public void setTraversalBefore(View r3, int r4) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalBefore(r3, r4);
        return;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public void setUniqueId(@Nullable String r3) {
        if (BuildCompat.isAtLeastT() == false) goto L6;
        this.mInfo.setUniqueId(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        this.mInfo.getExtras().putString(UNIQUE_ID_KEY, r3);
        return;
    }

    public void setViewIdResourceName(String r3) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        this.mInfo.setViewIdResourceName(r3);
        return;
    }

    public void setVisibleToUser(boolean r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        this.mInfo.setVisibleToUser(r3);
        return;
    }

    @NonNull
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        Rect r1 = new Rect();
        getBoundsInParent(r1);
        r0.append("; boundsInParent: " + r1);
        getBoundsInScreen(r1);
        r0.append("; boundsInScreen: " + r1);
        r0.append("; packageName: ");
        r0.append(getPackageName());
        r0.append("; className: ");
        r0.append(getClassName());
        r0.append("; text: ");
        r0.append(getText());
        r0.append("; contentDescription: ");
        r0.append(getContentDescription());
        r0.append("; viewId: ");
        r0.append(getViewIdResourceName());
        r0.append("; uniqueId: ");
        r0.append(getUniqueId());
        r0.append("; checkable: ");
        r0.append(isCheckable());
        r0.append("; checked: ");
        r0.append(isChecked());
        r0.append("; focusable: ");
        r0.append(isFocusable());
        r0.append("; focused: ");
        r0.append(isFocused());
        r0.append("; selected: ");
        r0.append(isSelected());
        r0.append("; clickable: ");
        r0.append(isClickable());
        r0.append("; longClickable: ");
        r0.append(isLongClickable());
        r0.append("; enabled: ");
        r0.append(isEnabled());
        r0.append("; password: ");
        r0.append(isPassword());
        r0.append("; scrollable: " + isScrollable());
        r0.append("; [");
        if (Build.VERSION.SDK_INT < 21) goto L16;
        List<AccessibilityActionCompat> r7 = getActionList();
        int r2 = 0;
    L6:
        if (r2 >= r7.size()) goto L21;
        AccessibilityActionCompat r4 = r7.get(r2);
        String r5 = getActionSymbolicName(r4.getId());
        if (r5.equals("ACTION_UNKNOWN") == true) goto L10;
    L12:
        r0.append(r5);
        if (r2 == (r7.size() - 1)) goto L15;
        r0.append(", ");
    L15:
        r2 = r2 + 1;
        goto L6
    L10:
        if (r4.getLabel() == null) goto L12;
        r5 = r4.getLabel().toString();
    L21:
        r0.append("]");
        return r0.toString();
    L16:
        int r8 = getActions();
    L17:
        if (r8 == 0) goto L21;
        int r3 = 1 << Integer.numberOfTrailingZeros(r8);
        r8 = r8 & (~r3);
        r0.append(getActionSymbolicName(r3));
        if (r8 == 0) goto L17;
        r0.append(", ");
        goto L17
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }
}
