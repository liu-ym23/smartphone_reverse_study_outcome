package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
public abstract class EmojiSpan extends ReplacementSpan {
    private short mHeight;

    @NonNull
    private final EmojiMetadata mMetadata;
    private float mRatio;
    private final Paint.FontMetricsInt mTmpFontMetrics;
    private short mWidth;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    EmojiSpan(@NonNull EmojiMetadata r2) {
        this.mTmpFontMetrics = new Paint.FontMetricsInt();
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRatio = 1.0f;
        Preconditions.checkNotNull(r2, "metadata cannot be null");
        this.mMetadata = r2;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int getHeight() {
        return this.mHeight;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public final int getId() {
        return getMetadata().getId();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final EmojiMetadata getMetadata() {
        return this.mMetadata;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    final float getRatio() {
        return this.mRatio;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint r1, @SuppressLint({"UnknownNullness"}) CharSequence r2, int r3, int r4, @Nullable Paint.FontMetricsInt r5) {
        r1.getFontMetricsInt(this.mTmpFontMetrics);
        Paint.FontMetricsInt r6 = this.mTmpFontMetrics;
        this.mRatio = (Math.abs(r6.descent - r6.ascent) * 1.0f) / this.mMetadata.getHeight();
        this.mHeight = (short) (this.mMetadata.getHeight() * this.mRatio);
        short r7 = (short) (this.mMetadata.getWidth() * this.mRatio);
        this.mWidth = r7;
        if (r5 == null) goto L5;
        Paint.FontMetricsInt r0 = this.mTmpFontMetrics;
        r5.ascent = r0.ascent;
        r5.descent = r0.descent;
        r5.top = r0.top;
        r5.bottom = r0.bottom;
    L5:
        return r7;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    final int getWidth() {
        return this.mWidth;
    }
}
