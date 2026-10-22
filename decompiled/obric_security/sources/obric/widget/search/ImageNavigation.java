package obric.widget.search;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class ImageNavigation extends RelativeLayout {
    private Context mContext;
    private ImageView mLeftImageView;
    private ViewGroup mMidContainer;
    private View mMidView;
    private ImageView mRightImageView;
    private TextView mTitle;

    public ImageNavigation(Context context) {
        this(context, null);
    }

    public ImageNavigation(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.image_navigation_layout, this, true);
        this.mMidContainer = (ViewGroup) findViewById(R.id.mid_container);
        this.mLeftImageView = (ImageView) findViewById(R.id.left_iv);
        this.mRightImageView = (ImageView) findViewById(R.id.right_iv);
        TextView r0 = (TextView) findViewById(R.id.title);
        this.mTitle = r0;
        this.mMidView = r0;
    }

    public void setRightImageWidthAndHeight(int width, int height) {
        ViewGroup.LayoutParams r0 = this.mRightImageView.getLayoutParams();
        r0.width = width;
        r0.height = height;
        this.mRightImageView.setLayoutParams(r0);
    }

    public void setTitleText(String text) {
        if (text != null) goto L4;
    L6:
        this.mTitle.setText(text);
        return;
    L4:
        if (text.equals(this.mTitle.getText().toString()) == false) goto L6;
    }

    public void setView(int id) {
        View r3 = LayoutInflater.from(this.mContext).inflate(id, this, false);
        this.mMidView = r3;
        setView(r3);
    }

    public void setView(View view) {
        this.mMidView = view;
        this.mMidContainer.removeAllViews();
        this.mMidContainer.addView(view);
    }

    public void setRightImageViewRes(int id) {
        this.mRightImageView.setImageResource(id);
    }

    public void setRightImageViewDrawable(Drawable d) {
        this.mRightImageView.setImageDrawable(d);
    }

    public void setLeftImageViewRes(int id) {
        this.mLeftImageView.setImageResource(id);
    }

    public void setRightImageViewVisible(int visible) {
        this.mRightImageView.setVisibility(visible);
    }

    public void setLeftImageViewVisible(int visible) {
        this.mLeftImageView.setVisibility(visible);
    }

    public void setRightImageViewClickLisener(View.OnClickListener l) {
        this.mRightImageView.setOnClickListener(l);
    }

    public void setLeftImageViewClickLisener(View.OnClickListener l) {
        this.mLeftImageView.setOnClickListener(l);
    }

    public View getMidView() {
        return this.mMidView;
    }

    public ImageView getRightImageView() {
        return this.mRightImageView;
    }

    public ImageView getLeftImageView() {
        return this.mLeftImageView;
    }
}
