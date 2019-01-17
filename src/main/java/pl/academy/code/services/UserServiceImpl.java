package pl.academy.code.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.academy.code.DBHandler;
import pl.academy.code.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private PermissionsService permissionsService;

    public void saveUser(User user) {
        try {
            String SQL = "INSERT INTO tuser (login, pass, permissions) VALUES (? , ?, ?)";

            PreparedStatement preparedStatement = DBHandler.connection.prepareStatement(SQL);

            String hash = DigestUtils.md5Hex(user.getPass());
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, hash);
            preparedStatement.setString(3, this.permissionsService.resolvePermissions());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        try {
            String SQL = "SELECT * FROM tuser WHERE id = ?";
            PreparedStatement preparedStatement = DBHandler.connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User userFromDb = new User();

                userFromDb.setId(id);
                userFromDb.setLogin(rs.getString("login"));
                userFromDb.setPass(rs.getString("pass"));

                return userFromDb;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean authorizeUser(User user) {
        try {
            String SQL = "SELECT * FROM tuser WHERE login = ?";
            PreparedStatement preparedStatement = DBHandler.connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getLogin());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getString("pass").equals(DigestUtils.md5Hex(user.getPass()))) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
