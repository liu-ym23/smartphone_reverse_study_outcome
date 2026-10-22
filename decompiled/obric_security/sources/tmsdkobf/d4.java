package tmsdkobf;

import android.security.keystore.KeyGenParameterSpec;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d4 {

    public static class a extends d4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public KeyGenParameterSpec.Builder f143a;

        public a(String r2, int r3) {
            this.f143a = null;
            this.f143a = new KeyGenParameterSpec.Builder(r2, r3);
        }

        @Override // tmsdkobf.d4
        public AlgorithmParameterSpec a() {
            return this.f143a.build();
        }

        @Override // tmsdkobf.d4
        public d4 b(String... r2) {
            this.f143a.setSignaturePaddings(r2);
            return this;
        }

        @Override // tmsdkobf.d4
        public d4 a(String... r2) {
            this.f143a.setDigests(r2);
            return this;
        }
    }

    public static class b extends d4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f144a;
        public int b;
        public String[] c;
        public String[] d;

        public b(String r2, int r3) {
            if (r2 == null) goto L11;
            if (r2.isEmpty() == true) goto L9;
            this.f144a = r2;
            this.b = r3;
            return;
        L9:
            throw new IllegalArgumentException("keystoreAlias must not be empty");
        L11:
            throw new NullPointerException("keystoreAlias == null");
        }

        @Override // tmsdkobf.d4
        public AlgorithmParameterSpec a() {
            Class<?> r1 = Class.forName("android.security.keystore.KeyGenParameterSpec");
            Class<?> r4 = Integer.TYPE;
            Class<?> r16 = Boolean.TYPE;
            return (AlgorithmParameterSpec) r1.getConstructor(new Class[]{String.class, r4, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, r4, String[].class, String[].class, String[].class, String[].class, r16, r16, r4}).newInstance(new Object[]{this.f144a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.b), this.c, null, this.d, null, Boolean.TRUE, Boolean.FALSE, -1});
        }

        @Override // tmsdkobf.d4
        public d4 b(String... r2) {
            if (r2.length <= 0) goto L5;
            r2 = (String[]) r2.clone();
        L5:
            this.d = r2;
            return this;
        }

        @Override // tmsdkobf.d4
        public d4 a(String... r2) {
            if (r2.length <= 0) goto L5;
            r2 = (String[]) r2.clone();
        L5:
            this.c = r2;
            return this;
        }
    }

    public d4() {
    }

    public abstract AlgorithmParameterSpec a();

    public abstract d4 a(String... r1);

    public abstract d4 b(String... r1);

    public static d4 a(String r1, int r2) {
        return new a(r1, r2);
    }
}
