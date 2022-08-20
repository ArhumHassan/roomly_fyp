package com.example.asp.roomly_one;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Recyclerviewadapter extends RecyclerView.Adapter<Recyclerviewadapter.Myviewholder> {

        private Context mcontext;
        private List<item_images> mdata;
        //  private  OnItemClickListner setListner;

   /* public interface OnItemClickListner{
        void onItemClick(int position);
    }
    public void setOnItemClickListner(OnItemClickListner listner){

        setListner =listner;
    }
*/

        public Recyclerviewadapter(Context mcontext, List<item_images> mdata) {
            this.mcontext = mcontext;
            this.mdata = mdata;
        }
        @Override
        public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            LayoutInflater inflater=LayoutInflater.from(mcontext);
            view =inflater.inflate(R.layout.card_view_item,parent,false);

            //     Myviewholder myviewholder=new Myviewholder(view);
            return new Myviewholder(view);


        }

        @Override
        public void onBindViewHolder(@NonNull Myviewholder holder, @SuppressLint("RecyclerView") int position) {
            item_images itemImages = mdata.get(position);
            holder.name.setText(itemImages.getName());
            holder.price.setText(itemImages.getPrice());
            // holder.imageView.setImageDrawable(mcontext.getResources().getDrawable(itemImages.getImage()));
            Picasso.get().load(itemImages.getImage()).into(holder.imageView);

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(mcontext,Item_description.class);
                    intent.putExtra("Image",mdata.get(position).getImage());
                    intent.putExtra("Name",mdata.get(position).getName());
                    intent.putExtra("Price",mdata.get(position).getPrice());



                    mcontext.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return mdata.size();
        }

        public class Myviewholder extends RecyclerView.ViewHolder{

            public CardView cardView;
            public TextView name,price;
            public ImageView imageView;
            public Myviewholder(View itemview) {
                super(itemview);
                cardView=(CardView)itemview.findViewById(R.id.card_id);
                name=(TextView)itemview.findViewById(R.id.textview);
                price=(TextView)itemview.findViewById(R.id.textRS);
                imageView=(ImageView)itemview.findViewById(R.id.imageView);


            }

        }



    }