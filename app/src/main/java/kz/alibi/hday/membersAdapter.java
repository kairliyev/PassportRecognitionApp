package kz.alibi.hday;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import kz.alibi.hday.gocr.OcrCaptureActivity;

public class membersAdapter extends RecyclerView.Adapter<membersAdapter.sViewHolder> {
    ArrayList<String> arrayLista;
    public membersAdapter(ArrayList<String> arrayList){
        arrayLista = arrayList;
    }
    private static final int RC_OCR_CAPTURE = 9003;
    @NonNull
    @Override
    public membersAdapter.sViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.members_list_item, viewGroup, false);
        return new sViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull membersAdapter.sViewHolder customViewHolder, int i) {
        customViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(v.getContext(), kz.alibi.hday.gocr.mActivity.class);
                Intent intent = new Intent(v.getContext(), OcrCaptureActivity.class);
                intent.putExtra(OcrCaptureActivity.AutoFocus, true);
                intent.putExtra(OcrCaptureActivity.UseFlash, false);

                ((Activity) v.getContext()).startActivityForResult(intent, RC_OCR_CAPTURE);

            }
        });
        Log.d("WWS", arrayLista.get(i));
        customViewHolder.editName.setText(arrayLista.get(i));
    }

    @Override
    public int getItemCount() {
        return arrayLista.size();
    }

    public class sViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private EditText editName;
        private EditText editSurname;
        public sViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.idcard);
            editName = itemView.findViewById(R.id.student_name_et);
            editSurname = itemView.findViewById(R.id.student_surname_et);
        }
    }
}
