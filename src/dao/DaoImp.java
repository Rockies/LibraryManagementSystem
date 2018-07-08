package dao;
import java.sql.*;
import java.util.Date;
import java.util.*;

import entity.Book;
import entity.Classification;
import entity.Comment;
import entity.Publisher;
import entity.User;


public class DaoImp implements Dao {
		static String url = "jdbc:mysql://localhost:3306/library_management_system";
		static String driver = "com.mysql.jdbc.Driver";
		static String username = "root";
		static String pass = "123456";
	    static Connection con=null;
	  	static {
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

		@Override
		public boolean checkInDb(User user) throws SQLException {
			String sql = "select * from user where username =?";
			PreparedStatement pstmt = null;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUserName());
			}catch(Exception e) {
				e.printStackTrace();
			}
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				System.out.println("用户名不存在");
				return false;
			}
			if (user.getPassword().equals(rs.getString("password")))
				return true;
			else
				System.out.println("密码不正确");
			return false;
		}
		@Override
		public User getUser(String username) throws SQLException {
			String sql="select * from user where username=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, username);
			User user=new User();
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("UserName"));
				user.setPassword(rs.getString("password"));
				System.out.println(user.getUserId());
				System.out.println(user.getUserName());
			}
			return user;
		}
		@Override
		public boolean addUser(User user) throws SQLException {
			String sql = "insert into user(username,password) values(?,?)";
			PreparedStatement pstmt = null;
			boolean isSuc = false;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			int row = pstmt.executeUpdate();
			isSuc = row > 0;
			return isSuc;
		}

		@Override
		public boolean addClassification(Classification classification) throws SQLException {
			String sql = "insert into  classification(classification) values(?)";
			PreparedStatement pstmt = null;
			boolean isSuc = false;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, classification.getClassification());
			int row = pstmt.executeUpdate();
			isSuc = row > 0;
			return isSuc;
		}

		@Override
		public boolean addPublisher(Publisher publisher) throws SQLException {
			String sql = "insert into  publisher(publisher_name) values(?)";
			PreparedStatement pstmt = null;
			boolean isSuc = false;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, publisher.getPublisher());
			int row = pstmt.executeUpdate();
			isSuc = row > 0;
			return isSuc;
		}

		@Override
		public List<Publisher> getPublisherList() throws SQLException {
			List<Publisher> publishers=new ArrayList<Publisher>();
			String sql="select * from publisher order by publisher_id";
			PreparedStatement pstmt = null;
			pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Publisher publisher=new Publisher();
				publisher.setPublisherId(rs.getInt("publisher_id"));
				publisher.setPublisher(rs.getString("publisher_name"));
				publishers.add(publisher);
			}
			return publishers;
		}

		@Override
		public boolean updatePublisher(Publisher publisher) throws SQLException {
			String sql="update publisher set publisher_name=? where publisher_id=?";
			PreparedStatement pstmt = null;
			pstmt=con.prepareStatement(sql);
			boolean isSuc = false;
			pstmt.setString(1, publisher.getPublisher());
			pstmt.setInt(2, publisher.getPublisherId());
			int row = pstmt.executeUpdate();
			isSuc = row > 0;
			return isSuc;
		}

		@Override
		public boolean deletePublisher(Publisher publisher) throws SQLException {
			String sql="delete from publisher where publisher_id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, publisher.getPublisherId());
			boolean isSuc=pstmt.executeUpdate()>0?true:false;
			return isSuc;
		}

		@Override
		public List<Classification> getClassificationList() throws SQLException {
			List<Classification> Classifications=new ArrayList<Classification>();
			String sql="select * from Classification order by classification_id";
			PreparedStatement pstmt = null;
			pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Classification classification=new Classification();
				classification.setClassificationId(rs.getInt(1));
				classification.setClassification(rs.getString(2));
				Classifications.add(classification);
			}
			return Classifications;
		}

		@Override
		public boolean addBook(Book book) throws SQLException {
			String sql = "insert into book(isbn,bookname,author,publisher_id,classification_id,publish_date,price) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = null;
			boolean isSuc = false;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPublisherId());
			pstmt.setInt(5, book.getClassificationId());
			pstmt.setDate(6, book.getPublisherDate());
			pstmt.setDouble(7, book.getPrice());
			int row = pstmt.executeUpdate();
			isSuc = row > 0;
			return isSuc;
		}

		@Override
		public List<Book> getBookList() throws SQLException {
			List<Book> books=new ArrayList<Book>();
			String sql="select * from book";
			PreparedStatement pstmt=null;
			pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setIsbn(rs.getString("isbn"));
				book.setAuthor(rs.getString("author"));
				book.setBookName(rs.getString("bookname"));
				book.setClassificationId(rs.getInt("classification_id"));
				book.setPublisherId(rs.getInt("publisher_id"));
				book.setPublisherDate(rs.getDate("publish_date"));
				book.setPrice(rs.getDouble("price"));
				book.setPublisherName(getPublisherName(book.getPublisherId()));
				book.setClassification(getClassificationName(book.getClassificationId()));
				books.add(book);
			}
			return books;
			
		}

		@Override
		public String getPublisherName(int publisherId) throws SQLException {
			String sql="select publisher_name from publisher where publisher_id= ?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, publisherId);
			ResultSet rs=pst.executeQuery();
			rs.next();
			return rs.getString("publisher_name");
		}

		@Override
		public String getClassificationName(int classificationId) throws SQLException {
			String sql="select classification from classification where classification_id= ?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, classificationId);
			ResultSet rs=pst.executeQuery();
			rs.next();
			return rs.getString(1);
		}

		@Override
		public List<Book> filterBook(Book book) throws SQLException {
			List<Book> books=new ArrayList<Book>();
			StringBuilder sql=new StringBuilder();
			int i=-1,j=-1;
			i=book.getPublisherId();
			j=book.getClassificationId();
			sql.append("select * from book where 1=1 ");
			if(!(book.getAuthor().length()==0)) {
				sql.append("and author = "+"'"+book.getAuthor()+"'");
				sql.append("   ");
			}
			if(!(book.getBookName().length()==0)) {
				sql.append("and bookname ="+"'"+book.getBookName()+"  "+"'");
				sql.append("   ");
			}
			if(!(i==-1)) {
				sql.append("and publisher_id = "+book.getPublisherId()+"  ");
			}
			if(!(j==-1)) {
				sql.append("and classification_id ="+book.getClassificationId());
			}
			String filtercondition=sql.toString();
			System.out.println(filtercondition);
			PreparedStatement pst=con.prepareStatement(filtercondition);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Book book1=new Book();
				book1.setBookId(rs.getInt("book_id"));
				book1.setIsbn(rs.getString("isbn"));
				book1.setAuthor(rs.getString("author"));
				book1.setBookName(rs.getString("bookname"));
				book1.setClassificationId(rs.getInt("classification_id"));
				book1.setPublisherId(rs.getInt("publisher_id"));
				book1.setPublisherDate(rs.getDate("publish_date"));
				book1.setPrice(rs.getDouble("price"));
				book1.setPublisherName(getPublisherName(book1.getPublisherId()));
				book1.setClassification(getClassificationName(book1.getClassificationId()));
				books.add(book1);
			}
			return books;
		}

		@Override
		public List<Book> filterBookByLiked(Book book) throws SQLException {
			List<Book> books=new ArrayList<Book>();
			StringBuilder sql=new StringBuilder();
			int i=-1,j=-1;
			i=book.getPublisherId();
			j=book.getClassificationId();
			sql.append("select * from book where 1=1 ");
			if(!(book.getAuthor().length()==0)) {
				sql.append("and author like "+"'"+"%"+book.getAuthor()+"%"+"'");
				sql.append("   ");
			}
			if(!(book.getBookName().length()==0)) {
				sql.append("and bookname like "+"'"+"%"+book.getBookName()+"%"+"'");
				sql.append("   ");
			}
			if(!(i==-1)) {
				sql.append("and publisher_id = "+book.getPublisherId()+"  ");
			}
			if(!(j==-1)) {
				sql.append("and classification_id ="+book.getClassificationId());
			}
			String filtercondition=sql.toString();
			PreparedStatement pst=con.prepareStatement(filtercondition);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Book book1=new Book();
				book1.setBookId(rs.getInt("book_id"));
				book1.setIsbn(rs.getString("isbn"));
				book1.setAuthor(rs.getString("author"));
				book1.setBookName(rs.getString("bookname"));
				book1.setClassificationId(rs.getInt("classification_id"));
				book1.setPublisherId(rs.getInt("publisher_id"));
				book1.setPublisherDate(rs.getDate("publish_date"));
				book1.setPrice(rs.getDouble("price"));
				book1.setPublisherName(getPublisherName(book1.getPublisherId()));
				book1.setClassification(getClassificationName(book1.getClassificationId()));
				books.add(book1);
			}
			return books;
		}

		@Override
		public boolean addFaver(User user, Book book) throws SQLException {
			String sql="insert into collection(user_id,book_id) values(?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,user.getUserId() );
			pst.setInt(2, book.getBookId());
			int row = pst.executeUpdate();
			boolean isSuc = row > 0;
			return isSuc;
		}
		@Override
		public List<Book> getFaverList(User user) throws SQLException {
			List<Book> books=new ArrayList<Book>();
			String sql="select book.book_id, ISBN, bookname, author, publisher_id, classification_id, publish_date, price from book,collection\r\n" + 
					"where collection.book_id=book.book_id and user_id = ? ";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			System.out.println(pst.toString());
			ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					Book book1=new Book();
					System.out.println(rs.getInt("book_id"));
					book1.setBookId(rs.getInt("book_id"));
					book1.setIsbn(rs.getString("isbn"));
					book1.setAuthor(rs.getString("author"));
					book1.setBookName(rs.getString("bookname"));
					book1.setClassificationId(rs.getInt("classification_id"));
					book1.setPublisherId(rs.getInt("publisher_id"));
					book1.setPublisherDate(rs.getDate("publish_date"));
					book1.setPrice(rs.getDouble("price"));
					book1.setPublisherName(getPublisherName(book1.getPublisherId()));
					book1.setClassification(getClassificationName(book1.getClassificationId()));
					books.add(book1);
				}
			return books;
			
		}
		@Override
		public boolean cancelFaver(User user, Book book) throws SQLException {
			String sql=" delete from collection where user_id =? and book_id = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user.getUserId());
			pstmt.setInt(2, book.getBookId());
			boolean isSuc=pstmt.executeUpdate()>0;
			return isSuc;
		}
		@Override
		public Book getBookInfo(int bookId) throws SQLException {
			String sql="select * from book where book_id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,bookId );
			ResultSet rs=pstmt.executeQuery();
			Book book1=new Book();
			while(rs.next()) {			
				book1.setBookId(rs.getInt("book_id"));
				book1.setIsbn(rs.getString("isbn"));
				book1.setAuthor(rs.getString("author"));
				book1.setBookName(rs.getString("bookname"));
				book1.setClassificationId(rs.getInt("classification_id"));
				book1.setPublisherId(rs.getInt("publisher_id"));
				book1.setPublisherDate(rs.getDate("publish_date"));
				book1.setPrice(rs.getDouble("price"));
				book1.setPublisherName(getPublisherName(book1.getPublisherId()));
				book1.setClassification(getClassificationName(book1.getClassificationId()));
			}
			return book1;
		}
		@Override
		public double getAvgGrade(int bookId) throws SQLException {
			String sql="select avg(score) from comment where book_id =?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,bookId);
			double i=0;
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) {
				i=rs.getDouble(1);
			}
			return i;
		}
		@Override
		public List<Comment> getCommentList(int bookId) throws SQLException {
			 List<Comment> comments =new ArrayList<Comment>();
			 String sql="select * from comment where book_id=?";
			 PreparedStatement pstmt=con.prepareStatement(sql);
			 pstmt.setInt(1, bookId);
			 ResultSet rs= pstmt.executeQuery();
			 while(rs.next()) {
				 Comment comment=new Comment();
				 comment.setBookId(rs.getInt("book_id"));
				 comment.setUserId(rs.getInt("user_id"));
				 comment.setCommentary(rs.getString("commentary"));
				 comment.setScore(rs.getInt("score"));
				 comments.add(comment);
			 }
			 return  comments;
		}
		@Override
		public boolean addComment(Book book, User user, Comment comment) throws SQLException {
			String sql="insert into comment(user_id, book_id, commentary, score) values(?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, user.getUserId());
			pst.setInt(2, book.getBookId());
			pst.setInt(4, comment.getScore());
			pst.setString(3, comment.getCommentary());
			boolean isSuc=pst.executeUpdate()>0;
			return isSuc;
		}
		
}
