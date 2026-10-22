package zn;

import java.util.Stack;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f23550b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Stack f23551a;

    static {
        f23550b = new a();
    }

    public a() {
        this.f23551a = new Stack();
        new WeakHashMap();
    }

    public final void a() {
        Stack r5 = this.f23551a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return;
    L7:
        if (r5.peek() != null) goto L10;
        return;
    L10:
        throw new ClassCastException();
    }
}
