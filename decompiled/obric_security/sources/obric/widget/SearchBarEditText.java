package obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.CompletionInfo;
import android.widget.EditText;

/* JADX INFO: loaded from: classes5.dex */
public class SearchBarEditText extends EditText {
    private Listener mListener;

    private interface Listener {
        void onCommitCompletion(CompletionInfo text);
    }

    public static class ListenerAdapter implements Listener {
        @Override // obric.widget.SearchBarEditText.Listener
        public void onCommitCompletion(CompletionInfo text) {
        }

        public ListenerAdapter() {
        }
    }

    public SearchBarEditText(Context context) {
        super(context);
    }

    public SearchBarEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SearchBarEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    @Override // android.widget.TextView
    public void onCommitCompletion(CompletionInfo text) {
        super.onCommitCompletion(text);
        Listener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onCommitCompletion(text);
        return;
    }
}
