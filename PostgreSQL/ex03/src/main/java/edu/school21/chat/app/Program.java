package edu.school21.chat.app;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingUse;
import com.sun.prism.null3d.NULL3DPipeline;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;
import org.postgresql.util.PSQLException;


public class Program {
    public static void main(String[] args) throws SQLException {  // исключения обработать ( ошибки )

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("ksu");
        ds.setPassword("12345");

        MessageRepository messageRepository = new MessagesRepositoryJdbcImpl(ds);
        Optional<Message> messageOptional = messageRepository.findById(3L);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setText("TEXT FOR SWAP");
            message.setDateTime(null);
            messageRepository.update(message);
            System.out.println(message.getMessageId());
        }
    }
}
