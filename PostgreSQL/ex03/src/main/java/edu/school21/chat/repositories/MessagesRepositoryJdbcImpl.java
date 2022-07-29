package edu.school21.chat.repositories;

import edu.school21.chat.models.*;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessageRepository {

    private final DataSource ds;

    public MessagesRepositoryJdbcImpl (DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage;

        String url = "jdbc:postgresql://localhost:5432/postgres";

        Connection conn = DriverManager.getConnection(url);

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(" SELECT * FROM chat.message WHERE id = " + id + " ;");

        resultSet.next();

        User user = new User(1L, "mkoch", "123", null, null);
        Chatroom chatroom = new Chatroom(1L, "chatroom", null, null);
        Message message = new Message(resultSet.getLong(1), user, chatroom, resultSet.getString("message"), LocalDate.of(2022, 7,26));
        optionalMessage = Optional.of(message);
        statement.close();
        conn.close();

        return optionalMessage;
    }

    public void update(Message message) {

        String str = "UPDATE chat.message SET message = \'" + message.getText() + "\', time  = "+ message.getDateTime() + " WHERE id = " + message.getMessageId();
        System.out.println(str);

        try(Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS)) {

            statement.execute();

            ResultSet key = statement.getGeneratedKeys();
            key.next();
            message.setMessageId(key.getLong(1));
        } catch (SQLException e) {
            throw new NotSavedSubEntityException();
        }

    }

    @Override
    public void save(Message message) throws NotSavedSubEntityException {

        String str =  " INSERT INTO chat.message (room_id, sender, message, time) VALUES (" + message.getRoom().getChatroomId() + ", " + message.getAuthor().getUserId() + ", \'" +  message.getText() + "\', to_timestamp(\'" + message.getDateTime() + "\', \'YYYY-MM-DD \') );";

        System.out.println(str);

        try(Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(str, Statement.RETURN_GENERATED_KEYS)) {

            statement.execute();

            ResultSet key = statement.getGeneratedKeys();
            key.next();
            message.setMessageId(key.getLong(1));
        } catch (SQLException e) {
            throw new NotSavedSubEntityException();
        }
    }
}