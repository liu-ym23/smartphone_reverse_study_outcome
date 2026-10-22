package androidx.slice;

/* JADX INFO: loaded from: classes.dex */
public class SystemClock implements Clock {
    public SystemClock() {
    }

    @Override // androidx.slice.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
