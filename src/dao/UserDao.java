package dao;

import entity.UserTemp;
import java.util.Iterator;
import java.util.List;

public class UserDao extends Dao2 {

    protected static String table = "user_temp";  // ���ݿ����

    protected static String class_type = UserTemp.class.getName(); // ����ģ�͵�class

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
//          dao.add(user); // �洢�����ݿ�
//        }

//        List<Object> list = dao.paginate(1, 10);
//        for(Object o: list){
//        	UserTemp u = (UserTemp)o;
//            System.out.println(u.getUsername());
//        }
        
//        dao.filter("id", ">2").filter("name", "2").first();

//        User user = new User();  // ����ģ�Ͷ��� ��������Ҫ���á���ORMά��
//        user.setSex("w");
//      user.setUser_identity("editor");
//      user.setUsername("sj");
//      dao.add(user); // �洢�����ݿ�
//
//        /*
//         * ORM�Ĳ�ѯ
//         * ��ǰֻ֧�ֵ����ѯ
//         * ֧�ֵ���Ķ�������ѯ
//         */
//
//        // ���ҵ�id����0�ĵ�һ������
        UserTemp user1 = (UserTemp)dao.filter("id", ">0").filter("username", "='2'").first();
        System.out.println(user1.getUsername());
//
//
//        // ��id����-1�Ķ����в����û���Ϊ sj�Ķ���
//        User user2 = (User)dao.filter("id", ">-1").filter("username", "='sj'").first();
//        System.out.println(user2.getUsername());
//
//
//        //�ҵ�����id����-1�Ķ�������û���
//        Iterator iter = dao.filter("id", ">1").all();
//        while (iter.hasNext()){
//            User u = (User)iter.next();
//            System.out.println(u.getUsername());
//        }
    }
}