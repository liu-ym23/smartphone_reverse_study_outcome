package com.bytedanceos.preventdisturb;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CursorAdapter;
import com.bytedanceos.preventdisturb.widget.ConversationListItem;
import com.bytedanceos.preventdisturb.widget.OConversationListItem;
import com.obric.oui.bouncelayout.OListView;
import com.obric.security.R;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class ConversationListAdapter extends CursorAdapter implements AbsListView.RecyclerListener {
    public static final int ITEM_LIST_TYPE = 0;
    public static final int ITEM_LIST_TYPE2 = 1;
    public static final String ITEM_TYPE = "item_type";
    public static final int ITEM_TYPE_INDEX = 13;
    private static final boolean LOCAL_LOGV = false;
    public static final int PHONE_ID_INDEX = 1;
    public static final String READ_BY_USER = "read_by_user";
    public static final String SELECT_ID = "select_id";
    public static final int SELECT_ID_INDEX = 12;
    private static final String TAG = "ConversationListAdapter";
    private ConversationListAdapterListener mAdapterListener;
    private ConversationAdapterAnimHelper mAnimHelper;
    private final LayoutInflater mFactory;
    private String mHighlight;
    private boolean mIsEditMode;
    private boolean mIsSpam;
    private SparseBooleanArray mMarkAsReadList;
    private View.OnClickListener mScrollBtnsClickListener;
    private HashSet<Long> mSelectedThreadIds;

    public interface ConversationListAdapterListener {
        void onContentChanged(ConversationListAdapter adapter);

        void onCursorChanged(Cursor cursor);

        void onScrollBtnClick(View v);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    static /* synthetic */ ConversationListAdapterListener access$000(ConversationListAdapter r0) {
        return r0.mAdapterListener;
    }

    public ConversationListAdapter(Context context, Cursor cursor, ConversationListAdapterListener listener, boolean isSpam) {
        super(context, cursor, false);
        this.mSelectedThreadIds = new HashSet();
        this.mMarkAsReadList = new SparseBooleanArray();
        this.mScrollBtnsClickListener = new AnonymousClass1(this);
        this.mAdapterListener = listener;
        this.mFactory = LayoutInflater.from(context);
        this.mIsSpam = isSpam;
        this.mAnimHelper = new ConversationAdapterAnimHelper(context);
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public Object getItem(int position) {
        Cursor r0 = getCursor();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isClosed() == false) goto L7;
        return null;
    L7:
        if (r0.moveToPosition(position) == true) goto L9;
        return null;
    L9:
        return Conversation.from(this.mFactory.getContext(), r0, this.mIsSpam);
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
    public void bindView(View view, final Context context, final Cursor cursor) {
        boolean r1 = true;
        if (getItemViewType(cursor) == 1) goto L13;
        Conversation r4 = Conversation.from(context, cursor, this.mIsSpam);
        OConversationListItem r9 = (OConversationListItem) view;
        if (this.mIsEditMode == true) goto L8;
    L10:
        r1 = false;
    L11:
        boolean r5 = this.mIsEditMode;
        r9.bind(context, r4, r5, r1, this.mHighlight);
        r9.mScrollDelBtn.setOnClickListener(this.mScrollBtnsClickListener);
        r9.mScrollUnBlockBtn.setOnClickListener(this.mScrollBtnsClickListener);
        return;
    L8:
        if (this.mSelectedThreadIds.contains(Long.valueOf(r4.getThreadId())) == false) goto L10;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View r0 = view.findViewById(R.id.conversation_list_item);
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof ConversationListItem) == false) goto L9;
        ((ConversationListItem) r0).unbind();
        return;
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return this.mFactory.inflate(R.layout.conversation_list_item_oswipe, parent, false);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
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
        return getItemViewType(r0);
    }

    public boolean isItemRead(int position, OListView listView) {
        if (listView == null) goto L4;
        position = position - listView.getHeaderViewsCount();
    L4:
        Cursor r1 = getCursor();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.isClosed() == false) goto L9;
        return false;
    L9:
        if (r1.moveToPosition(position) == true) goto L11;
        return false;
    L11:
        if (r1.getInt(r1.getColumnIndex(ProviderConstants.Sms.READ)) == 0) goto L17;
        return true;
    L17:
        return false;
    }

    public boolean isItemReadByUser(int position, OListView listView) {
        if (listView == null) goto L4;
        position = position - listView.getHeaderViewsCount();
    L4:
        Cursor r1 = getCursor();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.isClosed() == false) goto L9;
        return false;
    L9:
        if (r1.moveToPosition(position) == true) goto L11;
        return false;
    L11:
        if (r1.getInt(r1.getColumnIndex(READ_BY_USER)) == 0) goto L17;
        return true;
    L17:
        return false;
    }

    private int getItemViewType(Cursor cursor) {
        if (cursor.getColumnIndex(ITEM_TYPE) != (-1)) goto L6;
        return 0;
    L6:
        return cursor.getInt(13);
    }

    public long getItemPhoneId(int position, OListView listView) {
        if (listView == null) goto L4;
        position = position - listView.getHeaderViewsCount();
    L4:
        Cursor r0 = getCursor();
        if (r0 != null) goto L7;
        return 0;
    L7:
        if (r0.isClosed() == false) goto L9;
        return 0;
    L9:
        if (r0.moveToPosition(position) == false) goto L15;
        r0.getColumnIndex(ITEM_TYPE);
        return r0.getLong(1);
    L15:
        return 0;
    }

    public long getItemSelectId(int position, OListView listView) {
        if (listView == null) goto L4;
        position = position - listView.getHeaderViewsCount();
    L4:
        Cursor r0 = getCursor();
        if (r0 != null) goto L7;
        return -1;
    L7:
        if (r0.isClosed() == false) goto L9;
        return -1;
    L9:
        if (r0.moveToPosition(position) == true) goto L11;
        return -1;
    L11:
        if (r0.getColumnIndex(SELECT_ID) != (-1)) goto L13;
        return -1;
    L13:
        return r0.getLong(12);
    }

    @Override // android.widget.CursorAdapter
    public void changeCursor(Cursor cursor) {
        this.mAdapterListener.onCursorChanged(cursor);
        super.changeCursor(cursor);
    }

    @Override // android.widget.CursorAdapter
    protected void onContentChanged() {
        if (getCursor() != null) goto L5;
        return;
    L5:
        if (getCursor().isClosed() == true) goto L9;
        this.mAdapterListener.onContentChanged(this);
        return;
    }

    private boolean showHeaderView(Cursor cursor) {
        boolean r1 = true;
        if (cursor.moveToPrevious() == true) goto L5;
    L9:
        return r1;
    L5:
        if (getItemViewType(cursor) == 0) goto L8;
        r1 = false;
    L8:
        cursor.moveToNext();
        goto L9
    }

    public MatrixCursor getMatrixCursorWithoutSelect(HashSet<Long> selectedIds, Cursor cursor) {
        if (cursor != null) goto L4;
        return null;
    L4:
        if (cursor.isClosed() == true) goto L23;
        MatrixCursor r0 = new MatrixCursor(cursor.getColumnNames());
        if (cursor.moveToFirst() == false) goto L17;
    L8:
        ArrayList r1 = new ArrayList();
        int r2 = cursor.getColumnCount();
        if (selectedIds.contains(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id")))) == true) goto L16;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L14;
        r1.add(getCursorValue(cursor, r3));
        r3 = r3 + 1;
        goto L12
    L14:
        r0.addRow(r1);
    L16:
        if (cursor.moveToNext() == true) goto L8;
    L17:
        return r0;
    L23:
        return null;
    }

    public void setHightlight(String highlight) {
        this.mHighlight = highlight;
    }

    public boolean isEditMode() {
        return this.mIsEditMode;
    }

    public void setEditMode(boolean isEditMode) {
        this.mIsEditMode = isEditMode;
    }

    public HashSet<Long> getSelectedThreadIds() {
        return this.mSelectedThreadIds;
    }

    public SparseBooleanArray getMarkAsReadList() {
        return this.mMarkAsReadList;
    }

    public ConversationAdapterAnimHelper getAnimHelper() {
        return this.mAnimHelper;
    }

    private Object getCursorValue(Cursor cursor, int columnIndex) {
        int r1 = cursor.getType(columnIndex);
        if (r1 != 0) goto L5;
        return null;
    L5:
        if (r1 == 1) goto L21;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L17;
        if (r1 != 4) goto L15;
        return cursor.getBlob(columnIndex);
    L15:
        throw new IllegalStateException("Invalid or unhandled data type");
    L17:
        return cursor.getString(columnIndex);
    L19:
        return Float.valueOf(cursor.getFloat(columnIndex));
    L21:
        return Long.valueOf(cursor.getLong(columnIndex));
    }
}
