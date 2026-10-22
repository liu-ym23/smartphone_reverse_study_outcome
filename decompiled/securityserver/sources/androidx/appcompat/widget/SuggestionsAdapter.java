package androidx.appcompat.widget;

import a.a;
import android.R;
import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.bytedance.librarian.LibrarianImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private static final boolean DBG = false;
    static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE = 0;
    private boolean mClosed;
    private final int mCommitIconResId;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement;
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private ColorStateList mUrlColor;

    public static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View r2) {
            this.mText1 = (TextView) r2.findViewById(R.id.text1);
            this.mText2 = (TextView) r2.findViewById(R.id.text2);
            this.mIcon1 = (ImageView) r2.findViewById(R.id.icon1);
            this.mIcon2 = (ImageView) r2.findViewById(R.id.icon2);
            this.mIconRefine = (ImageView) r2.findViewById(androidx.appcompat.R.id.edit_query);
        }
    }

    public SuggestionsAdapter(Context r4, SearchView r5, SearchableInfo r6, WeakHashMap<String, Drawable.ConstantState> r7) {
        super(r4, r5.getSuggestionRowLayout(), null, true);
        this.mClosed = false;
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchView = r5;
        this.mSearchable = r6;
        this.mCommitIconResId = r5.getSuggestionCommitIconResId();
        this.mProviderContext = r4;
        this.mOutsideDrawablesCache = r7;
    }

    private Drawable checkIconCache(String r1) {
        Drawable.ConstantState r0 = this.mOutsideDrawablesCache.get(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.newDrawable();
    }

    private CharSequence formatUrl(CharSequence r9) {
        if (this.mUrlColor != null) goto L5;
        TypedValue r0 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(androidx.appcompat.R.attr.textColorSearchUrl, r0, true);
        this.mUrlColor = this.mContext.getResources().getColorStateList(r0.resourceId);
    L5:
        SpannableString r1 = new SpannableString(r9);
        r1.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, r9.length(), 33);
        return r1;
    }

    private Drawable getActivityIcon(ComponentName r6) {
        PackageManager r5 = this.mContext.getPackageManager();
        ActivityInfo r1 = r5.getActivityInfo(r6, 128);     // Catch: PackageManager.NameNotFoundException -> L12
        int r3 = r1.getIconResource();
        if (r3 != 0) goto L7;
        return null;
    L7:
        Drawable r7 = r5.getDrawable(r6.getPackageName(), r3, r1.applicationInfo);
        if (r7 != null) goto L11;
        StringBuilder r8 = a.p(r3, "Invalid icon resource ", " for ");
        r8.append(r6.flattenToShortString());
        Log.w(LOG_TAG, r8.toString());
        return null;
    L11:
        return r7;
    L12:
        e = move-exception;
        Log.w(LOG_TAG, e.toString());
        return null;
    }

    private Drawable getActivityIconWithCache(ComponentName r4) {
        String r0 = r4.flattenToShortString();
        Drawable.ConstantState r2 = null;
        if (this.mOutsideDrawablesCache.containsKey(r0) == false) goto L9;
        Drawable.ConstantState r5 = this.mOutsideDrawablesCache.get(r0);
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.newDrawable(this.mProviderContext.getResources());
    L9:
        Drawable r6 = getActivityIcon(r4);
        if (r6 == null) goto L13;
        r2 = r6.getConstantState();
    L13:
        this.mOutsideDrawablesCache.put(r0, r2);
        return r6;
    }

    public static String getColumnString(Cursor r0, String r1) {
        return getStringOrNull(r0, r0.getColumnIndex(r1));
    }

    private Drawable getDefaultIcon1() {
        Drawable r0 = getActivityIconWithCache(this.mSearchable.getSearchActivity());
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable getDrawable(Uri r8) {
    L7:
        e = move-exception;
        Log.w(LOG_TAG, "Icon not found: " + r8 + ", " + e.getMessage());
        return null;
    L4:
        if ("android.resource".equals(r8.getScheme()) == true) goto L33;
        InputStream r7 = this.mProviderContext.getContentResolver().openInputStream(r8);     // Catch: FileNotFoundException -> L7
        if (r7 == null) goto L26;
        Drawable r2 = Drawable.createFromStream(r7, null);     // Catch: Throwable -> L19
    L35:
        r7.close();     // Catch: IOException -> L16
    L18:
        return r2;
    L16:
        e = move-exception;
        Log.e(LOG_TAG, "Error closing icon stream for " + r8, e);     // Catch: FileNotFoundException -> L7
    L19:
        th = move-exception;
        r7.close();     // Catch: IOException -> L22
    L24:
        throw th;     // Catch: FileNotFoundException -> L7
    L22:
        e = move-exception;
        Log.e(LOG_TAG, "Error closing icon stream for " + r8, e);     // Catch: FileNotFoundException -> L7
        goto L24
    L26:
        throw new FileNotFoundException("Failed to open " + r8);     // Catch: FileNotFoundException -> L7
    L33:
        return getDrawableFromResourceUri(r8);
    L10:
        throw new FileNotFoundException("Resource does not exist: " + r8);     // Catch: FileNotFoundException -> L7
    }

    private Drawable getDrawableFromResourceValue(String r5) {
        if (r5 != null) goto L5;
    L21:
        return null;
    L5:
        if (r5.isEmpty() == true) goto L21;
        if ("0".equals(r5) == true) goto L21;
        int r2 = Integer.parseInt(r5);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        String r0 = "android.resource://" + this.mProviderContext.getPackageName() + LibrarianImpl.Constants.SEPARATOR + r2;     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        Drawable r3 = checkIconCache(r0);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        if (r3 == null) goto L12;
        return r3;
    L12:
        Drawable r4 = ContextCompat.getDrawable(this.mProviderContext, r2);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        storeInIconCache(r0, r4);     // Catch: Resources.NotFoundException -> L14 NumberFormatException -> L16
        return r4;
    L14:
        Log.w(LOG_TAG, "Icon resource not found: ".concat(r5));
        return null;
    L16:
        Drawable r1 = checkIconCache(r5);
        if (r1 == null) goto L19;
        return r1;
    L19:
        Drawable r6 = getDrawable(Uri.parse(r5));
        storeInIconCache(r5, r6);
        return r6;
    }

    private Drawable getIcon1(Cursor r3) {
        int r0 = this.mIconName1Col;
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        Drawable r4 = getDrawableFromResourceValue(r3.getString(r0));
        if (r4 == null) goto L10;
        return r4;
    L10:
        return getDefaultIcon1();
    }

    private Drawable getIcon2(Cursor r3) {
        int r0 = this.mIconName2Col;
        if (r0 != (-1)) goto L7;
        return null;
    L7:
        return getDrawableFromResourceValue(r3.getString(r0));
    }

    private static String getStringOrNull(Cursor r2, int r3) {
        if (r3 != (-1)) goto L10;
        return null;
    L10:
        return r2.getString(r3);
    L7:
        e = move-exception;
        Log.e(LOG_TAG, "unexpected error retrieving valid column from cursor, did the remote process die?", e);
        return null;
    }

    private void setViewDrawable(ImageView r1, Drawable r2, int r3) {
        r1.setImageDrawable(r2);
        if (r2 != null) goto L5;
        r1.setVisibility(r3);
        return;
    L5:
        r1.setVisibility(0);
        r2.setVisible(false, false);
        r2.setVisible(true, false);
    }

    private void setViewText(TextView r1, CharSequence r2) {
        r1.setText(r2);
        if (TextUtils.isEmpty(r2) == false) goto L5;
        r1.setVisibility(8);
        return;
    L5:
        r1.setVisibility(0);
    }

    private void storeInIconCache(String r1, Drawable r2) {
        if (r2 == null) goto L5;
        this.mOutsideDrawablesCache.put(r1, r2.getConstantState());
        return;
    }

    private void updateSpinnerState(Cursor r1) {
        if (r1 == null) goto L4;
        Bundle r0 = r1.getExtras();
    L5:
        if (r0 == null) goto L8;
        r0.getBoolean("in_progress");
        return;
    L8:
        return;
    L4:
        r0 = null;
        goto L5
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View r7, Context r8, Cursor r9) {
        ChildViewCache r10 = (ChildViewCache) r7.getTag();
        int r11 = this.mFlagsCol;
        if (r11 == (-1)) goto L5;
        int r12 = r9.getInt(r11);
    L7:
        if (r10.mText1 == null) goto L10;
        setViewText(r10.mText1, getStringOrNull(r9, this.mText1Col));
    L10:
        if (r10.mText2 == null) goto L24;
        String r0 = getStringOrNull(r9, this.mText2UrlCol);
        if (r0 == null) goto L14;
        CharSequence r1 = formatUrl(r0);
    L16:
        if (TextUtils.isEmpty(r1) == false) goto L20;
        TextView r4 = r10.mText1;
        if (r4 == null) goto L23;
        r4.setSingleLine(false);
        r10.mText1.setMaxLines(2);
    L23:
        setViewText(r10.mText2, r1);
        goto L24
    L20:
        TextView r5 = r10.mText1;
        if (r5 == null) goto L23;
        r5.setSingleLine(true);
        r10.mText1.setMaxLines(1);
        goto L23
    L14:
        r1 = getStringOrNull(r9, this.mText2Col);
    L24:
        ImageView r2 = r10.mIcon1;
        if (r2 == null) goto L27;
        setViewDrawable(r2, getIcon1(r9), 4);
    L27:
        ImageView r3 = r10.mIcon2;
        if (r3 == null) goto L30;
        setViewDrawable(r3, getIcon2(r9), 8);
    L30:
        int r13 = this.mQueryRefinement;
        if (r13 == 2) goto L37;
        if (r13 == 1) goto L34;
    L36:
        r10.mIconRefine.setVisibility(8);
        return;
    L34:
        if ((r12 & 1) == 0) goto L36;
    L37:
        r10.mIconRefine.setVisibility(0);
        r10.mIconRefine.setTag(r10.mText1.getText());
        r10.mIconRefine.setOnClickListener(this);
        return;
    L5:
        r12 = 0;
        goto L7
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor r3) {
        if (this.mClosed == false) goto L15;
        Log.w(LOG_TAG, "Tried to change cursor after adapter was closed.");
        if (r3 == null) goto L17;
        r3.close();
        return;
    L17:
        return;
    L15:
        super.changeCursor(r3);     // Catch: Exception -> L12
        if (r3 == null) goto L18;
        this.mText1Col = r3.getColumnIndex("suggest_text_1");     // Catch: Exception -> L12
        this.mText2Col = r3.getColumnIndex("suggest_text_2");     // Catch: Exception -> L12
        this.mText2UrlCol = r3.getColumnIndex("suggest_text_2_url");     // Catch: Exception -> L12
        this.mIconName1Col = r3.getColumnIndex("suggest_icon_1");     // Catch: Exception -> L12
        this.mIconName2Col = r3.getColumnIndex("suggest_icon_2");     // Catch: Exception -> L12
        this.mFlagsCol = r3.getColumnIndex("suggest_flags");     // Catch: Exception -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        Log.e(LOG_TAG, "error changing cursor and caching columns", e);
    }

    public void close() {
        changeCursor(null);
        this.mClosed = true;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        String r1 = getColumnString(r3, "suggest_intent_query");
        if (r1 == null) goto L9;
        return r1;
    L9:
        if (this.mSearchable.shouldRewriteQueryFromData() == false) goto L14;
        String r2 = getColumnString(r3, "suggest_intent_data");
        if (r2 == null) goto L14;
        return r2;
    L14:
        if (this.mSearchable.shouldRewriteQueryFromText() == false) goto L18;
        String r4 = getColumnString(r3, "suggest_text_1");
        if (r4 == null) goto L18;
        return r4;
    L18:
        return null;
    }

    public Drawable getDrawableFromResourceUri(Uri r7) {
        String r0 = r7.getAuthority();
        if (TextUtils.isEmpty(r0) == true) goto L28;
        Resources r6 = this.mContext.getPackageManager().getResourcesForApplication(r0);     // Catch: PackageManager.NameNotFoundException -> L25
        List<String> r1 = r7.getPathSegments();
        if (r1 == null) goto L24;
        int r2 = r1.size();
        if (r2 != 1) goto L14;
        int r3 = Integer.parseInt(r1.get(0));     // Catch: NumberFormatException -> L11
    L16:
        if (r3 == 0) goto L20;
        return r6.getDrawable(r3);
    L20:
        throw new FileNotFoundException("No resource found for: " + r7);
    L12:
        throw new FileNotFoundException("Single path segment is not a resource ID: " + r7);
    L14:
        if (r2 != 2) goto L22;
        r3 = r6.getIdentifier(r1.get(1), r1.get(0), r0);
        goto L16
    L22:
        throw new FileNotFoundException("More than two path segments: " + r7);
    L24:
        throw new FileNotFoundException("No path: " + r7);
    L26:
        throw new FileNotFoundException("No package found for authority: " + r7);
    L28:
        throw new FileNotFoundException("No authority: " + r7);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r2, View r3, ViewGroup r4) {
        return super.getDropDownView(r2, r3, r4);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e);
        View r1 = newDropDownView(this.mContext, this.mCursor, r4);
        if (r1 == null) goto L8;
        ((ChildViewCache) r1.getTag()).mText1.setText(e.toString());
    L8:
        return r1;
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    public Cursor getSearchManagerSuggestions(SearchableInfo r10, String r11, int r12) {
        String[] r0 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        String r1 = r10.getSuggestAuthority();
        if (r1 != null) goto L8;
        return null;
    L8:
        Uri.Builder r2 = new Uri.Builder().scheme("content").authority(r1).query("").fragment("");
        String r3 = r10.getSuggestPath();
        if (r3 == null) goto L11;
        r2.appendEncodedPath(r3);
    L11:
        r2.appendPath("search_suggest_query");
        String r6 = r10.getSuggestSelection();
        if (r6 == null) goto L15;
        r0 = new String[]{r11};
    L14:
        String[] r7 = r0;
        if (r12 <= 0) goto L19;
        r2.appendQueryParameter("limit", String.valueOf(r12));
    L19:
        return this.mContext.getContentResolver().query(r2.build(), null, r6, r7, null);
    L15:
        r2.appendPath(r11);
        goto L14
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int r2, View r3, ViewGroup r4) {
        return super.getView(r2, r3, r4);
    L4:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e);
        View r1 = newView(this.mContext, this.mCursor, r4);
        if (r1 == null) goto L8;
        ((ChildViewCache) r1.getTag()).mText1.setText(e.toString());
    L8:
        return r1;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context r1, Cursor r2, ViewGroup r3) {
        View r4 = super.newView(r1, r2, r3);
        r4.setTag(new ChildViewCache(r4));
        ((ImageView) r4.findViewById(androidx.appcompat.R.id.edit_query)).setImageResource(this.mCommitIconResId);
        return r4;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        Object r3 = r2.getTag();
        if ((r3 instanceof CharSequence) == false) goto L6;
        this.mSearchView.onQueryRefine((CharSequence) r3);
        return;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence r4) {
        if (r4 != null) goto L4;
        String r5 = "";
    L6:
        if (this.mSearchView.getVisibility() == 0) goto L8;
    L16:
        return null;
    L8:
        if (this.mSearchView.getWindowVisibility() != 0) goto L16;
        Cursor r3 = getSearchManagerSuggestions(this.mSearchable, r5, 50);     // Catch: RuntimeException -> L14
        if (r3 == null) goto L16;
        r3.getCount();     // Catch: RuntimeException -> L14
        return r3;
    L14:
        e = move-exception;
        Log.w(LOG_TAG, "Search suggestions query threw an exception.", e);
        goto L16
    L4:
        r5 = r4.toString();
        goto L6
    }

    public void setQueryRefinement(int r1) {
        this.mQueryRefinement = r1;
    }
}
