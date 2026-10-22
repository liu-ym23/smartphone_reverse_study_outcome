package com.obric.security.cleaner.bigfile;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.oui.OCardListItemExtKt;
import com.bytedanceos.security.Utils;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.OViewStyleController;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.toast.OToast;
import com.obric.security.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import obric.app.ProgressDialog;

/* JADX INFO: compiled from: BigFileItemViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u00013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010%\u001a\u0004\u0018\u00010\u0012J\b\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010)\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010,\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010-\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010.\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010/\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u00100\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u00101\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u00102\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/security/cleaner/bigfile/BigFileItemViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "adapter", "Lcom/obric/security/cleaner/bigfile/BigFileListAdapter;", "bigFileViewModel", "Lcom/obric/security/cleaner/bigfile/BigFileViewModel;", "checkBox", "Lcom/obric/oui/checkbox/OCheckBoxLayout;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBoxLayout;", "setCheckBox", "(Lcom/obric/oui/checkbox/OCheckBoxLayout;)V", "data", "Lcom/obric/security/cleaner/bigfile/BigFileScanResultItem;", "dialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "dialogBody", "Landroid/widget/LinearLayout;", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "getIconView", "()Landroidx/appcompat/widget/AppCompatImageView;", "setIconView", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "listItem", "Lcom/obric/oui/lisitem/OCardListItem;", "getListItem", "()Lcom/obric/oui/lisitem/OCardListItem;", "setListItem", "(Lcom/obric/oui/lisitem/OCardListItem;)V", "mProgressDialog", "Lobric/app/ProgressDialog;", "subfix", "", "getDetailDialog", "initView", "", "loadImage", "onBind", Utils.INTENT_KEY_INDEX, "", "onClickItem", "openFileManager", "openImage", "openMusic", "openVideo", "showDetailDialog", "updateDialogBody", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BigFileItemViewHolder extends RecyclerView.ViewHolder {
    public static final String ACTION_VIEW_FOLDER = "com.bytedance.action.VIEW_FOLDER";
    public static final Companion Companion = null;
    public static final String FILE_PATH = "path";
    public static final String INTENT_FILE_DATA = "file_data";
    private BigFileListAdapter adapter;
    private BigFileViewModel bigFileViewModel;
    private OCheckBoxLayout checkBox;
    private BigFileScanResultItem data;
    private OAlertDialog dialog;
    private LinearLayout dialogBody;
    private AppCompatImageView iconView;
    private OCardListItem listItem;
    private final ProgressDialog mProgressDialog;
    private String subfix;

    /* JADX INFO: compiled from: BigFileItemViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/security/cleaner/bigfile/BigFileItemViewHolder$Companion;", "", "()V", "ACTION_VIEW_FOLDER", "", "FILE_PATH", "INTENT_FILE_DATA", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BigFileItemViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.subfix = "";
        this.listItem = (OCardListItem) r2.findViewById(R.id.item);
        initView();
    }

    public static final /* synthetic */ BigFileListAdapter access$getAdapter$p(BigFileItemViewHolder r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ BigFileViewModel access$getBigFileViewModel$p(BigFileItemViewHolder r0) {
        return r0.bigFileViewModel;
    }

    public static final /* synthetic */ BigFileScanResultItem access$getData$p(BigFileItemViewHolder r0) {
        return r0.data;
    }

    public static final /* synthetic */ LinearLayout access$getDialogBody$p(BigFileItemViewHolder r0) {
        return r0.dialogBody;
    }

    public static final /* synthetic */ void access$onClickItem(BigFileItemViewHolder r0, BigFileScanResultItem r1) {
        r0.onClickItem(r1);
    }

    public static final /* synthetic */ void access$openFileManager(BigFileItemViewHolder r0, BigFileScanResultItem r1) {
        r0.openFileManager(r1);
    }

    public static final /* synthetic */ void access$setAdapter$p(BigFileItemViewHolder r0, BigFileListAdapter r1) {
        r0.adapter = r1;
    }

    public static final /* synthetic */ void access$setBigFileViewModel$p(BigFileItemViewHolder r0, BigFileViewModel r1) {
        r0.bigFileViewModel = r1;
    }

    public static final /* synthetic */ void access$setData$p(BigFileItemViewHolder r0, BigFileScanResultItem r1) {
        r0.data = r1;
    }

    public static final /* synthetic */ void access$setDialogBody$p(BigFileItemViewHolder r0, LinearLayout r1) {
        r0.dialogBody = r1;
    }

    public final OCardListItem getListItem() {
        return this.listItem;
    }

    public final void setListItem(OCardListItem r1) {
        this.listItem = r1;
    }

    public final AppCompatImageView getIconView() {
        return this.iconView;
    }

    public final void setIconView(AppCompatImageView r1) {
        this.iconView = r1;
    }

    public final OCheckBoxLayout getCheckBox() {
        return this.checkBox;
    }

    public final void setCheckBox(OCheckBoxLayout r1) {
        this.checkBox = r1;
    }

    public final void onBind(final BigFileScanResultItem r10, int r11, BigFileListAdapter r12) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r12, "adapter");
        this.data = r10;
        this.adapter = r12;
        View r13 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r13, "itemView");
        Object r14 = r13.getContext();
        Boolean r0 = null;
        if ((r14 instanceof ViewModelStoreOwner) == true) goto L5;
        r14 = null;
    L5:
        ViewModelStoreOwner r15 = (ViewModelStoreOwner) r14;
        if (r15 == null) goto L8;
        this.bigFileViewModel = (BigFileViewModel) new ViewModelProvider(r15).get(BigFileViewModel.class);
    L8:
        OCardListItem r16 = this.listItem;
        if (r16 == null) goto L11;
        r16.setTitle(r10.mName);
    L11:
        OCardListItem r17 = this.listItem;
        if (r17 == null) goto L14;
        r17.setSubTitle(r10.absolutePath);
    L14:
        OCardListItem r18 = this.listItem;
        if (r18 == null) goto L17;
        r18.showSubTitle(true);
    L17:
        OCardListItem r19 = this.listItem;
        if (r19 == null) goto L20;
        TextView r110 = (TextView) r19.findViewById(R.id.title);
    L21:
        if (r110 == null) goto L23;
        r110.setSingleLine(true);
    L23:
        if (r110 == null) goto L25;
        r110.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    L25:
        OCardListItem r111 = this.listItem;
        if (r111 == null) goto L28;
        TextView r112 = (TextView) r111.findViewById(R.id.sub_title);
    L29:
        if (r112 == null) goto L31;
        r112.setSingleLine(true);
    L31:
        if (r112 == null) goto L33;
        r112.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    L33:
        loadImage(r10);
        ByteUnitPair r113 = ByteConverter.convert(r10.mSize, "B", 1024);
        OCardListItem r1 = this.listItem;
        if (r1 == null) goto L36;
        OCardListItemExtKt.setEndText(r1, r113.getValue() + r113.getUnit());
    L36:
        String r114 = r10.mName;
        Intrinsics.checkNotNullExpressionValue(r114, "data.mName");
        String r2 = r10.mName;
        Intrinsics.checkNotNullExpressionValue(r2, "data.mName");
        String r115 = r114.substring(StringsKt.lastIndexOf$default(r2, LibrarianImpl.Constants.DOT, 0, false, 6, null) + 1);
        Intrinsics.checkNotNullExpressionValue(r115, "this as java.lang.String).substring(startIndex)");
        this.subfix = r115;
        OCardListItem r116 = this.listItem;
        if (r116 == null) goto L39;
        r116.setOnContentClickListener(new AnonymousClass2(this, r10));
    L39:
        OCheckBoxLayout r117 = this.checkBox;
        if (r117 == null) goto L42;
        r117.setOnCheckedChangeListener(null);
    L42:
        OCheckBoxLayout r118 = this.checkBox;
        if (r118 == null) goto L50;
        BigFileViewModel r3 = this.bigFileViewModel;
        if (r3 == null) goto L49;
        HashMap<String, Boolean> r4 = r3.getSelectedItem();
        if (r4 == null) goto L49;
        r0 = r4.get(r10.mPath);
    L49:
        r118.setChecked(Intrinsics.areEqual(r0, true));
    L50:
        OCheckBoxLayout r119 = this.checkBox;
        if (r119 == null) goto L54;
        r119.setOnCheckedChangeListener(new BigFileItemViewHolder$onBind$$inlined$apply$lambda$1(this, r10));
        return;
    L54:
        return;
    L28:
        r112 = null;
        goto L29
    L20:
        r110 = null;
        goto L21
    }

    private final void onClickItem(BigFileScanResultItem r3) {
        int r0 = r3.fileType;
        if (r0 != 0) goto L5;
    L18:
        showDetailDialog(r3);
        return;
    L5:
        if (r0 != 1) goto L7;
        openImage(r3);
        return;
    L7:
        if (r0 != 2) goto L9;
        openVideo(r3);
        return;
    L9:
        if (r0 != 3) goto L11;
        openMusic(r3);
        return;
    L11:
        if (r0 == 4) goto L18;
        if (r0 == 5) goto L18;
    }

    public final void openImage(BigFileScanResultItem r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Uri r0 = r4.imageContentUri;     // Catch: Exception -> L14
        if (r4.imageContentUri != null) goto L6;
        OCardListItem r1 = this.listItem;     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L14
        r0 = FileUtils.getUriForFile(r1.getContext(), r4.mPath);     // Catch: Exception -> L14
    L6:
        Intent r2 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L14
        r2.setDataAndType(r0, r4.mimeType);     // Catch: Exception -> L14
        r2.setPackage("com.android.gallery3d");     // Catch: Exception -> L14
        r2.addFlags(1);     // Catch: Exception -> L14
        OCardListItem r3 = this.listItem;     // Catch: Exception -> L14
        if (r3 == null) goto L9;
        Context r5 = r3.getContext();     // Catch: Exception -> L14
    L10:
        Activity r6 = (Activity) r5;     // Catch: Exception -> L14
        if (r6 == null) goto L17;
        r6.startActivity(r2);     // Catch: Exception -> L14
        return;
    L17:
        return;
    L9:
        r5 = null;
    }

    public final void openVideo(BigFileScanResultItem r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        OCardListItem r0 = this.listItem;
        Intrinsics.checkNotNull(r0);
        Uri r1 = FileUtils.getUriForFile(r0.getContext(), r4.mPath);
        Intent r2 = new Intent("android.intent.action.VIEW");
        r2.setDataAndType(r1, r4.mimeType);
        r2.setPackage("com.obric.videoplayer");
        r2.addFlags(1);
        OCardListItem r5 = this.listItem;
        if (r5 == null) goto L5;
        Context r6 = r5.getContext();
    L6:
        Activity r7 = (Activity) r6;
        if (r7 == null) goto L9;
        r7.startActivity(r2);
    L9:
        OCardListItem r3 = this.listItem;
        Intrinsics.checkNotNull(r3);
        Context r8 = r3.getContext();
        if (r8 == null) goto L14;
        TransitionAnimHelper.overrideEnterAnim((Activity) r8, TransitionAnimStyle.Modal);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L5:
        r6 = null;
        goto L6
    }

    private final void openMusic(BigFileScanResultItem r6) {
        OCardListItem r0 = this.listItem;
        Intrinsics.checkNotNull(r0);
        Uri r1 = FileUtils.getUriForFile(r0.getContext(), r6.mPath);
        Intent r2 = new Intent("android.intent.action.VIEW");
        r2.setComponent(new ComponentName("com.obric.music", "com.bytedanceos.music.activities.PlaybackActivity"));
        r2.setDataAndType(r1, r6.mimeType);
        r2.addFlags(1);
        OCardListItem r5 = this.listItem;
        if (r5 == null) goto L5;
        Context r7 = r5.getContext();
    L6:
        Activity r8 = (Activity) r7;
        if (r8 == null) goto L10;
        r8.startActivity(r2);
        return;
    L10:
        return;
    L5:
        r7 = null;
        goto L6
    }

    private final void loadImage(BigFileScanResultItem r5) {
        OCardListItem r0 = this.listItem;     // Catch: Exception -> L50
        if (r0 == null) goto L5;
        r0.setIcon(null);     // Catch: Exception -> L50
    L5:
        OCardListItem r1 = this.listItem;     // Catch: Exception -> L50
        if (r1 == null) goto L8;
        r1.setAppIcon(null);     // Catch: Exception -> L50
    L8:
        int r2 = r5.fileType;     // Catch: Exception -> L50
        if (r2 != 0) goto L11;
    L43:
        OCardListItem r3 = this.listItem;     // Catch: Exception -> L50
        if (r3 == null) goto L46;
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L50
        Context r4 = r3.getContext();     // Catch: Exception -> L50
        Integer r6 = TableFileTypeResHelper.getFileResource(r5.fileExtension);     // Catch: Exception -> L50
        Intrinsics.checkNotNullExpressionValue(r6, "TableFileTypeResHelper.g…ource(data.fileExtension)");     // Catch: Exception -> L50
        r3.setIcon(r4.getDrawable(r6.intValue()));     // Catch: Exception -> L50
    L46:
        OCardListItem r7 = this.listItem;     // Catch: Exception -> L50
        if (r7 == null) goto L53;
        r7.showIcon(true);     // Catch: Exception -> L50
        return;
    L53:
        return;
    L11:
        if (r2 == 1) goto L29;
        if (r2 == 2) goto L29;
        if (r2 == 3) goto L29;
        if (r2 != 4) goto L17;
        ImageLoadHelper r8 = ImageLoadHelper.INSTANCE;     // Catch: Exception -> L50
        String r9 = r5.mPath;     // Catch: Exception -> L50
        Intrinsics.checkNotNullExpressionValue(r9, "data.mPath");     // Catch: Exception -> L50
        Drawable r10 = r8.getAppIconFromApk(r9);     // Catch: Exception -> L50
        if (r10 == null) goto L46;
        OCardListItem r11 = this.listItem;     // Catch: Exception -> L50
        if (r11 == null) goto L24;
        r11.setAppIcon(r10);     // Catch: Exception -> L50
    L24:
        OCardListItem r12 = this.listItem;     // Catch: Exception -> L50
        if (r12 == null) goto L46;
        OImageAppIcon r13 = (OImageAppIcon) r12.findViewById(R.id.o_list_item_app_icon);     // Catch: Exception -> L50
        if (r13 == null) goto L46;
        r13.setClipToMask(true);     // Catch: Exception -> L50
        goto L46
    L17:
        if (r2 == 5) goto L43;
    L29:
        int r14 = r5.fileType;     // Catch: Exception -> L50
        if (r14 == 1) goto L40;
        if (r14 == 2) goto L37;
        if (r14 != 3) goto L46;
        OCardListItem r15 = this.listItem;     // Catch: Exception -> L50
        if (r15 == null) goto L46;
        Intrinsics.checkNotNull(r15);     // Catch: Exception -> L50
        r15.setIcon(r15.getContext().getDrawable(R.drawable.file_audio));     // Catch: Exception -> L50
        goto L46
    L37:
        OCardListItem r16 = this.listItem;     // Catch: Exception -> L50
        if (r16 == null) goto L46;
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L50
        r16.setIcon(r16.getContext().getDrawable(R.drawable.file_video));     // Catch: Exception -> L50
        goto L46
    L40:
        OCardListItem r17 = this.listItem;     // Catch: Exception -> L50
        if (r17 == null) goto L46;
        Intrinsics.checkNotNull(r17);     // Catch: Exception -> L50
        r17.setIcon(r17.getContext().getDrawable(R.drawable.file_image));     // Catch: Exception -> L50
    }

    private final void openFileManager(BigFileScanResultItem r8) {
        Intent r0 = new Intent("com.bytedance.action.VIEW_FOLDER");     // Catch: Exception -> L8
        r0.putExtra("path", FileUtils.getParentDirectory(r8.mPath));     // Catch: Exception -> L8
        r0.putExtra(INTENT_FILE_DATA, r8.mPath);     // Catch: Exception -> L8
        OCardListItem r9 = this.listItem;     // Catch: Exception -> L8
        if (r9 == null) goto L16;
        Context r10 = r9.getContext();     // Catch: Exception -> L8
        if (r10 == null) goto L17;
        r10.startActivity(r0);     // Catch: Exception -> L8
        return;
    L17:
        return;
    L16:
        return;
    L8:
        OToast.Companion r1 = OToast.Companion;
        View r11 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r11, "itemView");
        Context r12 = r11.getContext();
        if (r12 == null) goto L13;
        View r7 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r7, "itemView");
        String r3 = r7.getContext().getString(R.string.open_file_manager_failed);
        Intrinsics.checkNotNullExpressionValue(r3, "itemView.context.getStri…open_file_manager_failed)");
        OToast.Companion.show$default(r1, (Activity) r12, r3, 0, 4, null);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public final void showDetailDialog(BigFileScanResultItem r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        getDetailDialog();
        updateDialogBody(r2);
        OAlertDialog r1 = getDetailDialog();
        if (r1 == null) goto L6;
        r1.show();
        return;
    }

    public final void updateDialogBody(final BigFileScanResultItem r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        LinearLayout r0 = this.dialogBody;
        if (r0 == null) goto L7;
        OListItemSettings r1 = (OListItemSettings) r0.findViewById(R.id.file_name);
        if (r1 == null) goto L7;
        r1.getSettingsTrailingView().getTextView().setSingleLine(true);
        r1.getSettingsTrailingView().getTextView().setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r1.setTrailingTextString(r7.mName);
        r1.showTrailingImageView(null);
    L7:
        LinearLayout r2 = this.dialogBody;
        if (r2 == null) goto L12;
        OListItemSettings r3 = (OListItemSettings) r2.findViewById(R.id.file_path);
        if (r3 == null) goto L12;
        r3.setTrailingTextString(FileUtils.getParentDirectory(r7.absolutePath));
        r3.getSettingsTrailingView().getTextView().setTextColor(r3.getContext().getColor(R.color.oui_blue_6));
        r3.getSettingsTrailingView().getTextView().setSingleLine(true);
        r3.getSettingsTrailingView().getTextView().setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r3.getSettingsTrailingView().getTextView().setOnClickListener(new BigFileItemViewHolder$updateDialogBody$$inlined$let$lambda$1(this, r7));
        r3.showTrailingImageView(null);
    L12:
        LinearLayout r6 = this.dialogBody;
        if (r6 == null) goto L18;
        OListItemSettings r8 = (OListItemSettings) r6.findViewById(R.id.file_size);
        if (r8 == null) goto L19;
        ByteUnitPair r9 = ByteConverter.convert(r7.mSize, "B", 1024);
        r8.setTrailingTextString(r9.getValue() + r9.getUnit());
        r8.showTrailingImageView(null);
        return;
    L19:
        return;
    }

    public final OAlertDialog getDetailDialog() {
        OAlertDialog r1 = this.dialog;
        if (r1 == null) goto L5;
        return r1;
    L5:
        OCardListItem r2 = this.listItem;
        Intrinsics.checkNotNull(r2);
        Context r3 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "listItem!!.context");
        OAlertDialogBuilder r4 = new OAlertDialogBuilder(r3).autoDismiss(true);
        OCardListItem r5 = this.listItem;
        View r6 = null;
        if (r5 == null) goto L10;
        Context r7 = r5.getContext();
        if (r7 == null) goto L10;
        String r8 = r7.getString(R.string.file_info);
    L11:
        OAlertDialog r9 = OAlertDialogBuilder.negativeButton$default(OAlertDialogBuilder.positiveButton$default(OAlertDialogBuilder.title$default(r4, r8, false, 2, null).body(new OViewStyleController(new BigFileItemViewHolder$getDetailDialog$builder$1(this))).horizontalButton(true), R.string.dialog_delete_conform, new BigFileItemViewHolder$getDetailDialog$builder$2(this), null, 4, null), R.string.cancel, null, null, 4, null).build();
        this.dialog = r9;
        if (r9 == null) goto L14;
        r6 = r9.getPositiveButton();
    L14:
        if (r6 == null) goto L18;
        OButton r10 = (OButton) r6;
        r10.setTextColor(r10.getContext().getColor(R.color.oui_on_accent_default));
        r10.setBackgroundColor(r10.getContext().getColor(R.color.oui_functional_red_6));
        return this.dialog;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    L10:
        r8 = null;
        goto L11
    }

    private final void initView() {
        OCardListItem r0 = this.listItem;
        if (r0 == null) goto L5;
        r0.setDefaultCustomStartView(0);
    L5:
        OCardListItem r1 = this.listItem;
        if (r1 == null) goto L8;
        r1.showCustomStart(true);
    L8:
        OCardListItem r2 = this.listItem;
        View r3 = null;
        if (r2 == null) goto L11;
        View r4 = r2.getCustomStartView();
    L13:
        if ((r4 instanceof OCheckBoxLayout) == false) goto L16;
        r3 = r4;
    L16:
        this.checkBox = (OCheckBoxLayout) r3;
        return;
    L11:
        r4 = null;
        goto L13
    }
}
