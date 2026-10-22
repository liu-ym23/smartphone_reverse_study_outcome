package z;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f23353a = null;

    static {
        f23353a = Charset.forName("UTF-8");
    }

    void b(MessageDigest r5);

    boolean equals(Object r5);

    int hashCode();
}
