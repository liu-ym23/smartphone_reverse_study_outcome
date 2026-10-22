package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {
    private CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;
    protected int[] mTo;
    private ViewBinder mViewBinder;

    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor r1);
    }

    public interface ViewBinder {
        boolean setViewValue(View r1, Cursor r2, int r3);
    }

    @Deprecated
    public SimpleCursorAdapter(Context r1, int r2, Cursor r3, String[] r4, int[] r5) {
        super(r1, r2, r3);
        this.mStringConversionColumn = -1;
        this.mTo = r5;
        this.mOriginalFrom = r4;
        findColumns(r3, r4);
    }

    public SimpleCursorAdapter(Context r1, int r2, Cursor r3, String[] r4, int[] r5, int r6) {
        super(r1, r2, r3, r6);
        this.mStringConversionColumn = -1;
        this.mTo = r5;
        this.mOriginalFrom = r4;
        findColumns(r3, r4);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View r9, Context r10, Cursor r11) {
        ViewBinder r12 = this.mViewBinder;
        int[] r0 = this.mTo;
        int r1 = r0.length;
        int[] r2 = this.mFrom;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L22;
        View r5 = r9.findViewById(r0[r4]);
        if (r5 == null) goto L21;
        if (r12 == null) goto L8;
        boolean r6 = r12.setViewValue(r5, r11, r2[r4]);
    L9:
        if (r6 == true) goto L21;
        String r7 = r11.getString(r2[r4]);
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        if ((r5 instanceof TextView) == false) goto L17;
        setViewText((TextView) r5, r7);
        goto L21
    L17:
        if ((r5 instanceof ImageView) == false) goto L20;
        setViewImage((ImageView) r5, r7);
        goto L21
    L20:
        throw new IllegalStateException(r5.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
    L8:
        r6 = false;
    L21:
        r4 = r4 + 1;
        goto L3
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setViewBinder(ViewBinder r1) {
        this.mViewBinder = r1;
    }

    public void setViewImage(ImageView r1, String r2) {
        r1.setImageResource(Integer.parseInt(r2));     // Catch: NumberFormatException -> L4
        return;
    L4:
        r1.setImageURI(Uri.parse(r2));
    }

    public void setViewText(TextView r1, String r2) {
        r1.setText(r2);
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public void setStringConversionColumn(int r1) {
        this.mStringConversionColumn = r1;
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public void setCursorToStringConverter(CursorToStringConverter r1) {
        this.mCursorToStringConverter = r1;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor r3) {
        CursorToStringConverter r0 = this.mCursorToStringConverter;
        if (r0 != null) goto L5;
        int r1 = this.mStringConversionColumn;
        if (r1 <= (-1)) goto L11;
        return r3.getString(r1);
    L11:
        return super.convertToString(r3);
    L5:
        return r0.convertToString(r3);
    }

    private void findColumns(Cursor r5, String[] r6) {
        if (r5 == null) goto L11;
        int r0 = r6.length;
        int[] r1 = this.mFrom;
        if (r1 != null) goto L6;
    L7:
        this.mFrom = new int[r0];
    L8:
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L14;
        this.mFrom[r2] = r5.getColumnIndexOrThrow(r6[r2]);
        r2 = r2 + 1;
        goto L9
    L14:
        return;
    L6:
        if (r1.length == r0) goto L8;
    L11:
        this.mFrom = null;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor r2) {
        findColumns(r2, this.mOriginalFrom);
        return super.swapCursor(r2);
    }

    public void changeCursorAndColumns(Cursor r1, String[] r2, int[] r3) {
        this.mOriginalFrom = r2;
        this.mTo = r3;
        findColumns(r1, r2);
        super.changeCursor(r1);
    }
}
