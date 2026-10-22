package androidx.slice.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.slice.Slice;
import androidx.slice.SliceItem;
import androidx.slice.SliceMetadata;
import androidx.slice.core.SliceAction;
import androidx.slice.core.SliceActionImpl;
import androidx.slice.core.SliceQuery;
import androidx.slice.view.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SliceView extends ViewGroup implements Observer<Slice>, View.OnClickListener {
    public static final int MODE_LARGE = 2;
    public static final int MODE_SHORTCUT = 3;
    public static final int MODE_SMALL = 1;
    private static final int REFRESH_LAST_UPDATED_IN_MILLIS = 60000;
    public static final Comparator<SliceAction> SLICE_ACTION_PRIORITY_COMPARATOR = null;
    private static final String TAG = "SliceView";
    private ActionRow mActionRow;
    private int mActionRowHeight;
    private List<SliceAction> mActions;
    int[] mClickInfo;
    private Slice mCurrentSlice;
    private boolean mCurrentSliceLoggedVisible;
    private SliceMetrics mCurrentSliceMetrics;
    SliceChildView mCurrentView;
    private int mDownX;
    private int mDownY;
    Handler mHandler;
    boolean mInLongpress;
    private boolean mIsScrollable;
    private int mLargeHeight;
    ListContent mListContent;
    View.OnLongClickListener mLongClickListener;
    Runnable mLongpressCheck;
    private int mMinTemplateHeight;
    private int mMode;
    private View.OnClickListener mOnClickListener;
    boolean mPressing;
    Runnable mRefreshLastUpdated;
    private int mShortcutSize;
    private boolean mShowActions;
    private boolean mShowLastUpdated;
    private SliceMetadata mSliceMetadata;
    private OnSliceActionListener mSliceObserver;
    private SliceStyle mSliceStyle;
    private int mThemeTintColor;
    private int mTouchSlopSquared;

    public interface OnSliceActionListener {
        void onSliceAction(EventInfo r1, SliceItem r2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SliceMode {
    }

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Slice r1) {
        onChanged2(r1);
    }

    public SliceView(Context r2) {
        this(r2, null);
    }

    public SliceView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.sliceViewStyle);
    }

    public SliceView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.mMode = 2;
        this.mShowActions = false;
        this.mIsScrollable = true;
        this.mShowLastUpdated = true;
        this.mCurrentSliceLoggedVisible = false;
        this.mThemeTintColor = -1;
        this.mLongpressCheck = new AnonymousClass1(this);
        this.mRefreshLastUpdated = new AnonymousClass2(this);
        init(r3, r4, r5, R.style.Widget_SliceView);
    }

    public SliceView(Context r3, AttributeSet r4, int r5, int r6) {
        super(r3, r4, r5, r6);
        this.mMode = 2;
        this.mShowActions = false;
        this.mIsScrollable = true;
        this.mShowLastUpdated = true;
        this.mCurrentSliceLoggedVisible = false;
        this.mThemeTintColor = -1;
        this.mLongpressCheck = new AnonymousClass1(this);
        this.mRefreshLastUpdated = new AnonymousClass2(this);
        init(r3, r4, r5, r6);
    }

    private void init(Context r2, AttributeSet r3, int r4, int r5) {
        SliceStyle r0 = new SliceStyle(r2, r3, r4, r5);
        this.mSliceStyle = r0;
        this.mThemeTintColor = r0.getTintColor();
        this.mShortcutSize = getContext().getResources().getDimensionPixelSize(R.dimen.abc_slice_shortcut_size);
        this.mMinTemplateHeight = getContext().getResources().getDimensionPixelSize(R.dimen.abc_slice_row_min_height);
        this.mLargeHeight = getResources().getDimensionPixelSize(R.dimen.abc_slice_large_height);
        this.mActionRowHeight = getResources().getDimensionPixelSize(R.dimen.abc_slice_action_row_height);
        LargeTemplateView r6 = new LargeTemplateView(getContext());
        this.mCurrentView = r6;
        r6.setMode(getMode());
        SliceChildView r7 = this.mCurrentView;
        addView(r7, getChildLp(r7));
        applyConfigurations();
        ActionRow r8 = new ActionRow(getContext(), true);
        this.mActionRow = r8;
        r8.setBackground(new ColorDrawable(-1118482));
        ActionRow r9 = this.mActionRow;
        addView(r9, getChildLp(r9));
        updateActions();
        int r10 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mTouchSlopSquared = r10 * r10;
        this.mHandler = new Handler();
        this.mCurrentView.setInsets(getPaddingStart(), getPaddingTop(), getPaddingEnd(), getPaddingBottom());
        setClipToPadding(false);
        super.setOnClickListener(this);
    }

    public boolean isSliceViewClickable() {
        if (this.mOnClickListener != null) goto L10;
        ListContent r1 = this.mListContent;
        if (r1 != null) goto L7;
    L9:
        return false;
    L7:
        if (r1.getPrimaryAction() == null) goto L9;
    L10:
        return true;
    }

    public void setClickInfo(int[] r1) {
        this.mClickInfo = r1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        ListContent r6 = this.mListContent;
        if (r6 != null) goto L5;
    L19:
        View.OnClickListener r7 = this.mOnClickListener;
        if (r7 == null) goto L29;
        r7.onClick(this);
        return;
    L29:
        return;
    L5:
        if (r6.getPrimaryAction() == null) goto L19;
        SliceActionImpl r8 = new SliceActionImpl(this.mListContent.getPrimaryAction());     // Catch: PendingIntent.CanceledException -> L17
        if (r8.getActionItem().fireActionInternal(getContext(), null) == false) goto L10;
        this.mCurrentView.setActionLoading(r8.getSliceItem());     // Catch: PendingIntent.CanceledException -> L17
    L10:
        if (this.mSliceObserver == null) goto L25;
        int[] r9 = this.mClickInfo;     // Catch: PendingIntent.CanceledException -> L17
        if (r9 != null) goto L14;
        return;
    L14:
        if (r9.length <= 1) goto L27;
        int r1 = getMode();     // Catch: PendingIntent.CanceledException -> L17
        int[] r2 = this.mClickInfo;     // Catch: PendingIntent.CanceledException -> L17
        EventInfo r10 = new EventInfo(r1, 3, r2[0], r2[1]);     // Catch: PendingIntent.CanceledException -> L17
        SliceItem r0 = this.mListContent.getPrimaryAction();     // Catch: PendingIntent.CanceledException -> L17
        this.mSliceObserver.onSliceAction(r10, r0);     // Catch: PendingIntent.CanceledException -> L17
        logSliceMetricsOnTouch(r0, r10);     // Catch: PendingIntent.CanceledException -> L17
        return;
    L27:
        return;
    L25:
        return;
    L17:
        e = move-exception;
        Log.e(TAG, "PendingIntent for slice cannot be sent", e);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        this.mOnClickListener = r1;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r1) {
        super.setOnLongClickListener(r1);
        this.mLongClickListener = r1;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r3) {
        boolean r0 = super.onInterceptTouchEvent(r3);
        if (this.mLongClickListener != null) goto L5;
        return r0;
    L5:
        return handleTouchForLongpress(r3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        boolean r0 = super.onTouchEvent(r3);
        if (this.mLongClickListener != null) goto L5;
        return r0;
    L5:
        return handleTouchForLongpress(r3);
    }

    private boolean handleTouchForLongpress(MotionEvent r5) {
        int r0 = r5.getActionMasked();
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L6;
    L13:
        this.mPressing = false;
        this.mInLongpress = false;
        this.mHandler.removeCallbacks(this.mLongpressCheck);
    L16:
        return this.mInLongpress;
    L6:
        if (r0 != 2) goto L8;
        int r1 = ((int) r5.getRawX()) - this.mDownX;
        int r6 = ((int) r5.getRawY()) - this.mDownY;
        if (((r1 * r1) + (r6 * r6)) <= this.mTouchSlopSquared) goto L16;
        this.mPressing = false;
        this.mHandler.removeCallbacks(this.mLongpressCheck);
        goto L16
    L8:
        if (r0 == 3) goto L13;
    L14:
        this.mHandler.removeCallbacks(this.mLongpressCheck);
        this.mDownX = (int) r5.getRawX();
        this.mDownY = (int) r5.getRawY();
        this.mPressing = true;
        this.mInLongpress = false;
        this.mHandler.postDelayed(this.mLongpressCheck, ViewConfiguration.getLongPressTimeout());
        goto L16
    }

    private int getHeightForMode(int r4) {
        ListContent r0 = this.mListContent;
        if (r0 != null) goto L5;
    L21:
        return 0;
    L5:
        if (r0.isValid() == false) goto L21;
        int r1 = getMode();
        if (r1 == 3) goto L10;
        if (r4 <= 0) goto L15;
        int r2 = this.mMinTemplateHeight;
        if (r4 > r2) goto L15;
        this.mListContent.setMaxSmallHeight(r2);
        this.mCurrentView.setMaxSmallHeight(this.mMinTemplateHeight);
        r4 = r2;
    L17:
        if (r1 != 2) goto L20;
        return this.mListContent.getLargeHeight(r4, this.mIsScrollable);
    L20:
        return this.mListContent.getSmallHeight();
    L15:
        this.mListContent.setMaxSmallHeight(0);
        this.mCurrentView.setMaxSmallHeight(0);
        goto L17
    L10:
        return this.mShortcutSize;
    }

    @Override // android.view.View
    protected void onMeasure(int r9, int r10) {
        int r0 = View.MeasureSpec.getSize(r9);
        int r11 = View.MeasureSpec.getSize(r9);
        if (3 != this.mMode) goto L6;
        r11 = this.mShortcutSize;
        r0 = (getPaddingLeft() + r11) + getPaddingRight();
    L6:
        if (this.mActionRow.getVisibility() == 8) goto L8;
        int r1 = this.mActionRowHeight;
    L9:
        int r3 = View.MeasureSpec.getSize(r10);
        int r12 = View.MeasureSpec.getMode(r10);
        ViewGroup.LayoutParams r4 = getLayoutParams();
        if (r4 != null) goto L12;
    L13:
        if (r12 != 0) goto L15;
    L14:
        int r5 = -1;
    L16:
        int r6 = getHeightForMode(r5);
        int r7 = (r3 - getPaddingTop()) - getPaddingBottom();
        if (r3 >= (r6 + r1)) goto L32;
        if (r12 == 0) goto L32;
        if (getMode() != 2) goto L26;
        if (r3 < (this.mLargeHeight + r1)) goto L26;
    L34:
        int r13 = (getPaddingTop() + r6) + getPaddingBottom();
        int r14 = View.MeasureSpec.makeMeasureSpec((r11 + getPaddingLeft()) + getPaddingRight(), 1073741824);
        int r15 = View.MeasureSpec.makeMeasureSpec(r13, 1073741824);
        measureChild(this.mCurrentView, r14, r15);
        int r16 = View.MeasureSpec.makeMeasureSpec((getPaddingTop() + r1) + getPaddingBottom(), 1073741824);
        measureChild(this.mActionRow, r14, r16);
        setMeasuredDimension(r0, r6 + ((r1 + getPaddingTop()) + getPaddingBottom()));
        return;
    L26:
        if (getMode() != 3) goto L29;
        r6 = this.mShortcutSize;
        goto L34
    L29:
        if (r7 <= this.mMinTemplateHeight) goto L34;
        r6 = r7;
    L32:
        if (r12 != 1073741824) goto L34;
        r6 = Math.min(r6, r7);
        goto L34
    L15:
        r5 = r3;
        goto L16
    L12:
        if (r4.height == (-2)) goto L14;
    L8:
        r1 = 0;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        SliceChildView r6 = this.mCurrentView;
        r6.layout(0, 0, ((r6.getMeasuredWidth() + 0) + getPaddingRight()) + getPaddingLeft(), r6.getMeasuredHeight() + 0);
        if (this.mActionRow.getVisibility() == 8) goto L6;
        this.mActionRow.layout(0, r6.getMeasuredHeight() + 0, this.mActionRow.getMeasuredWidth() + 0, (r6.getMeasuredHeight() + 0) + this.mActionRow.getMeasuredHeight());
        return;
    }

    /* JADX INFO: renamed from: onChanged, reason: avoid collision after fix types in other method */
    public void onChanged2(Slice r1) {
        setSlice(r1);
    }

    public void setSlice(Slice r7) {
        initSliceMetrics(r7);
        boolean r0 = false;
        if (r7 != null) goto L5;
    L9:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L17;
        SliceMetadata r3 = SliceMetadata.from(getContext(), this.mCurrentSlice);
        SliceMetadata r4 = SliceMetadata.from(getContext(), r7);
        if (r3.getLoadingState() == 2) goto L15;
    L18:
        this.mCurrentSlice = r7;
        ListContent r8 = new ListContent(getContext(), this.mCurrentSlice, this.mSliceStyle);
        this.mListContent = r8;
        if (r8.isValid() == true) goto L22;
        this.mActions = null;
        this.mCurrentView.resetView();
        updateActions();
        return;
    L22:
        this.mCurrentView.setLoadingActions(null);
        SliceMetadata r9 = SliceMetadata.from(getContext(), this.mCurrentSlice);
        this.mSliceMetadata = r9;
        this.mActions = r9.getSliceActions();
        this.mCurrentView.setLastUpdated(this.mSliceMetadata.getLastUpdatedTime());
        SliceChildView r10 = this.mCurrentView;
        if (this.mShowLastUpdated == true) goto L25;
    L27:
        r10.setShowLastUpdated(r0);
        this.mCurrentView.setAllowTwoLines(this.mSliceMetadata.isPermissionSlice());
        this.mCurrentView.setTint(getTintColor());
        if (this.mListContent.getLayoutDirItem() == null) goto L30;
        this.mCurrentView.setLayoutDirection(this.mListContent.getLayoutDirItem().getInt());
    L31:
        this.mCurrentView.setSliceContent(this.mListContent);
        updateActions();
        logSliceMetricsVisibilityChange(true);
        refreshLastUpdatedLabel(true);
        return;
    L30:
        this.mCurrentView.setLayoutDirection(2);
        goto L31
    L25:
        if (isExpired() == false) goto L27;
        r0 = true;
        goto L27
    L15:
        if (r4.getLoadingState() != 0) goto L18;
        return;
    L17:
        this.mCurrentView.resetView();
        goto L18
    L5:
        if (this.mCurrentSlice == null) goto L9;
        if (r7.getUri().equals(this.mCurrentSlice.getUri()) == false) goto L9;
        r2 = true;
        goto L11
    }

    private boolean isNeverExpired() {
        SliceMetadata r5 = this.mSliceMetadata;
        if (r5 != null) goto L6;
        return true;
    L6:
        if (r5.getExpiry() == (-1)) goto L10;
        return false;
    L10:
        return true;
    }

    boolean isExpired() {
        SliceMetadata r7 = this.mSliceMetadata;
        if (r7 != null) goto L5;
        return false;
    L5:
        long r1 = r7.getExpiry();
        long r3 = System.currentTimeMillis();
        if (r1 != 0) goto L8;
        return false;
    L8:
        if (r1 != (-1)) goto L10;
        return false;
    L10:
        if (r3 <= r1) goto L15;
        return true;
    L15:
        return false;
    }

    private long getTimeToExpiry() {
        SliceMetadata r8 = this.mSliceMetadata;
        if (r8 != null) goto L5;
        return 0;
    L5:
        long r2 = r8.getExpiry();
        long r4 = System.currentTimeMillis();
        if (r2 != 0) goto L8;
        return 0;
    L8:
        if (r2 != (-1)) goto L10;
        return 0;
    L10:
        if (r4 <= r2) goto L13;
        return 0;
    L13:
        return r2 - r4;
    }

    public Slice getSlice() {
        return this.mCurrentSlice;
    }

    public List<SliceAction> getSliceActions() {
        List<SliceAction> r0 = this.mActions;
        if (r0 == null) goto L9;
        if (r0.isEmpty() == false) goto L9;
        return null;
    L9:
        return this.mActions;
    }

    public void setSliceActions(List<SliceAction> r4) {
        if (this.mCurrentSlice == null) goto L22;
        SliceMetadata r0 = this.mSliceMetadata;
        if (r0 == null) goto L22;
        List<SliceAction> r1 = r0.getSliceActions();
        if (r1 == null) goto L17;
        if (r4 == null) goto L17;
        int r2 = 0;
    L11:
        if (r2 >= r4.size()) goto L17;
        if (r1.contains(r4.get(r2)) == false) goto L16;
        r2 = r2 + 1;
        goto L11
    L16:
        throw new IllegalArgumentException("Trying to set an action that isn't available: " + r4.get(r2));
    L17:
        if (r4 != null) goto L19;
        r4 = new ArrayList();
    L19:
        this.mActions = r4;
        updateActions();
        return;
    L22:
        throw new IllegalStateException("Trying to set actions on a view without a slice");
    }

    public void setMode(int r2) {
        setMode(r2, false);
    }

    public void setScrollable(boolean r2) {
        if (r2 == this.mIsScrollable) goto L8;
        this.mIsScrollable = r2;
        SliceChildView r1 = this.mCurrentView;
        if ((r1 instanceof LargeTemplateView) == false) goto L9;
        ((LargeTemplateView) r1).setScrollable(r2);
        return;
    L9:
        return;
    }

    public boolean isScrollable() {
        return this.mIsScrollable;
    }

    public void setOnSliceActionListener(OnSliceActionListener r1) {
        this.mSliceObserver = r1;
        this.mCurrentView.setSliceActionListener(r1);
    }

    public void setTint(int r1) {
        setAccentColor(r1);
    }

    public void setAccentColor(int r2) {
        this.mThemeTintColor = r2;
        this.mSliceStyle.setTintColor(r2);
        this.mCurrentView.setTint(getTintColor());
    }

    public void setMode(int r4, boolean r5) {
        if (r5 == false) goto L6;
        Log.e(TAG, "Animation not supported yet");
    L6:
        if (this.mMode != r4) goto L9;
        return;
    L9:
        if (r4 != 1) goto L11;
    L15:
        this.mMode = r4;
        updateViewConfig();
        return;
    L11:
        if (r4 == 2) goto L15;
        if (r4 == 3) goto L15;
        Log.w(TAG, "Unknown mode: " + r4 + " please use one of MODE_SHORTCUT, MODE_SMALL, MODE_LARGE");
        r4 = 2;
        goto L15
    }

    public int getMode() {
        return this.mMode;
    }

    public void setShowActionRow(boolean r1) {
        this.mShowActions = r1;
        updateActions();
    }

    public boolean isShowingActionRow() {
        return this.mShowActions;
    }

    private void updateViewConfig() {
        int r0 = getMode();
        SliceChildView r1 = this.mCurrentView;
        boolean r2 = r1 instanceof ShortcutView;
        Set<SliceItem> r3 = r1.getLoadingActions();
        boolean r4 = true;
        if (r0 != 3) goto L6;
        if (r2 == true) goto L6;
        removeView(this.mCurrentView);
        ShortcutView r5 = new ShortcutView(getContext());
        this.mCurrentView = r5;
        addView(r5, getChildLp(r5));
    L10:
        this.mCurrentView.setMode(r0);
        if (r4 == false) goto L18;
        this.mCurrentView.setInsets(getPaddingStart(), getPaddingTop(), getPaddingEnd(), getPaddingBottom());
        applyConfigurations();
        ListContent r6 = this.mListContent;
        if (r6 != null) goto L15;
    L17:
        this.mCurrentView.setLoadingActions(r3);
        goto L18
    L15:
        if (r6.isValid() == false) goto L17;
        this.mCurrentView.setSliceContent(this.mListContent);
    L18:
        updateActions();
        return;
    L6:
        if (r0 == 3) goto L9;
        if (r2 == false) goto L9;
        removeView(this.mCurrentView);
        LargeTemplateView r7 = new LargeTemplateView(getContext());
        this.mCurrentView = r7;
        addView(r7, getChildLp(r7));
    L9:
        r4 = false;
        goto L10
    }

    private void applyConfigurations() {
        this.mCurrentView.setSliceActionListener(this.mSliceObserver);
        SliceChildView r0 = this.mCurrentView;
        if ((r0 instanceof LargeTemplateView) == false) goto L5;
        ((LargeTemplateView) r0).setScrollable(this.mIsScrollable);
    L5:
        this.mCurrentView.setStyle(this.mSliceStyle);
        this.mCurrentView.setTint(getTintColor());
        ListContent r1 = this.mListContent;
        if (r1 != null) goto L8;
    L10:
        this.mCurrentView.setLayoutDirection(2);
        return;
    L8:
        if (r1.getLayoutDirItem() == null) goto L10;
        this.mCurrentView.setLayoutDirection(this.mListContent.getLayoutDirItem().getInt());
    }

    private void updateActions() {
        if (this.mActions != null) goto L6;
        this.mActionRow.setVisibility(8);
        this.mCurrentView.setSliceActions(null);
        return;
    L6:
        ArrayList r0 = new ArrayList(this.mActions);
        Collections.sort(r0, SLICE_ACTION_PRIORITY_COMPARATOR);
        if (this.mShowActions == true) goto L9;
    L13:
        this.mCurrentView.setSliceActions(r0);
        this.mActionRow.setVisibility(8);
        return;
    L9:
        if (this.mMode == 3) goto L13;
        if (this.mActions.size() < 2) goto L13;
        this.mActionRow.setActions(r0, getTintColor());
        this.mActionRow.setVisibility(0);
        this.mCurrentView.setSliceActions(null);
    }

    private int getTintColor() {
        int r0 = this.mThemeTintColor;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        SliceItem r1 = SliceQuery.findSubtype(this.mCurrentSlice, "int", "color");
        if (r1 == null) goto L9;
        return r1.getInt();
    L9:
        return SliceViewUtil.getColorAccent(getContext());
    }

    private ViewGroup.LayoutParams getChildLp(View r1) {
        if ((r1 instanceof ShortcutView) == false) goto L7;
        int r0 = this.mShortcutSize;
        return new ViewGroup.LayoutParams(r0, r0);
    L7:
        return new ViewGroup.LayoutParams(-1, -1);
    }

    public static String modeToString(int r2) {
        if (r2 != 1) goto L5;
        return "MODE SMALL";
    L5:
        if (r2 != 2) goto L7;
        return "MODE LARGE";
    L7:
        if (r2 != 3) goto L9;
        return "MODE SHORTCUT";
    L9:
        return "unknown mode: " + r2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown() == false) goto L6;
        logSliceMetricsVisibilityChange(true);
        refreshLastUpdatedLabel(true);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        logSliceMetricsVisibilityChange(false);
        refreshLastUpdatedLabel(false);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View r3, int r4) {
        super.onVisibilityChanged(r3, r4);
        if (isAttachedToWindow() == false) goto L14;
        boolean r5 = true;
        if (r4 != 0) goto L7;
        boolean r1 = true;
    L8:
        logSliceMetricsVisibilityChange(r1);
        if (r4 == 0) goto L12;
        r5 = false;
    L12:
        refreshLastUpdatedLabel(r5);
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r4) {
        super.onWindowVisibilityChanged(r4);
        boolean r0 = true;
        if (r4 != 0) goto L5;
        boolean r2 = true;
    L6:
        logSliceMetricsVisibilityChange(r2);
        if (r4 == 0) goto L10;
        r0 = false;
    L10:
        refreshLastUpdatedLabel(r0);
        return;
    L5:
        r2 = false;
        goto L6
    }

    private void initSliceMetrics(Slice r4) {
        if (r4 != null) goto L5;
    L12:
        logSliceMetricsVisibilityChange(false);
        this.mCurrentSliceMetrics = null;
        return;
    L5:
        if (r4.getUri() == null) goto L12;
        Slice r1 = this.mCurrentSlice;
        if (r1 != null) goto L10;
    L11:
        logSliceMetricsVisibilityChange(false);
        this.mCurrentSliceMetrics = SliceMetrics.getInstance(getContext(), r4.getUri());
        return;
    L10:
        if (r1.getUri().equals(r4.getUri()) == false) goto L11;
    }

    private void logSliceMetricsVisibilityChange(boolean r3) {
        SliceMetrics r0 = this.mCurrentSliceMetrics;
        if (r0 == null) goto L13;
        if (r3 == true) goto L6;
    L8:
        if (r3 == false) goto L10;
        return;
    L10:
        if (this.mCurrentSliceLoggedVisible == false) goto L15;
        this.mCurrentSliceMetrics.logHidden();
        this.mCurrentSliceLoggedVisible = false;
        return;
    L15:
        return;
    L6:
        if (this.mCurrentSliceLoggedVisible == true) goto L8;
        r0.logVisible();
        this.mCurrentSliceLoggedVisible = true;
        goto L8
    }

    private void logSliceMetricsOnTouch(SliceItem r2, EventInfo r3) {
        if (this.mCurrentSliceMetrics != null) goto L5;
        return;
    L5:
        if (r2.getSlice() != null) goto L7;
        return;
    L7:
        if (r2.getSlice().getUri() == null) goto L12;
        this.mCurrentSliceMetrics.logTouch(r3.actionType, this.mListContent.getPrimaryAction().getSlice().getUri());
        return;
    }

    private void refreshLastUpdatedLabel(boolean r7) {
        if (this.mShowLastUpdated == true) goto L5;
        return;
    L5:
        if (isNeverExpired() == true) goto L15;
        if (r7 == false) goto L12;
        Handler r8 = this.mHandler;
        Runnable r0 = this.mRefreshLastUpdated;
        long r2 = 60000;
        if (isExpired() == true) goto L11;
        r2 = 60000 + getTimeToExpiry();
    L11:
        r8.postDelayed(r0, r2);
        return;
    L12:
        this.mHandler.removeCallbacks(this.mRefreshLastUpdated);
        return;
    }

    static {
        SLICE_ACTION_PRIORITY_COMPARATOR = new AnonymousClass3();
    }
}
