package coil.util;

import coil.size.Dimension;
import coil.size.Size;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HardwareBitmaps.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcoil/util/LimitedFileDescriptorHardwareBitmapService;", "Lcoil/util/HardwareBitmapService;", "logger", "Lcoil/util/Logger;", "(Lcoil/util/Logger;)V", "allowHardwareMainThread", "", PerfConsts.PERF_DISK_FILE_SIZE, "Lcoil/size/Size;", "allowHardwareWorkerThread", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LimitedFileDescriptorHardwareBitmapService implements HardwareBitmapService {
    public static final Companion Companion = null;
    private static final int MIN_SIZE_DIMENSION = 100;
    private final Logger logger;

    /* JADX INFO: compiled from: HardwareBitmaps.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/util/LimitedFileDescriptorHardwareBitmapService$Companion;", "", "()V", "MIN_SIZE_DIMENSION", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LimitedFileDescriptorHardwareBitmapService(Logger r1) {
        this.logger = r1;
    }

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareMainThread(Size r3) {
        Dimension r2 = r3.getWidth();
        int r1 = Integer.MAX_VALUE;
        if ((r2 instanceof Dimension.Pixels) == false) goto L5;
        int r4 = ((Dimension.Pixels) r2).px;
    L7:
        if (r4 <= 100) goto L13;
        Dimension r5 = r3.getHeight();
        if ((r5 instanceof Dimension.Pixels) == false) goto L11;
        r1 = ((Dimension.Pixels) r5).px;
    L11:
        if (r1 <= 100) goto L13;
        return true;
    L13:
        return false;
    L5:
        r4 = Integer.MAX_VALUE;
        goto L7
    }

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareWorkerThread() {
        return FileDescriptorCounter.INSTANCE.hasAvailableFileDescriptors(this.logger);
    }
}
