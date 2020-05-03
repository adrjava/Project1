package aplicatie.controller;


import aplicatie.dao.AngajatDao;
import aplicatie.dao.DepartamentDao;
import aplicatie.dao.UserDao;
import aplicatie.model.Angajat;
import aplicatie.model.Departament;
import aplicatie.model.User;
import com.sun.tools.javac.Main;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class MainController {
    private DepartamentDao departamentDao;
    private AngajatDao angajatDao;
    private UserDao userDao;
    private static MainController SINGLETON = null;

    private MainController() {
        Connection connection = DatabaseConnection.getConnection();
        departamentDao = new DepartamentDao(connection);
        angajatDao = new AngajatDao(connection);
        userDao = new UserDao(connection);
    }

    public static MainController getInstance(){
        if (SINGLETON == null) {
            SINGLETON = new MainController();
            return SINGLETON;
        }else{
            return SINGLETON;
        }
    }

    public boolean adaugaDepartament(String numeDepartament) {
        return departamentDao.insert(numeDepartament);
    }

    public List<Departament> getDepartamente() {
        return departamentDao.FindAllById();
    }

    public boolean adaugaAngajat(Angajat angajat) {
        return angajatDao.insert(angajat);
    }

    public List<Angajat> getAngajati(int id) {
        return angajatDao.findAllById(id);
    }

    public boolean deleteAngajat(String nume) {
        return angajatDao.deleteByNume(nume);
    }

    public  boolean  verificaLogin (String username, String password){
        return  userDao.verificaUser(username, password);
    }

    public boolean registerUser(User user){
        return  userDao.insert(user);
    }
}
