package androidx.slice.widget;

import androidx.slice.Slice;
import androidx.slice.SliceItem;
import androidx.slice.core.SliceActionImpl;
import androidx.slice.core.SliceQuery;
import com.bytedance.apm.constant.SlardarSettingsConsts;

/* JADX INFO: loaded from: classes.dex */
public class ShortcutContent {
    private SliceItem mActionItem;
    private SliceItem mColorItem;
    private final boolean mHasTopLevelColorItem;
    private SliceItem mIcon;
    private SliceItem mLabel;

    public ShortcutContent(ListContent r7) {
        Slice r0 = r7.getSlice();
        SliceItem r1 = r7.getColorItem();
        this.mColorItem = r1;
        if (r1 == null) goto L5;
        boolean r2 = true;
    L6:
        this.mHasTopLevelColorItem = r2;
        if (r2 == true) goto L9;
        this.mColorItem = SliceQuery.findSubtype(r0, "int", "color");
    L9:
        SliceItem r8 = r7.getPrimaryAction();
        if (r8 == null) goto L13;
        SliceActionImpl r5 = new SliceActionImpl(r8);
        this.mActionItem = r5.getActionItem();
        this.mIcon = SliceQuery.find(r5.getSliceItem(), SlardarSettingsConsts.SETTING_IMAGE, "title", null);
        SliceItem r9 = r5.getSliceItem();
        String r6 = (String) null;
        this.mLabel = SliceQuery.find(r9, "text", null, null);
    L13:
        if (this.mActionItem != null) goto L15;
        String r10 = (String) null;
        this.mActionItem = SliceQuery.find(r0, "action", null, null);
    L15:
        SliceItem r11 = this.mIcon;
        if (r11 != null) goto L18;
    L19:
        this.mIcon = SliceQuery.find(r0, SlardarSettingsConsts.SETTING_IMAGE, "title", null);
    L21:
        if (this.mLabel != null) goto L23;
        this.mLabel = SliceQuery.find(r0, "text", "title", null);
    L23:
        SliceItem r12 = this.mIcon;
        if (r12 != null) goto L26;
    L27:
        String r13 = (String) null;
        this.mIcon = SliceQuery.find(r0, SlardarSettingsConsts.SETTING_IMAGE, null, null);
    L29:
        if (this.mLabel != null) goto L32;
        String r14 = (String) null;
        this.mLabel = SliceQuery.find(r0, "text", null, null);
        return;
    L32:
        return;
    L26:
        if (r12.getIcon() != null) goto L29;
    L18:
        if (r11.getIcon() != null) goto L21;
    L5:
        r2 = false;
        goto L6
    }

    public SliceItem getActionItem() {
        return this.mActionItem;
    }

    public SliceItem getLabel() {
        return this.mLabel;
    }

    public SliceItem getIcon() {
        return this.mIcon;
    }

    public SliceItem getColorItem() {
        return this.mColorItem;
    }

    public Slice buildSlice(Slice.Builder r3) {
        Slice.Builder r0 = new Slice.Builder(r3);
        SliceItem r1 = this.mActionItem;
        if (r1 == null) goto L5;
        r0.addItem(r1);
    L5:
        SliceItem r2 = this.mLabel;
        if (r2 == null) goto L8;
        r0.addItem(r2);
    L8:
        SliceItem r4 = this.mIcon;
        if (r4 == null) goto L12;
        r0.addItem(r4);
    L12:
        if (this.mHasTopLevelColorItem == true) goto L17;
        SliceItem r5 = this.mColorItem;
        if (r5 == null) goto L17;
        r0.addItem(r5);
    L17:
        return r3.addSubSlice(r0.build()).build();
    }
}
