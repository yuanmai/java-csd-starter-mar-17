package csd.starter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

//        Stack
//        System.setIn();
//        System.setOut();
        Scanner s = new Scanner(System.in);
        while (true){
            String str = s.nextLine();
            System.out.println("输入信息：" + str);
            //分隔数据行
            String[] ins=str.split(" ");
            if(ins!=null && ins.length>=2){
                System.out.println(ins.length);
                System.out.println("第一个：" + ins[0]);
                System.out.println("第 二个：" + ins[1]);
                String address=ins[0];
                Integer stime=null;
                Integer etime=null;
                if(ins.length==2){
                    stime=Integer.parseInt(ins[1]);
                    etime=Integer.parseInt(ins[1]);
                }else{
                    stime=Integer.parseInt(ins[1]);
                    etime=Integer.parseInt(ins[2]);
                    System.out.println("第三个：" + ins[2]);
                }
                //调用业务逻辑
                ReservationService reservationService=new ReservationService();
                List<Integer> timeList=new ArrayList<Integer>();
                timeList.add(stime);
                timeList.add(etime);
                boolean flag=reservationService.reserve(address, timeList);
                if(flag){
                    System.out.println("预约成功^_^");
                }else{
                    System.out.println("预约失败!");
                }

            }else{
                System.out.println("数据格式有误，输入不能为空或以空格隔开");
            }
        }
    }
}