package javax.annotation.meta;

import com.bytedance.networkstackapplib.NetworkStackConstant;

/* JADX INFO: loaded from: classes2.dex */
public final enum When extends Enum<When> {
    public static final When b = null;
    public static final /* synthetic */ When[] c = null;

    static {
        When r0 = new When("ALWAYS", 0);
        b = r0;
        c = new When[]{r0, new When(NetworkStackConstant.UNKNOWN_TYPE, 1), new When("MAYBE", 2), new When("NEVER", 3)};
    }

    public static When valueOf(String r1) {
        return (When) Enum.valueOf(When.class, r1);
    }

    public static When[] values() {
        return (When[]) c.clone();
    }
}
