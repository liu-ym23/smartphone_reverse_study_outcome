package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import kotlin.Metadata;
import kotlin.f0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004\u001aQ\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\f2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u001a;\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\u0002\b\u0011H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"getSystemService", "T", "", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "withStyledAttributes", "", "set", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "defStyleRes", "block", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Lkotlin/ExtensionFunctionType;", "resourceId", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.j(4, "T");
        throw null;
    }

    public static final void withStyledAttributes(Context r1, @StyleRes int r2, int[] r3, kotlin.n0.c.l<? super TypedArray, f0> r4) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r3, "attrs");
        kotlin.n0.d.o.f(r4, "block");
        TypedArray r5 = r1.obtainStyledAttributes(r2, r3);
        kotlin.n0.d.o.e(r5, "obtainStyledAttributes(resourceId, attrs)");
        r4.invoke(r5);
        r5.recycle();
    }

    public static final void withStyledAttributes(Context r1, AttributeSet r2, int[] r3, @AttrRes int r4, @StyleRes int r5, kotlin.n0.c.l<? super TypedArray, f0> r6) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r3, "attrs");
        kotlin.n0.d.o.f(r6, "block");
        TypedArray r7 = r1.obtainStyledAttributes(r2, r3, r4, r5);
        kotlin.n0.d.o.e(r7, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        r6.invoke(r7);
        r7.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context r1, AttributeSet r2, int[] r3, int r4, int r5, kotlin.n0.c.l r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r3, "attrs");
        kotlin.n0.d.o.f(r6, "block");
        TypedArray r9 = r1.obtainStyledAttributes(r2, r3, r4, r5);
        kotlin.n0.d.o.e(r9, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        r6.invoke(r9);
        r9.recycle();
    }
}
