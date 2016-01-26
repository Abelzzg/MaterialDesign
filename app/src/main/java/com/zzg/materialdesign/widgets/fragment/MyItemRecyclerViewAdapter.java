package com.zzg.materialdesign.widgets.fragment;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzg.materialdesign.R;
import com.zzg.materialdesign.widgets.fragment.ItemFragment.OnListFragmentInteractionListener;
import com.zzg.materialdesign.widgets.fragment.dummy.DummyContent.DummyItem;
import com.zzg.materialdesign.widgets.fragment.dummy.DummyItemFilter;

import org.w3c.dom.Text;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private List<DummyItem> mValues;
    private static List<DummyItem> mValuesAll;
    private final OnListFragmentInteractionListener mListener;

    private boolean isSearching = false;
    private String mSearchText;

    public MyItemRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValuesAll = items;
        mValues = items;
        mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        holder.mItem = mValues.get(position);
        if (isSearching) {
            holder.mIdView.setText(emphasizeWord(mValues.get(position).id));
            holder.mContentView.setText(emphasizeWord(mValues.get(position).content));
        } else {
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).content);
        }
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

    private SpannableStringBuilder emphasizeWord(String text) {
        String str = text;
        int start = str.indexOf(mSearchText);
        int end = start + (mSearchText).length();
        SpannableStringBuilder style = new SpannableStringBuilder(str);
//        int size = 20;  //20px
//        style.setSpan(new AbsoluteSizeSpan(), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ForegroundColorSpan(Color.GREEN), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return style;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

    public void filter(String searchText) {
        mSearchText = searchText;
        if (TextUtils.isEmpty(searchText)) {
            isSearching = false;
            mValues = mValuesAll;
        } else {
            isSearching = true;
            DummyItemFilter dummyItemFilter = new DummyItemFilter(mValuesAll);
            mValues = dummyItemFilter.filte(searchText);
        }
        this.notifyDataSetChanged();
    }
}
