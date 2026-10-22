package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementationsKt;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public abstract class Random {
    public static final Default b = null;
    public static final Random c = null;

    @Metadata
    public static final class Default extends Random implements Serializable {

        @Metadata
        public static final class Serialized implements Serializable {
        }

        @Override // kotlin.random.Random
        public final int a(int r1) {
            return Random.c.a(r1);
        }

        @Override // kotlin.random.Random
        public final int b() {
            return Random.c.b();
        }
    }

    static {
        b = new Default();
        c = PlatformImplementationsKt.f340a.b();
    }

    public Random() {
    }

    public abstract int a(int r1);

    public int b() {
        return a(32);
    }
}
