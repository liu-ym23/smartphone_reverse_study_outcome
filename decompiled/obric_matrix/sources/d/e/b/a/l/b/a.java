package d.e.b.a.l.b;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements d.e.b.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f16638a = null;

    static {
        f16638a = Logger.getLogger(a.class.getName());
    }

    public a() {
    }

    @Override // d.e.b.a.b
    public InputStream a(String r5) {
        InputStream r4 = a.class.getResourceAsStream(r5);
        if (r4 != null) goto L5;
        f16638a.log(Level.WARNING, String.format("File %s not found", new Object[]{r5}));
    L5:
        return r4;
    }
}
