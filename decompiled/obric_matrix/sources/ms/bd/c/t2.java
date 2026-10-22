package ms.bd.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class t2 extends View {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ u2 f22492f;

    t2(u2 r1, Context r2) {
        this.f22492f = r1;
        super(r2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r8) {
        super.onTouchEvent(r8);
        long r0 = r8.getEventTime();
        w2 r2 = u2.a(this.f22492f);
        long r5 = 0;
        if (u2.a(this.f22492f).f22534i == 0) goto L6;
        r5 = r0 - u2.a(this.f22492f).f22534i;
    L6:
        r2.f22533h = r5;
        u2.a(this.f22492f).f22534i = r0;
        u2.a(this.f22492f).f22535j.f22537a = r8.getX();
        u2.a(this.f22492f).f22535j.f22538b = r8.getY();
        u2.a(this.f22492f).f22532g++;
        String r7 = (String) m.a(16777217, 0, 0, "6aaec5", new byte[]{3, 108, 7, 40, 85, 44, 25, 73, 38, 48});
        String r9 = (String) m.a(16777217, 0, 0, "b6f093", new byte[]{54, 48, 79, 4, 43, 43, 117, 30, 56, 110, 86, 34, 16, 74, 18, 126, 33, 82, 36});
        return true;
    }
}
