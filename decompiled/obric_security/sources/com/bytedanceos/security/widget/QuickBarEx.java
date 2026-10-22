package com.bytedanceos.security.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import bytedanceos.util.Utils;
import com.obric.olog.OLog;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.security.R;
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import obric.widget.SurnameGridView;
import obric.widget.letters.AlphabetView;
import obric.widget.letters.AlphabetsConfig;
import obric.widget.letters.LBLetter;
import obric.widget.letters.LettersBar;
import obric.widget.letters.LettersConfig;
import obric.widget.letters.SurnameFlowLayout;

/* JADX INFO: loaded from: classes2.dex */
public class QuickBarEx extends LinearLayout {
    private static final int DEFAULTX = -99999;
    public static final int LETTER_CHANGED_CLICK = 1;
    public static final int LETTER_CHANGED_SLIDE = 0;
    public static final int POUND_POSITION_BOTTOM = 2;
    public static final int POUND_POSITION_TOP = 1;
    public static final boolean QuickBarEx_DEBUG = false;
    public static final String QuickBarEx_TAG = "QuickBarEx";
    private static final int STATE_END = 3;
    private static final int STATE_MOVE = 2;
    private static final int STATE_START = 1;
    private static final int SURNAME_NUM_COLUMNS_THRESHOLD = 8;
    private static final int SURNAME_NUM_ROWS_THRESHOLD = 8;
    public static final int VISIBILITY_LIMIT = 30;
    private AlphabetsAdapter mAlphabetsAdapter;
    private int mColumnCount;
    private Context mContext;
    private float mCurrentRawX;
    private int mEndX;
    private GridView mGridView;
    private boolean mHasPerformedLongPress;
    private int mHostX;
    private Bitmap[][] mIconsForSymbols;
    private boolean mIsPerformingHideAnim;
    private boolean mIsPerformingShowAnim;
    private float mLastRawX;
    private int mLetterBarWidth;
    private int mLetterbarShadowWidth;
    private List<LBLetter> mLetters;
    private LettersBar mLettersBar;
    private boolean mLongPressEnabled;
    private int mMeasuredHeight;
    private int mMinXDistance;
    private float mMissX;
    private SurnameFlowLayout mPopupFlowLayout;
    private SurnameGridView mPopupGridView;
    private int mPopupViewMaxHeight;
    private int mPopupViewPendingHorizontal;
    private int mPopupViewPendingVertical;
    private PopupWindow mPopupWindow;
    private int mPopupYOffset;
    private int mPoundPosition;
    private boolean mPoundVisibility;
    private int mPrePosition;
    private QBListener mQBListener;
    private PopupWindow mSecondPopup;
    private TextView mSecondPopupView;
    private View mSecondPopupViewArrow;
    private ViewGroup mSecondPopupViewParent;
    private View mShadowView;
    private int mStartX;
    private int mState;
    private int mSurnameGridViewColumnsThreshold;
    private int mSurnameGridViewItemHeight;
    private int mSurnameGridViewItemWidth;
    private int mSurnameGridViewNumColumns;
    private int mSurnameGridViewNumRows;
    private SurnameListener mSurnameListener;
    private int[] mSymbols;
    private int mWidth;

    class AlphabetsAdapter extends BaseAdapter {
        private String[] mAlphabets;
        private Context mContext;
        private String mCurrentLanguage;
        private float mNumRows;
        private int mTotalVerticalSpacing;
        final /* synthetic */ QuickBarEx this$0;

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int position) {
            return getItem(position);
        }

        public AlphabetsAdapter(final QuickBarEx this$0, Context context) {
            this.this$0 = this$0;
            this.mContext = context;
            String r4 = Locale.getDefault().getLanguage();
            this.mCurrentLanguage = r4;
            float r5 = AlphabetsConfig.numRowsByLanguage(r4);
            this.mNumRows = r5;
            this.mTotalVerticalSpacing = (((int) Math.ceil(r5)) - 1) * QuickBarEx.access$2300(this$0).getVerticalSpacing();
        }

        public void setAlphabets(String[] alphabets) {
            this.mAlphabets = alphabets;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int position) {
            if (AlphabetsConfig.isPlaceholder(this.mAlphabets[position]) == false) goto L5;
        L7:
            return false;
        L5:
            if (AlphabetsConfig.isDisabled(this.mAlphabets[position]) == true) goto L7;
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            String[] r0 = this.mAlphabets;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.length;
        }

        @Override // android.widget.Adapter
        public String getItem(int position) {
            return this.mAlphabets[position];
        }

