package coil.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import coil.ImageLoader;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.util.Bitmaps;
import coil.util.HardwareBitmapService;
import coil.util.HardwareBitmaps;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: RequestService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcoil/request/RequestService;", "", "imageLoader", "Lcoil/ImageLoader;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/util/SystemCallbacks;Lcoil/util/Logger;)V", "hardwareBitmapService", "Lcoil/util/HardwareBitmapService;", "allowHardwareWorkerThread", "", "options", "Lcoil/request/Options;", "errorResult", "Lcoil/request/ErrorResult;", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "throwable", "", "isConfigValidForHardware", "requestedConfig", "Landroid/graphics/Bitmap$Config;", "isConfigValidForHardwareAllocation", PerfConsts.PERF_DISK_FILE_SIZE, "Lcoil/size/Size;", "isConfigValidForTransformations", "requestDelegate", "Lcoil/request/RequestDelegate;", "initialRequest", "job", "Lkotlinx/coroutines/Job;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RequestService {
    private final HardwareBitmapService hardwareBitmapService;
    private final ImageLoader imageLoader;
    private final SystemCallbacks systemCallbacks;

    public RequestService(ImageLoader r1, SystemCallbacks r2, Logger r3) {
        this.imageLoader = r1;
        this.systemCallbacks = r2;
        this.hardwareBitmapService = HardwareBitmaps.HardwareBitmapService(r3);
    }

    public final RequestDelegate requestDelegate(ImageRequest r8, Job r9) {
        Lifecycle r4 = r8.getLifecycle();
        Target r0 = r8.getTarget();
        if ((r0 instanceof ViewTarget) == false) goto L6;
        return new ViewTargetRequestDelegate(this.imageLoader, r8, (ViewTarget) r0, r4, r9);
    L6:
        return new BaseRequestDelegate(r4, r9);
    }

    public final ErrorResult errorResult(ImageRequest r2, Throwable r3) {
        if ((r3 instanceof NullRequestDataException) == false) goto L7;
        Drawable r0 = r2.getFallback();
        if (r0 != null) goto L9;
        r0 = r2.getError();
    L9:
        return new ErrorResult(r0, r2, r3);
    L7:
        r0 = r2.getError();
        goto L9
    }

    public final Options options(ImageRequest r20, Size r21) {
        if (isConfigValidForTransformations(r20) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        Bitmap.Config r1 = r20.getBitmapConfig();
    L11:
        Bitmap.Config r5 = r1;
        if (this.systemCallbacks.isOnline() == false) goto L14;
        CachePolicy r2 = r20.getNetworkCachePolicy();
    L15:
        CachePolicy r18 = r2;
        if (Intrinsics.areEqual(r21.getWidth(), Dimension.Undefined.INSTANCE) == false) goto L18;
    L21:
        Scale r3 = Scale.FIT;
    L22:
        Scale r8 = r3;
        if (r20.getAllowRgb565() == true) goto L25;
    L29:
        boolean r10 = false;
    L31:
        return new Options(r20.getContext(), r5, r20.getColorSpace(), r21, r8, Requests.getAllowInexactSize(r20), r10, r20.getPremultipliedAlpha(), r20.getDiskCacheKey(), r20.getHeaders(), r20.getTags(), r20.getParameters(), r20.getMemoryCachePolicy(), r20.getDiskCachePolicy(), r18);
    L25:
        if (r20.getTransformations().isEmpty() == false) goto L29;
        if (r5 == Bitmap.Config.ALPHA_8) goto L29;
        r10 = true;
        goto L31
    L18:
        if (Intrinsics.areEqual(r21.getHeight(), Dimension.Undefined.INSTANCE) == true) goto L21;
        r3 = r20.getScale();
        goto L22
    L14:
        r2 = CachePolicy.DISABLED;
        goto L15
    L10:
        r1 = Bitmap.Config.ARGB_8888;
        goto L11
    L5:
        if (isConfigValidForHardwareAllocation(r20, r21) == false) goto L7;
        r0 = true;
        goto L8
    }

    public final boolean isConfigValidForHardware(ImageRequest r2, Bitmap.Config r3) {
        if (Bitmaps.isHardware(r3) == true) goto L6;
        return true;
    L6:
        if (r2.getAllowHardware() == true) goto L8;
        return false;
    L8:
        Target r1 = r2.getTarget();
        if ((r1 instanceof ViewTarget) == false) goto L18;
        View r4 = ((ViewTarget) r1).getView();
        if (r4.isAttachedToWindow() == true) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L18;
        return false;
    L13:
        if (r4.isHardwareAccelerated() == true) goto L15;
        r5 = true;
    L18:
        return true;
    }

    public final boolean allowHardwareWorkerThread(Options r1) {
        if (Bitmaps.isHardware(r1.getConfig()) == true) goto L5;
    L8:
        return true;
    L5:
        if (this.hardwareBitmapService.allowHardwareWorkerThread() == true) goto L8;
        return false;
    }

    private final boolean isConfigValidForHardwareAllocation(ImageRequest r3, Size r4) {
        if (Bitmaps.isHardware(r3.getBitmapConfig()) == true) goto L6;
        return true;
    L6:
        if (isConfigValidForHardware(r3, r3.getBitmapConfig()) == true) goto L8;
    L10:
        return false;
    L8:
        if (this.hardwareBitmapService.allowHardwareMainThread(r4) == false) goto L10;
        return true;
    }

    private final boolean isConfigValidForTransformations(ImageRequest r1) {
        if (r1.getTransformations().isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (ArraysKt.contains(Utils.getVALID_TRANSFORMATION_CONFIGS(), r1.getBitmapConfig()) == true) goto L8;
        return false;
    }
}
