package kz.alibi.hday;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.List;


public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.CustomViewHolder> {
    private List<Listz> employees;

    public EmployeesAdapter(List<Listz> employees) {
        this.employees = employees;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Listz employee = employees.get(position);
        holder.employeeName.setText(employee.getName());
        holder.email.setText(employee.getEmail());
       // holder.dob.setText(employee.getOrganization());
//        holder.contactNumber.setText(employee.getPhone());
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView employeeName, designation, email, salary, dob,contactNumber;

        public CustomViewHolder(View view) {
            super(view);

            employeeName = (TextView) view.findViewById(R.id.employeeName);
            email = (TextView) view.findViewById(R.id.email);
            designation = (TextView) view.findViewById(R.id.designation);
            salary = (TextView) view.findViewById(R.id.salary);
            dob = (TextView) view.findViewById(R.id.dob);
            contactNumber = (TextView) view.findViewById(R.id.contactNumber);
        }
    }
}