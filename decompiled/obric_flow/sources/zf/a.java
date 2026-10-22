package zf;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f23427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f23428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageRequest f23429c;
    public final /* synthetic */ GenericDraweeHierarchy d;
    public final /* synthetic */ Drawable e;

    public a(Bitmap r5, long r10, ImageRequest r11, GenericDraweeHierarchy r12, Drawable r13) {
        this.f23427a = r5;
        this.f23428b = r10;
        this.f23429c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap r5 = this.f23427a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isRecycled() == true) goto L9;
        long r10 = SystemClock.uptimeMillis();
        long r11 = r10 - this.f23428b;
        ImageRequest r12 = this.f23429c;
        r12.setPreviewDecodeTime(r11);
        r12.setPreviewDecodeEnd(r10);
        Drawable r13 = this.e;
        ScalingUtils.ScaleType r14 = ScalingUtils.ScaleType.f7893a;
        this.d.a(r13, r14);
        return;
    }
}
