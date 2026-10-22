package se;

import ai.j0;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends CharacterStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21890b;

    public b(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "symbol");
        this.f21889a = r5;
        this.f21890b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        String r11 = r10.f21889a;
        if (Intrinsics.areEqual(this.f21889a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21890b, r10.f21890b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f21889a.hashCode() * 31;
        return this.f21890b.hashCode() + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("LynxMentionSpan(name=");
        r5.append(this.f21889a);
        r5.append(", symbol=");
        return j0.p(r5, this.f21890b, ')');
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
    }
}
