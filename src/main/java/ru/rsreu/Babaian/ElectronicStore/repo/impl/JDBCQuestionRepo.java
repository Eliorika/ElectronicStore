package ru.rsreu.Babaian.ElectronicStore.repo.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.rsreu.Babaian.ElectronicStore.model.Question;
import ru.rsreu.Babaian.ElectronicStore.repo.IQuestionRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JDBCQuestionRepo implements IQuestionRepository {

    private JdbcTemplate jdbcTemplate;

    private Question mapFromRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Question(resultSet.getLong("id"),
                resultSet.getString("question"),
                resultSet.getString("answer"));
    }
    @Override
    public List<Question> findAll() {
        return jdbcTemplate.query("select id, question, answer from questions", this::mapFromRow);

    }

    @Override
    public Optional<Question> findById(Long id) {
        List<Question> results = jdbcTemplate.query(
                "select id, question, answer from questions where id=?",
                this::mapFromRow,
                id);
        return results.isEmpty() ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public Question save(Question question) {
        jdbcTemplate.update(
                "insert into test_answers (id, answeredAt, question, answer) values (?, ?, ?, ?)",
                question.getId(),
                question.getQuestion(),
                question.getAnswer());

        return question;
    }
}
