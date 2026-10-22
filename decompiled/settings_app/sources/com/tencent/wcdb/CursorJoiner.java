package com.tencent.wcdb;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class CursorJoiner implements Iterator<Result>, Iterable<Result> {
    private int[] mColumnsLeft;
    private int[] mColumnsRight;
    private Result mCompareResult;
    private boolean mCompareResultIsValid;
    private Cursor mCursorLeft;
    private Cursor mCursorRight;
    private String[] mValues;

    /* JADX INFO: renamed from: com.tencent.wcdb.CursorJoiner$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$wcdb$CursorJoiner$Result = null;

        static {
            int[] r0 = new int[Result.values().length];
            $SwitchMap$com$tencent$wcdb$CursorJoiner$Result = r0;
            r0[Result.BOTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$tencent$wcdb$CursorJoiner$Result[Result.LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$tencent$wcdb$CursorJoiner$Result[Result.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum Result extends Enum<Result> {
        private static final /* synthetic */ Result[] $VALUES = null;
        public static final Result BOTH = null;
        public static final Result LEFT = null;
        public static final Result RIGHT = null;

        private Result(String r1, int r2) {
            super(r1, r2);
        }

        public static Result valueOf(String r1) {
            return (Result) Enum.valueOf(Result.class, r1);
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }

        static {
            Result r0 = new Result("RIGHT", 0);
            RIGHT = r0;
            Result r1 = new Result("LEFT", 1);
            LEFT = r1;
            Result r3 = new Result("BOTH", 2);
            BOTH = r3;
            $VALUES = new Result[]{r0, r1, r3};
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Result> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Result next() {
        return next();
    }

    public CursorJoiner(Cursor r3, String[] r4, Cursor r5, String[] r6) {
        if (r4.length != r6.length) goto L7;
        this.mCursorLeft = r3;
        this.mCursorRight = r5;
        r3.moveToFirst();
        this.mCursorRight.moveToFirst();
        this.mCompareResultIsValid = false;
        this.mColumnsLeft = buildColumnIndiciesArray(r3, r4);
        this.mColumnsRight = buildColumnIndiciesArray(r5, r6);
        this.mValues = new String[this.mColumnsLeft.length * 2];
        return;
    L7:
        throw new IllegalArgumentException("you must have the same number of columns on the left and right, " + r4.length + " != " + r6.length);
    }

    private int[] buildColumnIndiciesArray(Cursor r3, String[] r4) {
        int[] r2 = new int[r4.length];
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r2[r0] = r3.getColumnIndexOrThrow(r4[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.mCompareResultIsValid == false) goto L31;
        int r0 = AnonymousClass1.$SwitchMap$com$tencent$wcdb$CursorJoiner$Result[this.mCompareResult.ordinal()];
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L19;
        if (r0 != 3) goto L17;
        if (this.mCursorLeft.isAfterLast() == false) goto L15;
        if (this.mCursorRight.isLast() == false) goto L15;
        return false;
    L15:
        return true;
    L17:
        throw new IllegalStateException("bad value for mCompareResult, " + this.mCompareResult);
    L19:
        if (this.mCursorLeft.isLast() == false) goto L23;
        if (this.mCursorRight.isAfterLast() == false) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (this.mCursorLeft.isLast() == false) goto L29;
        if (this.mCursorRight.isLast() == false) goto L29;
        return false;
    L29:
        return true;
    L31:
        if (this.mCursorLeft.isAfterLast() == false) goto L35;
        if (this.mCursorRight.isAfterLast() == false) goto L35;
        return false;
    L35:
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Result next() {
        if (hasNext() == false) goto L21;
        incrementCursors();
        boolean r0 = !this.mCursorLeft.isAfterLast();
        boolean r2 = !this.mCursorRight.isAfterLast();
        if (r0 == false) goto L15;
        if (r2 == false) goto L15;
        populateValues(this.mValues, this.mCursorLeft, this.mColumnsLeft, 0);
        populateValues(this.mValues, this.mCursorRight, this.mColumnsRight, 1);
        int r1 = compareStrings(this.mValues);
        if (r1 == (-1)) goto L14;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L18;
        this.mCompareResult = Result.RIGHT;
    L18:
        this.mCompareResultIsValid = true;
        return this.mCompareResult;
    L13:
        this.mCompareResult = Result.BOTH;
        goto L18
    L14:
        this.mCompareResult = Result.LEFT;
    L15:
        if (r0 == false) goto L17;
        this.mCompareResult = Result.LEFT;
        goto L18
    L17:
        this.mCompareResult = Result.RIGHT;
        goto L18
    L21:
        throw new IllegalStateException("you must only call next() when hasNext() is true");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("not implemented");
    }

    private static void populateValues(String[] r3, Cursor r4, int[] r5, int r6) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L6;
        r3[(r0 * 2) + r6] = r4.getString(r5[r0]);
        r0 = r0 + 1;
        goto L4
    }

    private void incrementCursors() {
        if (this.mCompareResultIsValid == false) goto L16;
        int r0 = AnonymousClass1.$SwitchMap$com$tencent$wcdb$CursorJoiner$Result[this.mCompareResult.ordinal()];
        if (r0 != 1) goto L7;
        this.mCursorLeft.moveToNext();
        this.mCursorRight.moveToNext();
    L14:
        this.mCompareResultIsValid = false;
        return;
    L7:
        if (r0 != 2) goto L9;
        this.mCursorLeft.moveToNext();
        goto L14
    L9:
        if (r0 != 3) goto L14;
        this.mCursorRight.moveToNext();
        goto L14
    }

    private static int compareStrings(String... r6) {
        if ((r6.length % 2) != 0) goto L25;
        int r1 = 0;
    L6:
        if (r1 >= r6.length) goto L23;
        String r2 = r6[r1];
        if (r2 == null) goto L10;
        String r4 = r6[r1 + 1];
        if (r4 == null) goto L15;
        int r3 = r2.compareTo(r4);
        if (r3 == 0) goto L22;
        if (r3 >= 0) goto L21;
        return -1;
    L21:
        return 1;
    L22:
        r1 = r1 + 2;
        goto L6
    L15:
        return 1;
    L10:
        if (r6[r1 + 1] == null) goto L22;
        return -1;
    L23:
        return 0;
    L25:
        throw new IllegalArgumentException("you must specify an even number of values");
    }
}
