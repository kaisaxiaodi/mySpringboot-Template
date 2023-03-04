/**
 * @ClassName BaseContext
 * @Description 基于ThreadLocal封装的工具类，用于保存和获取当前登录用户的id
 * @Author 林jy
 **/

public class BaseContext {
    /* 工具方法所以要用static*/
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();


    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
