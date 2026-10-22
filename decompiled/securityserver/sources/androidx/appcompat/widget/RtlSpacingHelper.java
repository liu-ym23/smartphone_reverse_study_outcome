package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mEnd;
    private int mExplicitLeft;
    private int mExplicitRight;
    private boolean mIsRelative;
    private boolean mIsRtl;
    private int mLeft;
    private int mRight;
    private int mStart;

    public RtlSpacingHelper() {
        this.mLeft = 0;
        this.mRight = 0;
        this.mStart = Integer.MIN_VALUE;
        this.mEnd = Integer.MIN_VALUE;
        this.mExplicitLeft = 0;
        this.mExplicitRight = 0;
        this.mIsRtl = false;
        this.mIsRelative = false;
    }

    public int getEnd() {
        if (this.mIsRtl == false) goto L6;
        return this.mLeft;
    L6:
        return this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        if (this.mIsRtl == false) goto L6;
        return this.mRight;
    L6:
        return this.mLeft;
    }

    public void setAbsolute(int r2, int r3) {
        this.mIsRelative = false;
        if (r2 == Integer.MIN_VALUE) goto L5;
        this.mExplicitLeft = r2;
        this.mLeft = r2;
    L5:
        if (r3 == Integer.MIN_VALUE) goto L8;
        this.mExplicitRight = r3;
        this.mRight = r3;
        return;
    }

    public void setDirection(boolean r2) {
        if (r2 != this.mIsRtl) goto L5;
        return;
    L5:
        this.mIsRtl = r2;
        if (this.mIsRelative == true) goto L8;
        this.mLeft = this.mExplicitLeft;
        this.mRight = this.mExplicitRight;
        return;
    L8:
        if (r2 == false) goto L18;
        int r3 = this.mEnd;
        if (r3 != Integer.MIN_VALUE) goto L13;
        r3 = this.mExplicitLeft;
    L13:
        this.mLeft = r3;
        int r4 = this.mStart;
        if (r4 != Integer.MIN_VALUE) goto L17;
        r4 = this.mExplicitRight;
    L17:
        this.mRight = r4;
        return;
    L18:
        int r5 = this.mStart;
        if (r5 != Integer.MIN_VALUE) goto L22;
        r5 = this.mExplicitLeft;
    L22:
        this.mLeft = r5;
        int r6 = this.mEnd;
        if (r6 != Integer.MIN_VALUE) goto L26;
        r6 = this.mExplicitRight;
    L26:
        this.mRight = r6;
    }

    public void setRelative(int r3, int r4) {
        this.mStart = r3;
        this.mEnd = r4;
        this.mIsRelative = true;
        if (this.mIsRtl == false) goto L8;
        if (r4 == Integer.MIN_VALUE) goto L6;
        this.mLeft = r4;
    L6:
        if (r3 == Integer.MIN_VALUE) goto L13;
        this.mRight = r3;
        return;
    L13:
        return;
    L8:
        if (r3 == Integer.MIN_VALUE) goto L10;
        this.mLeft = r3;
    L10:
        if (r4 == Integer.MIN_VALUE) goto L15;
        this.mRight = r4;
        return;
    }
}
