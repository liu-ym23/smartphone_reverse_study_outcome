package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetClipToWindowEnabledMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static int getMaxAvailableHeight(PopupWindow r0, View r1, int r2, boolean r3) {
            return r0.getMaxAvailableHeight(r1, r2, r3);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setEpicenterBounds(PopupWindow r0, Rect r1) {
            r0.setEpicenterBounds(r1);
        }

        @DoNotInline
        static void setIsClippedToScreen(PopupWindow r0, boolean r1) {
            r0.setIsClippedToScreen(r1);
        }
    }

    private class ListSelectorHider implements Runnable {
        final /* synthetic */ ListPopupWindow this$0;

        ListSelectorHider(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.clearListSelection();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        final /* synthetic */ ListPopupWindow this$0;

        PopupDataSetObserver(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (this.this$0.isShowing() == false) goto L6;
            this.this$0.show();
            return;
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.dismiss();
        }
    }

    private class PopupScrollListener implements AbsListView.OnScrollListener {
        final /* synthetic */ ListPopupWindow this$0;

        PopupScrollListener(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView r1, int r2, int r3, int r4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView r1, int r2) {
            if (r2 == 1) goto L5;
            return;
        L5:
            if (this.this$0.isInputMethodNotNeeded() == false) goto L7;
            return;
        L7:
            if (this.this$0.mPopup.getContentView() == null) goto L12;
            ListPopupWindow r3 = this.this$0;
            r3.mHandler.removeCallbacks(r3.mResizePopupRunnable);
            this.this$0.mResizePopupRunnable.run();
            return;
        }
    }

    private class PopupTouchInterceptor implements View.OnTouchListener {
        final /* synthetic */ ListPopupWindow this$0;

        PopupTouchInterceptor(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r3, MotionEvent r4) {
            int r5 = r4.getAction();
            int r0 = (int) r4.getX();
            int r6 = (int) r4.getY();
            if (r5 != 0) goto L16;
            PopupWindow r1 = this.this$0.mPopup;
            if (r1 == null) goto L16;
            if (r1.isShowing() == false) goto L16;
            if (r0 < 0) goto L16;
            if (r0 >= this.this$0.mPopup.getWidth()) goto L16;
            if (r6 < 0) goto L16;
            if (r6 >= this.this$0.mPopup.getHeight()) goto L16;
            ListPopupWindow r2 = this.this$0;
            r2.mHandler.postDelayed(r2.mResizePopupRunnable, 250);
            return false;
        L16:
            if (r5 != 1) goto L21;
            ListPopupWindow r7 = this.this$0;
            r7.mHandler.removeCallbacks(r7.mResizePopupRunnable);
            return false;
        L21:
            return false;
        }
    }

    private class ResizePopupRunnable implements Runnable {
        final /* synthetic */ ListPopupWindow this$0;

        ResizePopupRunnable(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView r0 = this.this$0.mDropDownList;
            if (r0 != null) goto L5;
            return;
        L5:
            if (ViewCompat.isAttachedToWindow(r0) == true) goto L7;
            return;
        L7:
            if (this.this$0.mDropDownList.getCount() <= this.this$0.mDropDownList.getChildCount()) goto L14;
            int r1 = this.this$0.mDropDownList.getChildCount();
            ListPopupWindow r2 = this.this$0;
            if (r1 > r2.mListItemExpandMaximum) goto L15;
            r2.mPopup.setInputMethodMode(2);
            this.this$0.show();
            return;
        L15:
            return;
        }
    }

    static {
        Class r0 = Boolean.TYPE;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 > 28) goto L11;
        sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{r0});     // Catch: NoSuchMethodException -> L6
    L18:
        sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});     // Catch: NoSuchMethodException -> L9
    L9:
        Log.i(TAG, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
    L6:
        Log.i(TAG, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
    L11:
        if (r1 > 23) goto L22;
        sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, r0});     // Catch: NoSuchMethodException -> L14
        return;
    L14:
        Log.i(TAG, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        return;
    }

    public ListPopupWindow(@NonNull Context r3) {
        this(r3, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context r2, @Nullable AttributeSet r3, @AttrRes int r4) {
        this(r2, r3, r4, 0);
    }

    public ListPopupWindow(@NonNull Context r4, @Nullable AttributeSet r5, @AttrRes int r6, @StyleRes int r7) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = 1002;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable(this);
        this.mTouchInterceptor = new PopupTouchInterceptor(this);
        this.mScrollListener = new PopupScrollListener(this);
        this.mHideSelector = new ListSelectorHider(this);
        this.mTempRect = new Rect();
        this.mContext = r4;
        this.mHandler = new Handler(r4.getMainLooper());
        TypedArray r1 = r4.obtainStyledAttributes(r5, R.styleable.ListPopupWindow, r6, r7);
        this.mDropDownHorizontalOffset = r1.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int r0 = r1.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.mDropDownVerticalOffset = r0;
        if (r0 == 0) goto L5;
        this.mDropDownVerticalOffsetSet = true;
    L5:
        r1.recycle();
        AppCompatPopupWindow r2 = new AppCompatPopupWindow(r4, r5, r6, r7);
        this.mPopup = r2;
        r2.setInputMethodMode(1);
    }

    private int buildDropDown() {
        int r1 = Integer.MIN_VALUE;
        boolean r3 = true;
        if (this.mDropDownList != null) goto L25;
        Context r0 = this.mContext;
        this.mShowDropDownRunnable = new AnonymousClass2(this);
        DropDownListView r5 = createDropDownListView(r0, !this.mModal);
        this.mDropDownList = r5;
        Drawable r6 = this.mDropDownListHighlight;
        if (r6 == null) goto L7;
        r5.setSelector(r6);
    L7:
        this.mDropDownList.setAdapter(this.mAdapter);
        this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
        this.mDropDownList.setFocusable(true);
        this.mDropDownList.setFocusableInTouchMode(true);
        this.mDropDownList.setOnItemSelectedListener(new AnonymousClass3(this));
        this.mDropDownList.setOnScrollListener(this.mScrollListener);
        AdapterView.OnItemSelectedListener r7 = this.mItemSelectedListener;
        if (r7 == null) goto L10;
        this.mDropDownList.setOnItemSelectedListener(r7);
    L10:
        DropDownListView r8 = this.mDropDownList;
        View r9 = this.mPromptView;
        if (r9 == null) goto L23;
        LinearLayout r10 = new LinearLayout(r0);
        r10.setOrientation(1);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        int r11 = this.mPromptPosition;
        if (r11 == 0) goto L17;
        if (r11 == 1) goto L16;
        Log.e(TAG, "Invalid hint position " + this.mPromptPosition);
    L18:
        int r4 = this.mDropDownWidth;
        if (r4 < 0) goto L21;
        int r12 = Integer.MIN_VALUE;
    L22:
        r9.measure(View.MeasureSpec.makeMeasureSpec(r4, r12), 0);
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) r9.getLayoutParams();
        int r14 = (r9.getMeasuredHeight() + r13.topMargin) + r13.bottomMargin;
        View r15 = r10;
    L24:
        this.mPopup.setContentView(r15);
    L29:
        Drawable r16 = this.mPopup.getBackground();
        if (r16 == null) goto L34;
        r16.getPadding(this.mTempRect);
        Rect r17 = this.mTempRect;
        int r18 = r17.top;
        int r19 = r17.bottom + r18;
        if (this.mDropDownVerticalOffsetSet == true) goto L36;
        this.mDropDownVerticalOffset = -r18;
    L36:
        if (this.mPopup.getInputMethodMode() == 2) goto L39;
        r3 = false;
    L39:
        int r20 = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, r3);
        if (this.mDropDownAlwaysVisible == true) goto L56;
        if (this.mDropDownHeight == (-1)) goto L56;
        int r21 = this.mDropDownWidth;
        if (r21 == (-2)) goto L49;
        r1 = BasicMeasure.EXACTLY;
        if (r21 == (-1)) goto L49;
        int r22 = View.MeasureSpec.makeMeasureSpec(r21, BasicMeasure.EXACTLY);
    L50:
        int r23 = this.mDropDownList.measureHeightOfChildrenCompat(r22, 0, -1, r20 - r14, -1);
        if (r23 <= 0) goto L54;
        r14 = r14 + (r19 + (this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom()));
    L54:
        return r23 + r14;
    L49:
        int r24 = this.mContext.getResources().getDisplayMetrics().widthPixels;
        Rect r25 = this.mTempRect;
        r22 = View.MeasureSpec.makeMeasureSpec(r24 - (r25.left + r25.right), r1);
    L56:
        return r20 + r19;
    L34:
        this.mTempRect.setEmpty();
        r19 = 0;
        goto L36
    L21:
        r4 = 0;
        r12 = 0;
        goto L22
    L16:
        r10.addView(r8, r2);
        r10.addView(r9);
        goto L18
    L17:
        r10.addView(r9);
        r10.addView(r8, r2);
        goto L18
    L23:
        r14 = 0;
        r15 = r8;
        goto L24
    L25:
        ViewGroup r26 = (ViewGroup) this.mPopup.getContentView();
        View r27 = this.mPromptView;
        if (r27 == null) goto L28;
        LinearLayout.LayoutParams r28 = (LinearLayout.LayoutParams) r27.getLayoutParams();
        r14 = (r27.getMeasuredHeight() + r28.topMargin) + r28.bottomMargin;
        goto L29
    L28:
        r14 = 0;
        goto L29
    }

    private int getMaxAvailableHeight(View r6, int r7, boolean r8) {
        if (Build.VERSION.SDK_INT > 23) goto L12;
        Method r0 = sGetMaxAvailableHeightMethod;
        if (r0 == null) goto L10;
        return ((Integer) r0.invoke(this.mPopup, new Object[]{r6, Integer.valueOf(r7), Boolean.valueOf(r8)})).intValue();
    L8:
        Log.i(TAG, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
    L10:
        return this.mPopup.getMaxAvailableHeight(r6, r7);
    L12:
        return Api24Impl.getMaxAvailableHeight(this.mPopup, r6, r7, r8);
    }

    private static boolean isConfirmKey(int r1) {
        if (r1 != 66) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 23) goto L8;
        return false;
    }

    private void removePromptView() {
        View r0 = this.mPromptView;
        if (r0 == null) goto L8;
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r1).removeView(this.mPromptView);
        return;
    L9:
        return;
    }

    private void setPopupClipToScreenEnabled(boolean r4) {
        if (Build.VERSION.SDK_INT > 28) goto L9;
        Method r0 = sSetClipToWindowEnabledMethod;
        if (r0 == null) goto L13;
        r0.invoke(this.mPopup, new Object[]{Boolean.valueOf(r4)});     // Catch: Exception -> L8
        return;
    L8:
        Log.i(TAG, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
        return;
    L13:
        return;
    L9:
        Api29Impl.setIsClippedToScreen(this.mPopup, r4);
    }

    public void clearListSelection() {
        DropDownListView r1 = this.mDropDownList;
        if (r1 == null) goto L6;
        r1.setListSelectionHidden(true);
        r1.requestLayout();
        return;
    }

    public View.OnTouchListener createDragToOpenListener(final View r2) {
        return new AnonymousClass1(this, r2);
    }

    @NonNull
    DropDownListView createDropDownListView(Context r1, boolean r2) {
        return new DropDownListView(r1, r2);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    @Nullable
    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    @StyleRes
    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    @Nullable
    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    @Nullable
    public Rect getEpicenterBounds() {
        if (this.mEpicenterBounds != null) goto L7;
        return null;
    L7:
        return new Rect(this.mEpicenterBounds);
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    @Nullable
    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    @Nullable
    public Object getSelectedItem() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.mDropDownList.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (isShowing() == true) goto L7;
        return Long.MIN_VALUE;
    L7:
        return this.mDropDownList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (isShowing() == true) goto L7;
        return -1;
    L7:
        return this.mDropDownList.getSelectedItemPosition();
    }

    @Nullable
    public View getSelectedView() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.mDropDownList.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (this.mDropDownVerticalOffsetSet == true) goto L7;
        return 0;
    L7:
        return this.mDropDownVerticalOffset;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        if (this.mPopup.getInputMethodMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isModal() {
        return this.mModal;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean onKeyDown(int r10, @NonNull KeyEvent r11) {
        if (isShowing() == true) goto L5;
    L49:
        return false;
    L5:
        if (r10 == 62) goto L49;
        if (this.mDropDownList.getSelectedItemPosition() < 0) goto L9;
    L10:
        int r0 = this.mDropDownList.getSelectedItemPosition();
        boolean r2 = !this.mPopup.isAboveAnchor();
        ListAdapter r4 = this.mAdapter;
        int r5 = Integer.MAX_VALUE;
        int r6 = Integer.MIN_VALUE;
        if (r4 == null) goto L21;
        boolean r7 = r4.areAllItemsEnabled();
        if (r7 == false) goto L15;
        int r8 = 0;
    L16:
        if (r7 == false) goto L18;
        int r9 = r4.getCount() - 1;
    L19:
        r5 = r8;
        r6 = r9;
        goto L21
    L18:
        r9 = this.mDropDownList.lookForSelectablePosition(r4.getCount() - 1, false);
        goto L19
    L15:
        r8 = this.mDropDownList.lookForSelectablePosition(0, true);
    L21:
        if (r2 == false) goto L25;
        if (r10 != 19) goto L25;
        if (r0 > r5) goto L25;
    L28:
        clearListSelection();
        this.mPopup.setInputMethodMode(1);
        show();
        return true;
    L25:
        if (r2 == true) goto L30;
        if (r10 != 20) goto L30;
        if (r0 >= r6) goto L28;
    L30:
        this.mDropDownList.setListSelectionHidden(false);
        if (this.mDropDownList.onKeyDown(r10, r11) == false) goto L41;
        this.mPopup.setInputMethodMode(2);
        this.mDropDownList.requestFocusFromTouch();
        show();
        if (r10 == 19) goto L40;
        if (r10 == 20) goto L40;
        if (r10 == 23) goto L40;
        if (r10 != 66) goto L49;
    L40:
        return true;
    L41:
        if (r2 == false) goto L45;
        if (r10 != 20) goto L45;
        if (r0 != r6) goto L49;
        return true;
    L45:
        if (r2 == true) goto L49;
        if (r10 != 19) goto L49;
        if (r0 != r5) goto L49;
        return true;
    L9:
        if (isConfirmKey(r10) == true) goto L49;
        goto L10
    }

    public boolean onKeyPreIme(int r3, @NonNull KeyEvent r4) {
        if (r3 == 4) goto L5;
        return false;
    L5:
        if (isShowing() == false) goto L27;
        View r5 = this.mDropDownAnchorView;
        if (r4.getAction() != 0) goto L15;
        if (r4.getRepeatCount() != 0) goto L15;
        KeyEvent.DispatcherState r6 = r5.getKeyDispatcherState();
        if (r6 == null) goto L13;
        r6.startTracking(r4, this);
    L13:
        return true;
    L15:
        if (r4.getAction() != 1) goto L28;
        KeyEvent.DispatcherState r7 = r5.getKeyDispatcherState();
        if (r7 == null) goto L20;
        r7.handleUpEvent(r4);
    L20:
        if (r4.isTracking() == true) goto L22;
        return false;
    L22:
        if (r4.isCanceled() == true) goto L30;
        dismiss();
        return true;
    L30:
        return false;
    L28:
        return false;
    L27:
        return false;
    }

    public boolean onKeyUp(int r2, @NonNull KeyEvent r3) {
        if (isShowing() == true) goto L5;
        return false;
    L5:
        if (this.mDropDownList.getSelectedItemPosition() < 0) goto L14;
        boolean r4 = this.mDropDownList.onKeyUp(r2, r3);
        if (r4 == true) goto L9;
    L11:
        return r4;
    L9:
        if (isConfirmKey(r2) == false) goto L11;
        dismiss();
        goto L11
    L14:
        return false;
    }

    public boolean performItemClick(int r8) {
        if (isShowing() == true) goto L5;
        return false;
    L5:
        if (this.mItemClickListener == null) goto L11;
        DropDownListView r2 = this.mDropDownList;
        View r3 = r2.getChildAt(r8 - r2.getFirstVisiblePosition());
        ListAdapter r0 = r2.getAdapter();
        this.mItemClickListener.onItemClick(r2, r3, r8, r0.getItemId(r8));
        return true;
    L11:
        return true;
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(@Nullable ListAdapter r3) {
        DataSetObserver r0 = this.mObserver;
        if (r0 != null) goto L5;
        this.mObserver = new PopupDataSetObserver(this);
    L8:
        this.mAdapter = r3;
        if (r3 == null) goto L11;
        r3.registerDataSetObserver(this.mObserver);
    L11:
        DropDownListView r4 = this.mDropDownList;
        if (r4 == null) goto L15;
        r4.setAdapter(this.mAdapter);
        return;
    L15:
        return;
    L5:
        ListAdapter r1 = this.mAdapter;
        if (r1 == null) goto L8;
        r1.unregisterDataSetObserver(r0);
        goto L8
    }

    public void setAnchorView(@Nullable View r1) {
        this.mDropDownAnchorView = r1;
    }

    public void setAnimationStyle(@StyleRes int r1) {
        this.mPopup.setAnimationStyle(r1);
    }

    public void setBackgroundDrawable(@Nullable Drawable r1) {
        this.mPopup.setBackgroundDrawable(r1);
    }

    public void setContentWidth(int r3) {
        Drawable r0 = this.mPopup.getBackground();
        if (r0 == null) goto L5;
        r0.getPadding(this.mTempRect);
        Rect r1 = this.mTempRect;
        this.mDropDownWidth = (r1.left + r1.right) + r3;
        return;
    L5:
        setWidth(r3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean r1) {
        this.mDropDownAlwaysVisible = r1;
    }

    public void setDropDownGravity(int r1) {
        this.mDropDownGravity = r1;
    }

    public void setEpicenterBounds(@Nullable Rect r2) {
        if (r2 == null) goto L4;
        Rect r0 = new Rect(r2);
    L5:
        this.mEpicenterBounds = r0;
        return;
    L4:
        r0 = null;
        goto L5
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean r1) {
        this.mForceIgnoreOutsideTouch = r1;
    }

    public void setHeight(int r2) {
        if (r2 < 0) goto L4;
    L10:
        this.mDropDownHeight = r2;
        return;
    L4:
        if ((-2) == r2) goto L10;
        if ((-1) == r2) goto L10;
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void setHorizontalOffset(int r1) {
        this.mDropDownHorizontalOffset = r1;
    }

    public void setInputMethodMode(int r1) {
        this.mPopup.setInputMethodMode(r1);
    }

    void setListItemExpandMax(int r1) {
        this.mListItemExpandMaximum = r1;
    }

    public void setListSelector(Drawable r1) {
        this.mDropDownListHighlight = r1;
    }

    public void setModal(boolean r1) {
        this.mModal = r1;
        this.mPopup.setFocusable(r1);
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener r1) {
        this.mPopup.setOnDismissListener(r1);
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener r1) {
        this.mItemClickListener = r1;
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener r1) {
        this.mItemSelectedListener = r1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean r2) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = r2;
    }

    public void setPromptPosition(int r1) {
        this.mPromptPosition = r1;
    }

    public void setPromptView(@Nullable View r2) {
        boolean r0 = isShowing();
        if (r0 == false) goto L5;
        removePromptView();
    L5:
        this.mPromptView = r2;
        if (r0 == false) goto L9;
        show();
        return;
    }

    public void setSelection(int r2) {
        DropDownListView r0 = this.mDropDownList;
        if (isShowing() == false) goto L9;
        if (r0 == null) goto L10;
        r0.setListSelectionHidden(false);
        r0.setSelection(r2);
        if (r0.getChoiceMode() == 0) goto L11;
        r0.setItemChecked(r2, true);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setSoftInputMode(int r1) {
        this.mPopup.setSoftInputMode(r1);
    }

    public void setVerticalOffset(int r1) {
        this.mDropDownVerticalOffset = r1;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int r1) {
        this.mDropDownWidth = r1;
    }

    public void setWindowLayoutType(int r1) {
        this.mDropDownWindowLayoutType = r1;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int r0 = buildDropDown();
        boolean r1 = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        boolean r3 = true;
        if (this.mPopup.isShowing() == true) goto L5;
        int r2 = this.mDropDownWidth;
        if (r2 != (-1)) goto L48;
        r2 = -1;
    L50:
        int r4 = this.mDropDownHeight;
        if (r4 != (-1)) goto L53;
        r0 = -1;
    L56:
        this.mPopup.setWidth(r2);
        this.mPopup.setHeight(r0);
        setPopupClipToScreenEnabled(true);
        PopupWindow r5 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch == false) goto L59;
    L61:
        boolean r6 = false;
    L62:
        r5.setOutsideTouchable(r6);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        if (this.mOverlapAnchorSet == false) goto L66;
        PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
    L66:
        if (Build.VERSION.SDK_INT > 28) goto L73;
        Method r7 = sSetEpicenterBoundsMethod;
        if (r7 != null) goto L83;
    L74:
        PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if (this.mModal == true) goto L77;
    L78:
        clearListSelection();
    L80:
        if (this.mModal == true) goto L86;
        this.mHandler.post(this.mHideSelector);
        return;
    L86:
        return;
    L77:
        if (this.mDropDownList.isInTouchMode() == false) goto L80;
    L83:
        r7.invoke(this.mPopup, new Object[]{this.mEpicenterBounds});     // Catch: Exception -> L71
    L71:
        e = move-exception;
        Log.e(TAG, "Could not invoke setEpicenterBounds on PopupWindow", e);
        goto L74
    L73:
        Api29Impl.setEpicenterBounds(this.mPopup, this.mEpicenterBounds);
        goto L74
    L59:
        if (this.mDropDownAlwaysVisible == true) goto L61;
        r6 = true;
        goto L62
    L53:
        if (r4 == (-2)) goto L56;
        r0 = r4;
        goto L56
    L48:
        if (r2 != (-2)) goto L50;
        r2 = getAnchorView().getWidth();
        goto L50
    L5:
        if (ViewCompat.isAttachedToWindow(getAnchorView()) == true) goto L7;
        return;
    L7:
        int r8 = this.mDropDownWidth;
        if (r8 != (-1)) goto L10;
        r8 = -1;
    L12:
        int r9 = this.mDropDownHeight;
        if (r9 != (-1)) goto L28;
        if (r1 == true) goto L17;
        r0 = -1;
    L17:
        if (r1 == false) goto L23;
        PopupWindow r10 = this.mPopup;
        if (this.mDropDownWidth != (-1)) goto L21;
        int r11 = -1;
    L22:
        r10.setWidth(r11);
        this.mPopup.setHeight(0);
    L31:
        PopupWindow r12 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch == false) goto L34;
    L36:
        r3 = false;
    L37:
        r12.setOutsideTouchable(r3);
        PopupWindow r13 = this.mPopup;
        View r14 = getAnchorView();
        int r15 = this.mDropDownHorizontalOffset;
        int r16 = this.mDropDownVerticalOffset;
        if (r8 >= 0) goto L40;
        int r17 = -1;
    L41:
        if (r0 >= 0) goto L43;
        int r18 = -1;
    L44:
        r13.update(r14, r15, r16, r17, r18);
        return;
    L43:
        r18 = r0;
        goto L44
    L40:
        r17 = r8;
        goto L41
    L34:
        if (this.mDropDownAlwaysVisible == true) goto L36;
    L21:
        r11 = 0;
        goto L22
    L23:
        PopupWindow r19 = this.mPopup;
        if (this.mDropDownWidth != (-1)) goto L26;
        int r20 = -1;
    L27:
        r19.setWidth(r20);
        this.mPopup.setHeight(-1);
        goto L31
    L26:
        r20 = 0;
        goto L27
    L28:
        if (r9 == (-2)) goto L31;
        r0 = r9;
        goto L31
    L10:
        if (r8 != (-2)) goto L12;
        r8 = getAnchorView().getWidth();
        goto L12
    }
}
