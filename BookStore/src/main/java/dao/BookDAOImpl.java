package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Author;
import model.Book;
import model.Category;

public class BookDAOImpl implements BookDAO {

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
		}
	}

	private Connection getConnection() throws SQLException {
		//return DriverManager.getConnection("jdbc:mysql://localhost:3306/books",
			//	"root", "password");
		
		 return DriverManager.getConnection("jdbc:sqlite:C:\\RC\\Desktop\\trySQLite\\Books.db");
	}

	private void closeConnection(Connection connection) {
		if (connection == null)
			return;
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}

	public List<Book> findAllBooks() {
		List<Book> result = new ArrayList<Book>();
		//List<Author> authorList = new ArrayList<Author>();

		//String sql = "select * from book inner join author on book.id = author.book_id";
		String sql = "select * from book inner join author, category on book.id = author.book_id and book.category_id=category.ID";
				
		
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				//List<Author> authorList = new ArrayList<Author>(); //move here
				Book book = new Book();
				Author author = new Author();
				
				book.setId(resultSet.getLong("id"));
				book.setBookTitle(resultSet.getString("book_title"));
				//book.setCategoryId(resultSet.getLong("category_id"));
				book.setCategory(resultSet.getString("category_description"));
				
				//author.setBookId(resultSet.getLong("book_Id"));
				author.setFirstName(resultSet.getString("first_name"));
				author.setLastName(resultSet.getString("last_name"));
				//authorList.add(author);
				//book.setAuthors(authorList);
				book.setAuthor (author);
				 				
				result.add(book);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public List<Book> searchBooksByKeyword(String keyWord) {
		List<Book> result = new ArrayList<Book>();
		//List<Author> authorList = new ArrayList<Author>();

		//String sql = "select * from book inner join author on book.id = author.book_id"
		String sql = "select * from book inner join author, category on book.id = author.book_id and book.category_id=category.ID"
				+ " where book_title like '%"
				+ keyWord.trim()
				+ "%'"
				+ " or first_name like '%"
				+ keyWord.trim()
				+ "%'"
				+ " or last_name like '%" + keyWord.trim() + "%'";

		Connection connection = null;
		try {

			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				Author author = new Author();
				book.setId(resultSet.getLong("id"));
				book.setBookTitle(resultSet.getString("book_title"));
				author.setFirstName(resultSet.getString("first_name"));
				author.setLastName(resultSet.getString("last_name"));
				author.setBookId(resultSet.getLong("book_id"));
				
				//book.setAuthors(authorList);
				book.setCategory(resultSet.getString("category_description"));
				book.setAuthor (author);
				
				result.add(book);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}

		return result;
	}

	public List<Category> findAllCategories() {
		List<Category> result = new ArrayList<>();
		String sql = "select * from category";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getLong("id"));
				category.setCategoryDescription(resultSet.getString("category_description"));
				result.add(category);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	/*public void insert(Book book) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into Book (book_title) values (?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, book.getBookTitle());
			statement.execute();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				book.setId(generatedKeys.getLong(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}

	public void update(Book book) {
	}

	public void delete(Long bookId) {
		Connection connection = null;

		try {
			connection = getConnection();
			PreparedStatement statement = connection
					.prepareStatement("delete from book where id=?");
			statement.setLong(1, bookId);
			statement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
	
	*/
	
	public List<Book> findBooksByCategory(String category) {
		List<Book> result = new ArrayList<Book>();
		//List<Author> authorList = new ArrayList<Author>();

		String sql = "select * from book inner join author, category on book.id = author.book_id and book.category_id=category.ID where "
				+ "CATEGORY_DESCRIPTION='" + category + "'";

		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				//List<Author> authorList = new ArrayList<Author>(); //move here
				Book book = new Book();
				Author author = new Author();
				
				book.setId(resultSet.getLong("id"));
				book.setBookTitle(resultSet.getString("book_title"));
				//book.setCategoryId(resultSet.getLong("category_id"));
				book.setCategory(resultSet.getString("category_description"));
				
				//author.setBookId(resultSet.getLong("book_Id"));
				author.setFirstName(resultSet.getString("first_name"));
				author.setLastName(resultSet.getString("last_name"));
				//authorList.add(author);
				//book.setAuthors(authorList);
				book.setAuthor (author);
				result.add(book);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

}