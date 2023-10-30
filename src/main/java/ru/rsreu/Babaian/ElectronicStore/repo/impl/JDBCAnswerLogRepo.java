//package ru.rsreu.Babaian.ElectronicStore.repo.impl;
//
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//import ru.rsreu.Babaian.ElectronicStore.model.AnswersLog;
//import ru.rsreu.Babaian.ElectronicStore.repo.IAnswerLogRepository;
//import ru.rsreu.Babaian.ElectronicStore.repo.IQuestionRepository;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@Repository
//public class JDBCAnswerLogRepo implements IAnswerLogRepository {
//
//    public JDBCAnswerLogRepo(IQuestionRepository iQuestionRepository, DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//        this.iQuestionRepository = iQuestionRepository;
//        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
//                                    .withTableName("answers_log")
//                .usingColumns("answer", "answeredAt", "question");
//
//        this.simpleJdbcInsert.setGeneratedKeyName("id");
//    }
//
//    private final JdbcTemplate jdbcTemplate;
//    private final IQuestionRepository iQuestionRepository;
//    private final SimpleJdbcInsert simpleJdbcInsert;
//
//    private AnswersLog mapFromRow(ResultSet resultSet, int rowNum) throws SQLException {
//        var question = iQuestionRepository.findById(resultSet.getLong("question")).get();
//        return new AnswersLog(resultSet.getLong("id"),
//                resultSet.getDate("answeredAt"),
//                question,
//                resultSet.getString("answered"));
//    }
//    @Override
//    public List<AnswersLog> findAll() {
//        return jdbcTemplate.query("select id, answeredAt, question, answer from answers_log", this::mapFromRow);
//
//    }
//
//    @Override
//    public Optional<AnswersLog> findById(Long id) {
//        List<AnswersLog> results = jdbcTemplate.query(
//                "SELECT ID, ANSWEREDAT, QUESTION, ANSWER FROM ANSWERS_LOG WHERE ID=1",
//                this::mapFromRow,
//                id);
//        return results.isEmpty() ?
//                Optional.empty() :
//                Optional.of(results.get(0));
//    }
//
//    @Override
//    public AnswersLog save(AnswersLog answersLog) {
////        jdbcTemplate.update(
////                "insert into answers_log (id, answeredAt, question, answer) values (?, ?, ?, ?)",
////                answersLog.getId(),
////                answersLog.getAnsweredAt(),
////                answersLog.getQuestion().getId(),
////                answersLog.getAnswer());
//
//        Map<String,  Object> param = new HashMap<>();
//        param.put(("question"), answersLog.getQuestion().getId());
//        param.put("answeredAt", answersLog.getAnsweredAt());
//        param.put("answer", answersLog.getAnswer());
//
//        SqlParameterSource paramSource = new MapSqlParameterSource(param);
//        try {
//
//            Number number = simpleJdbcInsert.executeAndReturnKey(paramSource);
//            return findById(number.longValue()).get();
//        } catch (DataAccessException e) {
//
//            return null;
//        }
//    }
//}
