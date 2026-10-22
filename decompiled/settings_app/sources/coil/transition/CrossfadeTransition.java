package coil.transition;

import android.graphics.drawable.Drawable;
import android.icu.text.PluralRules;
import coil.decode.DataSource;
import coil.drawable.CrossfadeDrawable;
import coil.request.ErrorResult;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.size.Scale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CrossfadeTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcoil/transition/CrossfadeTransition;", "Lcoil/transition/Transition;", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "durationMillis", "", "preferExactIntrinsicSize", "", "(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;IZ)V", "getDurationMillis", "()I", "getPreferExactIntrinsicSize", "()Z", "transition", "", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CrossfadeTransition implements Transition {
    private final int durationMillis;
    private final boolean preferExactIntrinsicSize;
    private final ImageResult result;
    private final TransitionTarget target;

    /* JADX INFO: compiled from: CrossfadeTransition.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcoil/transition/CrossfadeTransition$Factory;", "Lcoil/transition/Transition$Factory;", "durationMillis", "", "preferExactIntrinsicSize", "", "(IZ)V", "getDurationMillis", "()I", "getPreferExactIntrinsicSize", "()Z", "create", "Lcoil/transition/Transition;", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "equals", PluralRules.KEYWORD_OTHER, "", "hashCode", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements Transition.Factory {
        private final int durationMillis;
        private final boolean preferExactIntrinsicSize;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory() {
            int r2 = 0;
            Object[] r3 = 0 == true ? 1 : 0;
            this(r2, r3, 3, null);
        }

        public Factory(int r4) {
            boolean r2 = false;
            this(r4, r2, 2, null);
        }

        public Factory(int r1, boolean r2) {
            this.durationMillis = r1;
            this.preferExactIntrinsicSize = r2;
            if (r1 <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("durationMillis must be > 0.".toString());
        L5:
            r0 = false;
            goto L6
        }

        public /* synthetic */ Factory(int r1, boolean r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = 100;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = false;
        L8:
            this(r1, r2);
        }

        public final int getDurationMillis() {
            return this.durationMillis;
        }

        public final boolean getPreferExactIntrinsicSize() {
            return this.preferExactIntrinsicSize;
        }

        @Override // coil.transition.Transition.Factory
        public Transition create(TransitionTarget r3, ImageResult r4) {
            if ((r4 instanceof SuccessResult) == true) goto L7;
            return Transition.Factory.NONE.create(r3, r4);
        L7:
            if (((SuccessResult) r4).getDataSource() != DataSource.MEMORY_CACHE) goto L11;
            return Transition.Factory.NONE.create(r3, r4);
        L11:
            return new CrossfadeTransition(r3, r4, this.durationMillis, this.preferExactIntrinsicSize);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Factory) == false) goto L12;
            Factory r5 = (Factory) r4;
            if (this.durationMillis != r5.durationMillis) goto L12;
            if (this.preferExactIntrinsicSize != r5.preferExactIntrinsicSize) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (this.durationMillis * 31) + Boolean.hashCode(this.preferExactIntrinsicSize);
        }
    }

    public CrossfadeTransition(TransitionTarget r8, ImageResult r9) {
        this(r8, r9, 0, false, 12, null);
    }

    public CrossfadeTransition(TransitionTarget r8, ImageResult r9, int r10) {
        this(r8, r9, r10, false, 8, null);
    }

    public CrossfadeTransition(TransitionTarget r1, ImageResult r2, int r3, boolean r4) {
        this.target = r1;
        this.result = r2;
        this.durationMillis = r3;
        this.preferExactIntrinsicSize = r4;
        if (r3 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("durationMillis must be > 0.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public /* synthetic */ CrossfadeTransition(TransitionTarget r1, ImageResult r2, int r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = 100;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = false;
    L8:
        this(r1, r2, r3, r4);
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    @Override // coil.transition.Transition
    public void transition() {
        Drawable r1 = this.target.getDrawable();
        Drawable r2 = this.result.getDrawable();
        Scale r3 = this.result.getRequest().getScale();
        int r4 = this.durationMillis;
        ImageResult r0 = this.result;
        if ((r0 instanceof SuccessResult) == true) goto L5;
    L8:
        boolean r5 = true;
    L9:
        CrossfadeDrawable r7 = new CrossfadeDrawable(r1, r2, r3, r4, r5, this.preferExactIntrinsicSize);
        ImageResult r6 = this.result;
        if ((r6 instanceof SuccessResult) == false) goto L13;
        this.target.onSuccess(r7);
        return;
    L13:
        if ((r6 instanceof ErrorResult) == false) goto L17;
        this.target.onError(r7);
        return;
    L17:
        return;
    L5:
        if (((SuccessResult) r0).isPlaceholderCached() == false) goto L8;
        r5 = false;
        goto L9
    }
}
