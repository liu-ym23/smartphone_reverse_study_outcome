package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
final class AppCompatTextClassifierHelper {
    private TextClassifier mTextClassifier;
    private TextView mTextView;

    private static final class Api26Impl {
        private Api26Impl() {
        }

        static TextClassifier getTextClassifier(TextView r1) {
            TextClassificationManager r2 = (TextClassificationManager) r1.getContext().getSystemService(TextClassificationManager.class);
            if (r2 == null) goto L7;
            return r2.getTextClassifier();
        L7:
            return TextClassifier.NO_OP;
        }
    }

    AppCompatTextClassifierHelper(TextView r1) {
        this.mTextView = (TextView) Preconditions.checkNotNull(r1);
    }

    public void setTextClassifier(TextClassifier r1) {
        this.mTextClassifier = r1;
    }

    public TextClassifier getTextClassifier() {
        TextClassifier r0 = this.mTextClassifier;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Api26Impl.getTextClassifier(this.mTextView);
    }
}
