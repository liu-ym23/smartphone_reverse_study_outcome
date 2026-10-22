package com.obric.matrix.account.m;

import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000bR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001b\u0010\t\u001a\u00028\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/account/common/InitOnce;", "T", "", "init", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "getInit", "()Lkotlin/jvm/functions/Function0;", "setInit", "value", "getValue", "()Ljava/lang/Object;", "value$delegate", "Lkotlin/Lazy;", "invoke", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private kotlin.n0.c.a<? extends T> f8587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f8588b;

    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "T", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b<T> f8589f;

        a(b<T> r1) {
            this.f8589f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public final T invoke() {
            return this.f8589f.a().invoke();
        }
    }

    public b(kotlin.n0.c.a<? extends T> r2) {
        o.f(r2, "init");
        this.f8587a = r2;
        this.f8588b = i.b(new a(this));
    }

    private final T b() {
        return (T) this.f8588b.getValue();
    }

    public final kotlin.n0.c.a<T> a() {
        return this.f8587a;
    }

    public final T c() {
        return b();
    }

    public final void d(kotlin.n0.c.a<? extends T> r2) {
        o.f(r2, "<set-?>");
        this.f8587a = r2;
    }
}
