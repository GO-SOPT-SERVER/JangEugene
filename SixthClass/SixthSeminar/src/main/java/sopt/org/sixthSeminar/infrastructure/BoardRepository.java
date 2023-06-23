package sopt.org.sixthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.sixthSeminar.domain.Board;

import java.util.List;

public interface BoardRepository extends Repository<Board, Long> {

    // CREATE
    void save(Board board);

    // READ

    List<Board> findAllByTitleContaining(String searchText);
    // UPDATE


    // DELETE
}