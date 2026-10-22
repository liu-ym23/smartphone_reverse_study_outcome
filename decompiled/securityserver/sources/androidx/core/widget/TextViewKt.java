package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextViewKt {
    @NotNull
    public static final TextWatcher addTextChangedListener(@NotNull TextView r1, @NotNull Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r2, @NotNull Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r3, @NotNull Function1<? super Editable, Unit> r4) {
        Intrinsics.g(r1, "$this$addTextChangedListener");
        Intrinsics.g(r2, "beforeTextChanged");
        Intrinsics.g(r3, "onTextChanged");
        Intrinsics.g(r4, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 r0 = new TextViewKt$addTextChangedListener$textWatcher$1(r4, r2, r3);
        r1.addTextChangedListener(r0);
        return r0;
    }

    @NotNull
    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView r0, Function4 r1, Function4 r2, Function1 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = AnonymousClass1.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = AnonymousClass2.INSTANCE;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = AnonymousClass3.INSTANCE;
    L11:
        Intrinsics.g(r0, "$this$addTextChangedListener");
        Intrinsics.g(r1, "beforeTextChanged");
        Intrinsics.g(r2, "onTextChanged");
        Intrinsics.g(r3, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 r6 = new TextViewKt$addTextChangedListener$textWatcher$1(r3, r1, r2);
        r0.addTextChangedListener(r6);
        return r6;
    }

    @NotNull
    public static final TextWatcher doAfterTextChanged(@NotNull TextView r1, @NotNull final Function1<? super Editable, Unit> r2) {
        Intrinsics.g(r1, "$this$doAfterTextChanged");
        Intrinsics.g(r2, "action");
        TextWatcher r0 = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1(r2);
        r1.addTextChangedListener(r0);
        return r0;
    }

    @NotNull
    public static final TextWatcher doBeforeTextChanged(@NotNull TextView r1, @NotNull final Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r2) {
        Intrinsics.g(r1, "$this$doBeforeTextChanged");
        Intrinsics.g(r2, "action");
        TextWatcher r0 = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1(r2);
        r1.addTextChangedListener(r0);
        return r0;
    }

    @NotNull
    public static final TextWatcher doOnTextChanged(@NotNull TextView r1, @NotNull final Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> r2) {
        Intrinsics.g(r1, "$this$doOnTextChanged");
        Intrinsics.g(r2, "action");
        TextWatcher r0 = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$1(r2);
        r1.addTextChangedListener(r0);
        return r0;
    }
}
