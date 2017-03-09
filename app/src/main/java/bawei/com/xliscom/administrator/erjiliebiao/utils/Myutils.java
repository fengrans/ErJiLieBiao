package bawei.com.xliscom.administrator.erjiliebiao.utils;
import android.content.Context;
import android.content.SharedPreferences;
/**
 * Created by Administrator on 2017/3/9.
 */
public class Myutils {
    static  Myutils myutils;
    SharedPreferences sp;
    SharedPreferences.Editor et;
    public  Myutils(Context context){
        sp=context.getSharedPreferences("conf",0);
        //在这个构造方法里面实例化一个文件
    }
    public void addName(String name,boolean flag){
        sp.edit().putBoolean(name,flag).commit();
        //当把名字添加进sp中更改flag状态
    }
    //总钱数
    public void addmoney(int money){
        sp.edit().putInt("count",money).commit();
    }
    //总条数
    public void  addCount_sum(int summcount){
        sp.edit() .putInt("sum",summcount).commit();
    }
    //得到总钱数
    public int Getmoney(){
        return  sp.getInt("count",0);
    }
    //得到总条数
    public int getcount(){

        return  sp.getInt("sum",0);

    }
    //得到名字
    public boolean Getname(String name){
        return  sp.getBoolean(name,false);
    }
    public  void clears(){
        sp.edit().commit();
    }
}
