package okhttp3.internal.cache;

import com.bytedance.apm.battery.dao.DBHelper;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    @NotNull
    private final Function1<IOException, Unit> onException;

    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(@NotNull Sink r2, @NotNull Function1<? super IOException, Unit> r3) {
        Intrinsics.f(r2, "delegate");
        Intrinsics.f(r3, "onException");
        super(r2);
        this.onException = r3;
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors == false) goto L10;
        return;
    L10:
        super.close();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        this.hasErrors = true;
        this.onException.invoke(e);
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.hasErrors == false) goto L10;
        return;
    L10:
        super.flush();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        this.hasErrors = true;
        this.onException.invoke(e);
    }

    @NotNull
    public final Function1<IOException, Unit> getOnException() {
        return this.onException;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@NotNull Buffer r2, long r3) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        if (this.hasErrors == false) goto L11;
        r2.skip(r3);
        return;
    L11:
        super.write(r2, r3);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        this.hasErrors = true;
        this.onException.invoke(e);
    }
}
