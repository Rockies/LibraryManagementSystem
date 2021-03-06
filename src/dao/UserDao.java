package dao;

import entity.UserTemp;
import java.util.Iterator;
import java.util.List;

public class UserDao extends Dao2 {

    protected static String table = "user_temp";  // 数据库表名

    protected static String class_type = UserTemp.class.getName(); // 数据模型的class

    public UserDao(){
        super(table, class_type);
    }

    public static void main(String [] args) throws Exception {
        UserDao dao = new UserDao();
        
//        for(int i=0; i<50;i++) {
//        	UserTemp user = new UserTemp();
//        	user.setSex("w");
//          user.setUser_identity("editor");
//          user.setUsername(""+i);
//          dao.add(user); // 存储到数据库
//        }

//        List<Object> list = dao.paginate(1, 10);
//        for(Object o: list){
//        	UserTemp u = (UserTemp)o;
//            System.out.println(u.getUsername());
//        }
        
//        dao.filter("id", ">2").filter("name", "2").first();

//        User user = new User();  // 创建模型对象 主键不需要设置　由ORM维护
//        user.setSex("w");
//      user.setUser_identity("editor");
//      user.setUsername("sj");
//      dao.add(user); // 存储到数据库
//
//        /*
//         * ORM的查询
//         * 当前只支持单表查询
//         * 支持单表的多条件查询
//         */
//
//        // 查找到id等于0的第一个对象
        UserTemp user1 = (UserTemp)dao.filter("id", ">0").filter("username", "='2'").first();
        System.out.println(user1.getUsername());
//
//
//        // 在id大于-1的对象中查找用户名为 sj的对象
//        User user2 = (User)dao.filter("id", ">-1").filter("username", "='sj'").first();
//        System.out.println(user2.getUsername());
//
//
//        //找到所有id大于-1的对象并输出用户名
//        Iterator iter = dao.filter("id", ">1").all();
//        while (iter.hasNext()){
//            User u = (User)iter.next();
//            System.out.println(u.getUsername());
//        }
    }
}