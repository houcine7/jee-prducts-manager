package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import applicationDOA.IProductDoa;
import applicationDOA.ProductDoaimp;
import metier.Product;

@WebServlet(name = "ServeletController", urlPatterns = { "/find.net", "/index.net", "/insert.net", "/delete.net" ,"/update.net" })
public class ServeletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductDoa pFunctions;

	public ServeletController() {

	}

	public void init(ServletConfig config) throws ServletException {
		pFunctions = new ProductDoaimp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// check path and perform needed actions

		if (request.getServletPath().equals("/index.net")) {
			request.getRequestDispatcher("/views/products.jsp").forward(request, response);

		} else if (request.getServletPath().equals("/find.net")) {
			String keyword = request.getParameter("nameInput");
			List<Product> products = pFunctions.searchByName("%" + keyword + "%");

			// store items in products model
			ProductModel productModel = new ProductModel();
			productModel.setKeyWord(keyword);
			productModel.setProducts(products);
			request.setAttribute("model", productModel);
			request.getRequestDispatcher("/views/products.jsp").forward(request, response);
			
			
		} else if (request.getServletPath().equals("/insert.net")) {
			request.getRequestDispatcher("/views/addProduct.jsp").forward(request, response);
			
			
		}else if(request.getServletPath().equals("/delete.net")) {
			
			int idProductToDelete =Integer.parseInt(request.getParameter("id")) ;
			pFunctions.deleteProduct(idProductToDelete) ;
			
			response.sendRedirect("index.net");
			
		}else if(request.getServletPath().equals("/update.net")) {
			
			Product p =pFunctions.searchById(Integer.parseInt(request.getParameter("id"))) ;
			
			request.setAttribute("product",p ) ;
			
			request.getRequestDispatcher("/views/edit.jsp").forward(request, response);
		}

		else {
			response.sendError(response.SC_NOT_FOUND);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// route to save new product in db 
		if (request.getServletPath().equals("/insert.net")) {
			String nameProduct = request.getParameter("name");
			double priceProduct = Double.parseDouble(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			Product p = pFunctions.save(new Product(priceProduct, nameProduct, quantity));
			request.setAttribute("product", p);
			request.getRequestDispatcher("/views/confirm.jsp").forward(request, response);
			
			
		// route to edit a product in db
			
		}else if(request.getServletPath().equals("/update.net")) {
			int idProduct =Integer.parseInt(request.getParameter("id"));
			
			String newName =request.getParameter("name") ;
			double newPrice = Double.parseDouble(request.getParameter("price"));
			int newQuantity = Integer.parseInt(request.getParameter("quantity"));
			
			Product p =new Product(newPrice ,newName,newQuantity) ;
			p.setId(idProduct) ;
			pFunctions.updateProduct(p) ;
			request.setAttribute("product", p);
			request.getRequestDispatcher("/views/confirm.jsp").forward(request, response);
			
		}
		

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
