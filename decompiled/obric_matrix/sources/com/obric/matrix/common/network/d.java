package com.obric.matrix.common.network;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 '*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002'(B\u0019\b\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J&\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0001\u0010\u0014\"\b\b\u0002\u0010\u0001*\u0002H\u00142\u0006\u0010\u0015\u001a\u0002H\u0014H\u0086\b¢\u0006\u0002\u0010\u0016JD\u0010\u0017\u001a\u0002H\u0014\"\u0004\b\u0001\u0010\u0014\"\b\b\u0002\u0010\u0001*\u0002H\u00142!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u00140\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00018\u0000H\u0086\b¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001f\u001a\u00028\u0000H\u0086\b¢\u0006\u0002\u0010\u0010JA\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00140\u0000\"\u0004\b\u0001\u0010\u0014\"\u0004\b\u0002\u0010\u00012!\u0010!\u001a\u001d\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u0002H\u00140\u0019H\u0086\bø\u0001\u0000JA\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0000\"\u0004\b\u0001\u0010\u0014\"\u0004\b\u0002\u0010\u00012!\u0010!\u001a\u001d\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u0002H\u00140\u0019H\u0086\bø\u0001\u0000J5\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020$0\u0019H\u0086\bø\u0001\u0000J5\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010#\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020$0\u0019H\u0086\bø\u0001\u0000J\b\u0010&\u001a\u00020\u0005H\u0016R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"Lcom/obric/matrix/common/network/CmdResult;", "T", "", "value", "logId", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "isFailure", "", "()Z", "isSuccess", "getLogId", "()Ljava/lang/String;", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "exceptionOrNull", "", "getOrDefault", "R", "defaultValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "onFailure", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "exception", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrNull", "getOrThrow", "map", "transform", "mapCatching", "action", "", "onSuccess", "toString", "Companion", "Failure", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f8927c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8929b;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\bJ*\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/matrix/common/network/CmdResult$Companion;", "", "()V", "failure", "Lcom/obric/matrix/common/network/CmdResult;", "T", "exception", "", "success", "value", "logId", "", "(Ljava/lang/Object;Ljava/lang/String;)Lcom/obric/matrix/common/network/CmdResult;", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/matrix/common/network/CmdResult$Failure;", "", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "hashCode", "", "toString", "", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f8930a;

        public b(Throwable r2) {
            o.f(r2, "exception");
            this.f8930a = r2;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof b) == true) goto L5;
        L7:
            return false;
        L5:
            if (o.a(this.f8930a, ((b) r2).f8930a) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.f8930a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f8930a + ')';
        }
    }

    static {
        f8927c = new a(null);
    }

    public d(Object r2, String r3) {
        o.f(r3, "logId");
        this.f8928a = r2;
        this.f8929b = r3;
    }

    public final Throwable a() {
        Object r1 = this.f8928a;
        if ((r1 instanceof b) == true) goto L7;
        return null;
    L7:
        return ((b) r1).f8930a;
    }

    public final String b() {
        return this.f8929b;
    }

    public final Object c() {
        return this.f8928a;
    }

    public final boolean d() {
        return !(this.f8928a instanceof b);
    }

    public String toString() {
        Object r0 = this.f8928a;
        if ((r0 instanceof b) == false) goto L6;
        return ((b) r0).toString();
    L6:
        return "Success(" + this.f8928a + ')';
    }
}
