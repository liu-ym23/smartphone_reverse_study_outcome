package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
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

    @RequiresApi(26)
    private static final class Api26Impl {
        private Api26Impl() {
        }

        @NonNull
        @DoNotInline
        static TextClassifier getTextClassifier(@NonNull TextView r1) {
            TextClassificationManager r2 = (TextClassificationManager) r1.getContext().getSystemService(TextClassificationManager.class);
            if (r2 == null) goto L7;
            return r2.getTextClassifier();
        L7:
            return TextClassifier.NO_OP;
        }
    }

    AppCompatTextClassifierHelper(@NonNull TextView r1) {
        this.mTextView = (TextView) Preconditions.checkNotNull(r1);
    }

    @NonNull
    @RequiresApi(api = 26)
    public TextClassifier getTextClassifier() {
        TextClassifier r0 = this.mTextClassifier;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Api26Impl.getTextClassifier(this.mTextView);
    }

    @RequiresApi(api = 26)
    public void setTextClassifier(@Nullable TextClassifier r1) {
        this.mTextClassifier = r1;
    }
}
