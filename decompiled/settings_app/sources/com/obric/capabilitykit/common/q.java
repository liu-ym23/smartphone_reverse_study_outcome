package com.obric.capabilitykit.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ConditionType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TIME", "LOCATION", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum q extends Enum<q> {
    public static final q b = null;
    public static final q c = null;
    private static final /* synthetic */ q[] d = null;
    private final String a;

    static {
        b = new q("TIME", 0, "time");
        c = new q("LOCATION", 1, "location");
        d = a();
    }

    private q(String r1, int r2, String r3) {
        super(r1, r2);
        this.a = r3;
    }

    private static final /* synthetic */ q[] a() {
        return new q[]{b, c};
    }

    public static q valueOf(String r1) {
        return (q) Enum.valueOf(q.class, r1);
    }

    public static q[] values() {
        return (q[]) d.clone();
    }

    public final String b() {
        return this.a;
    }
}
