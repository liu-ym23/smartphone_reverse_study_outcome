package l.b.c.d;

import java.security.AlgorithmParameters;
import java.security.MessageDigest;
import java.security.Signature;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {
    public a() {
    }

    @Override // l.b.c.d.b
    public MessageDigest a(String r1) {
        return MessageDigest.getInstance(r1);
    }

    @Override // l.b.c.d.b
    public AlgorithmParameters b(String r1) {
        return AlgorithmParameters.getInstance(r1);
    }

    @Override // l.b.c.d.b
    public Signature c(String r1) {
        return Signature.getInstance(r1);
    }
}
