import com.andrii.model.manager.SessionManager;
import com.andrii.view.View;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        SessionManager.openSessionFactory();
        View view = new View();
        view.print();
        SessionManager.closeSessionFactory();
    }
}