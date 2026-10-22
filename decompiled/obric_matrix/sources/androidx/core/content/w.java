package androidx.core.content;

import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f288a;

    public /* synthetic */ w(String r1) {
        this.f288a = r1;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object r1) {
        return this.f288a.equals((String) r1);
    }
}
