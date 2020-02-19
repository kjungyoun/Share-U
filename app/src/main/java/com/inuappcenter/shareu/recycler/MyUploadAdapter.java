package com.inuappcenter.shareu.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inuappcenter.shareu.R;
import com.inuappcenter.shareu.my_class.Major;
import com.inuappcenter.shareu.my_class.MyUpload;
import com.inuappcenter.shareu.my_class.Notice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyUploadAdapter extends RecyclerView.Adapter<MyUploadAdapter.ViewHolder> {
    private Context mContext;
    private List<MyUpload> mitems;


    public MyUploadAdapter(Context mContext) {
        this.mContext = mContext;
        this.mitems = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyUploadAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_my_upload,parent,false);
        return new MyUploadAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyUploadAdapter.ViewHolder holder, int position) {
        final MyUpload item = mitems.get(position);
        if(item.getExtension()=="ppt" || item.getExtension()=="pptx" )
        {
            holder.img_my_upload.setImageResource(R.drawable.ppt);
        }
        else if(item.getExtension()=="hwp")
        {
            holder.img_my_upload.setImageResource(R.drawable.korean);
        }
        else if(item.getExtension()=="doc" || item.getExtension()=="docx")
        {
            holder.img_my_upload.setImageResource(R.drawable.word);
        }
        else if(item.getExtension()=="ai")
        {
            holder.img_my_upload.setImageResource(R.drawable.ai);
        }
        else if(item.getExtension()=="ps")
        {
            holder.img_my_upload.setImageResource(R.drawable.ps);
        }

        else if(item.getExtension()=="jpeg" || item.getExtension()=="jpg")
        {
            holder.img_my_upload.setImageResource(R.drawable.jpeg);
        }
        else if(item.getExtension()=="png")
        {
            holder.img_my_upload.setImageResource(R.drawable.png);
        }
        else if(item.getExtension()=="xls"||item.getExtension()=="xlsx"|| item.getExtension()=="xlsm" || item.getExtension()=="csv")
        {
            holder.img_my_upload.setImageResource(R.drawable.excel);
        }
        else if(item.getExtension()=="mp3")
        {
            holder.img_my_upload.setImageResource(R.drawable.mp3);
        }
        else if(item.getExtension()=="zip")
        {
            holder.img_my_upload.setImageResource(R.drawable.zip);
        }
        else
        {
            holder.img_my_upload.setImageResource(R.drawable.file);
        }
        holder.tv_my_upload_title.setText(item.getTitle());
        holder.tv_my_upload_date.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return this.mitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_my_upload;
        TextView tv_my_upload_date;
        TextView tv_my_upload_title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_my_upload=itemView.findViewById(R.id.img_my_upload);
            tv_my_upload_date = itemView.findViewById(R.id.tv_my_upload_date);
            tv_my_upload_title = itemView.findViewById(R.id.tv_my_upload_title);
        }

    }
    public void setData(List<MyUpload> notices) {
        mitems = notices;
        notifyDataSetChanged();
    }
}