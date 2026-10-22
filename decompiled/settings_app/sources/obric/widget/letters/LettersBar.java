package obric.widget.letters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import obric.widget.R;
import smartisanos.util.Utils;

/* JADX INFO: loaded from: classes5.dex */
public class LettersBar extends View {
    private OnBackgroundVisibleChangedListener mBackgroundChangeListener;
    private int mChosenLetterIndex;
    private Context mContext;
    private Bitmap mDotIcon;
    private int mDotIconX;
    int mHasChosenLetterFontColor;
    private Bitmap mHighlightIcon;
    private int mHighlightIconHeight;
    private int mHighlightIconStartX;
    private int mLetterBarHeight;
    private int mLetterBarMargin;
    private int mLetterFontCenterX;
    private int mLetterFontSize;
    private int mLetterLocaleFontSize;
    private Paint mLetterPaint;
    private List<LBLetter> mLetters;
    private int mLettersBarWidth;
    private LBListener mListener;
    int mNoChosenLetterFontColor;
    private boolean mSettled;
    private boolean mShowBg;
    private int mSingleLetterMinHeight;

    public interface LBListener {
        boolean onLetterChanged(String letter);
    }

    public interface OnBackgroundVisibleChangedListener {
        void OnBackgroundVisibleChanged(boolean visible);
    }

    public LettersBar(Context context) {
        this(context, null);
    }

