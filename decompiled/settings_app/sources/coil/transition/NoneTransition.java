package coil.transition;

import android.icu.text.PluralRules;
import coil.request.ErrorResult;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import kotlin.Metadata;

/* JADX INFO: compiled from: NoneTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcoil/transition/NoneTransition;", "Lcoil/transition/Transition;", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;)V", "transition", "", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NoneTransition implements Transition {
    private final ImageResult result;
    private final TransitionTarget target;

    /* JADX INFO: compiled from: NoneTransition.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcoil/transition/NoneTransition$Factory;", "Lcoil/transition/Transition$Factory;", "()V", "create", "Lcoil/transition/Transition;", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements Transition.Factory {
        public Factory() {
        }

        @Override // coil.transition.Transition.Factory
        public Transition create(TransitionTarget r1, ImageResult r2) {
            return new NoneTransition(r1, r2);
        }

        public boolean equals(Object r1) {
            return r1 instanceof Factory;
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }

    public NoneTransition(TransitionTarget r1, ImageResult r2) {
        this.target = r1;
        this.result = r2;
    }

    @Override // coil.transition.Transition
    public void transition() {
        ImageResult r0 = this.result;
        if ((r0 instanceof SuccessResult) == false) goto L6;
        this.target.onSuccess(((SuccessResult) r0).getDrawable());
        return;
    L6:
        if ((r0 instanceof ErrorResult) == false) goto L10;
        this.target.onError(r0.getDrawable());
        return;
    }
}
