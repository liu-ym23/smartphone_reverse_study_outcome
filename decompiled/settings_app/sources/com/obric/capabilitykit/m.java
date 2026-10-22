package com.obric.capabilitykit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/entity/ActionType;", "", "action", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "INDEX", "DELETE", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum m extends Enum<m> {
    public static final a b = null;
    public static final m c = null;
    public static final m d = null;
    private static final /* synthetic */ m[] e = null;
    private final String a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/ActionType$Companion;", "", "()V", "of", "Lcom/obric/capabilitykit/entity/ActionType;", "value", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final m a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "value");
            m[] r3 = m.values();
            int r0 = 0;
        L4:
            if (r0 >= 2) goto L9;
            m r1 = r3[r0];
            if (Intrinsics.areEqual(r1.b(), r4) == true) goto L13;
            r0 = r0 + 1;
            goto L4
        L13:
            return r1;
        L9:
            return null;
        }
    }

    static {
        c = new m("INDEX", 0, "index");
        d = new m("DELETE", 1, "delete");
        e = a();
        b = new a(null);
    }

    private m(String r1, int r2, String r3) {
        super(r1, r2);
        this.a = r3;
    }

    private static final /* synthetic */ m[] a() {
        return new m[]{c, d};
    }

    public static m valueOf(String r1) {
        return (m) Enum.valueOf(m.class, r1);
    }

    public static m[] values() {
        return (m[]) e.clone();
    }

    public final String b() {
        return this.a;
    }
}
