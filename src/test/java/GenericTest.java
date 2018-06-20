import com.fidelium.domain.Result;
import com.fidelium.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-12-07.
 */
public class GenericTest {

    public static void main(String args[]){
        System.out.println("test");

        ClassGenericType<Result> classGenericType = new ClassGenericType<>();
        List<Result> resultList = new ArrayList<>();
        Result result = new Result();
        result.setTitle("test");
        result.setContents("contents");
        resultList.add(result);
        classGenericType.setList(resultList);

        for(Result result1 : classGenericType.getList()){
            System.out.println(result1.getTitle());
            System.out.println(result1.getContents());
        }

        User user = new User();
        user.setTitle("test2");
        user.setContents("contents2");
        interfaceGenericTypeImpl interfaceGenericType = new interfaceGenericTypeImpl();
        Result returnResult = interfaceGenericType.doSomething(user);
        System.out.println(returnResult.getTitle());
        System.out.println(returnResult.getContents());

        int count = MethodGenericType.methodGeneric(resultList, result);
        System.out.println(count);

        WildcardGenericType wildcardGenericType = new WildcardGenericType();
        wildcardGenericType.method1();
        wildcardGenericType.method2();
        wildcardGenericType.method3();

    }

}

class ClassGenericType<T>{

    private T t;

    private List<T> list;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

interface interfaceGenericType<T1, T2>{
    T1 doSomething(T2 t2);
    T2 doSomething2(T1 t1);
}

class interfaceGenericTypeImpl implements interfaceGenericType<Result, User>{

    @Override
    public Result doSomething(User user){
        return user;
    }

    @Override
    public User doSomething2(Result result){
        return null;
    }

}

class MethodGenericType{

    public static <T> int methodGeneric(List<T> list, T item){
        int count = 0;
        for (T t : list){
            if(item == t){
                count++;
            }
        }
        return count;
    }

}

class WildcardGenericType<T>{

    public List<? extends Class<T>> method1(){
        return new ArrayList<Class<T>>();
    }

    public <T> List<? extends Class<T>> method2(){
        return new ArrayList<Class<T>>();
    }

    public List<?> method3(){
        return new ArrayList<>();
    }

}

class NotAllowedGenericType<T>{

    // static 필드는 제너릭 타입을 가질수 없음
//    private static T t;

    public NotAllowedGenericType(){
        // T type 은 인스턴스로 생성할 수 없음
//        new T();

        // primitives 타입으로 제너릭 타입을 선언할 수 없음
//        List<int> list = new ArrayList<>();

    }

}

/**
 * E - Element
 * K - Key
 * N - Number
 * T - Type
 * V - Value
 * */