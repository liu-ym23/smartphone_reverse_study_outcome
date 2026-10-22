package coil.size;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: ViewSizeResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J\u0011\u0010\u0015\u001a\u00020\u0013H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lcoil/size/ViewSizeResolver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Lcoil/size/SizeResolver;", "subtractPadding", "", "getSubtractPadding", "()Z", "view", "getView", "()Landroid/view/View;", "getDimension", "Lcoil/size/Dimension;", "paramSize", "", "viewSize", "paddingSize", "getHeight", "getSize", "Lcoil/size/Size;", "getWidth", PerfConsts.PERF_DISK_FILE_SIZE, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removePreDrawListenerSafe", "", "Landroid/view/ViewTreeObserver;", "victim", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ViewSizeResolver<T extends View> extends SizeResolver {

    /* JADX INFO: compiled from: ViewSizeResolver.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T extends View> boolean getSubtractPadding(ViewSizeResolver<T> r0) {
            return ViewSizeResolver.access$getSubtractPadding$jd(r0);
        }

        @Deprecated
        public static <T extends View> Object size(ViewSizeResolver<T> r0, Continuation<? super Size> r1) {
            return ViewSizeResolver.access$size$jd(r0, r1);
        }
    }

    default boolean getSubtractPadding() {
        return true;
    }

    T getView();

    @Override // coil.size.SizeResolver
    default Object size(Continuation<? super Size> r1) {
        return size$suspendImpl(this, r1);
    }

    static /* synthetic */ Size access$getSize(ViewSizeResolver r0) {
        return r0.getSize();
    }

    static /* synthetic */ boolean access$getSubtractPadding$jd(ViewSizeResolver r0) {
        return super.getSubtractPadding();
    }

    static /* synthetic */ void access$removePreDrawListenerSafe(ViewSizeResolver r0, ViewTreeObserver r1, ViewTreeObserver.OnPreDrawListener r2) {
        r0.removePreDrawListenerSafe(r1, r2);
    }

    static /* synthetic */ Object access$size$jd(ViewSizeResolver r0, Continuation r1) {
        return super.size(r1);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [coil.size.ViewSizeResolver$size$3$preDrawListener$1] */
    static /* synthetic */ <T extends View> Object size$suspendImpl(final ViewSizeResolver<T> r5, Continuation<? super Size> r6) {
        Size r0 = r5.getSize();
        if (r0 == null) goto L5;
        return r0;
    L5:
        CancellableContinuationImpl r1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r6), 1);
        r1.initCancellability();
        final CancellableContinuationImpl r2 = r1;
        final ViewTreeObserver r3 = r5.getView().getViewTreeObserver();
        final ?? r4 = new ViewSizeResolver$size$3$preDrawListener$1(r5, r3, r2);
        r3.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) r4);
        r2.invokeOnCancellation(new ViewSizeResolver$size$3$1(r5, r3, r4));
        Object r7 = r1.getResult();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L8:
        return r7;
    }

    private default Size getSize() {
        Dimension r0 = getWidth();
        if (r0 != null) goto L5;
        return null;
    L5:
        Dimension r2 = getHeight();
        if (r2 != null) goto L9;
        return null;
    L9:
        return new Size(r0, r2);
    }

    private default Dimension getWidth() {
        ViewGroup.LayoutParams r0 = getView().getLayoutParams();
        if (r0 == null) goto L5;
        int r1 = r0.width;
    L6:
        int r2 = getView().getWidth();
        if (getSubtractPadding() == false) goto L9;
        int r3 = getView().getPaddingLeft() + getView().getPaddingRight();
    L11:
        return getDimension(r1, r2, r3);
    L9:
        r3 = 0;
        goto L11
    L5:
        r1 = -1;
        goto L6
    }

    private default Dimension getHeight() {
        ViewGroup.LayoutParams r0 = getView().getLayoutParams();
        if (r0 == null) goto L5;
        int r1 = r0.height;
    L6:
        int r2 = getView().getHeight();
        if (getSubtractPadding() == false) goto L9;
        int r3 = getView().getPaddingTop() + getView().getPaddingBottom();
    L11:
        return getDimension(r1, r2, r3);
    L9:
        r3 = 0;
        goto L11
    L5:
        r1 = -1;
        goto L6
    }

    private default Dimension getDimension(int r1, int r2, int r3) {
        if (r1 == (-2)) goto L5;
        int r4 = r1 - r3;
        if (r4 > 0) goto L9;
        int r5 = r2 - r3;
        if (r5 > 0) goto L13;
        return null;
    L13:
        return Dimensions.Dimension(r5);
    L9:
        return Dimensions.Dimension(r4);
    L5:
        return Dimension.Undefined.INSTANCE;
    }

    private default void removePreDrawListenerSafe(ViewTreeObserver r2, ViewTreeObserver.OnPreDrawListener r3) {
        if (r2.isAlive() == false) goto L5;
        r2.removeOnPreDrawListener(r3);
        return;
    L5:
        getView().getViewTreeObserver().removeOnPreDrawListener(r3);
    }
}
