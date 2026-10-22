package coil.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import coil.target.Target;
import kotlin.Metadata;

/* JADX INFO: compiled from: TransitionTarget.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcoil/transition/TransitionTarget;", "Lcoil/target/Target;", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TransitionTarget extends Target {

    /* JADX INFO: compiled from: TransitionTarget.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void onError(TransitionTarget r0, Drawable r1) {
            TransitionTarget.access$onError$jd(r0, r1);
        }

        @Deprecated
        public static void onStart(TransitionTarget r0, Drawable r1) {
            TransitionTarget.access$onStart$jd(r0, r1);
        }

        @Deprecated
        public static void onSuccess(TransitionTarget r0, Drawable r1) {
            TransitionTarget.access$onSuccess$jd(r0, r1);
        }
    }

    Drawable getDrawable();

    View getView();

    static /* synthetic */ void access$onError$jd(TransitionTarget r0, Drawable r1) {
        super.onError(r1);
    }

    static /* synthetic */ void access$onStart$jd(TransitionTarget r0, Drawable r1) {
        super.onStart(r1);
    }

    static /* synthetic */ void access$onSuccess$jd(TransitionTarget r0, Drawable r1) {
        super.onSuccess(r1);
    }
}
