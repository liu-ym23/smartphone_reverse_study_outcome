package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ Function1 $afterTextChanged;
    final /* synthetic */ Function4 $beforeTextChanged;
    final /* synthetic */ Function4 $onTextChanged;

    public TextViewKt$addTextChangedListener$textWatcher$1(Function1 r1, Function4 r2, Function4 r3) {
        this.$afterTextChanged = r1;
        this.$beforeTextChanged = r2;
        this.$onTextChanged = r3;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable r1) {
        this.$afterTextChanged.invoke(r1);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence r1, int r2, int r3, int r4) {
        this.$beforeTextChanged.invoke(r1, Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence r1, int r2, int r3, int r4) {
        this.$onTextChanged.invoke(r1, Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4));
    }
}
