package d.c.f.g;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    InterfaceC0422a f15712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final float f15713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f15714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f15715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f15716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f15717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f15718g;

    /* JADX INFO: renamed from: d.c.f.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0422a {
        boolean a();
    }

    public a(Context r1) {
        this.f15713b = ViewConfiguration.get(r1).getScaledTouchSlop();
        a();
    }

    public static a c(Context r1) {
        return new a(r1);
    }

    public void a() {
        this.f15712a = null;
        e();
    }

    public boolean b() {
        return this.f15714c;
    }

    public boolean d(MotionEvent r8) {
        int r0 = r8.getAction();
        if (r0 != 0) goto L5;
        this.f15714c = true;
        this.f15715d = true;
        this.f15716e = r8.getEventTime();
        this.f15717f = r8.getX();
        this.f15718g = r8.getY();
    L31:
        return true;
    L5:
        if (r0 != 1) goto L7;
        this.f15714c = false;
        if (Math.abs(r8.getX() - this.f15717f) <= this.f15713b) goto L21;
    L22:
        this.f15715d = false;
    L24:
        if (this.f15715d == true) goto L26;
    L12:
        this.f15715d = false;
        goto L31
    L26:
        if ((r8.getEventTime() - this.f15716e) > ViewConfiguration.getLongPressTimeout()) goto L12;
        InterfaceC0422a r9 = this.f15712a;
        if (r9 == null) goto L12;
        r9.a();
        goto L12
    L21:
        if (Math.abs(r8.getY() - this.f15718g) <= this.f15713b) goto L24;
    L7:
        if (r0 == 2) goto L14;
        if (r0 != 3) goto L31;
        this.f15714c = false;
        goto L12
    L14:
        if (Math.abs(r8.getX() - this.f15717f) > this.f15713b) goto L12;
        if (Math.abs(r8.getY() - this.f15718g) <= this.f15713b) goto L31;
        goto L31
    }

    public void e() {
        this.f15714c = false;
        this.f15715d = false;
    }

    public void f(InterfaceC0422a r1) {
        this.f15712a = r1;
    }
}
