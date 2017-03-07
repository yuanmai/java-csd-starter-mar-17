package csd.starter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
   static String address=null;
   static Integer stime=null;
    static Integer etime=null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String inputData = scanner.nextLine();
            if(inputData.equals("exit")){
                System.out.print("bye~");
                break;
            }else{
                String[] inputDataArr=inputData.split(" ");
                if(inputDataArr!=null && inputDataArr.length>=2){
                    fetchInutData(inputData);
                    //调用业务逻辑
                    judgeReservationTime();
                }else{
                    System.out.println("数据格式有误，输入不能为空或以空格隔开");
                }
            }
        }
    }

    /**
     * 判断球场时间是否被预约
     */
    private static void judgeReservationTime() {
        ReservationService reservationService=new ReservationService();
        List<Integer> timeList=new ArrayList<Integer>();
        timeList.add(stime);
        timeList.add(etime);
        boolean flag=reservationService.reserve(address, timeList);
        if(flag){
            System.out.print("OK");
        }else{
            System.out.print("FAIL");
        }
    }

    /**
     * 终端输入数据
     * @param input
     */
    public static void fetchInutData(String input){
          String[] ins=input.split(" ");
          if(ins!=null && ins.length>=2){
                //System.out.println(ins.length);
                //System.out.println("第一个：" + ins[0]);
                //System.out.println("第 二个：" + ins[1]);
               address=ins[0];
               stime=null;
               etime=null;
                if(ins.length==2){
                    stime=Integer.parseInt(ins[1]);
                    etime=Integer.parseInt(ins[1]);
                }else{
                    stime=Integer.parseInt(ins[1]);
                    etime=Integer.parseInt(ins[2]);
                    //System.out.println("第三个：" + ins[2]);
                }
          }
    }
}