package com.zzg.materialdesign.widgets.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzg.materialdesign.R;
import com.zzg.materialdesign.widgets.fragment.dummy.CardsContent;

import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCardViewRecyclerViewAdapter extends RecyclerView.Adapter<MyCardViewRecyclerViewAdapter.ViewHolder> {

    private final List<CardsContent.CardItem> mValues;
    private final CardViewFragment.OnListFragmentInteractionListener mListener;
    private Context mContext;

    public MyCardViewRecyclerViewAdapter(List<CardsContent.CardItem> items, CardViewFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
//        holder.mContentView.setText(mValues.get(position).id);
        int drawableId = getDrawableId(mContext,holder.mItem.cardName);
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), drawableId);
        holder.mImageView.setImageBitmap(bitmap);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    public static int getDrawableId(Context paramContext, String paramString) {
        return paramContext.getResources().getIdentifier(paramString,
                "drawable", paramContext.getPackageName());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
//        public final TextView mContentView;
        public final ImageView mImageView;
        public CardsContent.CardItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
//            mContentView = (TextView) view.findViewById(R.id.content);
            mImageView = (ImageView) view.findViewById(R.id.imageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" ;
        }
    }


}
