package com.android.launcher3.util;

/* JADX INFO: loaded from: classes.dex */
public interface FlagOp {
    public static final FlagOp NO_OP = null;

    static /* synthetic */ int lambda$static$0(int r0) {
        return r0;
    }

    int apply(int r1);

    static {
        NO_OP = new FlagOp$$ExternalSyntheticLambda1();
    }

    static /* synthetic */ int lambda$addFlag$1(FlagOp _this, int r1, int r2) {
        return _this.apply(r2) | r1;
    }

    default FlagOp addFlag(final int r2) {
        return new FlagOp$$ExternalSyntheticLambda0(this, r2);
    }

    static /* synthetic */ int lambda$removeFlag$2(FlagOp _this, int r1, int r2) {
        return _this.apply(r2) & (~r1);
    }

    default FlagOp removeFlag(final int r2) {
        return new FlagOp$$ExternalSyntheticLambda2(this, r2);
    }

    default FlagOp setFlag(int r1, boolean r2) {
        if (r2 == false) goto L5;
        return addFlag(r1);
    L5:
        return removeFlag(r1);
    }
}
