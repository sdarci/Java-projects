package edu.school21.chat.repositories;

import edu.school21.chat.models.*;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessageRepository {

    private final DataSource ds;

    public MessagesRepositoryJdbcImpl (DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage = null;

        String url = "jdbc:postgresql://localhost:5432/postgres";

        try {
            Connection conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(" SELECT * FROM chat.message WHERE id = " + id + " ;");
            resultSet.next();
            User user = new User(1, "Sdarci", "123", null, null);
            Chatroom chatroom = new Chatroom(1, "chatroom", null, null);
            Message message = new Message(resultSet.getInt(1), user, chatroom, resultSet.getString("message"), LocalDate.of(2014, 9, 19));
            optionalMessage = Optional.of(message);
            statement.close();
            conn.close();
            return optionalMessage;
        }
        catch (SQLException e) {
            System.err.println("Cant connect to DB");
            System.exit(-1);
        }
        return optionalMessage;
    }
}
