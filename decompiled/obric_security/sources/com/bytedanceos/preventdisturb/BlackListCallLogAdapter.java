package com.bytedanceos.preventdisturb;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CursorAdapter;
import com.bytedanceos.preventdisturb.widget.BlackCallListItem;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class BlackListCallLogAdapter extends CursorAdapter implements AbsListView.RecyclerListener {
    public static final int BLACK_ID = 0;
    private BlackListCallAdapterListener mAdapterListener;
    private ConversationAdapterAnimHelper mAnimHelper;
    private Bitmap mDefaultPhoto;
    private String mHighlight;
    private LayoutInflater mInflater;
    private Resources mResource;
    private View.OnClickListener mScrollBtnsClickListener;

    public interface BlackListCallAdapterListener {
        void onCallCursorChanged(Cursor cursor);

        void onCallScrollBtnClick(View v);
    }

    static /* synthetic */ BlackListCallAdapterListener access$000(BlackListCallLogAdapter r0) {
        return r0.mAdapterListener;
    }

    public BlackListCallLogAdapter(Context context, Cursor c, BlackListCallAdapterListener listener, boolean autoRequery) {
        super(context, c, autoRequery);
        this.mScrollBtnsClickListener = new AnonymousClass1(this);
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mResource = context.getResources();
        this.mAnimHelper = new ConversationAdapterAnimHelper(context);
        this.mAdapterListener = listener;
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        BlackCallListItem r2 = (BlackCallListItem) view;
        r2.bind(context, cursor, this.mHighlight);
        r2.mScrollDelBtn.setOnClickListener(this.mScrollBtnsClickListener);
        r2.mScrollUnBlockBtn.setOnClickListener(this.mScrollBtnsClickListener);
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public long getItemId(int position) {
        Cursor r0 = getCursor();
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.isClosed() == false) goto L7;
        return 0;
    L7:
        if (r0.moveToPosition(position) == true) goto L9;
        return 0;
    L9:
        return getCursor().getLong(getCursor().getColumnIndexOrThrow("_id"));
    }

    @Override // android.widget.CursorAdapter
    public void changeCursor(Cursor cursor) {
        this.mAdapterListener.onCallCursorChanged(cursor);
        super.changeCursor(cursor);
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return this.mInflater.inflate(R.layout.black_list_calllog_item, parent, false);
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View r0 = view.findViewById(R.id.conversation_list_item);
        if ((r0 instanceof BlackCallListItem) == false) goto L6;
        ((BlackCallListItem) r0).unbind();
        return;
    }
}
