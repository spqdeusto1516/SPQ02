package org.ClientP;

import org.models.Book;
import org.controllers.BookController;
import org.controllers.LoginController;
import org.controllers.ReserveController;
import org.dtos.FilterDTO;
import org.dtos.LoginDTO;
import org.dtos.ReserveDTO;

import java.io.IOException;
import java.util.List;

/**
 * Created by vitiok on 5/19/17.
 */
public class Client {

    public static final String REST_SERVICE_URI = "http://localhost:8080/";

    private static LoginDTO loginDTO = createDTOobj();
    private static ReserveDTO reserveDTO = createReserveDTO();
    public static void main(String[] args) throws IOException {
    	LoginDTO login = new LoginDTO();
    	login.setEmail("ander.areizagab@opendeusto.es");
    	login.setEncryptedPassword("1234");
    	FilterDTO filter = new FilterDTO();
//    	filter.setTitle("book1");
    	filter.setGenre("a");
//    	filter.setAuthorName("pedro");
//    	filter.setAuthorSurname("fed");
//        BookController.getBook();
        List<Book> books = BookController.getBooksFilter(filter);
        for(int i=0; i<books.size(); i++){
        	System.out.println(books.get(i).toString());
        }
        
//        IndexController.getAuth();
        System.out.println(LoginController.login(login).getToken());
        
//        ReserveController.create(reserveDTO);
    }


    private static LoginDTO createDTOobj() {
        loginDTO = new LoginDTO();
        loginDTO.setEmail("diana.artiom@opendeusto.es");
        loginDTO.setEncryptedPassword("qqqq1111");
        return loginDTO;
    }

    private static ReserveDTO createReserveDTO() {
        ReserveDTO reserveDTO = new ReserveDTO();
        reserveDTO.setBookId("591f7c315131a992d1f18b1d");
        return reserveDTO;
    }
}

