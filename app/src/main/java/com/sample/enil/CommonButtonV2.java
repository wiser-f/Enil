/*
 * Copyright (C) 2016 BOOK WALKER Co.,Ltd. All Rights Reserved.
 */

package jp.co.nttdocomo.books.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.renderscript.ScriptGroup;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//import jp.co.nttdocomo.books.R;
//import jp.co.nttdocomo.books.databinding.CustomViewCommonButtonV2Binding;
import timber.log.Timber;

/**
 * The type Common button v 2.
 */
public class CommonButtonV2 extends FrameLayout {

    private ScriptGroup.Binding mBinding;
    private int mButtonType = 0;
    private String mMainText = "";
    private float mMainTextSize = 0;
    private String mSubText = "";
    private float mSubTextSize = 0;
    private Drawable mIcon;
    private float mIconSize = 0;
    private Boolean mIsSelected = false;
    private OnClickListener mListener = v -> Timber.v("clicked");

    private static final int TYPE_SECONDARY = 1;
    private static final int TYPE_NEUTRAL = 2;

    /**
     * Instantiates a new Common button v 2.
     *
     * @param context the context
     */
    public CommonButtonV2(@NonNull Context context) {
        super(context);
        initialize(context);
    }

    /**
     * Instantiates a new Common button v 2.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public CommonButtonV2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        setAttribute(attrs);
        initialize(context);
    }

    /**
     * Instantiates a new Common button v 2.
     *
     * @param context      the context
     * @param attrs        the attrs
     * @param defStyleAttr the def style attr
     */
    public CommonButtonV2(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        setAttribute(attrs);
        initialize(context);
    }

//    private void setAttribute(@Nullable AttributeSet attrs) {
//        try (TypedArray typedArray = getContext().getTheme()
//                .obtainStyledAttributes(attrs, R.styleable.CommonButtonV2, 0, 0)) {
//            mMainText = typedArray.getString(R.styleable.CommonButtonV2_main_text);
//            mSubText = typedArray.getString(R.styleable.CommonButtonV2_sub_text);
//            mMainTextSize = typedArray.getDimension(R.styleable.CommonButtonV2_main_text_size, 0);
//            mSubTextSize = typedArray.getDimension(R.styleable.CommonButtonV2_sub_text_size, 0);
//            mButtonType = typedArray.getInt(R.styleable.CommonButtonV2_button_type, 0);
//            mIcon = typedArray.getDrawable(R.styleable.CommonButtonV2_icon);
//            mIconSize = typedArray.getDimension(R.styleable.CommonButtonV2_icon_size, 0);
//            mIsSelected = typedArray.getBoolean(R.styleable.CommonButtonV2_selected, false);
//        }
//    }

    private void initialize(Context context) {
//        mBinding = ScriptGroup.Binding.inflate(LayoutInflater.from(context), this, true);
//
//        switch (mButtonType) {
//            case TYPE_SECONDARY -> mBinding.secondaryButton.setVisibility(VISIBLE);
//            case TYPE_NEUTRAL -> mBinding.neutralButton.setVisibility(VISIBLE);
//            default -> mBinding.primaryButton.setVisibility(VISIBLE);
//        }
//        mBinding.primaryButton.setOnClickListener(v -> onClick(this));
//        mBinding.secondaryButton.setOnClickListener(v -> onClick(this));
//        mBinding.neutralButton.setOnClickListener(v -> onClick(this));
//        mBinding.primaryButton.setOnTouchListener((v, event) -> {
//            v.performClick();
//            return onTouch(event);
//        });
//
//        if (mMainText != null) {
//            mBinding.mainText.setText(mMainText);
//        }
//        if (mSubText != null) {
//            mBinding.subText.setText(mSubText);
//            mBinding.subText.setVisibility(VISIBLE);
//        }
//        if (mMainTextSize != 0) {
//            mBinding.mainText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mMainTextSize);
//        }
//        if (mSubTextSize != 0) {
//            mBinding.subText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mSubTextSize);
//        }
//        if (mButtonType == TYPE_NEUTRAL) {
//            mBinding.mainText.setTextColor(getResources().getColor(R.color.neutral_black));
//            mBinding.subText.setTextColor(getResources().getColor(R.color.neutral_black));
//        }
//
//        if (mIcon != null) {
//            mBinding.icon.setImageDrawable(mIcon);
//            mBinding.icon.setVisibility(VISIBLE);
//            mBinding.icon.setEnabled(true);
//        }
//        int size = (int) mIconSize;
//        if (size != 0) {
//            MarginLayoutParams lp = new LinearLayout.LayoutParams(size, size);
//            lp.setMargins(0, 0, (int)getResources().getDimension(R.dimen.common_button_v2_icon_margin), 0);
//            mBinding.icon.setLayoutParams(lp);
//        }
        if (mIsSelected) {
            changeSelected(true);
        }
    }

    private void onClick(View view) {
        mIsSelected = !mIsSelected;
//        mBinding.icon.setSelected(mIsSelected);
        mListener.onClick(view);
    }

    private Boolean onTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                if (mButtonType == TYPE_NEUTRAL) {
//                    mBinding.mainText.setTextColor(getResources().getColor(R.color.middle_gray));
//                    mBinding.subText.setTextColor(getResources().getColor(R.color.middle_gray));
//                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
            default:
//                if (mButtonType == TYPE_NEUTRAL) {
//                    mBinding.mainText.setTextColor(getResources().getColor(R.color.neutral_black));
//                    mBinding.subText.setTextColor(getResources().getColor(R.color.neutral_black));
//                }
                break;
        }
        return false;
    }

    @Override
    public void setOnClickListener(OnClickListener onClickListener) {
        mListener = onClickListener;
    }

    /**
     * Sets main text.
     *
     * @param text the text
     */
    public void setMainText(String text) {
        if (text != null) {
            mBinding.mainText.setText(text);
        }
    }

    /**
     * Sets sub text.
     *
     * @param text the text
     */
//    public void setSubText(String text) {
//        if (text == null) {
//            mBinding.subText.setVisibility(GONE);
//            mBinding.subText.setText("");
//        } else {
//            mBinding.subText.setText(text);
//            mBinding.subText.setVisibility(VISIBLE);
//        }
//    }

    /**
     * Sets icon.
     *
     * @param drawable the drawable
     */
    public void setIcon(Drawable drawable) {
//        if (drawable == null) {
//            mBinding.icon.setEnabled(false);
//            mBinding.icon.setVisibility(GONE);
//            mIcon = null;
//        } else {
//            mBinding.icon.setImageDrawable(drawable);
//            mBinding.icon.setEnabled(true);
//            mBinding.icon.setVisibility(VISIBLE);
//            mIcon = drawable;
//        }

    }

    @Override
    public boolean isSelected() {
        return mIsSelected;
    }

    /**
     * Change selected.
     *
     * @param isCheck the is check
     */
    public void changeSelected(boolean isCheck) {
//        mBinding.icon.setSelected(isCheck);
        mIsSelected = isCheck;
    }
}
