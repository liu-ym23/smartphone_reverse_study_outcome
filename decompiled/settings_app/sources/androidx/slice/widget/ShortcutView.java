package androidx.slice.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.slice.Slice;
import androidx.slice.SliceItem;
import androidx.slice.view.R;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutView extends SliceChildView {
    private static final String TAG = "ShortcutView";
    private SliceItem mActionItem;
    private SliceItem mIcon;
    private SliceItem mLabel;
    private int mLargeIconSize;
    private ListContent mListContent;
    private Set<SliceItem> mLoadingActions;
    private int mSmallIconSize;
    private Uri mUri;

    @Override // androidx.slice.widget.SliceChildView
    public int getMode() {
        return 3;
    }

    public ShortcutView(Context r2) {
        super(r2);
        Resources r3 = getResources();
        this.mSmallIconSize = r3.getDimensionPixelSize(R.dimen.abc_slice_icon_size);
        this.mLargeIconSize = r3.getDimensionPixelSize(R.dimen.abc_slice_shortcut_size);
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setSliceContent(ListContent r6) {
        resetView();
        this.mListContent = r6;
        if (r6 != null) goto L5;
        return;
    L5:
        ShortcutContent r0 = new ShortcutContent(r6);
        this.mActionItem = r0.getActionItem();
        this.mIcon = r0.getIcon();
        this.mLabel = r0.getLabel();
        SliceItem r1 = this.mIcon;
        if (r1 != null) goto L8;
    L13:
        useAppDataAsFallbackItems(getContext());
    L14:
        SliceItem r2 = r0.getColorItem();
        if (r2 == null) goto L17;
        int r3 = r2.getInt();
    L18:
        Drawable r4 = DrawableCompat.wrap(new ShapeDrawable(new OvalShape()));
        DrawableCompat.setTint(r4, r3);
        ImageView r5 = new ImageView(getContext());
        SliceItem r7 = this.mIcon;
        if (r7 != null) goto L21;
    L23:
        addView(r5);
        SliceItem r8 = this.mIcon;
        if (r8 == null) goto L30;
        boolean r9 = r8.hasHint("no_tint");
        if (r9 == false) goto L28;
        int r10 = this.mLargeIconSize;
    L29:
        SliceViewUtil.createCircledIcon(getContext(), r10, this.mIcon.getIcon(), r9, this);
        this.mUri = r6.getSlice().getUri();
        setClickable(true);
    L31:
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        r11.gravity = 17;
        setLayoutParams(r11);
        return;
    L28:
        r10 = this.mSmallIconSize;
        goto L29
    L30:
        setClickable(false);
        goto L31
    L21:
        if (r7.hasHint("no_tint") == true) goto L23;
        r5.setBackground(r4);
        goto L23
    L17:
        r3 = SliceViewUtil.getColorAccent(getContext());
        goto L18
    L8:
        if (r1.getIcon() == null) goto L13;
        if (this.mLabel == null) goto L13;
        if (this.mActionItem != null) goto L14;
        goto L13
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.mListContent != null) goto L6;
        return false;
    L6:
        if (callOnClick() == false) goto L22;
    L21:
        return true;
    L22:
        SliceItem r0 = this.mActionItem;     // Catch: PendingIntent.CanceledException -> L19
        if (r0 == null) goto L10;
        r0.fireAction(null, null);     // Catch: PendingIntent.CanceledException -> L19
    L12:
        if (this.mObserver == null) goto L21;
        EventInfo r1 = new EventInfo(3, 1, -1, 0);     // Catch: PendingIntent.CanceledException -> L19
        SliceItem r2 = this.mActionItem;     // Catch: PendingIntent.CanceledException -> L19
        if (r2 != null) goto L17;
        r2 = new SliceItem(this.mListContent.getSlice(), "slice", null, this.mListContent.getSlice().getHints());     // Catch: PendingIntent.CanceledException -> L19
    L17:
        this.mObserver.onSliceAction(r1, r2);     // Catch: PendingIntent.CanceledException -> L19
        goto L21
    L10:
        Intent r3 = new Intent("android.intent.action.VIEW").setData(this.mUri);     // Catch: PendingIntent.CanceledException -> L19
        r3.addFlags(268435456);     // Catch: PendingIntent.CanceledException -> L19
        getContext().startActivity(r3);     // Catch: PendingIntent.CanceledException -> L19
    L19:
        e = move-exception;
        Log.e(TAG, "PendingIntent for slice cannot be sent", e);
        goto L21
    }

    private void useAppDataAsFallbackItems(Context r12) {
        Slice r0 = this.mListContent.getSlice();
        PackageManager r1 = r12.getPackageManager();
        ApplicationInfo r2 = r1.resolveContentProvider(r0.getUri().getAuthority(), 0).applicationInfo;
        if (r2 == null) goto L16;
        SliceItem r4 = this.mIcon;
        if (r4 != null) goto L7;
    L8:
        Slice.Builder r5 = new Slice.Builder(r0.getUri());
        r5.addIcon(SliceViewUtil.createIconFromDrawable(r1.getApplicationIcon(r2)), "large", new String[0]);
        this.mIcon = r5.build().getItems().get(0);
    L10:
        if (this.mLabel != null) goto L13;
        Slice.Builder r6 = new Slice.Builder(r0.getUri());
        r6.addText(r1.getApplicationLabel(r2), null, new String[0]);
        this.mLabel = r6.build().getItems().get(0);
    L13:
        if (this.mActionItem != null) goto L17;
        this.mActionItem = new SliceItem(PendingIntent.getActivity(r12, 0, r1.getLaunchIntentForPackage(r2.packageName), 0), new Slice.Builder(r0.getUri()).build(), "action", null, null);
        return;
    L17:
        return;
    L7:
        if (r4.getIcon() != null) goto L10;
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setLoadingActions(Set<SliceItem> r1) {
        this.mLoadingActions = r1;
    }

    @Override // androidx.slice.widget.SliceChildView
    public Set<SliceItem> getLoadingActions() {
        return this.mLoadingActions;
    }

    @Override // androidx.slice.widget.SliceChildView
    public void resetView() {
        this.mListContent = null;
        this.mUri = null;
        this.mActionItem = null;
        this.mLabel = null;
        this.mIcon = null;
        setBackground(null);
        removeAllViews();
    }
}
