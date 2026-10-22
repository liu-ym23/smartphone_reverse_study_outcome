package coil.target;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewTarget.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcoil/target/ViewTarget;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Lcoil/target/Target;", "view", "getView", "()Landroid/view/View;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ViewTarget<T extends View> extends Target {

    /* JADX INFO: compiled from: ViewTarget.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T extends View> void onError(ViewTarget<T> r0, Drawable r1) {
            ViewTarget.access$onError$jd(r0, r1);
        }

        @Deprecated
        public static <T extends View> void onStart(ViewTarget<T> r0, Drawable r1) {
            ViewTarget.access$onStart$jd(r0, r1);
        }

        @Deprecated
        public static <T extends View> void onSuccess(ViewTarget<T> r0, Drawable r1) {
            ViewTarget.access$onSuccess$jd(r0, r1);
        }
    }

    T getView();

    static /* synthetic */ void access$onError$jd(ViewTarget r0, Drawable r1) {
        super.onError(r1);
    }

    static /* synthetic */ void access$onStart$jd(ViewTarget r0, Drawable r1) {
        super.onStart(r1);
    }

    static /* synthetic */ void access$onSuccess$jd(ViewTarget r0, Drawable r1) {
        super.onSuccess(r1);
    }
}
