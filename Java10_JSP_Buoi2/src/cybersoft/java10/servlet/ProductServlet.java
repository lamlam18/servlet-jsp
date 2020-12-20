package cybersoft.java10.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java10.model.Product;
import cybersoft.java10.service.ProductService;
import cybersoft.java10.util.ProductConstant;
import cybersoft.java10.util.ServletConstant;

@WebServlet(name = "productServlet" , urlPatterns = {
		"/product",
		"/product/add",
		"/product/edit",
		"/product/delete"}) //SEO

public class ProductServlet extends HttpServlet {
	
	/*
	 * cấu hình ProductServlet sao cho khi người dùng truy cập
	 * vào đường dẫn "/product"
	 * thì hiện trang products.jsp
	 * Trang product sẽ hiển thị sản phẩm đang có
	 * 
	 */
	private ProductService service;
	
	@Override
	public void init() throws ServletException {
		// TODO khởi tạo service
		super.init();
		service = new ProductService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO hiện trang product khi người dùng truy cập /product
		switch (req.getServletPath()) {
		case ServletConstant.PATH_PRODUCT:
			req.setAttribute("products", service.getAllProduct());
			req.getRequestDispatcher(ProductConstant.URL_PRODUCT_HOMEPAGE).forward(req, resp);
			break;	
			
		case ServletConstant.PATH_PRODUCT_DELETE:
			int id =Integer.parseInt(req.getParameter("id")) ;
			service.remove(id);
			String contextPath = req.getContextPath();
			resp.sendRedirect(contextPath  + ServletConstant.PATH_PRODUCT);
			break;
		case ServletConstant.PATH_PRODUCT_ADD:
			/*
			 * show product-add.jsp
			 */
			req.getRequestDispatcher(ProductConstant.URL_PRODUCT_ADD).forward(req, resp);
			break;
		case ServletConstant.PATH_PRODUCT_EDIT:
//			int idEdit = Integer.parseInt(req.getParameter("id"));
//			Product product = null;
//			if (product != null) {
//				service.update(idEdit,product );
//				req.getRequestDispatcher(ProductConstant.URL_PRODUCT_EDIT).forward(req, resp);
//			}
			req.getRequestDispatcher(ProductConstant.URL_PRODUCT_EDIT).forward(req, resp);
			break;
		default:
			break;
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 
		String contextPath = req.getContextPath();
		
		switch (req.getServletPath()) {
		case ServletConstant.PATH_PRODUCT_ADD:			
			//lấy thông tin từ form set vào product mới
			Product product = new Product();
			product.id 			= Integer.parseInt(req.getParameter("productId"));
			product.name		= req.getParameter("productName");
			product.code		= req.getParameter("productCode");
			product.description	= req.getParameter("productDescription");
			product.price		= Float.parseFloat(req.getParameter("productPrice"));
			
			if (service.add(product)) {
				resp.sendRedirect(contextPath + ServletConstant.PATH_PRODUCT );
			}
			else {
				req.setAttribute("message", "Thêm không thành công. Trùng Product ID hoặc điền thiếu thông tin");
				req.getRequestDispatcher(ProductConstant.URL_PRODUCT_ADD).forward(req, resp);
				
			}
				
			break;
		case ServletConstant.PATH_PRODUCT_EDIT:
			Product productEdit = new Product();
			productEdit.setName(req.getParameter("productName"));
			productEdit.setCode(req.getParameter("productCode"));
			productEdit.setDescription(req.getParameter("description"));
			productEdit.setPrice(Float.parseFloat(req.getParameter("productPrice")));
			service.update(Integer.parseInt(req.getParameter("id")), productEdit);
			resp.sendRedirect(contextPath + ServletConstant.PATH_PRODUCT );
			break;
			

		default:
			break;
		}
	}

}
