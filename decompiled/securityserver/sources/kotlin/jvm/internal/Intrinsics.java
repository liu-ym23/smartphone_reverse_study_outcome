package kotlin.jvm.internal;

import a.a;
import com.bytedance.librarian.LibrarianImpl;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.SinceKotlin;
import kotlin.UninitializedPropertyAccessException;

/* JADX INFO: loaded from: classes2.dex */
public class Intrinsics {

    @SinceKotlin
    public static class Kotlin {
    }

    public static boolean a(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    public static void b(Object r1, String r2) {
        if (r1 == null) goto L4;
        return;
    L4:
        IllegalStateException r3 = new IllegalStateException(r2.concat(" must not be null"));
        j(r3, Intrinsics.class.getName());
        throw r3;
    }

    public static void c(Object r1) {
        if (r1 == null) goto L4;
        return;
    L4:
        NullPointerException r2 = new NullPointerException();
        j(r2, Intrinsics.class.getName());
        throw r2;
    }

    public static void d(Object r0, String r1) {
        if (r0 == null) goto L4;
        return;
    L4:
        NullPointerException r2 = new NullPointerException(r1);
        j(r2, Intrinsics.class.getName());
        throw r2;
    }

    public static void e(Object r1, String r2) {
        if (r1 == null) goto L4;
        return;
    L4:
        NullPointerException r3 = new NullPointerException(r2.concat(" must not be null"));
        j(r3, Intrinsics.class.getName());
        throw r3;
    }

    public static void f(Object r0, String r1) {
        if (r0 == null) goto L4;
        return;
    L4:
        NullPointerException r2 = new NullPointerException(i(r1));
        j(r2, Intrinsics.class.getName());
        throw r2;
    }

    public static void g(Object r0, String r1) {
        if (r0 == null) goto L4;
        return;
    L4:
        IllegalArgumentException r2 = new IllegalArgumentException(i(r1));
        j(r2, Intrinsics.class.getName());
        throw r2;
    }

    public static int h(int r0, int r1) {
        if (r0 >= r1) goto L4;
        return -1;
    L4:
        if (r0 != r1) goto L6;
        return 0;
    L6:
        return 1;
    }

    public static String i(String r4) {
        StackTraceElement r0 = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + r0.getClassName() + LibrarianImpl.Constants.DOT + r0.getMethodName() + ", parameter " + r4;
    }

    public static void j(RuntimeException r5, String r6) {
        StackTraceElement[] r0 = r5.getStackTrace();
        int r1 = r0.length;
        int r2 = -1;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (r6.equals(r0[r3].getClassName()) == false) goto L7;
        r2 = r3;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        r5.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r0, r2 + 1, r1));
    }

    public static void k() {
        KotlinNullPointerException r0 = new KotlinNullPointerException();
        j(r0, Intrinsics.class.getName());
        throw r0;
    }

    public static void l() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void m(String r2) {
        UninitializedPropertyAccessException r0 = new UninitializedPropertyAccessException(a.k("lateinit property ", r2, " has not been initialized"));
        j(r0, Intrinsics.class.getName());
        throw r0;
    }
}
