package com.example.projecet1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterTeacher extends RecyclerView.Adapter<AdapterTeacher.NameViewHolder> {

    List<String> nameList = new ArrayList<>();
    List<String> familyList = new ArrayList<>();
    List<String> teacherIdList = new ArrayList<>();

    public AdapterTeacher() {
        TeacherClass teacher = new TeacherClass();
        nameList = teacher.getNames();
        familyList = teacher.getFamily();
        teacherIdList = teacher.getTeacherIds();
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ico_list, parent, false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        String name = nameList.get(position);
        String family = familyList.get(position);
        String teacherId = teacherIdList.get(position);

        holder.setItems(name, family, teacherId);
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    // 🔹 Interface برای کلیک
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public class NameViewHolder extends RecyclerView.ViewHolder {
        TextView names, family, teacherId;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            names = itemView.findViewById(R.id.txtName);
            family = itemView.findViewById(R.id.txtFamily);
            teacherId = itemView.findViewById(R.id.txtTeacherId);

            // 🔹 کلیک روی کل آیتم
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

        public void setItems(String Name, String Family, String TeacherId) {
            names.setText(Name);
            family.setText(Family);
            teacherId.setText(TeacherId);
        }
    }
}
