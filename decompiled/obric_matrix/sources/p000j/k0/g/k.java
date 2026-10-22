package p000j.k0.g;

import java.net.ProtocolException;
import p000j.b0;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f17901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17903c;

    public k(b0 r1, int r2, String r3) {
        this.f17901a = r1;
        this.f17902b = r2;
        this.f17903c = r3;
    }

    public static k a(String r8) {
        int r3 = 9;
        if (r8.startsWith("HTTP/1.") == false) goto L19;
        if (r8.length() < 9) goto L17;
        if (r8.charAt(8) != ' ') goto L17;
        int r0 = r8.charAt(7) - '0';
        if (r0 != 0) goto L12;
        b0 r1 = b0.f17672g;
    L21:
        int r6 = r3 + 3;
        if (r8.length() < r6) goto L37;
        int r5 = Integer.parseInt(r8.substring(r3, r6));     // Catch: NumberFormatException -> L34
        if (r8.length() > r6) goto L27;
        String r9 = "";
    L33:
        return new k(r1, r5, r9);
    L27:
        if (r8.charAt(r6) != ' ') goto L30;
        r9 = r8.substring(r3 + 4);
        goto L33
    L30:
        throw new ProtocolException("Unexpected status line: " + r8);
    L35:
        throw new ProtocolException("Unexpected status line: " + r8);
    L37:
        throw new ProtocolException("Unexpected status line: " + r8);
    L12:
        if (r0 != 1) goto L15;
        r1 = b0.f17673h;
        goto L21
    L15:
        throw new ProtocolException("Unexpected status line: " + r8);
    L17:
        throw new ProtocolException("Unexpected status line: " + r8);
    L19:
        if (r8.startsWith("ICY ") == false) goto L39;
        r1 = b0.f17672g;
        r3 = 4;
        goto L21
    L39:
        throw new ProtocolException("Unexpected status line: " + r8);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f17901a != b0.f17672g) goto L5;
        String r1 = "HTTP/1.0";
    L6:
        r0.append(r1);
        r0.append(' ');
        r0.append(this.f17902b);
        if (this.f17903c == null) goto L10;
        r0.append(' ');
        r0.append(this.f17903c);
    L10:
        return r0.toString();
    L5:
        r1 = "HTTP/1.1";
        goto L6
    }
}
