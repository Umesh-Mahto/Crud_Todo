package com.geekster.TODO.CRUD.repository;

import com.geekster.TODO.CRUD.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepo extends JpaRepository<Todo,Integer> {
    @Modifying
    @Query(value = "update todo set todo_name = :todoName,todo_status = :todoStatus where todo_id = :todoId" ,nativeQuery = true)
    void updateTodo(Integer todoId, String todoName, String todoStatus);
}
