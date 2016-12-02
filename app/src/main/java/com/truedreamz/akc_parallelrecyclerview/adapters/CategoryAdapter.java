package com.truedreamz.akc_parallelrecyclerview.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.truedreamz.akc_parallelrecyclerview.R;
import com.truedreamz.akc_parallelrecyclerview.models.Category;

import java.util.List;

import static com.truedreamz.akc_parallelrecyclerview.Utility.Constant.CATEGORY_SELECTED_POSITION;


/**
 * Created by wisdom-JP on 12/1/2016.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.AKCViewHolder>{

    private Context mContext;
    private List<Category> mCategoryList;
    private final static int FADE_DURATION = 300; // in milliseconds
    private int lastPosition = -1;

    public class AKCViewHolder extends RecyclerView.ViewHolder {
        public ImageView categoryIcon;

        public AKCViewHolder(View view) {
            super(view);
            categoryIcon = (ImageView) view.findViewById(R.id.categoryImage);
        }
    }

    public CategoryAdapter(Context mContext, List<Category> cateList) {
        this.mContext = mContext;
        this.mCategoryList = cateList;
    }

    @Override
    public AKCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View categoryItem= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_card,parent,false);

        return new AKCViewHolder(categoryItem);
    }

    @Override
    public void onBindViewHolder(AKCViewHolder holder, int position) {
        Category categoryItem=mCategoryList.get(position);
        Bitmap icon = BitmapFactory.decodeResource(mContext.getResources(),categoryItem.cat_icon);
        holder.categoryIcon.setImageBitmap(icon);

        // Set the view to scale
        //setScaleAnimation(holder.categoryIcon);

        if(CATEGORY_SELECTED_POSITION == position){
            // Here I am just highlighting the background
            holder.categoryIcon.setBackgroundColor(mContext.getResources().getColor(R.color.colorPickedItem));
        }else{
            holder.categoryIcon.setBackgroundColor(mContext.getResources().getColor(R.color.colorItembg));
        }
    }

    /*private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }*/

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }
}