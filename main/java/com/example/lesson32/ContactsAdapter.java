package com.example.lesson32;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.ColorSpace;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.security.auth.callback.Callback;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>{


    private List<ContactModel> list;
private Context mContext;
private CallBack callBack;

    public ContactsAdapter(Context context, List<ContactModel> list){
        this.mContext=context;
        this.list=list;
    }



    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_contacts,parent,false);

        return new ContactViewHolder(view);
    }

    public interface CallBack{
        void onCallBack();
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        holder.txtName.setText(list.get(position).getName());
       holder.txtPhone.setText(list.get(position).getPhone());



        holder.btnCall.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContext instanceof MainActivity) {
                    ((MainActivity)mContext).onCallClicked();
                    Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+list.get(position).getPhone()));
                    mContext.startActivity(intent);
                }
            }
        });





    }


    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ContactViewHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtPhone;
        Button btnCall, btnMessage;
        LinearLayout itemContact;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            itemContact = itemView.findViewById(R.id.item_contact);
            txtName = itemView.findViewById(R.id.txt_contact_name);
            txtPhone = itemView.findViewById(R.id.txt_number);

            btnCall = itemView.findViewById(R.id.btn_call);


            btnMessage = itemView.findViewById(R.id.btn_massage);

        }
    }

    }