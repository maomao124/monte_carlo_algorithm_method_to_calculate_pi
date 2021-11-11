

/**
 * Project name(项目名称)：蒙特卡罗算法法计算圆周率
 * Package(包名): PACKAGE_NAME
 * Class(类名): Axis
 * Author(作者）: mao
 * Author QQ：1296193245
 * github：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/11
 * Time(创建时间)： 13:25
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Axis
{
    private double x_axis;
    private double y_axis;
    private boolean result;

    public Axis()
    {

    }

    public Axis(double x_axis, double y_axis)
    {
        this.x_axis = x_axis;
        this.y_axis = y_axis;
    }

    public double getX_axis()
    {
        return x_axis;
    }

    public void setX_axis(double x_axis)
    {
        this.x_axis = x_axis;
    }

    public double getY_axis()
    {
        return y_axis;
    }

    public void setY_axis(double y_axis)
    {
        this.y_axis = y_axis;
    }

    public boolean isResult()
    {
        return result;
    }

    public boolean calculate()
    {
        double s = Math.sqrt((this.x_axis - 0.5) * (this.x_axis - 0.5) + (this.y_axis - 0.5) * (this.y_axis - 0.5));
        if (s <= 0.5)
        {
            this.result = true;
            return true;
        }
        else
        {
            this.result = false;
            return false;
        }
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("x_axis：").append(x_axis).append('\t');
        stringbuilder.append("y_axis：").append(y_axis).append('\t');
        stringbuilder.append("result：").append(result).append('\n');
        return stringbuilder.toString();
    }
}
