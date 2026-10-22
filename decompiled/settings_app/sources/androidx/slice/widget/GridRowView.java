package androidx.slice.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.slice.SliceItem;
import androidx.slice.core.SliceQuery;
import androidx.slice.view.R;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class GridRowView extends SliceChildView implements View.OnClickListener, View.OnTouchListener {
    private static final int MAX_CELL_IMAGES = 1;
    private static final int MAX_CELL_TEXT = 2;
    private static final int MAX_CELL_TEXT_SMALL = 1;
    private static final String TAG = "GridRowView";
    private static final int TEXT_LAYOUT = 0;
    private static final int TITLE_TEXT_LAYOUT = 0;
    private View mForeground;
    private GridContent mGridContent;
    private int mGutter;
    private int mIconSize;
    private int mLargeImageHeight;
    private int[] mLoc;
    boolean mMaxCellUpdateScheduled;
    int mMaxCells;
    private ViewTreeObserver.OnPreDrawListener mMaxCellsUpdater;
    private int mRowCount;
    private int mRowIndex;
    private int mSmallImageMinWidth;
    private int mSmallImageSize;
    private int mTextPadding;
    private LinearLayout mViewContainer;

    static {
        TITLE_TEXT_LAYOUT = R.layout.abc_slice_title;
        TEXT_LAYOUT = R.layout.abc_slice_secondary_text;
    }

    public GridRowView(Context r2) {
        this(r2, null);
    }

    public GridRowView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mMaxCells = -1;
        this.mLoc = new int[2];
        this.mMaxCellsUpdater = new AnonymousClass1(this);
        Resources r5 = getContext().getResources();
        LinearLayout r0 = new LinearLayout(getContext());
        this.mViewContainer = r0;
        r0.setOrientation(0);
        addView(this.mViewContainer, new FrameLayout.LayoutParams(-1, -1));
        this.mViewContainer.setGravity(16);
        this.mIconSize = r5.getDimensionPixelSize(R.dimen.abc_slice_icon_size);
        this.mSmallImageSize = r5.getDimensionPixelSize(R.dimen.abc_slice_small_image_size);
        this.mLargeImageHeight = r5.getDimensionPixelSize(R.dimen.abc_slice_grid_image_only_height);
        this.mSmallImageMinWidth = r5.getDimensionPixelSize(R.dimen.abc_slice_grid_image_min_width);
        this.mGutter = r5.getDimensionPixelSize(R.dimen.abc_slice_grid_gutter);
        this.mTextPadding = r5.getDimensionPixelSize(R.dimen.abc_slice_grid_text_padding);
        View r6 = new View(getContext());
        this.mForeground = r6;
        addView(r6, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setInsets(int r3, int r4, int r5, int r6) {
        super.setInsets(r3, r4, r5, r6);
        this.mViewContainer.setPadding(r3, r4 + getExtraTopPadding(), r5, r6 + getExtraBottomPadding());
    }

    @Override // androidx.slice.widget.SliceChildView
    public int getSmallHeight() {
        GridContent r0 = this.mGridContent;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return (r0.getSmallHeight() + getExtraTopPadding()) + getExtraBottomPadding();
    }

    @Override // androidx.slice.widget.SliceChildView
    public int getActualHeight() {
        GridContent r0 = this.mGridContent;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return (r0.getActualHeight() + getExtraTopPadding()) + getExtraBottomPadding();
    }

    private int getExtraTopPadding() {
        GridContent r0 = this.mGridContent;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.isAllImages() == true) goto L7;
        return 0;
    L7:
        if (this.mRowIndex == 0) goto L9;
        return 0;
    L9:
        if (this.mSliceStyle != null) goto L11;
        return 0;
    L11:
        return this.mSliceStyle.getGridTopPadding();
    }

    private int getExtraBottomPadding() {
        GridContent r0 = this.mGridContent;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.isAllImages() == true) goto L7;
        return 0;
    L7:
        if (this.mRowIndex == (this.mRowCount - 1)) goto L11;
        if (getMode() == 1) goto L11;
        return 0;
    L11:
        if (this.mSliceStyle != null) goto L13;
        return 0;
    L13:
        return this.mSliceStyle.getGridBottomPadding();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        if (getMode() != 1) goto L5;
        int r5 = getSmallHeight();
    L6:
        int r0 = View.MeasureSpec.makeMeasureSpec(r5, 1073741824);
        this.mViewContainer.getLayoutParams().height = r5;
        super.onMeasure(r3, r0);
        return;
    L5:
        r5 = getActualHeight();
        goto L6
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setTint(int r1) {
        super.setTint(r1);
        if (this.mGridContent == null) goto L6;
        resetView();
        populateViews();
        return;
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setSliceItem(SliceItem r1, boolean r2, int r3, int r4, SliceView.OnSliceActionListener r5) {
        resetView();
        setSliceActionListener(r5);
        this.mRowIndex = r3;
        this.mRowCount = r4;
        this.mGridContent = new GridContent(getContext(), r1);
        if (scheduleMaxCellsUpdate() == true) goto L5;
        populateViews();
    L5:
        this.mViewContainer.setPadding(this.mInsetStart, this.mInsetTop + getExtraTopPadding(), this.mInsetEnd, this.mInsetBottom + getExtraBottomPadding());
    }

    private boolean scheduleMaxCellsUpdate() {
        GridContent r0 = this.mGridContent;
        if (r0 != null) goto L5;
    L13:
        return true;
    L5:
        if (r0.isValid() == false) goto L13;
        if (getWidth() != 0) goto L11;
        this.mMaxCellUpdateScheduled = true;
        getViewTreeObserver().addOnPreDrawListener(this.mMaxCellsUpdater);
        return true;
    L11:
        this.mMaxCells = getMaxCells();
        return false;
    }

    int getMaxCells() {
        GridContent r0 = this.mGridContent;
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (r0.isValid() == true) goto L7;
        return -1;
    L7:
        if (getWidth() != 0) goto L10;
        return -1;
    L10:
        if (this.mGridContent.getGridContent().size() > 1) goto L12;
        return 1;
    L12:
        if (this.mGridContent.getLargestImageMode() != 2) goto L14;
        int r1 = this.mLargeImageHeight;
    L16:
        return getWidth() / (r1 + this.mGutter);
    L14:
        r1 = this.mSmallImageMinWidth;
        goto L16
    }

    void populateViews() {
        GridContent r0 = this.mGridContent;
        if (r0 != null) goto L5;
    L35:
        resetView();
        return;
    L5:
        if (r0.isValid() == false) goto L35;
        if (scheduleMaxCellsUpdate() == false) goto L11;
        return;
    L11:
        if (this.mGridContent.getLayoutDirItem() == null) goto L13;
        setLayoutDirection(this.mGridContent.getLayoutDirItem().getInt());
    L13:
        boolean r1 = true;
        if (this.mGridContent.getContentIntent() == null) goto L16;
        this.mViewContainer.setTag(new Pair(this.mGridContent.getContentIntent(), new EventInfo(getMode(), 3, 1, this.mRowIndex)));
        makeEntireGridClickable(true);
    L16:
        CharSequence r2 = this.mGridContent.getContentDescription();
        if (r2 == null) goto L19;
        this.mViewContainer.setContentDescription(r2);
    L19:
        ArrayList<GridContent.CellContent> r3 = this.mGridContent.getGridContent();
        if (this.mGridContent.getLargestImageMode() != 2) goto L22;
        this.mViewContainer.setGravity(48);
    L23:
        int r4 = this.mMaxCells;
        int r5 = 0;
        if (this.mGridContent.getSeeMoreItem() != null) goto L28;
        r1 = false;
    L28:
        if (r5 >= r3.size()) goto L41;
        if (this.mViewContainer.getChildCount() >= r4) goto L31;
        addCell(r3.get(r5), r5, Math.min(r3.size(), r4));
        r5 = r5 + 1;
        goto L28
    L31:
        if (r1 == false) goto L34;
        addSeeMoreCount(r3.size() - r4);
        return;
    L34:
        return;
    L41:
        return;
    L22:
        this.mViewContainer.setGravity(16);
        goto L23
    }

    private void addSeeMoreCount(int r12) {
        LinearLayout r0 = this.mViewContainer;
        View r1 = r0.getChildAt(r0.getChildCount() - 1);
        this.mViewContainer.removeView(r1);
        SliceItem r2 = this.mGridContent.getSeeMoreItem();
        int r3 = this.mViewContainer.getChildCount();
        int r4 = this.mMaxCells;
        if ("slice".equals(r2.getFormat()) == true) goto L7;
        if ("action".equals(r2.getFormat()) == true) goto L7;
    L10:
        LayoutInflater r5 = LayoutInflater.from(getContext());
        if (this.mGridContent.isAllImages() == false) goto L13;
        ViewGroup r6 = (FrameLayout) r5.inflate(R.layout.abc_slice_grid_see_more_overlay, this.mViewContainer, false);
        r6.addView(r1, 0, new FrameLayout.LayoutParams(-1, -1));
        TextView r7 = (TextView) r6.findViewById(R.id.text_see_more_count);
    L16:
        this.mViewContainer.addView(r6, new LinearLayout.LayoutParams(0, -1, 1.0f));
        r7.setText(getResources().getString(R.string.abc_slice_more_content, new Object[]{Integer.valueOf(r12)}));
        EventInfo r13 = new EventInfo(getMode(), 4, 1, this.mRowIndex);
        r13.setPosition(2, r3, r4);
        r6.setTag(new Pair(r2, r13));
        makeClickable(r6, true);
        return;
    L13:
        r6 = (LinearLayout) r5.inflate(R.layout.abc_slice_grid_see_more, this.mViewContainer, false);
        r7 = (TextView) r6.findViewById(R.id.text_see_more_count);
        TextView r8 = (TextView) r6.findViewById(R.id.text_see_more);
        if (this.mSliceStyle == null) goto L16;
        r8.setTextSize(0, this.mSliceStyle.getGridTitleSize());
        r8.setTextColor(this.mSliceStyle.getTitleColor());
    L7:
        if (r2.getSlice().getItems().size() <= 0) goto L10;
        addCell(new GridContent.CellContent(r2), r3, r4);
    }

    private void addCell(GridContent.CellContent r24, int r25, int r26) {
        if (getMode() == 1) goto L5;
    L7:
        int r11 = 2;
    L8:
        LinearLayout r12 = new LinearLayout(getContext());
        r12.setOrientation(1);
        r12.setGravity(1);
        ArrayList<SliceItem> r13 = r24.getCellItems();
        SliceItem r14 = r24.getContentIntent();
        if (r13.size() != 1) goto L11;
        boolean r16 = true;
    L12:
        String r5 = "text";
        if (r16 == false) goto L15;
    L29:
        ArrayList r4 = null;
    L30:
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
        SliceItem r3 = null;
        boolean r17 = false;
    L32:
        if (r2 >= r13.size()) goto L56;
        r3 = r13.get(r2);
        String r15 = r3.getFormat();
        int r18 = determinePadding(r3);
        if (r1 < r11) goto L36;
    L46:
        int r19 = r0;
        int r20 = r1;
        int r21 = r2;
        SliceItem r10 = r3;
        ArrayList r22 = r4;
        String r110 = r5;
        if (r19 < 1) goto L49;
    L54:
        r3 = r10;
        r0 = r19;
        r1 = r20;
    L55:
        r2 = r21 + 1;
        r5 = r110;
        r4 = r22;
        goto L32
    L49:
        if (SlardarSettingsConsts.SETTING_IMAGE.equals(r3.getFormat()) == false) goto L54;
        if (addItem(r3, this.mTintColor, r12, 0, r16) == false) goto L54;
        r0 = r19 + 1;
        r1 = r20;
    L53:
        r17 = true;
        goto L55
    L36:
        if (r5.equals(r15) == false) goto L38;
    L39:
        if (r4 != null) goto L41;
    L43:
        r19 = r0;
        r20 = r1;
        r21 = r2;
        r10 = r3;
        r22 = r4;
        r110 = r5;
        if (addItem(r3, this.mTintColor, r12, r18, r16) == false) goto L54;
        r1 = r20 + 1;
        r0 = r19;
        goto L53
    L41:
        if (r4.contains(r3) == true) goto L43;
        r19 = r0;
        r20 = r1;
        r21 = r2;
        r10 = r3;
        r22 = r4;
        r110 = r5;
        goto L54
    L38:
        if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r15) == false) goto L46;
    L56:
        if (r17 == false) goto L79;
        CharSequence r6 = r24.getContentDescription();
        if (r6 == null) goto L60;
        r12.setContentDescription(r6);
    L60:
        this.mViewContainer.addView(r12, new LinearLayout.LayoutParams(0, -2, 1.0f));
        if (r25 == (r26 - 1)) goto L63;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r12.getLayoutParams();
        r7.setMarginEnd(this.mGutter);
        r12.setLayoutParams(r7);
    L63:
        if (r14 == null) goto L80;
        EventInfo r8 = new EventInfo(getMode(), 1, 1, this.mRowIndex);
        r8.setPosition(2, r25, r26);
        r12.setTag(new Pair(r14, r8));
        makeClickable(r12, true);
        return;
    L80:
        return;
    L79:
        return;
    L15:
        if (getMode() != 1) goto L29;
        ArrayList r9 = new ArrayList();
        Iterator<SliceItem> r23 = r13.iterator();
    L18:
        if (r23.hasNext() == false) goto L22;
        SliceItem r27 = r23.next();
        if ("text".equals(r27.getFormat()) == false) goto L18;
        r9.add(r27);
        goto L18
    L22:
        Iterator r28 = r9.iterator();
    L24:
        if (r9.size() <= r11) goto L28;
        if (((SliceItem) r28.next()).hasAnyHints(new String[]{"title", "large"}) == true) goto L24;
        r28.remove();
        goto L24
    L28:
        r4 = r9;
        goto L30
    L11:
        r16 = false;
        goto L12
    L5:
        if (this.mGridContent.hasImage() == false) goto L7;
        r11 = 1;
        goto L8
    }

    private boolean addItem(SliceItem r8, int r9, ViewGroup r10, int r11, boolean r12) {
        String r0 = r8.getFormat();
        Object r6 = null;
        r6 = null;
        r6 = null;
        if ("text".equals(r0) == false) goto L5;
    L33:
        boolean r13 = SliceQuery.hasAnyHints(r8, new String[]{"large", "title"});
        LayoutInflater r14 = LayoutInflater.from(getContext());
        if (r13 == false) goto L36;
        int r1 = TITLE_TEXT_LAYOUT;
    L37:
        TextView r7 = (TextView) r14.inflate(r1, null);
        if (this.mSliceStyle == null) goto L48;
        if (r13 == false) goto L41;
        int r15 = this.mSliceStyle.getGridTitleSize();
    L42:
        r7.setTextSize(0, r15);
        if (r13 == false) goto L45;
        int r16 = this.mSliceStyle.getTitleColor();
    L46:
        r7.setTextColor(r16);
        goto L48
    L45:
        r16 = this.mSliceStyle.getSubtitleColor();
        goto L46
    L41:
        r15 = this.mSliceStyle.getGridSubtitleSize();
    L48:
        if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r0) == false) goto L50;
        CharSequence r17 = SliceViewUtil.getTimestampString(getContext(), r8.getLong());
    L51:
        r7.setText(r17);
        r10.addView(r7);
        r7.setPadding(0, r11, 0, 0);
        r6 = r7;
    L52:
        if (r6 == null) goto L55;
        return true;
    L55:
        return false;
    L50:
        r17 = r8.getText();
        goto L51
    L36:
        r1 = TEXT_LAYOUT;
        goto L37
    L5:
        if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r0) == true) goto L33;
        if (SlardarSettingsConsts.SETTING_IMAGE.equals(r0) == false) goto L52;
        if (r8.getIcon() == null) goto L52;
        Drawable r18 = r8.getIcon().loadDrawable(getContext());
        if (r18 == null) goto L52;
        ImageView r19 = new ImageView(getContext());
        r19.setImageDrawable(r18);
        if (r8.hasHint("large") == false) goto L20;
        r19.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (r12 == false) goto L18;
        int r20 = -1;
    L19:
        ViewGroup.LayoutParams r110 = new LinearLayout.LayoutParams(-1, r20);
    L28:
        if (r9 != (-1)) goto L30;
    L32:
        r10.addView(r19, r110);
        r6 = r19;
        goto L52
    L30:
        if (r8.hasHint("no_tint") == true) goto L32;
        r19.setColorFilter(r9);
        goto L32
    L18:
        r20 = this.mLargeImageHeight;
        goto L19
    L20:
        boolean r111 = !r8.hasHint("no_tint");
        if (r111 == false) goto L23;
        int r21 = this.mIconSize;
    L24:
        if (r111 == false) goto L26;
        ImageView.ScaleType r112 = ImageView.ScaleType.CENTER_INSIDE;
    L27:
        r19.setScaleType(r112);
        r110 = new LinearLayout.LayoutParams(r21, r21);
        goto L28
    L26:
        r112 = ImageView.ScaleType.CENTER_CROP;
        goto L27
    L23:
        r21 = this.mSmallImageSize;
        goto L24
    }

    private int determinePadding(SliceItem r4) {
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (SlardarSettingsConsts.SETTING_IMAGE.equals(r4.getFormat()) == false) goto L10;
        return this.mTextPadding;
    L10:
        if ("text".equals(r4.getFormat()) == true) goto L16;
        if (WsChannelMultiProcessSharedProvider.LONG_TYPE.equals(r4.getFormat()) == true) goto L16;
        return 0;
    L16:
        if (this.mSliceStyle != null) goto L18;
        return 0;
    L18:
        return this.mSliceStyle.getVerticalGridTextPadding();
    }

    private void makeEntireGridClickable(boolean r4) {
        LinearLayout r0 = this.mViewContainer;
        Drawable r1 = null;
        if (r4 == false) goto L5;
        GridRowView r2 = this;
    L6:
        r0.setOnTouchListener(r2);
        LinearLayout r3 = this.mViewContainer;
        if (r4 == false) goto L9;
        GridRowView r5 = this;
    L10:
        r3.setOnClickListener(r5);
        View r6 = this.mForeground;
        if (r4 == false) goto L13;
        r1 = SliceViewUtil.getDrawable(getContext(), android.R.attr.selectableItemBackground);
    L13:
        r6.setBackground(r1);
        this.mViewContainer.setClickable(r4);
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private void makeClickable(View r3, boolean r4) {
        Drawable r0 = null;
        if (r4 == false) goto L5;
        View.OnClickListener r1 = this;
    L6:
        r3.setOnClickListener(r1);
        if (r4 == false) goto L9;
        r0 = SliceViewUtil.getDrawable(getContext(), android.R.attr.selectableItemBackgroundBorderless);
    L9:
        r3.setBackground(r0);
        r3.setClickable(r4);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        Pair r5 = (Pair) r4.getTag();
        SliceItem r0 = (SliceItem) r5.first;
        EventInfo r6 = (EventInfo) r5.second;
        if (r0 == null) goto L15;
        String r2 = (String) null;
        SliceItem r1 = SliceQuery.find(r0, "action", null, null);
        if (r1 == null) goto L16;
        r1.fireAction(null, null);     // Catch: PendingIntent.CanceledException -> L10
        if (this.mObserver == null) goto L17;
        this.mObserver.onSliceAction(r6, r1);     // Catch: PendingIntent.CanceledException -> L10
        return;
    L17:
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "PendingIntent for slice cannot be sent", e);
        return;
    L16:
        return;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r1, MotionEvent r2) {
        onForegroundActivated(r2);
        return false;
    }

    private void onForegroundActivated(MotionEvent r6) {
        this.mForeground.getLocationOnScreen(this.mLoc);
        this.mForeground.getBackground().setHotspot((int) (r6.getRawX() - this.mLoc[0]), (int) (r6.getRawY() - this.mLoc[1]));
        int r7 = r6.getActionMasked();
        if (r7 != 0) goto L6;
        this.mForeground.setPressed(true);
        return;
    L6:
        if (r7 == 3) goto L10;
        if (r7 == 1) goto L10;
        if (r7 == 2) goto L10;
        return;
    L10:
        this.mForeground.setPressed(false);
    }

    @Override // androidx.slice.widget.SliceChildView
    public void resetView() {
        if (this.mMaxCellUpdateScheduled == false) goto L5;
        this.mMaxCellUpdateScheduled = false;
        getViewTreeObserver().removeOnPreDrawListener(this.mMaxCellsUpdater);
    L5:
        this.mViewContainer.removeAllViews();
        setLayoutDirection(2);
        makeEntireGridClickable(false);
    }
}
