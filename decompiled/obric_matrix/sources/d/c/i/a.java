package d.c.i;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import d.c.c.d.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    @VisibleForTesting
    static Integer f15837e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f15838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f15839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f15840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private ViewTreeObserverOnPreDrawListenerC0425a f15841d;

    /* JADX INFO: renamed from: d.c.i.a$a, reason: collision with other inner class name */
    private static final class ViewTreeObserverOnPreDrawListenerC0425a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final WeakReference<a> f15842f;

        ViewTreeObserverOnPreDrawListenerC0425a(@NonNull a r2) {
            this.f15842f = new WeakReference(r2);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (Log.isLoggable("SizeDeterminer", 2) == false) goto L5;
            Log.v("SizeDeterminer", "OnGlobalLayoutListener called attachStateListener=" + this);
        L5:
            a r3 = this.f15842f.get();
            if (r3 == null) goto L10;
            r3.a();
            return true;
        L10:
            return true;
        }
    }

    public a(@NonNull View r2) {
        this.f15839b = new ArrayList();
        this.f15838a = new WeakReference(r2);
    }

    private static int c(@NonNull Context r1) {
        if (f15837e != null) goto L6;
        WindowManager r2 = (WindowManager) r1.getSystemService("window");
        i.g(r2);
        Display r3 = r2.getDefaultDisplay();
        Point r0 = new Point();
        r3.getSize(r0);
        f15837e = Integer.valueOf(Math.max(r0.x, r0.y));
    L6:
        return f15837e.intValue();
    }

    private int f(int r2, int r3, int r4, View r5) {
        int r0 = r3 - r4;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        if (this.f15840c == true) goto L8;
    L10:
        int r6 = r2 - r4;
        if (r6 <= 0) goto L14;
        return r6;
    L14:
        if (r5.isLayoutRequested() == false) goto L16;
    L22:
        return 0;
    L16:
        if (r3 != (-2)) goto L22;
        if (Log.isLoggable("SizeDeterminer", 4) == false) goto L21;
        Log.i("SizeDeterminer", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
    L21:
        return c(r5.getContext());
    L8:
        if (r5.isLayoutRequested() == false) goto L10;
        return 0;
    }

    private int g(View r4) {
        int r0 = r4.getPaddingTop() + r4.getPaddingBottom();
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
        if (r1 == null) goto L5;
        int r2 = r1.height;
    L7:
        return f(r4.getHeight(), r2, r0, r4);
    L5:
        r2 = 0;
        goto L7
    }

    private int h(View r4) {
        int r0 = r4.getPaddingLeft() + r4.getPaddingRight();
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
        if (r1 == null) goto L5;
        int r2 = r1.width;
    L7:
        return f(r4.getWidth(), r2, r0, r4);
    L5:
        r2 = 0;
        goto L7
    }

    private boolean j(int r1) {
        if (r1 <= 0) goto L4;
    L7:
        return true;
    L4:
        if (r1 == Integer.MIN_VALUE) goto L7;
        return false;
    }

    private boolean k(int r1, int r2) {
        if (j(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (j(r2) == false) goto L7;
        return true;
    }

    private void l(int r2, int r3) {
        Iterator r1 = new ArrayList(this.f15839b).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((b) r1.next()).a(r2, r3);
        goto L4
    }

    void a() {
        if (this.f15839b.isEmpty() == false) goto L5;
        return;
    L5:
        View r0 = i();
        if (r0 != null) goto L8;
        return;
    L8:
        int r1 = h(r0);
        int r2 = g(r0);
        if (k(r1, r2) == true) goto L11;
        return;
    L11:
        l(r1, r2);
        b();
    }

    public void b() {
        View r0 = i();
        if (r0 == null) goto L7;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1.isAlive() == false) goto L7;
        r1.removeOnPreDrawListener(this.f15841d);
    L7:
        this.f15841d = null;
        this.f15839b.clear();
    }

    @Nullable
    public Pair<Integer, Integer> d() {
        View r0 = i();
        if (r0 != null) goto L5;
        return null;
    L5:
        int r2 = h(r0);
        int r1 = g(r0);
        if (k(r2, r1) == true) goto L8;
        return null;
    L8:
        return new Pair(Integer.valueOf(r2), Integer.valueOf(r1));
    }

    public void e(@NonNull b r5) {
        View r0 = i();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = h(r0);
        int r2 = g(r0);
        if (k(r1, r2) == false) goto L10;
        r5.a(r1, r2);
        return;
    L10:
        if (this.f15839b.contains(r5) == true) goto L13;
        this.f15839b.add(r5);
    L13:
        if (this.f15841d != null) goto L16;
        ViewTreeObserver r6 = r0.getViewTreeObserver();
        ViewTreeObserverOnPreDrawListenerC0425a r3 = new ViewTreeObserverOnPreDrawListenerC0425a(this);
        this.f15841d = r3;
        r6.addOnPreDrawListener(r3);
        return;
    }

    @Nullable
    public View i() {
        return this.f15838a.get();
    }

    public void m(@NonNull b r1) {
        this.f15839b.remove(r1);
    }
}
