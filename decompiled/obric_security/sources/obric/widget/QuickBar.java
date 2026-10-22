package obric.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class QuickBar extends View {
    private static final int BACK_INDEX = 27;
    private static final int COLUMN_COUNT = 3;
    private static final boolean DEBUG = true;
    public static final int ICON_STATUS_HOLDER = 1;
    public static final int ICON_STATUS_NORMAL = 0;
    public static final int ICON_STATUS_TOUCHED = 2;
    private static String[] JAPANESE_LETTERS = null;
    private static String[] KOREA_LETTERS = null;
    public static int LETTER_CHANGED_CLICK = 1;
    public static int LETTER_CHANGED_SLIDE = 0;
    private static final float POPUP_WINDOW_ARROW_WIDTH_DIP = 17.33f;
    private static final String POUND = "#";
    public static int POUND_POSITION_BOTTOM = 2;
    public static int POUND_POSITION_TOP = 1;
    private static final float SECOND_POPUP_HEIGHT_OFFSET_DIP = 6.78f;
    public static int SPECIAL_ICON_POSITION_BOTTOM = 2;
    public static int SPECIAL_ICON_POSITION_TOP = 1;
    private static final int STATE_END = 4;
    private static final int STATE_MOVE = 1;
    private static final int STATE_START = 3;
    private static final boolean SURNAME_DEBUG = false;
    private static final int SURNAME_NUM_COLUMNS_THRESHOLD = 8;
    private static final int SURNAME_NUM_ROWS_THRESHOLD = 8;
    private static final int SURNAME_NUM_ROWS_TOP_THRESHOLD = 1;
    private static final String TAG = "QuickBar";
    private static final int VISIBILITY_FLAG_GONE = 2;
    private static final int VISIBILITY_FLAG_NON_CHANGE = 0;
    private static final int VISIBILITY_FLAG_VISIBLE = 1;
    public static final int VISIBILITY_LIMIT = 30;
    private String[] ENGLISH_LETTERS;
    private NinePatchDrawable mBg;
    private NinePatch mBgDownNinePatch;
    private int mBgLeftInvisiblePadding;
    private int mChoose;
    private Context mContext;
    private float mDividerHeight;
    private float mDrawTouchX;
    private float mDrawTouchY;
    private long mDuration;
    private int mEndX;
    private int mFontY;
    private int mHasChooseColor;
    private boolean mHasDismissedSurnamePopupWindow;
    private boolean mHasPerformedLongPress;
    private Bitmap mHighlight;
    private int mHighlightX;
    private int mHighlightY;
    private Bitmap mIconDot;
    private int mIconDotYOffset;
    private int mIconX;
    private int mIconY;
    private boolean mIsDrawDownBg;
    private boolean mIsFixedHeight;
    private boolean mIsInterception;
    private boolean mIsPerformingHideAnim;
    private boolean mIsPerformingShowAnim;
    private boolean mIsStateChanged;
    private boolean mIsVisible;
    private int mItemHeight;
    private int mItemWidth;
    private float mLastX;
    private int mLetterMinHeight;
    private ArrayList<String> mLetters;
    private boolean mLongPressEnabled;
    private MotionEvent mLongPressMotionEvent;
    private Runnable mLongPressRunnable;
    private int mMeasuredHeight;
    private float mMissX;
    private int mMoveIndex;
    private int mNoChooseColor;
    private float mNowX;
    private Paint mPaint;
    private SurnameGridView mPopupGridView;
    private int mPopupViewMaxHeight;
    private int mPopupViewPendingHorizontal;
    private int mPopupViewPendingVertical;
    private PopupWindow mPopupWindow;
    private int mPopupYOffset;
    private int mPoundPosition;
    private boolean mPoundVisibility;
    private int mPrePosition;
    private QBHideListener mQBHideListener;
    private QBListener mQBListener;
    private QBTouchListener mQBTouchListener;
    private int mQuickBarFontSize;
    private int mQuickBarFontX;
    private int mQuickBarWidth;
    private int mQuickBarX;
    private int mScreenWidth;
    private PopupWindow mSecondPopup;
    private TextView mSecondPopupView;
    boolean mShowBg;
    private float mSingleHeight;
    private float mSingleItemHeight;
    private float mSingleWidth;
    private int mSpecailIconPosition;
    private Bitmap[][] mSpecialIcons;
    private int mSpecialPosition;
    private int[] mSpecialSymbol;
    private int mStartIndex;
    private int mStartX;
    private int mState;
    private int mStateActionDown;
    private SurnameListener mSurnameListener;
    private int mThumbModeYDiff;
    private String mToastSurnameNotFound;
    private int mWidth;

    public interface QBHideListener {
        void onLetterGridHidden();
    }

    public interface QBListener {
        boolean onLetterChanged(String letter, int type);

        void onLetterGridShow();
    }

    public interface QBTouchListener {
        void onQBTouchDown();

        void onQBTouchMove();

        void onQBTouchUp();
    }

    private final class SurnameAdapter extends BaseAdapter {
        private Context context;
        private List<String> surnames;
        final /* synthetic */ QuickBar this$0;

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return 0;
        }

        public SurnameAdapter(final QuickBar this$0, Context context, List<String> surnames) {
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
            convertView = LayoutInflater.from(this.context).inflate(R.layout.surname_popup_item, null);
            convertView.setLayoutParams(new AbsListView.LayoutParams(QuickBar.access$900(this.this$0), QuickBar.access$1000(this.this$0)));
        L4:
            int r5 = position % 8;
            if (r5 == 0) goto L7;
        L9:
            if (r5 != 0) goto L12;
            convertView.setBackgroundResource(R.drawable.surname_popup_item_right);
        L18:
            ((TextView) convertView).setText(String.valueOf(this.surnames.get(position)));
            return convertView;
        L12:
            if (r5 != 7) goto L14;
        L17:
            convertView.setBackgroundResource(R.drawable.surname_popup_item_left);
            goto L18
        L14:
            if (position == (getCount() - 1)) goto L17;
            convertView.setBackgroundResource(R.drawable.surname_popup_item_middle);
            goto L18
        L7:
            if (position != (getCount() - 1)) goto L9;
            convertView.setBackgroundResource(R.drawable.surname_popup_item_special);
            goto L18
        }
    }

    public interface SurnameListener {
        List<String> getMatchedSurnames(String letter);

        void onSurnameClicked(String surname);
    }

    private void printLog(String log) {
    }

    static /* synthetic */ boolean access$002(QuickBar r0, boolean r1) {
        r0.mIsPerformingShowAnim = r1;
        return r1;
    }

    static /* synthetic */ void access$100(QuickBar r0) {
        r0.onShowLetterGridAnimationEnd();
    }

    static /* synthetic */ int access$1000(QuickBar r0) {
        return r0.mItemHeight;
    }

    static /* synthetic */ boolean access$202(QuickBar r0, boolean r1) {
        r0.mIsPerformingHideAnim = r1;
        return r1;
    }

    static /* synthetic */ void access$300(QuickBar r0, int r1) {
        r0.onHideLetterGridAnimationEnd(r1);
    }

    static /* synthetic */ QBHideListener access$400(QuickBar r0) {
        return r0.mQBHideListener;
    }

    static /* synthetic */ void access$500(QuickBar r0) {
        r0.showPopupWindow();
    }

    static /* synthetic */ void access$600(QuickBar r0, View r1) {
        r0.showSecondPopupWindow(r1);
    }

    static /* synthetic */ SurnameGridView access$700(QuickBar r0) {
        return r0.mPopupGridView;
    }

    static /* synthetic */ SurnameListener access$800(QuickBar r0) {
        return r0.mSurnameListener;
    }

    static /* synthetic */ int access$900(QuickBar r0) {
        return r0.mItemWidth;
    }

    static {
        KOREA_LETTERS = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ".B", "D", ".E", "G", ".F", "J", ".K", "M", ".N", "P", ".Q", ExifInterface.LATITUDE_SOUTH, ".T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ".W", "Y", ".Z", POUND};
        JAPANESE_LETTERS = new String[]{"あ", "か", "さ", "た", "な", "は", "ま", "や", "ら", "わ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ".B", "D", ".E", "G", ".F", "J", ".K", "M", ".N", "P", ".Q", ExifInterface.LATITUDE_SOUTH, ".T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ".W", "Y", ".Z", POUND};
    }

    public QuickBar(Context context) {
        super(context);
        this.mPoundVisibility = true;
        this.mPoundPosition = POUND_POSITION_BOTTOM;
        this.mThumbModeYDiff = 0;
        this.mSpecailIconPosition = SPECIAL_ICON_POSITION_TOP;
        this.mLetters = new ArrayList();
        this.ENGLISH_LETTERS = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", POUND};
        this.mChoose = -1;
        this.mPaint = new Paint();
        this.mShowBg = false;
        this.mBg = null;
        this.mState = 3;
        this.mMissX = 0.0f;
        this.mLastX = 0.0f;
        this.mNowX = 0.0f;
        this.mMeasuredHeight = 0;
        this.mDuration = 200;
        this.mIsPerformingHideAnim = false;
        this.mIsPerformingShowAnim = false;
        this.mBgLeftInvisiblePadding = 10;
        this.mSpecialPosition = -1;
        this.mIsStateChanged = true;
        this.mIsDrawDownBg = false;
        this.mStartIndex = -1;
        this.mMoveIndex = -1;
        this.mIsVisible = true;
        this.mIsInterception = false;
        this.mIsFixedHeight = true;
        this.mHasDismissedSurnamePopupWindow = false;
        this.mLongPressEnabled = true;
        this.mPrePosition = -1;
        this.mLongPressRunnable = new AnonymousClass3(this);
    }

    public QuickBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mPoundVisibility = true;
        this.mPoundPosition = POUND_POSITION_BOTTOM;
        this.mThumbModeYDiff = 0;
        this.mSpecailIconPosition = SPECIAL_ICON_POSITION_TOP;
        this.mLetters = new ArrayList();
        this.ENGLISH_LETTERS = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", POUND};
        this.mChoose = -1;
        this.mPaint = new Paint();
        this.mShowBg = false;
        this.mBg = null;
        this.mState = 3;
        this.mMissX = 0.0f;
        this.mLastX = 0.0f;
        this.mNowX = 0.0f;
        this.mMeasuredHeight = 0;
        this.mDuration = 200;
        this.mIsPerformingHideAnim = false;
        this.mIsPerformingShowAnim = false;
        this.mBgLeftInvisiblePadding = 10;
        this.mSpecialPosition = -1;
        this.mIsStateChanged = true;
        this.mIsDrawDownBg = false;
        this.mStartIndex = -1;
        this.mMoveIndex = -1;
        this.mIsVisible = true;
        this.mIsInterception = false;
        this.mIsFixedHeight = true;
        this.mHasDismissedSurnamePopupWindow = false;
        this.mLongPressEnabled = true;
        this.mPrePosition = -1;
        this.mLongPressRunnable = new AnonymousClass3(this);
        init(context);
    }

    public QuickBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPoundVisibility = true;
        this.mPoundPosition = POUND_POSITION_BOTTOM;
        this.mThumbModeYDiff = 0;
        this.mSpecailIconPosition = SPECIAL_ICON_POSITION_TOP;
        this.mLetters = new ArrayList();
        this.ENGLISH_LETTERS = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", POUND};
        this.mChoose = -1;
        this.mPaint = new Paint();
        this.mShowBg = false;
        this.mBg = null;
        this.mState = 3;
        this.mMissX = 0.0f;
        this.mLastX = 0.0f;
        this.mNowX = 0.0f;
        this.mMeasuredHeight = 0;
        this.mDuration = 200;
        this.mIsPerformingHideAnim = false;
        this.mIsPerformingShowAnim = false;
        this.mBgLeftInvisiblePadding = 10;
        this.mSpecialPosition = -1;
        this.mIsStateChanged = true;
        this.mIsDrawDownBg = false;
        this.mStartIndex = -1;
        this.mMoveIndex = -1;
        this.mIsVisible = true;
        this.mIsInterception = false;
        this.mIsFixedHeight = true;
        this.mHasDismissedSurnamePopupWindow = false;
        this.mLongPressEnabled = true;
        this.mPrePosition = -1;
        this.mLongPressRunnable = new AnonymousClass3(this);
    }

    private void init(Context context) {
        this.mContext = context;
        Resources r3 = getResources();
        this.mWidth = r3.getDimensionPixelSize(R.dimen.quickbartable_width);
        this.mQuickBarWidth = r3.getDimensionPixelSize(R.dimen.quickbar_width);
        this.mLetterMinHeight = dipToPx(12.0d);
        this.mDividerHeight = r3.getDimension(R.dimen.quickbar_divider_height);
        this.mSingleItemHeight = r3.getDimension(R.dimen.quickbar_single_item_height);
        this.mQuickBarFontSize = r3.getDimensionPixelSize(R.dimen.quickbar_font_size);
        this.mQuickBarFontX = r3.getDimensionPixelSize(R.dimen.quickbar_font_x);
        this.mSingleWidth = (this.mWidth - this.mQuickBarWidth) / 3;
        this.mFontY = r3.getDimensionPixelSize(R.dimen.quickbar_font_y);
        this.mQuickBarX = r3.getDimensionPixelSize(R.dimen.quickbar_x);
        this.mHighlight = BitmapFactory.decodeResource(r3, R.drawable.quickbar_highlight);
        this.mHighlightX = r3.getDimensionPixelSize(R.dimen.quickbar_highlight_x);
        this.mHighlightY = r3.getDimensionPixelSize(R.dimen.quickbar_highlight_y);
        this.mIconX = r3.getDimensionPixelSize(R.dimen.quickbar_iconme_x);
        this.mIconY = r3.getDimensionPixelSize(R.dimen.quickbar_iconme_y);
        this.mIconDot = BitmapFactory.decodeResource(r3, R.drawable.quickbar_dot);
        this.mIconDotYOffset = dipToPx(0.67d);
        this.mHasChooseColor = Color.parseColor("#989898");
        this.mNoChooseColor = Color.parseColor("#b2b2b2");
        this.mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.mPaint.setTextSize(this.mQuickBarFontSize);
        this.mPaint.setAntiAlias(true);
        initLetters();
    }

    private void setHostWidth(int hostWidth) {
        this.mScreenWidth = hostWidth;
        int r0 = hostWidth - this.mQuickBarWidth;
        this.mStartX = r0;
        this.mEndX = hostWidth - this.mWidth;
        setX(r0);
        invalidate();
    }

    public void initSpecialIcons(int[] symbols, Bitmap[][] iconsBitmaps) {
        if (symbols == null) goto L20;
        if (iconsBitmaps != null) goto L6;
        return;
    L6:
        if (symbols.length != 0) goto L8;
        return;
    L8:
        if (iconsBitmaps.length != 0) goto L11;
        return;
    L11:
        if (symbols.length != iconsBitmaps.length) goto L19;
        if (iconsBitmaps[0].length != 3) goto L17;
        this.mSpecialSymbol = symbols;
        this.mSpecialIcons = iconsBitmaps;
        initLetters();
        return;
    L17:
        throw new IllegalArgumentException("Paramer iconsBitmaps[x][y], y must is 3 !!!");
    L19:
        throw new IllegalArgumentException("The symbols.length must equals iconsBitmap.length !");
    }

    public void initLetters() {
        int[] r0 = this.mSpecialSymbol;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        if (r2 < 0) goto L10;
        if (this.mSpecialPosition == r2) goto L10;
    L13:
        if (this.mSpecailIconPosition != SPECIAL_ICON_POSITION_TOP) goto L15;
        this.mSpecialPosition = r2;
    L15:
        this.mLetters.clear();
        String[] r3 = this.ENGLISH_LETTERS;
        int r4 = 0;
    L17:
        if (r4 >= (r3.length - 1)) goto L20;
        this.mLetters.add(r3[r4]);
        r4 = r4 + 1;
        goto L17
    L20:
        if (this.mSpecailIconPosition != SPECIAL_ICON_POSITION_TOP) goto L25;
        int r5 = 0;
    L22:
        if (r5 >= r2) goto L25;
        this.mLetters.add(r5, String.valueOf(this.mSpecialSymbol[r5]));
        r5 = r5 + 1;
    L25:
        if (this.mPoundVisibility == false) goto L34;
        if (this.mPoundPosition == POUND_POSITION_TOP) goto L29;
        this.mLetters.add(POUND);
        goto L34
    L29:
        if (this.mSpecailIconPosition != SPECIAL_ICON_POSITION_TOP) goto L31;
        this.mLetters.add(r2, POUND);
        goto L34
    L31:
        this.mLetters.add(0, POUND);
    L34:
        if (this.mSpecailIconPosition != SPECIAL_ICON_POSITION_BOTTOM) goto L38;
        this.mSpecialPosition = this.mLetters.size();
    L36:
        if (r1 >= r2) goto L38;
        this.mLetters.add(String.valueOf(this.mSpecialSymbol[r1]));
        r1 = r1 + 1;
    L38:
        printLog("mLetters: " + this.mLetters.toString());
        invalidate();
        return;
    L10:
        if (this.mPoundPosition == POUND_POSITION_TOP) goto L13;
        return;
    L5:
        r2 = r0.length;
        goto L6
    }

    public void clearSpecialIcons() {
        this.mSpecialSymbol = null;
        this.mSpecialIcons = null;
        this.mSpecialPosition = -1;
    }

    public void setPoundVisibility(boolean visible) {
        this.mPoundVisibility = visible;
    }

    public void setPoundPosition(int position) {
        this.mPoundPosition = position;
    }

    public void setSpecailIconPosition(int position) {
        this.mSpecailIconPosition = position;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mMeasuredHeight = measureHeight(heightMeasureSpec);
        measureSingleHeight();
        Object r1 = getParent();
        if (r1 == null) goto L8;
        int r2 = ((View) r1).getMeasuredWidth();
        if (r2 <= 0) goto L9;
        setHostWidth(r2);
        return;
    L9:
        return;
    }

    private int measureHeight(int measureSpec) {
        int r1 = View.MeasureSpec.getMode(measureSpec);
        int r2 = View.MeasureSpec.getSize(measureSpec);
        if (r1 != Integer.MIN_VALUE) goto L6;
        return r2;
    L6:
        if (r1 == 1073741824) goto L11;
        return 0;
    L11:
        return r2;
    }

    private void measureSingleHeight() {
        NinePatchDrawable r0 = this.mBg;
        if (r0 == null) goto L5;
        float r1 = Math.round((this.mMeasuredHeight - r0.getMinimumHeight()) / 18.0f);
    L6:
        this.mSingleHeight = (this.mSingleItemHeight + this.mDividerHeight) + (r1 * 2.0f);
        return;
    L5:
        r1 = 0.0f;
        goto L6
    }

    private boolean isKoreaLetter(String letter) {
        int r0 = 0;
    L4:
        if (r0 >= 14) goto L10;
        if (KOREA_LETTERS[r0].equals(letter) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static boolean isJapaneseLetter(String letter) {
        int r1 = 0;
    L4:
        if (r1 >= 10) goto L10;
        if (JAPANESE_LETTERS[r1].equals(letter) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r2 = getHeight();
        if (this.mShowBg == false) goto L5;
    L6:
        NinePatchDrawable r3 = this.mBg;
        if (r3 != null) goto L9;
    L12:
        float r4 = getSingleLetterHeight(r2);
        ArrayList<Integer> r5 = calculateVisibleLettersIndex();
        int r6 = calculateDotAlignmentHeight(r5);
        if (r6 >= 0) goto L15;
    L17:
        boolean r7 = false;
    L18:
        Iterator<Integer> r8 = r5.iterator();
        int r9 = 0;
    L20:
        if (r8.hasNext() == false) goto L59;
        int r10 = r8.next().intValue();
        float r11 = this.mQuickBarFontX - (this.mPaint.measureText(this.mLetters.get(r10)) / 2.0f);
        float r12 = r6 + r4;
        float r13 = r4 / 2.0f;
        float r14 = (r9 * r12) + r13;
        int r15 = this.mChoose;
        if (r10 == r15) goto L24;
    L26:
        Paint r16 = this.mPaint;
        if (r15 != (-1)) goto L29;
        int r17 = this.mNoChooseColor;
    L30:
        r16.setColor(r17);
        boolean r18 = false;
        this.mPaint.setFakeBoldText(false);
    L31:
        int r19 = this.mSpecialPosition;
        if (r9 < r19) goto L34;
    L37:
        if (r9 >= r19) goto L39;
    L41:
        String r20 = this.mLetters.get(r10);
        if (r20.startsWith(LibrarianImpl.Constants.DOT) == false) goto L45;
        canvas.drawBitmap(this.mIconDot, ((this.mQuickBarWidth + this.mBgLeftInvisiblePadding) - this.mIconDot.getWidth()) / 2, r14 - this.mIconDotYOffset, null);
    L52:
        r9 = r9 + 1;
        if (r7 == false) goto L20;
        if (r10 == (this.mLetters.size() - 2)) goto L20;
        canvas.drawBitmap(this.mIconDot, ((this.mQuickBarWidth + this.mBgLeftInvisiblePadding) - this.mIconDot.getWidth()) / 2, ((r12 * r9) + r13) - this.mIconDotYOffset, null);
        r9 = r9 + 1;
        goto L20
    L45:
        if (isKoreaLetter(r20) == false) goto L47;
    L50:
        this.mPaint.setTextSize(34.0f);
        this.mPaint.setFakeBoldText(true);
    L51:
        canvas.drawText(r20, r11, r14 + this.mFontY, this.mPaint);
        goto L52
    L47:
        if (isJapaneseLetter(r20) == true) goto L50;
        this.mPaint.setTextSize(this.mQuickBarFontSize);
        goto L51
    L39:
        if (this.mSpecailIconPosition != SPECIAL_ICON_POSITION_BOTTOM) goto L41;
        drawSpecialLetters(r9 - r19, canvas, r11, r14);
        goto L52
    L34:
        if (this.mSpecailIconPosition != SPECIAL_ICON_POSITION_TOP) goto L37;
        drawSpecialLetters(r9, canvas, r11, r14);
        goto L52
    L29:
        r17 = this.mHasChooseColor;
        goto L30
    L24:
        if (this.mState != 3) goto L26;
        this.mPaint.setColor(-1);
        this.mPaint.setFakeBoldText(true);
        canvas.drawBitmap(this.mHighlight, this.mHighlightX, r14 - this.mHighlightY, null);
        r18 = false;
        goto L31
    L59:
        if (this.mShowBg == true) goto L61;
        return;
    L61:
        if (this.mIsDrawDownBg == false) goto L69;
        drawTouchBg(canvas);
        return;
    L69:
        return;
    L15:
        if (r5.size() >= this.mLetters.size()) goto L17;
        r7 = true;
        goto L18
    L9:
        if (this.mMeasuredHeight == r3.copyBounds().height()) goto L11;
        this.mBg.setBounds(new Rect(0, 0, this.mWidth, this.mMeasuredHeight));
    L11:
        this.mBg.draw(canvas);
        goto L12
    L5:
        if (getX() == this.mStartX) goto L12;
        goto L6
    }

    private float getSingleLetterHeight(int height) {
        float r3 = height / (this.mLetters.size() + 0.5f);
        this.mIsFixedHeight = false;
        return Math.max(r3, this.mLetterMinHeight);
    }

    private ArrayList<Integer> calculateVisibleLettersIndex() {
        ArrayList<Integer> r0 = new ArrayList();
        if (this.mIsFixedHeight == false) goto L5;
    L7:
        int r1 = 1;
    L8:
        r0.add(0);
        if (r1 >= (this.mLetters.size() / 2)) goto L15;
        int r2 = r1;
    L12:
        if (r2 >= (this.mLetters.size() - 1)) goto L15;
        r0.add(Integer.valueOf(r2));
        r2 = r2 + r1;
    L15:
        if (r1 >= this.mLetters.size()) goto L17;
        r0.add(Integer.valueOf(this.mLetters.size() - 1));
    L17:
        return r0;
    L5:
        if ((this.mMeasuredHeight / this.mLetters.size()) >= this.mLetterMinHeight) goto L7;
        r1 = Math.max(2, ((int) Math.ceil(this.mLetters.size() / ((this.mMeasuredHeight / this.mLetterMinHeight) - 2))) * 2);
        goto L8
    }

    private int calculateDotAlignmentHeight(ArrayList<Integer> visibleLetters) {
        if (this.mIsFixedHeight == true) goto L21;
        if (visibleLetters == null) goto L21;
        if (visibleLetters.size() == 0) goto L21;
        if (visibleLetters.size() != this.mLetters.size()) goto L11;
        return 0;
    L11:
        int r0 = (visibleLetters.size() * 2) - 1;
        if (visibleLetters.size() >= 2) goto L14;
    L16:
        int r4 = (this.mMeasuredHeight - (this.mLetterMinHeight * r0)) / r0;
        if (r4 >= 0) goto L22;
        return -1;
    L22:
        return r4;
    L14:
        if (visibleLetters.get(visibleLetters.size() - 2).intValue() != (this.mLetters.size() - 2)) goto L16;
        r0 = r0 - 1;
    L21:
        return 0;
    }

    private void drawSpecialLetters(int position, Canvas canvas, float xPos, float yPos) {
        int[] r0 = this.mSpecialSymbol;
        if (r0 != null) goto L5;
        return;
    L5:
        if (position >= r0.length) goto L28;
        Bitmap[][] r1 = this.mSpecialIcons;
        if (r1 == null) goto L31;
        float r9 = xPos - this.mIconX;
        float r10 = yPos - this.mIconY;
        int r2 = this.mChoose;
        if (r2 != position) goto L16;
        if (this.mState != 3) goto L16;
        if (this.mSpecailIconPosition != SPECIAL_ICON_POSITION_TOP) goto L16;
    L21:
        canvas.drawBitmap(r1[position][2], r9, r10, null);
        return;
    L16:
        if (r2 != (this.mSpecialPosition + position)) goto L23;
        if (this.mState != 3) goto L23;
        if (this.mSpecailIconPosition == SPECIAL_ICON_POSITION_BOTTOM) goto L21;
    L23:
        if (r2 == (-1)) goto L25;
        canvas.drawBitmap(r1[position][1], r9, r10, null);
        return;
    L25:
        canvas.drawBitmap(r1[position][0], r9, r10, null);
        return;
    L31:
        return;
    }

    private void drawTouchBg(Canvas canvas) {
        float r0 = this.mDrawTouchX;
        int r1 = this.mQuickBarWidth;
        if (r0 > r1) goto L5;
        return;
    L5:
        float r2 = this.mSingleWidth;
        float r3 = this.mDrawTouchY;
        float r4 = this.mSingleHeight;
        int r5 = (int) (r3 / r4);
        float r6 = r1 + (((int) ((r0 - r1) / r2)) * r2);
        float r7 = r2 + r6;
        float r8 = r5 * r4;
        if (r5 != 8) goto L8;
        float r9 = this.mMeasuredHeight;
    L9:
        this.mBgDownNinePatch.draw(canvas, new RectF(r6, r8, r7, r9));
        return;
    L8:
        r9 = r8 + r4;
        goto L9
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        super.dispatchTouchEvent(event);
        int r0 = event.getAction();
        if (this.mIsVisible == true) goto L5;
    L129:
        return true;
    L5:
        if (this.mIsInterception == false) goto L8;
        if (r0 == 2) goto L129;
    L8:
        if (this.mIsPerformingHideAnim == true) goto L129;
        this.mIsInterception = false;
        float r4 = event.getY();
        float r5 = event.getRawX();
        this.mDrawTouchX = event.getX();
        this.mDrawTouchY = r4;
        int r6 = this.mChoose;
        int r7 = (int) ((r4 / getHeight()) * this.mLetters.size());
        if (r0 == 0) goto L103;
        if (r0 == 1) goto L64;
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L64;
    L16:
        QBTouchListener r1 = this.mQBTouchListener;
        if (r1 == null) goto L20;
        r1.onQBTouchMove();
    L20:
        if (this.mHasPerformedLongPress == false) goto L23;
        onMoveInLongPressState(event);
        goto L129
    L23:
        if (getX() == this.mEndX) goto L25;
        removeLongPressCallback();
    L25:
        this.mShowBg = true;
        this.mLastX = this.mNowX;
        this.mNowX = r5;
        int r15 = getIndex(this.mDrawTouchX, this.mDrawTouchY);
        this.mMoveIndex = r15;
        if (this.mIsStateChanged == false) goto L28;
    L30:
        int r16 = this.mState;
        if (r16 == 3) goto L33;
        if (r16 != 4) goto L43;
        float r17 = this.mNowX;
        float r2 = this.mLastX;
        if ((r17 - r2) > 5.0f) goto L41;
    L49:
        int r18 = this.mState;
        if (r18 == 4) goto L53;
        if (r18 == 1) goto L53;
    L54:
        if (r6 != r7) goto L56;
    L63:
        invalidate();
        goto L129
    L56:
        if (this.mQBListener == null) goto L63;
        if (r7 < 0) goto L63;
        if (r7 >= this.mLetters.size()) goto L63;
        if (this.mQBListener.onLetterChanged(this.mLetters.get(r7), LETTER_CHANGED_SLIDE) == false) goto L63;
        this.mChoose = r7;
    L53:
        if (getX() <= (this.mScreenWidth - 100)) goto L63;
    L41:
        if (r2 <= this.mEndX) goto L49;
        this.mState = 1;
        moveQuickBar(r5, this.mMissX);
        goto L49
    L43:
        if (r16 != 1) goto L49;
        moveQuickBar(r5, this.mMissX);
        if (this.mState != 3) goto L49;
        QBHideListener r19 = this.mQBHideListener;
        if (r19 == null) goto L49;
        r19.onLetterGridHidden();
        goto L49
    L33:
        if (r5 >= this.mStartX) goto L49;
        this.mState = 1;
        moveQuickBar(r5, this.mMissX);
        QBListener r110 = this.mQBListener;
        if (r110 == null) goto L49;
        r110.onLetterGridShow();
        goto L49
    L28:
        if (r15 == this.mStartIndex) goto L30;
        this.mIsStateChanged = true;
        this.mIsDrawDownBg = false;
        removeLongPressCallback();
    L64:
        QBTouchListener r3 = this.mQBTouchListener;
        if (r3 == null) goto L67;
        r3.onQBTouchUp();
    L67:
        removeLongPressCallback();
        if (this.mHasPerformedLongPress == false) goto L78;
        int r111 = this.mPrePosition;
        if (r111 < 0) goto L76;
        SurnameGridView r8 = this.mPopupGridView;
        if (r8 == null) goto L76;
        View r112 = r8.getChildAt(r111);
        if (r112 == null) goto L76;
        r112.setPressed(false);
        this.mPopupGridView.performItemClick(r112, this.mPrePosition, -1);
    L76:
        this.mPrePosition = -1;
        this.mIsDrawDownBg = false;
        invalidate();
        goto L129
    L78:
        if (this.mHasDismissedSurnamePopupWindow == false) goto L83;
        this.mHasDismissedSurnamePopupWindow = false;
        if (this.mState != 4) goto L83;
        this.mIsDrawDownBg = false;
        invalidate();
    L83:
        if (this.mState == 3) goto L85;
    L92:
        letterChanged(this.mStateActionDown, this.mState, event.getX(), this.mStartIndex, this.mIsStateChanged);
        this.mMissX = 0.0f;
        if (getX() != this.mStartX) goto L96;
        resetBackground();
        goto L129
    L96:
        if (this.mState != 1) goto L129;
        this.mIsDrawDownBg = false;
        invalidate();
        if ((this.mNowX - this.mLastX) <= 0.0f) goto L100;
    L102:
        hideLetterGridWithAnim(0);
        goto L129
    L100:
        if (getX() >= (this.mScreenWidth - this.mQuickBarX)) goto L102;
        showLetterGridWithAnim();
        goto L129
    L85:
        if (this.mQBListener == null) goto L92;
        if (r7 < 0) goto L92;
        if (r7 >= this.mLetters.size()) goto L92;
        if (this.mQBListener.onLetterChanged(this.mLetters.get(r7), LETTER_CHANGED_SLIDE) == false) goto L92;
        this.mChoose = r7;
        goto L92
    L103:
        QBTouchListener r9 = this.mQBTouchListener;
        if (r9 == null) goto L106;
        r9.onQBTouchDown();
    L106:
        this.mHasPerformedLongPress = false;
        if (this.mBg != null) goto L109;
        loadResource();
    L109:
        this.mLastX = r5;
        this.mNowX = r5;
        this.mStartIndex = getIndex(this.mDrawTouchX, this.mDrawTouchY);
        this.mIsStateChanged = false;
        this.mIsDrawDownBg = true;
        int r10 = this.mState;
        this.mStateActionDown = r10;
        this.mShowBg = true;
        if (r10 != 4) goto L112;
        this.mMissX = r5 - this.mEndX;
    L112:
        if (r10 != 3) goto L121;
        this.mMissX = 0.0f;
        if (r6 == r7) goto L121;
        if (this.mQBListener == null) goto L121;
        if (r7 < 0) goto L121;
        if (r7 >= this.mLetters.size()) goto L121;
        this.mChoose = r7;
    L121:
        invalidate();
        if (this.mState != 4) goto L129;
        PopupWindow r11 = this.mPopupWindow;
        if (r11 != null) goto L126;
    L128:
        postLongPress(event);
        goto L129
    L126:
        if (r11.isShowing() == false) goto L128;
        this.mPopupWindow.dismiss();
        this.mHasDismissedSurnamePopupWindow = true;
        goto L128
    }

    private int getIndex(float x, float y) {
        int r0 = this.mQuickBarWidth;
        if (x >= r0) goto L7;
        return -1;
    L7:
        return (((int) (y / this.mSingleHeight)) * 3) + ((int) (((x - r0) / this.mSingleWidth) + 1.0f));
    }

    private void loadResource() {
        if (this.mBg != null) goto L6;
        this.mBg = (NinePatchDrawable) getResources().getDrawable(R.drawable.quickbar_bg);
        Bitmap r0 = BitmapFactory.decodeResource(getResources(), R.drawable.quickbar_bg_down);
        this.mBgDownNinePatch = new NinePatch(r0, r0.getNinePatchChunk(), null);
        Rect r1 = new Rect(0, 0, this.mWidth, this.mMeasuredHeight);
        this.mBg.setBounds(r1);
        measureSingleHeight();
        return;
    }

    public void setQBListener(QBListener listener) {
        this.mQBListener = listener;
    }

    public void setQBHideListener(QBHideListener listener) {
        this.mQBHideListener = listener;
    }

    public void setQBTouchListener(QBTouchListener listener) {
        this.mQBTouchListener = listener;
    }

    public boolean isLetterGridShow() {
        if (this.mIsPerformingShowAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mState == 4) goto L8;
        return false;
    }

    public boolean isLetterGridShown() {
        if (this.mState != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLetterGridHide() {
        if (this.mIsPerformingHideAnim == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mState == 3) goto L8;
        return false;
    }

    public boolean isLetterGridHidden() {
        if (this.mState != 3) goto L5;
        return true;
    L5:
        return false;
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

    public void setHeightFixed(boolean fixed) {
        this.mIsFixedHeight = fixed;
    }

    public void hideLetterGrid(boolean withAnim) {
        if (this.mIsVisible == true) goto L5;
        return;
    L5:
        if (isLetterGridHide() == false) goto L7;
        return;
    L7:
        if (withAnim == false) goto L9;
        hideLetterGridWithAnim(0);
        return;
    L9:
        onHideLetterGridAnimationEnd(0);
    }

    public void resetBackground() {
        setX(this.mStartX);
        this.mShowBg = false;
        this.mChoose = -1;
        this.mState = 3;
        invalidate();
    }

    private void showLetterGridWithAnim() {
        AnimatorSet r0 = new AnimatorSet();
        r0.play(ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(MaterialConfigFormatNames.X, new float[]{getX(), this.mEndX})}));
        r0.setDuration(this.mDuration);
        r0.addListener(new AnonymousClass1(this));
        r0.start();
    }

    private void onShowLetterGridAnimationEnd() {
        setX(this.mEndX);
        this.mShowBg = true;
        this.mState = 4;
        invalidate();
    }

    private void hideLetterGridWithAnim(final int visibleFlag) {
        dismissPopupWindow();
        removeLongPressCallback();
        this.mIsInterception = true;
        AnimatorSet r1 = new AnimatorSet();
        r1.play(ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(MaterialConfigFormatNames.X, new float[]{getX(), this.mStartX})}));
        r1.setDuration(this.mDuration);
        r1.addListener(new AnonymousClass2(this, visibleFlag));
        r1.start();
    }

    private void onHideLetterGridAnimationEnd(int visibleFlag) {
        this.mIsStateChanged = false;
        this.mIsDrawDownBg = false;
        this.mShowBg = false;
        this.mChoose = -1;
        this.mState = 3;
        setX(this.mStartX);
        if (visibleFlag != 1) goto L5;
        super.setVisibility(0);
    L9:
        invalidate();
        return;
    L5:
        if (visibleFlag != 2) goto L9;
        super.setVisibility(8);
        goto L9
    }

    private void moveQuickBar(float x, float missX) {
        Locale.getDefault().getLanguage();
        float r2 = x - missX;
        int r3 = this.mStartX;
        if (r2 < r3) goto L5;
        setX(r3);
        this.mState = 3;
        return;
    L5:
        int r4 = this.mEndX;
        if (r2 > r4) goto L9;
        setX(r4);
        this.mState = 4;
        return;
    L9:
        if (r2 <= r4) goto L14;
        setX(r2);
        this.mState = 1;
        return;
    }

    private void letterChanged(int stateDown, int state, float endX, int index, boolean isStateChanged) {
        if (isStateChanged == false) goto L7;
        this.mIsDrawDownBg = false;
        invalidate();
        return;
    L7:
        if (endX >= this.mQuickBarWidth) goto L10;
        return;
    L10:
        if (stateDown != 4) goto L24;
        if (state != 4) goto L24;
        if (index != 27) goto L15;
        hideLetterGridWithAnim(0);
        return;
    L15:
        QBListener r2 = this.mQBListener;
        if (r2 == null) goto L27;
        if (index < 0) goto L28;
        String[] r3 = this.ENGLISH_LETTERS;
        if (index < r3.length) goto L21;
        return;
    L21:
        if (r2.onLetterChanged(r3[index - 1], LETTER_CHANGED_CLICK) == false) goto L23;
        this.mChoose = index - this.mSpecialPosition;
        invalidate();
    L23:
        hideLetterGridWithAnim(0);
        return;
    L28:
        return;
    L27:
        return;
    L24:
        invalidate();
    }

    private int dipToPx(double dipValue) {
        return (int) ((dipValue * ((double) this.mContext.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public void setSurnameListener(SurnameListener listener) {
        this.mSurnameListener = listener;
    }

    public void setLongPressEnabled(boolean enabled) {
        this.mLongPressEnabled = enabled;
    }

    private void postLongPress(MotionEvent ev) {
        if (this.mLongPressEnabled == true) goto L5;
        return;
    L5:
        this.mLongPressMotionEvent = ev;
        postDelayed(this.mLongPressRunnable, ViewConfiguration.getLongPressTimeout());
    }

    private void removeLongPressCallback() {
        removeCallbacks(this.mLongPressRunnable);
        this.mLongPressMotionEvent = null;
    }

    private void showPopupWindow() {
        int r1 = getIndex(this.mLongPressMotionEvent.getX(), this.mLongPressMotionEvent.getY()) - 1;
        if (r1 >= 0) goto L5;
        return;
    L5:
        if (r1 >= (this.ENGLISH_LETTERS.length - 1)) goto L58;
        this.mHasPerformedLongPress = true;
        this.mItemWidth = dipToPx(40.0d);
        this.mItemHeight = dipToPx(33.0d);
        this.mPopupYOffset = dipToPx(7.0d);
        this.mPopupViewMaxHeight = dipToPx(283.0d);
        this.mPopupViewPendingVertical = dipToPx(16.0d);
        this.mPopupViewPendingHorizontal = dipToPx(6.0d);
        SurnameListener r3 = this.mSurnameListener;
        if (r3 == null) goto L54;
        List<String> r4 = r3.getMatchedSurnames(this.ENGLISH_LETTERS[r1]);
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.size() == 0) goto L57;
        SurnameAdapter r5 = new SurnameAdapter(this, this.mContext, r4);
        View r6 = LayoutInflater.from(this.mContext).inflate(R.layout.surname_popup, null);
        this.mPopupGridView = (SurnameGridView) r6.findViewById(R.id.surname_content);
        if (r4.size() < 8) goto L17;
        int r7 = 8;
    L18:
        int r8 = (int) Math.ceil((((double) r4.size()) * 1.0d) / ((double) r7));
        this.mPopupGridView.setNumColumns(r7);
        int r9 = (this.mItemWidth * r7) + (this.mPopupViewPendingHorizontal * 2);
        if (r8 <= 8) goto L21;
        int r10 = this.mPopupViewMaxHeight;
    L22:
        int r11 = (this.mPopupViewPendingVertical * 2) + r10;
        printLog("surname GridView, width = " + r9 + ", height = " + r10);
        this.mPopupGridView.setLayoutParams(new LinearLayout.LayoutParams(r9, r11));
        this.mPopupGridView.setGravity(17);
        this.mPopupGridView.setAdapter(r5);
        this.mPopupGridView.setOnPressChangeListener(new AnonymousClass4(this));
        this.mPopupGridView.setOnItemClickListener(new AnonymousClass5(this));
        if (this.mPopupWindow != null) goto L25;
        PopupWindow r12 = new PopupWindow();
        this.mPopupWindow = r12;
        r12.setWindowLayoutMode(-2, -2);
        this.mPopupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        this.mPopupWindow.setClippingEnabled(true);
    L25:
        this.mPopupWindow.setContentView(r6);
        int[] r13 = new int[2];
        int[] r14 = new int[2];
        getLocationOnScreen(r13);
        getLocationInWindow(r14);
        int r15 = r14[1];
        int r16 = r13[1];
        this.mThumbModeYDiff = r15 - r16;
        float r17 = r13[0];
        float r18 = r16;
        printLog("index = " + r1 + ", quickBarX = " + r17 + ", quickBarY = " + r18);
        int r2 = (int) (((double) (r17 + this.mQuickBarWidth)) + ((((double) (r1 % 3)) + 0.5d) * ((double) this.mSingleWidth)));
        int r19 = (int) (((double) r18) + ((((double) (r1 / 3)) + 0.5d) * ((double) this.mSingleHeight)));
        printLog("anchorX = " + r2 + ", anchorY = " + r19);
        r6.measure(0, 0);
        int r20 = r6.getMeasuredWidth();
        int r21 = r6.getMeasuredHeight();
        printLog("popMeasureWidth = " + r20 + ", popMeasureHeight = " + r21);
        int r110 = r20 / 2;
        int r111 = Math.min(this.mScreenWidth - r2, r110);
        int r22 = r2 - r110;
        int r23 = (r20 - r111) - (dipToPx(17.329999923706055d) / 2);
        ImageView r112 = (ImageView) r6.findViewById(R.id.surname_top_mask);
        FrameLayout.LayoutParams r113 = (FrameLayout.LayoutParams) r112.getLayoutParams();
        r113.width = this.mItemWidth * r7;
        ImageView r114 = (ImageView) r6.findViewById(R.id.surname_bottom_mask);
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) r114.getLayoutParams();
        r115.width = this.mItemWidth * r7;
        LinearLayout r116 = (LinearLayout) r6.findViewById(R.id.surname_container);
        if (r7 != 8) goto L28;
        r116.setPadding(dipToPx(14.0d), dipToPx(1.5d), dipToPx(17.0d), dipToPx(4.0d));
        r23 = r23 + getResources().getDimensionPixelSize(R.dimen.arrow_translation_x);
        r113.leftMargin = dipToPx(20.0d);
        r115.leftMargin = dipToPx(20.0d);
    L29:
        r112.setLayoutParams(r113);
        r114.setLayoutParams(r115);
        boolean r24 = true;
        if (r1 >= 3) goto L33;
        if (r8 <= 1) goto L33;
    L48:
        if (r24 == false) goto L50;
        ImageView r25 = (ImageView) r6.findViewById(R.id.surname_popup_top_arrow);
        r25.setTranslationX(r23);
        int r26 = 0;
        r25.setVisibility(0);
        int r27 = r19 + this.mPopupYOffset;
    L51:
        this.mPopupWindow.showAtLocation(this, r26, r22, r27 + this.mThumbModeYDiff);
        return;
    L50:
        r26 = 0;
        ImageView r28 = (ImageView) r6.findViewById(R.id.surname_popup_bottom_arrow);
        r28.setTranslationX(r23);
        r28.setVisibility(0);
        r27 = (r19 - r21) - this.mPopupYOffset;
    L33:
        if (r1 < 3) goto L37;
        if (r1 >= 6) goto L37;
        if (r8 > 3) goto L48;
    L37:
        if (r1 < 6) goto L41;
        if (r1 >= 9) goto L41;
        if (r8 > 5) goto L48;
    L41:
        if (r1 >= 9) goto L43;
    L47:
        r24 = false;
        goto L48
    L43:
        if (r1 >= 12) goto L47;
        if (r8 <= 7) goto L47;
    L28:
        r22 = r22 - 1;
        goto L29
    L21:
        r10 = this.mItemHeight * r8;
        goto L22
    L17:
        r7 = r4.size();
        goto L18
    L57:
        return;
    L54:
        throw new IllegalArgumentException("You must implements SurnameListener");
    }

    private void dismissPopupWindow() {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mPopupWindow = null;
        this.mPopupGridView = null;
    L5:
        PopupWindow r1 = this.mSecondPopup;
        if (r1 == null) goto L9;
        r1.dismiss();
        this.mSecondPopup = null;
        this.mSecondPopupView = null;
        return;
    }

    private void onMoveInLongPressState(MotionEvent event) {
        PopupWindow r0 = this.mPopupWindow;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L26;
        int r1 = (int) event.getRawX();
        int r6 = (int) event.getRawY();
        SurnameGridView r2 = this.mPopupGridView;
        if (r2 == null) goto L25;
        int[] r3 = new int[2];
        r2.getLocationOnScreen(r3);
        int r7 = this.mPopupGridView.pointToPosition(r1 - r3[0], r6 - r3[1]);
        if (r7 < 0) goto L19;
        int r4 = this.mPrePosition;
        if (r4 == r7) goto L22;
        View r5 = this.mPopupGridView.getChildAt(r4);
        if (r5 == null) goto L16;
        r5.setPressed(false);
        showSecondPopupWindow(null);
    L16:
        View r8 = this.mPopupGridView.getChildAt(r7);
        if (r8 == null) goto L22;
        r8.setPressed(true);
        r8.setTag((String) this.mPopupGridView.getAdapter().getItem(r7));
        showSecondPopupWindow(r8);
    L22:
        this.mPrePosition = r7;
        return;
    L19:
        View r9 = this.mPopupGridView.getChildAt(this.mPrePosition);
        if (r9 == null) goto L22;
        r9.setPressed(false);
        showSecondPopupWindow(null);
        goto L22
    L25:
        return;
    }

    private void showSecondPopupWindow(View anchorView) {
        if (anchorView != null) goto L8;
        PopupWindow r7 = this.mSecondPopup;
        if (r7 == null) goto L12;
        r7.dismiss();
        return;
    L12:
        return;
    L8:
        if (this.mSecondPopup != null) goto L10;
        PopupWindow r0 = new PopupWindow();
        this.mSecondPopup = r0;
        r0.setWindowLayoutMode(-2, -2);
        this.mSecondPopup.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        this.mSecondPopup.setClippingEnabled(true);
        this.mSecondPopupView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.surname_second_popup, null);
    L10:
        this.mSecondPopup.setContentView(this.mSecondPopupView);
        int[] r2 = new int[2];
        anchorView.getLocationOnScreen(r2);
        this.mSecondPopupView.setText(String.valueOf(anchorView.getTag()));
        this.mSecondPopupView.measure(0, 0);
        int r8 = this.mSecondPopupView.getMeasuredWidth();
        int r4 = this.mSecondPopupView.getMeasuredHeight();
        r2[1] = r2[1] + this.mThumbModeYDiff;
        Log.d(TAG, "adjusted anchorViewLocation[0] = " + r2[0] + ", anchorViewLocation[1] = " + r2[1]);
        this.mSecondPopup.showAtLocation(this, 51, (r2[0] + (this.mItemWidth / 2)) - (r8 / 2), ((r2[1] + (this.mItemHeight / 2)) - r4) - dipToPx(6.78000020980835d));
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != 8) goto L16;
        if (changedView != this) goto L17;
        PopupWindow r2 = this.mPopupWindow;
        if (r2 != null) goto L8;
    L10:
        PopupWindow r3 = this.mSecondPopup;
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.isShowing() == false) goto L19;
        this.mSecondPopup.dismiss();
        return;
    L19:
        return;
    L8:
        if (r2.isShowing() == false) goto L10;
        this.mPopupWindow.dismiss();
        goto L10
    L17:
        return;
    }
}
