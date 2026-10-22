package com.android.settings.inputmethod;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class DictWordItem extends LinearLayout {
    private ImageView mDelete;
    private TextView mWord;

    public DictWordItem(Context r2) {
        this(r2, null);
    }

    public DictWordItem(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public DictWordItem(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        View r4 = LayoutInflater.from(r1).inflate(R.layout.dict_word_item, this, true);
        this.mWord = (TextView) r4.findViewById(R.id.word);
        this.mDelete = (ImageView) r4.findViewById(R.id.delete);
    }

    public void setOnDeleteClickListener(View.OnClickListener r2, String r3) {
        this.mDelete.setTag(r3);
        this.mDelete.setOnClickListener(r2);
    }

    public void setOnWordClickListener(View.OnClickListener r1) {
        this.mWord.setOnClickListener(r1);
    }

    public void setText(CharSequence r1) {
        this.mWord.setText(r1);
    }

    public CharSequence getText() {
        return this.mWord.getText();
    }

    public int getWordMeasuredWidth() {
        int r0 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mWord.measure(r0, r0);
        return this.mWord.getMeasuredWidth();
    }
}
