package tmsdkobf;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
public class e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f171a;
    public final LinkedList b;

    public e4(int r2) {
        this.b = new LinkedList();
        this.f171a = r2;
    }

    public void a(Object r3) {
        if (this.b.size() < this.f171a) goto L5;
        this.b.poll();
    L5:
        this.b.offer(r3);
    }
}
