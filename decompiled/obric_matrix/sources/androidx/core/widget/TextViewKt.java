package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.r;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0083\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022d\b\u0006\u0010\u0003\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00042d\b\u0006\u0010\u000e\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u00042%\b\u0006\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\bø\u0001\u0000\u001a7\u0010\u0013\u001a\u00020\u0001*\u00020\u00022%\b\u0004\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\bø\u0001\u0000\u001av\u0010\u0015\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004H\u0086\bø\u0001\u0000\u001av\u0010\u0016\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u0004H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"addTextChangedListener", "Landroid/text/TextWatcher;", "Landroid/widget/TextView;", "beforeTextChanged", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "text", "", "start", "count", "after", "", "onTextChanged", "before", "afterTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "doAfterTextChanged", "action", "doBeforeTextChanged", "doOnTextChanged", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextViewKt {

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass1 extends q implements r<CharSequence, Integer, Integer, Integer, f0> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(4);
        }

        @Override // kotlin.n0.c.r
        public /* bridge */ /* synthetic */ f0 invoke(CharSequence r1, Integer r2, Integer r3, Integer r4) {
            invoke(r1, r2.intValue(), r3.intValue(), r4.intValue());
            return f0.f18324a;
        }

        public final void invoke(CharSequence r1, int r2, int r3, int r4) {
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass2 extends q implements r<CharSequence, Integer, Integer, Integer, f0> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(4);
        }

        @Override // kotlin.n0.c.r
        public /* bridge */ /* synthetic */ f0 invoke(CharSequence r1, Integer r2, Integer r3, Integer r4) {
            invoke(r1, r2.intValue(), r3.intValue(), r4.intValue());
            return f0.f18324a;
        }

        public final void invoke(CharSequence r1, int r2, int r3, int r4) {
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/text/Editable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass3 extends q implements l<Editable, f0> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Editable r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable r1) {
        }
    }

    public static final TextWatcher addTextChangedListener(TextView r1, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f0> r2, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f0> r3, l<? super Editable, f0> r4) {
        o.f(r1, "<this>");
        o.f(r2, "beforeTextChanged");
        o.f(r3, "onTextChanged");
        o.f(r4, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 r0 = new TextViewKt$addTextChangedListener$textWatcher$1(r4, r2, r3);
        r1.addTextChangedListener(r0);
        return r0;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView r0, r r1, r r2, l r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = AnonymousClass1.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = AnonymousClass2.INSTANCE;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = AnonymousClass3.INSTANCE;
    L11:
        o.f(r0, "<this>");
        o.f(r1, "beforeTextChanged");
        o.f(r2, "onTextChanged");
        o.f(r3, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 r6 = new TextViewKt$addTextChangedListener$textWatcher$1(r3, r1, r2);
        r0.addTextChangedListener(r6);
        return r6;
    }

    public static final TextWatcher doAfterTextChanged(TextView r1, final l<? super Editable, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        TextWatcher r0 = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(r2);
        r1.addTextChangedListener(r0);
        return r0;
    }

    public static final TextWatcher doBeforeTextChanged(TextView r1, final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        TextWatcher r0 = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(r2);
        r1.addTextChangedListener(r0);
        return r0;
    }

    public static final TextWatcher doOnTextChanged(TextView r1, final r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "action");
        TextWatcher r0 = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(r2);
        r1.addTextChangedListener(r0);
        return r0;
    }
}
