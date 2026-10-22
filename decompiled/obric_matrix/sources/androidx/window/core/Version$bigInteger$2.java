package androidx.window.core;

import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.n0.c.a;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class Version$bigInteger$2 extends q implements a<BigInteger> {
    final /* synthetic */ Version this$0;

    Version$bigInteger$2(Version r1) {
        this.this$0 = r1;
        super(0);
    }

    @Override // kotlin.n0.c.a
    public /* bridge */ /* synthetic */ BigInteger invoke() {
        return invoke2();
    }

    @Override // kotlin.n0.c.a
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final BigInteger invoke2() {
        return BigInteger.valueOf(this.this$0.getMajor()).shiftLeft(32).or(BigInteger.valueOf(this.this$0.getMinor())).shiftLeft(32).or(BigInteger.valueOf(this.this$0.getPatch()));
    }
}
