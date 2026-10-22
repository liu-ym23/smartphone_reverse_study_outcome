package kotlin.q0;

import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00122\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0012B\u0017\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B7\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "seed1", "", "seed2", "(II)V", "x", "y", "z", "w", BaseSwitches.V, "addend", "(IIIIII)V", "nextBits", "bitCount", "nextInt", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f extends c implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f18457k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f18458l;
    private int m;

    static {
    }

    public f(int r8, int r9) {
        this(r8, r9, 0, 0, ~r8, (r8 << 10) ^ (r9 >>> 4));
    }

    public f(int r1, int r2, int r3, int r4, int r5, int r6) {
        this.f18454h = r1;
        this.f18455i = r2;
        this.f18456j = r3;
        this.f18457k = r4;
        this.f18458l = r5;
        this.m = r6;
        int r7 = (((r1 | r2) | r3) | r4) | r5;
        int r8 = 0;
        if (r7 == 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L12;
    L8:
        if (r8 >= 64) goto L10;
        c();
        r8 = r8 + 1;
        goto L8
    L10:
        return;
    L12:
        throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
    L5:
        r9 = false;
        goto L6
    }

    @Override // kotlin.q0.c
    public int b(int r1) {
        return d.f(c(), r1);
    }

    @Override // kotlin.q0.c
    public int c() {
        int r0 = this.f18454h;
        int r1 = r0 ^ (r0 >>> 2);
        this.f18454h = this.f18455i;
        this.f18455i = this.f18456j;
        this.f18456j = this.f18457k;
        int r2 = this.f18458l;
        this.f18457k = r2;
        int r3 = ((r1 ^ (r1 << 1)) ^ r2) ^ (r2 << 4);
        this.f18458l = r3;
        int r4 = this.m + 362437;
        this.m = r4;
        return r3 + r4;
    }
}
