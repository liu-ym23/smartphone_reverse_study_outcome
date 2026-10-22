package androidx.slice.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.slice.view.R;

/* JADX INFO: loaded from: classes.dex */
public class SliceStyle {
    private int mGridBottomPadding;
    private int mGridSubtitleSize;
    private int mGridTitleSize;
    private int mGridTopPadding;
    private int mHeaderSubtitleSize;
    private int mHeaderTitleSize;
    private int mSubtitleColor;
    private int mSubtitleSize;
    private int mTintColor;
    private int mTitleColor;
    private int mTitleSize;
    private int mVerticalGridTextPadding;
    private int mVerticalHeaderTextPadding;
    private int mVerticalTextPadding;

    public SliceStyle(Context r4, AttributeSet r5, int r6, int r7) {
        this.mTintColor = -1;
        TypedArray r8 = r4.getTheme().obtainStyledAttributes(r5, R.styleable.SliceView, r6, r7);
        int r9 = r8.getColor(R.styleable.SliceView_tintColor, -1);     // Catch: Throwable -> L10
        if (r9 != (-1)) goto L7;
        r9 = this.mTintColor;     // Catch: Throwable -> L10
    L7:
        this.mTintColor = r9;     // Catch: Throwable -> L10
        this.mTitleColor = r8.getColor(R.styleable.SliceView_titleColor, 0);     // Catch: Throwable -> L10
        this.mSubtitleColor = r8.getColor(R.styleable.SliceView_subtitleColor, 0);     // Catch: Throwable -> L10
        this.mHeaderTitleSize = (int) r8.getDimension(R.styleable.SliceView_headerTitleSize, 0.0f);     // Catch: Throwable -> L10
        this.mHeaderSubtitleSize = (int) r8.getDimension(R.styleable.SliceView_headerSubtitleSize, 0.0f);     // Catch: Throwable -> L10
        this.mVerticalHeaderTextPadding = (int) r8.getDimension(R.styleable.SliceView_headerTextVerticalPadding, 0.0f);     // Catch: Throwable -> L10
        this.mTitleSize = (int) r8.getDimension(R.styleable.SliceView_titleSize, 0.0f);     // Catch: Throwable -> L10
        this.mSubtitleSize = (int) r8.getDimension(R.styleable.SliceView_subtitleSize, 0.0f);     // Catch: Throwable -> L10
        this.mVerticalTextPadding = (int) r8.getDimension(R.styleable.SliceView_textVerticalPadding, 0.0f);     // Catch: Throwable -> L10
        this.mGridTitleSize = (int) r8.getDimension(R.styleable.SliceView_gridTitleSize, 0.0f);     // Catch: Throwable -> L10
        this.mGridSubtitleSize = (int) r8.getDimension(R.styleable.SliceView_gridSubtitleSize, 0.0f);     // Catch: Throwable -> L10
        this.mVerticalGridTextPadding = (int) r8.getDimension(R.styleable.SliceView_gridTextVerticalPadding, r4.getResources().getDimensionPixelSize(R.dimen.abc_slice_grid_text_inner_padding));     // Catch: Throwable -> L10
        this.mGridTopPadding = (int) r8.getDimension(R.styleable.SliceView_gridTopPadding, 0.0f);     // Catch: Throwable -> L10
        this.mGridBottomPadding = (int) r8.getDimension(R.styleable.SliceView_gridBottomPadding, 0.0f);     // Catch: Throwable -> L10
        r8.recycle();
        return;
    L10:
        th = move-exception;
        r8.recycle();
        throw th;
    }

    public void setTintColor(int r1) {
        this.mTintColor = r1;
    }

    public int getTintColor() {
        return this.mTintColor;
    }

    public int getTitleColor() {
        return this.mTitleColor;
    }

    public int getSubtitleColor() {
        return this.mSubtitleColor;
    }

    public int getHeaderTitleSize() {
        return this.mHeaderTitleSize;
    }

    public int getHeaderSubtitleSize() {
        return this.mHeaderSubtitleSize;
    }

    public int getVerticalHeaderTextPadding() {
        return this.mVerticalHeaderTextPadding;
    }

    public int getTitleSize() {
        return this.mTitleSize;
    }

    public int getSubtitleSize() {
        return this.mSubtitleSize;
    }

    public int getVerticalTextPadding() {
        return this.mVerticalTextPadding;
    }

    public int getGridTitleSize() {
        return this.mGridTitleSize;
    }

    public int getGridSubtitleSize() {
        return this.mGridSubtitleSize;
    }

    public int getVerticalGridTextPadding() {
        return this.mVerticalGridTextPadding;
    }

    public int getGridTopPadding() {
        return this.mGridTopPadding;
    }

    public int getGridBottomPadding() {
        return this.mGridBottomPadding;
    }
}
