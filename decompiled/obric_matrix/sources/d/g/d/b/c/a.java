package d.g.d.b.c;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f16820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f16821g;

    public a(float r1, float r2) {
        this.f16820f = r1;
        this.f16821g = r2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r2, MotionEvent r3) {
        int r4 = r3.getAction();
        if (r4 != 0) goto L5;
        float r1 = this.f16820f;
    L11:
        r2.setAlpha(r1);
        return false;
    L5:
        if (r4 != 1) goto L7;
    L9:
        r1 = this.f16821g;
        goto L11
    L7:
        if (r4 == 3) goto L9;
        return false;
    }
}
