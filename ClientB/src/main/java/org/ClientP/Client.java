package org.ClientP;

import com.deusto.models.Book;
import org.GUI.Login;
import org.controllers.BookController;
import org.controllers.IndexController;
import org.controllers.LoginController;
import org.controllers.ReserveController;
import org.dtos.LoginDTO;
import org.dtos.ReserveDTO;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vitiok on 5/19/17.
 */
public class Client {

    public static final String REST_SERVICE_URI = "http://localhost:8080/";

    private static LoginDTO loginDTO = createDTOobj();
    private static ReserveDTO reserveDTO = createReserveDTO();
    public static void main(String[] args) throws IOException {

//        BookController.getBook();
//        BookController.getAllBooks();
//        IndexController.getAuth();
//        LoginController.login(loginDTO);
        ReserveController.create(reserveDTO);
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

