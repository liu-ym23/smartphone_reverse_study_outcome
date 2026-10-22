package zf;

import android.graphics.Bitmap;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.blurhash.BlurDecodeProducer;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements BlurDecodeProducer.BlurDecodeCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GenericDraweeHierarchy f23430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageRequest f23431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ScalingUtils.ScaleType f23432c;
    public final /* synthetic */ long d;
    public final /* synthetic */ BlurHashConfig e;
    public final /* synthetic */ String f;

    public e(GenericDraweeHierarchy r5, ImageRequest r10, ScalingUtils.ScaleType r11, long r12, BlurHashConfig r13, String r14) {
        this.f23430a = r5;
        this.f23431b = r10;
        this.f23432c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // com.facebook.imagepipeline.blurhash.BlurDecodeProducer.BlurDecodeCallBack
    public final void a(Bitmap r11) {
        BlurHashConfig r5 = this.e;
        int r10 = r5.getTargetWidth();
        int r12 = r5.getTargetHeight();
        String r13 = this.f;
        h.b(r11, this.f23430a, this.f23431b, this.f23432c, this.d, r10, r12, r13);
    }
}
