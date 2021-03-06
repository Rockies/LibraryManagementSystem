package entity;

public class UserTemp {
   private int id = -1;  // 主键默认值必须为-1 这是由于hsqldb默认主键从0开始
   private String username;
   private String sex;
   private String user_identity;

   public void setId(int id) {
       this.id = id;
   }

   public void setUsername(String username) {
       this.username = username;
   }

   public void setSex(String sex) {
       this.sex = sex;
   }

   public void setUser_identity(String user_identity) {
       this.user_identity = user_identity;
   }

   public int getId() {
       return id;

   }

   public String getUsername() {
       return username;
   }

   public String getSex() {
       return sex;
   }

   public String getUser_identity() {
       return user_identity;
   }
}