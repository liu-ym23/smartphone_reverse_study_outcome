package androidx.slice.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.SliceItem;
import androidx.slice.SliceStructure;
import androidx.slice.core.SliceAction;
import androidx.slice.core.SliceActionImpl;
import androidx.slice.core.SliceHints;
import androidx.slice.core.SliceQuery;
import androidx.slice.view.R;
import com.android.settings.inputmethod.UserDictionaryAddWordContents;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class RowView extends SliceChildView implements View.OnClickListener {
    private static final int MAX_END_ITEMS = 3;
    private static final int SLIDER_INTERVAL = 200;
    private static final String TAG = "RowView";
    private static final boolean sCanSpecifyLargerRangeBarHeight = false;
    private ProgressBar mActionSpinner;
    private ArrayMap<SliceActionImpl, SliceActionView> mActions;
    private boolean mAllowTwoLines;
    private LinearLayout mContent;
    private View mDivider;
    private LinearLayout mEndContainer;
    Handler mHandler;
    private List<SliceAction> mHeaderActions;
    private int mIconSize;
    private int mIdealRangeHeight;
    private int mImageSize;
    private boolean mIsHeader;
    boolean mIsRangeSliding;
    private boolean mIsSingleItem;
    long mLastSentRangeUpdate;
    private TextView mLastUpdatedText;
    protected Set<SliceItem> mLoadingActions;
    private int mMaxSmallHeight;
    private int mMeasuredRangeHeight;
    private TextView mPrimaryText;
    private ProgressBar mRangeBar;
    boolean mRangeHasPendingUpdate;
    private SliceItem mRangeItem;
    int mRangeMinValue;
    Runnable mRangeUpdater;
    boolean mRangeUpdaterRunning;
    int mRangeValue;
    private LinearLayout mRootView;
    private SliceActionImpl mRowAction;
    RowContent mRowContent;
    int mRowIndex;
    private TextView mSecondaryText;
    private View mSeeMoreView;
    private SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;
    boolean mShowActionSpinner;
    private LinearLayout mStartContainer;
    private SliceItem mStartItem;
    private ArrayMap<SliceActionImpl, SliceActionView> mToggles;

    static {
        sCanSpecifyLargerRangeBarHeight = true;
    }

    public RowView(Context r4) {
        super(r4);
        this.mToggles = new ArrayMap();
        this.mActions = new ArrayMap();
        this.mLoadingActions = new HashSet();
        this.mRangeUpdater = new AnonymousClass2(this);
        this.mSeekBarChangeListener = new AnonymousClass3(this);
        this.mIconSize = getContext().getResources().getDimensionPixelSize(R.dimen.abc_slice_icon_size);
        this.mImageSize = getContext().getResources().getDimensionPixelSize(R.dimen.abc_slice_small_image_size);
        LinearLayout r0 = (LinearLayout) LayoutInflater.from(r4).inflate(R.layout.abc_slice_small_template, this, false);
        this.mRootView = r0;
        addView(r0);
        this.mStartContainer = (LinearLayout) findViewById(R.id.icon_frame);
        this.mContent = (LinearLayout) findViewById(android.R.id.content);
        this.mPrimaryText = (TextView) findViewById(android.R.id.title);
        this.mSecondaryText = (TextView) findViewById(android.R.id.summary);
        this.mLastUpdatedText = (TextView) findViewById(R.id.last_updated);
        this.mDivider = findViewById(R.id.divider);
        this.mActionSpinner = (ProgressBar) findViewById(R.id.action_sent_indicator);
        SliceViewUtil.tintIndeterminateProgressBar(getContext(), this.mActionSpinner);
        this.mEndContainer = (LinearLayout) findViewById(android.R.id.widget_frame);
        this.mIdealRangeHeight = r4.getResources().getDimensionPixelSize(R.dimen.abc_slice_row_range_height);
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setInsets(int r2, int r3, int r4, int r5) {
        super.setInsets(r2, r3, r4, r5);
        this.mRootView.setPadding(r2, r3, r4, r5);
        if (this.mRangeBar == null) goto L6;
        updateRangePadding();
        return;
    }

    public void setSingleItem(boolean r1) {
        this.mIsSingleItem = r1;
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setMaxSmallHeight(int r1) {
        this.mMaxSmallHeight = r1;
        if (this.mRowContent == null) goto L6;
        populateViews(true);
        return;
    }

    @Override // androidx.slice.widget.SliceChildView
    public int getSmallHeight() {
        RowContent r0 = this.mRowContent;
        if (r0 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r0.isValid() == false) goto L7;
        return this.mRowContent.getSmallHeight(this.mMaxSmallHeight);
    }

    @Override // androidx.slice.widget.SliceChildView
    public int getActualHeight() {
        if (this.mIsSingleItem == true) goto L5;
        RowContent r0 = this.mRowContent;
        if (r0 != null) goto L9;
    L11:
        return 0;
    L9:
        if (r0.isValid() == false) goto L11;
        return this.mRowContent.getActualHeight(this.mMaxSmallHeight);
    L5:
        return getSmallHeight();
    }

    private int getRowContentHeight() {
        if (getMode() != 1) goto L5;
    L8:
        int r0 = getSmallHeight();
    L10:
        if (this.mRangeBar != null) goto L12;
        return r0;
    L12:
        return r0 - this.mIdealRangeHeight;
    L5:
        if (this.mIsSingleItem == true) goto L8;
        r0 = getActualHeight();
        goto L10
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setTint(int r1) {
        super.setTint(r1);
        if (this.mRowContent == null) goto L6;
        populateViews(true);
        return;
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setSliceActions(List<SliceAction> r1) {
        this.mHeaderActions = r1;
        if (this.mRowContent == null) goto L6;
        updateEndItems();
        return;
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setShowLastUpdated(boolean r1) {
        super.setShowLastUpdated(r1);
        if (this.mRowContent == null) goto L6;
        populateViews(true);
        return;
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setAllowTwoLines(boolean r1) {
        this.mAllowTwoLines = r1;
        if (this.mRowContent == null) goto L6;
        populateViews(true);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r5, int r6) {
        if (getMode() != 1) goto L5;
        int r7 = getSmallHeight();
    L6:
        int r0 = getRowContentHeight();
        if (r0 == 0) goto L9;
        this.mRootView.setVisibility(0);
        int r1 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        measureChild(this.mRootView, r5, r1);
    L11:
        if (this.mRangeBar != null) goto L13;
    L17:
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec(r7, 1073741824));
        return;
    L13:
        if (sCanSpecifyLargerRangeBarHeight == false) goto L15;
        int r2 = View.MeasureSpec.makeMeasureSpec(this.mIdealRangeHeight, 1073741824);
    L16:
        measureChild(this.mRangeBar, r5, r2);
        this.mMeasuredRangeHeight = this.mRangeBar.getMeasuredHeight();
        goto L17
    L15:
        r2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L16
    L9:
        this.mRootView.setVisibility(8);
        goto L11
    L5:
        r7 = getActualHeight();
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        int r6 = this.mInsetStart + this.mInsetEnd;
        LinearLayout r7 = this.mRootView;
        r7.layout(0, 0, r7.getMeasuredWidth() + r6, getRowContentHeight());
        if (this.mRangeBar == null) goto L6;
        int r8 = (this.mIdealRangeHeight - this.mMeasuredRangeHeight) / 2;
        int r9 = getRowContentHeight() + r8;
        int r10 = this.mMeasuredRangeHeight + r9;
        ProgressBar r0 = this.mRangeBar;
        r0.layout(0, r9, r0.getMeasuredWidth(), r10);
        return;
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setSliceItem(SliceItem r4, boolean r5, int r6, int r7, SliceView.OnSliceActionListener r8) {
        setSliceActionListener(r8);
        if (r4 == null) goto L16;
        RowContent r9 = this.mRowContent;
        if (r9 == null) goto L16;
        if (r9.isValid() == false) goto L16;
        if (this.mRowContent == null) goto L11;
        SliceStructure r10 = new SliceStructure(this.mRowContent.getSlice());
    L12:
        boolean r0 = this.mRowContent.getSlice().getSlice().getUri().equals(r4.getSlice().getUri());
        boolean r11 = new SliceStructure(r4.getSlice()).equals(r10);
        if (r0 == false) goto L16;
        if (r11 == false) goto L16;
        boolean r12 = true;
    L17:
        this.mShowActionSpinner = false;
        this.mIsHeader = r5;
        this.mRowContent = new RowContent(getContext(), r4, this.mIsHeader);
        this.mRowIndex = r6;
        populateViews(r12);
        return;
    L11:
        r10 = null;
    L16:
        r12 = false;
        goto L17
    }

    private void populateViews(boolean r7) {
        if (r7 == true) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == true) goto L11;
        resetViewState();
    L11:
        if (this.mRowContent.getLayoutDirItem() == null) goto L14;
        setLayoutDirection(this.mRowContent.getLayoutDirItem().getInt());
    L14:
        if (this.mRowContent.isDefaultSeeMore() == false) goto L17;
        showSeeMore();
        return;
    L17:
        CharSequence r2 = this.mRowContent.getContentDescription();
        if (r2 == null) goto L20;
        this.mContent.setContentDescription(r2);
    L20:
        SliceItem r3 = this.mRowContent.getStartItem();
        this.mStartItem = r3;
        if (r3 != null) goto L23;
    L25:
        boolean r4 = false;
    L26:
        if (r4 == false) goto L28;
        r4 = addItem(r3, this.mTintColor, true);
    L28:
        LinearLayout r5 = this.mStartContainer;
        int r6 = 8;
        if (r4 == false) goto L31;
        int r9 = 0;
    L32:
        r5.setVisibility(r9);
        SliceItem r10 = this.mRowContent.getTitleItem();
        if (r10 == null) goto L36;
        this.mPrimaryText.setText(r10.getText());
    L36:
        if (this.mSliceStyle == null) goto L42;
        TextView r11 = this.mPrimaryText;
        if (this.mIsHeader == false) goto L40;
        int r12 = this.mSliceStyle.getHeaderTitleSize();
    L41:
        r11.setTextSize(0, r12);
        this.mPrimaryText.setTextColor(this.mSliceStyle.getTitleColor());
        goto L42
    L40:
        r12 = this.mSliceStyle.getTitleSize();
    L42:
        TextView r13 = this.mPrimaryText;
        if (r10 == null) goto L45;
        r6 = 0;
    L45:
        r13.setVisibility(r6);
        if (r10 == null) goto L48;
        boolean r14 = true;
    L49:
        addSubtitle(r14);
        SliceItem r15 = this.mRowContent.getPrimaryAction();
        if (r15 != null) goto L52;
    L57:
        SliceItem r1 = this.mRowContent.getRange();
        if (r1 != null) goto L60;
        updateEndItems();
        updateActionSpinner();
        return;
    L60:
        if (this.mRowAction == null) goto L62;
        setViewClickable(this.mRootView, true);
    L62:
        if (r8 == true) goto L64;
        determineRangeValues(r1);
        addRange(r1);
        return;
    L64:
        this.mRangeItem = r1;
        return;
    L52:
        if (r15 == this.mStartItem) goto L57;
        SliceActionImpl r16 = new SliceActionImpl(r15);
        this.mRowAction = r16;
        if (r16.isToggle() == false) goto L57;
        addAction(this.mRowAction, this.mTintColor, this.mEndContainer, false);
        setViewClickable(this.mRootView, true);
        return;
    L48:
        r14 = false;
        goto L49
    L31:
        r9 = 8;
        goto L32
    L23:
        if (this.mRowIndex <= 0) goto L25;
        r4 = true;
        goto L26
    L5:
        if (this.mIsRangeSliding == false) goto L7;
        r8 = true;
        goto L8
    }

    private void updateEndItems() {
        if (this.mRowContent != null) goto L5;
        return;
    L5:
        this.mEndContainer.removeAllViews();
        List r0 = this.mRowContent.getEndItems();
        List<SliceAction> r1 = this.mHeaderActions;
        if (r1 == null) goto L9;
        r0 = r1;
    L9:
        if (this.mRowIndex == 0) goto L11;
    L15:
        boolean r2 = false;
        SliceItem r3 = null;
        int r4 = 0;
        int r5 = 0;
        boolean r6 = false;
    L17:
        if (r4 >= r0.size()) goto L39;
        if ((r0.get(r4) instanceof SliceItem) == false) goto L21;
        SliceItem r7 = (SliceItem) r0.get(r4);
    L23:
        if (r5 >= 3) goto L38;
        if (addItem(r7, this.mTintColor, false) == false) goto L38;
        if (r3 == null) goto L28;
    L30:
        r5 = r5 + 1;
        if (r5 != 1) goto L38;
        if (this.mToggles.isEmpty() == false) goto L35;
    L37:
        r6 = false;
        goto L38
    L35:
        if (SliceQuery.find(r7.getSlice(), SlardarSettingsConsts.SETTING_IMAGE) != null) goto L37;
        r6 = true;
        goto L38
    L28:
        if (SliceQuery.find(r7, "action") == null) goto L30;
        r3 = r7;
    L38:
        r4 = r4 + 1;
        goto L17
    L21:
        r7 = ((SliceActionImpl) r0.get(r4)).getSliceItem();
        goto L23
    L39:
        LinearLayout r8 = this.mEndContainer;
        int r9 = 8;
        if (r5 <= 0) goto L42;
        int r10 = 0;
    L43:
        r8.setVisibility(r10);
        View r11 = this.mDivider;
        if (this.mRowAction == null) goto L47;
        if (r6 == false) goto L47;
        r9 = 0;
    L47:
        r11.setVisibility(r9);
        SliceItem r12 = this.mStartItem;
        if (r12 != null) goto L50;
    L52:
        boolean r13 = false;
    L53:
        if (r3 == null) goto L55;
        boolean r14 = true;
    L57:
        if (this.mRowAction == null) goto L59;
        setViewClickable(this.mRootView, true);
    L71:
        SliceActionImpl r15 = this.mRowAction;
        if (r15 == null) goto L84;
        if (r2 == false) goto L75;
        return;
    L75:
        if (this.mLoadingActions.contains(r15.getSliceItem()) == false) goto L86;
        this.mShowActionSpinner = true;
        return;
    L86:
        return;
    L84:
        return;
    L59:
        if (r14 == r13) goto L71;
        if (r5 == 1) goto L63;
        if (r13 == false) goto L71;
    L63:
        if (this.mToggles.isEmpty() == true) goto L66;
        this.mRowAction = this.mToggles.keySet().iterator().next();
    L70:
        setViewClickable(this.mRootView, true);
        r2 = true;
        goto L71
    L66:
        if (this.mActions.isEmpty() == true) goto L70;
        if (this.mActions.size() != 1) goto L70;
        this.mRowAction = this.mActions.valueAt(0).getAction();
        goto L70
    L55:
        r14 = false;
        goto L57
    L50:
        if (SliceQuery.find(r12, "action") == null) goto L52;
        r13 = true;
        goto L53
    L42:
        r10 = 8;
        goto L43
    L11:
        if (this.mStartItem == null) goto L15;
        if (r0.isEmpty() == false) goto L15;
        r0.add(this.mStartItem);
        goto L15
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setLastUpdated(long r1) {
        super.setLastUpdated(r1);
        RowContent r2 = this.mRowContent;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getTitleItem() != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        addSubtitle(r3);
        return;
    L7:
        if (TextUtils.isEmpty(this.mRowContent.getTitleItem().getText()) == false) goto L9;
        r3 = true;
        goto L10
    }

    private void addSubtitle(boolean r10) {
        if (this.mRowContent != null) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (getMode() != 1) goto L8;
        SliceItem r0 = this.mRowContent.getSummaryItem();
    L9:
        CharSequence r3 = null;
        if (this.mShowLastUpdated == true) goto L12;
    L16:
        String r2 = null;
    L17:
        if (r0 == null) goto L20;
        r3 = r0.getText();
    L20:
        if (TextUtils.isEmpty(r3) == false) goto L26;
        if (r0 != null) goto L23;
    L25:
        boolean r4 = false;
    L27:
        if (r4 == false) goto L39;
        this.mSecondaryText.setText(r3);
        if (this.mSliceStyle == null) goto L39;
        TextView r5 = this.mSecondaryText;
        if (this.mIsHeader == false) goto L33;
        int r6 = this.mSliceStyle.getHeaderSubtitleSize();
    L34:
        r5.setTextSize(0, r6);
        this.mSecondaryText.setTextColor(this.mSliceStyle.getSubtitleColor());
        if (this.mIsHeader == false) goto L37;
        int r7 = this.mSliceStyle.getVerticalHeaderTextPadding();
    L38:
        this.mSecondaryText.setPadding(0, r7, 0, 0);
        goto L39
    L37:
        r7 = this.mSliceStyle.getVerticalTextPadding();
        goto L38
    L33:
        r6 = this.mSliceStyle.getSubtitleSize();
    L39:
        int r8 = 2;
        if (r2 != null) goto L42;
    L51:
        TextView r9 = this.mLastUpdatedText;
        int r11 = 8;
        if (TextUtils.isEmpty(r2) == false) goto L54;
        int r12 = 8;
    L55:
        r9.setVisibility(r12);
        TextView r13 = this.mSecondaryText;
        if (r4 == false) goto L58;
        r11 = 0;
    L58:
        r13.setVisibility(r11);
        if (this.mRowIndex <= 0) goto L61;
    L64:
        boolean r14 = true;
    L65:
        if (r14 == false) goto L71;
        if (r10 == true) goto L71;
        if (r4 == false) goto L71;
        if (TextUtils.isEmpty(r2) == false) goto L71;
    L72:
        TextView r15 = this.mSecondaryText;
        if (r8 == 1) goto L76;
        r1 = false;
    L76:
        r15.setSingleLine(r1);
        this.mSecondaryText.setMaxLines(r8);
        this.mSecondaryText.requestLayout();
        this.mLastUpdatedText.requestLayout();
        return;
    L71:
        r8 = 1;
        goto L72
    L61:
        if (this.mAllowTwoLines == true) goto L64;
        r14 = false;
        goto L65
    L54:
        r12 = 0;
        goto L55
    L42:
        if (TextUtils.isEmpty(r3) == true) goto L44;
        r2 = " · " + r2;
    L44:
        SpannableString r16 = new SpannableString(r2);
        r16.setSpan(new StyleSpan(2), 0, r2.length(), 0);
        this.mLastUpdatedText.setText(r16);
        if (this.mSliceStyle == null) goto L51;
        TextView r17 = this.mLastUpdatedText;
        if (this.mIsHeader == false) goto L49;
        int r18 = this.mSliceStyle.getHeaderSubtitleSize();
    L50:
        r17.setTextSize(0, r18);
        this.mLastUpdatedText.setTextColor(this.mSliceStyle.getSubtitleColor());
        goto L51
    L49:
        r18 = this.mSliceStyle.getSubtitleSize();
        goto L50
    L23:
        if (r0.hasHint("partial") == false) goto L25;
    L26:
        r4 = true;
        goto L27
    L12:
        if (this.mLastUpdated == (-1)) goto L16;
        CharSequence r19 = getRelativeTimeString(this.mLastUpdated);
        if (r19 == null) goto L16;
        r2 = getResources().getString(R.string.abc_slice_updated, new Object[]{r19});
        goto L17
    L8:
        r0 = this.mRowContent.getSubtitleItem();
        goto L9
    }

    private CharSequence getRelativeTimeString(long r6) {
        long r0 = System.currentTimeMillis() - r6;
        if (r0 <= 31449600000L) goto L7;
        int r7 = (int) (r0 / 31449600000L);
        return getResources().getQuantityString(R.plurals.abc_slice_duration_years, r7, new Object[]{Integer.valueOf(r7)});
    L7:
        if (r0 <= 86400000) goto L11;
        int r8 = (int) (r0 / 86400000);
        return getResources().getQuantityString(R.plurals.abc_slice_duration_days, r8, new Object[]{Integer.valueOf(r8)});
    L11:
        if (r0 <= 60000) goto L14;
        int r9 = (int) (r0 / 60000);
        return getResources().getQuantityString(R.plurals.abc_slice_duration_min, r9, new Object[]{Integer.valueOf(r9)});
    L14:
        return null;
    }

    private void determineRangeValues(SliceItem r4) {
        int r0 = 0;
        if (r4 != null) goto L6;
        this.mRangeMinValue = 0;
        this.mRangeValue = 0;
        return;
    L6:
        this.mRangeItem = r4;
        SliceItem r5 = SliceQuery.findSubtype(r4, "int", SliceHints.SUBTYPE_MIN);
        if (r5 == null) goto L9;
        r0 = r5.getInt();
    L9:
        this.mRangeMinValue = r0;
        SliceItem r6 = SliceQuery.findSubtype(this.mRangeItem, "int", "value");
        if (r6 == null) goto L13;
        this.mRangeValue = r6.getInt() - r0;
        return;
    }

    private void addRange(SliceItem r6) {
        if (this.mHandler != null) goto L5;
        this.mHandler = new Handler();
    L5:
        boolean r0 = "action".equals(r6.getFormat());
        if (r0 == false) goto L8;
        ProgressBar r1 = new SeekBar(getContext());
    L9:
        Drawable r2 = DrawableCompat.wrap(r1.getProgressDrawable());
        if (this.mTintColor == (-1)) goto L13;
        if (r2 == null) goto L13;
        DrawableCompat.setTint(r2, this.mTintColor);
        r1.setProgressDrawable(r2);
    L13:
        SliceItem r7 = SliceQuery.findSubtype(r6, "int", "max");
        if (r7 == null) goto L16;
        r1.setMax(r7.getInt() - this.mRangeMinValue);
    L16:
        r1.setProgress(this.mRangeValue);
        r1.setVisibility(0);
        addView(r1);
        this.mRangeBar = r1;
        if (r0 == false) goto L30;
        SliceItem r8 = this.mRowContent.getInputRangeThumb();
        SeekBar r3 = (SeekBar) this.mRangeBar;
        if (r8 != null) goto L21;
    L25:
        Drawable r9 = DrawableCompat.wrap(r3.getThumb());
        if (this.mTintColor == (-1)) goto L29;
        if (r9 == null) goto L29;
        DrawableCompat.setTint(r9, this.mTintColor);
        r3.setThumb(r9);
    L29:
        r3.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
        goto L30
    L21:
        if (r8.getIcon() == null) goto L25;
        Drawable r10 = r8.getIcon().loadDrawable(getContext());
        if (r10 == null) goto L25;
        r3.setThumb(r10);
    L30:
        updateRangePadding();
        return;
    L8:
        r1 = new ProgressBar(getContext(), null, android.R.attr.progressBarStyleHorizontal);
        goto L9
    }

    private void updateRangePadding() {
        ProgressBar r0 = this.mRangeBar;
        if (r0 == null) goto L24;
        int r2 = 0;
        if ((r0 instanceof SeekBar) == false) goto L7;
        int r1 = ((SeekBar) r0).getThumb().getIntrinsicWidth();
    L8:
        RowContent r3 = this.mRowContent;
        if (r3 != null) goto L11;
    L13:
        int r4 = this.mInsetTop;
    L14:
        if (r1 == 0) goto L20;
        int r5 = r1 / 2;
        if (this.mInsetStart < r5) goto L20;
        if (this.mInsetEnd < r5) goto L20;
        this.mRangeBar.setPadding(this.mInsetStart, r4, this.mInsetEnd, this.mInsetBottom);
        return;
    L20:
        if (r1 == 0) goto L22;
        r2 = r1 / 2;
    L22:
        this.mRangeBar.setPadding(this.mInsetStart + r2, r4, this.mInsetEnd + r2, this.mInsetBottom);
        return;
    L11:
        if (r3.getLineCount() <= 0) goto L13;
        r4 = 0;
        goto L14
    L7:
        r1 = 0;
        goto L8
    }

    void sendSliderValue() {
        if (this.mRangeItem == null) goto L11;
        this.mLastSentRangeUpdate = System.currentTimeMillis();     // Catch: PendingIntent.CanceledException -> L6
        this.mRangeItem.fireAction(getContext(), new Intent().addFlags(268435456).putExtra("android.app.slice.extra.RANGE_VALUE", this.mRangeValue));     // Catch: PendingIntent.CanceledException -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "PendingIntent for slice cannot be sent", e);
        return;
    }

    private void addAction(SliceActionImpl r9, int r10, ViewGroup r11, boolean r12) {
        SliceActionView r6 = new SliceActionView(getContext());
        r11.addView(r6);
        if (r11.getVisibility() != 8) goto L5;
        r11.setVisibility(0);
    L5:
        boolean r13 = r9.isToggle();
        int r0 = !r13 ? 1 : 0;
        if (r13 == false) goto L8;
        int r1 = 3;
    L9:
        EventInfo r3 = new EventInfo(getMode(), r0, r1, this.mRowIndex);
        if (r12 == false) goto L12;
        r3.setPosition(0, 0, 1);
    L12:
        r6.setAction(r9, r3, this.mObserver, r10, this.mLoadingListener);
        if (this.mLoadingActions.contains(r9.getSliceItem()) == false) goto L15;
        r6.setLoading(true);
    L15:
        if (r13 == false) goto L17;
        this.mToggles.put(r9, r6);
        return;
    L17:
        this.mActions.put(r9, r6);
        return;
    L8:
        r1 = 0;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.view.View, android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.view.View, android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.slice.widget.RowView] */
    private boolean addItem(SliceItem r7, int r8, boolean r9) {
        if (r9 == false) goto L4;
        ?? r0 = this.mStartContainer;
    L6:
        if ("slice".equals(r7.getFormat()) == true) goto L10;
        if ("action".equals(r7.getFormat()) == true) goto L10;
    L17:
        ?? r1 = 0;
        if (SlardarSettingsConsts.SETTING_IMAGE.equals(r7.getFormat()) == false) goto L21;
        IconCompat r10 = r7.getIcon();
        boolean r4 = r7.hasHint("no_tint");
        SliceItem r5 = null;
    L25:
        if (r10 == null) goto L36;
        boolean r11 = !r4;
        r1 = new ImageView(getContext());
        r1.setImageDrawable(r10.loadDrawable(getContext()));
        if (r11 == true) goto L29;
    L31:
        r0.addView(r1);
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) r1.getLayoutParams();
        r12.width = this.mImageSize;
        r12.height = this.mImageSize;
        r1.setLayoutParams(r12);
        if (r11 == false) goto L34;
        int r6 = this.mIconSize / 2;
    L35:
        r1.setPadding(r6, r6, r6, r6);
    L41:
        if (r1 == 0) goto L44;
        return true;
    L44:
        return false;
    L34:
        r6 = 0;
        goto L35
    L29:
        if (r8 == (-1)) goto L31;
        r1.setColorFilter(r8);
        goto L31
    L36:
        if (r5 == null) goto L41;
        r1 = new TextView(getContext());
        r1.setText(SliceViewUtil.getTimestampString(getContext(), r7.getLong()));
        if (this.mSliceStyle == null) goto L40;
        r1.setTextSize(0, this.mSliceStyle.getSubtitleSize());
        r1.setTextColor(this.mSliceStyle.getSubtitleColor());
    L40:
        r0.addView(r1);
        goto L41
    L21:
        if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r7.getFormat()) == false) goto L23;
        r5 = r7;
        r10 = null;
    L24:
        r4 = false;
        goto L25
    L23:
        r10 = null;
        r5 = null;
    L10:
        if (r7.hasHint(UserDictionaryAddWordContents.EXTRA_SHORTCUT) == false) goto L14;
        addAction(new SliceActionImpl(r7), r8, r0, r9);
        return true;
    L14:
        if (r7.getSlice().getItems().size() != 0) goto L16;
        return false;
    L16:
        r7 = r7.getSlice().getItems().get(0);
        goto L17
    L4:
        r0 = this.mEndContainer;
        goto L6
    }

    private void showSeeMore() {
        final Button r0 = (Button) LayoutInflater.from(getContext()).inflate(R.layout.abc_slice_row_show_more, this, false);
        r0.setOnClickListener(new AnonymousClass1(this, r0));
        if (this.mTintColor == (-1)) goto L5;
        r0.setTextColor(this.mTintColor);
    L5:
        this.mSeeMoreView = r0;
        this.mRootView.addView(r0);
        if (this.mLoadingActions.contains(this.mRowContent.getSlice()) == false) goto L9;
        this.mShowActionSpinner = true;
        r0.setVisibility(8);
        updateActionSpinner();
        return;
    }

    void updateActionSpinner() {
        ProgressBar r0 = this.mActionSpinner;
        if (this.mShowActionSpinner == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setLoadingActions(Set<SliceItem> r1) {
        if (r1 != null) goto L4;
        this.mLoadingActions.clear();
        this.mShowActionSpinner = false;
    L5:
        updateEndItems();
        updateActionSpinner();
        return;
    L4:
        this.mLoadingActions = r1;
        goto L5
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        SliceActionImpl r0 = this.mRowAction;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getActionItem() != null) goto L8;
        return;
    L8:
        if (this.mRowAction.isToggle() == false) goto L10;
        SliceActionView r1 = this.mToggles.get(this.mRowAction);
    L11:
        if (r1 == null) goto L16;
        if ((r3 instanceof SliceActionView) == true) goto L16;
        r1.sendAction();
        return;
    L16:
        if (this.mRowIndex != 0) goto L28;
        performClick();
        return;
    L28:
        boolean r4 = this.mRowAction.getActionItem().fireActionInternal(getContext(), null);     // Catch: PendingIntent.CanceledException -> L25
        this.mShowActionSpinner = r4;     // Catch: PendingIntent.CanceledException -> L25
        if (r4 == true) goto L21;
    L23:
        updateActionSpinner();     // Catch: PendingIntent.CanceledException -> L25
        return;
    L21:
        if (this.mLoadingListener == null) goto L23;
        this.mLoadingListener.onSliceActionLoading(this.mRowAction.getSliceItem(), this.mRowIndex);     // Catch: PendingIntent.CanceledException -> L25
        this.mLoadingActions.add(this.mRowAction.getSliceItem());     // Catch: PendingIntent.CanceledException -> L25
    L25:
        e = move-exception;
        Log.e(TAG, "PendingIntent for slice cannot be sent", e);
        return;
    L10:
        r1 = this.mActions.get(this.mRowAction);
        goto L11
    }

    private void setViewClickable(View r3, boolean r4) {
        Drawable r0 = null;
        if (r4 == false) goto L5;
        View.OnClickListener r1 = this;
    L6:
        r3.setOnClickListener(r1);
        if (r4 == false) goto L9;
        r0 = SliceViewUtil.getDrawable(getContext(), android.R.attr.selectableItemBackground);
    L9:
        r3.setBackground(r0);
        r3.setClickable(r4);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // androidx.slice.widget.SliceChildView
    public void resetView() {
        this.mRowContent = null;
        this.mLoadingActions.clear();
        resetViewState();
    }

    private void resetViewState() {
        this.mRootView.setVisibility(0);
        setLayoutDirection(2);
        setViewClickable(this.mRootView, false);
        setViewClickable(this.mContent, false);
        this.mStartContainer.removeAllViews();
        this.mEndContainer.removeAllViews();
        this.mEndContainer.setVisibility(8);
        this.mPrimaryText.setText(null);
        this.mSecondaryText.setText(null);
        this.mLastUpdatedText.setText(null);
        this.mLastUpdatedText.setVisibility(8);
        this.mToggles.clear();
        this.mActions.clear();
        this.mRowAction = null;
        this.mStartItem = null;
        this.mDivider.setVisibility(8);
        View r0 = this.mSeeMoreView;
        if (r0 == null) goto L5;
        this.mRootView.removeView(r0);
        this.mSeeMoreView = null;
    L5:
        this.mIsRangeSliding = false;
        this.mRangeHasPendingUpdate = false;
        this.mRangeItem = null;
        this.mRangeMinValue = 0;
        this.mRangeValue = 0;
        this.mLastSentRangeUpdate = 0;
        this.mHandler = null;
        ProgressBar r1 = this.mRangeBar;
        if (r1 == null) goto L8;
        removeView(r1);
        this.mRangeBar = null;
    L8:
        this.mActionSpinner.setVisibility(8);
    }
}
