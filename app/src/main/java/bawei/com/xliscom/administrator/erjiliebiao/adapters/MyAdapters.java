package bawei.com.xliscom.administrator.erjiliebiao.adapters;
import android.content.Context;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import bawei.com.xliscom.administrator.erjiliebiao.Newsinfo;
import bawei.com.xliscom.administrator.erjiliebiao.R;

/**
 * Created by Administrator on 2017/3/8.
 */
public class MyAdapters extends BaseExpandableListAdapter {
    private List<Newsinfo.DataBean> list;
    private Context context;
    public MyAdapters(List<Newsinfo.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        return list.get(groupPosition).getDatas().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getDatas().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View con=View.inflate(context, R.layout.fubuju,null);
        TextView t1= (TextView) con.findViewById(R.id.fu);
        t1.setText(list.get(groupPosition).getTitle_id());
        return con;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view=View.inflate(context,R.layout.erzi,null);
        TextView t1= (TextView) view.findViewById(R.id.name);
        TextView t2= (TextView) view.findViewById(R.id.address);
        TextView t3= (TextView) view.findViewById(R.id.dates);
        TextView t4= (TextView) view.findViewById(R.id.money);
        t1.setText(list.get(groupPosition).getDatas().get(childPosition).getType_name());
        t2.setText(list.get(groupPosition).getDatas().get(childPosition).getMsg());
        t3.setText(list.get(groupPosition).getDatas().get(childPosition).getAdd_time());
        t4.setText(list.get(groupPosition).getDatas().get(childPosition).getPrice()+"");

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
