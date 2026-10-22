package ue;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f22321b;

    public b(c r5) {
        this.f22321b = r5;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r5) {
        this.f22321b.f22326i = false;
        this.f22320a = false;
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent r5, MotionEvent r10, float r11, float r12) {
        this.f22321b.f22326i = true;
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r5, MotionEvent r10, float r11, float r12) {
        boolean r13 = true;
        this.f22321b.f22326i = true;
        if (this.f22321b.getParent() != null) goto L5;
    L14:
        return false;
    L5:
        if (this.f22320a == false) goto L7;
    L13:
        this.f22321b.getParent().requestDisallowInterceptTouchEvent(r13);
        goto L14
    L7:
        if (c.a(this.f22321b) < this.f22321b.g) goto L9;
        boolean r14 = true;
    L10:
        if (r14 == false) goto L12;
        this.f22320a = true;
    L12:
        r13 = r14;
        goto L13
    L9:
        r14 = false;
        goto L10
    }
}
