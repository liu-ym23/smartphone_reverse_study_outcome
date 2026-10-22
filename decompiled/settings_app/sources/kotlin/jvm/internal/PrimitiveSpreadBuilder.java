package kotlin.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: PrimitiveSpreadBuilders.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0004H\u0004J\u001d\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0004*\u00028\u0000H$¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0082\u0004¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "", PerfConsts.PERF_DISK_FILE_SIZE, "", "(I)V", "position", "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", PowerUsageDetail.EXTRA_DETAIL_VALUES, "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PrimitiveSpreadBuilder<T> {
    private int position;
    private final int size;
    private final T[] spreads;

    private static /* synthetic */ void getSpreads$annotations() {
    }

    protected abstract int getSize(T r1);

    public PrimitiveSpreadBuilder(int r1) {
        this.size = r1;
        this.spreads = (T[]) new Object[r1];
    }

    protected final int getPosition() {
        return this.position;
    }

    protected final void setPosition(int r1) {
        this.position = r1;
    }

    public final void addSpread(T r4) {
        Intrinsics.checkNotNullParameter(r4, "spreadArgument");
        T[] r0 = this.spreads;
        int r1 = this.position;
        this.position = r1 + 1;
        r0[r1] = r4;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.IntIterator] */
    protected final int size() {
        int r3 = 0;
        ?? r0 = new IntRange(0, this.size - 1).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        T r1 = this.spreads[r0.nextInt()];
        if (r1 == null) goto L8;
        int r2 = getSize(r1);
    L9:
        r3 = r3 + r2;
        goto L4
    L8:
        r2 = 1;
        goto L9
    L10:
        return r3;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.collections.IntIterator] */
    protected final T toArray(T r8, T r9) {
        Intrinsics.checkNotNullParameter(r8, PowerUsageDetail.EXTRA_DETAIL_VALUES);
        Intrinsics.checkNotNullParameter(r9, "result");
        ?? r0 = new IntRange(0, this.size - 1).iterator();
        int r1 = 0;
        int r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L10;
        int r4 = r0.nextInt();
        T r5 = this.spreads[r4];
        if (r5 == null) goto L4;
        if (r1 >= r4) goto L9;
        int r6 = r4 - r1;
        System.arraycopy(r8, r1, r9, r3, r6);
        r3 = r3 + r6;
    L9:
        int r2 = getSize(r5);
        System.arraycopy(r5, 0, r9, r3, r2);
        r3 = r3 + r2;
        r1 = r4 + 1;
        goto L4
    L10:
        int r7 = this.size;
        if (r1 >= r7) goto L13;
        System.arraycopy(r8, r1, r9, r3, r7 - r1);
    L13:
        return r9;
    }
}
