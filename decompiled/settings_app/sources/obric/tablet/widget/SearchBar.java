package obric.tablet.widget;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.android.settings.R;
import com.android.vcard.VCardConfig;

/* JADX INFO: loaded from: classes5.dex */
public class SearchBar extends RelativeLayout {
    private View mClearTextBtn;
    private obric.widget.SearchBar.ListenerAdapter mListener;
    private EditText mSearchEditor;

    static /* synthetic */ EditText access$000(SearchBar r0) {
        return r0.mSearchEditor;
    }

    static /* synthetic */ obric.widget.SearchBar.ListenerAdapter access$100(SearchBar r0) {
        return r0.mListener;
    }

    static /* synthetic */ View access$200(SearchBar r0) {
        return r0.mClearTextBtn;
    }

    public SearchBar(Context r2) {
        this(r2, null);
    }

    public SearchBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SearchBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        initView(r1);
    }

    private void initView(Context r3) {
        View r4 = LayoutInflater.from(r3).inflate(R.layout.tablet_searchbar, this, true);
        this.mSearchEditor = (EditText) r4.findViewById(R.id.search);
        View r5 = r4.findViewById(R.id.btn_clear_search);
        this.mClearTextBtn = r5;
        r5.setOnClickListener(new AnonymousClass1(this));
        this.mSearchEditor.setOnEditorActionListener(new AnonymousClass2(this));
        this.mSearchEditor.addTextChangedListener(new AnonymousClass3(this));
        this.mSearchEditor.setImeOptions(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
    }

    public void setListener(obric.widget.SearchBar.ListenerAdapter r1) {
        this.mListener = r1;
    }

    public void hideKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchEditor.getWindowToken(), 2);
    }

    public void showKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.mSearchEditor, 0);
    }

    public View getSearchEditor() {
        return this.mSearchEditor;
    }

    public View getClearView() {
        return this.mClearTextBtn;
    }

    @Override // android.view.View
    public boolean onDragEvent(DragEvent r6) {
        int r0 = r6.getAction();
        if (r0 != 2) goto L5;
        setEditorSelection(this.mSearchEditor.getOffsetForPosition(r6.getX(), r6.getY()));
        return true;
    L5:
        if (r0 == 3) goto L22;
        if (r0 != 5) goto L9;
        this.mSearchEditor.requestFocus();
        return true;
    L9:
        if (r0 != 6) goto L27;
        this.mSearchEditor.clearFocus();
        return true;
    L27:
        return true;
    L22:
        CharSequence r1 = r6.getClipData().getItemAt(0).getText();     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r1) == true) goto L26;
        int r7 = this.mSearchEditor.getOffsetForPosition(r6.getX(), r6.getY());     // Catch: Exception -> L21
        this.mSearchEditor.getEditableText().insert(r7, r1);     // Catch: Exception -> L21
        setEditorSelection(r7 + r1.length());     // Catch: Exception -> L21
        return true;
    L26:
        return false;
    }

    private void setEditorSelection(int r2) {
        Editable r1 = this.mSearchEditor.getText();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 >= 0) goto L8;
        r2 = 0;
    L10:
        Selection.setSelection(r1, r2);
        return;
    L8:
        if (r2 <= r1.length()) goto L10;
        r2 = r1.length();
        goto L10
    }
}
