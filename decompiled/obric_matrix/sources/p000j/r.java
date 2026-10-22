package p000j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f18184a = null;

    static class a implements r {
        a() {
        }

        @Override // p000j.r
        public List<InetAddress> a(String r4) {
            if (r4 == null) goto L9;
            return Arrays.asList(InetAddress.getAllByName(r4));
        L5:
            e = move-exception;
            UnknownHostException r0 = new UnknownHostException("Broken system behaviour for dns lookup of " + r4);
            r0.initCause(e);
            throw r0;
        L9:
            throw new UnknownHostException("hostname == null");
        }
    }

    static {
        f18184a = new a();
    }

    List<InetAddress> a(String r1);
}
