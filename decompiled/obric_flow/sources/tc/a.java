package tc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements rc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22117a;

    public a() {
        this.f22117a = "default_bid";
    }

    @Override // rc.c
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        this.f22117a = r5;
    }
}
