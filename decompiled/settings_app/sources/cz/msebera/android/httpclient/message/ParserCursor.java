package cz.msebera.android.httpclient.message;

/* JADX INFO: loaded from: classes5.dex */
public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int r1, int r2) {
        if (r1 < 0) goto L10;
        if (r1 > r2) goto L8;
        this.lowerBound = r1;
        this.upperBound = r2;
        this.pos = r1;
        return;
    L8:
        throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
    L10:
        throw new IndexOutOfBoundsException("Lower bound cannot be negative");
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public int getPos() {
        return this.pos;
    }

    public void updatePos(int r4) {
        if (r4 < this.lowerBound) goto L11;
        if (r4 > this.upperBound) goto L9;
        this.pos = r4;
        return;
    L9:
        throw new IndexOutOfBoundsException("pos: " + r4 + " > upperBound: " + this.upperBound);
    L11:
        throw new IndexOutOfBoundsException("pos: " + r4 + " < lowerBound: " + this.lowerBound);
    }

    public boolean atEnd() {
        if (this.pos < this.upperBound) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "[" + Integer.toString(this.lowerBound) + '>' + Integer.toString(this.pos) + '>' + Integer.toString(this.upperBound) + ']';
    }
}
