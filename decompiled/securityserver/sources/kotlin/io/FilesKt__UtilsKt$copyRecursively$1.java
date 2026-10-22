package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class FilesKt__UtilsKt$copyRecursively$1 extends Lambda implements Function2 {
    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        IOException r3 = (IOException) r2;
        Intrinsics.f((File) r1, "<anonymous parameter 0>");
        Intrinsics.f(r3, "exception");
        throw r3;
    }
}
