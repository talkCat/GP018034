package bxc.proxy;

import bxc.cglibproxy.CGLIBMeiPo;
import bxc.jdkproxy.MeiPo;
import bxc.staticproxy.Facther;
import bxc.staticproxy.Son;
import org.junit.Test;

import java.lang.reflect.Method;

public class ProxyTest {

    @Test
    public void staticPorxyTest()
    {
        Facther facther = new Facther(new Son());
        facther.findLove();
    }

    @Test
    public void jdkProxy()
    {
        try
        {
            Object obj = new MeiPo().getInstance(new Son());
            Method method = obj.getClass().getMethod("findLove",null);
            method.invoke(obj);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void cjlibProxy()
    {
        try
        {
            Object obj = new CGLIBMeiPo().getInstance(new Son().getClass());
            Method method = obj.getClass().getMethod("findLove");
            method.invoke(obj);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
