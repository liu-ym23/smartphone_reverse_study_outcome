package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
final class AppCompatTextClassifierHelper {

    @Nullable
    private TextClassifier mTextClassifier;

    @NonNull
    private TextView mTextView;

    public AppCompatTextClassifierHelper(@NonNull TextView r1) {
        this.mTextView = (TextView) Preconditions.checkNotNull(r1);
    }

    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        TextClassifier r0 = this.mTextClassifier;
        if (r0 != null) goto L10;
        TextClassificationManager r1 = (TextClassificationManager) this.mTextView.getContext().getSystemService(TextClassificationManager.class);
        if (r1 == null) goto L9;
        return r1.getTextClassifier();
    L9:
        return TextClassifier.NO_OP;
    L10:
        return r0;
    }

    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier r1) {
        this.mTextClassifier = r1;
    }
}
