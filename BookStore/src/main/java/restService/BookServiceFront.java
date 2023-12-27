package restService;

import java.util.List;

//import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import com.fasterxml.jackson.annotation.JsonInclude;

import dao.BookDAO;
import dao.BookDAOImpl;
import model.Book;
import model.Category;

//import com.google.gson.Gson; 

//this class is a simple implementation of a REST service
//it is the simplest Plant catalog,
//@JsonInclude(JsonInclude.Include.NON_NULL)

@Path("Books") // this is the path of the service
public class BookServiceFront {

	//Catalog catalog;

	public BookServiceFront() {
 
//		try {
//			// catalog is a singleton, shared among all customers
//			//catalog = Catalog.getInstance();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	/* GET Plants */
	// return the collection of plants as JSON

	@GET
	@Path("/category")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getCategoryNames() {
		//String content = catalog.getCatalogAsJSON();
		BookDAO bookDao = new BookDAOImpl();
		// calling DAO method to retrieve bookList from Database
		List<Category> categoryList = bookDao.findAllCategories();
		//String content = new Gson().toJson(categoryList);
		//return Response.status(200).entity(content).build();
		return categoryList;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book>  getAllBooks() {
		//String content = catalog.getCatalogAsJSON();
		BookDAO bookDao = new BookDAOImpl();
		// calling DAO method to retrieve bookList from Database
		List<Book> bList = bookDao.findAllBooks();
		//String content = new Gson().toJson(bList);
		//return Response.status(200).entity(content).build();
		return bList;
	}
	
  	  @GET
	  @Path("/searchByCat/{catid}")
	  @Produces(MediaType.APPLICATION_JSON) 
  	  public List<Book> getBooksByCategory(@PathParam("catid") String id) { 
  		BookDAO bookDao = new BookDAOImpl();
		// calling DAO method to retrieve bookList from Database
		List<Book> bList = bookDao.findBooksByCategory(id);
		//String content = new Gson().toJson(bList);
		//return Response.status(200).entity(content).build();
		return bList;
  	}
  	  
  	  @GET
	  @Path("/searchByKey/{keyword}")
	  @Produces(MediaType.APPLICATION_JSON) 
	  public List<Book> getBooksByKeyword(@PathParam("keyword") String ky) { 
		BookDAO bookDao = new BookDAOImpl();
		// calling DAO method to retrieve bookList from Database
		List<Book> bList = bookDao.searchBooksByKeyword(ky);
		//String content = new Gson().toJson(bList);
		//return Response.status(200).entity(content).build();
		return bList;
		
	}
	

	/* GET Plants/{id} */
	// this is a READ method on the service
	// the resource name is plants, is a collection,
	// once you deploy this, you can access this method with
	// the url is http://localhost:8080/SampleStore/rest/Plants

	
//	  @GET
//	  
//	  @Path("/{id}")
//	  
//	  @Produces(MediaType.APPLICATION_JSON) public Response
//	  getPrice(@DefaultValue("rose") @PathParam("id") String id) { String content =
//	  catalog.getPlant(id); return Response.status(200).entity(content).build(); }
	 
	/* POST plants */
	// this is a CREATE method on the service
	// the resource name is plant, the operation is POST, the parameters are passed
	// as
	// parameters in a form/query/path
	// once you deploy this, you can access this method with
	// http://localhost:8080/SampleStore/rest/Plants?id={1d}...
	// you can invoke it at the above address but need to include the parameters


//	@POST
//	@Consumes(MediaType.TEXT_PLAIN)
//	public Response createPlant(@QueryParam("id") String id, @QueryParam("plantName") String name, @QueryParam("price") double price, @QueryParam("desc") String desc) {
//		System.out.println("received:" + name + " " + price);
//		catalog.put(id, name, price, desc);
//		String content = catalog.getCatalogAsJSON();
//		return Response.status(200).entity(content).build();
//	}
	

	/* to be completed */
//	public void deletePlant(String name) {
//		catalog.remove(name);
//
//	}

	/* to be completed */
//	public void updatePlant(String name, String price) {
//		catalog.replace(name, price);
//	}

}
