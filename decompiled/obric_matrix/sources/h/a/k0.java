package h.a;

import kotlin.Metadata;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@IgnoreJRERequirement
public final class k0 extends kotlin.k0.a implements t2<String> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f17532g = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f17533f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements kotlin.k0.g.c<k0> {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }
    }

    static {
        f17532g = new a(null);
    }

    public k0(long r2) {
        super(f17532g);
        this.f17533f = r2;
    }

    @Override // h.a.t2
    public /* bridge */ /* synthetic */ void Q(kotlin.k0.g r1, String r2) {
        i0(r1, r2);
    }

    @Override // h.a.t2
    public /* bridge */ /* synthetic */ String d0(kotlin.k0.g r1) {
        return j0(r1);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof k0) == true) goto L9;
        return false;
    L9:
        if (this.f17533f == ((k0) r6).f17533f) goto L11;
        return false;
    L11:
        return true;
    }

    public final long h0() {
        return this.f17533f;
    }

    public int hashCode() {
        return Long.hashCode(this.f17533f);
    }

    public void i0(kotlin.k0.g r1, String r2) {
        Thread.currentThread().setName(r2);
    }

    public String j0(kotlin.k0.g r9) {
        l0 r10 = (l0) r9.get(l0.f17535g);
        String r0 = "coroutine";
        if (r10 == null) goto L9;
        String r11 = r10.h0();
        if (r11 == null) goto L9;
        r0 = r11;
    L9:
        Thread r12 = Thread.currentThread();
        String r7 = r12.getName();
        int r1 = kotlin.u0.k.V(r7, " @", 0, false, 6, null);
        if (r1 >= 0) goto L12;
        r1 = r7.length();
    L12:
        StringBuilder r3 = new StringBuilder((r0.length() + r1) + 10);
        String r2 = r7.substring(0, r1);
        kotlin.n0.d.o.e(r2, "this as java.lang.String…ing(startIndex, endIndex)");
        r3.append(r2);
        r3.append(" @");
        r3.append(r0);
        r3.append('#');
        r3.append(h0());
        String r8 = r3.toString();
        kotlin.n0.d.o.e(r8, "StringBuilder(capacity).…builderAction).toString()");
        r12.setName(r8);
        return r7;
    }

    public String toString() {
        return "CoroutineId(" + this.f17533f + ')';
    }
}