    public LettersBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LettersBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mChosenLetterIndex = -1;
        this.mSettled = true;
        this.mLetterPaint = new Paint();
        init(context);
    }

    public void setLetters(List<LBLetter> letters) {
        this.mLetters = letters;
    }

    public void setListener(LBListener listener) {
        this.mListener = listener;
    }

    public void setSettled(boolean settled) {
        this.mSettled = settled;
        if (settled == false) goto L5;
        setTouchedLetter(-1);
    L5:
        invalidate();
    }

    public void setShowBg(boolean showBg) {
        if (this.mShowBg == showBg) goto L12;
        this.mShowBg = showBg;
        if (showBg == false) goto L7;
        Drawable r2 = getResources().getDrawable(R.drawable.letters_bar_background);
    L8:
        setBackground(r2);
        OnBackgroundVisibleChangedListener r3 = this.mBackgroundChangeListener;
        if (r3 == null) goto L13;
        r3.OnBackgroundVisibleChanged(this.mShowBg);
        return;
    L13:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public void setOnBackgroundVisibleChangedListener(OnBackgroundVisibleChangedListener listener) {
        this.mBackgroundChangeListener = listener;
    }

    private void init(Context context) {
        this.mContext = context;
        Resources r4 = context.getResources();
        this.mSingleLetterMinHeight = r4.getDimensionPixelSize(R.dimen.letters_bar_single_letter_min_height);
        this.mLettersBarWidth = Utils.getDrawableWidth(this.mContext.getResources().getDrawable(R.drawable.letters_bar_background));
        this.mLetterFontSize = r4.getDimensionPixelOffset(R.dimen.letters_bar_letter_font_size);
        this.mLetterLocaleFontSize = r4.getDimensionPixelOffset(R.dimen.letters_bar_letter_locale_font_size);
        this.mLetterFontCenterX = this.mLettersBarWidth / 2;
        this.mHighlightIcon = BitmapFactory.decodeResource(r4, R.drawable.letters_bar_highlight_icon);
        Drawable r0 = r4.getDrawable(R.drawable.letters_bar_highlight_icon);
        this.mHighlightIconStartX = this.mLetterFontCenterX - (Utils.getDrawableWidth(r0) / 2);
        this.mHighlightIconHeight = Utils.getDrawableHeight(r0);
        this.mLetterBarMargin = (int) r4.getDimension(R.dimen.obric_quickbar_letterbar_margin);
        this.mHasChosenLetterFontColor = r4.getColor(R.color.has_chosen_letter_font_color);
        this.mNoChosenLetterFontColor = r4.getColor(R.color.no_chosen_letter_font_color);
        Bitmap r5 = BitmapFactory.decodeResource(r4, R.drawable.letters_bar_dot);
        this.mDotIcon = r5;
        this.mDotIconX = this.mLetterFontCenterX - (r5.getWidth() / 2);
        this.mLetterPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.mLetterPaint.setTextSize(this.mLetterFontSize);
        this.mLetterPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mLetterBarHeight = ((measureHeight(heightMeasureSpec) - (this.mLetterBarMargin * 2)) - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        super.dispatchTouchEvent(event);
        int r0 = event.getAction();
        float r6 = event.getY();
        int r1 = this.mChosenLetterIndex;
        int r7 = (int) (((r6 - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom())) * this.mLetters.size());
        if (r0 != 0) goto L5;
        if (r1 == r7) goto L41;
        if (r7 < 0) goto L41;
        if (r7 >= this.mLetters.size()) goto L41;
        setTouchedLetter(r7);
    L41:
        setShowBg(true);
    L42:
        return true;
    L5:
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L42;
        setTouchedLetter(-1);
        goto L42
    L13:
        if (this.mSettled == false) goto L23;
        if (r1 == r7) goto L23;
        if (this.mListener == null) goto L23;
        if (r7 < 0) goto L23;
        if (r7 >= this.mLetters.size()) goto L23;
        if (this.mListener.onLetterChanged(this.mLetters.get(r7).getLetter()) == false) goto L23;
        setTouchedLetter(r7);
    L23:
        setShowBg(true);
        goto L42
    L25:
        if (this.mSettled == true) goto L27;
    L35:
        invalidate();
        goto L42
    L27:
        if (this.mListener == null) goto L34;
        if (r7 < 0) goto L34;
        if (r7 >= this.mLetters.size()) goto L34;
        if (this.mListener.onLetterChanged(this.mLetters.get(r7).getLetter()) == false) goto L34;
        setTouchedLetter(r7);
    L34:
        setTouchedLetter(-1);
        setShowBg(false);
        goto L35
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(0.0f, getPaddingTop());
        ArrayList<Integer> r0 = calculateVisibleLettersIndexes();
        float r1 = getSingleLetterHeight(this.mLetterBarHeight, r0);
        Iterator<Integer> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L10;
        int r4 = r2.next().intValue();
        setLetterPaint(r4);
        float r5 = this.mLetterFontCenterX - (this.mLetterPaint.measureText(this.mLetters.get(r4).getLetter()) / 2.0f);
        float r6 = ((r3 * r1) + (r1 / 2.0f)) + this.mLetterBarMargin;
        drawHighlightIcon(r4, canvas, r5, r6);
        if (this.mLetters.get(r4).getType() != 2) goto L8;
        drawSymbol(r4, canvas, r5, r6);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        drawLetter(r4, canvas, r5, r6);
        goto L9
    L10:
        canvas.restore();
    }

    private void setLetterPaint(int index) {
        if (isTouchedLetter(index) == true) goto L5;
    L7:
        Paint r0 = this.mLetterPaint;
        if (isHolderState() == false) goto L10;
    L13:
        int r2 = this.mHasChosenLetterFontColor;
    L14:
        r0.setColor(r2);
        this.mLetterPaint.setFakeBoldText(false);
    L16:
        if (this.mLetters.get(index).getLetter().startsWith(".") == false) goto L18;
        return;
    L18:
        if (this.mLetters.get(index).getType() != 1) goto L20;
        this.mLetterPaint.setTextSize(this.mLetterLocaleFontSize);
        this.mLetterPaint.setFakeBoldText(true);
        return;
    L20:
        this.mLetterPaint.setTextSize(this.mLetterFontSize);
        return;
    L10:
        if (this.mSettled == false) goto L13;
        r2 = this.mNoChosenLetterFontColor;
        goto L14
    L5:
        if (this.mSettled == false) goto L7;
        this.mLetterPaint.setColor(-1);
        this.mLetterPaint.setFakeBoldText(true);
        goto L16
    }

    private void drawHighlightIcon(int index, Canvas canvas, float xPos, float yPos) {
        if (isTouchedLetter(index) == true) goto L5;
        return;
    L5:
        if (this.mSettled == false) goto L9;
        canvas.drawBitmap(this.mHighlightIcon, this.mHighlightIconStartX, yPos - (this.mHighlightIconHeight / 2), null);
        return;
    }

    private void drawSymbol(int index, Canvas canvas, float xPos, float yPos) {
        Bitmap[] r8 = this.mLetters.get(index).getLetterBitmaps();
        if (isTouchedLetter(index) == true) goto L5;
    L7:
        boolean r6 = false;
    L9:
        if (isHolderState() == false) goto L11;
    L14:
        boolean r2 = true;
    L16:
        if (r6 == false) goto L18;
        int r7 = r8[2].getHeight();
        canvas.drawBitmap(r8[2], this.mLetterFontCenterX - (r8[2].getWidth() / 2), yPos - (r7 / 2), null);
        return;
    L18:
        if (r2 == false) goto L20;
        int r9 = r8[1].getHeight();
        canvas.drawBitmap(r8[1], this.mLetterFontCenterX - (r8[1].getWidth() / 2), yPos - (r9 / 2), null);
        return;
    L20:
        int r10 = r8[0].getHeight();
        canvas.drawBitmap(r8[0], this.mLetterFontCenterX - (r8[0].getWidth() / 2), yPos - (r10 / 2), null);
        return;
    L11:
        if (this.mSettled == false) goto L14;
        r2 = false;
        goto L16
    L5:
        if (this.mSettled == false) goto L7;
        r6 = true;
        goto L9
    }

    private void drawLetter(int index, Canvas canvas, float xPos, float yPos) {
        String r0 = this.mLetters.get(index).getLetter();
        if (r0.startsWith(".") == false) goto L5;
        drawDot(index, canvas, xPos, yPos);
        return;
    L5:
        Paint.FontMetricsInt r4 = this.mLetterPaint.getFontMetricsInt();
        canvas.drawText(r0, xPos, (yPos - ((r4.bottom - r4.top) / 2)) - r4.top, this.mLetterPaint);
    }

    private void drawDot(int index, Canvas canvas, float xPos, float yPos) {
        canvas.drawBitmap(this.mDotIcon, this.mDotIconX, yPos - (this.mDotIcon.getHeight() / 2), null);
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

    private float getSingleLetterHeight(int totalHeight, ArrayList<Integer> visibleLetters) {
        return Math.max(totalHeight / visibleLetters.size(), this.mSingleLetterMinHeight);
    }

    private ArrayList<Integer> calculateVisibleLettersIndexes() {
        ArrayList<Integer> r0 = new ArrayList();
        if ((this.mLetterBarHeight / this.mLetters.size()) >= this.mSingleLetterMinHeight) goto L5;
        int r1 = Math.max(2, ((int) Math.ceil(this.mLetters.size() / ((this.mLetterBarHeight / this.mSingleLetterMinHeight) - 2))) * 2);
    L6:
        r0.add(0);
        if (r1 >= (this.mLetters.size() / 2)) goto L13;
        int r2 = r1;
    L10:
        if (r2 >= (this.mLetters.size() - 1)) goto L13;
        r0.add(Integer.valueOf(r2));
        r2 = r2 + r1;
    L13:
        if (r1 >= this.mLetters.size()) goto L15;
        r0.add(Integer.valueOf(this.mLetters.size() - 1));
    L15:
        return r0;
    L5:
        r1 = 1;
        goto L6
    }

    private boolean isHolderState() {
        if (this.mChosenLetterIndex == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isTouchedLetter(int index) {
        if (this.mChosenLetterIndex != index) goto L5;
        return true;
    L5:
        return false;
    }

    private void setTouchedLetter(int index) {
        this.mChosenLetterIndex = index;
        invalidate();
    }
}
