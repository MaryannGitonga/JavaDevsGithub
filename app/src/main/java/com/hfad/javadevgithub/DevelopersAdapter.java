package com.hfad.javadevgithub;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DevelopersAdapter extends RecyclerView.Adapter<DevelopersAdapter.ViewHolder> {

    private List<Developer> developerList;
    private Context context;

    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";

    public DevelopersAdapter(List<Developer> developerList, Context context){
        this.developerList = developerList;
        this.context = context;
    }

    @NonNull
    @Override
    public DevelopersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.developers_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DevelopersAdapter.ViewHolder holder, int position) {
        final Developer currentDeveloper = developerList.get(position);

        holder.login.setText(currentDeveloper.getLogin());
        holder.html_url.setText(currentDeveloper.getHtml_url());
        Picasso.with(context).load(currentDeveloper.getAvatar_url()).into(holder.avatar_url);

        holder.linearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Developer developer = developerList.get(position);

                Intent developerIntent = new Intent(v.getContext(), ProfileActivity.class);
                developerIntent.putExtra(KEY_NAME, developer.getLogin());
                developerIntent.putExtra(KEY_IMAGE, developer.getAvatar_url());
                developerIntent.putExtra(KEY_URL, developer.getHtml_url());
                v.getContext().startActivity(developerIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return developerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView login, html_url;
        public ImageView avatar_url;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            login = itemView.findViewById(R.id.username);
            avatar_url = itemView.findViewById(R.id.imageView);
            html_url = itemView.findViewById(R.id.html_url);
            linearLayout = itemView.findViewById(R.id.linearLayout);

        }
    }
}
