package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
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
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
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
        public static final AccessibilityActionCompat ACTION_EXPAND = null;
        public static final AccessibilityActionCompat ACTION_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP = null;
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
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP = null;
        private static final String TAG = "A11yActionCompat";
        final Object mAction;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected final AccessibilityViewCommand mCommand;
        private final int mId;
        private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;

        static {
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
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            ACTION_PAGE_UP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
        }

        public AccessibilityActionCompat(int r7, CharSequence r8) {
            this(null, r7, r8, null, null);
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
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
        }

        public CharSequence getLabel() {
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
        public boolean perform(View r4, Bundle r5) {
            if (this.mCommand == null) goto L19;
            Class<? extends AccessibilityViewCommand.CommandArguments> r0 = this.mViewCommandArgumentClass;
            AccessibilityViewCommand.CommandArguments r1 = null;
            if (r0 == null) goto L18;
            AccessibilityViewCommand.CommandArguments r2 = r0.getDeclaredConstructor(null).newInstance(null);     // Catch: Exception -> L11
            r2.setBundle(r5);     // Catch: Exception -> L9
            r1 = r2;
        L9:
            e = e;
            r1 = r2;
        L12:
            Class<? extends AccessibilityViewCommand.CommandArguments> r3 = this.mViewCommandArgumentClass;
            if (r3 != null) goto L15;
            String r6 = "null";
        L16:
            Log.e(TAG, "Failed to execute command with argument class ViewCommandArgument: ".concat(r6), e);
            goto L18
        L15:
            r6 = r3.getName();
        L11:
            e = e;
        L18:
            return this.mCommand.perform(r4, r1);
        L19:
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int r7, CharSequence r8, AccessibilityViewCommand r9) {
            this(null, r7, r8, r9, null);
        }

        public AccessibilityActionCompat(Object r7) {
            this(r7, 0, null, null, null);
        }

        private AccessibilityActionCompat(int r7, CharSequence r8, Class<? extends AccessibilityViewCommand.CommandArguments> r9) {
            this(null, r7, r8, null, r9);
        }

        public AccessibilityActionCompat(Object r1, int r2, CharSequence r3, AccessibilityViewCommand r4, Class<? extends AccessibilityViewCommand.CommandArguments> r5) {
            this.mId = r2;
            this.mCommand = r4;
            if (r1 != null) goto L5;
            this.mAction = new AccessibilityNodeInfo.AccessibilityAction(r2, r3);
        L6:
            this.mViewCommandArgumentClass = r5;
            return;
        L5:
            this.mAction = r1;
            goto L6
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        public CollectionInfoCompat(Object r1) {
            this.mInfo = r1;
        }

        public static CollectionInfoCompat obtain(int r1, int r2, boolean r3, int r4) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r1, r2, r3, r4));
        }

        public int getColumnCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getColumnCount();
        }

        public int getRowCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getRowCount();
        }

        public int getSelectionMode() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getSelectionMode();
        }

        public boolean isHierarchical() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).isHierarchical();
        }

        public static CollectionInfoCompat obtain(int r1, int r2, boolean r3) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r1, r2, r3));
        }
    }

    public static class CollectionItemInfoCompat {
        final Object mInfo;

        public CollectionItemInfoCompat(Object r1) {
            this.mInfo = r1;
        }

        public static CollectionItemInfoCompat obtain(int r1, int r2, int r3, int r4, boolean r5, boolean r6) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r1, r2, r3, r4, r5, r6));
        }

        public int getColumnIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnIndex();
        }

        public int getColumnSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnSpan();
        }

        public int getRowIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowIndex();
        }

        public int getRowSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowSpan();
        }

        @Deprecated
        public boolean isHeading() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isHeading();
        }

        public boolean isSelected() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isSelected();
        }

        public static CollectionItemInfoCompat obtain(int r1, int r2, int r3, int r4, boolean r5) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r1, r2, r3, r4, r5));
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        public RangeInfoCompat(Object r1) {
            this.mInfo = r1;
        }

        public static RangeInfoCompat obtain(int r1, float r2, float r3, float r4) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(r1, r2, r3, r4));
        }

        public float getCurrent() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getCurrent();
        }

        public float getMax() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMax();
        }

        public float getMin() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMin();
        }

        public int getType() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getType();
        }
    }

    public static final class TouchDelegateInfoCompat {
        final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        public TouchDelegateInfoCompat(@NonNull Map<Region, View> r2) {
            this.mInfo = new AccessibilityNodeInfo.TouchDelegateInfo(r2);
        }

        @Nullable
        public Region getRegionAt(@IntRange(from = 0) int r1) {
            return this.mInfo.getRegionAt(r1);
        }

        @IntRange(from = 0)
        public int getRegionCount() {
            return this.mInfo.getRegionCount();
        }

        @Nullable
        public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region r1) {
            AccessibilityNodeInfo r0 = this.mInfo.getTargetForRegion(r1);
            if (r0 != null) goto L5;
            return null;
        L5:
            return AccessibilityNodeInfoCompat.wrap(r0);
        }

        public TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo r1) {
            this.mInfo = r1;
        }
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
        this.mInfo.getExtras().remove(SPANS_START_KEY);
        this.mInfo.getExtras().remove(SPANS_END_KEY);
        this.mInfo.getExtras().remove(SPANS_FLAGS_KEY);
        this.mInfo.getExtras().remove(SPANS_ID_KEY);
    }

    private List<Integer> extrasIntList(String r2) {
        ArrayList<Integer> r0 = this.mInfo.getExtras().getIntegerArrayList(r2);
        if (r0 != null) goto L6;
        ArrayList<Integer> r1 = new ArrayList();
        this.mInfo.getExtras().putIntegerArrayList(r2, r1);
        return r1;
    L6:
        return r0;
    }

    private static String getActionSymbolicName(int r1) {
        if (r1 != 1) goto L5;
        return "ACTION_FOCUS";
    L5:
        if (r1 == 2) goto L79;
        switch(r1) {
            case 4: goto L77;
            case 8: goto L75;
            case 16: goto L73;
            case 32: goto L71;
            case 64: goto L69;
            case 128: goto L67;
            case 256: goto L65;
            case 512: goto L63;
            case 1024: goto L61;
            case 2048: goto L59;
            case 4096: goto L57;
            case 8192: goto L55;
            case 16384: goto L53;
            case 32768: goto L51;
            case 65536: goto L49;
            case 131072: goto L47;
            case 262144: goto L45;
            case 524288: goto L43;
            case 2097152: goto L41;
            case 16908354: goto L39;
            default: goto L7;
        };
    L7:
        switch(r1) {
            case 16908342: goto L37;
            case 16908343: goto L35;
            case 16908344: goto L33;
            case 16908345: goto L31;
            case 16908346: goto L29;
            case 16908347: goto L27;
            case 16908348: goto L25;
            case 16908349: goto L23;
            default: goto L8;
        };
    L8:
        switch(r1) {
            case 16908356: goto L21;
            case 16908357: goto L19;
            case 16908358: goto L17;
            case 16908359: goto L15;
            case 16908360: goto L13;
            case 16908361: goto L11;
            default: goto L9;
        };
    L9:
        return "ACTION_UNKNOWN";
    L11:
        return "ACTION_PAGE_RIGHT";
    L13:
        return "ACTION_PAGE_LEFT";
    L15:
        return "ACTION_PAGE_DOWN";
    L17:
        return "ACTION_PAGE_UP";
    L19:
        return "ACTION_HIDE_TOOLTIP";
    L21:
        return "ACTION_SHOW_TOOLTIP";
    L23:
        return "ACTION_SET_PROGRESS";
    L25:
        return "ACTION_CONTEXT_CLICK";
    L27:
        return "ACTION_SCROLL_RIGHT";
    L29:
        return "ACTION_SCROLL_DOWN";
    L31:
        return "ACTION_SCROLL_LEFT";
    L33:
        return "ACTION_SCROLL_UP";
    L35:
        return "ACTION_SCROLL_TO_POSITION";
    L37:
        return "ACTION_SHOW_ON_SCREEN";
    L39:
        return "ACTION_MOVE_WINDOW";
    L41:
        return "ACTION_SET_TEXT";
    L43:
        return "ACTION_COLLAPSE";
    L45:
        return "ACTION_EXPAND";
    L47:
        return "ACTION_SET_SELECTION";
    L49:
        return "ACTION_CUT";
    L51:
        return "ACTION_PASTE";
    L53:
        return "ACTION_COPY";
    L55:
        return "ACTION_SCROLL_BACKWARD";
    L57:
        return "ACTION_SCROLL_FORWARD";
    L59:
        return "ACTION_PREVIOUS_HTML_ELEMENT";
    L61:
        return "ACTION_NEXT_HTML_ELEMENT";
    L63:
        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    L65:
        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    L67:
        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    L69:
        return "ACTION_ACCESSIBILITY_FOCUS";
    L71:
        return "ACTION_LONG_CLICK";
    L73:
        return "ACTION_CLICK";
    L75:
        return "ACTION_CLEAR_SELECTION";
    L77:
        return "ACTION_SELECT";
    L79:
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

    public static AccessibilityNodeInfoCompat obtain(View r0) {
        return wrap(AccessibilityNodeInfo.obtain(r0));
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

    public static AccessibilityNodeInfoCompat wrapNonNullInstance(Object r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        return new AccessibilityNodeInfoCompat(r1);
    }

    public void addAction(int r1) {
        this.mInfo.addAction(r1);
    }

    public void addChild(View r1) {
        this.mInfo.addChild(r1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addSpansToExtras(CharSequence r1, View r2) {
    }

    public boolean canOpenPopup() {
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

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String r2) {
        List<AccessibilityNodeInfo> r1 = this.mInfo.findAccessibilityNodeInfosByViewId(r2);
        ArrayList r3 = new ArrayList();
        Iterator<AccessibilityNodeInfo> r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r3.add(wrap(r4.next()));
        goto L4
    L6:
        return r3;
    }

    public AccessibilityNodeInfoCompat findFocus(int r1) {
        return wrapNonNullInstance(this.mInfo.findFocus(r1));
    }

    public AccessibilityNodeInfoCompat focusSearch(int r1) {
        return wrapNonNullInstance(this.mInfo.focusSearch(r1));
    }

    public List<AccessibilityActionCompat> getActionList() {
        List<AccessibilityNodeInfo.AccessibilityAction> r5 = this.mInfo.getActionList();
        if (r5 == null) goto L9;
        ArrayList r0 = new ArrayList();
        int r1 = r5.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r0.add(new AccessibilityActionCompat(r5.get(r2)));
        r2 = r2 + 1;
        goto L5
    L7:
        return r0;
    L9:
        return Collections.emptyList();
    }

    public int getActions() {
        return this.mInfo.getActions();
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
        AccessibilityNodeInfo.CollectionInfo r1 = this.mInfo.getCollectionInfo();
        if (r1 != null) goto L5;
        return null;
    L5:
        return new CollectionInfoCompat(r1);
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo r1 = this.mInfo.getCollectionItemInfo();
        if (r1 != null) goto L5;
        return null;
    L5:
        return new CollectionItemInfoCompat(r1);
    }

    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        return this.mInfo.getDrawingOrder();
    }

    public CharSequence getError() {
        return this.mInfo.getError();
    }

    public Bundle getExtras() {
        return this.mInfo.getExtras();
    }

    @Nullable
    public CharSequence getHintText() {
        return this.mInfo.getHintText();
    }

    @Deprecated
    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return this.mInfo.getInputType();
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    public int getLiveRegion() {
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        return this.mInfo.getMaxTextLength();
    }

    public int getMovementGranularities() {
        return this.mInfo.getMovementGranularities();
    }

    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    @Nullable
    public CharSequence getPaneTitle() {
        return this.mInfo.getPaneTitle();
    }

    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    public RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo r1 = this.mInfo.getRangeInfo();
        if (r1 != null) goto L5;
        return null;
    L5:
        return new RangeInfoCompat(r1);
    }

    @Nullable
    public CharSequence getRoleDescription() {
        return this.mInfo.getExtras().getCharSequence(ROLE_DESCRIPTION_KEY);
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
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        return this.mInfo.getTextSelectionStart();
    }

    @Nullable
    public CharSequence getTooltipText() {
        return this.mInfo.getTooltipText();
    }

    @Nullable
    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        AccessibilityNodeInfo.TouchDelegateInfo r1 = this.mInfo.getTouchDelegateInfo();
        if (r1 != null) goto L5;
        return null;
    L5:
        return new TouchDelegateInfoCompat(r1);
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return wrapNonNullInstance(this.mInfo.getTraversalAfter());
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return wrapNonNullInstance(this.mInfo.getTraversalBefore());
    }

    public String getViewIdResourceName() {
        return this.mInfo.getViewIdResourceName();
    }

    public AccessibilityWindowInfoCompat getWindow() {
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
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        return this.mInfo.isContextClickable();
    }

    public boolean isDismissable() {
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
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
        return this.mInfo.isHeading();
    }

    public boolean isImportantForAccessibility() {
        return this.mInfo.isImportantForAccessibility();
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        return this.mInfo.isScreenReaderFocusable();
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        return this.mInfo.isShowingHintText();
    }

    public boolean isTextEntryKey() {
        return this.mInfo.isTextEntryKey();
    }

    public boolean isVisibleToUser() {
        return this.mInfo.isVisibleToUser();
    }

    public boolean performAction(int r1) {
        return this.mInfo.performAction(r1);
    }

    public void recycle() {
        this.mInfo.recycle();
    }

    public boolean refresh() {
        return this.mInfo.refresh();
    }

    public boolean removeAction(AccessibilityActionCompat r1) {
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) r1.mAction);
    }

    public boolean removeChild(View r1) {
        return this.mInfo.removeChild(r1);
    }

    public void setAccessibilityFocused(boolean r1) {
        this.mInfo.setAccessibilityFocused(r1);
    }

    @Deprecated
    public void setBoundsInParent(Rect r1) {
        this.mInfo.setBoundsInParent(r1);
    }

    public void setBoundsInScreen(Rect r1) {
        this.mInfo.setBoundsInScreen(r1);
    }

    public void setCanOpenPopup(boolean r1) {
        this.mInfo.setCanOpenPopup(r1);
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

    public void setCollectionInfo(Object r1) {
        AccessibilityNodeInfo r0 = this.mInfo;
        if (r1 != null) goto L5;
        AccessibilityNodeInfo.CollectionInfo r2 = null;
    L6:
        r0.setCollectionInfo(r2);
        return;
    L5:
        r2 = (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) r1).mInfo;
        goto L6
    }

    public void setCollectionItemInfo(Object r1) {
        AccessibilityNodeInfo r0 = this.mInfo;
        if (r1 != null) goto L5;
        AccessibilityNodeInfo.CollectionItemInfo r2 = null;
    L6:
        r0.setCollectionItemInfo(r2);
        return;
    L5:
        r2 = (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) r1).mInfo;
        goto L6
    }

    public void setContentDescription(CharSequence r1) {
        this.mInfo.setContentDescription(r1);
    }

    public void setContentInvalid(boolean r1) {
        this.mInfo.setContentInvalid(r1);
    }

    public void setContextClickable(boolean r1) {
        this.mInfo.setContextClickable(r1);
    }

    public void setDismissable(boolean r1) {
        this.mInfo.setDismissable(r1);
    }

    public void setDrawingOrder(int r1) {
        this.mInfo.setDrawingOrder(r1);
    }

    public void setEditable(boolean r1) {
        this.mInfo.setEditable(r1);
    }

    public void setEnabled(boolean r1) {
        this.mInfo.setEnabled(r1);
    }

    public void setError(CharSequence r1) {
        this.mInfo.setError(r1);
    }

    public void setFocusable(boolean r1) {
        this.mInfo.setFocusable(r1);
    }

    public void setFocused(boolean r1) {
        this.mInfo.setFocused(r1);
    }

    public void setHeading(boolean r1) {
        this.mInfo.setHeading(r1);
    }

    public void setHintText(@Nullable CharSequence r1) {
        this.mInfo.setHintText(r1);
    }

    public void setImportantForAccessibility(boolean r1) {
        this.mInfo.setImportantForAccessibility(r1);
    }

    public void setInputType(int r1) {
        this.mInfo.setInputType(r1);
    }

    public void setLabelFor(View r1) {
        this.mInfo.setLabelFor(r1);
    }

    public void setLabeledBy(View r1) {
        this.mInfo.setLabeledBy(r1);
    }

    public void setLiveRegion(int r1) {
        this.mInfo.setLiveRegion(r1);
    }

    public void setLongClickable(boolean r1) {
        this.mInfo.setLongClickable(r1);
    }

    public void setMaxTextLength(int r1) {
        this.mInfo.setMaxTextLength(r1);
    }

    public void setMovementGranularities(int r1) {
        this.mInfo.setMovementGranularities(r1);
    }

    public void setMultiLine(boolean r1) {
        this.mInfo.setMultiLine(r1);
    }

    public void setPackageName(CharSequence r1) {
        this.mInfo.setPackageName(r1);
    }

    public void setPaneTitle(@Nullable CharSequence r1) {
        this.mInfo.setPaneTitle(r1);
    }

    public void setParent(View r2) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(r2);
    }

    public void setPassword(boolean r1) {
        this.mInfo.setPassword(r1);
    }

    public void setRangeInfo(RangeInfoCompat r1) {
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo) r1.mInfo);
    }

    public void setRoleDescription(@Nullable CharSequence r2) {
        this.mInfo.getExtras().putCharSequence(ROLE_DESCRIPTION_KEY, r2);
    }

    public void setScreenReaderFocusable(boolean r1) {
        this.mInfo.setScreenReaderFocusable(r1);
    }

    public void setScrollable(boolean r1) {
        this.mInfo.setScrollable(r1);
    }

    public void setSelected(boolean r1) {
        this.mInfo.setSelected(r1);
    }

    public void setShowingHintText(boolean r1) {
        this.mInfo.setShowingHintText(r1);
    }

    public void setSource(View r2) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(r2);
    }

    public void setText(CharSequence r1) {
        this.mInfo.setText(r1);
    }

    public void setTextEntryKey(boolean r1) {
        this.mInfo.setTextEntryKey(r1);
    }

    public void setTextSelection(int r1, int r2) {
        this.mInfo.setTextSelection(r1, r2);
    }

    public void setTooltipText(@Nullable CharSequence r1) {
        this.mInfo.setTooltipText(r1);
    }

    public void setTouchDelegateInfo(@NonNull TouchDelegateInfoCompat r1) {
        this.mInfo.setTouchDelegateInfo(r1.mInfo);
    }

    public void setTraversalAfter(View r1) {
        this.mInfo.setTraversalAfter(r1);
    }

    public void setTraversalBefore(View r1) {
        this.mInfo.setTraversalBefore(r1);
    }

    public void setViewIdResourceName(String r1) {
        this.mInfo.setViewIdResourceName(r1);
    }

    public void setVisibleToUser(boolean r1) {
        this.mInfo.setVisibleToUser(r1);
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
        List<AccessibilityActionCompat> r5 = getActionList();
        int r2 = 0;
    L4:
        if (r2 >= r5.size()) goto L14;
        AccessibilityActionCompat r3 = r5.get(r2);
        String r4 = getActionSymbolicName(r3.getId());
        if (r4.equals("ACTION_UNKNOWN") == true) goto L8;
    L10:
        r0.append(r4);
        if (r2 == (r5.size() - 1)) goto L13;
        r0.append(", ");
    L13:
        r2 = r2 + 1;
        goto L4
    L8:
        if (r3.getLabel() == null) goto L10;
        r4 = r3.getLabel().toString();
        goto L10
    L14:
        r0.append("]");
        return r0.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }

    public static AccessibilityNodeInfoCompat obtain(View r0, int r1) {
        return wrapNonNullInstance(AccessibilityNodeInfo.obtain(r0, r1));
    }

    public void addAction(AccessibilityActionCompat r1) {
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) r1.mAction);
    }

    public void addChild(View r1, int r2) {
        this.mInfo.addChild(r1, r2);
    }

    public boolean performAction(int r1, Bundle r2) {
        return this.mInfo.performAction(r1, r2);
    }

    public boolean removeChild(View r1, int r2) {
        return this.mInfo.removeChild(r1, r2);
    }

    public void setLabelFor(View r1, int r2) {
        this.mInfo.setLabelFor(r1, r2);
    }

    public void setLabeledBy(View r1, int r2) {
        this.mInfo.setLabeledBy(r1, r2);
    }

    public void setTraversalAfter(View r1, int r2) {
        this.mInfo.setTraversalAfter(r1, r2);
    }

    public void setTraversalBefore(View r1, int r2) {
        this.mInfo.setTraversalBefore(r1, r2);
    }

    public void setParent(View r1, int r2) {
        this.mParentVirtualDescendantId = r2;
        this.mInfo.setParent(r1, r2);
    }

    public void setSource(View r1, int r2) {
        this.mVirtualDescendantId = r2;
        this.mInfo.setSource(r1, r2);
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo r2) {
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = r2;
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat r0) {
        return wrap(AccessibilityNodeInfo.obtain(r0.mInfo));
    }
}
