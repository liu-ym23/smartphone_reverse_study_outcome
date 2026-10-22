package com.obric.security.cleaner.cacheFragment.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
import com.obric.oui.button.OIconButton;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OBaseTextView;
import com.obric.security.R;
import com.obric.security.cleaner.cacheFragment.adapter.RubbishBaseAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: RubbishBaseViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00104\u001a\u0002052\u0006\u0010$\u001a\u000206J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\u00110\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n \r*\u0004\u0018\u00010\u00150\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\n \r*\u0004\u0018\u00010\u00190\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u001d0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\n \r*\u0004\u0018\u00010!0!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\"\u0010$\u001a\n \r*\u0004\u0018\u00010\u00190\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010'R\u0019\u0010(\u001a\n \r*\u0004\u0018\u00010\u001d0\u001d¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\"\u0010*\u001a\n \r*\u0004\u0018\u00010+0+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0019\u00100\u001a\n \r*\u0004\u0018\u00010101¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006;"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/viewholder/RubbishBaseViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "adapter", "Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;", "getAdapter", "()Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;", "setAdapter", "(Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;)V", "appAllCheck", "Lcom/obric/oui/checkbox/OCheckBox;", "kotlin.jvm.PlatformType", "getAppAllCheck", "()Lcom/obric/oui/checkbox/OCheckBox;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "iconImageView", "Lcom/obric/oui/button/OIconButton;", "getIconImageView", "()Lcom/obric/oui/button/OIconButton;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "nameTextApp", "Lcom/obric/oui/text/OBaseTextView;", "getNameTextApp", "()Lcom/obric/oui/text/OBaseTextView;", "oCardListItem", "Lcom/obric/oui/lisitem/OCardListItem;", "getOCardListItem", "()Lcom/obric/oui/lisitem/OCardListItem;", PerfConsts.PERF_DISK_FILE_SIZE, "getSize", "setSize", "(Landroid/widget/TextView;)V", "sizeApp", "getSizeApp", "subItem", "Landroid/widget/LinearLayout;", "getSubItem", "()Landroid/widget/LinearLayout;", "setSubItem", "(Landroid/widget/LinearLayout;)V", "titleApp", "Landroid/widget/RelativeLayout;", "getTitleApp", "()Landroid/widget/RelativeLayout;", "getSizeString", "", "", "onBind", "", "data", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public class RubbishBaseViewHolder extends RecyclerView.ViewHolder {
    private RubbishBaseAdapter adapter;
    private final OCheckBox appAllCheck;
    private final ImageView icon;
    private final OIconButton iconImageView;
    private final TextView name;
    private final OBaseTextView nameTextApp;
    private final OCardListItem oCardListItem;
    private TextView size;
    private final OBaseTextView sizeApp;
    private LinearLayout subItem;
    private final RelativeLayout titleApp;

    public void onBind(RubbishEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "data");
    }

    public RubbishBaseViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.name = (TextView) r2.findViewById(R.id.name);
        this.size = (TextView) r2.findViewById(R.id.size);
        this.icon = (ImageView) r2.findViewById(R.id.icon);
        this.subItem = (LinearLayout) r2.findViewById(R.id.sub_item);
        this.oCardListItem = (OCardListItem) r2.findViewById(R.id.card_list_item);
        this.titleApp = (RelativeLayout) r2.findViewById(R.id.rl_app_info);
        this.iconImageView = (OIconButton) r2.findViewById(R.id.iconImageView);
        this.sizeApp = (OBaseTextView) r2.findViewById(R.id.app_size);
        this.nameTextApp = (OBaseTextView) r2.findViewById(R.id.nameTextView);
        this.appAllCheck = (OCheckBox) r2.findViewById(R.id.checkbox_app);
    }

    public final TextView getName() {
        return this.name;
    }

    public final TextView getSize() {
        return this.size;
    }

    public final void setSize(TextView r1) {
        this.size = r1;
    }

    public final ImageView getIcon() {
        return this.icon;
    }

    public final LinearLayout getSubItem() {
        return this.subItem;
    }

    public final void setSubItem(LinearLayout r1) {
        this.subItem = r1;
    }

    public final OCardListItem getOCardListItem() {
        return this.oCardListItem;
    }

    public final RelativeLayout getTitleApp() {
        return this.titleApp;
    }

    public final OIconButton getIconImageView() {
        return this.iconImageView;
    }

    public final OBaseTextView getSizeApp() {
        return this.sizeApp;
    }

    public final OBaseTextView getNameTextApp() {
        return this.nameTextApp;
    }

    public final OCheckBox getAppAllCheck() {
        return this.appAllCheck;
    }

    public final RubbishBaseAdapter getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(RubbishBaseAdapter r1) {
        this.adapter = r1;
    }

    public final String getSizeString(long r2) {
        ByteUnitPair r1 = ByteConverter.convert(r2, "B", 1000);
        return r1.getValue() + " " + r1.getUnit();
    }
}
