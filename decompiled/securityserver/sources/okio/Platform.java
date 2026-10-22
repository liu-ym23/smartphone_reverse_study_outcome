package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: okio.-Platform, reason: invalid class name */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class Platform {
    @NotNull
    public static final byte[] asUtf8ToByteArray(@NotNull String r1) {
        Intrinsics.f(r1, "$this$asUtf8ToByteArray");
        byte[] r2 = r1.getBytes(Charsets.f354a);
        Intrinsics.e(r2, "(this as java.lang.String).getBytes(charset)");
        return r2;
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m180synchronized(@NotNull Object r1, @NotNull Function0<? extends R> r2) {
        Intrinsics.f(r1, "lock");
        Intrinsics.f(r2, "block");
        monitor-enter(r1);
        R r3 = (R) r2.invoke();
        monitor-exit(r1);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    @NotNull
    public static final String toUtf8String(@NotNull byte[] r2) {
        Intrinsics.f(r2, "$this$toUtf8String");
        return new String(r2, Charsets.f354a);
    }
}
