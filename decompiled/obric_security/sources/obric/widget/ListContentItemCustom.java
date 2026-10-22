package obric.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes5.dex */
public class ListContentItemCustom extends ListContentItem {
    @Override // obric.widget.ListContentItem
    protected int getDefaultMidLayout() {
        return 0;
    }

    @Override // obric.widget.ListContentItem
    protected int getDefaultRightLayout() {
        return 0;
    }

    @Override // obric.widget.ListContentItem
    protected void initRightWidget() {
    }

    public ListContentItemCustom(Context context) {
        this(context, null);
    }

    public ListContentItemCustom(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListContentItemCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setMidContentPaddingLeft(0);
    }
}
