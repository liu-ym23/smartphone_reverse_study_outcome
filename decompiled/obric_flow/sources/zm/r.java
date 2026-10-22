package zm;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends CharacterStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23537c;
    public final int d;

    public r(int r5, int r10, boolean r11, boolean r12) {
        this.f23535a = r11;
        this.f23536b = r12;
        this.f23537c = r5;
        this.d = r10;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
    }
}
