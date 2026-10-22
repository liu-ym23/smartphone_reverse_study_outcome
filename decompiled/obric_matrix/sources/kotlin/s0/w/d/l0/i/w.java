package kotlin.s0.w.d.l0.i;

/* JADX INFO: loaded from: classes2.dex */
public class w extends RuntimeException {
    public w(q r1) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public k a() {
        return new k(getMessage());
    }
}
