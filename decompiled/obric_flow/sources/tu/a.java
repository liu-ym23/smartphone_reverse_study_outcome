package tu;

import java.io.PrintStream;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PrintStream f22179c;

    public a(Level r5) {
        Intrinsics.checkNotNullParameter(r5, "level");
        super(r5);
        if (r5.compareTo(Level.WARNING) < 0) goto L5;
        PrintStream r10 = System.err;
    L6:
        this.f22179c = r10;
        return;
    L5:
        r10 = System.out;
        goto L6
    }

    @Override // um.a
    public final void p(Level r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "level");
        Intrinsics.checkNotNullParameter(r10, "msg");
        this.f22179c.println("[" + r5 + "] [Koin] " + r10);
    }
}
