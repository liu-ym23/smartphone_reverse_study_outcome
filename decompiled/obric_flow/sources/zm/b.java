package zm;

import android.text.SpannableStringBuilder;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f23463c;

    public b(int r5, int r10, Object r11) {
        this.f23461a = r5;
        this.f23462b = r10;
        this.f23463c = r11;
    }

    public final void a(SpannableStringBuilder r5) {
        int r10 = this.f23461a;
        if (r10 != 0) goto L5;
        int r11 = 18;
    L6:
        Object r12 = this.f23463c;
        if ((r12 instanceof com.lynx.tasm.behavior.ui.text.a) == false) goto L9;
    L10:
        r11 = 33;
    L11:
        r5.setSpan(r12, r10, this.f23462b, r11);
        return;
    L9:
        if ((r12 instanceof n) == false) goto L11;
    L5:
        r11 = 34;
        goto L6
    }
}
