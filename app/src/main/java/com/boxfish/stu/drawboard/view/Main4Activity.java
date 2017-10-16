package com.boxfish.stu.drawboard.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.boxfish.stu.drawboard.R;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {

    private Activity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mContext = this;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("lishaowei" + i);
        }
        adapter.addAll(strings);

    }

    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


        private ArrayList<String> list = new ArrayList<>();

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout, parent, false);
            return new ViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.textView.setText(list.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("text", "lishaowei");
                    Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                    intent.putExtras(bundle);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(mContext, holder.imageView, "image");
                    startActivity(intent, options.toBundle());
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView textView;
            private final ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.text);
                imageView = (ImageView) itemView.findViewById(R.id.image);
            }
        }

        public void addAll(ArrayList<String> list) {
            this.list = list;
        }
    }

}
