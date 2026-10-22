package androidx.core.util;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresApi;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.n;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a3\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\u0087\bø\u0001\u0000\u001a\u0014\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "writeBytes", "array", "writeText", "text", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
public final class AtomicFileKt {
    @RequiresApi(17)
    public static final byte[] readBytes(android.util.AtomicFile r1) {
        o.f(r1, "<this>");
        byte[] r2 = r1.readFully();
        o.e(r2, "readFully()");
        return r2;
    }

    @RequiresApi(17)
    public static final String readText(android.util.AtomicFile r1, Charset r2) {
        o.f(r1, "<this>");
        o.f(r2, "charset");
        byte[] r3 = r1.readFully();
        o.e(r3, "readFully()");
        return new String(r3, r2);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = kotlin.u0.d.f21429a;
    L6:
        return readText(r0, r1);
    }

    @RequiresApi(17)
    public static final void tryWrite(android.util.AtomicFile r3, l<? super FileOutputStream, f0> r4) {
        o.f(r3, "<this>");
        o.f(r4, "block");
        FileOutputStream r0 = r3.startWrite();
        o.e(r0, "stream");     // Catch: Throwable -> L6
        r4.invoke(r0);     // Catch: Throwable -> L6
        n.b(1);
        r3.finishWrite(r0);
        n.a(1);
        return;
    L6:
        th = move-exception;
        n.b(1);
        r3.failWrite(r0);
        n.a(1);
        throw th;
    }

    @RequiresApi(17)
    public static final void writeBytes(android.util.AtomicFile r2, byte[] r3) {
        o.f(r2, "<this>");
        o.f(r3, "array");
        FileOutputStream r0 = r2.startWrite();
        o.e(r0, "stream");     // Catch: Throwable -> L6
        r0.write(r3);     // Catch: Throwable -> L6
        r2.finishWrite(r0);
        return;
    L6:
        th = move-exception;
        r2.failWrite(r0);
        throw th;
    }

    @RequiresApi(17)
    public static final void writeText(android.util.AtomicFile r1, String r2, Charset r3) {
        o.f(r1, "<this>");
        o.f(r2, "text");
        o.f(r3, "charset");
        byte[] r4 = r2.getBytes(r3);
        o.e(r4, "this as java.lang.String).getBytes(charset)");
        writeBytes(r1, r4);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile r0, String r1, Charset r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = kotlin.u0.d.f21429a;
    L5:
        writeText(r0, r1, r2);
    }
}