        private boolean isNeedIncreaseHeight() {
            if (((int) ((QuickBarEx.access$2400(this.this$0) - this.mTotalVerticalSpacing) % this.mNumRows)) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        private int getSingleCellHeight() {
            return (int) ((QuickBarEx.access$2400(this.this$0) - this.mTotalVerticalSpacing) / this.mNumRows);
        }

        private boolean isNeedInsreaseHeightPosition(int position) {
            if (position != (getCount() - 1)) goto L5;
            return true;
        L5:
            if (position != (getCount() - 2)) goto L7;
            return true;
        L7:
            if (position == (getCount() - 3)) goto L13;
            return false;
        L13:
            return true;
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            String r7 = this.mAlphabets[r4];
            int r8 = getSingleCellHeight();
            float r0 = QuickBarEx.access$2400(this.this$0) - this.mTotalVerticalSpacing;
            float r2 = this.mNumRows;
            int r1 = (int) (r0 - (r8 * r2));
            if (r2 != 9.0f) goto L10;
            if (isNeedIncreaseHeight() == false) goto L10;
            if (isNeedInsreaseHeightPosition(r4) == false) goto L10;
            r8 = r8 + r1;
        L10:
            if (AlphabetsConfig.isSymbol(r7) == false) goto L12;
            ImageView r9 = new ImageView(this.mContext);
            r9.setImageResource(R.drawable.letter_bar_unfold_button);
            r9.setScaleType(ImageView.ScaleType.CENTER);
            r9.setMinimumHeight(r8);
            Object r10 = r9;
        L22:
            View r11 = (View) r10;
            int r12 = (r4 / 3) % 2;
            Resources r3 = this.mContext.getResources();
            if (r12 != 0) goto L25;
            int r13 = R.drawable.quickbar_ex_alphabet_text_light_colorlist;
        L26:
            r11.setBackground(r3.getDrawable(r13));
            return r11;
        L25:
            r13 = R.drawable.quickbar_ex_alphabet_text_dark_colorlist;
            goto L26
        L12:
            AlphabetView r14 = new AlphabetView(this.mContext);
            r14.setHeight(r8);
            if (AlphabetsConfig.isDisabled(r7) == false) goto L16;
            r14.setTextColor(Color.parseColor("#80000000"));
            r7 = r7.substring(1);
        L16:
            if (AlphabetsConfig.isPlaceholder(r7) == true) goto L19;
            r14.setText(r7);
        L19:
            if (AlphabetsConfig.isRussianAlphabet(r7) == false) goto L21;
            Typeface r15 = (Typeface) null;
            r14.setTypeface(null, 0);
        L21:
            r10 = r14;
            goto L22
        }
    }

    public interface QBListener {
        boolean onLetterChanged(String var1, int var2);

        void onLetterGridHidden();

        void onLetterGridShow();
    }

    private final class SurnameAdapter extends BaseAdapter {
        private Context context;
        private List<String> surnames;
        final /* synthetic */ QuickBarEx this$0;

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return 0;
        }

        public SurnameAdapter(final QuickBarEx this$0, Context context, List<String> surnames) {
            this.this$0 = this$0;
            this.context = context;
            this.surnames = surnames;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> r0 = this.surnames;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            List<String> r0 = this.surnames;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.get(position);
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L4;
            ViewGroup r0 = (ViewGroup) null;
            convertView = LayoutInflater.from(this.context).inflate(R.layout.surname_popup_item_ex, null);
            convertView.setLayoutParams(new AbsListView.LayoutParams(QuickBarEx.access$2000(this.this$0), QuickBarEx.access$2100(this.this$0)));
        L4:
            int r5 = position % QuickBarEx.access$2200(this.this$0);
            if (r5 == 0) goto L7;
        L9:
            if (r5 != 0) goto L12;
            convertView.setBackgroundResource(R.drawable.surname_popup_item_right);
        L17:
            ((TextView) convertView).setText(String.valueOf(this.surnames.get(position)));
            return convertView;
        L12:
            if (r5 != (QuickBarEx.access$2200(this.this$0) - 1)) goto L14;
        L16:
            convertView.setBackgroundResource(R.drawable.surname_popup_item_left);
            goto L17
        L14:
            if (position == (getCount() - 1)) goto L16;
            convertView.setBackgroundResource(R.drawable.surname_popup_item_middle);
            goto L17
        L7:
            if (position != (getCount() - 1)) goto L9;
            convertView.setBackgroundResource(R.drawable.surname_popup_item_special);
            goto L17
        }
    }

    public interface SurnameListener {
        List<String> getMatchedSurnames(String var1);

        void onSurnameClicked(String var1);
    }

    static /* synthetic */ QBListener access$000(QuickBarEx r0) {
        return r0.mQBListener;
    }

    static /* synthetic */ void access$100(QuickBarEx r0, boolean r1) {
        r0.setShadowVisible(r1);
    }

    static /* synthetic */ boolean access$1002(QuickBarEx r0, boolean r1) {
        r0.mIsPerformingShowAnim = r1;
        return r1;
    }

    static /* synthetic */ void access$1100(QuickBarEx r0, boolean r1) {
        r0.setLettersBarBg(r1);
    }

    static /* synthetic */ void access$1200(QuickBarEx r0) {
        r0.onShowLetterGridAnimationEnd();
    }

    static /* synthetic */ boolean access$1302(QuickBarEx r0, boolean r1) {
        r0.mIsPerformingHideAnim = r1;
        return r1;
    }

    static /* synthetic */ void access$1400(QuickBarEx r0) {
        r0.onHideLetterGridAnimationEnd();
    }

    static /* synthetic */ SurnameListener access$1500(QuickBarEx r0) {
        return r0.mSurnameListener;
    }

    static /* synthetic */ void access$1600(QuickBarEx r0, View r1) {
        r0.showSecondPopupWindow(r1);
    }

    static /* synthetic */ PopupWindow access$1700(QuickBarEx r0) {
        return r0.mSecondPopup;
    }

    static /* synthetic */ TextView access$1800(QuickBarEx r0) {
        return r0.mSecondPopupView;
    }

    static /* synthetic */ SurnameGridView access$1900(QuickBarEx r0) {
        return r0.mPopupGridView;
    }

    static /* synthetic */ AlphabetsAdapter access$200(QuickBarEx r0) {
        return r0.mAlphabetsAdapter;
    }

    static /* synthetic */ int access$2000(QuickBarEx r0) {
        return r0.mSurnameGridViewItemWidth;
    }

    static /* synthetic */ int access$2100(QuickBarEx r0) {
        return r0.mSurnameGridViewItemHeight;
    }

    static /* synthetic */ int access$2200(QuickBarEx r0) {
        return r0.mSurnameGridViewColumnsThreshold;
    }

    static /* synthetic */ GridView access$2300(QuickBarEx r0) {
        return r0.mGridView;
    }

    static /* synthetic */ int access$2400(QuickBarEx r0) {
        return r0.mMeasuredHeight;
    }

    static /* synthetic */ void access$300(QuickBarEx r0) {
        r0.hideLetterGridWithAnim();
    }

    static /* synthetic */ int access$400(QuickBarEx r0) {
        return r0.mState;
    }

    static /* synthetic */ PopupWindow access$500(QuickBarEx r0) {
        return r0.mPopupWindow;
    }

    static /* synthetic */ boolean access$600(QuickBarEx r0) {
        return r0.mLongPressEnabled;
    }

    static /* synthetic */ void access$700(QuickBarEx r0, View r1, int r2) {
        r0.showFlowPopupWindow(r1, r2);
    }

    static /* synthetic */ void access$800(QuickBarEx r0, View r1, int r2) {
        r0.showGridPopupWindow(r1, r2);
    }

    static /* synthetic */ boolean access$902(QuickBarEx r0, boolean r1) {
        r0.mHasPerformedLongPress = r1;
        return r1;
    }

    static {
        QuickBarEx_DEBUG = Log.isLoggable("QuickBarEx", 3);
    }

    public QuickBarEx(Context context) {
        AttributeSet r1 = (AttributeSet) null;
        this(context, null);
    }

