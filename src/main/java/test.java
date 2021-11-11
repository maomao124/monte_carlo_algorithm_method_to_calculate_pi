import java.awt.*;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Project name(项目名称)：蒙特卡罗算法法计算圆周率
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * github：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/11
 * Time(创建时间)： 13:23
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{
    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        int SampleSize;
        boolean hide = false;
        if (args.length == 0)
        {
            SampleSize = 10000;      //样本大小
        }
        else
        {
            try
            {
                if (args.length >= 2)
                {
                    hide = args[1].equals("hide");
                }
                SampleSize = Integer.parseInt(args[0]);
            }
            catch (InputMismatchException e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("参数异常！！！样本大小已设置成100");
                SampleSize = 100;
            }
            catch (Exception e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("参数错误！！！样本大小已设置成100");
                SampleSize = 100;
            }
        }
        Map<Integer, Axis> map = new TreeMap<>();
        if (!hide)
        {
            for (int i = 0; i < SampleSize; i++)
            {
                Axis axis = new Axis(Math.random(), Math.random());
                if (i % 10 == 0 && i != 0)
                {
                    System.out.println(i + ": " + axis.calculate());
                }
                else
                {
                    System.out.print(i + ": " + axis.calculate() + "  ");
                }
                map.put(i, axis);
            }
        }
        else
        {
            for (int i = 0; i < SampleSize; i++)
            {
                Axis axis = new Axis(Math.random(), Math.random());
                axis.calculate();
                map.put(i, axis);
            }
        }
        double PI;                   //圆周率
        double P;                    //概率
        int trueCount = 0;        //正确总数
        for (Integer i : map.keySet())
        {
            Axis axis = map.get(i);
            if (axis.isResult())
            {
                trueCount++;
            }
        }
        P = (double) trueCount / (double) SampleSize;
        PI = P * 4;
        System.out.println();
        System.out.println();
        System.out.println("样本大小：" + SampleSize);
        System.out.println("位于圆内的点的数量：" + trueCount);
        System.out.println("概率：" + P);
        System.out.println("圆周率：" + PI);
        System.out.println();
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
