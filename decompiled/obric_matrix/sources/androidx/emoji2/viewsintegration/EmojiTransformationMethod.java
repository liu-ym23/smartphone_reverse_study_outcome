package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class EmojiTransformationMethod implements TransformationMethod {

    @Nullable
    private final TransformationMethod mTransformationMethod;

    EmojiTransformationMethod(@Nullable TransformationMethod r1) {
        this.mTransformationMethod = r1;
    }

    public TransformationMethod getOriginalTransformationMethod() {
        return this.mTransformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(@Nullable CharSequence r2, @NonNull View r3) {
        if (r3.isInEditMode() == false) goto L5;
        return r2;
    L5:
        TransformationMethod r1 = this.mTransformationMethod;
        if (r1 == null) goto L8;
        r2 = r1.getTransformation(r2, r3);
    L8:
        if (r2 != null) goto L10;
    L14:
        return r2;
    L10:
        if (EmojiCompat.get().getLoadState() != 1) goto L14;
        return EmojiCompat.get().process(r2);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View r7, CharSequence r8, boolean r9, int r10, Rect r11) {
        TransformationMethod r0 = this.mTransformationMethod;
        if (r0 == null) goto L6;
        r0.onFocusChanged(r7, r8, r9, r10, r11);
        return;
    }
}
