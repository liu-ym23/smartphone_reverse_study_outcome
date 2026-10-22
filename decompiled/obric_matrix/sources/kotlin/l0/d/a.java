package kotlin.l0.d;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "getSuppressed", "", "sdkIsNullOrAtLeast", "", "version", "", "ReflectSdkVersion", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class a extends kotlin.l0.a {

    /* JADX INFO: renamed from: kotlin.l0.d.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion;", "", "()V", "sdkVersion", "", "Ljava/lang/Integer;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class C0477a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Integer f18423a = null;

        static {
            Integer r0 = null;
            Object r1 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);     // Catch: Throwable -> L17
            if ((r1 instanceof Integer) == false) goto L7;
            Integer r2 = (Integer) r1;     // Catch: Throwable -> L17
        L8:
            if (r2 != null) goto L10;
        L15:
            f18423a = r0;
            return;
        L10:
            if (r2.intValue() <= 0) goto L12;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L15;
            r0 = r2;
            goto L15
        L12:
            r3 = false;
        L7:
            r2 = null;
            goto L8
        }
    }

    public a() {
    }

    private final boolean c(int r1) {
        Integer r0 = C0477a.f18423a;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.intValue() >= r1) goto L8;
        return false;
    }

    @Override // kotlin.l0.a
    public void a(Throwable r2, Throwable r3) {
        o.f(r2, "cause");
        o.f(r3, "exception");
        if (c(19) == false) goto L5;
        r2.addSuppressed(r3);
        return;
    L5:
        super.a(r2, r3);
    }
}