    public QuickBarEx(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public QuickBarEx(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mMeasuredHeight = 0;
        this.mState = 1;
        this.mMissX = 0.0f;
        this.mLastRawX = 0.0f;
        this.mCurrentRawX = 0.0f;
        this.mIsPerformingHideAnim = false;
        this.mIsPerformingShowAnim = false;
        this.mLetters = new ArrayList();
        this.mPoundVisibility = true;
        this.mPoundPosition = 2;
        this.mColumnCount = 3;
        this.mHostX = -99999;
        this.mPrePosition = -1;
        this.mLongPressEnabled = true;
        init(context);
    }

    public void setQBListener(QBListener listener) {
        this.mQBListener = listener;
    }

    public void setSurnameListener(SurnameListener listener) {
        this.mSurnameListener = listener;
    }

    public void initSpecialIcons(int[] symbols, Bitmap[][] bitmaps) {
        if (symbols == null) goto L17;
        if (bitmaps != null) goto L5;
        return;
    L5:
        if (symbols.length != 0) goto L7;
        return;
    L7:
        if (bitmaps.length != 0) goto L9;
        return;
    L9:
        if (symbols.length != bitmaps.length) goto L16;
        if (bitmaps[0].length != 3) goto L14;
        this.mSymbols = symbols;
        this.mIconsForSymbols = bitmaps;
        initLetters();
        return;
    L14:
        throw new IllegalArgumentException("Paramer bitmaps[x][y], y must is 3 !!!");
    L16:
        throw new IllegalArgumentException("The symbols.length must equals bitmaps.length !");
    }

    public void initLetters() {
        this.mLetters.clear();
        int r1 = 0;
        if (this.mSymbols == null) goto L9;
        int r0 = 0;
    L5:
        int[] r2 = this.mSymbols;
        if (r0 >= r2.length) goto L8;
        this.mLetters.add(LBLetter.fromSymbol(String.valueOf(r2[r0]), this.mIconsForSymbols[r0]));
        r0 = r0 + 1;
        goto L5
    L8:
        int r3 = r2.length;
    L10:
        String[] r4 = LettersConfig.lettersByLanguage(Locale.getDefault().getLanguage());
    L12:
        if (r1 >= (r4.length - 1)) goto L19;
        if (LettersConfig.isLocaleLetter(Locale.getDefault().getLanguage(), r1) == false) goto L16;
        this.mLetters.add(LBLetter.fromLocaleLetter(r4[r1]));
    L17:
        r1 = r1 + 1;
        goto L12
    L16:
        this.mLetters.add(LBLetter.fromLetter(r4[r1]));
        goto L17
    L19:
        if (this.mPoundVisibility == true) goto L21;
    L24:
        invalidate();
        return;
    L21:
        if (this.mPoundPosition != 1) goto L23;
        this.mLetters.add(r3, LBLetter.POUND);
        goto L24
    L23:
        this.mLetters.add(LBLetter.POUND);
        goto L24
    L9:
        r3 = 0;
        goto L10
    }

    public void setPoundVisibility(boolean visible) {
        this.mPoundVisibility = visible;
    }

    public void setPoundPosition(int position) {
        this.mPoundPosition = position;
    }

    public boolean isLetterGridShow() {
        if (this.mIsPerformingShowAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mState == 3) goto L8;
        return false;
    }

    public boolean isLetterGridShown() {
        if (this.mState != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLetterGridHide() {
        if (this.mIsPerformingHideAnim == false) goto L5;
        return true;
    L5:
        if (this.mState == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isLetterGridHidden() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isPerformingAnim() {
        if (this.mIsPerformingShowAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mIsPerformingHideAnim == true) goto L8;
        return false;
    }

    public void hideLetterGrid() {
        hideLetterGrid(true);
    }

    public void hideLetterGrid(boolean withAnim) {
        dismissPopupWindow();
        if (isLetterGridHide() == true) goto L8;
        if (withAnim == false) goto L6;
        hideLetterGridWithAnim();
        return;
    L6:
        onHideLetterGridAnimationEnd();
        return;
    }

    public void setLongPressEnabled(boolean enabled) {
        this.mLongPressEnabled = enabled;
    }

    private void init(Context context) {
        this.mContext = context;
        Resources r4 = context.getResources();
        LayoutInflater.from(this.mContext).inflate(R.layout.quickbar_ex, this, true);
        this.mLetterBarWidth = Utils.getDrawableWidth(this.mContext.getResources().getDrawable(R.drawable.letters_bar_background));
        int r0 = r4.getDimensionPixelOffset(R.dimen.obric_quickbar_grid_item_space);
        int r1 = r4.getDimensionPixelOffset(R.dimen.quickbar_ex_grid_column_width);
        this.mMinXDistance = r4.getDimensionPixelOffset(R.dimen.obric_quickbar_min_distance);
        this.mLetterbarShadowWidth = Utils.getDrawableWidth(this.mContext.getResources().getDrawable(R.drawable.letters_bar_background_shadow));
        this.mWidth = (((r0 * 2) + this.mLetterBarWidth) + (r1 * this.mContext.getResources().getInteger(R.integer.obric_letterbar_gridview_column_num))) + this.mLetterbarShadowWidth;
        initLettersBar();
        initGridView();
        this.mShadowView = findViewById(R.id.iv_letter_bar_shadow);
        setLettersBarBg(false);
    }

    private void initLettersBar() {
        LettersBar r0 = (LettersBar) findViewById(R.id.quickbar_left_letters_bar);
        this.mLettersBar = r0;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.width = this.mLetterBarWidth;
        this.mLettersBar.setLetters(this.mLetters);
        this.mLettersBar.setListener(new AnonymousClass1(this));
        this.mLettersBar.setOnBackgroundVisibleChangedListener(new AnonymousClass2(this));
        initLetters();
    }

    private void initGridView() {
        this.mGridView = (GridView) findViewById(R.id.quickbar_right_grid_view);
        AlphabetsAdapter r0 = new AlphabetsAdapter(this, this.mContext);
        this.mAlphabetsAdapter = r0;
        r0.setAlphabets(AlphabetsConfig.alphabetsByLanguage(Locale.getDefault().getLanguage()));
        GridView r1 = this.mGridView;
        if (r1 != null) goto L5;
        return;
    L5:
        r1.setAdapter(this.mAlphabetsAdapter);
        this.mGridView.setOnItemClickListener(new AnonymousClass3(this));
        this.mGridView.setOnTouchListener(new AnonymousClass4(this));
        this.mGridView.setOnItemLongClickListener(new AnonymousClass5(this));
    }

    private void setHostWidth(int hostWidth) {
        int r0 = (hostWidth - this.mLetterBarWidth) - this.mLetterbarShadowWidth;
        this.mStartX = r0;
        int r4 = hostWidth - this.mWidth;
        this.mEndX = r4;
        int r1 = this.mState;
        if (r1 != 1) goto L6;
        float r5 = r0;
    L9:
        setX(r5);
        if (QuickBarEx_DEBUG == false) goto L12;
        OLog.d("QuickBarEx", "mStartX = " + this.mStartX);
    L12:
        invalidate();
        return;
    L6:
        if (r1 != 3) goto L8;
        r5 = r4;
        goto L9
    L8:
        r5 = getX();
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mMeasuredHeight = measureHeight(heightMeasureSpec);
        int r2 = View.MeasureSpec.getSize(widthMeasureSpec);
        Object r3 = getParent();
        if (r3 == null) goto L7;
        int r4 = ((View) r3).getMeasuredWidth();
        if (r4 <= 0) goto L9;
        setHostWidth(r4);
    L9:
        if (QuickBarEx_DEBUG == false) goto L12;
        OLog.d("QuickBarEx", "measure width:" + r2 + "  parentWidth:" + r4);
        return;
    L12:
        return;
    L7:
        r4 = 0;
        goto L9
    }

    private int measureHeight(int measureSpec) {
        return View.MeasureSpec.getSize(measureSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (AlphabetsConfig.isAlphabetsSupportedByLanguage(Locale.getDefault().getLanguage()) == false) goto L5;
        getParentxPos();
        int r0 = event.getAction();
        event.getX();
        event.getY();
        float r1 = event.getRawX() - this.mHostX;
        if (r0 != 0) goto L9;
        this.mHasPerformedLongPress = false;
        this.mCurrentRawX = r1;
        this.mLastRawX = r1;
        int r2 = this.mState;
        if (r2 != 1) goto L70;
        this.mMissX = 0.0f;
    L70:
        if (r2 != 3) goto L72;
        this.mMissX = r1 - this.mEndX;
    L72:
        if (r2 != 3) goto L78;
        PopupWindow r3 = this.mPopupWindow;
        if (r3 == null) goto L78;
        if (r3.isShowing() == false) goto L78;
        this.mPopupWindow.dismiss();
    L78:
        boolean r4 = false;
    L79:
        if (r4 == true) goto L83;
        if (super.dispatchTouchEvent(event) == true) goto L83;
        return false;
    L83:
        return true;
    L9:
        if (r0 == 1) goto L37;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L37;
    L14:
        if (this.mHasPerformedLongPress == false) goto L16;
        onMoveInLongPressState(event);
        goto L78
    L16:
        float r5 = this.mCurrentRawX;
        this.mLastRawX = r5;
        this.mCurrentRawX = r1;
        int r6 = this.mState;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L30;
        moveQuickBar(r1, this.mMissX);
        if (this.mState != 1) goto L29;
        QBListener r7 = this.mQBListener;
        if (r7 == null) goto L29;
        r7.onLetterGridHidden();
    L29:
        r4 = true;
        goto L79
    L30:
        if (r6 != 3) goto L78;
        if ((r1 - r5) <= this.mMinXDistance) goto L78;
        if (r5 <= this.mEndX) goto L78;
        setState(2);
        moveQuickBar(r1, this.mMissX);
        goto L29
    L19:
        if (r1 >= this.mStartX) goto L78;
        setState(2);
        moveQuickBar(r1, this.mMissX);
        QBListener r8 = this.mQBListener;
        if (r8 == null) goto L29;
        r8.onLetterGridShow();
    L37:
        if (this.mHasPerformedLongPress == true) goto L39;
        this.mMissX = 0.0f;
        if (getX() != this.mStartX) goto L60;
        setLettersBarBg(false);
        goto L78
    L60:
        if (this.mState != 2) goto L78;
        if ((this.mCurrentRawX - this.mLastRawX) <= 0.0f) goto L64;
    L66:
        hideLetterGridWithAnim();
        goto L29
    L64:
        if (getX() >= (getScreenWidth() + NetError.ERR_SSL_PINNED_KEY_NOT_IN_CERT_CHAIN)) goto L66;
        showLetterGridWithAnim();
        goto L29
    L39:
        if (AlphabetsConfig.surnameTypeSupportedByLanguage(Locale.getDefault().getLanguage()) != 1) goto L48;
        int r9 = this.mPrePosition;
        if (r9 < 0) goto L47;
        SurnameFlowLayout r10 = this.mPopupFlowLayout;
        if (r10 == null) goto L47;
        View r11 = r10.getChildAt(r9);
        if (r11 == null) goto L47;
        r11.setPressed(false);
        r11.performClick();
    L47:
        this.mPrePosition = -1;
        goto L78
    L48:
        int r12 = this.mPrePosition;
        if (r12 < 0) goto L55;
        SurnameGridView r13 = this.mPopupGridView;
        if (r13 == null) goto L55;
        View r14 = r13.getChildAt(r12);
        if (r14 == null) goto L55;
        r14.setPressed(false);
        this.mPopupGridView.performItemClick(r14, this.mPrePosition, -1);
    L55:
        this.mPrePosition = -1;
        goto L78
    L5:
        return super.dispatchTouchEvent(event);
    }

    private void onMoveInLongPressState(MotionEvent event) {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L56;
        int r1 = (int) event.getRawX();
        int r10 = (int) event.getRawY();
        if (AlphabetsConfig.surnameTypeSupportedByLanguage(Locale.getDefault().getLanguage()) != 1) goto L34;
        SurnameFlowLayout r2 = this.mPopupFlowLayout;
        if (r2 == null) goto L57;
        int[] r3 = new int[2];
        r2.getLocationOnScreen(r3);
        int r4 = 0;
    L12:
        if (r4 >= this.mPopupFlowLayout.getChildCount()) goto L20;
        View r6 = this.mPopupFlowLayout.getChildAt(r4);
        if (r6 == null) goto L19;
        Rect r7 = new Rect();
        r6.getHitRect(r7);
        if (r7.contains(r1 - r3[0], r10 - r3[1]) == false) goto L19;
    L21:
        if (r4 < 0) goto L30;
        int r11 = this.mPrePosition;
        if (r11 == r4) goto L33;
        View r12 = this.mPopupFlowLayout.getChildAt(r11);
        if (r12 == null) goto L27;
        r12.setPressed(false);
        View r13 = (View) null;
        showSecondPopupWindow(null);
    L27:
        View r14 = this.mPopupFlowLayout.getChildAt(r4);
        if (r14 == null) goto L33;
        r14.setPressed(true);
        r14.setTag((String) ((TextView) r14).getText());
        showSecondPopupWindow(r14);
    L33:
        this.mPrePosition = r4;
        return;
    L30:
        View r15 = this.mPopupFlowLayout.getChildAt(this.mPrePosition);
        if (r15 == null) goto L33;
        r15.setPressed(false);
        View r16 = (View) null;
        showSecondPopupWindow(null);
    L19:
        r4 = r4 + 1;
        goto L12
    L20:
        r4 = -1;
        goto L21
    L57:
        return;
    L34:
        SurnameGridView r5 = this.mPopupGridView;
        if (r5 == null) goto L59;
        int[] r8 = new int[2];
        r5.getLocationOnScreen(r8);
        int r17 = this.mPopupGridView.pointToPosition(r1 - r8[0], r10 - r8[1]);
        if (r17 < 0) goto L46;
        int r9 = this.mPrePosition;
        if (r9 == r17) goto L49;
        View r18 = this.mPopupGridView.getChildAt(r9);
        if (r18 == null) goto L43;
        r18.setPressed(false);
        View r19 = (View) null;
        showSecondPopupWindow(null);
    L43:
        View r20 = this.mPopupGridView.getChildAt(r17);
        if (r20 == null) goto L49;
        r20.setPressed(true);
        r20.setTag((String) this.mPopupGridView.getAdapter().getItem(r17));
        showSecondPopupWindow(r20);
    L49:
        this.mPrePosition = r17;
        return;
    L46:
        View r21 = this.mPopupGridView.getChildAt(this.mPrePosition);
        if (r21 == null) goto L49;
        r21.setPressed(false);
        View r22 = (View) null;
        showSecondPopupWindow(null);
        goto L49
    L59:
        return;
    }

    private void setState(int state) {
        this.mState = state;
        LettersBar r1 = this.mLettersBar;
        boolean r0 = true;
        if (state == 1) goto L6;
        r0 = false;
    L6:
        r1.setSettled(r0);
    }

    private void moveQuickBar(float x, float missX) {
        float r2 = x - missX;
        int r3 = this.mStartX;
        if (r2 < r3) goto L5;
        setX(r3);
        setState(1);
        return;
    L5:
        int r4 = this.mEndX;
        if (r2 > r4) goto L9;
        setX(r4);
        setState(3);
        return;
    L9:
        if (r2 <= r4) goto L14;
        setX(r2);
        setState(2);
        return;
    }

    private void showLetterGridWithAnim() {
        QBListener r0 = this.mQBListener;
        if (r0 == null) goto L5;
        r0.onLetterGridShow();
    L5:
        AnimatorSet r1 = new AnimatorSet();
        r1.play(ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(MaterialConfigFormatNames.X, new float[]{getX(), this.mEndX})}));
        r1.setDuration(200);
        r1.addListener(new AnonymousClass6(this));
        r1.start();
    }

    private void onShowLetterGridAnimationEnd() {
        setX(this.mEndX);
        setState(3);
        setLettersBarBg(true);
    }

    private void hideLetterGridWithAnim() {
        dismissPopupWindow();
        AnimatorSet r0 = new AnimatorSet();
        r0.play(ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(MaterialConfigFormatNames.X, new float[]{getX(), this.mStartX})}));
        r0.setDuration(200);
        r0.addListener(new AnonymousClass7(this));
        r0.start();
    }

    private void onHideLetterGridAnimationEnd() {
        setState(1);
        setX(this.mStartX);
        setLettersBarBg(false);
    }

    private void setLettersBarBg(boolean showBg) {
        this.mLettersBar.setShowBg(showBg);
        setShadowVisible(showBg);
    }

    private void setShadowVisible(boolean visible) {
        View r0 = this.mShadowView;
        if (visible == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 4;
        goto L6
    }

    private int getScreenWidth() {
        Point r0 = new Point();
        WindowManager r2 = (WindowManager) this.mContext.getSystemService("window");
        if (r2 == null) goto L8;
        if (r2.getDefaultDisplay() == null) goto L8;
        r2.getDefaultDisplay().getSize(r0);
    L8:
        return r0.x;
    }

    private int dipToPx(double dipValue) {
        return (int) ((dipValue * ((double) this.mContext.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void showFlowPopupWindow(View alphabetView, int position) {
        if (this.mSurnameListener == null) goto L95;
        if (AlphabetsConfig.isSurnameSupportedByLanguage(Locale.getDefault().getLanguage(), this.mAlphabetsAdapter.getItem(position)) == false) goto L99;
        List<String> r2 = this.mSurnameListener.getMatchedSurnames(this.mAlphabetsAdapter.getItem(position));
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.size() == 0) goto L101;
        ViewGroup r5 = (ViewGroup) null;
        View r3 = LayoutInflater.from(this.mContext).inflate(R.layout.surname_flow_popup, null);
        SurnameFlowLayout r6 = (SurnameFlowLayout) r3.findViewById(R.id.surname_content);
        this.mPopupFlowLayout = r6;
        if (r6 != null) goto L13;
        return;
    L13:
        this.mPopupYOffset = dipToPx(7.0d);
        this.mPopupViewMaxHeight = dipToPx(283.0d);
        this.mSurnameGridViewItemWidth = dipToPx(40.0d);
        this.mSurnameGridViewItemHeight = dipToPx(33.0d);
        this.mSurnameGridViewColumnsThreshold = 8;
        int r7 = dipToPx(98.0d);
        Drawable r8 = getResources().getDrawable(R.drawable.surname_popup_item_left);
        int r9 = this.mSurnameGridViewColumnsThreshold * this.mSurnameGridViewItemWidth;
        Iterator<String> r10 = r2.iterator();
        int r12 = 1;
        int r13 = 0;
        int r14 = 0;
    L14:
        int r16 = r9;
        int r17 = r12;
        if (r10.hasNext() == false) goto L38;
        String r15 = r10.next();
        final TextView r11 = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.surname_popup_item_ex, null);
        r11.setText(r15);
        ViewGroup.MarginLayoutParams r18 = new ViewGroup.MarginLayoutParams(-2, -2);
        r18.height = this.mSurnameGridViewItemHeight;
        r11.setLayoutParams(r18);
        r11.setPadding(dipToPx(10.0d), 0, dipToPx(10.0d), 0);
        if (r2.size() != 1) goto L19;
        r11.setBackgroundResource(R.drawable.surname_popup_item_special);
    L20:
        int r19 = (int) Math.ceil(r11.getPaint().measureText(r15));
        if (r8 == null) goto L27;
        int r20 = r8.getIntrinsicWidth();
        if (r20 <= 0) goto L27;
        int r110 = r13;
        double r111 = 20.0d;
        if (r20 <= (dipToPx(20.0d) + r19)) goto L28;
        r19 = r20 - dipToPx(20.0d);
    L28:
        if (r19 <= r7) goto L30;
        r19 = r7;
    L30:
        int r21 = r19 + dipToPx(r111);
        if ((r14 + r21) <= r16) goto L33;
        r17 = r17 + 1;
        r14 = 0;
    L33:
        r14 = r14 + r21;
        r13 = r110;
        if (r13 > r14) goto L37;
        r13 = r14;
    L37:
        r11.setOnClickListener(new AnonymousClass8(this));
        r11.setOnTouchListener(new AnonymousClass9(this, r11));
        this.mPopupFlowLayout.addView(r11);
        r9 = r16;
        r12 = r17;
    L27:
        r110 = r13;
        r111 = 20.0d;
        goto L28
    L19:
        r11.setBackgroundResource(R.drawable.surname_popup_item_left);
        goto L20
    L38:
        this.mSurnameGridViewNumRows = r17;
        this.mPopupFlowLayout.measure(0, 0);
        boolean r4 = QuickBarEx_DEBUG;
        if (r4 == false) goto L41;
        OLog.d("QuickBarEx", "surname FlowLayout, width = " + r13);
        OLog.d("QuickBarEx", "surname FlowLayout, measuredHeight = " + this.mPopupFlowLayout.getMeasuredHeight());
    L41:
        FrameLayout.LayoutParams r22 = (FrameLayout.LayoutParams) this.mPopupFlowLayout.getLayoutParams();
        r22.width = r13;
        this.mPopupFlowLayout.setLayoutParams(r22);
        if (this.mPopupWindow != null) goto L44;
        PopupWindow r23 = new PopupWindow();
        this.mPopupWindow = r23;
        r23.setWindowLayoutMode(-2, -2);
        this.mPopupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        this.mPopupWindow.setClippingEnabled(true);
    L44:
        this.mPopupWindow.setContentView(r3);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r24 = new int[2];
        alphabetView.getLocationOnScreen(r24);
        int r112 = r24[0] + (alphabetView.getWidth() / 2);
        int r113 = r24[1] + (alphabetView.getHeight() / 2);
        if (r4 == false) goto L47;
        int r114 = 0;
        OLog.d("QuickBarEx", "alphabet anchorX = " + r24[0] + ", anchorY = " + r24[1]);
    L48:
        r3.measure(r114, r114);
        int r25 = r3.getMeasuredWidth();
        int r26 = r3.getMeasuredHeight();
        if (r4 == false) goto L51;
        OLog.d("QuickBarEx", "popMeasureWidth = " + r25 + ", popMeasureHeight = " + r26);
    L51:
        int r115 = this.mColumnCount;
        if (position >= r115) goto L57;
        if (this.mSurnameGridViewNumRows <= 1) goto L57;
    L74:
        boolean r116 = true;
    L76:
        if (r116 == false) goto L78;
        ImageView r1 = (ImageView) r3.findViewById(R.id.surname_popup_top_arrow);
        int r117 = r113 + this.mPopupYOffset;
    L79:
        r1.setVisibility(0);
        r1.measure(0, 0);
        int r27 = r1.getMeasuredWidth();
        if (r4 == false) goto L82;
        OLog.d("QuickBarEx", "arrowWidth = " + r27);
    L82:
        int r118 = r25 / 2;
        int r28 = Math.min(getScreenWidth() - r112, r118);
        int r119 = r112 - r118;
        int r29 = (r25 - r28) - (r27 / 2);
        ImageView r30 = (ImageView) r3.findViewById(R.id.surname_top_mask);
        FrameLayout.LayoutParams r31 = (FrameLayout.LayoutParams) r30.getLayoutParams();
        r31.width = r13;
        ImageView r32 = (ImageView) r3.findViewById(R.id.surname_bottom_mask);
        FrameLayout.LayoutParams r120 = (FrameLayout.LayoutParams) r32.getLayoutParams();
        r120.width = r13;
        LinearLayout r33 = (LinearLayout) r3.findViewById(R.id.surname_container);
        FrameLayout.LayoutParams r121 = (FrameLayout.LayoutParams) r33.getLayoutParams();
        int r122 = this.mPopupFlowLayout.getMeasuredHeight();
        int r34 = this.mPopupViewMaxHeight;
        if (r122 <= r34) goto L85;
        r121.height = r34;
    L85:
        r33.setLayoutParams(r121);
        if (r13 != (this.mSurnameGridViewColumnsThreshold * this.mSurnameGridViewItemWidth)) goto L88;
        r33.setPadding(dipToPx(14.0d), dipToPx(1.5d), dipToPx(17.0d), dipToPx(4.0d));
        r29 = r29 + getResources().getDimensionPixelSize(R.dimen.surname_arrow_offset_x);
        r31.leftMargin = dipToPx(20.0d);
        r120.leftMargin = dipToPx(20.0d);
        r31.width -= dipToPx(10.0d);
        r120.width -= dipToPx(10.0d);
    L89:
        r30.setLayoutParams(r31);
        r32.setLayoutParams(r120);
        r1.setTranslationX(r29);
        if (Math.abs(getX() - this.mEndX) <= dipToPx(1.0d)) goto L92;
        OLog.d("QuickBarEx", "GridView is hiding now...");
        return;
    L92:
        this.mPopupWindow.showAtLocation(this, 0, r119, r117);
        return;
    L88:
        r119 = r119 - 1;
        goto L89
    L78:
        r1 = (ImageView) r3.findViewById(R.id.surname_popup_bottom_arrow);
        r117 = (r113 - r26) - this.mPopupYOffset;
    L57:
        if (position < r115) goto L63;
        if (position >= (r115 * 2)) goto L63;
        if (this.mSurnameGridViewNumRows > 3) goto L74;
    L63:
        if (position < (r115 * 2)) goto L69;
        if (position >= (r115 * 3)) goto L69;
        if (this.mSurnameGridViewNumRows > 5) goto L74;
    L69:
        if (position >= (r115 * 3)) goto L71;
    L75:
        r116 = false;
        goto L76
    L71:
        if (position >= (r115 * 4)) goto L75;
        if (this.mSurnameGridViewNumRows <= 7) goto L75;
    L47:
        r114 = 0;
        goto L48
    L101:
        return;
    L99:
        return;
    L95:
        throw new IllegalArgumentException("You must implements SurnameListener");
    }

    private void showGridPopupWindow(View alphabetView, int position) {
        if (this.mSurnameListener == null) goto L85;
        if (AlphabetsConfig.isSurnameSupportedByLanguage(Locale.getDefault().getLanguage(), this.mAlphabetsAdapter.getItem(position)) == false) goto L86;
        List<String> r2 = this.mSurnameListener.getMatchedSurnames(this.mAlphabetsAdapter.getItem(position));
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.size() == 0) goto L88;
        SurnameAdapter r3 = new SurnameAdapter(this, this.mContext, r2);
        ViewGroup r6 = (ViewGroup) null;
        View r4 = LayoutInflater.from(this.mContext).inflate(R.layout.surname_popup, null);
        this.mPopupGridView = (SurnameGridView) r4.findViewById(R.id.surname_content);
        this.mPopupYOffset = dipToPx(7.0d);
        this.mSurnameGridViewItemHeight = dipToPx(33.0d);
        this.mPopupViewMaxHeight = dipToPx(283.0d);
        this.mPopupViewPendingVertical = dipToPx(16.0d);
        this.mPopupViewPendingHorizontal = dipToPx(6.0d);
        this.mSurnameGridViewColumnsThreshold = 8;
        this.mSurnameGridViewItemWidth = dipToPx(40.0d);
        int r8 = r2.size();
        int r9 = this.mSurnameGridViewColumnsThreshold;
        if (r8 >= r9) goto L14;
        r9 = r2.size();
    L14:
        this.mSurnameGridViewNumColumns = r9;
        int r5 = (int) Math.ceil((((double) r2.size()) * 1.0d) / ((double) this.mSurnameGridViewNumColumns));
        this.mSurnameGridViewNumRows = r5;
        int r10 = (this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth) + (this.mPopupViewPendingHorizontal * 2);
        if (r5 <= 8) goto L17;
        int r7 = this.mPopupViewMaxHeight;
    L18:
        int r11 = r7 + (this.mPopupViewPendingVertical * 2);
        boolean r12 = QuickBarEx_DEBUG;
        if (r12 == false) goto L21;
        OLog.d("QuickBarEx", "surname GridView, width = " + r10 + ", height = " + r11);
    L21:
        this.mPopupGridView.setNumColumns(this.mSurnameGridViewNumColumns);
        this.mPopupGridView.setLayoutParams(new LinearLayout.LayoutParams(r10, r11));
        this.mPopupGridView.setGravity(17);
        this.mPopupGridView.setAdapter(r3);
        this.mPopupGridView.setOnPressChangeListener(new AnonymousClass10(this));
        this.mPopupGridView.setOnItemClickListener(new AnonymousClass11(this));
        if (this.mPopupWindow != null) goto L24;
        PopupWindow r13 = new PopupWindow();
        this.mPopupWindow = r13;
        r13.setWindowLayoutMode(-2, -2);
        this.mPopupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        this.mPopupWindow.setClippingEnabled(true);
    L24:
        this.mPopupWindow.setContentView(r4);
        getLocationOnScreen(new int[2]);
        getLocationInWindow(new int[2]);
        int[] r14 = new int[2];
        alphabetView.getLocationOnScreen(r14);
        if (r12 == false) goto L27;
        OLog.d("QuickBarEx", "alphabetView.getWidth = " + alphabetView.getWidth() + ", alphabetView.getHeight = " + alphabetView.getHeight());
    L27:
        int r15 = r14[0] + (alphabetView.getWidth() / 2);
        int r16 = r14[1] + (alphabetView.getHeight() / 2);
        if (r12 == false) goto L30;
        OLog.d("QuickBarEx", "alphabet anchorX = " + r14[0] + ", anchorY = " + r14[1]);
    L30:
        r4.measure(0, 0);
        int r17 = r4.getMeasuredWidth();
        int r18 = r4.getMeasuredHeight();
        if (r12 == false) goto L33;
        OLog.d("QuickBarEx", "popMeasureWidth = " + r17 + ", popMeasureHeight = " + r18);
    L33:
        int r19 = this.mColumnCount;
        if (position < r19) goto L36;
    L37:
        if (position < r19) goto L43;
        if (position >= (r19 * 2)) goto L43;
        if (this.mSurnameGridViewNumRows <= 3) goto L43;
    L54:
        boolean r20 = true;
    L56:
        if (r20 == false) goto L58;
        ImageView r1 = (ImageView) r4.findViewById(R.id.surname_popup_top_arrow);
        int r110 = r16 + this.mPopupYOffset;
    L59:
        int r21 = r110;
        if (r1 == null) goto L62;
        r1.setVisibility(0);
        r1.measure(0, 0);
        int r22 = r1.getMeasuredWidth();
    L63:
        if (r12 == false) goto L65;
        OLog.d("QuickBarEx", "arrowWidth = " + r22);
    L65:
        int r111 = r17 / 2;
        int r112 = Math.min(getScreenWidth() - r15, r111);
        int r113 = r15 - r111;
        int r23 = r22 / 2;
        int r24 = (r17 - r112) - r23;
        ImageView r114 = (ImageView) r4.findViewById(R.id.surname_top_mask);
        if (r114 != null) goto L68;
        return;
    L68:
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) r114.getLayoutParams();
        r115.width = this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth;
        ImageView r25 = (ImageView) r4.findViewById(R.id.surname_bottom_mask);
        FrameLayout.LayoutParams r26 = (FrameLayout.LayoutParams) r25.getLayoutParams();
        r26.width = this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth;
        LinearLayout r27 = (LinearLayout) r4.findViewById(R.id.surname_container);
        int r28 = this.mSurnameGridViewNumColumns;
        int r116 = this.mSurnameGridViewColumnsThreshold;
        if (r28 != r116) goto L74;
        ImageView r117 = r25;
        boolean r118 = r12;
        ImageView r29 = r114;
        if (r116 != 8) goto L73;
        r27.setPadding(dipToPx(14.0d), dipToPx(1.5d), dipToPx(17.0d), dipToPx(4.0d));
        r24 = r24 + getResources().getDimensionPixelSize(R.dimen.surname_arrow_offset_x);
        r115.leftMargin = dipToPx(20.0d);
        r26.leftMargin = dipToPx(20.0d);
    L75:
        if (r118 == false) goto L77;
        OLog.d("QuickBarEx", "arrowTranslationX = " + r24);
    L77:
        if (r1 == null) goto L79;
        r1.setTranslationX(r24);
    L79:
        r29.setLayoutParams(r115);
        r117.setLayoutParams(r26);
        if (Math.abs(getX() - this.mEndX) <= dipToPx(1.0d)) goto L82;
        OLog.d(r13, "GridView is hiding now...");
        return;
    L82:
        this.mPopupWindow.showAtLocation(this, 0, r113, r21);
        return;
    L73:
        int r30 = ((dipToPx(40.0d) * 8) - (this.mSurnameGridViewNumColumns * this.mSurnameGridViewItemWidth)) / 2;
        r27.setPadding(dipToPx(14.0d) + r30, dipToPx(1.5d), dipToPx(17.0d) + r30, dipToPx(4.0d));
        r115.leftMargin = dipToPx(20.0d) + r30;
        r26.leftMargin = dipToPx(20.0d) + r30;
        r24 = r15 - r23;
        goto L75
    L74:
        r117 = r25;
        r118 = r12;
        r29 = r114;
        r113 = r113 - 1;
        goto L75
    L62:
        r22 = 0;
        goto L63
    L58:
        r1 = (ImageView) r4.findViewById(R.id.surname_popup_bottom_arrow);
        r110 = (r16 - r18) - this.mPopupYOffset;
    L43:
        if (position < (r19 * 2)) goto L49;
        if (position >= (r19 * 3)) goto L49;
        if (this.mSurnameGridViewNumRows > 5) goto L54;
    L49:
        if (position >= (r19 * 3)) goto L51;
    L55:
        r20 = false;
        goto L56
    L51:
        if (position >= (r19 * 4)) goto L55;
        if (this.mSurnameGridViewNumRows <= 7) goto L55;
    L36:
        if (this.mSurnameGridViewNumRows > 1) goto L54;
    L17:
        r7 = r5 * this.mSurnameGridViewItemHeight;
        goto L18
    L88:
        return;
    L86:
        return;
    L85:
        throw new IllegalArgumentException("You must implements SurnameListener");
    }

    private void dismissPopupWindow() {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mPopupWindow = null;
        this.mPopupGridView = null;
        this.mPopupFlowLayout = null;
    L5:
        PopupWindow r1 = this.mSecondPopup;
        if (r1 == null) goto L9;
        r1.dismiss();
        this.mSecondPopup = null;
        this.mSecondPopupView = null;
        return;
    }

    private void showSecondPopupWindow(View anchorView) {
        if (anchorView != null) goto L7;
        PopupWindow r11 = this.mSecondPopup;
        if (r11 == null) goto L28;
        r11.dismiss();
        return;
    L28:
        return;
    L7:
        if (this.mSecondPopup != null) goto L10;
        PopupWindow r0 = new PopupWindow();
        this.mSecondPopup = r0;
        r0.setWindowLayoutMode(-2, -2);
        this.mSecondPopup.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        this.mSecondPopup.setClippingEnabled(true);
        ViewGroup r4 = (ViewGroup) null;
        ViewGroup r1 = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.surname_second_popup_ex, null);
        this.mSecondPopupViewParent = r1;
        this.mSecondPopupViewArrow = r1.getChildAt(1);
        this.mSecondPopupView = (TextView) this.mSecondPopupViewParent.getChildAt(0);
    L10:
        if (this.mSecondPopupView != null) goto L12;
        return;
    L12:
        this.mSecondPopup.setContentView(this.mSecondPopupViewParent);
        int[] r3 = new int[2];
        anchorView.getLocationOnScreen(r3);
        OLog.d("QuickBarEx", "original anchorViewLocation[0] = " + r3[0] + ", anchorViewLocation[1] = " + r3[1]);
        int[] r6 = new int[2];
        getRootView().getLocationOnScreen(r6);
        OLog.d("QuickBarEx", "rootViewLocation[0] = " + r6[0] + ", rootViewLocation[1] = " + r6[1]);
        String r5 = String.valueOf(anchorView.getTag());
        this.mSecondPopupView.setText(r5);
        this.mSecondPopupView.measure(0, 0);
        int r7 = ((int) this.mSecondPopupView.getPaint().measureText(r5)) + dipToPx(40.0d);
        int r8 = dipToPx(320.0d);
        if (r7 <= r8) goto L15;
        r7 = r8;
    L15:
        int r9 = this.mSecondPopupView.getMeasuredHeight();
        int r10 = anchorView.getWidth();
        int r12 = anchorView.getHeight();
        int r13 = (r3[0] - r6[0]) + (r10 / 2);
        int r2 = (r3[1] - r6[1]) + (r12 / 2);
        int r14 = r7 / 2;
        int r15 = r13 - r14;
        int r16 = (r2 - r9) - 20;
        int[] r17 = new int[2];
        View r18 = this.mSecondPopupViewArrow;
        if (r18 == null) goto L24;
        r18.getLocationOnScreen(r17);
        this.mSecondPopupViewArrow.setTranslationX(0.0f);
        if (r15 >= 0) goto L20;
        this.mSecondPopupViewArrow.setTranslationX(r15);
        goto L24
    L20:
        int r19 = r13 + r14;
        if (r19 <= getScreenWidth()) goto L24;
        this.mSecondPopupViewArrow.setTranslationX(r19 - getScreenWidth());
    L24:
        if (QuickBarEx_DEBUG == false) goto L26;
        OLog.d("QuickBarEx", "x = " + r15 + ", width = " + r7 + ", anchorView.getWidth() = " + anchorView.getWidth());
        OLog.d("QuickBarEx", "y = " + r16 + ", height = " + r9 + ", anchorView.getHeight() = " + anchorView.getHeight());
    L26:
        this.mSecondPopup.showAtLocation(this, 51, r15, r16);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 8) goto L11;
        if (changedView != this) goto L12;
        PopupWindow r2 = this.mPopupWindow;
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.isShowing() == false) goto L14;
        this.mPopupWindow.dismiss();
        return;
    L14:
        return;
    L12:
        return;
    }

    private void getParentxPos() {
        if (this.mHostX != (-99999)) goto L8;
        Object r0 = getParent();
        if ((r0 instanceof View) == false) goto L9;
        int[] r1 = new int[2];
        ((View) r0).getLocationInWindow(r1);
        this.mHostX = r1[0];
        return;
    L9:
        return;
    }
}
