package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes.dex */
public class MotionButton extends AppCompatButton {
    private Path mPath;
    RectF mRect;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;

    public MotionButton(Context r2) {
        super(r2);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r2, null);
    }

    public MotionButton(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r2, r3);
    }

    public MotionButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        init(r1, r2);
    }

    static /* synthetic */ float access$000(MotionButton r0) {
        return r0.mRoundPercent;
    }

    static /* synthetic */ float access$100(MotionButton r0) {
        return r0.mRound;
    }

    private void init(Context r7, AttributeSet r8) {
        int r9 = Build.VERSION.SDK_INT;
        int r0 = 0;
        setPadding(0, 0, 0, 0);
        if (r8 == null) goto L23;
        TypedArray r10 = getContext().obtainStyledAttributes(r8, R.styleable.ImageFilterView);
        int r1 = r10.getIndexCount();
    L5:
        if (r0 >= r1) goto L15;
        int r2 = r10.getIndex(r0);
        if (r2 != R.styleable.ImageFilterView_round) goto L11;
        if (r9 < 21) goto L14;
        setRound(r10.getDimension(r2, 0.0f));
    L14:
        r0 = r0 + 1;
        goto L5
    L11:
        if (r2 != R.styleable.ImageFilterView_roundPercent) goto L14;
        if (r9 < 21) goto L14;
        setRoundPercent(r10.getFloat(r2, 0.0f));
        goto L14
    L15:
        r10.recycle();
        return;
    }

    @Override // android.view.View
    public void draw(Canvas r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L9:
        boolean r0 = false;
    L10:
        super.draw(r3);
        if (r0 == false) goto L14;
        r3.restore();
        return;
    L14:
        return;
    L5:
        if (this.mRound == 0.0f) goto L9;
        if (this.mPath == null) goto L9;
        r0 = true;
        r3.save();
        r3.clipPath(this.mPath);
        goto L10
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    @RequiresApi(21)
    public void setRound(float r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (Float.isNaN(r7) == false) goto L7;
        this.mRound = r7;
        float r8 = this.mRoundPercent;
        this.mRoundPercent = -1.0f;
        setRoundPercent(r8);
        return;
    L7:
        if (this.mRound == r7) goto L9;
        boolean r1 = true;
    L10:
        this.mRound = r7;
        if (r7 != 0.0f) goto L13;
        if (r0 < 21) goto L26;
        setClipToOutline(false);
    L26:
        if (r1 == false) goto L30;
        if (r0 < 21) goto L31;
        invalidateOutline();
        return;
    L31:
        return;
    L30:
        return;
    L13:
        if (this.mPath != null) goto L16;
        this.mPath = new Path();
    L16:
        if (this.mRect != null) goto L18;
        this.mRect = new RectF();
    L18:
        if (r0 >= 21) goto L20;
    L23:
        this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
        this.mPath.reset();
        Path r9 = this.mPath;
        RectF r2 = this.mRect;
        float r3 = this.mRound;
        r9.addRoundRect(r2, r3, r3, Path.Direction.CW);
        goto L26
    L20:
        if (this.mViewOutlineProvider != null) goto L22;
        ViewOutlineProvider r10 = new AnonymousClass2(this);
        this.mViewOutlineProvider = r10;
        setOutlineProvider(r10);
    L22:
        setClipToOutline(true);
        goto L23
    L9:
        r1 = false;
        goto L10
    }

    @RequiresApi(21)
    public void setRoundPercent(float r8) {
        int r0 = Build.VERSION.SDK_INT;
        if (this.mRoundPercent == r8) goto L5;
        boolean r1 = true;
    L6:
        this.mRoundPercent = r8;
        if (r8 != 0.0f) goto L9;
        if (r0 < 21) goto L22;
        setClipToOutline(false);
    L22:
        if (r1 == false) goto L26;
        if (r0 < 21) goto L27;
        invalidateOutline();
        return;
    L27:
        return;
    L26:
        return;
    L9:
        if (this.mPath != null) goto L12;
        this.mPath = new Path();
    L12:
        if (this.mRect != null) goto L14;
        this.mRect = new RectF();
    L14:
        if (r0 >= 21) goto L16;
    L19:
        int r9 = getWidth();
        int r2 = getHeight();
        float r3 = (Math.min(r9, r2) * this.mRoundPercent) / 2.0f;
        this.mRect.set(0.0f, 0.0f, r9, r2);
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRect, r3, r3, Path.Direction.CW);
        goto L22
    L16:
        if (this.mViewOutlineProvider != null) goto L18;
        ViewOutlineProvider r10 = new AnonymousClass1(this);
        this.mViewOutlineProvider = r10;
        setOutlineProvider(r10);
    L18:
        setClipToOutline(true);
        goto L19
    L5:
        r1 = false;
        goto L6
    }
}
