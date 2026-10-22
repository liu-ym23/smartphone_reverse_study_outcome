package androidx.slice.core;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.SliceItem;
import com.android.settings.inputmethod.UserDictionaryAddWordContents;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.obric.oui.material.MaterialConfigFormatNames;

/* JADX INFO: loaded from: classes.dex */
public class SliceActionImpl implements SliceAction {
    private PendingIntent mAction;
    private SliceItem mActionItem;
    private CharSequence mContentDescription;
    private IconCompat mIcon;
    private int mImageMode;
    private boolean mIsActivity;
    private boolean mIsChecked;
    private boolean mIsToggle;
    private int mPriority;
    private SliceItem mSliceItem;
    private CharSequence mTitle;

    @Override // androidx.slice.core.SliceAction
    public /* bridge */ /* synthetic */ SliceAction setChecked(boolean r1) {
        return setChecked(r1);
    }

    @Override // androidx.slice.core.SliceAction
    public /* bridge */ /* synthetic */ SliceAction setContentDescription(CharSequence r1) {
        return setContentDescription(r1);
    }

    @Override // androidx.slice.core.SliceAction
    public /* bridge */ /* synthetic */ SliceAction setPriority(int r1) {
        return setPriority(r1);
    }

    public SliceActionImpl(PendingIntent r2, IconCompat r3, CharSequence r4) {
        this(r2, r3, 0, r4);
    }

    public SliceActionImpl(PendingIntent r2, IconCompat r3, int r4, CharSequence r5) {
        this.mPriority = -1;
        this.mAction = r2;
        this.mIcon = r3;
        this.mTitle = r5;
        this.mImageMode = r4;
    }

    public SliceActionImpl(PendingIntent r2, IconCompat r3, CharSequence r4, boolean r5) {
        this(r2, r3, 0, r4);
        this.mIsChecked = r5;
        this.mIsToggle = true;
    }

    public SliceActionImpl(PendingIntent r2, CharSequence r3, boolean r4) {
        this.mImageMode = 3;
        this.mPriority = -1;
        this.mAction = r2;
        this.mTitle = r3;
        this.mIsToggle = true;
        this.mIsChecked = r4;
    }

    public SliceActionImpl(SliceItem r6) {
        this.mImageMode = 3;
        int r0 = -1;
        this.mPriority = -1;
        this.mSliceItem = r6;
        SliceItem r7 = SliceQuery.find(r6, "action");
        if (r7 != null) goto L5;
        return;
    L5:
        this.mActionItem = r7;
        this.mAction = r7.getAction();
        SliceItem r1 = SliceQuery.find(r7.getSlice(), SlardarSettingsConsts.SETTING_IMAGE);
        if (r1 == null) goto L15;
        this.mIcon = r1.getIcon();
        if (r1.hasHint("no_tint") == true) goto L10;
        int r2 = 0;
    L14:
        this.mImageMode = r2;
        goto L15
    L10:
        if (r1.hasHint("large") == false) goto L12;
        r2 = 2;
        goto L14
    L12:
        r2 = 1;
    L15:
        SliceItem r3 = SliceQuery.find(r7.getSlice(), "text", "title", null);
        if (r3 == null) goto L18;
        this.mTitle = r3.getText();
    L18:
        SliceItem r4 = SliceQuery.findSubtype(r7.getSlice(), "text", "content_description");
        if (r4 == null) goto L21;
        this.mContentDescription = r4.getText();
    L21:
        boolean r5 = "toggle".equals(r7.getSubType());
        this.mIsToggle = r5;
        if (r5 == false) goto L24;
        this.mIsChecked = r7.hasHint(MaterialConfigFormatNames.SELECTED);
    L24:
        this.mIsActivity = this.mSliceItem.hasHint("activity");
        SliceItem r8 = SliceQuery.findSubtype(r7.getSlice(), "int", "priority");
        if (r8 == null) goto L27;
        r0 = r8.getInt();
    L27:
        this.mPriority = r0;
    }

    @Override // androidx.slice.core.SliceAction
    public SliceActionImpl setContentDescription(CharSequence r1) {
        this.mContentDescription = r1;
        return this;
    }

    @Override // androidx.slice.core.SliceAction
    public SliceActionImpl setChecked(boolean r1) {
        this.mIsChecked = r1;
        return this;
    }

    @Override // androidx.slice.core.SliceAction
    public SliceActionImpl setPriority(int r1) {
        this.mPriority = r1;
        return this;
    }

    @Override // androidx.slice.core.SliceAction
    public PendingIntent getAction() {
        PendingIntent r0 = this.mAction;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.mActionItem.getAction();
    }

    public SliceItem getActionItem() {
        return this.mActionItem;
    }

    @Override // androidx.slice.core.SliceAction
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @Override // androidx.slice.core.SliceAction
    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // androidx.slice.core.SliceAction
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @Override // androidx.slice.core.SliceAction
    public int getPriority() {
        return this.mPriority;
    }

    @Override // androidx.slice.core.SliceAction
    public boolean isToggle() {
        return this.mIsToggle;
    }

    @Override // androidx.slice.core.SliceAction
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // androidx.slice.core.SliceAction
    public int getImageMode() {
        return this.mImageMode;
    }

    @Override // androidx.slice.core.SliceAction
    public boolean isDefaultToggle() {
        if (this.mIsToggle == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIcon != null) goto L7;
        return true;
    }

    public SliceItem getSliceItem() {
        return this.mSliceItem;
    }

    @Override // androidx.slice.core.SliceAction
    public boolean isActivity() {
        return this.mIsActivity;
    }

    public Slice buildSlice(Slice.Builder r3) {
        return r3.addHints(new String[]{UserDictionaryAddWordContents.EXTRA_SHORTCUT}).addAction(this.mAction, buildSliceContent(r3).build(), getSubtype()).build();
    }

    public Slice buildPrimaryActionSlice(Slice.Builder r2) {
        return buildSliceContent(r2).addHints(new String[]{UserDictionaryAddWordContents.EXTRA_SHORTCUT, "title"}).build();
    }

    private Slice.Builder buildSliceContent(Slice.Builder r6) {
        Slice.Builder r0 = new Slice.Builder(r6);
        IconCompat r1 = this.mIcon;
        if (r1 != null) goto L5;
    L9:
        CharSequence r2 = this.mTitle;
        if (r2 == null) goto L12;
        r0.addText(r2, null, new String[]{"title"});
    L12:
        CharSequence r3 = this.mContentDescription;
        if (r3 == null) goto L16;
        r0.addText(r3, "content_description", new String[0]);
    L16:
        if (this.mIsToggle == true) goto L18;
    L20:
        int r4 = this.mPriority;
        if (r4 == (-1)) goto L24;
        r0.addInt(r4, "priority", new String[0]);
    L24:
        if (this.mIsActivity == false) goto L26;
        r6.addHints(new String[]{"activity"});
    L26:
        return r0;
    L18:
        if (this.mIsChecked == false) goto L20;
        r0.addHints(new String[]{MaterialConfigFormatNames.SELECTED});
        goto L20
    L5:
        if (this.mImageMode != 0) goto L7;
        String[] r5 = new String[0];
    L8:
        r0.addIcon(r1, null, r5);
        goto L9
    L7:
        r5 = new String[]{"no_tint"};
        goto L8
    }

    public String getSubtype() {
        if (this.mIsToggle == false) goto L5;
        return "toggle";
    L5:
        return null;
    }

    public void setActivity(boolean r1) {
        this.mIsActivity = r1;
    }
}
